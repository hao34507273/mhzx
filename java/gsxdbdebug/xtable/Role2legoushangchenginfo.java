/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.LeGouShangChengInfo;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2legoushangchenginfo
/*    */ {
/*    */   public static LeGouShangChengInfo get(Long key)
/*    */   {
/* 12 */     return (LeGouShangChengInfo)_Tables_.getInstance().role2legoushangchenginfo.get(key);
/*    */   }
/*    */   
/*    */   public static LeGouShangChengInfo get(Long key, LeGouShangChengInfo value)
/*    */   {
/* 17 */     return (LeGouShangChengInfo)_Tables_.getInstance().role2legoushangchenginfo.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, LeGouShangChengInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2legoushangchenginfo.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2legoushangchenginfo.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, LeGouShangChengInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2legoushangchenginfo.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2legoushangchenginfo.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, LeGouShangChengInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2legoushangchenginfo.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, LeGouShangChengInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2legoushangchenginfo;
/*    */   }
/*    */   
/*    */   public static LeGouShangChengInfo select(Long key)
/*    */   {
/* 52 */     (LeGouShangChengInfo)getTable().select(key, new TField()
/*    */     {
/*    */       public LeGouShangChengInfo get(LeGouShangChengInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, Integer> selectCfgid2buycount(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new TField()
/*    */     {
/*    */       public Map<Integer, Integer> get(LeGouShangChengInfo v)
/*    */       {
/* 67 */         return v.getCfgid2buycountAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2legoushangchenginfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */