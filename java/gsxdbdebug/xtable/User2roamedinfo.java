/*    */ package xtable;
/*    */ 
/*    */ import xbean.UserRoamedInfo;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ import xdb.TTableCache;
/*    */ 
/*    */ public class User2roamedinfo
/*    */ {
/*    */   public static UserRoamedInfo get(String key)
/*    */   {
/* 12 */     return (UserRoamedInfo)_Tables_.getInstance().user2roamedinfo.get(key);
/*    */   }
/*    */   
/*    */   public static UserRoamedInfo get(String key, UserRoamedInfo value)
/*    */   {
/* 17 */     return (UserRoamedInfo)_Tables_.getInstance().user2roamedinfo.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(String key, UserRoamedInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().user2roamedinfo.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(String key)
/*    */   {
/* 27 */     _Tables_.getInstance().user2roamedinfo.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(String key, UserRoamedInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().user2roamedinfo.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(String key)
/*    */   {
/* 37 */     return _Tables_.getInstance().user2roamedinfo.remove(key);
/*    */   }
/*    */   
/*    */   public static TTableCache<String, UserRoamedInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().user2roamedinfo.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<String, UserRoamedInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().user2roamedinfo;
/*    */   }
/*    */   
/*    */   public static UserRoamedInfo select(String key)
/*    */   {
/* 52 */     (UserRoamedInfo)getTable().select(key, new TField()
/*    */     {
/*    */       public UserRoamedInfo get(UserRoamedInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectInstanceid(String key)
/*    */   {
/* 63 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(UserRoamedInfo v)
/*    */       {
/* 67 */         return Long.valueOf(v.getInstanceid());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectRoam_type(String key)
/*    */   {
/* 74 */     (Integer)getTable().select(key, new TField()
/*    */     {
/*    */       public Integer get(UserRoamedInfo v)
/*    */       {
/* 78 */         return Integer.valueOf(v.getRoam_type());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\User2roamedinfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */