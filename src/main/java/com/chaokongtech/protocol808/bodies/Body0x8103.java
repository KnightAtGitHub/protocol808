package com.chaokongtech.protocol808.bodies;

import com.chaokongtech.protocol808.Body;
import com.chaokongtech.protocol808.fields.Arg;
import com.chaokongtech.protocol808.fields.ArgList;
import com.chaokongtech.protocol808.fields.BYTE;
import com.chaokongtech.protocol808.fields.BYTEn;

public class Body0x8103 extends Body{
	private int num=0;
	public BYTE argsNum = new BYTE(0);
	public ArgList args = new ArgList(1);
	public Body0x8103() {
		super(0x8103);
	}
	public Body0x8103 addArgument(Arg argument){
		num++;
		argsNum.setByte((byte) num);
		args.addArg(argument);
		return this;
	}

}
