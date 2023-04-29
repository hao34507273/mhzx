/*     */ package mzm.gsp.item.main;
/*     */ 
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.homeland.confbean.SAnimalConst;
/*     */ import mzm.gsp.homeland.main.HomelandInterface;
/*     */ import mzm.gsp.item.SUseEmbryoItemSuccess;
/*     */ import mzm.gsp.item.confbean.SEmbryoItemCfg;
/*     */ import mzm.gsp.item.confbean.SItemCfg;
/*     */ import mzm.gsp.marriage.main.MarriageInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.zoo.main.AddAnimalResult;
/*     */ import mzm.gsp.zoo.main.AddAnimalResult.Reason;
/*     */ import mzm.gsp.zoo.main.ZooInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCUseEmbryoItem extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final long uuid;
/*     */   
/*     */   public PCUseEmbryoItem(long roleid, long uuid)
/*     */   {
/*  32 */     this.roleid = roleid;
/*  33 */     this.uuid = uuid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  39 */     if (this.uuid <= 0L)
/*     */     {
/*  41 */       return false;
/*     */     }
/*     */     
/*  44 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleid, 1191, true))
/*     */     {
/*  46 */       GameServer.logger().info(String.format("[item]PCUseCatItem.checkRoleStatus@status check failed|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*     */       
/*  48 */       return false;
/*     */     }
/*     */     
/*  51 */     if (!ZooInterface.isFunOpen(this.roleid))
/*     */     {
/*  53 */       return false;
/*     */     }
/*     */     
/*  56 */     if (!HomelandInterface.hasHome(this.roleid))
/*     */     {
/*  58 */       ItemManager.sendWrongInfo(this.roleid, 1154, new String[0]);
/*  59 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  63 */     int level = RoleInterface.getLevel(this.roleid);
/*  64 */     if (level < SAnimalConst.getInstance().OPEN_LEVEL)
/*     */     {
/*     */ 
/*  67 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  71 */     long partnerRoleId = MarriageInterface.getMarriedRoleid(this.roleid);
/*  72 */     String userid = RoleInterface.getUserId(this.roleid);
/*  73 */     if (partnerRoleId <= 0L)
/*     */     {
/*  75 */       lock(Lockeys.get(User.getTable(), userid));
/*  76 */       lock(Lockeys.get(Basic.getTable(), Long.valueOf(this.roleid)));
/*     */     }
/*     */     else
/*     */     {
/*  80 */       String partnerUserid = RoleInterface.getUserId(partnerRoleId);
/*  81 */       lock(Lockeys.get(User.getTable(), new Object[] { userid, partnerUserid }));
/*  82 */       lock(Lockeys.get(Basic.getTable(), new Object[] { Long.valueOf(this.roleid), Long.valueOf(partnerRoleId) }));
/*     */     }
/*     */     
/*  85 */     BasicItem item = ItemInterface.getItemByUuid(this.roleid, this.uuid);
/*  86 */     if (item == null)
/*     */     {
/*  88 */       ItemManager.sendWrongInfo(this.roleid, 102, new String[0]);
/*  89 */       return false;
/*     */     }
/*  91 */     if (!item.canUse(this.roleid))
/*     */     {
/*  93 */       return false;
/*     */     }
/*     */     
/*  96 */     int itemCfgid = item.getCfgId();
/*  97 */     SItemCfg itemCfg = SItemCfg.get(itemCfgid);
/*  98 */     if ((itemCfg == null) || (itemCfg.type != 122))
/*     */     {
/* 100 */       ItemManager.sendWrongInfo(this.roleid, 101, new String[0]);
/* 101 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 105 */     SEmbryoItemCfg embryoItemCfg = SEmbryoItemCfg.get(itemCfgid);
/* 106 */     if (embryoItemCfg == null)
/*     */     {
/* 108 */       ItemManager.sendWrongInfo(this.roleid, 101, new String[0]);
/* 109 */       return false;
/*     */     }
/*     */     
/* 112 */     TLogArg logArg = new TLogArg(LogReason.ITEM_USE_EMBRYO_ITEM);
/* 113 */     if (!ItemInterface.removeItemByUuid(this.roleid, this.uuid, 1, logArg))
/*     */     {
/* 115 */       GameServer.logger().error(String.format("[item]PCUseEmbryoItem.processImp@remove embryo item failed|roleid=%d|uuid=%d|item_cfgid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.uuid), Integer.valueOf(itemCfgid) }));
/*     */       
/*     */ 
/* 118 */       return false;
/*     */     }
/*     */     
/* 121 */     int embryoCfgid = embryoItemCfg.embryoCfgid;
/* 122 */     AddAnimalResult result = ZooInterface.addAnimal(this.roleid, embryoCfgid);
/* 123 */     if (result.getReason() != AddAnimalResult.Reason.SUCCESS)
/*     */     {
/* 125 */       GameServer.logger().error(String.format("[item]PCUseEmbryoItem.processImp@add animal failed|roleid=%d|item_cfgid=%d|embryo_cfgid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(itemCfgid), Integer.valueOf(embryoCfgid) }));
/*     */       
/*     */ 
/*     */ 
/* 129 */       ItemManager.sendWrongInfo(this.roleid, 1193, new String[0]);
/* 130 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 134 */     addTLog(this.roleid, "AniamlUseEmbryoItemForServer", new Object[] { Integer.valueOf(itemCfgid), Long.valueOf(result.getAnimalid()), Integer.valueOf(embryoCfgid) });
/*     */     
/* 136 */     SUseEmbryoItemSuccess rsp = new SUseEmbryoItemSuccess();
/* 137 */     rsp.item_cfgid = itemCfgid;
/* 138 */     rsp.used_num = 1;
/* 139 */     rsp.animal_info = ZooInterface.transToAnimalInfo(this.roleid, result.getAnimalid());
/* 140 */     OnlineManager.getInstance().send(this.roleid, rsp);
/*     */     
/* 142 */     GameServer.logger().info(String.format("[item]PCUseEmbryoItem.processImp@use embryo item success|roleid=%d|item_cfgid=%d|embryo_cfgid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(itemCfgid), Integer.valueOf(embryoCfgid) }));
/*     */     
/*     */ 
/*     */ 
/* 146 */     return true;
/*     */   }
/*     */   
/*     */   private void addTLog(long roleid, String logName, Object... logColumns)
/*     */   {
/* 151 */     String vGameIp = GameServerInfoManager.getHostIP();
/* 152 */     int roleLevel = RoleInterface.getLevel(roleid);
/* 153 */     String userid = RoleInterface.getUserId(roleid);
/*     */     
/* 155 */     StringBuilder logStr = new StringBuilder();
/* 156 */     logStr.append(vGameIp);
/* 157 */     logStr.append("|").append(userid);
/* 158 */     logStr.append("|").append(roleid);
/* 159 */     logStr.append("|").append(roleLevel);
/*     */     
/* 161 */     for (Object colum : logColumns)
/*     */     {
/* 163 */       logStr.append("|").append(colum);
/*     */     }
/*     */     
/* 166 */     TLogManager.getInstance().addLog(roleid, logName, logStr.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\PCUseEmbryoItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */