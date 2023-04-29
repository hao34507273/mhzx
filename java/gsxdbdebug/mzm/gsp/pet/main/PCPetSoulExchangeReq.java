/*     */ package mzm.gsp.pet.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.item.main.ItemOperateResult;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.pet.SPetSoulExchangeErrorRes;
/*     */ import mzm.gsp.pet.SPetSoulExchangeRes;
/*     */ import mzm.gsp.pet.confbean.PetConstants;
/*     */ import mzm.gsp.qingfu.main.CostType;
/*     */ import mzm.gsp.qingfu.main.QingfuInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Pet;
/*     */ import xbean.PetBag;
/*     */ import xbean.PetSoul;
/*     */ import xbean.PetSoulBag;
/*     */ import xtable.Role2petbag;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PCPetSoulExchangeReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final long petId1;
/*     */   private final long petId2;
/*     */   private final int useYuanbao;
/*     */   private final int useYuanbaoNum;
/*     */   private final long totalYuanbaoNum;
/*     */   
/*     */   public PCPetSoulExchangeReq(long roleId, long pet1, long pet2, int useYuanbao, int useYuanbaoNum, long totalYuanbaoNum)
/*     */   {
/*  46 */     this.roleId = roleId;
/*  47 */     this.petId1 = pet1;
/*  48 */     this.petId2 = pet2;
/*     */     
/*  50 */     this.useYuanbao = useYuanbao;
/*  51 */     this.useYuanbaoNum = useYuanbaoNum;
/*  52 */     this.totalYuanbaoNum = totalYuanbaoNum;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  59 */     if (!PetManager.isPetSwitchOpenForRole(this.roleId)) {
/*  60 */       return false;
/*     */     }
/*  62 */     if (!PetManager.isPetSoulOpen(this.roleId)) {
/*  63 */       return false;
/*     */     }
/*     */     
/*  66 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 1800, true)) {
/*  67 */       return false;
/*     */     }
/*     */     
/*  70 */     String userid = RoleInterface.getUserId(this.roleId);
/*  71 */     lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*  72 */     long totalNum = QingfuInterface.getBalance(userid, true);
/*  73 */     if (this.totalYuanbaoNum != totalNum) {
/*  74 */       return false;
/*     */     }
/*     */     
/*  77 */     PetBag xPetBag = Role2petbag.get(Long.valueOf(this.roleId));
/*  78 */     if (xPetBag == null) {
/*  79 */       return false;
/*     */     }
/*  81 */     Pet xPet1 = (Pet)xPetBag.getPetmap().get(Long.valueOf(this.petId1));
/*  82 */     if (xPet1 == null) {
/*  83 */       return false;
/*     */     }
/*     */     
/*  86 */     Pet xPet2 = (Pet)xPetBag.getPetmap().get(Long.valueOf(this.petId2));
/*  87 */     if (xPet2 == null) {
/*  88 */       return false;
/*     */     }
/*  90 */     int pet1SoulMaxLevel = getPetSoulMaxLevel(xPet1);
/*  91 */     int pet2SoulMaxLevel = getPetSoulMaxLevel(xPet2);
/*     */     
/*  93 */     if ((xPet1.getLevel() < pet2SoulMaxLevel) || (xPet2.getLevel() < pet1SoulMaxLevel)) {
/*  94 */       sendError(2);
/*  95 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  99 */     Map<Integer, Integer> costItemMap = new HashMap();
/* 100 */     int costMainItemCount = PetConstants.getInstance().PET_SOUL_EXCHANGE_ITEM_COUNT;
/* 101 */     if (PetConstants.getInstance().PET_SOUL_EXCHANGE_SUM_ITEM > 0) {
/* 102 */       int num = ItemInterface.getItemNumberById(this.roleId, PetConstants.getInstance().PET_SOUL_EXCHANGE_SUM_ITEM);
/* 103 */       if (num >= costMainItemCount) {
/* 104 */         costItemMap.put(Integer.valueOf(PetConstants.getInstance().PET_SOUL_EXCHANGE_SUM_ITEM), Integer.valueOf(costMainItemCount));
/* 105 */         costMainItemCount = 0;
/* 106 */       } else if (num > 0) {
/* 107 */         costItemMap.put(Integer.valueOf(PetConstants.getInstance().PET_SOUL_EXCHANGE_SUM_ITEM), Integer.valueOf(num));
/* 108 */         costMainItemCount -= num;
/*     */       }
/*     */     }
/* 111 */     if (costMainItemCount > 0) {
/* 112 */       Integer count = (Integer)costItemMap.get(Integer.valueOf(PetConstants.getInstance().PET_SOUL_EXCHANGE_MAIN_ITEM));
/* 113 */       if (count == null) {
/* 114 */         count = Integer.valueOf(0);
/*     */       }
/* 116 */       count = Integer.valueOf(count.intValue() + costMainItemCount);
/* 117 */       costItemMap.put(Integer.valueOf(PetConstants.getInstance().PET_SOUL_EXCHANGE_MAIN_ITEM), count);
/*     */     }
/*     */     
/* 120 */     boolean ret = false;
/* 121 */     boolean isUserYuanbao = this.useYuanbao == 1;
/* 122 */     if (isUserYuanbao) {
/* 123 */       ret = ItemInterface.removeItemsWithCutYuanbao(userid, this.roleId, CostType.COST_PET_SOUL_EXCHANGE_PROP, costItemMap, this.useYuanbaoNum, new TLogArg(LogReason.PET_SOUL_RANDOM_PROP_COST, 0));
/*     */     }
/*     */     else {
/* 126 */       ItemOperateResult itemOperateResult = ItemInterface.removeItemById(this.roleId, costItemMap, new TLogArg(LogReason.PET_SOUL_RANDOM_PROP_COST, 0));
/*     */       
/* 128 */       if (itemOperateResult.success()) {
/* 129 */         ret = true;
/*     */       } else {
/* 131 */         ret = false;
/* 132 */         sendError(3);
/* 133 */         return false;
/*     */       }
/*     */     }
/* 136 */     if (!ret) {
/* 137 */       sendError(1);
/* 138 */       return false;
/*     */     }
/*     */     
/* 141 */     Map<Integer, PetSoul> xMap1 = xPet1.getSoulbag().getSoulmap();
/* 142 */     Map<Integer, PetSoul> xMap2 = xPet2.getSoulbag().getSoulmap();
/* 143 */     Map<Integer, PetSoul> mapData1 = copyPetSoulMap(xMap1);
/* 144 */     Map<Integer, PetSoul> mapData2 = copyPetSoulMap(xMap2);
/* 145 */     xMap1.clear();
/* 146 */     xMap1.putAll(mapData2);
/* 147 */     xMap2.clear();
/* 148 */     xMap2.putAll(mapData1);
/*     */     
/* 150 */     updatePetOutFight(xPet1);
/* 151 */     updatePetOutFight(xPet2);
/*     */     
/* 153 */     SPetSoulExchangeRes protocol = new SPetSoulExchangeRes(this.petId1, this.petId2);
/* 154 */     OnlineManager.getInstance().send(this.roleId, protocol);
/* 155 */     GameServer.logger().info(String.format("[petsoul]PCPetSoulExchangeReq.processImp@exchange|roleid=%d|pet1=%d|pet2=%d|useYuanbao=%d|useYuanbaoNum=%d|subitemcount=%d|mainitemcount=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.petId1), Long.valueOf(this.petId2), Integer.valueOf(this.useYuanbao), Integer.valueOf(this.useYuanbaoNum), Integer.valueOf(PetConstants.getInstance().PET_SOUL_EXCHANGE_ITEM_COUNT - costMainItemCount), Integer.valueOf(costMainItemCount) }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 163 */     PetManager.tLogPetSoulExchange(this.roleId, this.petId1, this.petId2, this.useYuanbao, this.useYuanbaoNum);
/*     */     
/* 165 */     return true;
/*     */   }
/*     */   
/*     */   private Map<Integer, PetSoul> copyPetSoulMap(Map<Integer, PetSoul> xMap) {
/* 169 */     Map<Integer, PetSoul> map = new HashMap();
/* 170 */     Iterator<Map.Entry<Integer, PetSoul>> it = xMap.entrySet().iterator();
/* 171 */     while (it.hasNext()) {
/* 172 */       Map.Entry<Integer, PetSoul> entry = (Map.Entry)it.next();
/* 173 */       map.put(entry.getKey(), ((PetSoul)entry.getValue()).copy());
/*     */     }
/* 175 */     return map;
/*     */   }
/*     */   
/*     */   private void sendError(int code) {
/* 179 */     SPetSoulExchangeErrorRes protocol = new SPetSoulExchangeErrorRes(code);
/* 180 */     OnlineManager.getInstance().sendAtOnce(this.roleId, protocol);
/*     */   }
/*     */   
/*     */   private int getPetSoulMaxLevel(Pet xPet) {
/* 184 */     Map<Integer, PetSoul> xMap = xPet.getSoulbag().getSoulmap();
/* 185 */     Collection<PetSoul> xSouls = xMap.values();
/* 186 */     int maxLevel = 0;
/* 187 */     for (PetSoul xPetSoul : xSouls) {
/* 188 */       if (xPetSoul.getLevel() > maxLevel) {
/* 189 */         maxLevel = xPetSoul.getLevel();
/*     */       }
/*     */     }
/*     */     
/* 193 */     return maxLevel;
/*     */   }
/*     */   
/*     */   private void updatePetOutFight(Pet xPet) {
/* 197 */     PetOutFightObj pet = new PetOutFightObj(this.roleId, xPet);
/* 198 */     pet.updateSoul();
/* 199 */     xPet.setIsbinded(1);
/* 200 */     pet.syncPetInfo();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\main\PCPetSoulExchangeReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */