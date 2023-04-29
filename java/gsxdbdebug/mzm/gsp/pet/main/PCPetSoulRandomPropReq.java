/*     */ package mzm.gsp.pet.main;
/*     */ 
/*     */ import java.io.PrintStream;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Random;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.item.main.ItemOperateResult;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.pet.SPetSoulRandomPropErrorRes;
/*     */ import mzm.gsp.pet.SPetSoulRandomPropRes;
/*     */ import mzm.gsp.pet.confbean.PetConstants;
/*     */ import mzm.gsp.petsoul.confbean.SPetSoulCfg;
/*     */ import mzm.gsp.qingfu.main.QingfuInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import xbean.Pet;
/*     */ import xbean.PetBag;
/*     */ import xbean.PetSoul;
/*     */ import xbean.PetSoulBag;
/*     */ import xtable.Role2petbag;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCPetSoulRandomPropReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final long petId;
/*     */   private final int soulPos;
/*     */   private final int useYuanbao;
/*     */   private final int useYuanBaoNum;
/*     */   private final long totalYuanBaoNum;
/*     */   
/*     */   public PCPetSoulRandomPropReq(long roleId, long petId, int soulPos, int useYuanbao, int useYuanBaoNum, long totalYuanBaoNum)
/*     */   {
/*  37 */     this.roleId = roleId;
/*  38 */     this.petId = petId;
/*  39 */     this.soulPos = soulPos;
/*  40 */     this.useYuanbao = useYuanbao;
/*  41 */     this.useYuanBaoNum = useYuanBaoNum;
/*  42 */     this.totalYuanBaoNum = totalYuanBaoNum;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  48 */     if (!PetManager.isPetSwitchOpenForRole(this.roleId)) {
/*  49 */       return false;
/*     */     }
/*  51 */     if (!PetManager.isPetSoulOpen(this.roleId)) {
/*  52 */       return false;
/*     */     }
/*     */     
/*  55 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleId, 1800, true)) {
/*  56 */       return false;
/*     */     }
/*  58 */     String userid = mzm.gsp.role.main.RoleInterface.getUserId(this.roleId);
/*  59 */     lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*  60 */     long totalNum = QingfuInterface.getBalance(userid, true);
/*  61 */     if (totalNum != this.totalYuanBaoNum) {
/*  62 */       GameServer.logger().info(String.format("[petsoul]PCPetSoulRandomPropReq.processImp@total yuan bao num error|roleid=%d|sTotalNum=%d|cTotalNum=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(totalNum), Long.valueOf(this.totalYuanBaoNum) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  67 */       return false;
/*     */     }
/*     */     
/*  70 */     PetBag xPetBag = Role2petbag.get(Long.valueOf(this.roleId));
/*  71 */     if (xPetBag == null) {
/*  72 */       return false;
/*     */     }
/*  74 */     Pet xPet = (Pet)xPetBag.getPetmap().get(Long.valueOf(this.petId));
/*  75 */     if (xPet == null) {
/*  76 */       return false;
/*     */     }
/*     */     
/*  79 */     PetSoul xPetSoul = (PetSoul)xPet.getSoulbag().getSoulmap().get(Integer.valueOf(this.soulPos));
/*  80 */     if (xPetSoul == null) {
/*  81 */       PetManager.logInfo("[petsoul]PCPetSoulRandomPropReq.processImp@random petsoul prop with uninited soul|roleid=%d|soulPos=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.soulPos) });
/*     */       
/*     */ 
/*     */ 
/*  85 */       return false;
/*     */     }
/*     */     
/*  88 */     SPetSoulCfg petSoulCfg = PetManager.getPetSoulCfg(xPetSoul.getPos(), xPetSoul.getLevel());
/*  89 */     if (petSoulCfg == null) {
/*  90 */       return false;
/*     */     }
/*     */     
/*  93 */     int oldPropIndex = xPetSoul.getPropindex();
/*  94 */     int maxPropIndex = PetManager.getMaxPropIndex(petSoulCfg);
/*  95 */     if (maxPropIndex <= 1) {
/*  96 */       sendError(3);
/*  97 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 101 */     Map<Integer, Integer> costItemMap = new HashMap();
/* 102 */     int costMainItemCount = PetConstants.getInstance().soul_random_property_item_count;
/* 103 */     if (PetConstants.getInstance().soul_random_property_sub_item > 0) {
/* 104 */       int num = ItemInterface.getItemNumberById(this.roleId, PetConstants.getInstance().soul_random_property_sub_item);
/* 105 */       if (num >= costMainItemCount) {
/* 106 */         costItemMap.put(Integer.valueOf(PetConstants.getInstance().soul_random_property_sub_item), Integer.valueOf(costMainItemCount));
/* 107 */         costMainItemCount = 0;
/* 108 */       } else if (num > 0) {
/* 109 */         costItemMap.put(Integer.valueOf(PetConstants.getInstance().soul_random_property_sub_item), Integer.valueOf(num));
/* 110 */         costMainItemCount -= num;
/*     */       }
/*     */     }
/* 113 */     if (costMainItemCount > 0) {
/* 114 */       Integer count = (Integer)costItemMap.get(Integer.valueOf(PetConstants.getInstance().soul_random_property_main_item));
/* 115 */       if (count == null) {
/* 116 */         count = Integer.valueOf(0);
/*     */       }
/* 118 */       count = Integer.valueOf(count.intValue() + costMainItemCount);
/* 119 */       costItemMap.put(Integer.valueOf(PetConstants.getInstance().soul_random_property_main_item), count);
/*     */     }
/*     */     
/* 122 */     boolean ret = false;
/* 123 */     boolean isUserYuanbao = this.useYuanbao == 1;
/* 124 */     if (isUserYuanbao) {
/* 125 */       ret = ItemInterface.removeItemsWithCutYuanbao(userid, this.roleId, mzm.gsp.qingfu.main.CostType.COST_PET_SOUL_RANDOM_PROP, costItemMap, this.useYuanBaoNum, new TLogArg(LogReason.PET_SOUL_RANDOM_PROP_COST, this.soulPos));
/*     */     }
/*     */     else {
/* 128 */       ItemOperateResult itemOperateResult = ItemInterface.removeItemById(this.roleId, costItemMap, new TLogArg(LogReason.PET_SOUL_RANDOM_PROP_COST, this.soulPos));
/*     */       
/* 130 */       if (itemOperateResult.success()) {
/* 131 */         ret = true;
/*     */       } else {
/* 133 */         ret = false;
/* 134 */         sendError(1);
/* 135 */         return false;
/*     */       }
/*     */     }
/* 138 */     if (!ret) {
/* 139 */       sendError(2);
/* 140 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 144 */     int newIndex = randomNewPropIndex(oldPropIndex, maxPropIndex);
/* 145 */     xPetSoul.setPropindex(newIndex);
/*     */     
/* 147 */     SPetSoulRandomPropRes res = new SPetSoulRandomPropRes(this.petId, this.soulPos, newIndex, this.useYuanbao);
/* 148 */     OnlineManager.getInstance().send(this.roleId, res);
/*     */     
/* 150 */     PetOutFightObj pet = new PetOutFightObj(this.roleId, xPet);
/* 151 */     pet.updateSoul();
/* 152 */     xPet.setIsbinded(1);
/* 153 */     pet.syncPetInfo();
/*     */     
/* 155 */     int costSubItemCount = PetConstants.getInstance().soul_random_property_item_count - costMainItemCount;
/* 156 */     PetManager.logInfo("[petsoul]PCPetSoulRandomPropReq.processImp@random petsoul prop |roleid=%d|soulPos=%d|newindex=%d|oldindex=%d|costMainItemCount=%d|subItemCount=%d|isuseryuanbao=%d|useYuanBaoNum=%d|totalYuanBaoNum=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.soulPos), Integer.valueOf(newIndex), Integer.valueOf(oldPropIndex), Integer.valueOf(costMainItemCount), Integer.valueOf(costSubItemCount), Integer.valueOf(this.useYuanbao), Integer.valueOf(this.useYuanBaoNum), Long.valueOf(this.totalYuanBaoNum) });
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 162 */     PetManager.tLogPetSoulRandom(this.roleId, this.petId, this.useYuanbao, this.useYuanBaoNum, this.totalYuanBaoNum, oldPropIndex, xPetSoul, costMainItemCount, costSubItemCount);
/*     */     
/* 164 */     return true;
/*     */   }
/*     */   
/*     */   private void sendError(int error) {
/* 168 */     SPetSoulRandomPropErrorRes res = new SPetSoulRandomPropErrorRes();
/* 169 */     res.ret = error;
/* 170 */     OnlineManager.getInstance().sendAtOnce(this.roleId, res);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static int randomNewPropIndex(int excludeIndex, int maxIndex)
/*     */   {
/* 180 */     int i = xdb.Xdb.random().nextInt(maxIndex - 1) + 1;
/* 181 */     if (i >= excludeIndex) {
/* 182 */       i++;
/*     */     }
/* 184 */     return i;
/*     */   }
/*     */   
/*     */   public static void main(String[] args)
/*     */   {
/* 189 */     for (int i = 0; i < 50; i++) {
/* 190 */       System.out.println(randomNewPropIndex(3, 5));
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\main\PCPetSoulRandomPropReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */