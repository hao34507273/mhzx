/*    */ package xtable;
/*    */ 
/*    */ import java.util.Set;
/*    */ import xbean.WuShiAwardInfo;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2wushiawardinfo
/*    */ {
/*    */   public static WuShiAwardInfo get(Long key)
/*    */   {
/* 12 */     return (WuShiAwardInfo)_Tables_.getInstance().role2wushiawardinfo.get(key);
/*    */   }
/*    */   
/*    */   public static WuShiAwardInfo get(Long key, WuShiAwardInfo value)
/*    */   {
/* 17 */     return (WuShiAwardInfo)_Tables_.getInstance().role2wushiawardinfo.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, WuShiAwardInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2wushiawardinfo.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2wushiawardinfo.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, WuShiAwardInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2wushiawardinfo.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2wushiawardinfo.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, WuShiAwardInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2wushiawardinfo.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, WuShiAwardInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2wushiawardinfo;
/*    */   }
/*    */   
/*    */   public static WuShiAwardInfo select(Long key)
/*    */   {
/* 52 */     (WuShiAwardInfo)getTable().select(key, new TField()
/*    */     {
/*    */       public WuShiAwardInfo get(WuShiAwardInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Set<Integer> selectWushiawardcfgids(Long key)
/*    */   {
/* 63 */     (Set)getTable().select(key, new TField()
/*    */     {
/*    */       public Set<Integer> get(WuShiAwardInfo v)
/*    */       {
/* 67 */         return v.getWushiawardcfgidsAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2wushiawardinfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */