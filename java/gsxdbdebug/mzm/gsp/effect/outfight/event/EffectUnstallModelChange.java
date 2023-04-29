/*    */ package mzm.gsp.effect.outfight.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class EffectUnstallModelChange extends mzm.event.BasicEvent<EffectUnstallModelChangeArg>
/*    */ {
/*  7 */   private static EventManager<EffectUnstallModelChangeArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<EffectUnstallModelChangeArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.role.changemodel.POnEffectUnstallModelChange());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\outfight\event\EffectUnstallModelChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */