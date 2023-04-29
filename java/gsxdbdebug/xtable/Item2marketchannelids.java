/*    */ package xtable;
/*    */ 
/*    */ import java.util.List;
/*    */ import xbean.MarketChannelIds;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Item2marketchannelids
/*    */ {
/*    */   public static MarketChannelIds get(Long key)
/*    */   {
/* 12 */     return (MarketChannelIds)_Tables_.getInstance().item2marketchannelids.get(key);
/*    */   }
/*    */   
/*    */   public static MarketChannelIds get(Long key, MarketChannelIds value)
/*    */   {
/* 17 */     return (MarketChannelIds)_Tables_.getInstance().item2marketchannelids.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, MarketChannelIds value)
/*    */   {
/* 22 */     _Tables_.getInstance().item2marketchannelids.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().item2marketchannelids.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, MarketChannelIds value)
/*    */   {
/* 32 */     return _Tables_.getInstance().item2marketchannelids.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().item2marketchannelids.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, MarketChannelIds> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().item2marketchannelids.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, MarketChannelIds> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().item2marketchannelids;
/*    */   }
/*    */   
/*    */   public static MarketChannelIds select(Long key)
/*    */   {
/* 52 */     (MarketChannelIds)getTable().select(key, new TField()
/*    */     {
/*    */       public MarketChannelIds get(MarketChannelIds v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static List<Long> selectChannel_ids(Long key)
/*    */   {
/* 63 */     (List)getTable().select(key, new TField()
/*    */     {
/*    */       public List<Long> get(MarketChannelIds v)
/*    */       {
/* 67 */         return v.getChannel_idsAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectSupply_num(Long key)
/*    */   {
/* 74 */     (Integer)getTable().select(key, new TField()
/*    */     {
/*    */       public Integer get(MarketChannelIds v)
/*    */       {
/* 78 */         return Integer.valueOf(v.getSupply_num());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectSupply_time(Long key)
/*    */   {
/* 85 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(MarketChannelIds v)
/*    */       {
/* 89 */         return Long.valueOf(v.getSupply_time());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectSupply_skill_equip_num(Long key)
/*    */   {
/* 96 */     (Integer)getTable().select(key, new TField()
/*    */     {
/*    */       public Integer get(MarketChannelIds v)
/*    */       {
/* :0 */         return Integer.valueOf(v.getSupply_skill_equip_num());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Item2marketchannelids.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */