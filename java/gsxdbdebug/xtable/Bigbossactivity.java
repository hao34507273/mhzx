/*    */ package xtable;
/*    */ 
/*    */ import xbean.BigBossActivity;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ import xdb.TTableCache;
/*    */ 
/*    */ public class Bigbossactivity
/*    */ {
/*    */   public static BigBossActivity get(Long key)
/*    */   {
/* 12 */     return (BigBossActivity)_Tables_.getInstance().bigbossactivity.get(key);
/*    */   }
/*    */   
/*    */   public static BigBossActivity get(Long key, BigBossActivity value)
/*    */   {
/* 17 */     return (BigBossActivity)_Tables_.getInstance().bigbossactivity.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, BigBossActivity value)
/*    */   {
/* 22 */     _Tables_.getInstance().bigbossactivity.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().bigbossactivity.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, BigBossActivity value)
/*    */   {
/* 32 */     return _Tables_.getInstance().bigbossactivity.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().bigbossactivity.remove(key);
/*    */   }
/*    */   
/*    */   public static TTableCache<Long, BigBossActivity> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().bigbossactivity.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, BigBossActivity> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().bigbossactivity;
/*    */   }
/*    */   
/*    */   public static BigBossActivity select(Long key)
/*    */   {
/* 52 */     (BigBossActivity)getTable().select(key, new TField()
/*    */     {
/*    */       public BigBossActivity get(BigBossActivity v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectStarttime(Long key)
/*    */   {
/* 63 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(BigBossActivity v)
/*    */       {
/* 67 */         return Long.valueOf(v.getStarttime());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectEndtime(Long key)
/*    */   {
/* 74 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(BigBossActivity v)
/*    */       {
/* 78 */         return Long.valueOf(v.getEndtime());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectMonsterid(Long key)
/*    */   {
/* 85 */     (Integer)getTable().select(key, new TField()
/*    */     {
/*    */       public Integer get(BigBossActivity v)
/*    */       {
/* 89 */         return Integer.valueOf(v.getMonsterid());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectReserved(Long key)
/*    */   {
/* 96 */     (Integer)getTable().select(key, new TField()
/*    */     {
/*    */       public Integer get(BigBossActivity v)
/*    */       {
/* :0 */         return Integer.valueOf(v.getReserved());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Bigbossactivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */