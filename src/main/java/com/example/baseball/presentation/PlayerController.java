package com.example.baseball.presentation;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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

}