/*    */ package mzm.gsp.item.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class EquipQiLin extends mzm.event.BasicEvent<mzm.gsp.item.main.EquipQiLinArg>
/*    */ {
/*  7 */   private static EventManager<mzm.gsp.item.main.EquipQiLinArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<mzm.gsp.item.main.EquipQiLinArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.team.main.POnEquipQiLin());
/* 16 */     manager.register(new mzm.gsp.grow.LevelGuide.POnEquipQiLin());
/* 17 */     manager.register(new mzm.gsp.achievement.main.POnEquipQiLin());
/* 18 */     manager.register(new mzm.gsp.task.main.POnEquipQiLin());
/* 19 */     manager.register(new mzm.gsp.corps.main.POnEquipQiLin());
/* 20 */     manager.register(new mzm.gsp.shitu.main.POnEquipQiLin());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\event\EquipQiLin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */