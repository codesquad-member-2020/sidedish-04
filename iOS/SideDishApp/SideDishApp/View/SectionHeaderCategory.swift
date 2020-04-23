//
//  SectionHeaderCategory.swift
//  SideDishApp
//
//  Created by 임승혁 on 2020/04/21.
//  Copyright © 2020 임승혁. All rights reserved.
//

import UIKit

class SectionHeaderCategory: UILabel {
    @IBInspectable var padding: UIEdgeInsets = UIEdgeInsets(top: 4, left: 4, bottom: 4, right: 4)
    
    override func drawText(in rect: CGRect) {
        let paddinginRect = rect.inset(by: padding)
        super.drawText(in: paddinginRect)
    }
    
    override var intrinsicContentSize: CGSize {
        var contentSize = super.intrinsicContentSize
        contentSize.height += padding.top + padding.bottom
        contentSize.width += padding.left + padding.right
        return contentSize
    }
    
    override var layer: CALayer {
        let borderLayer = super.layer
        borderLayer.borderColor = UIColor.gray.cgColor
        borderLayer.borderWidth = 1
        return borderLayer
    }
}
