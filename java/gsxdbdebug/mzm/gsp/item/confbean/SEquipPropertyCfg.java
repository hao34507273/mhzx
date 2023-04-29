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
/*     */ public class SEquipPropertyCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SEquipPropertyCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SEquipPropertyCfg> all = null;
/*     */   
/*     */   public int id;
/*     */   public String templatename;
/*     */   public int equipmentLevel;
/*     */   public int menpai;
/*     */   public int equipmentType;
/*     */   public int attrAvaluemin;
/*     */   public int attrAvaluemax;
/*     */   public int attrBvaluemin;
/*     */   public int attrBvaluemax;
/*     */   public int whitePointMax;
/*     */   public int greenePointMax;
/*     */   public int bluePointMax;
/*     */   public int purplePointMax;
/*     */   public int propertydesc;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  35 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  36 */     this.templatename = rootElement.attributeValue("templatename");
/*  37 */     this.equipmentLevel = Integer.valueOf(rootElement.attributeValue("equipmentLevel")).intValue();
/*  38 */     this.menpai = Integer.valueOf(rootElement.attributeValue("menpai")).intValue();
/*  39 */     this.equipmentType = Integer.valueOf(rootElement.attributeValue("equipmentType")).intValue();
/*  40 */     this.attrAvaluemin = Integer.valueOf(rootElement.attributeValue("attrAvaluemin")).intValue();
/*  41 */     this.attrAvaluemax = Integer.valueOf(rootElement.attributeValue("attrAvaluemax")).intValue();
/*  42 */     this.attrBvaluemin = Integer.valueOf(rootElement.attributeValue("attrBvaluemin")).intValue();
/*  43 */     this.attrBvaluemax = Integer.valueOf(rootElement.attributeValue("attrBvaluemax")).intValue();
/*  44 */     this.whitePointMax = Integer.valueOf(rootElement.attributeValue("whitePointMax")).intValue();
/*  45 */     this.greenePointMax = Integer.valueOf(rootElement.attributeValue("greenePointMax")).intValue();
/*  46 */     this.bluePointMax = Integer.valueOf(rootElement.attributeValue("bluePointMax")).intValue();
/*  47 */     this.purplePointMax = Integer.valueOf(rootElement.attributeValue("purplePointMax")).intValue();
/*  48 */     this.propertydesc = Integer.valueOf(rootElement.attributeValue("propertydesc")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  53 */     _os_.marshal(this.id);
/*  54 */     _os_.marshal(this.templatename, "UTF-8");
/*  55 */     _os_.marshal(this.equipmentLevel);
/*  56 */     _os_.marshal(this.menpai);
/*  57 */     _os_.marshal(this.equipmentType);
/*  58 */     _os_.marshal(this.attrAvaluemin);
/*  59 */     _os_.marshal(this.attrAvaluemax);
/*  60 */     _os_.marshal(this.attrBvaluemin);
/*  61 */     _os_.marshal(this.attrBvaluemax);
/*  62 */     _os_.marshal(this.whitePointMax);
/*  63 */     _os_.marshal(this.greenePointMax);
/*  64 */     _os_.marshal(this.bluePointMax);
/*  65 */     _os_.marshal(this.purplePointMax);
/*  66 */     _os_.marshal(this.propertydesc);
/*  67 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  72 */     this.id = _os_.unmarshal_int();
/*  73 */     this.templatename = _os_.unmarshal_String("UTF-8");
/*  74 */     this.equipmentLevel = _os_.unmarshal_int();
/*  75 */     this.menpai = _os_.unmarshal_int();
/*  76 */     this.equipmentType = _os_.unmarshal_int();
/*  77 */     this.attrAvaluemin = _os_.unmarshal_int();
/*  78 */     this.attrAvaluemax = _os_.unmarshal_int();
/*  79 */     this.attrBvaluemin = _os_.unmarshal_int();
/*  80 */     this.attrBvaluemax = _os_.unmarshal_int();
/*  81 */     this.whitePointMax = _os_.unmarshal_int();
/*  82 */     this.greenePointMax = _os_.unmarshal_int();
/*  83 */     this.bluePointMax = _os_.unmarshal_int();
/*  84 */     this.purplePointMax = _os_.unmarshal_int();
/*  85 */     this.propertydesc = _os_.unmarshal_int();
/*  86 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  91 */     String path = dir + "mzm.gsp.item.confbean.SEquipPropertyCfg.xml";
/*     */     
/*     */     try
/*     */     {
/*  95 */       all = new java.util.HashMap();
/*  96 */       SAXReader reader = new SAXReader();
/*  97 */       org.dom4j.Document doc = reader.read(new File(path));
/*  98 */       Element root = doc.getRootElement();
/*  99 */       List<?> nodeList = root.elements();
/* 100 */       int len = nodeList.size();
/* 101 */       for (int i = 0; i < len; i++)
/*     */       {
/* 103 */         Element elem = (Element)nodeList.get(i);
/* 104 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.item.confbean.SEquipPropertyCfg"))
/*     */         {
/*     */ 
/* 107 */           SEquipPropertyCfg obj = new SEquipPropertyCfg();
/* 108 */           obj.loadFromXml(elem);
/* 109 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 110 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 115 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SEquipPropertyCfg> all)
/*     */   {
/* 121 */     String path = dir + "mzm.gsp.item.confbean.SEquipPropertyCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 125 */       SAXReader reader = new SAXReader();
/* 126 */       org.dom4j.Document doc = reader.read(new File(path));
/* 127 */       Element root = doc.getRootElement();
/* 128 */       List<?> nodeList = root.elements();
/* 129 */       int len = nodeList.size();
/* 130 */       for (int i = 0; i < len; i++)
/*     */       {
/* 132 */         Element elem = (Element)nodeList.get(i);
/* 133 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.item.confbean.SEquipPropertyCfg"))
/*     */         {
/*     */ 
/* 136 */           SEquipPropertyCfg obj = new SEquipPropertyCfg();
/* 137 */           obj.loadFromXml(elem);
/* 138 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 139 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 144 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 150 */     all = new java.util.HashMap();
/*     */     
/* 152 */     String path = dir + "mzm.gsp.item.confbean.SEquipPropertyCfg.bny";
/*     */     try
/*     */     {
/* 155 */       File file = new File(path);
/* 156 */       if (file.exists())
/*     */       {
/* 158 */         byte[] bytes = new byte['Ѐ'];
/* 159 */         FileInputStream fis = new FileInputStream(file);
/* 160 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 161 */         int len = 0;
/* 162 */         while ((len = fis.read(bytes)) > 0)
/* 163 */           baos.write(bytes, 0, len);
/* 164 */         fis.close();
/* 165 */         bytes = baos.toByteArray();
/* 166 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 167 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 169 */           _os_.unmarshal_int();
/* 170 */           _os_.unmarshal_int();
/* 171 */           _os_.unmarshal_int();
/*     */         }
/* 173 */         _os_.unmarshal_int();
/* 174 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 177 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 179 */           SEquipPropertyCfg _v_ = new SEquipPropertyCfg();
/* 180 */           _v_.unmarshal(_os_);
/* 181 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 182 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 187 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 192 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SEquipPropertyCfg> all)
/*     */   {
/* 199 */     String path = dir + "mzm.gsp.item.confbean.SEquipPropertyCfg.bny";
/*     */     try
/*     */     {
/* 202 */       File file = new File(path);
/* 203 */       if (file.exists())
/*     */       {
/* 205 */         byte[] bytes = new byte['Ѐ'];
/* 206 */         FileInputStream fis = new FileInputStream(file);
/* 207 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 208 */         int len = 0;
/* 209 */         while ((len = fis.read(bytes)) > 0)
/* 210 */           baos.write(bytes, 0, len);
/* 211 */         fis.close();
/* 212 */         bytes = baos.toByteArray();
/* 213 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 214 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 216 */           _os_.unmarshal_int();
/* 217 */           _os_.unmarshal_int();
/* 218 */           _os_.unmarshal_int();
/*     */         }
/* 220 */         _os_.unmarshal_int();
/* 221 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 224 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 226 */           SEquipPropertyCfg _v_ = new SEquipPropertyCfg();
/* 227 */           _v_.unmarshal(_os_);
/* 228 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 229 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 234 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 239 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SEquipPropertyCfg getOld(int key)
/*     */   {
/* 247 */     return (SEquipPropertyCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SEquipPropertyCfg get(int key)
/*     */   {
/* 252 */     return (SEquipPropertyCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SEquipPropertyCfg> getOldAll()
/*     */   {
/* 257 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SEquipPropertyCfg> getAll()
/*     */   {
/* 262 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SEquipPropertyCfg> newAll)
/*     */   {
/* 267 */     oldAll = all;
/* 268 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 273 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\confbean\SEquipPropertyCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */