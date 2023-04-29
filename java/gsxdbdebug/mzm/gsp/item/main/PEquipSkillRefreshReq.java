/*     */ package mzm.gsp.item.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.HashSet;
/*     */ import java.util.Set;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.item.SEquipSkillRefreshRes;
/*     */ import mzm.gsp.item.confbean.SEquipSkillRefresh;
/*     */ import mzm.gsp.item.confbean.SItemEquipCfg;
/*     */ import mzm.gsp.item.event.EquipSkillRefresh;
/*     */ import mzm.gsp.item.event.EquipSkillRefreshArg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.qingfu.main.CostType;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.role.main.RoleOneByOneManager;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PEquipSkillRefreshReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int bagid;
/*     */   private final int key;
/*     */   private final int itemid;
/*     */   private String userid;
/*     */   
/*     */   public PEquipSkillRefreshReq(long roleid, int bagid, int key, int itemid)
/*     */   {
/*  38 */     this.roleid = roleid;
/*  39 */     this.bagid = bagid;
/*  40 */     this.key = key;
/*  41 */     this.itemid = itemid;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  48 */     if (!ItemModuleSwitchInterface.isEquipSkillRefreshSwitchOpenForRole(this.roleid))
/*     */     {
/*  50 */       return false;
/*     */     }
/*  52 */     if (!ItemManager.isRoleStateCanOperateItem(this.roleid))
/*     */     {
/*  54 */       String logStr = String.format("[item]PEquipSkillRefreshReq.processImp@role state can not operate item|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/*     */       
/*  56 */       ItemManager.logger.info(logStr);
/*  57 */       return false;
/*     */     }
/*     */     
/*  60 */     if ((this.bagid != 340600000) && (this.bagid != 340600001))
/*     */     {
/*  62 */       String logstr = String.format("[item]PEquipSkillRefreshReq.processImp@bagid error|roleid=%d|bagid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.bagid) });
/*     */       
/*  64 */       ItemManager.logger.error(logstr);
/*  65 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  69 */     this.userid = RoleInterface.getUserId(this.roleid);
/*  70 */     lock(User.getTable(), Arrays.asList(new String[] { this.userid }));
/*     */     
/*     */ 
/*  73 */     RoleItemBag itemBag = ItemManager.getRoleItemBag(this.roleid);
/*     */     
/*  75 */     RoleItemBag equipBag = ItemManager.getBag(this.roleid, this.bagid);
/*     */     
/*  77 */     if ((itemBag == null) || (equipBag == null))
/*     */     {
/*  79 */       String logstr = String.format("[item]PEquipSkillRefreshReq.processImp@bagid null|roleid=%d|bagid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.bagid) });
/*     */       
/*  81 */       ItemManager.logger.error(logstr);
/*  82 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  86 */     BasicItem basicItem = equipBag.get(this.key);
/*  87 */     if ((basicItem == null) || (!(basicItem instanceof EquipmentItem)))
/*     */     {
/*  89 */       int itemId = basicItem == null ? 0 : basicItem.getCfgId();
/*  90 */       String logstr = String.format("[item]PEquipSkillRefreshReq.processImp@item key error,not equipment|roleid=%d|key=%d|itemid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.key), Integer.valueOf(itemId) });
/*     */       
/*     */ 
/*  93 */       ItemManager.logger.error(logstr);
/*  94 */       return false;
/*     */     }
/*  96 */     if (basicItem.getCfgId() != this.itemid)
/*     */     {
/*  98 */       return false;
/*     */     }
/* 100 */     Set<Integer> toRemoveSkillids = new HashSet();
/* 101 */     EquipmentItem equipmentItem = (EquipmentItem)basicItem;
/* 102 */     Integer hasSkill = equipmentItem.getExtra(ItemStoreEnum.EQUIP_SKILL);
/* 103 */     if (hasSkill == null)
/*     */     {
/* 105 */       return false;
/*     */     }
/* 107 */     toRemoveSkillids.add(hasSkill);
/* 108 */     Integer hasTmpSkill = equipmentItem.getExtra(ItemStoreEnum.EQUIP_SKILL_TEMP);
/* 109 */     if (hasTmpSkill == null)
/*     */     {
/* 111 */       hasTmpSkill = Integer.valueOf(0);
/*     */     }
/*     */     else
/*     */     {
/* 115 */       toRemoveSkillids.add(hasTmpSkill);
/*     */     }
/*     */     
/* 118 */     SItemEquipCfg itemEquipCfg = SItemEquipCfg.get(equipmentItem.getCfgId());
/* 119 */     if (itemEquipCfg == null)
/*     */     {
/* 121 */       String logstr = String.format("[item]PEquipSkillRefreshReq.processImp@item cfg error,not equipment|roleid=%d|uuid=%d|key=%d|bagid=%d|itemid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(equipmentItem.getTlogUuid()), Integer.valueOf(this.key), Integer.valueOf(this.bagid), Integer.valueOf(equipmentItem.getCfgId()) });
/*     */       
/*     */ 
/* 124 */       ItemManager.logger.error(logstr);
/* 125 */       return false;
/*     */     }
/* 127 */     SEquipSkillRefresh sEquipSkillRefresh = SEquipSkillRefresh.get(itemEquipCfg.useLevel);
/* 128 */     if (sEquipSkillRefresh == null)
/*     */     {
/* 130 */       String logstr = String.format("[item]PEquipSkillRefreshReq.processImp@sEquipSkillRefresh null,use level error|roleid=%d|uuid=%d|key=%d|bagid=%d|itemid=%d|uselevel=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(equipmentItem.getTlogUuid()), Integer.valueOf(this.key), Integer.valueOf(this.bagid), Integer.valueOf(equipmentItem.getCfgId()), Integer.valueOf(itemEquipCfg.useLevel) });
/*     */       
/*     */ 
/* 133 */       ItemManager.logger.error(logstr);
/* 134 */       return false;
/*     */     }
/* 136 */     if ((sEquipSkillRefresh.needItemNum <= 0) || (sEquipSkillRefresh.needMoneyNum <= 0))
/*     */     {
/* 138 */       String logstr = String.format("[item]PEquipSkillRefreshReq.processImp@need money,item error|roleid=%d|uuid=%d|key=%d|bagid=%d|itemid=%d|needItemNum=%d|needMoneyNum=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(equipmentItem.getTlogUuid()), Integer.valueOf(this.key), Integer.valueOf(this.bagid), Integer.valueOf(equipmentItem.getCfgId()), Integer.valueOf(sEquipSkillRefresh.needItemNum), Integer.valueOf(sEquipSkillRefresh.needMoneyNum) });
/*     */       
/*     */ 
/*     */ 
/* 142 */       ItemManager.logger.error(logstr);
/* 143 */       return false;
/*     */     }
/* 145 */     TLogArg logArg = new TLogArg(LogReason.EQUIP_SKILL_REFRESH, this.itemid);
/*     */     
/* 147 */     int num = ItemInterface.getItemNumberById(this.roleid, sEquipSkillRefresh.needViceItemId);
/* 148 */     int cutViceNum = Math.min(num, sEquipSkillRefresh.needItemNum);
/* 149 */     if (cutViceNum > 0)
/*     */     {
/* 151 */       boolean ret = ItemInterface.removeItemById(this.roleid, sEquipSkillRefresh.needViceItemId, cutViceNum, logArg);
/* 152 */       if (!ret)
/*     */       {
/* 154 */         String logstr = String.format("[item]PEquipSkillRefreshReq.processImp@cut needViceItemId error|roleid=%d|uuid=%d|key=%d|bagid=%d|itemid=%d|cut_itemid=%d|cut_num=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(equipmentItem.getTlogUuid()), Integer.valueOf(this.key), Integer.valueOf(this.bagid), Integer.valueOf(equipmentItem.getCfgId()), Integer.valueOf(sEquipSkillRefresh.needViceItemId), Integer.valueOf(cutViceNum) });
/*     */         
/*     */ 
/*     */ 
/* 158 */         ItemManager.logger.error(logstr);
/* 159 */         return false;
/*     */       }
/* 161 */       int delta = sEquipSkillRefresh.needItemNum - cutViceNum;
/* 162 */       if (delta > 0)
/*     */       {
/* 164 */         ItemOperateResult result = ItemInterface.removeItemsWithBindFirst(this.roleid, sEquipSkillRefresh.needMainItemId, delta, logArg);
/*     */         
/* 166 */         if (!result.success())
/*     */         {
/* 168 */           String logstr = String.format("[item]PEquipSkillRefreshReq.processImp@cut needMainItemId error|roleid=%d|uuid=%d|key=%d|bagid=%d|itemid=%d|cut_itemid=%d|cut_num=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(equipmentItem.getTlogUuid()), Integer.valueOf(this.key), Integer.valueOf(this.bagid), Integer.valueOf(equipmentItem.getCfgId()), Integer.valueOf(sEquipSkillRefresh.needMainItemId), Integer.valueOf(delta) });
/*     */           
/*     */ 
/*     */ 
/* 172 */           ItemManager.logger.error(logstr);
/* 173 */           return false;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     else
/*     */     {
/* 180 */       ItemOperateResult result = ItemInterface.removeItemsWithBindFirst(this.roleid, sEquipSkillRefresh.needMainItemId, sEquipSkillRefresh.needItemNum, logArg);
/*     */       
/* 182 */       if (!result.success())
/*     */       {
/* 184 */         String logstr = String.format("[item]PEquipSkillRefreshReq.processImp@cut needMainItemId error|roleid=%d|uuid=%d|key=%d|bagid=%d|itemid=%d|cut_itemid=%d|cut_num=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(equipmentItem.getTlogUuid()), Integer.valueOf(this.key), Integer.valueOf(this.bagid), Integer.valueOf(equipmentItem.getCfgId()), Integer.valueOf(sEquipSkillRefresh.needMainItemId), Integer.valueOf(sEquipSkillRefresh.needItemNum) });
/*     */         
/*     */ 
/*     */ 
/* 188 */         ItemManager.logger.error(logstr);
/* 189 */         return false;
/*     */       }
/*     */     }
/*     */     
/* 193 */     boolean ret = ItemManager.cutMoney(this.userid, this.roleid, LogReason.EQUIP_SKILL_REFRESH, this.itemid, sEquipSkillRefresh.moneyType, sEquipSkillRefresh.needMoneyNum, CostType.COST_BIND_FIRST_EQUIP_SKILL_REFRESH);
/*     */     
/* 195 */     if (!ret)
/*     */     {
/* 197 */       String logstr = String.format("[item]PEquipSkillRefreshReq.processImp@cut money error|roleid=%d|uuid=%d|key=%d|bagid=%d|itemid=%d|money_type=%d|cut_num=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(equipmentItem.getTlogUuid()), Integer.valueOf(this.key), Integer.valueOf(this.bagid), Integer.valueOf(equipmentItem.getCfgId()), Integer.valueOf(sEquipSkillRefresh.moneyType), Integer.valueOf(sEquipSkillRefresh.needMoneyNum) });
/*     */       
/*     */ 
/*     */ 
/* 201 */       ItemManager.logger.error(logstr);
/* 202 */       return false;
/*     */     }
/*     */     
/* 205 */     int skillid = ItemConfigManager.randomEquipSkill(itemEquipCfg.skillid, toRemoveSkillids);
/* 206 */     if (skillid > 0)
/*     */     {
/* 208 */       equipmentItem.setExtra(ItemStoreEnum.EQUIP_SKILL_TEMP, skillid);
/* 209 */       equipmentItem.setState(1);
/*     */       
/* 211 */       String logStr = String.format("[item]PEquipSkillRefreshReq.processImp@equip generate skill|itemid=%d|uuid=%d|has_skillid=%d|old_skillid=%d|new_skillid=%d|bagid=%d|key=%d", new Object[] { Integer.valueOf(this.itemid), Long.valueOf(equipmentItem.getTlogUuid()), Integer.valueOf(hasTmpSkill.intValue()), Integer.valueOf(hasSkill.intValue()), Integer.valueOf(skillid), Integer.valueOf(this.bagid), Integer.valueOf(this.key) });
/*     */       
/*     */ 
/* 214 */       ItemManager.logger.info(logStr);
/*     */       
/* 216 */       SEquipSkillRefreshRes res = new SEquipSkillRefreshRes();
/* 217 */       ItemManager.fillInItemInfoBean(res.iteminfo, equipmentItem.getItem());
/* 218 */       OnlineManager.getInstance().send(this.roleid, res);
/*     */       
/* 220 */       TriggerEventsManger.getInstance().triggerEvent(new EquipSkillRefresh(), new EquipSkillRefreshArg(this.roleid, this.itemid), RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(this.roleid)));
/*     */       
/*     */ 
/*     */ 
/* 224 */       tlogEquipskillrefresh(hasSkill.intValue(), equipmentItem, hasTmpSkill.intValue(), skillid);
/* 225 */       return true;
/*     */     }
/*     */     
/*     */ 
/* 229 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   void tlogEquipskillrefresh(int hasSkill, EquipmentItem equipmentItem, int oldSkill, int newSkill)
/*     */   {
/* 236 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 237 */     int rolelevel = RoleInterface.getLevel(this.roleid);
/* 238 */     String userId = RoleInterface.getUserId(this.roleid);
/*     */     
/* 240 */     Object[] columnns = { vGameIP, userId, Long.valueOf(this.roleid), Integer.valueOf(rolelevel), Long.valueOf(equipmentItem.getTlogUuid()), Integer.valueOf(equipmentItem.getCfgId()), Integer.valueOf(hasSkill), Integer.valueOf(oldSkill), Integer.valueOf(newSkill) };
/*     */     
/* 242 */     TLogManager.getInstance().addLog(this.roleid, "Equipskillrefresh", columnns);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\PEquipSkillRefreshReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */