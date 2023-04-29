/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.RoleFabaoSysInfo;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2fabaosys
/*    */ {
/*    */   public static RoleFabaoSysInfo get(Long key)
/*    */   {
/* 12 */     return (RoleFabaoSysInfo)_Tables_.getInstance().role2fabaosys.get(key);
/*    */   }
/*    */   
/*    */   public static RoleFabaoSysInfo get(Long key, RoleFabaoSysInfo value)
/*    */   {
/* 17 */     return (RoleFabaoSysInfo)_Tables_.getInstance().role2fabaosys.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, RoleFabaoSysInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2fabaosys.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2fabaosys.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, RoleFabaoSysInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2fabaosys.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2fabaosys.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, RoleFabaoSysInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2fabaosys.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, RoleFabaoSysInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2fabaosys;
/*    */   }
/*    */   
/*    */   public static RoleFabaoSysInfo select(Long key)
/*    */   {
/* 52 */     (RoleFabaoSysInfo)getTable().select(key, new TField()
/*    */     {
/*    */       public RoleFabaoSysInfo get(RoleFabaoSysInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, xbean.Item> selectFabaomap(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new TField()
/*    */     {
/*    */       public Map<Integer, xbean.Item> get(RoleFabaoSysInfo v)
/*    */       {
/* 67 */         return v.getFabaomapAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, xbean.LongJing> selectLongjingmap(Long key)
/*    */   {
/* 74 */     (Map)getTable().select(key, new TField()
/*    */     {
/*    */       public Map<Integer, xbean.LongJing> get(RoleFabaoSysInfo v)
/*    */       {
/* 78 */         return v.getLongjingmapAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectDisfabaotype(Long key)
/*    */   {
/* 85 */     (Integer)getTable().select(key, new TField()
/*    */     {
/*    */       public Integer get(RoleFabaoSysInfo v)
/*    */       {
/* 89 */         return Integer.valueOf(v.getDisfabaotype());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectTransfercount(Long key)
/*    */   {
/* 96 */     (Integer)getTable().select(key, new TField()
/*    */     {
/*    */       public Integer get(RoleFabaoSysInfo v)
/*    */       {
/* :0 */         return Integer.valueOf(v.getTransfercount());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2fabaosys.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */