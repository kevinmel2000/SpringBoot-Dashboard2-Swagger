package pjm.microservice.dashboard.manager;

import pjm.microservice.dashboard.common.DashboardException;
import pjm.microservice.dashboard.model.combobox.*;

import java.util.List;

public interface ComboboxMgr {
    public List<ComboboxInsurance> getListComboboxInsurance() throws DashboardException;

    public List<ComboboxBenefitType> getListComboboxBenefitType() throws DashboardException;

    public List<ComboboxBenefitType> getListComboboxBenefitTypeByInsuranceProduct(Integer insuranceId, Integer productId) throws DashboardException;

    public List<ComboboxCoverageType> getListComboboxCoverageType() throws DashboardException;

    public List<ComboboxProduct> getListComboboxProduct() throws DashboardException;

    public List<ComboboxProduct> getListComboboxProductByInsurance(Integer insuranceId) throws DashboardException;

    public List<ComboboxProductType> getListComboboxProductTypeById(Integer productId) throws DashboardException;

    public List<ComboboxAkadType> getListComboboxAkadType() throws DashboardException;

    public List<ComboboxJobType> getListComboboxJobTypeByProduct(Integer productId) throws DashboardException;
}
