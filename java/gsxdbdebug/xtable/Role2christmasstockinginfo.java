/*     */ package xtable;
/*     */ 
/*     */ import java.util.Map;
/*     */ import xbean.Role2ChristmasStockingInfo;
/*     */ import xdb.TField;
/*     */ import xdb.TTable;
/*     */ 
/*     */ public class Role2christmasstockinginfo
/*     */ {
/*     */   public static Role2ChristmasStockingInfo get(Long key)
/*     */   {
/*  12 */     return (Role2ChristmasStockingInfo)_Tables_.getInstance().role2christmasstockinginfo.get(key);
/*     */   }
/*     */   
/*     */   public static Role2ChristmasStockingInfo get(Long key, Role2ChristmasStockingInfo value)
/*     */   {
/*  17 */     return (Role2ChristmasStockingInfo)_Tables_.getInstance().role2christmasstockinginfo.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(Long key, Role2ChristmasStockingInfo value)
/*     */   {
/*  22 */     _Tables_.getInstance().role2christmasstockinginfo.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void delete(Long key)
/*     */   {
/*  27 */     _Tables_.getInstance().role2christmasstockinginfo.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(Long key, Role2ChristmasStockingInfo value)
/*     */   {
/*  32 */     return _Tables_.getInstance().role2christmasstockinginfo.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(Long key)
/*     */   {
/*  37 */     return _Tables_.getInstance().role2christmasstockinginfo.remove(key);
/*     */   }
/*     */   
/*     */   public static xdb.TTableCache<Long, Role2ChristmasStockingInfo> getCache()
/*     */   {
/*  42 */     return _Tables_.getInstance().role2christmasstockinginfo.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<Long, Role2ChristmasStockingInfo> getTable()
/*     */   {
/*  47 */     return _Tables_.getInstance().role2christmasstockinginfo;
/*     */   }
/*     */   
/*     */   public static Role2ChristmasStockingInfo select(Long key)
/*     */   {
/*  52 */     (Role2ChristmasStockingInfo)getTable().select(key, new TField()
/*     */     {
/*     */       public Role2ChristmasStockingInfo get(Role2ChristmasStockingInfo v)
/*     */       {
/*  56 */         return v.toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<Integer, xbean.ChristmasTreePositionInfo> selectChristmastreepositionindex2info(Long key)
/*     */   {
/*  63 */     (Map)getTable().select(key, new TField()
/*     */     {
/*     */       public Map<Integer, xbean.ChristmasTreePositionInfo> get(Role2ChristmasStockingInfo v)
/*     */       {
/*  67 */         return v.getChristmastreepositionindex2infoAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<Long, Integer> selectTargetroleid2selfhangnum(Long key)
/*     */   {
/*  74 */     (Map)getTable().select(key, new TField()
/*     */     {
/*     */       public Map<Long, Integer> get(Role2ChristmasStockingInfo v)
/*     */       {
/*  78 */         return v.getTargetroleid2selfhangnumAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static java.util.List<xbean.HangStockingHistoryInfo> selectHangstockinghistoryinfos(Long key)
/*     */   {
/*  85 */     (java.util.List)getTable().select(key, new TField()
/*     */     {
/*     */       public java.util.List<xbean.HangStockingHistoryInfo> get(Role2ChristmasStockingInfo v)
/*     */       {
/*  89 */         return v.getHangstockinghistoryinfosAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectGetstockinghidingawardnum(Long key)
/*     */   {
/*  96 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(Role2ChristmasStockingInfo v)
/*     */       {
/* 100 */         return Integer.valueOf(v.getGetstockinghidingawardnum());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Boolean selectHasgotstockinghidingmail(Long key)
/*     */   {
/* 107 */     (Boolean)getTable().select(key, new TField()
/*     */     {
/*     */       public Boolean get(Role2ChristmasStockingInfo v)
/*     */       {
/* 111 */         return Boolean.valueOf(v.getHasgotstockinghidingmail());
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2christmasstockinginfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */