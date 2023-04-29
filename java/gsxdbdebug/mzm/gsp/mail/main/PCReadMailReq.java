/*    */ package mzm.gsp.mail.main;
/*    */ 
/*    */ import mzm.gsp.mail.CReadMailReq;
/*    */ 
/*    */ public class PCReadMailReq extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private CReadMailReq cReadMailReq;
/*    */   private long roleId;
/*    */   
/*    */   public PCReadMailReq(long roleId, CReadMailReq cReadMailReq)
/*    */   {
/* 12 */     this.cReadMailReq = cReadMailReq;
/* 13 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 19 */     xbean.MailMapBean xMailMapBean = xtable.Role2mail.get(Long.valueOf(this.roleId));
/* 20 */     RoleMailManager.reqReadMail(this.roleId, xMailMapBean, this.cReadMailReq.mailindex);
/* 21 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mail\main\PCReadMailReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */