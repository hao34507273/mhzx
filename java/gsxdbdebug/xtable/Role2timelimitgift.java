/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.Giftid2count;
/*    */ import xbean.TimeLimitGift;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2timelimitgift
/*    */ {
/*    */   public static TimeLimitGift get(Long key)
/*    */   {
/* 12 */     return (TimeLimitGift)_Tables_.getInstance().role2timelimitgift.get(key);
/*    */   }
/*    */   
/*    */   public static TimeLimitGift get(Long key, TimeLimitGift value)
/*    */   {
/* 17 */     return (TimeLimitGift)_Tables_.getInstance().role2timelimitgift.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, TimeLimitGift value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2timelimitgift.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2timelimitgift.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, TimeLimitGift value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2timelimitgift.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2timelimitgift.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, TimeLimitGift> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2timelimitgift.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, TimeLimitGift> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2timelimitgift;
/*    */   }
/*    */   
/*    */   public static TimeLimitGift select(Long key)
/*    */   {
/* 52 */     (TimeLimitGift)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public TimeLimitGift get(TimeLimitGift v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, Giftid2count> selectActivityid2giftids(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, Giftid2count> get(TimeLimitGift v)
/*    */       {
/* 67 */         return v.getActivityid2giftidsAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Boolean selectIssendmail(Long key)
/*    */   {
/* 74 */     (Boolean)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Boolean get(TimeLimitGift v)
/*    */       {
/* 78 */         return Boolean.valueOf(v.getIssendmail());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2timelimitgift.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */