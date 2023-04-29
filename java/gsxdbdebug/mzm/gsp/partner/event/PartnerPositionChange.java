/*    */ package mzm.gsp.partner.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class PartnerPositionChange extends mzm.event.BasicEvent<mzm.gsp.partner.main.PartnerPositionChangeEventArg>
/*    */ {
/*  7 */   private static EventManager<mzm.gsp.partner.main.PartnerPositionChangeEventArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<mzm.gsp.partner.main.PartnerPositionChangeEventArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.team.main.POnPartnerPositionChange());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\partner\event\PartnerPositionChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */