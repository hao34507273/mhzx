/*    */ package mzm.gsp.crosscompete.roam;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ class PRemoveRoamEnterContext extends LogicProcedure
/*    */ {
/*    */   private final long contextid;
/*    */   
/*    */   PRemoveRoamEnterContext(long contextid) {
/* 10 */     this.contextid = contextid;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 15 */     RoamEnterContextManager.getInstance().removeContext(this.contextid);
/*    */     
/* 17 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crosscompete\roam\PRemoveRoamEnterContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */