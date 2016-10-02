package jUnits;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.filemanager.backend.service.interfaces.CalendarService;
import com.filemanager.config.AppConfig;
import com.filemanager.config.AppInitializer;
import com.filemanager.config.DataSourceConfig;
import com.filemanager.utils.transporters.entities.Calendar;
import com.filemanager.utils.transporters.entities.Doctor;
import com.filemanager.utils.transporters.entities.Event;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppInitializer.class, AppConfig.class, DataSourceConfig.class }, loader = AnnotationConfigContextLoader.class)
public class CalendarTest {

	@Autowired
	private CalendarService service;

	@Test
	public void insertDeleteCalendar() {

		// insert calendar
		Calendar calendar = service.addCalendarForDoctor(16);

		// delete interted calendar
		boolean success = service.deleteCalendar(calendar);

		assert (success);
	}

	@Test
	public void insertDeleteEvent() {

		// insert event
		Event event = new Event();
		Calendar calendar = new Calendar();
		Doctor doctor = new Doctor();
		doctor.setDoctorId(16);
		calendar.setDoctor(doctor);
		calendar.setCalendarId(1);
		event.setCalendar(calendar);
		event.setColor("red");
		service.addEvent(event);

		// delete inserted event
		boolean success = service.removeEvent(event);

		assert (success);
	}

	@Test
	public void getEvents() {

		int calendarId = 1;

		List<Event> result = service.getEvents(calendarId);

		assert (result != null && !result.isEmpty());

	}

	@Test
	public void getEventById() {

		int eventId = 1;

		Event event = service.getEventById(eventId);

		assert (event != null);
	}

}
