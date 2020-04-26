//
//  ProductTableViewDelegate.swift
//  SideDishApp
//
//  Created by 임승혁 on 2020/04/21.
//  Copyright © 2020 임승혁. All rights reserved.
//

import UIKit

class ProductTableViewDelegate: NSObject, UITableViewDelegate {
    
    let sectionLabel = ["메인반찬", "국.찌개", "밑반찬"]
    let sectionTitle = ["한그릇 뚝딱 메인 요리","김이 모락모락 국.찌개","언제 먹어도 든든한 밑반찬"]
    
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
        
        headerView.sectionLabel.text = sectionLabel[section]
        headerView.sectionTitle.text = sectionTitle[section]
        
        return headerView
    }
}
