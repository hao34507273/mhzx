/*     */ package mzm.gsp.children.childhood;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.children.SChildhoodToAdultSuccess;
/*     */ import mzm.gsp.children.confbean.SChildHoodConst;
/*     */ import mzm.gsp.children.confbean.SChildrenCfg;
/*     */ import mzm.gsp.children.confbean.SChildrenConsts;
/*     */ import mzm.gsp.children.event.ChildPeriodChange;
/*     */ import mzm.gsp.children.event.ChildShowModelChange;
/*     */ import mzm.gsp.children.event.ChildShowModelChangeArg;
/*     */ import mzm.gsp.children.event.ChildShowModelChangeReason;
/*     */ import mzm.gsp.children.main.ChildrenManager;
/*     */ import mzm.gsp.marriage.main.MarriageInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.ChildGrowthDiaryInfo;
/*     */ import xbean.ChildInfo;
/*     */ import xbean.ChildhoodInfo;
/*     */ import xbean.Role2ChildrenInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Childrengrowthdiary;
/*     */ import xtable.Role2children;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCChildhoodToAdult extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final long childid;
/*     */   private final int childrenCfgid;
/*     */   
/*     */   public PCChildhoodToAdult(long roleid, long childid, int childrenCfgid)
/*     */   {
/*  37 */     this.roleid = roleid;
/*  38 */     this.childid = childid;
/*  39 */     this.childrenCfgid = childrenCfgid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  45 */     if ((this.childid <= 0L) || (this.childrenCfgid <= 0))
/*     */     {
/*  47 */       return false;
/*     */     }
/*     */     
/*  50 */     if (!ChildrenManager.isFunOpen(this.roleid))
/*     */     {
/*  52 */       return false;
/*     */     }
/*     */     
/*  55 */     if (!ChildhoodManager.isFunOpen(this.roleid, 223))
/*     */     {
/*  57 */       return false;
/*     */     }
/*     */     
/*  60 */     if (!ChildhoodManager.canDoAction(this.roleid, 606))
/*     */     {
/*  62 */       return false;
/*     */     }
/*     */     
/*  65 */     SChildrenCfg childrenCfg = SChildrenCfg.get(this.childrenCfgid);
/*  66 */     if (childrenCfg == null)
/*     */     {
/*  68 */       GameServer.logger().error(String.format("[childhood]PCChildhoodToAdult.processImp@children cfg not exist|roleid=%d|childid=%d|children_cfgid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childid), Integer.valueOf(this.childrenCfgid) }));
/*     */       
/*     */ 
/*     */ 
/*  72 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  76 */     if (!mzm.gsp.homeland.main.HomelandInterface.hasHome(this.roleid))
/*     */     {
/*  78 */       GameServer.logger().error(String.format("[childhood]PCChildhoodToAdult.processImp@home not exist|roleid=%d|childid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childid) }));
/*     */       
/*     */ 
/*  81 */       return false;
/*     */     }
/*     */     
/*  84 */     String userid = RoleInterface.getUserId(this.roleid);
/*  85 */     if (userid == null)
/*     */     {
/*  87 */       GameServer.logger().error(String.format("[childhood]PCChildhoodToAdult.processImp@userid is null|roleid=%d|childid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childid) }));
/*     */       
/*     */ 
/*  90 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  94 */     long marriedRoleid = MarriageInterface.getMarriedRoleid(this.roleid, false);
/*  95 */     if (marriedRoleid > 0L)
/*     */     {
/*  97 */       String marriedUserId = RoleInterface.getUserId(marriedRoleid);
/*  98 */       lock(User.getTable(), Arrays.asList(new String[] { userid, marriedUserId }));
/*  99 */       lock(xtable.Role2properties.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid), Long.valueOf(marriedRoleid) }));
/*     */     }
/*     */     else
/*     */     {
/* 103 */       lock(Lockeys.get(User.getTable(), userid));
/*     */     }
/*     */     
/* 106 */     Role2ChildrenInfo xRole2ChildrenInfo = Role2children.get(Long.valueOf(this.roleid));
/* 107 */     Role2ChildrenInfo xMarriedChildrenInfo = null;
/* 108 */     if (marriedRoleid > 0L)
/*     */     {
/* 110 */       xMarriedChildrenInfo = Role2children.get(Long.valueOf(marriedRoleid));
/*     */     }
/*     */     
/*     */ 
/* 114 */     if (!ChildhoodManager.checkHomeWorldid(this.roleid, true))
/*     */     {
/* 116 */       GameServer.logger().error(String.format("[childhood]PCChildhoodToAdult.processImp@world not exist|roleid=%d|childid=%d|userid=%s", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childid), userid }));
/*     */       
/*     */ 
/* 119 */       return false;
/*     */     }
/* 121 */     ChildInfo xChildInfo = xtable.Children.get(Long.valueOf(this.childid));
/* 122 */     if (xChildInfo == null)
/*     */     {
/* 124 */       GameServer.logger().error(String.format("[childhood]PCChildhoodToAdult.processImp@child not exist|roleid=%d|childid=%d|userid=%s", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childid), userid }));
/*     */       
/*     */ 
/* 127 */       return false;
/*     */     }
/* 129 */     if (xChildInfo.getHome_state() == 0)
/*     */     {
/* 131 */       GameServer.logger().error(String.format("[childhood]PCChildhoodToAdult.processImp@child not in home|roleid=%d|childid=%d|userid=%s|home_state=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childid), userid, Integer.valueOf(xChildInfo.getHome_state()) }));
/*     */       
/*     */ 
/*     */ 
/* 135 */       return false;
/*     */     }
/*     */     
/* 138 */     long ownerRoleid = xChildInfo.getOwn_role_id();
/* 139 */     if (!ChildhoodManager.checkChild(xChildInfo, this.roleid, marriedRoleid))
/*     */     {
/* 141 */       GameServer.logger().error(String.format("[childhood]PCChildhoodToAdult.processImp@child check failed|roleid=%d|childid=%d|userid=%s|married_roleid=%d|owner_roleid=%d|another_parent_roleid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childid), userid, Long.valueOf(marriedRoleid), Long.valueOf(ownerRoleid), Long.valueOf(xChildInfo.getAnother_parent_role_id()) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 146 */       return false;
/*     */     }
/*     */     
/* 149 */     if (xChildInfo.getChild_period() != 1)
/*     */     {
/* 151 */       GameServer.logger().error(String.format("[childhood]PCChildhoodToAdult.processImp@child status|roleid=%d|childid=%d|status=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childid), Integer.valueOf(xChildInfo.getChild_period()) }));
/*     */       
/*     */ 
/* 154 */       return false;
/*     */     }
/*     */     
/* 157 */     ChildhoodInfo xChildhoodInfo = xChildInfo.getChildhood_info();
/* 158 */     if (xChildhoodInfo.getTotal_num() < SChildHoodConst.getInstance().TOTAL_NUM)
/*     */     {
/* 160 */       GameServer.logger().error(String.format("[childhood]PCChildhoodToAdult.processImp@course num not enough|roleid=%d|childid=%d|cur_num=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childid), Integer.valueOf(xChildhoodInfo.getTotal_num()) }));
/*     */       
/*     */ 
/*     */ 
/* 164 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 168 */     int gender = xChildInfo.getChild_gender();
/* 169 */     if (gender == 1)
/*     */     {
/* 171 */       if ((this.childrenCfgid != SChildrenConsts.getInstance().BOY_ADULT1_BASE_CFG_ID) && (this.childrenCfgid != SChildrenConsts.getInstance().BOY_ADULT2_BASE_CFG_ID))
/*     */       {
/*     */ 
/* 174 */         GameServer.logger().error(String.format("[childhood]PCChildhoodToAdult.processImp@children_cfg not match|roleid=%d|childid=%d|gender=%d|children_cfgid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childid), Integer.valueOf(gender), Integer.valueOf(this.childrenCfgid) }));
/*     */         
/*     */ 
/*     */ 
/* 178 */         return false;
/*     */       }
/*     */     }
/* 181 */     else if (gender == 2)
/*     */     {
/* 183 */       if ((this.childrenCfgid != SChildrenConsts.getInstance().GIRL_ADULT1_BASE_CFG_ID) && (this.childrenCfgid != SChildrenConsts.getInstance().GIRL_ADULT2_BASE_CFG_ID))
/*     */       {
/*     */ 
/* 186 */         GameServer.logger().error(String.format("[childhood]PCChildhoodToAdult.processImp@children_cfg not match|roleid=%d|childid=%d|gender=%d|children_cfgid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childid), Integer.valueOf(gender), Integer.valueOf(this.childrenCfgid) }));
/*     */         
/*     */ 
/*     */ 
/* 190 */         return false;
/*     */       }
/*     */     }
/*     */     else
/*     */     {
/* 195 */       GameServer.logger().error(String.format("[childhood]PCChildhoodToAdult.processImp@gender error|roleid=%d|childid=%d|gender=%d|children_cfgid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childid), Integer.valueOf(gender), Integer.valueOf(this.childrenCfgid) }));
/*     */       
/*     */ 
/*     */ 
/* 199 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 204 */     xChildInfo.setChild_period(2);
/*     */     
/*     */ 
/* 207 */     ChildGrowthDiaryInfo xChildGrowthDiaryInfo = Childrengrowthdiary.get(Long.valueOf(this.childid));
/* 208 */     if (xChildGrowthDiaryInfo == null)
/*     */     {
/* 210 */       GameServer.logger().error(String.format("[childhood]PCChildhoodToAdult.processImp@child grow data is null|roleid=%d|childid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childid) }));
/*     */       
/*     */ 
/* 213 */       return false;
/*     */     }
/* 215 */     xChildGrowthDiaryInfo.setAdult_begin_time(DateTimeUtils.getCurrTimeInMillis());
/*     */     
/*     */ 
/* 218 */     ChildrenManager.stepInAdulthood(this.childrenCfgid, xChildInfo, ChildhoodManager.getQuality(xChildhoodInfo));
/*     */     
/*     */ 
/* 221 */     ChildrenManager.trigChildrenEvent(new ChildPeriodChange(), new mzm.gsp.children.event.ChildPeriodChangeArg(this.roleid, this.childid));
/* 222 */     if ((xRole2ChildrenInfo != null) && (xRole2ChildrenInfo.getShow_child_id() == this.childid))
/*     */     {
/* 224 */       xRole2ChildrenInfo.setShow_child_period(2);
/* 225 */       ChildrenManager.trigChildrenEvent(new ChildShowModelChange(), new ChildShowModelChangeArg(this.roleid, ChildShowModelChangeReason.PERIOD_CHANGE));
/*     */       
/* 227 */       ChildrenManager.trigChildrenEvent(new ChildShowModelChange(), new ChildShowModelChangeArg(this.roleid, ChildShowModelChangeReason.CHILD_WEAPON_CHANGE));
/*     */     }
/*     */     
/*     */ 
/* 231 */     if ((xMarriedChildrenInfo != null) && (xMarriedChildrenInfo.getShow_child_id() == this.childid))
/*     */     {
/* 233 */       xMarriedChildrenInfo.setShow_child_period(2);
/* 234 */       ChildrenManager.trigChildrenEvent(new ChildShowModelChange(), new ChildShowModelChangeArg(marriedRoleid, ChildShowModelChangeReason.PERIOD_CHANGE));
/*     */       
/* 236 */       ChildrenManager.trigChildrenEvent(new ChildShowModelChange(), new ChildShowModelChangeArg(this.roleid, ChildShowModelChangeReason.CHILD_WEAPON_CHANGE));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 241 */     addTlog(userid, ownerRoleid, marriedRoleid, xChildhoodInfo.getCourses().toString(), xChildhoodInfo.getInterest());
/*     */     
/*     */ 
/* 244 */     SChildhoodToAdultSuccess resp = new SChildhoodToAdultSuccess();
/*     */     
/* 246 */     ChildrenManager.fillChildBean(ownerRoleid, this.childid, xChildInfo, resp.child_info, false);
/*     */     
/* 248 */     ChildhoodManager.sendProtocol(this.roleid, marriedRoleid, resp);
/*     */     
/*     */ 
/* 251 */     ChildrenManager.triggerChildRatingChange(this.roleid, this.childid, false);
/*     */     
/* 253 */     GameServer.logger().info(String.format("[childhood]PCChildhoodToAdult.processImp@childhood to adult success|roleid=%d|childid=%d|children_cfgid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childid), Integer.valueOf(this.childrenCfgid) }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 258 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   private void addTlog(String userid, long ownerRoleid, long marriedRoleid, String courseInfo, int drawLotsCfgid)
/*     */   {
/* 264 */     String vGameIp = GameServerInfoManager.getHostIP();
/* 265 */     int roleLevel = RoleInterface.getLevel(this.roleid);
/*     */     
/* 267 */     TLogManager.getInstance().addLog(userid, "ChildhoodToAdultForServer", new Object[] { vGameIp, userid, Long.valueOf(this.roleid), Integer.valueOf(roleLevel), Long.valueOf(this.childid), Long.valueOf(ownerRoleid), Long.valueOf(marriedRoleid), courseInfo, Integer.valueOf(drawLotsCfgid), Integer.valueOf(this.childrenCfgid) });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\childhood\PCChildhoodToAdult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */