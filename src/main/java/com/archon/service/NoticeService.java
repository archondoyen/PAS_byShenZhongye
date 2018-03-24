package com.archon.service;

import com.archon.po.Notice;

import java.util.List;

public interface NoticeService {
    boolean addNotice(Notice notice);
    boolean updateNotice(Notice notice);
    List<Notice> queryNotice(Notice notice);
}