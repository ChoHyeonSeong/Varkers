package com.jhs.varkers.listening;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QListeningEntity is a Querydsl query type for ListeningEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QListeningEntity extends EntityPathBase<ListeningEntity> {

    private static final long serialVersionUID = 799710105L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QListeningEntity listeningEntity = new QListeningEntity("listeningEntity");

    public final com.jhs.varkers.account.QAccountEntity account;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Long> listeningId = createNumber("listeningId", Long.class);

    public QListeningEntity(String variable) {
        this(ListeningEntity.class, forVariable(variable), INITS);
    }

    public QListeningEntity(Path<? extends ListeningEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QListeningEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QListeningEntity(PathMetadata metadata, PathInits inits) {
        this(ListeningEntity.class, metadata, inits);
    }

    public QListeningEntity(Class<? extends ListeningEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.account = inits.isInitialized("account") ? new com.jhs.varkers.account.QAccountEntity(forProperty("account"), inits.get("account")) : null;
    }

}

