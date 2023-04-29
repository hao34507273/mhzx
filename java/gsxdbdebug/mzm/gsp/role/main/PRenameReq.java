/*     */ package mzm.gsp.role.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.bulletin.SBulletinInfo;
/*     */ import mzm.gsp.bulletin.main.BulletinInterface;
/*     */ import mzm.gsp.idip.main.IdipManager;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.qingfu.main.CostResult;
/*     */ import mzm.gsp.qingfu.main.CostType;
/*     */ import mzm.gsp.qingfu.main.QingfuInterface;
/*     */ import mzm.gsp.role.SCommonResultRes;
/*     */ import mzm.gsp.role.event.RoleRename;
/*     */ import mzm.gsp.sensitive.main.SensitiveInterface;
/*     */ import mzm.gsp.server.main.AvailableStringArgs;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.CommonUtils;
/*     */ import mzm.gsp.util.LogManager;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xdb.util.UniqName;
/*     */ import xtable.Name2roleid;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PRenameReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final String newName;
/*     */   private final long oldYuanBao;
/*     */   private final int itemNum;
/*     */   private final boolean isUseYuanBao;
/*     */   private String userid;
/*     */   
/*     */   public PRenameReq(long roleId, String newName, long oldYuanBao, long itemNum, boolean isUseYuanBao)
/*     */   {
/*  47 */     this.roleId = roleId;
/*  48 */     this.newName = newName;
/*  49 */     this.oldYuanBao = oldYuanBao;
/*  50 */     this.isUseYuanBao = isUseYuanBao;
/*  51 */     this.itemNum = ((int)itemNum);
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  57 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 217, true))
/*     */     {
/*  59 */       return false;
/*     */     }
/*     */     
/*  62 */     if (IdipManager.isLockRoleInfo(this.roleId, 1))
/*     */     {
/*  64 */       sendCommonMsgAtOnce(101);
/*  65 */       GameServer.logger().info(String.format("[role]PRenameReq.processImp@ role info locked!|roleId=%d", new Object[] { Long.valueOf(this.roleId) }));
/*  66 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  70 */     this.userid = RoleInterface.getUserId(this.roleId);
/*  71 */     lock(User.getTable(), Arrays.asList(new String[] { this.userid }));
/*     */     
/*  73 */     long curYuanBao = QingfuInterface.getBalance(this.userid, true);
/*     */     
/*  75 */     if (this.oldYuanBao != curYuanBao)
/*     */     {
/*  77 */       return false;
/*     */     }
/*     */     
/*  80 */     if (!checkNewName())
/*     */     {
/*  82 */       return false;
/*     */     }
/*     */     
/*  85 */     if (!cutNeedProperty())
/*     */     {
/*  87 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  91 */     reName(this.roleId);
/*     */     
/*  93 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   boolean cutNeedProperty()
/*     */   {
/* 101 */     TLogArg arg = new TLogArg(LogReason.ROLE_RENAME_REM);
/* 102 */     if (!ItemInterface.removeItemsByType(this.roleId, 31, 1, arg))
/*     */     {
/* 104 */       int price = ItemInterface.getItemYuanBaoPrice(OccupationManager.getInstance().getRenameItem());
/* 105 */       if ((!this.isUseYuanBao) || (QingfuInterface.costYuanbao(this.userid, this.roleId, price, CostType.COST_BIND_FIRST_ROLE_RENAME, arg) != CostResult.Success))
/*     */       {
/*     */ 
/* 108 */         return false;
/*     */       }
/*     */     }
/* 111 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   boolean checkNewName()
/*     */   {
/* 119 */     if ((SensitiveInterface.isNameSensitive(this.newName)) || (!AvailableStringArgs.getInstance().isStringUsable(this.newName)) || (this.newName.matches("\\d+")) || (this.newName.isEmpty()) || (Math.ceil(CommonUtils.getUTF16Length(this.newName) / 2.0D) > RoleManager.NAME_LENGTH))
/*     */     {
/*     */ 
/*     */ 
/* 123 */       sendCommonMsgAtOnce(1);
/* 124 */       return false;
/*     */     }
/* 126 */     if (!UniqName.allocate("role", this.newName))
/*     */     {
/* 128 */       sendCommonMsgAtOnce(0);
/* 129 */       return false;
/*     */     }
/* 131 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   void reName(long roleId)
/*     */   {
/* 141 */     String oldName = xtable.Basic.selectName(Long.valueOf(roleId));
/*     */     
/* 143 */     setNewName(oldName);
/*     */     
/* 145 */     sendBulletInfo(oldName);
/*     */     
/* 147 */     sendCommonMsg(2);
/*     */     
/* 149 */     tlogRename(roleId, oldName, this.newName);
/*     */     
/* 151 */     TriggerEventsManger.getInstance().triggerEvent(new RoleRename(), Long.valueOf(roleId), RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(roleId)));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   void setNewName(String oldName)
/*     */   {
/* 162 */     xbean.Basic xBasic = xtable.Basic.get(Long.valueOf(this.roleId));
/* 163 */     lock(Name2roleid.getTable(), Arrays.asList(new String[] { oldName, this.newName }));
/* 164 */     Name2roleid.remove(oldName);
/* 165 */     xBasic.setName(this.newName);
/* 166 */     Name2roleid.insert(this.newName, Long.valueOf(this.roleId));
/* 167 */     UniqName.release("role", oldName);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   void sendCommonMsg(int result)
/*     */   {
/* 175 */     SCommonResultRes res = new SCommonResultRes();
/* 176 */     res.result = result;
/* 177 */     OnlineManager.getInstance().send(this.roleId, res);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   void sendCommonMsgAtOnce(int result)
/*     */   {
/* 185 */     SCommonResultRes res = new SCommonResultRes();
/* 186 */     res.result = result;
/* 187 */     OnlineManager.getInstance().sendAtOnce(this.roleId, res);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   void sendBulletInfo(String oldName)
/*     */   {
/* 197 */     SBulletinInfo sBulletinInfo = new SBulletinInfo();
/* 198 */     sBulletinInfo.bulletintype = 13;
/* 199 */     sBulletinInfo.params.put(Integer.valueOf(1), oldName);
/* 200 */     sBulletinInfo.params.put(Integer.valueOf(2), this.newName);
/* 201 */     BulletinInterface.sendBulletin(sBulletinInfo);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void tlogRename(long roleId, String beforename, String aftername)
/*     */   {
/* 213 */     String userid = RoleInterface.getUserId(roleId);
/*     */     
/* 215 */     Role role = RoleInterface.getRole(roleId, false);
/* 216 */     int rolelevel = role.getLevel();
/* 217 */     int gender = role.getGender();
/* 218 */     int occupation = role.getOccupationId();
/*     */     
/* 220 */     String logStr = String.format("%s|%d|%d|%d|%d|%s|%s", new Object[] { userid, Long.valueOf(roleId), Integer.valueOf(rolelevel), Integer.valueOf(gender), Integer.valueOf(occupation), beforename, aftername });
/*     */     
/* 222 */     TLogManager.getInstance().addLog(roleId, "RoleNameChange", logStr);
/*     */     
/*     */ 
/* 225 */     int platform = OnlineManager.getInstance().getPlatform(userid);
/* 226 */     String channel = RoleInterface.getChannel(userid);
/* 227 */     String mac = OnlineManager.getInstance().getMac(userid);
/*     */     
/* 229 */     String zlogStr = String.format("%d|%s|%s|%s|%d|%s|%s", new Object[] { Integer.valueOf(platform), channel, mac, userid, Long.valueOf(roleId), beforename, aftername });
/* 230 */     LogManager.getInstance().addLog("rolenamechange", zlogStr);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\PRenameReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */