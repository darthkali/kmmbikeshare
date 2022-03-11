//package de.darthkali.kmm_bike_share.datasource.network.mapper
//
//import de.darthkali.kmm_bike_share.datasource.BaseMapper
//import de.darthkali.kmm_bike_share.datasource.network.model.BicycleSharingSystemsDto
//
//class IngredientMapper : BaseMapper<Ingredient, BicycleSharingSystemsDto> {
//
//    override fun mapTo(db: BicycleSharingSystemsDto): Ingredient {
//        return Ingredient(
//            apiId = db.apiId,
//            name = db.name,
//            image = db.image,
//            quantity = 0F,
//            unit = "",
//        )
//    }
//
//    override fun mapBack(internal: Ingredient): BicycleSharingSystemsDto {
//        return BicycleSharingSystemsDto(
//            apiId = internal.apiId,
//            name = internal.name,
//            image = internal.image,
//        )
//    }
//}
