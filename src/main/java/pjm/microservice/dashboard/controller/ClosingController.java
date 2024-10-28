package pjm.microservice.dashboard.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pjm.microservice.dashboard.config.Constant;
import pjm.microservice.dashboard.model.Result;
import pjm.microservice.dashboard.model.closing.ClosingHistory;
import pjm.microservice.dashboard.model.combobox.*;
import pjm.microservice.dashboard.service.ClosingService;
import pjm.microservice.dashboard.service.ComboboxService;
import pjm.microservice.dashboard.util.SharedMethod;

import java.util.List;

@RestController
@RequestMapping("/closing")
public class ClosingController {
    Logger log = LoggerFactory.getLogger(ClosingController.class);


    @Autowired
    private ClosingService closingService;

    @GetMapping("/history/{appId}")
    ResponseEntity<Result<ClosingHistory>> getListClosingHistoryByAppId(@PathVariable String appId) {
        try {
            List<ClosingHistory> list = closingService.getListClosingHistory(appId);
            return SharedMethod.getResponse(HttpStatus.OK, Constant.STATUS_SUCCESS_MSG, list.getFirst()); // getFirst untuk sementara
        }catch (Exception e){
            return  SharedMethod.getResponse(HttpStatus.BAD_REQUEST,e.getMessage(), null);
        }
    }


}
