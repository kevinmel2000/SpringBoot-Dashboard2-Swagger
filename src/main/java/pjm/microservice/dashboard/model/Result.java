package pjm.microservice.dashboard.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import java.io.Serializable;

@JsonRootName("result")
@JsonInclude(JsonInclude.Include.NON_NULL)
@jakarta.xml.bind.annotation.XmlSeeAlso({Response.class})
public class Result<E> implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonProperty("response")
    private Response<E> response;

    @JsonProperty("response2")
    private String response2;

    @JsonProperty("metadata")
    private Metadata metadata;

    public Response<E> getResponse() {
        return response;
    }

    public void setResponse(Response<E> response) {
        this.response = response;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    public String getResponse2() {
        return response2;
    }

    public void setResponse2(String response2) {
        this.response2 = response2;
    }

}
