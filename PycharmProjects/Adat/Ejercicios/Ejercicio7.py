import random

class Persona:
    SEXOPORDEFECTO = 'H'
    def __init__(self, nombre = "", edad = 0, peso = 0, altura = 0, sexo = SEXOPORDEFECTO):
        self.__nombre = nombre
        self.__generarDNI()
        self.__edad = edad
        self.__peso = peso
        self.__altura = altura
        self.__sexo = sexo

    def calcularIMC(self):
        result = self.__peso/(self.__altura**2)
        if result < 20:
            return -1
        elif result > 25:
            return 1
        else:
            return 0

    def esMayorDeEdad(self):
        if self.__edad >= 18:
            return True
        else:
            return False

    def toString(self):
        txt = ""
        txt = txt + str(self.__nombre) + ", sexo: " + str(self.__sexo) + ", con DNI: " + str(self.__DNI) + " y edad de " + str(self.__edad)
        txt = txt + " años, pesa: " + str(self.__peso) + "kg y mide " + str(self.__altura) + " metros"
        return txt

    def __generarDNI(self):
        nuevoDNI = ""
        for i in range(8):
            numero = str(random.randint(0,9))
            nuevoDNI = nuevoDNI + numero

        n = int(nuevoDNI)
        palabra = 'TRWAGMYFPDXBNJZSQVHLCKE'
        letra = palabra[n % 23]
        self.__DNI = nuevoDNI + letra

    def setNombre(self, nuevoNombre):
        self.__nombre = nuevoNombre

    def setEdad(self, nuevaEdad):
        self.__edad = nuevaEdad

    def setAltura(self, nuevaAltura):
        self.__altura = nuevaAltura

    def setPeso(self, nuevoPeso):
        self.__peso = nuevoPeso

    def setSexo(self, nuevoSexo):
        self.__sexo = nuevoSexo
