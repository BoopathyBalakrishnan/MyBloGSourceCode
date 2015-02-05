package com.infy.serviceImpl;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.infy.dto.Item;
import com.infy.dto.User;
import com.infy.serviceImpl.ProductResponseServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml",
		"classpath:test-datasource-config.xml" })
public class FilterAsPerUserFriendsRelevanceTest {

	static {
		System.setProperty("spring.profiles.active", "dev");
	}

	ProductResponseServiceImpl productResponseServiceImpl = new ProductResponseServiceImpl();

	@Autowired
	SqlMapClientTemplate ibatisTemplate;

	@Before
	public void setUp() throws Exception {
		productResponseServiceImpl.ibatisTemplate = ibatisTemplate;
		populateSampleData();
	}

	private void populateSampleData() {
		// TODO Auto-generated method stub
	}

	@Test
	public void testInMemoryDatabase() {
		Integer value = (Integer) ibatisTemplate
				.queryForObject("GoSmarter.userCount");

		assertEquals(4, value.intValue());

		List<User> list = ibatisTemplate.queryForList("GoSmarter.userList");

		assertEquals(4, list.size());
		assertEquals(list.get(0).getFacebookid(), "bba@gmail.com");

		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("userId", 2);
	}

	@Test
	public void testUserRelevance() {

		ArrayList<Item> productFromApiList = new ArrayList<Item>();

		Item Item = new Item();
		Item.setName("Ferrari 750 Monza");
		Item.setBrand("Ferrari");
		productFromApiList.add(Item);

		Item = new Item();
		Item.setName("Porsche 911 GT3");
		Item.setBrand("Porsche");
		productFromApiList.add(Item);

		Item = new Item();
		Item.setName("Cheverlet Corvette");
		Item.setBrand("Cheverlet");
		productFromApiList.add(Item);

		Item = new Item();
		Item.setName("Honda City");
		Item.setBrand("Honda");
		productFromApiList.add(Item);

		Item = new Item();
		Item.setName("Hynduai Verna");
		Item.setBrand("Hynduai");
		productFromApiList.add(Item);

		HashMap<String, Object> map = new HashMap<String, Object>();

		List<Item> productFromApiListOut = productResponseServiceImpl
				.filterAsPerUserRelevance(productFromApiList, 2);

		assertEquals(productFromApiListOut.size(), 1);
		assertEquals(productFromApiListOut.get(0).getName(),
				"Ferrari 750 Monza");
	}
}
