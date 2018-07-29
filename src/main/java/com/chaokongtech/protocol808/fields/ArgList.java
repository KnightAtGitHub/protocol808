package com.chaokongtech.protocol808.fields;

import java.util.ArrayList;

import javax.xml.transform.Templates;

import com.chaokongtech.protocol808.utils.Utils;

public class ArgList extends FIELD{
	private ArrayList<Arg> arguments = new ArrayList<Arg>();
	public ArgList() {
	}
	public ArgList(int offset) {
		super(offset);
	}
	public ArgList addArg(Arg argument){
		argument.setOffset(size);
		size += argument.getSize();
		arguments.add(argument);
		return this;
	}
	@Override
	public byte[] encode() {
		byte[] dis = new byte[size];
		for(Arg arg:arguments){
			
		}	
		return dis;
	}
	
	public static void main(String[] args){
		DWORD dword = new DWORD(0,1000);
		Arg arg = new Arg(100, dword);
		Arg arg2 = new Arg(10, dword);
		ArgList args2 = new ArgList(0);
		args2.addArg(arg);
		args2.addArg(arg2);
		System.out.println("args:" + Utils.bytesToString(args2.encode()));
	}
	@Override
	public void decode(byte[] bytes) {
		// TODO Auto-generated method stub
		
	}
		

}
