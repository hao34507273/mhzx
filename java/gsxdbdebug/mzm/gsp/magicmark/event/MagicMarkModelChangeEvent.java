/*    */ package mzm.gsp.magicmark.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class MagicMarkModelChangeEvent extends mzm.event.BasicEvent<Long>
/*    */ {
/*  7 */   private static EventManager<Long> manager = new EventManager();
/*    */   
/*    */   public EventManager<Long> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.map.main.POnRoleMagicMarkModelChangeEvent());
/* 16 */     manager.register(new mzm.gsp.team.main.POnMagicMarkModelChange());
/* 17 */     manager.register(new mzm.gsp.corps.main.POnMagicMarkModelChange());
/* 18 */     manager.register(new mzm.gsp.shitu.main.POnMagicMarkModelChange());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\magicmark\event\MagicMarkModelChangeEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */