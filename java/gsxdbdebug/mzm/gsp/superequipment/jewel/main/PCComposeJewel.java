/*     */ package mzm.gsp.superequipment.jewel.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.item.main.ItemOperateResult;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.superequipment.SComposeJewelSuccess;
/*     */ import mzm.gsp.superequipment.SJewelError;
/*     */ import mzm.gsp.superequipment.jewel.confbean.SSuperEquipmentJewelItem;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ public class PCComposeJewel
/*     */   extends LogicProcedure
/*     */ {
/*     */   final long roleId;
/*     */   final int jewelcfgid;
/*     */   
/*     */   public PCComposeJewel(long roleId, int jewelcfgid)
/*     */   {
/*  32 */     this.roleId = roleId;
/*  33 */     this.jewelcfgid = jewelcfgid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  39 */     String userId = RoleInterface.getUserId(this.roleId);
/*     */     
/*  41 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 1601, true))
/*     */     {
/*  43 */       return false;
/*     */     }
/*  45 */     if (!OpenInterface.getOpenStatus(385))
/*     */     {
/*  47 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  51 */     SSuperEquipmentJewelItem cfgJewelItem = SSuperEquipmentJewelItem.get(this.jewelcfgid);
/*  52 */     if (cfgJewelItem == null)
/*     */     {
/*  54 */       GameServer.logger().error(String.format("[superequipmentjewel]PCComposeJewel.processImp@ cfg jewel item not exist |roleid=%d|jewelcfgid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.jewelcfgid) }));
/*     */       
/*     */ 
/*  57 */       OnlineManager.getInstance().sendAtOnce(this.roleId, new SJewelError(7));
/*  58 */       return false;
/*     */     }
/*     */     
/*  61 */     SSuperEquipmentJewelItem cfgJewelItemNextLevel = SSuperEquipmentJewelItem.get(cfgJewelItem.nextLevelId);
/*  62 */     if (cfgJewelItemNextLevel == null)
/*     */     {
/*  64 */       GameServer.logger().error(String.format("[superequipmentjewel]PCComposeJewel.processImp@ next level not exist |roleid=%d|jewelcfgid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.jewelcfgid) }));
/*     */       
/*     */ 
/*  67 */       return false;
/*     */     }
/*     */     
/*  70 */     lock(Lockeys.get(User.getTable(), userId));
/*  71 */     lock(Lockeys.get(Basic.getTable(), Long.valueOf(this.roleId)));
/*     */     
/*     */ 
/*  74 */     int maxLevel = SuperEquipmentJewelManager.getJewelMaxLevel(this.roleId, cfgJewelItem.jewelType);
/*  75 */     if (maxLevel < cfgJewelItemNextLevel.jewelLevel)
/*     */     {
/*  77 */       GameServer.logger().error(String.format("[superequipmentjewel]PCComposeJewel.processImp@ greater then equipment state requirement |roleid=%d|jewelcfgid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.jewelcfgid) }));
/*     */       
/*     */ 
/*  80 */       OnlineManager.getInstance().sendAtOnce(this.roleId, new SJewelError(2));
/*  81 */       return false;
/*     */     }
/*     */     
/*  84 */     Map<Integer, Integer> cfgItemId2countToRemove = new HashMap();
/*  85 */     Map<Integer, Long> moneyType2moneyCount = new HashMap();
/*     */     
/*  87 */     boolean ret = SuperEquipmentJewelManager.getComposeJewelCost(userId, this.roleId, this.jewelcfgid, cfgItemId2countToRemove, moneyType2moneyCount, 0);
/*     */     
/*  89 */     if (!ret) {
/*  90 */       return false;
/*     */     }
/*     */     
/*  93 */     ret = SuperEquipmentJewelManager.deleteItemAndCutMoney(userId, this.roleId, this.jewelcfgid, cfgItemId2countToRemove, moneyType2moneyCount);
/*     */     
/*  95 */     if (!ret) {
/*  96 */       return false;
/*     */     }
/*     */     
/*  99 */     HashMap<Integer, Integer> jewelcfgid2countToAdd = new HashMap();
/* 100 */     jewelcfgid2countToAdd.put(Integer.valueOf(cfgJewelItem.nextLevelId), Integer.valueOf(1));
/*     */     
/* 102 */     ItemOperateResult itemOperateResult = ItemInterface.addItem(this.roleId, jewelcfgid2countToAdd, false, new TLogArg(LogReason.SUPER_EQUIPMENT_JEWEL_COMPOSE));
/*     */     
/* 104 */     if (itemOperateResult.isBagFull())
/*     */     {
/* 106 */       GameServer.logger().error(String.format("[superequipmentjewel]PCComposeJewel.processImp@ bag full |roleid=%d|jewelcfgid=%d|itemidtoadd=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.jewelcfgid), Integer.valueOf(cfgJewelItem.nextLevelId) }));
/*     */       
/*     */ 
/* 109 */       OnlineManager.getInstance().sendAtOnce(this.roleId, new SJewelError(8));
/* 110 */       return false;
/*     */     }
/* 112 */     if (!itemOperateResult.success())
/*     */     {
/* 114 */       GameServer.logger().error(String.format("[superequipmentjewel]PCComposeJewel.processImp@ add jewel fail |roleid=%d|jewelcfgid=%d|itemidtoadd=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.jewelcfgid), Integer.valueOf(cfgJewelItem.nextLevelId) }));
/*     */       
/*     */ 
/* 117 */       return false;
/*     */     }
/*     */     
/* 120 */     SuperEquipmentJewelTLogManager.tlogJewelCompose(this.roleId, jewelcfgid2countToAdd, cfgItemId2countToRemove, moneyType2moneyCount, 0);
/*     */     
/*     */ 
/* 123 */     OnlineManager.getInstance().send(this.roleId, new SComposeJewelSuccess(jewelcfgid2countToAdd));
/* 124 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\superequipment\jewel\main\PCComposeJewel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */