package _TimeLogV01;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

import service.EmployeService;

public class EmployeServiceTest {

 
	

    @Test // Q15
    public void testConsulterHoraire() {
    	EmployeService employeService = new EmployeService(1); 
        assertDoesNotThrow(() -> employeService.consulterhoraire());
           
}
}
