package com.example.baseball.repository.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.baseball.entity.Player;

@Mapper
public interface PlayerMapper {
	List<Player> findAll();

	void insert(Player player);

}
