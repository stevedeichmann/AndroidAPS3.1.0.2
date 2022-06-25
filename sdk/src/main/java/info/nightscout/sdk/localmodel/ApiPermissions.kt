package info.nightscout.sdk.localmodel

public data class ApiPermissions(
    val deviceStatus: ApiPermission,
    val entries: ApiPermission,
    val food: ApiPermission,
    val profile: ApiPermission,
    val settings: ApiPermission,
    val treatments: ApiPermission
)
