/*     */ package mzm.gsp.corps.main;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.corps.SRenameCropsBro;
/*     */ import mzm.gsp.corps.confbean.CorpsConsts;
/*     */ import mzm.gsp.corps.event.CorpsNameChange;
/*     */ import mzm.gsp.corps.event.CorpsNameChangeEventArg;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.sensitive.main.SensitiveInterface;
/*     */ import mzm.gsp.server.main.AvailableStringArgs;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.CommonUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.CorpsMember;
/*     */ import xdb.Lockeys;
/*     */ import xdb.util.UniqName;
/*     */ import xtable.Basic;
/*     */ import xtable.Role2corps;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PCRenameCropsReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final Octets corpsNameOctets;
/*     */   private String corpsName;
/*     */   
/*     */   public PCRenameCropsReq(long roleId, Octets corpsNameOctets)
/*     */   {
/*  43 */     this.roleId = roleId;
/*  44 */     this.corpsNameOctets = corpsNameOctets;
/*  45 */     String tmpName = null;
/*     */     try
/*     */     {
/*  48 */       tmpName = corpsNameOctets.getString("UTF-8");
/*     */     }
/*     */     catch (Exception e) {}
/*     */     
/*     */ 
/*     */ 
/*  54 */     this.corpsName = tmpName;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  61 */     Lockeys.lock(User.getTable(), Arrays.asList(new String[] { RoleInterface.getUserId(this.roleId) }));
/*     */     
/*  63 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId) }));
/*  64 */     CorpsMember xCorpsMember = Role2corps.get(Long.valueOf(this.roleId));
/*  65 */     if (xCorpsMember == null)
/*     */     {
/*  67 */       GameServer.logger().error(String.format("[corps]PCReplaceBadgeReq.processImp@ not own corps!|roleId=%d", new Object[] { Long.valueOf(this.roleId) }));
/*  68 */       return false;
/*     */     }
/*     */     
/*  71 */     long corpsId = xCorpsMember.getCorpsid();
/*  72 */     xbean.Corps xCorps = xtable.Corps.get(Long.valueOf(corpsId));
/*  73 */     if (xCorps == null)
/*     */     {
/*  75 */       GameServer.logger().error(String.format("[corps]PCReplaceBadgeReq.processImp@ IMPOSSIBLE! not have this corps!|roleId=%d|corpsId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(corpsId) }));
/*     */       
/*     */ 
/*     */ 
/*  79 */       return false;
/*     */     }
/*     */     
/*  82 */     if (!canRenameCorps(xCorpsMember))
/*     */     {
/*     */ 
/*  85 */       return false;
/*     */     }
/*     */     
/*  88 */     int checkRes = checkNameContent(this.corpsName);
/*  89 */     if (checkRes > 0)
/*     */     {
/*  91 */       GameServer.logger().error(String.format("[corps]PCRenameCropsReq.processImp@ name content check err!|roleId=%d|newName=%s|res=%d", new Object[] { Long.valueOf(this.roleId), this.corpsName, Integer.valueOf(checkRes) }));
/*     */       
/*     */ 
/*  94 */       CorpsManager.sendCorpsNotice(this.roleId, false, checkRes, new String[0]);
/*  95 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  99 */     if (!RoleInterface.cutGold(this.roleId, CorpsConsts.getInstance().RENAME_CORPS_COST_GOLD_NUM, new TLogArg(LogReason.RENAME_CORPS_COST)))
/*     */     {
/*     */ 
/* 102 */       GameServer.logger().error(String.format("[corps]PCReplaceBadgeReq.processImp@ cut gold err!|roleId=%d|corpsName=%s|cutNum=%d", new Object[] { Long.valueOf(this.roleId), this.corpsName, Integer.valueOf(CorpsConsts.getInstance().RENAME_CORPS_COST_GOLD_NUM) }));
/*     */       
/*     */ 
/* 105 */       return false;
/*     */     }
/*     */     
/* 108 */     String oldName = xCorps.getCorpsname();
/*     */     
/* 110 */     xCorps.setCorpsname(this.corpsName);
/*     */     
/* 112 */     addRenameCorpsHistory(xCorps, oldName);
/*     */     
/*     */ 
/* 115 */     UniqName.release("corps", oldName);
/*     */     
/*     */ 
/* 118 */     CorpsManager.corpsBrocast(xCorps, true, new SRenameCropsBro(this.corpsNameOctets));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 123 */     TriggerEventsManger.getInstance().triggerEvent(new CorpsNameChange(), new CorpsNameChangeEventArg(corpsId, oldName, this.corpsName));
/*     */     
/* 125 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void addRenameCorpsHistory(xbean.Corps xCorps, String oldName)
/*     */   {
/* 136 */     List<String> params = new ArrayList();
/* 137 */     params.add(RoleInterface.getName(this.roleId));
/* 138 */     params.add(oldName);
/* 139 */     params.add(this.corpsName);
/* 140 */     CorpsManager.addCorpsHistory(xCorps, 5, params);
/*     */   }
/*     */   
/*     */ 
/*     */   private boolean canRenameCorps(CorpsMember xCorpsMember)
/*     */   {
/* 146 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 1227, true))
/*     */     {
/* 148 */       return false;
/*     */     }
/*     */     
/* 151 */     if (xCorpsMember.getDuty() != 1)
/*     */     {
/* 153 */       GameServer.logger().error(String.format("[corps]PCRenameCropsReq.canRenameCorps@ not leader!|roleId=%d", new Object[] { Long.valueOf(this.roleId) }));
/* 154 */       return false;
/*     */     }
/* 156 */     return true;
/*     */   }
/*     */   
/*     */   private int checkNameContent(String name)
/*     */   {
/* 161 */     name = name.trim();
/* 162 */     if ((this.corpsName.isEmpty()) || (Math.ceil(CommonUtils.getUTF16Length(name) / 2.0D) > CorpsConsts.getInstance().CORPS_NAME_MAX_LENGTH) || (Math.ceil(CommonUtils.getUTF16Length(name) / 2.0D) < CorpsConsts.getInstance().CORPS_NAME_MIN_LENGTH) || (!AvailableStringArgs.getInstance().isStringUsable(name)))
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/* 167 */       return 1;
/*     */     }
/* 169 */     if (SensitiveInterface.isNameSensitive(name))
/*     */     {
/* 171 */       return 1;
/*     */     }
/* 173 */     if (!UniqName.allocate("corps", this.corpsName))
/*     */     {
/* 175 */       return 61;
/*     */     }
/* 177 */     return -1;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\corps\main\PCRenameCropsReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */