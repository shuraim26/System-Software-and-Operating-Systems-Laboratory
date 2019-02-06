%{
	int c=0;
%}


%x CMT 
%x ct

%%


"//" { BEGIN ct ;}

<ct>.\n {c++; BEGIN INITIAL ;} 
<ct>. ;                        
"/*" { BEGIN CMT ;}
<CMT>\n {c++ ;}
<CMT>.\n {c++ ;}
<CMT>"*/" {c++; BEGIN INITIAL ;}
<CMT>. ;


%%


int main (int argc, char *argv[])
{
	FILE *fp1,*fp2;
	if (argc==3)
{
	fp1=fopen (argv [1],"r");
	fp2=fopen (argv [2],"w");
	yyin=fp1;
	yyout=fp2;
}
	yylex ();
}

int yywrap()
{
	return 1;
}
