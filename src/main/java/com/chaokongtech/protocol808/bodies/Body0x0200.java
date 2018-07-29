package com.chaokongtech.protocol808.bodies;

import com.chaokongtech.protocol808.Body;
import com.chaokongtech.protocol808.fields.BCDn;
import com.chaokongtech.protocol808.fields.DWORD;
import com.chaokongtech.protocol808.fields.FIELD;
import com.chaokongtech.protocol808.fields.LocationAdditionalInfoList;
import com.chaokongtech.protocol808.fields.WORD;

public class Body0x0200 extends Body {
	private DWORD alarmFlag = new DWORD(0);
	private DWORD status = new DWORD(4);
	private DWORD latitude = new DWORD(8);
	private DWORD longtitude = new DWORD(12);
	private WORD altitude = new WORD(16);
	private WORD speed = new WORD(18);
	private WORD direction = new WORD(20);
	private BCDn time = new BCDn(22, 6);
	private LocationAdditionalInfoList locationAdditionalInfo;

	public void setBasicLocationInfo(int vAlarmFlag,int vStatus,int vLatitued,int vLongtitude,int vAltitude,int vSpeed,
		int vDirection,String vTime){
		this.alarmFlag.setValue(vAlarmFlag);
		this.status.setValue(vStatus);
		this.latitude.setValue(vLatitued);
		this.longtitude.setValue(vLongtitude);
		this.altitude.setValue(vAltitude);
		this.speed.setValue(vSpeed);
		this.direction.setValue(vDirection);
		this.time.setValue(vTime);

	}

	
	public DWORD getAlarmFlag() {
		return alarmFlag;
	}
	public void setAlarmFlag(DWORD alarmFlag) {
		this.alarmFlag = alarmFlag;
	}
	public DWORD getStatus() {
		return status;
	}
	public void setStatus(DWORD status) {
		this.status = status;
	}
	public DWORD getLatitude() {
		return latitude;
	}
	public void setLatitude(DWORD latitude) {
		this.latitude = latitude;
	}
	public DWORD getLongtitude() {
		return longtitude;
	}
	public void setLongtitude(DWORD longtitude) {
		this.longtitude = longtitude;
	}
	public WORD getAltitude() {
		return altitude;
	}
	public void setAltitude(WORD altitude) {
		this.altitude = altitude;
	}
	public WORD getSpeed() {
		return speed;
	}
	public void setSpeed(WORD speed) {
		this.speed = speed;
	}
	public WORD getDirection() {
		return direction;
	}
	public void setDirection(WORD direction) {
		this.direction = direction;
	}
	public BCDn getTime() {
		return time;
	}
	public void setTime(BCDn time) {
		this.time = time;
	}
	public LocationAdditionalInfoList getLocationAdditionalInfo() {
		return locationAdditionalInfo;
	}
	@Override
	public void decode(byte[] bytes) {
		locationAdditionalInfo = new LocationAdditionalInfoList();
		int lsize = bytes.length - 28;
		locationAdditionalInfo.setSize(lsize);
		super.decode(bytes);
	}









	public Body0x0200() {
		super(0x0200);
	}
	public Body0x0200 setLocationAdditionalInfo(LocationAdditionalInfoList locationAdditionalInfo){
		this.locationAdditionalInfo = locationAdditionalInfo;
		return this;
	}
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args){
		Body0x0200 body0x0200 = new Body0x0200();
		body0x0200.encode();
	}
	
}
