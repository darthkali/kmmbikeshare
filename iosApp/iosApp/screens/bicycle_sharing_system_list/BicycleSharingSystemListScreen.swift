//
//  IngredientListScreen.swift
//  iosWeeFood
//
//  Created by Danny Steinbrecher on 11.07.21.
//  Copyright © 2021 orgName. All rights reserved.
//

import SwiftUI
import shared

@available(iOS 14.0, *)
struct BicycleSharingSystemListScreen: View {
    
    @ObservedObject var viewModel: BicycleSharingSystemListViewModel
    
    init(country: String) {
        self.viewModel = BicycleSharingSystemListViewModel(country : country)
        // dismiss keyboard when drag starts
        UIScrollView.appearance().keyboardDismissMode = .onDrag
    }
    
    var body: some View {
        VStack{
            Text("Bicycle Sharing System List Screen")
            ScrollView {
                ForEach(viewModel.state.bicycleSharingSystems, id: \.self){ bicycleSharingSystem in
                    VStack{
                        NavigationLink(destination: BicycleSharingSystemDetailScreen(bssid: bicycleSharingSystem.bssid)) {
                            VStack{
                                Text(bicycleSharingSystem.brand ?? "")
                                Text(bicycleSharingSystem.city ?? "")
                                Divider()
                            }
                        }
                    }
                }
            }
        }
        if viewModel.state.isLoading {
            ProgressView("Searching BicycleSharingSystems...")
        }
    }
    
}
