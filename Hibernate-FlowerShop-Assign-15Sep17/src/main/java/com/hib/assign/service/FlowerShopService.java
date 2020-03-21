package com.hib.assign.service;

import java.util.List;

import com.hib.assign.model.FlowerShop;

public interface FlowerShopService {

	public List<FlowerShop> getAllData();

	public void saveFlowerShop(FlowerShop flowerShop);

	public FlowerShop getFlowerShop(int id);

	public void deleteFlowerShop(int id);

	public FlowerShop updateFlowerShop(FlowerShop flowerShop);

}
