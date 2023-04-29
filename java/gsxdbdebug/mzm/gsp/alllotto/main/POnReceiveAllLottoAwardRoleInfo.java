/*     */ package mzm.gsp.alllotto.main;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import hub.AllLottoRoleInfo;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.alllotto.RoleInfo;
/*     */ import mzm.gsp.alllotto.SBrdAllLottoResult;
/*     */ import mzm.gsp.alllotto.confbean.SAllLottoCfg;
/*     */ import mzm.gsp.alllotto.confbean.SAllLottoTurnInfo;
/*     */ import mzm.gsp.crossserver.event.ReceiveAllLottoAwardRoleInfoArg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.AllLottoAwardRoleInfo;
/*     */ import xbean.AllLottoInfo;
/*     */ import xbean.AllLottoTurnInfo;
/*     */ import xbean.Pod;
/*     */ import xtable.All_lotto_infos;
/*     */ 
/*     */ public class POnReceiveAllLottoAwardRoleInfo extends mzm.gsp.crossserver.event.ReceiveAllLottoAwardRoleInfoProcedure
/*     */ {
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  28 */     SAllLottoCfg cfg = SAllLottoCfg.get(((ReceiveAllLottoAwardRoleInfoArg)this.arg).getActivityCfgid());
/*  29 */     if (cfg == null)
/*     */     {
/*     */ 
/*  32 */       onFail(-3, null);
/*  33 */       return false;
/*     */     }
/*  35 */     SAllLottoTurnInfo turnInfo = (SAllLottoTurnInfo)cfg.turn_infos.get(Integer.valueOf(((ReceiveAllLottoAwardRoleInfoArg)this.arg).getTurn()));
/*  36 */     if (turnInfo == null)
/*     */     {
/*     */ 
/*  39 */       onFail(-3, null);
/*  40 */       return false;
/*     */     }
/*     */     
/*  43 */     long globalActivityCfgid = GameServerInfoManager.toGlobalId(((ReceiveAllLottoAwardRoleInfoArg)this.arg).getActivityCfgid());
/*  44 */     lock(All_lotto_infos.getTable(), java.util.Arrays.asList(new Long[] { Long.valueOf(globalActivityCfgid) }));
/*  45 */     AllLottoInfo xAllLottoInfo = All_lotto_infos.get(Long.valueOf(globalActivityCfgid));
/*  46 */     if (xAllLottoInfo == null)
/*     */     {
/*  48 */       xAllLottoInfo = Pod.newAllLottoInfo();
/*  49 */       All_lotto_infos.insert(Long.valueOf(globalActivityCfgid), xAllLottoInfo);
/*     */     }
/*  51 */     if (xAllLottoInfo.getTurn_infos().containsKey(Integer.valueOf(((ReceiveAllLottoAwardRoleInfoArg)this.arg).getTurn())))
/*     */     {
/*     */ 
/*  54 */       onFail(-9, null);
/*  55 */       return false;
/*     */     }
/*  57 */     AllLottoTurnInfo xAllLottoTurnInfo = Pod.newAllLottoTurnInfo();
/*  58 */     xAllLottoInfo.getTurn_infos().put(Integer.valueOf(((ReceiveAllLottoAwardRoleInfoArg)this.arg).getTurn()), xAllLottoTurnInfo);
/*  59 */     if (!((ReceiveAllLottoAwardRoleInfoArg)this.arg).getAwardRoleInfos().isEmpty())
/*     */     {
/*  61 */       for (AllLottoRoleInfo roleInfo : ((ReceiveAllLottoAwardRoleInfoArg)this.arg).getAwardRoleInfos())
/*     */       {
/*  63 */         AllLottoAwardRoleInfo xAllLottoAwardRoleInfo = Pod.newAllLottoAwardRoleInfo();
/*  64 */         xAllLottoTurnInfo.getAward_role_infos().add(xAllLottoAwardRoleInfo);
/*  65 */         xAllLottoAwardRoleInfo.setRoleid(roleInfo.roleid);
/*  66 */         xAllLottoAwardRoleInfo.setRole_name(roleInfo.role_name.getString("UTF-8"));
/*  67 */         xAllLottoAwardRoleInfo.setOccupation(roleInfo.occupation);
/*  68 */         xAllLottoAwardRoleInfo.setGender(roleInfo.gender);
/*  69 */         xAllLottoAwardRoleInfo.setLevel(roleInfo.level);
/*  70 */         xAllLottoAwardRoleInfo.setAvatarid(roleInfo.avatarid);
/*  71 */         xAllLottoAwardRoleInfo.setAvatar_frameid(roleInfo.avatar_frameid);
/*     */       }
/*     */       
/*  74 */       if (AllLottoManager.isAllLottoSwitchOpen())
/*     */       {
/*  76 */         SBrdAllLottoResult protocol = new SBrdAllLottoResult();
/*  77 */         protocol.activity_cfg_id = ((ReceiveAllLottoAwardRoleInfoArg)this.arg).getActivityCfgid();
/*  78 */         protocol.turn = ((ReceiveAllLottoAwardRoleInfoArg)this.arg).getTurn();
/*  79 */         for (AllLottoRoleInfo roleInfo : ((ReceiveAllLottoAwardRoleInfoArg)this.arg).getAwardRoleInfos())
/*     */         {
/*  81 */           RoleInfo awardRoleInfo = new RoleInfo();
/*  82 */           protocol.award_role_infos.add(awardRoleInfo);
/*  83 */           awardRoleInfo.roleid = roleInfo.roleid;
/*  84 */           awardRoleInfo.role_name.setString(roleInfo.role_name.getString("UTF-8"), "UTF-8");
/*  85 */           awardRoleInfo.occupation = roleInfo.occupation;
/*  86 */           awardRoleInfo.gender = roleInfo.gender;
/*  87 */           awardRoleInfo.level = roleInfo.level;
/*  88 */           awardRoleInfo.avatarid = roleInfo.avatarid;
/*  89 */           awardRoleInfo.avatar_frameid = roleInfo.avatar_frameid;
/*     */         }
/*  91 */         OnlineManager.getInstance().sendAll(protocol);
/*     */       }
/*     */       
/*  94 */       for (AllLottoRoleInfo roleInfo : ((ReceiveAllLottoAwardRoleInfoArg)this.arg).getAwardRoleInfos())
/*     */       {
/*  96 */         if (GameServerInfoManager.isRoleInOwnServer(roleInfo.roleid))
/*     */         {
/*  98 */           TriggerEventsManger.getInstance().triggerEvent(new mzm.gsp.alllotto.event.RoleGetALLLottoAward(), new mzm.gsp.alllotto.event.RoleGetALLLottoAwardArg(((ReceiveAllLottoAwardRoleInfoArg)this.arg).getActivityCfgid(), ((ReceiveAllLottoAwardRoleInfoArg)this.arg).getTurn(), roleInfo.roleid));
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 103 */     GameServer.logger().info(String.format("[alllotto]POnReceiveAllLottoAwardRoleInfo.processImp@receive all lotto award role info process success|activity_cfg_id=%d|turn=%d", new Object[] { Integer.valueOf(((ReceiveAllLottoAwardRoleInfoArg)this.arg).getActivityCfgid()), Integer.valueOf(((ReceiveAllLottoAwardRoleInfoArg)this.arg).getTurn()) }));
/*     */     
/*     */ 
/*     */ 
/* 107 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(int res, Map<String, Object> extraInfo)
/*     */   {
/* 112 */     StringBuilder sb = new StringBuilder();
/* 113 */     sb.append(String.format("[alllotto]POnReceiveAllLottoAwardRoleInfo.processImp@receive all lotto award role info process fail|activity_cfg_id=%d|turn=%d|res=%d", new Object[] { Integer.valueOf(((ReceiveAllLottoAwardRoleInfoArg)this.arg).getActivityCfgid()), Integer.valueOf(((ReceiveAllLottoAwardRoleInfoArg)this.arg).getTurn()), Integer.valueOf(res) }));
/*     */     
/*     */ 
/* 116 */     if (extraInfo != null)
/*     */     {
/* 118 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 120 */         sb.append("|").append((String)entry.getKey());
/* 121 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 124 */     GameServer.logger().info(sb.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\alllotto\main\POnReceiveAllLottoAwardRoleInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */