/*    */ package mzm.gsp.personal.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class PersonalPraise extends mzm.event.BasicEvent<PersonalPraiseArg>
/*    */ {
/*  7 */   private static EventManager<PersonalPraiseArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<PersonalPraiseArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.achievement.main.POnPersonalPraise());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\personal\event\PersonalPraise.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */