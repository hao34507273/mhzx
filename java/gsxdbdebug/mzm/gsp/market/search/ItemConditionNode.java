/*     */ package mzm.gsp.market.search;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.locks.Lock;
/*     */ import java.util.concurrent.locks.ReadWriteLock;
/*     */ import mzm.gsp.market.main.MarketInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.MarketItem;
/*     */ 
/*     */ public class ItemConditionNode
/*     */ {
/*  15 */   private final Map<Integer, SearchItemNode> subid2Node = new java.util.LinkedHashMap(32)
/*     */   {
/*     */     private static final long serialVersionUID = -7970084122871015845L;
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     protected boolean removeEldestEntry(Map.Entry<Integer, SearchItemNode> eldest)
/*     */     {
/*  24 */       return size() >= Math.max(16, MarketInterface.getItemSubidSize() / 3);
/*     */     }
/*     */   };
/*     */   
/*  28 */   private final ReadWriteLock lock = new java.util.concurrent.locks.ReentrantReadWriteLock();
/*     */   
/*     */   public void addItemChartObj(int subid, AbstractCondition<MarketItem> condition, ItemChartObj itemChartObj)
/*     */   {
/*     */     try
/*     */     {
/*  34 */       this.lock.writeLock().lock();
/*     */       
/*  36 */       SearchItemNode conditionNode = (SearchItemNode)this.subid2Node.get(Integer.valueOf(subid));
/*  37 */       if (conditionNode == null)
/*     */       {
/*  39 */         conditionNode = new SearchItemNode(MarketSearcherManager.getItemSubIdCacheNum());
/*  40 */         this.subid2Node.put(Integer.valueOf(subid), conditionNode);
/*     */       }
/*  42 */       conditionNode.addItemChartObj(condition, itemChartObj);
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  46 */       String logStr = String.format("[marketsearch]ItemConditionNode.addItemChartObjs@error occured on add addItemChartObj|subid=%d|condition=%s", new Object[] { Integer.valueOf(subid), condition.toString() });
/*     */       
/*     */ 
/*     */ 
/*  50 */       MarketInterface.getLogger().error(logStr, e);
/*     */     }
/*     */     finally
/*     */     {
/*  54 */       this.lock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public void addItemChartObjs(int subid, AbstractCondition<MarketItem> condition, List<ItemChartObj> itemChartObjs)
/*     */   {
/*  61 */     if ((itemChartObjs == null) || (itemChartObjs.isEmpty()))
/*     */     {
/*  63 */       return;
/*     */     }
/*     */     try
/*     */     {
/*  67 */       this.lock.writeLock().lock();
/*     */       
/*  69 */       SearchItemNode conditionNode = (SearchItemNode)this.subid2Node.get(Integer.valueOf(subid));
/*  70 */       if (conditionNode == null)
/*     */       {
/*  72 */         conditionNode = new SearchItemNode(MarketSearcherManager.getItemSubIdCacheNum());
/*  73 */         this.subid2Node.put(Integer.valueOf(subid), conditionNode);
/*     */       }
/*     */       
/*  76 */       conditionNode.addItemChartObjs(condition, itemChartObjs);
/*     */ 
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  81 */       String logStr = String.format("[marketsearch]ItemConditionNode.addItemChartObjs@error occured on add addItemChartObjs|subid=%d|condition=%s", new Object[] { Integer.valueOf(subid), condition.toString() });
/*     */       
/*     */ 
/*     */ 
/*  85 */       MarketInterface.getLogger().error(logStr, e);
/*     */     }
/*     */     finally
/*     */     {
/*  89 */       this.lock.writeLock().unlock();
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
/*     */   public List<ItemChartObj> getItemChartObjByPage(int subid, AbstractCondition<MarketItem> condition, boolean isAsc, int pageNo)
/*     */   {
/*     */     try
/*     */     {
/* 106 */       this.lock.readLock().lock();
/*     */       
/* 108 */       SearchItemNode conditionNode = (SearchItemNode)this.subid2Node.get(Integer.valueOf(subid));
/* 109 */       Object localObject1; if (conditionNode == null)
/*     */       {
/* 111 */         return null;
/*     */       }
/* 113 */       return conditionNode.getByPage(condition, isAsc, pageNo);
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 117 */       String logStr = String.format("[marketsearch]ItemConditionNode.getItemChartObjByPage@error occured on get getItemChartObjByPage|subid=%d|condition=%s", new Object[] { Integer.valueOf(subid), condition.toString() });
/*     */       
/*     */ 
/*     */ 
/* 121 */       MarketInterface.getLogger().error(logStr, e);
/* 122 */       return null;
/*     */     }
/*     */     finally
/*     */     {
/* 126 */       this.lock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public void removeItemChartObj(int subid, AbstractCondition<MarketItem> condition, long marketId)
/*     */   {
/*     */     try
/*     */     {
/* 135 */       this.lock.writeLock().lock();
/*     */       
/* 137 */       SearchItemNode conditionNode = (SearchItemNode)this.subid2Node.get(Integer.valueOf(subid));
/* 138 */       if (conditionNode == null) {
/*     */         return;
/*     */       }
/*     */       
/* 142 */       conditionNode.removeItemChartObj(condition, marketId);
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 146 */       String logStr = String.format("[marketsearch]ItemConditionNode.removeItemChartObj@error occured on remove removeItemChartObj|subid=%d|condition=%s|marketId=%d", new Object[] { Integer.valueOf(subid), condition.toString(), Long.valueOf(marketId) });
/*     */       
/*     */ 
/*     */ 
/* 150 */       MarketInterface.getLogger().error(logStr, e);
/*     */     }
/*     */     finally
/*     */     {
/* 154 */       this.lock.writeLock().unlock();
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
/*     */   public int getSize(int subid, AbstractCondition<MarketItem> condition)
/*     */   {
/*     */     try
/*     */     {
/* 169 */       this.lock.readLock().lock();
/*     */       
/* 171 */       SearchItemNode conditionNode = (SearchItemNode)this.subid2Node.get(Integer.valueOf(subid));
/* 172 */       int i; if (conditionNode == null)
/*     */       {
/* 174 */         return -1;
/*     */       }
/* 176 */       return conditionNode.getSize(condition);
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 180 */       String logStr = String.format("[marketsearch]ItemConditionNode.getSize@error occured on getSize|subid=%d|condition=%s", new Object[] { Integer.valueOf(subid), condition.toString() });
/*     */       
/*     */ 
/*     */ 
/* 184 */       MarketInterface.getLogger().error(logStr, e);
/* 185 */       return -1;
/*     */     }
/*     */     finally
/*     */     {
/* 189 */       this.lock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void clear(int subid, AbstractCondition<MarketItem> condition)
/*     */   {
/*     */     try
/*     */     {
/* 203 */       this.lock.writeLock().lock();
/*     */       
/* 205 */       SearchItemNode conditionNode = (SearchItemNode)this.subid2Node.get(Integer.valueOf(subid));
/* 206 */       if (conditionNode != null)
/*     */       {
/* 208 */         conditionNode.remove(condition);
/*     */       }
/*     */       
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 214 */       String logStr = String.format("[marketsearch]ItemConditionNode.clear@error occured on clear marketid|subid=%d|condition=%s", new Object[] { Integer.valueOf(subid), condition.toString() });
/*     */       
/*     */ 
/*     */ 
/* 218 */       MarketInterface.getLogger().error(logStr, e);
/*     */ 
/*     */     }
/*     */     finally
/*     */     {
/* 223 */       this.lock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Set<AbstractCondition<MarketItem>> getAllConditions(int subid)
/*     */   {
/*     */     try
/*     */     {
/* 237 */       this.lock.readLock().lock();
/*     */       
/* 239 */       SearchItemNode conditionNode = (SearchItemNode)this.subid2Node.get(Integer.valueOf(subid));
/* 240 */       Set localSet1; if (conditionNode == null)
/*     */       {
/* 242 */         return java.util.Collections.emptySet();
/*     */       }
/* 244 */       return conditionNode.getAllConditions();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 248 */       String logStr = String.format("[marketsearch]ItemConditionNode.getAllConditions@error occured on getAllConditions|subid=%d", new Object[] { Integer.valueOf(subid) });
/*     */       
/*     */ 
/* 251 */       MarketInterface.getLogger().error(logStr, e);
/* 252 */       return java.util.Collections.emptySet();
/*     */     }
/*     */     finally
/*     */     {
/* 256 */       this.lock.readLock().unlock();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\search\ItemConditionNode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */