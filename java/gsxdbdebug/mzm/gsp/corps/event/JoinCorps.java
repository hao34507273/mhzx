/*    */ package mzm.gsp.corps.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class JoinCorps extends mzm.event.BasicEvent<JoinCorpsEventArg>
/*    */ {
/*  7 */   private static EventManager<JoinCorpsEventArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<JoinCorpsEventArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.corps.main.POnJoinCorps());
/* 16 */     manager.register(new mzm.gsp.crossbattle.own.POnJoinCorps());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\corps\event\JoinCorps.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */