/*    */ package mzm.gsp.fashiondress.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class GetNewFashionDress extends mzm.event.BasicEvent<GetNewFashionDressArg>
/*    */ {
/*  7 */   private static EventManager<GetNewFashionDressArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<GetNewFashionDressArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.achievement.main.POnGetNewFashionDress());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fashiondress\event\GetNewFashionDress.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */