package com.hello.servlet.web.examfrontcontroller.v2.controller;

import com.hello.servlet.domain.member.Member;
import com.hello.servlet.domain.member.MemberRepository;
import com.hello.servlet.web.examfrontcontroller.ExamMyView;
import com.hello.servlet.web.examfrontcontroller.v2.ExamControllerV2;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ExamMemberListControllerV2 implements ExamControllerV2 {

    private MemberRepository memberRepository = MemberRepository.getInstance();
    @Override
    public ExamMyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Member> members = memberRepository.findAll();

        request.setAttribute("members", members);

        return new ExamMyView("/WEB-INF/views/members.jsp");
    }
}
