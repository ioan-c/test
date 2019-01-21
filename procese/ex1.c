/*
Sa se scrie in limbajul C un program care creeaza filiatia de procese ilustrata in figura de mai jos.
Fiecare proces va afisa un text cu numele sau precum si pid-ul propriu si cel al parintelui.
Sa se transforme in ZOMBI cele 2 procese fiu.*/

#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>
main () {
int p1, p2;
p1=fork() ;
if(p1==0) {
printf("\n Fiu1 are id=%d Tata are id =%d\n",getpid(),getppid()) ;
exit(0);
}
p2=fork();
if(p2==0) {
printf("\n Fiu2 are id=%d Tata are id =%d\n",getpid(),getppid()) ;
exit(0);
}
printf("\n Tata are id =%d",getpid()) ;
sleep(10);
}
