package com.hello.servlet.web.examfrontcontroller.v4;

import com.hello.servlet.web.examfrontcontroller.ExamModelView;
import com.hello.servlet.web.examfrontcontroller.ExamMyView;
import com.hello.servlet.web.examfrontcontroller.v3.ExamControllerV3;
import com.hello.servlet.web.examfrontcontroller.v3.contoller.ExamMemberFormControllerV3;
import com.hello.servlet.web.examfrontcontroller.v3.contoller.ExamMemberListControllerV3;
import com.hello.servlet.web.examfrontcontroller.v3.contoller.ExamMemberSaveControllerV3;
import com.hello.servlet.web.examfrontcontroller.v4.controller.ExamMemberFormControllerV4;
import com.hello.servlet.web.examfrontcontroller.v4.controller.ExamMemberListControllerV4;
import com.hello.servlet.web.examfrontcontroller.v4.controller.ExamMemberSaveControllerV4;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerV4", urlPatterns = "/front-controller/exam/v4/members/*")
public class ExamFrontControllerV4 extends HttpServlet {

    Map<String, ExamControllerV4> controllerMap = new HashMap<>();

    public ExamFrontControllerV4() {
        controllerMap.put("/front-controller/exam/v4/members/new-form", new ExamMemberFormControllerV4());
        controllerMap.put("/front-controller/exam/v4/members/save", new ExamMemberSaveControllerV4());
        controllerMap.put("/front-controller/exam/v4/members", new ExamMemberListControllerV4());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String requestURI = request.getRequestURI();

        ExamControllerV4 controller = controllerMap.get(requestURI);

        Map<String, String> paramMap = createParamMap(request);
        Map<String, Object> model = new HashMap<>();

        String viewName = controller.process(paramMap, model);

        ExamMyView myView = new ExamMyView(viewResolver(viewName));
        myView.render(model, request, response);

    }

    private Map<String, String> createParamMap(HttpServletRequest request) {
        Map<String, String> paramMap = new HashMap<>();
        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName)));
        return paramMap;
    }

    private String viewResolver(String viewName) {
        return "/WEB-INF/views/" + viewName + ".jsp";
    }
}
