package com.chaokongtech.protocol808.fields;

public class LocationAdditionalInfo extends ComplexFIELD{
	private BYTE addInfoId = new BYTE(0);
	private BYTE addInfoLength = new BYTE(1);
	private FIELD field = new SimpleFIELD(2);
	public LocationAdditionalInfo() {
	}
	public LocationAdditionalInfo(FIELD field) {
		this.field = field;
		field.offset = 3;
	}
	public LocationAdditionalInfo(byte[] bytes) {
		field.bs = bytes;
		field.size = bytes.length;
	}
	public BYTE getAddInfoId() {
		return addInfoId;
	}
	public void setAddInfoId(BYTE addInfoId) {
		this.addInfoId = addInfoId;
	}
	public BYTE getAddInfoLength() {
		return addInfoLength;
	}
	public void setAddInfoLength(BYTE addInfoLength) {
		this.addInfoLength = addInfoLength;
	}
	public FIELD getField() {
		return field;
	}
	public void setField(FIELD field) {
		this.field = field;
	}
	@Override
	public void decode(byte[] bytes) {
		field.setSize(bytes[1]);
		super.decode(bytes);
	}
	

}
