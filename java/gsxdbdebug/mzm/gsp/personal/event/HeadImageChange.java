/*    */ package mzm.gsp.personal.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class HeadImageChange extends mzm.event.BasicEvent<HeadImageArg>
/*    */ {
/*  7 */   private static EventManager<HeadImageArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<HeadImageArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.personal.main.POnHeadImageChange());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\personal\event\HeadImageChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */