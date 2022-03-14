package de.darthkali.kmm_bike_share.mockFactory

import de.darthkali.kmm_bike_share.datasource.database.BicycleSharingSystemDb

object BicycleSharingSystemMock {

    val bicycleSharingSystemDb = BicycleSharingSystemDb(
        bssid = "london",
        brand = "Santander Cycles",
        city = "London",
        country = "United Kingdom",
        site = "https://tfl.gov.uk/modes/cycling/santander-cycles",
        electric = "no",
        currently_active = "yes"
    )


    val bicycleSharingSystemDbList = listOf(
        BicycleSharingSystemDb(
            bssid = "london",
            brand = "Santander Cycles",
            city = "London",
            country = "United Kingdom",
            site = "https://tfl.gov.uk/modes/cycling/santander-cycles",
            electric = "no",
            currently_active = "yes"
        ),
        BicycleSharingSystemDb(
            bssid = "belfast",
            brand = "Belfast Bikes",
            city = "Belfast",
            country = "United Kingdom",
            site = "http://www.belfastbikes.co.uk",
            electric = "no",
            currently_active = "yes"
        ),
        BicycleSharingSystemDb(
            bssid = "slough",
            brand = "Cycle Hire Slough",
            city = "Slough",
            country = "United Kingdom",
            site = "https://www.cycleslough.com/",
            electric = "no",
            currently_active = "yes"
        ),
        BicycleSharingSystemDb(
            bssid = "bath",
            brand = "Bike in Bath",
            city = "Bath",
            country = "United Kingdom",
            site = "http://www.bikeinbath.com/",
            electric = "no",
            currently_active = "no"
        ),
        BicycleSharingSystemDb(
            bssid = "glasgow",
            brand = "Glasgow Nextbike",
            city = "Glasgow",
            country = "United Kingdom",
            site = "http://www.nextbike.co.uk/en/glasgow/",
            electric = "no",
        ),
        BicycleSharingSystemDb(
            bssid = "cambridge1993",
            brand = "Green Bike Scheme",
            city = "Cambridge",
            country = "United Kingdom",
            site = null,
            electric = "yes",
            currently_active = "no"
        ),
        BicycleSharingSystemDb(
            bssid = "portsmouth",
            brand = "Bikeabout",
            city = "Portsmouth",
            country = "United Kingdom",
            site = null,
            electric = "no",
            currently_active = "yes"
        ),
        BicycleSharingSystemDb(
            bssid = "milton_keynes",
            brand = "Santander Cycles MK",
            city = "Milton Keynes",
            country = "United Kingdom",
            site = "https://santandercyclesmk.co.uk/",
            electric = "no",
            currently_active = "yes"


        ),
        BicycleSharingSystemDb(
            bssid = "lincoln",
            brand = "hirebike",
            city = "Lincoln",
            country = "United Kingdom",
            site = "https://www.hirebikelincoln.co.uk",
            electric = "yes",
            currently_active = "no"

        ),
        BicycleSharingSystemDb(
            bssid = "edinburgh",
            brand = "Just Eat Cycles",
            city = "Edinburgh",
            country = "United Kingdom",
            site = "https://edinburghcyclehire.com/",
            electric = "no",
            currently_active = "yes"

        ),
    )
}

