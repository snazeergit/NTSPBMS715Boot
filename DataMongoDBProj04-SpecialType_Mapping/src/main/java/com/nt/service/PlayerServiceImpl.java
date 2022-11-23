package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.document.PlayerInfo;
import com.nt.repository.IPlayerRepo;

@Service
public class PlayerServiceImpl implements IPlayerService {

	@Autowired
	private IPlayerRepo playerRepo;

	@Override
	public String registerPlayer(PlayerInfo pInfo) {
		return "Player is registerd with ID ::" + playerRepo.insert(pInfo).getPid();
	}

}
