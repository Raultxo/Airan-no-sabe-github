from Ejercicio7 import Persona

listaPersonas = [Persona("Persona1", 20, 80, 1.80, 'M'),
                 Persona("Persona2", 50, 40, 1.60, 'H'),
                 Persona("Persona3", 10, 50, 1.40)]

for Persona in listaPersonas:
    print(Persona.toString())

    if Persona.esMayorDeEdad():
        print("Es mayor de edad")
    else:
        print("No es mayor de edad")

    if Persona.calcularIMC() == -1:
        print("Debajo del peso ideal")
    elif Persona.calcularIMC() == 0:
        print("Peso ideal")
    else:
        print("Encima del peso ideal")

    print("\n")
