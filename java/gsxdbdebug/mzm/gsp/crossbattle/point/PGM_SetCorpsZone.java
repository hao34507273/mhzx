/*    */ package mzm.gsp.crossbattle.point;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.corps.main.CorpsInfo;
/*    */ import mzm.gsp.crossbattle.confbean.SCrossBattlePointConst;
/*    */ import mzm.gsp.gm.SGMMessageTipRes;
/*    */ import xbean.CrossbattleDrawLots;
/*    */ import xbean.CrossbattlePoint;
/*    */ import xbean.DrawLotsZoneInfo;
/*    */ 
/*    */ public class PGM_SetCorpsZone extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long gmRoleid;
/*    */   private final int activityCfgid;
/*    */   private final int zone;
/*    */   private final long roleid;
/*    */   
/*    */   public PGM_SetCorpsZone(long gmRoleid, int activityCfgid, int zone, long roleid)
/*    */   {
/* 20 */     this.gmRoleid = gmRoleid;
/* 21 */     this.activityCfgid = activityCfgid;
/* 22 */     this.zone = zone;
/* 23 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 29 */     CorpsInfo corpsInfo = mzm.gsp.corps.main.CorpsInterface.getCorpsInfoByRoleId(this.roleid, false, false);
/* 30 */     if (corpsInfo == null)
/*    */     {
/* 32 */       notifyClient("角色未参加战队");
/* 33 */       return false;
/*    */     }
/*    */     
/* 36 */     if ((this.zone < 1) || (this.zone > SCrossBattlePointConst.getInstance().ZONE_NUM))
/*    */     {
/* 38 */       notifyClient("赛区参数错误");
/* 39 */       return false;
/*    */     }
/*    */     
/* 42 */     if (mzm.gsp.crossbattle.confbean.SCrossBattleDrawLotsCfg.get(this.activityCfgid) == null)
/*    */     {
/* 44 */       notifyClient("活动参数错误");
/* 45 */       return false;
/*    */     }
/*    */     
/* 48 */     long corpsid = corpsInfo.getCorpsId();
/* 49 */     CrossbattleDrawLots xCrossbattleDrawLots = CrossBattlePointManager.getAndInitCrossbattleDrawLots(this.activityCfgid);
/* 50 */     DrawLotsZoneInfo xDrawLotsZoneInfo = (DrawLotsZoneInfo)xCrossbattleDrawLots.getCorps().get(Long.valueOf(corpsid));
/* 51 */     if (xDrawLotsZoneInfo == null)
/*    */     {
/* 53 */       xDrawLotsZoneInfo = xbean.Pod.newDrawLotsZoneInfo();
/* 54 */       xCrossbattleDrawLots.getCorps().put(Long.valueOf(corpsid), xDrawLotsZoneInfo);
/*    */     }
/* 56 */     xDrawLotsZoneInfo.setZone(this.zone);
/*    */     
/*    */ 
/* 59 */     CrossbattlePoint xCrossbattlePoint = CrossBattlePointManager.getAndInitCrossBattlePoint(this.activityCfgid);
/* 60 */     xCrossbattlePoint.getCorps_result().put(Long.valueOf(corpsid), Integer.valueOf(1));
/*    */     
/* 62 */     notifyClient(String.format("设置赛区成功|赛区=%d", new Object[] { Integer.valueOf(this.zone) }));
/* 63 */     return true;
/*    */   }
/*    */   
/*    */   private void notifyClient(String str)
/*    */   {
/* 68 */     SGMMessageTipRes messagetip = new SGMMessageTipRes();
/* 69 */     messagetip.result = Integer.MAX_VALUE;
/* 70 */     messagetip.args.add(str);
/* 71 */     mzm.gsp.online.main.OnlineManager.getInstance().sendAtOnce(this.gmRoleid, messagetip);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\point\PGM_SetCorpsZone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */