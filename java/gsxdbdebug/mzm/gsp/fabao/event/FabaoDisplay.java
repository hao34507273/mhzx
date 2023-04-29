/*    */ package mzm.gsp.fabao.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class FabaoDisplay extends mzm.event.BasicEvent<FabaoDisplayArg>
/*    */ {
/*  7 */   private static EventManager<FabaoDisplayArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<FabaoDisplayArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.map.main.POnFabaoDisplay());
/* 16 */     manager.register(new mzm.gsp.team.main.POnFabaoDisplay());
/* 17 */     manager.register(new mzm.gsp.corps.main.POnFabaoDisplay());
/* 18 */     manager.register(new mzm.gsp.fabaolingqi.main.POnFabaoDisplay());
/* 19 */     manager.register(new mzm.gsp.shitu.main.POnFabaoDisplay());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fabao\event\FabaoDisplay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */