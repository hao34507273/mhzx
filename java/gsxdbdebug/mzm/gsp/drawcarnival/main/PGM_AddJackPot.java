/*    */ package mzm.gsp.drawcarnival.main;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PGM_AddJackPot extends LogicProcedure
/*    */ {
/*    */   final long gmRoleId;
/*    */   final long count;
/*    */   
/*    */   public PGM_AddJackPot(long gmRoleId, long count)
/*    */   {
/* 13 */     this.gmRoleId = gmRoleId;
/* 14 */     this.count = count;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 20 */     boolean ret = DrawCarnivalInterface.addJackPot(this.count);
/* 21 */     if (!ret)
/*    */     {
/* 23 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "数量必须正数");
/* 24 */       return false;
/*    */     }
/* 26 */     GmManager.getInstance().sendResultToGM(this.gmRoleId, "设置成功");
/* 27 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\drawcarnival\main\PGM_AddJackPot.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */