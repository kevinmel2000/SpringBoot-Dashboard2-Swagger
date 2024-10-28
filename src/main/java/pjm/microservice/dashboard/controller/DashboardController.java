package pjm.microservice.dashboard.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pjm.microservice.dashboard.common.DashboardException;
import pjm.microservice.dashboard.config.Constant;
import pjm.microservice.dashboard.model.Dashboard;
import pjm.microservice.dashboard.model.Product;
import pjm.microservice.dashboard.model.Response;
import pjm.microservice.dashboard.model.Result;
import pjm.microservice.dashboard.service.DashboardService;
import pjm.microservice.dashboard.util.SharedMethod;

import java.util.List;

@RestController
@RequestMapping("api/dashboard")
public class DashboardController {
    @Autowired
    private DashboardService dashboardService;

    private Logger log = LoggerFactory.getLogger(DashboardController.class);

    @GetMapping("")
    ResponseEntity<Result<Dashboard>> getListDashboard()  {
        try {
            List<Dashboard> list = dashboardService.getListDashboard();
            log.info(list.toString());
            return SharedMethod.getResponse(HttpStatus.OK, Constant.STATUS_SUCCESS_MSG, list);
        }catch (Exception e){
            return  SharedMethod.getResponse(HttpStatus.BAD_REQUEST,e.getMessage(), null);
        }
    }

    @GetMapping("/{year}/{month}")
    ResponseEntity<Result<Dashboard>> getListDashboard(@PathVariable(required = false) Integer year,
                                                       @PathVariable(required = false) Integer month)  {
        try {
            List<Dashboard> list = dashboardService.getListDashboard(year, month);
            log.info(list.toString());
            return SharedMethod.getResponse(HttpStatus.OK, Constant.STATUS_SUCCESS_MSG, list);
        }catch (Exception e){
            return  SharedMethod.getResponse(HttpStatus.BAD_REQUEST,e.getMessage(), null);
        }
    }

    @GetMapping("/product")
    ResponseEntity<Result<Product>> getListProduct()  {
        try {
            List<Product> list = dashboardService.getListProduct();
            log.info(list.toString());
            return SharedMethod.getResponse(HttpStatus.OK, Constant.STATUS_SUCCESS_MSG, list);
        }catch (Exception e){
            return  SharedMethod.getResponse(HttpStatus.BAD_REQUEST,e.getMessage(), null);
        }
    }
}
