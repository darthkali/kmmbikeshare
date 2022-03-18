import SwiftUI
import shared

@available(iOS 14.0, *)
struct BicycleSharingSystemDetailScreen: View {
    
    @ObservedObject var viewModel: BicycleSharingSystemDetailViewModel
    
    init(bssid: String) {
        self.viewModel = BicycleSharingSystemDetailViewModel(bssid : bssid)
        // dismiss keyboard when drag starts
        UIScrollView.appearance().keyboardDismissMode = .onDrag
    }
    
    var body: some View {
        VStack(
            alignment: .leading,
            spacing: 20
        ){
            Group {
                Text("Brand: \(viewModel.state.brand ?? "")")
                Divider()
                Text("City: \(viewModel.state.city ?? "")")
                Divider()
                Text("Country: \(viewModel.state.country ?? "")")
                Divider()
                
            }
            Group {
                Text("Site: \(viewModel.state.site ?? "")")
                Divider()
                Text("Electric: \(viewModel.state.electric ?? "")")
                Divider()
                Text("Currently active: \(viewModel.state.currently_active ?? "")")
                Divider()
                
            }
            Spacer()
            
        }
        
    }
}
