/*    */ package mzm.gsp.map.main.scene.object;
/*    */ 
/*    */ public class MapRoleId implements SceneObjectId
/*    */ {
/*    */   private final long roleid;
/*    */   
/*    */   public MapRoleId(long roleid)
/*    */   {
/*  9 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */ 
/*    */   public Long getId()
/*    */   {
/* 15 */     return Long.valueOf(this.roleid);
/*    */   }
/*    */   
/*    */ 
/*    */   public int hashCode()
/*    */   {
/* 21 */     return (int)(this.roleid ^ this.roleid >>> 32);
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean equals(Object obj)
/*    */   {
/* 27 */     if (this == obj)
/*    */     {
/* 29 */       return true;
/*    */     }
/*    */     
/* 32 */     if ((obj instanceof MapRoleId))
/*    */     {
/* 34 */       return this.roleid == ((MapRoleId)obj).roleid;
/*    */     }
/*    */     
/* 37 */     return false;
/*    */   }
/*    */   
/*    */ 
/*    */   public String toString()
/*    */   {
/* 43 */     return String.valueOf(this.roleid);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\scene\object\MapRoleId.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */