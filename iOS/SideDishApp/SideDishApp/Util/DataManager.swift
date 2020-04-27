//
//  DataManager.swift
//  SideDishApp
//
//  Created by 임승혁 on 2020/04/26.
//  Copyright © 2020 임승혁. All rights reserved.
//

import Foundation

class DataManger {
    var allDishes = [Int:[DetailSideDishInfo]]()
    
    public func insertDish(dish: [DetailSideDishInfo], index: Int) {
        allDishes[index] = dish
        NotificationCenter.default.post(name: .changeDataSourceValue, object: nil, userInfo: ["reloadSection" : index])
    }
}
