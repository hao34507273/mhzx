/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import xbean.GangGlobal;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Gangglobal
/*    */ {
/*    */   public static GangGlobal get(Long key)
/*    */   {
/* 12 */     return (GangGlobal)_Tables_.getInstance().gangglobal.get(key);
/*    */   }
/*    */   
/*    */   public static GangGlobal get(Long key, GangGlobal value)
/*    */   {
/* 17 */     return (GangGlobal)_Tables_.getInstance().gangglobal.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, GangGlobal value)
/*    */   {
/* 22 */     _Tables_.getInstance().gangglobal.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().gangglobal.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, GangGlobal value)
/*    */   {
/* 32 */     return _Tables_.getInstance().gangglobal.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().gangglobal.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, GangGlobal> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().gangglobal.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, GangGlobal> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().gangglobal;
/*    */   }
/*    */   
/*    */   public static GangGlobal select(Long key)
/*    */   {
/* 52 */     (GangGlobal)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public GangGlobal get(GangGlobal v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Set<Long> selectAllgangids(Long key)
/*    */   {
/* 63 */     (Set)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Set<Long> get(GangGlobal v)
/*    */       {
/* 67 */         return v.getAllgangidsAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<xbean.CombiningGangsKey, xbean.CombineGangsInfo> selectCombine(Long key)
/*    */   {
/* 74 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<xbean.CombiningGangsKey, xbean.CombineGangsInfo> get(GangGlobal v)
/*    */       {
/* 78 */         return v.getCombineAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectNextdisplayid(Long key)
/*    */   {
/* 85 */     (Long)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Long get(GangGlobal v)
/*    */       {
/* 89 */         return Long.valueOf(v.getNextdisplayid());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Gangglobal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */