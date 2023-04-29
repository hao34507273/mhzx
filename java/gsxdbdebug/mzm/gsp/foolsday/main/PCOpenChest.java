/*     */ package mzm.gsp.foolsday.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardModel;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.foolsday.SOpenChestFail;
/*     */ import mzm.gsp.foolsday.SOpenChestSuccess;
/*     */ import mzm.gsp.foolsday.confbean.FoolsDayConsts;
/*     */ import mzm.gsp.item.main.BasicItem;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.item.main.ItemStoreEnum;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.util.CommonUtils;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.FoolsDayInfo;
/*     */ import xbean.Pod;
/*     */ import xbean.RoleFoolsDayInfo;
/*     */ import xtable.Basic;
/*     */ import xtable.Role_fools_day_infos;
/*     */ 
/*     */ public class PCOpenChest extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int grid;
/*     */   private final long makerid;
/*     */   
/*     */   public PCOpenChest(long roleid, int grid, long makerid)
/*     */   {
/*  38 */     this.roleid = roleid;
/*  39 */     this.grid = grid;
/*  40 */     this.makerid = makerid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  46 */     if ((this.grid < 0) || (this.makerid < 0L))
/*     */     {
/*     */ 
/*  49 */       onFail(-3, null);
/*  50 */       return false;
/*     */     }
/*  52 */     if (!FoolsDayManager.isFoolsDaySwitchOpenForRole(this.roleid))
/*     */     {
/*     */ 
/*  55 */       onFail(-1, null);
/*  56 */       return false;
/*     */     }
/*  58 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleid, 932, true))
/*     */     {
/*     */ 
/*  61 */       onFail(-2, null);
/*  62 */       return false;
/*     */     }
/*     */     
/*  65 */     if (RoleInterface.getLevel(this.roleid) < FoolsDayConsts.getInstance().OPEN_CHEST_MIN_LEVLE)
/*     */     {
/*     */ 
/*  68 */       onFail(5, null);
/*  69 */       return false;
/*     */     }
/*     */     
/*  72 */     String userid = RoleInterface.getUserId(this.roleid);
/*     */     
/*  74 */     lock(xtable.User.getTable(), Arrays.asList(new String[] { userid }));
/*     */     
/*  76 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/*     */     
/*  78 */     BasicItem chestItem = ItemInterface.getItem(this.roleid, this.grid);
/*  79 */     if ((chestItem == null) || (chestItem.getCfgId() != FoolsDayConsts.getInstance().CHEST_ITEM_CFG_ID) || (chestItem.getNumber() != 1))
/*     */     {
/*     */ 
/*     */ 
/*  83 */       onFail(-3, null);
/*  84 */       return false;
/*     */     }
/*  86 */     if (this.makerid != CommonUtils.getLong(chestItem.getExtra(ItemStoreEnum.MAKER_ID_HIGH).intValue(), chestItem.getExtra(ItemStoreEnum.MAKER_ID_LOW).intValue()))
/*     */     {
/*     */ 
/*     */ 
/*  90 */       onFail(-3, null);
/*  91 */       return false;
/*     */     }
/*  93 */     int buffid = chestItem.getExtra(ItemStoreEnum.BUFF_ID).intValue();
/*  94 */     int activityCfgid = chestItem.getExtra(ItemStoreEnum.ACTIVITY_CFG_ID).intValue();
/*     */     
/*  96 */     long now = DateTimeUtils.getCurrTimeInMillis();
/*  97 */     RoleFoolsDayInfo xRoleFoolsDayInfo = Role_fools_day_infos.get(Long.valueOf(this.roleid));
/*  98 */     if (xRoleFoolsDayInfo == null)
/*     */     {
/* 100 */       xRoleFoolsDayInfo = Pod.newRoleFoolsDayInfo();
/* 101 */       Role_fools_day_infos.insert(Long.valueOf(this.roleid), xRoleFoolsDayInfo);
/*     */     }
/* 103 */     FoolsDayInfo xFoolsDayInfo = (FoolsDayInfo)xRoleFoolsDayInfo.getFools_day_infos().get(Integer.valueOf(activityCfgid));
/* 104 */     if (xFoolsDayInfo == null)
/*     */     {
/* 106 */       xFoolsDayInfo = Pod.newFoolsDayInfo();
/* 107 */       xRoleFoolsDayInfo.getFools_day_infos().put(Integer.valueOf(activityCfgid), xFoolsDayInfo);
/* 108 */       xFoolsDayInfo.getAlternative_buff_cfg_ids().addAll(FoolsDayManager.getAlternativeBuffCfgids());
/* 109 */       xFoolsDayInfo.getOpen_chest_maker_ids().clear();
/* 110 */       xFoolsDayInfo.setOpen_chest_maker_ids_timestamp(now);
/*     */     }
/* 112 */     if (DateTimeUtils.needDailyReset(xFoolsDayInfo.getOpen_chest_maker_ids_timestamp(), now, 0))
/*     */     {
/* 114 */       xFoolsDayInfo.getOpen_chest_maker_ids().clear();
/* 115 */       xFoolsDayInfo.setOpen_chest_maker_ids_timestamp(now);
/*     */     }
/*     */     
/* 118 */     if (xFoolsDayInfo.getOpen_chest_maker_ids().size() >= FoolsDayConsts.getInstance().OPEN_CHEST_MAX_TIME)
/*     */     {
/*     */ 
/* 121 */       onFail(1, null);
/* 122 */       return false;
/*     */     }
/*     */     
/* 125 */     int openSameRoleChestTime = 0;
/* 126 */     for (Iterator i$ = xFoolsDayInfo.getOpen_chest_maker_ids().iterator(); i$.hasNext();) { long openChestMakerid = ((Long)i$.next()).longValue();
/*     */       
/* 128 */       if (openChestMakerid == this.makerid)
/*     */       {
/* 130 */         openSameRoleChestTime++;
/*     */       }
/*     */     }
/* 133 */     if (openSameRoleChestTime >= FoolsDayConsts.getInstance().OPEN_SAME_ROLE_CHEST_MAX_TIME)
/*     */     {
/*     */ 
/* 136 */       onFail(2, null);
/* 137 */       return false;
/*     */     }
/* 139 */     if (!ItemInterface.removeItemByGrid(this.roleid, 340600000, this.grid, new mzm.gsp.tlog.TLogArg(LogReason.FOOLS_DAY_COST_ITEM, activityCfgid)))
/*     */     {
/*     */ 
/*     */ 
/* 143 */       onFail(3, null);
/* 144 */       return false;
/*     */     }
/*     */     
/* 147 */     xFoolsDayInfo.getOpen_chest_maker_ids().add(Long.valueOf(this.makerid));
/* 148 */     xFoolsDayInfo.setOpen_chest_maker_ids_timestamp(now);
/* 149 */     xFoolsDayInfo.setPoint(xFoolsDayInfo.getPoint() + FoolsDayConsts.getInstance().OPEN_CHEST_POINT);
/*     */     
/*     */ 
/* 152 */     if (FoolsDayConsts.getInstance().MIN_AWARD_ID_1 > 0)
/*     */     {
/* 154 */       AwardModel awardModel = AwardInterface.awardFixAward(FoolsDayConsts.getInstance().MIN_AWARD_ID_1, userid, this.roleid, true, true, new AwardReason(LogReason.FOOLS_DAY_OPEN_CHEST_AWARD, activityCfgid));
/*     */       
/* 156 */       if (awardModel == null)
/*     */       {
/*     */ 
/* 159 */         onFail(4, null);
/* 160 */         return false;
/*     */       }
/*     */     }
/* 163 */     if (FoolsDayConsts.getInstance().MIN_AWARD_ID_2 > 0)
/*     */     {
/* 165 */       AwardModel awardModel = AwardInterface.awardFixAward(FoolsDayConsts.getInstance().MIN_AWARD_ID_2, userid, this.roleid, true, true, new AwardReason(LogReason.FOOLS_DAY_OPEN_CHEST_AWARD, activityCfgid));
/*     */       
/* 167 */       if (awardModel == null)
/*     */       {
/*     */ 
/* 170 */         onFail(4, null);
/* 171 */         return false;
/*     */       }
/*     */     }
/* 174 */     if (FoolsDayConsts.getInstance().MIN_AWARD_ID_3 > 0)
/*     */     {
/* 176 */       AwardModel awardModel = AwardInterface.awardFixAward(FoolsDayConsts.getInstance().MIN_AWARD_ID_3, userid, this.roleid, true, true, new AwardReason(LogReason.FOOLS_DAY_OPEN_CHEST_AWARD, activityCfgid));
/*     */       
/* 178 */       if (awardModel == null)
/*     */       {
/*     */ 
/* 181 */         onFail(4, null);
/* 182 */         return false;
/*     */       }
/*     */     }
/*     */     
/* 186 */     SOpenChestSuccess protocol = new SOpenChestSuccess();
/* 187 */     protocol.activity_cfg_id = activityCfgid;
/* 188 */     protocol.grid = this.grid;
/* 189 */     protocol.makerid = this.makerid;
/* 190 */     OnlineManager.getInstance().send(this.roleid, protocol);
/*     */     
/* 192 */     StringBuilder sb = new StringBuilder();
/* 193 */     sb.append(String.format("[foolsday]PCOpenChest.processImp@open chest success|roleid=%d|grid=%d|makerid=%d|buffid=%d|activity_cfg_id=%d|add_point=%d|current_point=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.grid), Long.valueOf(this.makerid), Integer.valueOf(buffid), Integer.valueOf(activityCfgid), Integer.valueOf(FoolsDayConsts.getInstance().OPEN_CHEST_POINT), Integer.valueOf(xFoolsDayInfo.getPoint()) }));
/*     */     
/*     */ 
/*     */ 
/* 197 */     FoolsDayManager.logger.info(sb.toString());
/*     */     
/* 199 */     long uuid = ((Long)new ArrayList(chestItem.getUuid()).get(0)).longValue();
/* 200 */     FoolsDayTlogManager.addOpenChestTlog(this.roleid, this.makerid, activityCfgid, chestItem.getCfgId(), uuid, buffid, FoolsDayConsts.getInstance().OPEN_CHEST_POINT, xFoolsDayInfo.getPoint());
/*     */     
/*     */ 
/* 203 */     mzm.gsp.buff.main.BuffInterface.installBuff(this.roleid, buffid);
/* 204 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(int res, Map<String, Object> extraInfo)
/*     */   {
/* 209 */     StringBuilder sb = new StringBuilder();
/* 210 */     sb.append(String.format("[foolsday]PCOpenChest.processImp@open chest fail|roleid=%d|grid=%d|makerid=%d|res=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.grid), Long.valueOf(this.makerid), Integer.valueOf(res) }));
/*     */     
/* 212 */     if (extraInfo != null)
/*     */     {
/* 214 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 216 */         sb.append("|").append((String)entry.getKey());
/* 217 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 220 */     FoolsDayManager.logger.info(sb.toString());
/* 221 */     if (res > 0)
/*     */     {
/* 223 */       SOpenChestFail protocol = new SOpenChestFail();
/* 224 */       protocol.res = res;
/* 225 */       OnlineManager.getInstance().sendAtOnce(this.roleid, protocol);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\foolsday\main\PCOpenChest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */