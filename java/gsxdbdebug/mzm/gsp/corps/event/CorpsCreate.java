/*    */ package mzm.gsp.corps.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class CorpsCreate extends mzm.event.BasicEvent<CorpsCreateEventArg>
/*    */ {
/*  7 */   private static EventManager<CorpsCreateEventArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<CorpsCreateEventArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.corps.main.POnCorpsCreate());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\corps\event\CorpsCreate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */