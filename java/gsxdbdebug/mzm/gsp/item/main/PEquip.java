/*     */ package mzm.gsp.item.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.item.SEquipRes;
/*     */ import mzm.gsp.item.confbean.SItemEquipCfg;
/*     */ import mzm.gsp.ocpequip.main.OcpEquipInterface;
/*     */ import mzm.gsp.ocpequip.main.TransferStrengthLevelBean;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.superequipment.main.SuperEquipmentInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class PEquip
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int key;
/*     */   
/*     */   public PEquip(long paramLong, int paramInt)
/*     */   {
/*  28 */     this.roleid = paramLong;
/*  29 */     this.key = paramInt;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  35 */     if (!ItemModuleSwitchInterface.isEquipOnSwitchOpenForRole(this.roleid)) {
/*  36 */       return false;
/*     */     }
/*  38 */     if (!ItemManager.isRoleStateCanOperateItem(this.roleid))
/*     */     {
/*  40 */       localObject1 = String.format("[item]PEquip.processImp@role state can not operate item|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/*  41 */       ItemManager.logger.info(localObject1);
/*  42 */       return false;
/*     */     }
/*  44 */     Object localObject1 = ItemManager.getRoleItemBag(this.roleid);
/*  45 */     RoleEquipBag localRoleEquipBag = ItemManager.getRoleEquipBag(this.roleid);
/*  46 */     if ((localObject1 == null) || (localRoleEquipBag == null))
/*     */     {
/*  48 */       ItemManager.sendWrongInfo(this.roleid, 610, new String[0]);
/*  49 */       return false;
/*     */     }
/*  51 */     BasicItem localBasicItem = ((RoleItemBag)localObject1).get(this.key);
/*  52 */     if ((localBasicItem == null) || (!(localBasicItem instanceof EquipmentItem)))
/*     */     {
/*  54 */       ItemManager.sendWrongInfo(this.roleid, 611, new String[0]);
/*  55 */       return false;
/*     */     }
/*  57 */     EquipmentItem localEquipmentItem1 = (EquipmentItem)localBasicItem;
/*  58 */     SItemEquipCfg localSItemEquipCfg = SItemEquipCfg.get(localEquipmentItem1.getCfgId());
/*  59 */     if (localSItemEquipCfg == null)
/*     */     {
/*  61 */       ItemManager.sendWrongInfo(this.roleid, 612, new String[0]);
/*  62 */       return false;
/*     */     }
/*  64 */     boolean bool1 = ItemInterface.checkEquipOnCondition(this.roleid, RoleInterface.getOccupationId(this.roleid), RoleInterface.getGender(this.roleid), localEquipmentItem1);
/*  65 */     if (!bool1) {
/*  66 */       return false;
/*     */     }
/*  68 */     SEquipRes localSEquipRes = new SEquipRes();
/*  69 */     Integer localInteger = localEquipmentItem1.getExtra(ItemStoreEnum.EQUIP_FLAG);
/*  70 */     Object localObject5; Object localObject6; if (localInteger == null)
/*     */     {
/*  72 */       localObject2 = null;
/*     */       
/*  74 */       boolean bool2 = true;
/*     */       
/*  76 */       localObject3 = localRoleEquipBag.get(localSItemEquipCfg.wearpos);
/*  77 */       long l1 = 0L;
/*  78 */       if (localObject3 != null)
/*     */       {
/*  80 */         localObject5 = (EquipmentItem)localObject3;
/*  81 */         l1 = ((EquipmentItem)localObject5).getTlogUuid();
/*  82 */         if ((SItemEquipCfg.get(((EquipmentItem)localObject5).getCfgId()).useLevel == 0) && (((EquipmentItem)localObject5).getStrengthLevel() <= 0) && (new PCSellItemReq(((EquipmentItem)localObject5).getFirstUuid().longValue(), 340600001, this.roleid, 1).call()))
/*     */         {
/*  84 */           bool2 = ItemInterface.moveItemIntoEquipBag(this.roleid, localEquipmentItem1.getFirstUuid().longValue());
/*  85 */           if (bool2)
/*     */           {
/*  87 */             localObject2 = OcpEquipInterface.transferStrengthFromOtherOcpBag(this.roleid, localSItemEquipCfg.wearpos, (EquipmentItem)localRoleEquipBag.get(localSItemEquipCfg.wearpos));
/*     */             
/*  89 */             OcpEquipInterface.transferSuperEquipmentDataFromOtherOcpBag(this.roleid, localSItemEquipCfg.wearpos, (EquipmentItem)localRoleEquipBag.get(localSItemEquipCfg.wearpos));
/*     */           }
/*     */         }
/*     */         else
/*     */         {
/*  94 */           if (((EquipmentItem)localObject5).getStrengthLevel() > localEquipmentItem1.getStrengthLevel())
/*     */           {
/*  96 */             localSEquipRes.uuids.add(((EquipmentItem)localObject5).getFirstUuid());
/*  97 */             localObject6 = String.format("[item]PEquip.processImpl@unequip item 1|roleId=%d|itemid=%d|uuid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(((EquipmentItem)localObject5).getCfgId()), ((EquipmentItem)localObject5).getFirstUuid() });
/*     */             
/*  99 */             ItemManager.logger.info(localObject6);
/*     */           }
/* 101 */           checkForSuperEquipmentTransferring(localEquipmentItem1, (EquipmentItem)localObject5, localSEquipRes);
/*     */           
/* 103 */           bool2 = ItemInterface.exchangeItem(this.roleid, this.key, localSItemEquipCfg.wearpos);
/* 104 */           if (bool2)
/*     */           {
/* 106 */             localObject2 = OcpEquipInterface.transferStrengthFromOtherOcpBag(this.roleid, localSItemEquipCfg.wearpos, (EquipmentItem)localRoleEquipBag.get(localSItemEquipCfg.wearpos));
/*     */             
/* 108 */             OcpEquipInterface.transferSuperEquipmentDataFromOtherOcpBag(this.roleid, localSItemEquipCfg.wearpos, (EquipmentItem)localRoleEquipBag.get(localSItemEquipCfg.wearpos));
/*     */           }
/*     */         }
/*     */       }
/*     */       else
/*     */       {
/* 114 */         bool2 = ItemInterface.moveItemIntoEquipBag(this.roleid, this.key);
/* 115 */         if (bool2)
/*     */         {
/* 117 */           localObject2 = OcpEquipInterface.transferStrengthFromOtherOcpBag(this.roleid, localSItemEquipCfg.wearpos, (EquipmentItem)localRoleEquipBag.get(localSItemEquipCfg.wearpos));
/*     */           
/* 119 */           OcpEquipInterface.transferSuperEquipmentDataFromOtherOcpBag(this.roleid, localSItemEquipCfg.wearpos, (EquipmentItem)localRoleEquipBag.get(localSItemEquipCfg.wearpos));
/*     */         }
/*     */         else
/*     */         {
/* 123 */           ItemManager.sendWrongInfo(this.roleid, 1, new String[0]);
/*     */         }
/*     */       }
/* 126 */       ItemManager.tlogEquipOn(this.roleid, localEquipmentItem1, localSItemEquipCfg.wearpos, localObject3 == null ? 0 : ((BasicItem)localObject3).getCfgId(), localObject3 == null ? 0L : l1, localEquipmentItem1.getStrengthLevel(), (TransferStrengthLevelBean)localObject2);
/* 127 */       if (localObject3 != null) {
/* 128 */         ItemManager.tlogEquipOff(this.roleid, (BasicItem)localObject3, l1, localSItemEquipCfg.wearpos);
/*     */       }
/* 130 */       OnlineManager.getInstance().send(this.roleid, localSEquipRes);
/* 131 */       return bool2;
/*     */     }
/* 133 */     Object localObject2 = ItemInterface.getItemByExtraPro(this.roleid, 340600000, ItemStoreEnum.EQUIP_FLAG, localInteger.intValue(), false);
/*     */     
/* 135 */     HashMap localHashMap = new HashMap();
/* 136 */     for (Object localObject3 = ((List)localObject2).iterator(); ((Iterator)localObject3).hasNext();) { localObject4 = (BasicItem)((Iterator)localObject3).next();
/* 137 */       if (((localObject4 instanceof EquipmentItem)) && (ItemInterface.checkEquipOnCondition(this.roleid, RoleInterface.getOccupationId(this.roleid), RoleInterface.getGender(this.roleid), (EquipmentItem)localObject4, false)))
/*     */       {
/*     */ 
/* 140 */         localHashMap.put(Integer.valueOf(SItemEquipCfg.get(((BasicItem)localObject4).getCfgId()).wearpos), (EquipmentItem)localObject4);
/*     */       }
/*     */     }
/* 143 */     localObject3 = new HashMap();
/* 144 */     for (Object localObject4 = localHashMap.keySet().iterator(); ((Iterator)localObject4).hasNext();)
/*     */     {
/* 146 */       int i = ((Integer)((Iterator)localObject4).next()).intValue();
/*     */       
/* 148 */       localObject5 = localRoleEquipBag.get(i);
/* 149 */       if (localObject5 != null) {
/* 150 */         ((Map)localObject3).put(Integer.valueOf(i), (EquipmentItem)localObject5);
/*     */       }
/*     */     }
/* 153 */     boolean bool3 = true;
/* 154 */     for (Iterator localIterator = localHashMap.keySet().iterator(); localIterator.hasNext();)
/*     */     {
/* 156 */       int j = ((Integer)localIterator.next()).intValue();
/*     */       
/* 158 */       localObject6 = null;
/* 159 */       EquipmentItem localEquipmentItem2 = (EquipmentItem)localHashMap.get(Integer.valueOf(j));
/* 160 */       EquipmentItem localEquipmentItem3 = (EquipmentItem)((Map)localObject3).get(Integer.valueOf(j));
/* 161 */       long l2 = 0L;
/* 162 */       if (localEquipmentItem3 != null)
/*     */       {
/* 164 */         l2 = localEquipmentItem3.getTlogUuid();
/* 165 */         String str; if (localEquipmentItem3.getExtra(ItemStoreEnum.EQUIP_FLAG) != null)
/*     */         {
/* 167 */           if ((SItemEquipCfg.get(localEquipmentItem3.getCfgId()).useLevel < SItemEquipCfg.get(localEquipmentItem2.getCfgId()).useLevel) && (localEquipmentItem3.getStrengthLevel() <= 0) && (new PCSellItemReq(localEquipmentItem3.getFirstUuid().longValue(), 340600001, this.roleid, 1).call()))
/*     */           {
/* 169 */             bool3 = ItemInterface.moveItemIntoEquipBag(this.roleid, localEquipmentItem2.getFirstUuid().longValue());
/* 170 */             if (bool3)
/*     */             {
/* 172 */               localObject6 = OcpEquipInterface.transferStrengthFromOtherOcpBag(this.roleid, j, (EquipmentItem)localRoleEquipBag.get(j));
/*     */               
/* 174 */               OcpEquipInterface.transferSuperEquipmentDataFromOtherOcpBag(this.roleid, j, (EquipmentItem)localRoleEquipBag.get(j));
/*     */             }
/*     */           }
/*     */           else
/*     */           {
/* 179 */             if (localEquipmentItem3.getStrengthLevel() > localEquipmentItem2.getStrengthLevel())
/*     */             {
/* 181 */               localSEquipRes.uuids.add(localEquipmentItem3.getFirstUuid());
/* 182 */               str = String.format("[item]PEquip.processImpl@unequip item 2|roleId=%d|itemid=%d|uuid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(localEquipmentItem3.getCfgId()), localEquipmentItem3.getFirstUuid() });
/*     */               
/* 184 */               ItemManager.logger.info(str);
/*     */             }
/* 186 */             checkForSuperEquipmentTransferring(localEquipmentItem2, localEquipmentItem3, localSEquipRes);
/*     */             
/* 188 */             bool3 = ItemInterface.exchangeItem(this.roleid, 340600000, localEquipmentItem2.getFirstUuid().longValue(), 340600001, localEquipmentItem3.getFirstUuid().longValue());
/* 189 */             if (bool3)
/*     */             {
/* 191 */               localObject6 = OcpEquipInterface.transferStrengthFromOtherOcpBag(this.roleid, j, (EquipmentItem)localRoleEquipBag.get(j));
/*     */               
/* 193 */               OcpEquipInterface.transferSuperEquipmentDataFromOtherOcpBag(this.roleid, j, (EquipmentItem)localRoleEquipBag.get(j));
/*     */             }
/*     */           }
/*     */         }
/* 197 */         else if ((SItemEquipCfg.get(localEquipmentItem3.getCfgId()).useLevel == 0) && (localEquipmentItem3.getStrengthLevel() <= 0) && (new PCSellItemReq(localEquipmentItem3.getFirstUuid().longValue(), 340600001, this.roleid, 1).call()))
/*     */         {
/* 199 */           bool3 = ItemInterface.moveItemIntoEquipBag(this.roleid, localEquipmentItem2.getFirstUuid().longValue());
/* 200 */           if (bool3)
/*     */           {
/* 202 */             localObject6 = OcpEquipInterface.transferStrengthFromOtherOcpBag(this.roleid, j, (EquipmentItem)localRoleEquipBag.get(j));
/*     */             
/* 204 */             OcpEquipInterface.transferSuperEquipmentDataFromOtherOcpBag(this.roleid, j, (EquipmentItem)localRoleEquipBag.get(j));
/*     */           }
/*     */         }
/*     */         else
/*     */         {
/* 209 */           if (localEquipmentItem3.getStrengthLevel() > localEquipmentItem2.getStrengthLevel())
/*     */           {
/* 211 */             localSEquipRes.uuids.add(localEquipmentItem3.getFirstUuid());
/* 212 */             str = String.format("[item]PEquip.processImpl@unequip item 3|roleId=%d|itemid=%d|uuid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(localEquipmentItem3.getCfgId()), localEquipmentItem3.getFirstUuid() });
/*     */             
/* 214 */             ItemManager.logger.info(str);
/*     */           }
/* 216 */           checkForSuperEquipmentTransferring(localEquipmentItem2, localEquipmentItem3, localSEquipRes);
/*     */           
/* 218 */           bool3 = ItemInterface.exchangeItem(this.roleid, 340600000, localEquipmentItem2.getFirstUuid().longValue(), 340600001, localEquipmentItem3.getFirstUuid().longValue());
/* 219 */           if (bool3)
/*     */           {
/* 221 */             localObject6 = OcpEquipInterface.transferStrengthFromOtherOcpBag(this.roleid, j, (EquipmentItem)localRoleEquipBag.get(j));
/*     */             
/* 223 */             OcpEquipInterface.transferSuperEquipmentDataFromOtherOcpBag(this.roleid, j, (EquipmentItem)localRoleEquipBag.get(j));
/*     */           }
/*     */         }
/*     */       }
/*     */       else
/*     */       {
/* 229 */         bool3 = ItemInterface.moveItemIntoEquipBag(this.roleid, localEquipmentItem2.getFirstUuid().longValue());
/* 230 */         if (bool3)
/*     */         {
/* 232 */           localObject6 = OcpEquipInterface.transferStrengthFromOtherOcpBag(this.roleid, j, (EquipmentItem)localRoleEquipBag.get(j));
/*     */           
/* 234 */           OcpEquipInterface.transferSuperEquipmentDataFromOtherOcpBag(this.roleid, j, (EquipmentItem)localRoleEquipBag.get(j));
/*     */         }
/*     */       }
/* 237 */       if (!bool3) {
/* 238 */         return false;
/*     */       }
/* 240 */       ItemManager.tlogEquipOn(this.roleid, localEquipmentItem2, j, localEquipmentItem3 == null ? 0 : localEquipmentItem3.getCfgId(), l2, localEquipmentItem2.getStrengthLevel(), (TransferStrengthLevelBean)localObject6);
/* 241 */       if (localEquipmentItem3 != null) {
/* 242 */         ItemManager.tlogEquipOff(this.roleid, localEquipmentItem3, l2, j);
/*     */       }
/*     */     }
/* 245 */     OnlineManager.getInstance().send(this.roleid, localSEquipRes);
/* 246 */     return bool3;
/*     */   }
/*     */   
/*     */   private void checkForSuperEquipmentTransferring(EquipmentItem paramEquipmentItem1, EquipmentItem paramEquipmentItem2, SEquipRes paramSEquipRes)
/*     */   {
/* 251 */     if (!OpenInterface.getOpenStatus(382)) {
/* 252 */       return;
/*     */     }
/* 254 */     int i = paramEquipmentItem1.getSuperEquipmentLevel();
/* 255 */     int j = paramEquipmentItem1.getSuperEquipmentStage();
/* 256 */     int k = paramEquipmentItem2.getSuperEquipmentLevel();
/* 257 */     int m = paramEquipmentItem2.getSuperEquipmentStage();
/* 258 */     if (!SuperEquipmentInterface.meetLowestConditionsForSuperEquipment(paramEquipmentItem1)) {
/* 259 */       return;
/*     */     }
/* 261 */     if ((i < k) || ((i == k) && (j < m))) {
/* 262 */       paramSEquipRes.super_equipment_uuids.add(paramEquipmentItem2.getFirstUuid());
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\PEquip.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */