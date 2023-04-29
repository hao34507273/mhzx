/*    */ package mzm.gsp.item.event;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FlowerGivePointChangedArg
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
/*    */   public final int totalGivePoint;
/*    */   
/*    */ 
/*    */   public FlowerGivePointChangedArg(long roleId, int newPoint, long endEffectTime, int addPoint, int totalGivePoint)
/*    */   {
/* 22 */     this.roleId = roleId;
/* 23 */     this.newPoint = newPoint;
/* 24 */     this.endEffectTime = endEffectTime;
/* 25 */     this.addPoint = addPoint;
/* 26 */     this.totalGivePoint = totalGivePoint;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\event\FlowerGivePointChangedArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */