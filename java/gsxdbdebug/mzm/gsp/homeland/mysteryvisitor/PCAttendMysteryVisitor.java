/*     */ package mzm.gsp.homeland.mysteryvisitor;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardModel;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.homeland.SAttendMysteryVisitorFail;
/*     */ import mzm.gsp.homeland.SAttendMysteryVisitorSuccess;
/*     */ import mzm.gsp.homeland.confbean.MysteryVisitorConsts;
/*     */ import mzm.gsp.homeland.confbean.SDanceMysteryVisitorCfg;
/*     */ import mzm.gsp.homeland.confbean.SMusicGameMysteryVisitorCfg;
/*     */ import mzm.gsp.homeland.confbean.SMysteryVisitorCfg;
/*     */ import mzm.gsp.homeland.event.MysteryVisitorDisappear;
/*     */ import mzm.gsp.homeland.event.MysteryVisitorDisappearArg;
/*     */ import mzm.gsp.homeland.main.HomelandInterface;
/*     */ import mzm.gsp.marriage.main.MarriageInterface;
/*     */ import mzm.gsp.musicgame.main.MusicGameInterface;
/*     */ import mzm.gsp.npc.main.NpcInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.RoleMysteryVisitorInfo;
/*     */ import xtable.Basic;
/*     */ import xtable.Role_mystery_visitor_infos;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCAttendMysteryVisitor extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int mysteryVisitorCfgid;
/*     */   
/*     */   public PCAttendMysteryVisitor(long roleid, int mysteryVisitorCfgid)
/*     */   {
/*  44 */     this.roleid = roleid;
/*  45 */     this.mysteryVisitorCfgid = mysteryVisitorCfgid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  51 */     if (this.mysteryVisitorCfgid <= 0)
/*     */     {
/*     */ 
/*  54 */       onFail(-4, null);
/*  55 */       return false;
/*     */     }
/*  57 */     if (!MysteryVisitorManager.isMysteryVisitorSwitchOpenForRole(this.roleid))
/*     */     {
/*     */ 
/*  60 */       onFail(-1, null);
/*  61 */       return false;
/*     */     }
/*  63 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleid, 1141, true))
/*     */     {
/*     */ 
/*  66 */       onFail(-2, null);
/*  67 */       return false;
/*     */     }
/*  69 */     SMysteryVisitorCfg cfg = SMysteryVisitorCfg.get(this.mysteryVisitorCfgid);
/*  70 */     if (cfg == null)
/*     */     {
/*     */ 
/*  73 */       onFail(-4, null);
/*  74 */       return false;
/*     */     }
/*  76 */     switch (cfg.type)
/*     */     {
/*     */ 
/*     */ 
/*     */     case 1: 
/*  81 */       onFail(-4, null);
/*  82 */       return false;
/*     */     
/*     */ 
/*     */     case 2: 
/*  86 */       if (!(cfg instanceof SDanceMysteryVisitorCfg))
/*     */       {
/*     */ 
/*  89 */         onFail(-4, null);
/*  90 */         return false;
/*     */       }
/*  92 */       SDanceMysteryVisitorCfg serverCfg = (SDanceMysteryVisitorCfg)cfg;
/*  93 */       if (!NpcInterface.checkNpcService(this.roleid, serverCfg.mystery_visitor_npc_service_id, serverCfg.mystery_visitor_npc_id, new MysteryVisitorNPCConditionChecker(this.roleid)))
/*     */       {
/*     */ 
/*     */ 
/*  97 */         onFail(-3, null);
/*  98 */         return false;
/*     */       }
/*     */       
/* 101 */       break;
/*     */     
/*     */     case 3: 
/* 104 */       if (!(cfg instanceof SMusicGameMysteryVisitorCfg))
/*     */       {
/*     */ 
/* 107 */         onFail(-4, null);
/* 108 */         return false;
/*     */       }
/* 110 */       SMusicGameMysteryVisitorCfg serverCfg = (SMusicGameMysteryVisitorCfg)cfg;
/* 111 */       if (!NpcInterface.checkNpcService(this.roleid, serverCfg.mystery_visitor_npc_service_id, serverCfg.mystery_visitor_npc_id, new MysteryVisitorNPCConditionChecker(this.roleid)))
/*     */       {
/*     */ 
/*     */ 
/* 115 */         onFail(-3, null);
/* 116 */         return false;
/*     */       }
/*     */       
/* 119 */       break;
/*     */     
/*     */ 
/*     */     default: 
/* 123 */       onFail(-4, null);
/* 124 */       return false;
/*     */     }
/*     */     
/*     */     
/* 128 */     String userid = RoleInterface.getUserId(this.roleid);
/* 129 */     long partnerid = MarriageInterface.getMarriedRoleid(this.roleid, false);
/* 130 */     if (partnerid < 0L)
/*     */     {
/*     */ 
/* 133 */       lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*     */       
/* 135 */       lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/* 136 */       if (MarriageInterface.getMarriedRoleid(this.roleid, true) >= 0L)
/*     */       {
/*     */ 
/* 139 */         onFail(5, null);
/* 140 */         return false;
/*     */       }
/*     */     }
/*     */     else
/*     */     {
/* 145 */       long marriageid = MarriageInterface.getMarriedId(this.roleid, false);
/* 146 */       if (marriageid < 0L)
/*     */       {
/*     */ 
/* 149 */         onFail(5, null);
/* 150 */         return false;
/*     */       }
/* 152 */       String partnerUserid = RoleInterface.getUserId(partnerid);
/*     */       
/* 154 */       lock(User.getTable(), Arrays.asList(new String[] { userid, partnerUserid }));
/*     */       
/* 156 */       lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid), Long.valueOf(partnerid) }));
/*     */       
/* 158 */       lock(xtable.Marriage.getTable(), Arrays.asList(new Long[] { Long.valueOf(marriageid) }));
/* 159 */       if ((MarriageInterface.getMarriedRoleid(this.roleid, true) != partnerid) || (MarriageInterface.getMarriedId(this.roleid, true) != marriageid))
/*     */       {
/*     */ 
/*     */ 
/* 163 */         onFail(5, null);
/* 164 */         return false;
/*     */       }
/*     */     }
/*     */     
/* 168 */     ActivityJoinResult activityJoinResult = ActivityInterface.canJoinAndCheckInitActivityData(userid, this.roleid, MysteryVisitorConsts.getInstance().ACTIVITY_CFG_ID);
/*     */     
/* 170 */     if (!activityJoinResult.isCanJoin())
/*     */     {
/*     */ 
/* 173 */       Map<String, Object> extraInfo = new HashMap();
/* 174 */       extraInfo.put("reason", Integer.valueOf(activityJoinResult.getReasonValue()));
/* 175 */       onFail(1, extraInfo);
/* 176 */       return false;
/*     */     }
/*     */     
/* 179 */     int courdyardAestheticsDegree = HomelandInterface.getCourtYardBeautiful(this.roleid);
/* 180 */     if (courdyardAestheticsDegree < 0)
/*     */     {
/*     */ 
/* 183 */       onFail(4, null);
/* 184 */       return false;
/*     */     }
/*     */     
/* 187 */     RoleMysteryVisitorInfo xRoleMysteryVisitorInfo = Role_mystery_visitor_infos.get(Long.valueOf(this.roleid));
/* 188 */     if (xRoleMysteryVisitorInfo == null)
/*     */     {
/*     */ 
/* 191 */       return false;
/*     */     }
/* 193 */     if (xRoleMysteryVisitorInfo.getMystery_visitor_cfg_id() <= 0)
/*     */     {
/*     */ 
/* 196 */       onFail(3, null);
/* 197 */       return false;
/*     */     }
/* 199 */     if (xRoleMysteryVisitorInfo.getMystery_visitor_cfg_id() != this.mysteryVisitorCfgid)
/*     */     {
/*     */ 
/* 202 */       onFail(-4, null);
/* 203 */       return false;
/*     */     }
/*     */     
/* 206 */     switch (cfg.type)
/*     */     {
/*     */ 
/*     */ 
/*     */     case 1: 
/* 211 */       onFail(-4, null);
/* 212 */       return false;
/*     */     
/*     */ 
/*     */     case 2: 
/* 216 */       if (!(cfg instanceof SDanceMysteryVisitorCfg))
/*     */       {
/*     */ 
/* 219 */         onFail(-4, null);
/* 220 */         return false;
/*     */       }
/* 222 */       SDanceMysteryVisitorCfg serverCfg = (SDanceMysteryVisitorCfg)cfg;
/*     */       
/* 224 */       if (serverCfg.award_id > 0)
/*     */       {
/* 226 */         AwardReason awardReason = new AwardReason(LogReason.MYSTERY_VISITOR_AWARD, this.mysteryVisitorCfgid);
/*     */         
/* 228 */         AwardModel awardModel = AwardInterface.award(serverCfg.award_id, userid, this.roleid, false, true, awardReason);
/*     */         
/* 230 */         if (awardModel == null)
/*     */         {
/*     */ 
/* 233 */           onFail(2, null);
/* 234 */           return false;
/*     */         }
/*     */       }
/* 237 */       xRoleMysteryVisitorInfo.setMystery_visitor_cfg_id(-1);
/* 238 */       ActivityInterface.addActivityCount(userid, this.roleid, MysteryVisitorConsts.getInstance().ACTIVITY_CFG_ID);
/* 239 */       TriggerEventsManger.getInstance().triggerEvent(new MysteryVisitorDisappear(), new MysteryVisitorDisappearArg(this.roleid));
/*     */       
/*     */ 
/* 242 */       SAttendMysteryVisitorSuccess protocol = new SAttendMysteryVisitorSuccess();
/* 243 */       protocol.mystery_visitor_cfg_id = this.mysteryVisitorCfgid;
/* 244 */       OnlineManager.getInstance().send(this.roleid, protocol);
/*     */       
/* 246 */       StringBuilder sb = new StringBuilder();
/* 247 */       sb.append(String.format("[mysteryvisitor]PCAttendMysteryVisitor.processImp@attend mystery visitor success|roleid=%d|mystery_visitor_cfg_id=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.mysteryVisitorCfgid) }));
/*     */       
/*     */ 
/* 250 */       MysteryVisitorManager.logger.info(sb.toString());
/*     */       
/* 252 */       break;
/*     */     
/*     */     case 3: 
/* 255 */       if (!(cfg instanceof SMusicGameMysteryVisitorCfg))
/*     */       {
/*     */ 
/* 258 */         onFail(-4, null);
/* 259 */         return false;
/*     */       }
/* 261 */       SMusicGameMysteryVisitorCfg serverCfg = (SMusicGameMysteryVisitorCfg)cfg;
/*     */       
/* 263 */       long now = DateTimeUtils.getCurrTimeInMillis();
/* 264 */       boolean isLastMusicGameStartInSameDay = false;
/* 265 */       long timestamp = MusicGameInterface.getRoleLastMusicGameStartTimestamp(this.roleid, serverCfg.music_game_id);
/* 266 */       if ((timestamp > 0L) && (!DateTimeUtils.needDailyReset(timestamp, now, 0)))
/*     */       {
/* 268 */         isLastMusicGameStartInSameDay = true;
/*     */       }
/* 270 */       if (isLastMusicGameStartInSameDay)
/*     */       {
/* 272 */         MusicGameInterface.startMusicGame(this.roleid, serverCfg.music_game_id, false, 0, new MysteryVisitorMusicGameContext());
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/* 277 */         MusicGameInterface.startMusicGame(this.roleid, serverCfg.music_game_id, true, 0, new MysteryVisitorMusicGameContext());
/*     */       }
/*     */       
/*     */ 
/* 281 */       StringBuilder sb = new StringBuilder();
/* 282 */       sb.append(String.format("[mysteryvisitor]PCAttendMysteryVisitor.processImp@attend mystery visitor success|roleid=%d|mystery_visitor_cfg_id=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.mysteryVisitorCfgid) }));
/*     */       
/*     */ 
/* 285 */       MysteryVisitorManager.logger.info(sb.toString());
/*     */       
/* 287 */       break;
/*     */     
/*     */ 
/*     */     default: 
/* 291 */       onFail(-4, null);
/* 292 */       return false;
/*     */     }
/*     */     
/* 295 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(int res, Map<String, Object> extraInfo)
/*     */   {
/* 300 */     StringBuilder sb = new StringBuilder();
/* 301 */     sb.append(String.format("[mysteryvisitor]PCAttendMysteryVisitor.processImp@attend mystery visitor fail|roleid=%d|mystery_visitor_cfg_id=%d|res=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.mysteryVisitorCfgid), Integer.valueOf(res) }));
/*     */     
/*     */ 
/* 304 */     if (extraInfo != null)
/*     */     {
/* 306 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 308 */         sb.append("|").append((String)entry.getKey());
/* 309 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 312 */     MysteryVisitorManager.logger.info(sb.toString());
/* 313 */     if (res > 0)
/*     */     {
/* 315 */       SAttendMysteryVisitorFail protocol = new SAttendMysteryVisitorFail();
/* 316 */       protocol.res = res;
/* 317 */       OnlineManager.getInstance().sendAtOnce(this.roleid, protocol);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\mysteryvisitor\PCAttendMysteryVisitor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */