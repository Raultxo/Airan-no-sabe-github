// Actividad 6, Raúl Estrada García
// Genera una estructura de procesos de Padre --> Hijo 1 y Hijo 2 --> Del Hijo2 sacar Hijo3

#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <sys/wait.h>

int main() {
    __pid_t pid;
    // Creamos el que va a servir como padre
    for (int i = 0; i < 2; i++) {
        if(i == 0) {
            pid = fork();
            if(pid == 0) {
                 printf("Soy el hijo 1, mi padre es PID= %d, yo soy %d\n", getppid(), getpid());
            }      
        }
        if(i == 1) {
            if(pid != 0) {
                pid = fork();
                if(pid == 0) {
                    printf("Soy el hijo 2, mi padre es PID= %d, yo soy %d\n", getppid(), getpid());
                    pid = fork();
                    if(pid == 0) {
                        printf("Soy el hijo 3, mi padre es PID= %d, yo soy %d\n", getppid(), getpid());
                    }
                }
            }
        }
    }
    
}
