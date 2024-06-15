package com.example.securenote

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.PopupMenu
import android.widget.SearchView
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.bumptech.glide.Glide
import com.example.securenote.Adapter.NotesAdapter
import com.example.securenote.Database.NoteDatabase
import com.example.securenote.Models.Note
import com.example.securenote.Models.NoteViewModel
import com.example.securenote.Utilities.AddNote
import com.example.securenote.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),NotesAdapter.NotesItemClickListener,PopupMenu.OnMenuItemClickListener {

    private  lateinit var binding: ActivityMainBinding
    private  lateinit var database: NoteDatabase
    private  lateinit var viewmodel:NoteViewModel
    private  lateinit var adapter: NotesAdapter
    private  lateinit var selectedNote: Note

private var updatenote=registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
    result ->

    if(result.resultCode==Activity.RESULT_OK){
        val note=result.data?.getSerializableExtra("note") as?Note
        if(note!=null)
        {
            viewmodel.update(note)
        }
    }
}

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)

setContentView(binding.root)

        initUI()
val viewModel=ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory.getInstance(application)).
get(NoteViewModel::class.java)
        viewModel.allNotes.observe(this){list->
            list?.let {
                adapter.updateList(list)
            }
        }

        database=NoteDatabase.getDatabase(this)
    }

    private fun initUI() {
        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.layoutManager=StaggeredGridLayoutManager(2,LinearLayout.VERTICAL)
        adapter= NotesAdapter(this,this)
        binding.recyclerView.adapter=adapter

        val getContent=registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
       result ->
            if(result.resultCode==Activity.RESULT_OK)
            {
                val note=result.data?.getSerializableExtra("note") as?Note
                if(note!=null){
                    viewmodel.insert(note)
                }
            }
        }
        binding.fbAddNote.setOnClickListener {
            val intent=Intent(this,AddNote::class.java)
            getContent.launch(intent)
        }

        binding.searchView.setOnQueryTextListener(object:SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(p0: String?): Boolean {
               return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if(newText!=null){
                    adapter.filterList(newText)
                }
                return true
            }

        })
    }

    override fun onItemClicked(note: Note) {
        val Intent=Intent(this@MainActivity,AddNote::class.java)
        intent.putExtra("current_note",note)
        updatenote.launch(intent)
    }

    override fun onLongItemClicked(note: Note, cardView: CardView) {
        selectedNote=note
        popupDisplay(cardView)
    }
    private fun popupDisplay(cardView: CardView) {
val popup=PopupMenu(this,cardView)
        popup.setOnMenuItemClickListener(this@MainActivity)
        popup.inflate(R.menu.popup_menu)
    }

    override fun onMenuItemClick(item: MenuItem?): Boolean {
        if(item?.itemId==R.id.deleteNote){
            viewmodel.delete(selectedNote)
            return true
        }
        return false
    }
}
