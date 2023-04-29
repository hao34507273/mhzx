/*     */ package xtable;
/*     */ 
/*     */ import java.util.Set;
/*     */ import xbean.AuctionPetInfo;
/*     */ import xdb.TField;
/*     */ import xdb.TTable;
/*     */ 
/*     */ public class Marketpetid2auction
/*     */ {
/*     */   public static AuctionPetInfo get(Long key)
/*     */   {
/*  12 */     return (AuctionPetInfo)_Tables_.getInstance().marketpetid2auction.get(key);
/*     */   }
/*     */   
/*     */   public static AuctionPetInfo get(Long key, AuctionPetInfo value)
/*     */   {
/*  17 */     return (AuctionPetInfo)_Tables_.getInstance().marketpetid2auction.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(Long key, AuctionPetInfo value)
/*     */   {
/*  22 */     _Tables_.getInstance().marketpetid2auction.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void delete(Long key)
/*     */   {
/*  27 */     _Tables_.getInstance().marketpetid2auction.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(Long key, AuctionPetInfo value)
/*     */   {
/*  32 */     return _Tables_.getInstance().marketpetid2auction.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(Long key)
/*     */   {
/*  37 */     return _Tables_.getInstance().marketpetid2auction.remove(key);
/*     */   }
/*     */   
/*     */   public static xdb.TTableCache<Long, AuctionPetInfo> getCache()
/*     */   {
/*  42 */     return _Tables_.getInstance().marketpetid2auction.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<Long, AuctionPetInfo> getTable()
/*     */   {
/*  47 */     return _Tables_.getInstance().marketpetid2auction;
/*     */   }
/*     */   
/*     */   public static AuctionPetInfo select(Long key)
/*     */   {
/*  52 */     (AuctionPetInfo)getTable().select(key, new TField()
/*     */     {
/*     */       public AuctionPetInfo get(AuctionPetInfo v)
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
/*     */       public Long get(AuctionPetInfo v)
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
/*     */       public Long get(AuctionPetInfo v)
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
/*     */       public Integer get(AuctionPetInfo v)
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
/*     */       public Integer get(AuctionPetInfo v)
/*     */       {
/* 100 */         return Integer.valueOf(v.getAuctionprice());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectPetcfgid(Long key)
/*     */   {
/* 107 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(AuctionPetInfo v)
/*     */       {
/* 111 */         return Integer.valueOf(v.getPetcfgid());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Set<Long> selectAuctionroleset(Long key)
/*     */   {
/* 118 */     (Set)getTable().select(key, new TField()
/*     */     {
/*     */       public Set<Long> get(AuctionPetInfo v)
/*     */       {
/* 122 */         return v.getAuctionrolesetAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Boolean selectIssendtip(Long key)
/*     */   {
/* 129 */     (Boolean)getTable().select(key, new TField()
/*     */     {
/*     */       public Boolean get(AuctionPetInfo v)
/*     */       {
/* 133 */         return Boolean.valueOf(v.getIssendtip());
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Marketpetid2auction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */