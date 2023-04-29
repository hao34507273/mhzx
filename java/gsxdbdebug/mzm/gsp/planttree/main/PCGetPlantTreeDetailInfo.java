/*     */ package mzm.gsp.planttree.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.planttree.SGetPlantTreeDetailInfoFail;
/*     */ import mzm.gsp.planttree.confbean.SPlantTreeCfg;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.PlantTreeInfo;
/*     */ import xbean.RolePlantTreeInfo;
/*     */ import xtable.Basic;
/*     */ import xtable.Role_plant_tree_infos;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCGetPlantTreeDetailInfo extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final long ownerid;
/*     */   private final int activityCfgid;
/*     */   
/*     */   public PCGetPlantTreeDetailInfo(long roleid, long ownerid, int activityCfgid)
/*     */   {
/*  29 */     this.roleid = roleid;
/*  30 */     this.ownerid = ownerid;
/*  31 */     this.activityCfgid = activityCfgid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  37 */     if (!PlantTreeManager.isPlantTreeSwitchOpenForRole(this.roleid, this.activityCfgid))
/*     */     {
/*     */ 
/*  40 */       onFail(-1, null);
/*  41 */       return false;
/*     */     }
/*  43 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleid, 911, true))
/*     */     {
/*     */ 
/*  46 */       onFail(-2, null);
/*  47 */       return false;
/*     */     }
/*  49 */     SPlantTreeCfg cfg = SPlantTreeCfg.get(this.activityCfgid);
/*  50 */     if (cfg == null)
/*     */     {
/*     */ 
/*  53 */       onFail(-3, null);
/*  54 */       return false;
/*     */     }
/*  56 */     if (this.ownerid < 0L)
/*     */     {
/*     */ 
/*  59 */       onFail(-3, null);
/*  60 */       return false;
/*     */     }
/*  62 */     if (!PlantTreeManager.checkRelationship(cfg.activity_type, this.roleid, this.ownerid))
/*     */     {
/*     */ 
/*  65 */       onFail(2, null);
/*  66 */       return false;
/*     */     }
/*     */     
/*  69 */     if (this.roleid == this.ownerid)
/*     */     {
/*  71 */       String userid = RoleInterface.getUserId(this.roleid);
/*     */       
/*  73 */       lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*     */       
/*  75 */       lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/*     */       
/*  77 */       ActivityJoinResult activityJoinResult = ActivityInterface.canJoinAndCheckInitActivityData(userid, this.roleid, this.activityCfgid);
/*     */       
/*  79 */       if (!activityJoinResult.isCanJoin())
/*     */       {
/*     */ 
/*  82 */         Map<String, Object> extraInfo = new HashMap();
/*  83 */         extraInfo.put("reason", Integer.valueOf(activityJoinResult.getReasonValue()));
/*  84 */         onFail(1, extraInfo);
/*  85 */         return false;
/*     */       }
/*     */       
/*  88 */       RolePlantTreeInfo xRolePlantTreeInfo = Role_plant_tree_infos.get(Long.valueOf(this.roleid));
/*  89 */       if (xRolePlantTreeInfo == null)
/*     */       {
/*  91 */         onFail(-4, null);
/*  92 */         return false;
/*     */       }
/*  94 */       PlantTreeInfo xPlantTreeInfo = (PlantTreeInfo)xRolePlantTreeInfo.getPlant_tree_infos().get(Integer.valueOf(this.activityCfgid));
/*  95 */       if (xPlantTreeInfo == null)
/*     */       {
/*  97 */         onFail(-4, null);
/*  98 */         return false;
/*     */       }
/* 100 */       OnlineManager.getInstance().send(this.roleid, PlantTreeManager.fillPlantTreeDetailInfo(this.roleid, this.activityCfgid, xPlantTreeInfo));
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/*     */ 
/* 106 */       String userid = RoleInterface.getUserId(this.roleid);
/* 107 */       String ownerUserid = RoleInterface.getUserId(this.ownerid);
/*     */       
/* 109 */       lock(User.getTable(), Arrays.asList(new String[] { userid, ownerUserid }));
/*     */       
/* 111 */       lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid), Long.valueOf(this.ownerid) }));
/*     */       
/*     */ 
/* 114 */       if (!PlantTreeManager.checkRelationship(cfg.activity_type, this.roleid, this.ownerid))
/*     */       {
/*     */ 
/* 117 */         onFail(2, null);
/* 118 */         return false;
/*     */       }
/*     */       
/* 121 */       ActivityJoinResult activityJoinResult1 = ActivityInterface.canJoinAndCheckInitActivityData(userid, this.roleid, this.activityCfgid);
/*     */       
/* 123 */       if (!activityJoinResult1.isCanJoin())
/*     */       {
/*     */ 
/* 126 */         Map<String, Object> extraInfo = new HashMap();
/* 127 */         extraInfo.put("cannot_join_activity_roleid", Long.valueOf(this.roleid));
/* 128 */         extraInfo.put("reason", Integer.valueOf(activityJoinResult1.getReasonValue()));
/* 129 */         onFail(1, extraInfo);
/* 130 */         return false;
/*     */       }
/* 132 */       ActivityJoinResult activityJoinResult2 = ActivityInterface.canJoinAndCheckInitActivityData(ownerUserid, this.ownerid, this.activityCfgid);
/*     */       
/* 134 */       if (!activityJoinResult2.isCanJoin())
/*     */       {
/*     */ 
/* 137 */         Map<String, Object> extraInfo = new HashMap();
/* 138 */         extraInfo.put("cannot_join_activity_roleid", Long.valueOf(this.ownerid));
/* 139 */         extraInfo.put("reason", Integer.valueOf(activityJoinResult2.getReasonValue()));
/* 140 */         onFail(1, extraInfo);
/* 141 */         return false;
/*     */       }
/*     */       
/* 144 */       RolePlantTreeInfo xRolePlantTreeInfo = Role_plant_tree_infos.get(Long.valueOf(this.ownerid));
/* 145 */       if (xRolePlantTreeInfo == null)
/*     */       {
/* 147 */         onFail(-4, null);
/* 148 */         return false;
/*     */       }
/* 150 */       PlantTreeInfo xPlantTreeInfo = (PlantTreeInfo)xRolePlantTreeInfo.getPlant_tree_infos().get(Integer.valueOf(this.activityCfgid));
/* 151 */       if (xPlantTreeInfo == null)
/*     */       {
/* 153 */         onFail(-4, null);
/* 154 */         return false;
/*     */       }
/* 156 */       OnlineManager.getInstance().send(this.roleid, PlantTreeManager.fillPlantTreeDetailInfo(this.ownerid, this.activityCfgid, xPlantTreeInfo));
/*     */     }
/*     */     
/* 159 */     StringBuilder sb = new StringBuilder();
/* 160 */     sb.append(String.format("[planttree]PGetPlantTreeDetailInfo.processImp@get plant tree detail info success|roleid=%d|ownerid=%d|activity_cfg_id=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.ownerid), Integer.valueOf(this.activityCfgid) }));
/*     */     
/*     */ 
/* 163 */     PlantTreeManager.logger.info(sb.toString());
/* 164 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(int res, Map<String, Object> extraInfo)
/*     */   {
/* 169 */     StringBuilder sb = new StringBuilder();
/* 170 */     sb.append(String.format("[planttree]PGetPlantTreeDetailInfo.processImp@get plant tree detail info fail|roleid=%d|ownerid=%d|activity_cfg_id=%d|res=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.ownerid), Integer.valueOf(this.activityCfgid), Integer.valueOf(res) }));
/*     */     
/*     */ 
/* 173 */     if (extraInfo != null)
/*     */     {
/* 175 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 177 */         sb.append("|").append((String)entry.getKey());
/* 178 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 181 */     PlantTreeManager.logger.info(sb.toString());
/* 182 */     if (res > 0)
/*     */     {
/* 184 */       SGetPlantTreeDetailInfoFail protocol = new SGetPlantTreeDetailInfoFail();
/* 185 */       protocol.res = res;
/* 186 */       OnlineManager.getInstance().sendAtOnce(this.roleid, protocol);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\planttree\main\PCGetPlantTreeDetailInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */