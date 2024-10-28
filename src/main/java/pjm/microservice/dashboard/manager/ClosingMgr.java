package pjm.microservice.dashboard.manager;

import pjm.microservice.dashboard.common.DashboardException;
import pjm.microservice.dashboard.model.closing.ClosingHistory;
import pjm.microservice.dashboard.model.combobox.*;

import java.util.List;

public interface ClosingMgr {
    public List<ClosingHistory> getListClosingHistory(String appId) throws DashboardException;
}
