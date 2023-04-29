/*     */ package mzm.gsp.alllotto.main;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.alllotto.confbean.SAllLottoCfg;
/*     */ import mzm.gsp.alllotto.event.RoleGetALLLottoAward;
/*     */ import mzm.gsp.alllotto.event.RoleGetALLLottoAwardArg;
/*     */ import mzm.gsp.grc.event.GetAllLottoAwardRoleInfoDoneArg;
/*     */ import mzm.gsp.grc.event.GetAllLottoAwardRoleInfoDoneProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import org.json.JSONObject;
/*     */ import xbean.AllLottoAwardRoleInfo;
/*     */ import xbean.AllLottoInfo;
/*     */ import xbean.AllLottoTurnInfo;
/*     */ import xbean.Pod;
/*     */ import xtable.All_lotto_infos;
/*     */ 
/*     */ public class POnGetAllLottoAwardRoleInfoDone
/*     */   extends GetAllLottoAwardRoleInfoDoneProcedure
/*     */ {
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  32 */     SAllLottoCfg cfg = SAllLottoCfg.get(((GetAllLottoAwardRoleInfoDoneArg)this.arg).getActivityCfgid());
/*  33 */     if (cfg == null)
/*     */     {
/*     */ 
/*  36 */       onFail(-3, null);
/*  37 */       return false;
/*     */     }
/*  39 */     if (!((GetAllLottoAwardRoleInfoDoneArg)this.arg).isSucceed())
/*     */     {
/*  41 */       GameServer.logger().info(String.format("[alllotto]POnGetAllLottoAwardRoleInfoDone.processImp@get all lotto award role info process success, get fail|activity_cfg_id=%d|retcode=%d", new Object[] { Integer.valueOf(((GetAllLottoAwardRoleInfoDoneArg)this.arg).getActivityCfgid()), Integer.valueOf(((GetAllLottoAwardRoleInfoDoneArg)this.arg).getRetCode()) }));
/*     */       
/*     */ 
/*     */ 
/*  45 */       return false;
/*     */     }
/*  47 */     OctetsStream result = OctetsStream.wrap(((GetAllLottoAwardRoleInfoDoneArg)this.arg).getResult());
/*  48 */     Map<Integer, List<String>> roleInfos = new HashMap();
/*  49 */     parseGrcResult(result, roleInfos);
/*     */     
/*  51 */     long globalActivityCfgid = GameServerInfoManager.toGlobalId(((GetAllLottoAwardRoleInfoDoneArg)this.arg).getActivityCfgid());
/*  52 */     lock(All_lotto_infos.getTable(), Arrays.asList(new Long[] { Long.valueOf(globalActivityCfgid) }));
/*  53 */     AllLottoInfo xAllLottoInfo = All_lotto_infos.get(Long.valueOf(globalActivityCfgid));
/*  54 */     if (xAllLottoInfo == null)
/*     */     {
/*  56 */       xAllLottoInfo = Pod.newAllLottoInfo();
/*  57 */       All_lotto_infos.insert(Long.valueOf(globalActivityCfgid), xAllLottoInfo);
/*     */     }
/*  59 */     for (Map.Entry<Integer, List<String>> entry : roleInfos.entrySet())
/*     */     {
/*  61 */       turn = ((Integer)entry.getKey()).intValue();
/*  62 */       List<String> strs = (List)entry.getValue();
/*  63 */       if (!xAllLottoInfo.getTurn_infos().containsKey(Integer.valueOf(turn)))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*  68 */         AllLottoTurnInfo xAllLottoTurnInfo = Pod.newAllLottoTurnInfo();
/*  69 */         xAllLottoInfo.getTurn_infos().put(Integer.valueOf(turn), xAllLottoTurnInfo);
/*  70 */         for (String str : strs)
/*     */         {
/*  72 */           JSONObject json = new JSONObject(str);
/*  73 */           long roleid = 0L;
/*  74 */           if (json.has("roleid"))
/*     */           {
/*  76 */             roleid = json.getLong("roleid");
/*     */           }
/*  78 */           if (roleid > 0L)
/*     */           {
/*     */ 
/*     */ 
/*  82 */             String roleName = "";
/*  83 */             if (json.has("role_name"))
/*     */             {
/*  85 */               roleName = json.getString("role_name");
/*     */             }
/*  87 */             int occupation = 0;
/*  88 */             if (json.has("occupation"))
/*     */             {
/*  90 */               occupation = json.getInt("occupation");
/*     */             }
/*  92 */             int gender = 0;
/*  93 */             if (json.has("gender"))
/*     */             {
/*  95 */               gender = json.getInt("gender");
/*     */             }
/*  97 */             int level = 0;
/*  98 */             if (json.has("level"))
/*     */             {
/* 100 */               level = json.getInt("level");
/*     */             }
/* 102 */             int avatarid = 0;
/* 103 */             if (json.has("avatarid"))
/*     */             {
/* 105 */               avatarid = json.getInt("avatarid");
/*     */             }
/* 107 */             int avatarFrameid = 0;
/* 108 */             if (json.has("avatar_frameid"))
/*     */             {
/* 110 */               avatarFrameid = json.getInt("avatar_frameid");
/*     */             }
/*     */             
/* 113 */             AllLottoAwardRoleInfo xAllLottoAwardRoleInfo = Pod.newAllLottoAwardRoleInfo();
/* 114 */             xAllLottoTurnInfo.getAward_role_infos().add(xAllLottoAwardRoleInfo);
/* 115 */             xAllLottoAwardRoleInfo.setRoleid(roleid);
/* 116 */             xAllLottoAwardRoleInfo.setRole_name(roleName);
/* 117 */             xAllLottoAwardRoleInfo.setOccupation(occupation);
/* 118 */             xAllLottoAwardRoleInfo.setGender(gender);
/* 119 */             xAllLottoAwardRoleInfo.setLevel(level);
/* 120 */             xAllLottoAwardRoleInfo.setAvatarid(avatarid);
/* 121 */             xAllLottoAwardRoleInfo.setAvatar_frameid(avatarFrameid);
/*     */           }
/*     */         }
/* 124 */         for (AllLottoAwardRoleInfo xAllLottoAwardRoleInfo : xAllLottoTurnInfo.getAward_role_infos())
/*     */         {
/* 126 */           if (GameServerInfoManager.isRoleInOwnServer(xAllLottoAwardRoleInfo.getRoleid()))
/*     */           {
/* 128 */             TriggerEventsManger.getInstance().triggerEvent(new RoleGetALLLottoAward(), new RoleGetALLLottoAwardArg(((GetAllLottoAwardRoleInfoDoneArg)this.arg).getActivityCfgid(), turn, xAllLottoAwardRoleInfo.getRoleid())); }
/*     */         }
/*     */       }
/*     */     }
/*     */     int turn;
/* 133 */     GameServer.logger().info(String.format("[alllotto]POnGetAllLottoAwardRoleInfoDone.processImp@get all lotto award role info process success, get success|activity_cfg_id=%d", new Object[] { Integer.valueOf(((GetAllLottoAwardRoleInfoDoneArg)this.arg).getActivityCfgid()) }));
/*     */     
/*     */ 
/*     */ 
/* 137 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(int res, Map<String, Object> extraInfo)
/*     */   {
/* 142 */     StringBuilder sb = new StringBuilder();
/* 143 */     sb.append(String.format("[alllotto]POnGetAllLottoAwardRoleInfoDone.processImp@get all lotto award role info process fail|activity_cfg_id=%d|res=%d", new Object[] { Integer.valueOf(((GetAllLottoAwardRoleInfoDoneArg)this.arg).getActivityCfgid()), Integer.valueOf(res) }));
/*     */     
/*     */ 
/* 146 */     if (extraInfo != null)
/*     */     {
/* 148 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 150 */         sb.append("|").append((String)entry.getKey());
/* 151 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 154 */     GameServer.logger().info(sb.toString());
/*     */   }
/*     */   
/*     */   private void parseGrcResult(OctetsStream os, Map<Integer, List<String>> roleInfos)
/*     */   {
/*     */     try
/*     */     {
/* 161 */       for (int i = os.uncompact_uint32(); i > 0; i--)
/*     */       {
/* 163 */         int turn = os.unmarshal_int();
/* 164 */         List<String> strs = new ArrayList();
/* 165 */         roleInfos.put(Integer.valueOf(turn), strs);
/* 166 */         for (int j = os.uncompact_uint32(); j > 0; j--)
/*     */         {
/* 168 */           strs.add(os.unmarshal_String("UTF-8"));
/*     */         }
/*     */       }
/*     */     }
/*     */     catch (MarshalException e) {}
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\alllotto\main\POnGetAllLottoAwardRoleInfoDone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */