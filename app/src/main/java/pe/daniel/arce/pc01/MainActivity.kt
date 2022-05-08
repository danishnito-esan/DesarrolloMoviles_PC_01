package pe.daniel.arce.pc01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val talla: TextView = findViewById(R.id.txtTalla)
        val peso: TextView = findViewById(R.id.txtPeso)

        val btnCalcular: Button = findViewById(R.id.btnCalcular)

        btnCalcular.setOnClickListener {
            this.mostrarResultado(
                talla = talla.text.toString().toInt(),
                peso = peso.text.toString().toInt()
            )
        }

    }

    private fun mostrarResultado(talla: Int, peso: Int) {
        val intentResultado = Intent(this, ResultadoActivity::class.java)
        intentResultado.putExtra("talla", talla)
        intentResultado.putExtra("peso", peso)

        startActivity(intentResultado)
    }
}