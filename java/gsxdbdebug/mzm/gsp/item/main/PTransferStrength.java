/*     */ package mzm.gsp.item.main;
/*     */ 
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.item.confbean.SItemEquipCfg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class PTransferStrength
/*     */   extends LogicProcedure
/*     */ {
/*     */   private long roleid;
/*     */   private Set<Long> uuids;
/*     */   
/*     */   public PTransferStrength(long roleid, Set<Long> uuids)
/*     */   {
/*  18 */     this.roleid = roleid;
/*  19 */     this.uuids = uuids;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  25 */     if (!ItemModuleSwitchInterface.isEquipChuanLinSwitchOpenForRole(this.roleid))
/*     */     {
/*  27 */       return false;
/*     */     }
/*  29 */     if (!ItemManager.isRoleStateCanOperateItem(this.roleid))
/*     */     {
/*  31 */       String logStr = String.format("[item]PTransferStrength.processImp@role state can not operate item|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/*     */       
/*  33 */       ItemManager.logger.info(logStr);
/*  34 */       return false;
/*     */     }
/*  36 */     if ((this.uuids == null) || (this.uuids.isEmpty()))
/*     */     {
/*  38 */       String logStr = String.format("[item]PTransferStrength.processImpl@uuids is empty|roleId=%d", new Object[] { Long.valueOf(this.roleid) });
/*  39 */       ItemManager.logger.info(logStr);
/*     */       
/*  41 */       return false;
/*     */     }
/*  43 */     RoleItemBag bag = ItemManager.getRoleItemBag(this.roleid);
/*  44 */     RoleEquipBag equipBag = ItemManager.getRoleEquipBag(this.roleid);
/*  45 */     if ((bag == null) || (equipBag == null))
/*     */     {
/*  47 */       return false;
/*     */     }
/*  49 */     if (this.uuids.size() > equipBag.getCapacity())
/*     */     {
/*  51 */       String logStr = String.format("[item]PTransferStrength.processImpl@uuids size error|roleId=%d|size=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.uuids.size()) });
/*     */       
/*  53 */       ItemManager.logger.info(logStr);
/*     */       
/*  55 */       return false;
/*     */     }
/*  57 */     Set<Long> useduuids = new HashSet();
/*  58 */     for (Iterator i$ = this.uuids.iterator(); i$.hasNext();) { long uuid = ((Long)i$.next()).longValue();
/*     */       
/*  60 */       if (useduuids.contains(Long.valueOf(uuid)))
/*     */       {
/*  62 */         return false;
/*     */       }
/*  64 */       BasicItem srcitem = bag.getItemByUuid(uuid);
/*     */       
/*  66 */       if ((srcitem == null) || (!(srcitem instanceof EquipmentItem)))
/*     */       {
/*  68 */         String logStr = String.format("[item]PTransferStrength.processImpl@srcitem error|roleId=%d|uuid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(uuid) });
/*     */         
/*  70 */         ItemManager.logger.info(logStr);
/*     */         
/*  72 */         return false;
/*     */       }
/*     */       
/*  75 */       EquipmentItem srcEquipmentItem = (EquipmentItem)srcitem;
/*     */       
/*  77 */       SItemEquipCfg itemEquipCfg = SItemEquipCfg.get(srcEquipmentItem.getCfgId());
/*  78 */       if (itemEquipCfg == null)
/*     */       {
/*  80 */         String logStr = String.format("[item]PTransferStrength.processImpl@itemEquipCfg null|roleId=%d|uuid=%d|itemId=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(uuid), Integer.valueOf(srcEquipmentItem.getCfgId()) });
/*     */         
/*     */ 
/*  83 */         ItemManager.logger.info(logStr);
/*     */         
/*  85 */         return false;
/*     */       }
/*  87 */       BasicItem desitem = equipBag.get(itemEquipCfg.wearpos);
/*  88 */       if ((desitem == null) || (!(desitem instanceof EquipmentItem)))
/*     */       {
/*  90 */         String logStr = String.format("[item]PTransferStrength.processImpl@desitem error|roleId=%d|wearpos=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(itemEquipCfg.wearpos) });
/*     */         
/*  92 */         ItemManager.logger.info(logStr);
/*  93 */         return false;
/*     */       }
/*     */       
/*  96 */       EquipmentItem desEquipmentItem = (EquipmentItem)desitem;
/*  97 */       SItemEquipCfg desitemEquipCfg = SItemEquipCfg.get(desEquipmentItem.getCfgId());
/*  98 */       if (desitemEquipCfg == null)
/*     */       {
/* 100 */         String logStr = String.format("[item]PTransferStrength.processImpl@desitemEquipCfg null|roleId=%d|uuid=%d|itemId=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(uuid), Integer.valueOf(desEquipmentItem.getCfgId()) });
/*     */         
/*     */ 
/* 103 */         ItemManager.logger.info(logStr);
/* 104 */         return false;
/*     */       }
/*     */       
/* 107 */       if (desEquipmentItem.getStrengthLevel() >= srcEquipmentItem.getStrengthLevel())
/*     */       {
/* 109 */         String logStr = String.format("[item]PTransferStrength.processImpl@strength level error|roleId=%d|desStrengthLevel=%d|srcStrengthLevel=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(desEquipmentItem.getStrengthLevel()), Integer.valueOf(srcEquipmentItem.getStrengthLevel()) });
/*     */         
/*     */ 
/* 112 */         ItemManager.logger.info(logStr);
/* 113 */         return false;
/*     */       }
/* 115 */       boolean ret = ItemInterface.canTransferStrengthLevel(this.roleid, itemEquipCfg, desitemEquipCfg, true);
/* 116 */       if (!ret)
/*     */       {
/* 118 */         String logStr = String.format("[item]PTransferStrength.processImpl@equip level error|roleId=%d|src_strength_level=%d|des_strength_level=%d|src_uuid=%d|des_uuid=%d|src_itemid=%d|des_itemid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(srcEquipmentItem.getStrengthLevel()), Integer.valueOf(desEquipmentItem.getStrengthLevel()), Long.valueOf(uuid), Long.valueOf(desEquipmentItem.getTlogUuid()), Integer.valueOf(itemEquipCfg.id), Integer.valueOf(desitemEquipCfg.id) });
/*     */         
/*     */ 
/*     */ 
/* 122 */         ItemManager.logger.info(logStr);
/* 123 */         return false;
/*     */       }
/* 125 */       int oldlevel = desEquipmentItem.getStrengthLevel();
/* 126 */       String oldExtraQiLinString = desEquipmentItem.getAccumulationQiLinExtraString();
/* 127 */       ItemManager.transferEquipAccumulationQilinInfo(srcEquipmentItem, desEquipmentItem);
/* 128 */       useduuids.add(Long.valueOf(uuid));
/*     */       
/* 130 */       ItemManager.tlogEquiptransferlin(this.roleid, desEquipmentItem.getCfgId(), desEquipmentItem.getStrengthLevel(), oldlevel, srcEquipmentItem.getCfgId(), desEquipmentItem.getTlogUuid(), srcEquipmentItem.getTlogUuid(), oldExtraQiLinString, desEquipmentItem.getAccumulationQiLinExtraString());
/*     */       
/*     */ 
/*     */ 
/* 134 */       String logStr = String.format("[item]PTransferStrength.processImpl@transfer strengthLevel success|roleId=%d|itemId=%d|oldDesStrengthLevel=%d|newDesStrengthLevel=%d|srcItemCfgId=%d|srcUuid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(desEquipmentItem.getCfgId()), Integer.valueOf(oldlevel), Integer.valueOf(desEquipmentItem.getStrengthLevel()), Integer.valueOf(itemEquipCfg.id), Long.valueOf(uuid) });
/*     */       
/*     */ 
/* 137 */       ItemManager.logger.info(logStr);
/*     */     }
/*     */     
/* 140 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\PTransferStrength.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */