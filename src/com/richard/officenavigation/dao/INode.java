package com.richard.officenavigation.dao;

import java.util.List;
import com.richard.officenavigation.dao.DaoSession;
import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, EDIT ONLY INSIDE THE "KEEP"-SECTIONS

// KEEP INCLUDES - put your custom includes here
// KEEP INCLUDES END
/**
 * Entity mapped to table INODE.
 */
public class INode implements Comparable<INode> {

    private Long id;
    private long x;
    private long y;
    /** Not-null value. */
    private String name;
    private boolean visible;
    private boolean trained;
    private long mapId;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient INodeDao myDao;

    private List<IRssi> rssis;
    private List<IPath> adjacencies;

    // KEEP FIELDS - put your custom fields here
	public double minDistance;
	public INode previous;
    // KEEP FIELDS END

    public INode() {
    }

    public INode(Long id) {
        this.id = id;
    }

    public INode(Long id, long x, long y, String name, boolean visible, boolean trained, long mapId) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.name = name;
        this.visible = visible;
        this.trained = trained;
        this.mapId = mapId;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getINodeDao() : null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getX() {
        return x;
    }

    public void setX(long x) {
        this.x = x;
    }

    public long getY() {
        return y;
    }

    public void setY(long y) {
        this.y = y;
    }

    /** Not-null value. */
    public String getName() {
        return name;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setName(String name) {
        this.name = name;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public boolean isTrained() {
        return trained;
    }

    public void setTrained(boolean trained) {
        this.trained = trained;
    }

    public long getMapId() {
        return mapId;
    }

    public void setMapId(long mapId) {
        this.mapId = mapId;
    }

    /** To-many relationship, resolved on first access (and after reset). Changes to to-many relations are not persisted, make changes to the target entity. */
    public List<IRssi> getRssis() {
        if (rssis == null) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            IRssiDao targetDao = daoSession.getIRssiDao();
            List<IRssi> rssisNew = targetDao._queryINode_Rssis(id);
            synchronized (this) {
                if(rssis == null) {
                    rssis = rssisNew;
                }
            }
        }
        return rssis;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    public synchronized void resetRssis() {
        rssis = null;
    }

    /** To-many relationship, resolved on first access (and after reset). Changes to to-many relations are not persisted, make changes to the target entity. */
    public List<IPath> getAdjacencies() {
        if (adjacencies == null) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            IPathDao targetDao = daoSession.getIPathDao();
            List<IPath> adjacenciesNew = targetDao._queryINode_Adjacencies(id);
            synchronized (this) {
                if(adjacencies == null) {
                    adjacencies = adjacenciesNew;
                }
            }
        }
        return adjacencies;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    public synchronized void resetAdjacencies() {
        adjacencies = null;
    }

    /** Convenient call for {@link AbstractDao#delete(Object)}. Entity must attached to an entity context. */
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.delete(this);
    }

    /** Convenient call for {@link AbstractDao#update(Object)}. Entity must attached to an entity context. */
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.update(this);
    }

    /** Convenient call for {@link AbstractDao#refresh(Object)}. Entity must attached to an entity context. */
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.refresh(this);
    }

    // KEEP METHODS - put your custom methods here
	@Override
	public int compareTo(INode another) {
		return Double.compare(minDistance, another.minDistance);
	}
    // KEEP METHODS END

}
