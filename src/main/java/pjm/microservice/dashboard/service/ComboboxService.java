package pjm.microservice.dashboard.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Service;
import pjm.microservice.dashboard.common.DashboardException;
import pjm.microservice.dashboard.manager.ComboboxMgr;
import pjm.microservice.dashboard.model.combobox.*;

import javax.sql.DataSource;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ComboboxService implements ComboboxMgr {
    private static Logger log = LoggerFactory.getLogger(ComboboxService.class);

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
    public List<ComboboxInsurance> getListComboboxInsurance() throws DashboardException {
        String query = "SELECT c_id, alias FROM tm_asuransi;";

        List<ComboboxInsurance> rows = new ArrayList<>();
        try (Connection con = DataSourceUtils.getConnection(bsiMitraGunaDataSource);
             CallableStatement cs = con.prepareCall(query);
             ResultSet rs = cs.executeQuery()) {

            while (rs.next()) {
                ComboboxInsurance list = new ComboboxInsurance();

                list.setId(rs.getInt("c_id"));
                list.setName(rs.getString("alias"));
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

    @Override
    public List<ComboboxBenefitType> getListComboboxBenefitType() throws DashboardException {
        String query = "SELECT c_id, nama FROM tm_type_manfaat WHERE status = 1;";

        List<ComboboxBenefitType> rows = new ArrayList<>();
        try (Connection con = DataSourceUtils.getConnection(bsiMitraGunaDataSource);
             CallableStatement cs = con.prepareCall(query);
             ResultSet rs = cs.executeQuery()) {

            while (rs.next()) {
                ComboboxBenefitType list = new ComboboxBenefitType();

                list.setId(rs.getInt("c_id"));
                list.setName(rs.getString("nama"));
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

    @Override
    public List<ComboboxBenefitType> getListComboboxBenefitTypeByInsuranceProduct(Integer insuranceId, Integer productId)
            throws DashboardException {
        String query = "SELECT b.c_id, b.nama " +
                " FROM tm_type_manfaat_setting a" +
                " LEFT JOIN tm_type_manfaat b ON b.c_id = a.id_type_manfaat" +
                " WHERE a.status = '1' AND a.id_asuransi = ? AND a.id_produk = ?" +
                " GROUP BY" +
                "   b.c_id," +
                "   b.nama" +
                " ORDER BY " +
                "   b.nama ASC";

        List<ComboboxBenefitType> rows = new ArrayList<>();

        try {
            Connection con = DataSourceUtils.getConnection(bsiMitraGunaDataSource);
            CallableStatement cs = con.prepareCall(query);
            cs.setInt(1, insuranceId); // Asuransi
            cs.setInt(2, productId); // Asuransi
            ResultSet rs = cs.executeQuery();

            while (rs.next()) {
                ComboboxBenefitType list = new ComboboxBenefitType();

                list.setId(rs.getInt("c_id"));
                list.setName(rs.getString("nama"));
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

    @Override
    public List<ComboboxCoverageType> getListComboboxCoverageType() throws DashboardException {
        String query = "SELECT * FROM tm_type_coverage WHERE status = 1;";

        List<ComboboxCoverageType> rows = new ArrayList<>();
        try (Connection con = DataSourceUtils.getConnection(bsiMitraGunaDataSource);
             CallableStatement cs = con.prepareCall(query);
             ResultSet rs = cs.executeQuery()) {

            while (rs.next()) {
                ComboboxCoverageType list = new ComboboxCoverageType();

                list.setId(rs.getInt("c_id"));
                list.setName(rs.getString("nama"));
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

    public List<ComboboxProduct> getListComboboxProduct() throws DashboardException {
        String query = "SELECT nama_produk, c_id FROM tm_product_list WHERE status = 1;";

        List<ComboboxProduct> rows = new ArrayList<>();
        try {
            Connection con = DataSourceUtils.getConnection(bsiMitraGunaDataSource);
            CallableStatement cs = con.prepareCall(query);
            ResultSet rs = cs.executeQuery();

            while (rs.next()) {
                ComboboxProduct list = new ComboboxProduct();

                list.setId(rs.getInt("c_id"));
                list.setName(rs.getString("nama_produk"));
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

    public List<ComboboxProduct> getListComboboxProductByInsurance(Integer insuranceId) throws DashboardException {
        String query = "SELECT b.c_id, b.nama_produk \n" +
                " FROM tm_type_manfaat_setting a\n" +
                " LEFT JOIN tm_product_list b ON b.c_id = a.id_produk\n" +
                " WHERE a.status = '1' AND a.id_asuransi = ?\n" +
                " GROUP BY\n" +
                "   b.c_id,\n" +
                "   b.nama_produk\n" +
                " ORDER BY \n" +
                "   b.nama_produk ASC;";

        List<ComboboxProduct> rows = new ArrayList<>();
        try {
            Connection con = DataSourceUtils.getConnection(bsiMitraGunaDataSource);
            CallableStatement cs = con.prepareCall(query);
            cs.setInt(1, insuranceId);
            ResultSet rs = cs.executeQuery();

            while (rs.next()) {
                ComboboxProduct list = new ComboboxProduct();

                list.setId(rs.getInt("c_id"));
                list.setName(rs.getString("nama_produk"));
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

    public List<ComboboxProductType> getListComboboxProductTypeById(Integer productId) throws DashboardException {
        String query = "SELECT  c_id, nama FROM tm_product_type WHERE status = 1 AND id_produk = ?;";

        List<ComboboxProductType> rows = new ArrayList<>();
        try {
            Connection con = DataSourceUtils.getConnection(bsiMitraGunaDataSource);
            CallableStatement cs = con.prepareCall(query);
            cs.setInt(1, productId);
            ResultSet rs = cs.executeQuery();

            while (rs.next()) {
                ComboboxProductType list = new ComboboxProductType();

                list.setId(rs.getInt("c_id"));
                list.setName(rs.getString("nama"));
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

    public List<ComboboxAkadType> getListComboboxAkadType() throws DashboardException {
        String query = "SELECT c_id, nama FROM tm_jenis_akad;";

        List<ComboboxAkadType> rows = new ArrayList<>();
        try {
            Connection con = DataSourceUtils.getConnection(bsiMitraGunaDataSource);
            CallableStatement cs = con.prepareCall(query);
            ResultSet rs = cs.executeQuery();

            while (rs.next()) {
                ComboboxAkadType list = new ComboboxAkadType();

                list.setId(rs.getInt("c_id"));
                list.setName(rs.getString("nama"));
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

    //    Belum ditambah flagging user login
    public List<ComboboxBranch> getListComboboxBranch() throws DashboardException {
        String query = "SELECT * FROM tm_cabang where status = 1 and c_type = 'AREA';";

        List<ComboboxBranch> rows = new ArrayList<>();
        try {
            Connection con = DataSourceUtils.getConnection(bsiMitraGunaDataSource);
            CallableStatement cs = con.prepareCall(query);
            ResultSet rs = cs.executeQuery();

            while (rs.next()) {
                ComboboxBranch list = new ComboboxBranch();

                list.setId(rs.getInt("c_id"));
                list.setName(rs.getString("nama"));
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

    public List<ComboboxArea> getListComboboxArea() throws DashboardException {
        String query = "SELECT * FROM tm_cabang where status = 1 and c_type = 'AREA';";

        List<ComboboxArea> rows = new ArrayList<>();
        try {
            Connection con = DataSourceUtils.getConnection(bsiMitraGunaDataSource);
            CallableStatement cs = con.prepareCall(query);
            ResultSet rs = cs.executeQuery();

            while (rs.next()) {
                ComboboxArea list = new ComboboxArea();

                list.setId(rs.getInt("c_id"));
                list.setName(rs.getString("nama"));
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

    public List<ComboboxJobType> getListComboboxJobTypeByProduct(Integer productId) throws DashboardException {
        String query = "SELECT c_id, nama FROM tm_jenis_pekerjaan WHERE id_produk = ? AND status = 1 ORDER BY nama ASC;";

        List<ComboboxJobType> rows = new ArrayList<>();
        try {
            Connection con = DataSourceUtils.getConnection(bsiMitraGunaDataSource);
            CallableStatement cs = con.prepareCall(query);
            cs.setInt(1, productId);
            ResultSet rs = cs.executeQuery();

            while (rs.next()) {
                ComboboxJobType list = new ComboboxJobType();

                list.setId(rs.getInt("c_id"));
                list.setName(rs.getString("nama"));
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
