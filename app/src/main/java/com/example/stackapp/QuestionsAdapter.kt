package com.example.stackapp

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.stackapp.models.Item
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_question.view.*

class QuestionsAdapter : RecyclerView.Adapter<QuestionsAdapter.QuestionsViewHolder>(){

    private val questions = mutableListOf<Item>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return QuestionsViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: QuestionsViewHolder, position: Int) {
        holder.bind(questions[position])
    }

    fun refreshData(newQuestions: List<Item>){
        questions.clear()
        questions.addAll(newQuestions)
        notifyDataSetChanged()
    }

    override fun getItemCount() = questions.size

    inner class QuestionsViewHolder(inflater: LayoutInflater, parent: ViewGroup) : RecyclerView.ViewHolder(inflater.inflate(R.layout.item_question, parent, false)){

        fun bind(question: Item){

            itemView.run {
                textQuestion.text = question.title
                textUsername.text = question.owner.displayName
                Picasso.get().load(question.owner.profileImage).into(imgProfil)

                setOnClickListener {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(question.link))
                    context.startActivity(intent)
                }

            }

        }

    }

}