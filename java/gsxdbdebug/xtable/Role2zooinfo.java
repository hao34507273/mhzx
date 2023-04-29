/*    */ package xtable;
/*    */ 
/*    */ import java.util.List;
/*    */ import xbean.ZooInfo;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2zooinfo
/*    */ {
/*    */   public static ZooInfo get(Long key)
/*    */   {
/* 12 */     return (ZooInfo)_Tables_.getInstance().role2zooinfo.get(key);
/*    */   }
/*    */   
/*    */   public static ZooInfo get(Long key, ZooInfo value)
/*    */   {
/* 17 */     return (ZooInfo)_Tables_.getInstance().role2zooinfo.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, ZooInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2zooinfo.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2zooinfo.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, ZooInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2zooinfo.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2zooinfo.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, ZooInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2zooinfo.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, ZooInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2zooinfo;
/*    */   }
/*    */   
/*    */   public static ZooInfo select(Long key)
/*    */   {
/* 52 */     (ZooInfo)getTable().select(key, new TField()
/*    */     {
/*    */       public ZooInfo get(ZooInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static List<Long> selectAnimals(Long key)
/*    */   {
/* 63 */     (List)getTable().select(key, new TField()
/*    */     {
/*    */       public List<Long> get(ZooInfo v)
/*    */       {
/* 67 */         return v.getAnimalsAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectClean_check_time(Long key)
/*    */   {
/* 74 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(ZooInfo v)
/*    */       {
/* 78 */         return Long.valueOf(v.getClean_check_time());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2zooinfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */