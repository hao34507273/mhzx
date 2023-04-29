/*    */ package mzm.gsp.title.main;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PGM_AddTitle extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int titleId;
/*    */   
/*    */   public PGM_AddTitle(long roleId, int titleId) {
/* 11 */     this.roleId = roleId;
/* 12 */     this.titleId = titleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception {
/* 16 */     return TitleManager.addNewTitle(this.roleId, this.titleId);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\title\main\PGM_AddTitle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */