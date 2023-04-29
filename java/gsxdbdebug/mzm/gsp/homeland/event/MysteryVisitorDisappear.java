/*    */ package mzm.gsp.homeland.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class MysteryVisitorDisappear extends mzm.event.BasicEvent<MysteryVisitorDisappearArg>
/*    */ {
/*  7 */   private static EventManager<MysteryVisitorDisappearArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<MysteryVisitorDisappearArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.homeland.main.POnMysteryVisitorDisappear());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\event\MysteryVisitorDisappear.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */