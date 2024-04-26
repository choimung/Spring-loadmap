package com.hello.servlet.web.examfrontcontroller.v5;

import com.hello.servlet.web.examfrontcontroller.ExamModelView;
import com.hello.servlet.web.examfrontcontroller.ExamMyView;
import com.hello.servlet.web.examfrontcontroller.v3.contoller.ExamMemberFormControllerV3;
import com.hello.servlet.web.examfrontcontroller.v3.contoller.ExamMemberListControllerV3;
import com.hello.servlet.web.examfrontcontroller.v3.contoller.ExamMemberSaveControllerV3;
import com.hello.servlet.web.examfrontcontroller.v4.ExamControllerV4;
import com.hello.servlet.web.examfrontcontroller.v5.adapter.ExamControllerV3HandlerAdapter;
import com.hello.servlet.web.frontcontroller.v5.MyHandlerAdapter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "frontControllerV5", urlPatterns = "/front-controller/exam/v5/v3/members/*")
public class ExamFrontControllerV5 extends HttpServlet {

    Map<String, Object> handlerMappingMap = new HashMap<>();
    List<ExamMyHandlerAdapter> handlerAdapterList = new ArrayList<>();

    public ExamFrontControllerV5() {
        handlerMappingMap.put("/front-controller/exam/v5/v3/members/new-form", new ExamMemberFormControllerV3());
        handlerMappingMap.put("/front-controller/exam/v5/v3/members/save", new ExamMemberSaveControllerV3());
        handlerMappingMap.put("/front-controller/exam/v5/v3/members", new ExamMemberListControllerV3());

        handlerAdapterList.add(new ExamControllerV3HandlerAdapter());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Object handler = getMyHandler(request);

        if(handler == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        ExamMyHandlerAdapter handlerAdapter = getHandlerAdapter(handler);

        ExamModelView mv = handlerAdapter.handle(request, response, handler);
        String viewName = mv.getViewName();
        Map<String, Object> model = mv.getModel();
        ExamMyView myView = new ExamMyView(viewResolver(viewName));
        myView.render(model, request, response);

    }

    private ExamMyHandlerAdapter getHandlerAdapter(Object handler) {
        for (ExamMyHandlerAdapter adapter : handlerAdapterList) {
            if(adapter.isSupports(handler)) {
                return adapter;
            }
        }throw new IllegalArgumentException("my handler not found");
    }

    private Object getMyHandler(HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        return handlerMappingMap.get(requestURI);
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
