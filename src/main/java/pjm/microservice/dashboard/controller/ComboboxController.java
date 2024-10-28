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
import pjm.microservice.dashboard.model.combobox.*;
import pjm.microservice.dashboard.service.ComboboxService;
import pjm.microservice.dashboard.util.SharedMethod;

import javax.ws.rs.Path;
import java.util.List;

@RestController
@RequestMapping("/combobox")
public class ComboboxController {
    Logger log = LoggerFactory.getLogger(ComboboxController.class);


    @Autowired
    private ComboboxService comboboxService;

    @GetMapping("/insurance")
    ResponseEntity<Result<ComboboxInsurance>> getListComboboxInsurance() {
        try {
            List<ComboboxInsurance> list = comboboxService.getListComboboxInsurance();
            return SharedMethod.getResponse(HttpStatus.OK, Constant.STATUS_SUCCESS_MSG, list);
        } catch (Exception e) {
            return SharedMethod.getResponse(HttpStatus.BAD_REQUEST, e.getMessage(), null);
        }
    }


    @GetMapping("/benefit-type")
    ResponseEntity<Result<ComboboxBenefitType>> getListComboboxBenefitType() {
        try {
            List<ComboboxBenefitType> list = comboboxService.getListComboboxBenefitType();
            return SharedMethod.getResponse(HttpStatus.OK, Constant.STATUS_SUCCESS_MSG, list);
        } catch (Exception e) {
            return SharedMethod.getResponse(HttpStatus.BAD_REQUEST, e.getMessage(), null);
        }
    }

    @GetMapping("/benefit-type/{insuranceId}/{productId}")
    ResponseEntity<Result<ComboboxBenefitType>> getListComboboxBenefitTypeByInsuranceProduct(
            @PathVariable Integer insuranceId,
            @PathVariable Integer productId
    ) {
        try {
            List<ComboboxBenefitType> list = comboboxService
                    .getListComboboxBenefitTypeByInsuranceProduct(insuranceId, productId);
            return SharedMethod.getResponse(HttpStatus.OK, Constant.STATUS_SUCCESS_MSG, list);
        } catch (Exception e) {
            return SharedMethod.getResponse(HttpStatus.BAD_REQUEST, e.getMessage(), null);
        }
    }

    @GetMapping("/coverage-type")
    ResponseEntity<Result<ComboboxCoverageType>> getListComboboxCoverageType() {
        try {
            List<ComboboxCoverageType> list = comboboxService.getListComboboxCoverageType();
            return SharedMethod.getResponse(HttpStatus.OK, Constant.STATUS_SUCCESS_MSG, list);
        } catch (Exception e) {
            return SharedMethod.getResponse(HttpStatus.BAD_REQUEST, e.getMessage(), null);
        }
    }

    @GetMapping("/product")
    ResponseEntity<Result<ComboboxProduct>> getListComboboxProduct() {
        try {
            List<ComboboxProduct> list = comboboxService.getListComboboxProduct();
            return SharedMethod.getResponse(HttpStatus.OK, Constant.STATUS_SUCCESS_MSG, list);
        } catch (Exception e) {
            return SharedMethod.getResponse(HttpStatus.BAD_REQUEST, e.getMessage(), null);
        }
    }

    @GetMapping("/product/{insuranceId}")
    ResponseEntity<Result<ComboboxProduct>> getListComboboxProductByInsurance(@PathVariable Integer insuranceId) {
        try {
            List<ComboboxProduct> list = comboboxService.getListComboboxProductByInsurance(insuranceId);
            return SharedMethod.getResponse(HttpStatus.OK, Constant.STATUS_SUCCESS_MSG, list);
        } catch (Exception e) {
            return SharedMethod.getResponse(HttpStatus.BAD_REQUEST, e.getMessage(), null);
        }
    }

    @GetMapping("/product-type/{productId}")
    ResponseEntity<Result<ComboboxProductType>> getListComboboxProductTypeById(@PathVariable Integer productId) {
        try {
            List<ComboboxProductType> list = comboboxService.getListComboboxProductTypeById(productId);
            return SharedMethod.getResponse(HttpStatus.OK, Constant.STATUS_SUCCESS_MSG, list);
        } catch (Exception e) {
            return SharedMethod.getResponse(HttpStatus.BAD_REQUEST, e.getMessage(), null);
        }
    }

    @GetMapping("/akad-type")
    ResponseEntity<Result<ComboboxAkadType>> getListComboboxAkadType() {
        try {
            List<ComboboxAkadType> list = comboboxService.getListComboboxAkadType();
            return SharedMethod.getResponse(HttpStatus.OK, Constant.STATUS_SUCCESS_MSG, list);
        } catch (Exception e) {
            return SharedMethod.getResponse(HttpStatus.BAD_REQUEST, e.getMessage(), null);
        }
    }

    @GetMapping("/branch")
    ResponseEntity<Result<ComboboxBranch>> getListComboboxBranch() {
        try {
            List<ComboboxBranch> list = comboboxService.getListComboboxBranch();
            return SharedMethod.getResponse(HttpStatus.OK, Constant.STATUS_SUCCESS_MSG, list);
        } catch (Exception e) {
            return SharedMethod.getResponse(HttpStatus.BAD_REQUEST, e.getMessage(), null);
        }
    }

    @GetMapping("/area")
    ResponseEntity<Result<ComboboxArea>> getListComboboxArea() {
        try {
            List<ComboboxArea> list = comboboxService.getListComboboxArea();
            return SharedMethod.getResponse(HttpStatus.OK, Constant.STATUS_SUCCESS_MSG, list);
        } catch (Exception e) {
            return SharedMethod.getResponse(HttpStatus.BAD_REQUEST, e.getMessage(), null);
        }
    }

    @GetMapping("/job-type/{productId}")
    ResponseEntity<Result<ComboboxJobType>> getListComboboxJobTypeByProduct(@PathVariable Integer productId) {
        try {
            List<ComboboxJobType> list = comboboxService.getListComboboxJobTypeByProduct(productId);
            return SharedMethod.getResponse(HttpStatus.OK, Constant.STATUS_SUCCESS_MSG, list);
        } catch (Exception e) {
            return SharedMethod.getResponse(HttpStatus.BAD_REQUEST, e.getMessage(), null);
        }
    }
}
