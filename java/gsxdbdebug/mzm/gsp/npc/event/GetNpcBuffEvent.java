/*    */ package mzm.gsp.npc.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class GetNpcBuffEvent extends mzm.event.BasicEvent<GetNpcBuffArg>
/*    */ {
/*  7 */   private static EventManager<GetNpcBuffArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<GetNpcBuffArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.jiuxiao.main.POnGetNpcBuffEvent());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\npc\event\GetNpcBuffEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */