/*    */ package mzm.gsp.buff.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.buff.confbean.STBuffCfg;
/*    */ import mzm.gsp.buff.event.UninstallBuffArg;
/*    */ import org.apache.log4j.Logger;
/*    */ import xdb.Lockeys;
/*    */ 
/*    */ public class POnUninstallBuff extends mzm.gsp.buff.event.UninstallBuffProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 13 */     long roleid = ((UninstallBuffArg)this.arg).roleid;
/* 14 */     int buffid = ((UninstallBuffArg)this.arg).buffid;
/*    */     
/* 16 */     STBuffCfg buffCfg = STBuffCfg.get(buffid);
/* 17 */     if (buffCfg == null)
/*    */     {
/* 19 */       GameServer.logger().error(String.format("[buff]POnUninstallBuff.processImp@buff cfg is null|roleid=%d|buffid=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(buffid) }));
/*    */       
/* 21 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 25 */     lock(Lockeys.get(xtable.Basic.getTable(), Long.valueOf(roleid)));
/*    */     
/* 27 */     if (((UninstallBuffArg)this.arg).state == 1)
/*    */     {
/*    */ 
/* 30 */       BuffManager.uninstallBuffEffect(roleid, buffCfg);
/*    */     }
/*    */     
/* 33 */     if (buffCfg.effectType == 2)
/*    */     {
/* 35 */       BuffMilliObserverCache.getInstance().stopMillObserver(roleid, buffid);
/*    */     }
/*    */     
/* 38 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\buff\main\POnUninstallBuff.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */