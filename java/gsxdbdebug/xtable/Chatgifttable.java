/*     */ package xtable;
/*     */ 
/*     */ import java.util.Map;
/*     */ import xbean.ChatGift;
/*     */ import xdb.TField;
/*     */ import xdb.TTable;
/*     */ 
/*     */ public class Chatgifttable
/*     */ {
/*     */   public static ChatGift get(Long key)
/*     */   {
/*  12 */     return (ChatGift)_Tables_.getInstance().chatgifttable.get(key);
/*     */   }
/*     */   
/*     */   public static ChatGift get(Long key, ChatGift value)
/*     */   {
/*  17 */     return (ChatGift)_Tables_.getInstance().chatgifttable.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(Long key, ChatGift value)
/*     */   {
/*  22 */     _Tables_.getInstance().chatgifttable.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void delete(Long key)
/*     */   {
/*  27 */     _Tables_.getInstance().chatgifttable.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(Long key, ChatGift value)
/*     */   {
/*  32 */     return _Tables_.getInstance().chatgifttable.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(Long key)
/*     */   {
/*  37 */     return _Tables_.getInstance().chatgifttable.remove(key);
/*     */   }
/*     */   
/*     */   public static xdb.TTableCache<Long, ChatGift> getCache()
/*     */   {
/*  42 */     return _Tables_.getInstance().chatgifttable.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<Long, ChatGift> getTable()
/*     */   {
/*  47 */     return _Tables_.getInstance().chatgifttable;
/*     */   }
/*     */   
/*     */   public static ChatGift select(Long key)
/*     */   {
/*  52 */     (ChatGift)getTable().select(key, new TField()
/*     */     {
/*     */       public ChatGift get(ChatGift v)
/*     */       {
/*  56 */         return v.toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectRoleid(Long key)
/*     */   {
/*  63 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(ChatGift v)
/*     */       {
/*  67 */         return Long.valueOf(v.getRoleid());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectStarttime(Long key)
/*     */   {
/*  74 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(ChatGift v)
/*     */       {
/*  78 */         return Long.valueOf(v.getStarttime());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectType(Long key)
/*     */   {
/*  85 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(ChatGift v)
/*     */       {
/*  89 */         return Integer.valueOf(v.getType());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<Long, xbean.ChatGiftRoleMoney> selectRole2money(Long key)
/*     */   {
/*  96 */     (Map)getTable().select(key, new TField()
/*     */     {
/*     */       public Map<Long, xbean.ChatGiftRoleMoney> get(ChatGift v)
/*     */       {
/* 100 */         return v.getRole2moneyAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectNum(Long key)
/*     */   {
/* 107 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(ChatGift v)
/*     */       {
/* 111 */         return Integer.valueOf(v.getNum());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static String selectDescstr(Long key)
/*     */   {
/* 118 */     (String)getTable().select(key, new TField()
/*     */     {
/*     */       public String get(ChatGift v)
/*     */       {
/* 122 */         return v.getDescstr();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<Integer, xbean.ChannelSet> selectChannelinfo(Long key)
/*     */   {
/* 129 */     (Map)getTable().select(key, new TField()
/*     */     {
/*     */       public Map<Integer, xbean.ChannelSet> get(ChatGift v)
/*     */       {
/* 133 */         return v.getChannelinfoAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Chatgifttable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */