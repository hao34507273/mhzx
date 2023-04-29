/*     */ package mzm.gsp.shitu.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.npc.main.NpcInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.shitu.SShouTuConditionCheckResult;
/*     */ import mzm.gsp.shitu.confbean.ShiTuConsts;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.ApprenticeInfo;
/*     */ import xbean.MasterInfo;
/*     */ import xbean.ShiTuTimeInfo;
/*     */ import xbean.role2ShiTuInfo;
/*     */ import xtable.Role2shitu;
/*     */ 
/*     */ public class PCShouTuConditionCheck extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long masterRoleId;
/*     */   private final long apprenticeRoleId;
/*     */   
/*     */   public PCShouTuConditionCheck(long masterRoleId, long apprenticeRoleId)
/*     */   {
/*  23 */     this.masterRoleId = masterRoleId;
/*  24 */     this.apprenticeRoleId = apprenticeRoleId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  30 */     if (!NpcInterface.checkNpcServiceIgnoreNpcLocationCond(ShiTuConsts.getInstance().shiTuNPCId, ShiTuConsts.getInstance().shouTuNpcServiceId, this.masterRoleId))
/*     */     {
/*     */ 
/*  33 */       GameServer.logger().error(String.format("[coupledaily]PCShouTuConditionCheck.processImp@npc service is not useable|npc_id=%d|service_id=%d|master_role_id=%d|apprentice_role_id=%d", new Object[] { Integer.valueOf(ShiTuConsts.getInstance().shiTuNPCId), Integer.valueOf(ShiTuConsts.getInstance().shouTuNpcServiceId), Long.valueOf(this.masterRoleId), Long.valueOf(this.apprenticeRoleId) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  38 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  42 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.masterRoleId, 1723, true))
/*     */     {
/*  44 */       return false;
/*     */     }
/*     */     
/*  47 */     if (!ShiTuManager.isShiTuSwitchOpen(this.masterRoleId, "PCShouTuConditionCheck.processImp"))
/*     */     {
/*  49 */       return false;
/*     */     }
/*     */     
/*  52 */     SShouTuConditionCheckResult sShouTuCheckResult = new SShouTuConditionCheckResult();
/*  53 */     sShouTuCheckResult.result.put(Integer.valueOf(ShiTuConsts.getInstance().punishConditionIdShouTu), Integer.valueOf(0));
/*  54 */     sShouTuCheckResult.result.put(Integer.valueOf(ShiTuConsts.getInstance().apprenticeConditionIdShouTu), Integer.valueOf(0));
/*     */     
/*  56 */     role2ShiTuInfo xApprenticeShiTuInfo = Role2shitu.select(Long.valueOf(this.apprenticeRoleId));
/*     */     
/*  58 */     if (xApprenticeShiTuInfo == null)
/*     */     {
/*  60 */       GameServer.logger().error(String.format("[shitu]PCShouTuConditionCheck.processImp@apprentice info is null|master_role_id=%d|apprentice_role_id=%d", new Object[] { Long.valueOf(this.masterRoleId), Long.valueOf(this.apprenticeRoleId) }));
/*     */       
/*     */ 
/*     */ 
/*  64 */       return false;
/*     */     }
/*     */     
/*  67 */     MasterInfo xMasterInfo = Role2shitu.selectMasterinfo(Long.valueOf(this.masterRoleId));
/*     */     
/*  69 */     if (xMasterInfo == null)
/*     */     {
/*  71 */       GameServer.logger().error(String.format("[shitu]PCShouTuConditionCheck.processImp@master shi tu info is null|master_role_id=%d|apprentice_role_id=%d", new Object[] { Long.valueOf(this.masterRoleId), Long.valueOf(this.apprenticeRoleId) }));
/*     */       
/*     */ 
/*     */ 
/*  75 */       return false;
/*     */     }
/*     */     
/*  78 */     boolean isInPunish = ShiTuManager.checkIsInPunishTime(this.masterRoleId, this.apprenticeRoleId, xMasterInfo, xApprenticeShiTuInfo.getMasterinfo(), null, false);
/*     */     
/*     */ 
/*  81 */     boolean isHasRelation = ShiTuManager.checkIsHasShiTuRelation(this.masterRoleId, this.apprenticeRoleId, xApprenticeShiTuInfo.getMasterinfo(), xMasterInfo, null, false);
/*     */     
/*     */ 
/*  84 */     sShouTuCheckResult.result.put(Integer.valueOf(ShiTuConsts.getInstance().punishConditionIdShouTu), Integer.valueOf((isInPunish) || (isHasRelation) ? 0 : 1));
/*     */     
/*     */ 
/*     */ 
/*  88 */     ApprenticeInfo xApprenticeInfo = xApprenticeShiTuInfo.getApprenticeinfo();
/*  89 */     ShiTuTimeInfo xApprenticeTimeInfo = xApprenticeInfo.getTimeinfo();
/*     */     
/*  91 */     int isFirstBaiShi = xApprenticeTimeInfo.getStarttime() <= 0L ? 1 : 0;
/*  92 */     sShouTuCheckResult.result.put(Integer.valueOf(ShiTuConsts.getInstance().apprenticeConditionIdShouTu), Integer.valueOf(isFirstBaiShi));
/*     */     
/*  94 */     OnlineManager.getInstance().send(this.masterRoleId, sShouTuCheckResult);
/*     */     
/*  96 */     GameServer.logger().info(String.format("[shitu]PCShouTuConditionCheck.processImp@handle shou tu condition check success|master_role_id=%d|punish_result=%b|first_bai_shi=%d|is_has_relation=%b", new Object[] { Long.valueOf(this.masterRoleId), Boolean.valueOf(isInPunish), Integer.valueOf(isFirstBaiShi), Boolean.valueOf(isHasRelation) }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 101 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shitu\main\PCShouTuConditionCheck.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */