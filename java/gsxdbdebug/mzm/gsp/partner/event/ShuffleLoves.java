/*    */ package mzm.gsp.partner.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class ShuffleLoves extends mzm.event.BasicEvent<PartnerLoveFlushArg>
/*    */ {
/*  7 */   private static EventManager<PartnerLoveFlushArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<PartnerLoveFlushArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.grow.LevelGuide.POnShuffleLoves());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\partner\event\ShuffleLoves.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */