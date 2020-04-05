package com.ecologicalRanch.project.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class xhd_SearchRes {
    @PostMapping("/xhd/SeachRes")
    public String returSearchRes(String str)
    {
        return "{\"code\":200,\"message\":\"操作成功\",\"data\":{\"pageNum\":1,\"pageSize\":4,\"totalPage\":3,\"total\":12,\"list\":[{\"fieldId\":1,\"adminId\":1999,\"fieldName\":\"德阳养鸡场\",\"address\":\"德阳市\",\"qualified\":0,\"grade\":1,\"logoSrc\":\"123\",\"styleClass\":\"乌骨鸡\"},{\"fieldId\":2,\"adminId\":1024,\"fieldName\":\"成都养殖场\",\"address\":\"成都市\",\"qualified\":1,\"grade\":1,\"logoSrc\":\"123\",\"styleClass\":\"火鸡\"},{\"fieldId\":3,\"adminId\":1024,\"fieldName\":\"北京养殖场\",\"address\":\"北京市\",\"qualified\":1,\"grade\":1,\"logoSrc\":\"123\",\"styleClass\":\"飞机\"},{\"fieldId\":4,\"adminId\":1999,\"fieldName\":\"美国养殖场\",\"address\":\"NEWYORK\",\"qualified\":1,\"grade\":1,\"logoSrc\":\"123\",\"styleClass\":\"小鸡\"}],\"orderByColumn\":null,\"isAsc\":null,\"orderBy\":\"\"}}";
    }
}
