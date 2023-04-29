/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.AllLostExpInfo;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2alllostexpinfo
/*    */ {
/*    */   public static AllLostExpInfo get(Long key)
/*    */   {
/* 12 */     return (AllLostExpInfo)_Tables_.getInstance().role2alllostexpinfo.get(key);
/*    */   }
/*    */   
/*    */   public static AllLostExpInfo get(Long key, AllLostExpInfo value)
/*    */   {
/* 17 */     return (AllLostExpInfo)_Tables_.getInstance().role2alllostexpinfo.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, AllLostExpInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2alllostexpinfo.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2alllostexpinfo.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, AllLostExpInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2alllostexpinfo.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2alllostexpinfo.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, AllLostExpInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2alllostexpinfo.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, AllLostExpInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2alllostexpinfo;
/*    */   }
/*    */   
/*    */   public static AllLostExpInfo select(Long key)
/*    */   {
/* 52 */     (AllLostExpInfo)getTable().select(key, new TField()
/*    */     {
/*    */       public AllLostExpInfo get(AllLostExpInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, xbean.LostExpInfo> selectActivityid2lostexpinfo(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new TField()
/*    */     {
/*    */       public Map<Integer, xbean.LostExpInfo> get(AllLostExpInfo v)
/*    */       {
/* 67 */         return v.getActivityid2lostexpinfoAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectLastupdatetime(Long key)
/*    */   {
/* 74 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(AllLostExpInfo v)
/*    */       {
/* 78 */         return Long.valueOf(v.getLastupdatetime());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2alllostexpinfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */