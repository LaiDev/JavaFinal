package com.generation.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Student
    extends Person
    implements Evaluation
{
    private double average;

    private final List<Course> courses = new ArrayList<>();

    private final Map<String, Course> approvedCourses = new HashMap<>();

    public Student( String id, String name, String email, Date birthDate )
    {
        super( id, name, email, birthDate );
    }


    public void enrollToCourse( Course course )
    {
        //Call isAttendingCourse with the course code passed in as the argument
        //If the call returns false, the student is not enrolled, add the course
        if(isAttendingCourse(course.getCode()) != true)
        {
            courses.add(course);
            System.out.println("Adding " + course);
        }
    }

    public void registerApprovedCourse( Course course )
    {
        approvedCourses.put( course.getCode(), course );
    }


    public boolean isAttendingCourse( String courseCode )
    {
        //Check to see if there are courses in the Array
        if(courses.size() != 0)
        {
            //Loop through each course in the course array
            for(Course course : courses)
            {   
               //If the course code of the current course is the same as the courseCode of the passed in string, return true
                if(course.getCode() == courseCode)
                {
                    System.out.println("You are already enrolled in " + course.getName() + " " + course.getCode());
                    return true;
                }
                
            }
        }
        //If the student is not enrolled, return false
        return false;
    }

    @Override
    public double getAverage()
    {
        return average;
    }

    @Override
    public String toString()
    {
        return "Student {" + super.toString() + "}";
    }
}
