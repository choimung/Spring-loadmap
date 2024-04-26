package com.hello.servlet.web.examfrontcontroller.v2.controller;

import com.hello.servlet.web.examfrontcontroller.ExamMyView;
import com.hello.servlet.web.examfrontcontroller.v1.ExamControllerV1;
import com.hello.servlet.web.examfrontcontroller.v2.ExamControllerV2;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ExamMemberFormControllerV2 implements ExamControllerV2 {

    @Override
    public ExamMyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        return new ExamMyView("/WEB-INF/views/new-form.jsp");
    }
}
