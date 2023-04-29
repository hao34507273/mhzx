/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.InstanceBean;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2instance
/*    */ {
/*    */   public static InstanceBean get(Long key)
/*    */   {
/* 12 */     return (InstanceBean)_Tables_.getInstance().role2instance.get(key);
/*    */   }
/*    */   
/*    */   public static InstanceBean get(Long key, InstanceBean value)
/*    */   {
/* 17 */     return (InstanceBean)_Tables_.getInstance().role2instance.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, InstanceBean value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2instance.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2instance.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, InstanceBean value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2instance.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2instance.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, InstanceBean> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2instance.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, InstanceBean> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2instance;
/*    */   }
/*    */   
/*    */   public static InstanceBean select(Long key)
/*    */   {
/* 52 */     (InstanceBean)getTable().select(key, new TField()
/*    */     {
/*    */       public InstanceBean get(InstanceBean v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, xbean.SingleInstance> selectSingleinstancemap(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new TField()
/*    */     {
/*    */       public Map<Integer, xbean.SingleInstance> get(InstanceBean v)
/*    */       {
/* 67 */         return v.getSingleinstancemapAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectSinglefailtime(Long key)
/*    */   {
/* 74 */     (Integer)getTable().select(key, new TField()
/*    */     {
/*    */       public Integer get(InstanceBean v)
/*    */       {
/* 78 */         return Integer.valueOf(v.getSinglefailtime());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, xbean.TeamInstance> selectTeaminstancemap(Long key)
/*    */   {
/* 85 */     (Map)getTable().select(key, new TField()
/*    */     {
/*    */       public Map<Integer, xbean.TeamInstance> get(InstanceBean v)
/*    */       {
/* 89 */         return v.getTeaminstancemapAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2instance.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */