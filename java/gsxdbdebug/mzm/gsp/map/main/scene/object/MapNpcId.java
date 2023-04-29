/*    */ package mzm.gsp.map.main.scene.object;
/*    */ 
/*    */ public class MapNpcId implements SceneObjectId
/*    */ {
/*    */   private final int id;
/*    */   
/*    */   public MapNpcId(int id)
/*    */   {
/*  9 */     this.id = id;
/*    */   }
/*    */   
/*    */ 
/*    */   public Integer getId()
/*    */   {
/* 15 */     return Integer.valueOf(this.id);
/*    */   }
/*    */   
/*    */ 
/*    */   public int hashCode()
/*    */   {
/* 21 */     return this.id;
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
/* 32 */     if ((obj instanceof MapNpcId))
/*    */     {
/* 34 */       return this.id == ((MapNpcId)obj).id;
/*    */     }
/*    */     
/* 37 */     return false;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public String toString()
/*    */   {
/* 44 */     return String.valueOf(this.id);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\scene\object\MapNpcId.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */