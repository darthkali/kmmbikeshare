package de.darthkali.kmm_bike_share.datasource

interface BaseMapper<I, D> {
    fun mapTo(db: D): I
    fun mapBack(internal: I): D
}
