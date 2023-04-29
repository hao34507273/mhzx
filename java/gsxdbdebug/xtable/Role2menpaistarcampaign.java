/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.MenPaiStarCampaignInfo;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2menpaistarcampaign
/*    */ {
/*    */   public static MenPaiStarCampaignInfo get(Long key)
/*    */   {
/* 12 */     return (MenPaiStarCampaignInfo)_Tables_.getInstance().role2menpaistarcampaign.get(key);
/*    */   }
/*    */   
/*    */   public static MenPaiStarCampaignInfo get(Long key, MenPaiStarCampaignInfo value)
/*    */   {
/* 17 */     return (MenPaiStarCampaignInfo)_Tables_.getInstance().role2menpaistarcampaign.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, MenPaiStarCampaignInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2menpaistarcampaign.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2menpaistarcampaign.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, MenPaiStarCampaignInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2menpaistarcampaign.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2menpaistarcampaign.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, MenPaiStarCampaignInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2menpaistarcampaign.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, MenPaiStarCampaignInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2menpaistarcampaign;
/*    */   }
/*    */   
/*    */   public static MenPaiStarCampaignInfo select(Long key)
/*    */   {
/* 52 */     (MenPaiStarCampaignInfo)getTable().select(key, new TField()
/*    */     {
/*    */       public MenPaiStarCampaignInfo get(MenPaiStarCampaignInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectToday_campaign_num(Long key)
/*    */   {
/* 63 */     (Integer)getTable().select(key, new TField()
/*    */     {
/*    */       public Integer get(MenPaiStarCampaignInfo v)
/*    */       {
/* 67 */         return Integer.valueOf(v.getToday_campaign_num());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectLast_campaign_time(Long key)
/*    */   {
/* 74 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(MenPaiStarCampaignInfo v)
/*    */       {
/* 78 */         return Long.valueOf(v.getLast_campaign_time());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, xbean.Campaign> selectCampaigns(Long key)
/*    */   {
/* 85 */     (Map)getTable().select(key, new TField()
/*    */     {
/*    */       public Map<Integer, xbean.Campaign> get(MenPaiStarCampaignInfo v)
/*    */       {
/* 89 */         return v.getCampaignsAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2menpaistarcampaign.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */