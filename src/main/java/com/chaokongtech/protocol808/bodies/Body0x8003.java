package com.chaokongtech.protocol808.bodies;

import com.chaokongtech.protocol808.Body;
import com.chaokongtech.protocol808.fields.WORD;

public class Body0x8003 extends Body {
	public WORD rawMsgSeq = new WORD(0);
	
	public Body0x8003() {
		super(0x8003);
	}

}
