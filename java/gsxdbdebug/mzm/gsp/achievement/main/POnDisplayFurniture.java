/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import java.util.LinkedList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.homeland.event.DisplayFurnitureArg;
/*    */ import mzm.gsp.homeland.event.DisplayFurnitureEventProcedure;
/*    */ import mzm.gsp.marriage.main.MarriageInterface;
/*    */ 
/*    */ 
/*    */ public class POnDisplayFurniture
/*    */   extends DisplayFurnitureEventProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */   {
/* 15 */     List<Long> roleIds = new LinkedList();
/* 16 */     roleIds.add(Long.valueOf(((DisplayFurnitureArg)this.arg).roleId));
/* 17 */     long partnerId = MarriageInterface.getMarriedRoleid(((DisplayFurnitureArg)this.arg).roleId);
/* 18 */     if (partnerId > 0L)
/*    */     {
/* 20 */       roleIds.add(Long.valueOf(partnerId));
/*    */     }
/* 22 */     AchievementManager.collectLocks(roleIds);
/*    */     
/*    */ 
/* 25 */     AchievementManager.updateGoalTypeState(((DisplayFurnitureArg)this.arg).roleId, 5603, Integer.valueOf(((DisplayFurnitureArg)this.arg).furnitureCfgId), "POnDisplayFurniture.processImp@handle HOME_DISPLAY_TYPE_FURNITURE success");
/*    */     
/*    */ 
/* 28 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnDisplayFurniture.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */