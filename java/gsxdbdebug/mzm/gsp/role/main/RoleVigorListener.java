/*    */ package mzm.gsp.role.main;
/*    */ 
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.SSyncVigorChange;
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
/*    */ 
/*    */ public class RoleVigorListener
/*    */   implements Listener
/*    */ {
/*    */   public void onChanged(Object key) {}
/*    */   
/*    */   public void onRemoved(Object key) {}
/*    */   
/*    */   public void onChanged(Object key, String fullVarName, Note note)
/*    */   {
/* 29 */     final Long roleId = (Long)key;
/*    */     
/* 31 */     Procedure.execute(new LogicProcedure()
/*    */     {
/*    */ 
/*    */       protected boolean processImp()
/*    */         throws Exception
/*    */       {
/* 37 */         int vigor = Role2properties.selectVigor(roleId).intValue();
/* 38 */         SSyncVigorChange sSyncVigorChange = new SSyncVigorChange();
/* 39 */         sSyncVigorChange.vigor = vigor;
/* 40 */         OnlineManager.getInstance().send(roleId.longValue(), sSyncVigorChange);
/* 41 */         return true;
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\RoleVigorListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */