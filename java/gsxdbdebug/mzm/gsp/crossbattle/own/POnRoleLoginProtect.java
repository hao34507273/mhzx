/*    */ package mzm.gsp.crossbattle.own;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.crossbattle.SSynCrossBattleCurrentActivityCfgid;
/*    */ import mzm.gsp.crossbattle.confbean.CrossBattleConsts;
/*    */ import mzm.gsp.crossbattle.confbean.SCrossBattleOwnCfg;
/*    */ import mzm.gsp.crossbattle.main.CrossBattleOneByOneManager;
/*    */ import mzm.gsp.online.event.PlayerLoginProtectProcedure;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ 
/*    */ public class POnRoleLoginProtect
/*    */   extends PlayerLoginProtectProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 19 */     SSynCrossBattleCurrentActivityCfgid protocol = new SSynCrossBattleCurrentActivityCfgid();
/* 20 */     protocol.activity_cfg_id = CrossBattleConsts.getInstance().CURRENT_ACTIVITY_CFG_ID;
/* 21 */     OnlineManager.getInstance().send(((Long)this.arg).longValue(), protocol);
/* 22 */     for (Iterator i$ = SCrossBattleOwnCfg.getAll().keySet().iterator(); i$.hasNext();) { int activityCfgid = ((Integer)i$.next()).intValue();
/*    */       
/* 24 */       CrossBattleOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(activityCfgid), new PSynRoleCrossBattleOwnInfo(((Long)this.arg).longValue(), activityCfgid, true));
/*    */     }
/*    */     
/* 27 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\own\POnRoleLoginProtect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */