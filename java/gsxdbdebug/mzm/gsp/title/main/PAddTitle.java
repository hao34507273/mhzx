/*    */ package mzm.gsp.title.main;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PAddTitle
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int titleId;
/*    */   
/*    */   public PAddTitle(long roleId, int titleId)
/*    */   {
/* 16 */     this.roleId = roleId;
/* 17 */     this.titleId = titleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception {
/* 21 */     return TitleManager.addNewTitle(this.roleId, this.titleId);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\title\main\PAddTitle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */