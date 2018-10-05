package com.md.reactboard.domain.util;

import com.md.reactboard.domain.IdEntity;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


public class EntityUtil {
    public static Collection<Long> getIds(Collection<? extends IdEntity> idEntity) {
        if (null == idEntity || idEntity.isEmpty()) {
            return null;
        }
        List<Long> rs = idEntity.stream().map(IdEntity::getId).collect(Collectors.toList());
        return rs;
    }

    public static Long getId(IdEntity idEntity) {
        return null == idEntity ? null : idEntity.getId();
    }
}
