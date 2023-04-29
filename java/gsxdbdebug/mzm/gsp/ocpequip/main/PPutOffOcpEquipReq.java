/*     */ package mzm.gsp.ocpequip.main;
/*     */ 
/*     */ import mzm.gsp.item.main.BasicItem;
/*     */ import mzm.gsp.item.main.EquipmentItem;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.item.main.ItemOperateResult;
/*     */ import mzm.gsp.item.main.RoleEquipBag;
/*     */ import mzm.gsp.item.main.RoleItemBag;
/*     */ import mzm.gsp.ocpequip.SPutOffOcpEquipRes;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Bag;
/*     */ import xio.Protocol;
/*     */ 
/*     */ public class PPutOffOcpEquipReq extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int ocp;
/*     */   private final int gender;
/*     */   private final int key;
/*     */   
/*     */   public PPutOffOcpEquipReq(long paramLong, int paramInt1, int paramInt2, int paramInt3)
/*     */   {
/*  25 */     this.roleid = paramLong;
/*  26 */     this.ocp = paramInt1;
/*  27 */     this.gender = paramInt2;
/*  28 */     this.key = paramInt3;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  34 */     if (this.key < 0) {
/*  35 */       return false;
/*     */     }
/*  37 */     if (!OcpEquipManager.isOcpEquipOffSwitchOpenForRole(this.roleid)) {
/*  38 */       return false;
/*     */     }
/*  40 */     if (!OcpEquipManager.isRoleStateCanOperateOcpEquip(this.roleid))
/*     */     {
/*  42 */       String str1 = String.format("[ocpequip]PPutOffOcpEquipReq.processImp@role state can not operate ocp equip|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/*     */       
/*  44 */       OcpEquipManager.logger.info(str1);
/*  45 */       return false;
/*     */     }
/*  47 */     boolean bool = OcpEquipManager.hasOcp(this.roleid, this.ocp);
/*  48 */     if (!bool)
/*     */     {
/*  50 */       localObject1 = String.format("[ocpequip]PPutOffOcpEquipReq.processImp@role no this ocp|roleid=%d|ocp=%d|gender=%d|key=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.ocp), Integer.valueOf(this.gender), Integer.valueOf(this.key) });
/*     */       
/*  52 */       OcpEquipManager.logger.info(localObject1);
/*  53 */       OcpEquipManager.sendScommonErrorRes(this.roleid, 1);
/*  54 */       return false;
/*     */     }
/*  56 */     Object localObject1 = OcpEquipManager.getEquipXBagByOcp(this.roleid, this.ocp, this.gender, false);
/*  57 */     if (localObject1 == null)
/*     */     {
/*  59 */       localObject2 = String.format("[ocpequip]PPutOffOcpEquipReq.processImp@get role ocp xbag null|roleid=%d|ocp=%d|gender=%d|key=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.ocp), Integer.valueOf(this.gender), Integer.valueOf(this.key) });
/*     */       
/*  61 */       OcpEquipManager.logger.info(localObject2);
/*  62 */       OcpEquipManager.sendScommonErrorRes(this.roleid, 1);
/*  63 */       return false;
/*     */     }
/*  65 */     Object localObject2 = new RoleEquipBag((Bag)localObject1);
/*     */     
/*  67 */     BasicItem localBasicItem = ((RoleEquipBag)localObject2).removeByGrid(this.key);
/*  68 */     if ((localBasicItem == null) || (!(localBasicItem instanceof EquipmentItem)))
/*     */     {
/*  70 */       localObject3 = String.format("[ocpequip]PPutOffOcpEquipReq.processImp@no equip to take off|roleid=%d|ocp=%d|gender=%d|wearpos=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.ocp), Integer.valueOf(this.gender), Integer.valueOf(this.key) });
/*     */       
/*  72 */       OcpEquipManager.logger.error(localObject3);
/*  73 */       return false;
/*     */     }
/*  75 */     Object localObject3 = new EquipmentItem(localBasicItem.getCopyItem());
/*  76 */     RoleItemBag localRoleItemBag = ItemInterface.getRoleItemBag(this.roleid);
/*  77 */     ItemOperateResult localItemOperateResult = localRoleItemBag.addItem((BasicItem)localObject3);
/*  78 */     if (localItemOperateResult.isBagFull())
/*     */     {
/*  80 */       ItemInterface.sendSpecificBagFull(this.roleid, localItemOperateResult.getFullBagId());
/*  81 */       return false;
/*     */     }
/*  83 */     if (localItemOperateResult.success())
/*     */     {
/*  85 */       localObject4 = new SPutOffOcpEquipRes();
/*  86 */       ((SPutOffOcpEquipRes)localObject4).itemid = ((EquipmentItem)localObject3).getCfgId();
/*  87 */       ((SPutOffOcpEquipRes)localObject4).key = this.key;
/*  88 */       ((SPutOffOcpEquipRes)localObject4).ocp = this.ocp;
/*  89 */       ((SPutOffOcpEquipRes)localObject4).gender = this.gender;
/*  90 */       OnlineManager.getInstance().send(this.roleid, (Protocol)localObject4);
/*     */       
/*  92 */       String str2 = String.format("[ocpequip]PPutOffOcpEquipReq.processImp@add equip into role bag success|roleid=%d|ocp=%d|gender=%d|wearpos=%d|itemid=%d|uuid=%d|strength_level=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.ocp), Integer.valueOf(this.gender), Integer.valueOf(this.key), Integer.valueOf(((EquipmentItem)localObject3).getCfgId()), ((EquipmentItem)localObject3).getFirstUuid(), Integer.valueOf(((EquipmentItem)localObject3).getStrengthLevel()) });
/*     */       
/*  94 */       OcpEquipManager.logger.info(str2);
/*  95 */       OcpEquipManager.tlogOcpEquipOff(this.roleid, this.ocp, (EquipmentItem)localObject3, this.key);
/*  96 */       return true;
/*     */     }
/*  98 */     Object localObject4 = String.format("[ocpequip]PPutOffOcpEquipReq.processImp@add equip into role bag error|roleid=%d|ocp=%d|gender=%d|wearpos=%d|itemid=%d|uuid=%d|strength_level=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.ocp), Integer.valueOf(this.gender), Integer.valueOf(this.key), Integer.valueOf(((EquipmentItem)localObject3).getCfgId()), ((EquipmentItem)localObject3).getFirstUuid(), Integer.valueOf(((EquipmentItem)localObject3).getStrengthLevel()) });
/*     */     
/* 100 */     OcpEquipManager.logger.error(localObject4);
/* 101 */     return false;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ocpequip\main\PPutOffOcpEquipReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */