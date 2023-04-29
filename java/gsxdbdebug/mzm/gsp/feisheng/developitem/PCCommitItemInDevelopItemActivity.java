/*     */ package mzm.gsp.feisheng.developitem;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.activity.main.ActivityLogStatus;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardModel;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.feisheng.SCommitItemInDevelopItemActivityFail;
/*     */ import mzm.gsp.feisheng.SCommitItemInDevelopItemActivitySuccess;
/*     */ import mzm.gsp.feisheng.confbean.SFeiShengDevelopItemActivityCfg;
/*     */ import mzm.gsp.feisheng.event.RoleCompleteFeiShengSubActivity;
/*     */ import mzm.gsp.feisheng.event.RoleCompleteFeiShengSubActivityArg;
/*     */ import mzm.gsp.feisheng.main.FeiShengManager;
/*     */ import mzm.gsp.item.main.BasicItem;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.item.main.ItemStoreEnum;
/*     */ import mzm.gsp.npc.main.NpcInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.server.main.ServerInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PCCommitItemInDevelopItemActivity
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int activityCfgid;
/*     */   private final int grid;
/*     */   
/*     */   public PCCommitItemInDevelopItemActivity(long roleid, int activityCfgid, int grid)
/*     */   {
/*  48 */     this.roleid = roleid;
/*  49 */     this.activityCfgid = activityCfgid;
/*  50 */     this.grid = grid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  56 */     if (this.grid < 0)
/*     */     {
/*     */ 
/*  59 */       onFail(-3, null);
/*  60 */       return false;
/*     */     }
/*  62 */     if (!DevelopItemActivityManager.isFeiShengDevelopItemActivitySwitchOpenForRole(this.roleid, this.activityCfgid))
/*     */     {
/*     */ 
/*  65 */       onFail(-1, null);
/*  66 */       return false;
/*     */     }
/*  68 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleid, 954, true))
/*     */     {
/*     */ 
/*     */ 
/*  72 */       onFail(-2, null);
/*  73 */       return false;
/*     */     }
/*  75 */     SFeiShengDevelopItemActivityCfg cfg = SFeiShengDevelopItemActivityCfg.get(this.activityCfgid);
/*  76 */     if (cfg == null)
/*     */     {
/*     */ 
/*  79 */       onFail(-3, null);
/*  80 */       return false;
/*     */     }
/*  82 */     if (ServerInterface.getCurrentServerLevel() < cfg.serverlevel)
/*     */     {
/*     */ 
/*  85 */       onFail(-5, null);
/*  86 */       return false;
/*     */     }
/*  88 */     if (!NpcInterface.checkNpcService(cfg.npc_id, cfg.commit_item_npc_service_id, this.roleid))
/*     */     {
/*     */ 
/*  91 */       onFail(-4, null);
/*  92 */       return false;
/*     */     }
/*     */     
/*  95 */     String userid = RoleInterface.getUserId(this.roleid);
/*     */     
/*  97 */     lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*     */     
/*  99 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/*     */     
/* 101 */     ActivityJoinResult activityJoinResult = ActivityInterface.canJoinAndCheckInitActivityData(userid, this.roleid, this.activityCfgid);
/*     */     
/* 103 */     if (!activityJoinResult.isCanJoin())
/*     */     {
/*     */ 
/* 106 */       Map<String, Object> extraInfo = new HashMap();
/* 107 */       extraInfo.put("reason", Integer.valueOf(activityJoinResult.getReasonValue()));
/* 108 */       onFail(1, extraInfo);
/* 109 */       return false;
/*     */     }
/*     */     
/* 112 */     BasicItem item = ItemInterface.getItem(this.roleid, this.grid);
/* 113 */     if ((item == null) || (item.getCfgId() != cfg.item_cfg_id) || (item.getNumber() != 1) || (item.getExtra(ItemStoreEnum.ACTIVITY_CFG_ID) == null) || (item.getExtra(ItemStoreEnum.ACTIVITY_CFG_ID).intValue() != this.activityCfgid))
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/* 118 */       onFail(-3, null);
/* 119 */       return false;
/*     */     }
/* 121 */     switch (cfg.extra_type)
/*     */     {
/*     */     case 1: 
/* 124 */       if ((item.getExtra(ItemStoreEnum.EXPERIENCE_VALUE) == null) || (item.getExtra(ItemStoreEnum.EXPERIENCE_VALUE).intValue() < cfg.extra_value))
/*     */       {
/*     */ 
/*     */ 
/* 128 */         onFail(3, null);
/* 129 */         return false;
/*     */       }
/* 131 */       if (!ItemInterface.removeItemByGrid(this.roleid, 340600000, this.grid, new TLogArg(LogReason.FEI_SHENG_DEVELOP_ITEM_COST_ITEM, this.activityCfgid)))
/*     */       {
/*     */ 
/*     */ 
/* 135 */         onFail(2, null);
/* 136 */         return false;
/*     */       }
/* 138 */       if (cfg.award_id > 0)
/*     */       {
/* 140 */         AwardModel awardModel = AwardInterface.award(cfg.award_id, userid, this.roleid, false, true, new AwardReason(LogReason.FEI_SHENG_DEVELOP_ITEM_AWARD, this.activityCfgid));
/*     */         
/* 142 */         if (awardModel == null)
/*     */         {
/*     */ 
/* 145 */           onFail(4, null);
/* 146 */           return false;
/*     */         }
/*     */       }
/*     */       
/*     */ 
/* 151 */       ActivityInterface.addActivityCount(userid, this.roleid, this.activityCfgid);
/*     */       
/* 153 */       TriggerEventsManger.getInstance().triggerEvent(new RoleCompleteFeiShengSubActivity(), new RoleCompleteFeiShengSubActivityArg(this.roleid, this.activityCfgid));
/*     */       
/*     */ 
/* 156 */       ActivityInterface.tlogActivity(userid, this.roleid, RoleInterface.getLevel(this.roleid), GameServerInfoManager.getHostIP(), this.activityCfgid, ActivityLogStatus.FINISH);
/*     */       
/*     */ 
/* 159 */       SCommitItemInDevelopItemActivitySuccess protocol = new SCommitItemInDevelopItemActivitySuccess();
/* 160 */       protocol.activity_cfg_id = this.activityCfgid;
/* 161 */       protocol.grid = this.grid;
/* 162 */       OnlineManager.getInstance().send(this.roleid, protocol);
/*     */       
/* 164 */       StringBuilder sb = new StringBuilder();
/* 165 */       sb.append(String.format("[feisheng]PCCommitItemInDevelopItemActivity.processImp@commit item in develop item activity success|roleid=%d|activity_cfg_id=%d|grid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(this.grid) }));
/*     */       
/*     */ 
/* 168 */       FeiShengManager.logger.info(sb.toString());
/* 169 */       return true;
/*     */     }
/* 171 */     onFail(-3, null);
/* 172 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   private void onFail(int res, Map<String, Object> extraInfo)
/*     */   {
/* 178 */     StringBuilder sb = new StringBuilder();
/* 179 */     sb.append(String.format("[feisheng]PCCommitItemInDevelopItemActivity.processImp@commit item in develop item activity fail|roleid=%d|activity_cfg_id=%d|grid=%d|res=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(this.grid), Integer.valueOf(res) }));
/*     */     
/*     */ 
/* 182 */     if (extraInfo != null)
/*     */     {
/* 184 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 186 */         sb.append("|").append((String)entry.getKey());
/* 187 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 190 */     FeiShengManager.logger.info(sb.toString());
/* 191 */     if (res > 0)
/*     */     {
/* 193 */       SCommitItemInDevelopItemActivityFail protocol = new SCommitItemInDevelopItemActivityFail();
/* 194 */       protocol.res = res;
/* 195 */       OnlineManager.getInstance().sendAtOnce(this.roleid, protocol);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\feisheng\developitem\PCCommitItemInDevelopItemActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */