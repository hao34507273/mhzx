/*    */ package xtable;
/*    */ 
/*    */ import java.util.List;
/*    */ import xbean.OnlineAward;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2onlineaward
/*    */ {
/*    */   public static OnlineAward get(Long key)
/*    */   {
/* 12 */     return (OnlineAward)_Tables_.getInstance().role2onlineaward.get(key);
/*    */   }
/*    */   
/*    */   public static OnlineAward get(Long key, OnlineAward value)
/*    */   {
/* 17 */     return (OnlineAward)_Tables_.getInstance().role2onlineaward.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, OnlineAward value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2onlineaward.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2onlineaward.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, OnlineAward value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2onlineaward.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2onlineaward.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, OnlineAward> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2onlineaward.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, OnlineAward> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2onlineaward;
/*    */   }
/*    */   
/*    */   public static OnlineAward select(Long key)
/*    */   {
/* 52 */     (OnlineAward)getTable().select(key, new TField()
/*    */     {
/*    */       public OnlineAward get(OnlineAward v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectLogintime(Long key)
/*    */   {
/* 63 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(OnlineAward v)
/*    */       {
/* 67 */         return Long.valueOf(v.getLogintime());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectOnlinetime(Long key)
/*    */   {
/* 74 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(OnlineAward v)
/*    */       {
/* 78 */         return Long.valueOf(v.getOnlinetime());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static List<Integer> selectOnlineawardlist(Long key)
/*    */   {
/* 85 */     (List)getTable().select(key, new TField()
/*    */     {
/*    */       public List<Integer> get(OnlineAward v)
/*    */       {
/* 89 */         return v.getOnlineawardlistAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2onlineaward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */