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

        // Ambil data dari Intent
        val title = intent.getStringExtra("title")
        val releaseDate = intent.getStringExtra("releaseDate")
        val description = intent.getStringExtra("description")
        val pages = intent.getIntExtra("pages", 0)
        val cover = intent.getStringExtra("cover")

        // Tampilkan ke layout
        binding.txtDetailTitle.text = title ?: "No Title"
        binding.txtDetailRelease.text = "Release: ${releaseDate ?: "-"}"
        binding.txtDetailPages.text = "Pages: $pages"
        binding.txtDetailDesc.text = description ?: "No Description"

        // Load Cover Image
        Glide.with(this)
            .load(cover)
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_foreground)
            .into(binding.imgDetailCover)
    }
}
