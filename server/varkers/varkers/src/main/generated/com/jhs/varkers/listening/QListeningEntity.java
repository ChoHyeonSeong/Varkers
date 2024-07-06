package com.jhs.varkers.listening;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QListeningEntity is a Querydsl query type for ListeningEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QListeningEntity extends EntityPathBase<ListeningEntity> {

    private static final long serialVersionUID = 799710105L;

    public static final QListeningEntity listeningEntity = new QListeningEntity("listeningEntity");

    public final NumberPath<Long> accountId = createNumber("accountId", Long.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Long> listeningId = createNumber("listeningId", Long.class);

    public QListeningEntity(String variable) {
        super(ListeningEntity.class, forVariable(variable));
    }

    public QListeningEntity(Path<? extends ListeningEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QListeningEntity(PathMetadata metadata) {
        super(ListeningEntity.class, metadata);
    }

}

