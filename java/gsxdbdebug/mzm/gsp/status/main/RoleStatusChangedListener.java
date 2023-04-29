/*    */ package mzm.gsp.status.main;
/*    */ 
/*    */ import java.util.Set;
/*    */ import mzm.event.TriggerEventsManger;
/*    */ import mzm.gsp.status.event.RoleStatusChangeArg;
/*    */ import mzm.gsp.status.event.RoleStatusChanged;
/*    */ import xdb.logs.Listener;
/*    */ import xdb.logs.Note;
/*    */ import xdb.logs.NoteSet;
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
/*    */ class RoleStatusChangedListener
/*    */   implements Listener
/*    */ {
/*    */   public void onChanged(Object key) {}
/*    */   
/*    */   public void onRemoved(Object key) {}
/*    */   
/*    */   public void onChanged(Object key, String fullVarName, Note note)
/*    */   {
/* 29 */     if ((note instanceof NoteSet)) {
/* 30 */       NoteSet<Integer> noteSet = (NoteSet)note;
/* 31 */       long roleid = ((Long)key).longValue();
/* 32 */       RoleStatusChangeArg arg = new RoleStatusChangeArg(roleid);
/* 33 */       arg.addedset.addAll(noteSet.getAdded());
/* 34 */       arg.remedSet.addAll(noteSet.getRemoved());
/* 35 */       RoleStatusChanged roleStatusChanged = new RoleStatusChanged();
/* 36 */       TriggerEventsManger.getInstance().triggerEventAtOnce(roleStatusChanged, arg);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\status\main\RoleStatusChangedListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */