/*    */ package mzm.gsp.npc.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class FinishDlgEvent extends mzm.event.BasicEvent<FinishDlgArg>
/*    */ {
/*  7 */   private static EventManager<FinishDlgArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<FinishDlgArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.task.main.POnFinishNpcDlg());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\npc\event\FinishDlgEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */