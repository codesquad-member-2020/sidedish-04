//
//  LoginViewController.swift
//  SideDishApp
//
//  Created by 임승혁 on 2020/04/23.
//  Copyright © 2020 임승혁. All rights reserved.
//

import UIKit

class LoginViewController: UIViewController {
    @IBAction func loginButton(_ sender: Any) {
       self.presentingViewController?.dismiss(animated: true, completion: nil)
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
    }
}
