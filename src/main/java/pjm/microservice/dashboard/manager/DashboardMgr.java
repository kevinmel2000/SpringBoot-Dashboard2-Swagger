package pjm.microservice.dashboard.manager;

import pjm.microservice.dashboard.common.DashboardException;
import pjm.microservice.dashboard.model.Dashboard;

import java.util.List;

public interface DashboardMgr {
    public List<Dashboard> getListDashboard() throws DashboardException;
    public List<Dashboard> getListDashboard(Integer year, Integer month) throws DashboardException;
}
