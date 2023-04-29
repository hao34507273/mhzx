/*     */ package mzm.gsp.shimen.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.SAXReader;
/*     */ 
/*     */ public class ShimenActivityCfgConsts
/*     */ {
/*  13 */   private static volatile ShimenActivityCfgConsts oldInstance = null;
/*     */   
/*  15 */   private static ShimenActivityCfgConsts instance = new ShimenActivityCfgConsts();
/*     */   public int ACTIVITYID;
/*     */   public int GUIWANG_NPC_ID;
/*     */   public int GUIWANG_GRAPH_ID;
/*     */   public int NPC_SERVICE_GUIWANG;
/*     */   public int QINGYUN_NPC_ID;
/*     */   public int QINGYUN_GRAPH_ID;
/*     */   
/*  23 */   public static ShimenActivityCfgConsts getOldInstance() { return oldInstance; }
/*     */   
/*     */ 
/*     */   public static ShimenActivityCfgConsts getInstance()
/*     */   {
/*  28 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */   public int NPC_SERVICE_QING_YUN;
/*     */   
/*     */   public int TIANYIN_NPC_ID;
/*     */   
/*     */   public int TIANYIN_GRAPH_ID;
/*     */   
/*     */   public int NPC_SERVICE_TIANYIN;
/*     */   
/*     */   public int FENXIANG_NPC_ID;
/*     */   
/*     */   public int FENXIANG_GRAPH_ID;
/*     */   
/*     */   public int NPC_SERVICE_FENXIANG;
/*     */   public int HEHUAN_NPC_ID;
/*     */   public int HEHUAN_GRAPH_ID;
/*     */   public int NPC_SERVICE_HEHUAN;
/*     */   public int SHENGWU_NPC_ID;
/*     */   public int SHENGWU_GRAPH_ID;
/*     */   public int NPC_SERVICE_SHENGWU;
/*     */   public int CANGYU_NPC_ID;
/*     */   public int CANGYU_GRAPH_ID;
/*     */   public int NPC_SERVICE_CANGYU;
/*     */   public int LINGYINDIAN_NPC_ID;
/*     */   public int LINGYINDIAN_GRAPH_ID;
/*     */   public int NPC_SERVICE_LINGYINDIAN;
/*     */   public int YINENGZHE_NPC_ID;
/*     */   public int YINENGZHE_GRAPH_ID;
/*     */   public int NPC_SERVICE_YINENGZHE;
/*     */   public int REWARD_ID;
/*     */   public boolean IS_AUTO_ACCEPT;
/*     */   public int DAY_TOTAL_COUNT;
/*     */   public int WEEK_PERFECT_CIRCLE_COUNT;
/*     */   public int DAY_PERFECT_CIRCLE_COUNT;
/*     */   public int COUNT_FOR_BOUND_TIP;
/*     */   public int DAY_PERFECT_CIRCLE_REWARD_ID;
/*     */   public int WEEK_PERFECT_CIRCLE_REWARD_ID;
/*     */   public int EXP_CHANGE_RATE;
/*     */   public int LOTTERY_VIEW_ID;
/*     */   public int DELAY_OFFER_TIME;
/*     */   public int SHIMEN_DEFAULT_MODIFY_ID;
/*     */   public int EXCHANGE_MOSHOU_REWARD_NEED_ITEM_NUM;
/*     */   public int MOSHOU_REWARD;
/*     */   public int EXCHANGE_MOSHOU_MAX_COUNT;
/*     */   public int EXCHANGE_NORMAL_REWARD_NEED_ITEM_NUM;
/*     */   public int NORMAL_REWARD;
/*     */   public int EXCHANGE_NPC_ID;
/*     */   public int EXCHANGE_MOSHOU_NPC_SERVICE;
/*     */   public int EXCHANGE_NORMAL_NPC_SERVICE;
/*     */   public int EXCHANGE_DESC_NPC_SERVICE;
/*     */   public int RETURN_BACK_EXP_CHANGE_RATE;
/*     */   public static void loadXml(String dir)
/*     */   {
/*  84 */     instance.doLoadXml(dir);
/*     */   }
/*     */   
/*     */   private void doLoadXml(String dir)
/*     */   {
/*  89 */     String path = dir + "mzm.gsp.shimen.confbean.ShimenActivityCfgConsts.xml";
/*     */     try
/*     */     {
/*  92 */       SAXReader reader = new SAXReader();
/*  93 */       org.dom4j.Document doc = reader.read(new File(path));
/*  94 */       Element root = doc.getRootElement();
/*  95 */       Map<String, Element> data = new java.util.HashMap();
/*  96 */       java.util.List<?> nodeList = root.elements();
/*  97 */       int len = nodeList.size();
/*  98 */       for (int i = 0; i < len; i++)
/*     */       {
/* 100 */         Element element = (Element)nodeList.get(i);
/* 101 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/* 104 */           String name = element.attributeValue("name");
/* 105 */           if (data.put(name, element) != null)
/* 106 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/* 109 */       this.ACTIVITYID = Integer.valueOf(((Element)data.get("ACTIVITYID")).attributeValue("value")).intValue();
/* 110 */       this.GUIWANG_NPC_ID = Integer.valueOf(((Element)data.get("GUIWANG_NPC_ID")).attributeValue("value")).intValue();
/* 111 */       this.GUIWANG_GRAPH_ID = Integer.valueOf(((Element)data.get("GUIWANG_GRAPH_ID")).attributeValue("value")).intValue();
/* 112 */       this.NPC_SERVICE_GUIWANG = Integer.valueOf(((Element)data.get("NPC_SERVICE_GUIWANG")).attributeValue("value")).intValue();
/* 113 */       this.QINGYUN_NPC_ID = Integer.valueOf(((Element)data.get("QINGYUN_NPC_ID")).attributeValue("value")).intValue();
/* 114 */       this.QINGYUN_GRAPH_ID = Integer.valueOf(((Element)data.get("QINGYUN_GRAPH_ID")).attributeValue("value")).intValue();
/* 115 */       this.NPC_SERVICE_QING_YUN = Integer.valueOf(((Element)data.get("NPC_SERVICE_QING_YUN")).attributeValue("value")).intValue();
/* 116 */       this.TIANYIN_NPC_ID = Integer.valueOf(((Element)data.get("TIANYIN_NPC_ID")).attributeValue("value")).intValue();
/* 117 */       this.TIANYIN_GRAPH_ID = Integer.valueOf(((Element)data.get("TIANYIN_GRAPH_ID")).attributeValue("value")).intValue();
/* 118 */       this.NPC_SERVICE_TIANYIN = Integer.valueOf(((Element)data.get("NPC_SERVICE_TIANYIN")).attributeValue("value")).intValue();
/* 119 */       this.FENXIANG_NPC_ID = Integer.valueOf(((Element)data.get("FENXIANG_NPC_ID")).attributeValue("value")).intValue();
/* 120 */       this.FENXIANG_GRAPH_ID = Integer.valueOf(((Element)data.get("FENXIANG_GRAPH_ID")).attributeValue("value")).intValue();
/* 121 */       this.NPC_SERVICE_FENXIANG = Integer.valueOf(((Element)data.get("NPC_SERVICE_FENXIANG")).attributeValue("value")).intValue();
/* 122 */       this.HEHUAN_NPC_ID = Integer.valueOf(((Element)data.get("HEHUAN_NPC_ID")).attributeValue("value")).intValue();
/* 123 */       this.HEHUAN_GRAPH_ID = Integer.valueOf(((Element)data.get("HEHUAN_GRAPH_ID")).attributeValue("value")).intValue();
/* 124 */       this.NPC_SERVICE_HEHUAN = Integer.valueOf(((Element)data.get("NPC_SERVICE_HEHUAN")).attributeValue("value")).intValue();
/* 125 */       this.SHENGWU_NPC_ID = Integer.valueOf(((Element)data.get("SHENGWU_NPC_ID")).attributeValue("value")).intValue();
/* 126 */       this.SHENGWU_GRAPH_ID = Integer.valueOf(((Element)data.get("SHENGWU_GRAPH_ID")).attributeValue("value")).intValue();
/* 127 */       this.NPC_SERVICE_SHENGWU = Integer.valueOf(((Element)data.get("NPC_SERVICE_SHENGWU")).attributeValue("value")).intValue();
/* 128 */       this.CANGYU_NPC_ID = Integer.valueOf(((Element)data.get("CANGYU_NPC_ID")).attributeValue("value")).intValue();
/* 129 */       this.CANGYU_GRAPH_ID = Integer.valueOf(((Element)data.get("CANGYU_GRAPH_ID")).attributeValue("value")).intValue();
/* 130 */       this.NPC_SERVICE_CANGYU = Integer.valueOf(((Element)data.get("NPC_SERVICE_CANGYU")).attributeValue("value")).intValue();
/* 131 */       this.LINGYINDIAN_NPC_ID = Integer.valueOf(((Element)data.get("LINGYINDIAN_NPC_ID")).attributeValue("value")).intValue();
/* 132 */       this.LINGYINDIAN_GRAPH_ID = Integer.valueOf(((Element)data.get("LINGYINDIAN_GRAPH_ID")).attributeValue("value")).intValue();
/* 133 */       this.NPC_SERVICE_LINGYINDIAN = Integer.valueOf(((Element)data.get("NPC_SERVICE_LINGYINDIAN")).attributeValue("value")).intValue();
/* 134 */       this.YINENGZHE_NPC_ID = Integer.valueOf(((Element)data.get("YINENGZHE_NPC_ID")).attributeValue("value")).intValue();
/* 135 */       this.YINENGZHE_GRAPH_ID = Integer.valueOf(((Element)data.get("YINENGZHE_GRAPH_ID")).attributeValue("value")).intValue();
/* 136 */       this.NPC_SERVICE_YINENGZHE = Integer.valueOf(((Element)data.get("NPC_SERVICE_YINENGZHE")).attributeValue("value")).intValue();
/* 137 */       this.REWARD_ID = Integer.valueOf(((Element)data.get("REWARD_ID")).attributeValue("value")).intValue();
/* 138 */       this.IS_AUTO_ACCEPT = Boolean.valueOf(((Element)data.get("IS_AUTO_ACCEPT")).attributeValue("value")).booleanValue();
/* 139 */       this.DAY_TOTAL_COUNT = Integer.valueOf(((Element)data.get("DAY_TOTAL_COUNT")).attributeValue("value")).intValue();
/* 140 */       this.WEEK_PERFECT_CIRCLE_COUNT = Integer.valueOf(((Element)data.get("WEEK_PERFECT_CIRCLE_COUNT")).attributeValue("value")).intValue();
/* 141 */       this.DAY_PERFECT_CIRCLE_COUNT = Integer.valueOf(((Element)data.get("DAY_PERFECT_CIRCLE_COUNT")).attributeValue("value")).intValue();
/* 142 */       this.COUNT_FOR_BOUND_TIP = Integer.valueOf(((Element)data.get("COUNT_FOR_BOUND_TIP")).attributeValue("value")).intValue();
/* 143 */       this.DAY_PERFECT_CIRCLE_REWARD_ID = Integer.valueOf(((Element)data.get("DAY_PERFECT_CIRCLE_REWARD_ID")).attributeValue("value")).intValue();
/* 144 */       this.WEEK_PERFECT_CIRCLE_REWARD_ID = Integer.valueOf(((Element)data.get("WEEK_PERFECT_CIRCLE_REWARD_ID")).attributeValue("value")).intValue();
/* 145 */       this.EXP_CHANGE_RATE = Integer.valueOf(((Element)data.get("EXP_CHANGE_RATE")).attributeValue("value")).intValue();
/* 146 */       this.LOTTERY_VIEW_ID = Integer.valueOf(((Element)data.get("LOTTERY_VIEW_ID")).attributeValue("value")).intValue();
/* 147 */       this.DELAY_OFFER_TIME = Integer.valueOf(((Element)data.get("DELAY_OFFER_TIME")).attributeValue("value")).intValue();
/* 148 */       this.SHIMEN_DEFAULT_MODIFY_ID = Integer.valueOf(((Element)data.get("SHIMEN_DEFAULT_MODIFY_ID")).attributeValue("value")).intValue();
/* 149 */       this.EXCHANGE_MOSHOU_REWARD_NEED_ITEM_NUM = Integer.valueOf(((Element)data.get("EXCHANGE_MOSHOU_REWARD_NEED_ITEM_NUM")).attributeValue("value")).intValue();
/* 150 */       this.MOSHOU_REWARD = Integer.valueOf(((Element)data.get("MOSHOU_REWARD")).attributeValue("value")).intValue();
/* 151 */       this.EXCHANGE_MOSHOU_MAX_COUNT = Integer.valueOf(((Element)data.get("EXCHANGE_MOSHOU_MAX_COUNT")).attributeValue("value")).intValue();
/* 152 */       this.EXCHANGE_NORMAL_REWARD_NEED_ITEM_NUM = Integer.valueOf(((Element)data.get("EXCHANGE_NORMAL_REWARD_NEED_ITEM_NUM")).attributeValue("value")).intValue();
/* 153 */       this.NORMAL_REWARD = Integer.valueOf(((Element)data.get("NORMAL_REWARD")).attributeValue("value")).intValue();
/* 154 */       this.EXCHANGE_NPC_ID = Integer.valueOf(((Element)data.get("EXCHANGE_NPC_ID")).attributeValue("value")).intValue();
/* 155 */       this.EXCHANGE_MOSHOU_NPC_SERVICE = Integer.valueOf(((Element)data.get("EXCHANGE_MOSHOU_NPC_SERVICE")).attributeValue("value")).intValue();
/* 156 */       this.EXCHANGE_NORMAL_NPC_SERVICE = Integer.valueOf(((Element)data.get("EXCHANGE_NORMAL_NPC_SERVICE")).attributeValue("value")).intValue();
/* 157 */       this.EXCHANGE_DESC_NPC_SERVICE = Integer.valueOf(((Element)data.get("EXCHANGE_DESC_NPC_SERVICE")).attributeValue("value")).intValue();
/* 158 */       this.RETURN_BACK_EXP_CHANGE_RATE = Integer.valueOf(((Element)data.get("RETURN_BACK_EXP_CHANGE_RATE")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 162 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadXml(String dir) {
/* 167 */     String path = dir + "mzm.gsp.shimen.confbean.ShimenActivityCfgConsts.xml";
/*     */     try
/*     */     {
/* 170 */       SAXReader reader = new SAXReader();
/* 171 */       org.dom4j.Document doc = reader.read(new File(path));
/* 172 */       Element root = doc.getRootElement();
/* 173 */       Map<String, Element> data = new java.util.HashMap();
/* 174 */       java.util.List<?> nodeList = root.elements();
/* 175 */       int len = nodeList.size();
/* 176 */       for (int i = 0; i < len; i++)
/*     */       {
/* 178 */         Element element = (Element)nodeList.get(i);
/* 179 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/* 182 */           String name = element.attributeValue("name");
/* 183 */           if (data.put(name, element) != null)
/* 184 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/* 187 */       this.ACTIVITYID = Integer.valueOf(((Element)data.get("ACTIVITYID")).attributeValue("value")).intValue();
/* 188 */       this.GUIWANG_NPC_ID = Integer.valueOf(((Element)data.get("GUIWANG_NPC_ID")).attributeValue("value")).intValue();
/* 189 */       this.GUIWANG_GRAPH_ID = Integer.valueOf(((Element)data.get("GUIWANG_GRAPH_ID")).attributeValue("value")).intValue();
/* 190 */       this.NPC_SERVICE_GUIWANG = Integer.valueOf(((Element)data.get("NPC_SERVICE_GUIWANG")).attributeValue("value")).intValue();
/* 191 */       this.QINGYUN_NPC_ID = Integer.valueOf(((Element)data.get("QINGYUN_NPC_ID")).attributeValue("value")).intValue();
/* 192 */       this.QINGYUN_GRAPH_ID = Integer.valueOf(((Element)data.get("QINGYUN_GRAPH_ID")).attributeValue("value")).intValue();
/* 193 */       this.NPC_SERVICE_QING_YUN = Integer.valueOf(((Element)data.get("NPC_SERVICE_QING_YUN")).attributeValue("value")).intValue();
/* 194 */       this.TIANYIN_NPC_ID = Integer.valueOf(((Element)data.get("TIANYIN_NPC_ID")).attributeValue("value")).intValue();
/* 195 */       this.TIANYIN_GRAPH_ID = Integer.valueOf(((Element)data.get("TIANYIN_GRAPH_ID")).attributeValue("value")).intValue();
/* 196 */       this.NPC_SERVICE_TIANYIN = Integer.valueOf(((Element)data.get("NPC_SERVICE_TIANYIN")).attributeValue("value")).intValue();
/* 197 */       this.FENXIANG_NPC_ID = Integer.valueOf(((Element)data.get("FENXIANG_NPC_ID")).attributeValue("value")).intValue();
/* 198 */       this.FENXIANG_GRAPH_ID = Integer.valueOf(((Element)data.get("FENXIANG_GRAPH_ID")).attributeValue("value")).intValue();
/* 199 */       this.NPC_SERVICE_FENXIANG = Integer.valueOf(((Element)data.get("NPC_SERVICE_FENXIANG")).attributeValue("value")).intValue();
/* 200 */       this.HEHUAN_NPC_ID = Integer.valueOf(((Element)data.get("HEHUAN_NPC_ID")).attributeValue("value")).intValue();
/* 201 */       this.HEHUAN_GRAPH_ID = Integer.valueOf(((Element)data.get("HEHUAN_GRAPH_ID")).attributeValue("value")).intValue();
/* 202 */       this.NPC_SERVICE_HEHUAN = Integer.valueOf(((Element)data.get("NPC_SERVICE_HEHUAN")).attributeValue("value")).intValue();
/* 203 */       this.SHENGWU_NPC_ID = Integer.valueOf(((Element)data.get("SHENGWU_NPC_ID")).attributeValue("value")).intValue();
/* 204 */       this.SHENGWU_GRAPH_ID = Integer.valueOf(((Element)data.get("SHENGWU_GRAPH_ID")).attributeValue("value")).intValue();
/* 205 */       this.NPC_SERVICE_SHENGWU = Integer.valueOf(((Element)data.get("NPC_SERVICE_SHENGWU")).attributeValue("value")).intValue();
/* 206 */       this.CANGYU_NPC_ID = Integer.valueOf(((Element)data.get("CANGYU_NPC_ID")).attributeValue("value")).intValue();
/* 207 */       this.CANGYU_GRAPH_ID = Integer.valueOf(((Element)data.get("CANGYU_GRAPH_ID")).attributeValue("value")).intValue();
/* 208 */       this.NPC_SERVICE_CANGYU = Integer.valueOf(((Element)data.get("NPC_SERVICE_CANGYU")).attributeValue("value")).intValue();
/* 209 */       this.LINGYINDIAN_NPC_ID = Integer.valueOf(((Element)data.get("LINGYINDIAN_NPC_ID")).attributeValue("value")).intValue();
/* 210 */       this.LINGYINDIAN_GRAPH_ID = Integer.valueOf(((Element)data.get("LINGYINDIAN_GRAPH_ID")).attributeValue("value")).intValue();
/* 211 */       this.NPC_SERVICE_LINGYINDIAN = Integer.valueOf(((Element)data.get("NPC_SERVICE_LINGYINDIAN")).attributeValue("value")).intValue();
/* 212 */       this.YINENGZHE_NPC_ID = Integer.valueOf(((Element)data.get("YINENGZHE_NPC_ID")).attributeValue("value")).intValue();
/* 213 */       this.YINENGZHE_GRAPH_ID = Integer.valueOf(((Element)data.get("YINENGZHE_GRAPH_ID")).attributeValue("value")).intValue();
/* 214 */       this.NPC_SERVICE_YINENGZHE = Integer.valueOf(((Element)data.get("NPC_SERVICE_YINENGZHE")).attributeValue("value")).intValue();
/* 215 */       this.REWARD_ID = Integer.valueOf(((Element)data.get("REWARD_ID")).attributeValue("value")).intValue();
/* 216 */       this.IS_AUTO_ACCEPT = Boolean.valueOf(((Element)data.get("IS_AUTO_ACCEPT")).attributeValue("value")).booleanValue();
/* 217 */       this.DAY_TOTAL_COUNT = Integer.valueOf(((Element)data.get("DAY_TOTAL_COUNT")).attributeValue("value")).intValue();
/* 218 */       this.WEEK_PERFECT_CIRCLE_COUNT = Integer.valueOf(((Element)data.get("WEEK_PERFECT_CIRCLE_COUNT")).attributeValue("value")).intValue();
/* 219 */       this.DAY_PERFECT_CIRCLE_COUNT = Integer.valueOf(((Element)data.get("DAY_PERFECT_CIRCLE_COUNT")).attributeValue("value")).intValue();
/* 220 */       this.COUNT_FOR_BOUND_TIP = Integer.valueOf(((Element)data.get("COUNT_FOR_BOUND_TIP")).attributeValue("value")).intValue();
/* 221 */       this.DAY_PERFECT_CIRCLE_REWARD_ID = Integer.valueOf(((Element)data.get("DAY_PERFECT_CIRCLE_REWARD_ID")).attributeValue("value")).intValue();
/* 222 */       this.WEEK_PERFECT_CIRCLE_REWARD_ID = Integer.valueOf(((Element)data.get("WEEK_PERFECT_CIRCLE_REWARD_ID")).attributeValue("value")).intValue();
/* 223 */       this.EXP_CHANGE_RATE = Integer.valueOf(((Element)data.get("EXP_CHANGE_RATE")).attributeValue("value")).intValue();
/* 224 */       this.LOTTERY_VIEW_ID = Integer.valueOf(((Element)data.get("LOTTERY_VIEW_ID")).attributeValue("value")).intValue();
/* 225 */       this.DELAY_OFFER_TIME = Integer.valueOf(((Element)data.get("DELAY_OFFER_TIME")).attributeValue("value")).intValue();
/* 226 */       this.SHIMEN_DEFAULT_MODIFY_ID = Integer.valueOf(((Element)data.get("SHIMEN_DEFAULT_MODIFY_ID")).attributeValue("value")).intValue();
/* 227 */       this.EXCHANGE_MOSHOU_REWARD_NEED_ITEM_NUM = Integer.valueOf(((Element)data.get("EXCHANGE_MOSHOU_REWARD_NEED_ITEM_NUM")).attributeValue("value")).intValue();
/* 228 */       this.MOSHOU_REWARD = Integer.valueOf(((Element)data.get("MOSHOU_REWARD")).attributeValue("value")).intValue();
/* 229 */       this.EXCHANGE_MOSHOU_MAX_COUNT = Integer.valueOf(((Element)data.get("EXCHANGE_MOSHOU_MAX_COUNT")).attributeValue("value")).intValue();
/* 230 */       this.EXCHANGE_NORMAL_REWARD_NEED_ITEM_NUM = Integer.valueOf(((Element)data.get("EXCHANGE_NORMAL_REWARD_NEED_ITEM_NUM")).attributeValue("value")).intValue();
/* 231 */       this.NORMAL_REWARD = Integer.valueOf(((Element)data.get("NORMAL_REWARD")).attributeValue("value")).intValue();
/* 232 */       this.EXCHANGE_NPC_ID = Integer.valueOf(((Element)data.get("EXCHANGE_NPC_ID")).attributeValue("value")).intValue();
/* 233 */       this.EXCHANGE_MOSHOU_NPC_SERVICE = Integer.valueOf(((Element)data.get("EXCHANGE_MOSHOU_NPC_SERVICE")).attributeValue("value")).intValue();
/* 234 */       this.EXCHANGE_NORMAL_NPC_SERVICE = Integer.valueOf(((Element)data.get("EXCHANGE_NORMAL_NPC_SERVICE")).attributeValue("value")).intValue();
/* 235 */       this.EXCHANGE_DESC_NPC_SERVICE = Integer.valueOf(((Element)data.get("EXCHANGE_DESC_NPC_SERVICE")).attributeValue("value")).intValue();
/* 236 */       this.RETURN_BACK_EXP_CHANGE_RATE = Integer.valueOf(((Element)data.get("RETURN_BACK_EXP_CHANGE_RATE")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 240 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/* 244 */   public static void loadBny(String dir) { instance._loadBny(dir); }
/*     */   
/*     */   public void _loadBny(String dir) {
/* 247 */     String path = dir + "mzm.gsp.shimen.confbean.ShimenActivityCfgConsts.bny";
/*     */     try
/*     */     {
/* 250 */       File file = new File(path);
/* 251 */       if (file.exists())
/*     */       {
/* 253 */         byte[] bytes = new byte['Ѐ'];
/* 254 */         FileInputStream fis = new FileInputStream(file);
/* 255 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 256 */         int len = 0;
/* 257 */         while ((len = fis.read(bytes)) > 0)
/* 258 */           baos.write(bytes, 0, len);
/* 259 */         fis.close();
/* 260 */         bytes = baos.toByteArray();
/* 261 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 262 */         this.ACTIVITYID = _os_.unmarshal_int();
/* 263 */         this.GUIWANG_NPC_ID = _os_.unmarshal_int();
/* 264 */         this.GUIWANG_GRAPH_ID = _os_.unmarshal_int();
/* 265 */         this.NPC_SERVICE_GUIWANG = _os_.unmarshal_int();
/* 266 */         this.QINGYUN_NPC_ID = _os_.unmarshal_int();
/* 267 */         this.QINGYUN_GRAPH_ID = _os_.unmarshal_int();
/* 268 */         this.NPC_SERVICE_QING_YUN = _os_.unmarshal_int();
/* 269 */         this.TIANYIN_NPC_ID = _os_.unmarshal_int();
/* 270 */         this.TIANYIN_GRAPH_ID = _os_.unmarshal_int();
/* 271 */         this.NPC_SERVICE_TIANYIN = _os_.unmarshal_int();
/* 272 */         this.FENXIANG_NPC_ID = _os_.unmarshal_int();
/* 273 */         this.FENXIANG_GRAPH_ID = _os_.unmarshal_int();
/* 274 */         this.NPC_SERVICE_FENXIANG = _os_.unmarshal_int();
/* 275 */         this.HEHUAN_NPC_ID = _os_.unmarshal_int();
/* 276 */         this.HEHUAN_GRAPH_ID = _os_.unmarshal_int();
/* 277 */         this.NPC_SERVICE_HEHUAN = _os_.unmarshal_int();
/* 278 */         this.SHENGWU_NPC_ID = _os_.unmarshal_int();
/* 279 */         this.SHENGWU_GRAPH_ID = _os_.unmarshal_int();
/* 280 */         this.NPC_SERVICE_SHENGWU = _os_.unmarshal_int();
/* 281 */         this.CANGYU_NPC_ID = _os_.unmarshal_int();
/* 282 */         this.CANGYU_GRAPH_ID = _os_.unmarshal_int();
/* 283 */         this.NPC_SERVICE_CANGYU = _os_.unmarshal_int();
/* 284 */         this.LINGYINDIAN_NPC_ID = _os_.unmarshal_int();
/* 285 */         this.LINGYINDIAN_GRAPH_ID = _os_.unmarshal_int();
/* 286 */         this.NPC_SERVICE_LINGYINDIAN = _os_.unmarshal_int();
/* 287 */         this.YINENGZHE_NPC_ID = _os_.unmarshal_int();
/* 288 */         this.YINENGZHE_GRAPH_ID = _os_.unmarshal_int();
/* 289 */         this.NPC_SERVICE_YINENGZHE = _os_.unmarshal_int();
/* 290 */         this.REWARD_ID = _os_.unmarshal_int();
/* 291 */         this.IS_AUTO_ACCEPT = _os_.unmarshal_boolean();
/* 292 */         this.DAY_TOTAL_COUNT = _os_.unmarshal_int();
/* 293 */         this.WEEK_PERFECT_CIRCLE_COUNT = _os_.unmarshal_int();
/* 294 */         this.DAY_PERFECT_CIRCLE_COUNT = _os_.unmarshal_int();
/* 295 */         this.COUNT_FOR_BOUND_TIP = _os_.unmarshal_int();
/* 296 */         this.DAY_PERFECT_CIRCLE_REWARD_ID = _os_.unmarshal_int();
/* 297 */         this.WEEK_PERFECT_CIRCLE_REWARD_ID = _os_.unmarshal_int();
/* 298 */         this.EXP_CHANGE_RATE = _os_.unmarshal_int();
/* 299 */         this.LOTTERY_VIEW_ID = _os_.unmarshal_int();
/* 300 */         this.DELAY_OFFER_TIME = _os_.unmarshal_int();
/* 301 */         this.SHIMEN_DEFAULT_MODIFY_ID = _os_.unmarshal_int();
/* 302 */         this.EXCHANGE_MOSHOU_REWARD_NEED_ITEM_NUM = _os_.unmarshal_int();
/* 303 */         this.MOSHOU_REWARD = _os_.unmarshal_int();
/* 304 */         this.EXCHANGE_MOSHOU_MAX_COUNT = _os_.unmarshal_int();
/* 305 */         this.EXCHANGE_NORMAL_REWARD_NEED_ITEM_NUM = _os_.unmarshal_int();
/* 306 */         this.NORMAL_REWARD = _os_.unmarshal_int();
/* 307 */         this.EXCHANGE_NPC_ID = _os_.unmarshal_int();
/* 308 */         this.EXCHANGE_MOSHOU_NPC_SERVICE = _os_.unmarshal_int();
/* 309 */         this.EXCHANGE_NORMAL_NPC_SERVICE = _os_.unmarshal_int();
/* 310 */         this.EXCHANGE_DESC_NPC_SERVICE = _os_.unmarshal_int();
/* 311 */         this.RETURN_BACK_EXP_CHANGE_RATE = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 316 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadBny(String dir)
/*     */   {
/* 322 */     String path = dir + "mzm.gsp.shimen.confbean.ShimenActivityCfgConsts.bny";
/*     */     try
/*     */     {
/* 325 */       File file = new File(path);
/* 326 */       if (file.exists())
/*     */       {
/* 328 */         byte[] bytes = new byte['Ѐ'];
/* 329 */         FileInputStream fis = new FileInputStream(file);
/* 330 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 331 */         int len = 0;
/* 332 */         while ((len = fis.read(bytes)) > 0)
/* 333 */           baos.write(bytes, 0, len);
/* 334 */         fis.close();
/* 335 */         bytes = baos.toByteArray();
/* 336 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 337 */         this.ACTIVITYID = _os_.unmarshal_int();
/* 338 */         this.GUIWANG_NPC_ID = _os_.unmarshal_int();
/* 339 */         this.GUIWANG_GRAPH_ID = _os_.unmarshal_int();
/* 340 */         this.NPC_SERVICE_GUIWANG = _os_.unmarshal_int();
/* 341 */         this.QINGYUN_NPC_ID = _os_.unmarshal_int();
/* 342 */         this.QINGYUN_GRAPH_ID = _os_.unmarshal_int();
/* 343 */         this.NPC_SERVICE_QING_YUN = _os_.unmarshal_int();
/* 344 */         this.TIANYIN_NPC_ID = _os_.unmarshal_int();
/* 345 */         this.TIANYIN_GRAPH_ID = _os_.unmarshal_int();
/* 346 */         this.NPC_SERVICE_TIANYIN = _os_.unmarshal_int();
/* 347 */         this.FENXIANG_NPC_ID = _os_.unmarshal_int();
/* 348 */         this.FENXIANG_GRAPH_ID = _os_.unmarshal_int();
/* 349 */         this.NPC_SERVICE_FENXIANG = _os_.unmarshal_int();
/* 350 */         this.HEHUAN_NPC_ID = _os_.unmarshal_int();
/* 351 */         this.HEHUAN_GRAPH_ID = _os_.unmarshal_int();
/* 352 */         this.NPC_SERVICE_HEHUAN = _os_.unmarshal_int();
/* 353 */         this.SHENGWU_NPC_ID = _os_.unmarshal_int();
/* 354 */         this.SHENGWU_GRAPH_ID = _os_.unmarshal_int();
/* 355 */         this.NPC_SERVICE_SHENGWU = _os_.unmarshal_int();
/* 356 */         this.CANGYU_NPC_ID = _os_.unmarshal_int();
/* 357 */         this.CANGYU_GRAPH_ID = _os_.unmarshal_int();
/* 358 */         this.NPC_SERVICE_CANGYU = _os_.unmarshal_int();
/* 359 */         this.LINGYINDIAN_NPC_ID = _os_.unmarshal_int();
/* 360 */         this.LINGYINDIAN_GRAPH_ID = _os_.unmarshal_int();
/* 361 */         this.NPC_SERVICE_LINGYINDIAN = _os_.unmarshal_int();
/* 362 */         this.YINENGZHE_NPC_ID = _os_.unmarshal_int();
/* 363 */         this.YINENGZHE_GRAPH_ID = _os_.unmarshal_int();
/* 364 */         this.NPC_SERVICE_YINENGZHE = _os_.unmarshal_int();
/* 365 */         this.REWARD_ID = _os_.unmarshal_int();
/* 366 */         this.IS_AUTO_ACCEPT = _os_.unmarshal_boolean();
/* 367 */         this.DAY_TOTAL_COUNT = _os_.unmarshal_int();
/* 368 */         this.WEEK_PERFECT_CIRCLE_COUNT = _os_.unmarshal_int();
/* 369 */         this.DAY_PERFECT_CIRCLE_COUNT = _os_.unmarshal_int();
/* 370 */         this.COUNT_FOR_BOUND_TIP = _os_.unmarshal_int();
/* 371 */         this.DAY_PERFECT_CIRCLE_REWARD_ID = _os_.unmarshal_int();
/* 372 */         this.WEEK_PERFECT_CIRCLE_REWARD_ID = _os_.unmarshal_int();
/* 373 */         this.EXP_CHANGE_RATE = _os_.unmarshal_int();
/* 374 */         this.LOTTERY_VIEW_ID = _os_.unmarshal_int();
/* 375 */         this.DELAY_OFFER_TIME = _os_.unmarshal_int();
/* 376 */         this.SHIMEN_DEFAULT_MODIFY_ID = _os_.unmarshal_int();
/* 377 */         this.EXCHANGE_MOSHOU_REWARD_NEED_ITEM_NUM = _os_.unmarshal_int();
/* 378 */         this.MOSHOU_REWARD = _os_.unmarshal_int();
/* 379 */         this.EXCHANGE_MOSHOU_MAX_COUNT = _os_.unmarshal_int();
/* 380 */         this.EXCHANGE_NORMAL_REWARD_NEED_ITEM_NUM = _os_.unmarshal_int();
/* 381 */         this.NORMAL_REWARD = _os_.unmarshal_int();
/* 382 */         this.EXCHANGE_NPC_ID = _os_.unmarshal_int();
/* 383 */         this.EXCHANGE_MOSHOU_NPC_SERVICE = _os_.unmarshal_int();
/* 384 */         this.EXCHANGE_NORMAL_NPC_SERVICE = _os_.unmarshal_int();
/* 385 */         this.EXCHANGE_DESC_NPC_SERVICE = _os_.unmarshal_int();
/* 386 */         this.RETURN_BACK_EXP_CHANGE_RATE = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 391 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void setInstance(ShimenActivityCfgConsts newInstance)
/*     */   {
/* 397 */     oldInstance = instance;
/* 398 */     instance = newInstance;
/*     */   }
/*     */   
/*     */   public static void resetOldInstance()
/*     */   {
/* 403 */     oldInstance = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shimen\confbean\ShimenActivityCfgConsts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */