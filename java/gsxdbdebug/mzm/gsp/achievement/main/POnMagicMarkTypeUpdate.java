/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import mzm.gsp.magicmark.event.MagicMarkTypeUpdateArg;
/*    */ import mzm.gsp.magicmark.event.MagicMarkTypeUpdateEventProcedure;
/*    */ 
/*    */ public class POnMagicMarkTypeUpdate extends MagicMarkTypeUpdateEventProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 10 */     AchievementManager.updateGoalTypeState(((MagicMarkTypeUpdateArg)this.arg).roleId, 5800, null, "POnMagicMarkTypeUpdate.processImp@handle MAGIC_MARK_OWN success");
/*    */     
/*    */ 
/* 13 */     AchievementManager.updateGoalTypeState(((MagicMarkTypeUpdateArg)this.arg).roleId, 5801, Integer.valueOf(((MagicMarkTypeUpdateArg)this.arg).markType), "POnMagicMarkTypeUpdate.processImp@handle MAGIC_MARK_SPECIFIC_OWN success");
/*    */     
/*    */ 
/* 16 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnMagicMarkTypeUpdate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */