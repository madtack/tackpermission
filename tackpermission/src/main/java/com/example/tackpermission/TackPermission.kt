package com.example.tackpermission

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import com.example.tackpermission.listener.PermissionListener
import com.example.tackpermission.ui.PermissionActivity

@SuppressLint("StaticFieldLeak")
object TackPermission {

    private var listener: PermissionListener? = null
    private lateinit var intent:Intent
    private lateinit var context:Context
    private lateinit var perEssentialArrayList:ArrayList<String>
    private lateinit var perChoiceArrayList:ArrayList<String>

    fun setPermissionListener(permissionListener: PermissionListener): TackPermission {
        listener = permissionListener
        return this
    }

    fun create(context: Context): TackPermission {
        this.context = context
        this.intent = Intent(TackPermission.context, PermissionActivity::class.java)
        return this
    }

    fun setEssentialPermission(permissionEssentialList:List<String>): TackPermission {
        this.perEssentialArrayList = ArrayList(permissionEssentialList)
        return this
    }

    fun setChoicePermission(permissionChoiceList: List<String>) : TackPermission{
        this.perChoiceArrayList = ArrayList(permissionChoiceList)
        return this
    }

    fun check(){
        intent.putStringArrayListExtra("perEssentialArrayList", perEssentialArrayList)
        intent.putStringArrayListExtra("perChoiceArrayList", perChoiceArrayList)
        context.startActivity(intent)
    }

    fun setDeniedAlertMessage(deniedStr:String):TackPermission{

        return this
    }

    fun setDeniedMessage(): TackPermission{
        return this
    }


}