/*    */ package mzm.gsp.qmhw.main;
/*    */ 
/*    */ import mzm.gsp.activity.event.ActivityPauseArg;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.qmhw.confbean.SQMHWCfgConsts;
/*    */ import xbean.QMHWActivity;
/*    */ 
/*    */ public class POnActivityPause extends mzm.gsp.activity.event.ActivityPauseProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 12 */     if (((ActivityPauseArg)this.arg).activityid == SQMHWCfgConsts.getInstance().ACTIVITY_ID)
/*    */     {
/* 14 */       QMHWActivity xQmhwActivity = QMHWManager.getQmhwActivity(false);
/* 15 */       if (xQmhwActivity == null) {
/* 16 */         return false;
/*    */       }
/* 18 */       long worldid = xQmhwActivity.getWorldid();
/* 19 */       java.util.List<Long> roleids = MapInterface.getRoleList(worldid);
/* 20 */       MapInterface.transferAllRole(roleids, MapInterface.getBigWorldid(), SQMHWCfgConsts.getInstance().OUT_MAP_ID);
/*    */     }
/*    */     
/* 23 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qmhw\main\POnActivityPause.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */