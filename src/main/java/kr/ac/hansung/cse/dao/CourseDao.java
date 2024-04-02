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
public class CourseDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Course> getCourses() {

        String sqlStatement = "select * from Courses";
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

    public List<Object[]> getYearSemesterCredit() {
        String sqlStatement = "SELECT Course_Year, Semester, SUM(Credit) AS TotalCredit FROM Courses GROUP BY Course_Year, Semester";
        return jdbcTemplate.query(sqlStatement, (rs, rowNum) -> {
            int year = rs.getInt("Course_Year");
            int semester = rs.getInt("Semester");
            int totalCredit = rs.getInt("TotalCredit");
            return new Object[]{year, semester, totalCredit};
        });
    }

    public List<Course> getCoursesByYearAndSemester(int year, int semester) {
        String sqlStatement = "SELECT * FROM Courses WHERE Course_Year = ? AND Semester = ?";
        return jdbcTemplate.query(sqlStatement, new Object[]{year, semester}, new RowMapper<Course>() {

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
}
