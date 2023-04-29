/*    */ package mzm.gsp.wing.main2;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PGM_AddWing
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int wingId;
/*    */   
/*    */   public PGM_AddWing(long roleId, int wingId)
/*    */   {
/* 17 */     this.roleId = roleId;
/* 18 */     this.wingId = wingId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 24 */     return new PAddWing(this.roleId, this.wingId).call();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wing\main2\PGM_AddWing.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */