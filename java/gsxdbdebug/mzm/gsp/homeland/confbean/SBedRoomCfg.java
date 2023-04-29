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
/*     */ public class SBedRoomCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SBedRoomCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SBedRoomCfg> all = null;
/*     */   
/*     */   public int level;
/*     */   public int id;
/*     */   public int moneyType;
/*     */   public int moneyNum;
/*     */   public int dayCutCleanliness;
/*     */   public int dayRestoreVigorCount;
/*     */   public int addVigorNum;
/*     */   public int dayRestoreSatiationCount;
/*     */   public int addSatiationNum;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  30 */     this.level = Integer.valueOf(rootElement.attributeValue("level")).intValue();
/*  31 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  32 */     this.moneyType = Integer.valueOf(rootElement.attributeValue("moneyType")).intValue();
/*  33 */     this.moneyNum = Integer.valueOf(rootElement.attributeValue("moneyNum")).intValue();
/*  34 */     this.dayCutCleanliness = Integer.valueOf(rootElement.attributeValue("dayCutCleanliness")).intValue();
/*  35 */     this.dayRestoreVigorCount = Integer.valueOf(rootElement.attributeValue("dayRestoreVigorCount")).intValue();
/*  36 */     this.addVigorNum = Integer.valueOf(rootElement.attributeValue("addVigorNum")).intValue();
/*  37 */     this.dayRestoreSatiationCount = Integer.valueOf(rootElement.attributeValue("dayRestoreSatiationCount")).intValue();
/*  38 */     this.addSatiationNum = Integer.valueOf(rootElement.attributeValue("addSatiationNum")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  43 */     _os_.marshal(this.level);
/*  44 */     _os_.marshal(this.id);
/*  45 */     _os_.marshal(this.moneyType);
/*  46 */     _os_.marshal(this.moneyNum);
/*  47 */     _os_.marshal(this.dayCutCleanliness);
/*  48 */     _os_.marshal(this.dayRestoreVigorCount);
/*  49 */     _os_.marshal(this.addVigorNum);
/*  50 */     _os_.marshal(this.dayRestoreSatiationCount);
/*  51 */     _os_.marshal(this.addSatiationNum);
/*  52 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  57 */     this.level = _os_.unmarshal_int();
/*  58 */     this.id = _os_.unmarshal_int();
/*  59 */     this.moneyType = _os_.unmarshal_int();
/*  60 */     this.moneyNum = _os_.unmarshal_int();
/*  61 */     this.dayCutCleanliness = _os_.unmarshal_int();
/*  62 */     this.dayRestoreVigorCount = _os_.unmarshal_int();
/*  63 */     this.addVigorNum = _os_.unmarshal_int();
/*  64 */     this.dayRestoreSatiationCount = _os_.unmarshal_int();
/*  65 */     this.addSatiationNum = _os_.unmarshal_int();
/*  66 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  71 */     String path = dir + "mzm.gsp.homeland.confbean.SBedRoomCfg.xml";
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
/*  84 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.homeland.confbean.SBedRoomCfg"))
/*     */         {
/*     */ 
/*  87 */           SBedRoomCfg obj = new SBedRoomCfg();
/*  88 */           obj.loadFromXml(elem);
/*  89 */           if (all.put(Integer.valueOf(obj.level), obj) != null) {
/*  90 */             throw new RuntimeException("duplicate key : " + obj.level);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/*  95 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SBedRoomCfg> all)
/*     */   {
/* 101 */     String path = dir + "mzm.gsp.homeland.confbean.SBedRoomCfg.xml";
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
/* 113 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.homeland.confbean.SBedRoomCfg"))
/*     */         {
/*     */ 
/* 116 */           SBedRoomCfg obj = new SBedRoomCfg();
/* 117 */           obj.loadFromXml(elem);
/* 118 */           if (all.put(Integer.valueOf(obj.level), obj) != null) {
/* 119 */             throw new RuntimeException("duplicate key : " + obj.level);
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
/* 132 */     String path = dir + "mzm.gsp.homeland.confbean.SBedRoomCfg.bny";
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
/* 159 */           SBedRoomCfg _v_ = new SBedRoomCfg();
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
/*     */   public static void reLoadBny(String dir, Map<Integer, SBedRoomCfg> all)
/*     */   {
/* 179 */     String path = dir + "mzm.gsp.homeland.confbean.SBedRoomCfg.bny";
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
/* 206 */           SBedRoomCfg _v_ = new SBedRoomCfg();
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
/*     */   public static SBedRoomCfg getOld(int key)
/*     */   {
/* 227 */     return (SBedRoomCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SBedRoomCfg get(int key)
/*     */   {
/* 232 */     return (SBedRoomCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SBedRoomCfg> getOldAll()
/*     */   {
/* 237 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SBedRoomCfg> getAll()
/*     */   {
/* 242 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SBedRoomCfg> newAll)
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


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\confbean\SBedRoomCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */