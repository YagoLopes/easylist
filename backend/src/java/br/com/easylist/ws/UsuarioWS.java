/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easylist.ws;

import br.com.easylist.daos.UsuarioDAO;
import br.com.easylist.entidades.Usuario;
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

@Path("usuario")
public class UsuarioWS {

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response create(@FormParam("nome") String nome, @FormParam("email") String email, @FormParam("senha") String senha , @FormParam("descricao") String descricao, @FormParam("comprovante") String comprovante) {
        try {
            //validar campos obrigatórios
            if (nome.isEmpty()) {
                return Response.status(Status.BAD_REQUEST).header("Access-Control-Allow-Origin", "*").encoding("Parâmetros incorretos!").build();//CORS 
            }
            //persistir os dados
            Usuario usuario = new Usuario();
            usuario.setNome(nome);
            usuario.setEmail(email);
            usuario.setSenha(senha);
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            if (usuarioDAO.save(usuario) != 0) {
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
    public Response create(Usuario usuario) {
        try {
            //validar campos obrigatórios
            //persistir os dados
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            if (usuarioDAO.save(usuario) != 0) {
                return Response.status(Status.OK).entity(usuario).build();
            } else {
                return Response.status(Status.INTERNAL_SERVER_ERROR).build();
            }
        } catch (SQLException ex) {
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GET
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
    public Response read(@QueryParam("email") String nome, @QueryParam("password") String senha) {        
        try {
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            Usuario usuario = null;
            if ((usuario = usuarioDAO.select(nome, senha)) != null) {
                return Response.status(Status.OK).entity(usuario).build();
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
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            List<Usuario> usuarios = usuarioDAO.selects(nome);
            //GenericEntity<List<Usuario>> entity = new GenericEntity<List<Usuario>>(usuarios) {};
            return Response.status(Status.OK).header("Access-Control-Allow-Origin", "*").entity(usuarios).build();
        } catch (SQLException ex) {
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PUT
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
    @Path("{id}")
    public Response update(@PathParam("id") int id,Usuario usuario) {
        try {
            usuario.setId(id);
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            if (usuarioDAO.update(usuario) != 0) {
                return Response.status(Status.OK).entity(usuario).build();
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
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            Usuario usuario = null;
            if ((usuario = usuarioDAO.delete(id)) == null) {
                return Response.status(Status.OK).entity(usuario).build();
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
