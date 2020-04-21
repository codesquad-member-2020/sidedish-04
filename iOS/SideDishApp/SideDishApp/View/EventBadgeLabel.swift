//
//  EventBadgeLabel.swift
//  SideDishApp
//
//  Created by 임승혁 on 2020/04/21.
//  Copyright © 2020 임승혁. All rights reserved.
//

import UIKit

class EventBadgeLabel: UILabel {
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
    
    override var text: String? {
        didSet {
            changeBackgroundColor(labelText: self.text)
        }
    }
    
    private func changeBackgroundColor(labelText: String?) {
        guard let badgeString = labelText else { return }
        
        self.textColor = .white
        self.font = UIFont.systemFont(ofSize: 13, weight: .medium)
        
        if badgeString.contains("특가") {
            self.backgroundColor = UIColor(named: "SpecialPrice")
        } else if badgeString.contains("증정") {
            self.backgroundColor = UIColor(named: "Gift")
        } else if badgeString.contains("품절"){
            self.backgroundColor = .black
        }
    }
}
