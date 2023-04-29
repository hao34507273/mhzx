/*     */ package xtable;
/*     */ 
/*     */ import java.util.Map;
/*     */ import xbean.RoleChatInfo;
/*     */ import xdb.TField;
/*     */ import xdb.TTable;
/*     */ 
/*     */ public class Role2chat
/*     */ {
/*     */   public static RoleChatInfo get(Long key)
/*     */   {
/*  12 */     return (RoleChatInfo)_Tables_.getInstance().role2chat.get(key);
/*     */   }
/*     */   
/*     */   public static RoleChatInfo get(Long key, RoleChatInfo value)
/*     */   {
/*  17 */     return (RoleChatInfo)_Tables_.getInstance().role2chat.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(Long key, RoleChatInfo value)
/*     */   {
/*  22 */     _Tables_.getInstance().role2chat.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void delete(Long key)
/*     */   {
/*  27 */     _Tables_.getInstance().role2chat.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(Long key, RoleChatInfo value)
/*     */   {
/*  32 */     return _Tables_.getInstance().role2chat.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(Long key)
/*     */   {
/*  37 */     return _Tables_.getInstance().role2chat.remove(key);
/*     */   }
/*     */   
/*     */   public static xdb.TTableCache<Long, RoleChatInfo> getCache()
/*     */   {
/*  42 */     return _Tables_.getInstance().role2chat.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<Long, RoleChatInfo> getTable()
/*     */   {
/*  47 */     return _Tables_.getInstance().role2chat;
/*     */   }
/*     */   
/*     */   public static RoleChatInfo select(Long key)
/*     */   {
/*  52 */     (RoleChatInfo)getTable().select(key, new TField()
/*     */     {
/*     */       public RoleChatInfo get(RoleChatInfo v)
/*     */       {
/*  56 */         return v.toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<Integer, Long> selectChannels(Long key)
/*     */   {
/*  63 */     (Map)getTable().select(key, new TField()
/*     */     {
/*     */       public Map<Integer, Long> get(RoleChatInfo v)
/*     */       {
/*  67 */         return v.getChannelsAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<Long, xbean.ChatDataListBean> selectChatinfo(Long key)
/*     */   {
/*  74 */     (Map)getTable().select(key, new TField()
/*     */     {
/*     */       public Map<Long, xbean.ChatDataListBean> get(RoleChatInfo v)
/*     */       {
/*  78 */         return v.getChatinfoAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<Integer, Integer> selectChatcfg(Long key)
/*     */   {
/*  85 */     (Map)getTable().select(key, new TField()
/*     */     {
/*     */       public Map<Integer, Integer> get(RoleChatInfo v)
/*     */       {
/*  89 */         return v.getChatcfgAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectChat_room_type(Long key)
/*     */   {
/*  96 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(RoleChatInfo v)
/*     */       {
/* 100 */         return Integer.valueOf(v.getChat_room_type());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectChat_roomid(Long key)
/*     */   {
/* 107 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(RoleChatInfo v)
/*     */       {
/* 111 */         return Integer.valueOf(v.getChat_roomid());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<Integer, Long> selectSecretchannels(Long key)
/*     */   {
/* 118 */     (Map)getTable().select(key, new TField()
/*     */     {
/*     */       public Map<Integer, Long> get(RoleChatInfo v)
/*     */       {
/* 122 */         return v.getSecretchannelsAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2chat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */