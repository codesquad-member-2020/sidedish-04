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
    
    public func fetchImage(urlString: String, completion: @escaping (UIImage?, Error?) -> ()) {
        let cacheDirectory = fileManager.urls(for: .cachesDirectory, in: .userDomainMask).first!
        let dataPath = cacheDirectory.appendingPathComponent("SideDishImage")
        
        // 디렉토리 경로 생성 -> 없으면
        if !fileManager.fileExists(atPath: dataPath.path) {
            do {
                try fileManager.createDirectory(atPath: dataPath.path, withIntermediateDirectories: false, attributes: nil)
            } catch let error {
                completion(nil, error)
            }
        }
        
        guard let lastPathComponent = URL(string: urlString)?.lastPathComponent else { return }
        let urlPath = dataPath.appendingPathComponent(lastPathComponent)
        
        if fileManager.fileExists(atPath: urlPath.path) {
            do {
                let data = try Data(contentsOf: urlPath)
                let image = UIImage(data: data)
                DispatchQueue.main.async {
                    completion(image, nil)
                }
            } catch let error {
                 completion(nil, error)
            }
        } else {
            DataUseCase.loadImage(url: urlString, manager: NetworkManager()) { (image) in
                self.fileManager.createFile(atPath: urlPath.path, contents: image?.jpegData(compressionQuality: 1) ?? image?.pngData(), attributes: nil)
                completion(image, nil)
            }
        }
    }
}
