/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.FriendTotalInfo;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2friend
/*    */ {
/*    */   public static FriendTotalInfo get(Long key)
/*    */   {
/* 12 */     return (FriendTotalInfo)_Tables_.getInstance().role2friend.get(key);
/*    */   }
/*    */   
/*    */   public static FriendTotalInfo get(Long key, FriendTotalInfo value)
/*    */   {
/* 17 */     return (FriendTotalInfo)_Tables_.getInstance().role2friend.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, FriendTotalInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2friend.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2friend.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, FriendTotalInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2friend.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2friend.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, FriendTotalInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2friend.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, FriendTotalInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2friend;
/*    */   }
/*    */   
/*    */   public static FriendTotalInfo select(Long key)
/*    */   {
/* 52 */     (FriendTotalInfo)getTable().select(key, new TField()
/*    */     {
/*    */       public FriendTotalInfo get(FriendTotalInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Long, xbean.FriendInfo> selectFriendinfomap(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new TField()
/*    */     {
/*    */       public Map<Long, xbean.FriendInfo> get(FriendTotalInfo v)
/*    */       {
/* 67 */         return v.getFriendinfomapAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectCleardatatime(Long key)
/*    */   {
/* 74 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(FriendTotalInfo v)
/*    */       {
/* 78 */         return Long.valueOf(v.getCleardatatime());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2friend.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */