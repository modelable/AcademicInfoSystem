package kr.ac.hansung.cse.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Course {

    @NotNull(message = "The Course_Year cannot be null")
    private Integer courseYear;

    @NotNull(message = "The Semester cannot be null")
    private Integer semester;

    @NotEmpty(message = "The Course_Code cannot be empty")
    @Size(max=45, message = "The Course_Code cannot exceed 45 chars")
    private String courseCode;

    @Size(max=100, message = "The Course_Name cannot exceed 100 chars")
    private String courseName;

    @Size(max=45, message = "The Course_Type cannot exceed 45 chars")
    private String courseType;

    @Size(max=45, message = "The Professor cannot exceed 45 chars")
    private String professor;

    @NotNull(message = "The Credit cannot be null")
    private Integer credit;
}
