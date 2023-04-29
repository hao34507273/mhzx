/*    */ package mzm.gsp.role.main;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.role.result.CutRoleExpResult;
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
/*    */ public class PGM_CutExp
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int cutValue;
/*    */   
/*    */   public PGM_CutExp(long roleId, int cutValue)
/*    */   {
/* 23 */     this.roleId = roleId;
/* 24 */     this.cutValue = cutValue;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 31 */     String userid = RoleInterface.getUserId(this.roleId);
/* 32 */     Lockeys.lock(Lockeys.get(User.getTable(), userid));
/* 33 */     CutRoleExpResult res = RoleInterface.cutExp(userid, this.roleId, this.cutValue, new TLogArg(LogReason.GM_REM));
/* 34 */     if (res.isCutSuc())
/*    */     {
/* 36 */       GmManager.getInstance().sendResultToGM(this.roleId, "扣除成功！");
/*    */     }
/*    */     else
/*    */     {
/* 40 */       GmManager.getInstance().sendResultToGM(this.roleId, String.format("扣除失败！reason:%s", new Object[] { res.getReason() }));
/*    */     }
/* 42 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\PGM_CutExp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */