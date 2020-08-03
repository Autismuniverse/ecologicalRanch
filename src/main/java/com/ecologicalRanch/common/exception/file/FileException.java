package com.ecologicalRanch.common.exception.file;

import com.ecologicalRanch.common.exception.base.BaseException;

/**
 * created by DJun on 2019/9/12 18:47
 * desc: 文件信息异常类
 */
public class FileException extends BaseException {
    private static final long serialVersionUID = 1L;

    public FileException(String code, Object[] args) {
        super("file", code, args, null);
    }

}
