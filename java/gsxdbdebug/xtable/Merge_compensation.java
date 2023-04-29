/*     */ package xtable;
/*     */ 
/*     */ import java.util.Map;
/*     */ import xbean.MergeCompensationInfo;
/*     */ import xdb.TField;
/*     */ import xdb.TTable;
/*     */ 
/*     */ public class Merge_compensation
/*     */ {
/*     */   public static MergeCompensationInfo get(Long key)
/*     */   {
/*  12 */     return (MergeCompensationInfo)_Tables_.getInstance().merge_compensation.get(key);
/*     */   }
/*     */   
/*     */   public static MergeCompensationInfo get(Long key, MergeCompensationInfo value)
/*     */   {
/*  17 */     return (MergeCompensationInfo)_Tables_.getInstance().merge_compensation.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(Long key, MergeCompensationInfo value)
/*     */   {
/*  22 */     _Tables_.getInstance().merge_compensation.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void delete(Long key)
/*     */   {
/*  27 */     _Tables_.getInstance().merge_compensation.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(Long key, MergeCompensationInfo value)
/*     */   {
/*  32 */     return _Tables_.getInstance().merge_compensation.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(Long key)
/*     */   {
/*  37 */     return _Tables_.getInstance().merge_compensation.remove(key);
/*     */   }
/*     */   
/*     */   public static xdb.TTableCache<Long, MergeCompensationInfo> getCache()
/*     */   {
/*  42 */     return _Tables_.getInstance().merge_compensation.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<Long, MergeCompensationInfo> getTable()
/*     */   {
/*  47 */     return _Tables_.getInstance().merge_compensation;
/*     */   }
/*     */   
/*     */   public static MergeCompensationInfo select(Long key)
/*     */   {
/*  52 */     (MergeCompensationInfo)getTable().select(key, new TField()
/*     */     {
/*     */       public MergeCompensationInfo get(MergeCompensationInfo v)
/*     */       {
/*  56 */         return v.toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<Long, xbean.ServerLevelInfo> selectServer_level_infos(Long key)
/*     */   {
/*  63 */     (Map)getTable().select(key, new TField()
/*     */     {
/*     */       public Map<Long, xbean.ServerLevelInfo> get(MergeCompensationInfo v)
/*     */       {
/*  67 */         return v.getServer_level_infosAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectMax_server_level_zoneid(Long key)
/*     */   {
/*  74 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(MergeCompensationInfo v)
/*     */       {
/*  78 */         return Long.valueOf(v.getMax_server_level_zoneid());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectMerge_system_timestamp(Long key)
/*     */   {
/*  85 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(MergeCompensationInfo v)
/*     */       {
/*  89 */         return Long.valueOf(v.getMerge_system_timestamp());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectMerge_time_offset(Long key)
/*     */   {
/*  96 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(MergeCompensationInfo v)
/*     */       {
/* 100 */         return Long.valueOf(v.getMerge_time_offset());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Boolean selectIs_data_available(Long key)
/*     */   {
/* 107 */     (Boolean)getTable().select(key, new TField()
/*     */     {
/*     */       public Boolean get(MergeCompensationInfo v)
/*     */       {
/* 111 */         return Boolean.valueOf(v.getIs_data_available());
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Merge_compensation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */