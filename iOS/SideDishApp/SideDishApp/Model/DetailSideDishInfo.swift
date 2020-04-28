//
//  DetailSideDishInfo.swift
//  SideDishApp
//
//  Created by 임승혁 on 2020/04/25.
//  Copyright © 2020 임승혁. All rights reserved.
//

import Foundation

struct DetailSideDishInfo: Decodable {
    let detail_hash: String
    let image: URL
    let alt: String
    let delivery_type: [String]
    let title: String
    let description: String
    let n_price: String?
    let s_price: String
    let badge: [String]?
}
