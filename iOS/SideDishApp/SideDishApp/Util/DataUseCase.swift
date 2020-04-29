//
//  DataUseCase.swift
//  SideDishApp
//
//  Created by 임승혁 on 2020/04/24.
//  Copyright © 2020 임승혁. All rights reserved.
//

import Foundation
import UIKit

final class DataUseCase {
    static let endpoint = "http://15.164.33.98/api/sidedish/"
    static let detailRequest = ["main", "soup", "side"]
    
    public static func loadAllDishes(manager: NetworkManager, completion: @escaping ([DetailSideDishInfo]?, Int?, Error?) -> ()) {
        manager.requestData(url: endpoint+detailRequest[0]) { (data, error) in
            guard let data = data else { return }
            do {
                let json = try JSONDecoder().decode(SideDishResponse.self, from: data)
                completion(json.body, 0, nil)
            } catch {
                completion(nil, nil, error)
            }
        }
        
        manager.requestData(url: endpoint+detailRequest[1]) { (data, error) in
            guard let data = data else { return }
            do {
                let json = try JSONDecoder().decode(SideDishResponse.self, from: data)
                completion(json.body, 1, nil)
            } catch {
                completion(nil, nil, error)
            }
        }
        
        manager.requestData(url: endpoint+detailRequest[2]) { (data, error) in
            guard let data = data else { return }
            do {
                let json = try JSONDecoder().decode(SideDishResponse.self, from: data)
                completion(json.body, 2, nil)
            } catch {
                completion(nil, nil, error)
            }
        }
    }
    
    public static func loadImage(url: URL, manager: NetworkManager, completion: @escaping (URL?) -> ()) {
        manager.requestImageData(url: url) { (url, error) in
            guard let localURL = url else { return }
            completion(localURL)
        }
    }
}
