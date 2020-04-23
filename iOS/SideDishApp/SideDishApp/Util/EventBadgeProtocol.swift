//
//  EventBadgeProtocol.swift
//  SideDishApp
//
//  Created by 임승혁 on 2020/04/22.
//  Copyright © 2020 임승혁. All rights reserved.
//

import Foundation
import UIKit

protocol EventBadgeProtocol {
    var labelText: String { get }
    var labelColor: UIColor { get }
    var labelFont: UIFont { get }
    var backGroundColor: UIColor { get }
}
