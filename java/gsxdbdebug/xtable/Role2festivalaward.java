/*    */ package xtable;
/*    */ 
/*    */ import xbean.FestivalAward;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ import xdb.TTableCache;
/*    */ 
/*    */ public class Role2festivalaward
/*    */ {
/*    */   public static FestivalAward get(Long key)
/*    */   {
/* 12 */     return (FestivalAward)_Tables_.getInstance().role2festivalaward.get(key);
/*    */   }
/*    */   
/*    */   public static FestivalAward get(Long key, FestivalAward value)
/*    */   {
/* 17 */     return (FestivalAward)_Tables_.getInstance().role2festivalaward.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, FestivalAward value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2festivalaward.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2festivalaward.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, FestivalAward value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2festivalaward.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2festivalaward.remove(key);
/*    */   }
/*    */   
/*    */   public static TTableCache<Long, FestivalAward> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2festivalaward.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, FestivalAward> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2festivalaward;
/*    */   }
/*    */   
/*    */   public static FestivalAward select(Long key)
/*    */   {
/* 52 */     (FestivalAward)getTable().select(key, new TField()
/*    */     {
/*    */       public FestivalAward get(FestivalAward v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectLastestawardedcfgid(Long key)
/*    */   {
/* 63 */     (Integer)getTable().select(key, new TField()
/*    */     {
/*    */       public Integer get(FestivalAward v)
/*    */       {
/* 67 */         return Integer.valueOf(v.getLastestawardedcfgid());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectLastestmailawardcfgid(Long key)
/*    */   {
/* 74 */     (Integer)getTable().select(key, new TField()
/*    */     {
/*    */       public Integer get(FestivalAward v)
/*    */       {
/* 78 */         return Integer.valueOf(v.getLastestmailawardcfgid());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2festivalaward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */