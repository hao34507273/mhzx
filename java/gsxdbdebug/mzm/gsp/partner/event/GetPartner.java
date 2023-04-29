/*    */ package mzm.gsp.partner.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class GetPartner extends mzm.event.BasicEvent<PartnerEventArg>
/*    */ {
/*  7 */   private static EventManager<PartnerEventArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<PartnerEventArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.grow.LevelGuide.POnGetPartner());
/* 16 */     manager.register(new mzm.gsp.achievement.main.POnGetPartner());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\partner\event\GetPartner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */