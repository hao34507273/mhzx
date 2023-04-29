/*    */ package mzm.gsp.partner.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class ChangePartnerZhenFaId extends mzm.event.BasicEvent<ChangePartnerZhenFaIdArg>
/*    */ {
/*  7 */   private static EventManager<ChangePartnerZhenFaIdArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<ChangePartnerZhenFaIdArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.team.main.POnChangePartnerZhenFaId());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\partner\event\ChangePartnerZhenFaId.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */