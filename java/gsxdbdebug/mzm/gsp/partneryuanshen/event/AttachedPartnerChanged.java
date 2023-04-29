/*    */ package mzm.gsp.partneryuanshen.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class AttachedPartnerChanged extends mzm.event.BasicEvent<AttachedPartnerChangedArg>
/*    */ {
/*  7 */   private static EventManager<AttachedPartnerChangedArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<AttachedPartnerChangedArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.partner.main.POnPartnerYuanshenAttachedPartnerChanged());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\partneryuanshen\event\AttachedPartnerChanged.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */