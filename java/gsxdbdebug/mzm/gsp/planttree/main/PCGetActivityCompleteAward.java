/*     */ package mzm.gsp.planttree.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardModel;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.planttree.SGetActivityCompleteAwardFail;
/*     */ import mzm.gsp.planttree.SGetActivityCompleteAwardSuccess;
/*     */ import mzm.gsp.planttree.confbean.SPlantTreeCfg;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.PlantTreeInfo;
/*     */ import xbean.RolePlantTreeInfo;
/*     */ import xtable.Basic;
/*     */ import xtable.Role_plant_tree_infos;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCGetActivityCompleteAward extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int activityCfgid;
/*     */   
/*     */   public PCGetActivityCompleteAward(long roleid, int activityCfgid)
/*     */   {
/*  34 */     this.roleid = roleid;
/*  35 */     this.activityCfgid = activityCfgid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  41 */     if (!PlantTreeManager.isPlantTreeSwitchOpenForRole(this.roleid, this.activityCfgid))
/*     */     {
/*     */ 
/*  44 */       onFail(-1, null);
/*  45 */       return false;
/*     */     }
/*  47 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleid, 915, true))
/*     */     {
/*     */ 
/*     */ 
/*  51 */       onFail(-2, null);
/*  52 */       return false;
/*     */     }
/*  54 */     SPlantTreeCfg cfg = SPlantTreeCfg.get(this.activityCfgid);
/*  55 */     if (cfg == null)
/*     */     {
/*     */ 
/*  58 */       onFail(-3, null);
/*  59 */       return false;
/*     */     }
/*     */     
/*  62 */     String userid = RoleInterface.getUserId(this.roleid);
/*     */     
/*  64 */     lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*     */     
/*  66 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/*     */     
/*  68 */     ActivityJoinResult activityJoinResult = ActivityInterface.canJoinAndCheckInitActivityData(userid, this.roleid, this.activityCfgid);
/*     */     
/*  70 */     if (!activityJoinResult.isCanJoin())
/*     */     {
/*     */ 
/*  73 */       Map<String, Object> extraInfo = new HashMap();
/*  74 */       extraInfo.put("reason", Integer.valueOf(activityJoinResult.getReasonValue()));
/*  75 */       onFail(1, extraInfo);
/*  76 */       return false;
/*     */     }
/*     */     
/*  79 */     RolePlantTreeInfo xRolePlantTreeInfo = Role_plant_tree_infos.get(Long.valueOf(this.roleid));
/*  80 */     if (xRolePlantTreeInfo == null)
/*     */     {
/*     */ 
/*  83 */       onFail(-4, null);
/*  84 */       return false;
/*     */     }
/*  86 */     PlantTreeInfo xPlantTreeInfo = (PlantTreeInfo)xRolePlantTreeInfo.getPlant_tree_infos().get(Integer.valueOf(this.activityCfgid));
/*  87 */     if (xPlantTreeInfo == null)
/*     */     {
/*     */ 
/*  90 */       onFail(-4, null);
/*  91 */       return false;
/*     */     }
/*     */     
/*  94 */     if (xPlantTreeInfo.getHas_get_activity_complete_award())
/*     */     {
/*     */ 
/*  97 */       onFail(2, null);
/*  98 */       return false;
/*     */     }
/*     */     
/* 101 */     if (PlantTreeManager.getActivityNeedPoint(this.activityCfgid, xPlantTreeInfo) > 0)
/*     */     {
/*     */ 
/* 104 */       onFail(3, null);
/* 105 */       return false;
/*     */     }
/*     */     
/* 108 */     if (cfg.activity_complete_award_id <= 0)
/*     */     {
/*     */ 
/* 111 */       onFail(4, null);
/* 112 */       return false;
/*     */     }
/* 114 */     AwardReason awardReason = new AwardReason(LogReason.PLANT_TREE_ACTIVITY_COMPLETE_AWARD, this.activityCfgid);
/* 115 */     AwardModel awardModel = AwardInterface.award(cfg.activity_complete_award_id, userid, this.roleid, false, true, awardReason);
/*     */     
/* 117 */     if (awardModel == null)
/*     */     {
/*     */ 
/* 120 */       onFail(4, null);
/* 121 */       return false;
/*     */     }
/* 123 */     xPlantTreeInfo.setHas_get_activity_complete_award(true);
/*     */     
/* 125 */     SGetActivityCompleteAwardSuccess protocol = new SGetActivityCompleteAwardSuccess();
/* 126 */     protocol.activity_cfg_id = this.activityCfgid;
/* 127 */     OnlineManager.getInstance().send(this.roleid, protocol);
/* 128 */     OnlineManager.getInstance().send(this.roleid, PlantTreeManager.fillRolePlantTreeInfo(this.roleid, this.activityCfgid, xPlantTreeInfo));
/*     */     
/*     */ 
/* 131 */     StringBuilder sb = new StringBuilder();
/* 132 */     sb.append(String.format("[planttree]PCGetActivityCompleteAward.processImp@get avtivity complete award succcess|roleid=%d|activity_cfg_id=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid) }));
/*     */     
/*     */ 
/* 135 */     PlantTreeManager.logger.info(sb.toString());
/* 136 */     PlantTreeTlogManager.addPlantTreeTlog(this.roleid, this.activityCfgid, this.roleid, 6, xPlantTreeInfo.getCurrent_section_id(), ((Integer)xPlantTreeInfo.getSections().get(Integer.valueOf(xPlantTreeInfo.getCurrent_section_id()))).intValue(), xPlantTreeInfo.getSpecial_state_index(), -1, -1, -1, cfg.section_num + 1);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 141 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(int res, Map<String, Object> extraInfo)
/*     */   {
/* 146 */     StringBuilder sb = new StringBuilder();
/* 147 */     sb.append(String.format("[planttree]PCGetActivityCompleteAward.processImp@get avtivity complete award fail|roleid=%d|activity_cfg_id=%d|res=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(res) }));
/*     */     
/*     */ 
/* 150 */     if (extraInfo != null)
/*     */     {
/* 152 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 154 */         sb.append("|").append((String)entry.getKey());
/* 155 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 158 */     PlantTreeManager.logger.info(sb.toString());
/* 159 */     if (res > 0)
/*     */     {
/* 161 */       SGetActivityCompleteAwardFail protocol = new SGetActivityCompleteAwardFail();
/* 162 */       protocol.res = res;
/* 163 */       OnlineManager.getInstance().sendAtOnce(this.roleid, protocol);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\planttree\main\PCGetActivityCompleteAward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */