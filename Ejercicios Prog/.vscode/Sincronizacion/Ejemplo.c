#include <unistd.h>
#include <stdio.h>
#include <signal.h>
#include <stdbool.h>

bool funcionando = true;

void gestionControlC(int signal) {
    funcionando = false;
    printf("\nADIOS\n");
}

void main() {
    while(funcionando) {
        signal(SIGINT, gestionControlC);
        printf("Dormir 1 segundo\n");
        sleep(1);
    }
    exit(0);
}