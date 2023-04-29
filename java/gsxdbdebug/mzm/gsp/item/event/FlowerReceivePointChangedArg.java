/*    */ package mzm.gsp.item.event;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FlowerReceivePointChangedArg
/*    */ {
/*    */   public final long roleId;
/*    */   
/*    */ 
/*    */   public final int newPoint;
/*    */   
/*    */ 
/*    */   public final long endEffectTime;
/*    */   
/*    */   public final int addPoint;
/*    */   
/*    */   public final int totalReceivePoint;
/*    */   
/*    */ 
/*    */   public FlowerReceivePointChangedArg(long roleId, int newPoint, long endEffectTime, int addPoint, int totalReceivePoint)
/*    */   {
/* 22 */     this.roleId = roleId;
/* 23 */     this.newPoint = newPoint;
/* 24 */     this.endEffectTime = endEffectTime;
/* 25 */     this.addPoint = addPoint;
/* 26 */     this.totalReceivePoint = totalReceivePoint;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\event\FlowerReceivePointChangedArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */