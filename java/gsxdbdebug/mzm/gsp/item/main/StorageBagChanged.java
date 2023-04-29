/*    */ package mzm.gsp.item.main;
/*    */ 
/*    */ import xdb.logs.Listener;
/*    */ import xdb.logs.Note;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class StorageBagChanged
/*    */   implements Listener
/*    */ {
/*    */   final int bagid;
/*    */   
/*    */   public StorageBagChanged(int bagid)
/*    */   {
/* 17 */     this.bagid = bagid;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void onChanged(Object key, String fullVarName, Note note)
/*    */   {
/* 24 */     StorageChangedProcedure storageChangedProcedure = new StorageChangedProcedure(((Long)key).longValue(), this.bagid, note);
/*    */     
/* 26 */     storageChangedProcedure.execute();
/*    */   }
/*    */   
/*    */   public void onChanged(Object key) {}
/*    */   
/*    */   public void onRemoved(Object key) {}
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\StorageBagChanged.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */