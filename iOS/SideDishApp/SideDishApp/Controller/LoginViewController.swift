//
//  LoginViewController.swift
//  SideDishApp
//
//  Created by 임승혁 on 2020/04/23.
//  Copyright © 2020 임승혁. All rights reserved.
//

import UIKit
import WebKit

class LoginViewController: UIViewController, WKUIDelegate, WKNavigationDelegate {
    
    var webView: WKWebView?
    
    @IBAction func loginButton(_ sender: Any) {
        let webConfiguration = WKWebViewConfiguration()
        webView = WKWebView(frame: .zero, configuration: webConfiguration)
        view = webView
        
        webView?.uiDelegate = self
        webView?.navigationDelegate = self
        
        let myURL = URL(string:"https://github.com/login/oauth/authorize?client_id=bc4a9e51a6494c1d0626&redirect_uri=http://15.164.33.98/api/sidedish2/github/callback&scope=user")
        
        let myRequest = URLRequest(url: myURL!)
        webView?.load(myRequest)
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
    }
    
    public func webView(_ webView: WKWebView, decidePolicyFor navigationResponse: WKNavigationResponse, decisionHandler: @escaping (WKNavigationResponsePolicy) -> Void) {
        
        guard let response = navigationResponse.response as? HTTPURLResponse else { return }
        if (response.statusCode == 202) {
            self.presentingViewController?.dismiss(animated: true, completion: nil)
        }
        decisionHandler(.allow)
    }

}

