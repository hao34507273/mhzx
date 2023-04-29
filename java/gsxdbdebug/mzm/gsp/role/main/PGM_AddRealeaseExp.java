/*    */ package mzm.gsp.role.main;
/*    */ 
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xdb.Lockeys;
/*    */ import xtable.User;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PGM_AddRealeaseExp
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int exp;
/*    */   
/*    */   public PGM_AddRealeaseExp(long roleId, int exp)
/*    */   {
/* 20 */     this.roleId = roleId;
/* 21 */     this.exp = exp;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 28 */     String userid = RoleInterface.getUserId(this.roleId);
/* 29 */     Lockeys.lock(Lockeys.get(User.getTable(), userid));
/* 30 */     Role role = RoleInterface.getRole(this.roleId, true);
/* 31 */     return role.addExp(this.exp, new TLogArg(LogReason.ROLE_GM_EXP_ADD_RELEASE), true);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\PGM_AddRealeaseExp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */