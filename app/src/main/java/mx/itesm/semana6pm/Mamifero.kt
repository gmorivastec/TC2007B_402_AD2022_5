package mx.itesm.semana6pm

import android.util.Log

// definición de clases en kotlin
// se puede tener una clase vacía
// class Mamifero

// como parte de la definición se incluyen los parámetros
// del constructor principal

// 2 opciones para los parámetros de constructor principal
// 1- son sólo parámetros
// 2- se reciben como propiedad

// para poder heredar una clase necesita ser "open" o "abstract"

// clase abstracta -
// - un tipo del que no se puede instanciar
// - pueden tener métodos abstractos

abstract class Mamifero (edad: Int, nombre: String) {

    // se pueden inicializar propiedades
    val edadProp = edad
    var peso = 0f
    var color = ""

    // se pueden incluir cualquier cantidad de bloques de inicialización
    init {

        Log.wtf("PRUEBA CLASES", edadProp.toString())
    }

    // se pueden intercalar bloques de inicialización con declaración de
    // propiedades indistintamente

    val nombreProp = nombre

    init {
        Log.wtf("PRUEBA CLASES", nombreProp.toString())
    }

    // además del principal podemos tener cualquier cantidad de constructores secundarios
    // se distinguen por tener una lista de parámetros distinta
    // todos los constructores secundarios se llaman constructor
    constructor(edad: Int, nombre: String, peso: Float) : this(edad, nombre) {
        this.peso = peso
        Log.wtf("PRUEBA CLASES", "constructor secundario")
    }

    constructor(
        edad: Int,
        nombre: String,
        peso: Float,
        color: String
    ) : this(edad, nombre, peso) {
        this.color = color
        Log.wtf("PRUEBA CLASES", "constructor secundario 2")
    }

    open fun saludar() {
        Log.wtf("PRUEBA CLASES", "saludos del mamifero: $nombreProp")
    }

    abstract fun comer()
}