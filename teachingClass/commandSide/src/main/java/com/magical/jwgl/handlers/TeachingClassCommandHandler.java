package com.magical.jwgl.handlers;


import com.magical.cloud.commands.CreateTeachingClassCommand;
import com.magical.cloud.domain.CourseStudent;
import com.magical.cloud.domain.CourseTeacher;
import com.magical.cloud.domain.TeacherPositionEnum;
import com.magical.cloud.domain.TeachingCourse;
import com.magical.jwgl.aggregates.TeachingClass;
import com.magical.jwgl.web.clients.StudentService;
import com.magical.jwgl.web.clients.TeacherService;
import com.magical.jwgl.web.dto.StudentDTO;
import com.magical.jwgl.web.dto.TeacherDTO;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Map;

@Component
public class TeachingClassCommandHandler {

    @Autowired
    private Repository<TeachingClass> repository;

    @Autowired
    private StudentService studentService;

    @Autowired
    private TeacherService teacherService;

    @CommandHandler
    public void handler(CreateTeachingClassCommand command) throws Exception {

        Map<String,String> courseInfo = command.getCourseInfo();

        TeachingCourse teachingCourse = new TeachingCourse(courseInfo.get("courseID"),courseInfo.get("courseName"),courseInfo.get("courseType"),courseInfo.get("courseNature"));


        ArrayList<CourseTeacher> courseTeachers = null;

        command.getTeachers().forEach((teacherID,teacherType)->{

            //从教员仓库获得教员信息
            TeacherDTO teacherDTO = this.teacherService.getTeacherDTOByID(teacherID);

            TeacherPositionEnum teacherPosition = null;
            if(teacherType == TeacherPositionEnum.MAJOR.toString() ){
                teacherPosition = TeacherPositionEnum.MAJOR;
            }else {
                teacherPosition = TeacherPositionEnum.ASSIST;
            }

            //封装上课教员信息
            courseTeachers.add(new CourseTeacher(teacherID,teacherDTO.getTeacherName(),teacherPosition));

        });

        ArrayList<CourseStudent> courseStudents = null;

        command.getStudentIDs().forEach(studentID->{

            //从仓库获得学员信息
            StudentDTO studentDTO = this.studentService.getStudentDTOByID(studentID);

            //封装上课学员
            courseStudents.add(new CourseStudent(studentDTO.getStudentID(),studentDTO.getStudentName()));
        });

        repository.newInstance(()->new TeachingClass(command.getTeachingClassID(), teachingCourse, command.getStudingInterval(), courseTeachers, courseStudents));

    }
}
