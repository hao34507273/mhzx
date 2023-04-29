/*     */ package mzm.gsp.item.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.item.SReplaceEquipSkillRes;
/*     */ import mzm.gsp.item.confbean.SEquipSkillRefresh;
/*     */ import mzm.gsp.item.confbean.SItemEquipCfg;
/*     */ import mzm.gsp.item.event.EquipSkillGet;
/*     */ import mzm.gsp.item.event.EquipSkillGetArg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.role.main.RoleOneByOneManager;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PReplaceEquipSkillReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int bagid;
/*     */   private final int key;
/*     */   private final int itemid;
/*     */   private String userid;
/*     */   
/*     */   public PReplaceEquipSkillReq(long roleid, int bagid, int key, int itemid)
/*     */   {
/*  33 */     this.roleid = roleid;
/*  34 */     this.bagid = bagid;
/*  35 */     this.key = key;
/*  36 */     this.itemid = itemid;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  43 */     if (!ItemModuleSwitchInterface.isEquipSkillRefreshSwitchOpenForRole(this.roleid))
/*     */     {
/*  45 */       return false;
/*     */     }
/*  47 */     if (!ItemManager.isRoleStateCanOperateItem(this.roleid))
/*     */     {
/*  49 */       String logStr = String.format("[item]PReplaceEquipSkillReq.processImp@role state can not operate item|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/*     */       
/*  51 */       ItemManager.logger.info(logStr);
/*  52 */       return false;
/*     */     }
/*     */     
/*  55 */     if ((this.bagid != 340600000) && (this.bagid != 340600001))
/*     */     {
/*  57 */       String logstr = String.format("[item]PReplaceEquipSkillReq.processImp@bagid error|roleid=%d|bagid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.bagid) });
/*     */       
/*  59 */       ItemManager.logger.error(logstr);
/*  60 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  64 */     this.userid = RoleInterface.getUserId(this.roleid);
/*  65 */     lock(User.getTable(), Arrays.asList(new String[] { this.userid }));
/*     */     
/*     */ 
/*  68 */     RoleItemBag itemBag = ItemManager.getRoleItemBag(this.roleid);
/*     */     
/*  70 */     RoleItemBag equipBag = ItemManager.getBag(this.roleid, this.bagid);
/*     */     
/*  72 */     if ((itemBag == null) || (equipBag == null))
/*     */     {
/*  74 */       String logstr = String.format("[item]PReplaceEquipSkillReq.processImp@bagid null|roleid=%d|bagid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.bagid) });
/*     */       
/*  76 */       ItemManager.logger.error(logstr);
/*  77 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  81 */     BasicItem basicItem = equipBag.get(this.key);
/*  82 */     if ((basicItem == null) || (!(basicItem instanceof EquipmentItem)))
/*     */     {
/*  84 */       int itemId = basicItem == null ? 0 : basicItem.getCfgId();
/*  85 */       String logstr = String.format("[item]PReplaceEquipSkillReq.processImp@item key error,not equipment|roleid=%d|key=%d|itemid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.key), Integer.valueOf(itemId) });
/*     */       
/*     */ 
/*  88 */       ItemManager.logger.error(logstr);
/*  89 */       return false;
/*     */     }
/*  91 */     if (basicItem.getCfgId() != this.itemid)
/*     */     {
/*  93 */       return false;
/*     */     }
/*  95 */     EquipmentItem equipmentItem = (EquipmentItem)basicItem;
/*     */     
/*  97 */     SItemEquipCfg itemEquipCfg = SItemEquipCfg.get(equipmentItem.getCfgId());
/*  98 */     if (itemEquipCfg == null)
/*     */     {
/* 100 */       String logstr = String.format("[item]PReplaceEquipSkillReq.processImp@item cfg error,not equipment|roleid=%d|uuid=%d|key=%d|bagid=%d|itemid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(equipmentItem.getTlogUuid()), Integer.valueOf(this.key), Integer.valueOf(this.bagid), Integer.valueOf(equipmentItem.getCfgId()) });
/*     */       
/*     */ 
/* 103 */       ItemManager.logger.error(logstr);
/* 104 */       return false;
/*     */     }
/*     */     
/* 107 */     SEquipSkillRefresh sEquipSkillRefresh = SEquipSkillRefresh.get(itemEquipCfg.useLevel);
/* 108 */     if (sEquipSkillRefresh == null)
/*     */     {
/* 110 */       String logstr = String.format("[item]PReplaceEquipSkillReq.processImp@sEquipSkillRefresh null,use level error|roleid=%d|uuid=%d|key=%d|bagid=%d|itemid=%d|uselevel=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(equipmentItem.getTlogUuid()), Integer.valueOf(this.key), Integer.valueOf(this.bagid), Integer.valueOf(equipmentItem.getCfgId()), Integer.valueOf(itemEquipCfg.useLevel) });
/*     */       
/*     */ 
/* 113 */       ItemManager.logger.error(logstr);
/* 114 */       return false;
/*     */     }
/*     */     
/* 117 */     Integer hasSkill = equipmentItem.getExtra(ItemStoreEnum.EQUIP_SKILL);
/* 118 */     if (hasSkill == null)
/*     */     {
/* 120 */       return false;
/*     */     }
/*     */     
/* 123 */     Integer tempSkill = equipmentItem.getExtra(ItemStoreEnum.EQUIP_SKILL_TEMP);
/* 124 */     if (tempSkill == null)
/*     */     {
/* 126 */       return false;
/*     */     }
/*     */     
/* 129 */     equipmentItem.setExtra(ItemStoreEnum.EQUIP_SKILL, tempSkill.intValue());
/* 130 */     equipmentItem.setState(1);
/* 131 */     equipmentItem.removeExtra(ItemStoreEnum.EQUIP_SKILL_TEMP);
/*     */     
/* 133 */     String logStr = String.format("[item]PReplaceEquipSkillReq.processImp@equip generate skill|itemid=%d|uuid=%d|old_skillid=%d|new_skillid=%d|bagid=%d|key=%d", new Object[] { Integer.valueOf(this.itemid), Long.valueOf(equipmentItem.getTlogUuid()), Integer.valueOf(hasSkill.intValue()), Integer.valueOf(tempSkill.intValue()), Integer.valueOf(this.bagid), Integer.valueOf(this.key) });
/*     */     
/*     */ 
/* 136 */     ItemManager.logger.info(logStr);
/*     */     
/* 138 */     SReplaceEquipSkillRes res = new SReplaceEquipSkillRes();
/* 139 */     ItemManager.fillInItemInfoBean(res.iteminfo, equipmentItem.getItem());
/* 140 */     OnlineManager.getInstance().send(this.roleid, res);
/* 141 */     tlogEquipskillreplace(equipmentItem, hasSkill.intValue(), tempSkill.intValue());
/*     */     
/* 143 */     TriggerEventsManger.getInstance().triggerEvent(new EquipSkillGet(), new EquipSkillGetArg(this.roleid, this.itemid, tempSkill.intValue()), RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(this.roleid)));
/*     */     
/*     */ 
/*     */ 
/* 147 */     return true;
/*     */   }
/*     */   
/*     */   void tlogEquipskillreplace(EquipmentItem equipmentItem, int oldSkill, int newSkill)
/*     */   {
/* 152 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 153 */     int rolelevel = RoleInterface.getLevel(this.roleid);
/* 154 */     String userId = RoleInterface.getUserId(this.roleid);
/*     */     
/* 156 */     Object[] columnns = { vGameIP, userId, Long.valueOf(this.roleid), Integer.valueOf(rolelevel), Long.valueOf(equipmentItem.getTlogUuid()), Integer.valueOf(equipmentItem.getCfgId()), Integer.valueOf(oldSkill), Integer.valueOf(newSkill) };
/*     */     
/* 158 */     TLogManager.getInstance().addLog(this.roleid, "Equipskillreplace", columnns);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\PReplaceEquipSkillReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */