/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import xbean.RelatedBoss;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Relatedboss
/*    */ {
/*    */   public static RelatedBoss get(Long key)
/*    */   {
/* 12 */     return (RelatedBoss)_Tables_.getInstance().relatedboss.get(key);
/*    */   }
/*    */   
/*    */   public static RelatedBoss get(Long key, RelatedBoss value)
/*    */   {
/* 17 */     return (RelatedBoss)_Tables_.getInstance().relatedboss.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, RelatedBoss value)
/*    */   {
/* 22 */     _Tables_.getInstance().relatedboss.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().relatedboss.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, RelatedBoss value)
/*    */   {
/* 32 */     return _Tables_.getInstance().relatedboss.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().relatedboss.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, RelatedBoss> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().relatedboss.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, RelatedBoss> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().relatedboss;
/*    */   }
/*    */   
/*    */   public static RelatedBoss select(Long key)
/*    */   {
/* 52 */     (RelatedBoss)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public RelatedBoss get(RelatedBoss v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, xbean.BossFights> selectBoss_fights(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, xbean.BossFights> get(RelatedBoss v)
/*    */       {
/* 67 */         return v.getBoss_fightsAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Set<Integer> selectRelated_monsters(Long key)
/*    */   {
/* 74 */     (Set)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Set<Integer> get(RelatedBoss v)
/*    */       {
/* 78 */         return v.getRelated_monstersAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Relatedboss.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */