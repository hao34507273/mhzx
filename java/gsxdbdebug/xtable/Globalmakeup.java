/*    */ package xtable;
/*    */ 
/*    */ import xbean.GlobalMakeUpInfo;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ import xdb.TTableCache;
/*    */ 
/*    */ public class Globalmakeup
/*    */ {
/*    */   public static GlobalMakeUpInfo get(Long key)
/*    */   {
/* 12 */     return (GlobalMakeUpInfo)_Tables_.getInstance().globalmakeup.get(key);
/*    */   }
/*    */   
/*    */   public static GlobalMakeUpInfo get(Long key, GlobalMakeUpInfo value)
/*    */   {
/* 17 */     return (GlobalMakeUpInfo)_Tables_.getInstance().globalmakeup.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, GlobalMakeUpInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().globalmakeup.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().globalmakeup.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, GlobalMakeUpInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().globalmakeup.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().globalmakeup.remove(key);
/*    */   }
/*    */   
/*    */   public static TTableCache<Long, GlobalMakeUpInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().globalmakeup.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, GlobalMakeUpInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().globalmakeup;
/*    */   }
/*    */   
/*    */   public static GlobalMakeUpInfo select(Long key)
/*    */   {
/* 52 */     (GlobalMakeUpInfo)getTable().select(key, new TField()
/*    */     {
/*    */       public GlobalMakeUpInfo get(GlobalMakeUpInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectTurn(Long key)
/*    */   {
/* 63 */     (Integer)getTable().select(key, new TField()
/*    */     {
/*    */       public Integer get(GlobalMakeUpInfo v)
/*    */       {
/* 67 */         return Integer.valueOf(v.getTurn());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Boolean selectQuetioning(Long key)
/*    */   {
/* 74 */     (Boolean)getTable().select(key, new TField()
/*    */     {
/*    */       public Boolean get(GlobalMakeUpInfo v)
/*    */       {
/* 78 */         return Boolean.valueOf(v.getQuetioning());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectPreparesessionid(Long key)
/*    */   {
/* 85 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(GlobalMakeUpInfo v)
/*    */       {
/* 89 */         return Long.valueOf(v.getPreparesessionid());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Globalmakeup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */