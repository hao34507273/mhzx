/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.gang.confbean.SGangDutyCfg;
/*    */ import mzm.gsp.gang.confbean.SGangMailCfg;
/*    */ import mzm.gsp.mail.main.MailInterface;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import mzm.gsp.util.LogicRunnable;
/*    */ import xbean.Gang;
/*    */ import xtable.Role2gangmember;
/*    */ 
/*    */ 
/*    */ class RGangMail
/*    */   extends LogicRunnable
/*    */ {
/*    */   private final long gangid;
/*    */   private final int gangMailCfgid;
/*    */   private final List<String> contentArgList;
/*    */   private final List<String> titleArgList;
/*    */   private final TLogArg tlogArg;
/*    */   
/*    */   RGangMail(long gangid, int gangMailCfgid, List<String> contentArgList, List<String> titleArgList, TLogArg tlogArg)
/*    */   {
/* 27 */     this.gangid = gangid;
/* 28 */     this.gangMailCfgid = gangMailCfgid;
/* 29 */     this.contentArgList = contentArgList;
/* 30 */     this.titleArgList = titleArgList;
/* 31 */     this.tlogArg = tlogArg;
/*    */   }
/*    */   
/*    */   public void process()
/*    */     throws Exception
/*    */   {
/* 37 */     Gang xGang = GangManager.getXGang(this.gangid, false);
/* 38 */     if (xGang == null) {
/* 39 */       return;
/*    */     }
/* 41 */     SGangMailCfg mailCfg = SGangMailCfg.get(this.gangMailCfgid);
/* 42 */     if (mailCfg == null) {
/* 43 */       GangManager.logError("RGangMail.process@invalid mailcfgid@gangid=%d|mailcfgid=%d", new Object[] { Long.valueOf(this.gangid), Integer.valueOf(this.gangMailCfgid) });
/*    */       
/*    */ 
/* 46 */       return;
/*    */     }
/* 48 */     for (Iterator i$ = GangManager.getMembers(xGang).iterator(); i$.hasNext();) { final long roleid = ((Long)i$.next()).longValue();
/* 49 */       Integer duty = Role2gangmember.selectDuty(Long.valueOf(roleid));
/* 50 */       if (duty != null)
/*    */       {
/*    */ 
/* 53 */         SGangDutyCfg dutyCfg = SGangDutyCfg.get(duty.intValue());
/* 54 */         if ((dutyCfg != null) && 
/*    */         
/*    */ 
/* 57 */           (mailCfg.dutyMinLevel <= dutyCfg.dutyLevel) && (mailCfg.dutyMaxLevel >= dutyCfg.dutyLevel))
/*    */         {
/*    */ 
/*    */ 
/*    */ 
/* 62 */           new LogicProcedure()
/*    */           {
/*    */             protected boolean processImp()
/*    */               throws Exception
/*    */             {
/* 67 */               MailInterface.synBuildAndSendMail(roleid, this.val$mailCfg.mailId, RGangMail.this.titleArgList, RGangMail.this.contentArgList, RGangMail.this.tlogArg);
/*    */               
/* 69 */               return true;
/*    */             }
/*    */           }.call();
/*    */         }
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\RGangMail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */