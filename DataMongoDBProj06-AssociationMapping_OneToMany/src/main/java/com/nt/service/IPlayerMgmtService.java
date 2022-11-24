package com.nt.service;

import java.util.List;

import com.nt.document.Player;

public interface IPlayerMgmtService {

	public String registerPlayer(Player person);

	public List<Player> showPlayersInfo();

}
