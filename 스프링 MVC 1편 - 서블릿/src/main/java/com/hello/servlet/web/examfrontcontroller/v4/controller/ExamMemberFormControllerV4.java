package com.hello.servlet.web.examfrontcontroller.v4.controller;

import com.hello.servlet.web.examfrontcontroller.v4.ExamControllerV4;
import java.util.Map;

public class ExamMemberFormControllerV4 implements ExamControllerV4 {
    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {
        return "new-form";
    }
}
