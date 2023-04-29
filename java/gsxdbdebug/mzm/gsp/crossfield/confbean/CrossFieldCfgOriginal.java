/*     */ package mzm.gsp.crossfield.confbean;
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
/*     */ public class CrossFieldCfgOriginal implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, CrossFieldCfgOriginal> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, CrossFieldCfgOriginal> all = null;
/*     */   
/*     */   public int id;
/*     */   public String desc;
/*     */   public int activity_cfg_id;
/*     */   public int single_battle_cfg_id;
/*     */   public String field_name;
/*     */   public String field_desc;
/*     */   public int icon_id;
/*     */   public int moduleid;
/*     */   public int role_num;
/*     */   public int tips_id;
/*     */   public String img_name;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  32 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  33 */     this.desc = rootElement.attributeValue("desc");
/*  34 */     this.activity_cfg_id = Integer.valueOf(rootElement.attributeValue("activity_cfg_id")).intValue();
/*  35 */     this.single_battle_cfg_id = Integer.valueOf(rootElement.attributeValue("single_battle_cfg_id")).intValue();
/*  36 */     this.field_name = rootElement.attributeValue("field_name");
/*  37 */     this.field_desc = rootElement.attributeValue("field_desc");
/*  38 */     this.icon_id = Integer.valueOf(rootElement.attributeValue("icon_id")).intValue();
/*  39 */     this.moduleid = Integer.valueOf(rootElement.attributeValue("moduleid")).intValue();
/*  40 */     this.role_num = Integer.valueOf(rootElement.attributeValue("role_num")).intValue();
/*  41 */     this.tips_id = Integer.valueOf(rootElement.attributeValue("tips_id")).intValue();
/*  42 */     this.img_name = rootElement.attributeValue("img_name");
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  47 */     _os_.marshal(this.id);
/*  48 */     _os_.marshal(this.desc, "UTF-8");
/*  49 */     _os_.marshal(this.activity_cfg_id);
/*  50 */     _os_.marshal(this.single_battle_cfg_id);
/*  51 */     _os_.marshal(this.field_name, "UTF-8");
/*  52 */     _os_.marshal(this.field_desc, "UTF-8");
/*  53 */     _os_.marshal(this.icon_id);
/*  54 */     _os_.marshal(this.moduleid);
/*  55 */     _os_.marshal(this.role_num);
/*  56 */     _os_.marshal(this.tips_id);
/*  57 */     _os_.marshal(this.img_name, "UTF-8");
/*  58 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  63 */     this.id = _os_.unmarshal_int();
/*  64 */     this.desc = _os_.unmarshal_String("UTF-8");
/*  65 */     this.activity_cfg_id = _os_.unmarshal_int();
/*  66 */     this.single_battle_cfg_id = _os_.unmarshal_int();
/*  67 */     this.field_name = _os_.unmarshal_String("UTF-8");
/*  68 */     this.field_desc = _os_.unmarshal_String("UTF-8");
/*  69 */     this.icon_id = _os_.unmarshal_int();
/*  70 */     this.moduleid = _os_.unmarshal_int();
/*  71 */     this.role_num = _os_.unmarshal_int();
/*  72 */     this.tips_id = _os_.unmarshal_int();
/*  73 */     this.img_name = _os_.unmarshal_String("UTF-8");
/*  74 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  79 */     String path = dir + "mzm.gsp.crossfield.confbean.CrossFieldCfgOriginal.xml";
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
/*  92 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.crossfield.confbean.CrossFieldCfgOriginal"))
/*     */         {
/*     */ 
/*  95 */           CrossFieldCfgOriginal obj = new CrossFieldCfgOriginal();
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
/*     */   public static void reLoadXml(String dir, Map<Integer, CrossFieldCfgOriginal> all)
/*     */   {
/* 109 */     String path = dir + "mzm.gsp.crossfield.confbean.CrossFieldCfgOriginal.xml";
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
/* 121 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.crossfield.confbean.CrossFieldCfgOriginal"))
/*     */         {
/*     */ 
/* 124 */           CrossFieldCfgOriginal obj = new CrossFieldCfgOriginal();
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
/* 140 */     String path = dir + "mzm.gsp.crossfield.confbean.CrossFieldCfgOriginal.bny";
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
/* 167 */           CrossFieldCfgOriginal _v_ = new CrossFieldCfgOriginal();
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
/*     */   public static void reLoadBny(String dir, Map<Integer, CrossFieldCfgOriginal> all)
/*     */   {
/* 187 */     String path = dir + "mzm.gsp.crossfield.confbean.CrossFieldCfgOriginal.bny";
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
/* 214 */           CrossFieldCfgOriginal _v_ = new CrossFieldCfgOriginal();
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
/*     */   public static CrossFieldCfgOriginal getOld(int key)
/*     */   {
/* 235 */     return (CrossFieldCfgOriginal)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static CrossFieldCfgOriginal get(int key)
/*     */   {
/* 240 */     return (CrossFieldCfgOriginal)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, CrossFieldCfgOriginal> getOldAll()
/*     */   {
/* 245 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, CrossFieldCfgOriginal> getAll()
/*     */   {
/* 250 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, CrossFieldCfgOriginal> newAll)
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


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossfield\confbean\CrossFieldCfgOriginal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */