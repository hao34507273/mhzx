/*     */ package mzm.gsp.menpaistar.main;
/*     */ 
/*     */ import java.text.SimpleDateFormat;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.badge.main.BadgeInterface;
/*     */ import mzm.gsp.mail.main.MailInterface;
/*     */ import mzm.gsp.map.main.CloneRoleNpcModelType;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.menpaistar.SBrocastMenPaiStar;
/*     */ import mzm.gsp.menpaistar.confbean.SMenPaiStarAwardCfg;
/*     */ import mzm.gsp.menpaistar.confbean.SMenPaiStarConst;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.title.main.TitleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.MenPaiStarInfo;
/*     */ 
/*     */ public class PSetChampion extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final int ocpid;
/*     */   
/*     */   public PSetChampion(int ocpid)
/*     */   {
/*  30 */     this.ocpid = ocpid;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  37 */     long roleid = 0L;
/*  38 */     CampaignChartObj chartObj = CampaignChartManager.getChampionChartObj(this.ocpid);
/*  39 */     if (chartObj != null)
/*     */     {
/*  41 */       roleid = chartObj.getRoleid();
/*     */     }
/*     */     
/*  44 */     int activityid = SMenPaiStarConst.getInstance().ACTIVITY_CFG_ID;
/*  45 */     long activityStartTime = ActivityInterface.getActivityStartTime(activityid);
/*  46 */     long now = DateTimeUtils.getCurrTimeInMillis();
/*     */     
/*     */ 
/*  49 */     MenPaiStarInfo xMenPaiStarInfo = MenPaiStarManager.getAndInitXMenPaiStarInfo(this.ocpid);
/*  50 */     xMenPaiStarInfo.setFinished(true);
/*  51 */     xMenPaiStarInfo.setEnd_time(now);
/*  52 */     xMenPaiStarInfo.setChampion(roleid);
/*     */     
/*     */ 
/*  55 */     long startTime = xMenPaiStarInfo.getStart_time();
/*  56 */     if (startTime < activityStartTime)
/*     */     {
/*  58 */       xMenPaiStarInfo.setFinished(false);
/*  59 */       xMenPaiStarInfo.setStart_time(activityStartTime);
/*     */       
/*     */ 
/*  62 */       CampaignChartManager.clear(this.ocpid);
/*     */       
/*  64 */       CampaignChartManager.canJoin(this.ocpid, true);
/*     */     }
/*     */     
/*  67 */     boolean funOpen = MenPaiStarManager.isFunOpen();
/*     */     
/*  69 */     if (roleid <= 0L)
/*     */     {
/*     */ 
/*  72 */       xMenPaiStarInfo.setChampion(0L);
/*     */       
/*  74 */       onFailed(funOpen);
/*     */       
/*     */ 
/*  77 */       tlog(roleid, 0, funOpen, false);
/*     */       
/*  79 */       GameServer.logger().error(String.format("[menpaistar]PSetChampion.processImp@set champion success|ocpid=%d|roleid=%d", new Object[] { Integer.valueOf(this.ocpid), Long.valueOf(roleid) }));
/*     */       
/*     */ 
/*  82 */       return true;
/*     */     }
/*     */     
/*     */ 
/*  86 */     boolean isBanPlay = MenPaiStarManager.isBanPlay(roleid);
/*  87 */     int point = chartObj.getPoint();
/*  88 */     boolean isAward = point >= SMenPaiStarConst.getInstance().CAMPAIGN_SUCCESS_MIN_POINT;
/*  89 */     if ((!isAward) || (!funOpen) || (isBanPlay))
/*     */     {
/*     */ 
/*  92 */       xMenPaiStarInfo.setChampion(0L);
/*     */       
/*  94 */       onFailed(funOpen);
/*     */       
/*     */ 
/*  97 */       tlog(roleid, point, funOpen, isBanPlay);
/*     */       
/*  99 */       GameServer.logger().error(String.format("[menpaistar]PSetChampion.processImp@set champion success|ocpid=%d|roleid=%d|point=%d|fun_open=%b|is_ban_play=%b", new Object[] { Integer.valueOf(this.ocpid), Long.valueOf(roleid), Integer.valueOf(point), Boolean.valueOf(funOpen), Boolean.valueOf(isBanPlay) }));
/*     */       
/*     */ 
/*     */ 
/* 103 */       return true;
/*     */     }
/*     */     
/*     */ 
/* 107 */     SMenPaiStarAwardCfg awardCfg = SMenPaiStarAwardCfg.get(this.ocpid);
/* 108 */     if (awardCfg == null)
/*     */     {
/* 110 */       GameServer.logger().error(String.format("[menpaistar]PSetChampion.processImp@award config not exist|ocpid=%d|roleid=%d", new Object[] { Integer.valueOf(this.ocpid), Long.valueOf(roleid) }));
/*     */       
/*     */ 
/* 113 */       return true;
/*     */     }
/*     */     
/*     */ 
/* 117 */     TLogArg tLogArg = new TLogArg(LogReason.MENPAI_STAR_CHAMPION_AWARD);
/* 118 */     MailInterface.synBuildAndSendMail(roleid, awardCfg.mailCfgid, null, null, tLogArg);
/*     */     
/*     */ 
/* 121 */     TitleInterface.addAppellation(roleid, awardCfg.appellation, true);
/*     */     
/*     */ 
/* 124 */     BadgeInterface.addBadge(roleid, SMenPaiStarConst.getInstance().STAR_BADGE);
/*     */     
/*     */ 
/* 127 */     TitleInterface.addTitle(roleid, SMenPaiStarConst.getInstance().STAR_TITLE);
/*     */     
/*     */ 
/* 130 */     tlog(roleid, point, funOpen, isBanPlay);
/*     */     
/*     */ 
/* 133 */     int npcCfgid = MenPaiStarConfigManager.getNpc(this.ocpid);
/* 134 */     if (npcCfgid > 0)
/*     */     {
/* 136 */       MapInterface.setCloneRoleNpcModelAsyc(CloneRoleNpcModelType.MEN_PAI_STAR, roleid, npcCfgid, awardCfg.appellation);
/*     */     }
/*     */     
/*     */ 
/* 140 */     String name = RoleInterface.getName(roleid);
/* 141 */     MenPaiStarChartObj starChartObj = new MenPaiStarChartObj(roleid, this.ocpid, chartObj.getPoint(), chartObj.getUpdatePointTime(), name);
/*     */     
/* 143 */     MenPaiStarChartManager.rank(starChartObj);
/*     */     
/*     */ 
/* 146 */     CampaignChartManager.setLastChampion(this.ocpid, roleid);
/*     */     
/*     */ 
/* 149 */     SBrocastMenPaiStar brocast = new SBrocastMenPaiStar();
/* 150 */     brocast.champion = MenPaiStarChartManager.trans(starChartObj);
/* 151 */     OnlineManager.getInstance().sendAll(brocast);
/*     */     
/* 153 */     GameServer.logger().info(String.format("[menpaistar]PSetChampion.processImp@set champion success|ocpid=%d|roleid=%d|point=%d", new Object[] { Integer.valueOf(this.ocpid), Long.valueOf(roleid), Integer.valueOf(point) }));
/*     */     
/*     */ 
/* 156 */     return true;
/*     */   }
/*     */   
/*     */   private void tlog(long roleid, int point, boolean funOpen, boolean isBanPlay)
/*     */   {
/* 161 */     String GameSvrId = String.valueOf(GameServerInfoManager.getZoneId());
/* 162 */     SimpleDateFormat sdf = DateTimeUtils.getSimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/* 163 */     long time = DateTimeUtils.getCurrTimeInMillis();
/* 164 */     String dtEventTime = sdf.format(Long.valueOf(time));
/*     */     
/* 166 */     String vGameAppid = "0";
/* 167 */     int PlatID = -1;
/* 168 */     int iZoneAreaID = GameServerInfoManager.getZoneId();
/* 169 */     String vopenid = "0";
/*     */     
/* 171 */     StringBuffer sb = new StringBuffer();
/* 172 */     sb.append(GameSvrId).append('|');
/* 173 */     sb.append(dtEventTime).append('|');
/* 174 */     sb.append("0").append('|');
/* 175 */     sb.append(-1).append('|');
/* 176 */     sb.append(iZoneAreaID).append('|');
/* 177 */     sb.append("0").append('|');
/*     */     
/* 179 */     sb.append(this.ocpid).append('|');
/* 180 */     sb.append(roleid).append('|');
/* 181 */     sb.append(point).append('|');
/* 182 */     sb.append(funOpen ? 1 : 0).append('|');
/* 183 */     sb.append(isBanPlay ? 1 : 0);
/*     */     
/* 185 */     TLogManager.getInstance().addLog("MenPaiStarSetChampionForServer", sb.toString());
/*     */   }
/*     */   
/*     */   private void onFailed(boolean funOpen)
/*     */   {
/* 190 */     int npcCfgid = MenPaiStarConfigManager.getNpc(this.ocpid);
/*     */     
/* 192 */     if (npcCfgid > 0)
/*     */     {
/* 194 */       MapInterface.unsetCloneRoleNpcModelAsync(CloneRoleNpcModelType.MEN_PAI_STAR, npcCfgid);
/*     */     }
/*     */     
/*     */ 
/* 198 */     MenPaiStarChartObj starChartObj = new MenPaiStarChartObj(-1L, this.ocpid, 0, 0L, "");
/* 199 */     MenPaiStarChartManager.rank(starChartObj);
/*     */     
/*     */ 
/* 202 */     CampaignChartManager.setLastChampion(this.ocpid, 0L);
/*     */     
/* 204 */     if (funOpen)
/*     */     {
/*     */ 
/* 207 */       SBrocastMenPaiStar brocast = new SBrocastMenPaiStar();
/* 208 */       brocast.champion = MenPaiStarChartManager.trans(starChartObj);
/* 209 */       OnlineManager.getInstance().sendAll(brocast);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\menpaistar\main\PSetChampion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */