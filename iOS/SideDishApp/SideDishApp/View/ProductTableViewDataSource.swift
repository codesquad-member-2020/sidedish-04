//
//  ProductTableViewDataSource.swift
//  SideDishApp
//
//  Created by 임승혁 on 2020/04/21.
//  Copyright © 2020 임승혁. All rights reserved.
//

import UIKit

class ProductTableViewDataSource: NSObject, UITableViewDataSource {
    var labelViewModel: EventBadgeViewModel?
    
    let eventBadgeTitle = ["이벤트 특가", "사은품 증정"]
    
    func numberOfSections(in tableView: UITableView) -> Int {
        return 3
    }
    
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return 3
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        guard let cell = tableView.dequeueReusableCell(withIdentifier: "productCell", for: indexPath) as? ProductInfoCell else { return UITableViewCell() }
        
        eventBadgeTitle.forEach { (title) in
            let eventBadge = EventBadgeLabel()
            labelViewModel = EventBadgeViewModel(labelText: title)
            
            eventBadge.text = labelViewModel?.labelText
            eventBadge.font = labelViewModel?.labelFont
            eventBadge.textColor = labelViewModel?.labelColor
            eventBadge.backgroundColor = labelViewModel?.backGroundColor
            
            cell.eventBagdeStackView.addArrangedSubview(eventBadge)
        }

        cell.productTitle.text = "[마더앤찬] 국내산 수제 도토리 묵사발 한그릇"
        cell.productSubTitle.text = "직접 쑨 수제 묵이라 더욱 쫄깃해요!"
        cell.discountPrice.attributedText = "7,900".strikeThrough()
        cell.listPrice.text = "7,100원"
        
        return cell
    }
}
