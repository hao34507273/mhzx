/*    */ package mzm.gsp.shitu.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.shitu.SRelieveShiTuRelation;
/*    */ import mzm.gsp.shitu.confbean.ShiTuConsts;
/*    */ import mzm.gsp.title.main.TitleInterface;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.ApprenticeInfo;
/*    */ import xbean.MasterInfo;
/*    */ import xbean.Pod;
/*    */ import xbean.ShiTuTimeInfo;
/*    */ 
/*    */ abstract class PAbstractRelieveShiTuRelation extends LogicProcedure
/*    */ {
/* 19 */   protected long masterRoleId = 0L;
/* 20 */   protected long apprenticeRoleId = 0L;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected void resetShiTuInfo(ApprenticeInfo xApprenticeInfo, MasterInfo xMasterInfo)
/*    */   {
/* 33 */     long currentTimeMillis = DateTimeUtils.getCurrTimeInMillis();
/* 34 */     xMasterInfo.getApprentice_now().remove(Long.valueOf(this.apprenticeRoleId));
/*    */     
/* 36 */     ShiTuTimeInfo xShiTuTimeInfo = xApprenticeInfo.getTimeinfo();
/*    */     
/* 38 */     Map<Long, ShiTuTimeInfo> xForceRelieveApprenticeInfoMap = xMasterInfo.getForce_relieve();
/* 39 */     ShiTuTimeInfo xRelieveTimeInfo = Pod.newShiTuTimeInfo();
/* 40 */     xRelieveTimeInfo.setStarttime(xShiTuTimeInfo.getStarttime());
/* 41 */     xRelieveTimeInfo.setEndtime(currentTimeMillis);
/* 42 */     xForceRelieveApprenticeInfoMap.put(Long.valueOf(this.apprenticeRoleId), xRelieveTimeInfo);
/* 43 */     xMasterInfo.getNow_apprentice_role_list().remove(Long.valueOf(this.apprenticeRoleId));
/*    */     
/*    */ 
/* 46 */     xApprenticeInfo.setMasterroleid(0L);
/* 47 */     xShiTuTimeInfo.setEndtime(0L);
/* 48 */     xShiTuTimeInfo.setStarttime(0L);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   protected void sendRelieveShiTuRelationInfo()
/*    */   {
/* 56 */     SRelieveShiTuRelation sRelieveShiTuRelation = new SRelieveShiTuRelation();
/* 57 */     sRelieveShiTuRelation.apprenticeroleid = this.apprenticeRoleId;
/* 58 */     sRelieveShiTuRelation.apprenticerolename = RoleInterface.getName(this.apprenticeRoleId);
/* 59 */     sRelieveShiTuRelation.masterroleid = this.masterRoleId;
/* 60 */     sRelieveShiTuRelation.masterrolename = RoleInterface.getName(this.masterRoleId);
/*    */     
/* 62 */     OnlineManager.getInstance().sendMulti(sRelieveShiTuRelation, Arrays.asList(new Long[] { Long.valueOf(this.apprenticeRoleId), Long.valueOf(this.masterRoleId) }));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected void removeAppelation(boolean isNeedRemoveMasterAppelation)
/*    */   {
/* 73 */     if (isNeedRemoveMasterAppelation)
/*    */     {
/* 75 */       TitleInterface.removeAppllation(this.masterRoleId, ShiTuConsts.getInstance().masterAppellationId);
/*    */     }
/* 77 */     TitleInterface.removeAppllation(this.apprenticeRoleId, ShiTuConsts.getInstance().apprenticeAppellationId);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shitu\main\PAbstractRelieveShiTuRelation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */