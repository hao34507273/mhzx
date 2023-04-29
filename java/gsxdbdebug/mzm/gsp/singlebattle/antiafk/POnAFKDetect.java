/*    */ package mzm.gsp.singlebattle.antiafk;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.afk.event.AFKDetectArg;
/*    */ import mzm.gsp.afk.event.AFKDetectProcedure;
/*    */ import mzm.gsp.singlebattle.main.SingleBattleInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ public class POnAFKDetect
/*    */   extends AFKDetectProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 16 */     int afkDetectCfgid = AntiAFKManager.getAFKDetectCfgid(((AFKDetectArg)this.arg).getRoleid());
/* 17 */     if (afkDetectCfgid != ((AFKDetectArg)this.arg).getCfgid())
/*    */     {
/* 19 */       return false;
/*    */     }
/* 21 */     SingleBattleInterface.activeLevelBattle(((AFKDetectArg)this.arg).getRoleid());
/* 22 */     GameServer.logger().info(String.format("[singlebattle]POnAFKDetect.processImp@afk detect process|roleid=%d|cfgid=%d", new Object[] { Long.valueOf(((AFKDetectArg)this.arg).getRoleid()), Integer.valueOf(((AFKDetectArg)this.arg).getCfgid()) }));
/*    */     
/*    */ 
/* 25 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\antiafk\POnAFKDetect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */