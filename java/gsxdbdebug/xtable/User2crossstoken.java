/*    */ package xtable;
/*    */ 
/*    */ import xbean.CrossToken;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ import xdb.TTableCache;
/*    */ 
/*    */ public class User2crossstoken
/*    */ {
/*    */   public static CrossToken get(String key)
/*    */   {
/* 12 */     return (CrossToken)_Tables_.getInstance().user2crossstoken.get(key);
/*    */   }
/*    */   
/*    */   public static CrossToken get(String key, CrossToken value)
/*    */   {
/* 17 */     return (CrossToken)_Tables_.getInstance().user2crossstoken.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(String key, CrossToken value)
/*    */   {
/* 22 */     _Tables_.getInstance().user2crossstoken.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(String key)
/*    */   {
/* 27 */     _Tables_.getInstance().user2crossstoken.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(String key, CrossToken value)
/*    */   {
/* 32 */     return _Tables_.getInstance().user2crossstoken.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(String key)
/*    */   {
/* 37 */     return _Tables_.getInstance().user2crossstoken.remove(key);
/*    */   }
/*    */   
/*    */   public static TTableCache<String, CrossToken> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().user2crossstoken.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<String, CrossToken> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().user2crossstoken;
/*    */   }
/*    */   
/*    */   public static CrossToken select(String key)
/*    */   {
/* 52 */     (CrossToken)getTable().select(key, new TField()
/*    */     {
/*    */       public CrossToken get(CrossToken v)
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
/*    */       public Integer get(CrossToken v)
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
/*    */       public byte[] get(CrossToken v)
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
/*    */       public Long get(CrossToken v)
/*    */       {
/* 89 */         return Long.valueOf(v.getRoleid());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\User2crossstoken.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */