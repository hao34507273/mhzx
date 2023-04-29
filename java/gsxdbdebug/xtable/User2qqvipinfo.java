/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.QQVipInfo;
/*    */ import xbean.UserQQVipInfo;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class User2qqvipinfo
/*    */ {
/*    */   public static UserQQVipInfo get(String key)
/*    */   {
/* 12 */     return (UserQQVipInfo)_Tables_.getInstance().user2qqvipinfo.get(key);
/*    */   }
/*    */   
/*    */   public static UserQQVipInfo get(String key, UserQQVipInfo value)
/*    */   {
/* 17 */     return (UserQQVipInfo)_Tables_.getInstance().user2qqvipinfo.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(String key, UserQQVipInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().user2qqvipinfo.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(String key)
/*    */   {
/* 27 */     _Tables_.getInstance().user2qqvipinfo.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(String key, UserQQVipInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().user2qqvipinfo.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(String key)
/*    */   {
/* 37 */     return _Tables_.getInstance().user2qqvipinfo.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<String, UserQQVipInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().user2qqvipinfo.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<String, UserQQVipInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().user2qqvipinfo;
/*    */   }
/*    */   
/*    */   public static UserQQVipInfo select(String key)
/*    */   {
/* 52 */     (UserQQVipInfo)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public UserQQVipInfo get(UserQQVipInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, QQVipInfo> selectVipinfos(String key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, QQVipInfo> get(UserQQVipInfo v)
/*    */       {
/* 67 */         return v.getVipinfosAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\User2qqvipinfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */