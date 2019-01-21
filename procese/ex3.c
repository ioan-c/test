/*
Sa se scrie in limbajul C  un program care creeaza filiatia de procese
 ilustrata in figura de mai jos. [parinte-fiu-nepot]
Procesul nepot1 va trimite prin pipe-line 500 de octeti ,
, procesul parinte ii va afisa pe ecran. 
*/
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

//parinte-fiu-nepot
int main(){
int fiu, nepot, p[2];
pipe(p);
fiu=fork();
if(fiu==0){
	printf("fiu are pid=%d, parintele are pid=%d",getpid(),getppid());
	
	nepot=fork();
	if(nepot==0){
		printf("nepot are pid=%d, parintele are pid=%d",
			getpid(),getppid());
		close(p[0]);
		int k=0;
		for(int i=0; i<10; i++)	{
			write(p[1],"A",1);
			sleep(1);
		}
		exit(0);
	}
	
	exit(0);
}

close(p[1]);
char* c;
c = (char*)malloc(1);
while(read(p[0], c, 1)==1){
	write(1,c,1);
	sleep(1);
}

return 0;
}
