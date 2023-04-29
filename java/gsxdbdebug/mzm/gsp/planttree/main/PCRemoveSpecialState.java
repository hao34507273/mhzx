/*     */ package mzm.gsp.planttree.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardModel;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.planttree.SRemoveSpecialStateFail;
/*     */ import mzm.gsp.planttree.confbean.SPlantTreeCfg;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.PlantTreeInfo;
/*     */ import xbean.PlantTreeLog;
/*     */ import xbean.RolePlantTreeInfo;
/*     */ import xtable.Basic;
/*     */ import xtable.Role_plant_tree_infos;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCRemoveSpecialState extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final long ownerid;
/*     */   private final int activityCfgid;
/*     */   private final int specialStateIndex;
/*     */   
/*     */   public PCRemoveSpecialState(long roleid, long ownerid, int activityCfgid, int specialStateIndex)
/*     */   {
/*  38 */     this.roleid = roleid;
/*  39 */     this.ownerid = ownerid;
/*  40 */     this.activityCfgid = activityCfgid;
/*  41 */     this.specialStateIndex = specialStateIndex;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  47 */     if (!PlantTreeManager.isPlantTreeSwitchOpenForRole(this.roleid, this.activityCfgid))
/*     */     {
/*     */ 
/*  50 */       onFail(-1, null);
/*  51 */       return false;
/*     */     }
/*  53 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleid, 912, true))
/*     */     {
/*     */ 
/*  56 */       onFail(-2, null);
/*  57 */       return false;
/*     */     }
/*  59 */     SPlantTreeCfg cfg = SPlantTreeCfg.get(this.activityCfgid);
/*  60 */     if (cfg == null)
/*     */     {
/*     */ 
/*  63 */       onFail(-3, null);
/*  64 */       return false;
/*     */     }
/*  66 */     if (this.ownerid < 0L)
/*     */     {
/*     */ 
/*  69 */       onFail(-3, null);
/*  70 */       return false;
/*     */     }
/*  72 */     if (!PlantTreeManager.checkRelationship(cfg.activity_type, this.roleid, this.ownerid))
/*     */     {
/*     */ 
/*  75 */       onFail(2, null);
/*  76 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  80 */     if (this.roleid == this.ownerid)
/*     */     {
/*  82 */       String userid = RoleInterface.getUserId(this.roleid);
/*     */       
/*  84 */       lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*     */       
/*  86 */       lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/*     */       
/*  88 */       ActivityJoinResult activityJoinResult = ActivityInterface.canJoinAndCheckInitActivityData(userid, this.roleid, this.activityCfgid);
/*     */       
/*  90 */       if (!activityJoinResult.isCanJoin())
/*     */       {
/*     */ 
/*  93 */         Map<String, Object> extraInfo = new HashMap();
/*  94 */         extraInfo.put("reason", Integer.valueOf(activityJoinResult.getReasonValue()));
/*  95 */         onFail(1, extraInfo);
/*  96 */         return false;
/*     */       }
/*     */       
/*  99 */       RolePlantTreeInfo xRolePlantTreeInfo = Role_plant_tree_infos.get(Long.valueOf(this.roleid));
/* 100 */       if (xRolePlantTreeInfo == null)
/*     */       {
/* 102 */         onFail(-4, null);
/* 103 */         return false;
/*     */       }
/* 105 */       PlantTreeInfo xPlantTreeInfo = (PlantTreeInfo)xRolePlantTreeInfo.getPlant_tree_infos().get(Integer.valueOf(this.activityCfgid));
/* 106 */       if (xPlantTreeInfo == null)
/*     */       {
/* 108 */         onFail(-4, null);
/* 109 */         return false;
/*     */       }
/* 111 */       if (xPlantTreeInfo.getSpecial_state_index() != this.specialStateIndex)
/*     */       {
/*     */ 
/* 114 */         onFail(3, null);
/* 115 */         return false;
/*     */       }
/* 117 */       xPlantTreeInfo.setSpecial_state_index(0);
/*     */       
/* 119 */       if ((xPlantTreeInfo.getRemove_special_state_award_times() < cfg.remove_special_state_award_max_times) && (cfg.remove_special_state_awardid > 0))
/*     */       {
/*     */ 
/* 122 */         AwardReason awardReason = new AwardReason(LogReason.PLANT_TREE_REMOVE_SPECIAL_STATE_AWARD, this.activityCfgid);
/*     */         
/* 124 */         AwardModel awardModel = AwardInterface.award(cfg.remove_special_state_awardid, userid, this.roleid, false, true, awardReason);
/*     */         
/* 126 */         if (awardModel == null)
/*     */         {
/*     */ 
/* 129 */           onFail(4, null);
/* 130 */           return false;
/*     */         }
/* 132 */         xPlantTreeInfo.setRemove_special_state_award_times(xPlantTreeInfo.getRemove_special_state_award_times() + 1);
/* 133 */         OnlineManager.getInstance().send(this.roleid, PlantTreeManager.fillRolePlantTreeInfo(this.roleid, this.activityCfgid, xPlantTreeInfo));
/*     */       }
/*     */       
/*     */ 
/* 137 */       int curSectionid = PlantTreeManager.getActivityNeedPoint(this.activityCfgid, xPlantTreeInfo) <= 0 ? xPlantTreeInfo.getCurrent_section_id() + 1 : xPlantTreeInfo.getCurrent_section_id();
/*     */       
/* 139 */       List<PlantTreeLog> xPlantTreeLogs = new ArrayList();
/* 140 */       xPlantTreeLogs.add(PlantTreeManager.createXPlantTreeLog(3, Arrays.asList(new String[] { Integer.toString(curSectionid), Long.toString(this.roleid), RoleInterface.getName(this.roleid), Integer.toString(this.specialStateIndex) })));
/*     */       
/*     */ 
/* 143 */       PlantTreeManager.addPlantTreeLog(xPlantTreeInfo, xPlantTreeLogs);
/*     */       
/* 145 */       OnlineManager.getInstance().sendMulti(PlantTreeManager.fillPlantTreeBasicInfo(this.roleid, this.activityCfgid, xPlantTreeInfo), PlantTreeManager.getRelatedRoleids(cfg.activity_type, this.roleid));
/*     */       
/*     */ 
/* 148 */       OnlineManager.getInstance().send(this.roleid, PlantTreeManager.fillPlantTreeUpdateInfo(this.roleid, this.activityCfgid, xPlantTreeInfo, xPlantTreeLogs));
/*     */       
/*     */ 
/* 151 */       if ((xPlantTreeInfo.getSpecial_state_refresh_sessionid() > 0L) && (Session.getSession(xPlantTreeInfo.getSpecial_state_refresh_sessionid()) != null) && ((Session.getSession(xPlantTreeInfo.getSpecial_state_refresh_sessionid()) instanceof SpecialStateRefreshSession)))
/*     */       {
/*     */ 
/*     */ 
/* 155 */         Session.removeSession(xPlantTreeInfo.getSpecial_state_refresh_sessionid(), this.roleid);
/*     */       }
/* 157 */       xPlantTreeInfo.setSpecial_state_refresh_sessionid(-1L);
/* 158 */       if (xPlantTreeInfo.getSpecial_state_index() <= 0)
/*     */       {
/* 160 */         xPlantTreeInfo.setSpecial_state_refresh_sessionid(new SpecialStateRefreshSession(cfg.special_state_refresh_interval * 60L, this.roleid, this.activityCfgid).getSessionId());
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 165 */       if ((xPlantTreeInfo.getSpecial_state_index() <= 0) && (PlantTreeManager.getActivityNeedPoint(this.activityCfgid, xPlantTreeInfo) > 0))
/*     */       {
/*     */ 
/* 168 */         OnlineRewardPointObserverManager.getInstance().startObserver(this.roleid, this.activityCfgid);
/*     */       }
/* 170 */       PlantTreeTlogManager.addPlantTreeTlog(this.roleid, this.activityCfgid, this.roleid, 4, xPlantTreeInfo.getCurrent_section_id(), ((Integer)xPlantTreeInfo.getSections().get(Integer.valueOf(xPlantTreeInfo.getCurrent_section_id()))).intValue(), xPlantTreeInfo.getSpecial_state_index(), -1, -1, this.specialStateIndex, -1);
/*     */ 
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/*     */ 
/* 177 */       String userid = RoleInterface.getUserId(this.roleid);
/* 178 */       String ownerUserid = RoleInterface.getUserId(this.ownerid);
/*     */       
/* 180 */       lock(User.getTable(), Arrays.asList(new String[] { userid, ownerUserid }));
/*     */       
/* 182 */       lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid), Long.valueOf(this.ownerid) }));
/*     */       
/*     */ 
/* 185 */       if (!PlantTreeManager.checkRelationship(cfg.activity_type, this.roleid, this.ownerid))
/*     */       {
/*     */ 
/* 188 */         onFail(2, null);
/* 189 */         return false;
/*     */       }
/*     */       
/* 192 */       ActivityJoinResult activityJoinResult1 = ActivityInterface.canJoinAndCheckInitActivityData(userid, this.roleid, this.activityCfgid);
/*     */       
/* 194 */       if (!activityJoinResult1.isCanJoin())
/*     */       {
/*     */ 
/* 197 */         Map<String, Object> extraInfo = new HashMap();
/* 198 */         extraInfo.put("cannot_join_activity_roleid", Long.valueOf(this.roleid));
/* 199 */         extraInfo.put("reason", Integer.valueOf(activityJoinResult1.getReasonValue()));
/* 200 */         onFail(1, extraInfo);
/* 201 */         return false;
/*     */       }
/* 203 */       ActivityJoinResult activityJoinResult2 = ActivityInterface.canJoinAndCheckInitActivityData(ownerUserid, this.ownerid, this.activityCfgid);
/*     */       
/* 205 */       if (!activityJoinResult2.isCanJoin())
/*     */       {
/*     */ 
/* 208 */         Map<String, Object> extraInfo = new HashMap();
/* 209 */         extraInfo.put("cannot_join_activity_roleid", Long.valueOf(this.ownerid));
/* 210 */         extraInfo.put("reason", Integer.valueOf(activityJoinResult2.getReasonValue()));
/* 211 */         onFail(1, extraInfo);
/* 212 */         return false;
/*     */       }
/*     */       
/* 215 */       RolePlantTreeInfo xOwnerRolePlantTreeInfo = Role_plant_tree_infos.get(Long.valueOf(this.ownerid));
/* 216 */       if (xOwnerRolePlantTreeInfo == null)
/*     */       {
/* 218 */         onFail(-4, null);
/* 219 */         return false;
/*     */       }
/* 221 */       PlantTreeInfo xOwnerPlantTreeInfo = (PlantTreeInfo)xOwnerRolePlantTreeInfo.getPlant_tree_infos().get(Integer.valueOf(this.activityCfgid));
/*     */       
/* 223 */       if (xOwnerPlantTreeInfo == null)
/*     */       {
/* 225 */         onFail(-4, null);
/* 226 */         return false;
/*     */       }
/* 228 */       if (xOwnerPlantTreeInfo.getSpecial_state_index() != this.specialStateIndex)
/*     */       {
/*     */ 
/* 231 */         onFail(3, null);
/* 232 */         return false;
/*     */       }
/* 234 */       xOwnerPlantTreeInfo.setSpecial_state_index(0);
/*     */       
/* 236 */       int curSectionid = PlantTreeManager.getActivityNeedPoint(this.activityCfgid, xOwnerPlantTreeInfo) <= 0 ? xOwnerPlantTreeInfo.getCurrent_section_id() + 1 : xOwnerPlantTreeInfo.getCurrent_section_id();
/*     */       
/* 238 */       List<PlantTreeLog> xPlantTreeLogs = new ArrayList();
/* 239 */       xPlantTreeLogs.add(PlantTreeManager.createXPlantTreeLog(3, Arrays.asList(new String[] { Integer.toString(curSectionid), Long.toString(this.roleid), RoleInterface.getName(this.roleid), Integer.toString(this.specialStateIndex) })));
/*     */       
/*     */ 
/* 242 */       PlantTreeManager.addPlantTreeLog(xOwnerPlantTreeInfo, xPlantTreeLogs);
/*     */       
/* 244 */       OnlineManager.getInstance().sendMulti(PlantTreeManager.fillPlantTreeBasicInfo(this.ownerid, this.activityCfgid, xOwnerPlantTreeInfo), PlantTreeManager.getRelatedRoleids(cfg.activity_type, this.ownerid));
/*     */       
/*     */ 
/* 247 */       OnlineManager.getInstance().send(this.ownerid, PlantTreeManager.fillPlantTreeUpdateInfo(this.ownerid, this.activityCfgid, xOwnerPlantTreeInfo, xPlantTreeLogs));
/*     */       
/*     */ 
/*     */ 
/* 251 */       OnlineManager.getInstance().send(this.roleid, PlantTreeManager.fillPlantTreeDetailInfo(this.ownerid, this.activityCfgid, xOwnerPlantTreeInfo));
/*     */       
/*     */ 
/* 254 */       RolePlantTreeInfo xRolePlantTreeInfo = Role_plant_tree_infos.get(Long.valueOf(this.roleid));
/* 255 */       if (xRolePlantTreeInfo == null)
/*     */       {
/* 257 */         onFail(-4, null);
/* 258 */         return false;
/*     */       }
/* 260 */       PlantTreeInfo xPlantTreeInfo = (PlantTreeInfo)xRolePlantTreeInfo.getPlant_tree_infos().get(Integer.valueOf(this.activityCfgid));
/* 261 */       if (xPlantTreeInfo == null)
/*     */       {
/* 263 */         onFail(-4, null);
/* 264 */         return false;
/*     */       }
/* 266 */       if ((xPlantTreeInfo.getRemove_special_state_award_times() < cfg.remove_special_state_award_max_times) && (cfg.remove_special_state_awardid > 0))
/*     */       {
/*     */ 
/* 269 */         AwardReason awardReason = new AwardReason(LogReason.PLANT_TREE_REMOVE_SPECIAL_STATE_AWARD, this.activityCfgid);
/*     */         
/* 271 */         AwardModel awardModel = AwardInterface.award(cfg.remove_special_state_awardid, userid, this.roleid, false, true, awardReason);
/*     */         
/* 273 */         if (awardModel == null)
/*     */         {
/*     */ 
/* 276 */           onFail(4, null);
/* 277 */           return false;
/*     */         }
/* 279 */         xPlantTreeInfo.setRemove_special_state_award_times(xPlantTreeInfo.getRemove_special_state_award_times() + 1);
/* 280 */         OnlineManager.getInstance().send(this.roleid, PlantTreeManager.fillRolePlantTreeInfo(this.roleid, this.activityCfgid, xPlantTreeInfo));
/*     */       }
/*     */       
/*     */ 
/* 284 */       if (OnlineManager.getInstance().isOnline(this.ownerid))
/*     */       {
/* 286 */         if ((xOwnerPlantTreeInfo.getSpecial_state_refresh_sessionid() > 0L) && (Session.getSession(xOwnerPlantTreeInfo.getSpecial_state_refresh_sessionid()) != null) && ((Session.getSession(xOwnerPlantTreeInfo.getSpecial_state_refresh_sessionid()) instanceof SpecialStateRefreshSession)))
/*     */         {
/*     */ 
/*     */ 
/* 290 */           Session.removeSession(xOwnerPlantTreeInfo.getSpecial_state_refresh_sessionid(), this.ownerid);
/*     */         }
/* 292 */         xOwnerPlantTreeInfo.setSpecial_state_refresh_sessionid(-1L);
/* 293 */         if (xOwnerPlantTreeInfo.getSpecial_state_index() <= 0)
/*     */         {
/* 295 */           xOwnerPlantTreeInfo.setSpecial_state_refresh_sessionid(new SpecialStateRefreshSession(cfg.special_state_refresh_interval * 60L, this.ownerid, this.activityCfgid).getSessionId());
/*     */         }
/*     */         
/*     */ 
/*     */ 
/* 300 */         if ((xOwnerPlantTreeInfo.getSpecial_state_index() <= 0) && (PlantTreeManager.getActivityNeedPoint(this.activityCfgid, xOwnerPlantTreeInfo) > 0))
/*     */         {
/*     */ 
/* 303 */           OnlineRewardPointObserverManager.getInstance().startObserver(this.ownerid, this.activityCfgid);
/*     */         }
/*     */       }
/* 306 */       PlantTreeTlogManager.addPlantTreeTlog(this.roleid, this.activityCfgid, this.ownerid, 4, xOwnerPlantTreeInfo.getCurrent_section_id(), ((Integer)xOwnerPlantTreeInfo.getSections().get(Integer.valueOf(xOwnerPlantTreeInfo.getCurrent_section_id()))).intValue(), xOwnerPlantTreeInfo.getSpecial_state_index(), -1, -1, this.specialStateIndex, -1);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 311 */     StringBuilder sb = new StringBuilder();
/* 312 */     sb.append(String.format("[planttree]PCRemoveSpecialState.processImp@remove special state success|roleid=%d|ownerid=%d|activity_cfg_id=%d|special_state_index=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.ownerid), Integer.valueOf(this.activityCfgid), Integer.valueOf(this.specialStateIndex) }));
/*     */     
/*     */ 
/* 315 */     PlantTreeManager.logger.info(sb.toString());
/* 316 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(int res, Map<String, Object> extraInfo)
/*     */   {
/* 321 */     StringBuilder sb = new StringBuilder();
/* 322 */     sb.append(String.format("[planttree]PCRemoveSpecialState.processImp@remove special state fail|roleid=%d|ownerid=%d|activity_cfg_id=%d|special_state_index=%d|res=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.ownerid), Integer.valueOf(this.activityCfgid), Integer.valueOf(this.specialStateIndex), Integer.valueOf(res) }));
/*     */     
/*     */ 
/* 325 */     if (extraInfo != null)
/*     */     {
/* 327 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 329 */         sb.append("|").append((String)entry.getKey());
/* 330 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 333 */     PlantTreeManager.logger.info(sb.toString());
/* 334 */     if (res > 0)
/*     */     {
/* 336 */       SRemoveSpecialStateFail protocol = new SRemoveSpecialStateFail();
/* 337 */       protocol.res = res;
/* 338 */       OnlineManager.getInstance().sendAtOnce(this.roleid, protocol);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\planttree\main\PCRemoveSpecialState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */