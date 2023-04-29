/*     */ package mzm.gsp.shitu.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.mail.main.SendMailRet;
/*     */ import mzm.gsp.mail.main.SendMailRet.RetEnum;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.shitu.confbean.ShiTuConsts;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.ApprenticeInfo;
/*     */ import xbean.MasterInfo;
/*     */ import xbean.ShiTuTimeInfo;
/*     */ import xbean.role2ShiTuInfo;
/*     */ import xtable.Role2shitu;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCMasteRelieveShiTuRelation extends PAbstractRelieveShiTuRelation
/*     */ {
/*     */   public PCMasteRelieveShiTuRelation(long masterRoleId, long apprenticeRoleId)
/*     */   {
/*  25 */     this.masterRoleId = masterRoleId;
/*  26 */     this.apprenticeRoleId = apprenticeRoleId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  32 */     if (!mzm.gsp.npc.main.NpcInterface.checkNpcServiceIgnoreNpcLocationCond(ShiTuConsts.getInstance().shiTuNPCId, ShiTuConsts.getInstance().dismissNpcServiceId, this.masterRoleId))
/*     */     {
/*     */ 
/*  35 */       GameServer.logger().error(String.format("[shitu]PCMasteRelieveShiTuRelation.processImp@npc service is not useable|npc_id=%d|service_id=%d|master_role_id=%d", new Object[] { Integer.valueOf(ShiTuConsts.getInstance().shiTuNPCId), Integer.valueOf(ShiTuConsts.getInstance().dismissNpcServiceId), Long.valueOf(this.masterRoleId) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  40 */       return false;
/*     */     }
/*     */     
/*  43 */     if (!ShiTuManager.isShiTuSwitchOpen(this.masterRoleId, "PCMasteRelieveShiTuRelation.processImp"))
/*     */     {
/*  45 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  49 */     String masterUserId = RoleInterface.getUserId(this.masterRoleId);
/*  50 */     String apprenticeUserId = RoleInterface.getUserId(this.apprenticeRoleId);
/*  51 */     if ((masterUserId == null) || (apprenticeUserId == null))
/*     */     {
/*  53 */       GameServer.logger().error(String.format("[shitu]PCMasteRelieveShiTuRelation.processImp@user id is null|master_role_id=%d|apprentice_role_id=%d|master_user_id=%s|apprentice_user_id=%s", new Object[] { Long.valueOf(this.masterRoleId), Long.valueOf(this.apprenticeRoleId), masterUserId, apprenticeUserId }));
/*     */       
/*     */ 
/*     */ 
/*  57 */       return false;
/*     */     }
/*  59 */     super.lock(User.getTable(), Arrays.asList(new String[] { masterUserId, apprenticeUserId }));
/*     */     
/*     */ 
/*  62 */     super.lock(xtable.Role2properties.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.masterRoleId), Long.valueOf(this.apprenticeRoleId) }));
/*     */     
/*     */ 
/*  65 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.masterRoleId, 1720, true, true))
/*     */     {
/*     */ 
/*  68 */       return false;
/*     */     }
/*     */     
/*  71 */     role2ShiTuInfo xApprenticeShiTuInfo = Role2shitu.get(Long.valueOf(this.apprenticeRoleId));
/*  72 */     if (xApprenticeShiTuInfo == null)
/*     */     {
/*  74 */       GameServer.logger().error(String.format("[shitu]PCMasteRelieveShiTuRelation.processImp@apprentice shi tu info is null|master_role_id=%d|apprentice_role_id=%d", new Object[] { Long.valueOf(this.masterRoleId), Long.valueOf(this.apprenticeRoleId) }));
/*     */       
/*     */ 
/*     */ 
/*  78 */       return false;
/*     */     }
/*     */     
/*  81 */     ApprenticeInfo xApprenticeInfo = xApprenticeShiTuInfo.getApprenticeinfo();
/*  82 */     if (xApprenticeInfo.getMasterroleid() != this.masterRoleId)
/*     */     {
/*  84 */       GameServer.logger().error(String.format("[shitu]PCMasteRelieveShiTuRelation.processImp@master role id not match|master_role_id=%d|apprentice_role_id=%d|xbean_master_role_id=%d", new Object[] { Long.valueOf(this.masterRoleId), Long.valueOf(this.apprenticeRoleId), Long.valueOf(xApprenticeInfo.getMasterroleid()) }));
/*     */       
/*     */ 
/*     */ 
/*  88 */       return false;
/*     */     }
/*     */     
/*  91 */     role2ShiTuInfo xMasterShiTuInfo = Role2shitu.get(Long.valueOf(this.masterRoleId));
/*  92 */     if (xMasterShiTuInfo == null)
/*     */     {
/*  94 */       GameServer.logger().error(String.format("[shitu]PCMasteRelieveShiTuRelation.processImp@master shi tu info is null|master_role_id=%d|apprentice_role_id=%d", new Object[] { Long.valueOf(this.masterRoleId), Long.valueOf(this.apprenticeRoleId) }));
/*     */       
/*     */ 
/*     */ 
/*  98 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 102 */     MasterInfo xMasterInfo = xMasterShiTuInfo.getMasterinfo();
/* 103 */     Map<Long, ShiTuTimeInfo> xNowMasterApprenticeInfoMap = xMasterInfo.getApprentice_now();
/* 104 */     ShiTuTimeInfo xMasterTimeInfo = (ShiTuTimeInfo)xNowMasterApprenticeInfoMap.get(Long.valueOf(this.apprenticeRoleId));
/*     */     
/* 106 */     if (xMasterTimeInfo == null)
/*     */     {
/* 108 */       GameServer.logger().error(String.format("[shitu]PCMasteRelieveShiTuRelation.processImp@master not has the apprentice|master_role_id=%d|apprentice_role_id=%d|master_now_apprentice=%s", new Object[] { Long.valueOf(this.masterRoleId), Long.valueOf(this.apprenticeRoleId), xNowMasterApprenticeInfoMap.keySet().toString() }));
/*     */       
/*     */ 
/*     */ 
/* 112 */       return false;
/*     */     }
/*     */     
/* 115 */     List<String> contentArgs = new ArrayList();
/* 116 */     String masterRoleName = RoleInterface.getName(this.masterRoleId);
/* 117 */     contentArgs.add(masterRoleName);
/*     */     
/*     */ 
/* 120 */     SendMailRet sendMailRet = mzm.gsp.mail.main.MailInterface.synBuildAndSendMail(this.apprenticeRoleId, ShiTuConsts.getInstance().forceRelieveMailID, null, contentArgs, new mzm.gsp.tlog.TLogArg(mzm.gsp.tlog.LogReason.MASTER_FORCE_RELIEVE_RELATION));
/*     */     
/*     */ 
/* 123 */     if (!sendMailRet.isOK())
/*     */     {
/* 125 */       GameServer.logger().error(String.format("[shitu]PCMasteRelieveShiTuRelation.processImp@send relieve shi tu relation email failed|ret=%d|ret_msg=%s|master_role_id=%d|apprentice_role_id=%d|mail_id=%d", new Object[] { Integer.valueOf(sendMailRet.getRetEnum().ret), sendMailRet.getRetEnum().retMsg, Long.valueOf(this.masterRoleId), Long.valueOf(this.apprenticeRoleId), Integer.valueOf(ShiTuConsts.getInstance().forceRelieveMailID) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 130 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 134 */     resetShiTuInfo(xApprenticeInfo, xMasterInfo);
/*     */     
/*     */ 
/* 137 */     sendRelieveShiTuRelationInfo();
/*     */     
/* 139 */     int nowApprenticeSize = xMasterInfo.getApprentice_now().size();
/*     */     
/* 141 */     int apprenticeGratuateSize = xMasterInfo.getApprentice_graduate().size();
/* 142 */     boolean isNeedRemoveMasterAppelation = (nowApprenticeSize == 0) && (apprenticeGratuateSize == 0);
/* 143 */     removeAppelation(isNeedRemoveMasterAppelation);
/*     */     
/*     */ 
/* 146 */     MasterRankManager.getInstance().rank(this.masterRoleId, nowApprenticeSize + apprenticeGratuateSize);
/*     */     
/*     */ 
/* 149 */     OnlineManager.getInstance().send(this.apprenticeRoleId, ShiTuManager.changeShiTuTaskPublishState(this.apprenticeRoleId, 2, 5));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 154 */     xbean.ShiTuTaskInfo xShiTuTaskInfo = xtable.Role2shitutask.get(Long.valueOf(this.apprenticeRoleId));
/* 155 */     ShiTuManager.sendShiTuTaskReward(this.masterRoleId, this.apprenticeRoleId, xShiTuTaskInfo);
/*     */     
/* 157 */     ShiTuManager.tlogShiTuRelation(this.masterRoleId, this.masterRoleId, this.apprenticeRoleId, ShiTuRelationTLogEnum.MASTER_FORCE_RELIEVE);
/*     */     
/*     */ 
/* 160 */     GameServer.logger().info(String.format("[shitu]PCMasteRelieveShiTuRelation.processImp@handle master relieve shi tu relation success|master_role_id=%d|apprentice_role_id=%d", new Object[] { Long.valueOf(this.masterRoleId), Long.valueOf(this.apprenticeRoleId) }));
/*     */     
/*     */ 
/*     */ 
/* 164 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shitu\main\PCMasteRelieveShiTuRelation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */