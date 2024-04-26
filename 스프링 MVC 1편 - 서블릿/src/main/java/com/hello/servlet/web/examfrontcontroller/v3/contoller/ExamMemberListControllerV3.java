package com.hello.servlet.web.examfrontcontroller.v3.contoller;

import com.hello.servlet.domain.member.Member;
import com.hello.servlet.domain.member.MemberRepository;
import com.hello.servlet.web.examfrontcontroller.ExamModelView;
import com.hello.servlet.web.examfrontcontroller.v3.ExamControllerV3;
import java.util.List;
import java.util.Map;

public class ExamMemberListControllerV3 implements ExamControllerV3 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public ExamModelView process(Map<String, String> paramMap) {

        List<Member> members = memberRepository.findAll();

        ExamModelView mv = new ExamModelView("members");
        mv.getModel().put("members",members);
        return mv;
    }
}
