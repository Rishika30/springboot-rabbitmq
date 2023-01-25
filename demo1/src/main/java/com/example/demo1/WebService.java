package com.example.demo1;

import java.util.ArrayList;
import java.util.List;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WebService {
	
	@Autowired
	private SampleRepository sampleRepository;
	
	@Autowired
	public RabbitTemplate template;

	/*
	 * private List<SampleResponse> samples= new ArrayList<>( Arrays.asList(new
	 * SampleResponse(1, "Rishika", 21), new SampleResponse(2, "Ayush", 20)) );
	 */
	
	public List<SampleResponse> getAllSample(){
		List<SampleResponse> samples= new ArrayList<>();
		sampleRepository.findAll().forEach(samples::add);
		return samples;
		
		//return samples;
	}
	
	public SampleResponse getSample(Integer id) {
		//return samples.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return sampleRepository.findById(id).get();
	}
	
	public void createSample(SampleResponse sample) {
		 //samples.add(sample);
		sampleRepository.save(sample);
	}
	
	public void updateSample(Integer id, SampleResponse sample) {
		/*
		 * for(int i=0;i<samples.size();i++) { SampleResponse s= samples.get(i);
		 * if(s.getId().equals(sample.getId())) { samples.set(i, sample); return; } }
		 */
		sampleRepository.save(sample);
	}
	
	public void deleteSample(Integer id) {
		//samples.removeIf(t-> t.getId().equals(id));
		sampleRepository.deleteById(id);
	}
	
	public String sendMessage(Integer id) {
		SampleResponse existingSample= sampleRepository.findById(id).get();
		template.convertAndSend(MessagingConfig.EXCHANGE,MessagingConfig.ROUTING_KEY,existingSample);
		return "SUCCESS!";
	}
}
