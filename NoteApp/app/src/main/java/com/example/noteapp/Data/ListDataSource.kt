package com.example.noteapp.Data

import com.example.noteapp.Model.Note

class ListDataSource {
    fun loadData():List<Note> {
        return listOf(
            Note(note = "To Day",discription = "Hello! How was your day today"),
            Note(note = "Laptop",discription = "I brought a new laptop"),
            Note(note = "Apple",discription = "Apple is a first Trillion Dollar Company"),
            Note(note = "Google",discription = "20% of employee in google works without Dgree"),
            Note(note = "HP",discription = "it is in Sylicon Valley"),
            Note(note = "Ryzen 7",discription = "Second Fastest CPU in Ryzen Company"),
            Note(note = "Intel",discription = "Intel is the father for processor"),
            Note(note = "Apple Mouse",discription = "it is super but it is unconfortable to use the design is a wast"),
            Note(note = "Microsoft",discription = "Microsoft is a company what makes OS like Windows"),
            Note(note = "Mac OS",discription = "Mac Os is a Apple OS"),
            Note(note = "Logitech",discription = "Logitech is a accesories company"),
            Note(note = "Boat",discription = "Boat is a HearPhone Complany"),
            Note(note = "To Do",discription = "These Are to do tasks"),
        )
    }

}