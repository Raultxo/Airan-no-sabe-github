lista = []
suma = 0
for i in range(10):
    numero = int(input("Introduce un numero: "))
    lista.append(numero)
    suma = suma + numero

print(lista)
print(sum(lista))
print(suma / len(lista))

