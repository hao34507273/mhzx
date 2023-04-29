/*     */ package mzm.gsp.shitu.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.friend.main.FriendInterface;
/*     */ import mzm.gsp.mail.main.MailInterface;
/*     */ import mzm.gsp.mail.main.SendMailRet;
/*     */ import mzm.gsp.mail.main.SendMailRet.RetEnum;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.shitu.SChuShiSuccess;
/*     */ import mzm.gsp.shitu.confbean.ShiTuConsts;
/*     */ import mzm.gsp.title.main.TitleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.ApprenticeInfo;
/*     */ import xbean.MasterInfo;
/*     */ import xbean.ShiTuTimeInfo;
/*     */ import xbean.role2ShiTuInfo;
/*     */ import xtable.Role2shitu;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCChuShiReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long apprenticeRoleId;
/*     */   
/*     */   public PCChuShiReq(long apprenticeRoleId)
/*     */   {
/*  35 */     this.apprenticeRoleId = apprenticeRoleId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  41 */     if (!mzm.gsp.npc.main.NpcInterface.checkNpcServiceIgnoreNpcLocationCond(ShiTuConsts.getInstance().shiTuNPCId, ShiTuConsts.getInstance().chuShiNpcServiceId, this.apprenticeRoleId))
/*     */     {
/*     */ 
/*  44 */       GameServer.logger().error(String.format("[coupledaily]PCChuShiReq.processImp@npc service is not useable|npc_id=%d|service_id=%d|apprentice_role_id=%d", new Object[] { Integer.valueOf(ShiTuConsts.getInstance().shiTuNPCId), Integer.valueOf(ShiTuConsts.getInstance().chuShiNpcServiceId), Long.valueOf(this.apprenticeRoleId) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  49 */       return false;
/*     */     }
/*     */     
/*  52 */     if (!ShiTuManager.isShiTuSwitchOpen(this.apprenticeRoleId, "PCChuShiReq.processImp"))
/*     */     {
/*  54 */       return false;
/*     */     }
/*     */     
/*  57 */     ApprenticeInfo xSelectApprenticeInfo = Role2shitu.selectApprenticeinfo(Long.valueOf(this.apprenticeRoleId));
/*  58 */     if (xSelectApprenticeInfo == null)
/*     */     {
/*  60 */       GameServer.logger().error(String.format("[shitu]PCChuShiReq.processImp@apprentice_role_id=%d", new Object[] { Long.valueOf(this.apprenticeRoleId) }));
/*  61 */       return false;
/*     */     }
/*     */     
/*  64 */     long xSelectMasterRoleId = xSelectApprenticeInfo.getMasterroleid();
/*  65 */     if (xSelectMasterRoleId == 0L)
/*     */     {
/*  67 */       GameServer.logger().error(String.format("[shitu]PCChuShiReq.processImp@not has master|master_role_id=%d|apprentice_role_id=%d", new Object[] { Long.valueOf(xSelectMasterRoleId), Long.valueOf(this.apprenticeRoleId) }));
/*     */       
/*     */ 
/*  70 */       return false;
/*     */     }
/*     */     
/*  73 */     String masterUserId = RoleInterface.getUserId(xSelectMasterRoleId);
/*  74 */     String apprenticeUserId = RoleInterface.getUserId(this.apprenticeRoleId);
/*  75 */     lock(User.getTable(), Arrays.asList(new String[] { masterUserId, apprenticeUserId }));
/*     */     
/*  77 */     lock(xtable.Role2properties.getTable(), Arrays.asList(new Long[] { Long.valueOf(xSelectMasterRoleId), Long.valueOf(this.apprenticeRoleId) }));
/*     */     
/*     */ 
/*  80 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.apprenticeRoleId, 1715, true, true))
/*     */     {
/*  82 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  86 */     role2ShiTuInfo xApprenticeShiTuInfo = Role2shitu.get(Long.valueOf(this.apprenticeRoleId));
/*  87 */     ApprenticeInfo xApprenticeInfo = xApprenticeShiTuInfo.getApprenticeinfo();
/*  88 */     long masterRoleId = xApprenticeInfo.getMasterroleid();
/*     */     
/*     */ 
/*  91 */     if (masterRoleId != xSelectMasterRoleId)
/*     */     {
/*  93 */       GameServer.logger().error(String.format("[shitu]PCChuShiReq.processImp@master role id changes|master_role_id=%d|select_master_role_id=%d|apprentice_role_id=%d", new Object[] { Long.valueOf(masterRoleId), Long.valueOf(xSelectMasterRoleId), Long.valueOf(this.apprenticeRoleId) }));
/*     */       
/*     */ 
/*     */ 
/*  97 */       return false;
/*     */     }
/*     */     
/* 100 */     ShiTuTimeInfo xApprenticeTimeInfo = xApprenticeShiTuInfo.getApprenticeinfo().getTimeinfo();
/* 101 */     if ((xApprenticeTimeInfo.getStarttime() <= 0L) || (xApprenticeTimeInfo.getEndtime() > 0L))
/*     */     {
/* 103 */       GameServer.logger().error(String.format("[shitu]PCChuShiReq.processImp@apprentice role not has shi tu relation now|master_role_id=%d|apprentice_role_id=%d|start_time=%d|end_time=%d", new Object[] { Long.valueOf(masterRoleId), Long.valueOf(this.apprenticeRoleId), Long.valueOf(xApprenticeTimeInfo.getStarttime()), Long.valueOf(xApprenticeTimeInfo.getEndtime()) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 108 */       return false;
/*     */     }
/*     */     
/* 111 */     MasterInfo xMasterInfo = Role2shitu.get(Long.valueOf(masterRoleId)).getMasterinfo();
/* 112 */     Map<Long, ShiTuTimeInfo> xNowApprenticeMapInfo = xMasterInfo.getApprentice_now();
/*     */     
/* 114 */     if (!xNowApprenticeMapInfo.containsKey(Long.valueOf(this.apprenticeRoleId)))
/*     */     {
/* 116 */       GameServer.logger().error(String.format("[shitu]PCChuShiReq.processImp@master not has the apprentice|master_role_id=%d|apprentice_role_id=%d|start_time=%d|end_time=%d|now_apprentice_list=%s", new Object[] { Long.valueOf(masterRoleId), Long.valueOf(this.apprenticeRoleId), Long.valueOf(xApprenticeTimeInfo.getStarttime()), Long.valueOf(xApprenticeTimeInfo.getEndtime()), xNowApprenticeMapInfo.keySet().toString() }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 121 */       return false;
/*     */     }
/*     */     
/* 124 */     ShiTuTimeInfo xMasterTimeInfo = (ShiTuTimeInfo)xNowApprenticeMapInfo.get(Long.valueOf(this.apprenticeRoleId));
/* 125 */     if ((xMasterTimeInfo.getStarttime() != xApprenticeTimeInfo.getStarttime()) || (xMasterTimeInfo.getEndtime() != xApprenticeTimeInfo.getEndtime()))
/*     */     {
/*     */ 
/* 128 */       GameServer.logger().error(String.format("[shitu]PCChuShiReq.processImp@master and apprentice time not match|master_role_id=%d|apprentice_role_id=%d|apprentice_start_time=%d|apprentice_end_time=%d|master_start_time=%d|master_end_time=%d", new Object[] { Long.valueOf(masterRoleId), Long.valueOf(this.apprenticeRoleId), Long.valueOf(xApprenticeTimeInfo.getStarttime()), Long.valueOf(xApprenticeTimeInfo.getEndtime()), Long.valueOf(xMasterTimeInfo.getStarttime()), Long.valueOf(xMasterTimeInfo.getEndtime()) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 133 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 137 */     long currentTimeMillis = DateTimeUtils.getCurrTimeInMillis();
/* 138 */     if (currentTimeMillis - xMasterTimeInfo.getStarttime() < ShiTuConsts.getInstance().chuShiRelationMinTime * 86400000L)
/*     */     {
/*     */ 
/* 141 */       GameServer.logger().error(String.format("[shitu]PCChuShiReq.processImp@shi tu relation time not enough|master_role_id=%d|apprentice_role_id=%d|apprentice_start_time=%d|apprentice_end_time=%d|master_start_time=%d|master_end_time=%d|current_time=%d", new Object[] { Long.valueOf(masterRoleId), Long.valueOf(this.apprenticeRoleId), Long.valueOf(xApprenticeTimeInfo.getStarttime()), Long.valueOf(xApprenticeTimeInfo.getEndtime()), Long.valueOf(xMasterTimeInfo.getStarttime()), Long.valueOf(xMasterTimeInfo.getEndtime()), Long.valueOf(currentTimeMillis) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 147 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 151 */     int apprenticeRoleLevel = RoleInterface.getLevel(this.apprenticeRoleId);
/* 152 */     if (apprenticeRoleLevel < ShiTuConsts.getInstance().chuShiApprenticeMinLevel)
/*     */     {
/* 154 */       GameServer.logger().error(String.format("[shitu]PCChuShiReq.processImp@apprentice role level is not enough|master_role_id=%d|apprentice_role_id=%d|apprentice_role_level=%d|need_level=%d", new Object[] { Long.valueOf(masterRoleId), Long.valueOf(this.apprenticeRoleId), Integer.valueOf(apprenticeRoleLevel), Integer.valueOf(ShiTuConsts.getInstance().chuShiApprenticeMinLevel) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 159 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 163 */     int friendValue = FriendInterface.getRelationValue(this.apprenticeRoleId, masterRoleId, true);
/* 164 */     if (friendValue < ShiTuConsts.getInstance().chuShiMinQinMiDu)
/*     */     {
/* 166 */       GameServer.logger().error(String.format("[shitu]PCChuShiReq.processImp@friend value is not enough|master_role_id=%d|apprentice_role_id=%d|friend_value=%d|need_friend_value=%d", new Object[] { Long.valueOf(masterRoleId), Long.valueOf(this.apprenticeRoleId), Integer.valueOf(friendValue), Integer.valueOf(ShiTuConsts.getInstance().chuShiMinQinMiDu) }));
/*     */       
/*     */ 
/*     */ 
/* 170 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 174 */     mzm.gsp.award.main.AwardModel awardModel = mzm.gsp.award.main.AwardInterface.awardFixAward(ShiTuConsts.getInstance().chuShiAwardId, apprenticeUserId, this.apprenticeRoleId, false, true, new AwardReason(LogReason.CHU_SHI_APPRENTICE_AWARD));
/*     */     
/*     */ 
/* 177 */     if (awardModel == null)
/*     */     {
/* 179 */       GameServer.logger().error(String.format("[shitu]PCChuShiReq.processImp@award apprentice error,AwardModel is null|apprentice_user_id=%s|apprentice_role_id=%d|master_role_id=%d|award_id=%d", new Object[] { apprenticeUserId, Long.valueOf(this.apprenticeRoleId), Long.valueOf(masterRoleId), Integer.valueOf(ShiTuConsts.getInstance().chuShiAwardId) }));
/*     */       
/*     */ 
/*     */ 
/* 183 */       return false;
/*     */     }
/* 185 */     String apprenticeRoleName = RoleInterface.getName(this.apprenticeRoleId);
/* 186 */     String masterRoleName = RoleInterface.getName(masterRoleId);
/*     */     
/* 188 */     List<String> contentArgs = new ArrayList();
/* 189 */     contentArgs.add(apprenticeRoleName);
/*     */     
/* 191 */     TLogArg tLogArg = new TLogArg(LogReason.CHU_SHI_MASTER_AWARD);
/*     */     
/* 193 */     SendMailRet sendMailRet = MailInterface.synBuildAndSendMail(masterRoleId, ShiTuConsts.getInstance().chuShiMailID, null, contentArgs, tLogArg);
/*     */     
/* 195 */     if (!sendMailRet.isOK())
/*     */     {
/* 197 */       GameServer.logger().error(String.format("[shitu]PCChuShiReq.processImp@send master email error|ret_code=%d|ret_reason=%s|apprentice_role_id=%d|master_role_id=%d|mail_id=%d", new Object[] { Integer.valueOf(sendMailRet.getRetEnum().ret), sendMailRet.getRetEnum().retMsg, Long.valueOf(this.apprenticeRoleId), Long.valueOf(masterRoleId), Integer.valueOf(ShiTuConsts.getInstance().chuShiMailID) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 202 */       return false;
/*     */     }
/* 204 */     xApprenticeShiTuInfo.setGraduatetimes(xApprenticeShiTuInfo.getGraduatetimes() + 1);
/* 205 */     xApprenticeTimeInfo.setEndtime(currentTimeMillis);
/*     */     
/* 207 */     xNowApprenticeMapInfo.remove(Long.valueOf(this.apprenticeRoleId));
/* 208 */     xMasterInfo.getNow_apprentice_role_list().remove(Long.valueOf(this.apprenticeRoleId));
/*     */     
/* 210 */     ShiTuTimeInfo xGraduateShiTuTimeInfo = xbean.Pod.newShiTuTimeInfo();
/* 211 */     xGraduateShiTuTimeInfo.setStarttime(xApprenticeTimeInfo.getStarttime());
/* 212 */     xGraduateShiTuTimeInfo.setEndtime(currentTimeMillis);
/*     */     
/* 214 */     xMasterInfo.getApprentice_graduate().put(Long.valueOf(this.apprenticeRoleId), xGraduateShiTuTimeInfo);
/* 215 */     xMasterInfo.getApprentice_role_list().add(Long.valueOf(this.apprenticeRoleId));
/*     */     
/*     */ 
/* 218 */     OnlineManager.getInstance().sendMulti(ShiTuManager.changeShiTuTaskPublishState(this.apprenticeRoleId, 2, 6), Arrays.asList(new Long[] { Long.valueOf(masterRoleId), Long.valueOf(this.apprenticeRoleId) }));
/*     */     
/*     */ 
/* 221 */     xbean.ShiTuTaskInfo xShiTuTaskInfo = xtable.Role2shitutask.get(Long.valueOf(this.apprenticeRoleId));
/*     */     
/* 223 */     ShiTuManager.sendShiTuTaskReward(masterRoleId, this.apprenticeRoleId, xShiTuTaskInfo);
/*     */     
/* 225 */     SChuShiSuccess sChuShiSuccess = new SChuShiSuccess();
/* 226 */     sChuShiSuccess.apprenticeroleid = this.apprenticeRoleId;
/* 227 */     sChuShiSuccess.apprenticerolename = apprenticeRoleName;
/*     */     
/* 229 */     TitleInterface.removeAppllation(this.apprenticeRoleId, ShiTuConsts.getInstance().apprenticeAppellationId);
/*     */     
/* 231 */     TitleInterface.addAppellation(this.apprenticeRoleId, ShiTuConsts.getInstance().chuShiAppellationId, Arrays.asList(new String[] { masterRoleName }));
/*     */     
/*     */ 
/* 234 */     OnlineManager.getInstance().sendMulti(sChuShiSuccess, Arrays.asList(new Long[] { Long.valueOf(masterRoleId), Long.valueOf(this.apprenticeRoleId) }));
/*     */     
/* 236 */     ShiTuManager.tlogShiTuRelation(this.apprenticeRoleId, masterRoleId, this.apprenticeRoleId, ShiTuRelationTLogEnum.CHU_SHI);
/*     */     
/* 238 */     GameServer.logger().info(String.format("[shitu]PCChuShiReq.processImp@handle chu shi req success|apprentice_role_id=%d|apprentice_role_name=%s|master_role_id=%d", new Object[] { Long.valueOf(this.apprenticeRoleId), apprenticeRoleName, Long.valueOf(masterRoleId) }));
/*     */     
/*     */ 
/*     */ 
/* 242 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shitu\main\PCChuShiReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */