/*    */ package mzm.gsp.mail.main;
/*    */ 
/*    */ import xbean.MailMapBean;
/*    */ 
/*    */ public class PCAutoDelMailReq extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private long roleId;
/*    */   
/*    */   public PCAutoDelMailReq(long roleId) {
/* 10 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 16 */     MailMapBean xMailMapBean = xtable.Role2mail.get(Long.valueOf(this.roleId));
/* 17 */     return RoleMailManager.reqAutoDelMail(this.roleId, xMailMapBean);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mail\main\PCAutoDelMailReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */