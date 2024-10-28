package pjm.microservice.dashboard.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Service;
import pjm.microservice.dashboard.common.DashboardException;
import pjm.microservice.dashboard.manager.ClosingMgr;
import pjm.microservice.dashboard.model.closing.ClosingHistory;
import pjm.microservice.dashboard.model.combobox.ComboboxInsurance;

import javax.sql.DataSource;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ClosingService implements ClosingMgr {
    private static Logger log = LoggerFactory.getLogger(ClosingService.class);

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
    public List<ClosingHistory> getListClosingHistory(String appId) throws DashboardException {
        String query = "SELECT *, tpt.nama as product_type FROM tm_penutupan " +
                "left join public.tm_product_list tpl on tm_penutupan.produk = tpl.c_id " +
                "left join public.tm_product_type tpt on tpl.c_id = tpt.id_produk " +
                "WHERE no_aplikasi = ? " +
                "ORDER BY tm_penutupan.createdon DESC LIMIT 1;";

        List<ClosingHistory> rows = new ArrayList<>();
        try {
            Connection con = DataSourceUtils.getConnection(bsiMitraGunaDataSource);
            CallableStatement cs = con.prepareCall(query);
            cs.setString(1, appId);
            ResultSet rs = cs.executeQuery();

            while (rs.next()) {
                ClosingHistory list = new ClosingHistory();

//                list.setId(rs.getInt("c_id"));
                list.setPolis(rs.getString("polis"));
                list.setCreatedBy(rs.getInt("createdby"));
                list.setApplicationNo(rs.getString("no_aplikasi"));
                list.setReffNumber(rs.getString("reffnumber"));
                list.setName(rs.getString("nama"));
                list.setInsuranceName(rs.getString("nama_asuransi"));
                list.setBranchName(rs.getString("nama_cabang"));
                list.setProductName(rs.getString("nama_produk"));
                list.setProductType(rs.getString("product_type"));
                list.setAttribution(rs.getString("atribusi"));
                list.setTenorMonth(rs.getString("bulan_tenor"));
                list.setPlafond(rs.getBigDecimal("plafond"));
                list.setCoverageFeePartner(rs.getBigDecimal("coverage_fee_mitra"));
                list.setCoverageFeeInsurance(rs.getBigDecimal("coverage_asuransi"));
                list.setCoverageFeePenalty(rs.getBigDecimal("coverage_pinalti"));
                list.setPremi(rs.getBigDecimal("premi"));
                list.setAdminFee(rs.getBigDecimal("biaya_admin"));
                list.setAkadDate(rs.getDate("tanggal_akad"));
                list.setAkadNumber(rs.getString("nomor_akad"));
                list.setDateofBirth(rs.getDate("tanggal_lahir"));
                list.setAgeWhenAkad(rs.getString("usia_saat_akad"));
                list.setAgeAfterAkad(rs.getString("usia_selesai_akad"));
//                list.setName(rs.getString("alias"));
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
