/*    */ package mzm.gsp.map.main.scene.object;
/*    */ 
/*    */ public class MapEntityId implements SceneObjectId
/*    */ {
/*    */   private final MapEntityType entityType;
/*    */   private final long id;
/*    */   
/*    */   public MapEntityId(MapEntityType entityType, long id)
/*    */   {
/* 10 */     this.entityType = entityType;
/* 11 */     this.id = id;
/*    */   }
/*    */   
/*    */   public MapEntityType getEntityType()
/*    */   {
/* 16 */     return this.entityType;
/*    */   }
/*    */   
/*    */   public long getInstanceid()
/*    */   {
/* 21 */     return this.id;
/*    */   }
/*    */   
/*    */ 
/*    */   public Long getId()
/*    */   {
/* 27 */     return Long.valueOf(this.id);
/*    */   }
/*    */   
/*    */ 
/*    */   public int hashCode()
/*    */   {
/* 33 */     return (int)(this.entityType.ordinal() ^ this.id ^ this.id >>> 32);
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean equals(Object obj)
/*    */   {
/* 39 */     if (this == obj)
/*    */     {
/* 41 */       return true;
/*    */     }
/*    */     
/* 44 */     if ((obj instanceof MapEntityId))
/*    */     {
/* 46 */       MapEntityId rhs = (MapEntityId)obj;
/* 47 */       return (this.entityType == rhs.entityType) && (this.id == rhs.id);
/*    */     }
/*    */     
/* 50 */     return false;
/*    */   }
/*    */   
/*    */ 
/*    */   public String toString()
/*    */   {
/* 56 */     return String.format("(entity_type=%d,id=%d)", new Object[] { Integer.valueOf(this.entityType.ordinal()), Long.valueOf(this.id) });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\scene\object\MapEntityId.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */