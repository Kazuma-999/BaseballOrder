package com.example.baseball.repository.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.baseball.entity.Player;

@Mapper
public interface PlayerMapper {

	/**
	 * 登録されているすべての選手データを取得する（一覧表示用）
	 * * @return 選手データのリスト
	 */
	List<Player> findAll();

	/**
	 * 新しい選手データをデータベースに登録する（新規追加用）
	 * * @param player 登録する選手データ
	 */
	void insert(Player player);

	/**
	 * IDを指定して選手を1人だけ取得する（編集画面用）
	 * * @param id 取得したい選手のID
	 * @return 見つかった選手データ（存在しない場合はnull）
	 */
	Player findById(Long id);

	/**
	 * 選手データを更新する（編集の保存用）
	 * * @param player 更新する情報を持った選手データ
	 */
	void update(Player player);

	/**
	 * IDを指定して選手を1人削除する（削除用）
	 * * @param id 削除したい選手のID
	 */
	void deleteById(Long id);
	
}
