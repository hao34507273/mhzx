/*     */ package mzm.gsp.wing.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ 
/*     */ public class WingCfgConsts
/*     */ {
/*  13 */   private static volatile WingCfgConsts oldInstance = null;
/*     */   
/*  15 */   private static WingCfgConsts instance = new WingCfgConsts();
/*     */   
/*     */   public int MIN_ROLE_LEVLE_FOR_WING;
/*     */   public int WING_INIT_LEVEL;
/*     */   public int WING_INIT_PHASE;
/*     */   
/*     */   public static WingCfgConsts getOldInstance()
/*     */   {
/*  23 */     return oldInstance;
/*     */   }
/*     */   
/*     */   public static WingCfgConsts getInstance()
/*     */   {
/*  28 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */   public int WING_PROPERTY_NUM;
/*     */   
/*     */   public int NORMAL_PROPERTY_WEIGHT;
/*     */   
/*     */   public int EXCELLENT_PROPERTY_WEIGHT;
/*     */   public int ELITE_PROPERTY_WEIGHT;
/*     */   public int BRILLIANT_PROPERTY_WEIGHT;
/*     */   public int PERFECT_PROPERTY_WEIGHT;
/*     */   public int GRASPING_TWO_SKILL_RATE;
/*     */   public int MAX_WING_VIEW_NUM;
/*     */   public int SCHEMA2_NEED_YUANBAO;
/*     */   public int SCHEMA3_NEED_YUANBAO;
/*     */   public int WING_DESC_TIP_ID;
/*     */   public int MAX_SCHEMA_NUM;
/*     */   public int WING_ROOT_ITEM_ID;
/*     */   public int WING_PROPERTY_RESET_ITEM_ID;
/*     */   public int WING_PROPERTY_RESET_ITEM_NUM;
/*     */   public int RESET_WING_YUANBAO_NUM;
/*     */   public int WING_DYE_ITEM_ID;
/*     */   public int WING_FAKE_ITEM_ID;
/*     */   public int WING_PRO_RESET_TIP_ID;
/*     */   public int WING_UNDERSTAND_TIP_ID;
/*     */   public int WING_DYE_TIP_ID;
/*     */   public int MIN_LEVLE_FOR_RESET_PROPERTY;
/*     */   public int SUB_SKILL_NUM;
/*     */   public int PHASE_UP_RAN_SKILL_NUM;
/*     */   public int WING_GRAPH_ID;
/*  59 */   public java.util.ArrayList<Integer> TASKS = new java.util.ArrayList();
/*     */   public int SKILL_RESET_TIP_ID;
/*     */   public int OUT_LOOK_TIP_ID;
/*     */   public int PRO_TIP_ID;
/*     */   public int LEVEL_PRO_ID;
/*  64 */   public int WING_LV_MAX = 209;
/*  65 */   public int WING_RANGE_MAX = 20;
/*     */   public int TARGET_SKILL_NUM;
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  70 */     instance.doLoadXml(dir);
/*     */   }
/*     */   
/*     */   private void doLoadXml(String dir)
/*     */   {
/*  75 */     String path = dir + "mzm.gsp.wing.confbean.WingCfgConsts.xml";
/*     */     try
/*     */     {
/*  78 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/*  79 */       org.dom4j.Document doc = reader.read(new File(path));
/*  80 */       Element root = doc.getRootElement();
/*  81 */       Map<String, Element> data = new java.util.HashMap();
/*  82 */       List<?> nodeList = root.elements();
/*  83 */       int len = nodeList.size();
/*  84 */       for (int i = 0; i < len; i++)
/*     */       {
/*  86 */         Element element = (Element)nodeList.get(i);
/*  87 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/*  90 */           String name = element.attributeValue("name");
/*  91 */           if (data.put(name, element) != null)
/*  92 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/*  95 */       this.MIN_ROLE_LEVLE_FOR_WING = Integer.valueOf(((Element)data.get("MIN_ROLE_LEVLE_FOR_WING")).attributeValue("value")).intValue();
/*  96 */       this.WING_INIT_LEVEL = Integer.valueOf(((Element)data.get("WING_INIT_LEVEL")).attributeValue("value")).intValue();
/*  97 */       this.WING_INIT_PHASE = Integer.valueOf(((Element)data.get("WING_INIT_PHASE")).attributeValue("value")).intValue();
/*  98 */       this.WING_PROPERTY_NUM = Integer.valueOf(((Element)data.get("WING_PROPERTY_NUM")).attributeValue("value")).intValue();
/*  99 */       this.NORMAL_PROPERTY_WEIGHT = Integer.valueOf(((Element)data.get("NORMAL_PROPERTY_WEIGHT")).attributeValue("value")).intValue();
/* 100 */       this.EXCELLENT_PROPERTY_WEIGHT = Integer.valueOf(((Element)data.get("EXCELLENT_PROPERTY_WEIGHT")).attributeValue("value")).intValue();
/* 101 */       this.ELITE_PROPERTY_WEIGHT = Integer.valueOf(((Element)data.get("ELITE_PROPERTY_WEIGHT")).attributeValue("value")).intValue();
/* 102 */       this.BRILLIANT_PROPERTY_WEIGHT = Integer.valueOf(((Element)data.get("BRILLIANT_PROPERTY_WEIGHT")).attributeValue("value")).intValue();
/* 103 */       this.PERFECT_PROPERTY_WEIGHT = Integer.valueOf(((Element)data.get("PERFECT_PROPERTY_WEIGHT")).attributeValue("value")).intValue();
/* 104 */       this.GRASPING_TWO_SKILL_RATE = Integer.valueOf(((Element)data.get("GRASPING_TWO_SKILL_RATE")).attributeValue("value")).intValue();
/* 105 */       this.MAX_WING_VIEW_NUM = Integer.valueOf(((Element)data.get("MAX_WING_VIEW_NUM")).attributeValue("value")).intValue();
/* 106 */       this.SCHEMA2_NEED_YUANBAO = Integer.valueOf(((Element)data.get("SCHEMA2_NEED_YUANBAO")).attributeValue("value")).intValue();
/* 107 */       this.SCHEMA3_NEED_YUANBAO = Integer.valueOf(((Element)data.get("SCHEMA3_NEED_YUANBAO")).attributeValue("value")).intValue();
/* 108 */       this.WING_DESC_TIP_ID = Integer.valueOf(((Element)data.get("WING_DESC_TIP_ID")).attributeValue("value")).intValue();
/* 109 */       this.MAX_SCHEMA_NUM = Integer.valueOf(((Element)data.get("MAX_SCHEMA_NUM")).attributeValue("value")).intValue();
/* 110 */       this.WING_ROOT_ITEM_ID = Integer.valueOf(((Element)data.get("WING_ROOT_ITEM_ID")).attributeValue("value")).intValue();
/* 111 */       this.WING_PROPERTY_RESET_ITEM_ID = Integer.valueOf(((Element)data.get("WING_PROPERTY_RESET_ITEM_ID")).attributeValue("value")).intValue();
/* 112 */       this.WING_PROPERTY_RESET_ITEM_NUM = Integer.valueOf(((Element)data.get("WING_PROPERTY_RESET_ITEM_NUM")).attributeValue("value")).intValue();
/* 113 */       this.RESET_WING_YUANBAO_NUM = Integer.valueOf(((Element)data.get("RESET_WING_YUANBAO_NUM")).attributeValue("value")).intValue();
/* 114 */       this.WING_DYE_ITEM_ID = Integer.valueOf(((Element)data.get("WING_DYE_ITEM_ID")).attributeValue("value")).intValue();
/* 115 */       this.WING_FAKE_ITEM_ID = Integer.valueOf(((Element)data.get("WING_FAKE_ITEM_ID")).attributeValue("value")).intValue();
/* 116 */       this.WING_PRO_RESET_TIP_ID = Integer.valueOf(((Element)data.get("WING_PRO_RESET_TIP_ID")).attributeValue("value")).intValue();
/* 117 */       this.WING_UNDERSTAND_TIP_ID = Integer.valueOf(((Element)data.get("WING_UNDERSTAND_TIP_ID")).attributeValue("value")).intValue();
/* 118 */       this.WING_DYE_TIP_ID = Integer.valueOf(((Element)data.get("WING_DYE_TIP_ID")).attributeValue("value")).intValue();
/* 119 */       this.MIN_LEVLE_FOR_RESET_PROPERTY = Integer.valueOf(((Element)data.get("MIN_LEVLE_FOR_RESET_PROPERTY")).attributeValue("value")).intValue();
/* 120 */       this.SUB_SKILL_NUM = Integer.valueOf(((Element)data.get("SUB_SKILL_NUM")).attributeValue("value")).intValue();
/* 121 */       this.PHASE_UP_RAN_SKILL_NUM = Integer.valueOf(((Element)data.get("PHASE_UP_RAN_SKILL_NUM")).attributeValue("value")).intValue();
/* 122 */       this.WING_GRAPH_ID = Integer.valueOf(((Element)data.get("WING_GRAPH_ID")).attributeValue("value")).intValue();
/*     */       
/* 124 */       Element collectionElement = (Element)data.get("TASKS");
/* 125 */       if (collectionElement == null)
/*     */       {
/* 127 */         throw new RuntimeException("collection type element does not find");
/*     */       }
/*     */       
/* 130 */       List<?> _nodeList = collectionElement.elements();
/* 131 */       int _len = _nodeList.size();
/* 132 */       for (int i = 0; i < _len; i++)
/*     */       {
/* 134 */         Element elem = (Element)_nodeList.get(i);
/* 135 */         if (elem.getName().equalsIgnoreCase("int"))
/*     */         {
/*     */           int _v_;
/*     */           
/*     */ 
/*     */           try
/*     */           {
/* 142 */             _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */           }
/*     */           catch (Exception e)
/*     */           {
/*     */             continue;
/*     */           }
/*     */           
/* 149 */           this.TASKS.add(Integer.valueOf(_v_));
/*     */         }
/*     */       }
/* 152 */       this.SKILL_RESET_TIP_ID = Integer.valueOf(((Element)data.get("SKILL_RESET_TIP_ID")).attributeValue("value")).intValue();
/* 153 */       this.OUT_LOOK_TIP_ID = Integer.valueOf(((Element)data.get("OUT_LOOK_TIP_ID")).attributeValue("value")).intValue();
/* 154 */       this.PRO_TIP_ID = Integer.valueOf(((Element)data.get("PRO_TIP_ID")).attributeValue("value")).intValue();
/* 155 */       this.LEVEL_PRO_ID = Integer.valueOf(((Element)data.get("LEVEL_PRO_ID")).attributeValue("value")).intValue();
/* 156 */       this.WING_LV_MAX = Integer.valueOf(((Element)data.get("WING_LV_MAX")).attributeValue("value")).intValue();
/* 157 */       this.WING_RANGE_MAX = Integer.valueOf(((Element)data.get("WING_RANGE_MAX")).attributeValue("value")).intValue();
/* 158 */       this.TARGET_SKILL_NUM = Integer.valueOf(((Element)data.get("TARGET_SKILL_NUM")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 162 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadXml(String dir) {
/* 167 */     String path = dir + "mzm.gsp.wing.confbean.WingCfgConsts.xml";
/*     */     try
/*     */     {
/* 170 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 171 */       org.dom4j.Document doc = reader.read(new File(path));
/* 172 */       Element root = doc.getRootElement();
/* 173 */       Map<String, Element> data = new java.util.HashMap();
/* 174 */       List<?> nodeList = root.elements();
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
/* 187 */       this.MIN_ROLE_LEVLE_FOR_WING = Integer.valueOf(((Element)data.get("MIN_ROLE_LEVLE_FOR_WING")).attributeValue("value")).intValue();
/* 188 */       this.WING_INIT_LEVEL = Integer.valueOf(((Element)data.get("WING_INIT_LEVEL")).attributeValue("value")).intValue();
/* 189 */       this.WING_INIT_PHASE = Integer.valueOf(((Element)data.get("WING_INIT_PHASE")).attributeValue("value")).intValue();
/* 190 */       this.WING_PROPERTY_NUM = Integer.valueOf(((Element)data.get("WING_PROPERTY_NUM")).attributeValue("value")).intValue();
/* 191 */       this.NORMAL_PROPERTY_WEIGHT = Integer.valueOf(((Element)data.get("NORMAL_PROPERTY_WEIGHT")).attributeValue("value")).intValue();
/* 192 */       this.EXCELLENT_PROPERTY_WEIGHT = Integer.valueOf(((Element)data.get("EXCELLENT_PROPERTY_WEIGHT")).attributeValue("value")).intValue();
/* 193 */       this.ELITE_PROPERTY_WEIGHT = Integer.valueOf(((Element)data.get("ELITE_PROPERTY_WEIGHT")).attributeValue("value")).intValue();
/* 194 */       this.BRILLIANT_PROPERTY_WEIGHT = Integer.valueOf(((Element)data.get("BRILLIANT_PROPERTY_WEIGHT")).attributeValue("value")).intValue();
/* 195 */       this.PERFECT_PROPERTY_WEIGHT = Integer.valueOf(((Element)data.get("PERFECT_PROPERTY_WEIGHT")).attributeValue("value")).intValue();
/* 196 */       this.GRASPING_TWO_SKILL_RATE = Integer.valueOf(((Element)data.get("GRASPING_TWO_SKILL_RATE")).attributeValue("value")).intValue();
/* 197 */       this.MAX_WING_VIEW_NUM = Integer.valueOf(((Element)data.get("MAX_WING_VIEW_NUM")).attributeValue("value")).intValue();
/* 198 */       this.SCHEMA2_NEED_YUANBAO = Integer.valueOf(((Element)data.get("SCHEMA2_NEED_YUANBAO")).attributeValue("value")).intValue();
/* 199 */       this.SCHEMA3_NEED_YUANBAO = Integer.valueOf(((Element)data.get("SCHEMA3_NEED_YUANBAO")).attributeValue("value")).intValue();
/* 200 */       this.WING_DESC_TIP_ID = Integer.valueOf(((Element)data.get("WING_DESC_TIP_ID")).attributeValue("value")).intValue();
/* 201 */       this.MAX_SCHEMA_NUM = Integer.valueOf(((Element)data.get("MAX_SCHEMA_NUM")).attributeValue("value")).intValue();
/* 202 */       this.WING_ROOT_ITEM_ID = Integer.valueOf(((Element)data.get("WING_ROOT_ITEM_ID")).attributeValue("value")).intValue();
/* 203 */       this.WING_PROPERTY_RESET_ITEM_ID = Integer.valueOf(((Element)data.get("WING_PROPERTY_RESET_ITEM_ID")).attributeValue("value")).intValue();
/* 204 */       this.WING_PROPERTY_RESET_ITEM_NUM = Integer.valueOf(((Element)data.get("WING_PROPERTY_RESET_ITEM_NUM")).attributeValue("value")).intValue();
/* 205 */       this.RESET_WING_YUANBAO_NUM = Integer.valueOf(((Element)data.get("RESET_WING_YUANBAO_NUM")).attributeValue("value")).intValue();
/* 206 */       this.WING_DYE_ITEM_ID = Integer.valueOf(((Element)data.get("WING_DYE_ITEM_ID")).attributeValue("value")).intValue();
/* 207 */       this.WING_FAKE_ITEM_ID = Integer.valueOf(((Element)data.get("WING_FAKE_ITEM_ID")).attributeValue("value")).intValue();
/* 208 */       this.WING_PRO_RESET_TIP_ID = Integer.valueOf(((Element)data.get("WING_PRO_RESET_TIP_ID")).attributeValue("value")).intValue();
/* 209 */       this.WING_UNDERSTAND_TIP_ID = Integer.valueOf(((Element)data.get("WING_UNDERSTAND_TIP_ID")).attributeValue("value")).intValue();
/* 210 */       this.WING_DYE_TIP_ID = Integer.valueOf(((Element)data.get("WING_DYE_TIP_ID")).attributeValue("value")).intValue();
/* 211 */       this.MIN_LEVLE_FOR_RESET_PROPERTY = Integer.valueOf(((Element)data.get("MIN_LEVLE_FOR_RESET_PROPERTY")).attributeValue("value")).intValue();
/* 212 */       this.SUB_SKILL_NUM = Integer.valueOf(((Element)data.get("SUB_SKILL_NUM")).attributeValue("value")).intValue();
/* 213 */       this.PHASE_UP_RAN_SKILL_NUM = Integer.valueOf(((Element)data.get("PHASE_UP_RAN_SKILL_NUM")).attributeValue("value")).intValue();
/* 214 */       this.WING_GRAPH_ID = Integer.valueOf(((Element)data.get("WING_GRAPH_ID")).attributeValue("value")).intValue();
/*     */       
/* 216 */       Element collectionElement = (Element)data.get("TASKS");
/* 217 */       if (collectionElement == null)
/*     */       {
/* 219 */         throw new RuntimeException("collection type element does not find");
/*     */       }
/*     */       
/* 222 */       List<?> _nodeList = collectionElement.elements();
/* 223 */       int _len = _nodeList.size();
/* 224 */       for (int i = 0; i < _len; i++)
/*     */       {
/* 226 */         Element elem = (Element)_nodeList.get(i);
/* 227 */         if (elem.getName().equalsIgnoreCase("int"))
/*     */         {
/*     */           int _v_;
/*     */           
/*     */ 
/*     */           try
/*     */           {
/* 234 */             _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */           }
/*     */           catch (Exception e)
/*     */           {
/*     */             continue;
/*     */           }
/*     */           
/* 241 */           this.TASKS.add(Integer.valueOf(_v_));
/*     */         }
/*     */       }
/* 244 */       this.SKILL_RESET_TIP_ID = Integer.valueOf(((Element)data.get("SKILL_RESET_TIP_ID")).attributeValue("value")).intValue();
/* 245 */       this.OUT_LOOK_TIP_ID = Integer.valueOf(((Element)data.get("OUT_LOOK_TIP_ID")).attributeValue("value")).intValue();
/* 246 */       this.PRO_TIP_ID = Integer.valueOf(((Element)data.get("PRO_TIP_ID")).attributeValue("value")).intValue();
/* 247 */       this.LEVEL_PRO_ID = Integer.valueOf(((Element)data.get("LEVEL_PRO_ID")).attributeValue("value")).intValue();
/* 248 */       this.WING_LV_MAX = Integer.valueOf(((Element)data.get("WING_LV_MAX")).attributeValue("value")).intValue();
/* 249 */       this.WING_RANGE_MAX = Integer.valueOf(((Element)data.get("WING_RANGE_MAX")).attributeValue("value")).intValue();
/* 250 */       this.TARGET_SKILL_NUM = Integer.valueOf(((Element)data.get("TARGET_SKILL_NUM")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 254 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/* 258 */   public static void loadBny(String dir) { instance._loadBny(dir); }
/*     */   
/*     */   public void _loadBny(String dir) {
/* 261 */     String path = dir + "mzm.gsp.wing.confbean.WingCfgConsts.bny";
/*     */     try
/*     */     {
/* 264 */       File file = new File(path);
/* 265 */       if (file.exists())
/*     */       {
/* 267 */         byte[] bytes = new byte['Ѐ'];
/* 268 */         FileInputStream fis = new FileInputStream(file);
/* 269 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 270 */         int len = 0;
/* 271 */         while ((len = fis.read(bytes)) > 0)
/* 272 */           baos.write(bytes, 0, len);
/* 273 */         fis.close();
/* 274 */         bytes = baos.toByteArray();
/* 275 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 276 */         this.MIN_ROLE_LEVLE_FOR_WING = _os_.unmarshal_int();
/* 277 */         this.WING_INIT_LEVEL = _os_.unmarshal_int();
/* 278 */         this.WING_INIT_PHASE = _os_.unmarshal_int();
/* 279 */         this.WING_PROPERTY_NUM = _os_.unmarshal_int();
/* 280 */         this.NORMAL_PROPERTY_WEIGHT = _os_.unmarshal_int();
/* 281 */         this.EXCELLENT_PROPERTY_WEIGHT = _os_.unmarshal_int();
/* 282 */         this.ELITE_PROPERTY_WEIGHT = _os_.unmarshal_int();
/* 283 */         this.BRILLIANT_PROPERTY_WEIGHT = _os_.unmarshal_int();
/* 284 */         this.PERFECT_PROPERTY_WEIGHT = _os_.unmarshal_int();
/* 285 */         this.GRASPING_TWO_SKILL_RATE = _os_.unmarshal_int();
/* 286 */         this.MAX_WING_VIEW_NUM = _os_.unmarshal_int();
/* 287 */         this.SCHEMA2_NEED_YUANBAO = _os_.unmarshal_int();
/* 288 */         this.SCHEMA3_NEED_YUANBAO = _os_.unmarshal_int();
/* 289 */         this.WING_DESC_TIP_ID = _os_.unmarshal_int();
/* 290 */         this.MAX_SCHEMA_NUM = _os_.unmarshal_int();
/* 291 */         this.WING_ROOT_ITEM_ID = _os_.unmarshal_int();
/* 292 */         this.WING_PROPERTY_RESET_ITEM_ID = _os_.unmarshal_int();
/* 293 */         this.WING_PROPERTY_RESET_ITEM_NUM = _os_.unmarshal_int();
/* 294 */         this.RESET_WING_YUANBAO_NUM = _os_.unmarshal_int();
/* 295 */         this.WING_DYE_ITEM_ID = _os_.unmarshal_int();
/* 296 */         this.WING_FAKE_ITEM_ID = _os_.unmarshal_int();
/* 297 */         this.WING_PRO_RESET_TIP_ID = _os_.unmarshal_int();
/* 298 */         this.WING_UNDERSTAND_TIP_ID = _os_.unmarshal_int();
/* 299 */         this.WING_DYE_TIP_ID = _os_.unmarshal_int();
/* 300 */         this.MIN_LEVLE_FOR_RESET_PROPERTY = _os_.unmarshal_int();
/* 301 */         this.SUB_SKILL_NUM = _os_.unmarshal_int();
/* 302 */         this.PHASE_UP_RAN_SKILL_NUM = _os_.unmarshal_int();
/* 303 */         this.WING_GRAPH_ID = _os_.unmarshal_int();
/* 304 */         for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */         {
/*     */ 
/* 307 */           int _v_ = _os_.unmarshal_int();
/* 308 */           this.TASKS.add(Integer.valueOf(_v_));
/*     */         }
/* 310 */         this.SKILL_RESET_TIP_ID = _os_.unmarshal_int();
/* 311 */         this.OUT_LOOK_TIP_ID = _os_.unmarshal_int();
/* 312 */         this.PRO_TIP_ID = _os_.unmarshal_int();
/* 313 */         this.LEVEL_PRO_ID = _os_.unmarshal_int();
/* 314 */         this.WING_LV_MAX = _os_.unmarshal_int();
/* 315 */         this.WING_RANGE_MAX = _os_.unmarshal_int();
/* 316 */         this.TARGET_SKILL_NUM = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 321 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadBny(String dir)
/*     */   {
/* 327 */     String path = dir + "mzm.gsp.wing.confbean.WingCfgConsts.bny";
/*     */     try
/*     */     {
/* 330 */       File file = new File(path);
/* 331 */       if (file.exists())
/*     */       {
/* 333 */         byte[] bytes = new byte['Ѐ'];
/* 334 */         FileInputStream fis = new FileInputStream(file);
/* 335 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 336 */         int len = 0;
/* 337 */         while ((len = fis.read(bytes)) > 0)
/* 338 */           baos.write(bytes, 0, len);
/* 339 */         fis.close();
/* 340 */         bytes = baos.toByteArray();
/* 341 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 342 */         this.MIN_ROLE_LEVLE_FOR_WING = _os_.unmarshal_int();
/* 343 */         this.WING_INIT_LEVEL = _os_.unmarshal_int();
/* 344 */         this.WING_INIT_PHASE = _os_.unmarshal_int();
/* 345 */         this.WING_PROPERTY_NUM = _os_.unmarshal_int();
/* 346 */         this.NORMAL_PROPERTY_WEIGHT = _os_.unmarshal_int();
/* 347 */         this.EXCELLENT_PROPERTY_WEIGHT = _os_.unmarshal_int();
/* 348 */         this.ELITE_PROPERTY_WEIGHT = _os_.unmarshal_int();
/* 349 */         this.BRILLIANT_PROPERTY_WEIGHT = _os_.unmarshal_int();
/* 350 */         this.PERFECT_PROPERTY_WEIGHT = _os_.unmarshal_int();
/* 351 */         this.GRASPING_TWO_SKILL_RATE = _os_.unmarshal_int();
/* 352 */         this.MAX_WING_VIEW_NUM = _os_.unmarshal_int();
/* 353 */         this.SCHEMA2_NEED_YUANBAO = _os_.unmarshal_int();
/* 354 */         this.SCHEMA3_NEED_YUANBAO = _os_.unmarshal_int();
/* 355 */         this.WING_DESC_TIP_ID = _os_.unmarshal_int();
/* 356 */         this.MAX_SCHEMA_NUM = _os_.unmarshal_int();
/* 357 */         this.WING_ROOT_ITEM_ID = _os_.unmarshal_int();
/* 358 */         this.WING_PROPERTY_RESET_ITEM_ID = _os_.unmarshal_int();
/* 359 */         this.WING_PROPERTY_RESET_ITEM_NUM = _os_.unmarshal_int();
/* 360 */         this.RESET_WING_YUANBAO_NUM = _os_.unmarshal_int();
/* 361 */         this.WING_DYE_ITEM_ID = _os_.unmarshal_int();
/* 362 */         this.WING_FAKE_ITEM_ID = _os_.unmarshal_int();
/* 363 */         this.WING_PRO_RESET_TIP_ID = _os_.unmarshal_int();
/* 364 */         this.WING_UNDERSTAND_TIP_ID = _os_.unmarshal_int();
/* 365 */         this.WING_DYE_TIP_ID = _os_.unmarshal_int();
/* 366 */         this.MIN_LEVLE_FOR_RESET_PROPERTY = _os_.unmarshal_int();
/* 367 */         this.SUB_SKILL_NUM = _os_.unmarshal_int();
/* 368 */         this.PHASE_UP_RAN_SKILL_NUM = _os_.unmarshal_int();
/* 369 */         this.WING_GRAPH_ID = _os_.unmarshal_int();
/* 370 */         for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */         {
/*     */ 
/* 373 */           int _v_ = _os_.unmarshal_int();
/* 374 */           this.TASKS.add(Integer.valueOf(_v_));
/*     */         }
/* 376 */         this.SKILL_RESET_TIP_ID = _os_.unmarshal_int();
/* 377 */         this.OUT_LOOK_TIP_ID = _os_.unmarshal_int();
/* 378 */         this.PRO_TIP_ID = _os_.unmarshal_int();
/* 379 */         this.LEVEL_PRO_ID = _os_.unmarshal_int();
/* 380 */         this.WING_LV_MAX = _os_.unmarshal_int();
/* 381 */         this.WING_RANGE_MAX = _os_.unmarshal_int();
/* 382 */         this.TARGET_SKILL_NUM = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 387 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void setInstance(WingCfgConsts newInstance)
/*     */   {
/* 393 */     oldInstance = instance;
/* 394 */     instance = newInstance;
/*     */   }
/*     */   
/*     */   public static void resetOldInstance()
/*     */   {
/* 399 */     oldInstance = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wing\confbean\WingCfgConsts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */