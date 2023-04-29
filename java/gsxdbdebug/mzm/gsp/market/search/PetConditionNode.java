/*     */ package mzm.gsp.market.search;
/*     */ 
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.locks.Lock;
/*     */ import java.util.concurrent.locks.ReadWriteLock;
/*     */ import mzm.gsp.market.main.MarketInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.MarketPet;
/*     */ 
/*     */ public class PetConditionNode
/*     */ {
/*  16 */   private final Map<Integer, SearchPetNode> subid2Node = new java.util.LinkedHashMap(32)
/*     */   {
/*     */     private static final long serialVersionUID = -7970084122871015845L;
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     protected boolean removeEldestEntry(Map.Entry<Integer, SearchPetNode> eldest)
/*     */     {
/*  25 */       return size() >= Math.max(8, MarketInterface.getPetSubidSize() / 3);
/*     */     }
/*     */   };
/*     */   
/*  29 */   private final ReadWriteLock lock = new java.util.concurrent.locks.ReentrantReadWriteLock();
/*     */   
/*     */   public void addPetChartObj(int subid, AbstractCondition<MarketPet> condition, PetChartObj petChartObj)
/*     */   {
/*     */     try
/*     */     {
/*  35 */       this.lock.writeLock().lock();
/*     */       
/*  37 */       SearchPetNode conditionNode = (SearchPetNode)this.subid2Node.get(Integer.valueOf(subid));
/*  38 */       if (conditionNode == null)
/*     */       {
/*  40 */         conditionNode = new SearchPetNode(MarketSearcherManager.getPetSubIdCacheNum());
/*  41 */         this.subid2Node.put(Integer.valueOf(subid), conditionNode);
/*     */       }
/*  43 */       conditionNode.addPetChartObj(condition, petChartObj);
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  47 */       String logStr = String.format("[marketsearch]PetConditionNode.addPetChartObj@error occured on add marketid|subid=%d|condition=%s|marketId=%d", new Object[] { Integer.valueOf(subid), condition.toString(), Long.valueOf(petChartObj.getMarketId()) });
/*     */       
/*     */ 
/*     */ 
/*  51 */       MarketInterface.getLogger().error(logStr, e);
/*     */     }
/*     */     finally
/*     */     {
/*  55 */       this.lock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public void addPetChartObjs(int subid, AbstractCondition<MarketPet> condition, List<PetChartObj> petChartObjs)
/*     */   {
/*  62 */     if ((petChartObjs == null) || (petChartObjs.isEmpty()))
/*     */     {
/*  64 */       return;
/*     */     }
/*     */     try
/*     */     {
/*  68 */       this.lock.writeLock().lock();
/*     */       
/*  70 */       SearchPetNode conditionNode = (SearchPetNode)this.subid2Node.get(Integer.valueOf(subid));
/*  71 */       if (conditionNode == null)
/*     */       {
/*  73 */         conditionNode = new SearchPetNode(MarketSearcherManager.getPetSubIdCacheNum());
/*  74 */         this.subid2Node.put(Integer.valueOf(subid), conditionNode);
/*     */       }
/*  76 */       conditionNode.addPetChartObjs(condition, petChartObjs);
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  80 */       String logStr = String.format("[marketsearch]PetConditionNode.addPetChartObjs@error occured on add marketid|subid=%d|condition=%s", new Object[] { Integer.valueOf(subid), condition.toString() });
/*     */       
/*     */ 
/*     */ 
/*  84 */       MarketInterface.getLogger().error(logStr, e);
/*     */     }
/*     */     finally
/*     */     {
/*  88 */       this.lock.writeLock().unlock();
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
/*     */   public List<PetChartObj> getPetChartObjByPage(int subid, AbstractCondition<MarketPet> condition, boolean isAsc, int pageNo)
/*     */   {
/*     */     try
/*     */     {
/* 105 */       this.lock.readLock().lock();
/*     */       
/* 107 */       SearchPetNode conditionNode = (SearchPetNode)this.subid2Node.get(Integer.valueOf(subid));
/* 108 */       Object localObject1; if (conditionNode == null)
/*     */       {
/* 110 */         return null;
/*     */       }
/* 112 */       return conditionNode.getByPage(condition, isAsc, pageNo);
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 116 */       String logStr = String.format("[marketsearch]PetConditionNode.getPetChartObjByPage@error occured on getPetChartObjByPage|subid=%d|condition=%s", new Object[] { Integer.valueOf(subid), condition.toString() });
/*     */       
/*     */ 
/*     */ 
/* 120 */       MarketInterface.getLogger().error(logStr, e);
/* 121 */       return null;
/*     */     }
/*     */     finally
/*     */     {
/* 125 */       this.lock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public void removePetChartObj(int subid, AbstractCondition<MarketPet> condition, long marketId)
/*     */   {
/*     */     try
/*     */     {
/* 134 */       this.lock.writeLock().lock();
/*     */       
/* 136 */       SearchPetNode conditionNode = (SearchPetNode)this.subid2Node.get(Integer.valueOf(subid));
/* 137 */       if (conditionNode == null) {
/*     */         return;
/*     */       }
/*     */       
/* 141 */       conditionNode.removePetChartObj(condition, marketId);
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 145 */       String logStr = String.format("[marketsearch]PetConditionNode.removePetChartObj@error occured on removePetChartObj|subid=%d|condition=%s|marketId=%d", new Object[] { Integer.valueOf(subid), condition.toString(), Long.valueOf(marketId) });
/*     */       
/*     */ 
/*     */ 
/* 149 */       MarketInterface.getLogger().error(logStr, e);
/*     */     }
/*     */     finally
/*     */     {
/* 153 */       this.lock.writeLock().unlock();
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
/*     */   public int getSize(int subid, AbstractCondition<MarketPet> condition)
/*     */   {
/*     */     try
/*     */     {
/* 168 */       this.lock.readLock().lock();
/*     */       
/* 170 */       SearchPetNode conditionNode = (SearchPetNode)this.subid2Node.get(Integer.valueOf(subid));
/* 171 */       int i; if (conditionNode == null)
/*     */       {
/* 173 */         return -1;
/*     */       }
/* 175 */       return conditionNode.getSize(condition);
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 179 */       String logStr = String.format("[marketsearch]PetConditionNode.getSize@error occured on getSize|subid=%d|condition=%s", new Object[] { Integer.valueOf(subid), condition.toString() });
/*     */       
/*     */ 
/*     */ 
/* 183 */       MarketInterface.getLogger().error(logStr, e);
/* 184 */       return -1;
/*     */     }
/*     */     finally
/*     */     {
/* 188 */       this.lock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void clear(int subid, AbstractCondition<MarketPet> condition)
/*     */   {
/*     */     try
/*     */     {
/* 202 */       this.lock.writeLock().lock();
/*     */       
/* 204 */       SearchPetNode conditionNode = (SearchPetNode)this.subid2Node.get(Integer.valueOf(subid));
/* 205 */       if (conditionNode != null)
/*     */       {
/* 207 */         conditionNode.remove(condition);
/*     */       }
/*     */       
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 213 */       String logStr = String.format("[marketsearch]PetConditionNode.clear@error occured on clear marketid|subid=%d|condition=%s", new Object[] { Integer.valueOf(subid), condition.toString() });
/*     */       
/*     */ 
/*     */ 
/* 217 */       MarketInterface.getLogger().error(logStr, e);
/*     */ 
/*     */     }
/*     */     finally
/*     */     {
/* 222 */       this.lock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Set<AbstractCondition<MarketPet>> getAllConditions(int subid)
/*     */   {
/*     */     try
/*     */     {
/* 236 */       this.lock.readLock().lock();
/*     */       
/* 238 */       SearchPetNode conditionNode = (SearchPetNode)this.subid2Node.get(Integer.valueOf(subid));
/* 239 */       Set localSet1; if (conditionNode == null)
/*     */       {
/* 241 */         return Collections.emptySet();
/*     */       }
/*     */       
/*     */ 
/* 245 */       return conditionNode.getAllConditions();
/*     */ 
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*     */ 
/* 251 */       String logStr = String.format("[marketsearch]PetConditionNode.getAllConditions@error occured on getAllConditions|subid=%d", new Object[] { Integer.valueOf(subid) });
/*     */       
/*     */ 
/* 254 */       MarketInterface.getLogger().error(logStr, e);
/* 255 */       return Collections.emptySet();
/*     */     }
/*     */     finally
/*     */     {
/* 259 */       this.lock.readLock().unlock();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\search\PetConditionNode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */