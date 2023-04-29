/*     */ package mzm.gsp.axe.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.axe.SAttendAxeActivityFail;
/*     */ import mzm.gsp.axe.SAttendAxeActivitySuccess;
/*     */ import mzm.gsp.axe.confbean.SAxeAvtivityCfg;
/*     */ import mzm.gsp.axe.confbean.SAxeResultInfo;
/*     */ import mzm.gsp.axe.confbean.SAxeSectionInfo;
/*     */ import mzm.gsp.item.confbean.AxeItemConsts;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.item.main.LotteryManager;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.qingfu.main.CostResult;
/*     */ import mzm.gsp.qingfu.main.CostType;
/*     */ import mzm.gsp.qingfu.main.QingfuInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.AxeActivityInfo;
/*     */ import xbean.UserAxeActivityInfo;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
/*     */ import xtable.User_axe_activity_infos;
/*     */ 
/*     */ public class PCAttendAxeActivity extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int activityCfgid;
/*     */   
/*     */   public PCAttendAxeActivity(long roleid, int activityCfgid)
/*     */   {
/*  40 */     this.roleid = roleid;
/*  41 */     this.activityCfgid = activityCfgid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  47 */     if (!AxeManager.isAxeActivitySwitchOpenForRole(this.roleid, this.activityCfgid))
/*     */     {
/*     */ 
/*  50 */       onFail(-1, null);
/*  51 */       return false;
/*     */     }
/*  53 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleid, 1111, true))
/*     */     {
/*     */ 
/*  56 */       onFail(-2, null);
/*  57 */       return false;
/*     */     }
/*  59 */     SAxeAvtivityCfg cfg = SAxeAvtivityCfg.get(this.activityCfgid);
/*  60 */     if (cfg == null)
/*     */     {
/*     */ 
/*  63 */       onFail(-3, null);
/*  64 */       return false;
/*     */     }
/*     */     
/*  67 */     String userid = RoleInterface.getUserId(this.roleid);
/*     */     
/*  69 */     lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*     */     
/*  71 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/*     */     
/*  73 */     ActivityJoinResult activityJoinResult = ActivityInterface.canJoinAndCheckInitActivityData(userid, this.roleid, this.activityCfgid);
/*     */     
/*  75 */     if (!activityJoinResult.isCanJoin())
/*     */     {
/*     */ 
/*  78 */       Map<String, Object> extraInfo = new HashMap();
/*  79 */       extraInfo.put("reason", Integer.valueOf(activityJoinResult.getReasonValue()));
/*  80 */       onFail(1, extraInfo);
/*  81 */       return false;
/*     */     }
/*  83 */     AxeManager.initData(userid, this.activityCfgid);
/*     */     
/*  85 */     UserAxeActivityInfo xUserAxeActivityInfo = User_axe_activity_infos.get(userid);
/*  86 */     if (xUserAxeActivityInfo == null)
/*     */     {
/*     */ 
/*  89 */       return false;
/*     */     }
/*  91 */     AxeActivityInfo xAxeActivityInfo = (AxeActivityInfo)xUserAxeActivityInfo.getAxe_activity_infos().get(Integer.valueOf(this.activityCfgid));
/*  92 */     if (xAxeActivityInfo == null)
/*     */     {
/*     */ 
/*  95 */       return false;
/*     */     }
/*     */     
/*  98 */     long now = DateTimeUtils.getCurrTimeInMillis();
/*  99 */     if (now - xAxeActivityInfo.getStart_timestamp() >= cfg.lock_trigger_interval_in_day * 86400000L)
/*     */     {
/*     */ 
/*     */ 
/* 103 */       onFail(6, null);
/* 104 */       return false;
/*     */     }
/*     */     
/* 107 */     int sectionid = ActivityInterface.getActivityCount(userid, this.roleid, this.activityCfgid, false) + 1;
/* 108 */     if (cfg.section_infos.get(Integer.valueOf(sectionid)) == null)
/*     */     {
/*     */ 
/* 111 */       onFail(-3, null);
/* 112 */       return false;
/*     */     }
/*     */     
/* 115 */     switch (((SAxeSectionInfo)cfg.section_infos.get(Integer.valueOf(sectionid))).cost_type)
/*     */     {
/*     */ 
/*     */ 
/*     */     case 1: 
/* 120 */       long yuanbao = QingfuInterface.getYuanbao(userid, true);
/* 121 */       if (yuanbao < ((SAxeSectionInfo)cfg.section_infos.get(Integer.valueOf(sectionid))).cost_num)
/*     */       {
/*     */ 
/* 124 */         onFail(3, null);
/* 125 */         return false;
/*     */       }
/* 127 */       if (QingfuInterface.costYuanbao(userid, this.roleid, ((SAxeSectionInfo)cfg.section_infos.get(Integer.valueOf(sectionid))).cost_num, CostType.COST_AXE_ACTIVITY, new TLogArg(LogReason.AXE_ATTEND_ACTIVITY_COST, this.activityCfgid)) != CostResult.Success)
/*     */       {
/*     */ 
/*     */ 
/* 131 */         onFail(3, null);
/* 132 */         return false;
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */       break;
/*     */     case 2: 
/* 139 */       long gold = RoleInterface.getGold(this.roleid);
/* 140 */       if (gold < ((SAxeSectionInfo)cfg.section_infos.get(Integer.valueOf(sectionid))).cost_num)
/*     */       {
/*     */ 
/* 143 */         onFail(7, null);
/* 144 */         return false;
/*     */       }
/* 146 */       if (!RoleInterface.cutGold(this.roleid, ((SAxeSectionInfo)cfg.section_infos.get(Integer.valueOf(sectionid))).cost_num, new TLogArg(LogReason.AXE_ATTEND_ACTIVITY_COST, this.activityCfgid)))
/*     */       {
/*     */ 
/*     */ 
/* 150 */         onFail(7, null);
/* 151 */         return false;
/*     */       }
/*     */       
/*     */ 
/*     */       break;
/*     */     case 3: 
/* 157 */       long silver = RoleInterface.getSilver(this.roleid);
/* 158 */       if (silver < ((SAxeSectionInfo)cfg.section_infos.get(Integer.valueOf(sectionid))).cost_num)
/*     */       {
/*     */ 
/* 161 */         onFail(8, null);
/* 162 */         return false;
/*     */       }
/* 164 */       if (!RoleInterface.cutSilver(this.roleid, ((SAxeSectionInfo)cfg.section_infos.get(Integer.valueOf(sectionid))).cost_num, new TLogArg(LogReason.AXE_ATTEND_ACTIVITY_COST, this.activityCfgid)))
/*     */       {
/*     */ 
/*     */ 
/* 168 */         onFail(8, null);
/* 169 */         return false;
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */       break;
/*     */     default: 
/* 176 */       onFail(-3, null);
/* 177 */       return false;
/*     */     }
/*     */     
/*     */     
/* 181 */     if (ItemInterface.getAvailableGridNum(this.roleid, 340600000, true) < ((SAxeSectionInfo)cfg.section_infos.get(Integer.valueOf(sectionid))).max_grid_num)
/*     */     {
/*     */ 
/* 184 */       onFail(5, null);
/* 185 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 189 */     SAxeResultInfo resultInfo = AxeManager.getAxeActivityResult(this.activityCfgid, sectionid, xAxeActivityInfo.getContinuous_not_gold_times() >= cfg.baodi_trigger_times);
/*     */     
/* 191 */     if (resultInfo == null)
/*     */     {
/*     */ 
/* 194 */       onFail(-3, null);
/* 195 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 199 */     if ((resultInfo.axe_item_cfg_id == AxeItemConsts.getInstance().GOLD_AXE_ITEM_CFG_ID) || (resultInfo.axe_item_cfg_id == AxeItemConsts.getInstance().GOLD_AXE_GOLD_ITEM_CFG_ID))
/*     */     {
/*     */ 
/* 202 */       xAxeActivityInfo.setContinuous_not_gold_times(0);
/*     */     }
/*     */     else
/*     */     {
/* 206 */       xAxeActivityInfo.setContinuous_not_gold_times(xAxeActivityInfo.getContinuous_not_gold_times() + 1);
/*     */     }
/*     */     
/*     */ 
/* 210 */     Map<Integer, Integer> itemid2num = new HashMap();
/* 211 */     itemid2num.put(Integer.valueOf(resultInfo.axe_item_cfg_id), Integer.valueOf(resultInfo.axe_num));
/* 212 */     if (!LotteryManager.addLottery(this.roleid, 10, 0, itemid2num, new TLogArg(LogReason.AXE_ATTEND_ACTIVITY_ADD_ITEM, this.activityCfgid)))
/*     */     {
/*     */ 
/*     */ 
/* 216 */       onFail(4, null);
/* 217 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 221 */     ActivityInterface.addActivityCount(userid, this.roleid, this.activityCfgid);
/*     */     
/* 223 */     SAttendAxeActivitySuccess protocol = new SAttendAxeActivitySuccess();
/* 224 */     protocol.activity_cfg_id = this.activityCfgid;
/* 225 */     protocol.sortid = resultInfo.sortid;
/* 226 */     OnlineManager.getInstance().send(this.roleid, protocol);
/*     */     
/* 228 */     StringBuilder sb = new StringBuilder();
/* 229 */     sb.append(String.format("[axe]PCAttendAxeActivity.processImp@attend axe activity success|roleid=%d|activity_cfg_id=%d|section_id=%d|sortid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(sectionid), Integer.valueOf(resultInfo.sortid) }));
/*     */     
/*     */ 
/* 232 */     AxeManager.logger.info(sb.toString());
/* 233 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(int res, Map<String, Object> extraInfo)
/*     */   {
/* 238 */     StringBuilder sb = new StringBuilder();
/* 239 */     sb.append(String.format("[axe]PCAttendAxeActivity.processImp@attend axe activity fail|roleid=%d|activity_cfg_id=%d|res=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(res) }));
/*     */     
/*     */ 
/* 242 */     if (extraInfo != null)
/*     */     {
/* 244 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 246 */         sb.append("|").append((String)entry.getKey());
/* 247 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 250 */     AxeManager.logger.info(sb.toString());
/* 251 */     if (res > 0)
/*     */     {
/* 253 */       SAttendAxeActivityFail protocol = new SAttendAxeActivityFail();
/* 254 */       protocol.res = res;
/* 255 */       OnlineManager.getInstance().sendAtOnce(this.roleid, protocol);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\axe\main\PCAttendAxeActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */