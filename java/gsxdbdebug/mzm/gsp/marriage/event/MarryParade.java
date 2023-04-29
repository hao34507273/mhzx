/*    */ package mzm.gsp.marriage.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class MarryParade extends mzm.event.BasicEvent<MarryParadeArg>
/*    */ {
/*  7 */   private static EventManager<MarryParadeArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<MarryParadeArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.achievement.main.POnMarryParade());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\marriage\event\MarryParade.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */