//
//  NetworkManager.swift
//  SideDishApp
//
//  Created by 임승혁 on 2020/04/24.
//  Copyright © 2020 임승혁. All rights reserved.
//

import Foundation
import Alamofire

class NetworkManager {
    public func requestData(url: String, completion: @escaping (_ data: Data?, _ error: Error?) -> ()) {
        
        Alamofire.request(url, method: .get, parameters: nil, encoding: JSONEncoding.default, headers: nil).responseJSON { (response) in
            
            switch response.result {
            case .success:
                guard let result = response.data else { return }
                completion(result, nil)
                
            case let .failure(error):
                print(error)
                completion(nil, error)
            }
        }
    }
}
