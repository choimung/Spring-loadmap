package com.hello.servlet.web.examfrontcontroller.v5;

import com.hello.servlet.web.examfrontcontroller.ExamModelView;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface ExamMyHandlerAdapter {

    boolean isSupports(Object handler);

    public ExamModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler);
}
