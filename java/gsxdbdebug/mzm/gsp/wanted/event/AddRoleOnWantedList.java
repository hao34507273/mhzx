/*    */ package mzm.gsp.wanted.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class AddRoleOnWantedList extends mzm.event.BasicEvent<AddRoleOnWantedListArg>
/*    */ {
/*  7 */   private static EventManager<AddRoleOnWantedListArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<AddRoleOnWantedListArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wanted\event\AddRoleOnWantedList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */