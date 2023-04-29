/*    */ package mzm.gsp.title.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PAddAppellationId
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int appellationId;
/*    */   private final List<String> args;
/*    */   private final boolean needWear;
/*    */   
/*    */   public PAddAppellationId(long roleId, int appellationId, List<String> args, boolean needWear)
/*    */   {
/* 20 */     this.roleId = roleId;
/* 21 */     this.appellationId = appellationId;
/* 22 */     this.args = args;
/* 23 */     this.needWear = needWear;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception {
/* 27 */     return TitleManager.addNewAppellation(this.roleId, this.appellationId, this.args, this.needWear);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\title\main\PAddAppellationId.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */