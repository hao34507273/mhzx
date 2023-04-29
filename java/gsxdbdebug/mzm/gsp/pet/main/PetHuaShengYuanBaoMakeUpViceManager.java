/*     */ package mzm.gsp.pet.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import java.util.TreeMap;
/*     */ import java.util.concurrent.locks.ReentrantReadWriteLock;
/*     */ import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
/*     */ import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;
/*     */ import mzm.gsp.item.confbean.SPetSkillBookCfg;
/*     */ import mzm.gsp.pet.confbean.SPetCfg;
/*     */ import mzm.gsp.pet.confbean.SPetHuaShengYuanBaoMakeUpMain2ViceSkillCfg;
/*     */ import mzm.gsp.pet.confbean.SPetHuaShengYuanBaoMakeUpViceConsts;
/*     */ import mzm.gsp.pet.confbean.STPetHuaShengYuanBaoMakeUpViceCfg;
/*     */ import mzm.gsp.pet.confbean.VicePetSkillPriceInfo;
/*     */ import mzm.gsp.shanghui.ShoppingItem;
/*     */ import mzm.gsp.shanghui.confbean.SShangHuiSubTypeCfg;
/*     */ import mzm.gsp.shanghui.main.ShanghuiInterface;
/*     */ import mzm.gsp.timer.main.DateObserver.MyDate;
/*     */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*     */ import xbean.Pet;
/*     */ import xbean.PetSkill;
/*     */ 
/*     */ public class PetHuaShengYuanBaoMakeUpViceManager
/*     */ {
/*  29 */   private static final ReentrantReadWriteLock vicePetSkillLock = new ReentrantReadWriteLock();
/*  30 */   private static final VicePetSkill vicePetSkill = new VicePetSkill();
/*     */   
/*     */   static class VicePetSkill
/*     */   {
/*     */     int skillBookShangHuiAveragePrice;
/*  35 */     final List<Integer> skillIdList = new ArrayList();
/*     */   }
/*     */   
/*     */ 
/*     */   public static void postInit()
/*     */   {
/*  41 */     NoneRealTimeTaskManager.getInstance().addTask(new PPetHuaShengYuanBaoMakeUpViceGetSkillsAndPrice());
/*     */     
/*     */ 
/*  44 */     DateObserver.MyDate dayDate = new DateObserver.MyDate(-1, -1, -1, SPetHuaShengYuanBaoMakeUpViceConsts.getInstance().HOUR);
/*     */     
/*  46 */     new PetHuaShengYuanBaoMakeUpViceObserver(dayDate);
/*     */   }
/*     */   
/*     */   static void getSkillsAndPriceFromShangHui()
/*     */   {
/*  51 */     List<ShoppingItem> skillBookShoppItemList = new ArrayList();
/*     */     
/*  53 */     skillBookShoppItemList.addAll(ShanghuiInterface.getShangHuiItemListBySubType(SPetHuaShengYuanBaoMakeUpViceConsts.getInstance().HIGH_LEVEL_SKILL_BOOK_ID));
/*     */     
/*  55 */     skillBookShoppItemList.addAll(ShanghuiInterface.getShangHuiItemListBySubType(SPetHuaShengYuanBaoMakeUpViceConsts.getInstance().LOW_LEVEL_SKILL_BOOK_ID));
/*     */     
/*     */ 
/*  58 */     int skillBookShoppItemListSize = skillBookShoppItemList.size();
/*  59 */     if (skillBookShoppItemListSize == 0)
/*     */     {
/*  61 */       getSkillsAndPriceFromCfg();
/*  62 */       return;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  67 */     Collections.sort(skillBookShoppItemList, new java.util.Comparator()
/*     */     {
/*     */ 
/*     */       public int compare(ShoppingItem o1, ShoppingItem o2)
/*     */       {
/*  72 */         return o1.price - o2.price;
/*     */       }
/*     */       
/*  75 */     });
/*  76 */     int skillBookCount = SPetHuaShengYuanBaoMakeUpViceConsts.getInstance().SKILL_BOOK_COUNT > skillBookShoppItemListSize ? skillBookShoppItemListSize : SPetHuaShengYuanBaoMakeUpViceConsts.getInstance().SKILL_BOOK_COUNT;
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  81 */     int totalPrice = 0;
/*     */     
/*     */ 
/*     */ 
/*  85 */     vicePetSkillLock.writeLock().lock();
/*     */     try
/*     */     {
/*  88 */       vicePetSkill.skillIdList.clear();
/*  89 */       for (int i = 0; i < skillBookCount; i++)
/*     */       {
/*  91 */         ShoppingItem shoppingItem = (ShoppingItem)skillBookShoppItemList.get(i);
/*  92 */         SPetSkillBookCfg petSkillBookCfg = SPetSkillBookCfg.get(shoppingItem.itemid);
/*  93 */         if (petSkillBookCfg != null)
/*     */         {
/*     */ 
/*     */ 
/*  97 */           totalPrice += shoppingItem.price;
/*  98 */           vicePetSkill.skillIdList.add(Integer.valueOf(petSkillBookCfg.skillId));
/*     */         } }
/* 100 */       vicePetSkill.skillBookShangHuiAveragePrice = (totalPrice / skillBookCount);
/*     */       
/* 102 */       if (vicePetSkill.skillIdList.isEmpty())
/*     */       {
/* 104 */         getSkillsAndPriceFromCfg();
/*     */       }
/*     */     }
/*     */     finally
/*     */     {
/* 109 */       vicePetSkillLock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   private static void getSkillsAndPriceFromCfg()
/*     */   {
/* 115 */     mzm.gsp.GameServer.logger().warn("[pet]PetHuaShengYuanBaoMakeUpViceManager.getSkillsAndPriceFromCfg:is getting skills and price from config");
/*     */     
/*     */ 
/*     */ 
/* 119 */     SShangHuiSubTypeCfg shangHuiSubTypeCfg = SShangHuiSubTypeCfg.get(SPetHuaShengYuanBaoMakeUpViceConsts.getInstance().LOW_LEVEL_SKILL_BOOK_ID);
/*     */     
/*     */ 
/* 122 */     vicePetSkillLock.writeLock().lock();
/*     */     try
/*     */     {
/* 125 */       vicePetSkill.skillIdList.clear();
/* 126 */       for (Iterator i$ = shangHuiSubTypeCfg.itemIdList.iterator(); i$.hasNext();) { int itemId = ((Integer)i$.next()).intValue();
/*     */         
/* 128 */         SPetSkillBookCfg petSkillBookCfg = SPetSkillBookCfg.get(itemId);
/* 129 */         if (petSkillBookCfg != null)
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/* 134 */           vicePetSkill.skillIdList.add(Integer.valueOf(petSkillBookCfg.skillId));
/*     */         }
/*     */       }
/* 137 */       if (vicePetSkill.skillIdList.isEmpty())
/*     */       {
/* 139 */         throw new RuntimeException("[pet]PetHuaShengYuanBaoMakeUpViceManager.getSkillsAndPriceFromCfg:skillIdList is empty");
/*     */       }
/*     */       
/* 142 */       vicePetSkill.skillBookShangHuiAveragePrice = SPetHuaShengYuanBaoMakeUpViceConsts.getInstance().DEFAULT_PRICE;
/*     */     }
/*     */     finally
/*     */     {
/* 146 */       vicePetSkillLock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   static int getVicePetSkillCount(int mainPetSkillCount)
/*     */   {
/* 153 */     SPetHuaShengYuanBaoMakeUpMain2ViceSkillCfg petHuaShengYuanBaoMakeUpMain2ViceSkillCfg = SPetHuaShengYuanBaoMakeUpMain2ViceSkillCfg.get(mainPetSkillCount);
/*     */     
/* 155 */     if (petHuaShengYuanBaoMakeUpMain2ViceSkillCfg == null)
/*     */     {
/* 157 */       return -1;
/*     */     }
/* 159 */     return petHuaShengYuanBaoMakeUpMain2ViceSkillCfg.vicePetSkillCount;
/*     */   }
/*     */   
/*     */   static VicePetMakeUpPriceInfo getMakeUpVicePetPrice(Pet xMainPet)
/*     */   {
/* 164 */     SPetCfg mainPetCfg = SPetCfg.get(xMainPet.getTemplateid());
/* 165 */     if (mainPetCfg == null)
/*     */     {
/* 167 */       return null;
/*     */     }
/*     */     
/* 170 */     List<PetSkill> mainPetSkillList = xMainPet.getSkilllist();
/* 171 */     int vicePetSkillCount = getVicePetSkillCount(mainPetSkillList.size());
/* 172 */     if (vicePetSkillCount == -1)
/*     */     {
/* 174 */       return null;
/*     */     }
/*     */     
/*     */ 
/* 178 */     STPetHuaShengYuanBaoMakeUpViceCfg petHuaShengYuanBaoMakeUpViceCfg = STPetHuaShengYuanBaoMakeUpViceCfg.get(getVicePetCatchLevel(mainPetCfg));
/*     */     
/* 180 */     if (petHuaShengYuanBaoMakeUpViceCfg == null)
/*     */     {
/* 182 */       return null;
/*     */     }
/*     */     
/*     */ 
/* 186 */     vicePetSkillLock.readLock().lock();
/*     */     Map.Entry<Integer, VicePetSkillPriceInfo> integerVicePetSkillPriceInfoEntry;
/*     */     try
/*     */     {
/* 190 */       integerVicePetSkillPriceInfoEntry = petHuaShengYuanBaoMakeUpViceCfg.skillBookPrice2vicePetSkillPriceInfo.ceilingEntry(Integer.valueOf(vicePetSkill.skillBookShangHuiAveragePrice));
/*     */ 
/*     */     }
/*     */     finally
/*     */     {
/* 195 */       vicePetSkillLock.readLock().unlock();
/*     */     }
/*     */     
/* 198 */     if (integerVicePetSkillPriceInfoEntry == null)
/*     */     {
/* 200 */       integerVicePetSkillPriceInfoEntry = petHuaShengYuanBaoMakeUpViceCfg.skillBookPrice2vicePetSkillPriceInfo.lastEntry();
/*     */     }
/* 202 */     VicePetSkillPriceInfo vicePetSkillPriceInfo = (VicePetSkillPriceInfo)integerVicePetSkillPriceInfoEntry.getValue();
/*     */     
/* 204 */     if (vicePetSkillCount > vicePetSkillPriceInfo.vicePetPrices.size())
/*     */     {
/* 206 */       return null;
/*     */     }
/* 208 */     VicePetMakeUpPriceInfo vicePetMakeUpPriceInfo = new VicePetMakeUpPriceInfo();
/* 209 */     vicePetMakeUpPriceInfo.vicePetMakeUpCfgId = vicePetSkillPriceInfo.id;
/* 210 */     vicePetMakeUpPriceInfo.vicePetMakeUpPrice = ((Integer)vicePetSkillPriceInfo.vicePetPrices.get(vicePetSkillCount)).intValue();
/* 211 */     vicePetMakeUpPriceInfo.skillCount = vicePetSkillCount;
/* 212 */     return vicePetMakeUpPriceInfo;
/*     */   }
/*     */   
/*     */   private static int getVicePetCatchLevel(SPetCfg mainPetCfg)
/*     */   {
/* 217 */     if ((mainPetCfg.type == 3) || (mainPetCfg.type == 4))
/*     */     {
/* 219 */       return SPetHuaShengYuanBaoMakeUpViceConsts.getInstance().MAIN_SHEN_SHOU_MO_SHOU_VICE_CACHE_LEVEL;
/*     */     }
/* 221 */     return mainPetCfg.catchLevel;
/*     */   }
/*     */   
/*     */   static List<Integer> getVicePetSkillList(Pet xMainPet)
/*     */   {
/* 226 */     List<PetSkill> mainPetSkillList = xMainPet.getSkilllist();
/* 227 */     Set<Integer> mainPetSkillCfgIdSet = new java.util.HashSet(mainPetSkillList.size());
/* 228 */     for (PetSkill xPetSkill : mainPetSkillList)
/*     */     {
/* 230 */       mainPetSkillCfgIdSet.add(Integer.valueOf(xPetSkill.getSkillid()));
/*     */     }
/* 232 */     List<Integer> candidateSkillCfgIdList = new ArrayList();
/*     */     
/* 234 */     vicePetSkillLock.readLock().lock();
/*     */     try
/*     */     {
/* 237 */       for (i$ = vicePetSkill.skillIdList.iterator(); i$.hasNext();) { int id = ((Integer)i$.next()).intValue();
/*     */         
/* 239 */         if (!mainPetSkillCfgIdSet.contains(Integer.valueOf(id)))
/*     */         {
/*     */ 
/*     */ 
/* 243 */           candidateSkillCfgIdList.add(Integer.valueOf(id));
/*     */         }
/*     */       }
/*     */     } finally {
/*     */       Iterator i$;
/* 248 */       vicePetSkillLock.readLock().unlock();
/*     */     }
/* 250 */     if (candidateSkillCfgIdList.isEmpty())
/*     */     {
/* 252 */       return null;
/*     */     }
/*     */     
/* 255 */     List<Integer> vicePetSkillCfgIds = new ArrayList();
/* 256 */     int vicePetSkillCount = getVicePetSkillCount(mainPetSkillList.size());
/* 257 */     if (vicePetSkillCount == -1)
/*     */     {
/* 259 */       return null;
/*     */     }
/*     */     
/* 262 */     int arraySizeToRandom = candidateSkillCfgIdList.size();
/*     */     
/* 264 */     for (int i = 0; i < vicePetSkillCount; i++)
/*     */     {
/* 266 */       int hitIndex = xdb.Xdb.random().nextInt(arraySizeToRandom);
/* 267 */       vicePetSkillCfgIds.add(candidateSkillCfgIdList.get(hitIndex));
/* 268 */       Collections.swap(candidateSkillCfgIdList, arraySizeToRandom - 1, hitIndex);
/* 269 */       arraySizeToRandom--;
/*     */     }
/* 271 */     return vicePetSkillCfgIds;
/*     */   }
/*     */   
/*     */   static VicePetMakeUpInfo getVicePetMakeUpInfo(Pet xMainPet)
/*     */   {
/* 276 */     VicePetMakeUpInfo vicePetMakeUpInfo = new VicePetMakeUpInfo();
/* 277 */     vicePetSkillLock.readLock().lock();
/*     */     try
/*     */     {
/* 280 */       vicePetMakeUpInfo.vicePetMakeUpPriceInfo = getMakeUpVicePetPrice(xMainPet);
/* 281 */       vicePetMakeUpInfo.vicePetSkillList = getVicePetSkillList(xMainPet);
/* 282 */       return vicePetMakeUpInfo;
/*     */     }
/*     */     finally
/*     */     {
/* 286 */       vicePetSkillLock.readLock().unlock();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\main\PetHuaShengYuanBaoMakeUpViceManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */