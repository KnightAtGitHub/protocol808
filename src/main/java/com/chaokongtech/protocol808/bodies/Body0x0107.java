package com.chaokongtech.protocol808.bodies;

import com.chaokongtech.protocol808.Body;
import com.chaokongtech.protocol808.fields.BCDn;
import com.chaokongtech.protocol808.fields.BYTE;
import com.chaokongtech.protocol808.fields.BYTEn;
import com.chaokongtech.protocol808.fields.STRING;
import com.chaokongtech.protocol808.fields.WORD;

public class Body0x0107 extends Body {
	public WORD terminalKind  = new WORD(0);
	public BYTEn producerId = new BYTEn(2, 5);
	public BYTEn terminalType = new BYTEn(7, 20);
	public BYTEn deviceId = new BYTEn(27, 7);
	public BYTEn blank = new BYTEn(34, 8);
	public BCDn simICCID = new BCDn(42, 10);
	public BYTE terminalHWVersionLength = new BYTE(52);
	public STRING terminalHWVersion = new STRING(53);
	public BYTE terminalFWVersionLength = new BYTE();
	public STRING terminalFWVersion = new STRING();
	public BYTE gnssProperty = new BYTE();
	public BYTE communicationProperty = new BYTE();
	
	public Body0x0107(int vTerminalKind,byte[] vProduceId,byte[] vTerminalType,
			byte[] vDeviceId,String vSimICCID,
			String vTerHWVersion,String vTerFWVersion,
			byte vGnssProperty,byte vCommunicationProperty) {
		super(0x0107);
		int m,n;
		terminalKind.setValue(vTerminalKind);
		producerId.setBytes(vProduceId);
		terminalType.setBytes(vTerminalType);
		deviceId.setBytes(vDeviceId);
		blank.setBytes(new byte[]{0x00});
		simICCID.setValue(vSimICCID);
		n = vTerHWVersion.length();
		terminalHWVersionLength.setByte((byte) n);
		terminalHWVersion.setValue(vTerHWVersion);
		m = vTerFWVersion.length();
		terminalFWVersionLength.setOffset(53+n);
		terminalFWVersionLength.setByte((byte) m);
		terminalFWVersion.setOffset(54+n);
		terminalFWVersion.setValue(vTerFWVersion);
		gnssProperty.setOffset(54+n+m);
		gnssProperty.setByte(vGnssProperty);
		communicationProperty.setOffset(55+n+m);
		communicationProperty.setByte(vCommunicationProperty);
	}
	
	
}
