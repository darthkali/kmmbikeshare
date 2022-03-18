//
//  WeekListScreen.swift
//  iosWeeFood
//
//  Created by Danny Steinbrecher on 26.07.21.
//  Copyright © 2021 orgName. All rights reserved.
//

import SwiftUI
import shared

struct CountryListScreen: View {
    var body: some View {
        
        NavigationView {
            VStack {
                Text("Country List Screen")
                ScrollView {
                    ForEach(Countries().countryList, id: \.self) { country in
                        VStack {
                            NavigationLink(destination: BicycleSharingSystemListScreen(country: country)) {
                                VStack{
                                    Text(country)
                                    Divider()
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

