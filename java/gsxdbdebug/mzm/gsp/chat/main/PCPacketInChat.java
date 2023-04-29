/*     */ package mzm.gsp.chat.main;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.aircraft.AircraftDataInfo;
/*     */ import mzm.gsp.aircraft.main.AircraftInterface;
/*     */ import mzm.gsp.chat.PacketInfo;
/*     */ import mzm.gsp.chat.SPacketInChatInfo;
/*     */ import mzm.gsp.item.ItemInfo;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.mounts.MountsInfo;
/*     */ import mzm.gsp.mounts.main.MountsInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.pet.PetInfo;
/*     */ import mzm.gsp.pet.main.PetInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PCPacketInChat
/*     */   extends LogicProcedure
/*     */ {
/*     */   private long roleId;
/*     */   private long checkedRoleId;
/*     */   private int packetType;
/*     */   private PacketInfo pacInfo;
/*     */   
/*     */   public PCPacketInChat(long roleId, long checkedRoleId, int packetType, PacketInfo pacInfo)
/*     */   {
/*  32 */     this.roleId = roleId;
/*  33 */     this.checkedRoleId = checkedRoleId;
/*  34 */     this.packetType = packetType;
/*  35 */     this.pacInfo = pacInfo;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  41 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 1052, true))
/*     */     {
/*  43 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  47 */     SPacketInChatInfo sPacInfo = new SPacketInChatInfo();
/*  48 */     sPacInfo.checkedroleid = this.checkedRoleId;
/*  49 */     sPacInfo.packettype = this.packetType;
/*     */     
/*  51 */     boolean isRoamServerAndNotOnline = false;
/*  52 */     if ((GameServerInfoManager.isRoamServer()) && (!OnlineManager.getInstance().isOnline(this.checkedRoleId)))
/*     */     {
/*  54 */       isRoamServerAndNotOnline = true;
/*     */     }
/*     */     
/*  57 */     OctetsStream os = new OctetsStream();
/*     */     
/*  59 */     switch (this.packetType)
/*     */     {
/*     */     case 1: 
/*  62 */       ItemInfo itemInfo = null;
/*  63 */       itemInfo = ItemInterface.getItemInfo(this.checkedRoleId, this.pacInfo.packetid, false);
/*  64 */       if ((itemInfo == null) || (isRoamServerAndNotOnline))
/*     */       {
/*  66 */         RoleChatManager.sendNormalResult(this.roleId, 10, new String[0]);
/*  67 */         return false;
/*     */       }
/*  69 */       sPacInfo.checkinfo = os.marshal(itemInfo);
/*  70 */       break;
/*     */     
/*     */     case 2: 
/*  73 */       PetInfo petinfo = PetInterface.getPetInfo(this.checkedRoleId, this.pacInfo.packetid);
/*  74 */       if ((petinfo == null) || (petinfo.petid <= 0L) || (isRoamServerAndNotOnline))
/*     */       {
/*  76 */         RoleChatManager.sendNormalResult(this.roleId, 11, new String[0]);
/*  77 */         return false;
/*     */       }
/*  79 */       sPacInfo.checkinfo = os.marshal(petinfo);
/*  80 */       break;
/*     */     
/*     */     case 5: 
/*  83 */       MountsInfo sMountsInfo = MountsInterface.getMountsInfoByMountsId(this.checkedRoleId, this.pacInfo.packetid, false);
/*     */       
/*  85 */       if ((sMountsInfo == null) || (isRoamServerAndNotOnline))
/*     */       {
/*  87 */         RoleChatManager.sendNormalResult(this.roleId, 12, new String[0]);
/*  88 */         return false;
/*     */       }
/*  90 */       sPacInfo.checkinfo = os.marshal(sMountsInfo);
/*  91 */       break;
/*     */     case 6: 
/*  93 */       AircraftDataInfo aircraftDataInfo = AircraftInterface.getRoleAircraftInfo(this.checkedRoleId, (int)this.pacInfo.packetid, false);
/*     */       
/*  95 */       if ((aircraftDataInfo == null) || (isRoamServerAndNotOnline))
/*     */       {
/*  97 */         RoleChatManager.sendNormalResult(this.roleId, 12, new String[0]);
/*  98 */         return false;
/*     */       }
/* 100 */       sPacInfo.checkinfo = os.marshal(aircraftDataInfo);
/* 101 */       break;
/*     */     case 3: case 4: default: 
/* 103 */       return false;
/*     */     }
/*     */     
/* 106 */     OnlineManager.getInstance().send(this.roleId, sPacInfo);
/* 107 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\main\PCPacketInChat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */