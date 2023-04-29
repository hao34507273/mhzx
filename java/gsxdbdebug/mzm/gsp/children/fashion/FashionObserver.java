/*     */ package mzm.gsp.children.fashion;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.children.SUndressFashionSuccess;
/*     */ import mzm.gsp.children.confbean.SFashionCfg;
/*     */ import mzm.gsp.children.event.ChildUndressFashionArg;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.timer.main.Observer;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.ChildFashionInfo;
/*     */ import xbean.ChildInfo;
/*     */ import xbean.DressedInfo;
/*     */ import xbean.FashionInfo;
/*     */ import xbean.Role2ChildrenInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ import xtable.Children;
/*     */ import xtable.Role2children;
/*     */ import xtable.User;
/*     */ 
/*     */ public class FashionObserver extends Observer
/*     */ {
/*     */   private final long roleid;
/*     */   private final int fashionCfgid;
/*     */   
/*     */   public FashionObserver(long roleid, int fashionCfgid, long intervalSeconds)
/*     */   {
/*  34 */     super(intervalSeconds);
/*     */     
/*  36 */     this.roleid = roleid;
/*  37 */     this.fashionCfgid = fashionCfgid;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean update()
/*     */   {
/*  43 */     new PFashionExpire(this.roleid, this.fashionCfgid).execute();
/*     */     
/*  45 */     return false;
/*     */   }
/*     */   
/*     */   private static class PFashionExpire extends mzm.gsp.util.LogicProcedure
/*     */   {
/*     */     private final long roleid;
/*     */     private final int fashionCfgid;
/*     */     
/*     */     public PFashionExpire(long roleid, int fashionCfgid)
/*     */     {
/*  55 */       this.roleid = roleid;
/*  56 */       this.fashionCfgid = fashionCfgid;
/*     */     }
/*     */     
/*     */ 
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  63 */       if (!FashionManager.isFunOpen(this.roleid))
/*     */       {
/*  65 */         return false;
/*     */       }
/*     */       
/*  68 */       SFashionCfg fashionCfg = SFashionCfg.get(this.fashionCfgid);
/*  69 */       if (fashionCfg == null)
/*     */       {
/*  71 */         GameServer.logger().error(String.format("[childfashion]PFashionExpire.processImp@fashion cfg is null|roleid=%d|fashion_cfgid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.fashionCfgid) }));
/*     */         
/*     */ 
/*  74 */         return false;
/*     */       }
/*     */       
/*     */ 
/*  78 */       String userid = RoleInterface.getUserId(this.roleid);
/*  79 */       long marriedRoleid = mzm.gsp.marriage.main.MarriageInterface.getMarriedRoleid(this.roleid, false);
/*  80 */       if (marriedRoleid > 0L)
/*     */       {
/*  82 */         String marriedUserid = RoleInterface.getUserId(marriedRoleid);
/*  83 */         lock(User.getTable(), Arrays.asList(new String[] { userid, marriedUserid }));
/*  84 */         lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid), Long.valueOf(marriedRoleid) }));
/*     */       }
/*     */       else
/*     */       {
/*  88 */         lock(Lockeys.get(User.getTable(), userid));
/*  89 */         lock(Lockeys.get(Basic.getTable(), Long.valueOf(this.roleid)));
/*     */       }
/*     */       
/*  92 */       List<Long> childIdList = new ArrayList();
/*  93 */       Role2ChildrenInfo xRole2ChildrenInfo = Role2children.get(Long.valueOf(this.roleid));
/*  94 */       if (xRole2ChildrenInfo != null)
/*     */       {
/*  96 */         childIdList.addAll(xRole2ChildrenInfo.getChild_id_list());
/*     */       }
/*  98 */       if (marriedRoleid > 0L)
/*     */       {
/* 100 */         Role2ChildrenInfo xMarriedChildrenInfo = Role2children.get(Long.valueOf(marriedRoleid));
/* 101 */         if (xMarriedChildrenInfo != null)
/*     */         {
/* 103 */           childIdList.addAll(xMarriedChildrenInfo.getChild_id_list());
/*     */         }
/*     */       }
/* 106 */       if (childIdList.isEmpty())
/*     */       {
/* 108 */         return false;
/*     */       }
/* 110 */       Lockeys.lock(Children.getTable(), childIdList);
/*     */       
/*     */ 
/* 113 */       ChildFashionInfo xChildFashionInfo = xRole2ChildrenInfo.getFashion_info();
/* 114 */       FashionInfo xFashionInfo = (FashionInfo)xChildFashionInfo.getFashions().remove(Integer.valueOf(this.fashionCfgid));
/* 115 */       if (xFashionInfo == null)
/*     */       {
/* 117 */         GameServer.logger().error(String.format("[childfashion]PFashionExpire.processImp@xbean is null|roleid=%d|fashion_cfgid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.fashionCfgid) }));
/*     */         
/*     */ 
/* 120 */         return false;
/*     */       }
/* 122 */       int duration = fashionCfg.duration;
/* 123 */       if (duration <= 0)
/*     */       {
/* 125 */         GameServer.logger().error(String.format("[childfashion]PFashionExpire.processImp@duration <= 0|roleid=%d|fashion_cfgid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.fashionCfgid) }));
/*     */         
/*     */ 
/* 128 */         return false;
/*     */       }
/* 130 */       long now = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/* 131 */       long startTime = xFashionInfo.getStart_time();
/* 132 */       long delay = TimeUnit.MILLISECONDS.toSeconds(TimeUnit.HOURS.toMillis(duration) + startTime - now);
/* 133 */       if (delay > 0L)
/*     */       {
/* 135 */         GameServer.logger().error(String.format("[childfashion]PFashionExpire.processImp@delay > 0|roleid=%d|fashion_cfgid=%d|start_time=%d|delay=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.fashionCfgid), Long.valueOf(startTime), Long.valueOf(delay) }));
/*     */         
/*     */ 
/*     */ 
/* 139 */         return false;
/*     */       }
/*     */       
/*     */ 
/* 143 */       int phase = fashionCfg.phase;
/* 144 */       List<Long> relateChildids = new ArrayList();
/* 145 */       if (xRole2ChildrenInfo != null)
/*     */       {
/* 147 */         relateChildids.addAll(handleRelateChilds(this.roleid, phase));
/*     */       }
/* 149 */       if (marriedRoleid > 0L)
/*     */       {
/* 151 */         relateChildids.addAll(handleRelateChilds(marriedRoleid, phase));
/*     */       }
/*     */       
/*     */ 
/* 155 */       FashionManager.removeFashionObserver(this.roleid, this.fashionCfgid);
/*     */       
/*     */ 
/* 158 */       FashionManager.syncRemoveFashionInfo(this.roleid, this.fashionCfgid);
/*     */       SUndressFashionSuccess resp;
/*     */       Iterator i$;
/* 161 */       if (!relateChildids.isEmpty())
/*     */       {
/* 163 */         resp = new SUndressFashionSuccess();
/* 164 */         resp.fashion_cfgid = this.fashionCfgid;
/* 165 */         for (i$ = relateChildids.iterator(); i$.hasNext();) { long childid = ((Long)i$.next()).longValue();
/*     */           
/* 167 */           resp.childid = childid;
/* 168 */           FashionManager.sendProtocol(this.roleid, marriedRoleid, resp);
/*     */         }
/*     */       }
/*     */       
/*     */ 
/* 173 */       addTlog(userid);
/*     */       
/* 175 */       GameServer.logger().info(String.format("[childfashion]PFashionExpire.processImp@handle fashion expire success|roleid=%d|fashion_cfgid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.fashionCfgid) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 180 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     private List<Long> handleRelateChilds(long roleid, int phase)
/*     */     {
/* 192 */       Role2ChildrenInfo xRole2ChildrenInfo = Role2children.get(Long.valueOf(roleid));
/* 193 */       if (xRole2ChildrenInfo == null)
/*     */       {
/* 195 */         return java.util.Collections.emptyList();
/*     */       }
/*     */       
/* 198 */       List<Long> childids = xRole2ChildrenInfo.getChild_id_list();
/* 199 */       if (childids.isEmpty())
/*     */       {
/* 201 */         return java.util.Collections.emptyList();
/*     */       }
/*     */       
/* 204 */       List<Long> result = new ArrayList();
/*     */       
/* 206 */       long showChildid = xRole2ChildrenInfo.getShow_child_id();
/* 207 */       int showPhase = xRole2ChildrenInfo.getShow_child_period();
/* 208 */       for (Iterator i$ = childids.iterator(); i$.hasNext();) { long childid = ((Long)i$.next()).longValue();
/*     */         
/* 210 */         ChildInfo xChildInfo = Children.get(Long.valueOf(childid));
/* 211 */         if (xChildInfo != null)
/*     */         {
/*     */ 
/*     */ 
/* 215 */           DressedInfo xDressedInfo = (DressedInfo)xChildInfo.getDressed().get(Integer.valueOf(phase));
/* 216 */           if (xDressedInfo != null)
/*     */           {
/*     */ 
/*     */ 
/* 220 */             if ((xDressedInfo.getOwner_roleid() == this.roleid) && (xDressedInfo.getFashion_cfgid() == this.fashionCfgid))
/*     */             {
/* 222 */               result.add(Long.valueOf(childid));
/*     */               
/*     */ 
/* 225 */               xChildInfo.getDressed().remove(Integer.valueOf(phase));
/*     */               
/*     */ 
/* 228 */               ChildUndressFashionArg eventArg = new ChildUndressFashionArg(xChildInfo.getOwn_role_id(), childid, this.fashionCfgid);
/*     */               
/* 230 */               mzm.gsp.children.main.ChildrenManager.trigChildrenEvent(new mzm.gsp.children.event.ChildUndressFashion(), eventArg);
/* 231 */               if ((showChildid == childid) && (showPhase == phase))
/*     */               {
/* 233 */                 mzm.gsp.children.main.ChildrenManager.trigChildrenEvent(new mzm.gsp.children.event.ChildShowModelChange(), new mzm.gsp.children.event.ChildShowModelChangeArg(roleid, mzm.gsp.children.event.ChildShowModelChangeReason.FASHION_REMOVE)); }
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/* 238 */       return result;
/*     */     }
/*     */     
/*     */     private void addTlog(String userid)
/*     */     {
/* 243 */       String vGameIp = mzm.gsp.GameServerInfoManager.getHostIP();
/* 244 */       int roleLevel = RoleInterface.getLevel(this.roleid);
/*     */       
/* 246 */       mzm.gsp.tlog.TLogManager.getInstance().addLog(userid, "ChildFashionExpireForServer", new Object[] { vGameIp, userid, Long.valueOf(this.roleid), Integer.valueOf(roleLevel), Integer.valueOf(this.fashionCfgid) });
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\fashion\FashionObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */