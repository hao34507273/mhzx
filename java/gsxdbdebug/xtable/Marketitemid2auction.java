/*     */ package xtable;
/*     */ 
/*     */ import java.util.Set;
/*     */ import xbean.AuctionItemInfo;
/*     */ import xdb.TField;
/*     */ import xdb.TTable;
/*     */ 
/*     */ public class Marketitemid2auction
/*     */ {
/*     */   public static AuctionItemInfo get(Long key)
/*     */   {
/*  12 */     return (AuctionItemInfo)_Tables_.getInstance().marketitemid2auction.get(key);
/*     */   }
/*     */   
/*     */   public static AuctionItemInfo get(Long key, AuctionItemInfo value)
/*     */   {
/*  17 */     return (AuctionItemInfo)_Tables_.getInstance().marketitemid2auction.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(Long key, AuctionItemInfo value)
/*     */   {
/*  22 */     _Tables_.getInstance().marketitemid2auction.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void delete(Long key)
/*     */   {
/*  27 */     _Tables_.getInstance().marketitemid2auction.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(Long key, AuctionItemInfo value)
/*     */   {
/*  32 */     return _Tables_.getInstance().marketitemid2auction.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(Long key)
/*     */   {
/*  37 */     return _Tables_.getInstance().marketitemid2auction.remove(key);
/*     */   }
/*     */   
/*     */   public static xdb.TTableCache<Long, AuctionItemInfo> getCache()
/*     */   {
/*  42 */     return _Tables_.getInstance().marketitemid2auction.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<Long, AuctionItemInfo> getTable()
/*     */   {
/*  47 */     return _Tables_.getInstance().marketitemid2auction;
/*     */   }
/*     */   
/*     */   public static AuctionItemInfo select(Long key)
/*     */   {
/*  52 */     (AuctionItemInfo)getTable().select(key, new TField()
/*     */     {
/*     */       public AuctionItemInfo get(AuctionItemInfo v)
/*     */       {
/*  56 */         return v.toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectAuctionroleid(Long key)
/*     */   {
/*  63 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(AuctionItemInfo v)
/*     */       {
/*  67 */         return Long.valueOf(v.getAuctionroleid());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectEndtime(Long key)
/*     */   {
/*  74 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(AuctionItemInfo v)
/*     */       {
/*  78 */         return Long.valueOf(v.getEndtime());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectAuctioncount(Long key)
/*     */   {
/*  85 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(AuctionItemInfo v)
/*     */       {
/*  89 */         return Integer.valueOf(v.getAuctioncount());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectAuctionprice(Long key)
/*     */   {
/*  96 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(AuctionItemInfo v)
/*     */       {
/* 100 */         return Integer.valueOf(v.getAuctionprice());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectItemid(Long key)
/*     */   {
/* 107 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(AuctionItemInfo v)
/*     */       {
/* 111 */         return Integer.valueOf(v.getItemid());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Set<Long> selectAuctionroleset(Long key)
/*     */   {
/* 118 */     (Set)getTable().select(key, new TField()
/*     */     {
/*     */       public Set<Long> get(AuctionItemInfo v)
/*     */       {
/* 122 */         return v.getAuctionrolesetAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectItemnum(Long key)
/*     */   {
/* 129 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(AuctionItemInfo v)
/*     */       {
/* 133 */         return Integer.valueOf(v.getItemnum());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Boolean selectIssendtip(Long key)
/*     */   {
/* 140 */     (Boolean)getTable().select(key, new TField()
/*     */     {
/*     */       public Boolean get(AuctionItemInfo v)
/*     */       {
/* 144 */         return Boolean.valueOf(v.getIssendtip());
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Marketitemid2auction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */