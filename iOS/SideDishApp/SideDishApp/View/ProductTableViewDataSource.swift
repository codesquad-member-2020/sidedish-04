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
    var sideDish = [Int:[DetailSideDishInfo]]()
    
    func numberOfSections(in tableView: UITableView) -> Int {
        return 3
    }
    
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return sideDish[section]?.count ?? 0
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        guard let cell = tableView.dequeueReusableCell(withIdentifier: "productCell", for: indexPath) as? ProductInfoCell else { return UITableViewCell() }
        
        let currentSideDish = sideDish[indexPath.section]?[indexPath.row]
        
        if !cell.eventBagdeStackView.arrangedSubviews.isEmpty {
            cell.eventBagdeStackView.arrangedSubviews.forEach { (badge) in
                badge.removeFromSuperview()
            }
        }
        
        currentSideDish?.badge?.forEach { (title) in
            let eventBadge = EventBadgeLabel()
            labelViewModel = EventBadgeViewModel(labelText: title)
            
            eventBadge.text = labelViewModel?.labelText
            eventBadge.font = labelViewModel?.labelFont
            eventBadge.textColor = labelViewModel?.labelColor
            eventBadge.backgroundColor = labelViewModel?.backGroundColor
            
            cell.eventBagdeStackView.addArrangedSubview(eventBadge)
        }
        
        DataManger().fetchImage(url: currentSideDish!.image, completion: { (image, error) in
            cell.productImage.image = image ?? UIImage()
            cell.productImage.layer.cornerRadius = cell.productImage.frame.height/2
            cell.productImage.layer.borderWidth = 1
            cell.productImage.layer.borderColor = UIColor.clear.cgColor
            cell.productImage.clipsToBounds = true
        })
        
        cell.productTitle.text = currentSideDish?.title
        cell.productSubTitle.text = currentSideDish?.description
        cell.discountPrice.attributedText = ((currentSideDish?.n_price) ?? "").strikeThrough()
        cell.listPrice.text = (currentSideDish?.s_price ?? "") + "원"
        
        return cell
    }
}
