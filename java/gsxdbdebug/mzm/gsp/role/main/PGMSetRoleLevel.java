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
/*    */ 
/*    */ 
/*    */ public class PGMSetRoleLevel
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int newLevel;
/*    */   
/*    */   public PGMSetRoleLevel(long roleId, int newLevel)
/*    */   {
/* 22 */     this.roleId = roleId;
/* 23 */     this.newLevel = newLevel;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 30 */     String userid = RoleInterface.getUserId(this.roleId);
/* 31 */     lock(Lockeys.get(User.getTable(), userid));
/*    */     
/* 33 */     Role role = RoleInterface.getRole(this.roleId, true);
/* 34 */     if (role.getLevel() >= this.newLevel)
/*    */     {
/* 36 */       return false;
/*    */     }
/* 38 */     role.setLevel(this.newLevel, -1, new TLogArg(LogReason.GM_ADD));
/* 39 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\PGMSetRoleLevel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */