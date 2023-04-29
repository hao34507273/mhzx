/*    */ package mzm.gsp.mail.main;
/*    */ 
/*    */ import mzm.gsp.mail.CDelMailReq;
/*    */ 
/*    */ public class PCDelMailReq extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private long roleId;
/*    */   private CDelMailReq cDelMailReq;
/*    */   
/*    */   public PCDelMailReq(long roleId, CDelMailReq cDelMailReq)
/*    */   {
/* 12 */     this.roleId = roleId;
/* 13 */     this.cDelMailReq = cDelMailReq;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 19 */     xbean.MailMapBean xMailMapBean = xtable.Role2mail.get(Long.valueOf(this.roleId));
/* 20 */     return RoleMailManager.reqDelMail(this.roleId, xMailMapBean, this.cDelMailReq.mailindex);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mail\main\PCDelMailReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */