/*     */ package mzm.gsp.item.main.sift;
/*     */ 
/*     */ import java.util.HashSet;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ import java.util.concurrent.locks.Lock;
/*     */ import java.util.concurrent.locks.ReadWriteLock;
/*     */ import java.util.concurrent.locks.ReentrantReadWriteLock;
/*     */ import mzm.gsp.item.confbean.SItemDrugInFightCfg;
/*     */ import mzm.gsp.item.confbean.SItemDrugOutFightCfg;
/*     */ import mzm.gsp.item.confbean.SItemEquipCfg;
/*     */ import mzm.gsp.item.confbean.SPetSkillBookCfg;
/*     */ import mzm.gsp.item.main.sift.condition.AbsSiftCondition;
/*     */ import org.apache.log4j.Logger;
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
/*     */ public class SiftCacheManager
/*     */ {
/*  31 */   private static Map<Integer, Node> cacheItemMap = new ConcurrentHashMap();
/*     */   
/*  33 */   private static final Logger LOGGER = Logger.getLogger(SiftCacheManager.class);
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private static class Node
/*     */   {
/*     */     private int floor;
/*     */     
/*     */ 
/*     */     private Set<Integer> ids;
/*     */     
/*     */ 
/*     */     private LinkedHashMap<AbsSiftCondition, Node> _subNodes;
/*     */     
/*     */ 
/*  49 */     private ReadWriteLock subNodesLock = new ReentrantReadWriteLock();
/*     */     
/*     */     Node(int floor) {
/*  52 */       this.floor = floor;
/*  53 */       this.ids = new HashSet();
/*  54 */       this._subNodes = new LinkedHashMap()
/*     */       {
/*     */         private static final long serialVersionUID = -1L;
/*     */         
/*     */         protected boolean removeEldestEntry(Map.Entry<AbsSiftCondition, SiftCacheManager.Node> eldest)
/*     */         {
/*  60 */           if (size() >= SiftItemArgs.getInstance().subNodeMax) {
/*  61 */             return true;
/*     */           }
/*  63 */           return false;
/*     */         }
/*     */       };
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     Node getNodeBySiftCondition(AbsSiftCondition siftCondition)
/*     */     {
/*  75 */       this.subNodesLock.readLock().lock();
/*     */       try {
/*  77 */         return (Node)this._subNodes.get(siftCondition);
/*     */       } catch (Exception e) {
/*  79 */         SiftCacheManager.LOGGER.error("getNodeBySiftCondition出错!!", e);
/*     */       } finally {
/*  81 */         this.subNodesLock.readLock().unlock();
/*     */       }
/*  83 */       return null;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     void putNode(AbsSiftCondition siftCondition, Node node)
/*     */     {
/*  93 */       this.subNodesLock.writeLock().lock();
/*     */       try {
/*  95 */         this._subNodes.put(siftCondition, node);
/*  96 */         SiftCacheManager.LOGGER.debug("CacheNodeAdd: AbsSiftCondition=" + siftCondition.getClass().getName() + "  conId=" + siftCondition.getConId() + "   conditionParams=" + siftCondition.getConditionParams() + " floor=" + node.floor);
/*     */ 
/*     */       }
/*     */       catch (Exception e)
/*     */       {
/* 101 */         SiftCacheManager.LOGGER.error("SiftCacheManager.putNode方法出错", e);
/*     */       } finally {
/* 103 */         this.subNodesLock.writeLock().unlock();
/*     */       }
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static void loadDataSource(int itemType)
/*     */   {
/* 160 */     Node node = new Node(1);
/* 161 */     switch (itemType) {
/*     */     case 2: 
/* 163 */       node.ids = SItemEquipCfg.getAllSelf().keySet();
/* 164 */       break;
/*     */     case 5: 
/* 166 */       node.ids = SItemDrugInFightCfg.getAllSelf().keySet();
/* 167 */       break;
/*     */     case 7: 
/* 169 */       node.ids = SItemDrugOutFightCfg.getAllSelf().keySet();
/* 170 */       break;
/*     */     case 4: 
/* 172 */       node.ids = SPetSkillBookCfg.getAllSelf().keySet();
/* 173 */       break;
/*     */     case 3: case 6: default: 
/* 175 */       return;
/*     */     }
/* 177 */     cacheItemMap.put(Integer.valueOf(itemType), node);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static Set<Integer> getAndSetCacheItemSet(int itemType, List<AbsSiftCondition> siftConditions)
/*     */   {
/* 188 */     Set<Integer> ret = new HashSet();
/* 189 */     if (!cacheItemMap.containsKey(Integer.valueOf(itemType))) {
/* 190 */       loadDataSource(itemType);
/*     */     }
/* 192 */     Node resultNode = (Node)cacheItemMap.get(Integer.valueOf(itemType));
/* 193 */     if (resultNode == null) {
/* 194 */       return ret;
/*     */     }
/* 196 */     for (int i = 0; 
/* 197 */         i < siftConditions.size(); i++) {
/* 198 */       AbsSiftCondition siftCondition = (AbsSiftCondition)siftConditions.get(i);
/* 199 */       Node nextNode = resultNode.getNodeBySiftCondition(siftCondition);
/* 200 */       if (nextNode == null) break;
/* 201 */       resultNode = nextNode;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 206 */     if (i == siftConditions.size()) {
/* 207 */       ret.addAll(resultNode.ids);
/* 208 */       return ret;
/*     */     }
/* 211 */     for (; 
/* 211 */         i < siftConditions.size(); i++) {
/* 212 */       AbsSiftCondition siftCondition = (AbsSiftCondition)siftConditions.get(i);
/* 213 */       HashSet<Integer> siftIds = new HashSet(resultNode.ids);
/* 214 */       siftCondition.sift(siftIds);
/* 215 */       Node nextNode = new Node(resultNode.floor + 1);
/* 216 */       nextNode.ids = siftIds;
/* 217 */       resultNode.putNode(siftCondition, nextNode);
/* 218 */       resultNode = nextNode;
/*     */     }
/* 220 */     ret.addAll(resultNode.ids);
/* 221 */     return ret;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\sift\SiftCacheManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */