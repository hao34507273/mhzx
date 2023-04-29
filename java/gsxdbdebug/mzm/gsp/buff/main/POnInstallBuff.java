/*    */ package mzm.gsp.buff.main;
/*    */ 
/*    */ import java.util.concurrent.TimeUnit;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.buff.confbean.STBuffCfg;
/*    */ import mzm.gsp.buff.event.InstallBuffArg;
/*    */ import mzm.gsp.buff.event.InstallBuffProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xdb.Lockeys;
/*    */ 
/*    */ public class POnInstallBuff extends InstallBuffProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 15 */     long roleid = ((InstallBuffArg)this.arg).roleid;
/* 16 */     int buffid = ((InstallBuffArg)this.arg).buffid;
/*    */     
/* 18 */     STBuffCfg buffCfg = STBuffCfg.get(buffid);
/* 19 */     if (buffCfg == null)
/*    */     {
/* 21 */       GameServer.logger().error(String.format("[buff]POnUninstallBuff.processImp@buff cfg is null|roleid=%d|buffid=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(buffid) }));
/*    */       
/* 23 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 27 */     lock(Lockeys.get(xtable.Basic.getTable(), Long.valueOf(roleid)));
/*    */     
/* 29 */     if (((InstallBuffArg)this.arg).state == 1)
/*    */     {
/*    */ 
/* 32 */       BuffManager.installBuffEffect(roleid, buffCfg);
/*    */     }
/*    */     
/* 35 */     if (buffCfg.effectType == 2)
/*    */     {
/* 37 */       long interval = TimeUnit.SECONDS.toMillis(buffCfg.persistTime);
/* 38 */       if (interval > 0L)
/*    */       {
/* 40 */         BuffMilliObserverCache.getInstance().addMillObserver(roleid, buffid, new BuffMilliObserver(interval, roleid, buffid, ((InstallBuffArg)this.arg).installTime));
/*    */       }
/*    */     }
/*    */     
/*    */ 
/* 45 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\buff\main\POnInstallBuff.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */