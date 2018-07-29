package com.chaokongtech.protocol808.utils;

import java.text.SimpleDateFormat;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Utils {
	private static Logger logger = LogManager.getLogger(Utils.class);
	public static byte[] integer2bytes(long num,int length){
		byte[] bytes = new byte[length];
		for(int i=0;i<length;i++){
			bytes[i] = (byte) (num >> 8*(length-i-1));
		}
		return bytes;
	}
	public static String bytesToString(byte[] src){
		StringBuilder sBuilder = new StringBuilder();
		if (src == null || src.length <= 0) {
			return null;
		}
		for(int i=0;i<src.length;i++){
			int v = src[i] & 0xFF;  
            String hv = Integer.toHexString(v).toUpperCase();  
            if (hv.length() < 2) {  
                sBuilder.append(0);  
            }  
            sBuilder.append(hv).append(" ");
		}
		return sBuilder.toString();
	}
	public static byte[] longTime2BCD(long time){
		return stringTime2BCD(dateFormate1(time));
	}
	public static byte[] intStr2BCD(String string,int bcdLength){
		byte[] src = string.getBytes();
		
		byte[] tmp = new byte[bcdLength*2];
		for(int i=0;i<tmp.length;i++){
			tmp[i] = '0';
		}
		int strLength = src.length;
		int minLength = strLength < bcdLength*2 ? strLength:bcdLength*2;
		for(int i=0;i<minLength;i++){
			tmp[i] = src[i];
		}
		
		byte[] dis = new byte[bcdLength];
		for(int i=0;i<bcdLength;i++){
			int j = (tmp[i*2]-'0')<<4;
			int k = tmp[i*2+1]-'0';
			dis[i]=(byte) (j + k);
		}
		return dis;
	}
	public static String bcd2intStr(byte[] bs){
		StringBuilder stringBuilder = new StringBuilder();
		String tmp = "0123456789";
		for(byte b:bs){
			int num = b&0xff;
			int i = num>>4;
			int j = num&0x0f;
			stringBuilder.append(tmp.charAt(num>>4))
							.append(tmp.charAt(num&0x0f));
		}
		return stringBuilder.toString();
	}
	public static byte[] stringTime2BCD(String string){
		byte[] bs = new byte[6];
//		byte[] source = new byte[string.length()];
		byte[] source = string.getBytes();
//		System.out.println("source:" + Converter.bytesToString(source));
//		System.out.println("0=" + (source[8]-'0'));
		for(int i=0;i<bs.length;i++){
			int j = (source[i*2]-'0')<<4;
			int k = source[i*2+1]-'0';
			bs[i]=(byte) (j + k);
			
//			System.out.println("j,k = " + j + "," + k);
//			System.out.println(":" + bs[i]);
		}
		return bs;
	}
	public static String dateFormate1(long millis){
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmss");
		return sdf.format(millis);
	}
	public static void main(String[] args) {
//		System.out.println(":" + Converter.bytesToString(integer2bytes(0x0200, 4)));
//		System.out.println(":" + dateFormate1(System.currentTimeMillis()));
//		System.out.println(":" + Converter.bytesToString(stringTime2BCD("123456789012")));
		/*for(int i=0;i<1000000000;i++){
			byte[] tmp = integer2bytes(i, 2);
			logger.info("" + i + ":" + bytesToString(tmp));
		}*/
//		System.out.println("" + bytesToString(intStr2BCD("12345678901", 7)));
		System.out.println("int:" + bytes2int(new byte[]{0x02,0x02}));
		byte[] bytes = new byte[]{0x01,0x02};
		int num1 = (bytes[0]<<8) + bytes[1];
		System.out.println("num1:" + num1);
		int num2 = 0;
		num2 += bytes[0]<<8;
		num2 += bytes[1];
		System.out.println("num2:" + num2);
		System.out.println("out:" + bcd2intStr(new byte[]{(byte) 0x99,0x02,0x03}));
	}
	// 计算校验码
    public static byte Xor(byte[] data, int offset, int count) {
        byte val = data[offset];
        for (int i = offset + 1; i < count; i++) {
            val = (byte) (val ^ data[i]);
        }
        return val;
    }
	public static byte[] bytesAdd0x00(byte[] src,int goalLength){
		if (src.length<goalLength) {
			byte[] tmp = new byte[goalLength];
			for(int i=0;i<src.length;i++){
				tmp[i] = src[i];
			}
			for(int i=src.length;i<goalLength;i++){
				tmp[i] = 0x00;
			}
			return tmp;
		}else {
			return src;
		}
	}
	public static int bytes2int(byte[] bytes){
		int length = bytes.length;
		int num = 0;
		for(int i=0;i<length;i++){
			num += (bytes[i] & 0xff) << (8*(length-1-i));
		}
		return num;
	}
	

}
