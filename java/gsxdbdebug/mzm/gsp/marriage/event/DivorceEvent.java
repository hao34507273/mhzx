/*    */ package mzm.gsp.marriage.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class DivorceEvent extends mzm.event.BasicEvent<DivorceArg>
/*    */ {
/*  7 */   private static EventManager<DivorceArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<DivorceArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.skill.main.POnDivorce());
/* 16 */     manager.register(new mzm.gsp.homeland.main.POnDivorce());
/* 17 */     manager.register(new mzm.gsp.homeland.mysteryvisitor.POnDivorce());
/* 18 */     manager.register(new mzm.gsp.achievement.main.POnDivorce());
/* 19 */     manager.register(new mzm.gsp.christmasstocking.main.POnDivorce());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\marriage\event\DivorceEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */