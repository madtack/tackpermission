package com.example.tackpermission

import com.example.tackpermission.model.PermissionModel

class CheckPermission {

    fun checkPermissionMap(permissionList:List<String>) : Map<String, PermissionModel>{

        val map = mutableMapOf<String, PermissionModel>()

        for (permissionItem in permissionList){
                when(permissionItem) {
                    android.Manifest.permission.READ_MEDIA_IMAGES ->
                        map[permissionItem] = PermissionModel(
                            "이미지 권한 입니다.",
                            "이미지를 사용하려면 해당 권한을 허용하셔야 합니다.",
                            permissionItem
                        )

                    android.Manifest.permission.READ_MEDIA_VIDEO ->
                        map[permissionItem] = PermissionModel(
                            "동영상 권한 입니다.",
                            "동영상을 사용하려면 해당 권한을 허용하셔야 합니다.",
                            permissionItem
                        )
                }
        }
        return map
    }
}