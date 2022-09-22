package mx.itesm.semana6pm

import android.util.Log

// si a algún parámetro del constructor principal
// le pongo var / val se vuelve una propiedad automáticamente
class Perrito(
    edad: Int,
    nombre: String,
    peso: Float,
    var raza: String
) : Mamifero(edad, nombre, peso), Paseable {

    var ciudad = ""

    init {
        Log.wtf("PRUEBA CLASE", "BLOQUE DE INICIALIZACION PERRITO")
    }

    constructor(
        edad: Int,
        nombre: String,
        peso: Float,
        raza: String,
        ciudad:String
    ) : this(edad, nombre, peso, raza){

        this.ciudad = ciudad
        Log.wtf("PRUEBA CLASE", "CONSTRUCTOR SECUNDARIO PERRITO")
    }

    // sobrecarga de métodos - overload
    // varias funciones con mismo nombre, diferentes argumentos
    // idealmente hacen algo muy parecido entre ellas

    // sobreescritura de métodos - override
    // - redefinir lógica para un método que heredamos

    override fun saludar(){
        super.saludar()
        Log.wtf("PRUEBA CLASE", "woof woof $nombreProp")
    }

    override fun comer() {
        Log.wtf("PRUEBA CLASE", "woof woof comer como atolondrado")
    }

    override fun pasear() {
        Log.wtf("PRUEBA CLASE", "ESTOY PASEANDO!")
    }


}