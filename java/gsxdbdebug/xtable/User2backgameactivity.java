/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.BackGameActivityUserInfo;
/*    */ import xbean.BackGameActivityUserMap;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class User2backgameactivity
/*    */ {
/*    */   public static BackGameActivityUserMap get(String key)
/*    */   {
/* 12 */     return (BackGameActivityUserMap)_Tables_.getInstance().user2backgameactivity.get(key);
/*    */   }
/*    */   
/*    */   public static BackGameActivityUserMap get(String key, BackGameActivityUserMap value)
/*    */   {
/* 17 */     return (BackGameActivityUserMap)_Tables_.getInstance().user2backgameactivity.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(String key, BackGameActivityUserMap value)
/*    */   {
/* 22 */     _Tables_.getInstance().user2backgameactivity.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(String key)
/*    */   {
/* 27 */     _Tables_.getInstance().user2backgameactivity.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(String key, BackGameActivityUserMap value)
/*    */   {
/* 32 */     return _Tables_.getInstance().user2backgameactivity.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(String key)
/*    */   {
/* 37 */     return _Tables_.getInstance().user2backgameactivity.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<String, BackGameActivityUserMap> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().user2backgameactivity.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<String, BackGameActivityUserMap> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().user2backgameactivity;
/*    */   }
/*    */   
/*    */   public static BackGameActivityUserMap select(String key)
/*    */   {
/* 52 */     (BackGameActivityUserMap)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public BackGameActivityUserMap get(BackGameActivityUserMap v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, BackGameActivityUserInfo> selectActivityid2userinfo(String key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, BackGameActivityUserInfo> get(BackGameActivityUserMap v)
/*    */       {
/* 67 */         return v.getActivityid2userinfoAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\User2backgameactivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */