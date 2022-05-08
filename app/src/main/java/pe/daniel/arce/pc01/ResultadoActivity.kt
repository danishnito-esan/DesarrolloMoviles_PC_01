package pe.daniel.arce.pc01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ResultadoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        val talla: Int = intent.getIntExtra("talla", 1)
        val peso: Int = intent.getIntExtra("peso", 0)

        val txtImc: TextView = findViewById(R.id.txtImc)
        val txtClass: TextView = findViewById(R.id.txtClasificacion)
        val imc = calcularImc(talla, peso)
        txtImc.text = imc.toString()

        if (imc < 18.5) {
            txtClass.text = "Bajo Peso"
            txtClass.setTextColor(resources.getColor(R.color.yellow))
        } else if (imc < 25) {
            txtClass.text = "Normal"
            txtClass.setTextColor(resources.getColor(R.color.green))
        } else if (imc < 30) {
            txtClass.text = "Sobrepeso"
            txtClass.setTextColor(resources.getColor(R.color.orange))
        } else if (imc < 35) {
            txtClass.text = "Obesidad grado I"
            txtClass.setTextColor(resources.getColor(R.color.orange))
        } else if (imc < 40) {
            txtClass.text = "Obesidad grado II"
            txtClass.setTextColor(resources.getColor(R.color.red))
        } else {
            txtClass.text = "Obesidad grado III"
            txtClass.setTextColor(resources.getColor(R.color.red))
        }
    }

    private fun calcularImc(talla: Int, peso: Int): Double {
        return (peso.toDouble() / Math.pow(talla.toDouble(), 2.0)) * 100 * 100
    }
}
