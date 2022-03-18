//
//  IngredientListViewModel.swift
//  iosWeeFood
//
//  Created by Danny Steinbrecher on 13.07.21.
//  Copyright © 2021 orgName. All rights reserved.
//

import SwiftUI
import shared

class BicycleSharingSystemListViewModel: ObservableObject {
    
    private let searchBicycleSharingSystems = SearchBicycleSharingSystems()
    private let saveBicycleSharingSystems = SaveBicycleSharingSystems()
    private let logger = Logger(className: "BicycleSharingSystemListViewModel")
    
    // State
    @Published var state: BicycleSharingSystemListState = BicycleSharingSystemListState()
    
    init(
        country: String
    ){
        updateState(country : country)
        self.loadBicycleSharingSystem()
        
    }
    
    
    private func saveAllBicycleSharingSystems(bicycleSharingSystems: [BicycleSharingSystem]) {
        for bicycleSharingSystem in bicycleSharingSystems {
            saveBicycleSharingSystems.execute(bicycleSharingSystem : bicycleSharingSystem)
        }
    }
    
    
    private func loadBicycleSharingSystem(){
        let currentState = (self.state.copy() as! BicycleSharingSystemListState)
        do{
            try searchBicycleSharingSystems.execute(
                country: currentState.country
            ).collectCommon(
                coroutineScope: nil,
                callback: { dataState in
                    if dataState != nil {
                        let data = dataState?.data
                        let loading = dataState?.isLoading ?? false
                        
                        self.updateState(isLoading: loading)
                        
                        if(data != nil){
                            self.appendBicycleSharingSystems(bicycleSharingSystems: data as! [BicycleSharingSystem])
                            self.saveAllBicycleSharingSystems(bicycleSharingSystems: data as! [BicycleSharingSystem])
                        }
                    }else{
                        self.logger.log(msg: "DataState is nil")
                    }
                })
        }catch{
            self.logger.log(msg: "\(error)")
        }
    }
    
    
    
    private func appendBicycleSharingSystems(bicycleSharingSystems: [BicycleSharingSystem]){
        var currentState = (self.state.copy() as! BicycleSharingSystemListState)
        var currentBicycleSharingSystems = currentState.bicycleSharingSystems
        currentBicycleSharingSystems.append(contentsOf: bicycleSharingSystems)
        self.state = self.state.doCopy(
            isLoading: currentState.isLoading,
            country: currentState.country,
            bicycleSharingSystems: currentBicycleSharingSystems
        )
        currentState = (self.state.copy() as! BicycleSharingSystemListState)
    }
    
    
    
    /**
     *  Not everything can be conveniently updated with this function.
     *  Things like recipes, selectedCategory must have their own functions.
     */
    private func updateState(
        isLoading: Bool? = nil,
        country: String? = ""
    ){
        let currentState = (self.state.copy() as! BicycleSharingSystemListState)
        self.state = self.state.doCopy(
            isLoading: isLoading ?? currentState.isLoading,
            country: country ?? currentState.country,
            bicycleSharingSystems: currentState.bicycleSharingSystems
        )
    }
}
