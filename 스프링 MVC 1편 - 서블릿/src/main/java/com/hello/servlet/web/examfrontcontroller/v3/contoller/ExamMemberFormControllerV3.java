package com.hello.servlet.web.examfrontcontroller.v3.contoller;

import com.hello.servlet.web.examfrontcontroller.ExamModelView;
import com.hello.servlet.web.examfrontcontroller.ExamMyView;
import com.hello.servlet.web.examfrontcontroller.v2.ExamControllerV2;
import com.hello.servlet.web.examfrontcontroller.v3.ExamControllerV3;
import com.hello.servlet.web.frontcontroller.ModelView;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class ExamMemberFormControllerV3 implements ExamControllerV3 {

    @Override
    public ExamModelView process(Map<String, String> paramMap) {
        return new ExamModelView("new-form");
    }
}
