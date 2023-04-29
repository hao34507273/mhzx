/*    */ package mzm.gsp.mail.main;
/*    */ 
/*    */ import xbean.MailMapBean;
/*    */ 
/*    */ public class PCAutoGetMailReq extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private long roleId;
/*    */   
/*    */   public PCAutoGetMailReq(long roleId) {
/* 10 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 16 */     MailMapBean xMailMapBean = xtable.Role2mail.select(Long.valueOf(this.roleId));
/*    */     
/* 18 */     return RoleMailManager.reqAutoGetThing(this.roleId, xMailMapBean);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mail\main\PCAutoGetMailReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */