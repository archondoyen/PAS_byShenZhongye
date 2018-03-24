package com.archon.service.impl;

import com.archon.dao.NoticeDao;
import com.archon.po.Notice;
import com.archon.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service(value = "NoticeService")
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    private NoticeDao noticeDao;
    @Override
    public boolean addNotice(Notice notice) {
        return noticeDao.addNotice(notice);
    }

    @Override
    public boolean updateNotice(Notice notice) {
        return noticeDao.updateNotice(notice);
    }

    @Override
    public List<Notice> queryNotice(Notice notice) {
        return noticeDao.queryNotice(notice);
    }
}