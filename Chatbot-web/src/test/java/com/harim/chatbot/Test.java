package com.harim.chatbot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
	
	public static void main(String[] args) {
	
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, List<String>> submap = new HashMap<String, List<String>>();
		List<String> sublist = new ArrayList<String>();
		
		 sublist.add("10");
		 sublist.add("11");
		 sublist.add("12");
		 
		 List<String> finalList = new ArrayList<String>();
		 
		 finalList.add("11");
		 finalList.add("12");
		 finalList.add("23");
		 
		 submap.put("semi", sublist);
		 submap.put("final", finalList);
		
		map.put("person", "���");
	    map.put("sports", "�߱�");
	    map.put("score", submap);
	    
	    Map<String, Object> map2 = new HashMap<String, Object>();
	    
	    map2.put("person", "���");
	    map2.put("sports", "cnrrn");
	    
	    Map<String, Object> map3 = new HashMap<String, Object>();
	    
	    map3.put("person", "���3");
	    map3.put("sports", "��");
	    
		
		list.add(map);
		list.add(map2);
		list.add(map3);
		
		System.out.println(list.toString());
		
		//�������� ���
		Map<String, Object> res = list.get(0);
		Map<String, List> scoreMap =  (Map<String, List>)map.get("scre");
		
		List<String> semi = scoreMap.get("semi");
		
		String value =  semi.get(1);
		
		System.out.println(value);
		
	}

}
