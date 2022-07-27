package com.example.demo2.Controller;

import com.example.demo2.Entity.Employee;
import com.example.demo2.Repoasitory.EmployeeRepository;
import com.example.demo2.Service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;

@SpringBootTest
@AutoConfigureMockMvc
class EmployeeControllerTest {

    @Autowired
    private MockMvc client;

    @Autowired
    private EmployeeService employeeService;

    @BeforeEach
    void setUp() {
        employeeService.clear();
    }

    @Test
    void should_get_all_employees_when_call_get_all_api_given_service() throws Exception {
        //given
        employeeService.insert(new Employee(1, "Susan", "F", 22, 7500));

        //when
        //then
        client.perform(MockMvcRequestBuilders.get("/employees"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").isNumber())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("Susan"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].age").value(22))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].gender").value("F"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].salary").value(7500));

    }


    @Test
    void should_create_an_employee_when_call_create_employee_api_given_service() throws Exception {
        //given
        Employee employee = new Employee(5,"Lily","F", 22, 7500);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(employee);

        //when
        //then

        client.perform(MockMvcRequestBuilders.post("/employees")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Lily"));

        List<Employee> employees = employeeService.findAll();
        assertEquals(employees.get(0).getName(), "Lily");
    }

    @Test
    void should_get_employee_when_call_get_by_id_given_employeeId() throws Exception {
        //given
        employeeService.insert(new Employee(1, "Susan", "F", 22, 7500));
        int employeeId = 1;

        //when
        //then
        client.perform(MockMvcRequestBuilders.get("/employees/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Susan"));
    }
}