package com.cg.repo;

import java.util.List;

import com.cg.bean.Player;

public interface PlayerRepo {
Player save(Player p);
Player findByName(String name);
Player findByGamesName(String name);
}
