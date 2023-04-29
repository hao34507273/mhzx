/*     */ package mzm.gsp.instance.main;
/*     */ 
/*     */ import java.io.PrintStream;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.avatar.frame.AvatarFrameInterface;
/*     */ import mzm.gsp.avatar.main.AvatarInterface;
/*     */ import mzm.gsp.instance.RoleInfo;
/*     */ import mzm.gsp.instance.SBrocastTeamInstanceItem;
/*     */ import mzm.gsp.instance.SGetOrRefuseItemRes;
/*     */ import mzm.gsp.instance.SSynAwardItemInfo;
/*     */ import mzm.gsp.instance.confbean.SInstanceConsts;
/*     */ import mzm.gsp.instance.event.BoxAwardArg;
/*     */ import mzm.gsp.instance.event.BoxAwardEvent;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.Role;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.AwardBean;
/*     */ import xbean.BoxAwardBean;
/*     */ import xbean.BoxAwardContext;
/*     */ import xbean.Pod;
/*     */ import xdb.Procedure;
/*     */ import xtable.Boxaward;
/*     */ import xtable.Boxawardcontext;
/*     */ 
/*     */ public class BoxAwardManager
/*     */ {
/*  36 */   private static BoxAwardManager instance = new BoxAwardManager();
/*     */   
/*     */   private static final int randomLength = 100;
/*     */   
/*  40 */   private static final int[] randomArray = new int[100];
/*     */   
/*     */   static {
/*  43 */     for (int i = 0; i < 100; i++) {
/*  44 */       randomArray[i] = (i + 1);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static BoxAwardManager getInstance()
/*     */   {
/*  52 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void awardItems(final List<Long> awardRoles, List<Integer> items, AwardContext awardContext)
/*     */   {
/*  66 */     if ((awardRoles.size() <= 0) || (items.size() <= 0))
/*     */     {
/*  68 */       BoxAwardEvent boxAwardEvent = new BoxAwardEvent();
/*  69 */       Map<Long, List<Integer>> awardroleMap = new HashMap();
/*  70 */       TriggerEventsManger.getInstance().triggerEvent(boxAwardEvent, new BoxAwardArg(awardRoles, awardroleMap, awardContext));
/*     */       
/*  72 */       return;
/*     */     }
/*  74 */     BoxAwardBean boxAwardBean = Pod.newBoxAwardBean();
/*  75 */     boxAwardBean.getAwarditemids().addAll(items);
/*  76 */     boxAwardBean.getRoleids().addAll(awardRoles);
/*     */     
/*     */ 
/*  79 */     final long awardUuid = Boxaward.insert(boxAwardBean).longValue();
/*  80 */     if (awardContext != null) {
/*  81 */       BoxAwardContext boxAwardContext = Pod.newBoxAwardContext();
/*  82 */       boxAwardContext.setContext(awardContext);
/*     */       
/*  84 */       Boxawardcontext.insert(Long.valueOf(awardUuid), boxAwardContext);
/*     */     }
/*     */     
/*  87 */     List<Integer> rollRet = roll(awardRoles.size());
/*     */     
/*  89 */     for (int index = 0; index < rollRet.size(); index++) {
/*  90 */       boxAwardBean.getRollrolemap().put(awardRoles.get(index), rollRet.get(index));
/*     */     }
/*     */     
/*     */ 
/*  94 */     Procedure.execute(new LogicProcedure()
/*     */     {
/*     */       protected boolean processImp() throws Exception
/*     */       {
/*  98 */         SSynAwardItemInfo synAwardItemInfo = new SSynAwardItemInfo();
/*  99 */         synAwardItemInfo.awarduuid = awardUuid;
/* 100 */         synAwardItemInfo.itemid = ((Integer)awardRoles.get(0)).intValue();
/* 101 */         for (Iterator i$ = this.val$awardRoles.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/* 102 */           RoleInfo roleInfo = new RoleInfo();
/*     */           
/* 104 */           Role role = RoleInterface.getRole(roleid, false);
/* 105 */           BoxAwardManager.this.fillinRoleinfo(role, roleInfo);
/* 106 */           roleInfo.avatarid = AvatarInterface.getCurrentAvatar(roleid, false);
/* 107 */           roleInfo.avatar_frame_id = AvatarFrameInterface.getCurrentAvatarFrameId(roleid, false);
/* 108 */           synAwardItemInfo.roles.add(roleInfo);
/*     */         }
/*     */         
/* 111 */         OnlineManager.getInstance().sendMulti(synAwardItemInfo, this.val$awardRoles);
/*     */         
/* 113 */         new BoxAwardTimer(SInstanceConsts.getInstance().ROLL_ITEM_SECOND + 2, awardUuid, 0);
/* 114 */         return true;
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   boolean award(long awardRoleid, final long awardUuid, BoxAwardBean xTrueAwardBean, BoxAwardContext xBoxAwardContext, int awardIndex)
/*     */   {
/* 132 */     if (xTrueAwardBean == null) {
/* 133 */       return false;
/*     */     }
/* 135 */     final List<Long> allRoles = new ArrayList();
/* 136 */     allRoles.addAll(xTrueAwardBean.getRoleids());
/* 137 */     if (xTrueAwardBean.getIndex() == awardIndex) {
/* 138 */       int itemid = ((Integer)xTrueAwardBean.getAwarditemids().get(xTrueAwardBean.getIndex())).intValue();
/* 139 */       if (awardRoleid > 0L)
/*     */       {
/* 141 */         int instancecfgid = 0;
/* 142 */         if (xBoxAwardContext != null) {
/* 143 */           AwardContext awardContext = xBoxAwardContext.getContext();
/* 144 */           if ((awardContext instanceof TeamAwardContext)) {
/* 145 */             instancecfgid = ((TeamAwardContext)awardContext).instanceid;
/*     */           }
/*     */         }
/* 148 */         if (!mzm.gsp.idip.main.IdipManager.isZeroProfit(awardRoleid)) {
/* 149 */           mzm.gsp.item.main.ItemInterface.addItem(awardRoleid, itemid, 1, new mzm.gsp.tlog.TLogArg(mzm.gsp.tlog.LogReason.INSTANCE_BOX_AWARD_ADD, instancecfgid));
/* 150 */           if (mzm.gsp.itembulletin.main.ItemBulletinInterface.needBulletin(itemid))
/*     */           {
/* 152 */             SBrocastTeamInstanceItem protocol = new SBrocastTeamInstanceItem();
/*     */             try
/*     */             {
/* 155 */               protocol.role_name.setString(RoleInterface.getName(awardRoleid), "UTF-8");
/*     */             }
/*     */             catch (UnsupportedEncodingException e) {}
/*     */             
/*     */ 
/*     */ 
/* 161 */             protocol.instance_cfg_id = instancecfgid;
/* 162 */             protocol.item_cfg_id = itemid;
/* 163 */             OnlineManager.getInstance().sendAll(protocol);
/*     */           }
/*     */         }
/* 166 */         if (xTrueAwardBean.getAwardrolemap().containsKey(Long.valueOf(awardRoleid))) {
/* 167 */           ((AwardBean)xTrueAwardBean.getAwardrolemap().get(Long.valueOf(awardRoleid))).getAwarditems().add(Integer.valueOf(itemid));
/*     */         } else {
/* 169 */           AwardBean awardBean = Pod.newAwardBean();
/* 170 */           awardBean.getAwarditems().add(Integer.valueOf(itemid));
/* 171 */           xTrueAwardBean.getAwardrolemap().put(Long.valueOf(awardRoleid), awardBean);
/*     */         }
/*     */       }
/*     */       
/* 175 */       for (Iterator i$ = allRoles.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/* 176 */         if (!xTrueAwardBean.getOperroleids().contains(Long.valueOf(roleid))) {
/* 177 */           SGetOrRefuseItemRes getOrRefuseItemRes = new SGetOrRefuseItemRes();
/* 178 */           getOrRefuseItemRes.code = ((Integer)xTrueAwardBean.getRollrolemap().get(Long.valueOf(roleid))).intValue();
/* 179 */           getOrRefuseItemRes.awarduuid = awardUuid;
/* 180 */           getOrRefuseItemRes.itemid = itemid;
/* 181 */           getOrRefuseItemRes.roleid = roleid;
/* 182 */           OnlineManager.getInstance().sendMulti(getOrRefuseItemRes, allRoles);
/*     */         }
/*     */       }
/*     */       
/*     */ 
/* 187 */       mzm.gsp.instance.SSynGetAwardBoxItemRes synGetAwardBoxItemRes = new mzm.gsp.instance.SSynGetAwardBoxItemRes();
/* 188 */       synGetAwardBoxItemRes.awarduuid = awardUuid;
/* 189 */       synGetAwardBoxItemRes.itemid = itemid;
/* 190 */       synGetAwardBoxItemRes.roleid = awardRoleid;
/* 191 */       OnlineManager.getInstance().sendMulti(synGetAwardBoxItemRes, allRoles);
/*     */       
/* 193 */       xTrueAwardBean.setIndex(xTrueAwardBean.getIndex() + 1);
/* 194 */       xTrueAwardBean.getOperroleids().clear();
/* 195 */       xTrueAwardBean.getRollrolemap().clear();
/*     */       
/* 197 */       List<Integer> rollRet = roll(allRoles.size());
/*     */       
/* 199 */       for (int index = 0; index < rollRet.size(); index++) {
/* 200 */         xTrueAwardBean.getRollrolemap().put(allRoles.get(index), rollRet.get(index));
/*     */       }
/*     */       
/* 203 */       if (xTrueAwardBean.getIndex() >= xTrueAwardBean.getAwarditemids().size())
/*     */       {
/* 205 */         BoxAwardEvent boxAwardEvent = new BoxAwardEvent();
/* 206 */         Map<Long, List<Integer>> awardroleMap = new HashMap();
/* 207 */         for (Map.Entry<Long, AwardBean> entry : xTrueAwardBean.getAwardrolemap().entrySet()) {
/* 208 */           awardroleMap.put(entry.getKey(), ((AwardBean)entry.getValue()).getAwarditems());
/*     */         }
/* 210 */         AwardContext awardContext = null;
/* 211 */         if (xBoxAwardContext != null) {
/* 212 */           awardContext = xBoxAwardContext.getContext();
/*     */         }
/* 214 */         TriggerEventsManger.getInstance().triggerEvent(boxAwardEvent, new BoxAwardArg(xTrueAwardBean.getRoleids(), awardroleMap, awardContext));
/*     */         
/*     */ 
/* 217 */         Boxaward.remove(Long.valueOf(awardUuid));
/*     */       }
/*     */       else {
/* 220 */         final int nextIndex = xTrueAwardBean.getIndex();
/* 221 */         int nextItemid = ((Integer)xTrueAwardBean.getAwarditemids().get(nextIndex)).intValue();
/* 222 */         Procedure.execute(new LogicProcedure()
/*     */         {
/*     */           protected boolean processImp() throws Exception
/*     */           {
/* 226 */             SSynAwardItemInfo synAwardItemInfo = new SSynAwardItemInfo();
/* 227 */             synAwardItemInfo.awarduuid = awardUuid;
/* 228 */             synAwardItemInfo.itemid = allRoles;
/* 229 */             for (Iterator i$ = nextIndex.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/* 230 */               RoleInfo roleInfo = new RoleInfo();
/*     */               
/* 232 */               Role role = RoleInterface.getRole(roleid, false);
/* 233 */               BoxAwardManager.this.fillinRoleinfo(role, roleInfo);
/* 234 */               roleInfo.avatarid = AvatarInterface.getCurrentAvatar(roleid, false);
/* 235 */               roleInfo.avatar_frame_id = AvatarFrameInterface.getCurrentAvatarFrameId(roleid, false);
/* 236 */               synAwardItemInfo.roles.add(roleInfo);
/*     */             }
/*     */             
/* 239 */             OnlineManager.getInstance().sendMulti(synAwardItemInfo, nextIndex);
/*     */             
/* 241 */             new BoxAwardTimer(SInstanceConsts.getInstance().ROLL_ITEM_SECOND + 2, awardUuid, this.val$nextIndex);
/* 242 */             return true;
/*     */           }
/*     */         });
/*     */       }
/* 246 */       return true;
/*     */     }
/* 248 */     return false;
/*     */   }
/*     */   
/*     */   public void fillinRoleinfo(Role role, RoleInfo roleInfo) {
/* 252 */     roleInfo.roleid = role.getId();
/* 253 */     roleInfo.rolename = role.getName();
/* 254 */     roleInfo.gender = role.getGender();
/* 255 */     roleInfo.occupation = role.getOccupationId();
/*     */   }
/*     */   
/*     */   long getAwardRoleid(BoxAwardBean xBoxAwardBean) {
/* 259 */     long awardRoleid = -1L;
/* 260 */     long maxPoint = 0L;
/* 261 */     for (Map.Entry<Long, Integer> entry : xBoxAwardBean.getRollrolemap().entrySet()) {
/* 262 */       if (((Integer)entry.getValue()).intValue() > maxPoint) {
/* 263 */         maxPoint = ((Integer)entry.getValue()).intValue();
/* 264 */         awardRoleid = ((Long)entry.getKey()).longValue();
/*     */       }
/*     */     }
/* 267 */     return awardRoleid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   boolean getOrRefuseItem(long roleid, final long awardUuid, BoxAwardBean xBoxAwardBean, int itemid, int operation)
/*     */   {
/* 283 */     if (xBoxAwardBean == null) {
/* 284 */       return false;
/*     */     }
/* 286 */     int awardIndex = xBoxAwardBean.getIndex();
/* 287 */     int awardItemid = ((Integer)xBoxAwardBean.getAwarditemids().get(awardIndex)).intValue();
/* 288 */     if (awardItemid != itemid) {
/* 289 */       return false;
/*     */     }
/* 291 */     if (!xBoxAwardBean.getRoleids().contains(Long.valueOf(roleid))) {
/* 292 */       return false;
/*     */     }
/* 294 */     if (operation == 1) {
/* 295 */       xBoxAwardBean.getRollrolemap().put(Long.valueOf(roleid), Integer.valueOf(-1));
/*     */     }
/* 297 */     xBoxAwardBean.getOperroleids().add(Long.valueOf(roleid));
/*     */     
/* 299 */     SGetOrRefuseItemRes getOrRefuseItemRes = new SGetOrRefuseItemRes();
/* 300 */     getOrRefuseItemRes.code = ((Integer)xBoxAwardBean.getRollrolemap().get(Long.valueOf(roleid))).intValue();
/* 301 */     getOrRefuseItemRes.awarduuid = awardUuid;
/* 302 */     getOrRefuseItemRes.itemid = itemid;
/* 303 */     getOrRefuseItemRes.roleid = roleid;
/* 304 */     OnlineManager.getInstance().sendMulti(getOrRefuseItemRes, xBoxAwardBean.getRoleids());
/*     */     
/* 306 */     if (xBoxAwardBean.getOperroleids().containsAll(xBoxAwardBean.getRoleids())) {
/* 307 */       Procedure.execute(new LogicProcedure()
/*     */       {
/*     */         protected boolean processImp()
/*     */           throws Exception
/*     */         {
/* 312 */           BoxAwardBean xTempAwardBean = Boxaward.select(Long.valueOf(awardUuid));
/* 313 */           if (xTempAwardBean == null) {
/* 314 */             return false;
/*     */           }
/*     */           
/* 317 */           long awardRoleid = BoxAwardManager.this.getAwardRoleid(xTempAwardBean);
/*     */           
/*     */ 
/* 320 */           lock(xtable.Role2properties.getTable(), java.util.Arrays.asList(new Long[] { Long.valueOf(awardRoleid) }));
/*     */           
/* 322 */           BoxAwardBean xTrueAwardBean = Boxaward.get(Long.valueOf(awardUuid));
/* 323 */           BoxAwardContext xBoxAwardContext = Boxawardcontext.get(Long.valueOf(awardUuid));
/* 324 */           return BoxAwardManager.this.award(awardRoleid, awardUuid, xTrueAwardBean, xBoxAwardContext, this.val$awardIndex);
/*     */         }
/*     */       });
/*     */     }
/* 328 */     return true;
/*     */   }
/*     */   
/*     */   private synchronized List<Integer> roll(int size) {
/* 332 */     if (size > 100) {
/* 333 */       throw new RuntimeException("随机个数不能够大于randomMax:100");
/*     */     }
/* 335 */     List<Integer> list = new ArrayList();
/*     */     
/* 337 */     if (size == 100) {
/* 338 */       for (int i = 0; i < 100; i++) {
/* 339 */         list.add(Integer.valueOf(randomArray[i]));
/*     */       }
/* 341 */       return list;
/*     */     }
/*     */     
/* 344 */     for (int i = 0; i < size; i++) {
/* 345 */       int random = xdb.Xdb.random().nextInt(100 - i);
/* 346 */       list.add(Integer.valueOf(randomArray[random]));
/* 347 */       randomArray[random] = randomArray[(99 - i)];
/*     */     }
/*     */     
/* 350 */     for (Iterator i$ = list.iterator(); i$.hasNext();) { int value = ((Integer)i$.next()).intValue();
/* 351 */       randomArray[(value - 1)] = value;
/*     */     }
/* 353 */     return list;
/*     */   }
/*     */   
/*     */   public static void main(String[] args) {
/* 357 */     Set<Integer> set = new java.util.HashSet();
/* 358 */     for (int j = 0; j < 100000; j++) {
/* 359 */       for (Iterator i$ = getInstance().roll(5).iterator(); i$.hasNext();) { int i = ((Integer)i$.next()).intValue();
/* 360 */         if (set.contains(Integer.valueOf(i))) {
/* 361 */           System.err.println("相同的值" + i);
/*     */         }
/* 363 */         set.add(Integer.valueOf(i));
/*     */       }
/* 365 */       set.clear();
/* 366 */       for (int i = 0; i < 100; i++) {
/* 367 */         if (randomArray[i] != i + 1) {
/* 368 */           System.err.println(randomArray[i] + ",i=" + i);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\instance\main\BoxAwardManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */