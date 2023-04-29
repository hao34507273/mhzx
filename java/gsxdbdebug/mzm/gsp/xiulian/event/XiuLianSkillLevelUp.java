/*    */ package mzm.gsp.xiulian.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class XiuLianSkillLevelUp extends mzm.event.BasicEvent<XiuLianSkillArg>
/*    */ {
/*  7 */   private static EventManager<XiuLianSkillArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<XiuLianSkillArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.role.main.POnXiuLianSkillLevelUp());
/* 16 */     manager.register(new mzm.gsp.pet.main.POnXiuLianSkillLevelUp());
/* 17 */     manager.register(new mzm.gsp.children.main.POnXiuLianSkillLevelUp());
/* 18 */     manager.register(new mzm.gsp.partner.main.POnXiuLianSkillLevelUp());
/* 19 */     manager.register(new mzm.gsp.grow.LevelGuide.POnXiuLianSkillLevelUp());
/* 20 */     manager.register(new mzm.gsp.achievement.main.POnXiuLianSkillLevelUp());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\xiulian\event\XiuLianSkillLevelUp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */