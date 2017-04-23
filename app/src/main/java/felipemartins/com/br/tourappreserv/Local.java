package felipemartins.com.br.tourappreserv;

import com.orm.SugarRecord;

/**
 * Created by lfeli on 23/04/2017.
 */

public class Local extends SugarRecord {

    public String nome;

    public String descricaoCurta, descricaolonga;

    public String local;

    public String categoria;

    public String urlimg;

    public Local(String ferinha, String s, String s1, String tambaú, String comidas){}

    public Local(String nome, String descricaoCurta, String descricaolonga, String local, String categoria, String urlimg){
        this.nome = nome;
        this.descricaoCurta = descricaoCurta;
        this.descricaolonga = descricaolonga;
        this.local = local;
        this.categoria = categoria;
        this.urlimg = urlimg;
    }

    public String getUrlimg() {
        return urlimg;
    }

    public void setUrlimg(String urlimg) {
        this.urlimg = urlimg;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

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
