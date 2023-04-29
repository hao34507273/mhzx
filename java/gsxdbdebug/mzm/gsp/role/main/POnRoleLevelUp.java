/*    */ package mzm.gsp.role.main;
/*    */ 
/*    */ import java.util.Collection;
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.bulletin.main.BulletinInterface;
/*    */ import mzm.gsp.feisheng.main.PGM_FeiShengOK;
/*    */ import mzm.gsp.role.event.RoleLevelUpArg;
/*    */ import mzm.gsp.role.event.RoleLevelUpProcedure;
/*    */ import xbean.BasicPropertiesSystem;
/*    */ import xbean.Pod;
/*    */ import xbean.Properties;
/*    */ import xdb.Procedure;
/*    */ import xtable.Role2properties;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnRoleLevelUp
/*    */   extends RoleLevelUpProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */   {
/* 25 */     RoleOutFightObj role = new RoleOutFightObj(((RoleLevelUpArg)this.arg).roleId);
/* 26 */     Properties xProperties = Role2properties.get(Long.valueOf(((RoleLevelUpArg)this.arg).roleId));
/* 27 */     role.setHP(role.getFinalMaxHP());
/* 28 */     role.setMP(role.getFinalMaxMP());
/* 29 */     role.onPropertyChange();
/* 30 */     int nowLevel = role.getLevel();
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 37 */     if ((nowLevel >= OccupationManager.getInstance().getSecondSysOpenLevel()) && (!xProperties.getPropertysysmap().containsKey(Integer.valueOf(1)))) {
/* 38 */       BasicPropertiesSystem xBPS1 = (BasicPropertiesSystem)xProperties.getPropertysysmap().get(Integer.valueOf(0));
/* 39 */       BasicPropertiesSystem xBPS3 = Pod.newBasicPropertiesSystem();
/* 40 */       Map propMap = xBPS1.getBasicpropertymap();
/* 41 */       int totalPoint = xBPS1.getPotentialpoint();
/*    */       int propValue;
/* 43 */       for (Iterator i$ = propMap.values().iterator(); i$.hasNext(); totalPoint += propValue) {
/* 44 */         propValue = ((Integer)i$.next()).intValue();
/*    */       }
/*    */       
/* 47 */       xBPS3.setPotentialpoint(totalPoint);
/* 48 */       xProperties.getPropertysysmap().put(Integer.valueOf(1), xBPS3);
/*    */     }
/*    */     
/* 51 */     if ((nowLevel >= OccupationManager.getInstance().getThirdSysOpenLevel()) && (!xProperties.getPropertysysmap().containsKey(Integer.valueOf(2)))) {
/* 52 */       BasicPropertiesSystem xBPS1 = (BasicPropertiesSystem)xProperties.getPropertysysmap().get(Integer.valueOf(0));
/* 53 */       BasicPropertiesSystem xBPS3 = Pod.newBasicPropertiesSystem();
/* 54 */       Map propMap = xBPS1.getBasicpropertymap();
/* 55 */       int totalPoint = xBPS1.getPotentialpoint();
/*    */       int propValue;
/* 57 */       for (Iterator i$ = propMap.values().iterator(); i$.hasNext(); totalPoint += propValue) {
/* 58 */         propValue = ((Integer)i$.next()).intValue();
/*    */       }
/*    */       
/* 61 */       xBPS3.setPotentialpoint(totalPoint);
/* 62 */       xProperties.getPropertysysmap().put(Integer.valueOf(2), xBPS3);
/*    */     }
/*    */     
/* 65 */     RoleManager.updateTransferOccupationPropertiesSys(xProperties, nowLevel);
/* 66 */     role.syncClientRoleProperty();
/* 67 */     if (((RoleLevelUpArg)this.arg).newLevel == 99) {
/* 68 */       BulletinInterface.sendNotice("恭喜！玩家" + role.getName() + "等级已经达到99级并飞升成仙！");
/* 69 */       Procedure.execute(new PGM_FeiShengOK(((RoleLevelUpArg)this.arg).roleId, ((RoleLevelUpArg)this.arg).roleId, 99));
/*    */     }
/* 71 */     RoleLevelChart roleLevelChart = new RoleLevelChart(((RoleLevelUpArg)this.arg).roleId, ((RoleLevelUpArg)this.arg).newLevel, xProperties.getLevelupcurtime());
/* 72 */     RoleLevelRankManager.getInstance().rank(roleLevelChart);
/* 73 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\POnRoleLevelUp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */