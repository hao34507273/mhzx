/*     */ package mzm.gsp.sworn.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.sworn.SRoleSwornTitleChange;
/*     */ import mzm.gsp.title.confbean.SwornConsts;
/*     */ import mzm.gsp.title.main.TitleInterface;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import xbean.SwornMember;
/*     */ import xtable.Role2swornmember;
/*     */ 
/*     */ public class PChangeSwornTitleReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final String title;
/*     */   
/*     */   public PChangeSwornTitleReq(long _roleid, String _title)
/*     */   {
/*  23 */     this.roleid = _roleid;
/*  24 */     this.title = _title;
/*     */   }
/*     */   
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  29 */     if ((!OpenInterface.getOpenStatus(100)) || (OpenInterface.isBanPlay(this.roleid, 100)))
/*     */     {
/*  31 */       OpenInterface.sendBanPlayMsg(this.roleid, 100);
/*  32 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  36 */     if (!SwornManager.isRoleStateCanSworn(this.roleid))
/*     */     {
/*  38 */       SwornManager.logInfo("PChangeSwornTitleReq.processImp@role state can not sworn|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/*  39 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  43 */     if (!SwornManager.checkSornTitle(this.title))
/*     */     {
/*  45 */       sendResult(2);
/*  46 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  50 */     SwornMember swornMember = Role2swornmember.get(Long.valueOf(this.roleid));
/*  51 */     if (swornMember == null)
/*     */     {
/*  53 */       sendResult(1);
/*  54 */       return false;
/*     */     }
/*  56 */     long swornid = swornMember.getSwornid();
/*     */     
/*     */ 
/*  59 */     xbean.Sworn sworn = xtable.Sworn.select(Long.valueOf(swornid));
/*  60 */     if (sworn == null)
/*     */     {
/*  62 */       sendResult(1);
/*  63 */       return false;
/*     */     }
/*     */     
/*  66 */     if (!sworn.getMembers().contains(Long.valueOf(this.roleid)))
/*     */     {
/*  68 */       sendResult(1);
/*  69 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  73 */     int needGold = SwornConsts.getInstance().CHANGE_TITLE_NEED_GOLD;
/*  74 */     if (needGold > 0)
/*     */     {
/*  76 */       if (!mzm.gsp.role.main.RoleInterface.cutGold(this.roleid, needGold, new TLogArg(mzm.gsp.tlog.LogReason.SWORN_CHANG_TITLE)))
/*     */       {
/*  78 */         sendResult(3);
/*  79 */         return false;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*  84 */     swornMember.setTitle(this.title);
/*     */     
/*     */ 
/*     */ 
/*  88 */     String name1 = sworn.getName1();
/*  89 */     String name2 = sworn.getName2();
/*  90 */     String number = SwornManager.getSwornNameNumber(sworn.getMembers().size());
/*  91 */     int titleCfgId = SwornConsts.getInstance().SWORN_TITLE_CFGID;
/*  92 */     List<String> args = new ArrayList();
/*  93 */     args.add(name1);
/*  94 */     args.add(number);
/*  95 */     args.add(name2);
/*  96 */     args.add(swornMember.getTitle());
/*  97 */     TitleInterface.replaceAppellationArgsNoneRealTime(this.roleid, titleCfgId, args);
/*     */     
/*     */ 
/* 100 */     SwornManager.tlogSworn(this.roleid, swornid, SwornOperateEnum.CHANGETITLE.value, name1, name2, swornMember.getTitle(), sworn.getNewmember().size(), 0, 0);
/*     */     
/*     */ 
/*     */ 
/* 104 */     SRoleSwornTitleChange res = new SRoleSwornTitleChange(swornid, this.roleid, this.title);
/* 105 */     for (Iterator i$ = sworn.getMembers().iterator(); i$.hasNext();) { long id = ((Long)i$.next()).longValue();
/* 106 */       OnlineManager.getInstance().send(id, res);
/*     */     }
/*     */     
/* 109 */     return true;
/*     */   }
/*     */   
/*     */   private void sendResult(int result)
/*     */   {
/* 114 */     OnlineManager.getInstance().sendAtOnce(this.roleid, new mzm.gsp.sworn.SChangeSwornTitleFailRes(result));
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\sworn\main\PChangeSwornTitleReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */