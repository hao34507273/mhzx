/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import mzm.gsp.gang.SSyncGangMoneyChange;
/*    */ import xbean.JinKu;
/*    */ import xdb.logs.Listener;
/*    */ import xdb.logs.Note;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class JinKuListener
/*    */   implements Listener
/*    */ {
/*    */   public void onChanged(Object o) {}
/*    */   
/*    */   public void onRemoved(Object o) {}
/*    */   
/*    */   public void onChanged(Object o, String s, Note note)
/*    */   {
/* 23 */     xbean.Gang xGang = xtable.Gang.select((Long)o);
/* 24 */     SSyncGangMoneyChange sSyncGangMoneyChange = new SSyncGangMoneyChange();
/* 25 */     sSyncGangMoneyChange.gangmoney = xGang.getJinku().getGangmoney();
/* 26 */     GangManager.broadcast(xGang, sSyncGangMoneyChange);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\JinKuListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */