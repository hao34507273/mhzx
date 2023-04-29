/*    */ package mzm.gsp.singlebattle.buff;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.buff.event.UninstallBuffArg;
/*    */ import mzm.gsp.buff.event.UninstallBuffProcedure;
/*    */ import mzm.gsp.singlebattle.confbean.BuffCfgid2InfoCfgidCfg;
/*    */ import mzm.gsp.singlebattle.main.SingleBattleInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ public class POnUninstallBuff
/*    */   extends UninstallBuffProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 17 */     long roleid = ((UninstallBuffArg)this.arg).roleid;
/* 18 */     int buffCfgid = ((UninstallBuffArg)this.arg).buffid;
/* 19 */     if (BuffCfgid2InfoCfgidCfg.get(buffCfgid) == null)
/*    */     {
/* 21 */       return false;
/*    */     }
/*    */     
/* 24 */     long battleid = SingleBattleInterface.getBattleId(roleid, true);
/* 25 */     if (battleid < 0L)
/*    */     {
/* 27 */       return false;
/*    */     }
/* 29 */     BuffManager.refreshRoleBuffInfo(roleid, true);
/*    */     
/* 31 */     GameServer.logger().info(String.format("[singlebattle]POnUninstallBuff.processImp@uninstall buff process|roleid=%d|buff_cfg_id=%d|battle_id=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(buffCfgid), Long.valueOf(battleid) }));
/*    */     
/*    */ 
/*    */ 
/* 35 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\buff\POnUninstallBuff.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */