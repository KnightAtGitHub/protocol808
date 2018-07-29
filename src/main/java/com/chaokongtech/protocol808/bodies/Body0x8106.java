package com.chaokongtech.protocol808.bodies;

import com.chaokongtech.protocol808.Body;
import com.chaokongtech.protocol808.fields.ArgIds;
import com.chaokongtech.protocol808.fields.BYTE;
import com.chaokongtech.protocol808.fields.BYTEn;

public class Body0x8106 extends Body{
	private int num = 0;
	public BYTE argsNum = new BYTE(0);
	public ArgIds argIds = new ArgIds(1);
	public Body0x8106() {
		super(0x8106);
	}
	public Body0x8106 addArgId(int argId){
		num++;
		argsNum.setByte((byte) num);
		argIds.addArgId(argId);
		return this;
	}

}
