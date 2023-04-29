/*     */ package mzm.gsp.foolsday.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.foolsday.SMakeChestFail;
/*     */ import mzm.gsp.foolsday.SMakeChestSuccess;
/*     */ import mzm.gsp.foolsday.confbean.FoolsDayConsts;
/*     */ import mzm.gsp.foolsday.confbean.SFoolsDayBuffCfg;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.item.main.ItemOperateResult;
/*     */ import mzm.gsp.item.main.ItemStoreEnum;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.CommonUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.FoolsDayInfo;
/*     */ import xbean.Item;
/*     */ import xbean.RoleFoolsDayInfo;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCMakeChest extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int buffCfgid;
/*     */   
/*     */   public PCMakeChest(long roleid, int buffCfgid)
/*     */   {
/*  37 */     this.roleid = roleid;
/*  38 */     this.buffCfgid = buffCfgid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  44 */     if (!FoolsDayManager.isFoolsDaySwitchOpenForRole(this.roleid))
/*     */     {
/*     */ 
/*  47 */       onFail(-1, null);
/*  48 */       return false;
/*     */     }
/*  50 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleid, 931, true))
/*     */     {
/*     */ 
/*  53 */       onFail(-2, null);
/*  54 */       return false;
/*     */     }
/*  56 */     SFoolsDayBuffCfg cfg = SFoolsDayBuffCfg.get(this.buffCfgid);
/*  57 */     if (cfg == null)
/*     */     {
/*     */ 
/*  60 */       onFail(-3, null);
/*  61 */       return false;
/*     */     }
/*     */     
/*  64 */     String userid = RoleInterface.getUserId(this.roleid);
/*     */     
/*  66 */     lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*     */     
/*  68 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/*     */     
/*  70 */     ActivityJoinResult activityJoinResult = ActivityInterface.canJoinAndCheckInitActivityData(userid, this.roleid, FoolsDayConsts.getInstance().ACTIVITY_CFG_ID);
/*     */     
/*  72 */     if (!activityJoinResult.isCanJoin())
/*     */     {
/*     */ 
/*  75 */       Map<String, Object> extraInfo = new HashMap();
/*  76 */       extraInfo.put("reason", Integer.valueOf(activityJoinResult.getReasonValue()));
/*  77 */       onFail(1, extraInfo);
/*  78 */       return false;
/*     */     }
/*  80 */     RoleFoolsDayInfo xRoleFoolsDayInfo = xtable.Role_fools_day_infos.get(Long.valueOf(this.roleid));
/*  81 */     if (xRoleFoolsDayInfo == null)
/*     */     {
/*  83 */       onFail(-4, null);
/*  84 */       return false;
/*     */     }
/*  86 */     FoolsDayInfo xFoolsDayInfo = (FoolsDayInfo)xRoleFoolsDayInfo.getFools_day_infos().get(Integer.valueOf(FoolsDayConsts.getInstance().ACTIVITY_CFG_ID));
/*     */     
/*  88 */     if (xFoolsDayInfo == null)
/*     */     {
/*  90 */       onFail(-4, null);
/*  91 */       return false;
/*     */     }
/*     */     
/*  94 */     if (xFoolsDayInfo.getMake_chest_num() >= FoolsDayConsts.getInstance().MAKE_CHEST_MAX_NUM)
/*     */     {
/*     */ 
/*  97 */       onFail(2, null);
/*  98 */       return false;
/*     */     }
/* 100 */     if (!xFoolsDayInfo.getAlternative_buff_cfg_ids().contains(Integer.valueOf(this.buffCfgid)))
/*     */     {
/*     */ 
/* 103 */       onFail(3, null);
/* 104 */       return false;
/*     */     }
/* 106 */     if (!RoleInterface.cutVigor(this.roleid, cfg.cost_vigor, new TLogArg(LogReason.FOOLS_DAY_COST_VIGOR, FoolsDayConsts.getInstance().ACTIVITY_CFG_ID)))
/*     */     {
/*     */ 
/*     */ 
/* 110 */       onFail(4, null);
/* 111 */       return false;
/*     */     }
/*     */     
/* 114 */     Map<Integer, Integer> extraMap = new HashMap();
/* 115 */     extraMap.put(Integer.valueOf(ItemStoreEnum.MAKER_ID_HIGH.getStoreType()), Integer.valueOf(CommonUtils.getLongHigh(this.roleid)));
/* 116 */     extraMap.put(Integer.valueOf(ItemStoreEnum.MAKER_ID_LOW.getStoreType()), Integer.valueOf(CommonUtils.getLongLow(this.roleid)));
/* 117 */     extraMap.put(Integer.valueOf(ItemStoreEnum.BUFF_ID.getStoreType()), Integer.valueOf(cfg.buff_id));
/* 118 */     extraMap.put(Integer.valueOf(ItemStoreEnum.ACTIVITY_CFG_ID.getStoreType()), Integer.valueOf(FoolsDayConsts.getInstance().ACTIVITY_CFG_ID));
/* 119 */     List<Item> xItems = ItemInterface.createXItem(FoolsDayConsts.getInstance().CHEST_ITEM_CFG_ID, 1, extraMap, false);
/*     */     
/* 121 */     ItemOperateResult itemOperateResult = ItemInterface.addItem(this.roleid, xItems, new TLogArg(LogReason.FOOLS_DAY_ADD_ITEM, FoolsDayConsts.getInstance().ACTIVITY_CFG_ID));
/*     */     
/* 123 */     if (!itemOperateResult.success())
/*     */     {
/*     */ 
/* 126 */       onFail(5, null);
/* 127 */       return false;
/*     */     }
/*     */     
/* 130 */     xFoolsDayInfo.setMake_chest_num(xFoolsDayInfo.getMake_chest_num() + 1);
/*     */     
/* 132 */     SMakeChestSuccess protocol = new SMakeChestSuccess();
/* 133 */     protocol.buff_cfg_id = this.buffCfgid;
/* 134 */     OnlineManager.getInstance().send(this.roleid, protocol);
/*     */     
/* 136 */     StringBuilder sb = new StringBuilder();
/* 137 */     sb.append(String.format("[foolsday]PCMakeChest.processImp@make chest success|roleid=%d|buff_cfg_id=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.buffCfgid) }));
/*     */     
/* 139 */     FoolsDayManager.logger.info(sb.toString());
/*     */     
/* 141 */     long uuid = ((Long)new ArrayList(((Item)xItems.get(0)).getUuid()).get(0)).longValue();
/* 142 */     FoolsDayTlogManager.addMakeChestTlog(this.roleid, FoolsDayConsts.getInstance().ACTIVITY_CFG_ID, FoolsDayConsts.getInstance().CHEST_ITEM_CFG_ID, uuid, cfg.buff_id, cfg.cost_vigor, xFoolsDayInfo.getMake_chest_num());
/*     */     
/*     */ 
/* 145 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(int res, Map<String, Object> extraInfo)
/*     */   {
/* 150 */     StringBuilder sb = new StringBuilder();
/* 151 */     sb.append(String.format("[foolsday]PCMakeChest.processImp@make chest fail|roleid=%d|buff_cfg_id=%d|res=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.buffCfgid), Integer.valueOf(res) }));
/*     */     
/* 153 */     if (extraInfo != null)
/*     */     {
/* 155 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 157 */         sb.append("|").append((String)entry.getKey());
/* 158 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 161 */     FoolsDayManager.logger.info(sb.toString());
/* 162 */     if (res > 0)
/*     */     {
/* 164 */       SMakeChestFail protocol = new SMakeChestFail();
/* 165 */       protocol.res = res;
/* 166 */       OnlineManager.getInstance().sendAtOnce(this.roleid, protocol);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\foolsday\main\PCMakeChest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */