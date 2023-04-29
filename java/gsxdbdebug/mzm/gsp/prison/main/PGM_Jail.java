/*    */ package mzm.gsp.prison.main;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PGM_Jail
/*    */   extends LogicProcedure
/*    */ {
/*    */   final long targetRoleId;
/*    */   final long gmRoleId;
/*    */   
/*    */   public PGM_Jail(long targetRoleId, long gmRoleId)
/*    */   {
/* 16 */     this.targetRoleId = targetRoleId;
/* 17 */     this.gmRoleId = gmRoleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 23 */     if (PrisonInterface.isRoleInJail(this.targetRoleId))
/*    */     {
/* 25 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "角色已经在监狱");
/*    */     }
/*    */     else
/*    */     {
/* 29 */       PrisonInterface.putRoleInJail(this.targetRoleId);
/* 30 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "角色入狱成功");
/*    */     }
/* 32 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\prison\main\PGM_Jail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */