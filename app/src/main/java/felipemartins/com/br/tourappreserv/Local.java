package felipemartins.com.br.tourappreserv;

/**
 * Created by lfeli on 23/04/2017.
 */

public class Local {

    private String nome;

    private String descricaoCurta, descricaolonga;

    private String local;

    public Local(){}

    public String getDescricaoCurta() {
        return descricaoCurta;
    }

    public void setDescricaoCurta(String descricaoCurta) {
        this.descricaoCurta = descricaoCurta;
    }

    public String getDescricaolonga() {
        return descricaolonga;
    }

    public void setDescricaolonga(String descricaolonga) {
        this.descricaolonga = descricaolonga;
    }

    public String getLocal() {
        return local;
    }
    public void setLocal(String local) {
        this.local = local;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


}
