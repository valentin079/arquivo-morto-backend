package br.com.api.arquivo_morto.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.api.arquivo_morto.modelo.ArquivoModelo;

@Repository
public interface ArquivoRepositorio extends CrudRepository <ArquivoModelo, Long>{
    
}
