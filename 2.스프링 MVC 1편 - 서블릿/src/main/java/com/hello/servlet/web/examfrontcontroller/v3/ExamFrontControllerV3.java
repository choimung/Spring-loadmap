package com.hello.servlet.web.examfrontcontroller.v3;

import com.hello.servlet.web.examfrontcontroller.ExamModelView;
import com.hello.servlet.web.examfrontcontroller.ExamMyView;
import com.hello.servlet.web.examfrontcontroller.v2.ExamControllerV2;
import com.hello.servlet.web.examfrontcontroller.v2.controller.ExamMemberFormControllerV2;
import com.hello.servlet.web.examfrontcontroller.v2.controller.ExamMemberListControllerV2;
import com.hello.servlet.web.examfrontcontroller.v2.controller.ExamMemberSaveControllerV2;
import com.hello.servlet.web.examfrontcontroller.v3.contoller.ExamMemberFormControllerV3;
import com.hello.servlet.web.examfrontcontroller.v3.contoller.ExamMemberListControllerV3;
import com.hello.servlet.web.examfrontcontroller.v3.contoller.ExamMemberSaveControllerV3;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerV3", urlPatterns = "/front-controller/exam/v3/members/*")
public class ExamFrontControllerV3 extends HttpServlet {

    Map<String, ExamControllerV3> controllerMap = new HashMap<>();

    public ExamFrontControllerV3() {
        controllerMap.put("/front-controller/exam/v3/members/new-form", new ExamMemberFormControllerV3());
        controllerMap.put("/front-controller/exam/v3/members/save", new ExamMemberSaveControllerV3());
        controllerMap.put("/front-controller/exam/v3/members", new ExamMemberListControllerV3());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();

        ExamControllerV3 controller = controllerMap.get(requestURI);

        Map<String, String> paramMap = createParamMap(request);
        ExamModelView mv = controller.process(paramMap);

        String viewName = mv.getViewName();
        ExamMyView myView = new ExamMyView(viewResolver(viewName));
        myView.render(mv.getModel(),request, response);

    }

    private  Map<String, String> createParamMap(HttpServletRequest request) {
        Map<String, String> paramMap = new HashMap<>();
        request.getParameterNames().asIterator()
                        .forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName)));
        return paramMap;
    }

    private String viewResolver(String viewName){
        return "/WEB-INF/views/" + viewName + ".jsp";
    }
}
