/*    */ package mzm.gsp.mounts.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class NewMountsGet extends mzm.event.BasicEvent<NewMountsGetArg>
/*    */ {
/*  7 */   private static EventManager<NewMountsGetArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<NewMountsGetArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.achievement.main.POnNewMountsGet());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mounts\event\NewMountsGet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */