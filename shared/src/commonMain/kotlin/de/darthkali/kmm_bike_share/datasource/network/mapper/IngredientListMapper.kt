//package de.darthkali.kmm_bike_share.datasource.network.mapper
//
//import de.darthkali.kmm_bike_share.datasource.BaseMapper
//import de.darthkali.kmm_bike_share.datasource.network.model.BicycleSharingSystemsDto
//
//class IngredientListMapper : BaseMapper<List<Ingredient>, List<BicycleSharingSystemsDto>> {
//
//    private val internalMapper = IngredientMapper()
//
//    override fun mapTo(db: List<BicycleSharingSystemsDto>): List<Ingredient> {
//        val resultList = mutableListOf<Ingredient>()
//
//        db.forEach {
//            resultList.add(internalMapper.mapTo(it))
//        }
//        return resultList
//    }
//
//    override fun mapBack(internal: List<Ingredient>): List<BicycleSharingSystemsDto> {
//        val resultList = mutableListOf<BicycleSharingSystemsDto>()
//
//        internal.forEach {
//            resultList.add(internalMapper.mapBack(it))
//        }
//        return resultList
//    }
//}
