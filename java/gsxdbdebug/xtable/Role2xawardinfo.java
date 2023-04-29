/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.XAwardContent;
/*    */ import xbean.XAwardInfo;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2xawardinfo
/*    */ {
/*    */   public static XAwardInfo get(Long key)
/*    */   {
/* 12 */     return (XAwardInfo)_Tables_.getInstance().role2xawardinfo.get(key);
/*    */   }
/*    */   
/*    */   public static XAwardInfo get(Long key, XAwardInfo value)
/*    */   {
/* 17 */     return (XAwardInfo)_Tables_.getInstance().role2xawardinfo.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, XAwardInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2xawardinfo.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2xawardinfo.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, XAwardInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2xawardinfo.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2xawardinfo.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, XAwardInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2xawardinfo.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, XAwardInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2xawardinfo;
/*    */   }
/*    */   
/*    */   public static XAwardInfo select(Long key)
/*    */   {
/* 52 */     (XAwardInfo)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public XAwardInfo get(XAwardInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, XAwardContent> selectType2awardcontent(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, XAwardContent> get(XAwardInfo v)
/*    */       {
/* 67 */         return v.getType2awardcontentAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, xbean.XAwardData> selectType2awarddata(Long key)
/*    */   {
/* 74 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, xbean.XAwardData> get(XAwardInfo v)
/*    */       {
/* 78 */         return v.getType2awarddataAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2xawardinfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */