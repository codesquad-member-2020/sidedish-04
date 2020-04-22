//
//  EventBadgeViewModel.swift
//  SideDishApp
//
//  Created by 임승혁 on 2020/04/22.
//  Copyright © 2020 임승혁. All rights reserved.
//
import Foundation
import UIKit

class EventBadgeViewModel: EventBadgeProtocol {
    var labelText: String
    var labelColor: UIColor {
        return UIColor.white
    }
    
    var labelFont: UIFont {
        return UIFont.systemFont(ofSize: 13, weight: .medium)
    }
    
    var backGroundColor: UIColor {
        var backgroundColor = UIColor.clear
        if labelText.contains("특가") {
            backgroundColor = UIColor(named: "SpecialPrice")!
        } else if labelText.contains("증정") {
            backgroundColor = UIColor(named: "Gift")!
        } else if labelText.contains("품절"){
            backgroundColor = .black
        }
        return backgroundColor
    }
    
    init(labelText: String) {
        self.labelText = labelText
    }
}
