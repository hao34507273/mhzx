/*     */ package mzm.gsp.interactivetask.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.homeland.main.HomeInfoWrapper;
/*     */ import mzm.gsp.homeland.main.HomelandInterface;
/*     */ import mzm.gsp.interactivetask.confbean.SInteractiveTaskTypeCfg;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.team.main.TeamInfo;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PGM_JoinGiveBirth
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int typeid;
/*     */   
/*     */   public PGM_JoinGiveBirth(long roleid, int typeid)
/*     */   {
/*  26 */     this.roleid = roleid;
/*  27 */     this.typeid = typeid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  33 */     SInteractiveTaskTypeCfg s = SInteractiveTaskTypeCfg.get(this.typeid);
/*  34 */     if (s == null)
/*     */     {
/*  36 */       return false;
/*     */     }
/*     */     
/*  39 */     HomeInfoWrapper homeInfoWrapper = HomelandInterface.getHomeInfoWrapper(this.roleid, true);
/*  40 */     if (homeInfoWrapper == null)
/*     */     {
/*  42 */       return false;
/*     */     }
/*  44 */     if (homeInfoWrapper.getPartnerRoleId() == -1L)
/*     */     {
/*  46 */       return false;
/*     */     }
/*  48 */     if (!InteractiveTaskManager.isInteractiveTaskSwitchOpenForRole(this.roleid, this.typeid))
/*     */     {
/*  50 */       String logString = String.format("[interactivetask]PJoinInteractiveTaskReq.processImp@switch is closed for|roleId=%d|typeid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.typeid) });
/*     */       
/*     */ 
/*  53 */       InteractiveTaskManager.logger.info(logString);
/*  54 */       return false;
/*     */     }
/*  56 */     if (!InteractiveTaskManager.isInteractiveTaskSwitchOpenForRole(homeInfoWrapper.getPartnerRoleId(), this.typeid))
/*     */     {
/*  58 */       String logString = String.format("[interactivetask]PJoinInteractiveTaskReq.processImp@switch is closed for|roleId=%d|typeid=%d", new Object[] { Long.valueOf(homeInfoWrapper.getPartnerRoleId()), Integer.valueOf(this.typeid) });
/*     */       
/*     */ 
/*  61 */       InteractiveTaskManager.logger.info(logString);
/*  62 */       return false;
/*     */     }
/*  64 */     if (RoleInterface.getGender(this.roleid) != 2)
/*     */     {
/*  66 */       return false;
/*     */     }
/*  68 */     long homeWorleId = homeInfoWrapper.getHomeWorldId();
/*  69 */     if (!HomelandInterface.isAtHome(this.roleid, homeWorleId))
/*     */     {
/*  71 */       String logString = String.format("[interactivetask]PJoinInteractiveTaskReq.processImp@role is not at home|roleId=%d|homeWorleId=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(homeWorleId) });
/*     */       
/*     */ 
/*  74 */       InteractiveTaskManager.logger.info(logString);
/*  75 */       return false;
/*     */     }
/*  77 */     if (!HomelandInterface.isAtHome(homeInfoWrapper.getPartnerRoleId(), homeWorleId))
/*     */     {
/*  79 */       String logString = String.format("[interactivetask]PJoinInteractiveTaskReq.processImp@role is not at home|roleId=%d|homeWorleId=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(homeWorleId) });
/*     */       
/*     */ 
/*  82 */       InteractiveTaskManager.logger.info(logString);
/*  83 */       return false;
/*     */     }
/*  85 */     TeamInfo teamInfo = TeamInterface.getTeamInfoByRoleId(this.roleid);
/*  86 */     if (teamInfo == null)
/*     */     {
/*  88 */       return false;
/*     */     }
/*  90 */     if (teamInfo.getLeaderId() != this.roleid)
/*     */     {
/*  92 */       return false;
/*     */     }
/*  94 */     if (teamInfo.getTeamMemberList().size() != 2)
/*     */     {
/*  96 */       return false;
/*     */     }
/*  98 */     if (teamInfo.getTeamNormalList().size() != 2)
/*     */     {
/* 100 */       return false;
/*     */     }
/* 102 */     if (!teamInfo.getTeamNormalList().contains(Long.valueOf(homeInfoWrapper.getPartnerRoleId())))
/*     */     {
/* 104 */       return false;
/*     */     }
/*     */     
/* 107 */     if (RoleStatusInterface.containsStatus(this.roleid, 650))
/*     */     {
/* 109 */       return false;
/*     */     }
/* 111 */     if (RoleStatusInterface.containsStatus(homeInfoWrapper.getPartnerRoleId(), 650))
/*     */     {
/* 113 */       return false;
/*     */     }
/* 115 */     if (!RoleStatusInterface.checkCansetStatus(Arrays.asList(new Long[] { Long.valueOf(this.roleid), Long.valueOf(homeInfoWrapper.getPartnerRoleId()) }), 650, true))
/*     */     {
/*     */ 
/* 118 */       String log = String.format("[interactivetask]PJoinInteractiveTaskReq.processImp@role status can not join interactive task|roleid1=%d|roleid2=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(homeInfoWrapper.getPartnerRoleId()) });
/*     */       
/*     */ 
/* 121 */       InteractiveTaskManager.logger.info(log);
/* 122 */       return false;
/*     */     }
/*     */     
/* 125 */     long worlid = InteractiveTaskManager.createWorld(s.mapid);
/* 126 */     List<Long> roleList = Arrays.asList(new Long[] { Long.valueOf(homeInfoWrapper.getOwnerRoleId()), Long.valueOf(homeInfoWrapper.getPartnerRoleId()) });
/* 127 */     InteractiveTaskSession session = new InteractiveTaskSession(TimeUnit.MINUTES.toSeconds(s.maxFinishTime), roleList, this.typeid);
/*     */     
/*     */ 
/* 130 */     InteractiveTaskManager.addInteractiveTaskInfo(homeInfoWrapper.getOwnerRoleId(), this.typeid, this.roleid, roleList, worlid, session.getSessionId());
/*     */     
/* 132 */     InteractiveTaskManager.addInteractiveTaskInfo(homeInfoWrapper.getPartnerRoleId(), this.typeid, this.roleid, roleList, worlid, session.getSessionId());
/*     */     
/* 134 */     InteractiveTaskManager.transferToFubenWorld(roleList, worlid, s.mapid);
/*     */     
/* 136 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\interactivetask\main\PGM_JoinGiveBirth.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */