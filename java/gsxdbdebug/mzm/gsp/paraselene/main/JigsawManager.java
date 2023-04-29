/*     */ package mzm.gsp.paraselene.main;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.paraselene.SJigsawFinishRes;
/*     */ import mzm.gsp.paraselene.SJigsawStateRes;
/*     */ import mzm.gsp.paraselene.SStartJigsawRes;
/*     */ import mzm.gsp.paraselene.confbean.SJigsawCfg;
/*     */ import mzm.gsp.paraselene.event.JigsawContext;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.JigsawInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Jigsawinfo;
/*     */ import xtable.Role2jigsaw;
/*     */ 
/*     */ public class JigsawManager
/*     */ {
/*  24 */   static final Logger logger = Logger.getLogger("Jigsaw");
/*  25 */   private static int WAN = 10000;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void startJigsaw(List<Long> roleids, final int jigsawcfgid, final JigsawContext context)
/*     */   {
/*  37 */     SJigsawCfg jigsawCfg = SJigsawCfg.get(jigsawcfgid);
/*  38 */     if (jigsawCfg == null)
/*     */     {
/*  40 */       String logstr = String.format("[jigsaw]JigsawManager.startJigsaw@jigsaw cfgid error!|jigsawcfgid=%d|roleids=%s", new Object[] { Integer.valueOf(jigsawcfgid), roleids.toString() });
/*  41 */       logger.error(logstr);
/*  42 */       return;
/*     */     }
/*  44 */     long now = DateTimeUtils.getCurrTimeInMillis();
/*  45 */     final long delay = TimeUnit.SECONDS.toMillis(1L);
/*  46 */     long limittime = TimeUnit.SECONDS.toMillis(jigsawCfg.limittime);
/*  47 */     long clientendtime = now + limittime;
/*  48 */     final long endtime = now + limittime + delay;
/*  49 */     new LogicProcedure()
/*     */     {
/*     */ 
/*     */       protected boolean processImp()
/*     */         throws Exception
/*     */       {
/*  55 */         Lockeys.lock(xtable.Role2properties.getTable(), this.val$roleids);
/*  56 */         if ((this.val$roleids == null) || (this.val$roleids.size() == 0))
/*     */         {
/*  58 */           return false;
/*     */         }
/*  60 */         for (Iterator i$ = this.val$roleids.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*     */           
/*  62 */           if (JigsawManager.isInJigsaw(roleid))
/*     */           {
/*     */ 
/*  65 */             JigsawManager.sendJigsawRes(roleid, 5);
/*  66 */             String logstr = String.format("[jigsaw]JigsawManager.startJigsaw@role already in jigsaw state!|jigsawcfgid=%d|roleid=%d", new Object[] { Integer.valueOf(jigsawcfgid), Long.valueOf(roleid) });
/*     */             
/*     */ 
/*  69 */             JigsawManager.logger.info(logstr);
/*  70 */             return false;
/*     */           }
/*     */         }
/*     */         
/*  74 */         JigsawInfo jigsawInfo = xbean.Pod.newJigsawInfo();
/*  75 */         jigsawInfo.setCfgid(jigsawcfgid);
/*  76 */         jigsawInfo.setContext(context);
/*  77 */         jigsawInfo.setEndtime(endtime);
/*  78 */         jigsawInfo.getAllroleids().addAll(this.val$roleids);
/*  79 */         long jigsawid = Jigsawinfo.insert(jigsawInfo).longValue();
/*  80 */         new JigsawObserver(TimeUnit.MILLISECONDS.toSeconds(delay + this.val$delay), jigsawid);
/*  81 */         for (Iterator i$ = this.val$roleids.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*     */           
/*     */ 
/*  84 */           Role2jigsaw.insert(Long.valueOf(roleid), Long.valueOf(jigsawid));
/*     */           
/*  86 */           SStartJigsawRes res = new SStartJigsawRes();
/*  87 */           res.endtime = TimeUnit.MILLISECONDS.toSeconds(this.val$clientendtime);
/*  88 */           OnlineManager.getInstance().send(roleid, res);
/*     */         }
/*  90 */         return true;
/*     */       }
/*     */     }.execute();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   static void stopJigsaw(long roleid, boolean issuccess)
/*     */   {
/*  99 */     new LogicProcedure()
/*     */     {
/*     */ 
/*     */       protected boolean processImp()
/*     */         throws Exception
/*     */       {
/* 105 */         Long jigid = Role2jigsaw.select(Long.valueOf(this.val$roleid));
/* 106 */         if (jigid == null)
/*     */         {
/* 108 */           return false;
/*     */         }
/* 110 */         List<Long> roleList = Jigsawinfo.selectAllroleids(jigid);
/* 111 */         Lockeys.lock(Role2jigsaw.getTable(), roleList);
/* 112 */         JigsawInfo jigsawInfo = Jigsawinfo.get(jigid);
/* 113 */         if (this.val$issuccess)
/*     */         {
/* 115 */           jigsawInfo.getSucroleids().clear();
/* 116 */           jigsawInfo.getSucroleids().addAll(jigsawInfo.getAllroleids());
/* 117 */           jigsawInfo.getFailroleids().clear();
/*     */         }
/*     */         else
/*     */         {
/* 121 */           jigsawInfo.getFailroleids().clear();
/* 122 */           jigsawInfo.getFailroleids().addAll(jigsawInfo.getAllroleids());
/* 123 */           jigsawInfo.getSucroleids().clear();
/*     */         }
/* 125 */         JigsawManager.triggerEvent(jigsawInfo.getSucroleids(), jigsawInfo.getFailroleids(), jigsawInfo.getAllroleids(), jigsawInfo.getCfgid(), jigsawInfo.getContext());
/*     */         
/*     */ 
/* 128 */         for (Iterator i$ = roleList.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/*     */           
/* 130 */           Role2jigsaw.remove(Long.valueOf(r));
/*     */         }
/* 132 */         Jigsawinfo.remove(jigid);
/* 133 */         return true;
/*     */       }
/*     */     }.execute();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void triggerEvent(List<Long> sucroleids, List<Long> failedroleids, List<Long> allroleids, int jigsawcfgid, JigsawContext context)
/*     */   {
/* 147 */     boolean ispassed = isPassed(jigsawcfgid, sucroleids.size(), allroleids.size());
/* 148 */     TriggerEventsManger.getInstance().triggerEvent(new mzm.gsp.paraselene.event.JigsawFinish(), new mzm.gsp.paraselene.event.JigsawFinishArg(sucroleids, failedroleids, ispassed, jigsawcfgid, context));
/*     */     
/* 150 */     sendJigsawFinishRes(allroleids);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isPassed(int jigcfgid, int sucnum, int totalnum)
/*     */   {
/* 163 */     SJigsawCfg jigsawCfg = SJigsawCfg.get(jigcfgid);
/* 164 */     if (jigsawCfg == null)
/*     */     {
/* 166 */       String logstr = String.format("[jigsaw]JigsawManager.isPassed@jigsaw cfgid error!|jigcfgid=%d", new Object[] { Integer.valueOf(jigcfgid) });
/* 167 */       logger.error(logstr);
/* 168 */       return false;
/*     */     }
/* 170 */     int rate = (int)(sucnum * 1.0F / totalnum * WAN);
/* 171 */     return rate >= jigsawCfg.sucrate;
/*     */   }
/*     */   
/*     */   static void removeAllJigsawRoles(List<Long> roleids)
/*     */   {
/* 176 */     for (Iterator i$ = roleids.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/*     */       
/* 178 */       NoneRealTimeTaskManager.getInstance().addTask(new LogicProcedure()
/*     */       {
/*     */ 
/*     */         protected boolean processImp()
/*     */           throws Exception
/*     */         {
/* 184 */           return Role2jigsaw.remove(Long.valueOf(this.val$r));
/*     */         }
/*     */       });
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isInJigsaw(long roleid)
/*     */   {
/* 199 */     return Role2jigsaw.select(Long.valueOf(roleid)) != null;
/*     */   }
/*     */   
/*     */   static void sendJigsawRes(long roleid, int rescode)
/*     */   {
/* 204 */     SJigsawStateRes res = new SJigsawStateRes();
/* 205 */     res.rescode = rescode;
/*     */     
/* 207 */     OnlineManager.getInstance().sendAtOnce(roleid, res);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void sendJigsawFinishRes(List<Long> roleids)
/*     */   {
/* 218 */     SJigsawFinishRes res = new SJigsawFinishRes();
/*     */     
/* 220 */     for (Iterator i$ = roleids.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*     */       
/* 222 */       OnlineManager.getInstance().sendAtOnce(roleid, res);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\paraselene\main\JigsawManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */