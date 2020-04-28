//
//  ProductTableViewHeader.swift
//  SideDishApp
//
//  Created by 임승혁 on 2020/04/22.
//  Copyright © 2020 임승혁. All rights reserved.
//

import UIKit

class ProductTableViewHeader: UITableViewHeaderFooterView {
    @IBOutlet weak var sectionLabel: SectionHeaderCategory!
    @IBOutlet weak var sectionTitle: UILabel!
    
    override init(reuseIdentifier: String?) {
        super.init(reuseIdentifier: reuseIdentifier)
    }
    
    required init?(coder: NSCoder) {
        super.init(coder: coder)
    }
}
