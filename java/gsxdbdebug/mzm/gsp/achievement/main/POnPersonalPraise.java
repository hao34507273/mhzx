/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import mzm.gsp.personal.event.PersonalPraiseArg;
/*    */ import mzm.gsp.personal.event.PersonalPraiseProcedure;
/*    */ 
/*    */ 
/*    */ public class POnPersonalPraise
/*    */   extends PersonalPraiseProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */   {
/* 13 */     AchievementManager.collectLocks(Arrays.asList(new Long[] { Long.valueOf(((PersonalPraiseArg)this.arg).roleid), Long.valueOf(((PersonalPraiseArg)this.arg).targetRoleid) }));
/*    */     
/*    */ 
/* 16 */     AchievementManager.updateGoalTypeState(((PersonalPraiseArg)this.arg).roleid, 305, Integer.valueOf(((PersonalPraiseArg)this.arg).praisedNum), "POnPersonalPraise.processImp@handle PRAISE_COUNT success");
/*    */     
/*    */ 
/*    */ 
/* 20 */     AchievementManager.updateGoalTypeState(((PersonalPraiseArg)this.arg).targetRoleid, 306, Integer.valueOf(((PersonalPraiseArg)this.arg).bePraisedNum), "POnPersonalPraise.processImp@handle BE_PRAISED_COUNT success");
/*    */     
/*    */ 
/* 23 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnPersonalPraise.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */