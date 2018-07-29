package com.chaokongtech.protocol808.trash;

import com.chaokongtech.protocol808.utils.Utils;

public class BodyLocation extends OldBody{
	public BodyLocation(int alarmFlag,int status,int latitude,int longitude
			,int elevation,int speed,int direction,long time) {
		super(0x0200);
		this.alarmFlag = alarmFlag;
		this.status = status;
		this.latitude = latitude;
		this.longitude = longitude;
		this.elevation = elevation;
		this.speed = speed;
		this.direction = direction;
		this.time = time;
		newBytes();
	}

	private int alarmFlag;
	private int status;
	private int latitude;
	private int longitude;
	private int elevation;
	private int speed;
	private int direction;
	private long time;

	public byte[] toBytes() {
//		System.out.println("toBytes");
		addData(alarmFlag, 0, 4);
		addData(status, 4, 4);
		addData(latitude, 8, 4);
		addData(longitude, 12, 4);
		addData(elevation, 16, 2);
		addData(speed, 18, 2);
		addData(direction, 20, 2);
		addData(Utils.longTime2BCD(time), 22);
//		System.out.println("body:" + Converter.bytesToString(bytes));
		return bytes;
	}

	@Override
	public void newBytes() {
		int length = 28;
		bytes = new byte[length];
	}

}
