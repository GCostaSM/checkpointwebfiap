package br.com.checkpoint.checkpointFiap;

import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@ManagedBean
public class UsuarioCheckpointManager {
		
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<UsuarioCheckpoint> loadAllUsers() {
        return this.entityManager.createQuery("SELECT u FROM usuario_checkpoint u", UsuarioCheckpoint.class).getResultList();
    }
	
	public void novoUsuario(UsuarioCheckpoint usuario) {
		UsuarioCheckpoint usuariocheck = new UsuarioCheckpoint();
		usuariocheck.setDataNascimento("teste");
		usuariocheck.setEmail("teste");
		usuariocheck.setNome("Nome");
		usuariocheck.setSenha("senha");
		this.entityManager.persist(usuariocheck);
		this.entityManager.flush();
		this.entityManager.getTransaction().commit();
	}
}
