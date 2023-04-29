/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.WorldCounterInfo;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Worldcounter
/*    */ {
/*    */   public static WorldCounterInfo get(Long key)
/*    */   {
/* 12 */     return (WorldCounterInfo)_Tables_.getInstance().worldcounter.get(key);
/*    */   }
/*    */   
/*    */   public static WorldCounterInfo get(Long key, WorldCounterInfo value)
/*    */   {
/* 17 */     return (WorldCounterInfo)_Tables_.getInstance().worldcounter.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, WorldCounterInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().worldcounter.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().worldcounter.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, WorldCounterInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().worldcounter.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().worldcounter.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, WorldCounterInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().worldcounter.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, WorldCounterInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().worldcounter;
/*    */   }
/*    */   
/*    */   public static WorldCounterInfo select(Long key)
/*    */   {
/* 52 */     (WorldCounterInfo)getTable().select(key, new TField()
/*    */     {
/*    */       public WorldCounterInfo get(WorldCounterInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, Long> selectIndex2times(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new TField()
/*    */     {
/*    */       public Map<Integer, Long> get(WorldCounterInfo v)
/*    */       {
/* 67 */         return v.getIndex2timesAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Worldcounter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */