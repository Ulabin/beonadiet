package com.ds.mainpagetest.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QMyOwnRecipePost is a Querydsl query type for MyOwnRecipePost
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMyOwnRecipePost extends EntityPathBase<MyOwnRecipePost> {

    private static final long serialVersionUID = 1526928447L;

    public static final QMyOwnRecipePost myOwnRecipePost = new QMyOwnRecipePost("myOwnRecipePost");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final NumberPath<Integer> calorie = createNumber("calorie", Integer.class);

    public final NumberPath<Integer> category = createNumber("category", Integer.class);

    public final StringPath detail = createString("detail");

    public final StringPath explanation = createString("explanation");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath image = createString("image");

    public final NumberPath<Integer> likeCount = createNumber("likeCount", Integer.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modDate = _super.modDate;

    public final StringPath name = createString("name");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> regDate = _super.regDate;

    public final NumberPath<Integer> views = createNumber("views", Integer.class);

    public QMyOwnRecipePost(String variable) {
        super(MyOwnRecipePost.class, forVariable(variable));
    }

    public QMyOwnRecipePost(Path<? extends MyOwnRecipePost> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMyOwnRecipePost(PathMetadata metadata) {
        super(MyOwnRecipePost.class, metadata);
    }

}

