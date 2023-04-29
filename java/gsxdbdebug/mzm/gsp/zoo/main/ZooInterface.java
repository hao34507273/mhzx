/*     */ package mzm.gsp.zoo.main;
/*     */ 
/*     */ import java.util.List;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.map.main.scene.object.MapEntityType;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ZooInterface
/*     */ {
/*     */   public static boolean isFunOpen(long roleid)
/*     */   {
/*  13 */     return ZooManager.isFunOpen(roleid);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void onYardCreate(long roleid, long marriageRoleid, long worldid, int mapCfgid)
/*     */   {
/*  28 */     ZooManager.displayAllAtYard(roleid, marriageRoleid, worldid, mapCfgid);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static AddAnimalResult addAnimal(long roleid, int embrypCfgid)
/*     */   {
/*  41 */     return ZooManager.addAnimal(roleid, embrypCfgid);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static mzm.gsp.zoo.AnimalInfo transToAnimalInfo(long roleid, long animalid)
/*     */   {
/*  53 */     xbean.AnimalInfo xAnimalInfo = ZooManager.getAnimalInfo(roleid, animalid);
/*  54 */     if (xAnimalInfo == null)
/*     */     {
/*  56 */       return null;
/*     */     }
/*  58 */     return ZooManager.transToAnimalInfo(animalid, xAnimalInfo);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void onAnimalCreate(long roleid, long animalid, long worldid, int mapCfgid)
/*     */   {
/*  72 */     ZooManager.displayAtYard(roleid, animalid, worldid, mapCfgid);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void onAnimalDisappear(long roleid, long animalid)
/*     */   {
/*  83 */     MapInterface.removeMapEntity(MapEntityType.MET_ANIMAL, animalid, null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void onEmbryoHatchDayChange(long roleid, long animalid, int days)
/*     */   {
/*  95 */     ZooManager.onEmbryoHatchDayChange(roleid, animalid, days);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void onAnimalStageChange(long roleid, long animalid, int oldStage, int newStage, long worldid, int mapCfgid)
/*     */   {
/* 111 */     ZooManager.onAnimalStageChange(roleid, animalid, worldid, mapCfgid);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void onAnimalMate(long roleid, long animalid, long lastMateTime, int awardCfgid)
/*     */   {
/* 124 */     ZooManager.onAnimalMate(roleid, animalid, lastMateTime, awardCfgid);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void onAnimalGetAward(long roleid, long animalid, int awardCfgid)
/*     */   {
/* 136 */     ZooManager.onAnimalGetAward(roleid, animalid, awardCfgid);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void onAnimalRename(long roleid, long animalid, String oldName, String name)
/*     */   {
/* 149 */     ZooManager.onAnimalRename(roleid, animalid, oldName, name);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void onDivorce(long roleid)
/*     */   {
/* 160 */     ZooManager.onDivorce(roleid);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void onMarriage(long roleid, long worldid, int mapCfgid)
/*     */   {
/* 171 */     ZooManager.onMarraried(roleid, worldid, mapCfgid);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void onHomeWorldDestory(List<Long> roles)
/*     */   {
/* 183 */     if (roles == null)
/*     */     {
/* 185 */       return;
/*     */     }
/* 187 */     if (roles.isEmpty())
/*     */     {
/* 189 */       return;
/*     */     }
/* 191 */     ZooManager.onHomeWorldDestory(roles);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getAnimalNum(long roleid, int star)
/*     */   {
/* 204 */     return ZooManager.getAnimalNum(roleid, star);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\zoo\main\ZooInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */