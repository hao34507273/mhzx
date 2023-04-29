/*     */ package mzm.gsp.axe.confbean;
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
/*     */ public class AxeActivityCfgOriginal implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, AxeActivityCfgOriginal> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, AxeActivityCfgOriginal> all = null;
/*     */   
/*     */   public int id;
/*     */   public String name;
/*     */   public String desc;
/*     */   public int activity_cfg_id;
/*     */   public int moduleid;
/*     */   public int baodi_trigger_times;
/*     */   public int lock_trigger_interval_in_day;
/*     */   public int unlock_cost_type;
/*     */   public int unlock_cost_num;
/*     */   public int section_id;
/*     */   public int cost_type;
/*     */   public int cost_num;
/*     */   public int sortid;
/*     */   public int axe_item_cfg_id;
/*     */   public int axe_num;
/*     */   public int probability;
/*     */   public int display_probability;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  38 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  39 */     this.name = rootElement.attributeValue("name");
/*  40 */     this.desc = rootElement.attributeValue("desc");
/*  41 */     this.activity_cfg_id = Integer.valueOf(rootElement.attributeValue("activity_cfg_id")).intValue();
/*  42 */     this.moduleid = Integer.valueOf(rootElement.attributeValue("moduleid")).intValue();
/*  43 */     this.baodi_trigger_times = Integer.valueOf(rootElement.attributeValue("baodi_trigger_times")).intValue();
/*  44 */     this.lock_trigger_interval_in_day = Integer.valueOf(rootElement.attributeValue("lock_trigger_interval_in_day")).intValue();
/*  45 */     this.unlock_cost_type = Integer.valueOf(rootElement.attributeValue("unlock_cost_type")).intValue();
/*  46 */     this.unlock_cost_num = Integer.valueOf(rootElement.attributeValue("unlock_cost_num")).intValue();
/*  47 */     this.section_id = Integer.valueOf(rootElement.attributeValue("section_id")).intValue();
/*  48 */     this.cost_type = Integer.valueOf(rootElement.attributeValue("cost_type")).intValue();
/*  49 */     this.cost_num = Integer.valueOf(rootElement.attributeValue("cost_num")).intValue();
/*  50 */     this.sortid = Integer.valueOf(rootElement.attributeValue("sortid")).intValue();
/*  51 */     this.axe_item_cfg_id = Integer.valueOf(rootElement.attributeValue("axe_item_cfg_id")).intValue();
/*  52 */     this.axe_num = Integer.valueOf(rootElement.attributeValue("axe_num")).intValue();
/*  53 */     this.probability = Integer.valueOf(rootElement.attributeValue("probability")).intValue();
/*  54 */     this.display_probability = Integer.valueOf(rootElement.attributeValue("display_probability")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  59 */     _os_.marshal(this.id);
/*  60 */     _os_.marshal(this.name, "UTF-8");
/*  61 */     _os_.marshal(this.desc, "UTF-8");
/*  62 */     _os_.marshal(this.activity_cfg_id);
/*  63 */     _os_.marshal(this.moduleid);
/*  64 */     _os_.marshal(this.baodi_trigger_times);
/*  65 */     _os_.marshal(this.lock_trigger_interval_in_day);
/*  66 */     _os_.marshal(this.unlock_cost_type);
/*  67 */     _os_.marshal(this.unlock_cost_num);
/*  68 */     _os_.marshal(this.section_id);
/*  69 */     _os_.marshal(this.cost_type);
/*  70 */     _os_.marshal(this.cost_num);
/*  71 */     _os_.marshal(this.sortid);
/*  72 */     _os_.marshal(this.axe_item_cfg_id);
/*  73 */     _os_.marshal(this.axe_num);
/*  74 */     _os_.marshal(this.probability);
/*  75 */     _os_.marshal(this.display_probability);
/*  76 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  81 */     this.id = _os_.unmarshal_int();
/*  82 */     this.name = _os_.unmarshal_String("UTF-8");
/*  83 */     this.desc = _os_.unmarshal_String("UTF-8");
/*  84 */     this.activity_cfg_id = _os_.unmarshal_int();
/*  85 */     this.moduleid = _os_.unmarshal_int();
/*  86 */     this.baodi_trigger_times = _os_.unmarshal_int();
/*  87 */     this.lock_trigger_interval_in_day = _os_.unmarshal_int();
/*  88 */     this.unlock_cost_type = _os_.unmarshal_int();
/*  89 */     this.unlock_cost_num = _os_.unmarshal_int();
/*  90 */     this.section_id = _os_.unmarshal_int();
/*  91 */     this.cost_type = _os_.unmarshal_int();
/*  92 */     this.cost_num = _os_.unmarshal_int();
/*  93 */     this.sortid = _os_.unmarshal_int();
/*  94 */     this.axe_item_cfg_id = _os_.unmarshal_int();
/*  95 */     this.axe_num = _os_.unmarshal_int();
/*  96 */     this.probability = _os_.unmarshal_int();
/*  97 */     this.display_probability = _os_.unmarshal_int();
/*  98 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 103 */     String path = dir + "mzm.gsp.axe.confbean.AxeActivityCfgOriginal.xml";
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
/* 116 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.axe.confbean.AxeActivityCfgOriginal"))
/*     */         {
/*     */ 
/* 119 */           AxeActivityCfgOriginal obj = new AxeActivityCfgOriginal();
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
/*     */   public static void reLoadXml(String dir, Map<Integer, AxeActivityCfgOriginal> all)
/*     */   {
/* 133 */     String path = dir + "mzm.gsp.axe.confbean.AxeActivityCfgOriginal.xml";
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
/* 145 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.axe.confbean.AxeActivityCfgOriginal"))
/*     */         {
/*     */ 
/* 148 */           AxeActivityCfgOriginal obj = new AxeActivityCfgOriginal();
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
/* 164 */     String path = dir + "mzm.gsp.axe.confbean.AxeActivityCfgOriginal.bny";
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
/* 191 */           AxeActivityCfgOriginal _v_ = new AxeActivityCfgOriginal();
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
/*     */   public static void reLoadBny(String dir, Map<Integer, AxeActivityCfgOriginal> all)
/*     */   {
/* 211 */     String path = dir + "mzm.gsp.axe.confbean.AxeActivityCfgOriginal.bny";
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
/* 238 */           AxeActivityCfgOriginal _v_ = new AxeActivityCfgOriginal();
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
/*     */   public static AxeActivityCfgOriginal getOld(int key)
/*     */   {
/* 259 */     return (AxeActivityCfgOriginal)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static AxeActivityCfgOriginal get(int key)
/*     */   {
/* 264 */     return (AxeActivityCfgOriginal)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, AxeActivityCfgOriginal> getOldAll()
/*     */   {
/* 269 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, AxeActivityCfgOriginal> getAll()
/*     */   {
/* 274 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, AxeActivityCfgOriginal> newAll)
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


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\axe\confbean\AxeActivityCfgOriginal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */