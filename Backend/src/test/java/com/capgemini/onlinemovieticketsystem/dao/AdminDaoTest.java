package com.capgemini.onlinemovieticketsystem.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.onlinemovieticketsystem.dto.Theater;
import com.capgemini.onlinemovieticketsystem.exception.OnlineMovieTicketException;

@SpringBootTest
public class AdminDaoTest {
	private Theater theater = new Theater();
	@Autowired
	private AdminDao dao;

	@Test
	void testAddTheater() {
		theater.setTheaterId(2345);
		theater.setTheaterName("Aparna");
		theater.setTheaterCity("Manvi");
		theater.setManagerName("Dilip");
		theater.setManagerContact("9019267075");
		try {
			Theater theater1 = dao.addTheater(theater);
			assertEquals(theater1 != null, true);
		} catch (Exception e) {
			assertThrows(OnlineMovieTicketException.class, () -> {
				dao.addTheater(theater);
			});
		}
	}

	@Test
	void deleteTheater() {
		try {
			boolean flag = dao.deleteTheater(theater.getTheaterId());
			assertEquals(flag, true);
		} catch (Exception e) {
			assertThrows(OnlineMovieTicketException.class, () -> {
				dao.deleteTheater(theater.getTheaterId());
			});
		}
	}

	@Test
	void getTheater() {
		try {
			Theater theater1 = dao.getTheater(theater.getTheaterId());
			assertEquals(theater1 != null, true);
		} catch (Exception e) {
			assertThrows(OnlineMovieTicketException.class, () -> {
				dao.getTheater(theater.getTheaterId());
			});
		}
	}

	@Test
	void getAllTheaters() {
		assertNotNull(dao.getAllTheaters());
	}
}
