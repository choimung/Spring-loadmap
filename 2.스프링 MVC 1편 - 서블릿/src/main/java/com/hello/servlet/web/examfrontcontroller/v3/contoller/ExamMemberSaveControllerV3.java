package com.hello.servlet.web.examfrontcontroller.v3.contoller;

import com.hello.servlet.domain.member.Member;
import com.hello.servlet.domain.member.MemberRepository;
import com.hello.servlet.web.examfrontcontroller.ExamModelView;
import com.hello.servlet.web.examfrontcontroller.ExamMyView;
import com.hello.servlet.web.examfrontcontroller.v2.ExamControllerV2;
import com.hello.servlet.web.examfrontcontroller.v3.ExamControllerV3;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class ExamMemberSaveControllerV3 implements ExamControllerV3 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public ExamModelView process(Map<String, String> paramMap) {

        String username = paramMap.get("username");
        int age = Integer.parseInt(paramMap.get("age"));

        Member member = new Member(username, age);
        memberRepository.save(member);

        ExamModelView mv = new ExamModelView("save-result");
        mv.getModel().put("member", member);
        return mv;
    }
}
