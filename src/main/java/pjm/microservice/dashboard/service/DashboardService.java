package pjm.microservice.dashboard.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Service;
import pjm.microservice.dashboard.common.DashboardException;
import pjm.microservice.dashboard.manager.DashboardMgr;
import pjm.microservice.dashboard.model.Dashboard;
import pjm.microservice.dashboard.model.Product;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class DashboardService implements DashboardMgr {
    private static Logger log = LoggerFactory.getLogger(DashboardService.class);

//    @Autowired
//    private DataSource dataSource;

    private DataSource bsiMitraGunaDataSource;
    private DataSource masterDataSource;

    @Autowired
    public void ProductService(
            @Qualifier("bsiMitraGunaDataSource") DataSource bsiMitraGunaDataSource,
            @Qualifier("masterDataSource") DataSource masterDataSource) {
        this.bsiMitraGunaDataSource = bsiMitraGunaDataSource;
        this.masterDataSource = masterDataSource;
    }

    @Override
    public List<Dashboard> getListDashboard() throws DashboardException {
        String query = "SELECT * FROM get_product_cob_premi();";

        List<Dashboard> rows = new ArrayList<>();
        try (Connection con = DataSourceUtils.getConnection(bsiMitraGunaDataSource);
             CallableStatement cs = con.prepareCall(query);
             ResultSet rs = cs.executeQuery()) {

            while (rs.next()) {
                Dashboard list = new Dashboard();

                list.setCobName(rs.getString("cob_name"));
                list.setNamaManfaat(rs.getString("nama_manfaat"));
                list.setProductName(rs.getString("nama_produk"));
                list.setTotalPremi(rs.getBigDecimal("total_premi"));
//                list.setRealizationThisMonthLastYear(rs.getBigDecimal("premi"));
//                list.setRealizationLastMonthLastYear(rs.getBigDecimal("premi"));
                rows.add(list);
            }
        } catch (SQLException e) {
            log.error("SQL Exception: ", e);
            throw new DashboardException("Database error: " + e.getMessage());
        } catch (Exception e) {
            log.error("Exception: ", e);
            throw new DashboardException("Unexpected error: " + e.getMessage());
        }

        return rows;
    }

    public List<Dashboard> getListDashboard(Integer year, Integer month) throws DashboardException {
        String query = "SELECT c_id, premi FROM public.tm_penutupan";

        log.debug(month.toString());
        log.debug(year.toString());

        List<Dashboard> rows = new ArrayList<>();
//        try (Connection con = bsiMitraGunaDataSource.getConnection();
//             CallableStatement cs = con.prepareCall(query);
//             ResultSet rs = cs.executeQuery()) {
//
//            while (rs.next()) {
//                Dashboard list = new Dashboard();
//
//                list.setId(Integer.valueOf(rs.getInt("c_id")));
//                list.setRealizationThisMonth(rs.getBigDecimal("premi"));
//                list.setRealizationLastMonth(rs.getBigDecimal("premi"));
//                list.setRealizationThisMonthLastYear(rs.getBigDecimal("premi"));
//                list.setRealizationLastMonthLastYear(rs.getBigDecimal("premi"));
//                rows.add(list);
//            }
//        } catch (SQLException e) {
//            log.error("SQL Exception: ", e);
//            throw new DashboardException("Database error: " + e.getMessage());
//        } catch (Exception e) {
//            log.error("Exception: ", e);
//            throw new DashboardException("Unexpected error: " + e.getMessage());
//        }

        return rows;
    }

    public List<Product> getListProduct() throws DashboardException {
        String query = "SELECT * FROM tm_product;";

        List<Product> rows = new ArrayList<>();
        try (Connection con = DataSourceUtils.getConnection(masterDataSource);
             CallableStatement cs = con.prepareCall(query);
             ResultSet rs = cs.executeQuery()) {

            while (rs.next()) {
                Product list = new Product();

                list.setProductName(rs.getString("product_name"));
                rows.add(list);
            }
        } catch (SQLException e) {
            log.error("SQL Exception: ", e);
            throw new DashboardException("Database error: " + e.getMessage());
        } catch (Exception e) {
            log.error("Exception: ", e);
            throw new DashboardException("Unexpected error: " + e.getMessage());
        }


        return rows;
    }

}
