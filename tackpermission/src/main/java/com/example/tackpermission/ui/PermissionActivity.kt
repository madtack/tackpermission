package com.example.tackpermission.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tackpermission.CheckPermission
import com.example.tackpermission.R
import com.example.tackpermission.listener.PermissionOnClickListener
import com.example.tackpermission.model.PermissionModel

class PermissionActivity : AppCompatActivity() , PermissionOnClickListener {
    private lateinit var perRecyclerView:RecyclerView
    private val perAdapter:PermissionAdapter by lazy { PermissionAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_permission)
        perRecyclerView = findViewById(R.id.per_RecyclerView)

        val permissionEssentialList = intent.getStringArrayListExtra("perEssentialArrayList")
        val permissionChoiceList = intent.getStringArrayListExtra("perChoiceArrayList")

        val permissionEssentialMap = permissionEssentialList?.let { essential -> CheckPermission().checkPermissionMap(essential) }
        val permissionChoiceMap = permissionChoiceList?.let { choice -> CheckPermission().checkPermissionMap(choice) }


        perRecyclerView.adapter = perAdapter
        perRecyclerView.layoutManager = LinearLayoutManager(this)

    }

    override fun onClickItem(permissionItem: PermissionModel) {

    }
}