package clientAPI;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


/**
 * @autor : eynar.pari
 * @date : 26/09/2020.
 **/
public class RequestPUT extends RequestClient {
    @Override
    public ResponseInfo send(RequestInfo request) {
        System.out.println("PUT "+request.getUrl());
        System.out.println("body : \n"+request.getBody());

        // si yo quiero cambiar de libreria / framework
        Response response= this.client.target(request.getUrl())
                .request(MediaType.APPLICATION_JSON_TYPE)
                .headers(request.getHeaders())
                .put(Entity.json(request.getBody()));

        ResponseInfo responseInfo = new ResponseInfo(response.readEntity(String.class),
                response.getStatus());

        response.close();
        return responseInfo;
    }
}
