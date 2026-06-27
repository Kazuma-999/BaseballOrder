package com.example.baseball.presentation;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.baseball.entity.Player;
import com.example.baseball.repository.mybatis.PlayerMapper;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/players")
@RequiredArgsConstructor
public class PlayerController {

	private final PlayerMapper playerMapper;

	@GetMapping
	public String showPlayerList(Model model) {
		List<Player> players = playerMapper.findAll();

		model.addAttribute("players", players);
		model.addAttribute("playerForm", new Player());// 登録フォーム用の空オブジェクト

		return "players";
	}

	@PostMapping("/register")
	public String registerPlater(@ModelAttribute Player player) {
		playerMapper.insert(player);
		return "redirect:/players"; // 登録完了後、一覧画面にリダイレクトして再表示

	}

	@GetMapping("/edit/{id}")
	public String showEditForm(@PathVariable("id") Long id, Model model) {
		Player player = playerMapper.findById(id);
		model.addAttribute("playerForm", player);
		return "edit";
	}

	@PostMapping("/delete/{id}")
	public String deletePlayrer(@PathVariable("id") Long id) {
		playerMapper.deleteById(id);
		return "redirect:/players"; // 削除したら、選手一覧画面に戻る
	}

	@PostMapping("/update")
	public String updatePlyer(@ModelAttribute Player player) {
		playerMapper.update(player);
		return "redirect:/players"; // 保存したら、選手一覧画面に戻る
	}

}
