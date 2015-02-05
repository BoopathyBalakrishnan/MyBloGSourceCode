package com.infy.Service;

import java.util.List;

import com.infy.dto.Item;

public interface ProductResponseService {

	public List<Item> filterAsPerUserRelevance(List<Item> productListFilteredAsperUserTaste, int id) ;
}
