package com.nt.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nt.document.PlayerInfo;

public interface IPlayerRepo extends MongoRepository<PlayerInfo, Integer> {

}
