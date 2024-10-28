package pjm.microservice.dashboard.service;

import org.springframework.stereotype.Service;
import pjm.microservice.dashboard.common.DashboardException;
import pjm.microservice.dashboard.manager.CalculateMgr;
import pjm.microservice.dashboard.model.calculate.CalculateTenor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

@Service
public class CalculateService implements CalculateMgr {
    public String calculateTenor(CalculateTenor calculateTenor) throws DashboardException {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate startDateLocal = LocalDate.parse(calculateTenor.getStartDate(), formatter);
        LocalDate endDateLocal = LocalDate.parse(calculateTenor.getEndDate(), formatter);

        long yearsTenor = ChronoUnit.YEARS.between(startDateLocal, endDateLocal);
        long monthsTenor = ChronoUnit.MONTHS.between(startDateLocal.plusYears(yearsTenor), endDateLocal);
        long daysTenor = ChronoUnit.DAYS.between(startDateLocal.plusYears(yearsTenor).plusMonths(monthsTenor), endDateLocal);

        long tenorMonth = (yearsTenor * 12) + monthsTenor;
        long tenorMonthBef = tenorMonth;

        boolean round = false;
        if (daysTenor < 14 && monthsTenor <= 0) {
            round = true;
        }

        if (daysTenor > 14) {
            monthsTenor += 1;
            tenorMonthBef += 1;
        }

        boolean notValidYears = false;

        if (yearsTenor > 0) {
            if (monthsTenor > 0) {
                round = false;
            } else {
                round = true;
            }
        } else {
            round = true;
            notValidYears = true;
            yearsTenor = 1;
        }

//        String tenorBulan = tenorMonthBef + " ( " + tenorMonth + " Bulan " + daysTenor + " Hari )";

        return tenorMonthBef + " ( " + tenorMonth + " Bulan " + daysTenor + " Hari )";
    }
}
