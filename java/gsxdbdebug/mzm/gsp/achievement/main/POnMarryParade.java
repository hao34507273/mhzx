/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import mzm.gsp.marriage.event.MarryParadeArg;
/*    */ import mzm.gsp.marriage.event.MarryParadeProcedure;
/*    */ 
/*    */ public class POnMarryParade
/*    */   extends MarryParadeProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 13 */     AchievementManager.collectLocks(Arrays.asList(new Long[] { Long.valueOf(((MarryParadeArg)this.arg).roleid1), Long.valueOf(((MarryParadeArg)this.arg).roleid2) }));
/*    */     
/*    */ 
/* 16 */     AchievementManager.updateGoalTypeState(((MarryParadeArg)this.arg).roleid1, 312, Integer.valueOf(1), "POnMarryParade.processImp@handle MARRY_PARADE_COUNT success");
/*    */     
/* 18 */     AchievementManager.updateGoalTypeState(((MarryParadeArg)this.arg).roleid2, 312, Integer.valueOf(1), "POnMarryParade.processImp@handle MARRY_PARADE_COUNT success");
/*    */     
/*    */ 
/* 21 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnMarryParade.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */