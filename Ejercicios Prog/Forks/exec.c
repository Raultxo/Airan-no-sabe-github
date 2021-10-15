#include <unistd.h>
#include <stdio.h>
void main ()
{ 
    printf("Ejemplo de uso de exec ():");
    printf("Los archivos en el directorio son: \n");
    execl ("/bin/ls","ls", "-lart", (char *)NULL);
    printf (" Esto no se ejecuta !!!!!");
}