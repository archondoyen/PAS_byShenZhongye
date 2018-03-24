package com.archon.dao;

import com.archon.po.Notice;

import java.util.List;

public interface NoticeDao {
    boolean addNotice(Notice notice);
    boolean updateNotice(Notice notice);
    List<Notice> queryNotice(Notice notice);
}