/*    */ package mzm.gsp.constellation.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class ChooseCard extends mzm.event.BasicEvent<ChooseCardArg>
/*    */ {
/*  7 */   private static EventManager<ChooseCardArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<ChooseCardArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.achievement.main.POnChooseCard());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\constellation\event\ChooseCard.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */