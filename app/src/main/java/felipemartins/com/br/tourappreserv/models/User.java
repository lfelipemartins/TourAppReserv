package felipemartins.com.br.tourappreserv.models;

/**
 * Created by lfeli on 24/04/2017.
 */

public class User {

    public String login, senha, status, token, salvar;

    public String getSalvar() {
        return salvar;
    }

    public void setSalvar(String salvar) {
        this.salvar = salvar;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
