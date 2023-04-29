/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.WuShiInfo;
/*    */ import xbean.WuShiInfoMap;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2wushiinfo
/*    */ {
/*    */   public static WuShiInfoMap get(Long key)
/*    */   {
/* 12 */     return (WuShiInfoMap)_Tables_.getInstance().role2wushiinfo.get(key);
/*    */   }
/*    */   
/*    */   public static WuShiInfoMap get(Long key, WuShiInfoMap value)
/*    */   {
/* 17 */     return (WuShiInfoMap)_Tables_.getInstance().role2wushiinfo.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, WuShiInfoMap value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2wushiinfo.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2wushiinfo.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, WuShiInfoMap value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2wushiinfo.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2wushiinfo.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, WuShiInfoMap> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2wushiinfo.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, WuShiInfoMap> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2wushiinfo;
/*    */   }
/*    */   
/*    */   public static WuShiInfoMap select(Long key)
/*    */   {
/* 52 */     (WuShiInfoMap)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public WuShiInfoMap get(WuShiInfoMap v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, WuShiInfo> selectWushicfgid2wushiinfo(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, WuShiInfo> get(WuShiInfoMap v)
/*    */       {
/* 67 */         return v.getWushicfgid2wushiinfoAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectOnwushicfgid(Long key)
/*    */   {
/* 74 */     (Integer)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Integer get(WuShiInfoMap v)
/*    */       {
/* 78 */         return Integer.valueOf(v.getOnwushicfgid());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2wushiinfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */