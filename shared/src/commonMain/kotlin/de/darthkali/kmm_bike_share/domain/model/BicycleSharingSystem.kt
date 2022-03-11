package de.darthkali.kmm_bike_share.domain.model

data class BicycleSharingSystem(
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
            .append("| unit: ")
            .append(this.cooking_time_unit)
            .append("| description: ")
            .append(this.recipeDescription)
            .append("| portion: ")
            .append(this.portion)
            .append("|")
            .toString()
    }

    /**
     * to check that 2 Recipes are the same
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

        // if we will only get a recipe without a portion, we will set the portion equal to the other portions
        if (this.portion == 0 && (other is Recipe)) {
            this.portion = other.portion
        }

        return (
                (other is Recipe) &&
                        other.name == this.name &&
                        other.image == this.image
                ) &&
                other.cooking_time == this.cooking_time &&
                other.cooking_time_unit == this.cooking_time_unit &&
                other.recipeDescription == this.recipeDescription
//                && other.portion == this.portion
//                && other.ingredients.hashCode() == this.ingredients.hashCode()
    }

    /**
     * to check that 2 Ingredients are exact the same
     * it also included the id
     *
     * @return a hash value as an Int
     */
    override fun hashCode(): Int {
        return super.hashCode()
    }

    fun isRecipeEmpty(): Boolean {
        return (
                name == "" &&
                        image == "" &&
                        cooking_time == 0 &&
                        cooking_time_unit == "" &&
                        recipeDescription == "" &&
                        portion == 0
                )
    }
}