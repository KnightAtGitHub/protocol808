package com.chaokongtech.protocol808.bodies;

import com.chaokongtech.protocol808.Body;
import com.chaokongtech.protocol808.fields.BYTEn;
import com.chaokongtech.protocol808.fields.WORD;

public class Body0x0001 extends Body{
	public Body0x0001(int responseNumV,int responseIdV,byte resultV) {
		super(0x0001);
		responseNumber.setValue(responseNumV);
		responseId.setValue(responseIdV);
		result.setBytes(new byte[]{resultV});
	}
	public WORD responseNumber = new WORD(0);
	public WORD responseId = new WORD(2);
	public BYTEn result = new BYTEn(4,1);
	
}
