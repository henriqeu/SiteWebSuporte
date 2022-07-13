package com.suporte.SiteWebSuporte.repository;

import com.suporte.SiteWebSuporte.model.Procedimento;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcedimentoRepositorio extends CrudRepository<Procedimento, Long> {

}
