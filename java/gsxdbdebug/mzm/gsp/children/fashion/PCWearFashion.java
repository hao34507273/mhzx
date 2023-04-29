/*     */ package mzm.gsp.children.fashion;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.children.SWearFashionFailed;
/*     */ import mzm.gsp.children.SWearFashionSuccess;
/*     */ import mzm.gsp.children.childhood.ChildhoodManager;
/*     */ import mzm.gsp.children.confbean.SFashionCfg;
/*     */ import mzm.gsp.children.event.ChildShowModelChange;
/*     */ import mzm.gsp.children.event.ChildShowModelChangeArg;
/*     */ import mzm.gsp.children.event.ChildShowModelChangeReason;
/*     */ import mzm.gsp.children.event.ChildWearFashionArg;
/*     */ import mzm.gsp.children.main.ChildrenManager;
/*     */ import mzm.gsp.marriage.main.MarriageInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.ChildFashionInfo;
/*     */ import xbean.ChildInfo;
/*     */ import xbean.FashionInfo;
/*     */ import xbean.Role2ChildrenInfo;
/*     */ import xtable.Basic;
/*     */ import xtable.Role2children;
/*     */ 
/*     */ public class PCWearFashion extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final long childid;
/*     */   private final int fashionCfgid;
/*     */   
/*     */   public PCWearFashion(long roleid, long childid, int fashionCfgid)
/*     */   {
/*  37 */     this.roleid = roleid;
/*  38 */     this.childid = childid;
/*  39 */     this.fashionCfgid = fashionCfgid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  45 */     if ((this.fashionCfgid <= 0) || (this.childid <= 0L))
/*     */     {
/*  47 */       return false;
/*     */     }
/*     */     
/*  50 */     if (!FashionManager.isFunOpen(this.roleid))
/*     */     {
/*  52 */       return false;
/*     */     }
/*     */     
/*  55 */     if (!ChildrenManager.canDoAction(this.roleid, 801))
/*     */     {
/*  57 */       return false;
/*     */     }
/*     */     
/*  60 */     SFashionCfg fashionCfg = SFashionCfg.get(this.fashionCfgid);
/*  61 */     if (fashionCfg == null)
/*     */     {
/*  63 */       onFailed(2);
/*  64 */       return false;
/*     */     }
/*     */     
/*  67 */     long marriedRoleid = MarriageInterface.getMarriedRoleid(this.roleid, false);
/*     */     
/*     */ 
/*  70 */     String userid = RoleInterface.getUserId(this.roleid);
/*  71 */     if (userid == null)
/*     */     {
/*  73 */       onFailed(4);
/*  74 */       return false;
/*     */     }
/*     */     
/*  77 */     if (marriedRoleid > 0L)
/*     */     {
/*  79 */       lock(xdb.Lockeys.get(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid), Long.valueOf(marriedRoleid) })));
/*     */     }
/*  81 */     Role2ChildrenInfo xRole2ChildrenInfo = Role2children.get(Long.valueOf(this.roleid));
/*  82 */     if (xRole2ChildrenInfo == null)
/*     */     {
/*  84 */       onFailed(1);
/*  85 */       return false;
/*     */     }
/*     */     
/*  88 */     ChildFashionInfo xChildFashionInfo = xRole2ChildrenInfo.getFashion_info();
/*  89 */     FashionInfo xFashionInfo = (FashionInfo)xChildFashionInfo.getFashions().get(Integer.valueOf(this.fashionCfgid));
/*  90 */     if (xFashionInfo == null)
/*     */     {
/*  92 */       onFailed(7);
/*  93 */       return false;
/*     */     }
/*     */     
/*  96 */     if (FashionManager.isExpire(fashionCfg.duration, xFashionInfo.getStart_time()))
/*     */     {
/*  98 */       Map<String, Object> extras = new HashMap();
/*  99 */       extras.put("start_time", Long.valueOf(xFashionInfo.getStart_time()));
/* 100 */       extras.put("duration", Integer.valueOf(fashionCfg.duration));
/* 101 */       onFailed(-1, extras);
/* 102 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 106 */     ChildInfo xChildInfo = xtable.Children.get(Long.valueOf(this.childid));
/* 107 */     if (xChildInfo == null)
/*     */     {
/* 109 */       onFailed(5);
/* 110 */       return false;
/*     */     }
/*     */     
/* 113 */     long ownerRoleid = xChildInfo.getOwn_role_id();
/* 114 */     if (!ChildhoodManager.checkChild(xChildInfo, this.roleid, marriedRoleid))
/*     */     {
/* 116 */       Map<String, Object> extras = new HashMap();
/* 117 */       extras.put("married_roleid", Long.valueOf(marriedRoleid));
/* 118 */       extras.put("owner_roleid", Long.valueOf(ownerRoleid));
/* 119 */       extras.put("another_parent_role_id", Long.valueOf(xChildInfo.getAnother_parent_role_id()));
/* 120 */       onFailed(6, extras);
/* 121 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 125 */     int fashionPhase = fashionCfg.phase;
/* 126 */     if (xChildInfo.getChild_period() < fashionPhase)
/*     */     {
/* 128 */       Map<String, Object> extras = new HashMap();
/* 129 */       extras.put("child_phase", Integer.valueOf(xChildInfo.getChild_period()));
/* 130 */       extras.put("fashion_phasae", Integer.valueOf(fashionPhase));
/* 131 */       onFailed(8, extras);
/* 132 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 136 */     int fashionGender = fashionCfg.gender;
/* 137 */     int childGender = xChildInfo.getChild_gender();
/* 138 */     if ((fashionGender != 0) && (fashionGender != childGender))
/*     */     {
/* 140 */       Map<String, Object> extras = new HashMap();
/* 141 */       extras.put("fashion_gender", Integer.valueOf(fashionGender));
/* 142 */       extras.put("child_gender", Integer.valueOf(childGender));
/* 143 */       onFailed(12, extras);
/* 144 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 148 */     xbean.DressedInfo xDressedInfo = (xbean.DressedInfo)xChildInfo.getDressed().get(Integer.valueOf(fashionPhase));
/* 149 */     int oldFashionCfgid = 0;
/* 150 */     long oldOwnerRoleid = 0L;
/* 151 */     if (xDressedInfo != null)
/*     */     {
/* 153 */       oldFashionCfgid = xDressedInfo.getFashion_cfgid();
/* 154 */       oldOwnerRoleid = xDressedInfo.getOwner_roleid();
/*     */     }
/*     */     
/* 157 */     xDressedInfo = xbean.Pod.newDressedInfo();
/* 158 */     xDressedInfo.setFashion_cfgid(this.fashionCfgid);
/* 159 */     xDressedInfo.setOwner_roleid(this.roleid);
/* 160 */     xChildInfo.getDressed().put(Integer.valueOf(fashionPhase), xDressedInfo);
/*     */     
/*     */ 
/* 163 */     if (xRole2ChildrenInfo.getShow_child_id() == this.childid)
/*     */     {
/* 165 */       ChildrenManager.trigChildrenEvent(new ChildShowModelChange(), new ChildShowModelChangeArg(this.roleid, ChildShowModelChangeReason.FASHION_CHANGE));
/*     */     }
/*     */     
/* 168 */     if (marriedRoleid > 0L)
/*     */     {
/* 170 */       Role2ChildrenInfo xMarriedRole2ChildrenInfo = Role2children.get(Long.valueOf(marriedRoleid));
/* 171 */       if (xMarriedRole2ChildrenInfo != null)
/*     */       {
/* 173 */         if (xMarriedRole2ChildrenInfo.getShow_child_id() == this.childid)
/*     */         {
/* 175 */           ChildrenManager.trigChildrenEvent(new ChildShowModelChange(), new ChildShowModelChangeArg(marriedRoleid, ChildShowModelChangeReason.FASHION_CHANGE));
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 182 */     ChildWearFashionArg eventArg = new ChildWearFashionArg(ownerRoleid, this.childid, oldFashionCfgid, this.fashionCfgid);
/*     */     
/* 184 */     ChildrenManager.trigChildrenEvent(new mzm.gsp.children.event.ChildWearFashion(), eventArg);
/*     */     
/*     */ 
/* 187 */     addTlog(userid, ownerRoleid, marriedRoleid, oldFashionCfgid, oldOwnerRoleid);
/*     */     
/* 189 */     SWearFashionSuccess resp = new SWearFashionSuccess();
/* 190 */     resp.childid = this.childid;
/* 191 */     resp.dressed_info = new mzm.gsp.children.DressedInfo(this.fashionCfgid, this.roleid);
/* 192 */     FashionManager.sendProtocol(this.roleid, marriedRoleid, resp);
/*     */     
/* 194 */     GameServer.logger().info(String.format("[childfashion]PCWearFashion.processImp@wear fashion successs|roleid=%d|child=%d|fashion_cfgid=%d|old_owner_roleid=%d|old_fashion_cfgid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childid), Integer.valueOf(this.fashionCfgid), Long.valueOf(oldOwnerRoleid), Integer.valueOf(oldFashionCfgid) }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 199 */     return true;
/*     */   }
/*     */   
/*     */   private void onFailed(int retcode)
/*     */   {
/* 204 */     onFailed(retcode, null);
/*     */   }
/*     */   
/*     */   private void onFailed(int retcode, Map<String, Object> extraParams)
/*     */   {
/* 209 */     if (retcode < 0)
/*     */     {
/* 211 */       SWearFashionFailed resp = new SWearFashionFailed();
/* 212 */       resp.retcode = retcode;
/* 213 */       resp.fashion_cfgid = this.fashionCfgid;
/* 214 */       resp.childid = this.childid;
/* 215 */       OnlineManager.getInstance().sendAtOnce(this.roleid, resp);
/*     */     }
/*     */     
/* 218 */     StringBuffer logBuilder = new StringBuffer();
/* 219 */     logBuilder.append("[childfashion]PCWearFashion.onFailed@wear fashion failed");
/* 220 */     logBuilder.append('|').append("roleid=").append(this.roleid);
/* 221 */     logBuilder.append('|').append("childid=").append(this.childid);
/* 222 */     logBuilder.append('|').append("fashion_cfgid=").append(this.fashionCfgid);
/* 223 */     logBuilder.append('|').append("retcode=").append(retcode);
/*     */     
/* 225 */     if (extraParams != null)
/*     */     {
/* 227 */       for (Map.Entry<String, Object> entry : extraParams.entrySet())
/*     */       {
/* 229 */         logBuilder.append('|').append((String)entry.getKey()).append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/*     */     
/* 233 */     GameServer.logger().error(logBuilder.toString());
/*     */   }
/*     */   
/*     */ 
/*     */   private void addTlog(String userid, long ownerRoleid, long marriedRoleid, int oldFashionCfgid, long oldFashionOwner)
/*     */   {
/* 239 */     String vGameIp = mzm.gsp.GameServerInfoManager.getHostIP();
/* 240 */     int roleLevel = RoleInterface.getLevel(this.roleid);
/*     */     
/* 242 */     TLogManager.getInstance().addLog(userid, "ChildWearFashionForServer", new Object[] { vGameIp, userid, Long.valueOf(this.roleid), Integer.valueOf(roleLevel), Long.valueOf(this.childid), Long.valueOf(ownerRoleid), Long.valueOf(marriedRoleid), Integer.valueOf(oldFashionCfgid), Long.valueOf(oldFashionOwner), Integer.valueOf(this.fashionCfgid) });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\fashion\PCWearFashion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */