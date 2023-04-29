/*    */ package mzm.gsp.guaji.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class FinishOneGuajiEvent extends mzm.event.BasicEvent<mzm.gsp.guaji.main.FinishOneGuajiEventArg>
/*    */ {
/*  7 */   private static EventManager<mzm.gsp.guaji.main.FinishOneGuajiEventArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<mzm.gsp.guaji.main.FinishOneGuajiEventArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.chivalry.main.POnFinishOneGuajiEvent());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\guaji\event\FinishOneGuajiEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */