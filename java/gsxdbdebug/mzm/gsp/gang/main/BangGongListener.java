/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import xdb.Procedure;
/*    */ import xdb.logs.Listener;
/*    */ import xdb.logs.Note;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BangGongListener
/*    */   implements Listener
/*    */ {
/*    */   public void onChanged(Object o) {}
/*    */   
/*    */   public void onRemoved(Object o) {}
/*    */   
/*    */   public void onChanged(Object o, String s, Note note)
/*    */   {
/* 25 */     long roleId = ((Long)o).longValue();
/* 26 */     Procedure.execute(new PBangGongChanged(roleId));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\BangGongListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */