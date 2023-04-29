/*    */ package mzm.gsp.multioccupation.main;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.MultiOccupation;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PMultiOccupationReq
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   
/*    */   public PMultiOccupationReq(long roleid)
/*    */   {
/* 16 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 22 */     MultiOccupation xMultiOccup = MultiOccupManager.getXMultiOccup(this.roleid, true);
/*    */     
/* 24 */     MultiOccupManager.sendMultiOccup(this.roleid, xMultiOccup);
/*    */     
/* 26 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\multioccupation\main\PMultiOccupationReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */