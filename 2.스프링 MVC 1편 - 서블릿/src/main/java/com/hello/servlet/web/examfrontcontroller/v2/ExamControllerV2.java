package com.hello.servlet.web.examfrontcontroller.v2;

import com.hello.servlet.web.examfrontcontroller.ExamMyView;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface ExamControllerV2 {
    ExamMyView process (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
