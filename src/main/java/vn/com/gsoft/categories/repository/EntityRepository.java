package vn.com.gsoft.categories.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.com.gsoft.categories.entity.Entity;
import vn.com.gsoft.categories.model.dto.EntityReq;

import java.util.List;

public interface EntityRepository extends BaseRepository<Entity, EntityReq, Integer> {
    @Query("SELECT c FROM Entity c " +
            "WHERE 1=1 "
    )
    Page<Entity> searchPage(@Param("param") EntityReq param, Pageable pageable);


    @Query("SELECT c FROM Entity c " +
            "WHERE 1=1 "
    )
    List<Entity> searchList(@Param("param") EntityReq param);

    Entity findByCode(String level);
}
