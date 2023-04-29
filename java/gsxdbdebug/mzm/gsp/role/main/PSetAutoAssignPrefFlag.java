/*    */ package mzm.gsp.role.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.SSetAutoAssignFuncRes;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.BasicPropertiesSystem;
/*    */ import xbean.Properties;
/*    */ import xtable.Role2properties;
/*    */ 
/*    */ public class PSetAutoAssignPrefFlag extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int BPSys_index;
/*    */   private final boolean isAutoAssignOpen;
/*    */   
/*    */   public PSetAutoAssignPrefFlag(long roleId, int bpSys_index, boolean isAutoAssignOpen)
/*    */   {
/* 19 */     this.roleId = roleId;
/* 20 */     this.BPSys_index = bpSys_index;
/* 21 */     this.isAutoAssignOpen = isAutoAssignOpen;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 27 */     Properties xProperties = Role2properties.get(Long.valueOf(this.roleId));
/* 28 */     BasicPropertiesSystem xBPSys = (BasicPropertiesSystem)xProperties.getPropertysysmap().get(Integer.valueOf(this.BPSys_index));
/* 29 */     if (xBPSys == null)
/*    */     {
/* 31 */       return false;
/*    */     }
/* 33 */     xBPSys.setIsautospecialpoint(this.isAutoAssignOpen);
/*    */     
/* 35 */     if ((this.isAutoAssignOpen) && (xProperties.getActivitybpsys() == this.BPSys_index))
/*    */     {
/* 37 */       RoleOutFightObj role = RoleInterface.getRoleOutFightObject(this.roleId);
/* 38 */       if (!role.autoSpecialPoint(xBPSys))
/*    */       {
/* 40 */         return false;
/*    */       }
/* 42 */       role.setMP(role.getFinalMaxMP());
/* 43 */       role.setHP(role.getFinalMaxHP());
/* 44 */       role.syncClientRoleProperty();
/*    */     }
/* 46 */     SSetAutoAssignFuncRes res = new SSetAutoAssignFuncRes();
/* 47 */     res.autoassignopenflag = (this.isAutoAssignOpen ? 1 : 0);
/* 48 */     OnlineManager.getInstance().send(this.roleId, res);
/*    */     
/* 50 */     LogRolePropertySystemManager.tlogRolePropertySystem(RoleInterface.getUserId(this.roleId), this.roleId, xProperties, 4, this.BPSys_index);
/*    */     
/* 52 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\PSetAutoAssignPrefFlag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */