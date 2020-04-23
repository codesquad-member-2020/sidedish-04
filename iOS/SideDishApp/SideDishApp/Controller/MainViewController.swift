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
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        let nib = UINib(nibName: "SectionHeader", bundle: nil)
        mainTableView.register(nib, forHeaderFooterViewReuseIdentifier: "TableSectionHeader")
        mainTableView.delegate = delegate
        mainTableView.dataSource = dataSource
    }
    
    override func viewDidAppear(_ animated: Bool) {
        super.viewDidAppear(animated)
        
        if let loginScreen = self.storyboard?.instantiateViewController(withIdentifier: "Login"){
            self.present(loginScreen, animated: true, completion: nil)
        }
    }
}

