/*    */ package xtable;
/*    */ 
/*    */ import xbean.XiaoHuiKuaiPaoGlobalInfo;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ import xdb.TTableCache;
/*    */ 
/*    */ public class Activityid2xiaohuikuaipaoglobalinfo
/*    */ {
/*    */   public static XiaoHuiKuaiPaoGlobalInfo get(Long key)
/*    */   {
/* 12 */     return (XiaoHuiKuaiPaoGlobalInfo)_Tables_.getInstance().activityid2xiaohuikuaipaoglobalinfo.get(key);
/*    */   }
/*    */   
/*    */   public static XiaoHuiKuaiPaoGlobalInfo get(Long key, XiaoHuiKuaiPaoGlobalInfo value)
/*    */   {
/* 17 */     return (XiaoHuiKuaiPaoGlobalInfo)_Tables_.getInstance().activityid2xiaohuikuaipaoglobalinfo.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, XiaoHuiKuaiPaoGlobalInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().activityid2xiaohuikuaipaoglobalinfo.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().activityid2xiaohuikuaipaoglobalinfo.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, XiaoHuiKuaiPaoGlobalInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().activityid2xiaohuikuaipaoglobalinfo.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().activityid2xiaohuikuaipaoglobalinfo.remove(key);
/*    */   }
/*    */   
/*    */   public static TTableCache<Long, XiaoHuiKuaiPaoGlobalInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().activityid2xiaohuikuaipaoglobalinfo.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, XiaoHuiKuaiPaoGlobalInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().activityid2xiaohuikuaipaoglobalinfo;
/*    */   }
/*    */   
/*    */   public static XiaoHuiKuaiPaoGlobalInfo select(Long key)
/*    */   {
/* 52 */     (XiaoHuiKuaiPaoGlobalInfo)getTable().select(key, new TField()
/*    */     {
/*    */       public XiaoHuiKuaiPaoGlobalInfo get(XiaoHuiKuaiPaoGlobalInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Boolean selectIsautodraw(Long key)
/*    */   {
/* 63 */     (Boolean)getTable().select(key, new TField()
/*    */     {
/*    */       public Boolean get(XiaoHuiKuaiPaoGlobalInfo v)
/*    */       {
/* 67 */         return Boolean.valueOf(v.getIsautodraw());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Activityid2xiaohuikuaipaoglobalinfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */