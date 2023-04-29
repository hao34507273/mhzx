/*     */ package xtable;
/*     */ 
/*     */ import java.util.Set;
/*     */ import xbean.ShoppingGroupInfo;
/*     */ import xdb.TField;
/*     */ import xdb.TTable;
/*     */ 
/*     */ public class Shopping_group_info
/*     */ {
/*     */   public static xdb.util.AutoKey<Long> getAutoKey()
/*     */   {
/*  12 */     return _Tables_.getInstance().shopping_group_info.getAutoKey();
/*     */   }
/*     */   
/*     */   public static xdb.util.AutoKey<Long> getAutoKey(int localid)
/*     */   {
/*  17 */     return _Tables_.getInstance().shopping_group_info.getAutoKey(localid);
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
/*     */   public static Long insert(ShoppingGroupInfo value)
/*     */   {
/*  32 */     Long next = nextKey();
/*  33 */     insert(next, value);
/*  34 */     return next;
/*     */   }
/*     */   
/*     */   public static Long insertWithLocalid(int localid, ShoppingGroupInfo value)
/*     */   {
/*  39 */     Long next = nextKey(localid);
/*  40 */     insertWithLocalid(localid, next, value);
/*  41 */     return next;
/*     */   }
/*     */   
/*     */   public static ShoppingGroupInfo get(Long key)
/*     */   {
/*  46 */     return (ShoppingGroupInfo)_Tables_.getInstance().shopping_group_info.get(key);
/*     */   }
/*     */   
/*     */   public static ShoppingGroupInfo get(Long key, ShoppingGroupInfo value)
/*     */   {
/*  51 */     return (ShoppingGroupInfo)_Tables_.getInstance().shopping_group_info.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(Long key, ShoppingGroupInfo value)
/*     */   {
/*  56 */     _Tables_.getInstance().shopping_group_info.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void insertWithLocalid(int localid, Long key, ShoppingGroupInfo value)
/*     */   {
/*  61 */     _Tables_.getInstance().shopping_group_info.insertWithLocalid(localid, key, value);
/*     */   }
/*     */   
/*     */   public static void delete(Long key)
/*     */   {
/*  66 */     _Tables_.getInstance().shopping_group_info.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(Long key, ShoppingGroupInfo value)
/*     */   {
/*  71 */     return _Tables_.getInstance().shopping_group_info.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean addWithLocalid(int localid, Long key, ShoppingGroupInfo value)
/*     */   {
/*  76 */     return _Tables_.getInstance().shopping_group_info.addWithLocalid(localid, key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(Long key)
/*     */   {
/*  81 */     return _Tables_.getInstance().shopping_group_info.remove(key);
/*     */   }
/*     */   
/*     */   public static xdb.TTableCache<Long, ShoppingGroupInfo> getCache()
/*     */   {
/*  86 */     return _Tables_.getInstance().shopping_group_info.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<Long, ShoppingGroupInfo> getTable()
/*     */   {
/*  91 */     return _Tables_.getInstance().shopping_group_info;
/*     */   }
/*     */   
/*     */   public static ShoppingGroupInfo select(Long key)
/*     */   {
/*  96 */     (ShoppingGroupInfo)getTable().select(key, new TField()
/*     */     {
/*     */       public ShoppingGroupInfo get(ShoppingGroupInfo v)
/*     */       {
/* 100 */         return v.toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectGroup_shopping_item_cfgid(Long key)
/*     */   {
/* 107 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(ShoppingGroupInfo v)
/*     */       {
/* 111 */         return Integer.valueOf(v.getGroup_shopping_item_cfgid());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectCreator_roleid(Long key)
/*     */   {
/* 118 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(ShoppingGroupInfo v)
/*     */       {
/* 122 */         return Long.valueOf(v.getCreator_roleid());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectCreate_time(Long key)
/*     */   {
/* 129 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(ShoppingGroupInfo v)
/*     */       {
/* 133 */         return Integer.valueOf(v.getCreate_time());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectClose_time(Long key)
/*     */   {
/* 140 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(ShoppingGroupInfo v)
/*     */       {
/* 144 */         return Integer.valueOf(v.getClose_time());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectStatus(Long key)
/*     */   {
/* 151 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(ShoppingGroupInfo v)
/*     */       {
/* 155 */         return Integer.valueOf(v.getStatus());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectPrice(Long key)
/*     */   {
/* 162 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(ShoppingGroupInfo v)
/*     */       {
/* 166 */         return Integer.valueOf(v.getPrice());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectGroup_size(Long key)
/*     */   {
/* 173 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(ShoppingGroupInfo v)
/*     */       {
/* 177 */         return Integer.valueOf(v.getGroup_size());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Set<Long> selectMembers(Long key)
/*     */   {
/* 184 */     (Set)getTable().select(key, new TField()
/*     */     {
/*     */       public Set<Long> get(ShoppingGroupInfo v)
/*     */       {
/* 188 */         return v.getMembersAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Shopping_group_info.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */