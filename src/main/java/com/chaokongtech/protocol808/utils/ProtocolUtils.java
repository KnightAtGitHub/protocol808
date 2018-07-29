package com.chaokongtech.protocol808.utils;

import java.util.ArrayList;

import com.chaokongtech.protocol808.Msg;
import com.chaokongtech.protocol808.bodies.Body0x8001;

public class ProtocolUtils {
	
	public static byte[] dataInConvert(byte[] source){
		ArrayList<Byte> byteList = new ArrayList<Byte>();
		for(int i=0;i<source.length;i++){
			if (source[i] == 0x7d) {
				if (source[i+1] == 0x01) {
					byteList.add((byte) 0x7d);
					i++;
				}else if (source[i+1] == 0x02) {
					byteList.add((byte) 0x7e);
					i++;
				}else {
					System.out.println("Frame error.outofindex");
				}
			}else {
				byteList.add(source[i]);
			}
		}
		byte[] dst = new byte[byteList.size()];
		for(int i=0;i<byteList.size();i++){
			dst[i] = byteList.get(i);
		}
		return dst;
	}
	public static byte[] dataOutConvert(byte[] source){
		ArrayList<Byte> byteList = new ArrayList<Byte>();
		byteList.add((byte) 0x7e);
		for(int i=0;i<source.length;i++){
			if (source[i] == 0x7e) {
				byteList.add((byte) 0x7d);
				byteList.add((byte) 0x02);
			}else if (source[i] == 0x7d) {
				byteList.add((byte) 0x7d);
				byteList.add((byte) 0x01);
			}else {
				byteList.add(source[i]);
			}
		}
		byteList.add((byte) 0x7e);
		byte[] dst = new byte[byteList.size()];
		for(int i=0;i<byteList.size();i++){
			dst[i] = byteList.get(i);
		}
				
		return dst;
	}
	// 计算校验码
    public static byte Xor(byte[] data, int offset, int count) {
        byte val = data[offset];
        for (int i = offset + 1; i < count; i++) {
            val = (byte) (val ^ data[i]);
        }
        return val;
    }
    public static String getDeviceId(byte[] frameWithout7e){
    	byte[] tmp = new byte[6];
    	for(int i=0;i<6;i++){
    		tmp[i] = frameWithout7e[4+i];
    	}
    	return Utils.bcd2intStr(tmp);
    }
    public static String getDeviceId10(byte[] frameWithout7e){
    	byte[] tmp = new byte[5];
    	for(int i=0;i<5;i++){
    		tmp[i] = frameWithout7e[5+i];
    	}
    	return Utils.bcd2intStr(tmp);
    }
    public static int getMsgId(byte[] frameWithout7e){
    	return ((frameWithout7e[0]&0xff)<<8) + (frameWithout7e[1]&0xff);
    }
    public static byte[] getServerCommonResponseWith7e(byte[] clientMsg,byte result){
    	Body0x8001 body0x8001 = new Body0x8001(new byte[]{clientMsg[10],clientMsg[11]}, 
    			new byte[]{clientMsg[0],clientMsg[1]}, result);
    	Msg msg = new Msg(ProtocolUtils.getDeviceId(clientMsg), body0x8001);
//    	msg.encode();
    	return msg.toBytes();
    }
    public static byte[] getServerCommonResponseWithout7e(byte[] clientMsg,byte result){
    	Body0x8001 body0x8001 = new Body0x8001(new byte[]{clientMsg[10],clientMsg[11]}, 
    			new byte[]{clientMsg[0],clientMsg[1]}, result);
    	Msg msg = new Msg(ProtocolUtils.getDeviceId(clientMsg), body0x8001);
    	return msg.encode();
    }

}
