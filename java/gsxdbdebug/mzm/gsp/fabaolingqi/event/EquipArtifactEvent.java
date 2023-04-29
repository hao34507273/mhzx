/*    */ package mzm.gsp.fabaolingqi.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class EquipArtifactEvent extends mzm.event.BasicEvent<EquipArtifactArg>
/*    */ {
/*  7 */   private static EventManager<EquipArtifactArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<EquipArtifactArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.fabao.main.POnEquipArtifact());
/* 16 */     manager.register(new mzm.gsp.map.main.POnEquipFabaoLingqi());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fabaolingqi\event\EquipArtifactEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */