package com.psm.daoapi;

import java.util.List;

import com.psm.entities.UserBean;

public interface DaoApi {

	public UserBean getUserByUsername(String username);
}
