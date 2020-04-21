//
//  ViewController.swift
//  SideDishApp
//
//  Created by 임승혁 on 2020/04/21.
//  Copyright © 2020 임승혁. All rights reserved.
//

import UIKit

class MainViewController: UIViewController, UITableViewDelegate {

    @IBOutlet weak var mainTableView: UITableView!
    
    let dataSource = ProductTableViewDataSource()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        mainTableView.dataSource = dataSource
        mainTableView.delegate = self
        
    }
}

