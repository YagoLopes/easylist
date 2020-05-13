/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easylist.ws;

import br.com.easylist.daos.ProdutoDAO;
import br.com.easylist.entidades.Produto;
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
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("produto")
public class ProdutoWS {

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response create(@FormParam("nome") String nome, @FormParam("valor") String valor, @FormParam("mercado") String mercado , @FormParam("descricao") String descricao, @FormParam("comprovante") String comprovante, @FormParam("listaid") String listaid) {
        try {
            //validar campos obrigatórios
            if (nome.isEmpty()) {
                return Response.status(Status.BAD_REQUEST).header("Access-Control-Allow-Origin", "*").encoding("Parâmetros incorretos!").build();//CORS 
            }
            //persistir os dados
            Produto produto = new Produto();
            produto.setNome(nome);
            produto.setValor(valor);
            produto.setMercado(mercado);
            produto.setDescricao(descricao);
            produto.setComprovante(comprovante);
            produto.setListaID(Integer.parseInt(listaid));
            ProdutoDAO produtoDAO = new ProdutoDAO();
            if (produtoDAO.save(produto) != 0) {
                return Response.status(Status.OK).header("Access-Control-Allow-Origin", "*").build();//CORS 
            } else {
                return Response.status(Status.INTERNAL_SERVER_ERROR).build();
            }
        } catch (SQLException ex) {
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @POST
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
    public Response create(Produto produto) {
        try {
            //validar campos obrigatórios
            //persistir os dados
            ProdutoDAO produtoDAO = new ProdutoDAO();
            if (produtoDAO.save(produto) != 0) {
                return Response.status(Status.OK).entity(produto).build();
            } else {
                return Response.status(Status.INTERNAL_SERVER_ERROR).build();
            }
        } catch (SQLException ex) {
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GET
    @Path("{id}")
    @Produces({ MediaType.APPLICATION_JSON})
    public Response read(@PathParam("id") int id) {
        try {
            ProdutoDAO produtoDAO = new ProdutoDAO();
            Produto produto = null;
            if ((produto = produtoDAO.select(id)) != null) {
                return Response.status(Status.OK).entity(produto).build();
            } else {
                return Response.status(Status.NOT_FOUND).build();
            }
        } catch (SQLException ex) {
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GET
    @Produces({ MediaType.APPLICATION_JSON})
    public Response reads(@QueryParam("nome") String nome) {
        try {
            ProdutoDAO produtoDAO = new ProdutoDAO();
            List<Produto> produtos = produtoDAO.selects(nome);
            //GenericEntity<List<Lista>> entity = new GenericEntity<List<Lista>>(produtos) {};
            return Response.status(Status.OK).header("Access-Control-Allow-Origin", "*").entity(produtos).build();
        } catch (SQLException ex) {
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PUT
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
    @Path("{id}")
    public Response update(@PathParam("id") int id,Produto produto) {
        try {
            produto.setId(id);
            ProdutoDAO produtoDAO = new ProdutoDAO();
            if (produtoDAO.update(produto) != 0) {
                return Response.status(Status.OK).entity(produto).build();
            } else {
                return Response.status(Status.NOT_FOUND).build();
            }
        } catch (SQLException ex) {
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DELETE
    @Produces({ MediaType.APPLICATION_JSON})
    @Path("{id}")
    public Response delete(@PathParam("id") int id) {
        try {
            ProdutoDAO produtoDAO = new ProdutoDAO();
            Produto produto = null;
            if ((produto = produtoDAO.delete(id)) == null) {
                return Response.status(Status.OK).entity(produto).build();
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
