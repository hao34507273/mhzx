/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.IndianaInfo;
/*    */ import xbean.IndianaTurnInfo;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Indiana_infos
/*    */ {
/*    */   public static IndianaInfo get(Long key)
/*    */   {
/* 12 */     return (IndianaInfo)_Tables_.getInstance().indiana_infos.get(key);
/*    */   }
/*    */   
/*    */   public static IndianaInfo get(Long key, IndianaInfo value)
/*    */   {
/* 17 */     return (IndianaInfo)_Tables_.getInstance().indiana_infos.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, IndianaInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().indiana_infos.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().indiana_infos.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, IndianaInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().indiana_infos.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().indiana_infos.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, IndianaInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().indiana_infos.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, IndianaInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().indiana_infos;
/*    */   }
/*    */   
/*    */   public static IndianaInfo select(Long key)
/*    */   {
/* 52 */     (IndianaInfo)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public IndianaInfo get(IndianaInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, IndianaTurnInfo> selectTurn_infos(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, IndianaTurnInfo> get(IndianaInfo v)
/*    */       {
/* 67 */         return v.getTurn_infosAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Indiana_infos.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */