/*    */ package mzm.gsp.loginaward.main;
/*    */ 
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Basic;
/*    */ import xtable.User;
/*    */ 
/*    */ public class PCGetLoginSumActivityInfos extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private String userid;
/*    */   
/*    */   public PCGetLoginSumActivityInfos(long roleid)
/*    */   {
/* 16 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 22 */     if (!LoginSumActivityManager.isFunOpen(this.roleid, true))
/*    */     {
/* 24 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 28 */     if (!LoginAwardManager.checkRoleStatus(this.roleid, 233))
/*    */     {
/* 30 */       return false;
/*    */     }
/*    */     
/* 33 */     this.userid = RoleInterface.getUserId(this.roleid);
/* 34 */     if (this.userid == null)
/*    */     {
/* 36 */       return false;
/*    */     }
/*    */     
/* 39 */     lock(Lockeys.get(User.getTable(), this.userid));
/* 40 */     lock(Lockeys.get(Basic.getTable(), Long.valueOf(this.roleid)));
/*    */     
/* 42 */     LoginSumActivityManager.sendLoginSumActivityInfos(this.userid, this.roleid);
/* 43 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\loginaward\main\PCGetLoginSumActivityInfos.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */