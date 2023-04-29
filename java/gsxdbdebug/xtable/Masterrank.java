/*    */ package xtable;
/*    */ 
/*    */ import java.util.List;
/*    */ import xbean.MasterRankInfo;
/*    */ import xbean.RoleMasterRankInfo;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Masterrank
/*    */ {
/*    */   public static MasterRankInfo get(Long key)
/*    */   {
/* 12 */     return (MasterRankInfo)_Tables_.getInstance().masterrank.get(key);
/*    */   }
/*    */   
/*    */   public static MasterRankInfo get(Long key, MasterRankInfo value)
/*    */   {
/* 17 */     return (MasterRankInfo)_Tables_.getInstance().masterrank.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, MasterRankInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().masterrank.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().masterrank.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, MasterRankInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().masterrank.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().masterrank.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, MasterRankInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().masterrank.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, MasterRankInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().masterrank;
/*    */   }
/*    */   
/*    */   public static MasterRankInfo select(Long key)
/*    */   {
/* 52 */     (MasterRankInfo)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public MasterRankInfo get(MasterRankInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static List<RoleMasterRankInfo> selectRolemasterrankdatas(Long key)
/*    */   {
/* 63 */     (List)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public List<RoleMasterRankInfo> get(MasterRankInfo v)
/*    */       {
/* 67 */         return v.getRolemasterrankdatasAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Masterrank.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */