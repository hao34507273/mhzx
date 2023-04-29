/*    */ package mzm.gsp.mail.main;
/*    */ 
/*    */ import mzm.gsp.mail.CGetThingReq;
/*    */ import xtable.User;
/*    */ 
/*    */ public class PCGetThingReq extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private long roleId;
/*    */   private CGetThingReq cGetThingReq;
/*    */   
/*    */   public PCGetThingReq(long roleId, CGetThingReq cGetThingReq)
/*    */   {
/* 13 */     this.roleId = roleId;
/* 14 */     this.cGetThingReq = cGetThingReq;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 20 */     String userId = mzm.gsp.role.main.RoleInterface.getUserId(this.roleId);
/* 21 */     lock(xdb.Lockeys.get(User.getTable(), userId));
/*    */     
/*    */ 
/* 24 */     xbean.MailMapBean xMailMapBean = xtable.Role2mail.get(Long.valueOf(this.roleId));
/* 25 */     return RoleMailManager.reqGetThing(userId, this.roleId, xMailMapBean, this.cGetThingReq.mailindex);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mail\main\PCGetThingReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */