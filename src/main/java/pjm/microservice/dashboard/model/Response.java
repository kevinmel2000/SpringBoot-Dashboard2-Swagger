package pjm.microservice.dashboard.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import java.io.Serializable;
import java.util.List;

@JsonRootName("response")
@JsonInclude(Include.NON_NULL)
public class Response<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("data")
    private T data;

    @JsonProperty("list")
    private List<T> list;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> listdata) {
        this.list = listdata;
    }
}
