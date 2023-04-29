/*     */ package xtable;
/*     */ 
/*     */ import java.util.List;
/*     */ import xbean.JigsawInfo;
/*     */ import xdb.TField;
/*     */ import xdb.TTable;
/*     */ 
/*     */ public class Jigsawinfo
/*     */ {
/*     */   public static xdb.util.AutoKey<Long> getAutoKey()
/*     */   {
/*  12 */     return _Tables_.getInstance().jigsawinfo.getAutoKey();
/*     */   }
/*     */   
/*     */   public static xdb.util.AutoKey<Long> getAutoKey(int localid)
/*     */   {
/*  17 */     return _Tables_.getInstance().jigsawinfo.getAutoKey(localid);
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
/*     */   public static Long insert(JigsawInfo value)
/*     */   {
/*  32 */     Long next = nextKey();
/*  33 */     insert(next, value);
/*  34 */     return next;
/*     */   }
/*     */   
/*     */   public static Long insertWithLocalid(int localid, JigsawInfo value)
/*     */   {
/*  39 */     Long next = nextKey(localid);
/*  40 */     insertWithLocalid(localid, next, value);
/*  41 */     return next;
/*     */   }
/*     */   
/*     */   public static JigsawInfo get(Long key)
/*     */   {
/*  46 */     return (JigsawInfo)_Tables_.getInstance().jigsawinfo.get(key);
/*     */   }
/*     */   
/*     */   public static JigsawInfo get(Long key, JigsawInfo value)
/*     */   {
/*  51 */     return (JigsawInfo)_Tables_.getInstance().jigsawinfo.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(Long key, JigsawInfo value)
/*     */   {
/*  56 */     _Tables_.getInstance().jigsawinfo.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void insertWithLocalid(int localid, Long key, JigsawInfo value)
/*     */   {
/*  61 */     _Tables_.getInstance().jigsawinfo.insertWithLocalid(localid, key, value);
/*     */   }
/*     */   
/*     */   public static void delete(Long key)
/*     */   {
/*  66 */     _Tables_.getInstance().jigsawinfo.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(Long key, JigsawInfo value)
/*     */   {
/*  71 */     return _Tables_.getInstance().jigsawinfo.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean addWithLocalid(int localid, Long key, JigsawInfo value)
/*     */   {
/*  76 */     return _Tables_.getInstance().jigsawinfo.addWithLocalid(localid, key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(Long key)
/*     */   {
/*  81 */     return _Tables_.getInstance().jigsawinfo.remove(key);
/*     */   }
/*     */   
/*     */   public static xdb.TTableCache<Long, JigsawInfo> getCache()
/*     */   {
/*  86 */     return _Tables_.getInstance().jigsawinfo.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<Long, JigsawInfo> getTable()
/*     */   {
/*  91 */     return _Tables_.getInstance().jigsawinfo;
/*     */   }
/*     */   
/*     */   public static Long selectEndtime(Long key)
/*     */   {
/*  96 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(JigsawInfo v)
/*     */       {
/* 100 */         return Long.valueOf(v.getEndtime());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectCfgid(Long key)
/*     */   {
/* 107 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(JigsawInfo v)
/*     */       {
/* 111 */         return Integer.valueOf(v.getCfgid());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static List<Long> selectAllroleids(Long key)
/*     */   {
/* 118 */     (List)getTable().select(key, new TField()
/*     */     {
/*     */       public List<Long> get(JigsawInfo v)
/*     */       {
/* 122 */         return v.getAllroleidsAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static List<Long> selectSucroleids(Long key)
/*     */   {
/* 129 */     (List)getTable().select(key, new TField()
/*     */     {
/*     */       public List<Long> get(JigsawInfo v)
/*     */       {
/* 133 */         return v.getSucroleidsAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static List<Long> selectFailroleids(Long key)
/*     */   {
/* 140 */     (List)getTable().select(key, new TField()
/*     */     {
/*     */       public List<Long> get(JigsawInfo v)
/*     */       {
/* 144 */         return v.getFailroleidsAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Jigsawinfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */