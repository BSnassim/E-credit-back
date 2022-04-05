package com.pfe.ecredit.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pfe.ecredit.domain.TypeDocuments;

@Repository
public interface TypeDocumentsRepository extends JpaRepository<TypeDocuments, Integer>{

	@Query(value = "select p from TypeCredit t, DocumentType c, PiecesJointes p where t.ID = c.codeType and c.codeDoc = p.ID and c.codeType = :code")
	List<TypeDocuments> findPieceByTypeCredit(@Param("code") Integer id);
}
