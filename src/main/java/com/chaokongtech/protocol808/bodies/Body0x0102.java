package com.chaokongtech.protocol808.bodies;

import com.chaokongtech.protocol808.Body;
import com.chaokongtech.protocol808.fields.STRING;

public class Body0x0102 extends Body {
	private STRING authenticationCode = new STRING(0);
	public Body0x0102(String vAuthenticationCode) {
		super(0x0102);
		authenticationCode.setValue(vAuthenticationCode);
	}

}
