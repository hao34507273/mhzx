/*    */ package mzm.gsp.children.event;
/*    */ 
/*    */ 
/*    */ public class AddChildIntoHomeArg
/*    */ {
/*    */   public final long roleId;
/*    */   public final long childId;
/*    */   public final int mapCfgId;
/*    */   public final int positionX;
/*    */   public final int positionY;
/*    */   public final ChildAddHomeReason childAddHomeReason;
/*    */   
/*    */   public AddChildIntoHomeArg(long roleId, long childId, int mapCfgId, ChildAddHomeReason childAddHomeReason)
/*    */   {
/* 15 */     this.roleId = roleId;
/* 16 */     this.childId = childId;
/* 17 */     this.mapCfgId = mapCfgId;
/* 18 */     this.positionX = 0;
/* 19 */     this.positionY = 0;
/* 20 */     this.childAddHomeReason = childAddHomeReason;
/*    */   }
/*    */   
/*    */ 
/*    */   public AddChildIntoHomeArg(long roleId, long childId, int mapCfgId, int positionX, int positionY, ChildAddHomeReason childAddHomeReason)
/*    */   {
/* 26 */     this.roleId = roleId;
/* 27 */     this.childId = childId;
/* 28 */     this.mapCfgId = mapCfgId;
/* 29 */     this.positionX = positionX;
/* 30 */     this.positionY = positionY;
/* 31 */     this.childAddHomeReason = childAddHomeReason;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\event\AddChildIntoHomeArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */