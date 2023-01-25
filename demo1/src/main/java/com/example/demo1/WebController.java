package com.example.demo1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class WebController {
	
	@Autowired
	private WebService webService;
	
	
	@RequestMapping("/sample")
	public List<SampleResponse> getAllSample(){
		return webService.getAllSample();
	}
	
	@RequestMapping("/sample/{id}")
	public SampleResponse getSample(@PathVariable Integer id) {
		return webService.getSample(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/sample")
	public void createSample(@RequestBody SampleResponse sample) {
		webService.createSample(sample);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/sample/{id}")
	public void updateSample(@PathVariable Integer id, @RequestBody SampleResponse sample) {
		webService.updateSample(id, sample);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/sample/{id}")
	public void deleteSample(@PathVariable Integer id) {
		webService.deleteSample(id);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/sample/{id}/message")
	public String sendMessage(@PathVariable Integer id) {
		return webService.sendMessage(id);
	}
}
