package com.pfe.ecredit.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pfe.ecredit.domain.SiTypeDocuments;

@Repository
public interface SiTypeDocumentsRepository extends JpaRepository<SiTypeDocuments, Long>{

	@Query(value = "select p from SiTypeCredit t, SiDocumentCrdt c, SiTypeDocuments p where t.idType = c.codeCredit and c.codeDocument = p.idDoc and c.codeCredit = :code")
	List<SiTypeDocuments> findPieceByTypeCredit(@Param("code") Long type);
}
