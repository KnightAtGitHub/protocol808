package com.chaokongtech.protocol808.fields;

import java.util.ArrayList;

import com.chaokongtech.protocol808.utils.Utils;

public class ArgIds extends FIELD{
	private ArrayList<Long> argIds = new ArrayList<Long>(); 
	public ArgIds(int offset) {
		super(offset);
	}
	public void addArgId(long argId){
		argIds.add(argId);
		size = 4*argIds.size();
	}

	@Override
	public byte[] encode() {
		
		byte[] bs = new byte[size];
		for(int i=0;i<argIds.size();i++){
			byte[] tmp = Utils.integer2bytes(argIds.get(i), 4);
			for(int j=0;j<4;j++){
				bs[4*i+j] = tmp[j];
			}
		}
		return bs;
	}
	@Override
	public void decode(byte[] bytes) {
		// TODO Auto-generated method stub
		
	}
		
}
