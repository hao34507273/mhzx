/*    */ package xtable;
/*    */ 
/*    */ import xbean.GlobleKeJuInfo;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ import xdb.TTableCache;
/*    */ 
/*    */ public class Gloablekeju
/*    */ {
/*    */   public static GlobleKeJuInfo get(Long key)
/*    */   {
/* 12 */     return (GlobleKeJuInfo)_Tables_.getInstance().gloablekeju.get(key);
/*    */   }
/*    */   
/*    */   public static GlobleKeJuInfo get(Long key, GlobleKeJuInfo value)
/*    */   {
/* 17 */     return (GlobleKeJuInfo)_Tables_.getInstance().gloablekeju.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, GlobleKeJuInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().gloablekeju.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().gloablekeju.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, GlobleKeJuInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().gloablekeju.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().gloablekeju.remove(key);
/*    */   }
/*    */   
/*    */   public static TTableCache<Long, GlobleKeJuInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().gloablekeju.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, GlobleKeJuInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().gloablekeju;
/*    */   }
/*    */   
/*    */   public static GlobleKeJuInfo select(Long key)
/*    */   {
/* 52 */     (GlobleKeJuInfo)getTable().select(key, new TField()
/*    */     {
/*    */       public GlobleKeJuInfo get(GlobleKeJuInfo v)
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
/*    */       public Long get(GlobleKeJuInfo v)
/*    */       {
/* 67 */         return Long.valueOf(v.getWorldid());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Gloablekeju.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */