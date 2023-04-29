/*    */ package mzm.gsp.title.main;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PRemoveAppellation extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int appellationId;
/*    */   
/*    */   public PRemoveAppellation(long roleId, int appellationId) {
/* 11 */     this.roleId = roleId;
/* 12 */     this.appellationId = appellationId;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 17 */     return TitleManager.pRmAppellantionImpl(this.roleId, this.appellationId);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\title\main\PRemoveAppellation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */