package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.document.Player;
import com.nt.repository.IPlayerRepo;

@Service
public class PlayerMgmtServiceImpl implements IPlayerMgmtService {

	@Autowired
	private IPlayerRepo playerRepo;

	@Override
	public String registerPlayer(Player player) {
		return "Player and his sports and Medals info got save with id::" + playerRepo.save(player).getPid();
	}

	@Override
	public List<Player> showPlayersInfo() {
		return playerRepo.findAll();
	}

}
