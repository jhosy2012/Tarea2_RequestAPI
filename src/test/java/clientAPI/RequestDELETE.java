package clientAPI;


import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


/**
 * @autor : eynar.pari
 * @date : 26/09/2020.
 **/
public class RequestDELETE extends RequestClient {
    @Override
    public ResponseInfo send(RequestInfo request) {
        System.out.println("DELETE "+request.getUrl());

        Response response= this.client.target(request.getUrl())
                .request(MediaType.APPLICATION_JSON_TYPE)
                .headers(request.getHeaders())
                .delete();

        ResponseInfo responseInfo = new ResponseInfo(response.readEntity(String.class),
                response.getStatus());

        response.close();
        return responseInfo;
    }
}

