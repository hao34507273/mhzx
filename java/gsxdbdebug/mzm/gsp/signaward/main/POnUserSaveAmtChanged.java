/*     */ package mzm.gsp.signaward.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.TreeMap;
/*     */ import mzm.gsp.qingfu.event.SaveAmtChangedArg;
/*     */ import mzm.gsp.qingfu.event.SaveAmtChangedProcedure;
/*     */ import mzm.gsp.signaward.confbean.SCashSigncountCfg;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Sign;
/*     */ import xtable.Role2sign;
/*     */ 
/*     */ public class POnUserSaveAmtChanged extends SaveAmtChangedProcedure
/*     */ {
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  20 */     int k = -1;
/*  21 */     Map<Integer, SCashSigncountCfg> map = SCashSigncountCfg.getAll();
/*  22 */     if ((map instanceof TreeMap))
/*     */     {
/*  24 */       TreeMap<Integer, SCashSigncountCfg> treeMap = (TreeMap)map;
/*  25 */       Integer k1 = (Integer)treeMap.floorKey(Integer.valueOf((int)((SaveAmtChangedArg)this.arg).oldSaveAmt));
/*  26 */       Integer k2 = (Integer)treeMap.floorKey(Integer.valueOf((int)((SaveAmtChangedArg)this.arg).currSaveAmt));
/*     */       
/*  28 */       if (k1 == null)
/*     */       {
/*  30 */         k1 = Integer.valueOf(0);
/*     */       }
/*     */       
/*  33 */       if (k2 == null)
/*     */       {
/*  35 */         return false;
/*     */       }
/*     */       
/*     */ 
/*  39 */       if (k2.intValue() > k1.intValue())
/*     */       {
/*  41 */         k = k2.intValue();
/*     */       }
/*     */       else
/*     */       {
/*  45 */         return false;
/*     */       }
/*     */       
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/*  52 */       List<Integer> cashcounts = new ArrayList(map.keySet());
/*  53 */       java.util.Collections.sort(cashcounts);
/*     */       
/*  55 */       for (int i = 0; i < cashcounts.size(); i++)
/*     */       {
/*  57 */         int yuanbaonum = ((Integer)cashcounts.get(i)).intValue();
/*  58 */         if (yuanbaonum > ((SaveAmtChangedArg)this.arg).currSaveAmt) {
/*     */           break;
/*     */         }
/*     */         
/*  62 */         if ((((SaveAmtChangedArg)this.arg).oldSaveAmt < yuanbaonum) && (yuanbaonum <= ((SaveAmtChangedArg)this.arg).currSaveAmt))
/*     */         {
/*  64 */           k = yuanbaonum;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*  70 */     if (k == -1)
/*     */     {
/*  72 */       return false;
/*     */     }
/*     */     
/*  75 */     xbean.User xUser = xtable.User.get(((SaveAmtChangedArg)this.arg).userid);
/*  76 */     if (xUser == null)
/*     */     {
/*  78 */       return false;
/*     */     }
/*  80 */     xdb.Lockeys.lock(xtable.Role2properties.getTable(), xUser.getRoleids());
/*  81 */     int signcount = SCashSigncountCfg.get(k).signcount;
/*     */     
/*  83 */     long now = DateTimeUtils.getCurrTimeInMillis();
/*  84 */     for (Iterator i$ = xUser.getRoleids().iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*     */       
/*  86 */       Sign xSign = Role2sign.get(Long.valueOf(roleid));
/*  87 */       if (xSign == null)
/*     */       {
/*  89 */         xSign = xbean.Pod.newSign();
/*  90 */         Role2sign.insert(Long.valueOf(roleid), xSign);
/*     */       }
/*  92 */       int delta = signcount - xSign.getAwardedfillincount();
/*  93 */       if (delta > 0)
/*     */       {
/*  95 */         xSign.setFillincount(xSign.getFillincount() + delta);
/*     */       }
/*     */       
/*  98 */       xSign.setAwardedfillincount(signcount);
/*  99 */       SignAwardManager.sendSSignInRes(roleid, xSign, now, 0, 0);
/*     */       
/* 101 */       String logstr = String.format("[sign]POnUserSaveAmtChanged.processImp@role add sign count|userid=%s|roleid=%d|addnum=%d|currSaveAmt=%d|oldSaveAmt=%d", new Object[] { ((SaveAmtChangedArg)this.arg).userid, Long.valueOf(roleid), Integer.valueOf(delta), Long.valueOf(((SaveAmtChangedArg)this.arg).currSaveAmt), Long.valueOf(((SaveAmtChangedArg)this.arg).oldSaveAmt) });
/*     */       
/*     */ 
/* 104 */       SignAwardManager.logger.info(logstr);
/*     */     }
/*     */     
/* 107 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\signaward\main\POnUserSaveAmtChanged.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */