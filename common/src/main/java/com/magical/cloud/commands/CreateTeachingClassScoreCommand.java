package com.magical.cloud.commands;

import com.magical.cloud.domain.CourseEvaluateStandardID;
import com.magical.cloud.domain.TeachingClassID;
import com.magical.cloud.domain.TeachingClassScoreID;

public class CreateTeachingClassScoreCommand {

    private TeachingClassScoreID teachingClassScoreID;

    private TeachingClassID teachingClassID;

    private String termID;

    private String courseID;

    //课程考核标准
    private CourseEvaluateStandardID courseEvaluateStandardID;

    public CreateTeachingClassScoreCommand(TeachingClassScoreID teachingClassScoreID, TeachingClassID teachingClassID, String termID, String courseID) {
        this.teachingClassScoreID = teachingClassScoreID;
        this.teachingClassID = teachingClassID;
        this.termID = termID;
        this.courseID = courseID;
    }

    public TeachingClassScoreID getTeachingClassScoreID() {
        return teachingClassScoreID;
    }

    public TeachingClassID getTeachingClassID() {
        return teachingClassID;
    }

    public String getTermID() {
        return termID;
    }

    public String getCourseID() {
        return courseID;
    }
}
