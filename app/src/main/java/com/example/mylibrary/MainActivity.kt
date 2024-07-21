package com.example.mylibrary

import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.mylibrary.databinding.ActivityMainBinding
import com.example.tackpermission.listener.PermissionListener
import com.example.tackpermission.TackPermission

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding

    private val permissionListener = object : PermissionListener {
        override fun onPermissionGranted() {
            Toast.makeText(this@MainActivity, "Permission Granted", Toast.LENGTH_SHORT).show()
        }

        override fun onPermissionDenied(deniedStr: String) {
            Toast.makeText(this@MainActivity, "Permission Denied", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)


        val permissionEssentialList = mutableListOf<String>()
        val permissionChoiceList = mutableListOf<String>()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            permissionEssentialList.add(android.Manifest.permission.READ_MEDIA_IMAGES)
        }else{
            permissionEssentialList.add(android.Manifest.permission.READ_EXTERNAL_STORAGE)
            permissionEssentialList.add(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
        }

        TackPermission.create(this)
            .setPermissionListener(permissionListener)
            .setEssentialPermission(permissionEssentialList)
            .setChoicePermission(permissionChoiceList)
            .check()


    }
}