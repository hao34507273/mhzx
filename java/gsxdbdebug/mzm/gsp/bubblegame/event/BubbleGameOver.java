/*    */ package mzm.gsp.bubblegame.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class BubbleGameOver extends mzm.event.BasicEvent<BubbleGameOverArg>
/*    */ {
/*  7 */   private static EventManager<BubbleGameOverArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<BubbleGameOverArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.children.preparepregnancy.POnBubbleGameOver());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\bubblegame\event\BubbleGameOver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */