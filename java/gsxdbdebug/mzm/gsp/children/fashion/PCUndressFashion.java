/*     */ package mzm.gsp.children.fashion;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.children.SUndressFashionFailed;
/*     */ import mzm.gsp.children.SUndressFashionSuccess;
/*     */ import mzm.gsp.children.childhood.ChildhoodManager;
/*     */ import mzm.gsp.children.confbean.SFashionCfg;
/*     */ import mzm.gsp.children.event.ChildShowModelChange;
/*     */ import mzm.gsp.children.event.ChildShowModelChangeArg;
/*     */ import mzm.gsp.children.event.ChildShowModelChangeReason;
/*     */ import mzm.gsp.children.event.ChildUndressFashion;
/*     */ import mzm.gsp.children.event.ChildUndressFashionArg;
/*     */ import mzm.gsp.children.main.ChildrenManager;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.ChildInfo;
/*     */ import xbean.DressedInfo;
/*     */ import xbean.Role2ChildrenInfo;
/*     */ import xtable.Basic;
/*     */ import xtable.Role2children;
/*     */ 
/*     */ public class PCUndressFashion extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final long childid;
/*     */   private final int fashionCfgid;
/*     */   
/*     */   public PCUndressFashion(long roleid, long childid, int fashionCfgid)
/*     */   {
/*  36 */     this.roleid = roleid;
/*  37 */     this.childid = childid;
/*  38 */     this.fashionCfgid = fashionCfgid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  44 */     if ((this.fashionCfgid <= 0) || (this.childid <= 0L))
/*     */     {
/*  46 */       return false;
/*     */     }
/*     */     
/*  49 */     if (!FashionManager.isFunOpen(this.roleid))
/*     */     {
/*  51 */       return false;
/*     */     }
/*     */     
/*  54 */     if (!ChildrenManager.canDoAction(this.roleid, 802))
/*     */     {
/*  56 */       return false;
/*     */     }
/*     */     
/*  59 */     SFashionCfg fashionCfg = SFashionCfg.get(this.fashionCfgid);
/*  60 */     if (fashionCfg == null)
/*     */     {
/*  62 */       onFailed(2);
/*  63 */       return false;
/*     */     }
/*     */     
/*  66 */     long marriedRoleid = mzm.gsp.marriage.main.MarriageInterface.getMarriedRoleid(this.roleid, false);
/*     */     
/*     */ 
/*  69 */     String userid = RoleInterface.getUserId(this.roleid);
/*  70 */     if (userid == null)
/*     */     {
/*  72 */       onFailed(4);
/*  73 */       return false;
/*     */     }
/*     */     
/*  76 */     if (marriedRoleid > 0L)
/*     */     {
/*  78 */       lock(xdb.Lockeys.get(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid), Long.valueOf(marriedRoleid) })));
/*     */     }
/*  80 */     Role2ChildrenInfo xRole2ChildrenInfo = Role2children.get(Long.valueOf(this.roleid));
/*  81 */     if (xRole2ChildrenInfo == null)
/*     */     {
/*  83 */       onFailed(1);
/*  84 */       return false;
/*     */     }
/*     */     
/*  87 */     ChildInfo xChildInfo = xtable.Children.get(Long.valueOf(this.childid));
/*  88 */     if (xChildInfo == null)
/*     */     {
/*  90 */       onFailed(5);
/*  91 */       return false;
/*     */     }
/*     */     
/*  94 */     long ownerRoleid = xChildInfo.getOwn_role_id();
/*  95 */     if (!ChildhoodManager.checkChild(xChildInfo, this.roleid, marriedRoleid))
/*     */     {
/*  97 */       Map<String, Object> extras = new HashMap();
/*  98 */       extras.put("married_roleid", Long.valueOf(marriedRoleid));
/*  99 */       extras.put("owner_roleid", Long.valueOf(ownerRoleid));
/* 100 */       extras.put("another_parent_role_id", Long.valueOf(xChildInfo.getAnother_parent_role_id()));
/* 101 */       onFailed(6, extras);
/* 102 */       return false;
/*     */     }
/*     */     
/* 105 */     int phase = fashionCfg.phase;
/* 106 */     DressedInfo xOldDressedInfo = (DressedInfo)xChildInfo.getDressed().remove(Integer.valueOf(phase));
/* 107 */     if (xOldDressedInfo == null)
/*     */     {
/* 109 */       onFailed(10);
/* 110 */       return false;
/*     */     }
/* 112 */     if (xOldDressedInfo.getFashion_cfgid() != this.fashionCfgid)
/*     */     {
/* 114 */       Map<String, Object> extras = new HashMap();
/* 115 */       extras.put("dressed_fashion_cfgid", Integer.valueOf(xOldDressedInfo.getFashion_cfgid()));
/* 116 */       onFailed(10, extras);
/* 117 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 121 */     if ((xRole2ChildrenInfo.getShow_child_id() == this.childid) && (xRole2ChildrenInfo.getShow_child_period() == fashionCfg.phase))
/*     */     {
/*     */ 
/* 124 */       ChildrenManager.trigChildrenEvent(new ChildShowModelChange(), new ChildShowModelChangeArg(this.roleid, ChildShowModelChangeReason.FASHION_REMOVE));
/*     */     }
/*     */     
/* 127 */     if (marriedRoleid > 0L)
/*     */     {
/* 129 */       Role2ChildrenInfo xMarriedRole2ChildrenInfo = Role2children.get(Long.valueOf(marriedRoleid));
/* 130 */       if (xMarriedRole2ChildrenInfo != null)
/*     */       {
/* 132 */         if ((xMarriedRole2ChildrenInfo.getShow_child_id() == this.childid) && (xMarriedRole2ChildrenInfo.getShow_child_period() == fashionCfg.phase))
/*     */         {
/*     */ 
/* 135 */           ChildrenManager.trigChildrenEvent(new ChildShowModelChange(), new ChildShowModelChangeArg(marriedRoleid, ChildShowModelChangeReason.FASHION_REMOVE));
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 142 */     ChildUndressFashionArg eventArg = new ChildUndressFashionArg(ownerRoleid, this.childid, this.fashionCfgid);
/* 143 */     ChildrenManager.trigChildrenEvent(new ChildUndressFashion(), eventArg);
/*     */     
/*     */ 
/* 146 */     addTlog(userid, ownerRoleid, marriedRoleid, xOldDressedInfo.getOwner_roleid());
/*     */     
/* 148 */     SUndressFashionSuccess resp = new SUndressFashionSuccess();
/* 149 */     resp.childid = this.childid;
/* 150 */     resp.fashion_cfgid = this.fashionCfgid;
/* 151 */     FashionManager.sendProtocol(this.roleid, marriedRoleid, resp);
/*     */     
/* 153 */     GameServer.logger().info(String.format("[childfashion]PCUndressFashion.processImp@undress fashion successs|roleid=%d|child=%d|fashion_cfgid=%d|owner_roleid=%d|married_roleid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childid), Integer.valueOf(this.fashionCfgid), Long.valueOf(ownerRoleid), Long.valueOf(marriedRoleid) }));
/*     */     
/*     */ 
/*     */ 
/* 157 */     return true;
/*     */   }
/*     */   
/*     */   private void onFailed(int retcode)
/*     */   {
/* 162 */     onFailed(retcode, null);
/*     */   }
/*     */   
/*     */   private void onFailed(int retcode, Map<String, Object> extraParams)
/*     */   {
/* 167 */     if (retcode < 0)
/*     */     {
/* 169 */       SUndressFashionFailed resp = new SUndressFashionFailed();
/* 170 */       resp.retcode = retcode;
/* 171 */       resp.childid = this.childid;
/* 172 */       resp.fashion_cfgid = this.fashionCfgid;
/* 173 */       OnlineManager.getInstance().sendAtOnce(this.roleid, resp);
/*     */     }
/*     */     
/* 176 */     StringBuffer logBuilder = new StringBuffer();
/* 177 */     logBuilder.append("[childfashion]PCUndressFashion.onFailed@undress fashion failed");
/* 178 */     logBuilder.append('|').append("roleid=").append(this.roleid);
/* 179 */     logBuilder.append('|').append("childid=").append(this.childid);
/* 180 */     logBuilder.append('|').append("fashion_cfgid=").append(this.fashionCfgid);
/* 181 */     logBuilder.append('|').append("retcode=").append(retcode);
/*     */     
/* 183 */     if (extraParams != null)
/*     */     {
/* 185 */       for (Map.Entry<String, Object> entry : extraParams.entrySet())
/*     */       {
/* 187 */         logBuilder.append('|').append((String)entry.getKey()).append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/*     */     
/* 191 */     GameServer.logger().error(logBuilder.toString());
/*     */   }
/*     */   
/*     */   private void addTlog(String userid, long ownerRoleid, long marriedRoleid, long fashionOwnerid)
/*     */   {
/* 196 */     String vGameIp = mzm.gsp.GameServerInfoManager.getHostIP();
/* 197 */     int roleLevel = RoleInterface.getLevel(this.roleid);
/*     */     
/* 199 */     TLogManager.getInstance().addLog(userid, "ChildUndressFashionForServer", new Object[] { vGameIp, userid, Long.valueOf(this.roleid), Integer.valueOf(roleLevel), Long.valueOf(this.childid), Long.valueOf(ownerRoleid), Long.valueOf(marriedRoleid), Integer.valueOf(this.fashionCfgid), Long.valueOf(fashionOwnerid) });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\fashion\PCUndressFashion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */