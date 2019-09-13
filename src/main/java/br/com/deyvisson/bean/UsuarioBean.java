package br.com.deyvisson.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.deyvisson.dao.PessoaDAO;
import br.com.deyvisson.dao.UsuarioDAO;
import br.com.deyvisson.domain.Pessoa;
import br.com.deyvisson.domain.Usuario;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class UsuarioBean implements Serializable {

	private Usuario usuario;

	private List<Usuario> usuarios;
	private List<Pessoa> pessoas;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	@PostConstruct
	public void listar() {

		try {
			UsuarioDAO dao = new UsuarioDAO();
			usuarios = dao.listar();

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao tentar listar os Usuarios");
			erro.printStackTrace();
		}

	}

	public void novo() {

		try {

			usuario = new Usuario();
			PessoaDAO dao = new PessoaDAO();
			pessoas = dao.listar();

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao tentar Iniciar um Usuario");
			erro.printStackTrace();
		}

	}

	public void salvar() {

		try {

			UsuarioDAO dao = new UsuarioDAO();
			dao.merge(usuario);

			novo();

			usuarios = dao.listar();

			Messages.addGlobalInfo("Usuario Cadastrado com Sucesso");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao tentar Salvar o Usuario");
			erro.printStackTrace();
		}

	}

	public void editar(ActionEvent evento) {

		try {

			usuario = (Usuario) evento.getComponent().getAttributes().get("usuarioSelecionadoEditar");

			PessoaDAO dao = new PessoaDAO();
			pessoas = dao.listar();
			
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar Editar um Cliente");
			erro.printStackTrace();
		}

	}

	public void excluir(ActionEvent evento) {

		try {
			usuario = (Usuario) evento.getComponent().getAttributes().get("usuarioSelecionadoExcluir");

			UsuarioDAO dao = new UsuarioDAO();
			dao.excluir(usuario);

			usuarios = dao.listar();

			Messages.addGlobalInfo("Usuario excluido com sucesso");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar Editar um Cliente");
			erro.printStackTrace();
		}

	}

}
