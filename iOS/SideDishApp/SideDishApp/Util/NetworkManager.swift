//
//  NetworkManager.swift
//  SideDishApp
//
//  Created by 임승혁 on 2020/04/24.
//  Copyright © 2020 임승혁. All rights reserved.
//

import Foundation

class NetworkManager {
    public func requestData(url: String, completion: @escaping (_ data: Data?, _ error: Error?) -> ()) {
        guard let requestURL = URL(string: url) else { return }
        let request = URLRequest(url: requestURL)
        
        URLSession.shared.dataTask(with: request) { (data, res, error) in
            if let error = error { print(error); completion(nil, error) }
            
            DispatchQueue.main.async {
                completion(data, nil)
            }
        }.resume()
    }
    
    public func requestImageData(url: URL, completion: @escaping (_ url: URL?, _ error: Error?) -> ()) {
        let request = URLRequest(url: url)
        
        URLSession.shared.downloadTask(with: request) { (url, res, error) in
            if let error = error { print(error); completion(nil, error) }
            
            guard let localURL = url else { return }
            completion(localURL, nil)
        }.resume()
    }
}
