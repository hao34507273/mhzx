/*      */ package mzm.gsp.pet.main;
/*      */ 
/*      */ import java.util.ArrayList;
/*      */ import java.util.HashMap;
/*      */ import java.util.HashSet;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import java.util.Random;
/*      */ import java.util.Set;
/*      */ import mzm.event.TriggerEventsManger;
/*      */ import mzm.gsp.GameServerInfoManager;
/*      */ import mzm.gsp.item.confbean.SPetSkillBookCfg;
/*      */ import mzm.gsp.item.main.ItemInterface;
/*      */ import mzm.gsp.item.main.ItemStoreEnum;
/*      */ import mzm.gsp.online.main.OnlineManager;
/*      */ import mzm.gsp.pet.PetInfo;
/*      */ import mzm.gsp.pet.SSyncAddPet;
/*      */ import mzm.gsp.pet.SSyncPetStateChange;
/*      */ import mzm.gsp.pet.confbean.PetConstants;
/*      */ import mzm.gsp.pet.confbean.PetScoreConf;
/*      */ import mzm.gsp.pet.confbean.SPetCfg;
/*      */ import mzm.gsp.pet.confbean.SPetYaoLiConf;
/*      */ import mzm.gsp.pet.event.PetCatchEvent;
/*      */ import mzm.gsp.pet.event.PetCatchEventArg;
/*      */ import mzm.gsp.pet.event.PetEventArg;
/*      */ import mzm.gsp.pet.event.PetRest;
/*      */ import mzm.gsp.pet.event.PlayerShowPetChange;
/*      */ import mzm.gsp.petequip.confbean.MonsterSkill2Prop;
/*      */ import mzm.gsp.petequip.confbean.SPetEquipItem;
/*      */ import mzm.gsp.pubdata.ModelInfo;
/*      */ import mzm.gsp.role.main.RoleInterface;
/*      */ import mzm.gsp.role.main.RoleOneByOneManager;
/*      */ import mzm.gsp.skill.main.SkillInterface;
/*      */ import xbean.Aptitude;
/*      */ import xbean.Item;
/*      */ import xbean.PetDepot;
/*      */ import xbean.PetEquipBag;
/*      */ import xbean.PetSkill;
/*      */ import xbean.Pod;
/*      */ import xbean.Role2PetBean;
/*      */ import xdb.Xdb;
/*      */ import xtable.Role2petbag;
/*      */ import xtable.Role2petdepot;
/*      */ import xtable.Role2petoutfightbean;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class PetInterface
/*      */ {
/*      */   public static PetOutFightObj getPetOutFightObjById(long roleId, long petId)
/*      */   {
/*   58 */     PetBag petBag = getPetBag(roleId, true);
/*   59 */     if (petBag == null)
/*      */     {
/*   61 */       return null;
/*      */     }
/*   63 */     return petBag.getPetOutFightObjById(petId);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static PetOutFightObj getFightPetOutFightObjById(long roleId)
/*      */   {
/*   75 */     PetBag petBag = getPetBag(roleId, true);
/*   76 */     return petBag.getPetOutFightObjById(petBag.getFightPetId());
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean isShowPet(long roleId, long petId)
/*      */   {
/*   87 */     return Role2petbag.selectShowpet(Long.valueOf(roleId)).longValue() == petId;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public static PetBag getPetBag(long roleId, boolean isRetainLock)
/*      */   {
/*      */     xbean.PetBag xPetBag;
/*      */     
/*      */     xbean.PetBag xPetBag;
/*      */     
/*   98 */     if (isRetainLock) {
/*   99 */       xPetBag = Role2petbag.get(Long.valueOf(roleId));
/*      */     } else {
/*  101 */       xPetBag = Role2petbag.select(Long.valueOf(roleId));
/*      */     }
/*  103 */     if (xPetBag == null) {
/*  104 */       return null;
/*      */     }
/*  106 */     return new PetBag(roleId, xPetBag);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static Pet getPetByPetId(long roleId, long petId, boolean isRetainLock)
/*      */   {
/*  118 */     PetBag petBag = getPetBag(roleId, isRetainLock);
/*  119 */     return petBag.getPetById(petId);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean isPetInBag(long roleId, long petId, boolean isRetainLock)
/*      */   {
/*  131 */     PetBag petBag = getPetBag(roleId, isRetainLock);
/*  132 */     if (petBag == null) {
/*  133 */       return false;
/*      */     }
/*  135 */     Pet pet = petBag.getPetById(petId);
/*  136 */     if (pet != null) {
/*  137 */       return true;
/*      */     }
/*  139 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void fillXpet(xbean.Pet xDesPet, xbean.Pet xSrcPet)
/*      */   {
/*  147 */     xDesPet.setId(xSrcPet.getId());
/*  148 */     xDesPet.setTemplateid(xSrcPet.getTemplateid());
/*  149 */     xDesPet.setPetname(xSrcPet.getPetname());
/*  150 */     xDesPet.setPetnameOctets(xSrcPet.getPetnameOctets());
/*  151 */     xDesPet.setLevel(xSrcPet.getLevel());
/*  152 */     xDesPet.setHp(xSrcPet.getHp());
/*  153 */     xDesPet.setMp(xSrcPet.getMp());
/*  154 */     xDesPet.setExp(xSrcPet.getExp());
/*  155 */     xDesPet.setLife(xSrcPet.getLife());
/*  156 */     xDesPet.setIsautospecialpoint(xSrcPet.getIsautospecialpoint());
/*  157 */     xDesPet.setPotentialpoint(xSrcPet.getPotentialpoint());
/*  158 */     xDesPet.setGrow(xSrcPet.getGrow());
/*  159 */     xDesPet.setRememberskillid(xSrcPet.getRememberskillid());
/*  160 */     xDesPet.setIsbinded(xSrcPet.getIsbinded());
/*  161 */     xDesPet.setYaoli(xSrcPet.getYaoli());
/*  162 */     xDesPet.setChangeyaolitime(xSrcPet.getChangeyaolitime());
/*  163 */     xDesPet.setMarketbuytime(xSrcPet.getMarketbuytime());
/*  164 */     xDesPet.setLianguitemusenum(xSrcPet.getLianguitemusenum());
/*  165 */     xDesPet.setGrowitemusenum(xSrcPet.getGrowitemusenum());
/*  166 */     xDesPet.setExtramodelcfgid(xSrcPet.getExtramodelcfgid());
/*      */     
/*  168 */     xDesPet.getOwnextramodelcfgids().addAll(xSrcPet.getOwnextramodelcfgids());
/*  169 */     int extramodelcfgid = xSrcPet.getExtramodelcfgid();
/*  170 */     if ((extramodelcfgid > 0) && (!xDesPet.getOwnextramodelcfgids().contains(Integer.valueOf(extramodelcfgid))))
/*      */     {
/*  172 */       xDesPet.getOwnextramodelcfgids().add(Integer.valueOf(extramodelcfgid));
/*      */     }
/*      */     
/*  175 */     for (PetSkill ps : xSrcPet.getSkilllist())
/*      */     {
/*  177 */       PetSkill p = Pod.newPetSkill();
/*  178 */       p.setSkillfrom(ps.getSkillfrom());
/*  179 */       p.setSkillid(ps.getSkillid());
/*  180 */       xDesPet.getSkilllist().add(p);
/*      */     }
/*  182 */     xDesPet.getAptitude().getAptlimitmap().putAll(xSrcPet.getAptitude().getAptlimitmap());
/*  183 */     xDesPet.getAptitude().getAptmap().putAll(xSrcPet.getAptitude().getAptmap());
/*  184 */     for (Map.Entry<Integer, Item> entry : xSrcPet.getEquipbag().getEquip2item().entrySet())
/*      */     {
/*  186 */       Item xItem = Pod.newItem();
/*  187 */       ItemInterface.fillXItem(xItem, (Item)entry.getValue());
/*  188 */       xDesPet.getEquipbag().getEquip2item().put(entry.getKey(), xItem);
/*      */     }
/*      */     
/*  191 */     xDesPet.getBasicproperty().putAll(xSrcPet.getBasicproperty());
/*  192 */     xDesPet.getAutospecialpointcase().putAll(xSrcPet.getAutospecialpointcase());
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean addXpetIntoPetbag(long roleId, xbean.Pet xPet)
/*      */   {
/*  201 */     if (xPet == null) {
/*  202 */       return false;
/*      */     }
/*  204 */     PetBag petBag = getPetBag(roleId, true);
/*  205 */     if (petBag == null) {
/*  206 */       return false;
/*      */     }
/*  208 */     if (!petBag.addXPet(xPet)) {
/*  209 */       return false;
/*      */     }
/*  211 */     PetOutFightObj petPropObj = new PetOutFightObj(roleId, xPet);
/*  212 */     SSyncAddPet sSyncAddPet = new SSyncAddPet();
/*  213 */     petPropObj.fillPetInfo(sSyncAddPet.petinfo);
/*  214 */     petPropObj.updateOutFightProperty();
/*  215 */     OnlineManager.getInstance().send(roleId, sSyncAddPet);
/*  216 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void setAutoAddPoint(long roleId, long petId)
/*      */   {
/*  226 */     xbean.PetBag xPetBag = Role2petbag.get(Long.valueOf(roleId));
/*  227 */     if (xPetBag == null) {
/*  228 */       PetManager.logDebug("PetInterface.setAutoAddPoint@xPetBag not exist!|roleId=%d", new Object[] { Long.valueOf(roleId) });
/*  229 */       return;
/*      */     }
/*  231 */     xbean.Pet xPet = (xbean.Pet)xPetBag.getPetmap().get(Long.valueOf(petId));
/*  232 */     if (xPet == null) {
/*  233 */       PetManager.logDebug("PetInterface.setAutoAddPoint@xPet not exist!|roleId=%d|petId=%d", new Object[] { Long.valueOf(roleId), Long.valueOf(petId) });
/*  234 */       return;
/*      */     }
/*  236 */     xPet.getAutospecialpointcase().put(Integer.valueOf(25), Integer.valueOf(10));
/*  237 */     xPet.setIsautospecialpoint(true);
/*  238 */     PetOutFightObj outFightObj = new PetOutFightObj(roleId, xPet);
/*  239 */     outFightObj.syncPetInfo();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static Pet getFightPet(long roleId, boolean isRetainLock)
/*      */   {
/*  251 */     PetBag petBag = getPetBag(roleId, isRetainLock);
/*  252 */     if (null == petBag) {
/*  253 */       return null;
/*      */     }
/*  255 */     return petBag.getFightPet();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static Pet getShowPet(long roleId, boolean isRetainLock)
/*      */   {
/*  266 */     PetBag petBag = getPetBag(roleId, isRetainLock);
/*  267 */     if (petBag == null) {
/*  268 */       return null;
/*      */     }
/*  270 */     return petBag.getShowPet();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean removePetInBag(long roleId, int petCfgId, int num)
/*      */   {
/*  281 */     PetBag petBag = getPetBag(roleId, true);
/*  282 */     if (petBag == null) {
/*  283 */       return false;
/*      */     }
/*  285 */     return petBag.removePetByCfg(petCfgId, num);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean removePetInBag(long roleId, long petId)
/*      */   {
/*  296 */     PetBag petBag = getPetBag(roleId, true);
/*  297 */     if (petBag == null) {
/*  298 */       return false;
/*      */     }
/*  300 */     xbean.Pet xPet = petBag.removePet(petId);
/*  301 */     if (xPet == null) {
/*  302 */       return false;
/*      */     }
/*  304 */     Role2PetBean xRole2Pet = Role2petoutfightbean.get(Long.valueOf(roleId));
/*  305 */     if (xRole2Pet != null) {
/*  306 */       xRole2Pet.getBeanmap().remove(Long.valueOf(petId));
/*      */     }
/*      */     
/*  309 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean isPetCfgExist(int cfgId)
/*      */   {
/*  318 */     return PetManager.getInstance().getPetCfg(cfgId) != null;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static List<Integer> getPetSkillList(long roleId, long petId)
/*      */   {
/*  328 */     List<Integer> skillList = new ArrayList();
/*  329 */     xbean.PetBag xPetBag = Role2petbag.select(Long.valueOf(roleId));
/*  330 */     xbean.Pet xPet = (xbean.Pet)xPetBag.getPetmap().get(Long.valueOf(petId));
/*  331 */     if (xPet == null)
/*      */     {
/*  333 */       return skillList;
/*      */     }
/*  335 */     List<PetSkill> xPetSkillList = xPet.getSkilllist();
/*      */     
/*  337 */     for (PetSkill xPetSkill : xPetSkillList) {
/*  338 */       int skillid = xPetSkill.getSkillid();
/*  339 */       if (!SkillInterface.isPassiveSkill(skillid))
/*      */       {
/*      */ 
/*  342 */         skillList.add(Integer.valueOf(xPetSkill.getSkillid()));
/*      */       }
/*      */     }
/*  345 */     Item xPetEquip = (Item)xPet.getEquipbag().getEquip2item().get(Integer.valueOf(2));
/*  346 */     if (xPetEquip != null) {
/*  347 */       Integer skillId = (Integer)xPetEquip.getExtra().get(Integer.valueOf(ItemStoreEnum.PET_EQUIP_SKILL_1.getStoreType()));
/*  348 */       if ((skillId != null) && (!skillList.contains(skillId)) && (!SkillInterface.isPassiveSkill(skillId.intValue()))) {
/*  349 */         skillList.add(skillId);
/*      */       }
/*  351 */       skillId = (Integer)xPetEquip.getExtra().get(Integer.valueOf(ItemStoreEnum.PET_EQUIP_SKILL_2.getStoreType()));
/*  352 */       if ((skillId != null) && (!skillList.contains(skillId)) && (!SkillInterface.isPassiveSkill(skillId.intValue()))) {
/*  353 */         skillList.add(skillId);
/*      */       }
/*      */     }
/*  356 */     return skillList;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static long addPet(long roleId, int petCfgId)
/*      */   {
/*  368 */     return PetManager.getInstance().createPet(roleId, petCfgId);
/*      */   }
/*      */   
/*      */   public static long addPet(long roleId, int petCfgId, int bind) {
/*  372 */     return PetManager.getInstance().createPet(roleId, petCfgId, bind);
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
/*      */   public static long addPetAndRandomPoint(long roleId, int petCfgId, int level, boolean random)
/*      */   {
/*  385 */     xbean.Pet xPet = Pod.newPet();
/*  386 */     long petId = PetManager.getInstance().createPetAction(roleId, petCfgId, 0, xPet);
/*  387 */     if (petId < 0L) return petId;
/*  388 */     if (random) {
/*  389 */       xPet.getAutospecialpointcase().put(Integer.valueOf(25), Integer.valueOf(1));
/*  390 */       xPet.getAutospecialpointcase().put(Integer.valueOf(29), Integer.valueOf(1));
/*  391 */       xPet.getAutospecialpointcase().put(Integer.valueOf(26), Integer.valueOf(1));
/*  392 */       xPet.getAutospecialpointcase().put(Integer.valueOf(27), Integer.valueOf(1));
/*  393 */       xPet.getAutospecialpointcase().put(Integer.valueOf(28), Integer.valueOf(1));
/*      */       
/*  395 */       xPet.setIsautospecialpoint(true);
/*      */     }
/*      */     
/*  398 */     PetOutFightObj outFightObj = new PetOutFightObj(roleId, xPet);
/*  399 */     outFightObj.setLevel(level, false);
/*  400 */     SSyncAddPet sSyncAddPet = new SSyncAddPet();
/*  401 */     outFightObj.fillPetInfo(sSyncAddPet.petinfo);
/*  402 */     OnlineManager.getInstance().send(roleId, sSyncAddPet);
/*  403 */     return petId;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static Pet getDepotPetByPetId(long roleId, long petId, boolean isRetainLock)
/*      */   {
/*  414 */     PetDepot xPetDepot = null;
/*  415 */     if (isRetainLock) {
/*  416 */       xPetDepot = Role2petdepot.get(Long.valueOf(roleId));
/*      */     } else {
/*  418 */       xPetDepot = Role2petdepot.select(Long.valueOf(roleId));
/*      */     }
/*  420 */     xbean.Pet xPet = (xbean.Pet)xPetDepot.getPetmap().get(Long.valueOf(petId));
/*  421 */     if (xPet == null) {
/*  422 */       return null;
/*      */     }
/*  424 */     Pet pet = new Pet(roleId, xPet);
/*  425 */     return pet;
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
/*      */   public static PetInfo getPetInfo(long roleId, long petId)
/*      */   {
/*  439 */     PetInfo petInfo = new PetInfo();
/*  440 */     fillPetInfo(roleId, petId, petInfo);
/*  441 */     return petInfo;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static PetInfo getPetInfoByCfgId(long roleId, long petCfgId)
/*      */   {
/*  450 */     PetInfo petInfo = new PetInfo();
/*  451 */     fillPetInfoByCfgId(roleId, petCfgId, petInfo);
/*  452 */     return petInfo;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static List<PetInfo> getPetListInBagAndDepot(long roleId)
/*      */   {
/*  461 */     List<PetInfo> petInfoList = new ArrayList();
/*  462 */     xbean.PetBag xPetBag = Role2petbag.get(Long.valueOf(roleId));
/*  463 */     for (Map.Entry<Long, xbean.Pet> entry : xPetBag.getPetmap().entrySet())
/*      */     {
/*  465 */       fillPetInfo(roleId, (xbean.Pet)entry.getValue(), petInfoList);
/*      */     }
/*      */     
/*  468 */     PetDepot xPetDepot = Role2petdepot.get(Long.valueOf(roleId));
/*  469 */     for (Map.Entry<Long, xbean.Pet> entry : xPetDepot.getPetmap().entrySet())
/*      */     {
/*  471 */       fillPetInfo(roleId, (xbean.Pet)entry.getValue(), petInfoList);
/*      */     }
/*      */     
/*  474 */     return petInfoList;
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
/*  491 */     return PetManager.getPetNumInBagAndDepotByPetCfgId(roleId, petCfgId, isRemainRolelock);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static void fillPetInfo(long roleId, xbean.Pet xPet, List<PetInfo> petInfoList)
/*      */   {
/*  500 */     PetInfo petInfo = new PetInfo();
/*  501 */     PetOutFightObj obj = new PetOutFightObj(roleId, xPet);
/*  502 */     obj.fillPetInfo(petInfo);
/*  503 */     petInfoList.add(petInfo);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void fillPetInfo(long roleId, long petId, PetInfo petInfo)
/*      */   {
/*  513 */     xbean.PetBag xPetBag = Role2petbag.get(Long.valueOf(roleId));
/*  514 */     if (xPetBag == null) {
/*  515 */       return;
/*      */     }
/*  517 */     xbean.Pet xPet = (xbean.Pet)xPetBag.getPetmap().get(Long.valueOf(petId));
/*  518 */     if (xPet == null) {
/*  519 */       PetDepot xPetDepot = Role2petdepot.get(Long.valueOf(roleId));
/*  520 */       xPet = (xbean.Pet)xPetDepot.getPetmap().get(Long.valueOf(petId));
/*      */     }
/*  522 */     if (xPet == null) {
/*  523 */       return;
/*      */     }
/*  525 */     PetOutFightObj obj = new PetOutFightObj(roleId, xPet);
/*  526 */     obj.fillPetInfo(petInfo);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void fillPetInfo(long roleId, xbean.Pet xPet, PetInfo petInfo)
/*      */   {
/*  537 */     PetOutFightObj obj = new PetOutFightObj(roleId, xPet);
/*  538 */     obj.fillPetInfo(petInfo);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void fillPetInfoByCfgId(long roleId, long petCfgId, PetInfo petInfo)
/*      */   {
/*  548 */     xbean.PetBag xPetBag = Role2petbag.get(Long.valueOf(roleId));
/*  549 */     xbean.Pet xPet = null;
/*  550 */     if (xPetBag != null)
/*      */     {
/*  552 */       for (Map.Entry<Long, xbean.Pet> entry : xPetBag.getPetmap().entrySet())
/*      */       {
/*  554 */         if (((xbean.Pet)entry.getValue()).getTemplateid() == petCfgId) { xPet = (xbean.Pet)entry.getValue();
/*      */         }
/*      */       }
/*      */     }
/*  558 */     if (xPet == null)
/*      */     {
/*  560 */       PetDepot xPetDepot = Role2petdepot.get(Long.valueOf(roleId));
/*  561 */       if (xPetDepot != null)
/*      */       {
/*  563 */         for (Map.Entry<Long, xbean.Pet> entry : xPetDepot.getPetmap().entrySet())
/*      */         {
/*  565 */           if (((xbean.Pet)entry.getValue()).getTemplateid() == petCfgId) { xPet = (xbean.Pet)entry.getValue();
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/*  570 */     if (xPet == null) return;
/*  571 */     PetOutFightObj obj = new PetOutFightObj(roleId, xPet);
/*  572 */     obj.fillPetInfo(petInfo);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void fillModelInfo(long roleId, long petId, ModelInfo modelInfo)
/*      */   {
/*  582 */     xbean.PetBag xPetBag = Role2petbag.select(Long.valueOf(roleId));
/*  583 */     xbean.Pet xPet = (xbean.Pet)xPetBag.getPetmap().get(Long.valueOf(petId));
/*  584 */     if (xPet != null) {
/*  585 */       PetCfg petCfg = PetManager.getInstance().getPetCfg(xPet.getTemplateid());
/*  586 */       if (petCfg == null) {
/*  587 */         return;
/*      */       }
/*  589 */       int modelId = petCfg.getModelId();
/*  590 */       modelInfo.modelid = modelId;
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static ModelInfo getModelInfo(long roleId, long petId)
/*      */   {
/*  600 */     ModelInfo modelInfo = new ModelInfo();
/*  601 */     fillModelInfo(roleId, petId, modelInfo);
/*  602 */     return modelInfo;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void setHP(long roleId, int petId, int hp)
/*      */   {
/*  613 */     PetOutFightObj obj = getPetOutFightObjById(roleId, petId);
/*  614 */     int maxHP = obj.getFinalMaxHP();
/*  615 */     hp = Math.min(maxHP, hp);
/*  616 */     hp = Math.max(hp, 1);
/*  617 */     obj.setHP(hp);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void setMP(long roleId, long petId, int mp)
/*      */   {
/*  628 */     PetOutFightObj obj = getPetOutFightObjById(roleId, petId);
/*  629 */     int maxMP = obj.getFinalMaxMP();
/*  630 */     mp = Math.min(maxMP, mp);
/*  631 */     mp = Math.max(mp, 1);
/*  632 */     obj.setMP(mp);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static int getPetCfgIdByPetId(long roleId, long petId)
/*      */   {
/*  643 */     xbean.PetBag xPetBag = Role2petbag.select(Long.valueOf(roleId));
/*  644 */     xbean.Pet xPet = (xbean.Pet)xPetBag.getPetmap().get(Long.valueOf(petId));
/*  645 */     if (xPet == null) {
/*  646 */       return -1;
/*      */     }
/*  648 */     return xPet.getTemplateid();
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
/*      */   public static long setFightPet(long roleId, long petId)
/*      */   {
/*  662 */     xbean.PetBag xPetBag = Role2petbag.get(Long.valueOf(roleId));
/*  663 */     long oldFightPet = xPetBag.getFightpet();
/*  664 */     if (oldFightPet == petId) {
/*  665 */       return petId;
/*      */     }
/*  667 */     xbean.Pet xPet = (xbean.Pet)xPetBag.getPetmap().get(Long.valueOf(petId));
/*  668 */     if (xPet == null) {
/*  669 */       return -1L;
/*      */     }
/*  671 */     xPetBag.setFightpet(petId);
/*  672 */     setPetBindSync(roleId, xPet);
/*  673 */     SSyncPetStateChange stateChange = new SSyncPetStateChange();
/*  674 */     if (oldFightPet > 0L) {
/*  675 */       stateChange.petid = oldFightPet;
/*  676 */       stateChange.state = 3;
/*  677 */       OnlineManager.getInstance().send(roleId, stateChange);
/*      */     }
/*  679 */     SSyncPetStateChange setFightStateChange = new SSyncPetStateChange();
/*  680 */     setFightStateChange.petid = petId;
/*  681 */     setFightStateChange.state = 0;
/*  682 */     OnlineManager.getInstance().send(roleId, setFightStateChange);
/*  683 */     return petId;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static PetCfg getPetCfgByCfgId(int id)
/*      */   {
/*  692 */     return PetManager.getInstance().getPetCfg(id);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean isPetBagFull(long roleId)
/*      */   {
/*  702 */     xbean.PetBag xPetBag = Role2petbag.select(Long.valueOf(roleId));
/*  703 */     return xPetBag.getPetmap().size() >= xPetBag.getBagsize();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean isPetTypeBaoBaoOrBianYi(int petCfgId)
/*      */   {
/*  712 */     PetCfg cfg = PetManager.getInstance().getPetCfg(petCfgId);
/*  713 */     if (cfg == null) {
/*  714 */       return false;
/*      */     }
/*  716 */     return (cfg.isBaoBao()) || (cfg.isBianYi());
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void setFightPetRest(long roleId)
/*      */   {
/*  724 */     xbean.PetBag xPetBag = Role2petbag.get(Long.valueOf(roleId));
/*  725 */     if (xPetBag == null) {
/*  726 */       return;
/*      */     }
/*  728 */     long petId = xPetBag.getFightpet();
/*  729 */     xbean.Pet xPet = (xbean.Pet)xPetBag.getPetmap().get(Long.valueOf(petId));
/*  730 */     if (xPet == null) {
/*  731 */       return;
/*      */     }
/*  733 */     xPetBag.setFightpet(-1L);
/*  734 */     SSyncPetStateChange petStateChange = new SSyncPetStateChange();
/*  735 */     petStateChange.petid = petId;
/*  736 */     petStateChange.state = 3;
/*  737 */     OnlineManager.getInstance().send(roleId, petStateChange);
/*      */     
/*  739 */     PetEventArg arg = new PetEventArg();
/*  740 */     arg.petId = petId;
/*  741 */     arg.roleId = roleId;
/*  742 */     TriggerEventsManger.getInstance().triggerEvent(new PetRest(), arg);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean isCanJoinFight(long roleId, long petId, boolean isRetainLock)
/*      */   {
/*      */     xbean.PetBag xPetBag;
/*      */     
/*      */ 
/*      */ 
/*      */     xbean.PetBag xPetBag;
/*      */     
/*      */ 
/*  757 */     if (isRetainLock) {
/*  758 */       xPetBag = Role2petbag.get(Long.valueOf(roleId));
/*      */     } else {
/*  760 */       xPetBag = Role2petbag.select(Long.valueOf(roleId));
/*      */     }
/*      */     
/*  763 */     if (xPetBag == null) {
/*  764 */       return false;
/*      */     }
/*  766 */     xbean.Pet xPet = (xbean.Pet)xPetBag.getPetmap().get(Long.valueOf(petId));
/*  767 */     if (xPet == null) {
/*  768 */       return false;
/*      */     }
/*      */     
/*  771 */     if (xPet.getIsbinded() != 1) {
/*  772 */       return false;
/*      */     }
/*      */     
/*  775 */     if ((xPet.getLife() != -1) && (xPet.getLife() < PetConstants.getInstance().PET_JOIN_FIGHT_MIN_LIFE)) {
/*  776 */       return false;
/*      */     }
/*      */     
/*  779 */     PetCfg petCfg = PetManager.getInstance().getPetCfg(xPet.getTemplateid());
/*  780 */     if (petCfg == null) {
/*  781 */       return false;
/*      */     }
/*  783 */     if (petCfg.getCarrayLevel() > RoleInterface.getLevel(roleId)) {
/*  784 */       return false;
/*      */     }
/*  786 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean isPetExist(long roleId, long petId, boolean isRetainLock)
/*      */   {
/*  798 */     if (!RoleInterface.isRoleExist(roleId, isRetainLock))
/*  799 */       return false;
/*      */     xbean.PetBag xPetBag;
/*      */     xbean.PetBag xPetBag;
/*  802 */     if (isRetainLock) {
/*  803 */       xPetBag = Role2petbag.get(Long.valueOf(roleId));
/*      */     } else {
/*  805 */       xPetBag = Role2petbag.select(Long.valueOf(roleId));
/*      */     }
/*  807 */     return xPetBag.getPetmap().containsKey(Long.valueOf(petId));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static long addCatchPet(long roleId, int petCfgId, int level)
/*      */   {
/*  819 */     long petId = 0L;
/*  820 */     if (isPetTypeBaoBaoOrBianYi(petCfgId)) {
/*  821 */       petId = addPet(roleId, petCfgId);
/*      */     } else {
/*  823 */       petId = addPetAndRandomPoint(roleId, petCfgId, level, true);
/*      */     }
/*  825 */     if (petId >= 0L)
/*      */     {
/*  827 */       List<Integer> skillList = getPetNativeSkillList(roleId, petId);
/*  828 */       String hostIp = GameServerInfoManager.getHostIP();
/*  829 */       String userId = RoleInterface.getUserId(roleId);
/*  830 */       PetManager.addPetGetTlog(roleId, hostIp, userId, petId, petCfgId, PetGetTLogEnum.FIELD_CATCH, skillList.size());
/*  831 */       PetManager.addPetSkillChangeTlog(roleId, hostIp, userId, petId, petCfgId, PetSkillChangeLogEnum.INIT, skillList);
/*      */       
/*  833 */       TriggerEventsManger.getInstance().triggerEvent(new PetCatchEvent(), new PetCatchEventArg(roleId, petCfgId, level), RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(roleId)));
/*      */     }
/*      */     
/*      */ 
/*  837 */     return petId;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean isSuperSkillBookMath(int itemId)
/*      */   {
/*  846 */     SPetSkillBookCfg sPetSkillBookCfg = SPetSkillBookCfg.get(itemId);
/*  847 */     if (sPetSkillBookCfg == null) {
/*  848 */       return false;
/*      */     }
/*  850 */     return sPetSkillBookCfg.itemPhase == 3;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean isPetEquipLevelGreatThan(int id, int level)
/*      */   {
/*  861 */     SPetEquipItem sPetEquipItem = SPetEquipItem.get(id);
/*  862 */     if (sPetEquipItem == null) {
/*  863 */       return false;
/*      */     }
/*  865 */     if (sPetEquipItem.equipLevel >= level) {
/*  866 */       return true;
/*      */     }
/*  868 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean isCanCarray(int cfgId, int level)
/*      */   {
/*  878 */     PetCfg petCfg = PetManager.getInstance().getPetCfg(cfgId);
/*  879 */     if (petCfg == null) {
/*  880 */       return false;
/*      */     }
/*  882 */     return petCfg.getCarrayLevel() <= level;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void hidePet(long roleId, boolean isTriggerEvent)
/*      */   {
/*  891 */     xbean.PetBag xPetBag = Role2petbag.get(Long.valueOf(roleId));
/*  892 */     if (xPetBag == null) {
/*  893 */       return;
/*      */     }
/*      */     
/*  896 */     if (xPetBag.getShowpet() <= 0L) {
/*  897 */       return;
/*      */     }
/*  899 */     long petId = xPetBag.getShowpet();
/*  900 */     xPetBag.setShowpet(-1L);
/*  901 */     SSyncPetStateChange sSyncPetStateChange = new SSyncPetStateChange();
/*  902 */     sSyncPetStateChange.petid = petId;
/*  903 */     sSyncPetStateChange.state = 4;
/*  904 */     OnlineManager.getInstance().send(roleId, sSyncPetStateChange);
/*      */     
/*  906 */     if (isTriggerEvent)
/*      */     {
/*  908 */       PlayerShowPetChange change = new PlayerShowPetChange();
/*  909 */       PetEventArg arg = new PetEventArg();
/*  910 */       arg.petId = petId;
/*  911 */       arg.roleId = roleId;
/*  912 */       TriggerEventsManger.getInstance().triggerEvent(change, arg);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean isBianYi(int petCfgId)
/*      */   {
/*  922 */     PetCfg petCfg = PetManager.getInstance().getPetCfg(petCfgId);
/*  923 */     if (petCfg == null) return false;
/*  924 */     return petCfg.isBianYi();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static String getPetName(int petCfgId)
/*      */   {
/*  933 */     PetCfg petCfg = PetManager.getInstance().getPetCfg(petCfgId);
/*  934 */     if (petCfg == null) return "";
/*  935 */     return petCfg.getDefaultName();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static Pet getPetById(long roleId, long petId)
/*      */   {
/*  947 */     xbean.PetBag xPetBag = Role2petbag.select(Long.valueOf(roleId));
/*  948 */     if (xPetBag == null) return null;
/*  949 */     xbean.Pet xPet = (xbean.Pet)xPetBag.getPetmap().get(Long.valueOf(petId));
/*  950 */     if (xPet == null) {
/*  951 */       PetDepot xPetDepot = Role2petdepot.select(Long.valueOf(roleId));
/*  952 */       if (xPetDepot == null) return null;
/*  953 */       xPet = (xbean.Pet)xPetDepot.getPetmap().get(Long.valueOf(petId));
/*  954 */       if (xPet == null) {
/*  955 */         return null;
/*      */       }
/*      */     }
/*  958 */     Pet pet = new Pet(roleId, xPet);
/*  959 */     return pet;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static xbean.Pet getXPetById(long roleId, long petId, boolean isRemainLock)
/*      */   {
/*  971 */     xbean.PetBag xPetBag = null;
/*  972 */     if (isRemainLock) {
/*  973 */       xPetBag = Role2petbag.get(Long.valueOf(roleId));
/*      */     } else {
/*  975 */       xPetBag = Role2petbag.select(Long.valueOf(roleId));
/*      */     }
/*  977 */     if (xPetBag == null) return null;
/*  978 */     xbean.Pet xPet = (xbean.Pet)xPetBag.getPetmap().get(Long.valueOf(petId));
/*  979 */     if (xPet == null) {
/*  980 */       PetDepot xPetDepot = null;
/*  981 */       if (isRemainLock) {
/*  982 */         xPetDepot = Role2petdepot.get(Long.valueOf(roleId));
/*      */       } else {
/*  984 */         xPetDepot = Role2petdepot.select(Long.valueOf(roleId));
/*      */       }
/*  986 */       if (xPetDepot == null) return null;
/*  987 */       xPet = (xbean.Pet)xPetDepot.getPetmap().get(Long.valueOf(petId));
/*  988 */       if (xPet == null) {
/*  989 */         return null;
/*      */       }
/*      */     }
/*  992 */     return xPet;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean isPetExist(long roleId, long petId)
/*      */   {
/* 1004 */     xbean.PetBag xPetBag = Role2petbag.select(Long.valueOf(roleId));
/* 1005 */     if ((xPetBag != null) && (xPetBag.getPetmap().containsKey(Long.valueOf(petId)))) {
/* 1006 */       return true;
/*      */     }
/* 1008 */     PetDepot xPetDepot = Role2petdepot.select(Long.valueOf(roleId));
/* 1009 */     if ((xPetDepot != null) && (xPetDepot.getPetmap().containsKey(Long.valueOf(petId)))) {
/* 1010 */       return true;
/*      */     }
/* 1012 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean isPetCfgIdExistInBagAndDepot(long roleId, long petCfgId)
/*      */   {
/* 1021 */     xbean.PetBag xPetBag = Role2petbag.get(Long.valueOf(roleId));
/* 1022 */     if (xPetBag != null)
/*      */     {
/* 1024 */       for (Map.Entry<Long, xbean.Pet> entry : xPetBag.getPetmap().entrySet())
/*      */       {
/* 1026 */         if (((xbean.Pet)entry.getValue()).getTemplateid() == petCfgId) { return true;
/*      */         }
/*      */       }
/*      */     }
/* 1030 */     PetDepot xPetDepot = Role2petdepot.get(Long.valueOf(roleId));
/* 1031 */     if (xPetDepot != null)
/*      */     {
/* 1033 */       for (Map.Entry<Long, xbean.Pet> entry : xPetDepot.getPetmap().entrySet())
/*      */       {
/* 1035 */         if (((xbean.Pet)entry.getValue()).getTemplateid() == petCfgId) return true;
/*      */       }
/*      */     }
/* 1038 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static Set<Long> getPetList(long roleId, boolean isRetainLock)
/*      */   {
/* 1049 */     PetBag petBag = getPetBag(roleId, isRetainLock);
/* 1050 */     if (null == petBag) {
/* 1051 */       return new HashSet();
/*      */     }
/* 1053 */     Map<Long, xbean.Pet> pets = petBag.getAllPets();
/* 1054 */     if (!pets.isEmpty()) {
/* 1055 */       return pets.keySet();
/*      */     }
/* 1057 */     return new HashSet();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static int getPetYaoli(long roleId, long petId)
/*      */   {
/* 1067 */     xbean.PetBag xPetBag = Role2petbag.select(Long.valueOf(roleId));
/* 1068 */     if (null == xPetBag) {
/* 1069 */       return 0;
/*      */     }
/* 1071 */     xbean.Pet xPet = (xbean.Pet)xPetBag.getPetmap().get(Long.valueOf(petId));
/* 1072 */     if (null == xPet) {
/* 1073 */       return 0;
/*      */     }
/* 1075 */     return xPet.getYaoli();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static long getPetYaoliChangeTime(long roleId, long petId)
/*      */   {
/* 1085 */     xbean.PetBag xPetBag = Role2petbag.select(Long.valueOf(roleId));
/* 1086 */     if (null == xPetBag) {
/* 1087 */       return 0L;
/*      */     }
/* 1089 */     xbean.Pet xPet = (xbean.Pet)xPetBag.getPetmap().get(Long.valueOf(petId));
/* 1090 */     if (null == xPet) {
/* 1091 */       return 0L;
/*      */     }
/* 1093 */     return xPet.getChangeyaolitime();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void setPetBindSync(long roleId, xbean.Pet xPet)
/*      */   {
/* 1104 */     if (xPet.getIsbinded() == 0) {
/* 1105 */       xPet.setIsbinded(1);
/* 1106 */       PetOutFightObj petOutFightObj = new PetOutFightObj(roleId, xPet);
/* 1107 */       petOutFightObj.syncPetInfo();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void recoveryHPAndMP(long roleId, long petId)
/*      */   {
/* 1118 */     PetOutFightObj obj = getPetOutFightObjById(roleId, petId);
/* 1119 */     if (null == obj) {
/* 1120 */       return;
/*      */     }
/* 1122 */     int maxHP = obj.getFinalMaxHP();
/* 1123 */     int maxMP = obj.getFinalMaxMP();
/* 1124 */     obj.setHP(maxHP);
/* 1125 */     obj.setMP(maxMP);
/* 1126 */     obj.syncPetInfo();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static long getFightPetId(long roleId)
/*      */   {
/* 1136 */     PetBag petBag = getPetBag(roleId, false);
/* 1137 */     return petBag.getFightPetId();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public static int getPetNormalAttackSkillId()
/*      */   {
/* 1145 */     return PetConstants.getInstance().NORMAL_ATTACK_SKILLID;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public static int getPetNormalDefenceSkillId()
/*      */   {
/* 1152 */     return PetConstants.getInstance().NORMAL_DEFENCE_SKILLID;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public static Map<Long, Integer> getPetYaoliMap(long roleId)
/*      */   {
/* 1160 */     Map<Long, Integer> petYaoLiMap = new HashMap();
/* 1161 */     PetDepot xPetDepot = Role2petdepot.select(Long.valueOf(roleId));
/* 1162 */     xbean.PetBag xPetBag = Role2petbag.select(Long.valueOf(roleId));
/* 1163 */     if (xPetBag != null) {
/* 1164 */       for (xbean.Pet xPet : xPetBag.getPetmap().values()) {
/* 1165 */         petYaoLiMap.put(Long.valueOf(xPet.getId()), Integer.valueOf(xPet.getYaoli()));
/*      */       }
/*      */     }
/* 1168 */     if (xPetDepot != null) {
/* 1169 */       for (xbean.Pet xPet : xPetDepot.getPetmap().values()) {
/* 1170 */         petYaoLiMap.put(Long.valueOf(xPet.getId()), Integer.valueOf(xPet.getYaoli()));
/*      */       }
/*      */     }
/* 1173 */     return petYaoLiMap;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static int getDefenseTeamScore(long roleid)
/*      */   {
/* 1183 */     PetFightTeam petFightTeam = PetFightInterface.getPetFightDefenseTeam(roleid, true);
/* 1184 */     if (petFightTeam == null)
/*      */     {
/* 1186 */       return 0;
/*      */     }
/* 1188 */     int score = 0;
/* 1189 */     for (PetFightTeam.Position position : petFightTeam.positions.values())
/*      */     {
/* 1191 */       PetInfo petInfo = getPetInfo(roleid, position.petId);
/* 1192 */       score += petInfo.yaoli;
/*      */     }
/* 1194 */     return score;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public static int getPetScore(xbean.Pet xPet)
/*      */   {
/* 1202 */     Aptitude xAptitude = xPet.getAptitude();
/* 1203 */     float totalApt = 0.0F;
/* 1204 */     for (Integer value : xAptitude.getAptmap().values()) {
/* 1205 */       totalApt += value.intValue();
/*      */     }
/* 1207 */     PetCfg petCfg = PetManager.getInstance().getPetCfg(xPet.getTemplateid());
/* 1208 */     if (petCfg == null) {
/* 1209 */       return 0;
/*      */     }
/* 1211 */     PetScoreConf petScoreConf = PetScoreConf.get(petCfg.getPetScoreConfId());
/* 1212 */     if (petScoreConf == null) {
/* 1213 */       return 0;
/*      */     }
/* 1215 */     float score = petScoreConf.param1Rate * (totalApt - petScoreConf.minAptRate + 1.0F) / (petScoreConf.maxAptRate - petScoreConf.minAptRate + 1) + petScoreConf.param2Rate * (xPet.getGrow() * 10000.0F - petScoreConf.minGrowRate + 1.0F) / (petScoreConf.maxGrowRate - petScoreConf.minGrowRate + 1);
/* 1216 */     return (int)score;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static int getPetScoreLevel(xbean.Pet xPet)
/*      */   {
/* 1225 */     int petScore = getPetScore(xPet);
/* 1226 */     if (petScore == 0) {
/* 1227 */       return -1;
/*      */     }
/* 1229 */     PetCfg petCfg = PetManager.getInstance().getPetCfg(xPet.getTemplateid());
/* 1230 */     if (petCfg == null) {
/* 1231 */       return -1;
/*      */     }
/* 1233 */     for (Map.Entry<Integer, SPetYaoLiConf> yaoliEntry : SPetYaoLiConf.getAll().entrySet()) {
/* 1234 */       SPetYaoLiConf sPetYaoLiConf = (SPetYaoLiConf)yaoliEntry.getValue();
/* 1235 */       if ((sPetYaoLiConf.yaoliLevel == petCfg.getYaoliLevel()) && 
/* 1236 */         (petScore >= sPetYaoLiConf.minValue) && (petScore <= sPetYaoLiConf.maxValue)) {
/* 1237 */         return sPetYaoLiConf.petYaoLiLevel;
/*      */       }
/*      */     }
/*      */     
/* 1241 */     return -1;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean isAboveScoreLevel(int petScoreLevel, xbean.Pet xPet)
/*      */   {
/* 1250 */     int curPetScoreLevel = getPetScoreLevel(xPet);
/* 1251 */     if ((curPetScoreLevel == -1) || (petScoreLevel > 7)) {
/* 1252 */       return false;
/*      */     }
/* 1254 */     if (curPetScoreLevel <= petScoreLevel) {
/* 1255 */       return true;
/*      */     }
/* 1257 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean isAboveScoreValue(int petScoreValue, xbean.Pet xPet)
/*      */   {
/* 1265 */     int curPetScoreLevel = getPetScore(xPet);
/* 1266 */     if (curPetScoreLevel == 0) {
/* 1267 */       return false;
/*      */     }
/* 1269 */     if (curPetScoreLevel >= petScoreValue) {
/* 1270 */       return true;
/*      */     }
/* 1272 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public static Set<Integer> getPetHasSkills(xbean.Pet xPet)
/*      */   {
/* 1280 */     if (xPet == null) {
/* 1281 */       return null;
/*      */     }
/* 1283 */     if (xPet.getSkilllist().size() == 0) {
/* 1284 */       return null;
/*      */     }
/* 1286 */     Set<Integer> skillSet = new HashSet();
/* 1287 */     for (PetSkill xPetSkill : xPet.getSkilllist()) {
/* 1288 */       skillSet.add(Integer.valueOf(xPetSkill.getSkillid()));
/*      */     }
/* 1290 */     return skillSet;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static List<Integer> getPetNativeSkillList(long roleId, long petId)
/*      */   {
/* 1300 */     List<Integer> skillList = new ArrayList();
/* 1301 */     xbean.PetBag xPetBag = Role2petbag.select(Long.valueOf(roleId));
/* 1302 */     if (xPetBag == null) {
/* 1303 */       return skillList;
/*      */     }
/* 1305 */     xbean.Pet xPet = (xbean.Pet)xPetBag.getPetmap().get(Long.valueOf(petId));
/* 1306 */     if (xPet == null) {
/* 1307 */       return skillList;
/*      */     }
/* 1309 */     for (PetSkill xPetSkill : xPet.getSkilllist()) {
/* 1310 */       skillList.add(Integer.valueOf(xPetSkill.getSkillid()));
/*      */     }
/* 1312 */     return skillList;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static List<Integer> getPetNativeSkillList(xbean.Pet xPet)
/*      */   {
/* 1321 */     List<Integer> skillList = new ArrayList();
/* 1322 */     if (xPet == null) {
/* 1323 */       return skillList;
/*      */     }
/* 1325 */     for (PetSkill xPetSkill : xPet.getSkilllist()) {
/* 1326 */       skillList.add(Integer.valueOf(xPetSkill.getSkillid()));
/*      */     }
/* 1328 */     return skillList;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public static int getPetSkillNum(xbean.Pet xPet)
/*      */   {
/* 1335 */     if (xPet == null) {
/* 1336 */       return 0;
/*      */     }
/* 1338 */     return xPet.getSkilllist().size();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static int getPetSkillNum(long roleId, long petId)
/*      */   {
/* 1348 */     xbean.PetBag xPetBag = Role2petbag.select(Long.valueOf(roleId));
/* 1349 */     if (xPetBag == null) {
/* 1350 */       return 0;
/*      */     }
/* 1352 */     xbean.Pet xPet = (xbean.Pet)xPetBag.getPetmap().get(Long.valueOf(petId));
/* 1353 */     if (xPet == null) {
/* 1354 */       return 0;
/*      */     }
/* 1356 */     return xPet.getSkilllist().size();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static int getPetType(int petCfgId)
/*      */   {
/* 1365 */     SPetCfg sPetCfg = SPetCfg.get(petCfgId);
/* 1366 */     if (sPetCfg == null) {
/* 1367 */       return -1;
/*      */     }
/* 1369 */     return sPetCfg.type;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean isPetTypeExist(int petType)
/*      */   {
/* 1377 */     if ((petType == 1) || (petType == 2) || (petType == 4) || (petType == 3) || (petType == 0)) {
/* 1378 */       return true;
/*      */     }
/* 1380 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean isPetScoreTypeExist(int petScoreType)
/*      */   {
/* 1388 */     if ((petScoreType == 4) || (petScoreType == 5) || (petScoreType == 6) || (petScoreType == 7) || (petScoreType == 3) || (petScoreType == 1) || (petScoreType == 0)) {
/* 1389 */       return true;
/*      */     }
/* 1391 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public static int getPetMarketPrice(xbean.Pet xPet)
/*      */   {
/* 1399 */     int petScore = getPetScore(xPet);
/* 1400 */     if (petScore == 0) {
/* 1401 */       return -1;
/*      */     }
/* 1403 */     PetCfg petCfg = PetManager.getInstance().getPetCfg(xPet.getTemplateid());
/* 1404 */     if (petCfg == null) {
/* 1405 */       return -1;
/*      */     }
/* 1407 */     for (Map.Entry<Integer, SPetYaoLiConf> yaoliEntry : SPetYaoLiConf.getAll().entrySet()) {
/* 1408 */       SPetYaoLiConf sPetYaoLiConf = (SPetYaoLiConf)yaoliEntry.getValue();
/* 1409 */       if ((sPetYaoLiConf.yaoliLevel == petCfg.getYaoliLevel()) && 
/* 1410 */         (petScore >= sPetYaoLiConf.minValue) && (petScore <= sPetYaoLiConf.maxValue)) {
/* 1411 */         return sPetYaoLiConf.marketPriceLimit;
/*      */       }
/*      */     }
/*      */     
/* 1415 */     return -1;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static int getTypePetCount(long roleId, List<Integer> typeList)
/*      */   {
/* 1425 */     int total = 0;
/* 1426 */     xbean.PetBag xPetBag = Role2petbag.select(Long.valueOf(roleId));
/* 1427 */     if (xPetBag == null) {
/* 1428 */       return total;
/*      */     }
/* 1430 */     for (xbean.Pet xPet : xPetBag.getPetmap().values()) {
/* 1431 */       sPetCfg = SPetCfg.get(xPet.getTemplateid());
/* 1432 */       if (sPetCfg != null)
/*      */       {
/*      */ 
/* 1435 */         for (Integer type : typeList)
/* 1436 */           if (type.intValue() == sPetCfg.type)
/* 1437 */             total++;
/*      */       }
/*      */     }
/*      */     SPetCfg sPetCfg;
/* 1441 */     PetDepot xPetDepot = Role2petdepot.select(Long.valueOf(roleId));
/* 1442 */     if (xPetDepot == null) {
/* 1443 */       return total;
/*      */     }
/* 1445 */     for (xbean.Pet xPet : xPetDepot.getPetmap().values()) {
/* 1446 */       sPetCfg = SPetCfg.get(xPet.getTemplateid());
/* 1447 */       if (sPetCfg != null)
/*      */       {
/*      */ 
/* 1450 */         for (Integer type : typeList)
/* 1451 */           if (type.intValue() == sPetCfg.type)
/* 1452 */             total++;
/*      */       }
/*      */     }
/*      */     SPetCfg sPetCfg;
/* 1456 */     return total;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static xbean.Pet getMaxPetSore(long roleId)
/*      */   {
/* 1467 */     return PetManager.getMaxPetScore(roleId);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static int getGodPetNum(long roleId, boolean isRemainROleLock)
/*      */   {
/* 1479 */     return PetManager.getGodPetNum(roleId, isRemainROleLock);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static int getMoShouPetNum(long roleId, boolean isRemainROleLock)
/*      */   {
/* 1491 */     return PetManager.getMoShouPetNum(roleId, isRemainROleLock);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static int getGodAndMoShowPetNum(long roleId, boolean isRemainROleLock)
/*      */   {
/* 1503 */     return PetManager.getGodPetNum(roleId, isRemainROleLock) + PetManager.getMoShouPetNum(roleId, isRemainROleLock);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static int getGodPetMaxSkillNum(long roleId, boolean isRemainROleLock)
/*      */   {
/* 1515 */     return PetManager.getGodPetMaxSkillNum(roleId, isRemainROleLock);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static int getMaxYaoliPetAmuletLevel(long roleId, boolean isRemainROleLock)
/*      */   {
/* 1527 */     return PetManager.getMaxYaoliPetAmuletLevel(roleId, isRemainROleLock);
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
/* 1539 */     return PetManager.getPetChangeModelCfg(roleId, petId);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean setPetInFightFlag(long roleId, long petId)
/*      */   {
/* 1551 */     return PetManager.setPetFightFlag(roleId, petId, 1);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean setPetOutFightFlag(long roleId, long petId)
/*      */   {
/* 1563 */     return PetManager.setPetFightFlag(roleId, petId, 0);
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
/*      */   public static boolean isInFight(long roleId, long petId)
/*      */   {
/* 1577 */     return PetManager.getPetFightFlag(roleId, petId) == 1;
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
/*      */   public static List<Integer> getRefreshPetEquipAmuletSkills(int skillNum, SPetEquipItem petEquipCfg)
/*      */   {
/* 1591 */     List<Integer> skillIdList = new ArrayList();
/* 1592 */     Set<Integer> skillSet; int prop; int baseProp; Set<Integer> skillSet; int prop; int baseProp; if (skillNum > 1)
/*      */     {
/* 1594 */       skillIdList.addAll(SkillInterface.getMonsterRandomSkill(petEquipCfg.monsterSkillId, 1));
/* 1595 */       skillSet = new HashSet(skillIdList);
/* 1596 */       int sumWight = 0;
/* 1597 */       for (MonsterSkill2Prop m2p : petEquipCfg.monsterSkillPropList)
/*      */       {
/* 1599 */         sumWight += m2p.monster2SkillProb;
/*      */       }
/* 1601 */       if (sumWight == 0)
/*      */       {
/* 1603 */         return skillIdList;
/*      */       }
/*      */       
/* 1606 */       prop = Xdb.random().nextInt(sumWight);
/* 1607 */       baseProp = 0;
/* 1608 */       for (MonsterSkill2Prop m2p : petEquipCfg.monsterSkillPropList)
/*      */       {
/* 1610 */         baseProp += m2p.monster2SkillProb;
/* 1611 */         if (prop <= baseProp)
/*      */         {
/* 1613 */           if (petEquipCfg.monsterSkillId == m2p.monster2SkillId)
/*      */           {
/* 1615 */             skillIdList.clear();
/* 1616 */             skillIdList.addAll(SkillInterface.getMonsterRandomSkill(m2p.monster2SkillId, skillSet, 2)); break;
/*      */           }
/*      */           
/*      */ 
/* 1620 */           skillIdList.addAll(SkillInterface.getMonsterRandomSkill(m2p.monster2SkillId, skillSet, 1));
/*      */           
/* 1622 */           break;
/*      */         }
/*      */       }
/*      */     }
/*      */     else
/*      */     {
/* 1628 */       skillSet = new HashSet(skillIdList);
/* 1629 */       int sumWight = 0;
/* 1630 */       for (MonsterSkill2Prop m2p : petEquipCfg.monsterSkillPropList)
/*      */       {
/* 1632 */         sumWight += m2p.monsterSkillProb;
/*      */       }
/* 1634 */       prop = Xdb.random().nextInt(sumWight);
/* 1635 */       baseProp = 0;
/* 1636 */       for (MonsterSkill2Prop m2p : petEquipCfg.monsterSkillPropList)
/*      */       {
/* 1638 */         baseProp += m2p.monsterSkillProb;
/* 1639 */         if (prop <= baseProp)
/*      */         {
/* 1641 */           skillIdList.addAll(SkillInterface.getMonsterRandomSkill(m2p.monsterSkillId, skillSet, 1));
/* 1642 */           break;
/*      */         }
/*      */       }
/*      */     }
/* 1646 */     return skillIdList;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean removeRoleCachePetOutfightObjs(long roleid)
/*      */   {
/* 1658 */     return Role2petoutfightbean.remove(Long.valueOf(roleid));
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
/* 1673 */     return PetManager.getTotalOwnPetNum(roleId, isRemainRolelock);
/*      */   }
/*      */   
/*      */   public static int removePet(long roleId, int petCfgId, long petId)
/*      */   {
/* 1678 */     return PetManager.removePet(roleId, petCfgId, petId);
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\main\PetInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */