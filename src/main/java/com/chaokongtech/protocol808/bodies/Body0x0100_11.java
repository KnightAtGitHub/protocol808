package com.chaokongtech.protocol808.bodies;

import com.chaokongtech.protocol808.Body;
import com.chaokongtech.protocol808.fields.BYTEn;
import com.chaokongtech.protocol808.fields.STRING;
import com.chaokongtech.protocol808.fields.WORD;
import com.chaokongtech.protocol808.utils.Utils;

public class Body0x0100_11 extends Body {
	public WORD provinceId = new WORD(0);
	public WORD cityId = new WORD(2);
	public BYTEn produceId = new BYTEn(4, 5);
	public BYTEn terminalType = new BYTEn(9, 8);
	public BYTEn terminalId = new BYTEn(17, 7);
	public BYTEn carColor = new BYTEn(24, 1);
	public STRING carFlag = new STRING(25);
	
	public Body0x0100_11(int vProvinceId,int vCityId,byte[] vProduceId,byte[] vTerminalType,
			byte[] vTerminalId,byte vCarColor, String vCarFlag) {
		super(0x0100);
		provinceId.setValue(vProvinceId);
		cityId.setValue(vCityId);
		produceId.setBytes(vProduceId);
		terminalType.setBytes(Utils.bytesAdd0x00(vTerminalType, terminalType.getSize()));
		terminalId.setBytes(Utils.bytesAdd0x00(vTerminalId, terminalId.getSize()));
		carColor.setBytes(new byte[]{vCarColor});
		carFlag.setValue(vCarFlag);
	}

}
