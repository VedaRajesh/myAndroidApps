package com.example.securenote.Adapter


import android.content.Context


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.securenote.Models.Note
import com.example.securenote.R
import kotlin.random.Random

class NotesAdapter(private val context: Context, val listener:NotesItemClickListener):RecyclerView.Adapter<NotesAdapter.NoteViewHolder>( ){

    private val NoteList=ArrayList<Note>()
    private val fullList=ArrayList<Note>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(
            LayoutInflater.from(context).inflate(R.layout.list_item,parent,false)
        )
    }

    override fun getItemCount(): Int {
        return NoteList.size
    }
fun updateList(newList: List<Note>){
    fullList.clear()
    fullList.addAll(newList)
    NoteList.clear()
    NoteList.addAll(fullList)
    notifyDataSetChanged()

}

    fun filterList(search:String){
        NoteList.clear()
        for(item in fullList){
            if((item.title?.lowercase()?.contains(search.lowercase()) == true) ||
                item.note?.lowercase()?.contains(search.lowercase())==true) {
                    NoteList.add(item)
                }

        }
    }

    fun randomColor():Int {
        val list=ArrayList<Int>()
        list.add(R.color.blue)
        list.add(R.color.white)
        list.add(R.color.yellow)

        val seed=System.currentTimeMillis().toInt()
        val randomIndex= Random(seed).nextInt(list.size)
        return list[randomIndex]

    }
    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val currentnote=NoteList[position]
        holder.title.text=currentnote.title
        holder.title.isSelected=true
        holder.note.text=currentnote.note
        holder.date.text=currentnote.date
        holder.date.isSelected=true
        holder.notes_layout.setCardBackgroundColor(holder.itemView.resources.getColor(randomColor(),null))
        holder.notes_layout.setOnClickListener{
            listener.onItemClicked(NoteList[holder.adapterPosition])
        }
        holder.notes_layout.setOnLongClickListener{
            listener.onLongItemClicked(NoteList[holder.adapterPosition],holder.notes_layout)
            true
        }
    }
    inner class NoteViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val notes_layout=itemView.findViewById<CardView>(R.id.card_layout)
        val title=itemView.findViewById<TextView>(R.id.tvTitle)
        val note=itemView.findViewById<TextView>(R.id.tv_Note)
        val date=itemView.findViewById<TextView>(R.id.tv_Date)

    }

    interface NotesItemClickListener{

        fun onItemClicked(note: Note)
        fun onLongItemClicked(note:Note,cardView: CardView)
    }
}