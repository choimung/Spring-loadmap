package com.hello.servlet.web.examfrontcontroller.v2;

import com.hello.servlet.web.examfrontcontroller.ExamMyView;
import com.hello.servlet.web.examfrontcontroller.v1.ExamControllerV1;
import com.hello.servlet.web.examfrontcontroller.v1.controller.ExamMemberFormControllerV1;
import com.hello.servlet.web.examfrontcontroller.v1.controller.ExamMemberListControllerV1;
import com.hello.servlet.web.examfrontcontroller.v1.controller.ExamMemberSaveControllerV1;
import com.hello.servlet.web.examfrontcontroller.v2.controller.ExamMemberFormControllerV2;
import com.hello.servlet.web.examfrontcontroller.v2.controller.ExamMemberListControllerV2;
import com.hello.servlet.web.examfrontcontroller.v2.controller.ExamMemberSaveControllerV2;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerV2", urlPatterns = "/front-controller/exam/v2/members/*")
public class ExamFrontControllerV2 extends HttpServlet {

    Map<String, ExamControllerV2> controllerMap = new HashMap<>();

    public ExamFrontControllerV2() {
        controllerMap.put("/front-controller/exam/v2/members/new-form", new ExamMemberFormControllerV2());
        controllerMap.put("/front-controller/exam/v2/members/save", new ExamMemberSaveControllerV2());
        controllerMap.put("/front-controller/exam/v2/members", new ExamMemberListControllerV2());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        ExamControllerV2 controller = controllerMap.get(requestURI);

        ExamMyView myView = controller.process(request, response);
        myView.render(request, response);
    }
}
