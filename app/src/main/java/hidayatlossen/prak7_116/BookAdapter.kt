package hidayatlossen.prak7_116

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import hidayatlossen.prak7_116.databinding.ItemBookBinding

class BookAdapter(
    private var list: List<Book>,
    private val onClick: (Book) -> Unit
) : RecyclerView.Adapter<BookAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        TODO("Not yet implemented")
        val binding = ItemBookBinding.inflate(
            LayoutInflater.from(parent.context),parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        TODO("Not yet implemented")
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
//        TODO("Not yet implemented")
        return list.size
    }

    inner class ViewHolder(val binding: ItemBookBinding)
        : RecyclerView.ViewHolder(binding.root) {
        fun bind(book: Book) {
            binding.txtTitle.text = book.title ?: "No Title"
            binding.txtRelease.text = book.releaseDate ?: "Unknown Release Date"

            Glide.with(binding.ivGambar.context)
                .load(book.cover)
                .centerCrop()
                .into(binding.ivGambar)

            binding.root.setOnClickListener {
                onClick(book)
            }
        }

        }
}