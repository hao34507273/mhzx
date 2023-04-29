/*    */ package mzm.gsp.drawcarnival.main;
/*    */ 
/*    */ import xdb.Lockeys;
/*    */ import xtable.Basic;
/*    */ 
/*    */ public class PGM_Draw extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   final long targetRoleId;
/*    */   final long gmRoleId;
/*    */   final int passType;
/*    */   final int passCount;
/*    */   
/*    */   public PGM_Draw(long targetRoleId, long gmRoleId, int passType, int passCount)
/*    */   {
/* 15 */     this.targetRoleId = targetRoleId;
/* 16 */     this.gmRoleId = gmRoleId;
/* 17 */     this.passType = passType;
/* 18 */     this.passCount = passCount;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 24 */     String userId = mzm.gsp.role.main.RoleInterface.getUserId(this.targetRoleId);
/*    */     
/*    */ 
/* 27 */     lock(Lockeys.get(xtable.User.getTable(), userId));
/*    */     
/* 29 */     lock(Lockeys.get(Basic.getTable(), Long.valueOf(this.targetRoleId)));
/*    */     
/* 31 */     int freePassCount = DrawCarnivalManager.getCurrentFreePassCount(this.targetRoleId, this.passType);
/*    */     
/* 33 */     for (int i = 0; i < freePassCount; i++)
/*    */     {
/* 35 */       new PCDrawReq(this.targetRoleId, this.passType, 1, (byte)0, false).call();
/*    */     }
/*    */     
/* 38 */     int feePassCount = this.passCount - freePassCount;
/* 39 */     int tenPassCount = feePassCount / 10;
/* 40 */     for (int i = 0; i < tenPassCount; i++)
/*    */     {
/* 42 */       new PCDrawReq(this.targetRoleId, this.passType, 10, (byte)1, false).call();
/*    */     }
/*    */     
/* 45 */     int onePassCount = feePassCount % 10;
/* 46 */     for (int i = 0; i < onePassCount; i++)
/*    */     {
/* 48 */       new PCDrawReq(this.targetRoleId, this.passType, 1, (byte)1, false).call();
/*    */     }
/* 50 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\drawcarnival\main\PGM_Draw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */