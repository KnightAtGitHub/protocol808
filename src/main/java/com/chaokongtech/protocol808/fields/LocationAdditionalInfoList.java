package com.chaokongtech.protocol808.fields;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.chaokongtech.protocol808.utils.Utils;

public class LocationAdditionalInfoList extends ComplexFIELD{
	private static Logger logger = LogManager.getLogger(LocationAdditionalInfoList.class);
	private ArrayList<LocationAdditionalInfo> locaAddiInfoList = new ArrayList<LocationAdditionalInfo>();
	
	public ArrayList<LocationAdditionalInfo> getLocaAddiInfoList() {
		return locaAddiInfoList;
	}
	public LocationAdditionalInfoList() {
		offset = 28;
	}
	public void addAddiInfo(LocationAdditionalInfo locationAdditionalInfo){
		locaAddiInfoList.add(locationAdditionalInfo);
		size += locationAdditionalInfo.size;
	}
	@Override
	public byte[] encode() {
		bs = new byte[size];
		int arrayIndex = 0;
		for(LocationAdditionalInfo locationAdditionalInfo:locaAddiInfoList){
			byte[] tmp = locationAdditionalInfo.encode();
			for(int i = 0;i<locationAdditionalInfo.size;i++){
				bs[arrayIndex++] = tmp[i];
			}
		}
		
		return bs;
	}
	@Override
	public void decode(byte[] bytes) {
		bs = bytes;
		int index = 0;
		while(index < bytes.length){
			int length = bytes[index+1] +2;
			if (length > bytes.length - index) {
				break;
			}
			byte[] tmp = new byte[length];
			for(int i=0;i<length;i++){
				tmp[i] = bytes[index + i];
			}
			LocationAdditionalInfo locationAdditionalInfo = new LocationAdditionalInfo();
			locationAdditionalInfo.decode(tmp);
			logger.debug("tmp:" + Utils.bytesToString(tmp));
			
			locaAddiInfoList.add(locationAdditionalInfo);
			index += length;
		}
	}
	
}
