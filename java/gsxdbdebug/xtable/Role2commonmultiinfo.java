/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.AllMultiTaskInfo;
/*    */ import xbean.CommonMultiTaskInfo;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2commonmultiinfo
/*    */ {
/*    */   public static AllMultiTaskInfo get(Long key)
/*    */   {
/* 12 */     return (AllMultiTaskInfo)_Tables_.getInstance().role2commonmultiinfo.get(key);
/*    */   }
/*    */   
/*    */   public static AllMultiTaskInfo get(Long key, AllMultiTaskInfo value)
/*    */   {
/* 17 */     return (AllMultiTaskInfo)_Tables_.getInstance().role2commonmultiinfo.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, AllMultiTaskInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2commonmultiinfo.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2commonmultiinfo.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, AllMultiTaskInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2commonmultiinfo.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2commonmultiinfo.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, AllMultiTaskInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2commonmultiinfo.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, AllMultiTaskInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2commonmultiinfo;
/*    */   }
/*    */   
/*    */   public static AllMultiTaskInfo select(Long key)
/*    */   {
/* 52 */     (AllMultiTaskInfo)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public AllMultiTaskInfo get(AllMultiTaskInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, CommonMultiTaskInfo> selectActivity2info(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, CommonMultiTaskInfo> get(AllMultiTaskInfo v)
/*    */       {
/* 67 */         return v.getActivity2infoAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2commonmultiinfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */