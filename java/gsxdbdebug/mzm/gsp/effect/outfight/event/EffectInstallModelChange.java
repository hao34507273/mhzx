/*    */ package mzm.gsp.effect.outfight.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class EffectInstallModelChange extends mzm.event.BasicEvent<EffectInstallModelChangeArg>
/*    */ {
/*  7 */   private static EventManager<EffectInstallModelChangeArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<EffectInstallModelChangeArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.role.changemodel.POnEffectInstallModelChange());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\outfight\event\EffectInstallModelChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */