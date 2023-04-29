/*     */ package mzm.gsp.shitu.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.friend.main.FriendInterface;
/*     */ import mzm.gsp.npc.main.NpcInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.shitu.SChuShiConditionCheckResult;
/*     */ import mzm.gsp.shitu.confbean.ShiTuConsts;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.ApprenticeInfo;
/*     */ import xbean.ShiTuTimeInfo;
/*     */ import xtable.Role2shitu;
/*     */ 
/*     */ public class PCChuShiConditionCheck extends LogicProcedure
/*     */ {
/*     */   private final long apprenticeRoleId;
/*     */   
/*     */   public PCChuShiConditionCheck(long apprenticeRoleId)
/*     */   {
/*  24 */     this.apprenticeRoleId = apprenticeRoleId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  30 */     if (!NpcInterface.checkNpcServiceIgnoreNpcLocationCond(ShiTuConsts.getInstance().shiTuNPCId, ShiTuConsts.getInstance().chuShiNpcServiceId, this.apprenticeRoleId))
/*     */     {
/*     */ 
/*  33 */       GameServer.logger().error(String.format("[shitu]PCChuShiConditionCheck.processImp@npc service is not useable|npc_id=%d|service_id=%d|apprentice_role_id=%d", new Object[] { Integer.valueOf(ShiTuConsts.getInstance().shiTuNPCId), Integer.valueOf(ShiTuConsts.getInstance().chuShiNpcServiceId), Long.valueOf(this.apprenticeRoleId) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  38 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  42 */     if (!RoleStatusInterface.checkCanSetStatus(this.apprenticeRoleId, 1714, true))
/*     */     {
/*  44 */       return false;
/*     */     }
/*     */     
/*  47 */     if (!ShiTuManager.isShiTuSwitchOpen(this.apprenticeRoleId, "PCChuShiConditionCheck.processImp"))
/*     */     {
/*  49 */       return false;
/*     */     }
/*     */     
/*  52 */     SChuShiConditionCheckResult sChuShiCheckResult = new SChuShiConditionCheckResult();
/*  53 */     sChuShiCheckResult.result.put(Integer.valueOf(ShiTuConsts.getInstance().relationTimeConditionIdChuShi), Integer.valueOf(0));
/*  54 */     sChuShiCheckResult.result.put(Integer.valueOf(ShiTuConsts.getInstance().qinMiDuConditionIdChuShi), Integer.valueOf(0));
/*     */     
/*  56 */     ApprenticeInfo xApprenticeInfo = Role2shitu.selectApprenticeinfo(Long.valueOf(this.apprenticeRoleId));
/*     */     
/*  58 */     if (xApprenticeInfo == null)
/*     */     {
/*  60 */       GameServer.logger().error(String.format("[shitu]PCChuShiConditionCheck.processImp@apprentice shi tu info is null|apprentice_role_id=%d", new Object[] { Long.valueOf(this.apprenticeRoleId) }));
/*     */       
/*     */ 
/*     */ 
/*  64 */       return false;
/*     */     }
/*  66 */     ShiTuTimeInfo xTimeInfo = xApprenticeInfo.getTimeinfo();
/*  67 */     if ((xTimeInfo.getStarttime() <= 0L) || (xTimeInfo.getEndtime() > 0L))
/*     */     {
/*  69 */       GameServer.logger().error(String.format("[shitu]PCChuShiConditionCheck.processImp@apprentice role not has shi tu relation now|apprentice_role_id=%d|master_role_id=%d|start_time=%d|end_time=%d", new Object[] { Long.valueOf(this.apprenticeRoleId), Long.valueOf(xApprenticeInfo.getMasterroleid()), Long.valueOf(xTimeInfo.getStarttime()), Long.valueOf(xTimeInfo.getEndtime()) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  74 */       OnlineManager.getInstance().sendAtOnce(this.apprenticeRoleId, sChuShiCheckResult);
/*  75 */       return false;
/*     */     }
/*     */     
/*  78 */     int timeLimitResult = DateTimeUtils.getCurrTimeInMillis() - xTimeInfo.getStarttime() > ShiTuConsts.getInstance().chuShiRelationMinTime * 86400000L ? 1 : 0;
/*     */     
/*     */ 
/*  81 */     long masterRoleId = xApprenticeInfo.getMasterroleid();
/*  82 */     if (masterRoleId == 0L)
/*     */     {
/*  84 */       GameServer.logger().error(String.format("[shitu]PCChuShiConditionCheck.processImp@master role id not exist|apprentice_role_id=%d|master_role_id=%d", new Object[] { Long.valueOf(this.apprenticeRoleId), Long.valueOf(masterRoleId) }));
/*     */       
/*     */ 
/*     */ 
/*  88 */       OnlineManager.getInstance().sendAtOnce(this.apprenticeRoleId, sChuShiCheckResult);
/*  89 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  93 */     int friendValue = FriendInterface.getRelationValue(this.apprenticeRoleId, masterRoleId, false);
/*  94 */     int qiMiDuLimit = friendValue < ShiTuConsts.getInstance().chuShiMinQinMiDu ? 0 : 1;
/*     */     
/*  96 */     sChuShiCheckResult.result.put(Integer.valueOf(ShiTuConsts.getInstance().relationTimeConditionIdChuShi), Integer.valueOf(timeLimitResult));
/*  97 */     sChuShiCheckResult.result.put(Integer.valueOf(ShiTuConsts.getInstance().qinMiDuConditionIdChuShi), Integer.valueOf(qiMiDuLimit));
/*     */     
/*  99 */     OnlineManager.getInstance().send(this.apprenticeRoleId, sChuShiCheckResult);
/*     */     
/* 101 */     GameServer.logger().info(String.format("[shitu]PCChuShiConditionCheck.processImp@handle chu shi condition check success|apprentice_role_id=%d|time_limit_result=%d", new Object[] { Long.valueOf(this.apprenticeRoleId), Integer.valueOf(timeLimitResult) }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 106 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shitu\main\PCChuShiConditionCheck.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */