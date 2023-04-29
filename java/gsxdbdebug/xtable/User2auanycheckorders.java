/*     */ package xtable;
/*     */ 
/*     */ import java.util.List;
/*     */ import xbean.UserAuAnyCheckOrders;
/*     */ import xdb.TField;
/*     */ import xdb.TTable;
/*     */ 
/*     */ public class User2auanycheckorders
/*     */ {
/*     */   public static UserAuAnyCheckOrders get(String key)
/*     */   {
/*  12 */     return (UserAuAnyCheckOrders)_Tables_.getInstance().user2auanycheckorders.get(key);
/*     */   }
/*     */   
/*     */   public static UserAuAnyCheckOrders get(String key, UserAuAnyCheckOrders value)
/*     */   {
/*  17 */     return (UserAuAnyCheckOrders)_Tables_.getInstance().user2auanycheckorders.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(String key, UserAuAnyCheckOrders value)
/*     */   {
/*  22 */     _Tables_.getInstance().user2auanycheckorders.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void delete(String key)
/*     */   {
/*  27 */     _Tables_.getInstance().user2auanycheckorders.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(String key, UserAuAnyCheckOrders value)
/*     */   {
/*  32 */     return _Tables_.getInstance().user2auanycheckorders.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(String key)
/*     */   {
/*  37 */     return _Tables_.getInstance().user2auanycheckorders.remove(key);
/*     */   }
/*     */   
/*     */   public static xdb.TTableCache<String, UserAuAnyCheckOrders> getCache()
/*     */   {
/*  42 */     return _Tables_.getInstance().user2auanycheckorders.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<String, UserAuAnyCheckOrders> getTable()
/*     */   {
/*  47 */     return _Tables_.getInstance().user2auanycheckorders;
/*     */   }
/*     */   
/*     */   public static UserAuAnyCheckOrders select(String key)
/*     */   {
/*  52 */     (UserAuAnyCheckOrders)getTable().select(key, new TField()
/*     */     {
/*     */       public UserAuAnyCheckOrders get(UserAuAnyCheckOrders v)
/*     */       {
/*  56 */         return v.toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectOffset(String key)
/*     */   {
/*  63 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(UserAuAnyCheckOrders v)
/*     */       {
/*  67 */         return Integer.valueOf(v.getOffset());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectSn(String key)
/*     */   {
/*  74 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(UserAuAnyCheckOrders v)
/*     */       {
/*  78 */         return Integer.valueOf(v.getSn());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectCheck_status(String key)
/*     */   {
/*  85 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(UserAuAnyCheckOrders v)
/*     */       {
/*  89 */         return Integer.valueOf(v.getCheck_status());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static List<xbean.AuAnyCheckOrderInfo> selectOrders(String key)
/*     */   {
/*  96 */     (List)getTable().select(key, new TField()
/*     */     {
/*     */       public List<xbean.AuAnyCheckOrderInfo> get(UserAuAnyCheckOrders v)
/*     */       {
/* 100 */         return v.getOrdersAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectMagic_num(String key)
/*     */   {
/* 107 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(UserAuAnyCheckOrders v)
/*     */       {
/* 111 */         return Long.valueOf(v.getMagic_num());
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\User2auanycheckorders.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */