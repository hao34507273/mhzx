/*    */ package mzm.gsp.item.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class EquipSkillGet extends mzm.event.BasicEvent<EquipSkillGetArg>
/*    */ {
/*  7 */   private static EventManager<EquipSkillGetArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<EquipSkillGetArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.achievement.main.POnEquipSkillGet());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\event\EquipSkillGet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */