/*     */ package mzm.gsp.children.fetuseducationmusic;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.children.SAttendFetusEducationMusicFail;
/*     */ import mzm.gsp.children.confbean.FetusEducationMusicConsts;
/*     */ import mzm.gsp.children.confbean.SChildrenConsts;
/*     */ import mzm.gsp.children.main.ChildrenInterface;
/*     */ import mzm.gsp.homeland.main.HomeInfoWrapper;
/*     */ import mzm.gsp.homeland.main.HomeServiceChecker;
/*     */ import mzm.gsp.homeland.main.HomelandInterface;
/*     */ import mzm.gsp.marriage.main.MarriageInterface;
/*     */ import mzm.gsp.musicgame.event.MusicGameContext;
/*     */ import mzm.gsp.musicgame.main.MusicGameInterface;
/*     */ import mzm.gsp.npc.main.NpcInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.HomeInfo;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCAttendFetusEducationMusic extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   
/*     */   public PCAttendFetusEducationMusic(long roleid)
/*     */   {
/*  35 */     this.roleid = roleid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  41 */     if (!FetusEducationMusicManager.isFetusEducationMusicSwitchOpenForRole(this.roleid))
/*     */     {
/*     */ 
/*  44 */       onFail(-1, null);
/*  45 */       return false;
/*     */     }
/*  47 */     if (!FetusEducationMusicManager.checkRoleStatus(this.roleid, 591))
/*     */     {
/*     */ 
/*  50 */       onFail(-2, null);
/*  51 */       return false;
/*     */     }
/*     */     
/*  54 */     HomeInfoWrapper homeInfoWrapper = HomelandInterface.getHomeInfoWrapper(this.roleid, false);
/*  55 */     if (homeInfoWrapper == null)
/*     */     {
/*     */ 
/*  58 */       onFail(-3, null);
/*  59 */       return false;
/*     */     }
/*  61 */     if (!NpcInterface.checkNpcService(this.roleid, SChildrenConsts.getInstance().pregnant_npc_service_id, HomelandInterface.getMaidNpc(homeInfoWrapper), new HomeServiceChecker(this.roleid, homeInfoWrapper.getxHomeInfo().getCurrentmaiduuid())))
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*  66 */       onFail(-3, null);
/*  67 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  71 */     if (!HomelandInterface.hasHome(this.roleid))
/*     */     {
/*     */ 
/*  74 */       onFail(1, null);
/*  75 */       return false;
/*     */     }
/*     */     
/*  78 */     if (!MarriageInterface.isMarried(this.roleid))
/*     */     {
/*     */ 
/*  81 */       onFail(2, null);
/*  82 */       return false;
/*     */     }
/*     */     
/*  85 */     long marriageid = MarriageInterface.getMarriedId(this.roleid, false);
/*     */     
/*  87 */     long partnerid = MarriageInterface.getMarriedRoleid(this.roleid, false);
/*     */     
/*  89 */     String userid = RoleInterface.getUserId(this.roleid);
/*  90 */     String partnerUserid = RoleInterface.getUserId(partnerid);
/*     */     
/*  92 */     lock(User.getTable(), Arrays.asList(new String[] { userid, partnerUserid }));
/*     */     
/*  94 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid), Long.valueOf(partnerid) }));
/*     */     
/*     */ 
/*  97 */     int currentPoint = ChildrenInterface.isCanCoupleFetusEduaction(this.roleid, partnerid, true);
/*  98 */     if (currentPoint < 0)
/*     */     {
/*     */ 
/* 101 */       onFail(3, null);
/* 102 */       return false;
/*     */     }
/* 104 */     if (currentPoint >= MusicGameInterface.getMusicGamePointUpperLimit(FetusEducationMusicConsts.getInstance().MUSIC_GAME_ID))
/*     */     {
/*     */ 
/* 107 */       onFail(4, null);
/* 108 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 112 */     ActivityJoinResult activityJoinResult = ActivityInterface.canJoinAndCheckInitActivityData(userid, this.roleid, FetusEducationMusicConsts.getInstance().ACTIVITY_CFG_ID);
/*     */     
/* 114 */     if (!activityJoinResult.isCanJoin())
/*     */     {
/*     */ 
/* 117 */       Map<String, Object> extraInfo = new HashMap();
/* 118 */       extraInfo.put("reason", Integer.valueOf(activityJoinResult.getReasonValue()));
/* 119 */       onFail(5, extraInfo);
/* 120 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 124 */     long now = DateTimeUtils.getCurrTimeInMillis();
/*     */     
/* 126 */     boolean isContextMatch = false;
/* 127 */     MusicGameContext context = MusicGameInterface.getRoleLastMusicGameContext(this.roleid, FetusEducationMusicConsts.getInstance().MUSIC_GAME_ID);
/*     */     
/* 129 */     if ((context != null) && ((context instanceof FetusEducationMusicGameContext)))
/*     */     {
/* 131 */       FetusEducationMusicGameContext fetusEducationMusicGameContext = (FetusEducationMusicGameContext)context;
/* 132 */       if ((fetusEducationMusicGameContext.partnerid == partnerid) && (fetusEducationMusicGameContext.marriageid == marriageid))
/*     */       {
/*     */ 
/* 135 */         isContextMatch = true;
/*     */       }
/*     */     }
/*     */     
/* 139 */     boolean isLastMusicGameStartInSameDay = false;
/* 140 */     long timestamp = MusicGameInterface.getRoleLastMusicGameStartTimestamp(this.roleid, FetusEducationMusicConsts.getInstance().MUSIC_GAME_ID);
/*     */     
/* 142 */     if ((timestamp > 0L) && (!DateTimeUtils.needDailyReset(timestamp, now, 0)))
/*     */     {
/* 144 */       isLastMusicGameStartInSameDay = true;
/*     */     }
/* 146 */     if ((isLastMusicGameStartInSameDay) && (!isContextMatch))
/*     */     {
/*     */ 
/* 149 */       onFail(6, null);
/* 150 */       return false;
/*     */     }
/* 152 */     if (isLastMusicGameStartInSameDay)
/*     */     {
/* 154 */       MusicGameInterface.startMusicGame(this.roleid, FetusEducationMusicConsts.getInstance().MUSIC_GAME_ID, false, currentPoint, new FetusEducationMusicGameContext(marriageid, partnerid));
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/* 159 */       MusicGameInterface.startMusicGame(this.roleid, FetusEducationMusicConsts.getInstance().MUSIC_GAME_ID, true, currentPoint, new FetusEducationMusicGameContext(marriageid, partnerid));
/*     */     }
/*     */     
/*     */ 
/* 163 */     StringBuilder sb = new StringBuilder();
/* 164 */     sb.append(String.format("[fetus_education_music]PCAttendFetusEducationMusic.processImp@attend fetus education music success|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*     */     
/*     */ 
/* 167 */     FetusEducationMusicManager.logger.info(sb.toString());
/* 168 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(int res, Map<String, Object> extraInfo)
/*     */   {
/* 173 */     StringBuilder sb = new StringBuilder();
/* 174 */     sb.append(String.format("[fetus_education_music]PCAttendFetusEducationMusic.processImp@attend fetus education music fail|roleid=%d|res=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(res) }));
/*     */     
/*     */ 
/* 177 */     if (extraInfo != null)
/*     */     {
/* 179 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 181 */         sb.append("|").append((String)entry.getKey());
/* 182 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 185 */     FetusEducationMusicManager.logger.info(sb.toString());
/* 186 */     if (res > 0)
/*     */     {
/* 188 */       SAttendFetusEducationMusicFail protocol = new SAttendFetusEducationMusicFail();
/* 189 */       protocol.res = res;
/* 190 */       OnlineManager.getInstance().sendAtOnce(this.roleid, protocol);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\fetuseducationmusic\PCAttendFetusEducationMusic.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */