package mx.itesm.semana6pm

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

// shared prefs
// prefs - preferencias
// mecanismo para almacenamiento local
// almacenan información en un archivo XML local
// sirven para cargarlo en runtime como un objeto de kotlin


class MainActivity : AppCompatActivity() {

    private val PREFS_ARCHIVO = "prefs.xml"
    private val PREFS_NOMBRE = "nombre"
    private val PREFS_CIUDAD = "ciudad"

    lateinit var sharedPrefsIn : EditText
    lateinit var sharedPrefsOut : TextView
    lateinit var sharedPrefs : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // obtener referencia a widgets
        sharedPrefsIn = findViewById(R.id.mainSharedPrefIn)
        sharedPrefsOut = findViewById(R.id.mainSharedPrefOut)

        // obtener objeto shared preferences
        // que contendra las tuplas llave-valor que conformen al archivo XML

        sharedPrefs = getSharedPreferences(PREFS_ARCHIVO, Context.MODE_PRIVATE)

        // escritura de prueba de shared prefs
        // primero necesitamos obtener un objeto para edición
        with(sharedPrefs.edit()){

            putString(PREFS_NOMBRE, "Memo")

            // 2 opciones para ver cambios reflejados

            // apply actualiza en memoria
            // apply()

            // 2da opción es commit
            // actualiza en archivo
            // puede bloquear ejecución
            commit()
        }

        sharedPrefsOut.text = sharedPrefs.getString(PREFS_NOMBRE, "no hay nombre todavía")

        Toast.makeText(
            this,
            getString(R.string.main_toast),
            Toast.LENGTH_SHORT
        ).show()
    }

    fun guardar(v: View?){

        with(sharedPrefs.edit()){

            putString(PREFS_CIUDAD, sharedPrefsIn.text.toString())
            commit()
        }
    }

    fun borrarCiudad(v: View?){

        with(sharedPrefs.edit()){
            remove(PREFS_CIUDAD)
            commit()
        }
    }

    fun borrarTodo(v: View?){

        with(sharedPrefs.edit()){
            clear()
            commit()
        }
    }

    fun mostrar(v: View?){

        // lectura de prueba de shared prefs
        Toast.makeText(
            this,
            sharedPrefs.getString(PREFS_NOMBRE, "no hay nombre todavía"),
            Toast.LENGTH_SHORT
        ).show()

        // lectura de prueba de shared prefs
        Toast.makeText(
            this,
            sharedPrefs.getString(PREFS_CIUDAD, "no hay ciudad todavía"),
            Toast.LENGTH_SHORT
        ).show()
    }
}