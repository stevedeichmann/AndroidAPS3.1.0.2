package info.nightscout.sdk.localmodel.entry

public data class Sgv(
    public override val date: Long,
    public override val device: String?,
    public override val identifier: String,
    public override val srvModified: Long,
    public override val srvCreated: Long,
    override val utcOffset: Int,
    override val subject: String?,
    override var isReadOnly: Boolean,
    override val isValid: Boolean,
    public val sgv: Double, // TODO: might be Double?
    public val units: SgvUnits,
    public val direction: Direction,
    public val noise: Int?, // TODO: enum?
    public val filtered: Double?, // number in doc (I found decimal values in API v1
    public val unfiltered: Double?, // number in doc (I found decimal values in API v1
    // TODO: add SVG fields
) : Entry
