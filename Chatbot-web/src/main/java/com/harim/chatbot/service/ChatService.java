package com.harim.chatbot.service;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.harim.chatbot.dao.ChatDao;

@Service
public class ChatService {
	private ChatDao chatDao= new ChatDao();
	
	
	@SuppressWarnings("unchecked")
	public Map open() {
		
		String json = chatDao.open();
		ObjectMapper mapper = new ObjectMapper();
		
		Map<String, Object> res = new HashMap<String, Object>();
		try {
			
			 Map<String, Object> map = mapper.readValue(json, Map.class);
	         Map<String, Object> return_object = (Map<String, Object>)map.get("return_object");
	         Map<String, Object> result = (Map<String, Object>) return_object.get("result");
	         Map<String, Object> submap = new HashMap<String, Object>();
	         
	         String uuid = (String) return_object.get("uuid");
	         String text = (String) result.get("system_text");
	         
	         submap.put("id", "user");
	         res.put("id", "chatbot");
	         res.put("uuid", uuid);
	         res.put("text", text);
	         res.put("createdAt", new Date());
	         res.put("user", submap);
	
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return res;
	}
	
	   @SuppressWarnings("unchecked")
	   public Map<String, Object> message(Map<String, Object> data) {
	      
	      Map<String, Object> question = (Map<String, Object>)data.get("question");
	      
	      Map<String, String> req = new HashMap<>();
	      req.put("text", (String)question.get("text"));
	      req.put("uuid", (String)data.get("uuid"));
	      
	      String json = chatDao.message(req);
	       ObjectMapper mapper = new ObjectMapper();
	       
	      System.out.println(json);
	      Map<String, Object> res = new HashMap<String, Object>();
	       try {
	         Map<String, Object> map = mapper.readValue(json, Map.class);
	         Map<String, Object> return_object = (Map<String, Object>)map.get("return_object");
	         Map<String, Object> result = (Map<String, Object>) return_object.get("result");
	         Map<String, Object> submap = new HashMap<String, Object>();
	         
	         String uuid = (String) return_object.get("uuid");
	         
	         String text = (String) result.get("system_text");
	         
	         submap.put("id", "user");
	         
	         res.put("id", "chatbot");
	         res.put("uuid", uuid);
	         res.put("text", text);
	         res.put("createdAt", new Date());
	         res.put("user", submap);
	         
	         
	      } catch (JsonParseException e) {
	         e.printStackTrace();
	      } catch (JsonMappingException e) {
	         e.printStackTrace();
	      } catch (IOException e) {
	         e.printStackTrace();
	      }
	      
	      return res;
	   }

}
