/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.BattleGrabData;
/*    */ import xbean.GrabPositionData;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Grabposition
/*    */ {
/*    */   public static BattleGrabData get(Long key)
/*    */   {
/* 12 */     return (BattleGrabData)_Tables_.getInstance().grabposition.get(key);
/*    */   }
/*    */   
/*    */   public static BattleGrabData get(Long key, BattleGrabData value)
/*    */   {
/* 17 */     return (BattleGrabData)_Tables_.getInstance().grabposition.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, BattleGrabData value)
/*    */   {
/* 22 */     _Tables_.getInstance().grabposition.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().grabposition.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, BattleGrabData value)
/*    */   {
/* 32 */     return _Tables_.getInstance().grabposition.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().grabposition.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, BattleGrabData> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().grabposition.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, BattleGrabData> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().grabposition;
/*    */   }
/*    */   
/*    */   public static BattleGrabData select(Long key)
/*    */   {
/* 52 */     (BattleGrabData)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public BattleGrabData get(BattleGrabData v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, GrabPositionData> selectPositiondatas(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, GrabPositionData> get(BattleGrabData v)
/*    */       {
/* 67 */         return v.getPositiondatasAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Grabposition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */