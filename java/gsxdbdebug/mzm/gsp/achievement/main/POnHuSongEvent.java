/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import mzm.gsp.husong.event.HuSongArg;
/*    */ import mzm.gsp.husong.event.HuSongEventProcedure;
/*    */ import mzm.gsp.husong.main.HuSongInterface;
/*    */ 
/*    */ public class POnHuSongEvent extends HuSongEventProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 11 */     if (!((HuSongArg)this.arg).success)
/*    */     {
/* 13 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 17 */     AchievementManager.updateGoalTypeState(((HuSongArg)this.arg).roleid, 2400, Integer.valueOf(HuSongInterface.getHuSongActivityid()), "POnHuSongEvent.processImp@handle ACTIVITY_JOIN finish");
/*    */     
/*    */ 
/* 20 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnHuSongEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */