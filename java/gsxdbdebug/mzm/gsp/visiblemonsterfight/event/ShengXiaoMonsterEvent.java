/*    */ package mzm.gsp.visiblemonsterfight.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class ShengXiaoMonsterEvent extends mzm.event.BasicEvent<ShengXiaoMonsterArg>
/*    */ {
/*  7 */   private static EventManager<ShengXiaoMonsterArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<ShengXiaoMonsterArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.grow.LevelGuide.POnShengXiaoMonster());
/* 16 */     manager.register(new mzm.gsp.achievement.main.POnShengXiaoMonster());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\visiblemonsterfight\event\ShengXiaoMonsterEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */