/*    */ package mzm.gsp.pet.main;
/*    */ 
/*    */ import java.util.HashSet;
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ import java.util.Random;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.item.confbean.SPetExpItem;
/*    */ import mzm.gsp.item.main.BasicItem;
/*    */ import mzm.gsp.item.main.ItemInterface;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.pet.SPetNormalResult;
/*    */ import mzm.gsp.pet.SUseExpItemRes;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ import xbean.Pet;
/*    */ import xbean.PetBag;
/*    */ import xtable.Role2petbag;
/*    */ 
/*    */ public class PAutoUsePetExpItemReq extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private long roleId;
/*    */   private long petId;
/*    */   private int itemKey;
/*    */   
/*    */   public PAutoUsePetExpItemReq(long roleId, long petId, int itemKey)
/*    */   {
/* 28 */     this.roleId = roleId;
/* 29 */     this.petId = petId;
/* 30 */     this.itemKey = itemKey;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 36 */     if (!PetManager.isPetSwitchOpenForRole(this.roleId)) {
/* 37 */       return false;
/*    */     }
/*    */     
/* 40 */     PetBag xPetBag = Role2petbag.get(Long.valueOf(this.roleId));
/* 41 */     Pet xPet = (Pet)xPetBag.getPetmap().get(Long.valueOf(this.petId));
/* 42 */     if (xPet == null) {
/* 43 */       PetManager.logDebug("PAutoUsePetExpItemReq.processImp@xdb pet not existed|roleid=%d|petid=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.petId) });
/* 44 */       return false;
/*    */     }
/*    */     
/* 47 */     PetOutFightObj obj = new PetOutFightObj(this.roleId, xPet);
/*    */     
/* 49 */     if (obj.getMaxLevel() <= obj.getLevel()) {
/* 50 */       SPetNormalResult normalResult = new SPetNormalResult();
/* 51 */       normalResult.result = 8;
/* 52 */       OnlineManager.getInstance().sendAtOnce(this.roleId, normalResult);
/* 53 */       return false;
/*    */     }
/*    */     
/* 56 */     BasicItem basicItem = ItemInterface.getItem(this.roleId, this.itemKey);
/* 57 */     if (basicItem == null) {
/* 58 */       PetManager.logDebug("PAutoUsePetExpItemReq.processImp@use item not existed|roleid=%d|itemid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemKey) });
/* 59 */       return false;
/*    */     }
/* 61 */     SPetExpItem sPetExpItem = SPetExpItem.get(basicItem.getCfgId());
/* 62 */     if (sPetExpItem == null) {
/* 63 */       PetManager.logDebug("PAutoUsePetExpItemReq.processImp@use item not existed|roleid=%d|itemid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemKey) });
/* 64 */       return false;
/*    */     }
/* 66 */     int addExp = 0;
/* 67 */     Set<Long> idSet = new HashSet();
/* 68 */     Iterator<Long> xIdIt = basicItem.getUuid().iterator();
/*    */     
/* 70 */     while (xIdIt.hasNext()) {
/* 71 */       Long id = (Long)xIdIt.next();
/* 72 */       if (obj.getMaxLevel() <= obj.getLevel()) {
/*    */         break;
/*    */       }
/* 75 */       idSet.add(id);
/* 76 */       addExp = getRandomValue(sPetExpItem.lowExpLimit, sPetExpItem.maxExpLimit);
/*    */       
/* 78 */       obj.addExp(addExp);
/*    */     }
/*    */     
/* 81 */     if (!ItemInterface.removeItemByUuid(this.roleId, basicItem.getFirstUuid().longValue(), idSet.size(), new TLogArg(LogReason.PET_USE_EXP_REM))) {
/* 82 */       PetManager.logDebug("PAutoUsePetExpItemReq.processImp@use item not existed|roleid=%d|itemid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemKey) });
/* 83 */       return false;
/*    */     }
/* 85 */     SUseExpItemRes res = new SUseExpItemRes();
/* 86 */     res.addexp = addExp;
/* 87 */     res.petid = this.petId;
/* 88 */     OnlineManager.getInstance().send(this.roleId, res);
/* 89 */     return true;
/*    */   }
/*    */   
/*    */   private int getRandomValue(int min, int max) {
/* 93 */     if (min == max) {
/* 94 */       return min;
/*    */     }
/* 96 */     return xdb.Xdb.random().nextInt(max - min) + min;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\main\PAutoUsePetExpItemReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */