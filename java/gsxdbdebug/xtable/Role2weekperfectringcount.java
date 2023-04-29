/*    */ package xtable;
/*    */ 
/*    */ import xbean.WeekPerfectRingCout;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ import xdb.TTableCache;
/*    */ 
/*    */ public class Role2weekperfectringcount
/*    */ {
/*    */   public static WeekPerfectRingCout get(Long key)
/*    */   {
/* 12 */     return (WeekPerfectRingCout)_Tables_.getInstance().role2weekperfectringcount.get(key);
/*    */   }
/*    */   
/*    */   public static WeekPerfectRingCout get(Long key, WeekPerfectRingCout value)
/*    */   {
/* 17 */     return (WeekPerfectRingCout)_Tables_.getInstance().role2weekperfectringcount.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, WeekPerfectRingCout value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2weekperfectringcount.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2weekperfectringcount.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, WeekPerfectRingCout value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2weekperfectringcount.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2weekperfectringcount.remove(key);
/*    */   }
/*    */   
/*    */   public static TTableCache<Long, WeekPerfectRingCout> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2weekperfectringcount.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, WeekPerfectRingCout> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2weekperfectringcount;
/*    */   }
/*    */   
/*    */   public static WeekPerfectRingCout select(Long key)
/*    */   {
/* 52 */     (WeekPerfectRingCout)getTable().select(key, new TField()
/*    */     {
/*    */       public WeekPerfectRingCout get(WeekPerfectRingCout v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectWeekperfectringcount(Long key)
/*    */   {
/* 63 */     (Integer)getTable().select(key, new TField()
/*    */     {
/*    */       public Integer get(WeekPerfectRingCout v)
/*    */       {
/* 67 */         return Integer.valueOf(v.getWeekperfectringcount());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectCleantime(Long key)
/*    */   {
/* 74 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(WeekPerfectRingCout v)
/*    */       {
/* 78 */         return Long.valueOf(v.getCleantime());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2weekperfectringcount.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */