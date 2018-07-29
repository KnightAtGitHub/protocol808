package com.chaokongtech.protocol808.bodies;

import com.chaokongtech.protocol808.Body;
import com.chaokongtech.protocol808.fields.BYTE;

public class Body0x0108 extends Body{
	public BYTE updateType = new BYTE(0);
	public BYTE updateResult = new BYTE(1);
	public Body0x0108(byte type,byte result) {
		super(0x0108);
		updateType.setByte(type);
		updateResult.setByte(result);
	}

}
