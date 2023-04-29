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
/*     */ public class FeiShengDevelopItemActivityCfgOriginal implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, FeiShengDevelopItemActivityCfgOriginal> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, FeiShengDevelopItemActivityCfgOriginal> all = null;
/*     */   
/*     */   public int id;
/*     */   public String desc;
/*     */   public int activity_cfg_id;
/*     */   public int moduleid;
/*     */   public int serverlevel;
/*     */   public int npc_id;
/*     */   public int get_item_npc_service_id;
/*     */   public int commit_item_npc_service_id;
/*     */   public int item_cfg_id;
/*     */   public int extra_type;
/*     */   public int extra_value;
/*     */   public int add_extra_value_per_operation;
/*     */   public int award_id;
/*     */   public int activity_map_cfg_id;
/*     */   public int effect_id;
/*     */   public int effect_coord_x;
/*     */   public int effect_coord_y;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  38 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  39 */     this.desc = rootElement.attributeValue("desc");
/*  40 */     this.activity_cfg_id = Integer.valueOf(rootElement.attributeValue("activity_cfg_id")).intValue();
/*  41 */     this.moduleid = Integer.valueOf(rootElement.attributeValue("moduleid")).intValue();
/*  42 */     this.serverlevel = Integer.valueOf(rootElement.attributeValue("serverlevel")).intValue();
/*  43 */     this.npc_id = Integer.valueOf(rootElement.attributeValue("npc_id")).intValue();
/*  44 */     this.get_item_npc_service_id = Integer.valueOf(rootElement.attributeValue("get_item_npc_service_id")).intValue();
/*  45 */     this.commit_item_npc_service_id = Integer.valueOf(rootElement.attributeValue("commit_item_npc_service_id")).intValue();
/*  46 */     this.item_cfg_id = Integer.valueOf(rootElement.attributeValue("item_cfg_id")).intValue();
/*  47 */     this.extra_type = Integer.valueOf(rootElement.attributeValue("extra_type")).intValue();
/*  48 */     this.extra_value = Integer.valueOf(rootElement.attributeValue("extra_value")).intValue();
/*  49 */     this.add_extra_value_per_operation = Integer.valueOf(rootElement.attributeValue("add_extra_value_per_operation")).intValue();
/*  50 */     this.award_id = Integer.valueOf(rootElement.attributeValue("award_id")).intValue();
/*  51 */     this.activity_map_cfg_id = Integer.valueOf(rootElement.attributeValue("activity_map_cfg_id")).intValue();
/*  52 */     this.effect_id = Integer.valueOf(rootElement.attributeValue("effect_id")).intValue();
/*  53 */     this.effect_coord_x = Integer.valueOf(rootElement.attributeValue("effect_coord_x")).intValue();
/*  54 */     this.effect_coord_y = Integer.valueOf(rootElement.attributeValue("effect_coord_y")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  59 */     _os_.marshal(this.id);
/*  60 */     _os_.marshal(this.desc, "UTF-8");
/*  61 */     _os_.marshal(this.activity_cfg_id);
/*  62 */     _os_.marshal(this.moduleid);
/*  63 */     _os_.marshal(this.serverlevel);
/*  64 */     _os_.marshal(this.npc_id);
/*  65 */     _os_.marshal(this.get_item_npc_service_id);
/*  66 */     _os_.marshal(this.commit_item_npc_service_id);
/*  67 */     _os_.marshal(this.item_cfg_id);
/*  68 */     _os_.marshal(this.extra_type);
/*  69 */     _os_.marshal(this.extra_value);
/*  70 */     _os_.marshal(this.add_extra_value_per_operation);
/*  71 */     _os_.marshal(this.award_id);
/*  72 */     _os_.marshal(this.activity_map_cfg_id);
/*  73 */     _os_.marshal(this.effect_id);
/*  74 */     _os_.marshal(this.effect_coord_x);
/*  75 */     _os_.marshal(this.effect_coord_y);
/*  76 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  81 */     this.id = _os_.unmarshal_int();
/*  82 */     this.desc = _os_.unmarshal_String("UTF-8");
/*  83 */     this.activity_cfg_id = _os_.unmarshal_int();
/*  84 */     this.moduleid = _os_.unmarshal_int();
/*  85 */     this.serverlevel = _os_.unmarshal_int();
/*  86 */     this.npc_id = _os_.unmarshal_int();
/*  87 */     this.get_item_npc_service_id = _os_.unmarshal_int();
/*  88 */     this.commit_item_npc_service_id = _os_.unmarshal_int();
/*  89 */     this.item_cfg_id = _os_.unmarshal_int();
/*  90 */     this.extra_type = _os_.unmarshal_int();
/*  91 */     this.extra_value = _os_.unmarshal_int();
/*  92 */     this.add_extra_value_per_operation = _os_.unmarshal_int();
/*  93 */     this.award_id = _os_.unmarshal_int();
/*  94 */     this.activity_map_cfg_id = _os_.unmarshal_int();
/*  95 */     this.effect_id = _os_.unmarshal_int();
/*  96 */     this.effect_coord_x = _os_.unmarshal_int();
/*  97 */     this.effect_coord_y = _os_.unmarshal_int();
/*  98 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 103 */     String path = dir + "mzm.gsp.feisheng.confbean.FeiShengDevelopItemActivityCfgOriginal.xml";
/*     */     
/*     */     try
/*     */     {
/* 107 */       all = new java.util.HashMap();
/* 108 */       SAXReader reader = new SAXReader();
/* 109 */       org.dom4j.Document doc = reader.read(new File(path));
/* 110 */       Element root = doc.getRootElement();
/* 111 */       List<?> nodeList = root.elements();
/* 112 */       int len = nodeList.size();
/* 113 */       for (int i = 0; i < len; i++)
/*     */       {
/* 115 */         Element elem = (Element)nodeList.get(i);
/* 116 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.feisheng.confbean.FeiShengDevelopItemActivityCfgOriginal"))
/*     */         {
/*     */ 
/* 119 */           FeiShengDevelopItemActivityCfgOriginal obj = new FeiShengDevelopItemActivityCfgOriginal();
/* 120 */           obj.loadFromXml(elem);
/* 121 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 122 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 127 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, FeiShengDevelopItemActivityCfgOriginal> all)
/*     */   {
/* 133 */     String path = dir + "mzm.gsp.feisheng.confbean.FeiShengDevelopItemActivityCfgOriginal.xml";
/*     */     
/*     */     try
/*     */     {
/* 137 */       SAXReader reader = new SAXReader();
/* 138 */       org.dom4j.Document doc = reader.read(new File(path));
/* 139 */       Element root = doc.getRootElement();
/* 140 */       List<?> nodeList = root.elements();
/* 141 */       int len = nodeList.size();
/* 142 */       for (int i = 0; i < len; i++)
/*     */       {
/* 144 */         Element elem = (Element)nodeList.get(i);
/* 145 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.feisheng.confbean.FeiShengDevelopItemActivityCfgOriginal"))
/*     */         {
/*     */ 
/* 148 */           FeiShengDevelopItemActivityCfgOriginal obj = new FeiShengDevelopItemActivityCfgOriginal();
/* 149 */           obj.loadFromXml(elem);
/* 150 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 151 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 156 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 162 */     all = new java.util.HashMap();
/*     */     
/* 164 */     String path = dir + "mzm.gsp.feisheng.confbean.FeiShengDevelopItemActivityCfgOriginal.bny";
/*     */     try
/*     */     {
/* 167 */       File file = new File(path);
/* 168 */       if (file.exists())
/*     */       {
/* 170 */         byte[] bytes = new byte['Ѐ'];
/* 171 */         FileInputStream fis = new FileInputStream(file);
/* 172 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 173 */         int len = 0;
/* 174 */         while ((len = fis.read(bytes)) > 0)
/* 175 */           baos.write(bytes, 0, len);
/* 176 */         fis.close();
/* 177 */         bytes = baos.toByteArray();
/* 178 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 179 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 181 */           _os_.unmarshal_int();
/* 182 */           _os_.unmarshal_int();
/* 183 */           _os_.unmarshal_int();
/*     */         }
/* 185 */         _os_.unmarshal_int();
/* 186 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 189 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 191 */           FeiShengDevelopItemActivityCfgOriginal _v_ = new FeiShengDevelopItemActivityCfgOriginal();
/* 192 */           _v_.unmarshal(_os_);
/* 193 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 194 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 199 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 204 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, FeiShengDevelopItemActivityCfgOriginal> all)
/*     */   {
/* 211 */     String path = dir + "mzm.gsp.feisheng.confbean.FeiShengDevelopItemActivityCfgOriginal.bny";
/*     */     try
/*     */     {
/* 214 */       File file = new File(path);
/* 215 */       if (file.exists())
/*     */       {
/* 217 */         byte[] bytes = new byte['Ѐ'];
/* 218 */         FileInputStream fis = new FileInputStream(file);
/* 219 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 220 */         int len = 0;
/* 221 */         while ((len = fis.read(bytes)) > 0)
/* 222 */           baos.write(bytes, 0, len);
/* 223 */         fis.close();
/* 224 */         bytes = baos.toByteArray();
/* 225 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 226 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 228 */           _os_.unmarshal_int();
/* 229 */           _os_.unmarshal_int();
/* 230 */           _os_.unmarshal_int();
/*     */         }
/* 232 */         _os_.unmarshal_int();
/* 233 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 236 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 238 */           FeiShengDevelopItemActivityCfgOriginal _v_ = new FeiShengDevelopItemActivityCfgOriginal();
/* 239 */           _v_.unmarshal(_os_);
/* 240 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 241 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 246 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 251 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static FeiShengDevelopItemActivityCfgOriginal getOld(int key)
/*     */   {
/* 259 */     return (FeiShengDevelopItemActivityCfgOriginal)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static FeiShengDevelopItemActivityCfgOriginal get(int key)
/*     */   {
/* 264 */     return (FeiShengDevelopItemActivityCfgOriginal)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, FeiShengDevelopItemActivityCfgOriginal> getOldAll()
/*     */   {
/* 269 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, FeiShengDevelopItemActivityCfgOriginal> getAll()
/*     */   {
/* 274 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, FeiShengDevelopItemActivityCfgOriginal> newAll)
/*     */   {
/* 279 */     oldAll = all;
/* 280 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 285 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\feisheng\confbean\FeiShengDevelopItemActivityCfgOriginal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */