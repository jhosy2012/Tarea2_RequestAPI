package clientAPI;

public class FactoryRequest {
    public static RequestClient make(String type){
        RequestClient client;
        switch (type){

            case "get":
                client= new RequestGET();
                break;
            case "post":
                client= new RequestPOST();
                break;
           case "put":
                client= new RequestPUT();
                break;
            case "delete":
                client= new RequestDELETE();
                break;
            default:
                client= new RequestGET();
                break;

        }
        return client;
    }
}
