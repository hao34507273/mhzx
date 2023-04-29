/*     */ package mzm.gsp.children.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.children.SChildNormalFail;
/*     */ import mzm.gsp.children.SPregnantCutVigorFail;
/*     */ import mzm.gsp.children.SSelectPregnantBelong;
/*     */ import mzm.gsp.children.confbean.SChildrenConsts;
/*     */ import mzm.gsp.homeland.main.HomeInfoWrapper;
/*     */ import mzm.gsp.homeland.main.HomeServiceChecker;
/*     */ import mzm.gsp.homeland.main.HomelandInterface;
/*     */ import mzm.gsp.marriage.main.MarriageInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import xbean.HomeInfo;
/*     */ import xbean.Role2ChildrenInfo;
/*     */ import xtable.Role2children;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCSelectPregnantBelong extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long teamLeaderRoleId;
/*     */   private long marriedRoleId;
/*     */   private final long belongRoleId;
/*     */   
/*     */   public PCSelectPregnantBelong(long teamLeaderRoleId, long belongRoleId)
/*     */   {
/*  30 */     this.teamLeaderRoleId = teamLeaderRoleId;
/*  31 */     this.belongRoleId = belongRoleId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  37 */     if (!ChildrenManager.isChildrenFunLevelOpen(this.teamLeaderRoleId))
/*     */     {
/*  39 */       onSelectPregnantBelongFail(21);
/*  40 */       return false;
/*     */     }
/*     */     
/*  43 */     if (!ChildrenManager.isFunOpen(this.teamLeaderRoleId))
/*     */     {
/*  45 */       return false;
/*     */     }
/*     */     
/*  48 */     if (!ChildrenManager.canDoAction(this.teamLeaderRoleId, 843))
/*     */     {
/*  50 */       return false;
/*     */     }
/*     */     
/*  53 */     HomeInfoWrapper homeInfoWrapper = HomelandInterface.getHomeInfoWrapper(this.teamLeaderRoleId, false);
/*  54 */     if (homeInfoWrapper == null)
/*     */     {
/*  56 */       onSelectPregnantBelongFail(10);
/*  57 */       return false;
/*     */     }
/*     */     
/*  60 */     int pregnantNpcId = HomelandInterface.getMaidNpc(homeInfoWrapper);
/*     */     
/*  62 */     if (!mzm.gsp.npc.main.NpcInterface.checkNpcService(this.teamLeaderRoleId, SChildrenConsts.getInstance().pregnant_npc_service_id, pregnantNpcId, new HomeServiceChecker(this.teamLeaderRoleId, homeInfoWrapper.getxHomeInfo().getCurrentmaiduuid())))
/*     */     {
/*     */ 
/*     */ 
/*  66 */       onSelectPregnantBelongFail(11);
/*  67 */       return false;
/*     */     }
/*     */     
/*  70 */     this.marriedRoleId = MarriageInterface.getMarriedRoleid(this.teamLeaderRoleId);
/*     */     
/*  72 */     if (this.marriedRoleId < 0L)
/*     */     {
/*  74 */       onSelectPregnantBelongFail(12);
/*  75 */       return false;
/*     */     }
/*     */     
/*  78 */     if (!ChildrenManager.isChildrenFunLevelOpen(this.marriedRoleId))
/*     */     {
/*  80 */       onSelectPregnantBelongFail(21);
/*  81 */       return false;
/*     */     }
/*     */     
/*  84 */     Long teamId = TeamInterface.getTeamidByRoleid(this.teamLeaderRoleId, false);
/*  85 */     if (teamId == null)
/*     */     {
/*  87 */       onSelectPregnantBelongFail(13);
/*  88 */       return false;
/*     */     }
/*     */     
/*  91 */     List<Long> selectMembers = TeamInterface.getTeamMemberList(teamId.longValue(), false);
/*  92 */     if (selectMembers.size() != 2)
/*     */     {
/*  94 */       onSelectPregnantBelongFail(14);
/*  95 */       return false;
/*     */     }
/*     */     
/*  98 */     if (this.teamLeaderRoleId != ((Long)selectMembers.get(0)).longValue())
/*     */     {
/* 100 */       onSelectPregnantBelongFail(15);
/* 101 */       return false;
/*     */     }
/*     */     
/* 104 */     if (this.marriedRoleId != ((Long)selectMembers.get(1)).longValue())
/*     */     {
/* 106 */       onSelectPregnantBelongFail(16);
/* 107 */       return false;
/*     */     }
/*     */     
/* 110 */     String teamLeaderUserId = RoleInterface.getUserId(this.teamLeaderRoleId);
/* 111 */     String marriedUserId = RoleInterface.getUserId(this.marriedRoleId);
/* 112 */     lock(User.getTable(), Arrays.asList(new String[] { teamLeaderUserId, marriedUserId }));
/* 113 */     lock(xtable.Role2properties.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.teamLeaderRoleId), Long.valueOf(this.marriedRoleId) }));
/*     */     
/* 115 */     if (this.marriedRoleId != MarriageInterface.getMarriedRoleid(this.teamLeaderRoleId, true))
/*     */     {
/* 117 */       onSelectPregnantBelongFail(18);
/* 118 */       return false;
/*     */     }
/*     */     
/* 121 */     if (!HomelandInterface.isAtHome(this.teamLeaderRoleId, true))
/*     */     {
/* 123 */       onSelectPregnantBelongFail(18);
/* 124 */       return false;
/*     */     }
/*     */     
/* 127 */     if (!HomelandInterface.isAtHome(this.marriedRoleId, true))
/*     */     {
/* 129 */       onSelectPregnantBelongFail(19);
/* 130 */       return false;
/*     */     }
/*     */     
/* 133 */     if (!HomelandInterface.hasBed(this.teamLeaderRoleId))
/*     */     {
/* 135 */       onSelectPregnantBelongFail(20);
/* 136 */       return false;
/*     */     }
/*     */     
/* 139 */     if ((this.belongRoleId != this.marriedRoleId) && (this.belongRoleId != this.teamLeaderRoleId))
/*     */     {
/* 141 */       onSelectPregnantBelongFail(17);
/* 142 */       return false;
/*     */     }
/*     */     
/* 145 */     Role2ChildrenInfo xBelongChildrenInfo = Role2children.get(Long.valueOf(this.belongRoleId));
/* 146 */     if (xBelongChildrenInfo != null)
/*     */     {
/* 148 */       int ownChildSize = xBelongChildrenInfo.getChild_id_list().size() - xBelongChildrenInfo.getTotal_discard_child_num();
/*     */       
/* 150 */       if (ownChildSize >= SChildrenConsts.getInstance().max_children_can_carrey)
/*     */       {
/* 152 */         onSelectPregnantBelongFail(27);
/* 153 */         return false;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 158 */     int teamLeaderVigor = RoleInterface.getVigor(this.teamLeaderRoleId);
/* 159 */     int teamMemberVigor = RoleInterface.getVigor(this.marriedRoleId);
/* 160 */     if (teamLeaderVigor < SChildrenConsts.getInstance().pregnant_cut_vigor_score)
/*     */     {
/* 162 */       SPregnantCutVigorFail sPregnantCutVigorFail = new SPregnantCutVigorFail();
/* 163 */       sPregnantCutVigorFail.role_id = this.teamLeaderRoleId;
/* 164 */       OnlineManager.getInstance().sendMultiAtOnce(sPregnantCutVigorFail, selectMembers);
/* 165 */       return false;
/*     */     }
/*     */     
/* 168 */     if (teamMemberVigor < SChildrenConsts.getInstance().pregnant_cut_vigor_score)
/*     */     {
/* 170 */       SPregnantCutVigorFail sPregnantCutVigorFail = new SPregnantCutVigorFail();
/* 171 */       sPregnantCutVigorFail.role_id = this.marriedRoleId;
/* 172 */       OnlineManager.getInstance().sendMultiAtOnce(sPregnantCutVigorFail, selectMembers);
/* 173 */       return false;
/*     */     }
/*     */     
/* 176 */     long sessionId = new SelectPregnantBelongSession(SChildrenConsts.getInstance().select_pregnant_wait_seconds, this.teamLeaderRoleId, this.marriedRoleId, this.belongRoleId).getSessionId();
/*     */     
/*     */ 
/* 179 */     SSelectPregnantBelong sSelectPregnantBelong = new SSelectPregnantBelong();
/* 180 */     sSelectPregnantBelong.belong_role_id = this.belongRoleId;
/* 181 */     sSelectPregnantBelong.session_id = sessionId;
/*     */     
/* 183 */     OnlineManager.getInstance().sendMulti(sSelectPregnantBelong, Arrays.asList(new Long[] { Long.valueOf(this.teamLeaderRoleId), Long.valueOf(this.marriedRoleId) }));
/*     */     
/* 185 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   private void onSelectPregnantBelongFail(int ret)
/*     */   {
/* 191 */     StringBuilder sbLog = new StringBuilder();
/* 192 */     sbLog.append("[children]PCSelectPregnantBelong.processImp@select pregnant belong failed");
/* 193 */     sbLog.append("|ret=").append(ret);
/* 194 */     sbLog.append("|team_leader_role_id=").append(this.teamLeaderRoleId);
/* 195 */     sbLog.append("|marriage_role_id=").append(this.marriedRoleId);
/* 196 */     sbLog.append("|belong_role_id=").append(this.belongRoleId);
/*     */     
/* 198 */     GameServer.logger().error(sbLog.toString());
/*     */     
/* 200 */     SChildNormalFail sChildNormalFail = new SChildNormalFail();
/* 201 */     sChildNormalFail.result = ret;
/* 202 */     OnlineManager.getInstance().sendAtOnce(this.teamLeaderRoleId, sChildNormalFail);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\main\PCSelectPregnantBelong.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */