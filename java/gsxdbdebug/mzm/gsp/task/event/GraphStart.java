/*    */ package mzm.gsp.task.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class GraphStart extends mzm.event.BasicEvent<mzm.gsp.task.main.GraphStartArg>
/*    */ {
/*  7 */   private static EventManager<mzm.gsp.task.main.GraphStartArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<mzm.gsp.task.main.GraphStartArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.huanhun.main.PonGraphStart());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\event\GraphStart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */