package com.chaokongtech.protocol808;

import java.lang.reflect.Field;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.chaokongtech.protocol808.bodies.Body0x0001;
import com.chaokongtech.protocol808.bodies.Body0x0002;
import com.chaokongtech.protocol808.bodies.Body0x0102;
import com.chaokongtech.protocol808.fields.BCDn;
import com.chaokongtech.protocol808.fields.BYTEn;
import com.chaokongtech.protocol808.fields.ComplexFIELD;
import com.chaokongtech.protocol808.fields.FIELD;
import com.chaokongtech.protocol808.fields.WORD;
import com.chaokongtech.protocol808.utils.ProtocolUtils;
import com.chaokongtech.protocol808.utils.Utils;

public class Msg extends ComplexFIELD{
	private static Logger logger = LogManager.getLogger(Msg.class);
	private static int msgStaticSeq;
	
	private WORD msgId = new WORD(0);
	private WORD msgProperty = new WORD(2);
	private BCDn deviceId = new BCDn(4, 6);
	private WORD msgSeq = new WORD(10);
	
	public WORD getMsgId() {
		return msgId;
	}
	public void setMsgId(WORD msgId) {
		this.msgId = msgId;
	}
	public WORD getMsgProperty() {
		return msgProperty;
	}
	public void setMsgProperty(WORD msgProperty) {
		this.msgProperty = msgProperty;
	}
	public BCDn getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(BCDn deviceId) {
		this.deviceId = deviceId;
	}
	public WORD getMsgSeq() {
		return msgSeq;
	}
	public void setMsgSeq(WORD msgSeq) {
		this.msgSeq = msgSeq;
	}
	public WORD getSumPackege() {
		return sumPackege;
	}
	public void setSumPackege(WORD sumPackege) {
		this.sumPackege = sumPackege;
	}
	public WORD getSubPackege() {
		return subPackege;
	}
	public void setSubPackege(WORD subPackege) {
		this.subPackege = subPackege;
	}
	public Body getBody() {
		
		return body;
	}
	public void setBody(Body body) {
		this.body = body;
	}

	private WORD sumPackege = new WORD(12);
	private WORD subPackege = new WORD(14);
	
	private Body body;
	
	public Msg() {
	}
	public Msg(String strDeviceId,Body body) {
		deviceId.setValue(strDeviceId);
		this.body = body;
		msgId.setValue(body.getMsgId());
		int tmp = body.getSize();
		logger.debug("body size:" + tmp);
		msgProperty.setValue(tmp);
		
		msgSeq.setValue(msgStaticSeq);
		msgStaticSeq++;
		sumPackege = null;
		subPackege = null;
	}		
		
	public byte[] toBytes(){
		encode();
		byte[] frame = new byte[bs.length + 1];
		for(int i=0;i<bs.length;i++){
			frame[i] = bs[i];
		}
		frame[frame.length - 1] = Utils.Xor(frame, 0, frame.length-1);	//校验计算	
		byte[] convert = ProtocolUtils.dataOutConvert(frame);		//转义处理
		return convert;
	}
	@Override
	public void decode(byte[] bytes) {
		body = new Body();
		msgProperty.decode(new byte[]{bytes[2],bytes[3]});
		body.setSize(msgProperty.getValue());
		body.setOffset(12);
		super.decode(bytes);
	}
	
	public static void main(String[] args){
//		Body0x0002 body0x0002 = new Body0x0002();
		Body0x0102 body0x0102 = new Body0x0102("Autnrntication");
		Msg msg = new Msg("123456789012", body0x0102);
//		System.out.println(Utils.bytesToString(msg.encode()));
		System.out.println(Utils.bytesToString(msg.toBytes()));
		
	}
	
}
