/*    */ package mzm.gsp.item.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class EquipSkillRefresh extends mzm.event.BasicEvent<EquipSkillRefreshArg>
/*    */ {
/*  7 */   private static EventManager<EquipSkillRefreshArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<EquipSkillRefreshArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.achievement.main.POnEquipSkillRefresh());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\event\EquipSkillRefresh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */