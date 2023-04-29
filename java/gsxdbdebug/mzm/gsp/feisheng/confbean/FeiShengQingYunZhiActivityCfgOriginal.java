/*     */ package mzm.gsp.feisheng.confbean;
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
/*     */ public class FeiShengQingYunZhiActivityCfgOriginal implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, FeiShengQingYunZhiActivityCfgOriginal> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, FeiShengQingYunZhiActivityCfgOriginal> all = null;
/*     */   
/*     */   public int id;
/*     */   public String desc;
/*     */   public int activity_cfg_id;
/*     */   public int moduleid;
/*     */   public int serverlevel;
/*     */   public int npc_id;
/*     */   public int npc_service_id;
/*     */   public int challenge_type;
/*     */   public int chapter_id;
/*     */   public int section_id;
/*     */   public int award_id;
/*     */   public int activity_map_cfg_id;
/*     */   public int effect_id;
/*     */   public int effect_coord_x;
/*     */   public int effect_coord_y;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  36 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  37 */     this.desc = rootElement.attributeValue("desc");
/*  38 */     this.activity_cfg_id = Integer.valueOf(rootElement.attributeValue("activity_cfg_id")).intValue();
/*  39 */     this.moduleid = Integer.valueOf(rootElement.attributeValue("moduleid")).intValue();
/*  40 */     this.serverlevel = Integer.valueOf(rootElement.attributeValue("serverlevel")).intValue();
/*  41 */     this.npc_id = Integer.valueOf(rootElement.attributeValue("npc_id")).intValue();
/*  42 */     this.npc_service_id = Integer.valueOf(rootElement.attributeValue("npc_service_id")).intValue();
/*  43 */     this.challenge_type = Integer.valueOf(rootElement.attributeValue("challenge_type")).intValue();
/*  44 */     this.chapter_id = Integer.valueOf(rootElement.attributeValue("chapter_id")).intValue();
/*  45 */     this.section_id = Integer.valueOf(rootElement.attributeValue("section_id")).intValue();
/*  46 */     this.award_id = Integer.valueOf(rootElement.attributeValue("award_id")).intValue();
/*  47 */     this.activity_map_cfg_id = Integer.valueOf(rootElement.attributeValue("activity_map_cfg_id")).intValue();
/*  48 */     this.effect_id = Integer.valueOf(rootElement.attributeValue("effect_id")).intValue();
/*  49 */     this.effect_coord_x = Integer.valueOf(rootElement.attributeValue("effect_coord_x")).intValue();
/*  50 */     this.effect_coord_y = Integer.valueOf(rootElement.attributeValue("effect_coord_y")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  55 */     _os_.marshal(this.id);
/*  56 */     _os_.marshal(this.desc, "UTF-8");
/*  57 */     _os_.marshal(this.activity_cfg_id);
/*  58 */     _os_.marshal(this.moduleid);
/*  59 */     _os_.marshal(this.serverlevel);
/*  60 */     _os_.marshal(this.npc_id);
/*  61 */     _os_.marshal(this.npc_service_id);
/*  62 */     _os_.marshal(this.challenge_type);
/*  63 */     _os_.marshal(this.chapter_id);
/*  64 */     _os_.marshal(this.section_id);
/*  65 */     _os_.marshal(this.award_id);
/*  66 */     _os_.marshal(this.activity_map_cfg_id);
/*  67 */     _os_.marshal(this.effect_id);
/*  68 */     _os_.marshal(this.effect_coord_x);
/*  69 */     _os_.marshal(this.effect_coord_y);
/*  70 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  75 */     this.id = _os_.unmarshal_int();
/*  76 */     this.desc = _os_.unmarshal_String("UTF-8");
/*  77 */     this.activity_cfg_id = _os_.unmarshal_int();
/*  78 */     this.moduleid = _os_.unmarshal_int();
/*  79 */     this.serverlevel = _os_.unmarshal_int();
/*  80 */     this.npc_id = _os_.unmarshal_int();
/*  81 */     this.npc_service_id = _os_.unmarshal_int();
/*  82 */     this.challenge_type = _os_.unmarshal_int();
/*  83 */     this.chapter_id = _os_.unmarshal_int();
/*  84 */     this.section_id = _os_.unmarshal_int();
/*  85 */     this.award_id = _os_.unmarshal_int();
/*  86 */     this.activity_map_cfg_id = _os_.unmarshal_int();
/*  87 */     this.effect_id = _os_.unmarshal_int();
/*  88 */     this.effect_coord_x = _os_.unmarshal_int();
/*  89 */     this.effect_coord_y = _os_.unmarshal_int();
/*  90 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  95 */     String path = dir + "mzm.gsp.feisheng.confbean.FeiShengQingYunZhiActivityCfgOriginal.xml";
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
/* 108 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.feisheng.confbean.FeiShengQingYunZhiActivityCfgOriginal"))
/*     */         {
/*     */ 
/* 111 */           FeiShengQingYunZhiActivityCfgOriginal obj = new FeiShengQingYunZhiActivityCfgOriginal();
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
/*     */   public static void reLoadXml(String dir, Map<Integer, FeiShengQingYunZhiActivityCfgOriginal> all)
/*     */   {
/* 125 */     String path = dir + "mzm.gsp.feisheng.confbean.FeiShengQingYunZhiActivityCfgOriginal.xml";
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
/* 137 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.feisheng.confbean.FeiShengQingYunZhiActivityCfgOriginal"))
/*     */         {
/*     */ 
/* 140 */           FeiShengQingYunZhiActivityCfgOriginal obj = new FeiShengQingYunZhiActivityCfgOriginal();
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
/* 156 */     String path = dir + "mzm.gsp.feisheng.confbean.FeiShengQingYunZhiActivityCfgOriginal.bny";
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
/* 183 */           FeiShengQingYunZhiActivityCfgOriginal _v_ = new FeiShengQingYunZhiActivityCfgOriginal();
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
/*     */   public static void reLoadBny(String dir, Map<Integer, FeiShengQingYunZhiActivityCfgOriginal> all)
/*     */   {
/* 203 */     String path = dir + "mzm.gsp.feisheng.confbean.FeiShengQingYunZhiActivityCfgOriginal.bny";
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
/* 230 */           FeiShengQingYunZhiActivityCfgOriginal _v_ = new FeiShengQingYunZhiActivityCfgOriginal();
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
/*     */   public static FeiShengQingYunZhiActivityCfgOriginal getOld(int key)
/*     */   {
/* 251 */     return (FeiShengQingYunZhiActivityCfgOriginal)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static FeiShengQingYunZhiActivityCfgOriginal get(int key)
/*     */   {
/* 256 */     return (FeiShengQingYunZhiActivityCfgOriginal)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, FeiShengQingYunZhiActivityCfgOriginal> getOldAll()
/*     */   {
/* 261 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, FeiShengQingYunZhiActivityCfgOriginal> getAll()
/*     */   {
/* 266 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, FeiShengQingYunZhiActivityCfgOriginal> newAll)
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


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\feisheng\confbean\FeiShengQingYunZhiActivityCfgOriginal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */