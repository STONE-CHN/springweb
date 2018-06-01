package fansir.me.springweb.showcase.ws;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import fansir.me.springweb.showcase.domain.Product;
import fansir.me.springweb.showcase.service.ProductService;

/**
 * Class Name: RESTSampleService Description: TODO
 * 
 *
 */
public class ProductRestService {
    protected final Logger log = LoggerFactory.getLogger(ProductRestService.class);

    @Autowired
    ProductService productService;

    @GET
    @Path("/product/{productId}")
    @Produces({ "application/json" })
    @Consumes({ "application/json" })
    public Response getProducts(@PathParam("productId") String productId) {
        Product result = productService.findProductById(productId);
        if (result == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        } else {
            return Response.ok(result).build();
        }

    }

}
