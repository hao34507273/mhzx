/*     */ package mzm.gsp.children.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.children.SAgreeOrRefusePregnantBelong;
/*     */ import mzm.gsp.children.SChildNormalFail;
/*     */ import mzm.gsp.children.SPregnantCutVigorFail;
/*     */ import mzm.gsp.children.SSyncBreedInfo;
/*     */ import mzm.gsp.children.confbean.SChildrenConsts;
/*     */ import mzm.gsp.homeland.main.HomeInfoWrapper;
/*     */ import mzm.gsp.homeland.main.HomeServiceChecker;
/*     */ import mzm.gsp.homeland.main.HomelandInterface;
/*     */ import mzm.gsp.marriage.main.MarriageInterface;
/*     */ import mzm.gsp.npc.main.NpcInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.HomeInfo;
/*     */ import xtable.Role2properties;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCAgreeOrRefusePregnantBelong
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long teamMemberRoleId;
/*     */   private final int operator;
/*     */   private final long sessionId;
/*     */   private long marriedRoleId;
/*     */   private long belongRoleId;
/*     */   
/*     */   public PCAgreeOrRefusePregnantBelong(long teamMemberRoleId, int operator, long sessionId)
/*     */   {
/*  42 */     this.teamMemberRoleId = teamMemberRoleId;
/*  43 */     this.operator = operator;
/*  44 */     this.sessionId = sessionId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  50 */     if ((this.operator != 1) && (this.operator != 0))
/*     */     {
/*  52 */       return false;
/*     */     }
/*     */     
/*  55 */     if (!ChildrenManager.isChildrenFunLevelOpen(this.teamMemberRoleId))
/*     */     {
/*  57 */       onAgreeOrRefusePregnantBelong(21);
/*  58 */       return false;
/*     */     }
/*     */     
/*  61 */     if (!ChildrenManager.isFunOpen(this.teamMemberRoleId))
/*     */     {
/*  63 */       return false;
/*     */     }
/*     */     
/*  66 */     if (!ChildrenManager.canDoAction(this.teamMemberRoleId, 831))
/*     */     {
/*  68 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  72 */     HomeInfoWrapper homeInfoWrapper = HomelandInterface.getHomeInfoWrapper(this.teamMemberRoleId, false);
/*  73 */     if (homeInfoWrapper == null)
/*     */     {
/*  75 */       onAgreeOrRefusePregnantBelong(10);
/*  76 */       return false;
/*     */     }
/*     */     
/*  79 */     int pregnantNpcId = HomelandInterface.getMaidNpc(homeInfoWrapper);
/*     */     
/*  81 */     if (!NpcInterface.checkNpcService(this.teamMemberRoleId, SChildrenConsts.getInstance().pregnant_npc_service_id, pregnantNpcId, new HomeServiceChecker(this.teamMemberRoleId, homeInfoWrapper.getxHomeInfo().getCurrentmaiduuid())))
/*     */     {
/*     */ 
/*     */ 
/*  85 */       onAgreeOrRefusePregnantBelong(11);
/*  86 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  90 */     this.marriedRoleId = MarriageInterface.getMarriedRoleid(this.teamMemberRoleId);
/*     */     
/*  92 */     if (this.marriedRoleId < 0L)
/*     */     {
/*  94 */       onAgreeOrRefusePregnantBelong(12);
/*  95 */       return false;
/*     */     }
/*     */     
/*  98 */     Long teamId = TeamInterface.getTeamidByRoleid(this.teamMemberRoleId, false);
/*  99 */     if (teamId == null)
/*     */     {
/* 101 */       onAgreeOrRefusePregnantBelong(13);
/* 102 */       return false;
/*     */     }
/*     */     
/* 105 */     List<Long> selectMembers = TeamInterface.getTeamMemberList(teamId.longValue(), false);
/* 106 */     if (selectMembers.size() != 2)
/*     */     {
/* 108 */       onAgreeOrRefusePregnantBelong(14);
/* 109 */       return false;
/*     */     }
/*     */     
/* 112 */     if (this.marriedRoleId != ((Long)selectMembers.get(0)).longValue())
/*     */     {
/* 114 */       onAgreeOrRefusePregnantBelong(15);
/* 115 */       return false;
/*     */     }
/*     */     
/* 118 */     if (this.teamMemberRoleId != ((Long)selectMembers.get(1)).longValue())
/*     */     {
/* 120 */       onAgreeOrRefusePregnantBelong(16);
/* 121 */       return false;
/*     */     }
/*     */     
/* 124 */     String teamMemberUserId = RoleInterface.getUserId(this.teamMemberRoleId);
/* 125 */     String marriedUserId = RoleInterface.getUserId(this.marriedRoleId);
/* 126 */     lock(User.getTable(), Arrays.asList(new String[] { teamMemberUserId, marriedUserId }));
/* 127 */     lock(Role2properties.getTable(), selectMembers);
/*     */     
/* 129 */     if (this.marriedRoleId != MarriageInterface.getMarriedRoleid(this.teamMemberRoleId, true))
/*     */     {
/* 131 */       onAgreeOrRefusePregnantBelong(22);
/* 132 */       return false;
/*     */     }
/*     */     
/* 135 */     if (!HomelandInterface.isAtHome(this.teamMemberRoleId, true))
/*     */     {
/* 137 */       onAgreeOrRefusePregnantBelong(19);
/* 138 */       return false;
/*     */     }
/*     */     
/* 141 */     if (!HomelandInterface.isAtHome(this.marriedRoleId, true))
/*     */     {
/* 143 */       onAgreeOrRefusePregnantBelong(18);
/* 144 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 148 */     if (!HomelandInterface.hasBed(this.teamMemberRoleId))
/*     */     {
/* 150 */       onAgreeOrRefusePregnantBelong(20);
/* 151 */       return false;
/*     */     }
/*     */     
/* 154 */     Session session = SelectPregnantBelongSession.getSession(this.sessionId);
/* 155 */     SelectPregnantBelongSession selectSession = null;
/*     */     
/* 157 */     if ((session instanceof SelectPregnantBelongSession))
/*     */     {
/* 159 */       selectSession = (SelectPregnantBelongSession)session;
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/* 164 */       return false;
/*     */     }
/*     */     
/* 167 */     Session.removeSession(this.sessionId);
/*     */     
/* 169 */     if ((selectSession.getOwerId() != this.marriedRoleId) || (selectSession.getTeamMemberRoleId() != this.teamMemberRoleId))
/*     */     {
/* 171 */       onAgreeOrRefusePregnantBelong(32);
/* 172 */       return false;
/*     */     }
/*     */     
/* 175 */     SAgreeOrRefusePregnantBelong sAgreeOrRefusePregnantBelong = new SAgreeOrRefusePregnantBelong();
/* 176 */     sAgreeOrRefusePregnantBelong.operator = this.operator;
/*     */     
/* 178 */     if (this.operator == 0)
/*     */     {
/* 180 */       OnlineManager.getInstance().send(this.marriedRoleId, sAgreeOrRefusePregnantBelong);
/* 181 */       return true;
/*     */     }
/*     */     
/* 184 */     this.belongRoleId = selectSession.getBelongRoleId();
/*     */     
/* 186 */     boolean cutLeaderVigorResult = RoleInterface.cutVigor(this.teamMemberRoleId, SChildrenConsts.getInstance().pregnant_cut_vigor_score, new TLogArg(LogReason.CHILDREN_PREGNANT_CUT_VIGOR));
/*     */     
/* 188 */     if (!cutLeaderVigorResult)
/*     */     {
/* 190 */       syncPrepareCutVigorFail(this.teamMemberRoleId);
/* 191 */       return false;
/*     */     }
/*     */     
/* 194 */     boolean cutMemberVigorResult = RoleInterface.cutVigor(this.marriedRoleId, SChildrenConsts.getInstance().pregnant_cut_vigor_score, new TLogArg(LogReason.CHILDREN_PREGNANT_CUT_VIGOR));
/*     */     
/* 196 */     if (!cutMemberVigorResult)
/*     */     {
/* 198 */       syncPrepareCutVigorFail(this.marriedRoleId);
/* 199 */       return false;
/*     */     }
/*     */     
/* 202 */     long marrigeId = MarriageInterface.getMarriedId(this.teamMemberRoleId, true);
/* 203 */     if (marrigeId < 0L)
/*     */     {
/* 205 */       onAgreeOrRefusePregnantBelong(31);
/* 206 */       return false;
/*     */     }
/*     */     
/* 209 */     MarriageInterface.setPregnantBelongRoleId(marrigeId, this.belongRoleId);
/*     */     
/* 211 */     int teamMemberRoleGender = RoleInterface.getGender(this.teamMemberRoleId);
/* 212 */     if (teamMemberRoleGender == 2)
/*     */     {
/* 214 */       RoleStatusInterface.setStatus(this.teamMemberRoleId, 901, false);
/*     */     }
/*     */     else
/*     */     {
/* 218 */       RoleStatusInterface.setStatus(this.marriedRoleId, 901, false);
/*     */     }
/*     */     
/* 221 */     OnlineManager.getInstance().send(this.marriedRoleId, sAgreeOrRefusePregnantBelong);
/*     */     
/* 223 */     ChildrenManager.tlogCoupleBreedFinishStep(this.teamMemberRoleId, this.marriedRoleId, 2);
/*     */     
/* 225 */     SSyncBreedInfo sSyncBreedInfo = new SSyncBreedInfo();
/* 226 */     sSyncBreedInfo.breed_state = 0;
/* 227 */     sSyncBreedInfo.score = 0;
/* 228 */     sSyncBreedInfo.step = 3;
/*     */     
/* 230 */     OnlineManager.getInstance().sendMulti(sSyncBreedInfo, selectMembers);
/*     */     
/* 232 */     GameServer.logger().info(String.format("[children]PCAgreeOrRefusePregnantBelong.processImp@handle argee or refuse pregnant belong success|team_member_role_id=%d|operator=%d|session_id=%d|marriage_role_id=%d|belong_role_id==%d", new Object[] { Long.valueOf(this.teamMemberRoleId), Integer.valueOf(this.operator), Long.valueOf(this.sessionId), Long.valueOf(this.marriedRoleId), Long.valueOf(this.belongRoleId) }));
/*     */     
/*     */ 
/*     */ 
/* 236 */     return true;
/*     */   }
/*     */   
/*     */   private void syncPrepareCutVigorFail(long roleId)
/*     */   {
/* 241 */     SPregnantCutVigorFail sPregnantCutVigorFail = new SPregnantCutVigorFail();
/* 242 */     sPregnantCutVigorFail.role_id = roleId;
/* 243 */     OnlineManager.getInstance().sendMultiAtOnce(sPregnantCutVigorFail, Arrays.asList(new Long[] { Long.valueOf(this.marriedRoleId), Long.valueOf(this.teamMemberRoleId) }));
/*     */     
/*     */ 
/* 246 */     StringBuilder sbLog = new StringBuilder();
/* 247 */     sbLog.append("[children]PCAgreeOrRefusePregnantBelong.processImp@cut vigor fail");
/* 248 */     sbLog.append("|vigor_not_enough_role_id=").append(roleId);
/* 249 */     sbLog.append("|team_member_role_id=").append(this.teamMemberRoleId);
/* 250 */     sbLog.append("|operator=").append(this.operator);
/* 251 */     sbLog.append("|session_id=").append(this.sessionId);
/* 252 */     sbLog.append("|marriage_role_id=").append(this.marriedRoleId);
/* 253 */     sbLog.append("|belong_role_id=").append(this.belongRoleId);
/*     */     
/* 255 */     GameServer.logger().error(sbLog.toString());
/*     */   }
/*     */   
/*     */ 
/*     */   private void onAgreeOrRefusePregnantBelong(int ret)
/*     */   {
/* 261 */     onAgreeOrRefusePregnantBelong(ret, null);
/*     */   }
/*     */   
/*     */   private void onAgreeOrRefusePregnantBelong(int ret, Map<String, Object> extraMap)
/*     */   {
/* 266 */     StringBuilder sbLog = new StringBuilder();
/* 267 */     sbLog.append("[children]PCAgreeOrRefusePregnantBelong.processImp@cut vigor fail");
/* 268 */     sbLog.append("|ret=").append(ret);
/* 269 */     sbLog.append("|team_member_role_id=").append(this.teamMemberRoleId);
/* 270 */     sbLog.append("|operator=").append(this.operator);
/* 271 */     sbLog.append("|session_id=").append(this.sessionId);
/* 272 */     sbLog.append("|marriage_role_id=").append(this.marriedRoleId);
/* 273 */     sbLog.append("|belong_role_id=").append(this.belongRoleId);
/* 274 */     if ((extraMap != null) && (!extraMap.isEmpty()))
/*     */     {
/* 276 */       for (Map.Entry<String, ?> entry : extraMap.entrySet())
/*     */       {
/* 278 */         sbLog.append('|').append((String)entry.getKey()).append('=').append(entry.getValue());
/*     */       }
/*     */     }
/* 281 */     GameServer.logger().error(sbLog.toString());
/*     */     
/* 283 */     SChildNormalFail sChildNormalFail = new SChildNormalFail();
/* 284 */     sChildNormalFail.result = ret;
/*     */     
/* 286 */     OnlineManager.getInstance().sendAtOnce(this.teamMemberRoleId, sChildNormalFail);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\main\PCAgreeOrRefusePregnantBelong.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */