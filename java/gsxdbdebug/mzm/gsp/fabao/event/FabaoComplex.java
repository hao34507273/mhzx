/*    */ package mzm.gsp.fabao.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class FabaoComplex extends mzm.event.BasicEvent<FabaoComplexArg>
/*    */ {
/*  7 */   private static EventManager<FabaoComplexArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<FabaoComplexArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.grow.LevelGuide.POnFabaoComplex());
/* 16 */     manager.register(new mzm.gsp.achievement.main.POnFabaoComplex());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fabao\event\FabaoComplex.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */