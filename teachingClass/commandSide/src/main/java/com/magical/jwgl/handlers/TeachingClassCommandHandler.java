package com.magical.jwgl.handlers;


import com.magical.cloud.commands.CreateTeachingClassCommand;
import com.magical.cloud.domain.CourseStudent;
import com.magical.cloud.domain.CourseTeacher;
import com.magical.cloud.domain.TeachingCourse;
import com.magical.jwgl.aggregates.TeachingClass;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Map;

public class TeachingClassCommandHandler {

    @Autowired
    private Repository<TeachingClass> repository;



    @CommandHandler
    public void handler(CreateTeachingClassCommand command) throws Exception {

        Map<String,String> courseInfo = command.getCourseInfo();

        TeachingCourse teachingCourse = new TeachingCourse(courseInfo.get("teachingCourseID"),courseInfo.get("courseName"),courseInfo.get("courseType"),courseInfo.get("courseNature"));


        ArrayList<CourseTeacher> courseTeachers = null;
        command.getTeachers().forEach((teacherID,teacherPosition)->{
            //从教员仓库获得教员信息

            //封装上课教员信息

        });

        ArrayList<CourseStudent> courseStudents = null;

        command.getStudentIDs().forEach(student->{
            //从仓库获得学员信息

            //封装上课学员

        });

        repository.newInstance(()->new TeachingClass(command.getTeachingClassID(), teachingCourse, command.getStudingInterval(), courseTeachers, courseStudents));

    }
}
