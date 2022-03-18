import SwiftUI
import shared

class BicycleSharingSystemDetailViewModel: ObservableObject {
    
    
    // Dependencies
    private let getBicycleSharingSystem = GetBicycleSharingSystem()
    
    
    // State
    @Published var state: BicycleSharingSystemDetailState =  BicycleSharingSystemDetailState()
    
    init(
        bssid: String
    ) {
        loadBicycleSharingSystem(bssid : bssid)
    }
    
    
    private func loadBicycleSharingSystem(bssid: String) {
        let bicycleSharingSystem = getBicycleSharingSystem.execute(bssid : bssid)
        if (bicycleSharingSystem != nil) {
            self.state = self.state.doCopy(
                isLoading : true,
                bssid : bicycleSharingSystem!.bssid,
                brand : bicycleSharingSystem!.brand,
                city : bicycleSharingSystem!.city,
                country : bicycleSharingSystem!.country,
                site : bicycleSharingSystem!.site,
                electric : bicycleSharingSystem!.electric,
                currently_active : bicycleSharingSystem!.currently_active
            )
        }
    }    
}





