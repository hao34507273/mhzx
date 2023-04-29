/*     */ package xtable;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import xbean.MultiRoleAwardCache;
/*     */ import xdb.TTable;
/*     */ 
/*     */ public class Multiroleaward
/*     */ {
/*     */   public static xdb.util.AutoKey<Long> getAutoKey()
/*     */   {
/*  12 */     return _Tables_.getInstance().multiroleaward.getAutoKey();
/*     */   }
/*     */   
/*     */   public static xdb.util.AutoKey<Long> getAutoKey(int localid)
/*     */   {
/*  17 */     return _Tables_.getInstance().multiroleaward.getAutoKey(localid);
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
/*     */   public static Long insert(MultiRoleAwardCache value)
/*     */   {
/*  32 */     Long next = nextKey();
/*  33 */     insert(next, value);
/*  34 */     return next;
/*     */   }
/*     */   
/*     */   public static Long insertWithLocalid(int localid, MultiRoleAwardCache value)
/*     */   {
/*  39 */     Long next = nextKey(localid);
/*  40 */     insertWithLocalid(localid, next, value);
/*  41 */     return next;
/*     */   }
/*     */   
/*     */   public static MultiRoleAwardCache get(Long key)
/*     */   {
/*  46 */     return (MultiRoleAwardCache)_Tables_.getInstance().multiroleaward.get(key);
/*     */   }
/*     */   
/*     */   public static MultiRoleAwardCache get(Long key, MultiRoleAwardCache value)
/*     */   {
/*  51 */     return (MultiRoleAwardCache)_Tables_.getInstance().multiroleaward.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(Long key, MultiRoleAwardCache value)
/*     */   {
/*  56 */     _Tables_.getInstance().multiroleaward.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void insertWithLocalid(int localid, Long key, MultiRoleAwardCache value)
/*     */   {
/*  61 */     _Tables_.getInstance().multiroleaward.insertWithLocalid(localid, key, value);
/*     */   }
/*     */   
/*     */   public static void delete(Long key)
/*     */   {
/*  66 */     _Tables_.getInstance().multiroleaward.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(Long key, MultiRoleAwardCache value)
/*     */   {
/*  71 */     return _Tables_.getInstance().multiroleaward.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean addWithLocalid(int localid, Long key, MultiRoleAwardCache value)
/*     */   {
/*  76 */     return _Tables_.getInstance().multiroleaward.addWithLocalid(localid, key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(Long key)
/*     */   {
/*  81 */     return _Tables_.getInstance().multiroleaward.remove(key);
/*     */   }
/*     */   
/*     */   public static xdb.TTableCache<Long, MultiRoleAwardCache> getCache()
/*     */   {
/*  86 */     return _Tables_.getInstance().multiroleaward.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<Long, MultiRoleAwardCache> getTable()
/*     */   {
/*  91 */     return _Tables_.getInstance().multiroleaward;
/*     */   }
/*     */   
/*     */   public static List<Long> selectRoles(Long key)
/*     */   {
/*  96 */     (List)getTable().select(key, new xdb.TField()
/*     */     {
/*     */       public List<Long> get(MultiRoleAwardCache v)
/*     */       {
/* 100 */         return v.getRolesAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static List<xbean.Item2CountBean> selectAwarditemids(Long key)
/*     */   {
/* 107 */     (List)getTable().select(key, new xdb.TField()
/*     */     {
/*     */       public List<xbean.Item2CountBean> get(MultiRoleAwardCache v)
/*     */       {
/* 111 */         return v.getAwarditemidsAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<Integer, Long> selectIndexmap(Long key)
/*     */   {
/* 118 */     (Map)getTable().select(key, new xdb.TField()
/*     */     {
/*     */       public Map<Integer, Long> get(MultiRoleAwardCache v)
/*     */       {
/* 122 */         return v.getIndexmapAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static java.util.Set<Long> selectOperroleids(Long key)
/*     */   {
/* 129 */     (java.util.Set)getTable().select(key, new xdb.TField()
/*     */     {
/*     */       public java.util.Set<Long> get(MultiRoleAwardCache v)
/*     */       {
/* 133 */         return v.getOperroleidsAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Multiroleaward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */