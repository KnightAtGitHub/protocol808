package com.chaokongtech.protocol808.bodies;

import com.chaokongtech.protocol808.Body;
import com.chaokongtech.protocol808.fields.BYTE;
import com.chaokongtech.protocol808.fields.BYTEn;
import com.chaokongtech.protocol808.fields.ComplexFIELD;
import com.chaokongtech.protocol808.fields.STRING;
import com.chaokongtech.protocol808.fields.WORD;

@Deprecated
public class Body0x8105 extends Body {
	public BYTE cmdCode = new BYTE(0);
	public STRING args;
	public Body0x8105(byte vCmdCode) {
		super(0x8105);
		cmdCode.setByte(vCmdCode);
	}
	@Deprecated
	public void setArgs(String string){
		args = new STRING(1);
		args.setValue(string);
	}
	@Deprecated
	public void setWirelessUpdateArgs(){
		WirelessUpdateArgs wirelessUpdateArgs = new WirelessUpdateArgs();
	}
	class WirelessUpdateArgs extends ComplexFIELD{
		STRING url;
		STRING dialingPointName;
		STRING dialUserName;
		STRING dialPasswd;
		STRING addr;
		WORD tcpPort;
		WORD udpPort;
		BYTEn producerId;
		STRING hwVersion;
		STRING fwVersion;
		WORD timeout;
		
		public void setProperties() {
			producerId.setSize(5);
		}
		@Override
		public byte[] encode() {
			StringBuilder sBuilder = new StringBuilder();
			sBuilder.append(url)
					.append(tcpPort.getValue());
			return null;
		}
		
	}
	class SwitchServer{
		BYTE connectCtl;
		STRING authrentication;
		STRING dialingPointName;
		STRING dialUserName;
		STRING dialPasswd;
		STRING addr;
		WORD tcpPort;
		WORD udpPort;
		WORD timeout;
		
	}
	

}
