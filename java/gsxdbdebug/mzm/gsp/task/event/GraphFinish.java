/*    */ package mzm.gsp.task.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class GraphFinish extends mzm.event.BasicEvent<mzm.gsp.task.main.GraphFinishArg>
/*    */ {
/*  7 */   private static EventManager<mzm.gsp.task.main.GraphFinishArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<mzm.gsp.task.main.GraphFinishArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.circletask.main.POnGraphFinish());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\event\GraphFinish.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */