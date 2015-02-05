package com.infy.serviceImpl;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.orm.ibatis.SqlMapClientTemplate;

import com.infy.Service.ProductResponseService;
import com.infy.dto.Item;
import com.infy.dto.UserItemPurchaseHistory;

public class ProductResponseServiceImpl implements ProductResponseService {

	SqlMapClientTemplate ibatisTemplate;

	public List<Item> filterAsPerUserRelevance(
			List<Item> productListFilteredAsperUserTaste,
			int id) {

		List<Item> recommendedProducts = getListFromRecommendationEngine(id);

		ArrayList<Item> list3 = new ArrayList<Item>();

		for (Item productFromApi : productListFilteredAsperUserTaste) {
			for (Item item : recommendedProducts) {
				if (productFromApi.getBrand().toLowerCase()
						.equals(item.getBrand().toLowerCase())) {
					list3.add(productFromApi);
				}
			}
		}
		return list3;
	}

	private List<Item> getListFromRecommendationEngine(int id) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("userId", id);

		List<UserItemPurchaseHistory> list2 = ibatisTemplate.queryForList(
				"GoSmarter.userItemList", map);

		assertEquals(1, list2.size());
		assertEquals(list2.get(0).getItemId(), 1);

		map = new HashMap<String, Object>();
		map.put("itemId", list2.get(0).getItemId());
		Item item = (Item) ibatisTemplate.queryForObject(
				"GoSmarter.itemDetails", map);
		assertEquals(item.getName(), "FERRARI ENZO");

		List<Item> list3 = new ArrayList<Item>();
		list3.add(item);
		return list3;
	}
}
