/*    */ package xtable;
/*    */ 
/*    */ import java.util.Set;
/*    */ import xbean.ArenaTmp;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Arena_tmp
/*    */ {
/*    */   public static ArenaTmp get(Long key)
/*    */   {
/* 12 */     return (ArenaTmp)_Tables_.getInstance().arena_tmp.get(key);
/*    */   }
/*    */   
/*    */   public static ArenaTmp get(Long key, ArenaTmp value)
/*    */   {
/* 17 */     return (ArenaTmp)_Tables_.getInstance().arena_tmp.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, ArenaTmp value)
/*    */   {
/* 22 */     _Tables_.getInstance().arena_tmp.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().arena_tmp.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, ArenaTmp value)
/*    */   {
/* 32 */     return _Tables_.getInstance().arena_tmp.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().arena_tmp.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, ArenaTmp> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().arena_tmp.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, ArenaTmp> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().arena_tmp;
/*    */   }
/*    */   
/*    */   public static ArenaTmp select(Long key)
/*    */   {
/* 52 */     (ArenaTmp)getTable().select(key, new TField()
/*    */     {
/*    */       public ArenaTmp get(ArenaTmp v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectWorld(Long key)
/*    */   {
/* 63 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(ArenaTmp v)
/*    */       {
/* 67 */         return Long.valueOf(v.getWorld());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Set<Long> selectFights(Long key)
/*    */   {
/* 74 */     (Set)getTable().select(key, new TField()
/*    */     {
/*    */       public Set<Long> get(ArenaTmp v)
/*    */       {
/* 78 */         return v.getFightsAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Arena_tmp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */