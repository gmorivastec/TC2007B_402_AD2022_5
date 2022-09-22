package mx.itesm.semana6pm

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts

class PhotoActivity : AppCompatActivity() {

    lateinit var imageView : ImageView

    var resultLauncher =
        registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ){ result ->

            // 2 opciones cuando lidiemos con fotos
            // 1 - obtenemos el thumbnail (la información binaria)
            // 2 - obtenemos el URI de la foto (URI - string que representa la ruta a un recurso)

            // si quisieran acceder al archivo necesitan configurar un provider

            // obteniendo el thumbnail
            val image = result.data?.extras?.get("data") as Bitmap
            imageView.setImageBitmap(image)
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo)

        // obtener referencia
        imageView = findViewById(R.id.imageView)
/*
        // pruebas de objetos
        var tigrito = Mamifero(4, "Tigrito")
        var leoncito = Mamifero(5, "Leoncito", 200f)
        var panterita = Mamifero(3, "Panterita", 150f, "negro")

        tigrito.saludar()
        leoncito.saludar()
        panterita.saludar()
*/
        var fifi = Perrito(5, "Fifi", 5f, "French Poodle")
        var killer = Perrito(3, "Killer", 2f, "Chihuahueño", "GDL")

        fifi.saludar()
        killer.saludar()
        fifi.comer()
        killer.comer()

        // podemos tener un objeto de tipo abstracto
        // PERO no podemos instanciar una clase abstracta
        var fifiMamifero: Mamifero = fifi
        var killerMamifero: Mamifero = killer

        // podemos tener un objeto de tipo interfaz
        // PERO no podemos instanciarlo
        var fifiPaseable: Paseable = fifi
        var killerPaseable: Paseable = killer

        // aunque en el fondo son perritos, sólo pueden correr lo que el tipo permita
        fifiMamifero.saludar()
        killerMamifero.saludar()

        fifiPaseable.pasear()
        killerPaseable.pasear()

        // casting - cambio arbitrario de tipo
        // puede ser PELIGROSO!!!
        // ningún problema entre tipos representables por objeto

        var fifi2 = fifiMamifero as Perrito
        fifi2.comer()
    }

    // solicitar tomar foto
    fun tomarFoto(v : View?){

        // 2 maneras de declarar un intent para abrir actividad
        // 1. utilizando explícitamente un tipo
        // 2. por medio de una acción (expresada en string)

        val photoIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

        // voy a escuchar retorno
        resultLauncher.launch(photoIntent)
    }
}