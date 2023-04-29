/*    */ package mzm.gsp.pk.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class MoralValueChanged extends mzm.event.BasicEvent<MoralValueChangeArg>
/*    */ {
/*  7 */   private static EventManager<MoralValueChangeArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<MoralValueChangeArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.wanted.main.POnRoleMoralValueChanged());
/* 16 */     manager.register(new mzm.gsp.pk.main.POnMoralValueChanged());
/* 17 */     manager.register(new mzm.gsp.map.main.POnMoralValueChanged());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pk\event\MoralValueChanged.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */