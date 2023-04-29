/*    */ package mzm.gsp.online.main;
/*    */ 
/*    */ import gnet.link.Kick;
/*    */ import gnet.link.Link;
/*    */ import gnet.link.Onlines;
/*    */ import java.util.HashMap;
/*    */ import java.util.HashSet;
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.util.LogicRunnable;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ 
/*    */ public class ClearLoginExctuteUser extends LogicRunnable
/*    */ {
/* 17 */   private Map<String, Map<Integer, Set<Integer>>> loginUserMap = new HashMap();
/*    */   
/*    */   public ClearLoginExctuteUser(Map<String, Map<Integer, Set<Integer>>> loginUserMap) {
/* 20 */     this.loginUserMap = loginUserMap;
/*    */   }
/*    */   
/*    */   public void process() throws Exception
/*    */   {
/* 25 */     for (Map.Entry<String, Map<Integer, Set<Integer>>> entry : this.loginUserMap.entrySet()) {
/* 26 */       final String userid = (String)entry.getKey();
/* 27 */       final Map<Integer, Set<Integer>> linksidTolinkid = new HashMap();
/* 28 */       NoneRealTimeTaskManager.getInstance().addTask(new LogicRunnable()
/*    */       {
/*    */         public void process() throws Exception
/*    */         {
/* 32 */           gnet.link.Role role = Onlines.getInstance().find(userid);
/* 33 */           Iterator i$; if (role == null) {
/* 34 */             for (i$ = linksidTolinkid.entrySet().iterator(); i$.hasNext();) { entry = (Map.Entry)i$.next();
/* 35 */               Set<Integer> linkids = (Set)entry.getValue();
/* 36 */               for (i$ = linkids.iterator(); i$.hasNext();) { int linkid = ((Integer)i$.next()).intValue();
/* 37 */                 Link link = Onlines.getInstance().find(linkid);
/* 38 */                 if (link != null) {
/* 39 */                   int linksid = ((Integer)entry.getKey()).intValue();
/* 40 */                   Kick kick = new Kick();
/* 41 */                   kick.action = 1;
/* 42 */                   kick.error = 2054;
/* 43 */                   kick.linksid = linksid;
/* 44 */                   HashSet<Integer> set = new HashSet();
/* 45 */                   set.add(Integer.valueOf(linksid));
/* 46 */                   Onlines.getInstance().send(link, set, kick);
/*    */                 }
/*    */               }
/*    */             }
/*    */           }
/*    */           Map.Entry<Integer, Set<Integer>> entry;
/*    */           Iterator i$;
/*    */         }
/*    */       });
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\online\main\ClearLoginExctuteUser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */