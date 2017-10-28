package com.springboot.starter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.starter.exception.BaseException;

/* in spring, business services are typically at singleton, when application
 * startups spring creates an instance of the business service and registers that
 * in its memory. Anything will depend on it,will request this service, Spring
 * knows its an instance of this service, it injected them to those instance
 * classes. If any class needs an service, it will not create another instance, 
 * it will ask for the instance, Spring created.
 */
@Service // to define its a service, and need to register its instance
public class TopicService {

	private List<Topic> topics = new ArrayList<>(Arrays.asList(new Topic("java", "J2EE", "Advance description"),
			new Topic("spring", "Spring Framework", "Spring boot description"),
			new Topic("json", "Json", "Json description"), new Topic("jersey", "Jersey", "Restful API description")));

	public List<Topic> getAllToics() {
		return topics;
	}

	public Topic getTopic(String id) {
		Topic topic = topics.stream().filter(t -> t.getId().equals(id)).findFirst()
				.orElseThrow(() -> new BaseException("Topic is not available"));
		// if(topic == null) {
		// System.out.println("Exception found while Retrieving");
		// throw new BaseException("Topic is not available");
		// }
		// else
		return topic;
	}

	public void addTopics(Topic topic) {
		for (Topic t : topics) {
			if (topic.getId().equals(t.getId())) {
				System.out.println("Exception found while Creating");
				throw new BaseException("ID is already added");
			}
		}
		topics.add(topic);
	}

	public void updateTopics(String id, Topic topic) {
		for (int i = 0; i < topics.size(); i++) {
			Topic t = topics.get(i);
			if (t.getId().equals(id)) {
				topics.set(i, topic);
				return;
			}
		}
	}

	public void deleteTopics(String id) {
		// for(int i=0; i<topics.size(); i++) {
		// Topic t = topics.get(i);
		// if(t.getId().equals(id)) {
		// topics.remove(i);
		// return;
		topics.removeIf(t -> t.getId().equals(id));
	}

	// public void addTopics(String id, String name, String desc) {
	// Topic topic = new Topic(id, name, desc);
	// topic.setId(id);
	// topic.setName(name);
	// topic.setDescription(desc);
	// topics.add(topic);
	// }

	// public void addTopics(String detail) {
	// System.out.println("srvice; "+ detail);
	// }

}
