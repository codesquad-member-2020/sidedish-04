//
//  DataManager.swift
//  SideDishApp
//
//  Created by 임승혁 on 2020/04/26.
//  Copyright © 2020 임승혁. All rights reserved.
//

import Foundation
import UIKit

class DataManger {
    let fileManager = FileManager.default
    let dataUseCase = DataUseCase()
    var allDishes = [Int:[DetailSideDishInfo]]()
    
    public func insertDish(dish: [DetailSideDishInfo], index: Int) {
        allDishes[index] = dish
        NotificationCenter.default.post(name: .changeDataSourceValue, object: nil, userInfo: ["reloadSection" : index])
    }
    
    public func fetchImage(url: URL, completion: @escaping (UIImage?, Error?) -> ()) {
        guard let saveDataDirectory = createDirectory() else { return }
        
        let saveDataPath = saveDataDirectory.appendingPathComponent(url.lastPathComponent)
        
        if fileManager.fileExists(atPath: saveDataPath.path) {
            let image = UIImage(contentsOfFile: saveDataPath.path)
            DispatchQueue.main.async {
                completion(image, nil)
            }
        } else {
            DataUseCase.loadImage(url: url, manager: NetworkManager()) { (local) in
                guard let localURL = local else { return }
                do {
                    try self.fileManager.moveItem(atPath: localURL.path, toPath: saveDataPath.path)
                    let image = UIImage(contentsOfFile: saveDataPath.path)
                    DispatchQueue.main.async {
                        completion(image, nil)
                    }
                } catch {
                    completion(nil, error)
                }
            }
        }
    }
    
    private func createDirectory() -> URL? {
        do {
            let cacheDirectory = try fileManager.url(for: .cachesDirectory, in: .userDomainMask, appropriateFor: nil, create: true)
            let sideDishImageDataPath = cacheDirectory.appendingPathComponent("SideDishImage")
            
            try fileManager.createDirectory(at: sideDishImageDataPath, withIntermediateDirectories: true, attributes: nil)
            return sideDishImageDataPath
        } catch {
            print(error.localizedDescription)
            return nil
        }
    }
}
