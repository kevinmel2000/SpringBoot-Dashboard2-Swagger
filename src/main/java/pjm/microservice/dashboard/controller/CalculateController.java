package pjm.microservice.dashboard.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pjm.microservice.dashboard.config.Constant;
import pjm.microservice.dashboard.model.Result;
import pjm.microservice.dashboard.model.calculate.CalculateTenor;
import pjm.microservice.dashboard.service.CalculateService;
import pjm.microservice.dashboard.util.SharedMethod;

@RestController
@RequestMapping("/calculate")
public class CalculateController {
    Logger log = LoggerFactory.getLogger(CalculateController.class);


    @Autowired
    private CalculateService calculateService;

    @PostMapping("/tenor")
    public ResponseEntity<Result<String>> calculateTenor(
            @RequestBody CalculateTenor calculateTenor
    ) {
        try {
//            List<ClosingHistory> list = calculateService.calculateTenor(startDate, endDate);

//            ObjectMapper objectMapper = new ObjectMapper();
//            CalculateTenor calculateTenor = objectMapper.readValue(stringInput, CalculateTenor.class);
            String list = calculateService.calculateTenor(calculateTenor);
            return SharedMethod.getResponse(HttpStatus.OK, Constant.STATUS_SUCCESS_MSG, list); // getFirst untuk sementara
        } catch (Exception e) {
            return SharedMethod.getResponse(HttpStatus.BAD_REQUEST, e.getMessage(), null);
        }
    }


}
