package com.richard.officenavigation.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

import com.richard.officenavigation.dao.IMap;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table IMAP.
*/
public class IMapDao extends AbstractDao<IMap, Long> {

    public static final String TABLENAME = "IMAP";

    /**
     * Properties of entity IMap.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Src = new Property(1, String.class, "src", false, "SRC");
        public final static Property Name = new Property(2, String.class, "name", false, "NAME");
        public final static Property Scale = new Property(3, double.class, "scale", false, "SCALE");
        public final static Property Width = new Property(4, long.class, "width", false, "WIDTH");
        public final static Property Height = new Property(5, long.class, "height", false, "HEIGHT");
    };

    private DaoSession daoSession;


    public IMapDao(DaoConfig config) {
        super(config);
    }
    
    public IMapDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists ? "IF NOT EXISTS " : "";
        db.execSQL("CREATE TABLE " + constraint + "'IMAP' (" + //
                "'_id' INTEGER PRIMARY KEY ," + // 0: id
                "'SRC' TEXT NOT NULL ," + // 1: src
                "'NAME' TEXT NOT NULL ," + // 2: name
                "'SCALE' REAL NOT NULL ," + // 3: scale
                "'WIDTH' INTEGER NOT NULL ," + // 4: width
                "'HEIGHT' INTEGER NOT NULL );"); // 5: height
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'IMAP'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, IMap entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindString(2, entity.getSrc());
        stmt.bindString(3, entity.getName());
        stmt.bindDouble(4, entity.getScale());
        stmt.bindLong(5, entity.getWidth());
        stmt.bindLong(6, entity.getHeight());
    }

    @Override
    protected void attachEntity(IMap entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public IMap readEntity(Cursor cursor, int offset) {
        IMap entity = new IMap( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.getString(offset + 1), // src
            cursor.getString(offset + 2), // name
            cursor.getDouble(offset + 3), // scale
            cursor.getLong(offset + 4), // width
            cursor.getLong(offset + 5) // height
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, IMap entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setSrc(cursor.getString(offset + 1));
        entity.setName(cursor.getString(offset + 2));
        entity.setScale(cursor.getDouble(offset + 3));
        entity.setWidth(cursor.getLong(offset + 4));
        entity.setHeight(cursor.getLong(offset + 5));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(IMap entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(IMap entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
}
