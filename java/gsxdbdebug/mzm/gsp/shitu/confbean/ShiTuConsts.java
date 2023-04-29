/*     */ package mzm.gsp.shitu.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.SAXReader;
/*     */ 
/*     */ public class ShiTuConsts
/*     */ {
/*  13 */   private static volatile ShiTuConsts oldInstance = null;
/*     */   
/*  15 */   private static ShiTuConsts instance = new ShiTuConsts();
/*     */   public int apprenticeMinLevel;
/*     */   public int minHighLevel;
/*     */   public int maxApprenticeNum;
/*     */   public int relievePunishTime;
/*     */   public int minQinMiDu;
/*     */   
/*     */   public static ShiTuConsts getOldInstance() {
/*  23 */     return oldInstance;
/*     */   }
/*     */   
/*     */   public static ShiTuConsts getInstance()
/*     */   {
/*  28 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */   public int apprenticeAppellationId;
/*     */   
/*     */   public int chuShiAppellationId;
/*     */   
/*     */   public int masterAppellationId;
/*     */   
/*     */   public int chuShiAwardId;
/*     */   
/*     */   public int chuShiApprenticeMinLevel;
/*     */   
/*     */   public int chuShiRelationMinTime;
/*     */   public int chuShiMinQinMiDu;
/*     */   public int waitSeconds;
/*     */   public int chuShiMailID;
/*     */   public int forceRelieveMailID;
/*     */   public int shiTuNPCId;
/*     */   public int teamConditionIdShouTu;
/*     */   public int levelConditionIdShouTu;
/*     */   public int apprenticeConditionIdShouTu;
/*     */   public int masterNumLimitConditionIdShouTu;
/*     */   public int punishConditionIdShouTu;
/*     */   public int qinMiDuConditionIdShouTu;
/*     */   public int apprenticeLevelConditionIdChuShi;
/*     */   public int relationTimeConditionIdChuShi;
/*     */   public int qinMiDuConditionIdChuShi;
/*     */   public int masterRankPageSize;
/*     */   public int graduateApprenticePageSize;
/*     */   public int payRespectMaxTimes;
/*     */   public int masterReplyRespectTimes;
/*     */   public int apprenticePayRespectAwardExp;
/*     */   public int payRespectAwardRelationValue;
/*     */   public int apprenticePayRespectTips;
/*     */   public int payRespectDefaultTips;
/*     */   public int masterPayRespectTips;
/*     */   public int apprenticeRoleLevelLimit;
/*     */   public int payRespectActivityId;
/*     */   public int payRespectStrMaxLength;
/*     */   public int shouTuNpcServiceId;
/*     */   public int chuShiNpcServiceId;
/*     */   public int defectNpcServiceId;
/*     */   public int dismissNpcServiceId;
/*     */   public static void loadXml(String dir)
/*     */   {
/*  75 */     instance.doLoadXml(dir);
/*     */   }
/*     */   
/*     */   private void doLoadXml(String dir)
/*     */   {
/*  80 */     String path = dir + "mzm.gsp.shitu.confbean.ShiTuConsts.xml";
/*     */     try
/*     */     {
/*  83 */       SAXReader reader = new SAXReader();
/*  84 */       org.dom4j.Document doc = reader.read(new File(path));
/*  85 */       Element root = doc.getRootElement();
/*  86 */       Map<String, Element> data = new java.util.HashMap();
/*  87 */       java.util.List<?> nodeList = root.elements();
/*  88 */       int len = nodeList.size();
/*  89 */       for (int i = 0; i < len; i++)
/*     */       {
/*  91 */         Element element = (Element)nodeList.get(i);
/*  92 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/*  95 */           String name = element.attributeValue("name");
/*  96 */           if (data.put(name, element) != null)
/*  97 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/* 100 */       this.apprenticeMinLevel = Integer.valueOf(((Element)data.get("apprenticeMinLevel")).attributeValue("value")).intValue();
/* 101 */       this.minHighLevel = Integer.valueOf(((Element)data.get("minHighLevel")).attributeValue("value")).intValue();
/* 102 */       this.maxApprenticeNum = Integer.valueOf(((Element)data.get("maxApprenticeNum")).attributeValue("value")).intValue();
/* 103 */       this.relievePunishTime = Integer.valueOf(((Element)data.get("relievePunishTime")).attributeValue("value")).intValue();
/* 104 */       this.minQinMiDu = Integer.valueOf(((Element)data.get("minQinMiDu")).attributeValue("value")).intValue();
/* 105 */       this.apprenticeAppellationId = Integer.valueOf(((Element)data.get("apprenticeAppellationId")).attributeValue("value")).intValue();
/* 106 */       this.chuShiAppellationId = Integer.valueOf(((Element)data.get("chuShiAppellationId")).attributeValue("value")).intValue();
/* 107 */       this.masterAppellationId = Integer.valueOf(((Element)data.get("masterAppellationId")).attributeValue("value")).intValue();
/* 108 */       this.chuShiAwardId = Integer.valueOf(((Element)data.get("chuShiAwardId")).attributeValue("value")).intValue();
/* 109 */       this.chuShiApprenticeMinLevel = Integer.valueOf(((Element)data.get("chuShiApprenticeMinLevel")).attributeValue("value")).intValue();
/* 110 */       this.chuShiRelationMinTime = Integer.valueOf(((Element)data.get("chuShiRelationMinTime")).attributeValue("value")).intValue();
/* 111 */       this.chuShiMinQinMiDu = Integer.valueOf(((Element)data.get("chuShiMinQinMiDu")).attributeValue("value")).intValue();
/* 112 */       this.waitSeconds = Integer.valueOf(((Element)data.get("waitSeconds")).attributeValue("value")).intValue();
/* 113 */       this.chuShiMailID = Integer.valueOf(((Element)data.get("chuShiMailID")).attributeValue("value")).intValue();
/* 114 */       this.forceRelieveMailID = Integer.valueOf(((Element)data.get("forceRelieveMailID")).attributeValue("value")).intValue();
/* 115 */       this.shiTuNPCId = Integer.valueOf(((Element)data.get("shiTuNPCId")).attributeValue("value")).intValue();
/* 116 */       this.teamConditionIdShouTu = Integer.valueOf(((Element)data.get("teamConditionIdShouTu")).attributeValue("value")).intValue();
/* 117 */       this.levelConditionIdShouTu = Integer.valueOf(((Element)data.get("levelConditionIdShouTu")).attributeValue("value")).intValue();
/* 118 */       this.apprenticeConditionIdShouTu = Integer.valueOf(((Element)data.get("apprenticeConditionIdShouTu")).attributeValue("value")).intValue();
/* 119 */       this.masterNumLimitConditionIdShouTu = Integer.valueOf(((Element)data.get("masterNumLimitConditionIdShouTu")).attributeValue("value")).intValue();
/* 120 */       this.punishConditionIdShouTu = Integer.valueOf(((Element)data.get("punishConditionIdShouTu")).attributeValue("value")).intValue();
/* 121 */       this.qinMiDuConditionIdShouTu = Integer.valueOf(((Element)data.get("qinMiDuConditionIdShouTu")).attributeValue("value")).intValue();
/* 122 */       this.apprenticeLevelConditionIdChuShi = Integer.valueOf(((Element)data.get("apprenticeLevelConditionIdChuShi")).attributeValue("value")).intValue();
/* 123 */       this.relationTimeConditionIdChuShi = Integer.valueOf(((Element)data.get("relationTimeConditionIdChuShi")).attributeValue("value")).intValue();
/* 124 */       this.qinMiDuConditionIdChuShi = Integer.valueOf(((Element)data.get("qinMiDuConditionIdChuShi")).attributeValue("value")).intValue();
/* 125 */       this.masterRankPageSize = Integer.valueOf(((Element)data.get("masterRankPageSize")).attributeValue("value")).intValue();
/* 126 */       this.graduateApprenticePageSize = Integer.valueOf(((Element)data.get("graduateApprenticePageSize")).attributeValue("value")).intValue();
/* 127 */       this.payRespectMaxTimes = Integer.valueOf(((Element)data.get("payRespectMaxTimes")).attributeValue("value")).intValue();
/* 128 */       this.masterReplyRespectTimes = Integer.valueOf(((Element)data.get("masterReplyRespectTimes")).attributeValue("value")).intValue();
/* 129 */       this.apprenticePayRespectAwardExp = Integer.valueOf(((Element)data.get("apprenticePayRespectAwardExp")).attributeValue("value")).intValue();
/* 130 */       this.payRespectAwardRelationValue = Integer.valueOf(((Element)data.get("payRespectAwardRelationValue")).attributeValue("value")).intValue();
/* 131 */       this.apprenticePayRespectTips = Integer.valueOf(((Element)data.get("apprenticePayRespectTips")).attributeValue("value")).intValue();
/* 132 */       this.payRespectDefaultTips = Integer.valueOf(((Element)data.get("payRespectDefaultTips")).attributeValue("value")).intValue();
/* 133 */       this.masterPayRespectTips = Integer.valueOf(((Element)data.get("masterPayRespectTips")).attributeValue("value")).intValue();
/* 134 */       this.apprenticeRoleLevelLimit = Integer.valueOf(((Element)data.get("apprenticeRoleLevelLimit")).attributeValue("value")).intValue();
/* 135 */       this.payRespectActivityId = Integer.valueOf(((Element)data.get("payRespectActivityId")).attributeValue("value")).intValue();
/* 136 */       this.payRespectStrMaxLength = Integer.valueOf(((Element)data.get("payRespectStrMaxLength")).attributeValue("value")).intValue();
/* 137 */       this.shouTuNpcServiceId = Integer.valueOf(((Element)data.get("shouTuNpcServiceId")).attributeValue("value")).intValue();
/* 138 */       this.chuShiNpcServiceId = Integer.valueOf(((Element)data.get("chuShiNpcServiceId")).attributeValue("value")).intValue();
/* 139 */       this.defectNpcServiceId = Integer.valueOf(((Element)data.get("defectNpcServiceId")).attributeValue("value")).intValue();
/* 140 */       this.dismissNpcServiceId = Integer.valueOf(((Element)data.get("dismissNpcServiceId")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 144 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadXml(String dir) {
/* 149 */     String path = dir + "mzm.gsp.shitu.confbean.ShiTuConsts.xml";
/*     */     try
/*     */     {
/* 152 */       SAXReader reader = new SAXReader();
/* 153 */       org.dom4j.Document doc = reader.read(new File(path));
/* 154 */       Element root = doc.getRootElement();
/* 155 */       Map<String, Element> data = new java.util.HashMap();
/* 156 */       java.util.List<?> nodeList = root.elements();
/* 157 */       int len = nodeList.size();
/* 158 */       for (int i = 0; i < len; i++)
/*     */       {
/* 160 */         Element element = (Element)nodeList.get(i);
/* 161 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/* 164 */           String name = element.attributeValue("name");
/* 165 */           if (data.put(name, element) != null)
/* 166 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/* 169 */       this.apprenticeMinLevel = Integer.valueOf(((Element)data.get("apprenticeMinLevel")).attributeValue("value")).intValue();
/* 170 */       this.minHighLevel = Integer.valueOf(((Element)data.get("minHighLevel")).attributeValue("value")).intValue();
/* 171 */       this.maxApprenticeNum = Integer.valueOf(((Element)data.get("maxApprenticeNum")).attributeValue("value")).intValue();
/* 172 */       this.relievePunishTime = Integer.valueOf(((Element)data.get("relievePunishTime")).attributeValue("value")).intValue();
/* 173 */       this.minQinMiDu = Integer.valueOf(((Element)data.get("minQinMiDu")).attributeValue("value")).intValue();
/* 174 */       this.apprenticeAppellationId = Integer.valueOf(((Element)data.get("apprenticeAppellationId")).attributeValue("value")).intValue();
/* 175 */       this.chuShiAppellationId = Integer.valueOf(((Element)data.get("chuShiAppellationId")).attributeValue("value")).intValue();
/* 176 */       this.masterAppellationId = Integer.valueOf(((Element)data.get("masterAppellationId")).attributeValue("value")).intValue();
/* 177 */       this.chuShiAwardId = Integer.valueOf(((Element)data.get("chuShiAwardId")).attributeValue("value")).intValue();
/* 178 */       this.chuShiApprenticeMinLevel = Integer.valueOf(((Element)data.get("chuShiApprenticeMinLevel")).attributeValue("value")).intValue();
/* 179 */       this.chuShiRelationMinTime = Integer.valueOf(((Element)data.get("chuShiRelationMinTime")).attributeValue("value")).intValue();
/* 180 */       this.chuShiMinQinMiDu = Integer.valueOf(((Element)data.get("chuShiMinQinMiDu")).attributeValue("value")).intValue();
/* 181 */       this.waitSeconds = Integer.valueOf(((Element)data.get("waitSeconds")).attributeValue("value")).intValue();
/* 182 */       this.chuShiMailID = Integer.valueOf(((Element)data.get("chuShiMailID")).attributeValue("value")).intValue();
/* 183 */       this.forceRelieveMailID = Integer.valueOf(((Element)data.get("forceRelieveMailID")).attributeValue("value")).intValue();
/* 184 */       this.shiTuNPCId = Integer.valueOf(((Element)data.get("shiTuNPCId")).attributeValue("value")).intValue();
/* 185 */       this.teamConditionIdShouTu = Integer.valueOf(((Element)data.get("teamConditionIdShouTu")).attributeValue("value")).intValue();
/* 186 */       this.levelConditionIdShouTu = Integer.valueOf(((Element)data.get("levelConditionIdShouTu")).attributeValue("value")).intValue();
/* 187 */       this.apprenticeConditionIdShouTu = Integer.valueOf(((Element)data.get("apprenticeConditionIdShouTu")).attributeValue("value")).intValue();
/* 188 */       this.masterNumLimitConditionIdShouTu = Integer.valueOf(((Element)data.get("masterNumLimitConditionIdShouTu")).attributeValue("value")).intValue();
/* 189 */       this.punishConditionIdShouTu = Integer.valueOf(((Element)data.get("punishConditionIdShouTu")).attributeValue("value")).intValue();
/* 190 */       this.qinMiDuConditionIdShouTu = Integer.valueOf(((Element)data.get("qinMiDuConditionIdShouTu")).attributeValue("value")).intValue();
/* 191 */       this.apprenticeLevelConditionIdChuShi = Integer.valueOf(((Element)data.get("apprenticeLevelConditionIdChuShi")).attributeValue("value")).intValue();
/* 192 */       this.relationTimeConditionIdChuShi = Integer.valueOf(((Element)data.get("relationTimeConditionIdChuShi")).attributeValue("value")).intValue();
/* 193 */       this.qinMiDuConditionIdChuShi = Integer.valueOf(((Element)data.get("qinMiDuConditionIdChuShi")).attributeValue("value")).intValue();
/* 194 */       this.masterRankPageSize = Integer.valueOf(((Element)data.get("masterRankPageSize")).attributeValue("value")).intValue();
/* 195 */       this.graduateApprenticePageSize = Integer.valueOf(((Element)data.get("graduateApprenticePageSize")).attributeValue("value")).intValue();
/* 196 */       this.payRespectMaxTimes = Integer.valueOf(((Element)data.get("payRespectMaxTimes")).attributeValue("value")).intValue();
/* 197 */       this.masterReplyRespectTimes = Integer.valueOf(((Element)data.get("masterReplyRespectTimes")).attributeValue("value")).intValue();
/* 198 */       this.apprenticePayRespectAwardExp = Integer.valueOf(((Element)data.get("apprenticePayRespectAwardExp")).attributeValue("value")).intValue();
/* 199 */       this.payRespectAwardRelationValue = Integer.valueOf(((Element)data.get("payRespectAwardRelationValue")).attributeValue("value")).intValue();
/* 200 */       this.apprenticePayRespectTips = Integer.valueOf(((Element)data.get("apprenticePayRespectTips")).attributeValue("value")).intValue();
/* 201 */       this.payRespectDefaultTips = Integer.valueOf(((Element)data.get("payRespectDefaultTips")).attributeValue("value")).intValue();
/* 202 */       this.masterPayRespectTips = Integer.valueOf(((Element)data.get("masterPayRespectTips")).attributeValue("value")).intValue();
/* 203 */       this.apprenticeRoleLevelLimit = Integer.valueOf(((Element)data.get("apprenticeRoleLevelLimit")).attributeValue("value")).intValue();
/* 204 */       this.payRespectActivityId = Integer.valueOf(((Element)data.get("payRespectActivityId")).attributeValue("value")).intValue();
/* 205 */       this.payRespectStrMaxLength = Integer.valueOf(((Element)data.get("payRespectStrMaxLength")).attributeValue("value")).intValue();
/* 206 */       this.shouTuNpcServiceId = Integer.valueOf(((Element)data.get("shouTuNpcServiceId")).attributeValue("value")).intValue();
/* 207 */       this.chuShiNpcServiceId = Integer.valueOf(((Element)data.get("chuShiNpcServiceId")).attributeValue("value")).intValue();
/* 208 */       this.defectNpcServiceId = Integer.valueOf(((Element)data.get("defectNpcServiceId")).attributeValue("value")).intValue();
/* 209 */       this.dismissNpcServiceId = Integer.valueOf(((Element)data.get("dismissNpcServiceId")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 213 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/* 217 */   public static void loadBny(String dir) { instance._loadBny(dir); }
/*     */   
/*     */   public void _loadBny(String dir) {
/* 220 */     String path = dir + "mzm.gsp.shitu.confbean.ShiTuConsts.bny";
/*     */     try
/*     */     {
/* 223 */       File file = new File(path);
/* 224 */       if (file.exists())
/*     */       {
/* 226 */         byte[] bytes = new byte['Ѐ'];
/* 227 */         FileInputStream fis = new FileInputStream(file);
/* 228 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 229 */         int len = 0;
/* 230 */         while ((len = fis.read(bytes)) > 0)
/* 231 */           baos.write(bytes, 0, len);
/* 232 */         fis.close();
/* 233 */         bytes = baos.toByteArray();
/* 234 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 235 */         this.apprenticeMinLevel = _os_.unmarshal_int();
/* 236 */         this.minHighLevel = _os_.unmarshal_int();
/* 237 */         this.maxApprenticeNum = _os_.unmarshal_int();
/* 238 */         this.relievePunishTime = _os_.unmarshal_int();
/* 239 */         this.minQinMiDu = _os_.unmarshal_int();
/* 240 */         this.apprenticeAppellationId = _os_.unmarshal_int();
/* 241 */         this.chuShiAppellationId = _os_.unmarshal_int();
/* 242 */         this.masterAppellationId = _os_.unmarshal_int();
/* 243 */         this.chuShiAwardId = _os_.unmarshal_int();
/* 244 */         this.chuShiApprenticeMinLevel = _os_.unmarshal_int();
/* 245 */         this.chuShiRelationMinTime = _os_.unmarshal_int();
/* 246 */         this.chuShiMinQinMiDu = _os_.unmarshal_int();
/* 247 */         this.waitSeconds = _os_.unmarshal_int();
/* 248 */         this.chuShiMailID = _os_.unmarshal_int();
/* 249 */         this.forceRelieveMailID = _os_.unmarshal_int();
/* 250 */         this.shiTuNPCId = _os_.unmarshal_int();
/* 251 */         this.teamConditionIdShouTu = _os_.unmarshal_int();
/* 252 */         this.levelConditionIdShouTu = _os_.unmarshal_int();
/* 253 */         this.apprenticeConditionIdShouTu = _os_.unmarshal_int();
/* 254 */         this.masterNumLimitConditionIdShouTu = _os_.unmarshal_int();
/* 255 */         this.punishConditionIdShouTu = _os_.unmarshal_int();
/* 256 */         this.qinMiDuConditionIdShouTu = _os_.unmarshal_int();
/* 257 */         this.apprenticeLevelConditionIdChuShi = _os_.unmarshal_int();
/* 258 */         this.relationTimeConditionIdChuShi = _os_.unmarshal_int();
/* 259 */         this.qinMiDuConditionIdChuShi = _os_.unmarshal_int();
/* 260 */         this.masterRankPageSize = _os_.unmarshal_int();
/* 261 */         this.graduateApprenticePageSize = _os_.unmarshal_int();
/* 262 */         this.payRespectMaxTimes = _os_.unmarshal_int();
/* 263 */         this.masterReplyRespectTimes = _os_.unmarshal_int();
/* 264 */         this.apprenticePayRespectAwardExp = _os_.unmarshal_int();
/* 265 */         this.payRespectAwardRelationValue = _os_.unmarshal_int();
/* 266 */         this.apprenticePayRespectTips = _os_.unmarshal_int();
/* 267 */         this.payRespectDefaultTips = _os_.unmarshal_int();
/* 268 */         this.masterPayRespectTips = _os_.unmarshal_int();
/* 269 */         this.apprenticeRoleLevelLimit = _os_.unmarshal_int();
/* 270 */         this.payRespectActivityId = _os_.unmarshal_int();
/* 271 */         this.payRespectStrMaxLength = _os_.unmarshal_int();
/* 272 */         this.shouTuNpcServiceId = _os_.unmarshal_int();
/* 273 */         this.chuShiNpcServiceId = _os_.unmarshal_int();
/* 274 */         this.defectNpcServiceId = _os_.unmarshal_int();
/* 275 */         this.dismissNpcServiceId = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 280 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadBny(String dir)
/*     */   {
/* 286 */     String path = dir + "mzm.gsp.shitu.confbean.ShiTuConsts.bny";
/*     */     try
/*     */     {
/* 289 */       File file = new File(path);
/* 290 */       if (file.exists())
/*     */       {
/* 292 */         byte[] bytes = new byte['Ѐ'];
/* 293 */         FileInputStream fis = new FileInputStream(file);
/* 294 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 295 */         int len = 0;
/* 296 */         while ((len = fis.read(bytes)) > 0)
/* 297 */           baos.write(bytes, 0, len);
/* 298 */         fis.close();
/* 299 */         bytes = baos.toByteArray();
/* 300 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 301 */         this.apprenticeMinLevel = _os_.unmarshal_int();
/* 302 */         this.minHighLevel = _os_.unmarshal_int();
/* 303 */         this.maxApprenticeNum = _os_.unmarshal_int();
/* 304 */         this.relievePunishTime = _os_.unmarshal_int();
/* 305 */         this.minQinMiDu = _os_.unmarshal_int();
/* 306 */         this.apprenticeAppellationId = _os_.unmarshal_int();
/* 307 */         this.chuShiAppellationId = _os_.unmarshal_int();
/* 308 */         this.masterAppellationId = _os_.unmarshal_int();
/* 309 */         this.chuShiAwardId = _os_.unmarshal_int();
/* 310 */         this.chuShiApprenticeMinLevel = _os_.unmarshal_int();
/* 311 */         this.chuShiRelationMinTime = _os_.unmarshal_int();
/* 312 */         this.chuShiMinQinMiDu = _os_.unmarshal_int();
/* 313 */         this.waitSeconds = _os_.unmarshal_int();
/* 314 */         this.chuShiMailID = _os_.unmarshal_int();
/* 315 */         this.forceRelieveMailID = _os_.unmarshal_int();
/* 316 */         this.shiTuNPCId = _os_.unmarshal_int();
/* 317 */         this.teamConditionIdShouTu = _os_.unmarshal_int();
/* 318 */         this.levelConditionIdShouTu = _os_.unmarshal_int();
/* 319 */         this.apprenticeConditionIdShouTu = _os_.unmarshal_int();
/* 320 */         this.masterNumLimitConditionIdShouTu = _os_.unmarshal_int();
/* 321 */         this.punishConditionIdShouTu = _os_.unmarshal_int();
/* 322 */         this.qinMiDuConditionIdShouTu = _os_.unmarshal_int();
/* 323 */         this.apprenticeLevelConditionIdChuShi = _os_.unmarshal_int();
/* 324 */         this.relationTimeConditionIdChuShi = _os_.unmarshal_int();
/* 325 */         this.qinMiDuConditionIdChuShi = _os_.unmarshal_int();
/* 326 */         this.masterRankPageSize = _os_.unmarshal_int();
/* 327 */         this.graduateApprenticePageSize = _os_.unmarshal_int();
/* 328 */         this.payRespectMaxTimes = _os_.unmarshal_int();
/* 329 */         this.masterReplyRespectTimes = _os_.unmarshal_int();
/* 330 */         this.apprenticePayRespectAwardExp = _os_.unmarshal_int();
/* 331 */         this.payRespectAwardRelationValue = _os_.unmarshal_int();
/* 332 */         this.apprenticePayRespectTips = _os_.unmarshal_int();
/* 333 */         this.payRespectDefaultTips = _os_.unmarshal_int();
/* 334 */         this.masterPayRespectTips = _os_.unmarshal_int();
/* 335 */         this.apprenticeRoleLevelLimit = _os_.unmarshal_int();
/* 336 */         this.payRespectActivityId = _os_.unmarshal_int();
/* 337 */         this.payRespectStrMaxLength = _os_.unmarshal_int();
/* 338 */         this.shouTuNpcServiceId = _os_.unmarshal_int();
/* 339 */         this.chuShiNpcServiceId = _os_.unmarshal_int();
/* 340 */         this.defectNpcServiceId = _os_.unmarshal_int();
/* 341 */         this.dismissNpcServiceId = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 346 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void setInstance(ShiTuConsts newInstance)
/*     */   {
/* 352 */     oldInstance = instance;
/* 353 */     instance = newInstance;
/*     */   }
/*     */   
/*     */   public static void resetOldInstance()
/*     */   {
/* 358 */     oldInstance = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shitu\confbean\ShiTuConsts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */