package entity;

import javax.persistence.Entity;
import java.util.Objects;

@Entity
public class Currency {

    private String code;
    private String country;

    public Currency() {
    }

    public Currency(String code) {
        this.code = code;
    }

    

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Currency currency = (Currency) o;
        return Objects.equals(code, currency.code) &&
                Objects.equals(country, currency.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, country);
    }
}
