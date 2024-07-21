package com.example.tackpermission.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.tackpermission.R
import com.example.tackpermission.listener.PermissionOnClickListener
import com.example.tackpermission.model.PermissionModel
import java.security.Permission

class PermissionAdapter : RecyclerView.Adapter<PermissionAdapter.PermissionViewHolder>() {
    private val perItemList = listOf<PermissionModel>()
    private lateinit var onClickListener: PermissionOnClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PermissionViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_permission_item, parent, false)
        return PermissionViewHolder(view , onClickListener)
    }

    override fun onBindViewHolder(holder: PermissionViewHolder, position: Int) {
        holder.perItemBind(perItemList[position])
    }

    override fun getItemCount(): Int = perItemList.size

    class PermissionViewHolder(view: View , onClickListener: PermissionOnClickListener) : RecyclerView.ViewHolder(view){

        fun perItemBind(permissionModel: PermissionModel){

        }
    }
}