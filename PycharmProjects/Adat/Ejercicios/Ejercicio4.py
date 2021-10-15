lista = []
suma = 0
i = 0
limite = 10
while i < limite:
    numero = int(input("Introduce un numero impar: "))
    
    if numero%2 == 1:
        lista.append(numero)
        suma = suma + numero
        i = i + 1
    else:
        print("Tiene que ser un numero impar!!")
        i = i - 1

print("""¿Que desea hacer con la lista?
            1.Sumatorio
             2.Media
            3.Maximo
            4.Minimo
                
             0.Salir""")
result = int(input())
if result == 1:
    print(sum(lista))
elif result == 2:
    print(suma / len(lista))
elif result == 3:
    print(max(lista))
elif result == 4:
    print(min(lista))
else:
    exit()



