/*    */ package mzm.gsp.zhenfa.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class ZhenfaLevelUp extends mzm.event.BasicEvent<ZhenfaLevelUpArg>
/*    */ {
/*  7 */   private static EventManager<ZhenfaLevelUpArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<ZhenfaLevelUpArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.team.main.POnZhenFaLvChange());
/* 16 */     manager.register(new mzm.gsp.grow.LevelGuide.POnZhenFaLvChange());
/* 17 */     manager.register(new mzm.gsp.achievement.main.POnZhenFaZhenfaLevelUp());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\zhenfa\event\ZhenfaLevelUp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */