package com.magical.cloud.events;

import com.magical.cloud.domain.CourseEvaluateStandardID;
import com.magical.cloud.domain.EvaluateCourse;
import com.magical.cloud.domain.TeachingClassID;
import com.magical.cloud.domain.TeachingClassScoreID;

public class TeachingClassScoreCreatedEvent {

    private TeachingClassScoreID teachingClassScoreID;

    private TeachingClassID teachingClassID;

    private String termID;

    //考核课程
    private EvaluateCourse evaluateCourse;

    //课程考核标准
    private CourseEvaluateStandardID courseEvaluateStandardID;

    public TeachingClassScoreCreatedEvent(TeachingClassScoreID teachingClassScoreID, TeachingClassID teachingClassID, String termID, EvaluateCourse evaluateCourse, CourseEvaluateStandardID courseEvaluateStandardID) {
        this.teachingClassScoreID = teachingClassScoreID;
        this.teachingClassID = teachingClassID;
        this.termID = termID;
        this.evaluateCourse = evaluateCourse;
        this.courseEvaluateStandardID = courseEvaluateStandardID;
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

    public EvaluateCourse getEvaluateCourse() {
        return evaluateCourse;
    }

    public CourseEvaluateStandardID getCourseEvaluateStandardID() {
        return courseEvaluateStandardID;
    }
}
