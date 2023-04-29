/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.Iterator;
/*    */ import java.util.LinkedList;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.item.main.ItemInterface;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ 
/*    */ public class Cmd_offersystemaward extends CmdBase
/*    */ {
/* 17 */   private ArrayList<Integer> arg = new ArrayList();
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean parse()
/*    */   {
/* 28 */     if (this.m_arguments == null) {
/* 29 */       return false;
/*    */     }
/* 31 */     int index = 0;
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 36 */     while (index < this.m_arguments.size())
/*    */     {
/*    */ 
/* 39 */       if (index >= this.m_arguments.size()) {
/* 40 */         return false;
/*    */       }
/* 42 */       Integer I_arg = parseInt((String)this.m_arguments.get(index++));
/* 43 */       if (I_arg == null) {
/* 44 */         return false;
/*    */       }
/* 46 */       this.arg.add(I_arg);
/*    */     }
/*    */     
/* 49 */     if (index != this.m_arguments.size()) {
/* 50 */       return false;
/*    */     }
/* 52 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean fillData()
/*    */   {
/* 61 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   protected void run()
/*    */   {
/* 67 */     long starttime = DateTimeUtils.getCurrTimeInMillis();
/* 68 */     long endtime = starttime + 259200000L;
/*    */     
/* 70 */     Map<Integer, Integer> itemid2count = new HashMap();
/* 71 */     for (int i = 0; i < this.arg.size(); i += 2) {
/* 72 */       itemid2count.put(this.arg.get(i), this.arg.get(i + 1));
/*    */     }
/* 74 */     Map<Integer, String> contentMap = new HashMap();
/* 75 */     contentMap.put(Integer.valueOf(1000), "梦幻诛仙手游GM奖励");
/* 76 */     contentMap.put(Integer.valueOf(1001), "来自梦幻诛仙手游的GM奖励");
/* 77 */     Map<Integer, Integer> type2value = new HashMap();
/* 78 */     type2value.put(Integer.valueOf(998), Integer.valueOf(LogReason.GM_ADD.value));
/* 79 */     type2value.put(Integer.valueOf(999), Integer.valueOf(LogReason.GM_ADD.value));
/* 80 */     ItemInterface.addSystemAward(itemid2count, starttime, endtime, type2value, contentMap);
/*    */     
/* 82 */     for (Iterator i$ = OnlineManager.getInstance().getAllRolesInWorld().iterator(); i$.hasNext();) { final long roleid = ((Long)i$.next()).longValue();
/* 83 */       NoneRealTimeTaskManager.getInstance().addTask(new LogicProcedure()
/*    */       {
/*    */         protected boolean processImp() throws Exception {
/* 86 */           return ItemInterface.offerSystemAwards(roleid);
/*    */         }
/*    */       });
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_offersystemaward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */