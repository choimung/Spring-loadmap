package com.hello.servlet.web.examfrontcontroller.v5;

import com.hello.servlet.web.examfrontcontroller.ExamModelView;
import com.hello.servlet.web.frontcontroller.ModelView;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface ExamMyHandlerAdapter {

    boolean isSupports(Object object);

    ExamModelView handle(HttpServletRequest request, HttpServletResponse response, Object handle);

}
