/*     */ package mzm.gsp.activity3.confbean;
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
/*     */ public class SBackGameActivityCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SBackGameActivityCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SBackGameActivityCfg> all = null;
/*     */   
/*     */   public int activityId;
/*     */   public int backGameOnlineHour;
/*     */   public int backGameLastLoginTime;
/*     */   public int backGameCycleDay;
/*     */   public int backGameMessageId;
/*     */   public int signCfgId;
/*     */   public int pointCfgId;
/*     */   public int awardCfgId;
/*     */   public int giftCfgId;
/*     */   public int expCfgId;
/*     */   public int taskCfgId;
/*     */   public int rechargeCfgId;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  33 */     this.activityId = Integer.valueOf(rootElement.attributeValue("activityId")).intValue();
/*  34 */     this.backGameOnlineHour = Integer.valueOf(rootElement.attributeValue("backGameOnlineHour")).intValue();
/*  35 */     this.backGameLastLoginTime = Integer.valueOf(rootElement.attributeValue("backGameLastLoginTime")).intValue();
/*  36 */     this.backGameCycleDay = Integer.valueOf(rootElement.attributeValue("backGameCycleDay")).intValue();
/*  37 */     this.backGameMessageId = Integer.valueOf(rootElement.attributeValue("backGameMessageId")).intValue();
/*  38 */     this.signCfgId = Integer.valueOf(rootElement.attributeValue("signCfgId")).intValue();
/*  39 */     this.pointCfgId = Integer.valueOf(rootElement.attributeValue("pointCfgId")).intValue();
/*  40 */     this.awardCfgId = Integer.valueOf(rootElement.attributeValue("awardCfgId")).intValue();
/*  41 */     this.giftCfgId = Integer.valueOf(rootElement.attributeValue("giftCfgId")).intValue();
/*  42 */     this.expCfgId = Integer.valueOf(rootElement.attributeValue("expCfgId")).intValue();
/*  43 */     this.taskCfgId = Integer.valueOf(rootElement.attributeValue("taskCfgId")).intValue();
/*  44 */     this.rechargeCfgId = Integer.valueOf(rootElement.attributeValue("rechargeCfgId")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  49 */     _os_.marshal(this.activityId);
/*  50 */     _os_.marshal(this.backGameOnlineHour);
/*  51 */     _os_.marshal(this.backGameLastLoginTime);
/*  52 */     _os_.marshal(this.backGameCycleDay);
/*  53 */     _os_.marshal(this.backGameMessageId);
/*  54 */     _os_.marshal(this.signCfgId);
/*  55 */     _os_.marshal(this.pointCfgId);
/*  56 */     _os_.marshal(this.awardCfgId);
/*  57 */     _os_.marshal(this.giftCfgId);
/*  58 */     _os_.marshal(this.expCfgId);
/*  59 */     _os_.marshal(this.taskCfgId);
/*  60 */     _os_.marshal(this.rechargeCfgId);
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  66 */     this.activityId = _os_.unmarshal_int();
/*  67 */     this.backGameOnlineHour = _os_.unmarshal_int();
/*  68 */     this.backGameLastLoginTime = _os_.unmarshal_int();
/*  69 */     this.backGameCycleDay = _os_.unmarshal_int();
/*  70 */     this.backGameMessageId = _os_.unmarshal_int();
/*  71 */     this.signCfgId = _os_.unmarshal_int();
/*  72 */     this.pointCfgId = _os_.unmarshal_int();
/*  73 */     this.awardCfgId = _os_.unmarshal_int();
/*  74 */     this.giftCfgId = _os_.unmarshal_int();
/*  75 */     this.expCfgId = _os_.unmarshal_int();
/*  76 */     this.taskCfgId = _os_.unmarshal_int();
/*  77 */     this.rechargeCfgId = _os_.unmarshal_int();
/*  78 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  83 */     String path = dir + "mzm.gsp.activity3.confbean.SBackGameActivityCfg.xml";
/*     */     
/*     */     try
/*     */     {
/*  87 */       all = new java.util.HashMap();
/*  88 */       SAXReader reader = new SAXReader();
/*  89 */       org.dom4j.Document doc = reader.read(new File(path));
/*  90 */       Element root = doc.getRootElement();
/*  91 */       List<?> nodeList = root.elements();
/*  92 */       int len = nodeList.size();
/*  93 */       for (int i = 0; i < len; i++)
/*     */       {
/*  95 */         Element elem = (Element)nodeList.get(i);
/*  96 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.activity3.confbean.SBackGameActivityCfg"))
/*     */         {
/*     */ 
/*  99 */           SBackGameActivityCfg obj = new SBackGameActivityCfg();
/* 100 */           obj.loadFromXml(elem);
/* 101 */           if (all.put(Integer.valueOf(obj.activityId), obj) != null) {
/* 102 */             throw new RuntimeException("duplicate key : " + obj.activityId);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 107 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SBackGameActivityCfg> all)
/*     */   {
/* 113 */     String path = dir + "mzm.gsp.activity3.confbean.SBackGameActivityCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 117 */       SAXReader reader = new SAXReader();
/* 118 */       org.dom4j.Document doc = reader.read(new File(path));
/* 119 */       Element root = doc.getRootElement();
/* 120 */       List<?> nodeList = root.elements();
/* 121 */       int len = nodeList.size();
/* 122 */       for (int i = 0; i < len; i++)
/*     */       {
/* 124 */         Element elem = (Element)nodeList.get(i);
/* 125 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.activity3.confbean.SBackGameActivityCfg"))
/*     */         {
/*     */ 
/* 128 */           SBackGameActivityCfg obj = new SBackGameActivityCfg();
/* 129 */           obj.loadFromXml(elem);
/* 130 */           if (all.put(Integer.valueOf(obj.activityId), obj) != null) {
/* 131 */             throw new RuntimeException("duplicate key : " + obj.activityId);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 136 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 142 */     all = new java.util.HashMap();
/*     */     
/* 144 */     String path = dir + "mzm.gsp.activity3.confbean.SBackGameActivityCfg.bny";
/*     */     try
/*     */     {
/* 147 */       File file = new File(path);
/* 148 */       if (file.exists())
/*     */       {
/* 150 */         byte[] bytes = new byte['Ѐ'];
/* 151 */         FileInputStream fis = new FileInputStream(file);
/* 152 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 153 */         int len = 0;
/* 154 */         while ((len = fis.read(bytes)) > 0)
/* 155 */           baos.write(bytes, 0, len);
/* 156 */         fis.close();
/* 157 */         bytes = baos.toByteArray();
/* 158 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 159 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 161 */           _os_.unmarshal_int();
/* 162 */           _os_.unmarshal_int();
/* 163 */           _os_.unmarshal_int();
/*     */         }
/* 165 */         _os_.unmarshal_int();
/* 166 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 169 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 171 */           SBackGameActivityCfg _v_ = new SBackGameActivityCfg();
/* 172 */           _v_.unmarshal(_os_);
/* 173 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 174 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 179 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 184 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SBackGameActivityCfg> all)
/*     */   {
/* 191 */     String path = dir + "mzm.gsp.activity3.confbean.SBackGameActivityCfg.bny";
/*     */     try
/*     */     {
/* 194 */       File file = new File(path);
/* 195 */       if (file.exists())
/*     */       {
/* 197 */         byte[] bytes = new byte['Ѐ'];
/* 198 */         FileInputStream fis = new FileInputStream(file);
/* 199 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 200 */         int len = 0;
/* 201 */         while ((len = fis.read(bytes)) > 0)
/* 202 */           baos.write(bytes, 0, len);
/* 203 */         fis.close();
/* 204 */         bytes = baos.toByteArray();
/* 205 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 206 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 208 */           _os_.unmarshal_int();
/* 209 */           _os_.unmarshal_int();
/* 210 */           _os_.unmarshal_int();
/*     */         }
/* 212 */         _os_.unmarshal_int();
/* 213 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 216 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 218 */           SBackGameActivityCfg _v_ = new SBackGameActivityCfg();
/* 219 */           _v_.unmarshal(_os_);
/* 220 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 221 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 226 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 231 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SBackGameActivityCfg getOld(int key)
/*     */   {
/* 239 */     return (SBackGameActivityCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SBackGameActivityCfg get(int key)
/*     */   {
/* 244 */     return (SBackGameActivityCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SBackGameActivityCfg> getOldAll()
/*     */   {
/* 249 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SBackGameActivityCfg> getAll()
/*     */   {
/* 254 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SBackGameActivityCfg> newAll)
/*     */   {
/* 259 */     oldAll = all;
/* 260 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 265 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity3\confbean\SBackGameActivityCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */