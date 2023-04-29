/*     */ package mzm.gsp.item.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import mzm.gsp.item.CEquipTransferHun;
/*     */ import mzm.gsp.item.ExtraProBean;
/*     */ import mzm.gsp.item.SEquipTransferHunRes;
/*     */ import mzm.gsp.item.confbean.EquipItemCfgConsts;
/*     */ import mzm.gsp.item.confbean.SEquipTransferInherit;
/*     */ import mzm.gsp.item.confbean.SItemEquipCfg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Item;
/*     */ import xbean.XExtraProBean;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PEquipTransferHun
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int srcEquipKey;
/*     */   private final int desBagId;
/*     */   private final int desEquipKey;
/*     */   
/*     */   public PEquipTransferHun(long roleid, CEquipTransferHun c)
/*     */   {
/*  36 */     this.roleid = roleid;
/*  37 */     this.srcEquipKey = c.srceequipkey;
/*  38 */     this.desBagId = c.desequipbagid;
/*  39 */     this.desEquipKey = c.desequipkey;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  46 */     if (!ItemModuleSwitchInterface.isEquipZhuanhunSwitchOpenForRole(this.roleid))
/*     */     {
/*  48 */       return false;
/*     */     }
/*  50 */     if (!ItemManager.isRoleStateCanOperateItem(this.roleid))
/*     */     {
/*  52 */       String logStr = String.format("[item]PEquipTransferHun.processImp@role state can not operate item|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/*     */       
/*  54 */       ItemManager.logger.info(logStr);
/*  55 */       return false;
/*     */     }
/*  57 */     int userLevel = RoleInterface.getLevel(this.roleid);
/*  58 */     if (userLevel < EquipItemCfgConsts.getInstance().EQUIP_FUHUN_OPEN_LEVEL)
/*     */     {
/*  60 */       String logstr = String.format("[item]PEquipTransferHun.processImp@rolelevel error|roleid=%d|rolelevel=%d|openlevel=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(userLevel), Integer.valueOf(EquipItemCfgConsts.getInstance().EQUIP_FUHUN_OPEN_LEVEL) });
/*     */       
/*     */ 
/*  63 */       ItemManager.logger.error(logstr);
/*  64 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  68 */     RoleItemBag itemBag = ItemManager.getBag(this.roleid, 340600000);
/*  69 */     if (itemBag == null)
/*     */     {
/*  71 */       String logstr = String.format("[item]PEquipTransferHun.processImp@role bag error|roleid=%d|bagid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(340600000) });
/*     */       
/*  73 */       ItemManager.logger.error(logstr);
/*  74 */       ItemManager.sendWrongInfo(this.roleid, 430, new String[0]);
/*  75 */       return false;
/*     */     }
/*     */     
/*  78 */     RoleItemBag desBag = ItemManager.getBag(this.roleid, this.desBagId);
/*  79 */     if (desBag == null)
/*     */     {
/*  81 */       String logstr = String.format("[item]PEquipTransferHun.processImp@role bag error|roleid=%d|bagid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.desBagId) });
/*     */       
/*  83 */       ItemManager.logger.error(logstr);
/*  84 */       ItemManager.sendWrongInfo(this.roleid, 430, new String[0]);
/*  85 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  89 */     BasicItem srcBasicItem = itemBag.get(this.srcEquipKey);
/*     */     
/*  91 */     if (srcBasicItem == null)
/*     */     {
/*  93 */       String logstr = String.format("[item]PEquipTransferHun.processImp@srcBasicItem null|roleid=%d|key=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.srcEquipKey) });
/*     */       
/*  95 */       ItemManager.logger.error(logstr);
/*  96 */       ItemManager.sendWrongInfo(this.roleid, 431, new String[0]);
/*  97 */       return false;
/*     */     }
/*  99 */     BasicItem desBasicItem = desBag.get(this.desEquipKey);
/* 100 */     if (desBasicItem == null)
/*     */     {
/* 102 */       String logstr = String.format("[item]PEquipTransferHun.processImp@desBasicItem null|roleid=%d|key=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.desEquipKey) });
/*     */       
/* 104 */       ItemManager.logger.error(logstr);
/* 105 */       ItemManager.sendWrongInfo(this.roleid, 431, new String[0]);
/* 106 */       return false;
/*     */     }
/* 108 */     if ((!(srcBasicItem instanceof EquipmentItem)) || (!(desBasicItem instanceof EquipmentItem)))
/*     */     {
/* 110 */       ItemManager.sendWrongInfo(this.roleid, 431, new String[0]);
/* 111 */       return false;
/*     */     }
/*     */     
/* 114 */     EquipmentItem srcEquipmentItem = (EquipmentItem)srcBasicItem;
/* 115 */     EquipmentItem desEquipmentItem = (EquipmentItem)desBasicItem;
/*     */     
/*     */ 
/* 118 */     if (srcEquipmentItem.getSuperEquipmentStage() > 0)
/*     */     {
/* 120 */       String logstr = String.format("PEquipTransferHun.processImp()@srcEquipmentItem.isSuperEquipment|roleid=%d|key=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.srcEquipKey) });
/*     */       
/* 122 */       ItemManager.logger.error(logstr);
/* 123 */       return false;
/*     */     }
/*     */     
/* 126 */     boolean checkResult = (checkEquip(srcEquipmentItem, desEquipmentItem)) && (checkSliver(desEquipmentItem));
/* 127 */     if (!checkResult)
/*     */     {
/* 129 */       return false;
/*     */     }
/*     */     
/* 132 */     TLogArg tLogArg = new TLogArg(LogReason.EQUIP_FUHUN_REM, srcEquipmentItem.getCfgId());
/* 133 */     SItemEquipCfg desItemEquipCfg = SItemEquipCfg.get(desEquipmentItem.getCfgId());
/* 134 */     SEquipTransferInherit equipTransferInherit = ItemConfigManager.getSEquipTransferHun(desItemEquipCfg.useLevel);
/*     */     
/* 136 */     if (!RoleInterface.cutSilver(this.roleid, equipTransferInherit.transferHunNeedSilver, tLogArg))
/*     */     {
/* 138 */       String logstr = String.format("[item]PEquipTransferHun.processImp@silver not enough|roleid=%d|needsilver=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(equipTransferInherit.transferHunNeedSilver) });
/*     */       
/* 140 */       ItemManager.logger.error(logstr);
/*     */       
/* 142 */       ItemManager.sendWrongInfo(this.roleid, 435, new String[0]);
/* 143 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 147 */     boolean ret = ItemInterface.removeItemByGrid(this.roleid, 340600000, this.srcEquipKey, tLogArg);
/* 148 */     if (!ret)
/*     */     {
/* 150 */       String logstr = String.format("[item]PEquipTransferHun.processImp@remove srcitem error|roleid=%d|srcEquipKey=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.srcEquipKey) });
/*     */       
/* 152 */       ItemManager.logger.error(logstr);
/*     */       
/* 154 */       ItemManager.sendWrongInfo(this.roleid, 440, new String[0]);
/* 155 */       return false;
/*     */     }
/* 157 */     List<XExtraProBean> oldExtraProBeans = desEquipmentItem.getCopyXExtraProBeans();
/* 158 */     int beforelevel = desEquipmentItem.getStrengthLevel();
/* 159 */     boolean r = doInherit(srcEquipmentItem, desEquipmentItem);
/*     */     
/* 161 */     ItemManager.logEquip(this.roleid, desEquipmentItem.getCfgId(), EquipmentLogStatus.EQUIP_CHUANGCHENG, null, new String[] { String.valueOf(srcEquipmentItem.getCfgId()) });
/*     */     
/*     */ 
/* 164 */     ItemManager.tlogEquipfuhun(this.roleid, desEquipmentItem.getCfgId(), desEquipmentItem.getStrengthLevel(), desEquipmentItem.getCopyXExtraProBeans(), beforelevel, oldExtraProBeans, srcEquipmentItem.getCfgId(), desEquipmentItem.getTlogUuid(), srcEquipmentItem.getTlogUuid());
/*     */     
/*     */ 
/*     */ 
/* 168 */     if (r)
/*     */     {
/* 170 */       String logstr = String.format("[item]PEquipTransferHun.processImp@equip transfer hun success|roleid=%d|srcEquipKey=%d|srccfgid=%d|desEquipKey=%d|descfgid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.srcEquipKey), Integer.valueOf(srcEquipmentItem.getCfgId()), Integer.valueOf(this.desEquipKey), Integer.valueOf(desEquipmentItem.getCfgId()) });
/*     */       
/*     */ 
/* 173 */       ItemManager.logger.info(logstr);
/*     */     }
/* 175 */     return r;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean checkEquip(EquipmentItem srcEquipmentItem, EquipmentItem desEquipmentItem)
/*     */   {
/* 186 */     SItemEquipCfg srcItemEquipCfg = SItemEquipCfg.get(srcEquipmentItem.getCfgId());
/* 187 */     SItemEquipCfg desItemEquipCfg = SItemEquipCfg.get(desEquipmentItem.getCfgId());
/* 188 */     if ((srcItemEquipCfg == null) || (desItemEquipCfg == null))
/*     */     {
/* 190 */       String logstr = String.format("[item]PEquipTransferHun.checkEquip@SItemEquipCfg null|roleid=%d|srccfgid=%d|descfgid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(srcEquipmentItem.getCfgId()), Integer.valueOf(desEquipmentItem.getCfgId()) });
/*     */       
/*     */ 
/* 193 */       ItemManager.logger.error(logstr);
/* 194 */       ItemManager.sendWrongInfo(this.roleid, 433, new String[0]);
/* 195 */       return false;
/*     */     }
/*     */     
/* 198 */     if (srcItemEquipCfg.wearpos != desItemEquipCfg.wearpos)
/*     */     {
/* 200 */       String logstr = String.format("[item]PEquipTransferHun.checkEquip@equip wearpos error|roleid=%d|srcwearpos=%d|deswearpos=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(srcItemEquipCfg.wearpos), Integer.valueOf(desItemEquipCfg.wearpos) });
/*     */       
/*     */ 
/* 203 */       ItemManager.logger.error(logstr);
/* 204 */       ItemManager.sendWrongInfo(this.roleid, 437, new String[0]);
/* 205 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 209 */     if (srcItemEquipCfg.useLevel > desItemEquipCfg.useLevel)
/*     */     {
/* 211 */       String logstr = String.format("[item]PEquipTransferHun.checkEquip@equip level error|roleid=%d|srcuselevel=%d|desuselevel=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(srcItemEquipCfg.useLevel), Integer.valueOf(desItemEquipCfg.useLevel) });
/*     */       
/*     */ 
/* 214 */       ItemManager.logger.error(logstr);
/* 215 */       ItemManager.sendWrongInfo(this.roleid, 439, new String[0]);
/* 216 */       return false;
/*     */     }
/*     */     
/* 219 */     if (srcEquipmentItem.getHunNum() <= 0)
/*     */     {
/* 221 */       String logstr = String.format("[item]PEquipTransferHun.checkEquip@serequip no hun error|roleid=%d|srccfgid=%d|hunnum=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(srcEquipmentItem.getCfgId()), Integer.valueOf(srcEquipmentItem.getHunNum()) });
/*     */       
/*     */ 
/* 224 */       ItemManager.logger.error(logstr);
/*     */       
/* 226 */       ItemManager.sendWrongInfo(this.roleid, 438, new String[0]);
/* 227 */       return false;
/*     */     }
/*     */     
/* 230 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean checkSliver(EquipmentItem desEquipmentItem)
/*     */   {
/* 241 */     SItemEquipCfg desItemEquipCfg = SItemEquipCfg.get(desEquipmentItem.getCfgId());
/* 242 */     SEquipTransferInherit equipTransferInherit = ItemConfigManager.getSEquipTransferHun(desItemEquipCfg.useLevel);
/* 243 */     if (equipTransferInherit == null)
/*     */     {
/* 245 */       String logstr = String.format("[item]PEquipTransferHun.checkSliver@SEquipTransferInherit null|roleid=%d|level=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(desItemEquipCfg.useLevel) });
/*     */       
/* 247 */       ItemManager.logger.error(logstr);
/* 248 */       return false;
/*     */     }
/*     */     
/* 251 */     long hasSilverNum = RoleInterface.getSilver(this.roleid);
/* 252 */     if (hasSilverNum < equipTransferInherit.transferHunNeedSilver)
/*     */     {
/* 254 */       String logstr = String.format("[item]PEquipTransferHun.checkEquip@silver not enough|roleid=%d|hassilver=%d|needsilver=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(hasSilverNum), Integer.valueOf(equipTransferInherit.transferHunNeedSilver) });
/*     */       
/*     */ 
/* 257 */       ItemManager.logger.error(logstr);
/* 258 */       ItemManager.sendWrongInfo(this.roleid, 435, new String[0]);
/* 259 */       return false;
/*     */     }
/*     */     
/* 262 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   private boolean doInherit(EquipmentItem srcEquipmentItem, EquipmentItem desEquipmentItem)
/*     */   {
/* 268 */     SEquipTransferHunRes res = new SEquipTransferHunRes();
/*     */     
/* 270 */     List<XExtraProBean> srcExtraProBeans = srcEquipmentItem.getCopyXExtraProBeans();
/*     */     
/* 272 */     if (!desEquipmentItem.resetExtraPro(srcExtraProBeans))
/*     */     {
/*     */ 
/* 275 */       String logstr = String.format("[item]PEquipTransferHun.doInherit@reset hun error|roleid=%d|descfgid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(desEquipmentItem.getCfgId()) });
/*     */       
/* 277 */       ItemManager.logger.error(logstr);
/* 278 */       return false;
/*     */     }
/*     */     
/* 281 */     for (XExtraProBean x : desEquipmentItem.getItem().getExtraprolist())
/*     */     {
/* 283 */       res.newexprolist.add(new ExtraProBean(x.getProtype(), x.getProvalue(), x.getIslock()));
/*     */     }
/*     */     
/* 286 */     OnlineManager.getInstance().send(this.roleid, res);
/*     */     
/* 288 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\PEquipTransferHun.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */