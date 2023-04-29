/*    */ package mzm.gsp.fabao.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class FabaoSysChange extends mzm.event.BasicEvent<FabaoSysChangeArg>
/*    */ {
/*  7 */   private static EventManager<FabaoSysChangeArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<FabaoSysChangeArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.role.main.POnFabaoSysChange());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fabao\event\FabaoSysChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */