/*    */ package mzm.gsp.item.main;
/*    */ 
/*    */ import xdb.logs.Listener;
/*    */ import xdb.logs.Note;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BagChanged
/*    */   implements Listener
/*    */ {
/*    */   final int bagid;
/*    */   
/*    */   public BagChanged(int bagid)
/*    */   {
/* 17 */     this.bagid = bagid;
/*    */   }
/*    */   
/*    */ 
/*    */   public void onChanged(Object key, String fullVarName, Note note)
/*    */   {
/* 23 */     BagChangedProcedure bagChangedProcedure = new BagChangedProcedure(((Long)key).longValue(), this.bagid, note);
/*    */     
/* 25 */     bagChangedProcedure.execute();
/*    */   }
/*    */   
/*    */   public void onChanged(Object key) {}
/*    */   
/*    */   public void onRemoved(Object key) {}
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\BagChanged.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */