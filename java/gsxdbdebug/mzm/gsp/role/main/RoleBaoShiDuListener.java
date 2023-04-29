/*    */ package mzm.gsp.role.main;
/*    */ 
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.SSyncBaoShiDuInfo;
/*    */ import mzm.gsp.util.LogicProcedure;
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
/*    */ 
/*    */ public class RoleBaoShiDuListener
/*    */   implements Listener
/*    */ {
/*    */   public void onChanged(Object key) {}
/*    */   
/*    */   public void onRemoved(Object key) {}
/*    */   
/*    */   public void onChanged(Object key, String fullVarName, Note note)
/*    */   {
/* 29 */     final long roleId = ((Long)key).longValue();
/* 30 */     new LogicProcedure()
/*    */     {
/*    */ 
/*    */       protected boolean processImp()
/*    */         throws Exception
/*    */       {
/* 36 */         SSyncBaoShiDuInfo info = new SSyncBaoShiDuInfo();
/* 37 */         info.baoshudu = Role2properties.selectBaoshidu(Long.valueOf(roleId)).intValue();
/* 38 */         OnlineManager.getInstance().send(roleId, info);
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 53 */         return true;
/*    */       }
/*    */     }.execute();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\RoleBaoShiDuListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */