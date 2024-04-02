package kr.ac.hansung.cse.service;

import kr.ac.hansung.cse.dao.RegistDao;
import kr.ac.hansung.cse.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistService {

    @Autowired
    private RegistDao registDao;

    public List<Course> getAllRegistrations() {
        return registDao.getRegistrations();
    }
    public void insert(Course course) { registDao.insert(course);}
}
