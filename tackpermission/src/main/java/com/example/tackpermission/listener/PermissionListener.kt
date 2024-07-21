package com.example.tackpermission.listener

interface PermissionListener {

    fun onPermissionGranted()

    fun onPermissionDenied(deniedStr:String)
}