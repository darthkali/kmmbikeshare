package de.darthkali.kmmbikeshare.datasource

interface BaseMapper<I, D> {
    fun mapTo(db: D): I
    fun mapBack(internal: I): D
}
