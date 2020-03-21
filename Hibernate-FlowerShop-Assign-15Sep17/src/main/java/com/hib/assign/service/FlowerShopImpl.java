package com.hib.assign.service;

import java.util.List;

import com.hib.assign.model.FlowerShop;
import com.hib.assign.repository.FlowerShopRepository;
import com.hib.assign.repository.FlowerShopRepositoryImpl;

public class FlowerShopImpl implements FlowerShopService {
	
	private static FlowerShopRepository flowerShopRepository;
	
	static {
		flowerShopRepository = new FlowerShopRepositoryImpl();
	}

	public List<FlowerShop> getAllData() {
		// TODO Auto-generated method stub
		return flowerShopRepository.getAllData();
	}

	public void saveFlowerShop(FlowerShop flowerShop) {
		// TODO Auto-generated method stub
		flowerShopRepository.saveFlowerShop(flowerShop);
	}

	public FlowerShop getFlowerShop(int id) {
		// TODO Auto-generated method stub
		return flowerShopRepository.getFlowerShop(id);
	}

	public void deleteFlowerShop(int id) {
		// TODO Auto-generated method stub
		flowerShopRepository.deleteFlowerShop(id);
	}

	public FlowerShop updateFlowerShop(FlowerShop flowerShop) {
		// TODO Auto-generated method stub
		return flowerShopRepository.updateFlowerShop(flowerShop);
	}

}
