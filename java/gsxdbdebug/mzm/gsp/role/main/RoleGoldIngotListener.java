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
/*    */ public class RoleGoldIngotListener
/*    */   implements Listener
/*    */ {
/*    */   public void onChanged(Object o) {}
/*    */   
/*    */   public void onRemoved(Object o) {}
/*    */   
/*    */   public void onChanged(Object o, String s, Note note)
/*    */   {
/* 26 */     final Long roleId = (Long)o;
/*    */     
/* 28 */     Procedure.execute(new LogicProcedure()
/*    */     {
/*    */       protected boolean processImp()
/*    */         throws Exception
/*    */       {
/* 33 */         long goldIngot = Role2properties.selectGoldingot(roleId).longValue();
/* 34 */         SSyncMoneyChange moneyChange = new SSyncMoneyChange();
/* 35 */         moneyChange.changemoneymap.put(Integer.valueOf(2), Long.valueOf(goldIngot));
/* 36 */         OnlineManager.getInstance().send(roleId.longValue(), moneyChange);
/* 37 */         return true;
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\RoleGoldIngotListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */