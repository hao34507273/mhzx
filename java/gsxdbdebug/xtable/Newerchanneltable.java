/*    */ package xtable;
/*    */ 
/*    */ import java.util.List;
/*    */ import xbean.NewerChannel;
/*    */ import xbean.NewerChannels;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Newerchanneltable
/*    */ {
/*    */   public static NewerChannels get(Long key)
/*    */   {
/* 12 */     return (NewerChannels)_Tables_.getInstance().newerchanneltable.get(key);
/*    */   }
/*    */   
/*    */   public static NewerChannels get(Long key, NewerChannels value)
/*    */   {
/* 17 */     return (NewerChannels)_Tables_.getInstance().newerchanneltable.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, NewerChannels value)
/*    */   {
/* 22 */     _Tables_.getInstance().newerchanneltable.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().newerchanneltable.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, NewerChannels value)
/*    */   {
/* 32 */     return _Tables_.getInstance().newerchanneltable.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().newerchanneltable.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, NewerChannels> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().newerchanneltable.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, NewerChannels> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().newerchanneltable;
/*    */   }
/*    */   
/*    */   public static NewerChannels select(Long key)
/*    */   {
/* 52 */     (NewerChannels)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public NewerChannels get(NewerChannels v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static List<NewerChannel> selectNewerchannels(Long key)
/*    */   {
/* 63 */     (List)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public List<NewerChannel> get(NewerChannels v)
/*    */       {
/* 67 */         return v.getNewerchannelsAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Newerchanneltable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */