package br.ufms.facom.progweb.agenda.model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ContatoGerenciador {
    private List<Contato> contatos;

    public ContatoGerenciador() {
        this.contatos = new ArrayList<>();
    }

    private AtomicInteger idGenerator = new AtomicInteger(0);

    // Método para adicionar um novo contato à lista
    public void salvarContato(Contato contato) {
        contato.setId(idGenerator.incrementAndGet()); // Atribui um ID único
        contatos.add(contato);
    }

    // Método para listar todos os contatos
    public List<Contato> listarContatos() {
        return contatos;
    }

    // Método para editar um contato existente pelo índice
    public boolean editarContato(int index, String nome, String email, String telefone) {
        if (index >= 0 && index < contatos.size()) {
            Contato contato = contatos.get(index);
            contato.setNome(nome);
            contato.setEmail(email);
            contato.setTelefone(telefone);
            return true;
        } else {
            return false; // Índice inválido
        }
    }

    // Método para buscar um contato pelo nome
    public Contato buscarContatoPorId(Integer id) {
        for (Contato contato : contatos) {
            if (contato.getId().equals(id)) {
                return contato;
            }
        }
        return null; // Retorna null se não encontrar o contato
    }

    public boolean removerContatoPorId(Integer id) {
        return contatos.removeIf(contato -> contato.getId().equals(id));
    }

    public void atualizarContato(Contato contato) {
        Contato contatoExistente = buscarContatoPorId(contato.getId());
        if (contatoExistente != null) {
            contatoExistente.setNome(contato.getNome());
            contatoExistente.setEmail(contato.getEmail());
            contatoExistente.setTelefone(contato.getTelefone());
        }
    }

}
