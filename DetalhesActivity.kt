package view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.localizamoviesapp.databinding.ActivityDetailsBinding

class DetalhesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val id = intent.getIntExtra("chaveDoId", -1)

        binding = ActivityDetailsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.tituloText = "Teste"
    }

    //buttonVoltar
    private fun voltarLista(id: String) {
        val intent = Intent(this, ListActivity::class.java)
        startActivity(intent)
    }

}
