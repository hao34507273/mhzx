/*     */ package mzm.gsp.occupation.confbean;
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
/*     */ public class SRoleClothesColor implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SRoleClothesColor> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SRoleClothesColor> all = null;
/*     */   
/*     */   public int id;
/*     */   public String templatename;
/*     */   public int menpai;
/*     */   public int gender;
/*     */   public int part;
/*     */   public int color;
/*     */   public int a;
/*     */   public int r;
/*     */   public int g;
/*     */   public int b;
/*     */   public int itemid1;
/*     */   public int itemcount1;
/*     */   public int itemid2;
/*     */   public int itemcount2;
/*     */   public int fashionDressTypeId;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  36 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  37 */     this.templatename = rootElement.attributeValue("templatename");
/*  38 */     this.menpai = Integer.valueOf(rootElement.attributeValue("menpai")).intValue();
/*  39 */     this.gender = Integer.valueOf(rootElement.attributeValue("gender")).intValue();
/*  40 */     this.part = Integer.valueOf(rootElement.attributeValue("part")).intValue();
/*  41 */     this.color = Integer.valueOf(rootElement.attributeValue("color")).intValue();
/*  42 */     this.a = Integer.valueOf(rootElement.attributeValue("a")).intValue();
/*  43 */     this.r = Integer.valueOf(rootElement.attributeValue("r")).intValue();
/*  44 */     this.g = Integer.valueOf(rootElement.attributeValue("g")).intValue();
/*  45 */     this.b = Integer.valueOf(rootElement.attributeValue("b")).intValue();
/*  46 */     this.itemid1 = Integer.valueOf(rootElement.attributeValue("itemid1")).intValue();
/*  47 */     this.itemcount1 = Integer.valueOf(rootElement.attributeValue("itemcount1")).intValue();
/*  48 */     this.itemid2 = Integer.valueOf(rootElement.attributeValue("itemid2")).intValue();
/*  49 */     this.itemcount2 = Integer.valueOf(rootElement.attributeValue("itemcount2")).intValue();
/*  50 */     this.fashionDressTypeId = Integer.valueOf(rootElement.attributeValue("fashionDressTypeId")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  55 */     _os_.marshal(this.id);
/*  56 */     _os_.marshal(this.templatename, "UTF-8");
/*  57 */     _os_.marshal(this.menpai);
/*  58 */     _os_.marshal(this.gender);
/*  59 */     _os_.marshal(this.part);
/*  60 */     _os_.marshal(this.color);
/*  61 */     _os_.marshal(this.a);
/*  62 */     _os_.marshal(this.r);
/*  63 */     _os_.marshal(this.g);
/*  64 */     _os_.marshal(this.b);
/*  65 */     _os_.marshal(this.itemid1);
/*  66 */     _os_.marshal(this.itemcount1);
/*  67 */     _os_.marshal(this.itemid2);
/*  68 */     _os_.marshal(this.itemcount2);
/*  69 */     _os_.marshal(this.fashionDressTypeId);
/*  70 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  75 */     this.id = _os_.unmarshal_int();
/*  76 */     this.templatename = _os_.unmarshal_String("UTF-8");
/*  77 */     this.menpai = _os_.unmarshal_int();
/*  78 */     this.gender = _os_.unmarshal_int();
/*  79 */     this.part = _os_.unmarshal_int();
/*  80 */     this.color = _os_.unmarshal_int();
/*  81 */     this.a = _os_.unmarshal_int();
/*  82 */     this.r = _os_.unmarshal_int();
/*  83 */     this.g = _os_.unmarshal_int();
/*  84 */     this.b = _os_.unmarshal_int();
/*  85 */     this.itemid1 = _os_.unmarshal_int();
/*  86 */     this.itemcount1 = _os_.unmarshal_int();
/*  87 */     this.itemid2 = _os_.unmarshal_int();
/*  88 */     this.itemcount2 = _os_.unmarshal_int();
/*  89 */     this.fashionDressTypeId = _os_.unmarshal_int();
/*  90 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  95 */     String path = dir + "mzm.gsp.occupation.confbean.SRoleClothesColor.xml";
/*     */     
/*     */     try
/*     */     {
/*  99 */       all = new java.util.HashMap();
/* 100 */       SAXReader reader = new SAXReader();
/* 101 */       org.dom4j.Document doc = reader.read(new File(path));
/* 102 */       Element root = doc.getRootElement();
/* 103 */       List<?> nodeList = root.elements();
/* 104 */       int len = nodeList.size();
/* 105 */       for (int i = 0; i < len; i++)
/*     */       {
/* 107 */         Element elem = (Element)nodeList.get(i);
/* 108 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.occupation.confbean.SRoleClothesColor"))
/*     */         {
/*     */ 
/* 111 */           SRoleClothesColor obj = new SRoleClothesColor();
/* 112 */           obj.loadFromXml(elem);
/* 113 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 114 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 119 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SRoleClothesColor> all)
/*     */   {
/* 125 */     String path = dir + "mzm.gsp.occupation.confbean.SRoleClothesColor.xml";
/*     */     
/*     */     try
/*     */     {
/* 129 */       SAXReader reader = new SAXReader();
/* 130 */       org.dom4j.Document doc = reader.read(new File(path));
/* 131 */       Element root = doc.getRootElement();
/* 132 */       List<?> nodeList = root.elements();
/* 133 */       int len = nodeList.size();
/* 134 */       for (int i = 0; i < len; i++)
/*     */       {
/* 136 */         Element elem = (Element)nodeList.get(i);
/* 137 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.occupation.confbean.SRoleClothesColor"))
/*     */         {
/*     */ 
/* 140 */           SRoleClothesColor obj = new SRoleClothesColor();
/* 141 */           obj.loadFromXml(elem);
/* 142 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 143 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 148 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 154 */     all = new java.util.HashMap();
/*     */     
/* 156 */     String path = dir + "mzm.gsp.occupation.confbean.SRoleClothesColor.bny";
/*     */     try
/*     */     {
/* 159 */       File file = new File(path);
/* 160 */       if (file.exists())
/*     */       {
/* 162 */         byte[] bytes = new byte['Ѐ'];
/* 163 */         FileInputStream fis = new FileInputStream(file);
/* 164 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 165 */         int len = 0;
/* 166 */         while ((len = fis.read(bytes)) > 0)
/* 167 */           baos.write(bytes, 0, len);
/* 168 */         fis.close();
/* 169 */         bytes = baos.toByteArray();
/* 170 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 171 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 173 */           _os_.unmarshal_int();
/* 174 */           _os_.unmarshal_int();
/* 175 */           _os_.unmarshal_int();
/*     */         }
/* 177 */         _os_.unmarshal_int();
/* 178 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 181 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 183 */           SRoleClothesColor _v_ = new SRoleClothesColor();
/* 184 */           _v_.unmarshal(_os_);
/* 185 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 186 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 191 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 196 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SRoleClothesColor> all)
/*     */   {
/* 203 */     String path = dir + "mzm.gsp.occupation.confbean.SRoleClothesColor.bny";
/*     */     try
/*     */     {
/* 206 */       File file = new File(path);
/* 207 */       if (file.exists())
/*     */       {
/* 209 */         byte[] bytes = new byte['Ѐ'];
/* 210 */         FileInputStream fis = new FileInputStream(file);
/* 211 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 212 */         int len = 0;
/* 213 */         while ((len = fis.read(bytes)) > 0)
/* 214 */           baos.write(bytes, 0, len);
/* 215 */         fis.close();
/* 216 */         bytes = baos.toByteArray();
/* 217 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 218 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 220 */           _os_.unmarshal_int();
/* 221 */           _os_.unmarshal_int();
/* 222 */           _os_.unmarshal_int();
/*     */         }
/* 224 */         _os_.unmarshal_int();
/* 225 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 228 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 230 */           SRoleClothesColor _v_ = new SRoleClothesColor();
/* 231 */           _v_.unmarshal(_os_);
/* 232 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 233 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 238 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 243 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SRoleClothesColor getOld(int key)
/*     */   {
/* 251 */     return (SRoleClothesColor)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SRoleClothesColor get(int key)
/*     */   {
/* 256 */     return (SRoleClothesColor)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SRoleClothesColor> getOldAll()
/*     */   {
/* 261 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SRoleClothesColor> getAll()
/*     */   {
/* 266 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SRoleClothesColor> newAll)
/*     */   {
/* 271 */     oldAll = all;
/* 272 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 277 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\occupation\confbean\SRoleClothesColor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */