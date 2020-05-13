/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easylist.ws;

import br.com.easylist.daos.ProdutoDAO;
import br.com.easylist.entidades.Lista;
import br.com.easylist.entidades.Produto;
import java.sql.SQLException;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("prodlists")
public class ListaProdWS {
    
    @GET
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response reads(@PathParam("id") int id ) {     
        System.out.println(id);
        try {
            ProdutoDAO produtoDAO = new ProdutoDAO();
            List<Produto> produtos = produtoDAO.selectsProduto(id);
            //GenericEntity<List<Lista>> entity = new GenericEntity<List<Lista>>(listas) {};
            return Response.status(Status.OK).header("Access-Control-Allow-Origin", "*").entity(produtos).build();
        } catch (SQLException ex) {
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
    }
    
}
