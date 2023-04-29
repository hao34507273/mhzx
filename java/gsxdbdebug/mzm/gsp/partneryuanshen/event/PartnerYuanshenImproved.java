/*    */ package mzm.gsp.partneryuanshen.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class PartnerYuanshenImproved extends mzm.event.BasicEvent<PartnerYuanshenImprovedArg>
/*    */ {
/*  7 */   private static EventManager<PartnerYuanshenImprovedArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<PartnerYuanshenImprovedArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.partner.main.POnPartnerYuanshenImproved());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\partneryuanshen\event\PartnerYuanshenImproved.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */