// Actividad 6, Raúl Estrada García
// Genera una estructura de procesos de Padre --> Hijo 1 y Hijo 2 --> Del Hijo2 sacar Hijo3

#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <sys/wait.h>

int main() {
    __pid_t pid;
    // Creamos el Hijo1
    pid = fork();
    if(pid == 0) {
        // Si es el Hijo1, lo visualizamos
        printf("Soy el hijo 1, mi padre es PID= %d, yo soy %d\n", getppid(), getpid());
    }
    else {
        // Si es el padre, creamos el Hijo2
        pid = fork();
        if(pid == 0) {
            //Visualizamos el Hijo2 y creamos el Hijo3
            printf("Soy el hijo 2, mi padre es PID= %d, yo soy %d\n", getppid(), getpid());
            pid = fork();
            if(pid == 0) {
                // Visualizamos el Hijo3
                printf("Soy el hijo 3, mi padre es PID= %d, yo soy %d\n", getppid(), getpid());
            }
        }
    }
}
