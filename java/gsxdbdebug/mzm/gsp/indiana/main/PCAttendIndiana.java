/*     */ package mzm.gsp.indiana.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.grc.main.GrcInterface;
/*     */ import mzm.gsp.indiana.SAttendIndianaFail;
/*     */ import mzm.gsp.indiana.confbean.SIndianaAwardInfo;
/*     */ import mzm.gsp.indiana.confbean.SIndianaCfg;
/*     */ import mzm.gsp.indiana.confbean.SIndianaTurnInfo;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.qingfu.main.CostResult;
/*     */ import mzm.gsp.qingfu.main.CostType;
/*     */ import mzm.gsp.qingfu.main.QingfuInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Pod;
/*     */ import xbean.RoleIndianaActivityInfo;
/*     */ import xbean.RoleIndianaInfo;
/*     */ import xbean.RoleIndianaNumberInfo;
/*     */ import xbean.RoleIndianaTurnInfo;
/*     */ import xtable.Basic;
/*     */ import xtable.Role_indiana_infos;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCAttendIndiana extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int activityCfgid;
/*     */   private final int turn;
/*     */   private final int sortid;
/*     */   
/*     */   public PCAttendIndiana(long roleid, int activityCfgid, int turn, int sortid)
/*     */   {
/*  41 */     this.roleid = roleid;
/*  42 */     this.activityCfgid = activityCfgid;
/*  43 */     this.turn = turn;
/*  44 */     this.sortid = sortid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  50 */     SIndianaCfg cfg = SIndianaCfg.get(this.activityCfgid);
/*  51 */     if (cfg == null)
/*     */     {
/*     */ 
/*  54 */       onFail(-3, null);
/*  55 */       return false;
/*     */     }
/*  57 */     SIndianaTurnInfo turnInfo = (SIndianaTurnInfo)cfg.turn_infos.get(Integer.valueOf(this.turn));
/*  58 */     if (turnInfo == null)
/*     */     {
/*     */ 
/*  61 */       onFail(-3, null);
/*  62 */       return false;
/*     */     }
/*  64 */     SIndianaAwardInfo awardInfo = (SIndianaAwardInfo)turnInfo.award_infos.get(Integer.valueOf(this.sortid));
/*  65 */     if (awardInfo == null)
/*     */     {
/*     */ 
/*  68 */       onFail(-3, null);
/*  69 */       return false;
/*     */     }
/*  71 */     if (!IndianaManager.isIndianaSwitchOpenForRole(this.roleid))
/*     */     {
/*     */ 
/*  74 */       onFail(-1, null);
/*  75 */       return false;
/*     */     }
/*  77 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleid, 1991, true))
/*     */     {
/*     */ 
/*  80 */       onFail(-2, null);
/*  81 */       return false;
/*     */     }
/*  83 */     String userid = RoleInterface.getUserId(this.roleid);
/*     */     
/*  85 */     lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*     */     
/*  87 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/*  88 */     ActivityJoinResult activityJoinResult = ActivityInterface.canJoinAndCheckInitActivityData(userid, this.roleid, this.activityCfgid);
/*     */     
/*  90 */     if (!activityJoinResult.isCanJoin())
/*     */     {
/*     */ 
/*  93 */       Map<String, Object> extraInfo = new HashMap();
/*  94 */       extraInfo.put("reason", Integer.valueOf(activityJoinResult.getReasonValue()));
/*  95 */       onFail(1, extraInfo);
/*  96 */       return false;
/*     */     }
/*  98 */     int currTurn = IndianaManager.getCurrentTurn(this.activityCfgid);
/*  99 */     if (currTurn != this.turn)
/*     */     {
/*     */ 
/* 102 */       Map<String, Object> extraInfo = new HashMap();
/* 103 */       extraInfo.put("curr_turn", Integer.valueOf(currTurn));
/* 104 */       onFail(2, extraInfo);
/* 105 */       return false;
/*     */     }
/* 107 */     RoleIndianaInfo xRoleIndianaInfo = Role_indiana_infos.get(Long.valueOf(this.roleid));
/* 108 */     if (xRoleIndianaInfo == null)
/*     */     {
/* 110 */       xRoleIndianaInfo = Pod.newRoleIndianaInfo();
/* 111 */       Role_indiana_infos.insert(Long.valueOf(this.roleid), xRoleIndianaInfo);
/*     */     }
/* 113 */     RoleIndianaActivityInfo xRoleIndianaActivityInfo = (RoleIndianaActivityInfo)xRoleIndianaInfo.getActivity_infos().get(Integer.valueOf(this.activityCfgid));
/* 114 */     if (xRoleIndianaActivityInfo == null)
/*     */     {
/* 116 */       xRoleIndianaActivityInfo = Pod.newRoleIndianaActivityInfo();
/* 117 */       xRoleIndianaInfo.getActivity_infos().put(Integer.valueOf(this.activityCfgid), xRoleIndianaActivityInfo);
/*     */     }
/* 119 */     RoleIndianaTurnInfo xRoleIndianaTurnInfo = (RoleIndianaTurnInfo)xRoleIndianaActivityInfo.getTurn_infos().get(Integer.valueOf(this.turn));
/* 120 */     if (xRoleIndianaTurnInfo == null)
/*     */     {
/* 122 */       xRoleIndianaTurnInfo = Pod.newRoleIndianaTurnInfo();
/* 123 */       xRoleIndianaActivityInfo.getTurn_infos().put(Integer.valueOf(this.turn), xRoleIndianaTurnInfo);
/*     */     }
/* 125 */     if (xRoleIndianaTurnInfo.getNumber_infos().containsKey(Integer.valueOf(this.sortid)))
/*     */     {
/*     */ 
/* 128 */       onFail(3, null);
/* 129 */       return false;
/*     */     }
/* 131 */     switch (awardInfo.cost_money_type)
/*     */     {
/*     */     case 1: 
/* 134 */       if (QingfuInterface.costYuanbao(userid, this.roleid, awardInfo.cost_money_num, CostType.COST_INDIANA, new TLogArg(LogReason.ATTEND_INDIANA_COST, this.activityCfgid)) != CostResult.Success)
/*     */       {
/*     */ 
/*     */ 
/* 138 */         onFail(8, null);
/* 139 */         return false;
/*     */       }
/*     */       break;
/*     */     case 2: 
/* 143 */       if (!RoleInterface.cutGold(this.roleid, awardInfo.cost_money_num, new TLogArg(LogReason.ATTEND_INDIANA_COST, this.activityCfgid)))
/*     */       {
/*     */ 
/*     */ 
/* 147 */         onFail(8, null);
/* 148 */         return false;
/*     */       }
/*     */       break;
/*     */     case 3: 
/* 152 */       if (!RoleInterface.cutSilver(this.roleid, awardInfo.cost_money_num, new TLogArg(LogReason.ATTEND_INDIANA_COST, this.activityCfgid)))
/*     */       {
/*     */ 
/*     */ 
/* 156 */         onFail(8, null);
/* 157 */         return false;
/*     */       }
/*     */       
/*     */       break;
/*     */     default: 
/* 162 */       onFail(-3, null);
/* 163 */       return false;
/*     */     }
/*     */     
/* 166 */     RoleIndianaNumberInfo xRoleIndianaNumberInfo = Pod.newRoleIndianaNumberInfo();
/* 167 */     xRoleIndianaNumberInfo.setNumber(0);
/* 168 */     xRoleIndianaTurnInfo.getNumber_infos().put(Integer.valueOf(this.sortid), xRoleIndianaNumberInfo);
/*     */     
/* 170 */     boolean canGetSpecialNumber = false;
/* 171 */     if ((awardInfo.special_number_need_yuanbao_num > 0) && (QingfuInterface.getTotalCash(userid, true) >= awardInfo.special_number_need_yuanbao_num))
/*     */     {
/*     */ 
/* 174 */       canGetSpecialNumber = true;
/*     */     }
/* 176 */     if (!GrcInterface.getIndianaNumber(this.activityCfgid, this.turn, this.sortid, awardInfo.init_award_num, awardInfo.extra_award_need_num, this.roleid, canGetSpecialNumber))
/*     */     {
/*     */ 
/*     */ 
/* 180 */       onFail(10, null);
/* 181 */       return false;
/*     */     }
/* 183 */     GameServer.logger().info(String.format("[indiana]PCAttendIndiana.processImp@attend indiana success|roleid=%d|activity_cfg_id=%d|turn=%d|sortid=%d|can_get_special_number=%b", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(this.turn), Integer.valueOf(this.sortid), Boolean.valueOf(canGetSpecialNumber) }));
/*     */     
/*     */ 
/*     */ 
/* 187 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(int res, Map<String, Object> extraInfo)
/*     */   {
/* 192 */     StringBuilder sb = new StringBuilder();
/* 193 */     sb.append(String.format("[indiana]PCAttendIndiana.processImp@attend indiana fail|roleid=%d|activity_cfg_id=%d|turn=%d|sortid=%d|res=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(this.turn), Integer.valueOf(this.sortid), Integer.valueOf(res) }));
/*     */     
/*     */ 
/* 196 */     if (extraInfo != null)
/*     */     {
/* 198 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 200 */         sb.append("|").append((String)entry.getKey());
/* 201 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 204 */     GameServer.logger().info(sb.toString());
/* 205 */     if (res > 0)
/*     */     {
/* 207 */       SAttendIndianaFail protocol = new SAttendIndianaFail();
/* 208 */       protocol.res = res;
/* 209 */       OnlineManager.getInstance().sendAtOnce(this.roleid, protocol);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\indiana\main\PCAttendIndiana.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */