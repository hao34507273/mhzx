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
/*    */ public class PGM_AddExp
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int addValue;
/*    */   
/*    */   public PGM_AddExp(long roleId, int addValue)
/*    */   {
/* 20 */     this.roleId = roleId;
/* 21 */     this.addValue = addValue;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 28 */     String userid = RoleInterface.getUserId(this.roleId);
/* 29 */     Lockeys.lock(Lockeys.get(User.getTable(), userid));
/* 30 */     Role role = RoleInterface.getRole(this.roleId, true);
/* 31 */     return role.addExp(this.addValue, new TLogArg(LogReason.GM_ADD), true);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\PGM_AddExp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */