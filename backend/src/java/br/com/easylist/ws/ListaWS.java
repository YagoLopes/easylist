/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easylist.ws;

import br.com.easylist.daos.ListaDAO;
import br.com.easylist.entidades.Lista;
import java.sql.SQLException;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("lista")
public class ListaWS {

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response create(@FormParam("nome") String nome, @FormParam("usuarioID") String usuarioID) {
        try {
            //validar campos obrigatórios
            if (nome.isEmpty()) {
                return Response.status(Status.BAD_REQUEST).header("Access-Control-Allow-Origin", "*").encoding("Parâmetros incorretos!").build();//CORS 
            }
            //persistir os dados
            Lista lista = new Lista();
            lista.setNome(nome);
            lista.setUsuarioID(Integer.parseInt(usuarioID));
            lista.setInativo(false);
            ListaDAO listaDAO = new ListaDAO();
            if (listaDAO.save(lista) != 0) {
                return Response.status(Status.OK).header("Access-Control-Allow-Origin", "*").build();//CORS 
            } else {
                return Response.status(Status.INTERNAL_SERVER_ERROR).build();
            }
        } catch (SQLException ex) {
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response create(Lista lista) {
        try {
            //validar campos obrigatórios
            //persistir os dados
            ListaDAO listaDAO = new ListaDAO();
            if (listaDAO.save(lista) != 0) {
                return Response.status(Status.OK).entity(lista).build();
            } else {
                return Response.status(Status.INTERNAL_SERVER_ERROR).build();
            }
        } catch (SQLException ex) {
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    
    @GET
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("{id}")
    public Response read(@PathParam("id") int id) {
        try {
            ListaDAO listaDAO = new ListaDAO();
            Lista lista = null;
            if ((lista = listaDAO.select(id)) != null) {
                return Response.status(Status.OK).entity(lista).build();
            } else {
                return Response.status(Status.NOT_FOUND).build();
            }
        } catch (SQLException ex) {
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response reads(@QueryParam("nome") String nome) {
            try {
            ListaDAO listaDAO = new ListaDAO();
            List<Lista> listas = listaDAO.selects(nome);
            //GenericEntity<List<Lista>> entity = new GenericEntity<List<Lista>>(listas) {};
            return Response.status(Status.OK).header("Access-Control-Allow-Origin", "*").entity(listas).build();
        } catch (SQLException ex) {
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
        
    }

    @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("{id}")
    public Response update(@PathParam("id") int id,Lista lista) {
        try {
            lista.setId(id);
            ListaDAO listaDAO = new ListaDAO();
            if (listaDAO.update(lista) != 0) {
                return Response.status(Status.OK).entity(lista).build();
            } else {
                return Response.status(Status.NOT_FOUND).build();
            }
        } catch (SQLException ex) {
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
    }
@DELETE
    @Produces({MediaType.APPLICATION_JSON})
    @Path("{id}")
    public Response delete(@PathParam("id") int id) {
        try {
            ListaDAO listaDAO = new ListaDAO();
            Lista lista = null;
            if ((lista = listaDAO.delete(id)) == null) {
                return Response.status(Status.OK).entity(lista).build();
            } else {
                return Response.status(Status.NOT_FOUND).build();
            }
        } catch (SQLException ex) {
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    
    /*
    @Controller
@Path("arquivo")
public class ArquivoController {
 
  @Post
  public void upload(UploadedFile upload) {
    Arquivo arquivo = new Arquivo();
    arquivo.upload("/home/matheus/arquivos", upload.getFileName(),
      upload.getFile());
  }
 
}
*/
 
}
