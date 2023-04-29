/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.MakeUpInfo;
/*    */ import xbean.MakeUpRecord;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2makeupinfo
/*    */ {
/*    */   public static MakeUpInfo get(Long key)
/*    */   {
/* 12 */     return (MakeUpInfo)_Tables_.getInstance().role2makeupinfo.get(key);
/*    */   }
/*    */   
/*    */   public static MakeUpInfo get(Long key, MakeUpInfo value)
/*    */   {
/* 17 */     return (MakeUpInfo)_Tables_.getInstance().role2makeupinfo.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, MakeUpInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2makeupinfo.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2makeupinfo.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, MakeUpInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2makeupinfo.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2makeupinfo.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, MakeUpInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2makeupinfo.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, MakeUpInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2makeupinfo;
/*    */   }
/*    */   
/*    */   public static MakeUpInfo select(Long key)
/*    */   {
/* 52 */     (MakeUpInfo)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public MakeUpInfo get(MakeUpInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, MakeUpRecord> selectActivityid2record(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, MakeUpRecord> get(MakeUpInfo v)
/*    */       {
/* 67 */         return v.getActivityid2recordAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2makeupinfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */