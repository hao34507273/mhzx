/*    */ package mzm.gsp.crossfield.roam;
/*    */ 
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.crossfield.SSynCrossFieldMatchInfo;
/*    */ import mzm.gsp.crossfield.main.CrossFieldManager;
/*    */ import mzm.gsp.crossserver.main.SingleCrossFieldRoamedContext;
/*    */ import mzm.gsp.online.event.PlayerLoginRunnable;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.singlebattle.main.SingleBattleInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ROnRoleLogin
/*    */   extends PlayerLoginRunnable
/*    */ {
/*    */   public void process()
/*    */     throws Exception
/*    */   {
/* 21 */     if (!GameServerInfoManager.isRoamServer())
/*    */     {
/* 23 */       return;
/*    */     }
/* 25 */     long roleid = ((Long)this.arg).longValue();
/* 26 */     SingleCrossFieldRoamedContext context = (SingleCrossFieldRoamedContext)SingleCrossFieldRoamedContextManager.getInstance().getValue(Long.valueOf(roleid));
/* 27 */     if (context == null)
/*    */     {
/* 29 */       return;
/*    */     }
/* 31 */     context.setLogined(roleid);
/* 32 */     SingleBattleInterface.joinBattle(context.getSingleBattleid(), roleid);
/*    */     
/* 34 */     SSynCrossFieldMatchInfo protocol = new SSynCrossFieldMatchInfo();
/* 35 */     protocol.activity_cfg_id = context.getActivityCfgid();
/* 36 */     protocol.process = 4;
/* 37 */     OnlineManager.getInstance().send(roleid, protocol);
/*    */     
/* 39 */     CrossFieldManager.logger.info(String.format("[crossfield]ROnRoleLogin.process@roam server login process|roleid=%d", new Object[] { Long.valueOf(roleid) }));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossfield\roam\ROnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */