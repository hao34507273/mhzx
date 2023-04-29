/*    */ package mzm.gsp.jiuxiao.main;
/*    */ 
/*    */ import mzm.gsp.award.event.MultiRoleSelectArg;
/*    */ 
/*    */ public class PJiuXiaoMultiAwardEnd extends mzm.gsp.award.event.MultiRoleSelectAwardEndProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/*  9 */     if ((((MultiRoleSelectArg)this.arg).context instanceof JiuXiaoMultiRoleAwardContext)) {
/* 10 */       JiuXiaoMultiRoleAwardContext context = (JiuXiaoMultiRoleAwardContext)((MultiRoleSelectArg)this.arg).context;
/* 11 */       int floor = context.awardFloor;
/* 12 */       mzm.gsp.activity.confbean.SJueZhanJiuXiaoCfg nextJueZhanJiuXiaoCfg = JiuXiaoCfgManager.getNextJiuXiaoCfg(context.activityid, floor);
/* 13 */       if (nextJueZhanJiuXiaoCfg != null) {
/* 14 */         JiuXiaoManager.finishFloor(nextJueZhanJiuXiaoCfg, ((MultiRoleSelectArg)this.arg).allRoles);
/*    */       }
/* 16 */       return true;
/*    */     }
/* 18 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\jiuxiao\main\PJiuXiaoMultiAwardEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */