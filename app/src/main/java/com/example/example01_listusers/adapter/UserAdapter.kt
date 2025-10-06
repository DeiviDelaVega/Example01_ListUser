package com.example.example01_listusers.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.example01_listusers.R
import com.example.example01_listusers.data.User
import com.google.android.material.button.MaterialButton

class UserAdapter(
    private val onButtonClick: (User) -> Unit
) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    private var users: MutableList<User> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_users, parent, false)
        return UserViewHolder(view)

    }

    override fun onBindViewHolder(
        holder: UserViewHolder,
        position: Int
    ) {
        val user = users[position]
        holder.bind(user, onButtonClick)
    }

    override fun getItemCount(): Int {
        return users.size
    }

    fun updateUserList(newUsers: List<User>) {

        val oldSize = this.users.size
        if (oldSize > 0) {
            this.users.clear()
            notifyItemRangeRemoved(0, oldSize)
        }

        if (newUsers.isNotEmpty()) {
            this.users.addAll(newUsers)
            notifyItemRangeInserted(0, newUsers.size)
        }
    }

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val text: TextView = itemView.findViewById(R.id.text_item)
        val image: ImageView = itemView.findViewById(R.id.image_item)

        val button: MaterialButton = itemView.findViewById(R.id.button_item)

        fun bind(user: User, onButtonClick: (User) -> Unit) {
            text.text = user.name
            image.setImageResource(user.image)

            button.setOnClickListener {
                onButtonClick(user)

            }
        }

    }
}