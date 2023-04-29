/*     */ package mzm.gsp.market.search;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import java.util.concurrent.locks.Lock;
/*     */ import java.util.concurrent.locks.ReadWriteLock;
/*     */ import mzm.gsp.market.main.MarketInterface;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.CustommizedCons;
/*     */ import xbean.MarketEquipCon;
/*     */ import xbean.MarketEquipConSet;
/*     */ import xbean.MarketItem;
/*     */ import xbean.MarketPetCon;
/*     */ import xbean.MarketPetConSet;
/*     */ import xbean.MarketPetEquipCon;
/*     */ import xbean.MarketPetEquipConSet;
/*     */ 
/*     */ public class CustomizedConditionManager
/*     */ {
/*  26 */   private static CustomizedConditionManager instance = new CustomizedConditionManager();
/*     */   
/*     */   public static CustomizedConditionManager getInstance()
/*     */   {
/*  30 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  38 */   private final Map<Integer, Map<EquipCondition, Set<Long>>> equipCondition2Roles = new HashMap();
/*  39 */   private final Map<Integer, Map<PetEquipCondition, Set<Long>>> petEquipCondition2Roles = new HashMap();
/*  40 */   private final Map<Integer, Map<PetCondition, Set<Long>>> petCondition2Roles = new HashMap();
/*     */   
/*  42 */   private final ReadWriteLock lock = new java.util.concurrent.locks.ReentrantReadWriteLock();
/*     */   
/*     */   public void addEquipConditionRoleId(int subid, EquipCondition condition, long roleid)
/*     */   {
/*     */     try
/*     */     {
/*  48 */       this.lock.writeLock().lock();
/*     */       
/*  50 */       Map<EquipCondition, Set<Long>> con2RoleMap = (Map)this.equipCondition2Roles.get(Integer.valueOf(subid));
/*  51 */       if (con2RoleMap == null)
/*     */       {
/*  53 */         con2RoleMap = new HashMap();
/*  54 */         this.equipCondition2Roles.put(Integer.valueOf(subid), con2RoleMap);
/*     */       }
/*     */       
/*  57 */       Set<Long> roles = (Set)con2RoleMap.get(condition);
/*  58 */       if (roles == null)
/*     */       {
/*  60 */         roles = new HashSet();
/*  61 */         con2RoleMap.put(condition, roles);
/*     */       }
/*  63 */       roles.add(Long.valueOf(roleid));
/*     */ 
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  68 */       String logStr = String.format("[marketsearch]CustomizedConditionManager.addEquipConditionRoleId@error occured on add|subid=%d|condition=%s|roleid=%d", new Object[] { Integer.valueOf(subid), condition.toString(), Long.valueOf(roleid) });
/*     */       
/*     */ 
/*     */ 
/*  72 */       MarketInterface.getLogger().error(logStr, e);
/*     */     }
/*     */     finally
/*     */     {
/*  76 */       this.lock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public void addPetEquipConditionRoleId(int subid, PetEquipCondition condition, long roleid)
/*     */   {
/*     */     try
/*     */     {
/*  84 */       this.lock.writeLock().lock();
/*     */       
/*  86 */       Map<PetEquipCondition, Set<Long>> con2RoleMap = (Map)this.petEquipCondition2Roles.get(Integer.valueOf(subid));
/*  87 */       if (con2RoleMap == null)
/*     */       {
/*  89 */         con2RoleMap = new HashMap();
/*  90 */         this.petEquipCondition2Roles.put(Integer.valueOf(subid), con2RoleMap);
/*     */       }
/*     */       
/*  93 */       Set<Long> roles = (Set)con2RoleMap.get(condition);
/*  94 */       if (roles == null)
/*     */       {
/*  96 */         roles = new HashSet();
/*  97 */         con2RoleMap.put(condition, roles);
/*     */       }
/*  99 */       roles.add(Long.valueOf(roleid));
/*     */ 
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 104 */       String logStr = String.format("[marketsearch]CustomizedConditionManager.addPetEquipConditionRoleId@error occured on add|subid=%d|condition=%s|roleid=%d", new Object[] { Integer.valueOf(subid), condition.toString(), Long.valueOf(roleid) });
/*     */       
/*     */ 
/*     */ 
/* 108 */       MarketInterface.getLogger().error(logStr, e);
/*     */     }
/*     */     finally
/*     */     {
/* 112 */       this.lock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public void addPetConditionRoleId(int subid, PetCondition condition, long roleid)
/*     */   {
/*     */     try
/*     */     {
/* 120 */       this.lock.writeLock().lock();
/*     */       
/* 122 */       Map<PetCondition, Set<Long>> con2RoleMap = (Map)this.petCondition2Roles.get(Integer.valueOf(subid));
/* 123 */       if (con2RoleMap == null)
/*     */       {
/* 125 */         con2RoleMap = new HashMap();
/* 126 */         this.petCondition2Roles.put(Integer.valueOf(subid), con2RoleMap);
/*     */       }
/*     */       
/* 129 */       Set<Long> roles = (Set)con2RoleMap.get(condition);
/* 130 */       if (roles == null)
/*     */       {
/* 132 */         roles = new HashSet();
/* 133 */         con2RoleMap.put(condition, roles);
/*     */       }
/* 135 */       roles.add(Long.valueOf(roleid));
/*     */ 
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 140 */       String logStr = String.format("[marketsearch]CustomizedConditionManager.addPetConditionRoleId@error occured on add|subid=%d|condition=%s|roleid=%d", new Object[] { Integer.valueOf(subid), condition.toString(), Long.valueOf(roleid) });
/*     */       
/*     */ 
/*     */ 
/* 144 */       MarketInterface.getLogger().error(logStr, e);
/*     */     }
/*     */     finally
/*     */     {
/* 148 */       this.lock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeEquipConditionRoleId(int subid, EquipCondition condition, long roleid)
/*     */   {
/*     */     try
/*     */     {
/* 156 */       this.lock.writeLock().lock();
/*     */       
/* 158 */       Map<EquipCondition, Set<Long>> con2RoleMap = (Map)this.equipCondition2Roles.get(Integer.valueOf(subid));
/* 159 */       if (con2RoleMap == null) {
/*     */         return;
/*     */       }
/*     */       
/*     */ 
/* 164 */       Set<Long> roles = (Set)con2RoleMap.get(condition);
/* 165 */       if (roles == null) {
/*     */         return;
/*     */       }
/*     */       
/* 169 */       roles.remove(Long.valueOf(roleid));
/* 170 */       if (roles.isEmpty())
/*     */       {
/* 172 */         con2RoleMap.remove(condition);
/* 173 */         if (this.equipCondition2Roles.isEmpty())
/*     */         {
/* 175 */           this.equipCondition2Roles.remove(Integer.valueOf(subid));
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 182 */       String logStr = String.format("[marketsearch]CustomizedConditionManager.removeEquipConditionRoleId@error occured on remove|subid=%d|condition=%s|roleid=%d", new Object[] { Integer.valueOf(subid), condition.toString(), Long.valueOf(roleid) });
/*     */       
/*     */ 
/*     */ 
/* 186 */       MarketInterface.getLogger().error(logStr, e);
/*     */     }
/*     */     finally
/*     */     {
/* 190 */       this.lock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public void removePetEquipConditionRoleId(int subid, PetEquipCondition condition, long roleid)
/*     */   {
/*     */     try
/*     */     {
/* 198 */       this.lock.writeLock().lock();
/*     */       
/* 200 */       Map<PetEquipCondition, Set<Long>> con2RoleMap = (Map)this.petEquipCondition2Roles.get(Integer.valueOf(subid));
/* 201 */       if (con2RoleMap == null) {
/*     */         return;
/*     */       }
/*     */       
/*     */ 
/* 206 */       Set<Long> roles = (Set)con2RoleMap.get(condition);
/* 207 */       if (roles == null) {
/*     */         return;
/*     */       }
/*     */       
/* 211 */       roles.remove(Long.valueOf(roleid));
/* 212 */       if (roles.isEmpty())
/*     */       {
/* 214 */         con2RoleMap.remove(condition);
/* 215 */         if (this.petEquipCondition2Roles.isEmpty())
/*     */         {
/* 217 */           this.petEquipCondition2Roles.remove(Integer.valueOf(subid));
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 224 */       String logStr = String.format("[marketsearch]CustomizedConditionManager.removePetEquipConditionRoleId@error occured on remove|subid=%d|condition=%s|roleid=%d", new Object[] { Integer.valueOf(subid), condition.toString(), Long.valueOf(roleid) });
/*     */       
/*     */ 
/*     */ 
/* 228 */       MarketInterface.getLogger().error(logStr, e);
/*     */     }
/*     */     finally
/*     */     {
/* 232 */       this.lock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public void removePetConditionRoleId(int subid, PetCondition condition, long roleid)
/*     */   {
/*     */     try
/*     */     {
/* 240 */       this.lock.writeLock().lock();
/*     */       
/* 242 */       Map<PetCondition, Set<Long>> con2RoleMap = (Map)this.petCondition2Roles.get(Integer.valueOf(subid));
/* 243 */       if (con2RoleMap == null) {
/*     */         return;
/*     */       }
/*     */       
/*     */ 
/* 248 */       Set<Long> roles = (Set)con2RoleMap.get(condition);
/* 249 */       if (roles == null) {
/*     */         return;
/*     */       }
/*     */       
/* 253 */       roles.remove(Long.valueOf(roleid));
/* 254 */       if (roles.isEmpty())
/*     */       {
/* 256 */         con2RoleMap.remove(condition);
/* 257 */         if (this.petCondition2Roles.isEmpty())
/*     */         {
/* 259 */           this.petCondition2Roles.remove(Integer.valueOf(subid));
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 266 */       String logStr = String.format("[marketsearch]CustomizedConditionManager.removePetConditionRoleId@error occured on remove|subid=%d|condition=%s|roleid=%d", new Object[] { Integer.valueOf(subid), condition.toString(), Long.valueOf(roleid) });
/*     */       
/*     */ 
/*     */ 
/* 270 */       MarketInterface.getLogger().error(logStr, e);
/*     */     }
/*     */     finally
/*     */     {
/* 274 */       this.lock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getConditionLengthTime(int subid)
/*     */   {
/* 286 */     mzm.gsp.market.confbean.SMarketSubTypeCfg marketSubTypeCfg = mzm.gsp.market.confbean.SMarketSubTypeCfg.get(subid);
/* 287 */     if (marketSubTypeCfg == null)
/*     */     {
/* 289 */       return 0;
/*     */     }
/*     */     
/*     */ 
/* 293 */     mzm.gsp.market.confbean.SMarketCfg marketCfg = mzm.gsp.market.confbean.SMarketCfg.get(marketSubTypeCfg.marketCfgId);
/* 294 */     if (marketCfg == null)
/*     */     {
/* 296 */       return 0;
/*     */     }
/* 298 */     return marketCfg.conditionEffectTime;
/*     */   }
/*     */   
/*     */ 
/*     */   private void sendHasCustomizedTipRes(long roleid, int subid, int index, boolean isPub)
/*     */   {
/* 304 */     mzm.gsp.market.SSynHasCustomizedRes res = new mzm.gsp.market.SSynHasCustomizedRes();
/* 305 */     res.index = index;
/* 306 */     res.subid = subid;
/* 307 */     res.puborsell = (isPub ? 0 : 1);
/* 308 */     mzm.gsp.online.main.OnlineManager.getInstance().send(roleid, res);
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
/*     */   public void sendEquipOnShelfTipToAll(int subid, long marketId, MarketItem xMarketItem, boolean isPub)
/*     */   {
/* 321 */     if (!OpenInterface.getOpenStatus(119))
/*     */     {
/*     */ 
/* 324 */       return;
/*     */     }
/*     */     try
/*     */     {
/* 328 */       this.lock.readLock().lock();
/*     */       
/* 330 */       condition2roles = (Map)this.equipCondition2Roles.get(Integer.valueOf(subid));
/* 331 */       if ((condition2roles == null) || (condition2roles.isEmpty())) {
/*     */         return;
/*     */       }
/*     */       
/*     */ 
/* 336 */       for (i$ = condition2roles.keySet().iterator(); i$.hasNext();) { equipCondition = (EquipCondition)i$.next();
/*     */         
/* 338 */         if (equipCondition.isTrue(xMarketItem))
/*     */         {
/*     */ 
/*     */ 
/* 342 */           Set<Long> roleSet = (Set)condition2roles.get(equipCondition);
/* 343 */           if ((roleSet != null) && (!roleSet.isEmpty()))
/*     */           {
/*     */ 
/*     */ 
/* 347 */             for (i$ = roleSet.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*     */               
/* 349 */               new SendTipToRole(roleid, subid, isPub, equipCondition).execute();
/*     */             } }
/*     */         }
/*     */       } } catch (Exception e) { Map<EquipCondition, Set<Long>> condition2roles;
/*     */       Iterator i$;
/*     */       EquipCondition equipCondition;
/*     */       Iterator i$;
/* 356 */       String logStr = String.format("[marketsearch]CustomizedConditionManager.sendEquipOnShelfTipToAll@error occured |subid=%d", new Object[] { Integer.valueOf(subid) });
/*     */       
/*     */ 
/* 359 */       MarketInterface.getLogger().error(logStr, e);
/*     */ 
/*     */     }
/*     */     finally
/*     */     {
/* 364 */       this.lock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean isSame(MarketEquipCon c1, EquipCondition c2)
/*     */   {
/* 371 */     if (c1.getLevel() != c2.getLevel())
/*     */     {
/* 373 */       return false;
/*     */     }
/*     */     
/* 376 */     if (!c1.getColors().equals(new HashSet(c2.getColors())))
/*     */     {
/* 378 */       return false;
/*     */     }
/* 380 */     if (!c1.getSkillids().equals(new HashSet(c2.getSkillIds())))
/*     */     {
/* 382 */       return false;
/*     */     }
/* 384 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean isSame(MarketPetCon c1, PetCondition c2)
/*     */   {
/* 390 */     if (c1.getSkillnum() != c2.getSkillNum())
/*     */     {
/* 392 */       return false;
/*     */     }
/* 394 */     if (!c1.getPettypes().equals(new HashSet(c2.getPetTypes())))
/*     */     {
/* 396 */       return false;
/*     */     }
/* 398 */     if (!c1.getSkillids().equals(new HashSet(c2.getSkillIds())))
/*     */     {
/* 400 */       return false;
/*     */     }
/* 402 */     if (!c1.getQualitys().equals(new HashSet(c2.getQualitys())))
/*     */     {
/* 404 */       return false;
/*     */     }
/* 406 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean isSame(MarketPetEquipCon c1, PetEquipCondition c2)
/*     */   {
/* 412 */     if (c1.getProperty() != c2.getProperty())
/*     */     {
/* 414 */       return false;
/*     */     }
/* 416 */     if (!c1.getSkillids().equals(new HashSet(c2.getSkillIds())))
/*     */     {
/* 418 */       return false;
/*     */     }
/*     */     
/* 421 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   private static class SendTipToRole
/*     */     extends mzm.gsp.util.LogicProcedure
/*     */   {
/*     */     private final long roleId;
/*     */     private final int subid;
/*     */     private final boolean isPub;
/*     */     private final AbstractCondition<?> condition;
/*     */     
/*     */     public SendTipToRole(long roleId, int subid, boolean isPub, AbstractCondition<?> condition)
/*     */     {
/* 435 */       this.roleId = roleId;
/* 436 */       this.subid = subid;
/* 437 */       this.isPub = isPub;
/* 438 */       this.condition = condition;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 444 */       if (!MarketInterface.isMarketCustomizedSwitchOpenForRole(this.roleId))
/*     */       {
/* 446 */         return false;
/*     */       }
/* 448 */       CustommizedCons xCustommizedCons = xtable.Role2customized.get(Long.valueOf(this.roleId));
/* 449 */       if (xCustommizedCons == null)
/*     */       {
/* 451 */         return false;
/*     */       }
/* 453 */       long now = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/*     */       EquipCondition c;
/* 455 */       int i; if ((this.condition instanceof EquipCondition))
/*     */       {
/* 457 */         c = (EquipCondition)this.condition;
/* 458 */         MarketEquipConSet xMarketEquipConSet = (MarketEquipConSet)xCustommizedCons.getSubid2equipcons().get(Integer.valueOf(this.subid));
/* 459 */         CustomizedConditionManager.getInstance().removeRoleTimeOutConditions(xCustommizedCons, now);
/* 460 */         if ((xMarketEquipConSet == null) || (xMarketEquipConSet.getEquipcons().isEmpty()))
/*     */         {
/* 462 */           return false;
/*     */         }
/* 464 */         i = 0;
/* 465 */         for (MarketEquipCon xMarketEquipCon : xMarketEquipConSet.getEquipcons())
/*     */         {
/*     */ 
/* 468 */           i++;
/* 469 */           if (CustomizedConditionManager.getInstance().isSame(xMarketEquipCon, c))
/*     */           {
/* 471 */             CustomizedConditionManager.getInstance().sendHasCustomizedTipRes(this.roleId, this.subid, i, this.isPub);
/* 472 */             return true;
/*     */           }
/*     */         }
/*     */       }
/*     */       PetEquipCondition c;
/*     */       int i;
/* 478 */       if ((this.condition instanceof PetEquipCondition))
/*     */       {
/* 480 */         c = (PetEquipCondition)this.condition;
/*     */         
/* 482 */         MarketPetEquipConSet xMarketPetEquipConSet = (MarketPetEquipConSet)xCustommizedCons.getSubid2petequipcons().get(Integer.valueOf(this.subid));
/* 483 */         if ((xMarketPetEquipConSet == null) || (xMarketPetEquipConSet.getPetequipcons().isEmpty()))
/*     */         {
/* 485 */           return false;
/*     */         }
/* 487 */         i = 0;
/* 488 */         for (MarketPetEquipCon xMarketPetEquipCon : xMarketPetEquipConSet.getPetequipcons())
/*     */         {
/*     */ 
/* 491 */           i++;
/* 492 */           if (CustomizedConditionManager.getInstance().isSame(xMarketPetEquipCon, c))
/*     */           {
/* 494 */             CustomizedConditionManager.getInstance().sendHasCustomizedTipRes(this.roleId, this.subid, i, this.isPub);
/* 495 */             return true;
/*     */           }
/*     */         }
/*     */       }
/*     */       PetCondition c;
/*     */       int i;
/* 501 */       if ((this.condition instanceof PetCondition))
/*     */       {
/* 503 */         c = (PetCondition)this.condition;
/*     */         
/* 505 */         MarketPetConSet xMarketPetConSet = (MarketPetConSet)xCustommizedCons.getSubid2petcons().get(Integer.valueOf(this.subid));
/*     */         
/* 507 */         if ((xMarketPetConSet == null) || (xMarketPetConSet.getPetcons().isEmpty()))
/*     */         {
/* 509 */           return false;
/*     */         }
/* 511 */         i = 0;
/* 512 */         for (MarketPetCon xMarketPetCon : xMarketPetConSet.getPetcons())
/*     */         {
/*     */ 
/* 515 */           i++;
/* 516 */           if (CustomizedConditionManager.getInstance().isSame(xMarketPetCon, c))
/*     */           {
/* 518 */             CustomizedConditionManager.getInstance().sendHasCustomizedTipRes(this.roleId, this.subid, i, this.isPub);
/* 519 */             return true;
/*     */           }
/*     */         }
/*     */       }
/*     */       
/*     */ 
/* 525 */       return true;
/*     */     }
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
/*     */   public void sendPetEquipOnShelfTipToAll(int subid, long marketId, MarketItem xMarketItem, boolean isPub)
/*     */   {
/* 540 */     if (!OpenInterface.getOpenStatus(119))
/*     */     {
/*     */ 
/* 543 */       return;
/*     */     }
/*     */     try
/*     */     {
/* 547 */       this.lock.readLock().lock();
/*     */       
/* 549 */       condition2roles = (Map)this.petEquipCondition2Roles.get(Integer.valueOf(subid));
/* 550 */       if ((condition2roles == null) || (condition2roles.isEmpty())) {
/*     */         return;
/*     */       }
/*     */       
/*     */ 
/* 555 */       for (i$ = condition2roles.keySet().iterator(); i$.hasNext();) { petEquipCondition = (PetEquipCondition)i$.next();
/*     */         
/* 557 */         if (petEquipCondition.isTrue(xMarketItem))
/*     */         {
/*     */ 
/*     */ 
/* 561 */           Set<Long> roleSet = (Set)condition2roles.get(petEquipCondition);
/* 562 */           if ((roleSet != null) && (!roleSet.isEmpty()))
/*     */           {
/*     */ 
/*     */ 
/* 566 */             for (i$ = roleSet.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*     */               
/* 568 */               new SendTipToRole(roleid, subid, isPub, petEquipCondition).execute();
/*     */             } }
/*     */         }
/*     */       } } catch (Exception e) { Map<PetEquipCondition, Set<Long>> condition2roles;
/*     */       Iterator i$;
/*     */       PetEquipCondition petEquipCondition;
/*     */       Iterator i$;
/* 575 */       String logStr = String.format("[marketsearch]CustomizedConditionManager.sendPetEquipOnShelfTipToAll@error occured |subid=%d", new Object[] { Integer.valueOf(subid) });
/*     */       
/*     */ 
/* 578 */       MarketInterface.getLogger().error(logStr, e);
/*     */ 
/*     */     }
/*     */     finally
/*     */     {
/* 583 */       this.lock.readLock().unlock();
/*     */     }
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
/*     */   public void sendPetOnShelfTipToAll(int subid, long marketId, xbean.MarketPet xMarketPet, boolean isPub)
/*     */   {
/* 598 */     if (!OpenInterface.getOpenStatus(119))
/*     */     {
/*     */ 
/* 601 */       return;
/*     */     }
/*     */     try
/*     */     {
/* 605 */       this.lock.readLock().lock();
/*     */       
/* 607 */       condition2roles = (Map)this.petCondition2Roles.get(Integer.valueOf(subid));
/* 608 */       if ((condition2roles == null) || (condition2roles.isEmpty())) {
/*     */         return;
/*     */       }
/*     */       
/*     */ 
/* 613 */       for (i$ = condition2roles.keySet().iterator(); i$.hasNext();) { petCondition = (PetCondition)i$.next();
/*     */         
/* 615 */         if (petCondition.isTrue(xMarketPet))
/*     */         {
/*     */ 
/*     */ 
/* 619 */           Set<Long> roleSet = (Set)condition2roles.get(petCondition);
/* 620 */           if ((roleSet != null) && (!roleSet.isEmpty()))
/*     */           {
/*     */ 
/*     */ 
/* 624 */             for (i$ = roleSet.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*     */               
/* 626 */               new SendTipToRole(roleid, subid, isPub, petCondition).execute();
/*     */             } }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) { Map<PetCondition, Set<Long>> condition2roles;
/*     */       Iterator i$;
/*     */       PetCondition petCondition;
/*     */       Iterator i$;
/* 634 */       String logStr = String.format("[marketsearch]CustomizedConditionManager.sendPetOnShelfTipToAll@error occured |subid=%d", new Object[] { Integer.valueOf(subid) });
/*     */       
/*     */ 
/* 637 */       MarketInterface.getLogger().error(logStr, e);
/*     */ 
/*     */     }
/*     */     finally
/*     */     {
/* 642 */       this.lock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   void removeRoleTimeOutConditions(CustommizedCons xCustommizedCons, long now)
/*     */   {
/* 649 */     if (xCustommizedCons == null)
/*     */     {
/* 651 */       return;
/*     */     }
/* 653 */     for (Iterator i$ = xCustommizedCons.getSubid2equipcons().keySet().iterator(); i$.hasNext();) { int subid = ((Integer)i$.next()).intValue();
/*     */       
/* 655 */       MarketEquipConSet xMarketEquipConSet = (MarketEquipConSet)xCustommizedCons.getSubid2equipcons().get(Integer.valueOf(subid));
/*     */       
/* 657 */       Iterator<MarketEquipCon> iterator = xMarketEquipConSet.getEquipcons().iterator();
/*     */       
/* 659 */       while (iterator.hasNext())
/*     */       {
/* 661 */         MarketEquipCon xMarketEquipCon = (MarketEquipCon)iterator.next();
/* 662 */         if (TimeUnit.SECONDS.toMillis(xMarketEquipCon.getCusttime()) + TimeUnit.HOURS.toMillis(getInstance().getConditionLengthTime(subid)) < now)
/*     */         {
/*     */ 
/* 665 */           iterator.remove();
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 670 */     for (Iterator i$ = xCustommizedCons.getSubid2petequipcons().keySet().iterator(); i$.hasNext();) { int subid = ((Integer)i$.next()).intValue();
/*     */       
/* 672 */       MarketPetEquipConSet xMarketPetEquipConSet = (MarketPetEquipConSet)xCustommizedCons.getSubid2petequipcons().get(Integer.valueOf(subid));
/*     */       
/* 674 */       Iterator<MarketPetEquipCon> iterator = xMarketPetEquipConSet.getPetequipcons().iterator();
/* 675 */       while (iterator.hasNext())
/*     */       {
/* 677 */         MarketPetEquipCon xMarketEquipCon = (MarketPetEquipCon)iterator.next();
/* 678 */         if (TimeUnit.SECONDS.toMillis(xMarketEquipCon.getCusttime()) + TimeUnit.HOURS.toMillis(getInstance().getConditionLengthTime(subid)) < now)
/*     */         {
/*     */ 
/* 681 */           iterator.remove();
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 686 */     for (Iterator i$ = xCustommizedCons.getSubid2petcons().keySet().iterator(); i$.hasNext();) { int subid = ((Integer)i$.next()).intValue();
/*     */       
/* 688 */       MarketPetConSet xMarketPetConSet = (MarketPetConSet)xCustommizedCons.getSubid2petcons().get(Integer.valueOf(subid));
/*     */       
/* 690 */       Iterator<MarketPetCon> iterator = xMarketPetConSet.getPetcons().iterator();
/* 691 */       while (iterator.hasNext())
/*     */       {
/* 693 */         MarketPetCon xMarketPetCon = (MarketPetCon)iterator.next();
/* 694 */         if (TimeUnit.SECONDS.toMillis(xMarketPetCon.getCusttime()) + TimeUnit.HOURS.toMillis(getInstance().getConditionLengthTime(subid)) < now)
/*     */         {
/*     */ 
/* 697 */           iterator.remove();
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   boolean isCustomizedToMax(CustommizedCons xCustommizedCons)
/*     */   {
/* 706 */     if (xCustommizedCons == null)
/*     */     {
/* 708 */       return false;
/*     */     }
/* 710 */     int c = 0;
/* 711 */     for (Iterator i$ = xCustommizedCons.getSubid2equipcons().keySet().iterator(); i$.hasNext();) { int subid = ((Integer)i$.next()).intValue();
/*     */       
/* 713 */       MarketEquipConSet xMarketEquipConSet = (MarketEquipConSet)xCustommizedCons.getSubid2equipcons().get(Integer.valueOf(subid));
/*     */       
/* 715 */       c += xMarketEquipConSet.getEquipcons().size();
/*     */     }
/*     */     
/* 718 */     for (Iterator i$ = xCustommizedCons.getSubid2petequipcons().keySet().iterator(); i$.hasNext();) { int subid = ((Integer)i$.next()).intValue();
/*     */       
/* 720 */       MarketPetEquipConSet xMarketPetEquipConSet = (MarketPetEquipConSet)xCustommizedCons.getSubid2petequipcons().get(Integer.valueOf(subid));
/* 721 */       c += xMarketPetEquipConSet.getPetequipcons().size();
/*     */     }
/*     */     
/* 724 */     for (Iterator i$ = xCustommizedCons.getSubid2petcons().keySet().iterator(); i$.hasNext();) { int subid = ((Integer)i$.next()).intValue();
/*     */       
/* 726 */       MarketPetConSet xMarketPetConSet = (MarketPetConSet)xCustommizedCons.getSubid2petcons().get(Integer.valueOf(subid));
/* 727 */       c += xMarketPetConSet.getPetcons().size();
/*     */     }
/*     */     
/* 730 */     return c >= mzm.gsp.market.confbean.SMarketConsts.getInstance().MAX_CUSTOMIZED_CONDITION_NUM;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\search\CustomizedConditionManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */