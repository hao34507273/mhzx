/*     */ package mzm.gsp.menpaistar.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.fight.main.FightInterface;
/*     */ import mzm.gsp.fight.main.FightParam;
/*     */ import mzm.gsp.fight.main.FightReason;
/*     */ import mzm.gsp.map.main.CloneRoleNpcModelType;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.menpaistar.SStartCampaignFightFailed;
/*     */ import mzm.gsp.menpaistar.confbean.SMenPaiStarConst;
/*     */ import mzm.gsp.menpaistar.confbean.SMenPaiStarNpcCfg;
/*     */ import mzm.gsp.npc.main.NpcInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.pubdata.ModelInfo;
/*     */ import mzm.gsp.role.main.Role;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.server.main.ServerInterface;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Campaign;
/*     */ import xbean.MenPaiStarCampaignInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCStartCampaignFight extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   
/*     */   public PCStartCampaignFight(long roleid)
/*     */   {
/*  39 */     this.roleid = roleid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  45 */     if (!MenPaiStarManager.canDoAction(this.roleid, 1003))
/*     */     {
/*  47 */       return false;
/*     */     }
/*     */     
/*  50 */     if (!MenPaiStarManager.isFunOpen(this.roleid))
/*     */     {
/*  52 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  56 */     long endTime = MenPaiStarConfigManager.campaignFightEndTime();
/*  57 */     long now = DateTimeUtils.getCurrTimeInMillis();
/*  58 */     if (now >= endTime)
/*     */     {
/*     */ 
/*  61 */       Map<String, Object> extras = new HashMap();
/*  62 */       extras.put("end_time", Long.valueOf(endTime));
/*  63 */       onFailed(13, extras);
/*  64 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  68 */     int ocpid = RoleInterface.getOccupationId(this.roleid);
/*  69 */     if (!CampaignChartManager.canJoin(ocpid))
/*     */     {
/*  71 */       Map<String, Object> extras = new HashMap();
/*  72 */       extras.put("occupationid", Integer.valueOf(ocpid));
/*  73 */       onFailed(-7, extras);
/*  74 */       return false;
/*     */     }
/*     */     
/*  77 */     String userid = RoleInterface.getUserId(this.roleid);
/*  78 */     if (userid == null)
/*     */     {
/*  80 */       onFailed(2);
/*  81 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  85 */     if (TeamInterface.isRoleInTeam(this.roleid, false))
/*     */     {
/*  87 */       onFailed(-5);
/*  88 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  92 */     lock(Lockeys.get(User.getTable(), userid));
/*  93 */     Role role = RoleInterface.getRole(this.roleid, true);
/*  94 */     int level = role.getLevel();
/*  95 */     if (level < SMenPaiStarConst.getInstance().CAMPAIGN_MIN_LEVEL)
/*     */     {
/*  97 */       Map<String, Object> extras = new HashMap();
/*  98 */       extras.put("level", Integer.valueOf(level));
/*  99 */       onFailed(-1, extras);
/* 100 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 104 */     int serverLevel = ServerInterface.getCurrentServerLevel();
/* 105 */     if (level < serverLevel - SMenPaiStarConst.getInstance().CAMPAIGN_NOT_LESS_SERVER_LEVEL)
/*     */     {
/* 107 */       Map<String, Object> extras = new HashMap();
/* 108 */       extras.put("level", Integer.valueOf(level));
/* 109 */       extras.put("server_level", Integer.valueOf(serverLevel));
/* 110 */       onFailed(-2, extras);
/* 111 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 115 */     SMenPaiStarNpcCfg menPaiStarNpcCfg = SMenPaiStarNpcCfg.get(ocpid);
/* 116 */     if (menPaiStarNpcCfg == null)
/*     */     {
/* 118 */       Map<String, Object> extras = new HashMap();
/* 119 */       extras.put("occupationid", Integer.valueOf(ocpid));
/* 120 */       onFailed(3, extras);
/* 121 */       return false;
/*     */     }
/* 123 */     if (!NpcInterface.checkNpcService(menPaiStarNpcCfg.npcCfgid, menPaiStarNpcCfg.campaignBattleServiceCfgid, this.roleid))
/*     */     {
/* 125 */       onFailed(5);
/* 126 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 130 */     int activityCfgid = SMenPaiStarConst.getInstance().ACTIVITY_CFG_ID;
/* 131 */     ActivityJoinResult joinResult = ActivityInterface.canJoinAndCheckInitActivityData(userid, this.roleid, activityCfgid);
/*     */     
/* 133 */     if (!joinResult.isCanJoin())
/*     */     {
/* 135 */       Map<String, Object> extras = new HashMap();
/* 136 */       extras.put("activity_cfgid", Integer.valueOf(activityCfgid));
/* 137 */       extras.put("reason", Integer.valueOf(joinResult.getReasonValue()));
/* 138 */       onFailed(-6, extras);
/* 139 */       return false;
/*     */     }
/*     */     
/* 142 */     MenPaiStarCampaignInfo xCampaignInfo = MenPaiStarManager.getAndInitXCampaignInfo(this.roleid);
/* 143 */     Campaign xCampaign = (Campaign)xCampaignInfo.getCampaigns().get(Integer.valueOf(ocpid));
/* 144 */     if ((xCampaign != null) && (xCampaign.getCampaign() == 1))
/*     */     {
/* 146 */       onFailed(6);
/* 147 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 151 */     long lastCamaignFightTime = xCampaignInfo.getLast_campaign_time();
/* 152 */     if (DateTimeUtils.needDailyReset(lastCamaignFightTime, now, 0, 0))
/*     */     {
/* 154 */       xCampaignInfo.setToday_campaign_num(0);
/*     */     }
/* 156 */     if (xCampaignInfo.getToday_campaign_num() >= SMenPaiStarConst.getInstance().DAILY_CAMPAIGN_BATTLE_NUM)
/*     */     {
/* 158 */       onFailed(-3);
/* 159 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 163 */     xCampaignInfo.setLast_campaign_time(now);
/*     */     
/* 165 */     int npcCfgid = MenPaiStarConfigManager.getNpc(ocpid);
/* 166 */     ModelInfo modelInfo = MapInterface.getCloneRoleNpcPubModelInfo(CloneRoleNpcModelType.MEN_PAI_STAR, npcCfgid, true);
/* 167 */     long opponentRoleid = CampaignChartManager.getLastChampion(ocpid);
/* 168 */     if ((modelInfo == null) || (opponentRoleid <= 0L))
/*     */     {
/* 170 */       PVEFightContext fightContex = new PVEFightContext();
/* 171 */       fightContex.setRoleid(this.roleid);
/* 172 */       fightContex.setFightReson(FightReason.MENPAI_STAR_CAMPAIGN_PVE_FIGHT);
/* 173 */       FightInterface.startPVEFight(this.roleid, menPaiStarNpcCfg.campaignFightPveid, fightContex, FightReason.MENPAI_STAR_CAMPAIGN_PVE_FIGHT);
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/* 178 */       CampaignFightContext fightContex = new CampaignFightContext();
/* 179 */       fightContex.setRoleid(this.roleid);
/* 180 */       fightContex.setOpponentRoleid(opponentRoleid);
/* 181 */       fightContex.setFightReson(FightReason.MENPAI_STAR_CAMPAIGN_ROLE_FIGHT);
/*     */       
/* 183 */       FightParam fightParam = new FightParam();
/* 184 */       fightParam.addPVERoleRowModelInfo(opponentRoleid, modelInfo);
/* 185 */       FightInterface.startPVEFight(this.roleid, menPaiStarNpcCfg.campaignFightPvcid, fightContex, 1, FightReason.MENPAI_STAR_CAMPAIGN_ROLE_FIGHT, fightParam);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 190 */     addTlog(userid, ocpid, opponentRoleid, xCampaignInfo.getToday_campaign_num());
/*     */     
/* 192 */     GameServer.logger().info(String.format("[menpaistar]PCStartCampaignFight.processImp@start campaign fight|roleid=%d|opponent_roleid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(opponentRoleid) }));
/*     */     
/*     */ 
/* 195 */     return true;
/*     */   }
/*     */   
/*     */   private void addTlog(String userid, int ocpid, long opponentRoleid, int todayCampaignFightNum)
/*     */   {
/* 200 */     String vGameIp = GameServerInfoManager.getHostIP();
/* 201 */     int roleLevel = RoleInterface.getLevel(this.roleid);
/*     */     
/* 203 */     TLogManager.getInstance().addLog(userid, "MenPaiStarStartCampaignFightForServer", new Object[] { vGameIp, userid, Long.valueOf(this.roleid), Integer.valueOf(roleLevel), Integer.valueOf(ocpid), Long.valueOf(opponentRoleid), Integer.valueOf(todayCampaignFightNum) });
/*     */   }
/*     */   
/*     */ 
/*     */   private void onFailed(int retcode)
/*     */   {
/* 209 */     onFailed(retcode, null);
/*     */   }
/*     */   
/*     */   private void onFailed(int retcode, Map<String, Object> extraParams)
/*     */   {
/* 214 */     SStartCampaignFightFailed resp = new SStartCampaignFightFailed();
/* 215 */     resp.retcode = retcode;
/* 216 */     OnlineManager.getInstance().sendAtOnce(this.roleid, resp);
/*     */     
/* 218 */     StringBuffer logBuilder = new StringBuffer();
/* 219 */     logBuilder.append("[menpaistar]PCStartCampaignFight.onFailed@start campaign fight failed");
/* 220 */     logBuilder.append('|').append("roleid=").append(this.roleid);
/* 221 */     logBuilder.append('|').append("retcode=").append(retcode);
/*     */     
/* 223 */     if (extraParams != null)
/*     */     {
/* 225 */       for (Map.Entry<String, Object> entry : extraParams.entrySet())
/*     */       {
/* 227 */         logBuilder.append('|').append((String)entry.getKey()).append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/*     */     
/* 231 */     GameServer.logger().error(logBuilder.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\menpaistar\main\PCStartCampaignFight.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */