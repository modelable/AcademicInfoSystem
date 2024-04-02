package kr.ac.hansung.cse.dao;

import kr.ac.hansung.cse.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class RegistDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Course> getRegistrations() {

        String sqlStatement= "select * from Registrations";
        return jdbcTemplate.query(sqlStatement, new RowMapper<Course>() {

            @Override
            public Course mapRow(ResultSet rs, int rowNum) throws SQLException {

                Course course = new Course();

                course.setCourseYear(rs.getInt("Course_Year"));
                course.setSemester(rs.getInt("Semester"));
                course.setCourseCode(rs.getString("Course_Code"));
                course.setCourseName(rs.getString("Course_Name"));
                course.setCourseType(rs.getString("Course_Type"));
                course.setProfessor(rs.getString("Professor"));
                course.setCredit(rs.getInt("Credit"));

                return course;
            }
        });
    }

    public boolean insert(Course course) {

        Integer courseYear = course.getCourseYear();
        Integer semester = course.getSemester();
        String courseCode = course.getCourseCode();
        String courseName = course.getCourseName();
        String courseType = course.getCourseType();
        String professor = course.getProfessor();
        Integer credit = course.getCredit();

        String sqlStatement= "insert into registrations (Course_Year, Semester, Course_Code, Course_Name, Course_Type, Professor, Credit) VALUES (?,?,?,?,?,?,?)";

        return (jdbcTemplate.update(sqlStatement, new Object[] {courseYear, semester, courseCode, courseName, courseType, professor, credit}) == 1);
    }
}
