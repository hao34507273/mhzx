/*    */ package mzm.gsp.crossbattle.point;
/*    */ 
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.crossbattle.confbean.CrossBattleConsts;
/*    */ import mzm.gsp.crossbattle.main.CrossBattleOneByOneManager;
/*    */ import mzm.gsp.online.event.PlayerLoginRunnable;
/*    */ 
/*    */ public class ROnRoleLogin extends PlayerLoginRunnable
/*    */ {
/*    */   public void process() throws Exception
/*    */   {
/* 12 */     long roleid = ((Long)this.arg).longValue();
/* 13 */     if (GameServerInfoManager.isRoamServer())
/*    */     {
/* 15 */       POnRoleLoginRoam p = new POnRoleLoginRoam(roleid);
/* 16 */       if (p.call())
/*    */       {
/* 18 */         new PReturnTeam(roleid).call();
/*    */       }
/* 20 */       return;
/*    */     }
/*    */     
/* 23 */     int activityCfgid = CrossBattleConsts.getInstance().CURRENT_ACTIVITY_CFG_ID;
/* 24 */     CrossBattleOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(activityCfgid), new POnRoleLoginLocal(activityCfgid, roleid));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\point\ROnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */