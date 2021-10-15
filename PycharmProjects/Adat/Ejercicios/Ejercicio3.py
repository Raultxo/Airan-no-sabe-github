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

print(lista)
print(sum(lista))
print(suma / len(lista))

