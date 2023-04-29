/*     */ package mzm.gsp.qingfu.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.SAXReader;
/*     */ 
/*     */ public class STimeLimitGiftBagCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, STimeLimitGiftBagCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, STimeLimitGiftBagCfg> all = null;
/*     */   
/*     */   public int id;
/*     */   public int rewardId;
/*     */   public int buyWeekDay;
/*     */   public int maxCount;
/*     */   public int activityId;
/*     */   public int giftBagType;
/*     */   public int moneytype;
/*     */   public int discountPrice;
/*     */   public int originalPrice;
/*     */   public int minActiveValue;
/*     */   public int canGift;
/*     */   public int giftPrice;
/*     */   public int friendIntimacyMin;
/*     */   public int sendCountMax;
/*     */   public int p2pCountMax;
/*     */   public int receiveCountMax;
/*     */   public int isReceiveGiftBind;
/*     */   public String desc;
/*     */   public int giftMoneyType;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  40 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  41 */     this.rewardId = Integer.valueOf(rootElement.attributeValue("rewardId")).intValue();
/*  42 */     this.buyWeekDay = Integer.valueOf(rootElement.attributeValue("buyWeekDay")).intValue();
/*  43 */     this.maxCount = Integer.valueOf(rootElement.attributeValue("maxCount")).intValue();
/*  44 */     this.activityId = Integer.valueOf(rootElement.attributeValue("activityId")).intValue();
/*  45 */     this.giftBagType = Integer.valueOf(rootElement.attributeValue("giftBagType")).intValue();
/*  46 */     this.moneytype = Integer.valueOf(rootElement.attributeValue("moneytype")).intValue();
/*  47 */     this.discountPrice = Integer.valueOf(rootElement.attributeValue("discountPrice")).intValue();
/*  48 */     this.originalPrice = Integer.valueOf(rootElement.attributeValue("originalPrice")).intValue();
/*  49 */     this.minActiveValue = Integer.valueOf(rootElement.attributeValue("minActiveValue")).intValue();
/*  50 */     this.canGift = Integer.valueOf(rootElement.attributeValue("canGift")).intValue();
/*  51 */     this.giftPrice = Integer.valueOf(rootElement.attributeValue("giftPrice")).intValue();
/*  52 */     this.friendIntimacyMin = Integer.valueOf(rootElement.attributeValue("friendIntimacyMin")).intValue();
/*  53 */     this.sendCountMax = Integer.valueOf(rootElement.attributeValue("sendCountMax")).intValue();
/*  54 */     this.p2pCountMax = Integer.valueOf(rootElement.attributeValue("p2pCountMax")).intValue();
/*  55 */     this.receiveCountMax = Integer.valueOf(rootElement.attributeValue("receiveCountMax")).intValue();
/*  56 */     this.isReceiveGiftBind = Integer.valueOf(rootElement.attributeValue("isReceiveGiftBind")).intValue();
/*  57 */     this.desc = rootElement.attributeValue("desc");
/*  58 */     this.giftMoneyType = Integer.valueOf(rootElement.attributeValue("giftMoneyType")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  63 */     _os_.marshal(this.id);
/*  64 */     _os_.marshal(this.rewardId);
/*  65 */     _os_.marshal(this.buyWeekDay);
/*  66 */     _os_.marshal(this.maxCount);
/*  67 */     _os_.marshal(this.activityId);
/*  68 */     _os_.marshal(this.giftBagType);
/*  69 */     _os_.marshal(this.moneytype);
/*  70 */     _os_.marshal(this.discountPrice);
/*  71 */     _os_.marshal(this.originalPrice);
/*  72 */     _os_.marshal(this.minActiveValue);
/*  73 */     _os_.marshal(this.canGift);
/*  74 */     _os_.marshal(this.giftPrice);
/*  75 */     _os_.marshal(this.friendIntimacyMin);
/*  76 */     _os_.marshal(this.sendCountMax);
/*  77 */     _os_.marshal(this.p2pCountMax);
/*  78 */     _os_.marshal(this.receiveCountMax);
/*  79 */     _os_.marshal(this.isReceiveGiftBind);
/*  80 */     _os_.marshal(this.desc, "UTF-8");
/*  81 */     _os_.marshal(this.giftMoneyType);
/*  82 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  87 */     this.id = _os_.unmarshal_int();
/*  88 */     this.rewardId = _os_.unmarshal_int();
/*  89 */     this.buyWeekDay = _os_.unmarshal_int();
/*  90 */     this.maxCount = _os_.unmarshal_int();
/*  91 */     this.activityId = _os_.unmarshal_int();
/*  92 */     this.giftBagType = _os_.unmarshal_int();
/*  93 */     this.moneytype = _os_.unmarshal_int();
/*  94 */     this.discountPrice = _os_.unmarshal_int();
/*  95 */     this.originalPrice = _os_.unmarshal_int();
/*  96 */     this.minActiveValue = _os_.unmarshal_int();
/*  97 */     this.canGift = _os_.unmarshal_int();
/*  98 */     this.giftPrice = _os_.unmarshal_int();
/*  99 */     this.friendIntimacyMin = _os_.unmarshal_int();
/* 100 */     this.sendCountMax = _os_.unmarshal_int();
/* 101 */     this.p2pCountMax = _os_.unmarshal_int();
/* 102 */     this.receiveCountMax = _os_.unmarshal_int();
/* 103 */     this.isReceiveGiftBind = _os_.unmarshal_int();
/* 104 */     this.desc = _os_.unmarshal_String("UTF-8");
/* 105 */     this.giftMoneyType = _os_.unmarshal_int();
/* 106 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 111 */     String path = dir + "mzm.gsp.qingfu.confbean.STimeLimitGiftBagCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 115 */       all = new java.util.HashMap();
/* 116 */       SAXReader reader = new SAXReader();
/* 117 */       org.dom4j.Document doc = reader.read(new File(path));
/* 118 */       Element root = doc.getRootElement();
/* 119 */       List<?> nodeList = root.elements();
/* 120 */       int len = nodeList.size();
/* 121 */       for (int i = 0; i < len; i++)
/*     */       {
/* 123 */         Element elem = (Element)nodeList.get(i);
/* 124 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.qingfu.confbean.STimeLimitGiftBagCfg"))
/*     */         {
/*     */ 
/* 127 */           STimeLimitGiftBagCfg obj = new STimeLimitGiftBagCfg();
/* 128 */           obj.loadFromXml(elem);
/* 129 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 130 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 135 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, STimeLimitGiftBagCfg> all)
/*     */   {
/* 141 */     String path = dir + "mzm.gsp.qingfu.confbean.STimeLimitGiftBagCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 145 */       SAXReader reader = new SAXReader();
/* 146 */       org.dom4j.Document doc = reader.read(new File(path));
/* 147 */       Element root = doc.getRootElement();
/* 148 */       List<?> nodeList = root.elements();
/* 149 */       int len = nodeList.size();
/* 150 */       for (int i = 0; i < len; i++)
/*     */       {
/* 152 */         Element elem = (Element)nodeList.get(i);
/* 153 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.qingfu.confbean.STimeLimitGiftBagCfg"))
/*     */         {
/*     */ 
/* 156 */           STimeLimitGiftBagCfg obj = new STimeLimitGiftBagCfg();
/* 157 */           obj.loadFromXml(elem);
/* 158 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 159 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 164 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 170 */     all = new java.util.HashMap();
/*     */     
/* 172 */     String path = dir + "mzm.gsp.qingfu.confbean.STimeLimitGiftBagCfg.bny";
/*     */     try
/*     */     {
/* 175 */       File file = new File(path);
/* 176 */       if (file.exists())
/*     */       {
/* 178 */         byte[] bytes = new byte['Ѐ'];
/* 179 */         FileInputStream fis = new FileInputStream(file);
/* 180 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 181 */         int len = 0;
/* 182 */         while ((len = fis.read(bytes)) > 0)
/* 183 */           baos.write(bytes, 0, len);
/* 184 */         fis.close();
/* 185 */         bytes = baos.toByteArray();
/* 186 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 187 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 189 */           _os_.unmarshal_int();
/* 190 */           _os_.unmarshal_int();
/* 191 */           _os_.unmarshal_int();
/*     */         }
/* 193 */         _os_.unmarshal_int();
/* 194 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 197 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 199 */           STimeLimitGiftBagCfg _v_ = new STimeLimitGiftBagCfg();
/* 200 */           _v_.unmarshal(_os_);
/* 201 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 202 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 207 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 212 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, STimeLimitGiftBagCfg> all)
/*     */   {
/* 219 */     String path = dir + "mzm.gsp.qingfu.confbean.STimeLimitGiftBagCfg.bny";
/*     */     try
/*     */     {
/* 222 */       File file = new File(path);
/* 223 */       if (file.exists())
/*     */       {
/* 225 */         byte[] bytes = new byte['Ѐ'];
/* 226 */         FileInputStream fis = new FileInputStream(file);
/* 227 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 228 */         int len = 0;
/* 229 */         while ((len = fis.read(bytes)) > 0)
/* 230 */           baos.write(bytes, 0, len);
/* 231 */         fis.close();
/* 232 */         bytes = baos.toByteArray();
/* 233 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 234 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 236 */           _os_.unmarshal_int();
/* 237 */           _os_.unmarshal_int();
/* 238 */           _os_.unmarshal_int();
/*     */         }
/* 240 */         _os_.unmarshal_int();
/* 241 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 244 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 246 */           STimeLimitGiftBagCfg _v_ = new STimeLimitGiftBagCfg();
/* 247 */           _v_.unmarshal(_os_);
/* 248 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 249 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 254 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 259 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static STimeLimitGiftBagCfg getOld(int key)
/*     */   {
/* 267 */     return (STimeLimitGiftBagCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static STimeLimitGiftBagCfg get(int key)
/*     */   {
/* 272 */     return (STimeLimitGiftBagCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, STimeLimitGiftBagCfg> getOldAll()
/*     */   {
/* 277 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, STimeLimitGiftBagCfg> getAll()
/*     */   {
/* 282 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, STimeLimitGiftBagCfg> newAll)
/*     */   {
/* 287 */     oldAll = all;
/* 288 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 293 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingfu\confbean\STimeLimitGiftBagCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */