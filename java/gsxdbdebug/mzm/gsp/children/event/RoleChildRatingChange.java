/*    */ package mzm.gsp.children.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class RoleChildRatingChange extends mzm.event.BasicEvent<RoleChildRatingChangeArg>
/*    */ {
/*  7 */   private static EventManager<RoleChildRatingChangeArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<RoleChildRatingChangeArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\event\RoleChildRatingChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */