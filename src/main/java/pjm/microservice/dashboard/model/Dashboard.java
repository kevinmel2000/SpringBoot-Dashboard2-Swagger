package pjm.microservice.dashboard.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Dashboard {
    private String cobName;
    private String productName;
    private String namaManfaat;
    private BigDecimal totalPremi;

    public String getCobName() {
        return cobName;
    }

    public void setCobName(String cobName) {
        this.cobName = cobName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getNamaManfaat() {
        return namaManfaat;
    }

    public void setNamaManfaat(String namaManfaat) {
        this.namaManfaat = namaManfaat;
    }

    public BigDecimal getTotalPremi() {
        return totalPremi;
    }

    public void setTotalPremi(BigDecimal totalPremi) {
        this.totalPremi = totalPremi;
    }
}
