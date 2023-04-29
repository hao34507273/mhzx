/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PUpdateGoalTypeState extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final int goalType;
/*    */   private final Object context;
/*    */   private final String logStr;
/*    */   
/*    */   public PUpdateGoalTypeState(long roleid, int goalType, Object context, String logStr)
/*    */   {
/* 14 */     this.roleid = roleid;
/* 15 */     this.goalType = goalType;
/* 16 */     this.context = context;
/* 17 */     this.logStr = logStr;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 23 */     AchievementManager.updateGoalTypeState(this.roleid, this.goalType, this.context, this.logStr);
/* 24 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\PUpdateGoalTypeState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */