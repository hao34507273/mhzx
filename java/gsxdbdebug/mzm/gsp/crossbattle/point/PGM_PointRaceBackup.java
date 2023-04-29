/*    */ package mzm.gsp.crossbattle.point;
/*    */ 
/*    */ import mzm.gsp.gm.SGMMessageTipRes;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PGM_PointRaceBackup extends LogicProcedure
/*    */ {
/*    */   private final long gmRoleid;
/*    */   private final int activityCfgid;
/*    */   private final int zone;
/*    */   private final int index;
/*    */   
/*    */   public PGM_PointRaceBackup(long gmRoleid, int activityCfgid, int zone, int index)
/*    */   {
/* 16 */     this.gmRoleid = gmRoleid;
/* 17 */     this.activityCfgid = activityCfgid;
/* 18 */     this.zone = zone;
/* 19 */     this.index = index;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 25 */     BackupResult result = CrossBattlePointManager.pointRaceBackup(this.activityCfgid, this.zone, this.index);
/* 26 */     if (result == BackupResult.Success)
/*    */     {
/* 28 */       notifyClient("操作成功");
/* 29 */       return true;
/*    */     }
/*    */     
/* 32 */     notifyClient(String.format("操作失败:%s", new Object[] { result.desc }));
/* 33 */     return false;
/*    */   }
/*    */   
/*    */   private void notifyClient(String str)
/*    */   {
/* 38 */     SGMMessageTipRes messagetip = new SGMMessageTipRes();
/* 39 */     messagetip.result = Integer.MAX_VALUE;
/* 40 */     messagetip.args.add(str);
/* 41 */     OnlineManager.getInstance().sendAtOnce(this.gmRoleid, messagetip);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\point\PGM_PointRaceBackup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */