package jUnits;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.filemanager.backend.dao.interfaces.EventDao;
import com.filemanager.config.AppConfig;
import com.filemanager.config.AppInitializer;
import com.filemanager.config.DataSourceConfig;
import com.filemanager.utils.transporters.dto.simple.EventDto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppInitializer.class, AppConfig.class, DataSourceConfig.class }, loader = AnnotationConfigContextLoader.class)
public class EventTest {

	@Autowired
	private EventDao dao;
	private static final int validDoctorId = 1;
	private static final int validEventId = 1;

	@Test
	public void insertRemoveEvent() {
		EventDto event = new EventDto();
		event.setCalendarId(1);
		event.setAllDay("1");
		event.setColor("purple");
		event.setDoctorId(validDoctorId);
		event.setStartDate(new Timestamp(new Date().getTime()));
		event.setEndDate(new Timestamp(new Date().getTime() + 1000));
		event.setObservation("obs");
		int insertedId = dao.insertEvent(event);

		boolean result = dao.removeEvent(insertedId);

		assert (result);
	}

	@Test
	public void updateEvent() {
		EventDto event = new EventDto();
		event.setEventId(1);
		event.setCalendarId(2);
		event.setAllDay("0");
		event.setColor("pink");
		event.setDoctorId(validDoctorId);
		event.setStartDate(new Timestamp(new Date().getTime()));
		event.setEndDate(new Timestamp(new Date().getTime() + 996));
		event.setObservation("obs2");
		boolean result = dao.updateEvent(event);

		assert (result);
	}

	@Test
	public void getEventById() {

		EventDto event = dao.getEventById(validEventId);

		assert (event != null);
	}

	@Test
	public void getEvents() {

		List<EventDto> events = dao.getEvents();
		System.out.println(events.size());
		assert (events.size() > 0);
	}
	
}
