#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <sys/wait.h>

void main() {
    pid_t pidHijo, pidNieto;
    int fd1[2], fd2[2];       // Declaramos variables
    char buffer[20];
    pipe(fd1);            // Creamos la tuberia del abuelo
    pidHijo = fork();     // Creamos el Hijo
    if (pidHijo == 0) {   // Estamos en el Hijo
        pipe(fd2);          // Creamos otra tuberia
        pidNieto = fork();  // Creamos el Nieto
    }

    if(pidNieto == 0) { // Estamos en el Nieto
        read(fd2[0], buffer, sizeof(buffer));   // Leemos lo que hay en la pipe que ha enviado el HIJO
        printf("        El NIETO recibe un mensaje del padre: %s\n", buffer); // Lo visualizamos
        printf("        El NIETO envia un mensaje al HIJO.....\n");
        write(fd2[1], "Saludo del nieto", sizeof(buffer)); // Enviamos un mensaje al HIJO
    }
    else {
        if (pidHijo == 0) { // Estamos en el Hijo
            read(fd1[0], buffer, sizeof(buffer)); // Leemos lo que hay en la pipe que ha enviado el ABUELO
            printf("    El HIJO recibe un mensaje de abuelo: %s\n", buffer); // Lo visualizamos
            printf("    El HIJO envia un mensaje al NIETO......\n");
            write(fd2[1], "Saludo del padre", sizeof(buffer));  // Enviamos un mensaje al NIETO
            wait(NULL);  // Esperamos a que acabe el NIETO
            read(fd2[0], buffer, sizeof(buffer)); // Leemos lo que hay en la pipe que ha enviado el NIETO
            printf("    El HIJO recibe un mensaje de su hijo: %s\n", buffer); // Lo visualizamos
            printf("    El HIJO envia un mensaje al ABUELO......\n");
            write(fd1[1], "Saludo del hijo", sizeof(buffer));   // Enviamos un mensaje al ABUELO
        }
        else { // Estamos en el ABUELO
            printf("El ABUELO envia un mensaje al HIJO......\n"); 
            write(fd1[1], "Saludo del abuelo", sizeof(buffer)); // Enviamos un mensaje al HIJO
            wait(NULL); // Esperamos a que termine el HIJO
            read(fd1[0], buffer, sizeof(buffer)); // Lees lo que hay en la pipe que ha enviado el HIJO
            printf("El ABUELO recibe un mensaje del HIJO: %s\n", buffer); // Lo visualizas
        }
    }
    exit(0);
}
