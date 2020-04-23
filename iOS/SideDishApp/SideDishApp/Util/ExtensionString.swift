//
//  RenderView.swift
//  SideDishApp
//
//  Created by 임승혁 on 2020/04/21.
//  Copyright © 2020 임승혁. All rights reserved.
//

import Foundation

extension String {
    func strikeThrough() -> NSAttributedString {
        let attributeString = NSMutableAttributedString(string: self)
        attributeString.addAttribute(
          NSAttributedString.Key.strikethroughStyle,
          value: 1,
          range: NSRange(location: 0, length: attributeString.length))

          return attributeString
    }
}
