/*    */ package mzm.gsp.menpaistar.main;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PReturnCost extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   
/*    */   public PReturnCost(long roleid)
/*    */   {
/* 11 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 17 */     MenPaiStarManager.returnCost(this.roleid, false);
/* 18 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\menpaistar\main\PReturnCost.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */