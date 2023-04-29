/*     */ package mzm.gsp.feisheng.fight;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardModel;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.feisheng.SSynFightActivitySchedule;
/*     */ import mzm.gsp.feisheng.confbean.SFeiShengFightActivityCfg;
/*     */ import mzm.gsp.feisheng.confbean.SFeiShengFightInfo;
/*     */ import mzm.gsp.feisheng.event.RoleCompleteFeiShengSubActivityArg;
/*     */ import mzm.gsp.feisheng.main.FeiShengManager;
/*     */ import mzm.gsp.fight.event.PVEFightEndArg;
/*     */ import mzm.gsp.fight.main.FightReason;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.FeiShengFightInfo;
/*     */ import xbean.Pod;
/*     */ import xbean.RoleFeiShengFightInfo;
/*     */ import xtable.Role_fei_sheng_fight_infos;
/*     */ 
/*     */ public class POnPVEFightEnd extends mzm.gsp.fight.event.PVEFightEndProcedure
/*     */ {
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  35 */     if (((PVEFightEndArg)this.arg).fightReason != FightReason.FEI_SHENG_FIGHT_ACTIVITY_PVE.value)
/*     */     {
/*     */ 
/*  38 */       return false;
/*     */     }
/*  40 */     FeiShengFightContext context = null;
/*  41 */     if ((((PVEFightEndArg)this.arg).context instanceof FeiShengFightContext))
/*     */     {
/*  43 */       context = (FeiShengFightContext)((PVEFightEndArg)this.arg).context;
/*     */     }
/*  45 */     if (context == null)
/*     */     {
/*     */ 
/*  48 */       return false;
/*     */     }
/*  50 */     if (!((PVEFightEndArg)this.arg).isPlayerWin)
/*     */     {
/*     */ 
/*  53 */       StringBuilder sb = new StringBuilder();
/*  54 */       sb.append(String.format("[feisheng]POnPVEFightEnd.processImp@fei sheng fight activity fight lose|roleid=%d|activity_cfg_id=%d|sortid=%d", new Object[] { Long.valueOf(context.roleid), Integer.valueOf(context.activityCfgid), Integer.valueOf(context.sortid) }));
/*     */       
/*     */ 
/*  57 */       FeiShengManager.logger.info(sb.toString());
/*  58 */       return false;
/*     */     }
/*  60 */     List<Long> notEscapedRoles = new ArrayList(((PVEFightEndArg)this.arg).roleList);
/*  61 */     notEscapedRoles.removeAll(((PVEFightEndArg)this.arg).escapedRoles);
/*  62 */     if (!notEscapedRoles.contains(Long.valueOf(context.roleid)))
/*     */     {
/*     */ 
/*  65 */       StringBuilder sb = new StringBuilder();
/*  66 */       sb.append(String.format("[feisheng]POnPVEFightEnd.processImp@fei sheng fight activity role escape|roleid=%d|activity_cfg_id=%d|sortid=%d", new Object[] { Long.valueOf(context.roleid), Integer.valueOf(context.activityCfgid), Integer.valueOf(context.sortid) }));
/*     */       
/*     */ 
/*  69 */       FeiShengManager.logger.info(sb.toString());
/*  70 */       return false;
/*     */     }
/*     */     
/*  73 */     List<String> lockRoleUserids = new ArrayList();
/*  74 */     for (Iterator i$ = notEscapedRoles.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*     */       
/*  76 */       lockRoleUserids.add(RoleInterface.getUserId(roleid));
/*     */     }
/*  78 */     String userid = RoleInterface.getUserId(context.roleid);
/*     */     
/*  80 */     lock(xtable.User.getTable(), lockRoleUserids);
/*     */     
/*  82 */     lock(xtable.Basic.getTable(), notEscapedRoles);
/*     */     
/*  84 */     ActivityJoinResult activityJoinResult = ActivityInterface.canJoinAndCheckInitActivityData(userid, context.roleid, context.activityCfgid);
/*     */     
/*  86 */     if (!activityJoinResult.isCanJoin())
/*     */     {
/*     */ 
/*  89 */       StringBuilder sb = new StringBuilder();
/*  90 */       sb.append(String.format("[feisheng]POnPVEFightEnd.processImp@fei sheng fight activity fight win process fail|roleid=%d|activity_cfg_id=%d|sortid=%d|res=%d|reason=%d", new Object[] { Long.valueOf(context.roleid), Integer.valueOf(context.activityCfgid), Integer.valueOf(context.sortid), Integer.valueOf(1), Integer.valueOf(activityJoinResult.getReasonValue()) }));
/*     */       
/*     */ 
/*     */ 
/*  94 */       FeiShengManager.logger.info(sb.toString());
/*  95 */       return false;
/*     */     }
/*     */     
/*  98 */     long now = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/*  99 */     RoleFeiShengFightInfo xRoleFeiShengFightInfo = Role_fei_sheng_fight_infos.get(Long.valueOf(context.roleid));
/* 100 */     if (xRoleFeiShengFightInfo == null)
/*     */     {
/* 102 */       xRoleFeiShengFightInfo = Pod.newRoleFeiShengFightInfo();
/* 103 */       Role_fei_sheng_fight_infos.insert(Long.valueOf(context.roleid), xRoleFeiShengFightInfo);
/*     */     }
/* 105 */     FeiShengFightInfo xFeiShengFightInfo = (FeiShengFightInfo)xRoleFeiShengFightInfo.getFei_sheng_fight_infos().get(Integer.valueOf(context.activityCfgid));
/*     */     
/* 107 */     if (xFeiShengFightInfo == null)
/*     */     {
/* 109 */       xFeiShengFightInfo = Pod.newFeiShengFightInfo();
/* 110 */       xFeiShengFightInfo.setDaily_get_team_member_award_times(0);
/* 111 */       xFeiShengFightInfo.setDaily_get_team_member_award_times_timestamp(now);
/* 112 */       xRoleFeiShengFightInfo.getFei_sheng_fight_infos().put(Integer.valueOf(context.activityCfgid), xFeiShengFightInfo);
/*     */     }
/* 114 */     if (!xFeiShengFightInfo.getComplete_sortids().add(Integer.valueOf(context.sortid)))
/*     */     {
/*     */ 
/* 117 */       StringBuilder sb = new StringBuilder();
/* 118 */       sb.append(String.format("[feisheng]POnPVEFightEnd.processImp@fei sheng fight activity fight win process fail|roleid=%d|activity_cfg_id=%d|sortid=%d|res=%d", new Object[] { Long.valueOf(context.roleid), Integer.valueOf(context.activityCfgid), Integer.valueOf(context.sortid), Integer.valueOf(2) }));
/*     */       
/*     */ 
/* 121 */       FeiShengManager.logger.info(sb.toString());
/* 122 */       return false;
/*     */     }
/* 124 */     SSynFightActivitySchedule protocol = new SSynFightActivitySchedule();
/* 125 */     protocol.activity_cfg_id = context.activityCfgid;
/* 126 */     protocol.complete_sortids.addAll(xFeiShengFightInfo.getComplete_sortids());
/* 127 */     protocol.daily_get_team_member_award_times = FightActivityManager.getDailyGetTeamMemberAwardTimes(xFeiShengFightInfo, now);
/*     */     
/* 129 */     OnlineManager.getInstance().send(context.roleid, protocol);
/*     */     
/* 131 */     SFeiShengFightActivityCfg cfg = SFeiShengFightActivityCfg.get(context.activityCfgid);
/* 132 */     if ((cfg == null) || (!cfg.fight_infos.containsKey(Integer.valueOf(context.sortid))))
/*     */     {
/*     */ 
/* 135 */       return false;
/*     */     }
/*     */     
/* 138 */     for (Iterator i$ = notEscapedRoles.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*     */       
/* 140 */       if (roleid == context.roleid)
/*     */       {
/* 142 */         if (((SFeiShengFightInfo)cfg.fight_infos.get(Integer.valueOf(context.sortid))).team_leader_award_id > 0)
/*     */         {
/* 144 */           AwardModel awardModel = AwardInterface.award(((SFeiShengFightInfo)cfg.fight_infos.get(Integer.valueOf(context.sortid))).team_leader_award_id, RoleInterface.getUserId(roleid), roleid, false, true, new AwardReason(LogReason.FEI_SHENG_FIGHT_TEAM_LEADER_AWARD, context.activityCfgid));
/*     */           
/*     */ 
/* 147 */           if (awardModel == null)
/*     */           {
/*     */ 
/* 150 */             StringBuilder sb = new StringBuilder();
/* 151 */             sb.append(String.format("[feisheng]POnPVEFightEnd.processImp@fei sheng fight activity fight win process fail|roleid=%d|activity_cfg_id=%d|sortid=%d|res=%d", new Object[] { Long.valueOf(context.roleid), Integer.valueOf(context.activityCfgid), Integer.valueOf(context.sortid), Integer.valueOf(3) }));
/*     */             
/*     */ 
/* 154 */             FeiShengManager.logger.info(sb.toString());
/* 155 */             return false;
/*     */           }
/*     */         }
/*     */       }
/*     */       else
/*     */       {
/* 161 */         boolean needSendTeamMemberAward = false;
/* 162 */         String teamMemberUserid = RoleInterface.getUserId(roleid);
/* 163 */         ActivityJoinResult teamMemberActivityJoinResult = ActivityInterface.canJoinAndCheckInitActivityData(teamMemberUserid, roleid, context.activityCfgid);
/*     */         
/* 165 */         if (teamMemberActivityJoinResult.isCanJoin())
/*     */         {
/* 167 */           RoleFeiShengFightInfo xMemberRoleFeiShengFightInfo = Role_fei_sheng_fight_infos.get(Long.valueOf(roleid));
/* 168 */           if (xMemberRoleFeiShengFightInfo == null)
/*     */           {
/* 170 */             xMemberRoleFeiShengFightInfo = Pod.newRoleFeiShengFightInfo();
/* 171 */             Role_fei_sheng_fight_infos.insert(Long.valueOf(roleid), xMemberRoleFeiShengFightInfo);
/*     */           }
/* 173 */           FeiShengFightInfo xMemberFeiShengFightInfo = (FeiShengFightInfo)xMemberRoleFeiShengFightInfo.getFei_sheng_fight_infos().get(Integer.valueOf(context.activityCfgid));
/*     */           
/* 175 */           if (xMemberFeiShengFightInfo == null)
/*     */           {
/* 177 */             xMemberFeiShengFightInfo = Pod.newFeiShengFightInfo();
/* 178 */             xMemberFeiShengFightInfo.setDaily_get_team_member_award_times(0);
/* 179 */             xMemberFeiShengFightInfo.setDaily_get_team_member_award_times_timestamp(now);
/* 180 */             xMemberRoleFeiShengFightInfo.getFei_sheng_fight_infos().put(Integer.valueOf(context.activityCfgid), xMemberFeiShengFightInfo);
/*     */           }
/*     */           
/* 183 */           if (xMemberFeiShengFightInfo.getComplete_sortids().add(Integer.valueOf(context.sortid)))
/*     */           {
/*     */ 
/* 186 */             needSendTeamMemberAward = false;
/* 187 */             if (((SFeiShengFightInfo)cfg.fight_infos.get(Integer.valueOf(context.sortid))).team_leader_award_id > 0)
/*     */             {
/* 189 */               AwardModel awardModel = AwardInterface.award(((SFeiShengFightInfo)cfg.fight_infos.get(Integer.valueOf(context.sortid))).team_leader_award_id, teamMemberUserid, roleid, false, true, new AwardReason(LogReason.FEI_SHENG_FIGHT_TEAM_LEADER_AWARD, context.activityCfgid));
/*     */               
/*     */ 
/* 192 */               if (awardModel == null)
/*     */               {
/*     */ 
/* 195 */                 StringBuilder sb = new StringBuilder();
/* 196 */                 sb.append(String.format("[feisheng]POnPVEFightEnd.processImp@fei sheng fight activity fight win process fail|roleid=%d|activity_cfg_id=%d|sortid=%d|member_roleid=%d|res=%d", new Object[] { Long.valueOf(context.roleid), Integer.valueOf(context.activityCfgid), Integer.valueOf(context.sortid), Long.valueOf(roleid), Integer.valueOf(3) }));
/*     */                 
/*     */ 
/*     */ 
/* 200 */                 FeiShengManager.logger.info(sb.toString());
/* 201 */                 return false;
/*     */               }
/*     */             }
/*     */             
/* 205 */             if ((xMemberFeiShengFightInfo.getComplete_sortids().size() == cfg.fight_infos.keySet().size()) && (xMemberFeiShengFightInfo.getComplete_sortids().containsAll(cfg.fight_infos.keySet())))
/*     */             {
/*     */ 
/*     */ 
/* 209 */               if (cfg.award_id > 0)
/*     */               {
/* 211 */                 AwardModel awardModel = AwardInterface.award(cfg.award_id, teamMemberUserid, roleid, false, true, new AwardReason(LogReason.FEI_SHENG_FIGHT_AWARD, context.activityCfgid));
/*     */                 
/* 213 */                 if (awardModel == null)
/*     */                 {
/*     */ 
/* 216 */                   StringBuilder sb = new StringBuilder();
/* 217 */                   sb.append(String.format("[feisheng]POnPVEFightEnd.processImp@fei sheng fight activity fight win process fail|roleid=%d|activity_cfg_id=%d|sortid=%d|member_roleid=%d|res=%d", new Object[] { Long.valueOf(context.roleid), Integer.valueOf(context.activityCfgid), Integer.valueOf(context.sortid), Long.valueOf(roleid), Integer.valueOf(3) }));
/*     */                   
/*     */ 
/*     */ 
/* 221 */                   FeiShengManager.logger.info(sb.toString());
/* 222 */                   return false;
/*     */                 }
/*     */               }
/*     */               
/* 226 */               ActivityInterface.addActivityCount(teamMemberUserid, roleid, context.activityCfgid);
/*     */               
/* 228 */               TriggerEventsManger.getInstance().triggerEvent(new mzm.gsp.feisheng.event.RoleCompleteFeiShengSubActivity(), new RoleCompleteFeiShengSubActivityArg(roleid, context.activityCfgid));
/*     */               
/*     */ 
/* 231 */               ActivityInterface.tlogActivity(teamMemberUserid, roleid, RoleInterface.getLevel(roleid), mzm.gsp.GameServerInfoManager.getHostIP(), context.activityCfgid, mzm.gsp.activity.main.ActivityLogStatus.FINISH);
/*     */             }
/*     */             
/* 234 */             SSynFightActivitySchedule protocol_team_member = new SSynFightActivitySchedule();
/* 235 */             protocol_team_member.activity_cfg_id = context.activityCfgid;
/* 236 */             protocol_team_member.complete_sortids.addAll(xMemberFeiShengFightInfo.getComplete_sortids());
/* 237 */             protocol_team_member.daily_get_team_member_award_times = FightActivityManager.getDailyGetTeamMemberAwardTimes(xMemberFeiShengFightInfo, now);
/*     */             
/* 239 */             OnlineManager.getInstance().send(roleid, protocol_team_member);
/*     */ 
/*     */           }
/*     */           else
/*     */           {
/* 244 */             needSendTeamMemberAward = true;
/*     */           }
/*     */           
/*     */         }
/*     */         else
/*     */         {
/* 250 */           needSendTeamMemberAward = true;
/*     */         }
/*     */         
/* 253 */         if ((needSendTeamMemberAward) && (((SFeiShengFightInfo)cfg.fight_infos.get(Integer.valueOf(context.sortid))).team_member_award_id > 0))
/*     */         {
/* 255 */           RoleFeiShengFightInfo xMemberRoleFeiShengFightInfo = Role_fei_sheng_fight_infos.get(Long.valueOf(roleid));
/* 256 */           if (xMemberRoleFeiShengFightInfo == null)
/*     */           {
/* 258 */             xMemberRoleFeiShengFightInfo = Pod.newRoleFeiShengFightInfo();
/* 259 */             Role_fei_sheng_fight_infos.insert(Long.valueOf(roleid), xMemberRoleFeiShengFightInfo);
/*     */           }
/* 261 */           FeiShengFightInfo xMemberFeiShengFightInfo = (FeiShengFightInfo)xMemberRoleFeiShengFightInfo.getFei_sheng_fight_infos().get(Integer.valueOf(context.activityCfgid));
/*     */           
/* 263 */           if (xMemberFeiShengFightInfo == null)
/*     */           {
/* 265 */             xMemberFeiShengFightInfo = Pod.newFeiShengFightInfo();
/* 266 */             xMemberFeiShengFightInfo.setDaily_get_team_member_award_times(0);
/* 267 */             xMemberFeiShengFightInfo.setDaily_get_team_member_award_times_timestamp(now);
/* 268 */             xMemberRoleFeiShengFightInfo.getFei_sheng_fight_infos().put(Integer.valueOf(context.activityCfgid), xMemberFeiShengFightInfo);
/*     */           }
/*     */           
/* 271 */           if (FightActivityManager.getDailyGetTeamMemberAwardTimes(xMemberFeiShengFightInfo, now) < cfg.daily_get_team_member_award_max_times)
/*     */           {
/* 273 */             AwardModel awardModel = AwardInterface.award(((SFeiShengFightInfo)cfg.fight_infos.get(Integer.valueOf(context.sortid))).team_member_award_id, RoleInterface.getUserId(roleid), roleid, false, true, new AwardReason(LogReason.FEI_SHENG_FIGHT_TEAM_MEMBER_AWARD, context.activityCfgid));
/*     */             
/*     */ 
/*     */ 
/* 277 */             if (awardModel == null)
/*     */             {
/*     */ 
/* 280 */               StringBuilder sb = new StringBuilder();
/* 281 */               sb.append(String.format("[feisheng]POnPVEFightEnd.processImp@fei sheng fight activity fight win process fail|roleid=%d|activity_cfg_id=%d|sortid=%d|member_roleid=%d|res=%d", new Object[] { Long.valueOf(context.roleid), Integer.valueOf(context.activityCfgid), Integer.valueOf(context.sortid), Long.valueOf(roleid), Integer.valueOf(3) }));
/*     */               
/*     */ 
/*     */ 
/* 285 */               FeiShengManager.logger.info(sb.toString());
/* 286 */               return false;
/*     */             }
/* 288 */             xMemberFeiShengFightInfo.setDaily_get_team_member_award_times(xMemberFeiShengFightInfo.getDaily_get_team_member_award_times() + 1);
/* 289 */             xMemberFeiShengFightInfo.setDaily_get_team_member_award_times_timestamp(now);
/*     */           }
/* 291 */           SSynFightActivitySchedule protocol_team_member = new SSynFightActivitySchedule();
/* 292 */           protocol_team_member.activity_cfg_id = context.activityCfgid;
/* 293 */           protocol_team_member.complete_sortids.addAll(xMemberFeiShengFightInfo.getComplete_sortids());
/* 294 */           protocol_team_member.daily_get_team_member_award_times = FightActivityManager.getDailyGetTeamMemberAwardTimes(xMemberFeiShengFightInfo, now);
/*     */           
/* 296 */           OnlineManager.getInstance().send(roleid, protocol_team_member);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 301 */     if ((xFeiShengFightInfo.getComplete_sortids().size() == cfg.fight_infos.keySet().size()) && (xFeiShengFightInfo.getComplete_sortids().containsAll(cfg.fight_infos.keySet())))
/*     */     {
/*     */ 
/*     */ 
/* 305 */       if (cfg.award_id > 0)
/*     */       {
/* 307 */         AwardModel awardModel = AwardInterface.award(cfg.award_id, userid, context.roleid, false, true, new AwardReason(LogReason.FEI_SHENG_FIGHT_AWARD, context.activityCfgid));
/*     */         
/* 309 */         if (awardModel == null)
/*     */         {
/*     */ 
/* 312 */           StringBuilder sb = new StringBuilder();
/* 313 */           sb.append(String.format("[feisheng]POnPVEFightEnd.processImp@fei sheng fight activity fight win process fail|roleid=%d|activity_cfg_id=%d|sortid=%d|res=%d", new Object[] { Long.valueOf(context.roleid), Integer.valueOf(context.activityCfgid), Integer.valueOf(context.sortid), Integer.valueOf(3) }));
/*     */           
/*     */ 
/* 316 */           FeiShengManager.logger.info(sb.toString());
/* 317 */           return false;
/*     */         }
/*     */       }
/*     */       
/* 321 */       ActivityInterface.addActivityCount(userid, context.roleid, context.activityCfgid);
/*     */       
/* 323 */       TriggerEventsManger.getInstance().triggerEvent(new mzm.gsp.feisheng.event.RoleCompleteFeiShengSubActivity(), new RoleCompleteFeiShengSubActivityArg(context.roleid, context.activityCfgid));
/*     */       
/*     */ 
/* 326 */       ActivityInterface.tlogActivity(userid, context.roleid, RoleInterface.getLevel(context.roleid), mzm.gsp.GameServerInfoManager.getHostIP(), context.activityCfgid, mzm.gsp.activity.main.ActivityLogStatus.FINISH);
/*     */     }
/*     */     
/*     */ 
/* 330 */     StringBuilder sb = new StringBuilder();
/* 331 */     sb.append(String.format("[feisheng]POnPVEFightEnd.processImp@fei sheng fight activity fight win process success|roleid=%d|activity_cfg_id=%d|sortid=%d", new Object[] { Long.valueOf(context.roleid), Integer.valueOf(context.activityCfgid), Integer.valueOf(context.sortid) }));
/*     */     
/*     */ 
/* 334 */     FeiShengManager.logger.info(sb.toString());
/* 335 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\feisheng\fight\POnPVEFightEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */