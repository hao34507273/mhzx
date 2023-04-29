/*    */ package mzm.gsp.wanted.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class DeleteRoleOnWantedList extends mzm.event.BasicEvent<DeleteRoleOnWantedListArg>
/*    */ {
/*  7 */   private static EventManager<DeleteRoleOnWantedListArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<DeleteRoleOnWantedListArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wanted\event\DeleteRoleOnWantedList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */