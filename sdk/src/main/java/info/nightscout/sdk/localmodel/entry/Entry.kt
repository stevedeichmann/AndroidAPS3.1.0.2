package info.nightscout.sdk.localmodel.entry

public interface Entry {
    public val date: Long
    public val device: String?
    public val identifier: String
    public val srvModified: Long
    public val srvCreated: Long
    public val utcOffset: Int
    public val subject: String?
    public var isReadOnly: Boolean // TODO: nullability?
    public val isValid: Boolean
}
// TODO: add date string?
