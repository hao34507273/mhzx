/*    */ package mzm.gsp.marriage.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class MarriageEvent extends mzm.event.BasicEvent<MarriageArg>
/*    */ {
/*  7 */   private static EventManager<MarriageArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<MarriageArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.marriage.main.POnMarraige());
/* 16 */     manager.register(new mzm.gsp.homeland.main.POnMarraige());
/* 17 */     manager.register(new mzm.gsp.homeland.mysteryvisitor.POnMarraige());
/* 18 */     manager.register(new mzm.gsp.achievement.main.POnMarraige());
/* 19 */     manager.register(new mzm.gsp.christmasstocking.main.POnMarraige());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\marriage\event\MarriageEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */