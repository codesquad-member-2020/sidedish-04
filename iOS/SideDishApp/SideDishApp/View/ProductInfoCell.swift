//
//  ProductInfoCell.swift
//  SideDishApp
//
//  Created by 임승혁 on 2020/04/21.
//  Copyright © 2020 임승혁. All rights reserved.
//

import UIKit

class ProductInfoCell: UITableViewCell {
    @IBOutlet weak var productImage: UIImageView!
    @IBOutlet weak var productTitle: UILabel!
    @IBOutlet weak var productSubTitle: UILabel!
    @IBOutlet weak var productPrice: UILabel!
    @IBOutlet weak var eventBagdeStackView: UIStackView!
    
    override func awakeFromNib() {
        super.awakeFromNib()
    }

    override func setSelected(_ selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)
    }

}
