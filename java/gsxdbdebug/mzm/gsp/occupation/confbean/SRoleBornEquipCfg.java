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
/*     */ public class SRoleBornEquipCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SRoleBornEquipCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SRoleBornEquipCfg> all = null;
/*     */   
/*     */   public int id;
/*     */   public String templatename;
/*     */   public int occupationId;
/*     */   public int gender;
/*     */   public int weaponId;
/*     */   public int clothId;
/*     */   public int hatId;
/*     */   public int beltId;
/*     */   public int wristerId;
/*     */   public int shoeId;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  31 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  32 */     this.templatename = rootElement.attributeValue("templatename");
/*  33 */     this.occupationId = Integer.valueOf(rootElement.attributeValue("occupationId")).intValue();
/*  34 */     this.gender = Integer.valueOf(rootElement.attributeValue("gender")).intValue();
/*  35 */     this.weaponId = Integer.valueOf(rootElement.attributeValue("weaponId")).intValue();
/*  36 */     this.clothId = Integer.valueOf(rootElement.attributeValue("clothId")).intValue();
/*  37 */     this.hatId = Integer.valueOf(rootElement.attributeValue("hatId")).intValue();
/*  38 */     this.beltId = Integer.valueOf(rootElement.attributeValue("beltId")).intValue();
/*  39 */     this.wristerId = Integer.valueOf(rootElement.attributeValue("wristerId")).intValue();
/*  40 */     this.shoeId = Integer.valueOf(rootElement.attributeValue("shoeId")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  45 */     _os_.marshal(this.id);
/*  46 */     _os_.marshal(this.templatename, "UTF-8");
/*  47 */     _os_.marshal(this.occupationId);
/*  48 */     _os_.marshal(this.gender);
/*  49 */     _os_.marshal(this.weaponId);
/*  50 */     _os_.marshal(this.clothId);
/*  51 */     _os_.marshal(this.hatId);
/*  52 */     _os_.marshal(this.beltId);
/*  53 */     _os_.marshal(this.wristerId);
/*  54 */     _os_.marshal(this.shoeId);
/*  55 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  60 */     this.id = _os_.unmarshal_int();
/*  61 */     this.templatename = _os_.unmarshal_String("UTF-8");
/*  62 */     this.occupationId = _os_.unmarshal_int();
/*  63 */     this.gender = _os_.unmarshal_int();
/*  64 */     this.weaponId = _os_.unmarshal_int();
/*  65 */     this.clothId = _os_.unmarshal_int();
/*  66 */     this.hatId = _os_.unmarshal_int();
/*  67 */     this.beltId = _os_.unmarshal_int();
/*  68 */     this.wristerId = _os_.unmarshal_int();
/*  69 */     this.shoeId = _os_.unmarshal_int();
/*  70 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  75 */     String path = dir + "mzm.gsp.occupation.confbean.SRoleBornEquipCfg.xml";
/*     */     
/*     */     try
/*     */     {
/*  79 */       all = new java.util.HashMap();
/*  80 */       SAXReader reader = new SAXReader();
/*  81 */       org.dom4j.Document doc = reader.read(new File(path));
/*  82 */       Element root = doc.getRootElement();
/*  83 */       List<?> nodeList = root.elements();
/*  84 */       int len = nodeList.size();
/*  85 */       for (int i = 0; i < len; i++)
/*     */       {
/*  87 */         Element elem = (Element)nodeList.get(i);
/*  88 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.occupation.confbean.SRoleBornEquipCfg"))
/*     */         {
/*     */ 
/*  91 */           SRoleBornEquipCfg obj = new SRoleBornEquipCfg();
/*  92 */           obj.loadFromXml(elem);
/*  93 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/*  94 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/*  99 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SRoleBornEquipCfg> all)
/*     */   {
/* 105 */     String path = dir + "mzm.gsp.occupation.confbean.SRoleBornEquipCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 109 */       SAXReader reader = new SAXReader();
/* 110 */       org.dom4j.Document doc = reader.read(new File(path));
/* 111 */       Element root = doc.getRootElement();
/* 112 */       List<?> nodeList = root.elements();
/* 113 */       int len = nodeList.size();
/* 114 */       for (int i = 0; i < len; i++)
/*     */       {
/* 116 */         Element elem = (Element)nodeList.get(i);
/* 117 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.occupation.confbean.SRoleBornEquipCfg"))
/*     */         {
/*     */ 
/* 120 */           SRoleBornEquipCfg obj = new SRoleBornEquipCfg();
/* 121 */           obj.loadFromXml(elem);
/* 122 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 123 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 128 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 134 */     all = new java.util.HashMap();
/*     */     
/* 136 */     String path = dir + "mzm.gsp.occupation.confbean.SRoleBornEquipCfg.bny";
/*     */     try
/*     */     {
/* 139 */       File file = new File(path);
/* 140 */       if (file.exists())
/*     */       {
/* 142 */         byte[] bytes = new byte['Ѐ'];
/* 143 */         FileInputStream fis = new FileInputStream(file);
/* 144 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 145 */         int len = 0;
/* 146 */         while ((len = fis.read(bytes)) > 0)
/* 147 */           baos.write(bytes, 0, len);
/* 148 */         fis.close();
/* 149 */         bytes = baos.toByteArray();
/* 150 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 151 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 153 */           _os_.unmarshal_int();
/* 154 */           _os_.unmarshal_int();
/* 155 */           _os_.unmarshal_int();
/*     */         }
/* 157 */         _os_.unmarshal_int();
/* 158 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 161 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 163 */           SRoleBornEquipCfg _v_ = new SRoleBornEquipCfg();
/* 164 */           _v_.unmarshal(_os_);
/* 165 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 166 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 171 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 176 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SRoleBornEquipCfg> all)
/*     */   {
/* 183 */     String path = dir + "mzm.gsp.occupation.confbean.SRoleBornEquipCfg.bny";
/*     */     try
/*     */     {
/* 186 */       File file = new File(path);
/* 187 */       if (file.exists())
/*     */       {
/* 189 */         byte[] bytes = new byte['Ѐ'];
/* 190 */         FileInputStream fis = new FileInputStream(file);
/* 191 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 192 */         int len = 0;
/* 193 */         while ((len = fis.read(bytes)) > 0)
/* 194 */           baos.write(bytes, 0, len);
/* 195 */         fis.close();
/* 196 */         bytes = baos.toByteArray();
/* 197 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 198 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 200 */           _os_.unmarshal_int();
/* 201 */           _os_.unmarshal_int();
/* 202 */           _os_.unmarshal_int();
/*     */         }
/* 204 */         _os_.unmarshal_int();
/* 205 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 208 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 210 */           SRoleBornEquipCfg _v_ = new SRoleBornEquipCfg();
/* 211 */           _v_.unmarshal(_os_);
/* 212 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 213 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 218 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 223 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SRoleBornEquipCfg getOld(int key)
/*     */   {
/* 231 */     return (SRoleBornEquipCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SRoleBornEquipCfg get(int key)
/*     */   {
/* 236 */     return (SRoleBornEquipCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SRoleBornEquipCfg> getOldAll()
/*     */   {
/* 241 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SRoleBornEquipCfg> getAll()
/*     */   {
/* 246 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SRoleBornEquipCfg> newAll)
/*     */   {
/* 251 */     oldAll = all;
/* 252 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 257 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\occupation\confbean\SRoleBornEquipCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */