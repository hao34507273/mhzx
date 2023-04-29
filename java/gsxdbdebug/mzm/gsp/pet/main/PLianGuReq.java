/*     */ package mzm.gsp.pet.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.item.confbean.SPetDecorateItemCfg;
/*     */ import mzm.gsp.item.confbean.SPetLianGuItem;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.pet.SLianGuRes;
/*     */ import mzm.gsp.pet.SPetNormalResult;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.CommonUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Aptitude;
/*     */ import xbean.Item;
/*     */ import xbean.Pet;
/*     */ import xbean.PetBag;
/*     */ import xbean.PetEquipBag;
/*     */ import xtable.Role2petbag;
/*     */ 
/*     */ public class PLianGuReq
/*     */   extends LogicProcedure
/*     */ {
/*  33 */   private static final Logger logger = Logger.getLogger(PLianGuReq.class);
/*     */   private final long roleId;
/*     */   private final long petId;
/*     */   private final int aptType;
/*     */   
/*     */   public PLianGuReq(long roleId, long petId, int aptType) {
/*  39 */     this.roleId = roleId;
/*  40 */     this.petId = petId;
/*  41 */     this.aptType = aptType;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  47 */     if (!PetManager.isPetSwitchOpenForRole(this.roleId)) {
/*  48 */       return false;
/*     */     }
/*     */     
/*  51 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 198, true)) {
/*  52 */       Set<Integer> statusSet = RoleStatusInterface.getStatusSet(this.roleId);
/*  53 */       GameServer.logger().error(String.format("[pet]PLianGuReq.processImp@ role in STATUS_ROAM not use fun!|roleid=%d|status_set=%s", new Object[] { Long.valueOf(this.roleId), statusSet }));
/*     */       
/*     */ 
/*  56 */       return false;
/*     */     }
/*     */     
/*  59 */     PetBag xPetBag = Role2petbag.get(Long.valueOf(this.roleId));
/*  60 */     if (xPetBag == null) {
/*  61 */       return false;
/*     */     }
/*  63 */     Pet xPet = (Pet)xPetBag.getPetmap().get(Long.valueOf(this.petId));
/*  64 */     if (xPet == null) {
/*  65 */       return false;
/*     */     }
/*  67 */     SLianGuRes res = new SLianGuRes();
/*  68 */     res.petid = this.petId;
/*  69 */     Aptitude xApt = xPet.getAptitude();
/*  70 */     PetCfg petCfg = PetManager.getInstance().getPetCfg(xPet.getTemplateid());
/*  71 */     if (petCfg == null) {
/*  72 */       return false;
/*     */     }
/*     */     
/*  75 */     if (xPet.getLianguitemusenum() >= petCfg.getLianguItemLimit()) {
/*  76 */       SPetNormalResult sPetNormalResult = new SPetNormalResult();
/*  77 */       sPetNormalResult.result = 25;
/*  78 */       OnlineManager.getInstance().sendAtOnce(this.roleId, sPetNormalResult);
/*  79 */       return false;
/*     */     }
/*     */     
/*  82 */     Item decorateItem = (Item)xPet.getEquipbag().getEquip2item().get(Integer.valueOf(3));
/*  83 */     if (petCfg.isWild()) {
/*  84 */       SPetNormalResult normalResult = new SPetNormalResult();
/*  85 */       normalResult.result = 21;
/*  86 */       OnlineManager.getInstance().sendAtOnce(this.roleId, normalResult);
/*  87 */       return false;
/*     */     }
/*  89 */     int addApt = 0;
/*  90 */     if (decorateItem != null) {
/*  91 */       SPetDecorateItemCfg cfg = SPetDecorateItemCfg.get(decorateItem.getCfgid());
/*  92 */       addApt = cfg.addRealAptMaxLimit;
/*     */     }
/*  94 */     int currentValue = ((Integer)xApt.getAptmap().get(Integer.valueOf(this.aptType))).intValue();
/*  95 */     int addValue = lianGuAction(currentValue, ((Integer)xApt.getAptlimitmap().get(Integer.valueOf(this.aptType))).intValue() + addApt, petCfg.getMinApt(this.aptType).intValue());
/*  96 */     if (addValue < 0) {
/*  97 */       return false;
/*     */     }
/*  99 */     xApt.getAptmap().put(Integer.valueOf(this.aptType), Integer.valueOf(currentValue + addValue));
/* 100 */     res.aptmap.put(Integer.valueOf(this.aptType), Integer.valueOf(addValue));
/* 101 */     xPet.setLianguitemusenum(xPet.getLianguitemusenum() + 1);
/* 102 */     int leftNum = petCfg.getLianguItemLimit() - xPet.getLianguitemusenum();
/* 103 */     if (leftNum < 0) {
/* 104 */       leftNum = 0;
/*     */     }
/* 106 */     res.lianguitemleft = leftNum;
/* 107 */     OnlineManager.getInstance().send(this.roleId, res);
/* 108 */     xPet.setIsbinded(1);
/*     */     
/* 110 */     PetOutFightObj obj = new PetOutFightObj(this.roleId, xPet);
/* 111 */     obj.syncPetInfo();
/*     */     
/* 113 */     TLogManager.getInstance().addLog(this.roleId, "PetLiangu", PetManager.createTLog(new Object[] { GameServerInfoManager.getHostIP(), RoleInterface.getUserId(this.roleId), Long.valueOf(this.roleId), Long.valueOf(this.petId), Integer.valueOf(petCfg.getId()), Integer.valueOf(this.aptType), Integer.valueOf(currentValue), Integer.valueOf(currentValue + addValue) }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 123 */     return true;
/*     */   }
/*     */   
/*     */   private int lianGuAction(int current, int max, int min) {
/* 127 */     if (current == max) {
/* 128 */       return 0;
/*     */     }
/* 130 */     List<Integer> removeIdList = PetManager.getInstance().getLianGuItemStateSqeuenceIdList();
/* 131 */     int lianGuId = -1;
/* 132 */     for (int i = 0; i < removeIdList.size(); i++) {
/* 133 */       int removeId = ((Integer)removeIdList.get(i)).intValue();
/* 134 */       if (ItemInterface.removeItemById(this.roleId, 340600000, removeId, 1, new TLogArg(LogReason.PET_LIANGU_REM, removeId)))
/*     */       {
/*     */ 
/* 137 */         lianGuId = removeId; }
/*     */     }
/* 139 */     if (lianGuId == -1) {
/* 140 */       return -1;
/*     */     }
/* 142 */     int linaGuValue = -1;
/* 143 */     SPetLianGuItem itemCfg = SPetLianGuItem.get(lianGuId);
/* 144 */     int offset = max - current;
/*     */     
/* 146 */     float expval = offset * itemCfg.expectAddRate / 10000;
/* 147 */     int random = CommonUtils.random((int)(expval - Math.min(expval * itemCfg.floatExpectRate / 10000.0F, itemCfg.floatMaxNum)), (int)(expval + Math.min(expval * itemCfg.floatExpectRate / 10000.0F, itemCfg.floatMaxNum)));
/*     */     
/* 149 */     linaGuValue = Math.max(random, itemCfg.minAddNum);
/* 150 */     if (linaGuValue + current > max) {
/* 151 */       linaGuValue = max - current;
/*     */     }
/* 153 */     if (logger.isDebugEnabled()) {
/* 154 */       logger.debug("liangu add apt : " + linaGuValue);
/*     */     }
/*     */     
/* 157 */     return linaGuValue;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\main\PLianGuReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */