/*    */ package xtable;
/*    */ 
/*    */ import xbean.CatBestPartnerInfo;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ import xdb.TTableCache;
/*    */ 
/*    */ public class Catbestpartner
/*    */ {
/*    */   public static CatBestPartnerInfo get(Long key)
/*    */   {
/* 12 */     return (CatBestPartnerInfo)_Tables_.getInstance().catbestpartner.get(key);
/*    */   }
/*    */   
/*    */   public static CatBestPartnerInfo get(Long key, CatBestPartnerInfo value)
/*    */   {
/* 17 */     return (CatBestPartnerInfo)_Tables_.getInstance().catbestpartner.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, CatBestPartnerInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().catbestpartner.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().catbestpartner.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, CatBestPartnerInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().catbestpartner.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().catbestpartner.remove(key);
/*    */   }
/*    */   
/*    */   public static TTableCache<Long, CatBestPartnerInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().catbestpartner.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, CatBestPartnerInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().catbestpartner;
/*    */   }
/*    */   
/*    */   public static CatBestPartnerInfo select(Long key)
/*    */   {
/* 52 */     (CatBestPartnerInfo)getTable().select(key, new TField()
/*    */     {
/*    */       public CatBestPartnerInfo get(CatBestPartnerInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectLast_timestamp(Long key)
/*    */   {
/* 63 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(CatBestPartnerInfo v)
/*    */       {
/* 67 */         return Long.valueOf(v.getLast_timestamp());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectPartner_cfgid(Long key)
/*    */   {
/* 74 */     (Integer)getTable().select(key, new TField()
/*    */     {
/*    */       public Integer get(CatBestPartnerInfo v)
/*    */       {
/* 78 */         return Integer.valueOf(v.getPartner_cfgid());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Catbestpartner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */