package com.chaokongtech.protocol808.trash;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.chaokongtech.protocol808.utils.ProtocolUtils;
import com.chaokongtech.protocol808.utils.Utils;

public class Message {
	private static Logger logger = LogManager.getLogger(Message.class);
	private int msgId;
	private int msgProperty;
	private String deviceId;
	private int msgSeq;
	private static int msgStaticSeq;
	private OldBody body;
	
	private byte[] msg;
	public Message(String deviceId,OldBody body) {
		this.deviceId = deviceId;
		this.body = body;
	}
	public byte[] toBytes(){
		msgId = body.msgId;
		if (body.toBytes() == null) {
			msgProperty = 0;
			int length = msgProperty + 13;
			msg = new byte[length];
		}else {
			byte[] bodyBytes = body.toBytes();
			msgProperty = bodyBytes.length;
			int length = msgProperty + 13;
			msg = new byte[length];
			addData(bodyBytes, 12);
			
		}
		msgSeq = msgStaticSeq;
		addData(msgId, 0, 2);
		addData(msgProperty, 2, 2);
		addData(Utils.stringTime2BCD(deviceId), 4);
		addData(msgSeq, 10, 2);
		msg[msg.length-1] = Utils.Xor(msg, 0, msg.length-1);
		byte[] convert = ProtocolUtils.dataOutConvert(msg);
		
		msgStaticSeq++;
		
		return convert;
	}
	private void addData(long num,int offset,int length){
		byte[] tmp = Utils.integer2bytes(num, length);
		for(int i=0;i<length;i++){
			msg[offset+i] = tmp[i];
		}
	}
	private void addData(byte[] source,int offset) {
		for(int i=0;i<source.length;i++){
			msg[offset + i] = source[i];
		}
	}
	public static void main(String[] args){
		for(int i=0;i<100;i++){
			OldBody body = new BodyLocation(10000000, 2, 3, 4, 5, 6, 7, System.currentTimeMillis());
			Message message = new Message("123456789012",body);
			byte[] heartbeat1 = message.toBytes();
			logger.debug("to send:" + Utils.bytesToString(heartbeat1));
		}
	}
}
