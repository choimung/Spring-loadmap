package com.hello.servlet.web.examfrontcontroller.v1;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.rmi.ServerException;

public interface ExamControllerV1{
    void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
