/*    */ package mzm.gsp.partner.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class LineUpPartner extends mzm.event.BasicEvent<LineUpPartnerEventArg>
/*    */ {
/*  7 */   private static EventManager<LineUpPartnerEventArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<LineUpPartnerEventArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.grow.LevelGuide.POnLineUpPartner());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\partner\event\LineUpPartner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */