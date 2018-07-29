package com.chaokongtech.protocol808.bodies;

import com.chaokongtech.protocol808.Body;
import com.chaokongtech.protocol808.fields.BYTEn;
import com.chaokongtech.protocol808.fields.STRING;
import com.chaokongtech.protocol808.fields.WORD;

public class Body0x8100 extends Body{
	public WORD respondSeq = new WORD(0);
	public BYTEn result = new BYTEn(2, 1);
	public STRING authenticationCode = new STRING(3);
	public Body0x8100(int vResponseSeq,byte vResult,String vAuthenticationCode) {
		super(0x8100);
		respondSeq.setValue(vResponseSeq);
		result.setBytes(new byte[]{vResult});
		authenticationCode.setValue(vAuthenticationCode);
	}

}
