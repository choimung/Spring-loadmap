package com.hello.servlet.web.examfrontcontroller;

import java.util.HashMap;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExamModelView {
    private String viewName;
    private Map<String, Object> model = new HashMap<>();

    public ExamModelView(String viewName) {
        this.viewName = viewName;
    }

}
