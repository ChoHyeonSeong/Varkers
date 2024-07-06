package com.jhs.varkers.vark;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QVarkEntity is a Querydsl query type for VarkEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QVarkEntity extends EntityPathBase<VarkEntity> {

    private static final long serialVersionUID = -1253722817L;

    public static final QVarkEntity varkEntity = new QVarkEntity("varkEntity");

    public final NumberPath<Long> accountId = createNumber("accountId", Long.class);

    public final StringPath content = createString("content");

    public final DateTimePath<java.util.Date> createdAt = createDateTime("createdAt", java.util.Date.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DateTimePath<java.util.Date> updatedAt = createDateTime("updatedAt", java.util.Date.class);

    public QVarkEntity(String variable) {
        super(VarkEntity.class, forVariable(variable));
    }

    public QVarkEntity(Path<? extends VarkEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QVarkEntity(PathMetadata metadata) {
        super(VarkEntity.class, metadata);
    }

}

