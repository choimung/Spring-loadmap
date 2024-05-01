package com.hello.servlet.web.examfrontcontroller.v5.adapter;

import com.fasterxml.jackson.databind.deser.impl.CreatorCandidate.Param;
import com.hello.servlet.web.examfrontcontroller.ExamModelView;
import com.hello.servlet.web.examfrontcontroller.v3.ExamControllerV3;
import com.hello.servlet.web.examfrontcontroller.v5.ExamMyHandlerAdapter;
import com.hello.servlet.web.frontcontroller.ModelView;
import com.hello.servlet.web.frontcontroller.v3.ControllerV3;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class ExamControllerV3HandlerAdapter implements ExamMyHandlerAdapter {

    @Override
    public boolean isSupports(Object object) {
        return (object instanceof ExamControllerV3);
    }

    @Override
    public ExamModelView handle(HttpServletRequest request, HttpServletResponse response, Object handle) {
        ExamControllerV3 controller = (ExamControllerV3) handle;
        Map<String, String> paramMap = createParamMap(request);
        ExamModelView mv = controller.process(paramMap);
        return mv;
    }

    private static Map<String, String> createParamMap(HttpServletRequest request) {
        Map<String, String> paramMap = new HashMap<>();
        request.getParameterNames().asIterator()
                        .forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName)));
        return paramMap;
    }
}
