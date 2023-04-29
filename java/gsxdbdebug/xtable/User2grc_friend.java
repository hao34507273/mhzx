/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.RoleGrcFriendInfo;
/*    */ import xbean.UserGrcFriendInfo;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class User2grc_friend
/*    */ {
/*    */   public static UserGrcFriendInfo get(String key)
/*    */   {
/* 12 */     return (UserGrcFriendInfo)_Tables_.getInstance().user2grc_friend.get(key);
/*    */   }
/*    */   
/*    */   public static UserGrcFriendInfo get(String key, UserGrcFriendInfo value)
/*    */   {
/* 17 */     return (UserGrcFriendInfo)_Tables_.getInstance().user2grc_friend.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(String key, UserGrcFriendInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().user2grc_friend.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(String key)
/*    */   {
/* 27 */     _Tables_.getInstance().user2grc_friend.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(String key, UserGrcFriendInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().user2grc_friend.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(String key)
/*    */   {
/* 37 */     return _Tables_.getInstance().user2grc_friend.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<String, UserGrcFriendInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().user2grc_friend.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<String, UserGrcFriendInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().user2grc_friend;
/*    */   }
/*    */   
/*    */   public static UserGrcFriendInfo select(String key)
/*    */   {
/* 52 */     (UserGrcFriendInfo)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public UserGrcFriendInfo get(UserGrcFriendInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, RoleGrcFriendInfo> selectZone2ids(String key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, RoleGrcFriendInfo> get(UserGrcFriendInfo v)
/*    */       {
/* 67 */         return v.getZone2idsAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\User2grc_friend.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */