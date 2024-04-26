package com.hello.servlet.web.examfrontcontroller.v3;

import com.hello.servlet.web.examfrontcontroller.ExamModelView;
import com.hello.servlet.web.frontcontroller.ModelView;
import java.rmi.ServerException;
import java.util.Map;

public interface ExamControllerV3 {
    ExamModelView process(Map<String, String> paramMap);
}
