//
//  ProductTableViewDelegate.swift
//  SideDishApp
//
//  Created by 임승혁 on 2020/04/21.
//  Copyright © 2020 임승혁. All rights reserved.
//

import UIKit

class ProductTableViewDelegate: NSObject, UITableViewDelegate {
    
    func tableView(_ tableView: UITableView,
                   heightForHeaderInSection section: Int) -> CGFloat {
        return 74
    }
    
    func tableView(_ tableView: UITableView,
                   viewForHeaderInSection section: Int) -> UIView? {
        guard let headerView = tableView.dequeueReusableHeaderFooterView(
            withIdentifier: "TableSectionHeader") as? ProductTableViewHeader
            else {
                return nil
        }
        
        headerView.sectionLabel.text = "국 찌개"
        headerView.sectionTitle.text = "김이 모락모락 국 찌개"
        
        return headerView
    }
}
