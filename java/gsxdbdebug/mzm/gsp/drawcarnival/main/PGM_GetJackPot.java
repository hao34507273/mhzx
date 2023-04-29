/*    */ package mzm.gsp.drawcarnival.main;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PGM_GetJackPot extends LogicProcedure
/*    */ {
/*    */   final long gmRoleId;
/*    */   
/*    */   public PGM_GetJackPot(long gmRoleId)
/*    */   {
/* 12 */     this.gmRoleId = gmRoleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 18 */     GmManager.getInstance().sendResultToGM(this.gmRoleId, String.valueOf(DrawCarnivalInterface.getJackPot()));
/*    */     
/* 20 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\drawcarnival\main\PGM_GetJackPot.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */