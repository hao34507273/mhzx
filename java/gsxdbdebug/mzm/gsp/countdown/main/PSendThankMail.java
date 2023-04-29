/*    */ package mzm.gsp.countdown.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.countdown.confbean.MailInfo;
/*    */ import mzm.gsp.countdown.confbean.SCountDownCfg;
/*    */ import mzm.gsp.mail.main.SendMailRet;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.CountDownInfo;
/*    */ import xbean.RoleCountDownInfo;
/*    */ import xtable.Role2countdowninfo;
/*    */ 
/*    */ public class PSendThankMail extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final int cfgid;
/*    */   private final int index;
/*    */   
/*    */   public PSendThankMail(long roleid, int cfgid, int index)
/*    */   {
/* 22 */     this.roleid = roleid;
/* 23 */     this.cfgid = cfgid;
/* 24 */     this.index = index;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 30 */     if (!CountDownManager.isCountDownSwitchOpenForRole(this.roleid, false))
/*    */     {
/*    */ 
/* 33 */       return false;
/*    */     }
/*    */     
/* 36 */     RoleCountDownInfo xRoleCountDownInfo = Role2countdowninfo.get(Long.valueOf(this.roleid));
/* 37 */     if (xRoleCountDownInfo == null)
/*    */     {
/* 39 */       xRoleCountDownInfo = xbean.Pod.newRoleCountDownInfo();
/* 40 */       Role2countdowninfo.insert(Long.valueOf(this.roleid), xRoleCountDownInfo);
/*    */     }
/* 42 */     CountDownInfo xCountDownInfo = (CountDownInfo)xRoleCountDownInfo.getCount_down_infos().get(Integer.valueOf(this.cfgid));
/* 43 */     if (xCountDownInfo == null)
/*    */     {
/* 45 */       xCountDownInfo = xbean.Pod.newCountDownInfo();
/* 46 */       xRoleCountDownInfo.getCount_down_infos().put(Integer.valueOf(this.cfgid), xCountDownInfo);
/*    */     }
/* 48 */     if (xCountDownInfo.getThank_mails().contains(Integer.valueOf(this.index)))
/*    */     {
/* 50 */       return false;
/*    */     }
/*    */     
/* 53 */     SCountDownCfg cfg = SCountDownCfg.get(this.cfgid);
/* 54 */     if ((cfg == null) || (!cfg.thank_mail_infos.containsKey(Integer.valueOf(this.index))))
/*    */     {
/*    */ 
/* 57 */       return false;
/*    */     }
/* 59 */     mzm.gsp.tlog.TLogArg tLogArg = new mzm.gsp.tlog.TLogArg(mzm.gsp.tlog.LogReason.COUNT_DOWN_THANK_MAIL, this.cfgid);
/* 60 */     SendMailRet sendMailRet = mzm.gsp.mail.main.MailInterface.synBuildAndSendMail(this.roleid, ((MailInfo)cfg.thank_mail_infos.get(Integer.valueOf(this.index))).mail_cfg_id, null, null, tLogArg);
/*    */     
/* 62 */     if (!sendMailRet.isOK())
/*    */     {
/* 64 */       CountDownManager.logger.info(String.format("[countdown]PSendThankMail.processImp@send thank mail fail|roleid=%d|cfgid=%d|index=%d|reason=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.cfgid), Integer.valueOf(this.index), Integer.valueOf(sendMailRet.getRetEnum().ordinal()) }));
/*    */       
/*    */ 
/* 67 */       return false;
/*    */     }
/*    */     
/* 70 */     xCountDownInfo.getThank_mails().add(Integer.valueOf(this.index));
/* 71 */     if (CountDownManager.logger.isDebugEnabled())
/*    */     {
/* 73 */       CountDownManager.logger.debug(String.format("[countdown]PSendThankMail.processImp@send thank mail success|roleid=%d|cfgid=%d|index=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.cfgid), Integer.valueOf(this.index) }));
/*    */     }
/*    */     
/*    */ 
/* 77 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\countdown\main\PSendThankMail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */