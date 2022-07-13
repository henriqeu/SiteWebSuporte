package com.suporte.SiteWebSuporte.repository;

import com.suporte.SiteWebSuporte.model.Chamado;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChamadoRepositorio extends CrudRepository<Chamado, Long> {

}
