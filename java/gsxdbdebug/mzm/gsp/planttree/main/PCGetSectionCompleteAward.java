/*     */ package mzm.gsp.planttree.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.planttree.SGetSectionCompleteAwardFail;
/*     */ import mzm.gsp.planttree.SGetSectionCompleteAwardSuccess;
/*     */ import mzm.gsp.planttree.confbean.SPlantTreeCfg;
/*     */ import mzm.gsp.planttree.confbean.SSectionInfo;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.PlantTreeInfo;
/*     */ import xbean.RolePlantTreeInfo;
/*     */ import xtable.Basic;
/*     */ import xtable.Role_plant_tree_infos;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCGetSectionCompleteAward extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int activityCfgid;
/*     */   private final int sectionid;
/*     */   
/*     */   public PCGetSectionCompleteAward(long roleid, int activityCfgid, int sectionid)
/*     */   {
/*  34 */     this.roleid = roleid;
/*  35 */     this.activityCfgid = activityCfgid;
/*  36 */     this.sectionid = sectionid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  42 */     if (!PlantTreeManager.isPlantTreeSwitchOpenForRole(this.roleid, this.activityCfgid))
/*     */     {
/*     */ 
/*  45 */       onFail(-1, null);
/*  46 */       return false;
/*     */     }
/*  48 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleid, 914, true))
/*     */     {
/*     */ 
/*     */ 
/*  52 */       onFail(-2, null);
/*  53 */       return false;
/*     */     }
/*  55 */     SPlantTreeCfg cfg = SPlantTreeCfg.get(this.activityCfgid);
/*  56 */     if (cfg == null)
/*     */     {
/*     */ 
/*  59 */       onFail(-3, null);
/*  60 */       return false;
/*     */     }
/*  62 */     if ((this.sectionid <= 0) || (this.sectionid > cfg.section_num))
/*     */     {
/*     */ 
/*  65 */       onFail(-3, null);
/*  66 */       return false;
/*     */     }
/*     */     
/*  69 */     String userid = RoleInterface.getUserId(this.roleid);
/*     */     
/*  71 */     lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*     */     
/*  73 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/*     */     
/*  75 */     ActivityJoinResult activityJoinResult = ActivityInterface.canJoinAndCheckInitActivityData(userid, this.roleid, this.activityCfgid);
/*     */     
/*  77 */     if (!activityJoinResult.isCanJoin())
/*     */     {
/*     */ 
/*  80 */       Map<String, Object> extraInfo = new HashMap();
/*  81 */       extraInfo.put("reason", Integer.valueOf(activityJoinResult.getReasonValue()));
/*  82 */       onFail(1, extraInfo);
/*  83 */       return false;
/*     */     }
/*     */     
/*  86 */     RolePlantTreeInfo xRolePlantTreeInfo = Role_plant_tree_infos.get(Long.valueOf(this.roleid));
/*  87 */     if (xRolePlantTreeInfo == null)
/*     */     {
/*     */ 
/*  90 */       onFail(-4, null);
/*  91 */       return false;
/*     */     }
/*  93 */     PlantTreeInfo xPlantTreeInfo = (PlantTreeInfo)xRolePlantTreeInfo.getPlant_tree_infos().get(Integer.valueOf(this.activityCfgid));
/*  94 */     if (xPlantTreeInfo == null)
/*     */     {
/*     */ 
/*  97 */       onFail(-4, null);
/*  98 */       return false;
/*     */     }
/*     */     
/* 101 */     if (xPlantTreeInfo.getAward_section_ids().contains(Integer.valueOf(this.sectionid)))
/*     */     {
/*     */ 
/* 104 */       onFail(2, null);
/* 105 */       return false;
/*     */     }
/*     */     
/* 108 */     if ((xPlantTreeInfo.getSections().get(Integer.valueOf(this.sectionid)) == null) || (((Integer)xPlantTreeInfo.getSections().get(Integer.valueOf(this.sectionid))).intValue() < ((SSectionInfo)cfg.section_infos.get(Integer.valueOf(this.sectionid))).section_total_point))
/*     */     {
/*     */ 
/*     */ 
/* 112 */       onFail(3, null);
/* 113 */       return false;
/*     */     }
/*     */     
/* 116 */     if (((SSectionInfo)cfg.section_infos.get(Integer.valueOf(this.sectionid))).section_complete_award_id <= 0)
/*     */     {
/*     */ 
/* 119 */       onFail(4, null);
/* 120 */       return false;
/*     */     }
/* 122 */     AwardReason awardReason = new AwardReason(LogReason.PLANT_TREE_SECTION_COMPLETE_AWARD, this.activityCfgid);
/* 123 */     mzm.gsp.award.main.AwardModel awardModel = AwardInterface.award(((SSectionInfo)cfg.section_infos.get(Integer.valueOf(this.sectionid))).section_complete_award_id, userid, this.roleid, false, true, awardReason);
/*     */     
/* 125 */     if (awardModel == null)
/*     */     {
/*     */ 
/* 128 */       onFail(4, null);
/* 129 */       return false;
/*     */     }
/* 131 */     xPlantTreeInfo.getAward_section_ids().add(Integer.valueOf(this.sectionid));
/*     */     
/* 133 */     SGetSectionCompleteAwardSuccess protocol = new SGetSectionCompleteAwardSuccess();
/* 134 */     protocol.activity_cfg_id = this.activityCfgid;
/* 135 */     protocol.section_id = this.sectionid;
/* 136 */     OnlineManager.getInstance().send(this.roleid, protocol);
/* 137 */     OnlineManager.getInstance().send(this.roleid, PlantTreeManager.fillRolePlantTreeInfo(this.roleid, this.activityCfgid, xPlantTreeInfo));
/*     */     
/*     */ 
/* 140 */     StringBuilder sb = new StringBuilder();
/* 141 */     sb.append(String.format("[planttree]PCGetSectionCompleteAward.processImp@get section complete award success|roleid=%d|activity_cfg_id=%d|sectionid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(this.sectionid) }));
/*     */     
/*     */ 
/* 144 */     PlantTreeManager.logger.info(sb.toString());
/* 145 */     PlantTreeTlogManager.addPlantTreeTlog(this.roleid, this.activityCfgid, this.roleid, 5, xPlantTreeInfo.getCurrent_section_id(), ((Integer)xPlantTreeInfo.getSections().get(Integer.valueOf(xPlantTreeInfo.getCurrent_section_id()))).intValue(), xPlantTreeInfo.getSpecial_state_index(), -1, -1, -1, this.sectionid);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 150 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(int res, Map<String, Object> extraInfo)
/*     */   {
/* 155 */     StringBuilder sb = new StringBuilder();
/* 156 */     sb.append(String.format("[planttree]PCGetSectionCompleteAward.processImp@get section complete award fail|roleid=%d|activity_cfg_id=%d|sectionid=%d|res=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(this.sectionid), Integer.valueOf(res) }));
/*     */     
/*     */ 
/* 159 */     if (extraInfo != null)
/*     */     {
/* 161 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 163 */         sb.append("|").append((String)entry.getKey());
/* 164 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 167 */     PlantTreeManager.logger.info(sb.toString());
/* 168 */     if (res > 0)
/*     */     {
/* 170 */       SGetSectionCompleteAwardFail protocol = new SGetSectionCompleteAwardFail();
/* 171 */       protocol.res = res;
/* 172 */       OnlineManager.getInstance().sendAtOnce(this.roleid, protocol);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\planttree\main\PCGetSectionCompleteAward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */