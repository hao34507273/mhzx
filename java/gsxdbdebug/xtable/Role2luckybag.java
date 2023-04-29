/*    */ package xtable;
/*    */ 
/*    */ import xbean.LuckyBagInfo;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ import xdb.TTableCache;
/*    */ 
/*    */ public class Role2luckybag
/*    */ {
/*    */   public static LuckyBagInfo get(Long key)
/*    */   {
/* 12 */     return (LuckyBagInfo)_Tables_.getInstance().role2luckybag.get(key);
/*    */   }
/*    */   
/*    */   public static LuckyBagInfo get(Long key, LuckyBagInfo value)
/*    */   {
/* 17 */     return (LuckyBagInfo)_Tables_.getInstance().role2luckybag.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, LuckyBagInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2luckybag.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2luckybag.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, LuckyBagInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2luckybag.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2luckybag.remove(key);
/*    */   }
/*    */   
/*    */   public static TTableCache<Long, LuckyBagInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2luckybag.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, LuckyBagInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2luckybag;
/*    */   }
/*    */   
/*    */   public static LuckyBagInfo select(Long key)
/*    */   {
/* 52 */     (LuckyBagInfo)getTable().select(key, new TField()
/*    */     {
/*    */       public LuckyBagInfo get(LuckyBagInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectScore(Long key)
/*    */   {
/* 63 */     (Integer)getTable().select(key, new TField()
/*    */     {
/*    */       public Integer get(LuckyBagInfo v)
/*    */       {
/* 67 */         return Integer.valueOf(v.getScore());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2luckybag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */