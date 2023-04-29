/*    */ package xtable;
/*    */ 
/*    */ import xbean.ApprenticeInfo;
/*    */ import xbean.MasterInfo;
/*    */ import xbean.role2ShiTuInfo;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2shitu
/*    */ {
/*    */   public static role2ShiTuInfo get(Long key)
/*    */   {
/* 12 */     return (role2ShiTuInfo)_Tables_.getInstance().role2shitu.get(key);
/*    */   }
/*    */   
/*    */   public static role2ShiTuInfo get(Long key, role2ShiTuInfo value)
/*    */   {
/* 17 */     return (role2ShiTuInfo)_Tables_.getInstance().role2shitu.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, role2ShiTuInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2shitu.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2shitu.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, role2ShiTuInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2shitu.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2shitu.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, role2ShiTuInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2shitu.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, role2ShiTuInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2shitu;
/*    */   }
/*    */   
/*    */   public static role2ShiTuInfo select(Long key)
/*    */   {
/* 52 */     (role2ShiTuInfo)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public role2ShiTuInfo get(role2ShiTuInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectGraduatetimes(Long key)
/*    */   {
/* 63 */     (Integer)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Integer get(role2ShiTuInfo v)
/*    */       {
/* 67 */         return Integer.valueOf(v.getGraduatetimes());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static MasterInfo selectMasterinfo(Long key)
/*    */   {
/* 74 */     (MasterInfo)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public MasterInfo get(role2ShiTuInfo v)
/*    */       {
/* 78 */         return v.getMasterinfo().toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static ApprenticeInfo selectApprenticeinfo(Long key)
/*    */   {
/* 85 */     (ApprenticeInfo)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public ApprenticeInfo get(role2ShiTuInfo v)
/*    */       {
/* 89 */         return v.getApprenticeinfo().toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Boolean selectRefusemasterrecommend(Long key)
/*    */   {
/* 96 */     (Boolean)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Boolean get(role2ShiTuInfo v)
/*    */       {
/* :0 */         return Boolean.valueOf(v.getRefusemasterrecommend());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2shitu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */