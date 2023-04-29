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
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.planttree.SAddPointFail;
/*     */ import mzm.gsp.planttree.SAddPointSuccess;
/*     */ import mzm.gsp.planttree.confbean.SAddPointOperation;
/*     */ import mzm.gsp.planttree.confbean.SPlantTreeCfg;
/*     */ import mzm.gsp.qingfu.main.CostResult;
/*     */ import mzm.gsp.qingfu.main.CostType;
/*     */ import mzm.gsp.qingfu.main.QingfuInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.PlantTreeInfo;
/*     */ import xbean.PlantTreeLog;
/*     */ import xbean.RolePlantTreeInfo;
/*     */ import xtable.Basic;
/*     */ import xtable.Role_plant_tree_infos;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCAddPoint
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int activityCfgid;
/*     */   private final int addPointOperationCfgid;
/*     */   private final int moneyType;
/*     */   private final int moneyNum;
/*     */   
/*     */   public PCAddPoint(long roleid, int activityCfgid, int addPointOperationCfgid, int moneyType, int moneyNum)
/*     */   {
/*  43 */     this.roleid = roleid;
/*  44 */     this.activityCfgid = activityCfgid;
/*  45 */     this.addPointOperationCfgid = addPointOperationCfgid;
/*  46 */     this.moneyType = moneyType;
/*  47 */     this.moneyNum = moneyNum;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  53 */     if (!PlantTreeManager.isPlantTreeSwitchOpenForRole(this.roleid, this.activityCfgid))
/*     */     {
/*     */ 
/*  56 */       onFail(-1, null);
/*  57 */       return false;
/*     */     }
/*  59 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleid, 913, true))
/*     */     {
/*     */ 
/*  62 */       onFail(-2, null);
/*  63 */       return false;
/*     */     }
/*  65 */     SPlantTreeCfg cfg = SPlantTreeCfg.get(this.activityCfgid);
/*  66 */     if (cfg == null)
/*     */     {
/*     */ 
/*  69 */       onFail(-3, null);
/*  70 */       return false;
/*     */     }
/*  72 */     SAddPointOperation addPointOperation = (SAddPointOperation)cfg.add_point_operations.get(Integer.valueOf(this.addPointOperationCfgid));
/*  73 */     if ((addPointOperation == null) || (addPointOperation.money_type != this.moneyType))
/*     */     {
/*     */ 
/*  76 */       onFail(-3, null);
/*  77 */       return false;
/*     */     }
/*     */     
/*  80 */     String userid = RoleInterface.getUserId(this.roleid);
/*     */     
/*  82 */     lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*     */     
/*  84 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/*     */     
/*  86 */     ActivityJoinResult activityJoinResult = ActivityInterface.canJoinAndCheckInitActivityData(userid, this.roleid, this.activityCfgid);
/*     */     
/*  88 */     if (!activityJoinResult.isCanJoin())
/*     */     {
/*     */ 
/*  91 */       Map<String, Object> extraInfo = new HashMap();
/*  92 */       extraInfo.put("reason", Integer.valueOf(activityJoinResult.getReasonValue()));
/*  93 */       onFail(1, extraInfo);
/*  94 */       return false;
/*     */     }
/*     */     
/*  97 */     RolePlantTreeInfo xRolePlantTreeInfo = Role_plant_tree_infos.get(Long.valueOf(this.roleid));
/*  98 */     if (xRolePlantTreeInfo == null)
/*     */     {
/* 100 */       onFail(-4, null);
/* 101 */       return false;
/*     */     }
/* 103 */     PlantTreeInfo xPlantTreeInfo = (PlantTreeInfo)xRolePlantTreeInfo.getPlant_tree_infos().get(Integer.valueOf(this.activityCfgid));
/* 104 */     if (xPlantTreeInfo == null)
/*     */     {
/* 106 */       onFail(-4, null);
/* 107 */       return false;
/*     */     }
/* 109 */     if (xPlantTreeInfo.getAdd_point_times() >= cfg.add_point_max_times)
/*     */     {
/* 111 */       onFail(2, null);
/* 112 */       return false;
/*     */     }
/*     */     
/* 115 */     int activityNeedPoint = PlantTreeManager.getActivityNeedPoint(this.activityCfgid, xPlantTreeInfo);
/* 116 */     if (activityNeedPoint <= 0)
/*     */     {
/*     */ 
/* 119 */       onFail(3, null);
/* 120 */       return false;
/*     */     }
/*     */     
/* 123 */     switch (addPointOperation.money_type)
/*     */     {
/*     */     case 1: 
/* 126 */       long yuanbao = QingfuInterface.getYuanbao(userid, true) + QingfuInterface.getBindYuanbao(userid, true);
/* 127 */       if (yuanbao != this.moneyNum)
/*     */       {
/*     */ 
/* 130 */         onFail(4, null);
/* 131 */         return false;
/*     */       }
/* 133 */       if (yuanbao < addPointOperation.money_num)
/*     */       {
/*     */ 
/* 136 */         onFail(5, null);
/* 137 */         return false;
/*     */       }
/* 139 */       if (QingfuInterface.costYuanbao(userid, this.roleid, addPointOperation.money_num, CostType.COST_BIND_FIRST_PLANT_TREE, new TLogArg(LogReason.PLANT_TREE_COST, this.activityCfgid)) != CostResult.Success)
/*     */       {
/*     */ 
/*     */ 
/* 143 */         onFail(6, null);
/* 144 */         return false;
/*     */       }
/*     */       break;
/*     */     case 2: 
/* 148 */       long gold = RoleInterface.getGold(this.roleid);
/* 149 */       if (gold < addPointOperation.money_num)
/*     */       {
/*     */ 
/* 152 */         onFail(5, null);
/* 153 */         return false;
/*     */       }
/* 155 */       if (!RoleInterface.cutGold(this.roleid, addPointOperation.money_num, new TLogArg(LogReason.PLANT_TREE_COST, this.activityCfgid)))
/*     */       {
/*     */ 
/*     */ 
/* 159 */         onFail(6, null);
/* 160 */         return false;
/*     */       }
/*     */       break;
/*     */     case 3: 
/* 164 */       long silver = RoleInterface.getSilver(this.roleid);
/* 165 */       if (silver < addPointOperation.money_num)
/*     */       {
/*     */ 
/* 168 */         onFail(5, null);
/* 169 */         return false;
/*     */       }
/* 171 */       if (!RoleInterface.cutSilver(this.roleid, addPointOperation.money_num, new TLogArg(LogReason.PLANT_TREE_COST, this.activityCfgid)))
/*     */       {
/*     */ 
/*     */ 
/* 175 */         onFail(6, null);
/* 176 */         return false;
/*     */       }
/*     */       
/*     */       break;
/*     */     default: 
/* 181 */       onFail(-3, null);
/* 182 */       return false;
/*     */     }
/*     */     
/* 185 */     xPlantTreeInfo.setAdd_point_times(xPlantTreeInfo.getAdd_point_times() + 1);
/*     */     
/* 187 */     int preSectionid = xPlantTreeInfo.getCurrent_section_id();
/* 188 */     int realAddPoint = Math.min(addPointOperation.point, activityNeedPoint);
/* 189 */     PlantTreeManager.addActivityPoint(this.activityCfgid, xPlantTreeInfo, realAddPoint);
/* 190 */     int curSectionid = PlantTreeManager.getActivityNeedPoint(this.activityCfgid, xPlantTreeInfo) <= 0 ? xPlantTreeInfo.getCurrent_section_id() + 1 : xPlantTreeInfo.getCurrent_section_id();
/*     */     
/* 192 */     if (curSectionid == cfg.section_num + 1)
/*     */     {
/*     */ 
/* 195 */       OnlineRewardPointObserverManager.getInstance().stopObserver(this.roleid, this.activityCfgid);
/*     */     }
/*     */     
/* 198 */     List<PlantTreeLog> xPlantTreeLogs = new ArrayList();
/* 199 */     xPlantTreeLogs.add(PlantTreeManager.createXPlantTreeLog(2, Arrays.asList(new String[] { Integer.toString(preSectionid), Integer.toString(this.addPointOperationCfgid), Integer.toString(realAddPoint) })));
/*     */     
/* 201 */     for (int i = preSectionid; i < curSectionid; i++)
/*     */     {
/* 203 */       xPlantTreeLogs.add(PlantTreeManager.createXPlantTreeLog(4, Arrays.asList(new String[] { Integer.toString(i) })));
/*     */     }
/*     */     
/* 206 */     PlantTreeManager.addPlantTreeLog(xPlantTreeInfo, xPlantTreeLogs);
/*     */     
/* 208 */     SAddPointSuccess protocol = new SAddPointSuccess();
/* 209 */     protocol.activity_cfg_id = this.activityCfgid;
/* 210 */     protocol.add_point_operation_cfg_id = this.addPointOperationCfgid;
/* 211 */     OnlineManager.getInstance().send(this.roleid, protocol);
/* 212 */     OnlineManager.getInstance().sendMulti(PlantTreeManager.fillPlantTreeBasicInfo(this.roleid, this.activityCfgid, xPlantTreeInfo), PlantTreeManager.getRelatedRoleids(cfg.activity_type, this.roleid));
/*     */     
/*     */ 
/* 215 */     OnlineManager.getInstance().send(this.roleid, PlantTreeManager.fillPlantTreeUpdateInfo(this.roleid, this.activityCfgid, xPlantTreeInfo, xPlantTreeLogs));
/*     */     
/* 217 */     OnlineManager.getInstance().send(this.roleid, PlantTreeManager.fillRolePlantTreeInfo(this.roleid, this.activityCfgid, xPlantTreeInfo));
/*     */     
/*     */ 
/* 220 */     StringBuilder sb = new StringBuilder();
/* 221 */     sb.append(String.format("[planttree]PCAddPoint.processImp@add point success|roleid=%d|activity_cfg_id=%d|add_point_operation_cfg_id=%d|money_type=%d|money_num=%d|real_add_point=%d|current_section_id=%d|current_section_point=%d|special_state_index=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(this.addPointOperationCfgid), Integer.valueOf(this.moneyType), Integer.valueOf(this.moneyNum), Integer.valueOf(realAddPoint), Integer.valueOf(xPlantTreeInfo.getCurrent_section_id()), xPlantTreeInfo.getSections().get(Integer.valueOf(xPlantTreeInfo.getCurrent_section_id())), Integer.valueOf(xPlantTreeInfo.getSpecial_state_index()) }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 227 */     PlantTreeManager.logger.info(sb.toString());
/* 228 */     PlantTreeTlogManager.addPlantTreeTlog(this.roleid, this.activityCfgid, this.roleid, 2, xPlantTreeInfo.getCurrent_section_id(), ((Integer)xPlantTreeInfo.getSections().get(Integer.valueOf(xPlantTreeInfo.getCurrent_section_id()))).intValue(), xPlantTreeInfo.getSpecial_state_index(), realAddPoint, this.addPointOperationCfgid, -1, -1);
/*     */     
/*     */ 
/*     */ 
/* 232 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(int res, Map<String, Object> extraInfo)
/*     */   {
/* 237 */     StringBuilder sb = new StringBuilder();
/* 238 */     sb.append(String.format("[planttree]PCAddPoint.processImp@add point fail|roleid=%d|activity_cfg_id=%d|add_point_operation_cfg_id=%d|money_type=%d|money_num=%d|res=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(this.addPointOperationCfgid), Integer.valueOf(this.moneyType), Integer.valueOf(this.moneyNum), Integer.valueOf(res) }));
/*     */     
/*     */ 
/* 241 */     if (extraInfo != null)
/*     */     {
/* 243 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 245 */         sb.append("|").append((String)entry.getKey());
/* 246 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 249 */     PlantTreeManager.logger.info(sb.toString());
/* 250 */     if (res > 0)
/*     */     {
/* 252 */       SAddPointFail protocol = new SAddPointFail();
/* 253 */       protocol.res = res;
/* 254 */       OnlineManager.getInstance().sendAtOnce(this.roleid, protocol);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\planttree\main\PCAddPoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */