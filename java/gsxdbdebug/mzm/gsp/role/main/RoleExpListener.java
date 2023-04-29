/*    */ package mzm.gsp.role.main;
/*    */ 
/*    */ import mzm.event.TriggerEventsManger;
/*    */ import mzm.gsp.role.event.RolePropertyChange;
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
/*    */ 
/*    */ 
/*    */ class RoleExpListener
/*    */   implements Listener
/*    */ {
/*    */   public void onChanged(Object o) {}
/*    */   
/*    */   public void onRemoved(Object o) {}
/*    */   
/*    */   public void onChanged(Object o, String s, Note note)
/*    */   {
/* 28 */     Long roleId = (Long)o;
/* 29 */     RolePropertyChange change = new RolePropertyChange();
/* 30 */     TriggerEventsManger.getInstance().triggerEventAtOnce(change, roleId);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\RoleExpListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */