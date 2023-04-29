/*     */ package mzm.gsp.marriage.confbean;
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
/*     */ public class SMarriageParadeCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SMarriageParadeCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SMarriageParadeCfg> all = null;
/*     */   
/*     */   public int id;
/*     */   public int yuanBaoNum;
/*     */   public int awardid;
/*     */   public int rate;
/*     */   public int maxRoleNum;
/*     */   public int giveMoneyCount;
/*     */   public int benefitScacle;
/*     */   public int paradeSpeed;
/*     */   public int stopMapItemCount;
/*     */   public int stopSec;
/*     */   public int paradeMaxTimeSec;
/*     */   public int pathPointScale;
/*     */   public int rideIconid;
/*     */   public int paradeMapid;
/*     */   public int npcInMap;
/*     */   public int prepareSec;
/*     */   public int notifyInGang;
/*     */   public int notifyInWorld;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  39 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  40 */     this.yuanBaoNum = Integer.valueOf(rootElement.attributeValue("yuanBaoNum")).intValue();
/*  41 */     this.awardid = Integer.valueOf(rootElement.attributeValue("awardid")).intValue();
/*  42 */     this.rate = Integer.valueOf(rootElement.attributeValue("rate")).intValue();
/*  43 */     this.maxRoleNum = Integer.valueOf(rootElement.attributeValue("maxRoleNum")).intValue();
/*  44 */     this.giveMoneyCount = Integer.valueOf(rootElement.attributeValue("giveMoneyCount")).intValue();
/*  45 */     this.benefitScacle = Integer.valueOf(rootElement.attributeValue("benefitScacle")).intValue();
/*  46 */     this.paradeSpeed = Integer.valueOf(rootElement.attributeValue("paradeSpeed")).intValue();
/*  47 */     this.stopMapItemCount = Integer.valueOf(rootElement.attributeValue("stopMapItemCount")).intValue();
/*  48 */     this.stopSec = Integer.valueOf(rootElement.attributeValue("stopSec")).intValue();
/*  49 */     this.paradeMaxTimeSec = Integer.valueOf(rootElement.attributeValue("paradeMaxTimeSec")).intValue();
/*  50 */     this.pathPointScale = Integer.valueOf(rootElement.attributeValue("pathPointScale")).intValue();
/*  51 */     this.rideIconid = Integer.valueOf(rootElement.attributeValue("rideIconid")).intValue();
/*  52 */     this.paradeMapid = Integer.valueOf(rootElement.attributeValue("paradeMapid")).intValue();
/*  53 */     this.npcInMap = Integer.valueOf(rootElement.attributeValue("npcInMap")).intValue();
/*  54 */     this.prepareSec = Integer.valueOf(rootElement.attributeValue("prepareSec")).intValue();
/*  55 */     this.notifyInGang = Integer.valueOf(rootElement.attributeValue("notifyInGang")).intValue();
/*  56 */     this.notifyInWorld = Integer.valueOf(rootElement.attributeValue("notifyInWorld")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  61 */     _os_.marshal(this.id);
/*  62 */     _os_.marshal(this.yuanBaoNum);
/*  63 */     _os_.marshal(this.awardid);
/*  64 */     _os_.marshal(this.rate);
/*  65 */     _os_.marshal(this.maxRoleNum);
/*  66 */     _os_.marshal(this.giveMoneyCount);
/*  67 */     _os_.marshal(this.benefitScacle);
/*  68 */     _os_.marshal(this.paradeSpeed);
/*  69 */     _os_.marshal(this.stopMapItemCount);
/*  70 */     _os_.marshal(this.stopSec);
/*  71 */     _os_.marshal(this.paradeMaxTimeSec);
/*  72 */     _os_.marshal(this.pathPointScale);
/*  73 */     _os_.marshal(this.rideIconid);
/*  74 */     _os_.marshal(this.paradeMapid);
/*  75 */     _os_.marshal(this.npcInMap);
/*  76 */     _os_.marshal(this.prepareSec);
/*  77 */     _os_.marshal(this.notifyInGang);
/*  78 */     _os_.marshal(this.notifyInWorld);
/*  79 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  84 */     this.id = _os_.unmarshal_int();
/*  85 */     this.yuanBaoNum = _os_.unmarshal_int();
/*  86 */     this.awardid = _os_.unmarshal_int();
/*  87 */     this.rate = _os_.unmarshal_int();
/*  88 */     this.maxRoleNum = _os_.unmarshal_int();
/*  89 */     this.giveMoneyCount = _os_.unmarshal_int();
/*  90 */     this.benefitScacle = _os_.unmarshal_int();
/*  91 */     this.paradeSpeed = _os_.unmarshal_int();
/*  92 */     this.stopMapItemCount = _os_.unmarshal_int();
/*  93 */     this.stopSec = _os_.unmarshal_int();
/*  94 */     this.paradeMaxTimeSec = _os_.unmarshal_int();
/*  95 */     this.pathPointScale = _os_.unmarshal_int();
/*  96 */     this.rideIconid = _os_.unmarshal_int();
/*  97 */     this.paradeMapid = _os_.unmarshal_int();
/*  98 */     this.npcInMap = _os_.unmarshal_int();
/*  99 */     this.prepareSec = _os_.unmarshal_int();
/* 100 */     this.notifyInGang = _os_.unmarshal_int();
/* 101 */     this.notifyInWorld = _os_.unmarshal_int();
/* 102 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 107 */     String path = dir + "mzm.gsp.marriage.confbean.SMarriageParadeCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 111 */       all = new java.util.HashMap();
/* 112 */       SAXReader reader = new SAXReader();
/* 113 */       org.dom4j.Document doc = reader.read(new File(path));
/* 114 */       Element root = doc.getRootElement();
/* 115 */       List<?> nodeList = root.elements();
/* 116 */       int len = nodeList.size();
/* 117 */       for (int i = 0; i < len; i++)
/*     */       {
/* 119 */         Element elem = (Element)nodeList.get(i);
/* 120 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.marriage.confbean.SMarriageParadeCfg"))
/*     */         {
/*     */ 
/* 123 */           SMarriageParadeCfg obj = new SMarriageParadeCfg();
/* 124 */           obj.loadFromXml(elem);
/* 125 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 126 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 131 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SMarriageParadeCfg> all)
/*     */   {
/* 137 */     String path = dir + "mzm.gsp.marriage.confbean.SMarriageParadeCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 141 */       SAXReader reader = new SAXReader();
/* 142 */       org.dom4j.Document doc = reader.read(new File(path));
/* 143 */       Element root = doc.getRootElement();
/* 144 */       List<?> nodeList = root.elements();
/* 145 */       int len = nodeList.size();
/* 146 */       for (int i = 0; i < len; i++)
/*     */       {
/* 148 */         Element elem = (Element)nodeList.get(i);
/* 149 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.marriage.confbean.SMarriageParadeCfg"))
/*     */         {
/*     */ 
/* 152 */           SMarriageParadeCfg obj = new SMarriageParadeCfg();
/* 153 */           obj.loadFromXml(elem);
/* 154 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 155 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 160 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 166 */     all = new java.util.HashMap();
/*     */     
/* 168 */     String path = dir + "mzm.gsp.marriage.confbean.SMarriageParadeCfg.bny";
/*     */     try
/*     */     {
/* 171 */       File file = new File(path);
/* 172 */       if (file.exists())
/*     */       {
/* 174 */         byte[] bytes = new byte['Ѐ'];
/* 175 */         FileInputStream fis = new FileInputStream(file);
/* 176 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 177 */         int len = 0;
/* 178 */         while ((len = fis.read(bytes)) > 0)
/* 179 */           baos.write(bytes, 0, len);
/* 180 */         fis.close();
/* 181 */         bytes = baos.toByteArray();
/* 182 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 183 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 185 */           _os_.unmarshal_int();
/* 186 */           _os_.unmarshal_int();
/* 187 */           _os_.unmarshal_int();
/*     */         }
/* 189 */         _os_.unmarshal_int();
/* 190 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 193 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 195 */           SMarriageParadeCfg _v_ = new SMarriageParadeCfg();
/* 196 */           _v_.unmarshal(_os_);
/* 197 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 198 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 203 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 208 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SMarriageParadeCfg> all)
/*     */   {
/* 215 */     String path = dir + "mzm.gsp.marriage.confbean.SMarriageParadeCfg.bny";
/*     */     try
/*     */     {
/* 218 */       File file = new File(path);
/* 219 */       if (file.exists())
/*     */       {
/* 221 */         byte[] bytes = new byte['Ѐ'];
/* 222 */         FileInputStream fis = new FileInputStream(file);
/* 223 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 224 */         int len = 0;
/* 225 */         while ((len = fis.read(bytes)) > 0)
/* 226 */           baos.write(bytes, 0, len);
/* 227 */         fis.close();
/* 228 */         bytes = baos.toByteArray();
/* 229 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 230 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 232 */           _os_.unmarshal_int();
/* 233 */           _os_.unmarshal_int();
/* 234 */           _os_.unmarshal_int();
/*     */         }
/* 236 */         _os_.unmarshal_int();
/* 237 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 240 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 242 */           SMarriageParadeCfg _v_ = new SMarriageParadeCfg();
/* 243 */           _v_.unmarshal(_os_);
/* 244 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 245 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 250 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 255 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SMarriageParadeCfg getOld(int key)
/*     */   {
/* 263 */     return (SMarriageParadeCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SMarriageParadeCfg get(int key)
/*     */   {
/* 268 */     return (SMarriageParadeCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SMarriageParadeCfg> getOldAll()
/*     */   {
/* 273 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SMarriageParadeCfg> getAll()
/*     */   {
/* 278 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SMarriageParadeCfg> newAll)
/*     */   {
/* 283 */     oldAll = all;
/* 284 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 289 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\marriage\confbean\SMarriageParadeCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */