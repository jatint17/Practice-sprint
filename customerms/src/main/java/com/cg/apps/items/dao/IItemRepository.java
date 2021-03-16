package com.cg.apps.items.dao;

import com.cg.apps.items.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IItemRepository extends JpaRepository<Item,String> {

}
