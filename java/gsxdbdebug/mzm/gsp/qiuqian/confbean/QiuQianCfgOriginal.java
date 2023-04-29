/*     */ package mzm.gsp.qiuqian.confbean;
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
/*     */ public class QiuQianCfgOriginal implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, QiuQianCfgOriginal> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, QiuQianCfgOriginal> all = null;
/*     */   
/*     */   public int id;
/*     */   public String name;
/*     */   public String desc;
/*     */   public int qiuqian_id;
/*     */   public int moduleid;
/*     */   public int anim_duration;
/*     */   public int sort_id;
/*     */   public String qianwen_title;
/*     */   public String qianwen_content_1;
/*     */   public String qianwen_content_2;
/*     */   public String qianwen_content_3;
/*     */   public String qianwen_content_4;
/*     */   public int point;
/*     */   public int effect_id;
/*     */   public int probability;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  36 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  37 */     this.name = rootElement.attributeValue("name");
/*  38 */     this.desc = rootElement.attributeValue("desc");
/*  39 */     this.qiuqian_id = Integer.valueOf(rootElement.attributeValue("qiuqian_id")).intValue();
/*  40 */     this.moduleid = Integer.valueOf(rootElement.attributeValue("moduleid")).intValue();
/*  41 */     this.anim_duration = Integer.valueOf(rootElement.attributeValue("anim_duration")).intValue();
/*  42 */     this.sort_id = Integer.valueOf(rootElement.attributeValue("sort_id")).intValue();
/*  43 */     this.qianwen_title = rootElement.attributeValue("qianwen_title");
/*  44 */     this.qianwen_content_1 = rootElement.attributeValue("qianwen_content_1");
/*  45 */     this.qianwen_content_2 = rootElement.attributeValue("qianwen_content_2");
/*  46 */     this.qianwen_content_3 = rootElement.attributeValue("qianwen_content_3");
/*  47 */     this.qianwen_content_4 = rootElement.attributeValue("qianwen_content_4");
/*  48 */     this.point = Integer.valueOf(rootElement.attributeValue("point")).intValue();
/*  49 */     this.effect_id = Integer.valueOf(rootElement.attributeValue("effect_id")).intValue();
/*  50 */     this.probability = Integer.valueOf(rootElement.attributeValue("probability")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  55 */     _os_.marshal(this.id);
/*  56 */     _os_.marshal(this.name, "UTF-8");
/*  57 */     _os_.marshal(this.desc, "UTF-8");
/*  58 */     _os_.marshal(this.qiuqian_id);
/*  59 */     _os_.marshal(this.moduleid);
/*  60 */     _os_.marshal(this.anim_duration);
/*  61 */     _os_.marshal(this.sort_id);
/*  62 */     _os_.marshal(this.qianwen_title, "UTF-8");
/*  63 */     _os_.marshal(this.qianwen_content_1, "UTF-8");
/*  64 */     _os_.marshal(this.qianwen_content_2, "UTF-8");
/*  65 */     _os_.marshal(this.qianwen_content_3, "UTF-8");
/*  66 */     _os_.marshal(this.qianwen_content_4, "UTF-8");
/*  67 */     _os_.marshal(this.point);
/*  68 */     _os_.marshal(this.effect_id);
/*  69 */     _os_.marshal(this.probability);
/*  70 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  75 */     this.id = _os_.unmarshal_int();
/*  76 */     this.name = _os_.unmarshal_String("UTF-8");
/*  77 */     this.desc = _os_.unmarshal_String("UTF-8");
/*  78 */     this.qiuqian_id = _os_.unmarshal_int();
/*  79 */     this.moduleid = _os_.unmarshal_int();
/*  80 */     this.anim_duration = _os_.unmarshal_int();
/*  81 */     this.sort_id = _os_.unmarshal_int();
/*  82 */     this.qianwen_title = _os_.unmarshal_String("UTF-8");
/*  83 */     this.qianwen_content_1 = _os_.unmarshal_String("UTF-8");
/*  84 */     this.qianwen_content_2 = _os_.unmarshal_String("UTF-8");
/*  85 */     this.qianwen_content_3 = _os_.unmarshal_String("UTF-8");
/*  86 */     this.qianwen_content_4 = _os_.unmarshal_String("UTF-8");
/*  87 */     this.point = _os_.unmarshal_int();
/*  88 */     this.effect_id = _os_.unmarshal_int();
/*  89 */     this.probability = _os_.unmarshal_int();
/*  90 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  95 */     String path = dir + "mzm.gsp.qiuqian.confbean.QiuQianCfgOriginal.xml";
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
/* 108 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.qiuqian.confbean.QiuQianCfgOriginal"))
/*     */         {
/*     */ 
/* 111 */           QiuQianCfgOriginal obj = new QiuQianCfgOriginal();
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
/*     */   public static void reLoadXml(String dir, Map<Integer, QiuQianCfgOriginal> all)
/*     */   {
/* 125 */     String path = dir + "mzm.gsp.qiuqian.confbean.QiuQianCfgOriginal.xml";
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
/* 137 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.qiuqian.confbean.QiuQianCfgOriginal"))
/*     */         {
/*     */ 
/* 140 */           QiuQianCfgOriginal obj = new QiuQianCfgOriginal();
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
/* 156 */     String path = dir + "mzm.gsp.qiuqian.confbean.QiuQianCfgOriginal.bny";
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
/* 183 */           QiuQianCfgOriginal _v_ = new QiuQianCfgOriginal();
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
/*     */   public static void reLoadBny(String dir, Map<Integer, QiuQianCfgOriginal> all)
/*     */   {
/* 203 */     String path = dir + "mzm.gsp.qiuqian.confbean.QiuQianCfgOriginal.bny";
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
/* 230 */           QiuQianCfgOriginal _v_ = new QiuQianCfgOriginal();
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
/*     */   public static QiuQianCfgOriginal getOld(int key)
/*     */   {
/* 251 */     return (QiuQianCfgOriginal)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static QiuQianCfgOriginal get(int key)
/*     */   {
/* 256 */     return (QiuQianCfgOriginal)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, QiuQianCfgOriginal> getOldAll()
/*     */   {
/* 261 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, QiuQianCfgOriginal> getAll()
/*     */   {
/* 266 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, QiuQianCfgOriginal> newAll)
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


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qiuqian\confbean\QiuQianCfgOriginal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */