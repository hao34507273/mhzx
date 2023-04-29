/*     */ package mzm.gsp.item.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import mzm.gsp.item.SFixAllEquipmentsRes;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PFixAllEquipments
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   
/*     */   public PFixAllEquipments(long roleid)
/*     */   {
/*  26 */     this.roleId = roleid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  32 */     if (!ItemModuleSwitchInterface.isEquipFixSwitchOpenForRole(this.roleId))
/*     */     {
/*  34 */       return false;
/*     */     }
/*  36 */     if (!ItemManager.isRoleStateCanOperateItem(this.roleId))
/*     */     {
/*  38 */       String logStr = String.format("[item]PFixAllEquipments.processImp@role state can not operate item|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  40 */       ItemManager.logger.info(logStr);
/*  41 */       return false;
/*     */     }
/*     */     
/*  44 */     RoleItemBag roleItemBag = ItemManager.getRoleItemBag(this.roleId);
/*  45 */     RoleEquipBag roleEquipBag = ItemManager.getRoleEquipBag(this.roleId);
/*  46 */     if ((roleItemBag == null) || (roleEquipBag == null))
/*     */     {
/*  48 */       ItemManager.sendWrongInfo(this.roleId, 640, new String[0]);
/*  49 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  53 */     Map<Integer, BasicItem> itemBagEuips = roleItemBag.getItemByType(2);
/*  54 */     Map<Integer, BasicItem> equipBagEquips = roleEquipBag.getItemByType(2);
/*  55 */     if ((itemBagEuips.size() == 0) && (equipBagEquips.size() == 0))
/*     */     {
/*  57 */       ItemManager.sendWrongInfo(this.roleId, 640, new String[0]);
/*  58 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  62 */     int totalNeedSilverNum = computeNeedSilver(itemBagEuips) + computeNeedSilver(equipBagEquips);
/*     */     
/*  64 */     if (totalNeedSilverNum == 0)
/*     */     {
/*  66 */       ItemManager.sendWrongInfo(this.roleId, 643, new String[0]);
/*  67 */       return false;
/*     */     }
/*     */     
/*  70 */     TLogArg logArg = new TLogArg(LogReason.EQUIP_FIX_REM);
/*     */     
/*  72 */     if (!RoleInterface.cutSilver(this.roleId, totalNeedSilverNum, logArg))
/*     */     {
/*  74 */       ItemManager.sendWrongInfo(this.roleId, 642, new String[0]);
/*  75 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  79 */     fixEquips(itemBagEuips);
/*  80 */     fixEquips(equipBagEquips);
/*     */     
/*     */ 
/*  83 */     SFixAllEquipmentsRes res = new SFixAllEquipmentsRes();
/*  84 */     OnlineManager.getInstance().sendAtOnce(this.roleId, res);
/*     */     
/*  86 */     return true;
/*     */   }
/*     */   
/*     */   private int computeNeedSilver(Map<Integer, BasicItem> equips)
/*     */   {
/*  91 */     int needSilverNum = 0;
/*  92 */     for (BasicItem basicItem : equips.values())
/*     */     {
/*  94 */       EquipmentItem equipmentItem = (EquipmentItem)basicItem;
/*  95 */       needSilverNum += equipmentItem.computeNeedSilver();
/*     */     }
/*     */     
/*  98 */     return needSilverNum;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void fixEquips(Map<Integer, BasicItem> equips)
/*     */   {
/* 108 */     for (BasicItem basicItem : equips.values())
/*     */     {
/* 110 */       EquipmentItem equipmentItem = (EquipmentItem)basicItem;
/* 111 */       equipmentItem.fix();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\PFixAllEquipments.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */