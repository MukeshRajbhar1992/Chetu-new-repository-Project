package com.example.chetunewretrofitproject.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.chetunewretrofitproject.R
import com.example.chetunewretrofitproject.databinding.CustomLayoutUsersViewBinding
import com.example.chetunewretrofitproject.model.UsersListItem

class UsersAdapter(private val usersList:List<UsersListItem>,private val context: Context) :RecyclerView.Adapter<UsersAdapter.UserViewHolder>(){
    class UserViewHolder(var binding: CustomLayoutUsersViewBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding:CustomLayoutUsersViewBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),
            R.layout.custom_layout_users_view,parent,false)
        return UserViewHolder(binding)
    }


    override fun getItemCount(): Int {
        return usersList.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val listUsers = usersList[position]
        holder.binding.apply {
          usersId.text = listUsers.id.toString()
            userName.text =listUsers.name
            userEmail.text =listUsers.email
            userCity.text= listUsers.address.city
            userPhone.text = listUsers.phone
            userWebSite.text = listUsers.website
            userCompanyName.text = listUsers.company.name
        }
    }
}