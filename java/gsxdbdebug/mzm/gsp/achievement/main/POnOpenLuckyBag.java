/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import mzm.gsp.achievement.main.goaltype.OpenLuckyBag.Context;
/*    */ import mzm.gsp.luckybag.event.OpenLuckyBagArg;
/*    */ import mzm.gsp.luckybag.event.OpenLuckyBagProcedure;
/*    */ 
/*    */ public class POnOpenLuckyBag
/*    */   extends OpenLuckyBagProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 13 */     OpenLuckyBag.Context context = new OpenLuckyBag.Context(((OpenLuckyBagArg)this.arg).type, ((OpenLuckyBagArg)this.arg).openNum);
/* 14 */     AchievementManager.updateGoalTypeState(((OpenLuckyBagArg)this.arg).roleid, 5200, context, "POnOpenLuckyBag.processImp@handle OPEN_LUCK_BAG sucess");
/*    */     
/*    */ 
/* 17 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnOpenLuckyBag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */