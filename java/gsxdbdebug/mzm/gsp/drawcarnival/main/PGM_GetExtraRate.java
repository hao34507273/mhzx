/*    */ package mzm.gsp.drawcarnival.main;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PGM_GetExtraRate extends LogicProcedure
/*    */ {
/*    */   final long gmRoleId;
/*    */   final int activityId;
/*    */   final int passTypeId;
/*    */   
/*    */   public PGM_GetExtraRate(long gmRoleId, int activityId, int passTypeId)
/*    */   {
/* 14 */     this.gmRoleId = gmRoleId;
/* 15 */     this.activityId = activityId;
/* 16 */     this.passTypeId = passTypeId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 22 */     GmManager.getInstance().sendResultToGM(this.gmRoleId, DrawCarnivalInterface.getExtraRate(this.activityId, this.passTypeId));
/*    */     
/* 24 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\drawcarnival\main\PGM_GetExtraRate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */