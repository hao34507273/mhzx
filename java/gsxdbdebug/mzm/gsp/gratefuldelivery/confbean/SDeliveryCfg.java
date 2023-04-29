/*     */ package mzm.gsp.gratefuldelivery.confbean;
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
/*     */ public class SDeliveryCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SDeliveryCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SDeliveryCfg> all = null;
/*     */   
/*     */   public int activityId;
/*     */   public int switchId;
/*     */   public int minLevel;
/*     */   public int minItemNum;
/*     */   public int maxItemNum;
/*     */   public int maxDeliveryCountPerDay;
/*     */   public int deliveryRewardId;
/*     */   public int autoDeliveryRewardId;
/*     */   public int autoRedeliveryCountdown;
/*     */   public int activitySubtype;
/*     */   public int mailId;
/*     */   public int cardItemCfgId;
/*     */   public int sendCardTargetCount;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  34 */     this.activityId = Integer.valueOf(rootElement.attributeValue("activityId")).intValue();
/*  35 */     this.switchId = Integer.valueOf(rootElement.attributeValue("switchId")).intValue();
/*  36 */     this.minLevel = Integer.valueOf(rootElement.attributeValue("minLevel")).intValue();
/*  37 */     this.minItemNum = Integer.valueOf(rootElement.attributeValue("minItemNum")).intValue();
/*  38 */     this.maxItemNum = Integer.valueOf(rootElement.attributeValue("maxItemNum")).intValue();
/*  39 */     this.maxDeliveryCountPerDay = Integer.valueOf(rootElement.attributeValue("maxDeliveryCountPerDay")).intValue();
/*  40 */     this.deliveryRewardId = Integer.valueOf(rootElement.attributeValue("deliveryRewardId")).intValue();
/*  41 */     this.autoDeliveryRewardId = Integer.valueOf(rootElement.attributeValue("autoDeliveryRewardId")).intValue();
/*  42 */     this.autoRedeliveryCountdown = Integer.valueOf(rootElement.attributeValue("autoRedeliveryCountdown")).intValue();
/*  43 */     this.activitySubtype = Integer.valueOf(rootElement.attributeValue("activitySubtype")).intValue();
/*  44 */     this.mailId = Integer.valueOf(rootElement.attributeValue("mailId")).intValue();
/*  45 */     this.cardItemCfgId = Integer.valueOf(rootElement.attributeValue("cardItemCfgId")).intValue();
/*  46 */     this.sendCardTargetCount = Integer.valueOf(rootElement.attributeValue("sendCardTargetCount")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  51 */     _os_.marshal(this.activityId);
/*  52 */     _os_.marshal(this.switchId);
/*  53 */     _os_.marshal(this.minLevel);
/*  54 */     _os_.marshal(this.minItemNum);
/*  55 */     _os_.marshal(this.maxItemNum);
/*  56 */     _os_.marshal(this.maxDeliveryCountPerDay);
/*  57 */     _os_.marshal(this.deliveryRewardId);
/*  58 */     _os_.marshal(this.autoDeliveryRewardId);
/*  59 */     _os_.marshal(this.autoRedeliveryCountdown);
/*  60 */     _os_.marshal(this.activitySubtype);
/*  61 */     _os_.marshal(this.mailId);
/*  62 */     _os_.marshal(this.cardItemCfgId);
/*  63 */     _os_.marshal(this.sendCardTargetCount);
/*  64 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  69 */     this.activityId = _os_.unmarshal_int();
/*  70 */     this.switchId = _os_.unmarshal_int();
/*  71 */     this.minLevel = _os_.unmarshal_int();
/*  72 */     this.minItemNum = _os_.unmarshal_int();
/*  73 */     this.maxItemNum = _os_.unmarshal_int();
/*  74 */     this.maxDeliveryCountPerDay = _os_.unmarshal_int();
/*  75 */     this.deliveryRewardId = _os_.unmarshal_int();
/*  76 */     this.autoDeliveryRewardId = _os_.unmarshal_int();
/*  77 */     this.autoRedeliveryCountdown = _os_.unmarshal_int();
/*  78 */     this.activitySubtype = _os_.unmarshal_int();
/*  79 */     this.mailId = _os_.unmarshal_int();
/*  80 */     this.cardItemCfgId = _os_.unmarshal_int();
/*  81 */     this.sendCardTargetCount = _os_.unmarshal_int();
/*  82 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  87 */     String path = dir + "mzm.gsp.gratefuldelivery.confbean.SDeliveryCfg.xml";
/*     */     
/*     */     try
/*     */     {
/*  91 */       all = new java.util.HashMap();
/*  92 */       SAXReader reader = new SAXReader();
/*  93 */       org.dom4j.Document doc = reader.read(new File(path));
/*  94 */       Element root = doc.getRootElement();
/*  95 */       List<?> nodeList = root.elements();
/*  96 */       int len = nodeList.size();
/*  97 */       for (int i = 0; i < len; i++)
/*     */       {
/*  99 */         Element elem = (Element)nodeList.get(i);
/* 100 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.gratefuldelivery.confbean.SDeliveryCfg"))
/*     */         {
/*     */ 
/* 103 */           SDeliveryCfg obj = new SDeliveryCfg();
/* 104 */           obj.loadFromXml(elem);
/* 105 */           if (all.put(Integer.valueOf(obj.activityId), obj) != null) {
/* 106 */             throw new RuntimeException("duplicate key : " + obj.activityId);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 111 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SDeliveryCfg> all)
/*     */   {
/* 117 */     String path = dir + "mzm.gsp.gratefuldelivery.confbean.SDeliveryCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 121 */       SAXReader reader = new SAXReader();
/* 122 */       org.dom4j.Document doc = reader.read(new File(path));
/* 123 */       Element root = doc.getRootElement();
/* 124 */       List<?> nodeList = root.elements();
/* 125 */       int len = nodeList.size();
/* 126 */       for (int i = 0; i < len; i++)
/*     */       {
/* 128 */         Element elem = (Element)nodeList.get(i);
/* 129 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.gratefuldelivery.confbean.SDeliveryCfg"))
/*     */         {
/*     */ 
/* 132 */           SDeliveryCfg obj = new SDeliveryCfg();
/* 133 */           obj.loadFromXml(elem);
/* 134 */           if (all.put(Integer.valueOf(obj.activityId), obj) != null) {
/* 135 */             throw new RuntimeException("duplicate key : " + obj.activityId);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 140 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 146 */     all = new java.util.HashMap();
/*     */     
/* 148 */     String path = dir + "mzm.gsp.gratefuldelivery.confbean.SDeliveryCfg.bny";
/*     */     try
/*     */     {
/* 151 */       File file = new File(path);
/* 152 */       if (file.exists())
/*     */       {
/* 154 */         byte[] bytes = new byte['Ѐ'];
/* 155 */         FileInputStream fis = new FileInputStream(file);
/* 156 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 157 */         int len = 0;
/* 158 */         while ((len = fis.read(bytes)) > 0)
/* 159 */           baos.write(bytes, 0, len);
/* 160 */         fis.close();
/* 161 */         bytes = baos.toByteArray();
/* 162 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 163 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 165 */           _os_.unmarshal_int();
/* 166 */           _os_.unmarshal_int();
/* 167 */           _os_.unmarshal_int();
/*     */         }
/* 169 */         _os_.unmarshal_int();
/* 170 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 173 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 175 */           SDeliveryCfg _v_ = new SDeliveryCfg();
/* 176 */           _v_.unmarshal(_os_);
/* 177 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 178 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 183 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 188 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SDeliveryCfg> all)
/*     */   {
/* 195 */     String path = dir + "mzm.gsp.gratefuldelivery.confbean.SDeliveryCfg.bny";
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
/* 210 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 212 */           _os_.unmarshal_int();
/* 213 */           _os_.unmarshal_int();
/* 214 */           _os_.unmarshal_int();
/*     */         }
/* 216 */         _os_.unmarshal_int();
/* 217 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 220 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 222 */           SDeliveryCfg _v_ = new SDeliveryCfg();
/* 223 */           _v_.unmarshal(_os_);
/* 224 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 225 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 230 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 235 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SDeliveryCfg getOld(int key)
/*     */   {
/* 243 */     return (SDeliveryCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SDeliveryCfg get(int key)
/*     */   {
/* 248 */     return (SDeliveryCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SDeliveryCfg> getOldAll()
/*     */   {
/* 253 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SDeliveryCfg> getAll()
/*     */   {
/* 258 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SDeliveryCfg> newAll)
/*     */   {
/* 263 */     oldAll = all;
/* 264 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 269 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gratefuldelivery\confbean\SDeliveryCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */