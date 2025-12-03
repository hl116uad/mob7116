package hidayatlossen.prak7_116

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import hidayatlossen.prak7_116.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Ambil data dari intent
        val title = intent.getStringExtra("title")
        val originalTitle = intent.getStringExtra("originalTitle")
        val releaseDate = intent.getStringExtra("releaseDate")
        val description = intent.getStringExtra("description")
        val pages = intent.getIntExtra("pages", 0)
        val cover = intent.getStringExtra("cover")

        // Set data ke view
        binding.txtDetailTitle.text = title ?: "-"
        binding.txtDetailOriginalTitle.text = originalTitle ?: "-"
        binding.txtDetailRelease.text = "Release Date: ${releaseDate ?: "-"}"
        binding.txtDetailDesc.text = description ?: "-"
        binding.txtDetailPages.text = "Pages: $pages"

        // Load Cover Full Width
        Glide.with(this)
            .load(cover)
            .into(binding.imgDetailCover)
    }
}
