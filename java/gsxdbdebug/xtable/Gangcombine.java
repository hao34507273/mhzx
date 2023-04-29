/*    */ package xtable;
/*    */ 
/*    */ import java.util.Set;
/*    */ import xbean.GangCombine;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Gangcombine
/*    */ {
/*    */   public static GangCombine get(Long key)
/*    */   {
/* 12 */     return (GangCombine)_Tables_.getInstance().gangcombine.get(key);
/*    */   }
/*    */   
/*    */   public static GangCombine get(Long key, GangCombine value)
/*    */   {
/* 17 */     return (GangCombine)_Tables_.getInstance().gangcombine.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, GangCombine value)
/*    */   {
/* 22 */     _Tables_.getInstance().gangcombine.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().gangcombine.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, GangCombine value)
/*    */   {
/* 32 */     return _Tables_.getInstance().gangcombine.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().gangcombine.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, GangCombine> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().gangcombine.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, GangCombine> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().gangcombine;
/*    */   }
/*    */   
/*    */   public static GangCombine select(Long key)
/*    */   {
/* 52 */     (GangCombine)getTable().select(key, new TField()
/*    */     {
/*    */       public GangCombine get(GangCombine v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectGangid(Long key)
/*    */   {
/* 63 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(GangCombine v)
/*    */       {
/* 67 */         return Long.valueOf(v.getGangid());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Set<Long> selectApplicants(Long key)
/*    */   {
/* 74 */     (Set)getTable().select(key, new TField()
/*    */     {
/*    */       public Set<Long> get(GangCombine v)
/*    */       {
/* 78 */         return v.getApplicantsAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Gangcombine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */