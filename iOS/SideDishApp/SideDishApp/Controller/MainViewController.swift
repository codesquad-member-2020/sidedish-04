//
//  ViewController.swift
//  SideDishApp
//
//  Created by 임승혁 on 2020/04/21.
//  Copyright © 2020 임승혁. All rights reserved.
//

import UIKit

class MainViewController: UIViewController {
    
    @IBOutlet weak var mainTableView: UITableView!
    
    let dataSource = ProductTableViewDataSource()
    let delegate = ProductTableViewDelegate()
    let dataManager = DataManger()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        let nib = UINib(nibName: "SectionHeader", bundle: nil)
        mainTableView.register(nib, forHeaderFooterViewReuseIdentifier: "TableSectionHeader")
        mainTableView.delegate = delegate
        mainTableView.dataSource = dataSource
        
        DataUseCase.loadAllDishes(manager: NetworkManager()) { (sideDish, indexNum, error) in
            if error != nil {
                print("Data load Error!") //알람창 뜨도록 변경할 것.
                return
            }
            self.updateDataSource(sideDishInfo: sideDish!, indexNum: indexNum!)
        }
        
        NotificationCenter.default.addObserver(self, selector: #selector(reloadDataSource), name: .changeDataSourceValue, object: nil)
    }
    
    override func viewDidAppear(_ animated: Bool) {
        super.viewDidAppear(animated)
        
        if let loginScreen = self.storyboard?.instantiateViewController(withIdentifier: "Login"){
            self.present(loginScreen, animated: true, completion: nil)
        }
    }
    
    private func updateDataSource(sideDishInfo: [DetailSideDishInfo], indexNum: Int) {
        dataManager.insertDish(dish: sideDishInfo, index: indexNum)
    }
    
    @objc private func reloadDataSource(notification: Notification) {
        guard let notificationInfo = notification.userInfo as? [String:Int] else { return }
        let row = notificationInfo["reloadSection"]!
        
        dataSource.sideDish[row] = dataManager.allDishes[row]
        //self.mainTableView.reloadData()
        self.mainTableView.reloadSections(IndexSet(integersIn: row...row), with: .automatic)
    }
}

