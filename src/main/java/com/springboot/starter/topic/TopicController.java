package com.springboot.starter.topic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
	/*
	 * how to ask for service instance, first need to create the private member variable
	 * then spring will inject the service into this class
	 */

	@Autowired //which marks as it needs dependency injection
	private TopicService topicservice;
	
	@RequestMapping("/topics")
	public List<Topic> getAlltopics() {
		return topicservice.getAllToics();			
	}
	
	@RequestMapping("/topics/{id}")
	public Topic getTopic(@PathVariable String id) {
		return topicservice.getTopic(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/topics")
	public void addTopics(@RequestBody Topic topic) {
		System.out.println("Adding topic");
		topicservice.addTopics(topic);			
	}
	
//	@RequestMapping(method = RequestMethod.POST, value = "/topics/{id,name,desc}")
//	public void addTopics2(@RequestBody String detail) {
//		System.out.println("Detail: "+ detail);
//		topicservice.addTopics(detail);			
//	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/topics/{id}")
	public void updateTopics(@RequestBody Topic topic, @PathVariable String id) {
		System.out.println("Updating topic");
		topicservice.updateTopics(id, topic);			
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/topics/{id}")
	public void deleteTopics(@PathVariable String id) {
		System.out.println("Deleting topic");
		topicservice.deleteTopics(id);			
	}
}