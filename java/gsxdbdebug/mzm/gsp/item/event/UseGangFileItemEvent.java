/*    */ package mzm.gsp.item.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class UseGangFileItemEvent extends mzm.event.BasicEvent<UseGangFileItemArg>
/*    */ {
/*  7 */   private static EventManager<UseGangFileItemArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<UseGangFileItemArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.worship.main.POnUseFactionFile());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\event\UseGangFileItemEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */