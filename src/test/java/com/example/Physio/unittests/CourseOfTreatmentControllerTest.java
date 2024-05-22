package com.example.Physio.unittests;

import com.example.Physio.entity.CourseOfTreatment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
@WebMvcTest(CourseOfTreatment.class)
public class CourseOfTreatmentControllerTest {

     @Test
     public void shouldCreateCourseOfTreatment() {
         CourseOfTreatment courseOfTreatment = new CourseOfTreatment();
         courseOfTreatment.setName("testCourseOfTreatment");
         courseOfTreatment.setId(1L);
         courseOfTreatment.setId(1L);
         courseOfTreatment.setStartDate(LocalDate.parse("2021-01-01"));
         courseOfTreatment.setEndDate(LocalDate.parse("2021-01-31"));
         courseOfTreatment.setProgressRating(5);
         courseOfTreatment.setMuscleStrength(5.0);
         courseOfTreatment.setEndurance(5.0);
         courseOfTreatment.setVisitNotes("testVisitNotes");

         assertEquals("testCourseOfTreatment", courseOfTreatment.getName());
         assertEquals(1L, courseOfTreatment.getId());
         assertEquals(LocalDate.parse("2021-01-01"), courseOfTreatment.getStartDate());
         assertEquals(LocalDate.parse("2021-01-31"), courseOfTreatment.getEndDate());
         assertEquals(5, courseOfTreatment.getProgressRating());
         assertEquals(5.0, courseOfTreatment.getMuscleStrength());
         assertEquals(5.0, courseOfTreatment.getEndurance());
         assertEquals("testVisitNotes", courseOfTreatment.getVisitNotes());
     }

        @Test
        public void shouldCreateCourseOfTreatmentassertNotNull() {
        CourseOfTreatment courseOfTreatment = new CourseOfTreatment();
        assertNotNull(courseOfTreatment);
        }


}
