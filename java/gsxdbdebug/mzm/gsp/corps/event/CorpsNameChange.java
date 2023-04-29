/*    */ package mzm.gsp.corps.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class CorpsNameChange extends mzm.event.BasicEvent<CorpsNameChangeEventArg>
/*    */ {
/*  7 */   private static EventManager<CorpsNameChangeEventArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<CorpsNameChangeEventArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.corps.main.POnCorpsNameChange());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\corps\event\CorpsNameChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */