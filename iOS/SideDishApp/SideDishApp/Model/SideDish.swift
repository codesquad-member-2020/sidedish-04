//
//  SideDish.swift
//  SideDishApp
//
//  Created by 임승혁 on 2020/04/24.
//  Copyright © 2020 임승혁. All rights reserved.
//

import Foundation

struct SideDishResponse: Decodable {
    let statusCode: String
    let body: [DetailSideDishInfo]
}
