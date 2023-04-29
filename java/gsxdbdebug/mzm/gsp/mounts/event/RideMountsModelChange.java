/*    */ package mzm.gsp.mounts.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class RideMountsModelChange extends mzm.event.BasicEvent<RideMountsModelChangeArg>
/*    */ {
/*  7 */   private static EventManager<RideMountsModelChangeArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<RideMountsModelChangeArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.map.main.POnRideMountsModelChange());
/* 16 */     manager.register(new mzm.gsp.team.main.POnRideMountsModelChange());
/* 17 */     manager.register(new mzm.gsp.corps.main.POnRideMountsModelChange());
/* 18 */     manager.register(new mzm.gsp.shitu.main.POnRideMountsModelChange());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mounts\event\RideMountsModelChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */