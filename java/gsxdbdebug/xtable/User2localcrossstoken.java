/*    */ package xtable;
/*    */ 
/*    */ import xbean.LocalCrossToken;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ import xdb.TTableCache;
/*    */ 
/*    */ public class User2localcrossstoken
/*    */ {
/*    */   public static LocalCrossToken get(String key)
/*    */   {
/* 12 */     return (LocalCrossToken)_Tables_.getInstance().user2localcrossstoken.get(key);
/*    */   }
/*    */   
/*    */   public static LocalCrossToken get(String key, LocalCrossToken value)
/*    */   {
/* 17 */     return (LocalCrossToken)_Tables_.getInstance().user2localcrossstoken.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(String key, LocalCrossToken value)
/*    */   {
/* 22 */     _Tables_.getInstance().user2localcrossstoken.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(String key)
/*    */   {
/* 27 */     _Tables_.getInstance().user2localcrossstoken.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(String key, LocalCrossToken value)
/*    */   {
/* 32 */     return _Tables_.getInstance().user2localcrossstoken.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(String key)
/*    */   {
/* 37 */     return _Tables_.getInstance().user2localcrossstoken.remove(key);
/*    */   }
/*    */   
/*    */   public static TTableCache<String, LocalCrossToken> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().user2localcrossstoken.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<String, LocalCrossToken> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().user2localcrossstoken;
/*    */   }
/*    */   
/*    */   public static LocalCrossToken select(String key)
/*    */   {
/* 52 */     (LocalCrossToken)getTable().select(key, new TField()
/*    */     {
/*    */       public LocalCrossToken get(LocalCrossToken v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectZoneid(String key)
/*    */   {
/* 63 */     (Integer)getTable().select(key, new TField()
/*    */     {
/*    */       public Integer get(LocalCrossToken v)
/*    */       {
/* 67 */         return Integer.valueOf(v.getZoneid());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static byte[] selectToken(String key)
/*    */   {
/* 74 */     (byte[])getTable().select(key, new TField()
/*    */     {
/*    */       public byte[] get(LocalCrossToken v)
/*    */       {
/* 78 */         return v.getTokenCopy();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectRoleid(String key)
/*    */   {
/* 85 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(LocalCrossToken v)
/*    */       {
/* 89 */         return Long.valueOf(v.getRoleid());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\User2localcrossstoken.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */