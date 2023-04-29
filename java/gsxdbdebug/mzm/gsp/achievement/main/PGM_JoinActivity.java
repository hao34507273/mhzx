/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.gm.SGMMessageTipRes;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ 
/*    */ public class PGM_JoinActivity extends LogicProcedure
/*    */ {
/*    */   private final long gmRoleid;
/*    */   private final long roleid;
/*    */   private final int activityCfgid;
/*    */   private final int num;
/*    */   
/*    */   public PGM_JoinActivity(long gmRoleid, long roleid, int activityCfgid, int num)
/*    */   {
/* 18 */     this.gmRoleid = gmRoleid;
/* 19 */     this.roleid = roleid;
/* 20 */     this.activityCfgid = activityCfgid;
/* 21 */     this.num = num;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 28 */     for (int i = 0; i < this.num; i++)
/*    */     {
/* 30 */       NoneRealTimeTaskManager.getInstance().addTask(new PUpdateGoalTypeState(this.roleid, this.activityCfgid));
/*    */     }
/*    */     
/* 33 */     notifyClient("成就触发成功");
/* 34 */     return true;
/*    */   }
/*    */   
/*    */   private static class PUpdateGoalTypeState extends LogicProcedure
/*    */   {
/*    */     private final long roleid;
/*    */     private final int activityCfgid;
/*    */     
/*    */     public PUpdateGoalTypeState(long roleid, int activityCfgid)
/*    */     {
/* 44 */       this.roleid = roleid;
/* 45 */       this.activityCfgid = activityCfgid;
/*    */     }
/*    */     
/*    */ 
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 52 */       AchievementManager.updateGoalTypeState(this.roleid, 2400, Integer.valueOf(this.activityCfgid), "PUpdateGoalTypeState.processImp@add join activity");
/*    */       
/* 54 */       return true;
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */   private void notifyClient(String str)
/*    */   {
/* 61 */     SGMMessageTipRes messagetip = new SGMMessageTipRes();
/* 62 */     messagetip.result = Integer.MAX_VALUE;
/* 63 */     messagetip.args.add(str);
/* 64 */     OnlineManager.getInstance().sendAtOnce(this.gmRoleid, messagetip);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\PGM_JoinActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */