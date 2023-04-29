/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import mzm.gsp.gang.SSyncGangVitalityChange;
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
/*    */ public class VitalityListener
/*    */   implements Listener
/*    */ {
/*    */   public void onChanged(Object o) {}
/*    */   
/*    */   public void onRemoved(Object o) {}
/*    */   
/*    */   public void onChanged(Object o, String s, Note note)
/*    */   {
/* 24 */     xbean.Gang xGang = xtable.Gang.select((Long)o);
/* 25 */     SSyncGangVitalityChange sync = new SSyncGangVitalityChange();
/* 26 */     sync.vitality = xGang.getVitality();
/* 27 */     GangManager.broadcast(xGang, sync);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\VitalityListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */