/*     */ package mzm.gsp.item.main;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.gm.main.GmManager;
/*     */ import mzm.gsp.ocpequip.main.PQueryOcpEquipReq;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.Bag;
/*     */ import xbean.OcpEquipBag;
/*     */ 
/*     */ public class Pgm_Equipqilin extends LogicProcedure
/*     */ {
/*     */   private final long gmRoleid;
/*     */   private final long roleid;
/*     */   private final int wearpos;
/*     */   private final int strengthLevel;
/*     */   private final int ocp;
/*     */   
/*     */   public Pgm_Equipqilin(long gmRoleid, long roleid, int wearpos, int strengthLevel, int ocp)
/*     */   {
/*  23 */     this.gmRoleid = gmRoleid;
/*  24 */     this.roleid = roleid;
/*  25 */     this.wearpos = wearpos;
/*  26 */     this.strengthLevel = strengthLevel;
/*  27 */     this.ocp = ocp;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  33 */     if (this.ocp == -1)
/*     */     {
/*  35 */       RoleEquipBag equipBag = ItemManager.getRoleEquipBag(this.roleid);
/*  36 */       BasicItem basicItem = equipBag.get(this.wearpos);
/*  37 */       if (basicItem == null)
/*     */       {
/*  39 */         for (int i = 0; i < 6; i++)
/*     */         {
/*  41 */           basicItem = equipBag.get(i);
/*  42 */           setLevel(basicItem, true);
/*     */         }
/*     */         
/*     */       }
/*     */       else {
/*  47 */         setLevel(basicItem, true);
/*     */       }
/*     */     }
/*     */     else
/*     */     {
/*  52 */       OcpEquipBag xOcpEquipBag = xtable.Role2ocpequipbag.get(Long.valueOf(this.roleid));
/*  53 */       if (xOcpEquipBag == null)
/*     */       {
/*  55 */         GmManager.getInstance().sendResultToGM(this.gmRoleid, String.format("玩家 [%d]没有开启该职业%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.ocp) }));
/*  56 */         return false;
/*     */       }
/*  58 */       Bag xBag = (Bag)xOcpEquipBag.getOcp2equipbag().get(Integer.valueOf(this.ocp));
/*  59 */       if (xBag == null)
/*     */       {
/*  61 */         GmManager.getInstance().sendResultToGM(this.gmRoleid, String.format("玩家 [%d]没有开启该职业%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.ocp) }));
/*  62 */         return false;
/*     */       }
/*  64 */       RoleEquipBag equipBag = new RoleEquipBag(xBag);
/*  65 */       BasicItem basicItem = equipBag.get(this.wearpos);
/*  66 */       if (basicItem == null)
/*     */       {
/*  68 */         for (int i = 0; i < 6; i++)
/*     */         {
/*  70 */           basicItem = equipBag.get(i);
/*  71 */           setLevel(basicItem, false);
/*     */         }
/*     */         
/*     */       }
/*     */       else {
/*  76 */         setLevel(basicItem, false);
/*     */       }
/*  78 */       new PQueryOcpEquipReq(this.roleid, this.ocp).execute();
/*     */     }
/*     */     
/*  81 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   private void setLevel(BasicItem basicItem, boolean isEquipBag)
/*     */   {
/*  87 */     if ((basicItem != null) && ((basicItem instanceof EquipmentItem)))
/*     */     {
/*  89 */       EquipmentItem equipmentItem = (EquipmentItem)basicItem;
/*  90 */       int oldStrengthlevel = equipmentItem.getStrengthLevel();
/*  91 */       equipmentItem.setStrengthLevel(this.strengthLevel);
/*     */       
/*  93 */       GmManager.getInstance().sendResultToGM(this.gmRoleid, String.format("玩家 [%d]的装备[%s]已经启灵到%d", new Object[] { Long.valueOf(this.roleid), ItemInterface.getItemName(equipmentItem.getCfgId()), Integer.valueOf(this.strengthLevel) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  98 */       if (isEquipBag)
/*     */       {
/* 100 */         TriggerEventsManger.getInstance().triggerEvent(new mzm.gsp.item.event.EquipQiLin(), new EquipQiLinArg(this.roleid, 340600001, ((Long)equipmentItem.getUuid().iterator().next()).longValue(), oldStrengthlevel, this.strengthLevel));
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\Pgm_Equipqilin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */