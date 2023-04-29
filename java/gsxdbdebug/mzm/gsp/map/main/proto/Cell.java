/*     */ package mzm.gsp.map.main.proto;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.map.main.scene.object.MapEntity;
/*     */ import mzm.gsp.map.main.scene.object.MapRole;
/*     */ import mzm.gsp.map.main.scene.zone.IZone;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Cell
/*     */ {
/*     */   public static final byte F_WALKABLE = 0;
/*     */   public static final byte F_BLOCK = 1;
/*     */   public static final byte F_FURNITURE_BLOCK = 2;
/*     */   public static final byte F_FURNITURE_CARPET = 4;
/*     */   public static final byte F_FURNITURE_WALL_DECOR = 8;
/*     */   public static final byte F_WALL = 32;
/*  21 */   public static final Cell WARKABLE_CELL = new Cell((byte)0);
/*  22 */   public static final Cell BLOCK_CELL = new Cell((byte)1);
/*  23 */   public static final Cell WALL_CELL = new Cell((byte)32);
/*  24 */   public static final Cell BLOCK_WALL_CELL = new Cell((byte)33);
/*     */   
/*  26 */   private static final Map<Byte, Cell> protoTypeCell = new HashMap();
/*     */   private final Cell srcCell;
/*     */   
/*  29 */   static { protoTypeCell.put(Byte.valueOf((byte)0), WARKABLE_CELL);
/*  30 */     protoTypeCell.put(Byte.valueOf((byte)1), BLOCK_CELL);
/*  31 */     protoTypeCell.put(Byte.valueOf((byte)32), WALL_CELL);
/*  32 */     protoTypeCell.put(Byte.valueOf((byte)33), BLOCK_WALL_CELL);
/*     */   }
/*     */   
/*     */   public static Cell getPrototypeCell(byte flag)
/*     */   {
/*  37 */     return (Cell)protoTypeCell.get(Byte.valueOf(flag));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*  42 */   private final Set<IZone> zoneSet = new HashSet();
/*     */   
/*  44 */   private byte m_flags = 0;
/*     */   
/*     */   public Cell(byte flag)
/*     */   {
/*  48 */     this.m_flags = flag;
/*  49 */     this.srcCell = null;
/*     */   }
/*     */   
/*     */   public Cell(Cell cell)
/*     */   {
/*  54 */     this.m_flags = cell.m_flags;
/*  55 */     this.srcCell = cell;
/*     */   }
/*     */   
/*     */   public void addZone(IZone z)
/*     */   {
/*  60 */     this.zoneSet.add(z);
/*     */   }
/*     */   
/*     */   public void removeZone(IZone z)
/*     */   {
/*  65 */     this.zoneSet.remove(z);
/*     */   }
/*     */   
/*     */   public boolean containZone(IZone z)
/*     */   {
/*  70 */     return this.zoneSet.contains(z);
/*     */   }
/*     */   
/*     */   public void onEnter(MapRole role)
/*     */   {
/*  75 */     Cell oldCell = role.getCell();
/*  76 */     role.setCell(this);
/*  77 */     if ((oldCell != null) && (oldCell != this))
/*     */     {
/*  79 */       oldCell.onLeave(role, this);
/*     */     }
/*  81 */     for (IZone zone : this.zoneSet)
/*     */     {
/*  83 */       zone.enterRole(role);
/*     */     }
/*     */   }
/*     */   
/*     */   public void onLeave(MapRole role, Cell newCell)
/*     */   {
/*  89 */     for (IZone zone : this.zoneSet)
/*     */     {
/*  91 */       if (!newCell.containZone(zone))
/*     */       {
/*  93 */         zone.leaveRole(role);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void onRemove(MapRole role)
/*     */   {
/* 100 */     for (IZone zone : this.zoneSet)
/*     */     {
/* 102 */       zone.leaveRole(role);
/*     */     }
/*     */   }
/*     */   
/*     */   public void onEnter(MapEntity entity)
/*     */   {
/* 108 */     Cell oldCell = entity.getCell();
/* 109 */     entity.setCell(this);
/* 110 */     if ((oldCell != null) && (oldCell != this))
/*     */     {
/* 112 */       oldCell.onLeave(entity, this);
/*     */     }
/* 114 */     for (IZone zone : this.zoneSet)
/*     */     {
/* 116 */       zone.enterEntity(entity);
/*     */     }
/*     */   }
/*     */   
/*     */   public void onLeave(MapEntity entity, Cell newCell)
/*     */   {
/* 122 */     for (IZone zone : this.zoneSet)
/*     */     {
/* 124 */       if (!newCell.containZone(zone))
/*     */       {
/* 126 */         zone.leaveEntity(entity);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void onRemove(MapEntity entity)
/*     */   {
/* 133 */     for (IZone zone : this.zoneSet)
/*     */     {
/* 135 */       zone.leaveEntity(entity);
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean isPrototypeCell()
/*     */   {
/* 141 */     return this.srcCell == null;
/*     */   }
/*     */   
/*     */   public boolean isContainZone(IZone zone)
/*     */   {
/* 146 */     return this.zoneSet.contains(zone);
/*     */   }
/*     */   
/*     */   public boolean isBlock()
/*     */   {
/* 151 */     return (this.m_flags & 0x1) == 1;
/*     */   }
/*     */   
/*     */   public boolean isWall()
/*     */   {
/* 156 */     return (this.m_flags & 0x20) == 32;
/*     */   }
/*     */   
/*     */   public boolean isFurnitureBlock()
/*     */   {
/* 161 */     return (this.m_flags & 0x2) == 2;
/*     */   }
/*     */   
/*     */   public void setFurnitureBlock()
/*     */   {
/* 166 */     this.m_flags = ((byte)(this.m_flags | 0x2));
/*     */   }
/*     */   
/*     */   public void unsetFurnitureBlock()
/*     */   {
/* 171 */     this.m_flags = ((byte)(this.m_flags & 0xFFFFFFFD));
/*     */   }
/*     */   
/*     */   public boolean isFurnitureCarpet()
/*     */   {
/* 176 */     return (this.m_flags & 0x4) == 4;
/*     */   }
/*     */   
/*     */   public void setFurnitureCarpet()
/*     */   {
/* 181 */     this.m_flags = ((byte)(this.m_flags | 0x4));
/*     */   }
/*     */   
/*     */   public void unsetFurnitureCarpet()
/*     */   {
/* 186 */     this.m_flags = ((byte)(this.m_flags & 0xFFFFFFFB));
/*     */   }
/*     */   
/*     */   public boolean isFurnitureWallDecor()
/*     */   {
/* 191 */     return (this.m_flags & 0x8) == 8;
/*     */   }
/*     */   
/*     */   public void setFurnitureWallDecor()
/*     */   {
/* 196 */     this.m_flags = ((byte)(this.m_flags | 0x8));
/*     */   }
/*     */   
/*     */   public void unsetFurnitureWallDecor()
/*     */   {
/* 201 */     this.m_flags = ((byte)(this.m_flags & 0xFFFFFFF7));
/*     */   }
/*     */   
/*     */   public boolean containsFlag(byte flag)
/*     */   {
/* 206 */     return (this.m_flags & flag) > 0;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isReachable()
/*     */   {
/* 216 */     return isWalkable();
/*     */   }
/*     */   
/*     */   private boolean isWalkable()
/*     */   {
/* 221 */     return ((this.m_flags & 0x1) == 0) && ((this.m_flags & 0x2) == 0);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\proto\Cell.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */