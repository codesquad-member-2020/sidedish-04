//
//  ProductTableViewDataSource.swift
//  SideDishApp
//
//  Created by 임승혁 on 2020/04/21.
//  Copyright © 2020 임승혁. All rights reserved.
//

import UIKit

class ProductTableViewDataSource: NSObject, UITableViewDataSource {
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return 1
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        guard let cell = tableView.dequeueReusableCell(withIdentifier: "productCell", for: indexPath) as? ProductInfoCell else { return UITableViewCell() }
        
        let eventBadge1 = EventBadgeLabel()
        eventBadge1.text = "이벤트 특가"
        let eventBadge2 = EventBadgeLabel()
        eventBadge2.text = "사은품 증정"
        
        cell.eventBagdeStackView.addArrangedSubview(eventBadge1)
        cell.eventBagdeStackView.addArrangedSubview(eventBadge2)
        
        cell.productTitle.text = "[마더앤찬] 국내산 수제 도토리 묵사발 한그릇"
        cell.productSubTitle.text = "직접 쑨 수제 묵이라 더욱 쫄깃해요!"
        cell.discountPrice.attributedText = "7,900".strikeThrough()
        cell.listPrice.text = "7,100원"
        
        return cell
    }
}
