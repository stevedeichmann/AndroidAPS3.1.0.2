package info.nightscout.sdk.localmodel

public data class Status(
    val version: String,
    val apiVersion: String,
    val srvDate: Long,
    val storage: Storage,
    val apiPermissions: ApiPermissions
)
