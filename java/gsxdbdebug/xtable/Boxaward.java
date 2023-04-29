/*     */ package xtable;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import xbean.BoxAwardBean;
/*     */ import xdb.TTable;
/*     */ 
/*     */ public class Boxaward
/*     */ {
/*     */   public static xdb.util.AutoKey<Long> getAutoKey()
/*     */   {
/*  12 */     return _Tables_.getInstance().boxaward.getAutoKey();
/*     */   }
/*     */   
/*     */   public static xdb.util.AutoKey<Long> getAutoKey(int localid)
/*     */   {
/*  17 */     return _Tables_.getInstance().boxaward.getAutoKey(localid);
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
/*     */   public static Long insert(BoxAwardBean value)
/*     */   {
/*  32 */     Long next = nextKey();
/*  33 */     insert(next, value);
/*  34 */     return next;
/*     */   }
/*     */   
/*     */   public static Long insertWithLocalid(int localid, BoxAwardBean value)
/*     */   {
/*  39 */     Long next = nextKey(localid);
/*  40 */     insertWithLocalid(localid, next, value);
/*  41 */     return next;
/*     */   }
/*     */   
/*     */   public static BoxAwardBean get(Long key)
/*     */   {
/*  46 */     return (BoxAwardBean)_Tables_.getInstance().boxaward.get(key);
/*     */   }
/*     */   
/*     */   public static BoxAwardBean get(Long key, BoxAwardBean value)
/*     */   {
/*  51 */     return (BoxAwardBean)_Tables_.getInstance().boxaward.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(Long key, BoxAwardBean value)
/*     */   {
/*  56 */     _Tables_.getInstance().boxaward.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void insertWithLocalid(int localid, Long key, BoxAwardBean value)
/*     */   {
/*  61 */     _Tables_.getInstance().boxaward.insertWithLocalid(localid, key, value);
/*     */   }
/*     */   
/*     */   public static void delete(Long key)
/*     */   {
/*  66 */     _Tables_.getInstance().boxaward.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(Long key, BoxAwardBean value)
/*     */   {
/*  71 */     return _Tables_.getInstance().boxaward.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean addWithLocalid(int localid, Long key, BoxAwardBean value)
/*     */   {
/*  76 */     return _Tables_.getInstance().boxaward.addWithLocalid(localid, key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(Long key)
/*     */   {
/*  81 */     return _Tables_.getInstance().boxaward.remove(key);
/*     */   }
/*     */   
/*     */   public static xdb.TTableCache<Long, BoxAwardBean> getCache()
/*     */   {
/*  86 */     return _Tables_.getInstance().boxaward.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<Long, BoxAwardBean> getTable()
/*     */   {
/*  91 */     return _Tables_.getInstance().boxaward;
/*     */   }
/*     */   
/*     */   public static BoxAwardBean select(Long key)
/*     */   {
/*  96 */     (BoxAwardBean)getTable().select(key, new xdb.TField()
/*     */     {
/*     */       public BoxAwardBean get(BoxAwardBean v)
/*     */       {
/* 100 */         return v.toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static List<Long> selectRoleids(Long key)
/*     */   {
/* 107 */     (List)getTable().select(key, new xdb.TField()
/*     */     {
/*     */       public List<Long> get(BoxAwardBean v)
/*     */       {
/* 111 */         return v.getRoleidsAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<Long, xbean.AwardBean> selectAwardrolemap(Long key)
/*     */   {
/* 118 */     (Map)getTable().select(key, new xdb.TField()
/*     */     {
/*     */       public Map<Long, xbean.AwardBean> get(BoxAwardBean v)
/*     */       {
/* 122 */         return v.getAwardrolemapAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<Long, Integer> selectRollrolemap(Long key)
/*     */   {
/* 129 */     (Map)getTable().select(key, new xdb.TField()
/*     */     {
/*     */       public Map<Long, Integer> get(BoxAwardBean v)
/*     */       {
/* 133 */         return v.getRollrolemapAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static List<Integer> selectAwarditemids(Long key)
/*     */   {
/* 140 */     (List)getTable().select(key, new xdb.TField()
/*     */     {
/*     */       public List<Integer> get(BoxAwardBean v)
/*     */       {
/* 144 */         return v.getAwarditemidsAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectIndex(Long key)
/*     */   {
/* 151 */     (Integer)getTable().select(key, new xdb.TField()
/*     */     {
/*     */       public Integer get(BoxAwardBean v)
/*     */       {
/* 155 */         return Integer.valueOf(v.getIndex());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static List<Long> selectOperroleids(Long key)
/*     */   {
/* 162 */     (List)getTable().select(key, new xdb.TField()
/*     */     {
/*     */       public List<Long> get(BoxAwardBean v)
/*     */       {
/* 166 */         return v.getOperroleidsAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Boxaward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */