//
//  LoginViewController.swift
//  SideDishApp
//
//  Created by 임승혁 on 2020/04/23.
//  Copyright © 2020 임승혁. All rights reserved.
//

import UIKit
import WebKit
import Toaster

class LoginViewController: UIViewController, WKUIDelegate, WKNavigationDelegate {
    
    var webView: WKWebView?
    var indicator = UIActivityIndicatorView(style: .large)
    
    @IBAction func loginButton(_ sender: Any) {
        let webConfiguration = WKWebViewConfiguration()
        webView = WKWebView(frame: .zero, configuration: webConfiguration)
        view = webView
        
        webView?.uiDelegate = self
        webView?.navigationDelegate = self
        
        let myURL = URL(string:"https://github.com/login/oauth/authorize?client_id=bc4a9e51a6494c1d0626&redirect_uri=http://15.164.33.98/api/sidedish2/github/callback&scope=user")
        
        let myRequest = URLRequest(url: myURL!)
        webView?.load(myRequest)
        webView?.addSubview(indicator)
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        setIndicator()
    }
    
    public func webView(_ webView: WKWebView, decidePolicyFor navigationResponse: WKNavigationResponse, decisionHandler: @escaping (WKNavigationResponsePolicy) -> Void) {
        
        guard let response = navigationResponse.response as? HTTPURLResponse else { return }
        if (response.statusCode == 202) {
            Toast(text: "로그인 성공").show()
            self.presentingViewController?.dismiss(animated: true, completion: nil)
            cleanAllCookies()
        }
        decisionHandler(.allow)
    }
    
    public func webView(_ webView: WKWebView, didCommit navigation: WKNavigation!) {
        indicator.isHidden = false
        indicator.startAnimating()
    }
    
    public func webView(_ webView: WKWebView, didFinish navigation: WKNavigation!) {
        indicator.isHidden = true
        indicator.stopAnimating()
    }
    
    private func setIndicator() {
        indicator.style = .medium
        indicator.color = .gray
        indicator.center = view.center
        indicator.hidesWhenStopped = false
    }
    
    func cleanAllCookies() {
        WKWebsiteDataStore.default().fetchDataRecords(ofTypes: WKWebsiteDataStore.allWebsiteDataTypes()) { records in
            records.forEach { record in
                WKWebsiteDataStore.default().removeData(ofTypes: record.dataTypes, for: [record], completionHandler: {})
                print("Cookie ::: \(record) deleted")
            }
        }
    }
}

