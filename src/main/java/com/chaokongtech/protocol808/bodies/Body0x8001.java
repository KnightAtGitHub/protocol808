package com.chaokongtech.protocol808.bodies;


import com.chaokongtech.protocol808.Body;
import com.chaokongtech.protocol808.fields.BYTE;
import com.chaokongtech.protocol808.fields.WORD;

public class Body0x8001 extends Body{
	public WORD responseNumber = new WORD(0);
	public WORD responseId = new WORD(2);
	public BYTE result = new BYTE(4);
	public Body0x8001(int responseNumV,int responseIdV,byte resultV) {
		super(0x8001);
		responseNumber.setValue(responseNumV);
		responseId.setValue(responseIdV);
		result.setByte(resultV);
	}
	public Body0x8001(byte[] responseBs,byte[] responseIdBs,byte resultB) {
		super(0x8001);
		responseNumber.decode(responseBs);
		responseId.decode(responseIdBs);
		result.setByte(resultB);
	}
	
}
