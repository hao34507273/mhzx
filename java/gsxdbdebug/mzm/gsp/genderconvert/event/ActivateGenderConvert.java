/*    */ package mzm.gsp.genderconvert.event;
/*    */ 
/*    */ import mzm.event.BasicEvent;
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class ActivateGenderConvert
/*    */   extends BasicEvent<ActivateGenderConvertArg>
/*    */ {
/*  9 */   private static EventManager<ActivateGenderConvertArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<ActivateGenderConvertArg> getEventManager()
/*    */   {
/* 13 */     return manager;
/*    */   }
/*    */   
/*    */   static
/*    */   {
/* 18 */     manager.register(new mzm.gsp.map.main.POnRoleActivateGenderConvert());
/* 19 */     manager.register(new mzm.gsp.corps.main.POnRoleActivateGenderConvert());
/* 20 */     manager.register(new mzm.gsp.friendscircle.main.POnRoleActivateGenderConvert());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\genderconvert\event\ActivateGenderConvert.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */