/*    */ package mzm.gsp.active.main;
/*    */ 
/*    */ import java.util.Map.Entry;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.active.ActiveData;
/*    */ import mzm.gsp.active.SynActiveDataRes;
/*    */ import mzm.gsp.activity.confbean.SActivityCfg;
/*    */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import xbean.Active;
/*    */ 
/*    */ public class POnRoleLogin extends PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 16 */     long curTime = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/*    */     
/* 18 */     Active xActive = ActiveManager.checkAndInitActive(((Long)this.arg).longValue(), curTime);
/*    */     
/* 20 */     SynActiveDataRes synActiveDataRes = new SynActiveDataRes();
/* 21 */     for (Map.Entry<Integer, Integer> entry : xActive.getActivitymap().entrySet())
/*    */     {
/* 23 */       ActiveData activeData = new ActiveData();
/* 24 */       activeData.activityid = ((Integer)entry.getKey()).intValue();
/* 25 */       SActivityCfg sActivityCfg = SActivityCfg.get(activeData.activityid);
/* 26 */       if (sActivityCfg != null)
/*    */       {
/* 28 */         activeData.activecount = Math.min(sActivityCfg.awardActiveTimes, ((Integer)entry.getValue()).intValue());
/*    */       }
/*    */       else
/*    */       {
/* 32 */         GameServer.logger().error(String.format("[active]POnRoleLogin.processImp@activeCfgId not found|activity_cfg_id=%d", new Object[] { Integer.valueOf(activeData.activityid) }));
/*    */       }
/*    */       
/*    */ 
/* 36 */       synActiveDataRes.activedatas.add(activeData);
/*    */     }
/* 38 */     synActiveDataRes.award_active_index_id_set.addAll(xActive.getAward_index_id_set());
/* 39 */     OnlineManager.getInstance().send(((Long)this.arg).longValue(), synActiveDataRes);
/*    */     
/* 41 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\active\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */