/*     */ package mzm.gsp.crossbattle.confbean;
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
/*     */ public class SCrossBattleDrawLotsCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SCrossBattleDrawLotsCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SCrossBattleDrawLotsCfg> all = null;
/*     */   
/*     */   public int activityCfgid;
/*     */   public int firstZoneIndex;
/*     */   public int drawLotsMailCfgid;
/*     */   public int zoneMailCfgid;
/*     */   public int zoneDivideTimePoint;
/*     */   public int drawLotsTimePoint;
/*     */   public int durationInMinute;
/*     */   public int activitySwitch;
/*     */   public int funSwitch;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  30 */     this.activityCfgid = Integer.valueOf(rootElement.attributeValue("activityCfgid")).intValue();
/*  31 */     this.firstZoneIndex = Integer.valueOf(rootElement.attributeValue("firstZoneIndex")).intValue();
/*  32 */     this.drawLotsMailCfgid = Integer.valueOf(rootElement.attributeValue("drawLotsMailCfgid")).intValue();
/*  33 */     this.zoneMailCfgid = Integer.valueOf(rootElement.attributeValue("zoneMailCfgid")).intValue();
/*  34 */     this.zoneDivideTimePoint = Integer.valueOf(rootElement.attributeValue("zoneDivideTimePoint")).intValue();
/*  35 */     this.drawLotsTimePoint = Integer.valueOf(rootElement.attributeValue("drawLotsTimePoint")).intValue();
/*  36 */     this.durationInMinute = Integer.valueOf(rootElement.attributeValue("durationInMinute")).intValue();
/*  37 */     this.activitySwitch = Integer.valueOf(rootElement.attributeValue("activitySwitch")).intValue();
/*  38 */     this.funSwitch = Integer.valueOf(rootElement.attributeValue("funSwitch")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  43 */     _os_.marshal(this.activityCfgid);
/*  44 */     _os_.marshal(this.firstZoneIndex);
/*  45 */     _os_.marshal(this.drawLotsMailCfgid);
/*  46 */     _os_.marshal(this.zoneMailCfgid);
/*  47 */     _os_.marshal(this.zoneDivideTimePoint);
/*  48 */     _os_.marshal(this.drawLotsTimePoint);
/*  49 */     _os_.marshal(this.durationInMinute);
/*  50 */     _os_.marshal(this.activitySwitch);
/*  51 */     _os_.marshal(this.funSwitch);
/*  52 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  57 */     this.activityCfgid = _os_.unmarshal_int();
/*  58 */     this.firstZoneIndex = _os_.unmarshal_int();
/*  59 */     this.drawLotsMailCfgid = _os_.unmarshal_int();
/*  60 */     this.zoneMailCfgid = _os_.unmarshal_int();
/*  61 */     this.zoneDivideTimePoint = _os_.unmarshal_int();
/*  62 */     this.drawLotsTimePoint = _os_.unmarshal_int();
/*  63 */     this.durationInMinute = _os_.unmarshal_int();
/*  64 */     this.activitySwitch = _os_.unmarshal_int();
/*  65 */     this.funSwitch = _os_.unmarshal_int();
/*  66 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  71 */     String path = dir + "mzm.gsp.crossbattle.confbean.SCrossBattleDrawLotsCfg.xml";
/*     */     
/*     */     try
/*     */     {
/*  75 */       all = new java.util.HashMap();
/*  76 */       SAXReader reader = new SAXReader();
/*  77 */       org.dom4j.Document doc = reader.read(new File(path));
/*  78 */       Element root = doc.getRootElement();
/*  79 */       List<?> nodeList = root.elements();
/*  80 */       int len = nodeList.size();
/*  81 */       for (int i = 0; i < len; i++)
/*     */       {
/*  83 */         Element elem = (Element)nodeList.get(i);
/*  84 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.crossbattle.confbean.SCrossBattleDrawLotsCfg"))
/*     */         {
/*     */ 
/*  87 */           SCrossBattleDrawLotsCfg obj = new SCrossBattleDrawLotsCfg();
/*  88 */           obj.loadFromXml(elem);
/*  89 */           if (all.put(Integer.valueOf(obj.activityCfgid), obj) != null) {
/*  90 */             throw new RuntimeException("duplicate key : " + obj.activityCfgid);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/*  95 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SCrossBattleDrawLotsCfg> all)
/*     */   {
/* 101 */     String path = dir + "mzm.gsp.crossbattle.confbean.SCrossBattleDrawLotsCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 105 */       SAXReader reader = new SAXReader();
/* 106 */       org.dom4j.Document doc = reader.read(new File(path));
/* 107 */       Element root = doc.getRootElement();
/* 108 */       List<?> nodeList = root.elements();
/* 109 */       int len = nodeList.size();
/* 110 */       for (int i = 0; i < len; i++)
/*     */       {
/* 112 */         Element elem = (Element)nodeList.get(i);
/* 113 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.crossbattle.confbean.SCrossBattleDrawLotsCfg"))
/*     */         {
/*     */ 
/* 116 */           SCrossBattleDrawLotsCfg obj = new SCrossBattleDrawLotsCfg();
/* 117 */           obj.loadFromXml(elem);
/* 118 */           if (all.put(Integer.valueOf(obj.activityCfgid), obj) != null) {
/* 119 */             throw new RuntimeException("duplicate key : " + obj.activityCfgid);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 124 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 130 */     all = new java.util.HashMap();
/*     */     
/* 132 */     String path = dir + "mzm.gsp.crossbattle.confbean.SCrossBattleDrawLotsCfg.bny";
/*     */     try
/*     */     {
/* 135 */       File file = new File(path);
/* 136 */       if (file.exists())
/*     */       {
/* 138 */         byte[] bytes = new byte['Ѐ'];
/* 139 */         FileInputStream fis = new FileInputStream(file);
/* 140 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 141 */         int len = 0;
/* 142 */         while ((len = fis.read(bytes)) > 0)
/* 143 */           baos.write(bytes, 0, len);
/* 144 */         fis.close();
/* 145 */         bytes = baos.toByteArray();
/* 146 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 147 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 149 */           _os_.unmarshal_int();
/* 150 */           _os_.unmarshal_int();
/* 151 */           _os_.unmarshal_int();
/*     */         }
/* 153 */         _os_.unmarshal_int();
/* 154 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 157 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 159 */           SCrossBattleDrawLotsCfg _v_ = new SCrossBattleDrawLotsCfg();
/* 160 */           _v_.unmarshal(_os_);
/* 161 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 162 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 167 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 172 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SCrossBattleDrawLotsCfg> all)
/*     */   {
/* 179 */     String path = dir + "mzm.gsp.crossbattle.confbean.SCrossBattleDrawLotsCfg.bny";
/*     */     try
/*     */     {
/* 182 */       File file = new File(path);
/* 183 */       if (file.exists())
/*     */       {
/* 185 */         byte[] bytes = new byte['Ѐ'];
/* 186 */         FileInputStream fis = new FileInputStream(file);
/* 187 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 188 */         int len = 0;
/* 189 */         while ((len = fis.read(bytes)) > 0)
/* 190 */           baos.write(bytes, 0, len);
/* 191 */         fis.close();
/* 192 */         bytes = baos.toByteArray();
/* 193 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 194 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 196 */           _os_.unmarshal_int();
/* 197 */           _os_.unmarshal_int();
/* 198 */           _os_.unmarshal_int();
/*     */         }
/* 200 */         _os_.unmarshal_int();
/* 201 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 204 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 206 */           SCrossBattleDrawLotsCfg _v_ = new SCrossBattleDrawLotsCfg();
/* 207 */           _v_.unmarshal(_os_);
/* 208 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 209 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 214 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 219 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SCrossBattleDrawLotsCfg getOld(int key)
/*     */   {
/* 227 */     return (SCrossBattleDrawLotsCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SCrossBattleDrawLotsCfg get(int key)
/*     */   {
/* 232 */     return (SCrossBattleDrawLotsCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SCrossBattleDrawLotsCfg> getOldAll()
/*     */   {
/* 237 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SCrossBattleDrawLotsCfg> getAll()
/*     */   {
/* 242 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SCrossBattleDrawLotsCfg> newAll)
/*     */   {
/* 247 */     oldAll = all;
/* 248 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 253 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\confbean\SCrossBattleDrawLotsCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */