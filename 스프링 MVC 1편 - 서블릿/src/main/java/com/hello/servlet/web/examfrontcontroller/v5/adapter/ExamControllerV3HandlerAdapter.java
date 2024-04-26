package com.hello.servlet.web.examfrontcontroller.v5.adapter;

import com.fasterxml.jackson.databind.deser.impl.CreatorCandidate.Param;
import com.hello.servlet.web.examfrontcontroller.ExamModelView;
import com.hello.servlet.web.examfrontcontroller.v3.ExamControllerV3;
import com.hello.servlet.web.examfrontcontroller.v5.ExamMyHandlerAdapter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class ExamControllerV3HandlerAdapter implements ExamMyHandlerAdapter {
    @Override
    public boolean isSupports(Object handler) {
        return (handler instanceof ExamControllerV3);
    }

    @Override
    public ExamModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        ExamControllerV3 controller = (ExamControllerV3) handler;

        Map<String, String> paramMap = crateParamMap(request);
        ExamModelView mv = controller.process(paramMap);

        return mv;
    }

    private Map<String, String> crateParamMap(HttpServletRequest request) {
        Map<String, String > paramMap = new HashMap<>();
        request.getParameterNames().asIterator()
                .forEachRemaining(i -> paramMap.put(i, request.getParameter(i)));
        return paramMap;
    }
}
