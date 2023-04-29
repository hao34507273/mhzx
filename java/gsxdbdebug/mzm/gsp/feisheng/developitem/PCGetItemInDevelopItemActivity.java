/*     */ package mzm.gsp.feisheng.developitem;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.feisheng.SGetItemInDevelopItemActivityFail;
/*     */ import mzm.gsp.feisheng.SGetItemInDevelopItemActivitySuccess;
/*     */ import mzm.gsp.feisheng.confbean.SFeiShengDevelopItemActivityCfg;
/*     */ import mzm.gsp.feisheng.main.FeiShengManager;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.item.main.ItemOperateResult;
/*     */ import mzm.gsp.item.main.ItemStoreEnum;
/*     */ import mzm.gsp.npc.main.NpcInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.server.main.ServerInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.FeiShengDevelopItemInfo;
/*     */ import xbean.Item;
/*     */ import xbean.RoleFeiShengDevelopItemInfo;
/*     */ import xtable.Basic;
/*     */ import xtable.Role_fei_sheng_develop_item_infos;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCGetItemInDevelopItemActivity extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int activityCfgid;
/*     */   
/*     */   public PCGetItemInDevelopItemActivity(long roleid, int activityCfgid)
/*     */   {
/*  38 */     this.roleid = roleid;
/*  39 */     this.activityCfgid = activityCfgid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  45 */     if (!DevelopItemActivityManager.isFeiShengDevelopItemActivitySwitchOpenForRole(this.roleid, this.activityCfgid))
/*     */     {
/*     */ 
/*  48 */       onFail(-1, null);
/*  49 */       return false;
/*     */     }
/*  51 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleid, 952, true))
/*     */     {
/*     */ 
/*     */ 
/*  55 */       onFail(-2, null);
/*  56 */       return false;
/*     */     }
/*  58 */     SFeiShengDevelopItemActivityCfg cfg = SFeiShengDevelopItemActivityCfg.get(this.activityCfgid);
/*  59 */     if (cfg == null)
/*     */     {
/*     */ 
/*  62 */       onFail(-3, null);
/*  63 */       return false;
/*     */     }
/*  65 */     if (ServerInterface.getCurrentServerLevel() < cfg.serverlevel)
/*     */     {
/*     */ 
/*  68 */       onFail(-5, null);
/*  69 */       return false;
/*     */     }
/*  71 */     if (!NpcInterface.checkNpcService(cfg.npc_id, cfg.get_item_npc_service_id, this.roleid))
/*     */     {
/*     */ 
/*  74 */       onFail(-4, null);
/*  75 */       return false;
/*     */     }
/*     */     
/*  78 */     String userid = RoleInterface.getUserId(this.roleid);
/*     */     
/*  80 */     lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*     */     
/*  82 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/*     */     
/*  84 */     ActivityJoinResult activityJoinResult = ActivityInterface.canJoinAndCheckInitActivityData(userid, this.roleid, this.activityCfgid);
/*     */     
/*  86 */     if (!activityJoinResult.isCanJoin())
/*     */     {
/*     */ 
/*  89 */       Map<String, Object> extraInfo = new HashMap();
/*  90 */       extraInfo.put("reason", Integer.valueOf(activityJoinResult.getReasonValue()));
/*  91 */       onFail(1, extraInfo);
/*  92 */       return false;
/*     */     }
/*     */     
/*  95 */     RoleFeiShengDevelopItemInfo xRoleFeiShengDevelopItemInfo = Role_fei_sheng_develop_item_infos.get(Long.valueOf(this.roleid));
/*  96 */     if (xRoleFeiShengDevelopItemInfo == null)
/*     */     {
/*     */ 
/*  99 */       return false;
/*     */     }
/* 101 */     FeiShengDevelopItemInfo xFeiShengDevelopItemInfo = (FeiShengDevelopItemInfo)xRoleFeiShengDevelopItemInfo.getFei_sheng_develop_item_infos().get(Integer.valueOf(this.activityCfgid));
/*     */     
/* 103 */     if (xFeiShengDevelopItemInfo == null)
/*     */     {
/*     */ 
/* 106 */       return false;
/*     */     }
/*     */     
/* 109 */     if (xFeiShengDevelopItemInfo.getHas_get_item())
/*     */     {
/*     */ 
/* 112 */       onFail(2, null);
/* 113 */       return false;
/*     */     }
/*     */     
/* 116 */     Map<Integer, Integer> extraMap = new HashMap();
/* 117 */     extraMap.put(Integer.valueOf(ItemStoreEnum.ACTIVITY_CFG_ID.getStoreType()), Integer.valueOf(this.activityCfgid));
/* 118 */     switch (cfg.extra_type)
/*     */     {
/*     */     case 1: 
/* 121 */       extraMap.put(Integer.valueOf(ItemStoreEnum.EXPERIENCE_VALUE.getStoreType()), Integer.valueOf(0));
/* 122 */       break;
/*     */     default: 
/* 124 */       onFail(-3, null);
/* 125 */       return false;
/*     */     }
/* 127 */     java.util.List<Item> xItems = ItemInterface.createXItem(cfg.item_cfg_id, 1, extraMap, true);
/* 128 */     ItemOperateResult itemOperateResult = ItemInterface.addItem(this.roleid, xItems, new TLogArg(LogReason.FEI_SHENG_DEVELOP_ITEM_ADD_ITEM, this.activityCfgid));
/*     */     
/* 130 */     if (!itemOperateResult.success())
/*     */     {
/*     */ 
/* 133 */       onFail(3, null);
/* 134 */       return false;
/*     */     }
/* 136 */     xFeiShengDevelopItemInfo.setHas_get_item(true);
/*     */     
/* 138 */     SGetItemInDevelopItemActivitySuccess protocol = new SGetItemInDevelopItemActivitySuccess();
/* 139 */     protocol.activity_cfg_id = this.activityCfgid;
/* 140 */     OnlineManager.getInstance().send(this.roleid, protocol);
/*     */     
/* 142 */     StringBuilder sb = new StringBuilder();
/* 143 */     sb.append(String.format("[feisheng]PCGetItemInDevelopItemActivity.processImp@get item in develop item activity success|roleid=%d|activity_cfg_id=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid) }));
/*     */     
/*     */ 
/* 146 */     FeiShengManager.logger.info(sb.toString());
/* 147 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(int res, Map<String, Object> extraInfo)
/*     */   {
/* 152 */     StringBuilder sb = new StringBuilder();
/* 153 */     sb.append(String.format("[feisheng]PCGetItemInDevelopItemActivity.processImp@get item in develop item activity fail|roleid=%d|activity_cfg_id=%d|res=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(res) }));
/*     */     
/*     */ 
/* 156 */     if (extraInfo != null)
/*     */     {
/* 158 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 160 */         sb.append("|").append((String)entry.getKey());
/* 161 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 164 */     FeiShengManager.logger.info(sb.toString());
/* 165 */     if (res > 0)
/*     */     {
/* 167 */       SGetItemInDevelopItemActivityFail protocol = new SGetItemInDevelopItemActivityFail();
/* 168 */       protocol.res = res;
/* 169 */       OnlineManager.getInstance().sendAtOnce(this.roleid, protocol);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\feisheng\developitem\PCGetItemInDevelopItemActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */