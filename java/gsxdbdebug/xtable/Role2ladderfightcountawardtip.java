/*    */ package xtable;
/*    */ 
/*    */ import xbean.FightCountAwardTip;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ import xdb.TTableCache;
/*    */ 
/*    */ public class Role2ladderfightcountawardtip
/*    */ {
/*    */   public static FightCountAwardTip get(Long key)
/*    */   {
/* 12 */     return (FightCountAwardTip)_Tables_.getInstance().role2ladderfightcountawardtip.get(key);
/*    */   }
/*    */   
/*    */   public static FightCountAwardTip get(Long key, FightCountAwardTip value)
/*    */   {
/* 17 */     return (FightCountAwardTip)_Tables_.getInstance().role2ladderfightcountawardtip.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, FightCountAwardTip value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2ladderfightcountawardtip.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2ladderfightcountawardtip.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, FightCountAwardTip value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2ladderfightcountawardtip.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2ladderfightcountawardtip.remove(key);
/*    */   }
/*    */   
/*    */   public static TTableCache<Long, FightCountAwardTip> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2ladderfightcountawardtip.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, FightCountAwardTip> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2ladderfightcountawardtip;
/*    */   }
/*    */   
/*    */   public static Integer selectCount(Long key)
/*    */   {
/* 52 */     (Integer)getTable().select(key, new TField()
/*    */     {
/*    */       public Integer get(FightCountAwardTip v)
/*    */       {
/* 56 */         return Integer.valueOf(v.getCount());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2ladderfightcountawardtip.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */