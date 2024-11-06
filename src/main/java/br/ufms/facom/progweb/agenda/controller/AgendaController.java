package br.ufms.facom.progweb.agenda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.ufms.facom.progweb.agenda.model.ContatoGerenciador;
import br.ufms.facom.progweb.agenda.model.Contato;

@Controller
@RequestMapping("/agenda")
public class AgendaController {

    private ContatoGerenciador contatoGerenciador = new ContatoGerenciador();

    // Rota para a página inicial (GET)
    @GetMapping("/")
    public String mostrarPaginaInicial() {
        return "inicio"; // Nome da view: inicio.html
    }

    @GetMapping("/listar")
    public String listarContatos(Model model) {
        model.addAttribute("contatos", contatoGerenciador.listarContatos());
        return "listaContatos"; // Nome da view: listaContatos.html
    }

    // Método para exibir um formulário de cadastro de contato (GET)
    @GetMapping("/cadastro")
    public String exibirFormularioCadastro() {
        return "novoContato"; // Nome da view correta: novoContato.html
    }

    @PostMapping("/salvar")
    public String salvarContato(Contato contato) {
        contatoGerenciador.salvarContato(contato);
        return "redirect:/agenda/listar"; // Redireciona para a página de listagem
    }

    @GetMapping("/editar/{id}")
    public String exibirFormularioEdicao(@PathVariable("id") Integer id, Model model) {
        Contato contato = contatoGerenciador.buscarContatoPorId(id);
        model.addAttribute("contato", contato);
        return "editaContato"; // Nome da view para o formulário de edição
    }

    @PostMapping("/editar/{id}")
    public String salvarEdicao(@PathVariable("id") Integer id, Contato contato) {
        contato.setId(id); // Assegura que o ID não muda
        contatoGerenciador.atualizarContato(contato); // Atualiza o contato usando o método corrigido
        return "redirect:/agenda/listar"; // Redireciona para a listagem após salvar a edição
    }

    @GetMapping("/excluir/{id}")
    public String excluirContato(@PathVariable("id") Integer id) {
        contatoGerenciador.removerContatoPorId(id); // Método de exclusão a ser implementado em ContatoGerenciador
        return "redirect:/agenda/listar"; // Redireciona para a listagem após a exclusão
    }

}
