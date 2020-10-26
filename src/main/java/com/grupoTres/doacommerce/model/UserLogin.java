package com.grupoTres.doacommerce.model;

public class UserLogin {

    private String nomeRazao;

    private String email;

    private String senha;

    private String token;

    private int tipoPessoa;

    public String getNome() {
        return nomeRazao;
    }

    public void setNome(String nomeRazao) {
        this.nomeRazao = nomeRazao;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(int tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }
}