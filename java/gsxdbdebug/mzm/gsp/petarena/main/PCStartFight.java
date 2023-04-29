/*     */ package mzm.gsp.petarena.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.fight.main.FightInterface;
/*     */ import mzm.gsp.fight.main.FightInterface.PetFightInfo;
/*     */ import mzm.gsp.fight.main.FightInterface.PetFightRobotInfo;
/*     */ import mzm.gsp.fight.main.FightReason;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.pet.PetInfo;
/*     */ import mzm.gsp.pet.main.PetFightInterface;
/*     */ import mzm.gsp.pet.main.PetFightTeam;
/*     */ import mzm.gsp.pet.main.PetFightTeam.Position;
/*     */ import mzm.gsp.petarena.SStartFightFailed;
/*     */ import mzm.gsp.petarena.confbean.SPetArenaConst;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.PetArenaInfo;
/*     */ import xbean.PetArenaRankInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCStartFight extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final long targetRoleid;
/*     */   private final int rank;
/*     */   private final int teamid;
/*     */   private final int serial;
/*     */   
/*     */   public PCStartFight(long roleid, long targetRoleid, int rank, int teamid, int serial)
/*     */   {
/*  39 */     this.roleid = roleid;
/*  40 */     this.targetRoleid = targetRoleid;
/*  41 */     this.rank = rank;
/*  42 */     this.teamid = teamid;
/*  43 */     this.serial = serial;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  49 */     if ((this.targetRoleid < 0L) || (this.rank <= 0))
/*     */     {
/*  51 */       return false;
/*     */     }
/*     */     
/*  54 */     if (!PetArenaManager.canDoAction(this.roleid, 2115))
/*     */     {
/*  56 */       return false;
/*     */     }
/*     */     
/*  59 */     if (!PetArenaManager.isFunOpen(this.roleid))
/*     */     {
/*  61 */       return false;
/*     */     }
/*     */     
/*  64 */     int level = RoleInterface.getLevel(this.roleid);
/*  65 */     if (level < SPetArenaConst.getInstance().OPEN_LEVEL)
/*     */     {
/*  67 */       onFailed(-1);
/*  68 */       return false;
/*     */     }
/*     */     
/*  71 */     if ((TeamInterface.isTeamMemberNormal(this.roleid)) && (TeamInterface.getNormalRoleList(this.roleid).size() > 1))
/*     */     {
/*  73 */       onFailed(-6);
/*  74 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  78 */     String userid = RoleInterface.getUserId(this.roleid);
/*  79 */     lock(Lockeys.get(User.getTable(), userid));
/*  80 */     if (this.targetRoleid > 0L)
/*     */     {
/*  82 */       lock(Lockeys.get(Basic.getTable(), new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.targetRoleid) }));
/*     */     }
/*     */     else
/*     */     {
/*  86 */       lock(Lockeys.get(Basic.getTable(), Long.valueOf(this.roleid)));
/*     */     }
/*     */     
/*     */ 
/*  90 */     int activityCfgid = SPetArenaConst.getInstance().ACTIVITY_CFG_ID;
/*  91 */     ActivityJoinResult joinResult = mzm.gsp.activity.main.ActivityInterface.canJoinAndCheckInitActivityData(userid, this.roleid, activityCfgid);
/*     */     
/*  93 */     if ((!joinResult.isCanJoin()) && (!joinResult.isSingleRoleTeam()))
/*     */     {
/*  95 */       onFailed(-2);
/*  96 */       return false;
/*     */     }
/*     */     
/*  99 */     PetArenaInfo xPetArenaInfo = xtable.Role2petarenainfo.get(Long.valueOf(this.roleid));
/* 100 */     if (xPetArenaInfo == null)
/*     */     {
/* 102 */       onFailed(1);
/* 103 */       return false;
/*     */     }
/* 105 */     PetArenaManager.checkData(xPetArenaInfo);
/*     */     
/*     */ 
/* 108 */     PetFightTeam defenseFightTeam = PetFightInterface.getPetFightDefenseTeam(this.roleid, true);
/* 109 */     if (defenseFightTeam == null)
/*     */     {
/* 111 */       onFailed(7);
/* 112 */       return false;
/*     */     }
/* 114 */     if (defenseFightTeam.positions.isEmpty())
/*     */     {
/* 116 */       onFailed(7);
/* 117 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 121 */     int freeCount = SPetArenaConst.getInstance().FREE_CHALLENGE_COUNT;
/* 122 */     int buyCount = xPetArenaInfo.getBuy_count();
/* 123 */     int challengeCount = xPetArenaInfo.getChallenge_count();
/* 124 */     if (freeCount + buyCount - challengeCount <= 0)
/*     */     {
/* 126 */       Map<String, Object> extras = new HashMap();
/* 127 */       extras.put("challenge_count", Integer.valueOf(challengeCount));
/* 128 */       extras.put("buy_count", Integer.valueOf(buyCount));
/*     */       
/* 130 */       onFailed(-3, extras);
/* 131 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 135 */     if (this.serial != xPetArenaInfo.getOpponent_serial())
/*     */     {
/* 137 */       PetArenaManager.sendPetAreanInfoMsg(this.roleid, xPetArenaInfo);
/* 138 */       onFailed(-7);
/* 139 */       return true;
/*     */     }
/*     */     
/* 142 */     PetArenaRankInfo xTargetPetArenaRankInfo = null;
/* 143 */     for (PetArenaRankInfo xPetArenaRankInfo : xPetArenaInfo.getOpponent_ranks())
/*     */     {
/* 145 */       if ((xPetArenaRankInfo.getRank() == this.rank) && (xPetArenaRankInfo.getRoleid() == this.targetRoleid))
/*     */       {
/* 147 */         xTargetPetArenaRankInfo = xPetArenaRankInfo;
/*     */       }
/*     */     }
/* 150 */     if (xTargetPetArenaRankInfo == null)
/*     */     {
/* 152 */       onFailed(6);
/* 153 */       return false;
/*     */     }
/*     */     
/* 156 */     if (PetArenaRankManager.getInstance().checkRankChanged(this.rank, this.targetRoleid))
/*     */     {
/* 158 */       PetArenaManager.sendPetAreanInfoMsg(this.roleid, xPetArenaInfo);
/* 159 */       onFailed(-8);
/* 160 */       return true;
/*     */     }
/*     */     
/*     */ 
/* 164 */     xPetArenaInfo.setChallenge_count(challengeCount + 1);
/*     */     
/* 166 */     PetFightTeam attackFightTeam = PetFightInterface.getPetFightTeam(this.roleid, this.teamid, true);
/* 167 */     if (attackFightTeam == null)
/*     */     {
/* 169 */       onFailed(-4);
/* 170 */       return false;
/*     */     }
/* 172 */     if (attackFightTeam.positions.isEmpty())
/*     */     {
/* 174 */       onFailed(-4);
/* 175 */       return false;
/*     */     }
/*     */     
/* 178 */     int myRank = PetArenaRankManager.getInstance().getRank(this.roleid);
/* 179 */     RankInfo activeRankInfo = new RankInfo(myRank, this.roleid);
/* 180 */     RankInfo opponentRankInfo = new RankInfo(this.rank, this.targetRoleid);
/* 181 */     PetCVCFightContext context = new PetCVCFightContext(activeRankInfo, opponentRankInfo);
/* 182 */     fillPetArenaFightInfo(this.roleid, attackFightTeam, context.activeInfos);
/*     */     
/* 184 */     FightInterface.PetFightInfo activePetFightInfo = new FightInterface.PetFightInfo();
/* 185 */     activePetFightInfo.roleId = this.roleid;
/* 186 */     activePetFightInfo.zhenfaInfo = attackFightTeam;
/*     */     
/* 188 */     if (this.targetRoleid > 0L)
/*     */     {
/* 190 */       PetFightTeam petFightTeam = PetFightInterface.getPetFightDefenseTeam(this.targetRoleid, true);
/* 191 */       if (petFightTeam == null)
/*     */       {
/* 193 */         onFailed(-5);
/* 194 */         return false;
/*     */       }
/* 196 */       fillPetArenaFightInfo(this.targetRoleid, petFightTeam, context.passiveInfos);
/*     */       
/* 198 */       FightInterface.PetFightInfo passivePetFightInfo = new FightInterface.PetFightInfo();
/* 199 */       passivePetFightInfo.roleId = this.targetRoleid;
/* 200 */       passivePetFightInfo.zhenfaInfo = petFightTeam;
/*     */       
/* 202 */       FightInterface.startPetCVCFight(activePetFightInfo, passivePetFightInfo, context, 28, FightReason.PET_ARENA_CVC);
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/* 207 */       RobotPetTeamInfo robotPetTeamInfo = PetArenaTeamManager.getInstance().getPetTeamInfo(this.rank);
/* 208 */       if (robotPetTeamInfo == null)
/*     */       {
/* 210 */         PetArenaTeamManager.asyncStartFight(this.roleid, activePetFightInfo, context, this.rank);
/* 211 */         GameServer.logger().info(String.format("[petarena]PCStartFight.processImp@async start fight|roleid=%d|my_rank=%d|target_roleid=%d|rank=%d|teamid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(myRank), Long.valueOf(this.targetRoleid), Integer.valueOf(this.rank), Integer.valueOf(this.teamid) }));
/*     */         
/*     */ 
/*     */ 
/* 215 */         return true;
/*     */       }
/* 217 */       FightInterface.PetFightRobotInfo robotFightInfo = new FightInterface.PetFightRobotInfo();
/* 218 */       robotPetTeamInfo.fillPetFightRobotInfo(robotFightInfo);
/* 219 */       robotPetTeamInfo.fillPetAreanFightInfos(context.passiveInfos);
/*     */       
/* 221 */       FightInterface.startPetCVCRobotFight(activePetFightInfo, robotFightInfo, context, 28, FightReason.PET_ARENA_CVC);
/*     */     }
/*     */     
/*     */ 
/* 225 */     GameServer.logger().info(String.format("[petarena]PCStartFight.processImp@start fight success|roleid=%d|my_rank=%d|target_roleid=%d|rank=%d|teamid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(myRank), Long.valueOf(this.targetRoleid), Integer.valueOf(this.rank), Integer.valueOf(this.teamid) }));
/*     */     
/*     */ 
/*     */ 
/* 229 */     return true;
/*     */   }
/*     */   
/*     */   private void onFailed(int retcode)
/*     */   {
/* 234 */     onFailed(retcode, null);
/*     */   }
/*     */   
/*     */   private void onFailed(int retcode, Map<String, Object> extraParams)
/*     */   {
/* 239 */     SStartFightFailed rsp = new SStartFightFailed();
/* 240 */     rsp.retcode = retcode;
/* 241 */     rsp.rank = this.rank;
/* 242 */     rsp.target_roleid = this.targetRoleid;
/* 243 */     rsp.teamid = this.teamid;
/* 244 */     OnlineManager.getInstance().sendAtOnce(this.roleid, rsp);
/*     */     
/* 246 */     StringBuilder logBuilder = new StringBuilder();
/* 247 */     logBuilder.append("[petarena]PCStartFight.onFailed@failed");
/* 248 */     logBuilder.append('|').append("roleid=").append(this.roleid);
/* 249 */     logBuilder.append('|').append("target_roleid=").append(this.targetRoleid);
/* 250 */     logBuilder.append('|').append("rank=").append(this.rank);
/* 251 */     logBuilder.append('|').append("teamid=").append(this.teamid);
/* 252 */     logBuilder.append('|').append("retcode=").append(retcode);
/*     */     
/* 254 */     if (extraParams != null)
/*     */     {
/* 256 */       for (Map.Entry<String, Object> entry : extraParams.entrySet())
/*     */       {
/* 258 */         logBuilder.append('|').append((String)entry.getKey()).append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/*     */     
/* 262 */     GameServer.logger().error(logBuilder.toString());
/*     */   }
/*     */   
/*     */   private void fillPetArenaFightInfo(long roleid, PetFightTeam petFightTeam, List<PetArenaFightInfo> infos)
/*     */   {
/* 267 */     for (PetFightTeam.Position position : petFightTeam.positions.values())
/*     */     {
/* 269 */       long petid = position.petId;
/* 270 */       PetInfo petInfo = mzm.gsp.pet.main.PetInterface.getPetInfo(roleid, petid);
/* 271 */       PetArenaFightInfo petArenaFightInfo = new PetArenaFightInfo(petid, position.positionNumber, petInfo.typeid, 0, petInfo.petname);
/*     */       
/* 273 */       infos.add(petArenaFightInfo);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petarena\main\PCStartFight.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */