/*     */ package mzm.gsp.feisheng.developitem;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.feisheng.SDevelopItemInDevelopItemActivityFail;
/*     */ import mzm.gsp.feisheng.SDevelopItemInDevelopItemActivitySuccess;
/*     */ import mzm.gsp.feisheng.confbean.SFeiShengDevelopItemActivityCfg;
/*     */ import mzm.gsp.feisheng.main.FeiShengManager;
/*     */ import mzm.gsp.item.main.BasicItem;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.item.main.ItemStoreEnum;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.role.result.CutRoleExpResult;
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
/*     */ public class PCDevelopItemInDevelopItemActivity
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int activityCfgid;
/*     */   private final int grid;
/*     */   private final int addExtraValue;
/*     */   
/*     */   public PCDevelopItemInDevelopItemActivity(long roleid, int activityCfgid, int grid, int addExtraValue)
/*     */   {
/*  40 */     this.roleid = roleid;
/*  41 */     this.activityCfgid = activityCfgid;
/*  42 */     this.grid = grid;
/*  43 */     this.addExtraValue = addExtraValue;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  49 */     if ((this.grid < 0) || (this.addExtraValue <= 0))
/*     */     {
/*     */ 
/*  52 */       onFail(-3, null);
/*  53 */       return false;
/*     */     }
/*  55 */     if (!DevelopItemActivityManager.isFeiShengDevelopItemActivitySwitchOpenForRole(this.roleid, this.activityCfgid))
/*     */     {
/*     */ 
/*  58 */       onFail(-1, null);
/*  59 */       return false;
/*     */     }
/*  61 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleid, 953, true))
/*     */     {
/*     */ 
/*     */ 
/*  65 */       onFail(-2, null);
/*  66 */       return false;
/*     */     }
/*  68 */     SFeiShengDevelopItemActivityCfg cfg = SFeiShengDevelopItemActivityCfg.get(this.activityCfgid);
/*  69 */     if (cfg == null)
/*     */     {
/*     */ 
/*  72 */       onFail(-3, null);
/*  73 */       return false;
/*     */     }
/*  75 */     if (ServerInterface.getCurrentServerLevel() < cfg.serverlevel)
/*     */     {
/*     */ 
/*  78 */       onFail(-5, null);
/*  79 */       return false;
/*     */     }
/*     */     
/*  82 */     String userid = RoleInterface.getUserId(this.roleid);
/*     */     
/*  84 */     lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*     */     
/*  86 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/*     */     
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
/*     */     
/*  99 */     BasicItem item = ItemInterface.getItem(this.roleid, this.grid);
/* 100 */     if ((item == null) || (item.getCfgId() != cfg.item_cfg_id) || (item.getNumber() != 1) || (item.getExtra(ItemStoreEnum.ACTIVITY_CFG_ID) == null) || (item.getExtra(ItemStoreEnum.ACTIVITY_CFG_ID).intValue() != this.activityCfgid))
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/* 105 */       onFail(-3, null);
/* 106 */       return false;
/*     */     }
/* 108 */     switch (cfg.extra_type)
/*     */     {
/*     */     case 1: 
/* 111 */       if (item.getExtra(ItemStoreEnum.EXPERIENCE_VALUE) == null)
/*     */       {
/*     */ 
/* 114 */         item.setExtra(ItemStoreEnum.EXPERIENCE_VALUE, 0);
/*     */       }
/* 116 */       int itemNeedExtraValue = cfg.extra_value - item.getExtra(ItemStoreEnum.EXPERIENCE_VALUE).intValue();
/* 117 */       if (itemNeedExtraValue <= 0)
/*     */       {
/*     */ 
/* 120 */         onFail(2, null);
/* 121 */         return false;
/*     */       }
/* 123 */       int realAddExtraValue = Math.min(this.addExtraValue, itemNeedExtraValue);
/*     */       
/* 125 */       CutRoleExpResult cutRoleExpResult = RoleInterface.cutExp(userid, this.roleid, realAddExtraValue, new TLogArg(LogReason.FEI_SHENG_DEVELOP_ITEM_COST_EXPERIENCE, this.activityCfgid));
/*     */       
/* 127 */       if (!cutRoleExpResult.isCutSuc())
/*     */       {
/*     */ 
/* 130 */         Map<String, Object> extraInfo = new HashMap();
/* 131 */         extraInfo.put("reason", Integer.valueOf(cutRoleExpResult.getReasonValue()));
/* 132 */         onFail(3, extraInfo);
/* 133 */         return false;
/*     */       }
/*     */       
/* 136 */       item.setExtra(ItemStoreEnum.EXPERIENCE_VALUE, item.getExtra(ItemStoreEnum.EXPERIENCE_VALUE).intValue() + realAddExtraValue);
/*     */       
/* 138 */       SDevelopItemInDevelopItemActivitySuccess protocol = new SDevelopItemInDevelopItemActivitySuccess();
/* 139 */       protocol.activity_cfg_id = this.activityCfgid;
/* 140 */       protocol.grid = this.grid;
/* 141 */       protocol.real_add_extra_value = realAddExtraValue;
/* 142 */       OnlineManager.getInstance().send(this.roleid, protocol);
/*     */       
/* 144 */       StringBuilder sb = new StringBuilder();
/* 145 */       sb.append(String.format("[feisheng]PCDevelopItemInDevelopItemActivity.processImp@develop item in develop item activity success|roleid=%d|activity_cfg_id=%d|grid=%d|add_extra_value=%d|real_add_extra_value=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(this.grid), Integer.valueOf(this.addExtraValue), Integer.valueOf(realAddExtraValue) }));
/*     */       
/*     */ 
/* 148 */       FeiShengManager.logger.info(sb.toString());
/* 149 */       return true;
/*     */     }
/* 151 */     onFail(-3, null);
/* 152 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   private void onFail(int res, Map<String, Object> extraInfo)
/*     */   {
/* 158 */     StringBuilder sb = new StringBuilder();
/* 159 */     sb.append(String.format("[feisheng]PCDevelopItemInDevelopItemActivity.processImp@develop item in develop item activity fail|roleid=%d|activity_cfg_id=%d|grid=%d|add_extra_value=%d|res=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(this.grid), Integer.valueOf(this.addExtraValue), Integer.valueOf(res) }));
/*     */     
/*     */ 
/* 162 */     if (extraInfo != null)
/*     */     {
/* 164 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 166 */         sb.append("|").append((String)entry.getKey());
/* 167 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 170 */     FeiShengManager.logger.info(sb.toString());
/* 171 */     if (res > 0)
/*     */     {
/* 173 */       SDevelopItemInDevelopItemActivityFail protocol = new SDevelopItemInDevelopItemActivityFail();
/* 174 */       protocol.res = res;
/* 175 */       OnlineManager.getInstance().sendAtOnce(this.roleid, protocol);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\feisheng\developitem\PCDevelopItemInDevelopItemActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */