/*    */ package xtable;
/*    */ 
/*    */ import xbean.MassWedding;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ import xdb.TTableCache;
/*    */ 
/*    */ public class Masswedding
/*    */ {
/*    */   public static MassWedding get(Long key)
/*    */   {
/* 12 */     return (MassWedding)_Tables_.getInstance().masswedding.get(key);
/*    */   }
/*    */   
/*    */   public static MassWedding get(Long key, MassWedding value)
/*    */   {
/* 17 */     return (MassWedding)_Tables_.getInstance().masswedding.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, MassWedding value)
/*    */   {
/* 22 */     _Tables_.getInstance().masswedding.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().masswedding.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, MassWedding value)
/*    */   {
/* 32 */     return _Tables_.getInstance().masswedding.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().masswedding.remove(key);
/*    */   }
/*    */   
/*    */   public static TTableCache<Long, MassWedding> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().masswedding.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, MassWedding> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().masswedding;
/*    */   }
/*    */   
/*    */   public static MassWedding select(Long key)
/*    */   {
/* 52 */     (MassWedding)getTable().select(key, new TField()
/*    */     {
/*    */       public MassWedding get(MassWedding v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectWorldid(Long key)
/*    */   {
/* 63 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(MassWedding v)
/*    */       {
/* 67 */         return Long.valueOf(v.getWorldid());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectEndearlier(Long key)
/*    */   {
/* 74 */     (Integer)getTable().select(key, new TField()
/*    */     {
/*    */       public Integer get(MassWedding v)
/*    */       {
/* 78 */         return Integer.valueOf(v.getEndearlier());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectStage(Long key)
/*    */   {
/* 85 */     (Integer)getTable().select(key, new TField()
/*    */     {
/*    */       public Integer get(MassWedding v)
/*    */       {
/* 89 */         return Integer.valueOf(v.getStage());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Masswedding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */