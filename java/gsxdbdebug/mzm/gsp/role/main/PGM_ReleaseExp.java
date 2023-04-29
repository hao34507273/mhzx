/*    */ package mzm.gsp.role.main;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.role.result.ReleaseStorageExpResult;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xdb.Lockeys;
/*    */ import xtable.User;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PGM_ReleaseExp
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   
/*    */   public PGM_ReleaseExp(long roleId)
/*    */   {
/* 21 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 28 */     String userid = RoleInterface.getUserId(this.roleId);
/* 29 */     Lockeys.lock(Lockeys.get(User.getTable(), userid));
/*    */     
/* 31 */     ReleaseStorageExpResult res = RoleInterface.releaseExp(userid, this.roleId, new TLogArg(LogReason.ROLE_GM_EXP_RELEASE));
/* 32 */     if (!res.isReleaseSuc())
/*    */     {
/* 34 */       GmManager.getInstance().sendResultToGM(this.roleId, String.format("释放失败！原因=%s", new Object[] { res.getReason() }));
/* 35 */       return false;
/*    */     }
/* 37 */     GmManager.getInstance().sendResultToGM(this.roleId, String.format("释放成功！总释放经验=%d|转换经验=%d|转换修炼=%d", new Object[] { Integer.valueOf(res.getTotalReleaseExp()), Integer.valueOf(res.getConvert2exp()), Integer.valueOf(res.getConvert2xiu()) }));
/*    */     
/*    */ 
/*    */ 
/* 41 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\PGM_ReleaseExp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */