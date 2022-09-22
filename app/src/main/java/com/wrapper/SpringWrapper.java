/**
 * Author: Yasushi Oh
 * Email: yoh@ucsd.edu
 * Description: This file wraps around the Spring web framework
 * and passes any called url including the query param, but not the 
 * request body, to the Program Class's handleRequest method. It is 
 * intentionally designed to help the students to avoid Spring specific
 * syntax(such as @decorators) and focus more on writing the logic codes 
 */

package com.wrapper;

//http request handle
import javax.servlet.http.HttpServletRequest;

//packages associated with spring
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//the program class where all the logic codes are written
import com.program.ProgramClass;

//decorators that initializes the springboot application and defines
//a restful api controller
@SpringBootApplication
@RestController
public class SpringWrapper {
    ProgramClass program = new ProgramClass();

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SpringWrapper.class, args);
    }

    @GetMapping("**")
    public Object visit(HttpServletRequest request) throws Exception {
        if (request.getQueryString() == null) {
            return program.handleRequest(
                    request.getRequestURI());
        }
        return program.handleRequest(
                request.getRequestURI() + "?" + request.getQueryString());
    }

}
