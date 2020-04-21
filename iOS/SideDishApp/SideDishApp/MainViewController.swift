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
    
    override func viewDidLoad() {
        super.viewDidLoad()
        mainTableView.dataSource = self
        mainTableView.delegate = self
        
    }
}

extension MainViewController: UITableViewDataSource {
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return 1
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        
        let cell = tableView.dequeueReusableCell(withIdentifier: "productCell", for: indexPath) as? ProductInfoCell
        
        return cell!
    }
    
    
}

extension MainViewController: UITableViewDelegate {
    
}

