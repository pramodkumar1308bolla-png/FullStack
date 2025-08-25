package com.jsp.ListSenerioBased;

import java.util.HashSet;

public class UniqueEmployeeId {

	public static void main(String[] args) {
		HashSet<Object> ids=new HashSet<Object>();
		ids.add(111);
		ids.add(222);
		ids.add(333);
		ids.add(999);
		ids.add(111);
//		System.out.println("unique employe ids are " + ids);
		System.out.println("unique employe ids are ");
		for(Object obj : ids ) {
			System.out.println(obj);
		}
		

	}

}
