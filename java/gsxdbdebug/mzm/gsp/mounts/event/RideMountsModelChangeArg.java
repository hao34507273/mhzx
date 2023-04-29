/*    */ package mzm.gsp.mounts.event;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RideMountsModelChangeArg
/*    */ {
/*    */   private final long roleId;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   private final int mountsCfgId;
/*    */   
/*    */ 
/*    */ 
/*    */   private final int mountsRank;
/*    */   
/*    */ 
/*    */ 
/*    */   private final int colorId;
/*    */   
/*    */ 
/*    */ 
/*    */   private final int changeReason;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public RideMountsModelChangeArg(long roleId, int mountsCfgId, int mountsRank, int colorId, int changeReason)
/*    */   {
/* 33 */     this.roleId = roleId;
/* 34 */     this.mountsCfgId = mountsCfgId;
/* 35 */     this.mountsRank = mountsRank;
/* 36 */     this.colorId = colorId;
/* 37 */     this.changeReason = changeReason;
/*    */   }
/*    */   
/*    */   public long getRoleId()
/*    */   {
/* 42 */     return this.roleId;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getMountsCfgId()
/*    */   {
/* 51 */     return this.mountsCfgId;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getMountsRank()
/*    */   {
/* 59 */     return this.mountsRank;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getColorId()
/*    */   {
/* 67 */     return this.colorId;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getChangeReson()
/*    */   {
/* 78 */     return this.changeReason;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mounts\event\RideMountsModelChangeArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */