package br.com.api.arquivo_morto.servico;

import org.apache.tools.ant.taskdefs.Rmic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.api.arquivo_morto.modelo.ArquivoModelo;
import br.com.api.arquivo_morto.modelo.RespostaModelo;
import br.com.api.arquivo_morto.repositorio.ArquivoRepositorio;

@Service
public class ArquivoServico {
    @Autowired
    private ArquivoRepositorio ar;

    @Autowired
    private RespostaModelo rm;

    //Método para listar todos os arquivos
    public Iterable <ArquivoModelo> listar(){
        return ar.findAll();
    }

    //Método para cadastrar ou alterar produtos
    public ResponseEntity<?> cadastrarAlterar(ArquivoModelo am, String acao){

        if(am.getNome().equals("")){
            rm.setMensagem("O nome é obrigatório!");
            return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);
        }else if(am.getPasta().equals("")){
            rm.setMensagem("O número da pasta é obrigatório");
            return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);
        }else{
            if(acao.equals("cadastrar")){
                return new ResponseEntity<ArquivoModelo>(ar.save(am), HttpStatus.CREATED);
            }else{
                return new ResponseEntity<ArquivoModelo>(ar.save(am), HttpStatus.OK);
            }
        }
    }
    //método para remover produtos
    public ResponseEntity<RespostaModelo> remover(long codigo){

        ar.deleteById(codigo);
        rm.setMensagem("Arquivo removido com sucesso!;");
        return new ResponseEntity<RespostaModelo>(rm, HttpStatus.OK);
    }


}
