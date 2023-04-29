/*    */ package mzm.gsp.role.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.SSyncMoneyChange;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xdb.Procedure;
/*    */ import xdb.logs.Listener;
/*    */ import xdb.logs.Note;
/*    */ import xtable.Role2properties;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class RoleGoldListener
/*    */   implements Listener
/*    */ {
/*    */   public void onChanged(Object o) {}
/*    */   
/*    */   public void onRemoved(Object o) {}
/*    */   
/*    */   public void onChanged(Object o, String s, Note note)
/*    */   {
/* 29 */     final Long roleId = (Long)o;
/*    */     
/* 31 */     Procedure.execute(new LogicProcedure()
/*    */     {
/*    */       protected boolean processImp()
/*    */         throws Exception
/*    */       {
/* 36 */         long gold = Role2properties.selectGold(roleId).longValue();
/* 37 */         SSyncMoneyChange moneyChange = new SSyncMoneyChange();
/* 38 */         moneyChange.changemoneymap.put(Integer.valueOf(0), Long.valueOf(gold));
/* 39 */         OnlineManager.getInstance().send(roleId.longValue(), moneyChange);
/* 40 */         return true;
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\RoleGoldListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */