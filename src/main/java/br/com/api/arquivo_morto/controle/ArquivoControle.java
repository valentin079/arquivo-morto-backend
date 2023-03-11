package br.com.api.arquivo_morto.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.arquivo_morto.modelo.ArquivoModelo;
import br.com.api.arquivo_morto.modelo.RespostaModelo;
import br.com.api.arquivo_morto.servico.ArquivoServico;

@RestController
@CrossOrigin(origins = "*")
public class ArquivoControle {
    @Autowired
    private ArquivoServico as;

    @DeleteMapping("/remover/{codigo}")
    public ResponseEntity<RespostaModelo> remover(@PathVariable long codigo){
        return as.remover(codigo);
    }
    
    @PutMapping("/alterar")
    public ResponseEntity<?> alterar(@RequestBody ArquivoModelo am){
        return as.cadastrarAlterar(am,"alterar");
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody ArquivoModelo am){
        return as.cadastrarAlterar(am,"cadastrar");
    }

    @GetMapping("/listar")
    public Iterable<ArquivoModelo> listar(){
        return as.listar();
    }
    
    @GetMapping("/")
    public String rota(){
        return "API de produtos funcionando!";
    }
}
