/*     */ package mzm.gsp.shitu.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.mail.main.SendMailRet;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.shitu.confbean.ShiTuConsts;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.ApprenticeInfo;
/*     */ import xbean.MasterInfo;
/*     */ import xbean.ShiTuTimeInfo;
/*     */ import xbean.role2ShiTuInfo;
/*     */ import xtable.Role2shitu;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCApprenticeRelieveShiTuRelation extends PAbstractRelieveShiTuRelation
/*     */ {
/*     */   public PCApprenticeRelieveShiTuRelation(long apprenticeRoleId)
/*     */   {
/*  25 */     this.apprenticeRoleId = apprenticeRoleId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  31 */     if (!mzm.gsp.npc.main.NpcInterface.checkNpcServiceIgnoreNpcLocationCond(ShiTuConsts.getInstance().shiTuNPCId, ShiTuConsts.getInstance().defectNpcServiceId, this.apprenticeRoleId))
/*     */     {
/*     */ 
/*  34 */       GameServer.logger().error(String.format("[coupledaily]PCGetCoupleDailyAward.processImp@npc service is not useable|npc_id=%d|service_id=%d|apprentice_role_id=%d", new Object[] { Integer.valueOf(ShiTuConsts.getInstance().shiTuNPCId), Integer.valueOf(ShiTuConsts.getInstance().defectNpcServiceId), Long.valueOf(this.apprenticeRoleId) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  39 */       return false;
/*     */     }
/*     */     
/*  42 */     if (!ShiTuManager.isShiTuSwitchOpen(this.apprenticeRoleId, "PCApprenticeRelieveShiTuRelation.processImp"))
/*     */     {
/*  44 */       return false;
/*     */     }
/*     */     
/*  47 */     ApprenticeInfo xSelectApprenticeInfo = Role2shitu.selectApprenticeinfo(Long.valueOf(this.apprenticeRoleId));
/*     */     
/*  49 */     if (xSelectApprenticeInfo == null)
/*     */     {
/*  51 */       GameServer.logger().error(String.format("[shitu]PCApprenticeRelieveShiTuRelation.processImp@apprentice shi tu info is null|apprentice_role_id=%d", new Object[] { Long.valueOf(this.apprenticeRoleId) }));
/*     */       
/*     */ 
/*     */ 
/*  55 */       return false;
/*     */     }
/*     */     
/*  58 */     long xSelectMasterRoleId = xSelectApprenticeInfo.getMasterroleid();
/*  59 */     if (xSelectMasterRoleId == 0L)
/*     */     {
/*  61 */       GameServer.logger().error(String.format("[shitu]PCApprenticeRelieveShiTuRelation.processImp@not has master|master_role_id=%d|apprentice_role_id=%d", new Object[] { Long.valueOf(xSelectMasterRoleId), Long.valueOf(this.apprenticeRoleId) }));
/*     */       
/*     */ 
/*     */ 
/*  65 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  69 */     String masterUserId = RoleInterface.getUserId(xSelectMasterRoleId);
/*  70 */     String apprenticeUserId = RoleInterface.getUserId(this.apprenticeRoleId);
/*  71 */     super.lock(User.getTable(), Arrays.asList(new String[] { masterUserId, apprenticeUserId }));
/*     */     
/*     */ 
/*  74 */     super.lock(xtable.Role2properties.getTable(), Arrays.asList(new Long[] { Long.valueOf(xSelectMasterRoleId), Long.valueOf(this.apprenticeRoleId) }));
/*     */     
/*     */ 
/*  77 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.apprenticeRoleId, 1712, true, true))
/*     */     {
/*     */ 
/*  80 */       return false;
/*     */     }
/*     */     
/*  83 */     ApprenticeInfo xApprenticeInfo = Role2shitu.get(Long.valueOf(this.apprenticeRoleId)).getApprenticeinfo();
/*  84 */     this.masterRoleId = xApprenticeInfo.getMasterroleid();
/*     */     
/*  86 */     if (this.masterRoleId != xSelectMasterRoleId)
/*     */     {
/*  88 */       GameServer.logger().error(String.format("[shitu]PCApprenticeRelieveShiTuRelation.processImp@shi tu info changed,master role id not match|select_master_role_id=%d|get_master_role_id=%d|apprentice_role_id=%d", new Object[] { Long.valueOf(xSelectMasterRoleId), Long.valueOf(this.masterRoleId), Long.valueOf(this.apprenticeRoleId) }));
/*     */       
/*     */ 
/*     */ 
/*  92 */       return false;
/*     */     }
/*     */     
/*  95 */     role2ShiTuInfo xMasterShiTuInfo = Role2shitu.get(Long.valueOf(this.masterRoleId));
/*     */     
/*  97 */     if (xMasterShiTuInfo == null)
/*     */     {
/*  99 */       GameServer.logger().error(String.format("[shitu]PCApprenticeRelieveShiTuRelation.processImp@master shi tu info is null|master_role_id=%d|apprentice_role_id=%d", new Object[] { Long.valueOf(this.masterRoleId), Long.valueOf(this.apprenticeRoleId) }));
/*     */       
/*     */ 
/*     */ 
/* 103 */       return false;
/*     */     }
/* 105 */     MasterInfo xMasterInfo = xMasterShiTuInfo.getMasterinfo();
/* 106 */     Map<Long, ShiTuTimeInfo> xNowMasterApprenticeMap = xMasterInfo.getApprentice_now();
/*     */     
/* 108 */     ShiTuTimeInfo xMasterTimeInfo = (ShiTuTimeInfo)xNowMasterApprenticeMap.get(Long.valueOf(this.apprenticeRoleId));
/*     */     
/* 110 */     if (xMasterTimeInfo == null)
/*     */     {
/* 112 */       GameServer.logger().error(String.format("[shitu]PCApprenticeRelieveShiTuRelation.processImp@master not has the apprentice|master_role_id=%d|apprentice_role_id=%d|master_now_apprentice=%s", new Object[] { Long.valueOf(this.masterRoleId), Long.valueOf(this.apprenticeRoleId), xNowMasterApprenticeMap.keySet().toString() }));
/*     */       
/*     */ 
/*     */ 
/* 116 */       return false;
/*     */     }
/*     */     
/* 119 */     List<String> contentArgs = new ArrayList();
/* 120 */     String apprenticeRoleName = RoleInterface.getName(this.apprenticeRoleId);
/* 121 */     contentArgs.add(apprenticeRoleName);
/*     */     
/* 123 */     SendMailRet sendMailRet = mzm.gsp.mail.main.MailInterface.synBuildAndSendMail(this.masterRoleId, ShiTuConsts.getInstance().forceRelieveMailID, null, contentArgs, new TLogArg(mzm.gsp.tlog.LogReason.APPRENTICE_FORCE_RELIEVE_RELATION));
/*     */     
/*     */ 
/* 126 */     if (!sendMailRet.isOK())
/*     */     {
/* 128 */       GameServer.logger().info(String.format("[shitu]PCApprenticeRelieveShiTuRelation.processImp@send relieve shi tu relation email failed|master_role_id=%d|apprentice_role_id=%d|mail_id=%d", new Object[] { Long.valueOf(this.masterRoleId), Long.valueOf(this.apprenticeRoleId), Integer.valueOf(ShiTuConsts.getInstance().forceRelieveMailID) }));
/*     */       
/*     */ 
/*     */ 
/* 132 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 136 */     resetShiTuInfo(xApprenticeInfo, xMasterInfo);
/*     */     
/*     */ 
/* 139 */     sendRelieveShiTuRelationInfo();
/*     */     
/* 141 */     int nowApprenticeSize = xMasterInfo.getApprentice_now().size();
/*     */     
/*     */ 
/* 144 */     int apprenticeGraduateSize = xMasterInfo.getApprentice_graduate().size();
/* 145 */     boolean isNeedRemoveMasterAppelation = (nowApprenticeSize == 0) && (apprenticeGraduateSize == 0);
/*     */     
/*     */ 
/* 148 */     removeAppelation(isNeedRemoveMasterAppelation);
/*     */     
/*     */ 
/* 151 */     MasterRankManager.getInstance().rank(this.masterRoleId, nowApprenticeSize + apprenticeGraduateSize);
/*     */     
/*     */ 
/* 154 */     OnlineManager.getInstance().send(this.apprenticeRoleId, ShiTuManager.changeShiTuTaskPublishState(this.apprenticeRoleId, 2, 5));
/*     */     
/*     */ 
/*     */ 
/* 158 */     xbean.ShiTuTaskInfo xShiTuTaskInfo = xtable.Role2shitutask.get(Long.valueOf(this.apprenticeRoleId));
/*     */     
/* 160 */     ShiTuManager.sendShiTuTaskReward(this.masterRoleId, this.apprenticeRoleId, xShiTuTaskInfo);
/*     */     
/* 162 */     ShiTuManager.tlogShiTuRelation(this.apprenticeRoleId, this.masterRoleId, this.apprenticeRoleId, ShiTuRelationTLogEnum.APPRENTICE_FORCE_RELIECE);
/*     */     
/*     */ 
/* 165 */     GameServer.logger().info(String.format("[shitu]PCApprenticeRelieveShiTuRelation.processImp@handle apprentice relieve shi tu relation success|master_role_id=%d|apprentice_role_id=%d", new Object[] { Long.valueOf(this.masterRoleId), Long.valueOf(this.apprenticeRoleId) }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 170 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shitu\main\PCApprenticeRelieveShiTuRelation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */