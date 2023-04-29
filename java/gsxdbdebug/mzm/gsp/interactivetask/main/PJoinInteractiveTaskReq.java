/*     */ package mzm.gsp.interactivetask.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.children.main.ChildrenInterface;
/*     */ import mzm.gsp.homeland.main.HomeInfoWrapper;
/*     */ import mzm.gsp.homeland.main.HomelandInterface;
/*     */ import mzm.gsp.interactivetask.confbean.SInteractiveTaskTypeCfg;
/*     */ import mzm.gsp.qingfu.main.CostType;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.team.main.TeamInfo;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PJoinInteractiveTaskReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int typeid;
/*     */   
/*     */   public PJoinInteractiveTaskReq(long roleid, int typeid)
/*     */   {
/*  31 */     this.roleid = roleid;
/*  32 */     this.typeid = typeid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  38 */     SInteractiveTaskTypeCfg s = SInteractiveTaskTypeCfg.get(this.typeid);
/*  39 */     if (s == null)
/*     */     {
/*  41 */       String logString = String.format("[interactivetask]PJoinInteractiveTaskReq.processImp@type id error|roleid=%d|typeid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.typeid) });
/*     */       
/*     */ 
/*  44 */       InteractiveTaskManager.logger.error(logString);
/*  45 */       return false;
/*     */     }
/*     */     
/*  48 */     HomeInfoWrapper homeInfoWrapper = HomelandInterface.getHomeInfoWrapper(this.roleid, true);
/*  49 */     if (homeInfoWrapper == null)
/*     */     {
/*  51 */       String logString = String.format("[interactivetask]PJoinInteractiveTaskReq.processImp@no home|roleid=%d|typeid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.typeid) });
/*     */       
/*  53 */       InteractiveTaskManager.logger.info(logString);
/*  54 */       return false;
/*     */     }
/*  56 */     if (homeInfoWrapper.getPartnerRoleId() == -1L)
/*     */     {
/*  58 */       String logString = String.format("[interactivetask]PJoinInteractiveTaskReq.processImp@no partener roleid|roleid=%d|typeid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.typeid) });
/*     */       
/*     */ 
/*  61 */       InteractiveTaskManager.logger.info(logString);
/*  62 */       return false;
/*     */     }
/*  64 */     if ((this.roleid != homeInfoWrapper.getOwnerRoleId()) && (this.roleid != homeInfoWrapper.getPartnerRoleId()))
/*     */     {
/*  66 */       String log = String.format("[interactivetask]PJoinInteractiveTaskReq.processImp@role error|roleid=%d|partner_roleid=%d|owner_roleid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(homeInfoWrapper.getPartnerRoleId()), Long.valueOf(homeInfoWrapper.getOwnerRoleId()) });
/*     */       
/*     */ 
/*  69 */       InteractiveTaskManager.logger.error(log);
/*  70 */       return false;
/*     */     }
/*  72 */     if (!InteractiveTaskManager.isInteractiveTaskSwitchOpenForRole(homeInfoWrapper.getOwnerRoleId(), this.typeid))
/*     */     {
/*  74 */       String logString = String.format("[interactivetask]PJoinInteractiveTaskReq.processImp@switch is closed for owner roleid|roleId=%d|typeid=%d|owner_roleid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.typeid), Long.valueOf(homeInfoWrapper.getOwnerRoleId()) });
/*     */       
/*     */ 
/*  77 */       InteractiveTaskManager.logger.info(logString);
/*  78 */       return false;
/*     */     }
/*  80 */     if (!InteractiveTaskManager.isInteractiveTaskSwitchOpenForRole(homeInfoWrapper.getPartnerRoleId(), this.typeid))
/*     */     {
/*  82 */       String logString = String.format("[interactivetask]PJoinInteractiveTaskReq.processImp@switch is closed for partner roleid|roleId=%d|typeid=%d|partner_roleid=%d", new Object[] { Long.valueOf(homeInfoWrapper.getPartnerRoleId()), Integer.valueOf(this.typeid), Long.valueOf(homeInfoWrapper.getPartnerRoleId()) });
/*     */       
/*     */ 
/*  85 */       InteractiveTaskManager.logger.info(logString);
/*  86 */       return false;
/*     */     }
/*  88 */     if (RoleInterface.getGender(this.roleid) != 2)
/*     */     {
/*  90 */       String logString = String.format("[interactivetask]PJoinInteractiveTaskReq.processImp@sex error|roleId=%d|typeid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.typeid) });
/*     */       
/*  92 */       InteractiveTaskManager.logger.info(logString);
/*  93 */       return false;
/*     */     }
/*  95 */     long homeWorleId = homeInfoWrapper.getHomeWorldId();
/*  96 */     if (!HomelandInterface.isAtHome(this.roleid, homeWorleId))
/*     */     {
/*  98 */       String logString = String.format("[interactivetask]PJoinInteractiveTaskReq.processImp@role is not at home|roleid=%d|homeWorleId=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(homeWorleId) });
/*     */       
/*     */ 
/* 101 */       InteractiveTaskManager.logger.info(logString);
/* 102 */       return false;
/*     */     }
/* 104 */     if (!HomelandInterface.isAtHome(homeInfoWrapper.getPartnerRoleId(), homeWorleId))
/*     */     {
/* 106 */       String logString = String.format("[interactivetask]PJoinInteractiveTaskReq.processImp@role is not at home|roleid=%d|homeWorleId=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(homeWorleId) });
/*     */       
/*     */ 
/* 109 */       InteractiveTaskManager.logger.info(logString);
/* 110 */       return false;
/*     */     }
/* 112 */     TeamInfo teamInfo = TeamInterface.getTeamInfoByRoleId(this.roleid);
/* 113 */     if (teamInfo == null)
/*     */     {
/* 115 */       String logString = String.format("[interactivetask]PJoinInteractiveTaskReq.processImp@team info null|roleid=%d|homeWorleId=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(homeWorleId) });
/*     */       
/*     */ 
/* 118 */       InteractiveTaskManager.logger.info(logString);
/* 119 */       return false;
/*     */     }
/* 121 */     if (teamInfo.getLeaderId() != this.roleid)
/*     */     {
/* 123 */       String logString = String.format("[interactivetask]PJoinInteractiveTaskReq.processImp@not team leader|roleid=%d|homeWorleId=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(homeWorleId) });
/*     */       
/*     */ 
/* 126 */       InteractiveTaskManager.logger.info(logString);
/* 127 */       return false;
/*     */     }
/* 129 */     if (teamInfo.getTeamMemberList().size() != 2)
/*     */     {
/* 131 */       String logString = String.format("[interactivetask]PJoinInteractiveTaskReq.processImp@team has other roles|roleid=%d|homeWorleId=%d|team_size=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(homeWorleId), Integer.valueOf(teamInfo.getTeamMemberList().size()) });
/*     */       
/*     */ 
/* 134 */       InteractiveTaskManager.logger.info(logString);
/* 135 */       return false;
/*     */     }
/* 137 */     if (teamInfo.getTeamNormalList().size() != 2)
/*     */     {
/* 139 */       String logString = String.format("[interactivetask]PJoinInteractiveTaskReq.processImp@team normal list has other roles|roleid=%d|homeWorleId=%d|normal_size=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(homeWorleId), Integer.valueOf(teamInfo.getTeamNormalList().size()) });
/*     */       
/*     */ 
/* 142 */       InteractiveTaskManager.logger.info(logString);
/* 143 */       return false;
/*     */     }
/* 145 */     if (!teamInfo.getTeamNormalList().contains(Long.valueOf(homeInfoWrapper.getOwnerRoleId())))
/*     */     {
/* 147 */       String logString = String.format("[interactivetask]PJoinInteractiveTaskReq.processImp@team normal list contains no owner|roleid=%d|owner_roleid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(homeInfoWrapper.getOwnerRoleId()) });
/*     */       
/*     */ 
/* 150 */       InteractiveTaskManager.logger.info(logString);
/* 151 */       return false;
/*     */     }
/* 153 */     if (!teamInfo.getTeamNormalList().contains(Long.valueOf(homeInfoWrapper.getPartnerRoleId())))
/*     */     {
/* 155 */       String logString = String.format("[interactivetask]PJoinInteractiveTaskReq.processImp@team normal list contains no partner|roleid=%d|partner_roleid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(homeInfoWrapper.getPartnerRoleId()) });
/*     */       
/*     */ 
/* 158 */       InteractiveTaskManager.logger.info(logString);
/* 159 */       return false;
/*     */     }
/* 161 */     if (RoleStatusInterface.containsStatus(homeInfoWrapper.getOwnerRoleId(), 650))
/*     */     {
/* 163 */       String logString = String.format("[interactivetask]PJoinInteractiveTaskReq.processImp@owner is already in give birth|roleid=%d|owner_roleid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(homeInfoWrapper.getOwnerRoleId()) });
/*     */       
/*     */ 
/* 166 */       InteractiveTaskManager.logger.info(logString);
/* 167 */       return false;
/*     */     }
/* 169 */     if (RoleStatusInterface.containsStatus(homeInfoWrapper.getPartnerRoleId(), 650))
/*     */     {
/* 171 */       String logString = String.format("[interactivetask]PJoinInteractiveTaskReq.processImp@partner is already in give birth|roleid=%d|partner_roleid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(homeInfoWrapper.getPartnerRoleId()) });
/*     */       
/*     */ 
/* 174 */       InteractiveTaskManager.logger.info(logString);
/* 175 */       return false;
/*     */     }
/* 177 */     List<Long> roleList = Arrays.asList(new Long[] { Long.valueOf(homeInfoWrapper.getOwnerRoleId()), Long.valueOf(homeInfoWrapper.getPartnerRoleId()) });
/* 178 */     if (!RoleStatusInterface.checkCansetStatus(roleList, 650, true))
/*     */     {
/* 180 */       String log = String.format("[interactivetask]PJoinInteractiveTaskReq.processImp@role status can not join interactive task|roleid=%d|partner_roleid=%d|owner_roleid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(homeInfoWrapper.getPartnerRoleId()), Long.valueOf(homeInfoWrapper.getOwnerRoleId()) });
/*     */       
/*     */ 
/* 183 */       InteractiveTaskManager.logger.info(log);
/* 184 */       return false;
/*     */     }
/* 186 */     if (!ChildrenInterface.isCanGiveBirth(this.roleid))
/*     */     {
/* 188 */       String log = String.format("[interactivetask]PJoinInteractiveTaskReq.processImp@role can not join interactive task|roleid=%d|partner_roleid=%d|owner_roleid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(homeInfoWrapper.getPartnerRoleId()), Long.valueOf(homeInfoWrapper.getOwnerRoleId()) });
/*     */       
/*     */ 
/* 191 */       InteractiveTaskManager.logger.info(log);
/* 192 */       return false;
/*     */     }
/* 194 */     if (s.moneyNum > 0)
/*     */     {
/* 196 */       boolean ret = InteractiveTaskManager.cutMoney(RoleInterface.getUserId(this.roleid), this.roleid, LogReason.GIVE_BIRTH_COST, this.typeid, s.moneyType, s.moneyNum, CostType.COST_BIND_GIVE_BIRTH);
/*     */       
/* 198 */       if (!ret)
/*     */       {
/* 200 */         String log = String.format("[interactivetask]PJoinInteractiveTaskReq.processImp@money not enough|roleid|moneytype=%d|moneynum=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(s.moneyType), Integer.valueOf(s.moneyNum) });
/*     */         
/*     */ 
/* 203 */         InteractiveTaskManager.logger.error(log);
/* 204 */         return false;
/*     */       }
/*     */     }
/*     */     
/* 208 */     long partnerRoleid = homeInfoWrapper.getOwnerRoleId() != this.roleid ? homeInfoWrapper.getOwnerRoleId() : homeInfoWrapper.getPartnerRoleId();
/*     */     
/* 210 */     tlogJoinInteractivetask(partnerRoleid, s.moneyType, s.moneyNum);
/*     */     
/* 212 */     long worlid = InteractiveTaskManager.createWorld(s.mapid);
/* 213 */     InteractiveTaskSession session = new InteractiveTaskSession(TimeUnit.MINUTES.toSeconds(s.maxFinishTime), roleList, this.typeid);
/*     */     
/*     */ 
/* 216 */     InteractiveTaskManager.addInteractiveTaskInfo(homeInfoWrapper.getOwnerRoleId(), this.typeid, this.roleid, roleList, worlid, session.getSessionId());
/*     */     
/* 218 */     InteractiveTaskManager.addInteractiveTaskInfo(homeInfoWrapper.getPartnerRoleId(), this.typeid, this.roleid, roleList, worlid, session.getSessionId());
/*     */     
/* 220 */     InteractiveTaskManager.transferToFubenWorld(roleList, worlid, s.mapid);
/*     */     
/* 222 */     String log = String.format("[interactivetask]PJoinInteractiveTaskReq.processImp@role transfer in give birth world success|roleid=%d|partner_roleid=%d|owner_roleid=%d|worldid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(homeInfoWrapper.getPartnerRoleId()), Long.valueOf(homeInfoWrapper.getOwnerRoleId()), Long.valueOf(worlid) });
/*     */     
/*     */ 
/* 225 */     InteractiveTaskManager.logger.info(log);
/* 226 */     return true;
/*     */   }
/*     */   
/*     */   private void tlogJoinInteractivetask(long partnerRoleid, int moneyType, int moneyNum)
/*     */   {
/* 231 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 232 */     String userid = RoleInterface.getUserId(this.roleid);
/* 233 */     int rolelevel = RoleInterface.getLevel(this.roleid);
/* 234 */     Object[] columnns = { vGameIP, userid, Long.valueOf(this.roleid), Integer.valueOf(rolelevel), Long.valueOf(partnerRoleid), Integer.valueOf(this.typeid), Integer.valueOf(moneyType), Integer.valueOf(moneyNum) };
/* 235 */     TLogManager.getInstance().addLog(this.roleid, "JoinInteractivetask", columnns);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\interactivetask\main\PJoinInteractiveTaskReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */