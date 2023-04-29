/*     */ package mzm.gsp.planttree.confbean;
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
/*     */ public class PlantTreeSpecialStateCfgOriginal implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, PlantTreeSpecialStateCfgOriginal> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, PlantTreeSpecialStateCfgOriginal> all = null;
/*     */   
/*     */   public int id;
/*     */   public String name;
/*     */   public String desc;
/*     */   public int activity_cfg_id;
/*     */   public int special_state_index;
/*     */   public int section_id;
/*     */   public int image_id;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  28 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  29 */     this.name = rootElement.attributeValue("name");
/*  30 */     this.desc = rootElement.attributeValue("desc");
/*  31 */     this.activity_cfg_id = Integer.valueOf(rootElement.attributeValue("activity_cfg_id")).intValue();
/*  32 */     this.special_state_index = Integer.valueOf(rootElement.attributeValue("special_state_index")).intValue();
/*  33 */     this.section_id = Integer.valueOf(rootElement.attributeValue("section_id")).intValue();
/*  34 */     this.image_id = Integer.valueOf(rootElement.attributeValue("image_id")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  39 */     _os_.marshal(this.id);
/*  40 */     _os_.marshal(this.name, "UTF-8");
/*  41 */     _os_.marshal(this.desc, "UTF-8");
/*  42 */     _os_.marshal(this.activity_cfg_id);
/*  43 */     _os_.marshal(this.special_state_index);
/*  44 */     _os_.marshal(this.section_id);
/*  45 */     _os_.marshal(this.image_id);
/*  46 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  51 */     this.id = _os_.unmarshal_int();
/*  52 */     this.name = _os_.unmarshal_String("UTF-8");
/*  53 */     this.desc = _os_.unmarshal_String("UTF-8");
/*  54 */     this.activity_cfg_id = _os_.unmarshal_int();
/*  55 */     this.special_state_index = _os_.unmarshal_int();
/*  56 */     this.section_id = _os_.unmarshal_int();
/*  57 */     this.image_id = _os_.unmarshal_int();
/*  58 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  63 */     String path = dir + "mzm.gsp.planttree.confbean.PlantTreeSpecialStateCfgOriginal.xml";
/*     */     
/*     */     try
/*     */     {
/*  67 */       all = new java.util.HashMap();
/*  68 */       SAXReader reader = new SAXReader();
/*  69 */       org.dom4j.Document doc = reader.read(new File(path));
/*  70 */       Element root = doc.getRootElement();
/*  71 */       List<?> nodeList = root.elements();
/*  72 */       int len = nodeList.size();
/*  73 */       for (int i = 0; i < len; i++)
/*     */       {
/*  75 */         Element elem = (Element)nodeList.get(i);
/*  76 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.planttree.confbean.PlantTreeSpecialStateCfgOriginal"))
/*     */         {
/*     */ 
/*  79 */           PlantTreeSpecialStateCfgOriginal obj = new PlantTreeSpecialStateCfgOriginal();
/*  80 */           obj.loadFromXml(elem);
/*  81 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/*  82 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/*  87 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, PlantTreeSpecialStateCfgOriginal> all)
/*     */   {
/*  93 */     String path = dir + "mzm.gsp.planttree.confbean.PlantTreeSpecialStateCfgOriginal.xml";
/*     */     
/*     */     try
/*     */     {
/*  97 */       SAXReader reader = new SAXReader();
/*  98 */       org.dom4j.Document doc = reader.read(new File(path));
/*  99 */       Element root = doc.getRootElement();
/* 100 */       List<?> nodeList = root.elements();
/* 101 */       int len = nodeList.size();
/* 102 */       for (int i = 0; i < len; i++)
/*     */       {
/* 104 */         Element elem = (Element)nodeList.get(i);
/* 105 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.planttree.confbean.PlantTreeSpecialStateCfgOriginal"))
/*     */         {
/*     */ 
/* 108 */           PlantTreeSpecialStateCfgOriginal obj = new PlantTreeSpecialStateCfgOriginal();
/* 109 */           obj.loadFromXml(elem);
/* 110 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 111 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 116 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 122 */     all = new java.util.HashMap();
/*     */     
/* 124 */     String path = dir + "mzm.gsp.planttree.confbean.PlantTreeSpecialStateCfgOriginal.bny";
/*     */     try
/*     */     {
/* 127 */       File file = new File(path);
/* 128 */       if (file.exists())
/*     */       {
/* 130 */         byte[] bytes = new byte['Ѐ'];
/* 131 */         FileInputStream fis = new FileInputStream(file);
/* 132 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 133 */         int len = 0;
/* 134 */         while ((len = fis.read(bytes)) > 0)
/* 135 */           baos.write(bytes, 0, len);
/* 136 */         fis.close();
/* 137 */         bytes = baos.toByteArray();
/* 138 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 139 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 141 */           _os_.unmarshal_int();
/* 142 */           _os_.unmarshal_int();
/* 143 */           _os_.unmarshal_int();
/*     */         }
/* 145 */         _os_.unmarshal_int();
/* 146 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 149 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 151 */           PlantTreeSpecialStateCfgOriginal _v_ = new PlantTreeSpecialStateCfgOriginal();
/* 152 */           _v_.unmarshal(_os_);
/* 153 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 154 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 159 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 164 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, PlantTreeSpecialStateCfgOriginal> all)
/*     */   {
/* 171 */     String path = dir + "mzm.gsp.planttree.confbean.PlantTreeSpecialStateCfgOriginal.bny";
/*     */     try
/*     */     {
/* 174 */       File file = new File(path);
/* 175 */       if (file.exists())
/*     */       {
/* 177 */         byte[] bytes = new byte['Ѐ'];
/* 178 */         FileInputStream fis = new FileInputStream(file);
/* 179 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 180 */         int len = 0;
/* 181 */         while ((len = fis.read(bytes)) > 0)
/* 182 */           baos.write(bytes, 0, len);
/* 183 */         fis.close();
/* 184 */         bytes = baos.toByteArray();
/* 185 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 186 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 188 */           _os_.unmarshal_int();
/* 189 */           _os_.unmarshal_int();
/* 190 */           _os_.unmarshal_int();
/*     */         }
/* 192 */         _os_.unmarshal_int();
/* 193 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 196 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 198 */           PlantTreeSpecialStateCfgOriginal _v_ = new PlantTreeSpecialStateCfgOriginal();
/* 199 */           _v_.unmarshal(_os_);
/* 200 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 201 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 206 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 211 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static PlantTreeSpecialStateCfgOriginal getOld(int key)
/*     */   {
/* 219 */     return (PlantTreeSpecialStateCfgOriginal)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static PlantTreeSpecialStateCfgOriginal get(int key)
/*     */   {
/* 224 */     return (PlantTreeSpecialStateCfgOriginal)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, PlantTreeSpecialStateCfgOriginal> getOldAll()
/*     */   {
/* 229 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, PlantTreeSpecialStateCfgOriginal> getAll()
/*     */   {
/* 234 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, PlantTreeSpecialStateCfgOriginal> newAll)
/*     */   {
/* 239 */     oldAll = all;
/* 240 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 245 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\planttree\confbean\PlantTreeSpecialStateCfgOriginal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */