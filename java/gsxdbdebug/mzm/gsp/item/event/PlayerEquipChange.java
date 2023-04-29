/*    */ package mzm.gsp.item.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class PlayerEquipChange extends mzm.event.BasicEvent<mzm.gsp.item.main.EquipChangeArg>
/*    */ {
/*  7 */   private static EventManager<mzm.gsp.item.main.EquipChangeArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<mzm.gsp.item.main.EquipChangeArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.role.main.POnPlayerEquipChange());
/* 16 */     manager.register(new mzm.gsp.map.main.POnPlayerEquipChange());
/* 17 */     manager.register(new mzm.gsp.team.main.POnPlayerEquipChange());
/* 18 */     manager.register(new mzm.gsp.corps.main.POnPlayerEquipChange());
/* 19 */     manager.register(new mzm.gsp.superequipment.wushi.main.POnPlayerEquipChange());
/* 20 */     manager.register(new mzm.gsp.shitu.main.POnPlayerEquipChange());
/* 21 */     manager.register(new mzm.gsp.achievement.main.POnPlayerEquipChange());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\event\PlayerEquipChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */