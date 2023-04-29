/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import java.util.LinkedList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.homeland.event.BuyFurnitureArg;
/*    */ import mzm.gsp.homeland.event.BuyFurnitureProcedure;
/*    */ import mzm.gsp.marriage.main.MarriageInterface;
/*    */ 
/*    */ 
/*    */ public class POnBuyFurniture
/*    */   extends BuyFurnitureProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */   {
/* 15 */     List<Long> roleIds = new LinkedList();
/* 16 */     roleIds.add(Long.valueOf(((BuyFurnitureArg)this.arg).roleId));
/* 17 */     long partnerId = MarriageInterface.getMarriedRoleid(((BuyFurnitureArg)this.arg).roleId);
/* 18 */     if (partnerId > 0L)
/*    */     {
/* 20 */       roleIds.add(Long.valueOf(partnerId));
/*    */     }
/* 22 */     AchievementManager.collectLocks(roleIds);
/*    */     
/*    */ 
/* 25 */     AchievementManager.updateGoalTypeState(((BuyFurnitureArg)this.arg).roleId, 5605, Integer.valueOf(((BuyFurnitureArg)this.arg).itemCfgId), "POnBuyFurniture.processImp@handle HOME_OWN_TYPE_FURNITURE success");
/*    */     
/*    */ 
/* 28 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnBuyFurniture.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */