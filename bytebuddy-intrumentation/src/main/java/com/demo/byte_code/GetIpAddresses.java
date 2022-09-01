package com.demo.byte_code;

import java.net.InetAddress;

public class GetIpAddresses {

	public static void main(String[] args) throws Exception{
		InetAddress[] addresses=InetAddress.getAllByName("www.google.com");
		
		for(InetAddress addr:addresses) {
			System.out.println(addr.getHostAddress());
		}
		
		
		

	}

}
