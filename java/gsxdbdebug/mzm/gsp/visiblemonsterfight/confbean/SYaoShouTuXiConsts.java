/*     */ package mzm.gsp.visiblemonsterfight.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ 
/*     */ public class SYaoShouTuXiConsts
/*     */ {
/*  13 */   private static volatile SYaoShouTuXiConsts oldInstance = null;
/*     */   
/*  15 */   private static SYaoShouTuXiConsts instance = new SYaoShouTuXiConsts();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static SYaoShouTuXiConsts getOldInstance()
/*     */   {
/*  23 */     return oldInstance;
/*     */   }
/*     */   
/*     */   public static SYaoShouTuXiConsts getInstance()
/*     */   {
/*  28 */     return instance;
/*     */   }
/*     */   
/*  31 */   public int ACTIVITYID = 0;
/*  32 */   public int VISIBLE_MONSTER_ID1 = 0;
/*  33 */   public int AWARD_ID1 = 500000000;
/*  34 */   public int VISIBLE_MONSTER_ID2 = 0;
/*  35 */   public int AWARD_ID2 = 500000000;
/*  36 */   public int REWARD_LIMIT = 3;
/*  37 */   public int CONTROLLERID1 = 0;
/*  38 */   public int CONTROLLERID2 = 0;
/*  39 */   public int NPC_FIGHT_ITEM_ID = 0;
/*  40 */   public int NPC_FIGHT_ITEM_NUM = 0;
/*  41 */   public int NPCID = 150111175;
/*  42 */   public int REFRESH_INTERVAL1_SEC = 7200;
/*  43 */   public int REFRESH_INTERVAL2_SEC = 7200;
/*  44 */   public java.util.ArrayList<Integer> FightIDList = new java.util.ArrayList();
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  48 */     instance.doLoadXml(dir);
/*     */   }
/*     */   
/*     */   private void doLoadXml(String dir)
/*     */   {
/*  53 */     String path = dir + "mzm.gsp.visiblemonsterfight.confbean.SYaoShouTuXiConsts.xml";
/*     */     try
/*     */     {
/*  56 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/*  57 */       org.dom4j.Document doc = reader.read(new File(path));
/*  58 */       Element root = doc.getRootElement();
/*  59 */       Map<String, Element> data = new java.util.HashMap();
/*  60 */       List<?> nodeList = root.elements();
/*  61 */       int len = nodeList.size();
/*  62 */       for (int i = 0; i < len; i++)
/*     */       {
/*  64 */         Element element = (Element)nodeList.get(i);
/*  65 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/*  68 */           String name = element.attributeValue("name");
/*  69 */           if (data.put(name, element) != null)
/*  70 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/*  73 */       this.ACTIVITYID = Integer.valueOf(((Element)data.get("ACTIVITYID")).attributeValue("value")).intValue();
/*  74 */       this.VISIBLE_MONSTER_ID1 = Integer.valueOf(((Element)data.get("VISIBLE_MONSTER_ID1")).attributeValue("value")).intValue();
/*  75 */       this.AWARD_ID1 = Integer.valueOf(((Element)data.get("AWARD_ID1")).attributeValue("value")).intValue();
/*  76 */       this.VISIBLE_MONSTER_ID2 = Integer.valueOf(((Element)data.get("VISIBLE_MONSTER_ID2")).attributeValue("value")).intValue();
/*  77 */       this.AWARD_ID2 = Integer.valueOf(((Element)data.get("AWARD_ID2")).attributeValue("value")).intValue();
/*  78 */       this.REWARD_LIMIT = Integer.valueOf(((Element)data.get("REWARD_LIMIT")).attributeValue("value")).intValue();
/*  79 */       this.CONTROLLERID1 = Integer.valueOf(((Element)data.get("CONTROLLERID1")).attributeValue("value")).intValue();
/*  80 */       this.CONTROLLERID2 = Integer.valueOf(((Element)data.get("CONTROLLERID2")).attributeValue("value")).intValue();
/*  81 */       this.NPC_FIGHT_ITEM_ID = Integer.valueOf(((Element)data.get("NPC_FIGHT_ITEM_ID")).attributeValue("value")).intValue();
/*  82 */       this.NPC_FIGHT_ITEM_NUM = Integer.valueOf(((Element)data.get("NPC_FIGHT_ITEM_NUM")).attributeValue("value")).intValue();
/*  83 */       this.NPCID = Integer.valueOf(((Element)data.get("NPCID")).attributeValue("value")).intValue();
/*  84 */       this.REFRESH_INTERVAL1_SEC = Integer.valueOf(((Element)data.get("REFRESH_INTERVAL1_SEC")).attributeValue("value")).intValue();
/*  85 */       this.REFRESH_INTERVAL2_SEC = Integer.valueOf(((Element)data.get("REFRESH_INTERVAL2_SEC")).attributeValue("value")).intValue();
/*     */       
/*  87 */       Element collectionElement = (Element)data.get("FightIDList");
/*  88 */       if (collectionElement == null)
/*     */       {
/*  90 */         throw new RuntimeException("collection type element does not find");
/*     */       }
/*     */       
/*  93 */       List<?> _nodeList = collectionElement.elements();
/*  94 */       int _len = _nodeList.size();
/*  95 */       for (int i = 0; i < _len; i++)
/*     */       {
/*  97 */         Element elem = (Element)_nodeList.get(i);
/*  98 */         if (elem.getName().equalsIgnoreCase("int"))
/*     */         {
/*     */           int _v_;
/*     */           
/*     */ 
/*     */           try
/*     */           {
/* 105 */             _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */           }
/*     */           catch (Exception e)
/*     */           {
/*     */             continue;
/*     */           }
/*     */           
/* 112 */           this.FightIDList.add(Integer.valueOf(_v_));
/*     */         }
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 118 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadXml(String dir) {
/* 123 */     String path = dir + "mzm.gsp.visiblemonsterfight.confbean.SYaoShouTuXiConsts.xml";
/*     */     try
/*     */     {
/* 126 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 127 */       org.dom4j.Document doc = reader.read(new File(path));
/* 128 */       Element root = doc.getRootElement();
/* 129 */       Map<String, Element> data = new java.util.HashMap();
/* 130 */       List<?> nodeList = root.elements();
/* 131 */       int len = nodeList.size();
/* 132 */       for (int i = 0; i < len; i++)
/*     */       {
/* 134 */         Element element = (Element)nodeList.get(i);
/* 135 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/* 138 */           String name = element.attributeValue("name");
/* 139 */           if (data.put(name, element) != null)
/* 140 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/* 143 */       this.ACTIVITYID = Integer.valueOf(((Element)data.get("ACTIVITYID")).attributeValue("value")).intValue();
/* 144 */       this.VISIBLE_MONSTER_ID1 = Integer.valueOf(((Element)data.get("VISIBLE_MONSTER_ID1")).attributeValue("value")).intValue();
/* 145 */       this.AWARD_ID1 = Integer.valueOf(((Element)data.get("AWARD_ID1")).attributeValue("value")).intValue();
/* 146 */       this.VISIBLE_MONSTER_ID2 = Integer.valueOf(((Element)data.get("VISIBLE_MONSTER_ID2")).attributeValue("value")).intValue();
/* 147 */       this.AWARD_ID2 = Integer.valueOf(((Element)data.get("AWARD_ID2")).attributeValue("value")).intValue();
/* 148 */       this.REWARD_LIMIT = Integer.valueOf(((Element)data.get("REWARD_LIMIT")).attributeValue("value")).intValue();
/* 149 */       this.CONTROLLERID1 = Integer.valueOf(((Element)data.get("CONTROLLERID1")).attributeValue("value")).intValue();
/* 150 */       this.CONTROLLERID2 = Integer.valueOf(((Element)data.get("CONTROLLERID2")).attributeValue("value")).intValue();
/* 151 */       this.NPC_FIGHT_ITEM_ID = Integer.valueOf(((Element)data.get("NPC_FIGHT_ITEM_ID")).attributeValue("value")).intValue();
/* 152 */       this.NPC_FIGHT_ITEM_NUM = Integer.valueOf(((Element)data.get("NPC_FIGHT_ITEM_NUM")).attributeValue("value")).intValue();
/* 153 */       this.NPCID = Integer.valueOf(((Element)data.get("NPCID")).attributeValue("value")).intValue();
/* 154 */       this.REFRESH_INTERVAL1_SEC = Integer.valueOf(((Element)data.get("REFRESH_INTERVAL1_SEC")).attributeValue("value")).intValue();
/* 155 */       this.REFRESH_INTERVAL2_SEC = Integer.valueOf(((Element)data.get("REFRESH_INTERVAL2_SEC")).attributeValue("value")).intValue();
/*     */       
/* 157 */       Element collectionElement = (Element)data.get("FightIDList");
/* 158 */       if (collectionElement == null)
/*     */       {
/* 160 */         throw new RuntimeException("collection type element does not find");
/*     */       }
/*     */       
/* 163 */       List<?> _nodeList = collectionElement.elements();
/* 164 */       int _len = _nodeList.size();
/* 165 */       for (int i = 0; i < _len; i++)
/*     */       {
/* 167 */         Element elem = (Element)_nodeList.get(i);
/* 168 */         if (elem.getName().equalsIgnoreCase("int"))
/*     */         {
/*     */           int _v_;
/*     */           
/*     */ 
/*     */           try
/*     */           {
/* 175 */             _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */           }
/*     */           catch (Exception e)
/*     */           {
/*     */             continue;
/*     */           }
/*     */           
/* 182 */           this.FightIDList.add(Integer.valueOf(_v_));
/*     */         }
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 188 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/* 192 */   public static void loadBny(String dir) { instance._loadBny(dir); }
/*     */   
/*     */   public void _loadBny(String dir) {
/* 195 */     String path = dir + "mzm.gsp.visiblemonsterfight.confbean.SYaoShouTuXiConsts.bny";
/*     */     try
/*     */     {
/* 198 */       File file = new File(path);
/* 199 */       if (file.exists())
/*     */       {
/* 201 */         byte[] bytes = new byte['Ѐ'];
/* 202 */         FileInputStream fis = new FileInputStream(file);
/* 203 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 204 */         int len = 0;
/* 205 */         while ((len = fis.read(bytes)) > 0)
/* 206 */           baos.write(bytes, 0, len);
/* 207 */         fis.close();
/* 208 */         bytes = baos.toByteArray();
/* 209 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 210 */         this.ACTIVITYID = _os_.unmarshal_int();
/* 211 */         this.VISIBLE_MONSTER_ID1 = _os_.unmarshal_int();
/* 212 */         this.AWARD_ID1 = _os_.unmarshal_int();
/* 213 */         this.VISIBLE_MONSTER_ID2 = _os_.unmarshal_int();
/* 214 */         this.AWARD_ID2 = _os_.unmarshal_int();
/* 215 */         this.REWARD_LIMIT = _os_.unmarshal_int();
/* 216 */         this.CONTROLLERID1 = _os_.unmarshal_int();
/* 217 */         this.CONTROLLERID2 = _os_.unmarshal_int();
/* 218 */         this.NPC_FIGHT_ITEM_ID = _os_.unmarshal_int();
/* 219 */         this.NPC_FIGHT_ITEM_NUM = _os_.unmarshal_int();
/* 220 */         this.NPCID = _os_.unmarshal_int();
/* 221 */         this.REFRESH_INTERVAL1_SEC = _os_.unmarshal_int();
/* 222 */         this.REFRESH_INTERVAL2_SEC = _os_.unmarshal_int();
/* 223 */         for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */         {
/*     */ 
/* 226 */           int _v_ = _os_.unmarshal_int();
/* 227 */           this.FightIDList.add(Integer.valueOf(_v_));
/*     */         }
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 233 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadBny(String dir)
/*     */   {
/* 239 */     String path = dir + "mzm.gsp.visiblemonsterfight.confbean.SYaoShouTuXiConsts.bny";
/*     */     try
/*     */     {
/* 242 */       File file = new File(path);
/* 243 */       if (file.exists())
/*     */       {
/* 245 */         byte[] bytes = new byte['Ѐ'];
/* 246 */         FileInputStream fis = new FileInputStream(file);
/* 247 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 248 */         int len = 0;
/* 249 */         while ((len = fis.read(bytes)) > 0)
/* 250 */           baos.write(bytes, 0, len);
/* 251 */         fis.close();
/* 252 */         bytes = baos.toByteArray();
/* 253 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 254 */         this.ACTIVITYID = _os_.unmarshal_int();
/* 255 */         this.VISIBLE_MONSTER_ID1 = _os_.unmarshal_int();
/* 256 */         this.AWARD_ID1 = _os_.unmarshal_int();
/* 257 */         this.VISIBLE_MONSTER_ID2 = _os_.unmarshal_int();
/* 258 */         this.AWARD_ID2 = _os_.unmarshal_int();
/* 259 */         this.REWARD_LIMIT = _os_.unmarshal_int();
/* 260 */         this.CONTROLLERID1 = _os_.unmarshal_int();
/* 261 */         this.CONTROLLERID2 = _os_.unmarshal_int();
/* 262 */         this.NPC_FIGHT_ITEM_ID = _os_.unmarshal_int();
/* 263 */         this.NPC_FIGHT_ITEM_NUM = _os_.unmarshal_int();
/* 264 */         this.NPCID = _os_.unmarshal_int();
/* 265 */         this.REFRESH_INTERVAL1_SEC = _os_.unmarshal_int();
/* 266 */         this.REFRESH_INTERVAL2_SEC = _os_.unmarshal_int();
/* 267 */         for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */         {
/*     */ 
/* 270 */           int _v_ = _os_.unmarshal_int();
/* 271 */           this.FightIDList.add(Integer.valueOf(_v_));
/*     */         }
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 277 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void setInstance(SYaoShouTuXiConsts newInstance)
/*     */   {
/* 283 */     oldInstance = instance;
/* 284 */     instance = newInstance;
/*     */   }
/*     */   
/*     */   public static void resetOldInstance()
/*     */   {
/* 289 */     oldInstance = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\visiblemonsterfight\confbean\SYaoShouTuXiConsts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */