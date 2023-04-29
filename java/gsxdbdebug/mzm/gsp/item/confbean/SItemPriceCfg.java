/*     */ package mzm.gsp.item.confbean;
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
/*     */ public class SItemPriceCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SItemPriceCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SItemPriceCfg> all = null;
/*     */   
/*     */   public int itemId;
/*     */   public int id;
/*     */   public int baiTanMinSilver;
/*     */   public int baiTanMaxSilver;
/*     */   public int baiTanSilverNum;
/*     */   public int shopSilverNum;
/*     */   public int disGoldNum;
/*     */   public int bangGongNum;
/*     */   public int xiayiNum;
/*     */   public int shimenNum;
/*     */   public int jingjiPointNum;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  32 */     this.itemId = Integer.valueOf(rootElement.attributeValue("itemId")).intValue();
/*  33 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  34 */     this.baiTanMinSilver = Integer.valueOf(rootElement.attributeValue("baiTanMinSilver")).intValue();
/*  35 */     this.baiTanMaxSilver = Integer.valueOf(rootElement.attributeValue("baiTanMaxSilver")).intValue();
/*  36 */     this.baiTanSilverNum = Integer.valueOf(rootElement.attributeValue("baiTanSilverNum")).intValue();
/*  37 */     this.shopSilverNum = Integer.valueOf(rootElement.attributeValue("shopSilverNum")).intValue();
/*  38 */     this.disGoldNum = Integer.valueOf(rootElement.attributeValue("disGoldNum")).intValue();
/*  39 */     this.bangGongNum = Integer.valueOf(rootElement.attributeValue("bangGongNum")).intValue();
/*  40 */     this.xiayiNum = Integer.valueOf(rootElement.attributeValue("xiayiNum")).intValue();
/*  41 */     this.shimenNum = Integer.valueOf(rootElement.attributeValue("shimenNum")).intValue();
/*  42 */     this.jingjiPointNum = Integer.valueOf(rootElement.attributeValue("jingjiPointNum")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  47 */     _os_.marshal(this.itemId);
/*  48 */     _os_.marshal(this.id);
/*  49 */     _os_.marshal(this.baiTanMinSilver);
/*  50 */     _os_.marshal(this.baiTanMaxSilver);
/*  51 */     _os_.marshal(this.baiTanSilverNum);
/*  52 */     _os_.marshal(this.shopSilverNum);
/*  53 */     _os_.marshal(this.disGoldNum);
/*  54 */     _os_.marshal(this.bangGongNum);
/*  55 */     _os_.marshal(this.xiayiNum);
/*  56 */     _os_.marshal(this.shimenNum);
/*  57 */     _os_.marshal(this.jingjiPointNum);
/*  58 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  63 */     this.itemId = _os_.unmarshal_int();
/*  64 */     this.id = _os_.unmarshal_int();
/*  65 */     this.baiTanMinSilver = _os_.unmarshal_int();
/*  66 */     this.baiTanMaxSilver = _os_.unmarshal_int();
/*  67 */     this.baiTanSilverNum = _os_.unmarshal_int();
/*  68 */     this.shopSilverNum = _os_.unmarshal_int();
/*  69 */     this.disGoldNum = _os_.unmarshal_int();
/*  70 */     this.bangGongNum = _os_.unmarshal_int();
/*  71 */     this.xiayiNum = _os_.unmarshal_int();
/*  72 */     this.shimenNum = _os_.unmarshal_int();
/*  73 */     this.jingjiPointNum = _os_.unmarshal_int();
/*  74 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  79 */     String path = dir + "mzm.gsp.item.confbean.SItemPriceCfg.xml";
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
/*  92 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.item.confbean.SItemPriceCfg"))
/*     */         {
/*     */ 
/*  95 */           SItemPriceCfg obj = new SItemPriceCfg();
/*  96 */           obj.loadFromXml(elem);
/*  97 */           if (all.put(Integer.valueOf(obj.itemId), obj) != null) {
/*  98 */             throw new RuntimeException("duplicate key : " + obj.itemId);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 103 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SItemPriceCfg> all)
/*     */   {
/* 109 */     String path = dir + "mzm.gsp.item.confbean.SItemPriceCfg.xml";
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
/* 121 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.item.confbean.SItemPriceCfg"))
/*     */         {
/*     */ 
/* 124 */           SItemPriceCfg obj = new SItemPriceCfg();
/* 125 */           obj.loadFromXml(elem);
/* 126 */           if (all.put(Integer.valueOf(obj.itemId), obj) != null) {
/* 127 */             throw new RuntimeException("duplicate key : " + obj.itemId);
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
/* 140 */     String path = dir + "mzm.gsp.item.confbean.SItemPriceCfg.bny";
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
/* 167 */           SItemPriceCfg _v_ = new SItemPriceCfg();
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
/*     */   public static void reLoadBny(String dir, Map<Integer, SItemPriceCfg> all)
/*     */   {
/* 187 */     String path = dir + "mzm.gsp.item.confbean.SItemPriceCfg.bny";
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
/* 214 */           SItemPriceCfg _v_ = new SItemPriceCfg();
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
/*     */   public static SItemPriceCfg getOld(int key)
/*     */   {
/* 235 */     return (SItemPriceCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SItemPriceCfg get(int key)
/*     */   {
/* 240 */     return (SItemPriceCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SItemPriceCfg> getOldAll()
/*     */   {
/* 245 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SItemPriceCfg> getAll()
/*     */   {
/* 250 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SItemPriceCfg> newAll)
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


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\confbean\SItemPriceCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */