/*     */ package mzm.gsp.drawcarnival.confbean;
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
/*     */ public class SDrawCarnivalPassTypeCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SDrawCarnivalPassTypeCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SDrawCarnivalPassTypeCfg> all = null;
/*     */   
/*     */   public int passTypeId;
/*     */   public int yuanBaoPrice;
/*     */   public int drawCountPerPass;
/*     */   public int freePassCountPerDay;
/*     */   public int freePassResetTime;
/*     */   public int baseRatePerPass;
/*     */   public int extraRatePerPass;
/*     */   public int freePassLotteryViewCfgId;
/*     */   public int passLotteryViewCfgId;
/*     */   public int useFreePassPointCount;
/*     */   public int usePassPointCount;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  32 */     this.passTypeId = Integer.valueOf(rootElement.attributeValue("passTypeId")).intValue();
/*  33 */     this.yuanBaoPrice = Integer.valueOf(rootElement.attributeValue("yuanBaoPrice")).intValue();
/*  34 */     this.drawCountPerPass = Integer.valueOf(rootElement.attributeValue("drawCountPerPass")).intValue();
/*  35 */     this.freePassCountPerDay = Integer.valueOf(rootElement.attributeValue("freePassCountPerDay")).intValue();
/*  36 */     this.freePassResetTime = Integer.valueOf(rootElement.attributeValue("freePassResetTime")).intValue();
/*  37 */     this.baseRatePerPass = Integer.valueOf(rootElement.attributeValue("baseRatePerPass")).intValue();
/*  38 */     this.extraRatePerPass = Integer.valueOf(rootElement.attributeValue("extraRatePerPass")).intValue();
/*  39 */     this.freePassLotteryViewCfgId = Integer.valueOf(rootElement.attributeValue("freePassLotteryViewCfgId")).intValue();
/*  40 */     this.passLotteryViewCfgId = Integer.valueOf(rootElement.attributeValue("passLotteryViewCfgId")).intValue();
/*  41 */     this.useFreePassPointCount = Integer.valueOf(rootElement.attributeValue("useFreePassPointCount")).intValue();
/*  42 */     this.usePassPointCount = Integer.valueOf(rootElement.attributeValue("usePassPointCount")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  47 */     _os_.marshal(this.passTypeId);
/*  48 */     _os_.marshal(this.yuanBaoPrice);
/*  49 */     _os_.marshal(this.drawCountPerPass);
/*  50 */     _os_.marshal(this.freePassCountPerDay);
/*  51 */     _os_.marshal(this.freePassResetTime);
/*  52 */     _os_.marshal(this.baseRatePerPass);
/*  53 */     _os_.marshal(this.extraRatePerPass);
/*  54 */     _os_.marshal(this.freePassLotteryViewCfgId);
/*  55 */     _os_.marshal(this.passLotteryViewCfgId);
/*  56 */     _os_.marshal(this.useFreePassPointCount);
/*  57 */     _os_.marshal(this.usePassPointCount);
/*  58 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  63 */     this.passTypeId = _os_.unmarshal_int();
/*  64 */     this.yuanBaoPrice = _os_.unmarshal_int();
/*  65 */     this.drawCountPerPass = _os_.unmarshal_int();
/*  66 */     this.freePassCountPerDay = _os_.unmarshal_int();
/*  67 */     this.freePassResetTime = _os_.unmarshal_int();
/*  68 */     this.baseRatePerPass = _os_.unmarshal_int();
/*  69 */     this.extraRatePerPass = _os_.unmarshal_int();
/*  70 */     this.freePassLotteryViewCfgId = _os_.unmarshal_int();
/*  71 */     this.passLotteryViewCfgId = _os_.unmarshal_int();
/*  72 */     this.useFreePassPointCount = _os_.unmarshal_int();
/*  73 */     this.usePassPointCount = _os_.unmarshal_int();
/*  74 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  79 */     String path = dir + "mzm.gsp.drawcarnival.confbean.SDrawCarnivalPassTypeCfg.xml";
/*     */     
/*     */     try
/*     */     {
/*  83 */       all = new java.util.HashMap();
/*  84 */       SAXReader reader = new SAXReader();
/*  85 */       org.dom4j.Document doc = reader.read(new File(path));
/*  86 */       Element root = doc.getRootElement();
/*  87 */       List<?> nodeList = root.elements();
/*  88 */       int len = nodeList.size();
/*  89 */       for (int i = 0; i < len; i++)
/*     */       {
/*  91 */         Element elem = (Element)nodeList.get(i);
/*  92 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.drawcarnival.confbean.SDrawCarnivalPassTypeCfg"))
/*     */         {
/*     */ 
/*  95 */           SDrawCarnivalPassTypeCfg obj = new SDrawCarnivalPassTypeCfg();
/*  96 */           obj.loadFromXml(elem);
/*  97 */           if (all.put(Integer.valueOf(obj.passTypeId), obj) != null) {
/*  98 */             throw new RuntimeException("duplicate key : " + obj.passTypeId);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 103 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SDrawCarnivalPassTypeCfg> all)
/*     */   {
/* 109 */     String path = dir + "mzm.gsp.drawcarnival.confbean.SDrawCarnivalPassTypeCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 113 */       SAXReader reader = new SAXReader();
/* 114 */       org.dom4j.Document doc = reader.read(new File(path));
/* 115 */       Element root = doc.getRootElement();
/* 116 */       List<?> nodeList = root.elements();
/* 117 */       int len = nodeList.size();
/* 118 */       for (int i = 0; i < len; i++)
/*     */       {
/* 120 */         Element elem = (Element)nodeList.get(i);
/* 121 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.drawcarnival.confbean.SDrawCarnivalPassTypeCfg"))
/*     */         {
/*     */ 
/* 124 */           SDrawCarnivalPassTypeCfg obj = new SDrawCarnivalPassTypeCfg();
/* 125 */           obj.loadFromXml(elem);
/* 126 */           if (all.put(Integer.valueOf(obj.passTypeId), obj) != null) {
/* 127 */             throw new RuntimeException("duplicate key : " + obj.passTypeId);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 132 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 138 */     all = new java.util.HashMap();
/*     */     
/* 140 */     String path = dir + "mzm.gsp.drawcarnival.confbean.SDrawCarnivalPassTypeCfg.bny";
/*     */     try
/*     */     {
/* 143 */       File file = new File(path);
/* 144 */       if (file.exists())
/*     */       {
/* 146 */         byte[] bytes = new byte['Ѐ'];
/* 147 */         FileInputStream fis = new FileInputStream(file);
/* 148 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 149 */         int len = 0;
/* 150 */         while ((len = fis.read(bytes)) > 0)
/* 151 */           baos.write(bytes, 0, len);
/* 152 */         fis.close();
/* 153 */         bytes = baos.toByteArray();
/* 154 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 155 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 157 */           _os_.unmarshal_int();
/* 158 */           _os_.unmarshal_int();
/* 159 */           _os_.unmarshal_int();
/*     */         }
/* 161 */         _os_.unmarshal_int();
/* 162 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 165 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 167 */           SDrawCarnivalPassTypeCfg _v_ = new SDrawCarnivalPassTypeCfg();
/* 168 */           _v_.unmarshal(_os_);
/* 169 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 170 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 175 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 180 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SDrawCarnivalPassTypeCfg> all)
/*     */   {
/* 187 */     String path = dir + "mzm.gsp.drawcarnival.confbean.SDrawCarnivalPassTypeCfg.bny";
/*     */     try
/*     */     {
/* 190 */       File file = new File(path);
/* 191 */       if (file.exists())
/*     */       {
/* 193 */         byte[] bytes = new byte['Ѐ'];
/* 194 */         FileInputStream fis = new FileInputStream(file);
/* 195 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 196 */         int len = 0;
/* 197 */         while ((len = fis.read(bytes)) > 0)
/* 198 */           baos.write(bytes, 0, len);
/* 199 */         fis.close();
/* 200 */         bytes = baos.toByteArray();
/* 201 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 202 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 204 */           _os_.unmarshal_int();
/* 205 */           _os_.unmarshal_int();
/* 206 */           _os_.unmarshal_int();
/*     */         }
/* 208 */         _os_.unmarshal_int();
/* 209 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 212 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 214 */           SDrawCarnivalPassTypeCfg _v_ = new SDrawCarnivalPassTypeCfg();
/* 215 */           _v_.unmarshal(_os_);
/* 216 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 217 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 222 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 227 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SDrawCarnivalPassTypeCfg getOld(int key)
/*     */   {
/* 235 */     return (SDrawCarnivalPassTypeCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SDrawCarnivalPassTypeCfg get(int key)
/*     */   {
/* 240 */     return (SDrawCarnivalPassTypeCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SDrawCarnivalPassTypeCfg> getOldAll()
/*     */   {
/* 245 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SDrawCarnivalPassTypeCfg> getAll()
/*     */   {
/* 250 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SDrawCarnivalPassTypeCfg> newAll)
/*     */   {
/* 255 */     oldAll = all;
/* 256 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 261 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\drawcarnival\confbean\SDrawCarnivalPassTypeCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */