/*     */ package mzm.gsp.bigboss.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ 
/*     */ public class SBigbossCfgConsts
/*     */ {
/*  13 */   private static volatile SBigbossCfgConsts oldInstance = null;
/*     */   
/*  15 */   private static SBigbossCfgConsts instance = new SBigbossCfgConsts();
/*     */   public int ACTIVITYID;
/*     */   public int DAY_OFFER_CHALLENGE_COUNT;
/*     */   public int FIRST_BUY_YUANBAO_PRICE;
/*     */   public int YUANBAO_PRICE_ADD_NUM;
/*     */   public double DAMAGE_PARAM;
/*     */   
/*     */   public static SBigbossCfgConsts getOldInstance() {
/*  23 */     return oldInstance;
/*     */   }
/*     */   
/*     */   public static SBigbossCfgConsts getInstance()
/*     */   {
/*  28 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */   public int FIGHT_END_REWARDID;
/*     */   
/*     */   public int MAX_BUY_COUNT;
/*     */   
/*     */   public int MIN_RANK_FOR_BULLETIN;
/*     */   
/*     */   public int BOSS_HP_BULLETIN_INTERVAL;
/*     */   
/*     */   public int MAILID;
/*     */   public int PAGE_SIZE_LITTLE;
/*  42 */   public java.util.ArrayList<Integer> hprates = new java.util.ArrayList();
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  46 */     instance.doLoadXml(dir);
/*     */   }
/*     */   
/*     */   private void doLoadXml(String dir)
/*     */   {
/*  51 */     String path = dir + "mzm.gsp.bigboss.confbean.SBigbossCfgConsts.xml";
/*     */     try
/*     */     {
/*  54 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/*  55 */       org.dom4j.Document doc = reader.read(new File(path));
/*  56 */       Element root = doc.getRootElement();
/*  57 */       Map<String, Element> data = new java.util.HashMap();
/*  58 */       List<?> nodeList = root.elements();
/*  59 */       int len = nodeList.size();
/*  60 */       for (int i = 0; i < len; i++)
/*     */       {
/*  62 */         Element element = (Element)nodeList.get(i);
/*  63 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/*  66 */           String name = element.attributeValue("name");
/*  67 */           if (data.put(name, element) != null)
/*  68 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/*  71 */       this.ACTIVITYID = Integer.valueOf(((Element)data.get("ACTIVITYID")).attributeValue("value")).intValue();
/*  72 */       this.DAY_OFFER_CHALLENGE_COUNT = Integer.valueOf(((Element)data.get("DAY_OFFER_CHALLENGE_COUNT")).attributeValue("value")).intValue();
/*  73 */       this.FIRST_BUY_YUANBAO_PRICE = Integer.valueOf(((Element)data.get("FIRST_BUY_YUANBAO_PRICE")).attributeValue("value")).intValue();
/*  74 */       this.YUANBAO_PRICE_ADD_NUM = Integer.valueOf(((Element)data.get("YUANBAO_PRICE_ADD_NUM")).attributeValue("value")).intValue();
/*  75 */       this.DAMAGE_PARAM = Double.valueOf(((Element)data.get("DAMAGE_PARAM")).attributeValue("value")).doubleValue();
/*  76 */       this.FIGHT_END_REWARDID = Integer.valueOf(((Element)data.get("FIGHT_END_REWARDID")).attributeValue("value")).intValue();
/*  77 */       this.MAX_BUY_COUNT = Integer.valueOf(((Element)data.get("MAX_BUY_COUNT")).attributeValue("value")).intValue();
/*  78 */       this.MIN_RANK_FOR_BULLETIN = Integer.valueOf(((Element)data.get("MIN_RANK_FOR_BULLETIN")).attributeValue("value")).intValue();
/*  79 */       this.BOSS_HP_BULLETIN_INTERVAL = Integer.valueOf(((Element)data.get("BOSS_HP_BULLETIN_INTERVAL")).attributeValue("value")).intValue();
/*  80 */       this.MAILID = Integer.valueOf(((Element)data.get("MAILID")).attributeValue("value")).intValue();
/*  81 */       this.PAGE_SIZE_LITTLE = Integer.valueOf(((Element)data.get("PAGE_SIZE_LITTLE")).attributeValue("value")).intValue();
/*     */       
/*  83 */       Element collectionElement = (Element)data.get("hprates");
/*  84 */       if (collectionElement == null)
/*     */       {
/*  86 */         throw new RuntimeException("collection type element does not find");
/*     */       }
/*     */       
/*  89 */       List<?> _nodeList = collectionElement.elements();
/*  90 */       int _len = _nodeList.size();
/*  91 */       for (int i = 0; i < _len; i++)
/*     */       {
/*  93 */         Element elem = (Element)_nodeList.get(i);
/*  94 */         if (elem.getName().equalsIgnoreCase("int"))
/*     */         {
/*     */           int _v_;
/*     */           
/*     */ 
/*     */           try
/*     */           {
/* 101 */             _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */           }
/*     */           catch (Exception e)
/*     */           {
/*     */             continue;
/*     */           }
/*     */           
/* 108 */           this.hprates.add(Integer.valueOf(_v_));
/*     */         }
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 114 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadXml(String dir) {
/* 119 */     String path = dir + "mzm.gsp.bigboss.confbean.SBigbossCfgConsts.xml";
/*     */     try
/*     */     {
/* 122 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 123 */       org.dom4j.Document doc = reader.read(new File(path));
/* 124 */       Element root = doc.getRootElement();
/* 125 */       Map<String, Element> data = new java.util.HashMap();
/* 126 */       List<?> nodeList = root.elements();
/* 127 */       int len = nodeList.size();
/* 128 */       for (int i = 0; i < len; i++)
/*     */       {
/* 130 */         Element element = (Element)nodeList.get(i);
/* 131 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/* 134 */           String name = element.attributeValue("name");
/* 135 */           if (data.put(name, element) != null)
/* 136 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/* 139 */       this.ACTIVITYID = Integer.valueOf(((Element)data.get("ACTIVITYID")).attributeValue("value")).intValue();
/* 140 */       this.DAY_OFFER_CHALLENGE_COUNT = Integer.valueOf(((Element)data.get("DAY_OFFER_CHALLENGE_COUNT")).attributeValue("value")).intValue();
/* 141 */       this.FIRST_BUY_YUANBAO_PRICE = Integer.valueOf(((Element)data.get("FIRST_BUY_YUANBAO_PRICE")).attributeValue("value")).intValue();
/* 142 */       this.YUANBAO_PRICE_ADD_NUM = Integer.valueOf(((Element)data.get("YUANBAO_PRICE_ADD_NUM")).attributeValue("value")).intValue();
/* 143 */       this.DAMAGE_PARAM = Double.valueOf(((Element)data.get("DAMAGE_PARAM")).attributeValue("value")).doubleValue();
/* 144 */       this.FIGHT_END_REWARDID = Integer.valueOf(((Element)data.get("FIGHT_END_REWARDID")).attributeValue("value")).intValue();
/* 145 */       this.MAX_BUY_COUNT = Integer.valueOf(((Element)data.get("MAX_BUY_COUNT")).attributeValue("value")).intValue();
/* 146 */       this.MIN_RANK_FOR_BULLETIN = Integer.valueOf(((Element)data.get("MIN_RANK_FOR_BULLETIN")).attributeValue("value")).intValue();
/* 147 */       this.BOSS_HP_BULLETIN_INTERVAL = Integer.valueOf(((Element)data.get("BOSS_HP_BULLETIN_INTERVAL")).attributeValue("value")).intValue();
/* 148 */       this.MAILID = Integer.valueOf(((Element)data.get("MAILID")).attributeValue("value")).intValue();
/* 149 */       this.PAGE_SIZE_LITTLE = Integer.valueOf(((Element)data.get("PAGE_SIZE_LITTLE")).attributeValue("value")).intValue();
/*     */       
/* 151 */       Element collectionElement = (Element)data.get("hprates");
/* 152 */       if (collectionElement == null)
/*     */       {
/* 154 */         throw new RuntimeException("collection type element does not find");
/*     */       }
/*     */       
/* 157 */       List<?> _nodeList = collectionElement.elements();
/* 158 */       int _len = _nodeList.size();
/* 159 */       for (int i = 0; i < _len; i++)
/*     */       {
/* 161 */         Element elem = (Element)_nodeList.get(i);
/* 162 */         if (elem.getName().equalsIgnoreCase("int"))
/*     */         {
/*     */           int _v_;
/*     */           
/*     */ 
/*     */           try
/*     */           {
/* 169 */             _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */           }
/*     */           catch (Exception e)
/*     */           {
/*     */             continue;
/*     */           }
/*     */           
/* 176 */           this.hprates.add(Integer.valueOf(_v_));
/*     */         }
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 182 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/* 186 */   public static void loadBny(String dir) { instance._loadBny(dir); }
/*     */   
/*     */   public void _loadBny(String dir) {
/* 189 */     String path = dir + "mzm.gsp.bigboss.confbean.SBigbossCfgConsts.bny";
/*     */     try
/*     */     {
/* 192 */       File file = new File(path);
/* 193 */       if (file.exists())
/*     */       {
/* 195 */         byte[] bytes = new byte['Ѐ'];
/* 196 */         FileInputStream fis = new FileInputStream(file);
/* 197 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 198 */         int len = 0;
/* 199 */         while ((len = fis.read(bytes)) > 0)
/* 200 */           baos.write(bytes, 0, len);
/* 201 */         fis.close();
/* 202 */         bytes = baos.toByteArray();
/* 203 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 204 */         this.ACTIVITYID = _os_.unmarshal_int();
/* 205 */         this.DAY_OFFER_CHALLENGE_COUNT = _os_.unmarshal_int();
/* 206 */         this.FIRST_BUY_YUANBAO_PRICE = _os_.unmarshal_int();
/* 207 */         this.YUANBAO_PRICE_ADD_NUM = _os_.unmarshal_int();
/* 208 */         this.DAMAGE_PARAM = _os_.unmarshal_float();
/* 209 */         this.FIGHT_END_REWARDID = _os_.unmarshal_int();
/* 210 */         this.MAX_BUY_COUNT = _os_.unmarshal_int();
/* 211 */         this.MIN_RANK_FOR_BULLETIN = _os_.unmarshal_int();
/* 212 */         this.BOSS_HP_BULLETIN_INTERVAL = _os_.unmarshal_int();
/* 213 */         this.MAILID = _os_.unmarshal_int();
/* 214 */         this.PAGE_SIZE_LITTLE = _os_.unmarshal_int();
/* 215 */         for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */         {
/*     */ 
/* 218 */           int _v_ = _os_.unmarshal_int();
/* 219 */           this.hprates.add(Integer.valueOf(_v_));
/*     */         }
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 225 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadBny(String dir)
/*     */   {
/* 231 */     String path = dir + "mzm.gsp.bigboss.confbean.SBigbossCfgConsts.bny";
/*     */     try
/*     */     {
/* 234 */       File file = new File(path);
/* 235 */       if (file.exists())
/*     */       {
/* 237 */         byte[] bytes = new byte['Ѐ'];
/* 238 */         FileInputStream fis = new FileInputStream(file);
/* 239 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 240 */         int len = 0;
/* 241 */         while ((len = fis.read(bytes)) > 0)
/* 242 */           baos.write(bytes, 0, len);
/* 243 */         fis.close();
/* 244 */         bytes = baos.toByteArray();
/* 245 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 246 */         this.ACTIVITYID = _os_.unmarshal_int();
/* 247 */         this.DAY_OFFER_CHALLENGE_COUNT = _os_.unmarshal_int();
/* 248 */         this.FIRST_BUY_YUANBAO_PRICE = _os_.unmarshal_int();
/* 249 */         this.YUANBAO_PRICE_ADD_NUM = _os_.unmarshal_int();
/* 250 */         this.DAMAGE_PARAM = _os_.unmarshal_float();
/* 251 */         this.FIGHT_END_REWARDID = _os_.unmarshal_int();
/* 252 */         this.MAX_BUY_COUNT = _os_.unmarshal_int();
/* 253 */         this.MIN_RANK_FOR_BULLETIN = _os_.unmarshal_int();
/* 254 */         this.BOSS_HP_BULLETIN_INTERVAL = _os_.unmarshal_int();
/* 255 */         this.MAILID = _os_.unmarshal_int();
/* 256 */         this.PAGE_SIZE_LITTLE = _os_.unmarshal_int();
/* 257 */         for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */         {
/*     */ 
/* 260 */           int _v_ = _os_.unmarshal_int();
/* 261 */           this.hprates.add(Integer.valueOf(_v_));
/*     */         }
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 267 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void setInstance(SBigbossCfgConsts newInstance)
/*     */   {
/* 273 */     oldInstance = instance;
/* 274 */     instance = newInstance;
/*     */   }
/*     */   
/*     */   public static void resetOldInstance()
/*     */   {
/* 279 */     oldInstance = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\bigboss\confbean\SBigbossCfgConsts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */