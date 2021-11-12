package com.test.springmvcex;



import java.util.List;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class Fruitservice implements FruitInterfaceService {
	
	@Autowired
	private FruitRepository repo;

	@Override
	public List<Fruit> getAllFruit() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public void deleteFruit(int id) {
		// TODO Auto-generated method stub
        repo.deleteById(id);
	}

	@Override
	public void saveOrUpdate(Fruit fruit) {
		
		Fruit f = new Fruit();
		f.setId(fruit.getId());
		f.setFruitname(fruit.getFruitname());
		f.setFruitprice(fruit.getFruitprice());
		f.setQuantity(fruit.getQuantity());
		repo.save(f);
		
	}

	@Override
	public Fruit getFruitById(int id) {
		Optional<Fruit> list = repo.findById(id);
		Fruit f = null;
		if(list.isPresent()) {
			f = list.get();
			
		}
		
		return f;
	}

}
