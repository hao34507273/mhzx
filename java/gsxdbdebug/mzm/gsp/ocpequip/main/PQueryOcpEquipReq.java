/*    */ package mzm.gsp.ocpequip.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.fashiondress.main.FashionDressInterface;
/*    */ import mzm.gsp.item.BagInfo;
/*    */ import mzm.gsp.item.ItemInfo;
/*    */ import mzm.gsp.item.main.ItemInterface;
/*    */ import mzm.gsp.item.main.RoleEquipBag;
/*    */ import mzm.gsp.ocpequip.SSynOcpEquipRes;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.pubdata.ModelInfo;
/*    */ import mzm.gsp.roledye.main.RoleDyeInterface;
/*    */ import mzm.gsp.roledye.main.RoleDyeInterface.RoleColorInfo;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.Bag;
/*    */ import xbean.Item;
/*    */ 
/*    */ public class PQueryOcpEquipReq
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final int ocp;
/*    */   private final int gender;
/*    */   
/*    */   public PQueryOcpEquipReq(long paramLong, int paramInt1, int paramInt2)
/*    */   {
/* 31 */     this.roleid = paramLong;
/* 32 */     this.ocp = paramInt1;
/* 33 */     this.gender = paramInt2;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 39 */     if (!OcpEquipManager.isRoleStateCanOperateOcpEquip(this.roleid))
/*    */     {
/* 41 */       String str = String.format("[ocpequip]PQueryOcpEquipReq.processImp@role state can not operate ocp equip|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/*    */       
/* 43 */       OcpEquipManager.logger.info(str);
/* 44 */       return false;
/*    */     }
/* 46 */     boolean bool = OcpEquipManager.hasOcp(this.roleid, this.ocp);
/* 47 */     if (!bool)
/*    */     {
/* 49 */       localObject1 = String.format("[ocpequip]PQueryOcpEquipReq.processImp@role no this ocp|roleid=%d|ocp=%d|gender=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.ocp), Integer.valueOf(this.gender) });
/* 50 */       OcpEquipManager.logger.info(localObject1);
/* 51 */       OcpEquipManager.sendScommonErrorRes(this.roleid, 1);
/* 52 */       return false;
/*    */     }
/* 54 */     Object localObject1 = OcpEquipManager.getEquipXBagByOcp(this.roleid, this.ocp, this.gender, false);
/* 55 */     if (localObject1 == null)
/*    */     {
/* 57 */       localObject2 = String.format("[ocpequip]PQueryOcpEquipReq.processImp@get role ocp xbag null|roleid=%d|ocp=%d|gender=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.ocp), Integer.valueOf(this.gender) });
/*    */       
/* 59 */       OcpEquipManager.logger.info(localObject2);
/* 60 */       OcpEquipManager.sendScommonErrorRes(this.roleid, 1);
/* 61 */       return false;
/*    */     }
/* 63 */     Object localObject2 = new RoleEquipBag((Bag)localObject1);
/* 64 */     SSynOcpEquipRes localSSynOcpEquipRes = new SSynOcpEquipRes();
/* 65 */     localSSynOcpEquipRes.ocp = this.ocp;
/* 66 */     localSSynOcpEquipRes.gender = this.gender;
/* 67 */     localSSynOcpEquipRes.ocpequipbags.capacity = ((RoleEquipBag)localObject2).getCapacity();
/* 68 */     for (Object localObject3 = ((Bag)localObject1).getItems().keySet().iterator(); ((Iterator)localObject3).hasNext();)
/*    */     {
/* 70 */       i = ((Integer)((Iterator)localObject3).next()).intValue();
/*    */       
/* 72 */       ItemInfo localItemInfo = new ItemInfo();
/* 73 */       ItemInterface.fillInItemInfoBean(localItemInfo, (Item)((Bag)localObject1).getItems().get(Integer.valueOf(i)));
/* 74 */       localSSynOcpEquipRes.ocpequipbags.items.put(Integer.valueOf(i), localItemInfo);
/*    */     }
/* 76 */     localObject3 = RoleDyeInterface.getRoleOccupationColorInfo(this.roleid, this.ocp, true);
/* 77 */     if (localObject3 != null)
/*    */     {
/* 79 */       localSSynOcpEquipRes.modelinfo.extramap.put(Integer.valueOf(8), Integer.valueOf(((RoleDyeInterface.RoleColorInfo)localObject3).getClothColorId()));
/* 80 */       localSSynOcpEquipRes.modelinfo.extramap.put(Integer.valueOf(7), Integer.valueOf(((RoleDyeInterface.RoleColorInfo)localObject3).getHairColorId()));
/*    */     }
/* 82 */     int i = FashionDressInterface.getRoleOccupationFashionDressCfgId(this.roleid, this.ocp, true);
/* 83 */     localSSynOcpEquipRes.modelinfo.extramap.put(Integer.valueOf(14), Integer.valueOf(i));
/* 84 */     int j = ItemInterface.getWholeBodyMinQilinLevel((RoleEquipBag)localObject2);
/* 85 */     localSSynOcpEquipRes.modelinfo.extramap.put(Integer.valueOf(16), Integer.valueOf(j));
/*    */     
/* 87 */     OnlineManager.getInstance().send(this.roleid, localSSynOcpEquipRes);
/* 88 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ocpequip\main\PQueryOcpEquipReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */