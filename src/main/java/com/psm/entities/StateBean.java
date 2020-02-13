package com.psm.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "stateinfo")
public class StateBean {

	@Id
	@GeneratedValue
	private int state_id;

	@Column(name = "state_name")
	private String stateName;

	public int getState_id() {
		return state_id;
	}

	public void setState_id(int state_id) {
		this.state_id = state_id;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	@Override
	public String toString() {
		return "StateBean [state_id=" + state_id + ", stateName=" + stateName + "]";
	}

	

}
