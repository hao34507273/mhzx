/*     */ package mzm.gsp.signaward.confbean;
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
/*     */ public class SGiftCode implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SGiftCode> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SGiftCode> all = null;
/*     */   
/*     */   public int id;
/*     */   public int cardtype;
/*     */   public int parenttype;
/*     */   public int awarditemid;
/*     */   public int maxnum;
/*     */   public int startyear;
/*     */   public int startmonth;
/*     */   public int startday;
/*     */   public int endyear;
/*     */   public int endmonth;
/*     */   public int endday;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  32 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  33 */     this.cardtype = Integer.valueOf(rootElement.attributeValue("cardtype")).intValue();
/*  34 */     this.parenttype = Integer.valueOf(rootElement.attributeValue("parenttype")).intValue();
/*  35 */     this.awarditemid = Integer.valueOf(rootElement.attributeValue("awarditemid")).intValue();
/*  36 */     this.maxnum = Integer.valueOf(rootElement.attributeValue("maxnum")).intValue();
/*  37 */     this.startyear = Integer.valueOf(rootElement.attributeValue("startyear")).intValue();
/*  38 */     this.startmonth = Integer.valueOf(rootElement.attributeValue("startmonth")).intValue();
/*  39 */     this.startday = Integer.valueOf(rootElement.attributeValue("startday")).intValue();
/*  40 */     this.endyear = Integer.valueOf(rootElement.attributeValue("endyear")).intValue();
/*  41 */     this.endmonth = Integer.valueOf(rootElement.attributeValue("endmonth")).intValue();
/*  42 */     this.endday = Integer.valueOf(rootElement.attributeValue("endday")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  47 */     _os_.marshal(this.id);
/*  48 */     _os_.marshal(this.cardtype);
/*  49 */     _os_.marshal(this.parenttype);
/*  50 */     _os_.marshal(this.awarditemid);
/*  51 */     _os_.marshal(this.maxnum);
/*  52 */     _os_.marshal(this.startyear);
/*  53 */     _os_.marshal(this.startmonth);
/*  54 */     _os_.marshal(this.startday);
/*  55 */     _os_.marshal(this.endyear);
/*  56 */     _os_.marshal(this.endmonth);
/*  57 */     _os_.marshal(this.endday);
/*  58 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  63 */     this.id = _os_.unmarshal_int();
/*  64 */     this.cardtype = _os_.unmarshal_int();
/*  65 */     this.parenttype = _os_.unmarshal_int();
/*  66 */     this.awarditemid = _os_.unmarshal_int();
/*  67 */     this.maxnum = _os_.unmarshal_int();
/*  68 */     this.startyear = _os_.unmarshal_int();
/*  69 */     this.startmonth = _os_.unmarshal_int();
/*  70 */     this.startday = _os_.unmarshal_int();
/*  71 */     this.endyear = _os_.unmarshal_int();
/*  72 */     this.endmonth = _os_.unmarshal_int();
/*  73 */     this.endday = _os_.unmarshal_int();
/*  74 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  79 */     String path = dir + "mzm.gsp.signaward.confbean.SGiftCode.xml";
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
/*  92 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.signaward.confbean.SGiftCode"))
/*     */         {
/*     */ 
/*  95 */           SGiftCode obj = new SGiftCode();
/*  96 */           obj.loadFromXml(elem);
/*  97 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/*  98 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 103 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SGiftCode> all)
/*     */   {
/* 109 */     String path = dir + "mzm.gsp.signaward.confbean.SGiftCode.xml";
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
/* 121 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.signaward.confbean.SGiftCode"))
/*     */         {
/*     */ 
/* 124 */           SGiftCode obj = new SGiftCode();
/* 125 */           obj.loadFromXml(elem);
/* 126 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 127 */             throw new RuntimeException("duplicate key : " + obj.id);
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
/* 140 */     String path = dir + "mzm.gsp.signaward.confbean.SGiftCode.bny";
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
/* 167 */           SGiftCode _v_ = new SGiftCode();
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
/*     */   public static void reLoadBny(String dir, Map<Integer, SGiftCode> all)
/*     */   {
/* 187 */     String path = dir + "mzm.gsp.signaward.confbean.SGiftCode.bny";
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
/* 214 */           SGiftCode _v_ = new SGiftCode();
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
/*     */   public static SGiftCode getOld(int key)
/*     */   {
/* 235 */     return (SGiftCode)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SGiftCode get(int key)
/*     */   {
/* 240 */     return (SGiftCode)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SGiftCode> getOldAll()
/*     */   {
/* 245 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SGiftCode> getAll()
/*     */   {
/* 250 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SGiftCode> newAll)
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


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\signaward\confbean\SGiftCode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */