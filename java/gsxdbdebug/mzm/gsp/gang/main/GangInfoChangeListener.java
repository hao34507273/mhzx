/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ import xdb.logs.Listener;
/*    */ import xdb.logs.Note;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GangInfoChangeListener
/*    */   implements Listener
/*    */ {
/*    */   public void onChanged(Object key)
/*    */   {
/* 15 */     final long gangId = ((Long)key).longValue();
/* 16 */     NoneRealTimeTaskManager.getInstance().addTask(new LogicProcedure()
/*    */     {
/*    */       protected boolean processImp()
/*    */         throws Exception
/*    */       {
/* 21 */         GangManager.onAddGang(gangId);
/* 22 */         return true;
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void onRemoved(Object key)
/*    */   {
/* 31 */     final long gangId = ((Long)key).longValue();
/* 32 */     NoneRealTimeTaskManager.getInstance().addTask(new LogicProcedure()
/*    */     {
/*    */       protected boolean processImp()
/*    */         throws Exception
/*    */       {
/* 37 */         GangManager.onRemoveGang(gangId);
/* 38 */         return true;
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public void onChanged(Object key, String fullVarName, Note note) {}
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\GangInfoChangeListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */