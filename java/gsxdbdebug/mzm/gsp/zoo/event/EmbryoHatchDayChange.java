/*    */ package mzm.gsp.zoo.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class EmbryoHatchDayChange extends mzm.event.BasicEvent<EmbryoHatchDayChangeArg>
/*    */ {
/*  7 */   private static EventManager<EmbryoHatchDayChangeArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<EmbryoHatchDayChangeArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.homeland.main.POnAnimalEmbryoHatchDayChange());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\zoo\event\EmbryoHatchDayChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */