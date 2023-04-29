/*    */ package mzm.gsp.crossbattle.point;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.corps.main.CorpsInfo;
/*    */ import mzm.gsp.corps.main.CorpsInterface;
/*    */ import mzm.gsp.crossbattle.confbean.SCrossBattleDrawLotsCfg;
/*    */ import mzm.gsp.gm.SGMMessageTipRes;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ 
/*    */ public class PGM_GetCorpsZone extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long gmRoleid;
/*    */   private final long roleid;
/*    */   private final int activityCfgid;
/*    */   
/*    */   public PGM_GetCorpsZone(long gmRoleid, long roleid, int activityCfgid)
/*    */   {
/* 18 */     this.gmRoleid = gmRoleid;
/* 19 */     this.roleid = roleid;
/* 20 */     this.activityCfgid = activityCfgid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 26 */     CorpsInfo corpsInfo = CorpsInterface.getCorpsInfoByRoleId(this.roleid, false, false);
/* 27 */     if (corpsInfo == null)
/*    */     {
/* 29 */       notifyClient("角色未参加战队");
/* 30 */       return false;
/*    */     }
/*    */     
/* 33 */     if (SCrossBattleDrawLotsCfg.get(this.activityCfgid) == null)
/*    */     {
/* 35 */       notifyClient("活动参数错误");
/* 36 */       return false;
/*    */     }
/*    */     
/* 39 */     long corpsid = corpsInfo.getCorpsId();
/* 40 */     int zone = CrossBattlePointManager.getCorpsZone(this.activityCfgid, corpsid);
/* 41 */     notifyClient(String.format("查询赛区成功|赛区=%d", new Object[] { Integer.valueOf(zone) }));
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   private void notifyClient(String str)
/*    */   {
/* 47 */     SGMMessageTipRes messagetip = new SGMMessageTipRes();
/* 48 */     messagetip.result = Integer.MAX_VALUE;
/* 49 */     messagetip.args.add(str);
/* 50 */     OnlineManager.getInstance().sendAtOnce(this.gmRoleid, messagetip);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\point\PGM_GetCorpsZone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */