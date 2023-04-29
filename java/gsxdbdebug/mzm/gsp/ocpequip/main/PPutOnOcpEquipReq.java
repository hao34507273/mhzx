/*     */ package mzm.gsp.ocpequip.main;
/*     */ 
/*     */ import mzm.gsp.item.confbean.SItemEquipCfg;
/*     */ import mzm.gsp.item.main.BasicItem;
/*     */ import mzm.gsp.item.main.EquipmentItem;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.item.main.ItemOperateResult;
/*     */ import mzm.gsp.item.main.RoleEquipBag;
/*     */ import mzm.gsp.item.main.RoleItemBag;
/*     */ import mzm.gsp.ocpequip.SPutOnOcpEquipRes;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.server.main.ServerInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Bag;
/*     */ import xbean.Item;
/*     */ import xbean.OcpEquipBag;
/*     */ import xbean.Pod;
/*     */ import xio.Protocol;
/*     */ import xtable.Role2ocpequipbag;
/*     */ 
/*     */ public class PPutOnOcpEquipReq extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int ocp;
/*     */   private final int gender;
/*     */   private final long uuid;
/*     */   
/*     */   public PPutOnOcpEquipReq(long paramLong1, int paramInt1, int paramInt2, long paramLong2)
/*     */   {
/*  32 */     this.roleid = paramLong1;
/*  33 */     this.ocp = paramInt1;
/*  34 */     this.gender = paramInt2;
/*  35 */     this.uuid = paramLong2;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  41 */     if (!OcpEquipManager.isOcpEquipOnSwitchOpenForRole(this.roleid)) {
/*  42 */       return false;
/*     */     }
/*  44 */     if (!OcpEquipManager.isRoleStateCanOperateOcpEquip(this.roleid))
/*     */     {
/*  46 */       String str1 = String.format("[ocpequip]PPutOnOcpEquipReq.processImp@role state can not operate ocp equip|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/*     */       
/*  48 */       OcpEquipManager.logger.info(str1);
/*  49 */       return false;
/*     */     }
/*  51 */     boolean bool1 = OcpEquipManager.hasOcp(this.roleid, this.ocp);
/*  52 */     if (!bool1)
/*     */     {
/*  54 */       localObject1 = String.format("[ocpequip]PPutOnOcpEquipReq.processImp@role no this ocp|roleid=%d|ocp=%d|gender=%d|uuid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.ocp), Integer.valueOf(this.gender), Long.valueOf(this.uuid) });
/*     */       
/*  56 */       OcpEquipManager.logger.info(localObject1);
/*  57 */       OcpEquipManager.sendScommonErrorRes(this.roleid, 1);
/*  58 */       return false;
/*     */     }
/*  60 */     Object localObject1 = Role2ocpequipbag.get(Long.valueOf(this.roleid));
/*  61 */     if (localObject1 == null)
/*     */     {
/*  63 */       localObject1 = Pod.newOcpEquipBag();
/*  64 */       Role2ocpequipbag.insert(Long.valueOf(this.roleid), (OcpEquipBag)localObject1);
/*     */     }
/*  66 */     Bag localBag = OcpEquipManager.getEquipXBagByOcp(this.roleid, (OcpEquipBag)localObject1, this.ocp, this.gender, false);
/*  67 */     if (localBag == null)
/*     */     {
/*  69 */       localObject2 = String.format("[ocpequip]PPutOnOcpEquipReq.processImp@get role ocp xbag null|roleid=%d|ocp=%d|gender=%d|uuid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.ocp), Integer.valueOf(this.gender), Long.valueOf(this.uuid) });
/*     */       
/*  71 */       OcpEquipManager.logger.info(localObject2);
/*  72 */       OcpEquipManager.sendScommonErrorRes(this.roleid, 1);
/*  73 */       return false;
/*     */     }
/*  75 */     Object localObject2 = new RoleEquipBag(localBag);
/*     */     
/*  77 */     RoleItemBag localRoleItemBag = ItemInterface.getRoleItemBag(this.roleid);
/*  78 */     BasicItem localBasicItem = localRoleItemBag.getItemByUuid(this.uuid);
/*  79 */     if ((localBasicItem == null) || (!(localBasicItem instanceof EquipmentItem))) {
/*  80 */       return false;
/*     */     }
/*  82 */     EquipmentItem localEquipmentItem1 = new EquipmentItem(localBasicItem.getItem().toBean());
/*     */     
/*  84 */     int i = ItemInterface.getEquipWearpos(localEquipmentItem1.getCfgId());
/*  85 */     if (i == -1)
/*     */     {
/*  87 */       localObject3 = String.format("[ocpequip]PPutOnOcpEquipReq.processImp@equip wear pos error|roleid=%d|ocp=%d|gender=%d|uuid=%d|itemid=%d|wearpos=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.ocp), Integer.valueOf(this.gender), Long.valueOf(this.uuid), Integer.valueOf(localEquipmentItem1.getCfgId()), Integer.valueOf(i) });
/*     */       
/*  89 */       OcpEquipManager.logger.info(localObject3);
/*  90 */       return false;
/*     */     }
/*  92 */     Object localObject3 = SItemEquipCfg.get(localEquipmentItem1.getCfgId());
/*  93 */     boolean bool2 = ItemInterface.checkEquipOnCondition(this.roleid, this.ocp, this.gender, localEquipmentItem1);
/*  94 */     if (!bool2)
/*     */     {
/*  96 */       localObject4 = String.format("[ocpequip]PPutOnOcpEquipReq.processImp@equip wear condition error|roleid=%d|ocp=%d|gender=%d|uuid=%d|itemid=%d|wearpos=%d|equipocp=%d|use_point=%d|role_level=%d|equip_level=%d|server_level=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.ocp), Integer.valueOf(this.gender), Long.valueOf(this.uuid), Integer.valueOf(localEquipmentItem1.getCfgId()), Integer.valueOf(i), Integer.valueOf(((SItemEquipCfg)localObject3).menpai), Integer.valueOf(localEquipmentItem1.getUsePointValue()), Integer.valueOf(RoleInterface.getLevel(this.roleid)), Integer.valueOf(((SItemEquipCfg)localObject3).useLevel), Integer.valueOf(ServerInterface.getCurrentServerLevel()) });
/*     */       
/*  98 */       OcpEquipManager.logger.info(localObject4);
/*  99 */       return false;
/*     */     }
/* 101 */     Object localObject4 = ((RoleEquipBag)localObject2).removeByGrid(i);
/* 102 */     int j = -1;
/* 103 */     int k = 0;
/* 104 */     long l = 0L;
/* 105 */     if (localObject4 != null)
/*     */     {
/* 107 */       k = ((BasicItem)localObject4).getCfgId();
/* 108 */       l = ((BasicItem)localObject4).getTlogUuid();
/* 109 */       if ((localObject4 instanceof EquipmentItem))
/*     */       {
/* 111 */         EquipmentItem localEquipmentItem2 = (EquipmentItem)localObject4;
/* 112 */         j = localEquipmentItem2.getStrengthLevel();
/*     */       }
/* 114 */       boolean bool3 = localRoleItemBag.add((BasicItem)localObject4);
/* 115 */       if (!bool3)
/*     */       {
/* 117 */         localObject5 = String.format("[ocpequip]PPutOnOcpEquipReq.processImp@add equip into role item bag error|roleid=%d|ocp=%d|gender=%d|toun_uuid=%d|toun_itemid=%d|wearpos=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.ocp), Integer.valueOf(this.gender), ((BasicItem)localObject4).getFirstUuid(), Integer.valueOf(((BasicItem)localObject4).getCfgId()), Integer.valueOf(i) });
/*     */         
/* 119 */         OcpEquipManager.logger.error(localObject5);
/* 120 */         return false;
/*     */       }
/*     */     }
/* 123 */     ItemOperateResult localItemOperateResult = localRoleItemBag.removeItemByUuid(this.uuid, localEquipmentItem1.getNumber());
/* 124 */     if (!localItemOperateResult.success()) {
/* 125 */       return false;
/*     */     }
/* 127 */     localItemOperateResult = ((RoleEquipBag)localObject2).addItem(localEquipmentItem1);
/* 128 */     if (localItemOperateResult.success())
/*     */     {
/* 130 */       localObject5 = new SPutOnOcpEquipRes();
/* 131 */       ItemInterface.fillInItemInfoBean(((SPutOnOcpEquipRes)localObject5).item, localEquipmentItem1.getItem());
/* 132 */       ((SPutOnOcpEquipRes)localObject5).key = i;
/* 133 */       ((SPutOnOcpEquipRes)localObject5).ocp = this.ocp;
/* 134 */       ((SPutOnOcpEquipRes)localObject5).gender = this.gender;
/* 135 */       OnlineManager.getInstance().send(this.roleid, (Protocol)localObject5);
/* 136 */       String str2 = String.format("[ocpequip]PPutOnOcpEquipReq.processImp@add equip into role ocp bag success|roleid=%d|ocp=%d|gender=%d|uuid=%d|itemid=%d|wearpos=%d|strength_level=%d|toun_itemid=%d|toun_uuid=%d|toun_strength_level=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.ocp), Integer.valueOf(this.gender), Long.valueOf(this.uuid), Integer.valueOf(localEquipmentItem1.getCfgId()), Integer.valueOf(i), Integer.valueOf(localEquipmentItem1.getStrengthLevel()), Integer.valueOf(localObject4 == null ? 0 : ((BasicItem)localObject4).getCfgId()), Long.valueOf(localObject4 == null ? 0L : ((BasicItem)localObject4).getFirstUuid().longValue()), Integer.valueOf(j) });
/*     */       
/* 138 */       OcpEquipManager.logger.info(str2);
/* 139 */       OcpEquipManager.tlogOcpEquipOn(this.roleid, this.ocp, localEquipmentItem1, i, k, l, j);
/* 140 */       return true;
/*     */     }
/* 142 */     Object localObject5 = String.format("[ocpequip]PPutOnOcpEquipReq.processImp@add equip into role ocp bag error|roleid=%d|ocp=%d|gender=%d|uuid=%d|itemid=%d|wearpos=%d|strength_level=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.ocp), Integer.valueOf(this.gender), Long.valueOf(this.uuid), Integer.valueOf(localEquipmentItem1.getCfgId()), Integer.valueOf(i), Integer.valueOf(localEquipmentItem1.getStrengthLevel()) });
/*     */     
/* 144 */     OcpEquipManager.logger.error(localObject5);
/* 145 */     return false;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ocpequip\main\PPutOnOcpEquipReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */