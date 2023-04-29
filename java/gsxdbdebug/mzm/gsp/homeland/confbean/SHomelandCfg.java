/*     */ package mzm.gsp.homeland.confbean;
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
/*     */ public class SHomelandCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SHomelandCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SHomelandCfg> all = null;
/*     */   
/*     */   public int level;
/*     */   public int id;
/*     */   public int moneyType;
/*     */   public int moneyNum;
/*     */   public int itemId;
/*     */   public int itemNum;
/*     */   public int mapId;
/*     */   public int maxPetRoomLevel;
/*     */   public int maxBedRoomLevel;
/*     */   public int maxDrugRoomLevel;
/*     */   public int maxKitchenLevel;
/*     */   public int maxMaidRoomLevel;
/*     */   public int dayCutCleanliness;
/*     */   public int maxCleanliness;
/*     */   public int maxFengShui;
/*     */   public int offSetX;
/*     */   public int offSetY;
/*     */   public int maidX;
/*     */   public int maidY;
/*     */   public int maidDir;
/*     */   public int point;
/*     */   public int maxPeople;
/*     */   public int transferX;
/*     */   public int transferY;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  45 */     this.level = Integer.valueOf(rootElement.attributeValue("level")).intValue();
/*  46 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  47 */     this.moneyType = Integer.valueOf(rootElement.attributeValue("moneyType")).intValue();
/*  48 */     this.moneyNum = Integer.valueOf(rootElement.attributeValue("moneyNum")).intValue();
/*  49 */     this.itemId = Integer.valueOf(rootElement.attributeValue("itemId")).intValue();
/*  50 */     this.itemNum = Integer.valueOf(rootElement.attributeValue("itemNum")).intValue();
/*  51 */     this.mapId = Integer.valueOf(rootElement.attributeValue("mapId")).intValue();
/*  52 */     this.maxPetRoomLevel = Integer.valueOf(rootElement.attributeValue("maxPetRoomLevel")).intValue();
/*  53 */     this.maxBedRoomLevel = Integer.valueOf(rootElement.attributeValue("maxBedRoomLevel")).intValue();
/*  54 */     this.maxDrugRoomLevel = Integer.valueOf(rootElement.attributeValue("maxDrugRoomLevel")).intValue();
/*  55 */     this.maxKitchenLevel = Integer.valueOf(rootElement.attributeValue("maxKitchenLevel")).intValue();
/*  56 */     this.maxMaidRoomLevel = Integer.valueOf(rootElement.attributeValue("maxMaidRoomLevel")).intValue();
/*  57 */     this.dayCutCleanliness = Integer.valueOf(rootElement.attributeValue("dayCutCleanliness")).intValue();
/*  58 */     this.maxCleanliness = Integer.valueOf(rootElement.attributeValue("maxCleanliness")).intValue();
/*  59 */     this.maxFengShui = Integer.valueOf(rootElement.attributeValue("maxFengShui")).intValue();
/*  60 */     this.offSetX = Integer.valueOf(rootElement.attributeValue("offSetX")).intValue();
/*  61 */     this.offSetY = Integer.valueOf(rootElement.attributeValue("offSetY")).intValue();
/*  62 */     this.maidX = Integer.valueOf(rootElement.attributeValue("maidX")).intValue();
/*  63 */     this.maidY = Integer.valueOf(rootElement.attributeValue("maidY")).intValue();
/*  64 */     this.maidDir = Integer.valueOf(rootElement.attributeValue("maidDir")).intValue();
/*  65 */     this.point = Integer.valueOf(rootElement.attributeValue("point")).intValue();
/*  66 */     this.maxPeople = Integer.valueOf(rootElement.attributeValue("maxPeople")).intValue();
/*  67 */     this.transferX = Integer.valueOf(rootElement.attributeValue("transferX")).intValue();
/*  68 */     this.transferY = Integer.valueOf(rootElement.attributeValue("transferY")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  73 */     _os_.marshal(this.level);
/*  74 */     _os_.marshal(this.id);
/*  75 */     _os_.marshal(this.moneyType);
/*  76 */     _os_.marshal(this.moneyNum);
/*  77 */     _os_.marshal(this.itemId);
/*  78 */     _os_.marshal(this.itemNum);
/*  79 */     _os_.marshal(this.mapId);
/*  80 */     _os_.marshal(this.maxPetRoomLevel);
/*  81 */     _os_.marshal(this.maxBedRoomLevel);
/*  82 */     _os_.marshal(this.maxDrugRoomLevel);
/*  83 */     _os_.marshal(this.maxKitchenLevel);
/*  84 */     _os_.marshal(this.maxMaidRoomLevel);
/*  85 */     _os_.marshal(this.dayCutCleanliness);
/*  86 */     _os_.marshal(this.maxCleanliness);
/*  87 */     _os_.marshal(this.maxFengShui);
/*  88 */     _os_.marshal(this.offSetX);
/*  89 */     _os_.marshal(this.offSetY);
/*  90 */     _os_.marshal(this.maidX);
/*  91 */     _os_.marshal(this.maidY);
/*  92 */     _os_.marshal(this.maidDir);
/*  93 */     _os_.marshal(this.point);
/*  94 */     _os_.marshal(this.maxPeople);
/*  95 */     _os_.marshal(this.transferX);
/*  96 */     _os_.marshal(this.transferY);
/*  97 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 102 */     this.level = _os_.unmarshal_int();
/* 103 */     this.id = _os_.unmarshal_int();
/* 104 */     this.moneyType = _os_.unmarshal_int();
/* 105 */     this.moneyNum = _os_.unmarshal_int();
/* 106 */     this.itemId = _os_.unmarshal_int();
/* 107 */     this.itemNum = _os_.unmarshal_int();
/* 108 */     this.mapId = _os_.unmarshal_int();
/* 109 */     this.maxPetRoomLevel = _os_.unmarshal_int();
/* 110 */     this.maxBedRoomLevel = _os_.unmarshal_int();
/* 111 */     this.maxDrugRoomLevel = _os_.unmarshal_int();
/* 112 */     this.maxKitchenLevel = _os_.unmarshal_int();
/* 113 */     this.maxMaidRoomLevel = _os_.unmarshal_int();
/* 114 */     this.dayCutCleanliness = _os_.unmarshal_int();
/* 115 */     this.maxCleanliness = _os_.unmarshal_int();
/* 116 */     this.maxFengShui = _os_.unmarshal_int();
/* 117 */     this.offSetX = _os_.unmarshal_int();
/* 118 */     this.offSetY = _os_.unmarshal_int();
/* 119 */     this.maidX = _os_.unmarshal_int();
/* 120 */     this.maidY = _os_.unmarshal_int();
/* 121 */     this.maidDir = _os_.unmarshal_int();
/* 122 */     this.point = _os_.unmarshal_int();
/* 123 */     this.maxPeople = _os_.unmarshal_int();
/* 124 */     this.transferX = _os_.unmarshal_int();
/* 125 */     this.transferY = _os_.unmarshal_int();
/* 126 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 131 */     String path = dir + "mzm.gsp.homeland.confbean.SHomelandCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 135 */       all = new java.util.HashMap();
/* 136 */       SAXReader reader = new SAXReader();
/* 137 */       org.dom4j.Document doc = reader.read(new File(path));
/* 138 */       Element root = doc.getRootElement();
/* 139 */       List<?> nodeList = root.elements();
/* 140 */       int len = nodeList.size();
/* 141 */       for (int i = 0; i < len; i++)
/*     */       {
/* 143 */         Element elem = (Element)nodeList.get(i);
/* 144 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.homeland.confbean.SHomelandCfg"))
/*     */         {
/*     */ 
/* 147 */           SHomelandCfg obj = new SHomelandCfg();
/* 148 */           obj.loadFromXml(elem);
/* 149 */           if (all.put(Integer.valueOf(obj.level), obj) != null) {
/* 150 */             throw new RuntimeException("duplicate key : " + obj.level);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 155 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SHomelandCfg> all)
/*     */   {
/* 161 */     String path = dir + "mzm.gsp.homeland.confbean.SHomelandCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 165 */       SAXReader reader = new SAXReader();
/* 166 */       org.dom4j.Document doc = reader.read(new File(path));
/* 167 */       Element root = doc.getRootElement();
/* 168 */       List<?> nodeList = root.elements();
/* 169 */       int len = nodeList.size();
/* 170 */       for (int i = 0; i < len; i++)
/*     */       {
/* 172 */         Element elem = (Element)nodeList.get(i);
/* 173 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.homeland.confbean.SHomelandCfg"))
/*     */         {
/*     */ 
/* 176 */           SHomelandCfg obj = new SHomelandCfg();
/* 177 */           obj.loadFromXml(elem);
/* 178 */           if (all.put(Integer.valueOf(obj.level), obj) != null) {
/* 179 */             throw new RuntimeException("duplicate key : " + obj.level);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 184 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 190 */     all = new java.util.HashMap();
/*     */     
/* 192 */     String path = dir + "mzm.gsp.homeland.confbean.SHomelandCfg.bny";
/*     */     try
/*     */     {
/* 195 */       File file = new File(path);
/* 196 */       if (file.exists())
/*     */       {
/* 198 */         byte[] bytes = new byte['Ѐ'];
/* 199 */         FileInputStream fis = new FileInputStream(file);
/* 200 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 201 */         int len = 0;
/* 202 */         while ((len = fis.read(bytes)) > 0)
/* 203 */           baos.write(bytes, 0, len);
/* 204 */         fis.close();
/* 205 */         bytes = baos.toByteArray();
/* 206 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 207 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 209 */           _os_.unmarshal_int();
/* 210 */           _os_.unmarshal_int();
/* 211 */           _os_.unmarshal_int();
/*     */         }
/* 213 */         _os_.unmarshal_int();
/* 214 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 217 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 219 */           SHomelandCfg _v_ = new SHomelandCfg();
/* 220 */           _v_.unmarshal(_os_);
/* 221 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 222 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 227 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 232 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SHomelandCfg> all)
/*     */   {
/* 239 */     String path = dir + "mzm.gsp.homeland.confbean.SHomelandCfg.bny";
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
/* 254 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 256 */           _os_.unmarshal_int();
/* 257 */           _os_.unmarshal_int();
/* 258 */           _os_.unmarshal_int();
/*     */         }
/* 260 */         _os_.unmarshal_int();
/* 261 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 264 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 266 */           SHomelandCfg _v_ = new SHomelandCfg();
/* 267 */           _v_.unmarshal(_os_);
/* 268 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 269 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 274 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 279 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SHomelandCfg getOld(int key)
/*     */   {
/* 287 */     return (SHomelandCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SHomelandCfg get(int key)
/*     */   {
/* 292 */     return (SHomelandCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SHomelandCfg> getOldAll()
/*     */   {
/* 297 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SHomelandCfg> getAll()
/*     */   {
/* 302 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SHomelandCfg> newAll)
/*     */   {
/* 307 */     oldAll = all;
/* 308 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 313 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\confbean\SHomelandCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */