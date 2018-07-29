package com.chaokongtech.protocol808.bodies;

import com.chaokongtech.protocol808.Body;
import com.chaokongtech.protocol808.fields.Arg;
import com.chaokongtech.protocol808.fields.ArgList;
import com.chaokongtech.protocol808.fields.BYTE;
import com.chaokongtech.protocol808.fields.WORD;

public class Body0x0104 extends Body{
	private int num;
	public WORD responseSeq = new WORD(0);
	public BYTE argsNum = new BYTE(2);
	public ArgList argList = new ArgList(3);
	public Body0x0104(int vResponseSeq) {
		super(0x0104);
		responseSeq.setValue(vResponseSeq);
	}
	public Body0x0104 addArgument(Arg argument){
		num++;
		argsNum.setByte((byte) num);
		argList.addArg(argument);
		return this;
	}

}
