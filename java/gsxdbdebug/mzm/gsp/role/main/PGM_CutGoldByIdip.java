/*    */ package mzm.gsp.role.main;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PGM_CutGoldByIdip extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final long cutValue;
/*    */   private final int type;
/*    */   
/*    */   public PGM_CutGoldByIdip(long roleId, long cutValue, int type)
/*    */   {
/* 16 */     this.roleId = roleId;
/* 17 */     this.cutValue = cutValue;
/* 18 */     this.type = type;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 24 */     MoneyOperResult result = null;
/* 25 */     switch (this.type)
/*    */     {
/*    */     case 1: 
/* 28 */       result = RoleInterface.cutGoldByIDIP(this.roleId, this.cutValue, new TLogArg(LogReason.GM_REM));
/*    */       
/* 30 */       break;
/*    */     case 2: 
/* 32 */       result = RoleInterface.cutGoldByAqIDIP(this.roleId, this.cutValue, new TLogArg(LogReason.GM_REM));
/* 33 */       break;
/*    */     
/*    */     default: 
/* 36 */       return false;
/*    */     }
/* 38 */     if (result == null)
/*    */     {
/* 40 */       return false;
/*    */     }
/* 42 */     GmManager.getInstance().sendResultToGM(this.roleId, "扣除金币操作结果：" + result.retMsg);
/* 43 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\PGM_CutGoldByIdip.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */