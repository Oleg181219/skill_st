
import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;
import beans.Course;
import beans.Student;
import lombok.AllArgsConstructor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@AllArgsConstructor
public class CsvReader {

    private final File sourceCsvFile;
    private final CsvToBean csv = new CsvToBean();

    private static ColumnPositionMappingStrategy setColumMapping() {
        ColumnPositionMappingStrategy<Student> strategy = new ColumnPositionMappingStrategy<Student>();
        strategy.setType(Student.class);
        String[] columns = new String[]{"name", "age", "courses"};
        strategy.setColumnMapping(columns);
        return strategy;
    }


    public List<Student> createStudentList() throws FileNotFoundException {

        CSVReader csvFileReader = new CSVReader(new BufferedReader(new FileReader(sourceCsvFile)));
        List<Student> stList = csv.parse(setColumMapping(), csvFileReader);
        stList.forEach(student -> student.setCourseList(
                Arrays.stream(student.getCourses().split(",")).map(Course ::new).collect(Collectors.toList()))
        );
        return stList;
    }
}
