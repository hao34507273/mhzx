/*      */ package mzm.gsp.pet.main;
/*      */ 
/*      */ import java.util.ArrayList;
/*      */ import java.util.Calendar;
/*      */ import java.util.Collection;
/*      */ import java.util.HashMap;
/*      */ import java.util.Iterator;
/*      */ import java.util.LinkedList;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import java.util.Random;
/*      */ import mzm.event.TriggerEventsManger;
/*      */ import mzm.gsp.GameServer;
/*      */ import mzm.gsp.GameServerInfoManager;
/*      */ import mzm.gsp.bag.confbean.SBagCfg;
/*      */ import mzm.gsp.item.confbean.SItemCfg;
/*      */ import mzm.gsp.item.confbean.SPetLianGuItem;
/*      */ import mzm.gsp.item.main.ItemInterface;
/*      */ import mzm.gsp.mail.main.MailInterface;
/*      */ import mzm.gsp.occupation.confbean.SDefaultAddPointCase;
/*      */ import mzm.gsp.online.main.OnlineManager;
/*      */ import mzm.gsp.open.main.OpenInterface;
/*      */ import mzm.gsp.pet.SPetNormalResult;
/*      */ import mzm.gsp.pet.SSyncAddPet;
/*      */ import mzm.gsp.pet.SSyncPetStateChange;
/*      */ import mzm.gsp.pet.confbean.PetConstants;
/*      */ import mzm.gsp.pet.confbean.SPetCfg;
/*      */ import mzm.gsp.pet.confbean.SPetExp2Level;
/*      */ import mzm.gsp.pet.confbean.SPetRandomRedeemCfg;
/*      */ import mzm.gsp.pet.confbean.SPetRandomRedeemCostItemCfg;
/*      */ import mzm.gsp.pet.confbean.SPetRedeemCostItemCfg;
/*      */ import mzm.gsp.pet.confbean.SPetShopCfg;
/*      */ import mzm.gsp.pet.confbean.SPetSkillScoreCfg;
/*      */ import mzm.gsp.pet.confbean.SPetSpecialSkillConf;
/*      */ import mzm.gsp.pet.confbean.STPetEquipTypeLevel;
/*      */ import mzm.gsp.pet.confbean.STPetEquipTypeLevelInfo;
/*      */ import mzm.gsp.pet.event.PetEventArg;
/*      */ import mzm.gsp.pet.event.PetJoinFight;
/*      */ import mzm.gsp.pet.event.PlayerDeletePet;
/*      */ import mzm.gsp.pet.event.PlayerShowPetChange;
/*      */ import mzm.gsp.petequip.confbean.SPetEquipItem;
/*      */ import mzm.gsp.petsoul.confbean.SPetPropBean;
/*      */ import mzm.gsp.petsoul.confbean.SPetSoulCfg;
/*      */ import mzm.gsp.petsoul.confbean.SPetSoulCfgPos2Level;
/*      */ import mzm.gsp.qingfu.main.CostResult;
/*      */ import mzm.gsp.qingfu.main.CostType;
/*      */ import mzm.gsp.qingfu.main.QingfuInterface;
/*      */ import mzm.gsp.role.main.RoleInterface;
/*      */ import mzm.gsp.skill.confbean.SPassiveSkillCfg;
/*      */ import mzm.gsp.skill.confbean.SSkillCfg;
/*      */ import mzm.gsp.tlog.TLogArg;
/*      */ import mzm.gsp.tlog.TLogManager;
/*      */ import mzm.gsp.util.UuidUtils;
/*      */ import mzm.gsp.util.UuidUtils.UuidType;
/*      */ import org.apache.log4j.Logger;
/*      */ import xbean.Aptitude;
/*      */ import xbean.Item;
/*      */ import xbean.Pet;
/*      */ import xbean.PetBag;
/*      */ import xbean.PetDepot;
/*      */ import xbean.PetEquipBag;
/*      */ import xbean.PetOutFightBean;
/*      */ import xbean.PetSkill;
/*      */ import xbean.PetSoul;
/*      */ import xbean.Pod;
/*      */ import xbean.Role2PetBean;
/*      */ import xdb.Executor;
/*      */ import xdb.Xdb;
/*      */ import xdb.logs.Listener;
/*      */ import xdb.logs.Note;
/*      */ import xtable.Role2petbag;
/*      */ import xtable.Role2petdepot;
/*      */ import xtable.Role2petoutfightbean;
/*      */ 
/*      */ class PetManager
/*      */ {
/*      */   static final int WAN = 10000;
/*      */   static final int BAI_WAN = 1000000;
/*      */   static final int SKILL_SCORE_RATE = 1;
/*      */   static final int PET_MAIL_NUM = 8;
/*      */   static final int DECORATE = 3;
/*   83 */   private static final Logger logger = Logger.getLogger(PetManager.class);
/*      */   
/*      */   public static final String TPET_FANSHENG_LOG = "PetFanSheng";
/*      */   
/*      */   public static final String TPET_GET_LOG = "PetGet";
/*      */   
/*      */   public static final String TPET_DELETE_LOG = "PetDelete";
/*      */   
/*      */   public static final long MILLIS = 86400000L;
/*      */   
/*   93 */   private static PetManager instance = new PetManager();
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static final int PET_BAG_ID = 340600003;
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static final int PET_DEPOT_ID = 340600004;
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  113 */   public static int autoAssignPointLimit = 10;
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static PetManager getInstance()
/*      */   {
/*  121 */     return instance;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public PetCfg randomPetByType(int petType)
/*      */   {
/*  132 */     List<Integer> typeList = new ArrayList();
/*  133 */     for (SPetCfg petCfg : SPetCfg.getAll().values())
/*      */     {
/*  135 */       if (petCfg.type == petType)
/*      */       {
/*  137 */         typeList.add(Integer.valueOf(petCfg.templateId));
/*      */       }
/*      */     }
/*  140 */     int idx = Xdb.random().nextInt(typeList.size());
/*  141 */     return new PetCfg(idx);
/*      */   }
/*      */   
/*      */   public void init(Map<String, String> envs)
/*      */   {
/*  146 */     autoAssignPointLimit = Integer.parseInt((String)envs.get("autoAssignPointLimit"));
/*  147 */     if (SBagCfg.get(340600003) == null)
/*      */     {
/*  149 */       throw new RuntimeException("pet bag config is null");
/*      */     }
/*  151 */     if (SBagCfg.get(340600004) == null)
/*      */     {
/*  153 */       throw new RuntimeException("pet depot config is null");
/*      */     }
/*      */     
/*  156 */     Role2petbag.getTable().addListener(new Listener()
/*      */     {
/*      */       public void onChanged(Object o) {}
/*      */       
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       public void onRemoved(Object o) {}
/*      */       
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       public void onChanged(Object o, String s, Note note)
/*      */       {
/*  173 */         long roleId = ((Long)o).longValue();
/*  174 */         PetBag xPetbag = Role2petbag.get(Long.valueOf(roleId));
/*  175 */         long fightPet = xPetbag.getFightpet();
/*  176 */         if (fightPet > 0L)
/*      */         {
/*  178 */           PetEventArg arg = new PetEventArg();
/*  179 */           arg.petId = fightPet;
/*  180 */           arg.roleId = roleId;
/*  181 */           TriggerEventsManger.getInstance().triggerEventAtOnce(new PetJoinFight(), arg); } } }, new String[] { "value", "fightpet" });
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   Integer getScorebySkillId(int skillId)
/*      */   {
/*  196 */     SPetSkillScoreCfg sPetSkillScoreCfg = SPetSkillScoreCfg.get(skillId);
/*  197 */     if (sPetSkillScoreCfg == null)
/*      */     {
/*  199 */       return null;
/*      */     }
/*  201 */     return Integer.valueOf(sPetSkillScoreCfg.score);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   Integer getSkillStagebySkillId(int skillId)
/*      */   {
/*  212 */     SPetSkillScoreCfg sPetSkillScoreCfg = SPetSkillScoreCfg.get(skillId);
/*  213 */     if (sPetSkillScoreCfg == null)
/*      */     {
/*  215 */       return null;
/*      */     }
/*  217 */     return Integer.valueOf(sPetSkillScoreCfg.skillLevel);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   boolean isSkillCanHuaSheng(int skillId)
/*      */   {
/*  228 */     SPetSpecialSkillConf specialSkillConf = SPetSpecialSkillConf.get(skillId);
/*  229 */     if (specialSkillConf == null)
/*      */     {
/*  231 */       return true;
/*      */     }
/*      */     
/*      */ 
/*  235 */     return specialSkillConf.canHuaSheng;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean isSkillAutoRemember(int skillId)
/*      */   {
/*  246 */     SPetSpecialSkillConf specialSkillConf = SPetSpecialSkillConf.get(skillId);
/*  247 */     if ((specialSkillConf != null) && (specialSkillConf.isAutoRemember)) {
/*  248 */       return true;
/*      */     }
/*  250 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   List<Integer> getLianGuItemStateSqeuenceIdList()
/*      */   {
/*  259 */     List<Integer> lianGuItemStateSqeuenceIdList = new ArrayList();
/*  260 */     for (SItemCfg lianGuItem : SPetLianGuItem.getAllSelf().values()) {
/*  261 */       if (lianGuItem.isProprietary) {
/*  262 */         lianGuItemStateSqeuenceIdList.add(0, Integer.valueOf(lianGuItem.id));
/*      */       }
/*      */       else
/*  265 */         lianGuItemStateSqeuenceIdList.add(Integer.valueOf(lianGuItem.id));
/*      */     }
/*  267 */     return lianGuItemStateSqeuenceIdList;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public Integer randomEquipId(int equipType, int level)
/*      */   {
/*  279 */     STPetEquipTypeLevel stPetEquipTypeLevel = STPetEquipTypeLevel.get(equipType);
/*  280 */     if (stPetEquipTypeLevel == null) {
/*  281 */       return null;
/*      */     }
/*  283 */     STPetEquipTypeLevelInfo sTPetEquipTypeLevelInfo = (STPetEquipTypeLevelInfo)stPetEquipTypeLevel.level2equipIds.get(Integer.valueOf(level));
/*  284 */     if (sTPetEquipTypeLevelInfo == null) {
/*  285 */       return null;
/*      */     }
/*  287 */     return (Integer)sTPetEquipTypeLevelInfo.petequipinfo.get(Xdb.random().nextInt(sTPetEquipTypeLevelInfo.petequipinfo.size()));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public int getAutoAssignPointLimit()
/*      */   {
/*  297 */     return autoAssignPointLimit;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public int getMaxLevel()
/*      */   {
/*  306 */     return SPetExp2Level.getAll().size();
/*      */   }
/*      */   
/*      */   public PetCfg getPetCfg(int id) {
/*  310 */     SPetCfg sPetCfg = SPetCfg.get(id);
/*  311 */     if (sPetCfg == null) {
/*  312 */       logDebug("PetCfg.getsPetCfg@petcfg not find in cfg!|petid=%d", new Object[] { Integer.valueOf(id) });
/*  313 */       return null;
/*      */     }
/*  315 */     return new PetCfg(id);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public long createPet(long roleId, int petCfgId)
/*      */   {
/*  328 */     PetCfg petCfg = new PetCfg(petCfgId);
/*  329 */     if (petCfg.getsPetCfg() == null) {
/*  330 */       return -1L;
/*      */     }
/*  332 */     return createPet(roleId, petCfgId, 0);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public PetDepot createDepot(long roleId)
/*      */   {
/*  342 */     PetDepot xDepot = Pod.newPetDepot();
/*  343 */     SBagCfg bagCfg = SBagCfg.get(340600004);
/*  344 */     xDepot.setDepotsize(bagCfg.initcapacity);
/*  345 */     Role2petdepot.add(Long.valueOf(roleId), xDepot);
/*  346 */     return xDepot;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   long createPet(long roleId, int petCfgId, int binded)
/*      */   {
/*  361 */     Pet xPet = Pod.newPet();
/*  362 */     long petId = createPetAction(roleId, petCfgId, binded, xPet);
/*  363 */     if (petId <= 0L) {
/*  364 */       return petId;
/*      */     }
/*  366 */     PetOutFightObj petPropObj = new PetOutFightObj(roleId, xPet);
/*  367 */     SSyncAddPet sSyncAddPet = new SSyncAddPet();
/*  368 */     petPropObj.fillPetInfo(sSyncAddPet.petinfo);
/*  369 */     petPropObj.updateOutFightProperty();
/*  370 */     OnlineManager.getInstance().send(roleId, sSyncAddPet);
/*  371 */     return petId;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   long createPetAction(long roleId, int petCfgId, int binded, Pet xPet)
/*      */   {
/*  384 */     PetCfg petCfg = new PetCfg(petCfgId);
/*  385 */     if (petCfg.getsPetCfg() == null) {
/*  386 */       logger.error(String.format("can not find pet cfg from id %d", new Object[] { Integer.valueOf(petCfgId) }));
/*  387 */       return -1L;
/*      */     }
/*  389 */     PetBag xPetBag = Role2petbag.get(Long.valueOf(roleId));
/*  390 */     if (xPetBag == null) {
/*  391 */       return -3L;
/*      */     }
/*  393 */     if (xPetBag.getPetmap().size() == xPetBag.getBagsize()) {
/*  394 */       logger.warn(String.format("add pet detected pet bag is full!", new Object[0]));
/*  395 */       return -3L;
/*      */     }
/*  397 */     long petId = UuidUtils.generateUuid(UuidUtils.UuidType.Pet);
/*  398 */     if (petId < 0L) {
/*  399 */       logger.error(String.format("allocated pet id failed!", new Object[0]));
/*  400 */       return -2L;
/*      */     }
/*      */     
/*  403 */     xPet.setRememberskillid(-1);
/*  404 */     List<Integer> skillList = petCfg.getBornSkillList();
/*  405 */     for (Iterator i$ = skillList.iterator(); i$.hasNext();) { int skillId = ((Integer)i$.next()).intValue();
/*  406 */       PetSkill xPetSkill = Pod.newPetSkill();
/*  407 */       xPetSkill.setSkillid(skillId);
/*  408 */       xPetSkill.setSkillfrom(0);
/*  409 */       xPet.getSkilllist().add(xPetSkill);
/*  410 */       if (isSkillAutoRemember(skillId)) {
/*  411 */         xPet.setRememberskillid(skillId);
/*      */       }
/*      */     }
/*  414 */     Aptitude xAptitude = xPet.getAptitude();
/*  415 */     int[] aptArray = { 0, 1, 2, 3, 4, 5 };
/*      */     
/*      */ 
/*  418 */     for (int aptType : aptArray) {
/*  419 */       int aptLimitValue = petCfg.getRandomAptLimit(aptType);
/*  420 */       xAptitude.getAptlimitmap().put(Integer.valueOf(aptType), Integer.valueOf(aptLimitValue));
/*  421 */       xAptitude.getAptmap().put(Integer.valueOf(aptType), Integer.valueOf(petCfg.getRandomApt(aptType, aptLimitValue)));
/*      */     }
/*      */     
/*  424 */     xPet.setLife(petCfg.getLife());
/*  425 */     xPet.setGrow(petCfg.getGrow());
/*  426 */     xPet.setId(petId);
/*  427 */     xPet.setLevel(0);
/*  428 */     xPet.setPetname(petCfg.getName());
/*  429 */     xPet.setTemplateid(petCfg.getId());
/*  430 */     xPet.setExp(0);
/*  431 */     PetOutFightObj petPropObj = new PetOutFightObj(roleId, xPet);
/*  432 */     xPet.setHp(petPropObj.getFinalMaxHP());
/*  433 */     xPet.setMp(petPropObj.getFinalMaxMP());
/*  434 */     xPet.setIsautospecialpoint(false);
/*  435 */     xPet.setPotentialpoint(0);
/*  436 */     xPet.setLianguitemusenum(0);
/*  437 */     xPet.setGrowitemusenum(0);
/*  438 */     xPet.setFanshengunbianyinum(0);
/*  439 */     xPet.setStagelevel(0);
/*      */     
/*  441 */     if (petCfg.isSpecial()) {
/*  442 */       binded = 1;
/*      */     }
/*  444 */     xPet.setIsbinded(binded);
/*      */     
/*      */ 
/*  447 */     if (petCfg.getIsAutoSetPoint()) {
/*  448 */       SDefaultAddPointCase sDefaultAddPointCase = petCfg.getdefaultPetPointCfg();
/*  449 */       if (sDefaultAddPointCase != null) {
/*  450 */         xPet.getAutospecialpointcase().put(Integer.valueOf(25), Integer.valueOf(sDefaultAddPointCase.STR));
/*  451 */         xPet.getAutospecialpointcase().put(Integer.valueOf(29), Integer.valueOf(sDefaultAddPointCase.STA));
/*  452 */         xPet.getAutospecialpointcase().put(Integer.valueOf(27), Integer.valueOf(sDefaultAddPointCase.SPR));
/*  453 */         xPet.getAutospecialpointcase().put(Integer.valueOf(28), Integer.valueOf(sDefaultAddPointCase.CON));
/*  454 */         xPet.getAutospecialpointcase().put(Integer.valueOf(26), Integer.valueOf(sDefaultAddPointCase.DEX));
/*      */         
/*  456 */         xPet.setIsautospecialpoint(true);
/*      */       }
/*      */     }
/*  459 */     xPetBag.getPetmap().put(Long.valueOf(petId), xPet);
/*      */     
/*  461 */     PetEventArg arg = new PetEventArg();
/*  462 */     arg.petId = petId;
/*  463 */     arg.roleId = roleId;
/*  464 */     TriggerEventsManger.getInstance().triggerEvent(new mzm.gsp.pet.event.PlayerAddPet(), arg);
/*  465 */     return petId;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   PetBag createPetBag(long roleId)
/*      */   {
/*  475 */     PetBag xPetBag = Role2petbag.get(Long.valueOf(roleId));
/*  476 */     if (xPetBag != null) {
/*  477 */       return xPetBag;
/*      */     }
/*  479 */     xPetBag = Pod.newPetBag();
/*  480 */     xPetBag.setShowpet(-1L);
/*  481 */     xPetBag.setFightpet(-1L);
/*  482 */     SBagCfg bagCfg = SBagCfg.get(340600003);
/*  483 */     xPetBag.setBagsize(bagCfg.initcapacity);
/*  484 */     Role2petbag.add(Long.valueOf(roleId), xPetBag);
/*  485 */     return xPetBag;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static int getPortentialPointPerLevel()
/*      */   {
/*  494 */     return PetConstants.getInstance().ADD_POTENTIAL_PER_LEVEL;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public boolean isCanCarray(long roleId, int templateId)
/*      */   {
/*  505 */     PetCfg pc = new PetCfg(templateId);
/*  506 */     if (pc.getsPetCfg() == null) {
/*  507 */       return false;
/*      */     }
/*  509 */     long roleLevel = RoleInterface.getLevel(roleId);
/*  510 */     return roleLevel >= pc.getCarrayLevel();
/*      */   }
/*      */   
/*      */   public int getPetMaxLevel() {
/*  514 */     return 1;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public boolean removeItemAndYuanBao(String userid, long roleId, int itemId, int itemNum, CostType costType, TLogArg logArg)
/*      */   {
/*  534 */     int bagItemNum = ItemInterface.getItemNumberById(roleId, itemId);
/*  535 */     int needCount = itemNum - bagItemNum;
/*  536 */     if (ItemInterface.removeItemById(roleId, 340600000, itemId, itemNum, logArg)) {
/*  537 */       return true;
/*      */     }
/*      */     
/*  540 */     if (needCount > 0) {
/*  541 */       long yuanbaoNum = needCount * ItemInterface.getItemYuanBaoPrice(itemId);
/*      */       
/*  543 */       if (QingfuInterface.costYuanbao(userid, roleId, (int)yuanbaoNum, costType, logArg) != CostResult.Success) {
/*  544 */         logDebug("PetManager.removeItemAndYuanBao@yuanbao not enough|roleid=%d|yuanbaoNum=%d", new Object[] { Long.valueOf(roleId), Long.valueOf(yuanbaoNum) });
/*      */         
/*  546 */         return false;
/*      */       }
/*      */       
/*  549 */       if ((bagItemNum > 0) && 
/*  550 */         (!ItemInterface.removeItemById(roleId, 340600000, itemId, bagItemNum, logArg))) {
/*  551 */         logDebug("PetManager.removeItemAndYuanBao@not have bagItemNum|roleid=%d|itemId=%d|bagItemNum=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(itemId), Integer.valueOf(bagItemNum) });
/*      */         
/*  553 */         return false;
/*      */       }
/*      */     }
/*      */     
/*  557 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public boolean isInShop(int petCfgId)
/*      */   {
/*  567 */     return SPetShopCfg.getAll().containsKey(Integer.valueOf(petCfgId));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public SPetRandomRedeemCfg randomRedeemShenShou()
/*      */   {
/*  576 */     List<Integer> shenShouPetRedeemIdList = new ArrayList();
/*  577 */     int shenShouPetTotalWeight = 0;
/*  578 */     getRedeemIdListAndWeight(shenShouPetRedeemIdList, shenShouPetTotalWeight, 3);
/*  579 */     return randomRedeemPetCfg(shenShouPetRedeemIdList, shenShouPetTotalWeight);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public SPetRandomRedeemCfg randomRedeemMoShou()
/*      */   {
/*  588 */     List<Integer> moShouPetRedeemIdList = new ArrayList();
/*  589 */     int moShouPetTotalWeight = 0;
/*  590 */     getRedeemIdListAndWeight(moShouPetRedeemIdList, moShouPetTotalWeight, 4);
/*  591 */     return randomRedeemPetCfg(moShouPetRedeemIdList, moShouPetTotalWeight);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private void getRedeemIdListAndWeight(List<Integer> redeemIdList, int weight, int type)
/*      */   {
/*  602 */     for (SPetRandomRedeemCfg cfg : SPetRandomRedeemCfg.getAll().values()) {
/*  603 */       PetCfg pet = getInstance().getPetCfg(cfg.petId);
/*  604 */       if (pet != null)
/*      */       {
/*      */ 
/*  607 */         if (pet.getPetType() == type) {
/*  608 */           redeemIdList.add(Integer.valueOf(cfg.id));
/*  609 */           weight += cfg.weight;
/*      */         }
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private SPetRandomRedeemCfg randomRedeemPetCfg(List<Integer> idList, int totalWeight)
/*      */   {
/*  622 */     if (idList.isEmpty()) {
/*  623 */       return null;
/*      */     }
/*  625 */     int prop = Xdb.random().nextInt(totalWeight);
/*  626 */     int weight = 0;
/*  627 */     for (Integer id : idList) {
/*  628 */       SPetRandomRedeemCfg cfg = SPetRandomRedeemCfg.get(id.intValue());
/*  629 */       weight += cfg.weight;
/*  630 */       if (prop < weight) {
/*  631 */         return cfg;
/*      */       }
/*      */     }
/*  634 */     return null;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public SPetRandomRedeemCostItemCfg getRandomRedeemCost(int petType)
/*      */   {
/*  644 */     for (SPetRandomRedeemCostItemCfg cfg : SPetRandomRedeemCostItemCfg.getAll().values()) {
/*  645 */       if (cfg.petType == petType) {
/*  646 */         return cfg;
/*      */       }
/*      */     }
/*  649 */     return null;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public SPetRedeemCostItemCfg getPetRedeemCostItemCfg(int petId)
/*      */   {
/*  659 */     for (SPetRedeemCostItemCfg cfg : SPetRedeemCostItemCfg.getAll().values()) {
/*  660 */       if (cfg.petId == petId) {
/*  661 */         return cfg;
/*      */       }
/*      */     }
/*  664 */     return null;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static String createTLog(Object... objects)
/*      */   {
/*  674 */     StringBuilder stringBuilder = new StringBuilder();
/*  675 */     for (int i = 0; i < objects.length; i++) {
/*  676 */       Object o = objects[i];
/*  677 */       stringBuilder.append(o);
/*  678 */       if (i != objects.length - 1) {
/*  679 */         stringBuilder.append("|");
/*      */       }
/*      */     }
/*  682 */     return stringBuilder.toString();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static long getBeginningOfDay(long times)
/*      */   {
/*  692 */     if (times == 0L) {
/*  693 */       return 0L;
/*      */     }
/*  695 */     Calendar calendar = Calendar.getInstance();
/*  696 */     calendar.setTimeInMillis(times);
/*  697 */     calendar.set(11, 0);
/*  698 */     calendar.set(12, 0);
/*  699 */     calendar.set(13, 0);
/*  700 */     calendar.set(14, 0);
/*      */     
/*  702 */     return calendar.getTimeInMillis();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean isPetSwitchOpenForRole(long roleid)
/*      */   {
/*  712 */     if (!OpenInterface.getOpenStatus(102)) {
/*  713 */       return false;
/*      */     }
/*  715 */     if (OpenInterface.isBanPlay(roleid, 102)) {
/*  716 */       OpenInterface.sendBanPlayMsg(roleid, 102);
/*  717 */       return false;
/*      */     }
/*  719 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static Pet getMaxPetScore(long roleid)
/*      */   {
/*  730 */     Pet xPet = null;
/*  731 */     PetBag xPetBag = Role2petbag.select(Long.valueOf(roleid));
/*  732 */     if ((xPetBag != null) && (xPetBag.getPetmap().size() > 0)) {
/*  733 */       for (Pet xPetInBag : xPetBag.getPetmap().values()) {
/*  734 */         if (xPetInBag.getYaoli() > 0) {
/*  735 */           if (xPet == null) {
/*  736 */             xPet = xPetInBag;
/*      */           }
/*  738 */           else if (xPetInBag.getYaoli() > xPet.getYaoli()) {
/*  739 */             xPet = xPetInBag;
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*  746 */     PetDepot xPetDepot = Role2petdepot.select(Long.valueOf(roleid));
/*  747 */     if ((xPetDepot != null) && (xPetDepot.getPetmap().size() > 0)) {
/*  748 */       for (Pet xPetInDepot : xPetDepot.getPetmap().values()) {
/*  749 */         if (xPetInDepot.getYaoli() > 0) {
/*  750 */           if (xPet == null) {
/*  751 */             xPet = xPetInDepot;
/*      */           }
/*  753 */           else if (xPetInDepot.getYaoli() > xPet.getYaoli()) {
/*  754 */             xPet = xPetInDepot;
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*  761 */     return xPet;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void sendTitleMail(long roleId, int petcfgId, int mailCfgId, TLogArg tLogArg, int... arg)
/*      */   {
/*  773 */     List<String> argList = new ArrayList();
/*  774 */     SPetCfg sPetCfg = SPetCfg.get(petcfgId);
/*  775 */     if (sPetCfg != null) {
/*  776 */       argList.add(sPetCfg.name);
/*      */     }
/*  778 */     for (int a : arg) {
/*  779 */       SSkillCfg sSkillCfg = SSkillCfg.get(a);
/*  780 */       if (sSkillCfg == null) {
/*  781 */         SPassiveSkillCfg sPassiveSkillCfg = SPassiveSkillCfg.get(a);
/*  782 */         if (sPassiveSkillCfg != null) {
/*  783 */           argList.add(sPassiveSkillCfg.name);
/*      */         }
/*      */       } else {
/*  786 */         argList.add(sSkillCfg.name);
/*      */       }
/*      */     }
/*  789 */     MailInterface.asynBuildAndSendMail(roleId, mailCfgId, null, argList, null, tLogArg);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void addPetDeleteTlog(long roleId, long petId, int petCfgId, PetDeleteTLogEnum deleteType)
/*      */   {
/*  802 */     StringBuilder tlogStr = new StringBuilder();
/*  803 */     tlogStr.append(GameServerInfoManager.getHostIP()).append("|").append(RoleInterface.getUserId(roleId)).append("|").append(roleId).append("|").append(petId).append("|").append(petCfgId).append("|").append(deleteType);
/*      */     
/*      */ 
/*  806 */     TLogManager.getInstance().addLog(roleId, "PetDelete", tlogStr.toString());
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void addPetGetTlog(long roleId, String hostIp, String userId, long petId, int petCfgId, PetGetTLogEnum getType, int skillNum)
/*      */   {
/*  821 */     StringBuilder tlogStr = new StringBuilder();
/*  822 */     tlogStr.append(hostIp).append("|").append(userId).append("|").append(roleId).append("|").append(petId).append("|").append(petCfgId).append("|").append(getType.value).append("|").append(skillNum).append("|").append("0").append("|").append("0");
/*      */     
/*      */ 
/*  825 */     TLogManager.getInstance().addLog(roleId, "PetGet", tlogStr.toString());
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void logDebug(String format, Object... args)
/*      */   {
/*  835 */     if (logger.isDebugEnabled()) {
/*  836 */       logger.debug(String.format(format, args));
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void logInfo(String format, Object... args)
/*      */   {
/*  847 */     logger.info(String.format(format, args));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void addPetSkillChangeTlog(long roleId, String hostIp, String userId, long petId, int petCfgId, PetSkillChangeLogEnum getType, List<Integer> skillList)
/*      */   {
/*  861 */     StringBuilder skillStr = new StringBuilder();
/*  862 */     for (int i = 0; i < 10; i++) {
/*  863 */       if (skillList.size() > i) {
/*  864 */         skillStr.append(skillList.get(i));
/*      */       } else {
/*  866 */         skillStr.append(0);
/*      */       }
/*  868 */       if (i < 9) {
/*  869 */         skillStr.append("|");
/*      */       }
/*      */     }
/*      */     
/*  873 */     StringBuilder tlogStr = new StringBuilder();
/*  874 */     tlogStr.append(hostIp).append("|").append(userId).append("|").append(roleId).append("|").append(petId).append("|").append(petCfgId).append("|").append(getType.value).append("|").append(skillStr.toString());
/*      */     
/*  876 */     TLogManager.getInstance().addLog(roleId, "PetSkillChangeTLog", tlogStr.toString());
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void addPetPointChangeTlog(long roleId, String hostIp, String userId, long petId, int petLevel, PetPointChangeLogEnum getType, Map<Integer, Integer> propMap, int leftpoint)
/*      */   {
/*  892 */     int str = 0;int sta = 0;int dex = 0;int spr = 0;int con = 0;
/*  893 */     for (Map.Entry<Integer, Integer> entry : propMap.entrySet()) {
/*  894 */       switch (((Integer)entry.getKey()).intValue()) {
/*      */       case 25: 
/*  896 */         str = ((Integer)entry.getValue()).intValue();
/*  897 */         break;
/*      */       case 29: 
/*  899 */         sta = ((Integer)entry.getValue()).intValue();
/*  900 */         break;
/*      */       case 26: 
/*  902 */         dex = ((Integer)entry.getValue()).intValue();
/*  903 */         break;
/*      */       case 27: 
/*  905 */         spr = ((Integer)entry.getValue()).intValue();
/*  906 */         break;
/*      */       case 28: 
/*  908 */         con = ((Integer)entry.getValue()).intValue();
/*      */       }
/*      */       
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*  915 */     StringBuilder tlogStr = new StringBuilder();
/*  916 */     tlogStr.append(hostIp).append("|").append(userId).append("|").append(roleId).append("|").append(petId).append("|").append(petLevel).append("|").append(getType).append("|").append(str).append("|").append(sta).append("|").append(dex).append("|").append(spr).append("|").append(con).append("|").append(leftpoint);
/*      */     
/*      */ 
/*      */ 
/*  920 */     TLogManager.getInstance().addLog(roleId, "PetPointChangeTLog", tlogStr.toString());
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean addPointTypeCheck(int propertyType)
/*      */   {
/*  930 */     switch (propertyType) {
/*      */     case 25: 
/*  932 */       return true;
/*      */     case 29: 
/*  934 */       return true;
/*      */     case 26: 
/*  936 */       return true;
/*      */     case 27: 
/*  938 */       return true;
/*      */     case 28: 
/*  940 */       return true;
/*      */     }
/*  942 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void checkPetPointError(long roleId, Map<Long, Pet> petBagMap, Map<Long, Pet> petDepotMap)
/*      */   {
/*  954 */     Map<Long, Pet> petMap = new HashMap();
/*  955 */     petMap.putAll(petBagMap);
/*  956 */     petMap.putAll(petDepotMap);
/*  957 */     int zeroId = GameServer.getZoneid();
/*  958 */     for (Map.Entry<Long, Pet> petMapEntry : petMap.entrySet()) {
/*  959 */       Map<Integer, Integer> propMap = ((Pet)petMapEntry.getValue()).getBasicproperty();
/*  960 */       if (propMap != null)
/*      */       {
/*      */ 
/*  963 */         long totalpoint = 0L;
/*      */         
/*  965 */         int levelPoint = ((Pet)petMapEntry.getValue()).getLevel() * getPortentialPointPerLevel();
/*  966 */         for (Map.Entry<Integer, Integer> propEntry : propMap.entrySet()) {
/*  967 */           if (!addPointTypeCheck(((Integer)propEntry.getKey()).intValue()))
/*      */           {
/*  969 */             addPetPointErrorLog(roleId, ((Long)petMapEntry.getKey()).longValue(), zeroId);
/*  970 */             break;
/*      */           }
/*  972 */           int propValue = ((Integer)propEntry.getValue()).intValue();
/*  973 */           if ((propValue < 0) || (propValue > levelPoint))
/*      */           {
/*  975 */             addPetPointErrorLog(roleId, ((Long)petMapEntry.getKey()).longValue(), zeroId);
/*  976 */             break;
/*      */           }
/*  978 */           totalpoint += propValue;
/*      */         }
/*  980 */         if ((totalpoint < 0L) || (totalpoint > levelPoint))
/*      */         {
/*  982 */           addPetPointErrorLog(roleId, ((Long)petMapEntry.getKey()).longValue(), zeroId);
/*      */         }
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public static void addPetPointErrorLog(long roleId, long petId, int zeroId) {
/*  989 */     logInfo("[Pet]PetManager.addPetPointErrorLog@mark pet point error!|roleId=%d|petId=%d|zeroId=%d", new Object[] { Long.valueOf(roleId), Long.valueOf(petId), Integer.valueOf(zeroId) });
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static List<Pet> getAllXbeanPet(long roleId, boolean isRemainROleLock)
/*      */   {
/* 1001 */     List<Pet> petList = new ArrayList();
/* 1002 */     PetBag xPetBag = null;
/* 1003 */     if (isRemainROleLock) {
/* 1004 */       xPetBag = Role2petbag.get(Long.valueOf(roleId));
/*      */     } else {
/* 1006 */       xPetBag = Role2petbag.select(Long.valueOf(roleId));
/*      */     }
/* 1008 */     if (xPetBag != null) {
/* 1009 */       petList.addAll(xPetBag.getPetmap().values());
/*      */     }
/* 1011 */     PetDepot xPetDepot = null;
/* 1012 */     if (isRemainROleLock) {
/* 1013 */       xPetDepot = Role2petdepot.get(Long.valueOf(roleId));
/*      */     } else {
/* 1015 */       xPetDepot = Role2petdepot.select(Long.valueOf(roleId));
/*      */     }
/* 1017 */     if (xPetDepot != null) {
/* 1018 */       petList.addAll(xPetDepot.getPetmap().values());
/*      */     }
/* 1020 */     return petList;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static int getGodPetNum(long roleId, boolean isRemainROleLock)
/*      */   {
/* 1031 */     int godPetNum = 0;
/* 1032 */     List<Pet> petList = getAllXbeanPet(roleId, isRemainROleLock);
/* 1033 */     if (petList.size() == 0) {
/* 1034 */       return godPetNum;
/*      */     }
/*      */     
/* 1037 */     for (Pet xPet : petList) {
/* 1038 */       SPetCfg sPetCfg = SPetCfg.get(xPet.getTemplateid());
/* 1039 */       if (sPetCfg != null)
/*      */       {
/*      */ 
/* 1042 */         if (sPetCfg.type == 3)
/* 1043 */           godPetNum++;
/*      */       }
/*      */     }
/* 1046 */     return godPetNum;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static int getMoShouPetNum(long roleId, boolean isRemainROleLock)
/*      */   {
/* 1057 */     int moShowPetNum = 0;
/* 1058 */     List<Pet> petList = getAllXbeanPet(roleId, isRemainROleLock);
/* 1059 */     if (petList.size() == 0) {
/* 1060 */       return moShowPetNum;
/*      */     }
/*      */     
/* 1063 */     for (Pet xPet : petList) {
/* 1064 */       SPetCfg sPetCfg = SPetCfg.get(xPet.getTemplateid());
/* 1065 */       if (sPetCfg != null)
/*      */       {
/*      */ 
/* 1068 */         if (sPetCfg.type == 4)
/* 1069 */           moShowPetNum++;
/*      */       }
/*      */     }
/* 1072 */     return moShowPetNum;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static int getGodPetMaxSkillNum(long roleId, boolean isRemainROleLock)
/*      */   {
/* 1083 */     int petSkillNum = 0;
/* 1084 */     List<Pet> petList = getAllXbeanPet(roleId, isRemainROleLock);
/* 1085 */     if (petList.size() == 0) {
/* 1086 */       return petSkillNum;
/*      */     }
/*      */     
/* 1089 */     for (Pet xPet : petList) {
/* 1090 */       SPetCfg sPetCfg = SPetCfg.get(xPet.getTemplateid());
/* 1091 */       if (sPetCfg != null)
/*      */       {
/*      */ 
/* 1094 */         if (sPetCfg.type == 3) {
/* 1095 */           int skillNum = xPet.getSkilllist().size();
/* 1096 */           if (skillNum > petSkillNum)
/* 1097 */             petSkillNum = skillNum;
/*      */         }
/*      */       }
/*      */     }
/* 1101 */     return petSkillNum;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static int getMaxYaoliPetAmuletLevel(long roleId, boolean isRemainROleLock)
/*      */   {
/* 1112 */     int maxYaoli = 0;
/* 1113 */     Pet xMaxYaoliPet = null;
/* 1114 */     List<Pet> petList = getAllXbeanPet(roleId, isRemainROleLock);
/* 1115 */     if (petList.size() == 0) {
/* 1116 */       return maxYaoli;
/*      */     }
/*      */     
/* 1119 */     for (Pet xPet : petList) {
/* 1120 */       if (xPet.getYaoli() > maxYaoli) {
/* 1121 */         maxYaoli = xPet.getYaoli();
/* 1122 */         xMaxYaoliPet = xPet;
/*      */       }
/*      */     }
/* 1125 */     if (xMaxYaoliPet != null) {
/* 1126 */       Map<Integer, Item> petEquipMap = xMaxYaoliPet.getEquipbag().getEquip2item();
/* 1127 */       if (petEquipMap == null) {
/* 1128 */         return 0;
/*      */       }
/* 1130 */       Item xPetEquip = (Item)petEquipMap.get(Integer.valueOf(2));
/* 1131 */       if (xPetEquip == null) {
/* 1132 */         return 0;
/*      */       }
/* 1134 */       SPetEquipItem sPetEquipItem = SPetEquipItem.get(xPetEquip.getCfgid());
/* 1135 */       if (sPetEquipItem == null) {
/* 1136 */         return 0;
/*      */       }
/* 1138 */       return sPetEquipItem.equipLevel;
/*      */     }
/* 1140 */     return 0;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean isPetChangeModelOpenForRole(long roleid)
/*      */   {
/* 1150 */     if (!OpenInterface.getOpenStatus(198)) {
/* 1151 */       return false;
/*      */     }
/* 1153 */     if (OpenInterface.isBanPlay(roleid, 198)) {
/* 1154 */       OpenInterface.sendBanPlayMsg(roleid, 198);
/* 1155 */       return false;
/*      */     }
/* 1157 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static int getPetChangeModelCfg(long roleId, long petId)
/*      */   {
/* 1169 */     PetBag xPetBag = Role2petbag.select(Long.valueOf(roleId));
/* 1170 */     if (xPetBag == null) {
/* 1171 */       return -1;
/*      */     }
/* 1173 */     Pet xPet = (Pet)xPetBag.getPetmap().get(Long.valueOf(petId));
/* 1174 */     if (xPet == null) {
/* 1175 */       return -1;
/*      */     }
/* 1177 */     return xPet.getExtramodelcfgid();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean setPetFightFlag(long roleId, long petId, int fightFlag)
/*      */   {
/* 1189 */     Role2PetBean xRole2PetBean = Role2petoutfightbean.get(Long.valueOf(roleId));
/* 1190 */     if (xRole2PetBean == null) {
/* 1191 */       return false;
/*      */     }
/* 1193 */     PetOutFightBean xPetOutFightBean = (PetOutFightBean)xRole2PetBean.getBeanmap().get(Long.valueOf(petId));
/* 1194 */     if (xPetOutFightBean == null) {
/* 1195 */       return false;
/*      */     }
/* 1197 */     xPetOutFightBean.setIsinfight(fightFlag);
/* 1198 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static int getPetFightFlag(long roleId, long petId)
/*      */   {
/* 1211 */     Role2PetBean xRole2PetBean = Role2petoutfightbean.get(Long.valueOf(roleId));
/* 1212 */     if (xRole2PetBean == null) {
/* 1213 */       return 0;
/*      */     }
/* 1215 */     PetOutFightBean xPetOutFightBean = (PetOutFightBean)xRole2PetBean.getBeanmap().get(Long.valueOf(petId));
/* 1216 */     if (xPetOutFightBean == null) {
/* 1217 */       return 0;
/*      */     }
/* 1219 */     return xPetOutFightBean.getIsinfight();
/*      */   }
/*      */   
/*      */   static boolean isPetLevelOpenForRole(long roleid, int switchId) {
/* 1223 */     if (!OpenInterface.getOpenStatus(switchId)) {
/* 1224 */       SPetNormalResult sPetNormalResult = new SPetNormalResult();
/* 1225 */       sPetNormalResult.result = 217;
/*      */       
/* 1227 */       OnlineManager.getInstance().sendAtOnce(roleid, sPetNormalResult);
/* 1228 */       return false;
/*      */     }
/* 1230 */     if (OpenInterface.isBanPlay(roleid, switchId)) {
/* 1231 */       OpenInterface.sendBanPlayMsg(roleid, switchId);
/* 1232 */       return false;
/*      */     }
/* 1234 */     return true;
/*      */   }
/*      */   
/*      */   public static boolean isPetSoulOpen(long roleId) {
/* 1238 */     int switchId = 442;
/* 1239 */     if (!OpenInterface.getOpenStatus(442)) {
/* 1240 */       return false;
/*      */     }
/* 1242 */     if (OpenInterface.isBanPlay(roleId, 442)) {
/* 1243 */       OpenInterface.sendBanPlayMsg(roleId, 442);
/* 1244 */       return false;
/*      */     }
/* 1246 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static SPetSoulCfg getPetSoulCfg(int pos, int level)
/*      */   {
/* 1259 */     SPetSoulCfgPos2Level pos2LevelCfg = SPetSoulCfgPos2Level.get(pos);
/* 1260 */     if (pos2LevelCfg != null) {
/* 1261 */       Integer cfgId = (Integer)pos2LevelCfg.level2id.get(Integer.valueOf(level));
/* 1262 */       if (cfgId != null) {
/* 1263 */         return SPetSoulCfg.get(cfgId.intValue());
/*      */       }
/*      */     }
/* 1266 */     return null;
/*      */   }
/*      */   
/*      */ 
/*      */   public static void tLogPetSoulRandom(long roleid, long petId, int isuseyuanbao, int costyuanbao, long totalYuanBaoNum, int oldPropIndex, PetSoul xPetSoul, int mainItemCount, int subItemCount)
/*      */   {
/* 1272 */     String userid = RoleInterface.getUserId(roleid);
/* 1273 */     Object[] columnns = { userid, Long.valueOf(roleid), Long.valueOf(petId), Integer.valueOf(isuseyuanbao), Integer.valueOf(costyuanbao), Long.valueOf(totalYuanBaoNum), Integer.valueOf(oldPropIndex), Integer.valueOf(xPetSoul.getPos()), Integer.valueOf(xPetSoul.getPropindex()), Integer.valueOf(mainItemCount), Integer.valueOf(subItemCount) };
/*      */     
/* 1275 */     TLogManager.getInstance().addLog(roleid, "PetSoulRandom", columnns);
/*      */   }
/*      */   
/*      */   public static void tLogPetSoulExchange(long roleId, long petId1, long petId2, int isuseyuanbao, int costyuanbao)
/*      */   {
/* 1280 */     String userid = RoleInterface.getUserId(roleId);
/*      */     
/* 1282 */     Object[] columnns = { userid, Long.valueOf(roleId), Long.valueOf(petId1), Long.valueOf(petId2), Integer.valueOf(isuseyuanbao), Integer.valueOf(costyuanbao) };
/* 1283 */     TLogManager.getInstance().addLog(roleId, "PetSoulExchange", columnns);
/*      */   }
/*      */   
/*      */ 
/*      */   public static void tLogPetSoulAddExp(long roleId, long petId, int soulPos, int itemId, int usedItemCount, PetSoul xPetSoulNew, PetSoul xPetSoulOld)
/*      */   {
/* 1289 */     String userid = RoleInterface.getUserId(roleId);
/* 1290 */     Object[] columnns = { userid, Long.valueOf(roleId), Long.valueOf(petId), Integer.valueOf(soulPos), Integer.valueOf(itemId), Integer.valueOf(usedItemCount), Integer.valueOf(xPetSoulNew.getExp()), Integer.valueOf(xPetSoulNew.getLevel()), Integer.valueOf(xPetSoulOld.getExp()), Integer.valueOf(xPetSoulOld.getLevel()) };
/*      */     
/* 1292 */     TLogManager.getInstance().addLog(roleId, "PetSoulAddExp", columnns);
/*      */   }
/*      */   
/*      */   public static void tLogPetSoulInit(long roleId, long petId, PetSoul xPetSoul)
/*      */   {
/* 1297 */     String userid = RoleInterface.getUserId(roleId);
/* 1298 */     Object[] columnns = { userid, Long.valueOf(roleId), Long.valueOf(petId), Integer.valueOf(xPetSoul.getPos()), Integer.valueOf(xPetSoul.getPropindex()) };
/* 1299 */     TLogManager.getInstance().addLog(roleId, "PetSoulInitProp", columnns);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static int getMaxPropIndex(SPetSoulCfg petSoulCfg)
/*      */   {
/* 1309 */     int maxPropIndex = 0;
/* 1310 */     int size = petSoulCfg.propList.size();
/* 1311 */     for (int i = 0; i < size; i++) {
/* 1312 */       if ((petSoulCfg.propList.get(i) != null) && (((SPetPropBean)petSoulCfg.propList.get(i)).propType > 0)) {
/* 1313 */         maxPropIndex++;
/*      */       }
/*      */     }
/* 1316 */     return maxPropIndex;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static int getPetNumInBagAndDepotByPetCfgId(long roleId, int petCfgId, boolean isRemainRolelock)
/*      */   {
/* 1333 */     int count = 0;
/*      */     
/*      */ 
/*      */ 
/* 1337 */     PetBag xPetBag = null;
/* 1338 */     if (isRemainRolelock)
/*      */     {
/* 1340 */       xPetBag = Role2petbag.get(Long.valueOf(roleId));
/*      */     }
/*      */     else
/*      */     {
/* 1344 */       xPetBag = Role2petbag.select(Long.valueOf(roleId));
/*      */     }
/*      */     
/* 1347 */     if (xPetBag != null)
/*      */     {
/* 1349 */       for (Map.Entry<Long, Pet> entry : xPetBag.getPetmap().entrySet())
/*      */       {
/* 1351 */         Pet xPet = (Pet)entry.getValue();
/* 1352 */         if (xPet.getTemplateid() == petCfgId)
/*      */         {
/* 1354 */           count++;
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/* 1362 */     PetDepot xPetDepot = null;
/* 1363 */     if (isRemainRolelock)
/*      */     {
/* 1365 */       xPetDepot = Role2petdepot.get(Long.valueOf(roleId));
/*      */     }
/*      */     else
/*      */     {
/* 1369 */       xPetDepot = Role2petdepot.select(Long.valueOf(roleId));
/*      */     }
/*      */     
/* 1372 */     if (xPetDepot != null)
/*      */     {
/* 1374 */       for (Map.Entry<Long, Pet> entry : xPetDepot.getPetmap().entrySet())
/*      */       {
/* 1376 */         Pet xPet = (Pet)entry.getValue();
/* 1377 */         if (xPet.getTemplateid() == petCfgId)
/*      */         {
/* 1379 */           count++;
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*      */ 
/* 1385 */     return count;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static int getTotalOwnPetNum(long roleId, boolean isRemainRolelock)
/*      */   {
/* 1400 */     int count = 0;
/*      */     
/*      */ 
/*      */ 
/* 1404 */     PetBag xPetBag = null;
/* 1405 */     if (isRemainRolelock)
/*      */     {
/* 1407 */       xPetBag = Role2petbag.get(Long.valueOf(roleId));
/*      */     }
/*      */     else
/*      */     {
/* 1411 */       xPetBag = Role2petbag.select(Long.valueOf(roleId));
/*      */     }
/*      */     
/* 1414 */     if (xPetBag != null)
/*      */     {
/* 1416 */       count += xPetBag.getPetmap().size();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/* 1422 */     PetDepot xPetDepot = null;
/* 1423 */     if (isRemainRolelock)
/*      */     {
/* 1425 */       xPetDepot = Role2petdepot.get(Long.valueOf(roleId));
/*      */     }
/*      */     else
/*      */     {
/* 1429 */       xPetDepot = Role2petdepot.select(Long.valueOf(roleId));
/*      */     }
/*      */     
/* 1432 */     if (xPetDepot != null)
/*      */     {
/* 1434 */       count += xPetDepot.getPetmap().size();
/*      */     }
/*      */     
/* 1437 */     return count;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static int removePet(long roleId, int petCfgId, long petId)
/*      */   {
/* 1454 */     xbean.Basic xBasic = xtable.Basic.get(Long.valueOf(roleId));
/* 1455 */     if (xBasic == null)
/*      */     {
/* 1457 */       logRemovePet(roleId, petId, petCfgId, 64046);
/* 1458 */       return 64046;
/*      */     }
/*      */     
/* 1461 */     SPetCfg sPetCfg = SPetCfg.get(petCfgId);
/* 1462 */     if (sPetCfg == null)
/*      */     {
/* 1464 */       logRemovePet(roleId, petId, petCfgId, 64044);
/* 1465 */       return 64044;
/*      */     }
/*      */     
/* 1468 */     PetBag xPetBag = Role2petbag.get(Long.valueOf(roleId));
/* 1469 */     if (xPetBag == null)
/*      */     {
/* 1471 */       logRemovePet(roleId, petId, petCfgId, 64041);
/* 1472 */       return 64041;
/*      */     }
/*      */     
/* 1475 */     PetDepot xPetDepot = Role2petdepot.get(Long.valueOf(roleId));
/*      */     
/* 1477 */     Pet xPet = null;
/* 1478 */     if (petId == -1L)
/*      */     {
/*      */ 
/* 1481 */       Iterator<Pet> petIterator = xPetBag.getPetmap().values().iterator();
/*      */       
/* 1483 */       while (petIterator.hasNext())
/*      */       {
/* 1485 */         xPet = (Pet)petIterator.next();
/* 1486 */         if (xPet.getTemplateid() == petCfgId)
/*      */         {
/* 1488 */           if (PetInterface.isInFight(roleId, xPet.getId()))
/*      */           {
/* 1490 */             logRemovePet(roleId, petId, petCfgId, 64040);
/* 1491 */             return 64040;
/*      */           }
/*      */           
/* 1494 */           if (PetFightInterface.isPetInDefenseTeam(roleId, petId, true))
/*      */           {
/* 1496 */             logRemovePet(roleId, petId, petCfgId, 64039);
/* 1497 */             return 64039;
/*      */           }
/*      */           
/* 1500 */           PetFightInterface.clearPetFightDataForCertainPet(roleId, petId);
/*      */           
/* 1502 */           petIterator.remove();
/*      */         }
/*      */       }
/*      */       
/*      */ 
/* 1507 */       if (((xPet == null) || (xPet.getTemplateid() != petCfgId)) && (xPetDepot != null))
/*      */       {
/* 1509 */         Iterator<Pet> depotPetIterator = xPetDepot.getPetmap().values().iterator();
/*      */         
/* 1511 */         while (depotPetIterator.hasNext())
/*      */         {
/* 1513 */           xPet = (Pet)depotPetIterator.next();
/* 1514 */           if (xPet.getTemplateid() == petCfgId)
/*      */           {
/* 1516 */             depotPetIterator.remove();
/*      */           }
/*      */         }
/*      */       }
/*      */       
/*      */ 
/* 1522 */       if (xPet == null)
/*      */       {
/* 1524 */         logRemovePet(roleId, petId, petCfgId, 64045);
/* 1525 */         return 64045;
/*      */       }
/*      */       
/* 1528 */       if (xPet.getTemplateid() != petCfgId)
/*      */       {
/* 1530 */         logRemovePet(roleId, petId, petCfgId, 64042);
/* 1531 */         return 64042;
/*      */       }
/*      */     }
/*      */     else
/*      */     {
/* 1536 */       xPet = (Pet)xPetBag.getPetmap().remove(Long.valueOf(petId));
/*      */       
/* 1538 */       if ((xPet != null) && (PetInterface.isInFight(roleId, xPet.getId())))
/*      */       {
/* 1540 */         logRemovePet(roleId, petId, petCfgId, 64040);
/* 1541 */         return 64040;
/*      */       }
/*      */       
/* 1544 */       if ((xPet != null) && (PetFightInterface.isPetInDefenseTeam(roleId, petId, true)))
/*      */       {
/* 1546 */         logRemovePet(roleId, petId, petCfgId, 64039);
/* 1547 */         return 64039;
/*      */       }
/*      */       
/* 1550 */       if (xPet != null)
/*      */       {
/* 1552 */         PetFightInterface.clearPetFightDataForCertainPet(roleId, petId);
/*      */       }
/*      */       
/* 1555 */       if ((xPet == null) && (xPetDepot != null))
/*      */       {
/* 1557 */         xPet = (Pet)xPetDepot.getPetmap().remove(Long.valueOf(petId));
/*      */       }
/*      */       
/* 1560 */       if (xPet == null)
/*      */       {
/* 1562 */         logRemovePet(roleId, petId, petCfgId, 64045);
/* 1563 */         return 64045;
/*      */       }
/*      */       
/* 1566 */       if (xPet.getTemplateid() != petCfgId)
/*      */       {
/* 1568 */         logRemovePet(roleId, petId, petCfgId, 64043);
/* 1569 */         return 64043;
/*      */       }
/*      */     }
/*      */     
/* 1573 */     if (xPetBag.getShowpet() == xPet.getId())
/*      */     {
/* 1575 */       xPetBag.setShowpet(-1L);
/*      */       
/* 1577 */       SSyncPetStateChange sSyncPetStateChange = new SSyncPetStateChange();
/* 1578 */       sSyncPetStateChange.petid = xPet.getId();
/* 1579 */       sSyncPetStateChange.state = 4;
/* 1580 */       OnlineManager.getInstance().send(roleId, sSyncPetStateChange);
/*      */       
/* 1582 */       PlayerShowPetChange change = new PlayerShowPetChange();
/* 1583 */       PetEventArg arg = new PetEventArg();
/* 1584 */       arg.petId = xPet.getId();
/* 1585 */       arg.roleId = roleId;
/* 1586 */       TriggerEventsManger.getInstance().triggerEvent(change, arg);
/*      */     }
/*      */     
/* 1589 */     if (xPetBag.getFightpet() == xPet.getId())
/*      */     {
/* 1591 */       xPetBag.setFightpet(-1L);
/*      */     }
/*      */     
/*      */ 
/* 1595 */     PlayerDeletePet playerDeletePet = new PlayerDeletePet();
/* 1596 */     PetEventArg deletePetArg = new PetEventArg();
/* 1597 */     deletePetArg.petId = petId;
/* 1598 */     deletePetArg.roleId = roleId;
/* 1599 */     deletePetArg.enventType = PetDeleteTLogEnum.IDIP_DELETE.value;
/* 1600 */     TriggerEventsManger.getInstance().triggerEvent(playerDeletePet, deletePetArg);
/*      */     
/* 1602 */     tlogRemovePet(xBasic.getUser_id(), roleId, petCfgId, petId, xPet.getId());
/*      */     
/* 1604 */     Xdb.executor().schedule(new Runnable()
/*      */     {
/*      */ 
/*      */ 
/*      */ 
/*      */       public void run() {
/* 1610 */         OnlineManager.getInstance().forceReconnect(this.val$roleId); } }, 3L, java.util.concurrent.TimeUnit.SECONDS);
/*      */     
/*      */ 
/*      */ 
/* 1614 */     logRemovePet(roleId, petId, petCfgId, 0);
/*      */     
/* 1616 */     return 0;
/*      */   }
/*      */   
/*      */   private static void logRemovePet(long roleId, long petId, int petCfgId, int ret)
/*      */   {
/* 1621 */     StringBuilder stringBuilder = new StringBuilder();
/* 1622 */     stringBuilder.append("[pet]PetManager.logRemovePet@log remove pet");
/* 1623 */     stringBuilder.append("|role_id=").append(roleId);
/* 1624 */     stringBuilder.append("|pet_id=").append(petId);
/* 1625 */     stringBuilder.append("|pet_cfg_id=").append(petCfgId);
/* 1626 */     stringBuilder.append("|ret=").append(ret);
/*      */     
/* 1628 */     GameServer.logger().info(stringBuilder.toString());
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void tlogRemovePet(String userId, long roleId, int petCfgId, long petId, long realRemovePetId)
/*      */   {
/* 1646 */     int roleLevel = RoleInterface.getLevel(roleId);
/*      */     
/* 1648 */     StringBuilder sbLog = new StringBuilder();
/* 1649 */     sbLog.append(GameServerInfoManager.getHostIP()).append('|');
/* 1650 */     sbLog.append(userId).append('|');
/* 1651 */     sbLog.append(roleId).append('|');
/* 1652 */     sbLog.append(roleLevel).append('|');
/*      */     
/* 1654 */     sbLog.append(petCfgId).append('|');
/* 1655 */     sbLog.append(petId).append('|');
/* 1656 */     sbLog.append(realRemovePetId);
/*      */     
/* 1658 */     TLogManager.getInstance().addLog(roleId, "PetIdipDelete", sbLog.toString());
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\main\PetManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */