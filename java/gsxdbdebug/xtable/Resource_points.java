/*     */ package xtable;
/*     */ 
/*     */ import java.util.Map;
/*     */ import xbean.ResourcePoint;
/*     */ import xdb.TTable;
/*     */ import xdb.util.AutoKey;
/*     */ 
/*     */ public class Resource_points
/*     */ {
/*     */   public static AutoKey<Long> getAutoKey()
/*     */   {
/*  12 */     return _Tables_.getInstance().resource_points.getAutoKey();
/*     */   }
/*     */   
/*     */   public static AutoKey<Long> getAutoKey(int localid)
/*     */   {
/*  17 */     return _Tables_.getInstance().resource_points.getAutoKey(localid);
/*     */   }
/*     */   
/*     */   public static Long nextKey()
/*     */   {
/*  22 */     return (Long)getAutoKey().next();
/*     */   }
/*     */   
/*     */   public static Long nextKey(int localid)
/*     */   {
/*  27 */     return (Long)getAutoKey(localid).next();
/*     */   }
/*     */   
/*     */   public static Long insert(ResourcePoint value)
/*     */   {
/*  32 */     Long next = nextKey();
/*  33 */     insert(next, value);
/*  34 */     return next;
/*     */   }
/*     */   
/*     */   public static Long insertWithLocalid(int localid, ResourcePoint value)
/*     */   {
/*  39 */     Long next = nextKey(localid);
/*  40 */     insertWithLocalid(localid, next, value);
/*  41 */     return next;
/*     */   }
/*     */   
/*     */   public static ResourcePoint get(Long key)
/*     */   {
/*  46 */     return (ResourcePoint)_Tables_.getInstance().resource_points.get(key);
/*     */   }
/*     */   
/*     */   public static ResourcePoint get(Long key, ResourcePoint value)
/*     */   {
/*  51 */     return (ResourcePoint)_Tables_.getInstance().resource_points.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(Long key, ResourcePoint value)
/*     */   {
/*  56 */     _Tables_.getInstance().resource_points.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void insertWithLocalid(int localid, Long key, ResourcePoint value)
/*     */   {
/*  61 */     _Tables_.getInstance().resource_points.insertWithLocalid(localid, key, value);
/*     */   }
/*     */   
/*     */   public static void delete(Long key)
/*     */   {
/*  66 */     _Tables_.getInstance().resource_points.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(Long key, ResourcePoint value)
/*     */   {
/*  71 */     return _Tables_.getInstance().resource_points.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean addWithLocalid(int localid, Long key, ResourcePoint value)
/*     */   {
/*  76 */     return _Tables_.getInstance().resource_points.addWithLocalid(localid, key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(Long key)
/*     */   {
/*  81 */     return _Tables_.getInstance().resource_points.remove(key);
/*     */   }
/*     */   
/*     */   public static xdb.TTableCache<Long, ResourcePoint> getCache()
/*     */   {
/*  86 */     return _Tables_.getInstance().resource_points.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<Long, ResourcePoint> getTable()
/*     */   {
/*  91 */     return _Tables_.getInstance().resource_points;
/*     */   }
/*     */   
/*     */   public static ResourcePoint select(Long key)
/*     */   {
/*  96 */     (ResourcePoint)getTable().select(key, new xdb.TField()
/*     */     {
/*     */       public ResourcePoint get(ResourcePoint v)
/*     */       {
/* 100 */         return v.toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<Long, xbean.RoleResourcePointInfo> selectRole_resource_point_infos(Long key)
/*     */   {
/* 107 */     (Map)getTable().select(key, new xdb.TField()
/*     */     {
/*     */       public Map<Long, xbean.RoleResourcePointInfo> get(ResourcePoint v)
/*     */       {
/* 111 */         return v.getRole_resource_point_infosAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Resource_points.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */