/*    */ package mzm.gsp.homeland.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class MysteryVisitorAppear extends mzm.event.BasicEvent<MysteryVisitorAppearArg>
/*    */ {
/*  7 */   private static EventManager<MysteryVisitorAppearArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<MysteryVisitorAppearArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.homeland.main.POnMysteryVisitorAppear());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\event\MysteryVisitorAppear.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */