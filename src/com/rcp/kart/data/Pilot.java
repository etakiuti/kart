package com.rcp.kart.data;

/**
 * 
 * Holds pilot data during race.
 *
 */
public class Pilot {

	private String mHour;
	private int mIDPilot;
	private String mNamePilot;
	private int mLap;
	private String mTimeLap;
	private String mSpeed;
	private String mTotalTime;

	public Pilot() {
	}

	public String getHour() {
		return mHour;
	}

	public void setHour(final String hour) {
		mHour = hour;
	}

	public int getIDPilot() {
		return mIDPilot;
	}

	public void setIDPilot(final int idPilot) {
		mIDPilot = idPilot;
	}

	public String getNamePilot() {
		return mNamePilot;
	}

	public void setNamePilot(final String namePilot) {
		mNamePilot = namePilot;
	}

	public int getLap() {
		return mLap;
	}

	public void setLap(final int lap) {
		mLap = lap;
	}

	public String getTimeLap() {
		return mTimeLap;
	}

	public void setTimeLap(final String timeLap) {
		mTimeLap = timeLap;
	}

	public String getSpeed() {
		return mSpeed;
	}

	public void setSpeed(final String speed) {
		mSpeed = speed;
	}

	public String getTotalTime() {
		return mTotalTime;
	}

	public void setTotalTime(final String totalTime) {
		mTotalTime = totalTime;
	}
}
