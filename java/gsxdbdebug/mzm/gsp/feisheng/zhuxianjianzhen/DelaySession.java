/*    */ package mzm.gsp.feisheng.zhuxianjianzhen;
/*    */ 
/*    */ import mzm.gsp.timer.main.Session;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DelaySession
/*    */   extends Session
/*    */ {
/*    */   private final int activityCfgid;
/*    */   private final int stage;
/*    */   
/*    */   public DelaySession(long interval, long roleid, int activityCfgid, int stage)
/*    */   {
/* 20 */     super(interval, roleid);
/* 21 */     this.activityCfgid = activityCfgid;
/* 22 */     this.stage = stage;
/*    */   }
/*    */   
/*    */ 
/*    */   protected void onTimeOut()
/*    */   {
/* 28 */     switch (this.stage)
/*    */     {
/*    */     case 1: 
/* 31 */       new PKillMonsterStageStart(getOwerId(), this.activityCfgid).execute();
/* 32 */       return;
/*    */     case 2: 
/* 34 */       new PCLeaveZhuXianJianZhenActivityMap(getOwerId(), this.activityCfgid).execute();
/* 35 */       return;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\feisheng\zhuxianjianzhen\DelaySession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */