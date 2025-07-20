package com.example.course.registration.system.controller;

import com.example.course.registration.system.model.Course;
import com.example.course.registration.system.model.CourseRegistry;
import com.example.course.registration.system.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins="http://127.0.0.1:5500")
public class CourseController {

    @Autowired
    CourseService  courseService;

    @GetMapping("courses")
    public List<Course> availableCourses(){
        return courseService.availaibleCourses();
    }

    @GetMapping("courses/enrolled")
    public List<CourseRegistry> enrolledStudents(){
        return courseService.enrolledStudents();
    }

    @PostMapping("/courses/register")
    public  String enrollCourse(@RequestParam("name") String name,
                                @RequestParam("emailId") String emailId,
                                @RequestParam("courseName") String courseName){
        courseService.enrollcourse(name,emailId,courseName);
        return "congrats! " + name+ " Enrollment sucessfull for "+courseName;
    }



}