%{
#include<stdio.h>
#include<ctype.h>
%}

 %token DIG
 %left '+''-'
 %left '*''/'
 %left UMINUS

%%

line : 	line exp '\n'
	{ printf("res=%d\n",$2); }
	|
	| line '\n'
	| error '\n'
	{yyerror("invalid exp:\n");
	yyerror;
	}
	;

exp : exp'+'exp
	{ $$=$1+$3; }
	| exp '-' exp
	{$$ = $1 - $3;}
	| exp'*'exp
	{$$ = $1*$3;}
	| exp '/' exp
	{
	if($3==0)
	{printf("Divide by zero error");
	return 0;}
	else $$=$1/$3;
	}
 	| '-' exp %prec UMINUS
 	{ $$ = -$2; }
	| num
 	;

num :	DIG {$$=$1;}
	| num DIG {$$ = $1*10+$2;}
	;

%%

main()
{
	printf("Enter valid arithmetic expression\n");
	yyparse();
}

yyerror(char *s)
{
	printf("%s\n",s);
}

int yylex()
{
	int c;
	while ((c = getchar()) == ' ');
	if (isdigit(c))
	{
		yylval = c - '0';
		return DIG;
	}
	return c;
}
