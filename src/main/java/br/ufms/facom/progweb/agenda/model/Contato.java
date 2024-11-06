package br.ufms.facom.progweb.agenda.model;

public class Contato {
  private Integer id;
  private String nome;
  private String email;
  private String telefone;

  // Construtor completo com id
  public Contato(Integer id, String nome, String email, String telefone) {
    this.id = id;
    this.nome = nome;
    this.email = email;
    this.telefone = telefone;
  }

  // Construtor sem id (para novos contatos)
  public Contato(String nome, String email, String telefone) {
    this.nome = nome;
    this.email = email;
    this.telefone = telefone;
  }

  // Construtor padrão
  public Contato() {
  }

  // Getters
  public Integer getId() {
    return id;
  }

  public String getNome() {
    return nome;
  }

  public String getEmail() {
    return email;
  }

  public String getTelefone() {
    return telefone;
  }

  // Setters
  public void setId(Integer id) {
    this.id = id;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setTelefone(String telefone) {
    this.telefone = telefone;
  }
}
