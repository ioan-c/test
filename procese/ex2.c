/* Sa se scrie in limbajul C un program care creeaza filiatia de procese ilustrata in figura de mai jos.
Fiecare proces va afisa un text cu numele sau (parinte, fiu, nepot, etc), precum si pid-ul propriu si cel al
parintelui.
Sa se transforme in ORFANI procesele nepot.*/

#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>
main () {
int p1, p2, p3, p4 ; int m=5, n=100;
p1=fork() ;
if(p1==0) {
	printf("\n Fiu1 are id=%d Tata are id =%d\n",getpid(),getppid()) ;
	p3=fork();
	if(p3==0) {
		printf("\n Nepot1 are id=%d Tatal lui are id =%d\n",getpid(),getppid()) ;
		sleep(20);
	}
	sleep(10);
	exit(0);
}
p2=fork();
if(p2==0) {
	printf("\n Fiu 2 are id=%d Tata are id =%d\n",getpid(),getppid()) ;
	p4=fork();
	if(p4==0) {
		printf("\n Nepot2 are id=%d Tatal lui are id =%d\n",getpid(),getppid()) ;
		sleep(20);

	}
	sleep(10);
	exit(0);
}

printf("\n Tata are id =%d\n",getpid(),getppid()) ;
sleep(30);
exit(0);
}
