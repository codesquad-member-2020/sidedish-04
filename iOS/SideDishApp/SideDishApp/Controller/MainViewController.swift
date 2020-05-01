//
//  ViewController.swift
//  SideDishApp
//
//  Created by 임승혁 on 2020/04/21.
//  Copyright © 2020 임승혁. All rights reserved.
//

import UIKit
import Toaster

class MainViewController: UIViewController {
    
    @IBOutlet weak var mainTableView: UITableView!
    
    let dataSource = ProductTableViewDataSource()
    let delegate = ProductTableViewDelegate()
    let dataManager = DataManger()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        if let loginScreen = self.storyboard?.instantiateViewController(withIdentifier: "Login"){
            self.present(loginScreen, animated: true, completion: nil)
        }
        
        let nib = UINib(nibName: "SectionHeader", bundle: nil)
        mainTableView.register(nib, forHeaderFooterViewReuseIdentifier: "TableSectionHeader")
        mainTableView.delegate = delegate
        mainTableView.dataSource = dataSource
        
        DataUseCase.loadAllDishes(manager: NetworkManager()) { (sideDish, indexNum, error) in
            if error != nil {
                print("Data load Error!")
                return
            }
            self.updateDataSource(sideDishInfo: sideDish!, indexNum: indexNum!)
        }
        
        NotificationCenter.default.addObserver(self, selector: #selector(reloadDataSource), name: .changeDataSourceValue, object: nil)
        NotificationCenter.default.addObserver(self, selector: #selector(showToast), name: .touchSectionHeader, object: nil)
    }
    
    override func viewWillAppear(_ animated: Bool) {
        super.viewWillAppear(animated)
        self.navigationController?.setNavigationBarHidden(true, animated: animated)
    }
    
    override func viewWillDisappear(_ animated: Bool) {
        super.viewWillDisappear(animated)
        self.navigationController?.setNavigationBarHidden(false, animated: animated)
    }
    
    private func updateDataSource(sideDishInfo: [DetailSideDishInfo], indexNum: Int) {
        dataManager.insertDish(dish: sideDishInfo, index: indexNum)
    }
    
    @objc private func reloadDataSource(notification: Notification) {
        guard let notificationInfo = notification.userInfo as? [String:Int] else { return }
        let row = notificationInfo["reloadSection"]!
        
        dataSource.sideDish[row] = dataManager.allDishes[row]
        self.mainTableView.reloadSections(IndexSet(integersIn: row...row), with: .automatic)
    }
    
    @objc private func showToast(notification: Notification) {
        guard let sectionIndex = notification.userInfo?["sectionIndex"] as? Int else { return }
        guard let sectionTitle = notification.userInfo?["sectionTitle"] as? String else { return }
        
        let productCount = dataManager.allDishes[sectionIndex]?.count
        Toast(text: "\(sectionTitle)상품은 \(productCount ?? 0)개가 있습니다.").show()
    }
}

