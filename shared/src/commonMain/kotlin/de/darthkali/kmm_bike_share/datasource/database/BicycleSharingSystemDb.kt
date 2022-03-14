package de.darthkali.kmm_bike_share.datasource.database

data class BicycleSharingSystemDb(
    var databaseId: Int? = null,
    var bssid: String,
    var brand: String? = "",
    var city: String? = "",
    var country: String? = "",
    var site: String? = "",
    var electric: String? = "no",
    var currently_active: String? = "no",
) {

    override fun toString(): String {
        return StringBuilder()
            .append("|databaseId: ")
            .append(this.databaseId)
            .append("| bssid: ")
            .append(this.bssid)
            .append("| brand: ")
            .append(this.brand)
            .append("| city: ")
            .append(this.city)
            .append("| country: ")
            .append(this.country)
            .append("| site: ")
            .append(this.site)
            .append("| electric: ")
            .append(this.electric)
            .append("| currently_active: ")
            .append(this.currently_active)
            .append("|")
            .toString()
    }

    /**
     * to check that 2 BicycleSharingSystems are the same
     * without the id
     * this is important for the tests because when we run the tests, we don't know
     * which ids the inserted items will get.
     *
     * with this we can easily check that this has the same attributes
     *
     * @param other: the other element to compare with this
     * @return a boolean true / false
     */
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as BicycleSharingSystemDb

        if (databaseId != other.databaseId) return false
        if (bssid != other.bssid) return false
        if (brand != other.brand) return false
        if (city != other.city) return false
        if (country != other.country) return false
        if (site != other.site) return false
        if (electric != other.electric) return false
        if (currently_active != other.currently_active) return false

        return true
    }

    override fun hashCode(): Int {
        var result = databaseId ?: 0
        result = 31 * result + bssid.hashCode()
        result = 31 * result + (brand?.hashCode() ?: 0)
        result = 31 * result + (city?.hashCode() ?: 0)
        result = 31 * result + (country?.hashCode() ?: 0)
        result = 31 * result + (site?.hashCode() ?: 0)
        result = 31 * result + (electric?.hashCode() ?: 0)
        result = 31 * result + (currently_active?.hashCode() ?: 0)
        return result
    }


}
