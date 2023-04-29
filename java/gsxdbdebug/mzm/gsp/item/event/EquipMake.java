/*    */ package mzm.gsp.item.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class EquipMake extends mzm.event.BasicEvent<mzm.gsp.item.main.EquipMakeArg>
/*    */ {
/*  7 */   private static EventManager<mzm.gsp.item.main.EquipMakeArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<mzm.gsp.item.main.EquipMakeArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.grow.LevelGuide.POnEquipMake());
/* 16 */     manager.register(new mzm.gsp.achievement.main.POnEquipMake());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\event\EquipMake.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */