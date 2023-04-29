/*     */ package xtable;
/*     */ 
/*     */ import java.util.Map;
/*     */ import xbean.OnlineUserInfo;
/*     */ import xdb.TField;
/*     */ import xdb.TTable;
/*     */ 
/*     */ public class Onlineuserinfo
/*     */ {
/*     */   public static OnlineUserInfo get(String key)
/*     */   {
/*  12 */     return (OnlineUserInfo)_Tables_.getInstance().onlineuserinfo.get(key);
/*     */   }
/*     */   
/*     */   public static OnlineUserInfo get(String key, OnlineUserInfo value)
/*     */   {
/*  17 */     return (OnlineUserInfo)_Tables_.getInstance().onlineuserinfo.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(String key, OnlineUserInfo value)
/*     */   {
/*  22 */     _Tables_.getInstance().onlineuserinfo.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void delete(String key)
/*     */   {
/*  27 */     _Tables_.getInstance().onlineuserinfo.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(String key, OnlineUserInfo value)
/*     */   {
/*  32 */     return _Tables_.getInstance().onlineuserinfo.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(String key)
/*     */   {
/*  37 */     return _Tables_.getInstance().onlineuserinfo.remove(key);
/*     */   }
/*     */   
/*     */   public static xdb.TTableCache<String, OnlineUserInfo> getCache()
/*     */   {
/*  42 */     return _Tables_.getInstance().onlineuserinfo.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<String, OnlineUserInfo> getTable()
/*     */   {
/*  47 */     return _Tables_.getInstance().onlineuserinfo;
/*     */   }
/*     */   
/*     */   public static OnlineUserInfo select(String key)
/*     */   {
/*  52 */     (OnlineUserInfo)getTable().select(key, new TField()
/*     */     {
/*     */       public OnlineUserInfo get(OnlineUserInfo v)
/*     */       {
/*  56 */         return v.toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectPeer(String key)
/*     */   {
/*  63 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(OnlineUserInfo v)
/*     */       {
/*  67 */         return Integer.valueOf(v.getPeer());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectFunc(String key)
/*     */   {
/*  74 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(OnlineUserInfo v)
/*     */       {
/*  78 */         return Integer.valueOf(v.getFunc());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectFuncparm(String key)
/*     */   {
/*  85 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(OnlineUserInfo v)
/*     */       {
/*  89 */         return Integer.valueOf(v.getFuncparm());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectAlgorithm(String key)
/*     */   {
/*  96 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(OnlineUserInfo v)
/*     */       {
/* 100 */         return Integer.valueOf(v.getAlgorithm());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static String selectChannel(String key)
/*     */   {
/* 107 */     (String)getTable().select(key, new TField()
/*     */     {
/*     */       public String get(OnlineUserInfo v)
/*     */       {
/* 111 */         return v.getChannel();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static String selectRegisterchannel(String key)
/*     */   {
/* 118 */     (String)getTable().select(key, new TField()
/*     */     {
/*     */       public String get(OnlineUserInfo v)
/*     */       {
/* 122 */         return v.getRegisterchannel();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static String selectGameappid(String key)
/*     */   {
/* 129 */     (String)getTable().select(key, new TField()
/*     */     {
/*     */       public String get(OnlineUserInfo v)
/*     */       {
/* 133 */         return v.getGameappid();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectPlatid(String key)
/*     */   {
/* 140 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(OnlineUserInfo v)
/*     */       {
/* 144 */         return Integer.valueOf(v.getPlatid());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectTelecomoper(String key)
/*     */   {
/* 151 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(OnlineUserInfo v)
/*     */       {
/* 155 */         return Integer.valueOf(v.getTelecomoper());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<String, String> selectJsonparams(String key)
/*     */   {
/* 162 */     (Map)getTable().select(key, new TField()
/*     */     {
/*     */       public Map<String, String> get(OnlineUserInfo v)
/*     */       {
/* 166 */         return v.getJsonparamsAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Boolean selectFake_plat(String key)
/*     */   {
/* 173 */     (Boolean)getTable().select(key, new TField()
/*     */     {
/*     */       public Boolean get(OnlineUserInfo v)
/*     */       {
/* 177 */         return Boolean.valueOf(v.getFake_plat());
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Onlineuserinfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */