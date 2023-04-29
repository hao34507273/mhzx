/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import mzm.gsp.item.confbean.SItemCfg;
/*    */ import mzm.gsp.item.event.EquipMakeProcedure;
/*    */ import mzm.gsp.item.main.EquipMakeArg;
/*    */ 
/*    */ public class POnEquipMake
/*    */   extends EquipMakeProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 13 */     SItemCfg sItemCfg = SItemCfg.get(((EquipMakeArg)this.arg).itemid);
/* 14 */     AchievementManager.updateGoalTypeState(((EquipMakeArg)this.arg).roleid, 3012, Integer.valueOf(sItemCfg.namecolor), "POnEquipMake.processImp@handle EQUIPMENT_MAKE_COMBO_QUALITY success");
/*    */     
/*    */ 
/* 17 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnEquipMake.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */