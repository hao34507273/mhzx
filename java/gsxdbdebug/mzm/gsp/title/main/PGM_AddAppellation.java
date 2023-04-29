/*    */ package mzm.gsp.title.main;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PGM_AddAppellation extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int appellationId;
/*    */   
/*    */   public PGM_AddAppellation(long roleId, int appellationId) {
/* 11 */     this.roleId = roleId;
/* 12 */     this.appellationId = appellationId;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception {
/* 16 */     return TitleInterface.addAppellation(this.roleId, this.appellationId);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\title\main\PGM_AddAppellation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */