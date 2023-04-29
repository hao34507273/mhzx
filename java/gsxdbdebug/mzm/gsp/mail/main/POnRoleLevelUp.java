/*    */ package mzm.gsp.mail.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import mzm.gsp.role.event.RoleLevelUpArg;
/*    */ 
/*    */ public class POnRoleLevelUp extends mzm.gsp.role.event.RoleLevelUpProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/*    */     Iterator i$;
/* 11 */     for (int level = ((RoleLevelUpArg)this.arg).oldLevel + 1; level <= ((RoleLevelUpArg)this.arg).newLevel; level++) {
/* 12 */       mzm.gsp.mail.confbean.SMailRemindCfg mailRemindCfg = mzm.gsp.mail.confbean.SMailRemindCfg.get(level);
/* 13 */       if (mailRemindCfg != null)
/*    */       {
/*    */ 
/* 16 */         for (i$ = mailRemindCfg.mailcfgList.iterator(); i$.hasNext();) { int mailid = ((Integer)i$.next()).intValue();
/* 17 */           MailInterface.asynBuildAndSendMail(((RoleLevelUpArg)this.arg).roleId, mailid, null, null, new mzm.gsp.tlog.TLogArg(mzm.gsp.tlog.LogReason.LEVEL_UP_NOTIFY_MAIL));
/*    */         }
/*    */       }
/*    */     }
/* 21 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mail\main\POnRoleLevelUp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */