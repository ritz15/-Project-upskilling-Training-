package net.upskilling.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import net.upskilling.springboot.entity.WikimediaData;
import net.upskilling.springboot.repository.WikimediaDataRepository;

@Service
public class KafkaDatabaseConsumer {

	private static final Logger LOGGER=LoggerFactory.getLogger(KafkaDatabaseConsumer.class);
	
	private WikimediaDataRepository dataRepository;
	
	public KafkaDatabaseConsumer(WikimediaDataRepository dataRepository) {
		super();
		this.dataRepository = dataRepository;
	}


	@KafkaListener(
			topics="wikimedia_recentchange",
			groupId= "myGroup")
	public void consume(String eventMessage) {
		LOGGER.info(String.format(" EVENT MESSAGE RECEIVED  -> %s", eventMessage));
		
		WikimediaData wikimediaData = new WikimediaData();
		wikimediaData.setWikiEventData(eventMessage);
		
		dataRepository.save(wikimediaData);
		
	}
	
	
}
