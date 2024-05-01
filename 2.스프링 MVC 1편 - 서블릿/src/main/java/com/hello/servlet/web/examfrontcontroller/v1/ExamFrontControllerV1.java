package com.hello.servlet.web.examfrontcontroller.v1;

import com.hello.servlet.web.examfrontcontroller.v1.ExamControllerV1;
import com.hello.servlet.web.examfrontcontroller.v1.controller.ExamMemberFormControllerV1;
import com.hello.servlet.web.examfrontcontroller.v1.controller.ExamMemberListControllerV1;
import com.hello.servlet.web.examfrontcontroller.v1.controller.ExamMemberSaveControllerV1;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerV1", urlPatterns = "/front-controller/exam/v1/members/*")
public class ExamFrontControllerV1 extends HttpServlet {

    Map<String, ExamControllerV1> controllerMap = new HashMap<>();

    public ExamFrontControllerV1() {
        controllerMap.put("/front-controller/exam/v1/members/new-form", new ExamMemberFormControllerV1());
        controllerMap.put("/front-controller/exam/v1/members/save", new ExamMemberSaveControllerV1());
        controllerMap.put("/front-controller/exam/v1/members", new ExamMemberListControllerV1());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        ExamControllerV1 controller = controllerMap.get(requestURI);
        controller.process(request, response);
    }
}
