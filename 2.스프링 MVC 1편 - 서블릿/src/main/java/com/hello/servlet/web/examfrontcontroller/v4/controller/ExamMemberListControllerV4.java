package com.hello.servlet.web.examfrontcontroller.v4.controller;

import com.hello.servlet.domain.member.Member;
import com.hello.servlet.domain.member.MemberRepository;
import com.hello.servlet.web.examfrontcontroller.v4.ExamControllerV4;
import java.util.List;
import java.util.Map;

public class ExamMemberListControllerV4 implements ExamControllerV4 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {

        List<Member> members = memberRepository.findAll();

        model.put("members", members);
        return "members";
    }
}
