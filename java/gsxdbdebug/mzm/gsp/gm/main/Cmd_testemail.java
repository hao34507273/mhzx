/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.mail.main.MailAttachment;
/*    */ import mzm.gsp.mail.main.MailInterface;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ import xtable.Name2roleid;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Cmd_testemail
/*    */   extends CmdBase
/*    */ {
/*    */   private long roleId;
/*    */   
/*    */   protected boolean parse()
/*    */   {
/* 25 */     this.roleId = this.m_gmRole.getRoleid();
/*    */     
/* 27 */     if (this.m_arguments == null) {
/* 28 */       return true;
/*    */     }
/* 30 */     int index = 0;
/*    */     
/* 32 */     if (index >= this.m_arguments.size()) {
/* 33 */       return true;
/*    */     }
/* 35 */     Long targetId = null;
/* 36 */     targetId = Name2roleid.select((String)this.m_arguments.get(index));
/*    */     
/* 38 */     if (targetId != null)
/*    */     {
/* 40 */       this.roleId = targetId.longValue();
/* 41 */       index++;
/*    */     }
/*    */     
/* 44 */     if (index != this.m_arguments.size()) {
/* 45 */       return false;
/*    */     }
/* 47 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean fillData()
/*    */   {
/* 56 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected void run()
/*    */   {
/* 63 */     MailAttachment mailAttachment = new MailAttachment();
/* 64 */     mailAttachment.setPetExp(1000);
/* 65 */     mailAttachment.setRoleExp(1000);
/* 66 */     mailAttachment.setXiuLianExp(1000);
/* 67 */     mailAttachment.setVigor(10);
/* 68 */     mailAttachment.setStoreExp(10000);
/* 69 */     mailAttachment.addToken(2, 10);
/*    */     
/* 71 */     MailInterface.asynBuildAndSendMail(this.roleId, 1, "GM", "GM", mailAttachment, new TLogArg(LogReason.GM_ADD));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_testemail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */