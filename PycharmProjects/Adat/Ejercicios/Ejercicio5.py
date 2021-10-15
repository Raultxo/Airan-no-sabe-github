lista = []

def cargarDatos():
    i = 0
    limite = 10
    while i < limite:
        numero = int(input("Introduce un numero impar: "))

        if numero % 2 == 1:
            lista.append(numero)
            i = i + 1
        else:
            print("Tiene que ser un numero impar!!")



def menu():
    print("""¿Que desea hacer con la lista?
                1.Sumatorio
                 2.Media
                3.Maximo
                4.Minimo
                    
                 0.Salir""")
    return int(input())

def imprimirRespuesta(result = menu()):
    if result == 1:
        print(sum(lista))
    elif result == 2:
        print(sum(lista) / len(lista))
    elif result == 3:
        print(max(lista))
    elif result == 4:
        print(min(lista))
    else:
        exit()

cargarDatos()
imprimirRespuesta()