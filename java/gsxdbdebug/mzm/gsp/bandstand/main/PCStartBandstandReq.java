/*     */ package mzm.gsp.bandstand.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.activity.main.ActivityLogStatus;
/*     */ import mzm.gsp.activity4.confbean.SBandstandActivityCfg;
/*     */ import mzm.gsp.activity4.confbean.SBandstandMusicCfg;
/*     */ import mzm.gsp.bandstand.FragmentInfo;
/*     */ import mzm.gsp.bandstand.SStartBandstandFail;
/*     */ import mzm.gsp.bandstand.SStartBandstandSuccess;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.CommonUtils;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ import xtable.Role2bandstandsessionid;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCStartBandstandReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int activityId;
/*     */   
/*     */   public PCStartBandstandReq(long roleId, int activityId)
/*     */   {
/*  36 */     this.roleId = roleId;
/*  37 */     this.activityId = activityId;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  44 */     if (!OpenInterface.getOpenStatus(548))
/*     */     {
/*  46 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  50 */     String userId = RoleInterface.getUserId(this.roleId);
/*  51 */     if (null == userId)
/*     */     {
/*  53 */       String logstr = String.format("[bandstand]PCStartBandstandReq.processImp@user not exsist|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  55 */       GameServer.logger().error(logstr);
/*  56 */       return false;
/*     */     }
/*  58 */     Lockeys.lock(Lockeys.get(User.getTable(), userId));
/*  59 */     Lockeys.lock(Lockeys.get(Basic.getTable(), Long.valueOf(this.roleId)));
/*     */     
/*     */ 
/*  62 */     if (!mzm.gsp.status.main.RoleStatusInterface.setStatus(Collections.singletonList(Long.valueOf(this.roleId)), 2081, true))
/*     */     {
/*  64 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  68 */     SBandstandActivityCfg sBandstandActivityCfg = SBandstandActivityCfg.get(this.activityId);
/*  69 */     if (null == sBandstandActivityCfg)
/*     */     {
/*  71 */       onFail(2);
/*  72 */       return false;
/*     */     }
/*     */     
/*  75 */     ActivityJoinResult res = ActivityInterface.canJoinAndCheckInitActivityData(userId, this.roleId, this.activityId);
/*  76 */     if (!res.isCanJoin())
/*     */     {
/*  78 */       onFail(1);
/*  79 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  83 */     int npcId = sBandstandActivityCfg.npcId;
/*  84 */     int serviceId = sBandstandActivityCfg.serviceId;
/*  85 */     if (!mzm.gsp.npc.main.NpcInterface.checkNpcService(npcId, serviceId, this.roleId))
/*     */     {
/*  87 */       onFail(4);
/*  88 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  92 */     Long sessionId = Role2bandstandsessionid.get(Long.valueOf(this.roleId));
/*  93 */     if (null != sessionId)
/*     */     {
/*  95 */       if (null != BandstandSession.getSession(sessionId.longValue()))
/*     */       {
/*  97 */         onFail(3);
/*  98 */         return false;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 103 */     ArrayList<Integer> resMusicIdList = new ArrayList(1);
/* 104 */     CommonUtils.randomList(sBandstandActivityCfg.musicIds, 1, resMusicIdList);
/* 105 */     SBandstandMusicCfg resMusicCfg = SBandstandMusicCfg.get(((Integer)resMusicIdList.get(0)).intValue());
/* 106 */     ArrayList<Integer> resFragmentIndexList = new ArrayList(1);
/* 107 */     CommonUtils.randomList(resMusicCfg.fragmentIndexesWithLyric, 1, resFragmentIndexList);
/*     */     
/* 109 */     int fragmentIndex = ((Integer)resFragmentIndexList.get(0)).intValue();
/* 110 */     BandstandSession session = BandstandManager.startMusic(this.roleId, this.activityId, resMusicCfg.id, fragmentIndex);
/*     */     
/*     */ 
/* 113 */     onSuccess(userId, session, fragmentIndex);
/*     */     
/* 115 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void onSuccess(String userId, BandstandSession session, int startFragmentIndex)
/*     */   {
/* 124 */     String logstr = String.format("[bandstand]PCStartBandstandReq.onSuccess@start bandstand success!|roleId=%d, activityId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityId) });
/*     */     
/*     */ 
/* 127 */     GameServer.logger().info(logstr);
/*     */     
/* 129 */     int musicCfgId = session.getMusicCfgId();
/*     */     
/* 131 */     SStartBandstandSuccess proto = new SStartBandstandSuccess();
/* 132 */     proto.activity_id = this.activityId;
/* 133 */     proto.music_id = musicCfgId;
/* 134 */     proto.start_fragment_index = startFragmentIndex;
/* 135 */     proto.start_time = ((int)(DateTimeUtils.getCurrTimeInMillis() / 1000L));
/* 136 */     for (Map.Entry<Integer, java.util.List<Integer>> entry : session.getAnswerSequenceMap().entrySet())
/*     */     {
/* 138 */       FragmentInfo fragmentInfo = new FragmentInfo();
/* 139 */       fragmentInfo.answer_sequence.addAll((Collection)entry.getValue());
/* 140 */       proto.fragment_info_map.put(entry.getKey(), fragmentInfo);
/*     */     }
/* 142 */     OnlineManager.getInstance().send(this.roleId, proto);
/*     */     
/*     */ 
/* 145 */     BandstandManager.addStartBandstandTlog(this.roleId, this.activityId, musicCfgId, startFragmentIndex);
/*     */     
/*     */ 
/* 148 */     ActivityInterface.logActivity(this.roleId, this.activityId, ActivityLogStatus.ATTEND);
/*     */     
/*     */ 
/* 151 */     ActivityInterface.tlogActivity(this.roleId, this.activityId, ActivityLogStatus.ATTEND);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void onFail(int errorCode)
/*     */   {
/* 162 */     String logstr = String.format("[bandstand]PCStartBandstandReq.onFail@start bandstand fail!|roleId=%d, activityId=%d, errorCode=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityId), Integer.valueOf(errorCode) });
/*     */     
/*     */ 
/* 165 */     GameServer.logger().info(logstr);
/*     */     
/*     */ 
/* 168 */     SStartBandstandFail proto = new SStartBandstandFail();
/* 169 */     proto.error_code = errorCode;
/* 170 */     OnlineManager.getInstance().sendAtOnce(this.roleId, proto);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\bandstand\main\PCStartBandstandReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */