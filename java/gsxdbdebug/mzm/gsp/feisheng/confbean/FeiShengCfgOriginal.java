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
/*     */ public class FeiShengCfgOriginal implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, FeiShengCfgOriginal> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, FeiShengCfgOriginal> all = null;
/*     */   
/*     */   public int id;
/*     */   public String desc;
/*     */   public int activity_cfg_id;
/*     */   public int moduleid;
/*     */   public int serverlevel;
/*     */   public int activity_map_cfg_id;
/*     */   public int activity_map_transfer_x;
/*     */   public int activity_map_transfer_y;
/*     */   public int npc_controller_id;
/*     */   public int award_id;
/*     */   public int level;
/*     */   public int task_graph_id;
/*     */   public int not_complete_effect_id;
/*     */   public int complete_effect_id;
/*     */   public int effect_coord_x;
/*     */   public int effect_coord_y;
/*     */   public int ui_complete_effect_id;
/*  35 */   public java.util.ArrayList<SubActivityCfgid> sub_activity_cfg_ids = new java.util.ArrayList();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  39 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  40 */     this.desc = rootElement.attributeValue("desc");
/*  41 */     this.activity_cfg_id = Integer.valueOf(rootElement.attributeValue("activity_cfg_id")).intValue();
/*  42 */     this.moduleid = Integer.valueOf(rootElement.attributeValue("moduleid")).intValue();
/*  43 */     this.serverlevel = Integer.valueOf(rootElement.attributeValue("serverlevel")).intValue();
/*  44 */     this.activity_map_cfg_id = Integer.valueOf(rootElement.attributeValue("activity_map_cfg_id")).intValue();
/*  45 */     this.activity_map_transfer_x = Integer.valueOf(rootElement.attributeValue("activity_map_transfer_x")).intValue();
/*  46 */     this.activity_map_transfer_y = Integer.valueOf(rootElement.attributeValue("activity_map_transfer_y")).intValue();
/*  47 */     this.npc_controller_id = Integer.valueOf(rootElement.attributeValue("npc_controller_id")).intValue();
/*  48 */     this.award_id = Integer.valueOf(rootElement.attributeValue("award_id")).intValue();
/*  49 */     this.level = Integer.valueOf(rootElement.attributeValue("level")).intValue();
/*  50 */     this.task_graph_id = Integer.valueOf(rootElement.attributeValue("task_graph_id")).intValue();
/*  51 */     this.not_complete_effect_id = Integer.valueOf(rootElement.attributeValue("not_complete_effect_id")).intValue();
/*  52 */     this.complete_effect_id = Integer.valueOf(rootElement.attributeValue("complete_effect_id")).intValue();
/*  53 */     this.effect_coord_x = Integer.valueOf(rootElement.attributeValue("effect_coord_x")).intValue();
/*  54 */     this.effect_coord_y = Integer.valueOf(rootElement.attributeValue("effect_coord_y")).intValue();
/*  55 */     this.ui_complete_effect_id = Integer.valueOf(rootElement.attributeValue("ui_complete_effect_id")).intValue();
/*     */     
/*  57 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "sub_activity_cfg_ids");
/*  58 */     if (collectionElement == null)
/*     */     {
/*  60 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  63 */     List<?> _nodeList = collectionElement.elements();
/*  64 */     int _len = _nodeList.size();
/*  65 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  67 */       Element elem = (Element)_nodeList.get(i);
/*  68 */       if (elem.getName().equalsIgnoreCase("mzm.gsp.feisheng.confbean.SubActivityCfgid"))
/*     */       {
/*     */         SubActivityCfgid _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  75 */           _v_ = new SubActivityCfgid();
/*  76 */           _v_.loadFromXml(elem);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  83 */         this.sub_activity_cfg_ids.add(_v_);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  90 */     _os_.marshal(this.id);
/*  91 */     _os_.marshal(this.desc, "UTF-8");
/*  92 */     _os_.marshal(this.activity_cfg_id);
/*  93 */     _os_.marshal(this.moduleid);
/*  94 */     _os_.marshal(this.serverlevel);
/*  95 */     _os_.marshal(this.activity_map_cfg_id);
/*  96 */     _os_.marshal(this.activity_map_transfer_x);
/*  97 */     _os_.marshal(this.activity_map_transfer_y);
/*  98 */     _os_.marshal(this.npc_controller_id);
/*  99 */     _os_.marshal(this.award_id);
/* 100 */     _os_.marshal(this.level);
/* 101 */     _os_.marshal(this.task_graph_id);
/* 102 */     _os_.marshal(this.not_complete_effect_id);
/* 103 */     _os_.marshal(this.complete_effect_id);
/* 104 */     _os_.marshal(this.effect_coord_x);
/* 105 */     _os_.marshal(this.effect_coord_y);
/* 106 */     _os_.marshal(this.ui_complete_effect_id);
/* 107 */     _os_.compact_uint32(this.sub_activity_cfg_ids.size());
/* 108 */     for (SubActivityCfgid _v_ : this.sub_activity_cfg_ids)
/*     */     {
/* 110 */       _os_.marshal(_v_);
/*     */     }
/* 112 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 117 */     this.id = _os_.unmarshal_int();
/* 118 */     this.desc = _os_.unmarshal_String("UTF-8");
/* 119 */     this.activity_cfg_id = _os_.unmarshal_int();
/* 120 */     this.moduleid = _os_.unmarshal_int();
/* 121 */     this.serverlevel = _os_.unmarshal_int();
/* 122 */     this.activity_map_cfg_id = _os_.unmarshal_int();
/* 123 */     this.activity_map_transfer_x = _os_.unmarshal_int();
/* 124 */     this.activity_map_transfer_y = _os_.unmarshal_int();
/* 125 */     this.npc_controller_id = _os_.unmarshal_int();
/* 126 */     this.award_id = _os_.unmarshal_int();
/* 127 */     this.level = _os_.unmarshal_int();
/* 128 */     this.task_graph_id = _os_.unmarshal_int();
/* 129 */     this.not_complete_effect_id = _os_.unmarshal_int();
/* 130 */     this.complete_effect_id = _os_.unmarshal_int();
/* 131 */     this.effect_coord_x = _os_.unmarshal_int();
/* 132 */     this.effect_coord_y = _os_.unmarshal_int();
/* 133 */     this.ui_complete_effect_id = _os_.unmarshal_int();
/* 134 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 137 */       SubActivityCfgid _v_ = new SubActivityCfgid();
/* 138 */       _v_.unmarshal(_os_);
/* 139 */       this.sub_activity_cfg_ids.add(_v_);
/*     */     }
/* 141 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 146 */     String path = dir + "mzm.gsp.feisheng.confbean.FeiShengCfgOriginal.xml";
/*     */     
/*     */     try
/*     */     {
/* 150 */       all = new java.util.HashMap();
/* 151 */       SAXReader reader = new SAXReader();
/* 152 */       org.dom4j.Document doc = reader.read(new File(path));
/* 153 */       Element root = doc.getRootElement();
/* 154 */       List<?> nodeList = root.elements();
/* 155 */       int len = nodeList.size();
/* 156 */       for (int i = 0; i < len; i++)
/*     */       {
/* 158 */         Element elem = (Element)nodeList.get(i);
/* 159 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.feisheng.confbean.FeiShengCfgOriginal"))
/*     */         {
/*     */ 
/* 162 */           FeiShengCfgOriginal obj = new FeiShengCfgOriginal();
/* 163 */           obj.loadFromXml(elem);
/* 164 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 165 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 170 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, FeiShengCfgOriginal> all)
/*     */   {
/* 176 */     String path = dir + "mzm.gsp.feisheng.confbean.FeiShengCfgOriginal.xml";
/*     */     
/*     */     try
/*     */     {
/* 180 */       SAXReader reader = new SAXReader();
/* 181 */       org.dom4j.Document doc = reader.read(new File(path));
/* 182 */       Element root = doc.getRootElement();
/* 183 */       List<?> nodeList = root.elements();
/* 184 */       int len = nodeList.size();
/* 185 */       for (int i = 0; i < len; i++)
/*     */       {
/* 187 */         Element elem = (Element)nodeList.get(i);
/* 188 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.feisheng.confbean.FeiShengCfgOriginal"))
/*     */         {
/*     */ 
/* 191 */           FeiShengCfgOriginal obj = new FeiShengCfgOriginal();
/* 192 */           obj.loadFromXml(elem);
/* 193 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 194 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 199 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 205 */     all = new java.util.HashMap();
/*     */     
/* 207 */     String path = dir + "mzm.gsp.feisheng.confbean.FeiShengCfgOriginal.bny";
/*     */     try
/*     */     {
/* 210 */       File file = new File(path);
/* 211 */       if (file.exists())
/*     */       {
/* 213 */         byte[] bytes = new byte['Ѐ'];
/* 214 */         FileInputStream fis = new FileInputStream(file);
/* 215 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 216 */         int len = 0;
/* 217 */         while ((len = fis.read(bytes)) > 0)
/* 218 */           baos.write(bytes, 0, len);
/* 219 */         fis.close();
/* 220 */         bytes = baos.toByteArray();
/* 221 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 222 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 224 */           _os_.unmarshal_int();
/* 225 */           _os_.unmarshal_int();
/* 226 */           _os_.unmarshal_int();
/*     */         }
/* 228 */         _os_.unmarshal_int();
/* 229 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 232 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 234 */           FeiShengCfgOriginal _v_ = new FeiShengCfgOriginal();
/* 235 */           _v_.unmarshal(_os_);
/* 236 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 237 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 242 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 247 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, FeiShengCfgOriginal> all)
/*     */   {
/* 254 */     String path = dir + "mzm.gsp.feisheng.confbean.FeiShengCfgOriginal.bny";
/*     */     try
/*     */     {
/* 257 */       File file = new File(path);
/* 258 */       if (file.exists())
/*     */       {
/* 260 */         byte[] bytes = new byte['Ѐ'];
/* 261 */         FileInputStream fis = new FileInputStream(file);
/* 262 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 263 */         int len = 0;
/* 264 */         while ((len = fis.read(bytes)) > 0)
/* 265 */           baos.write(bytes, 0, len);
/* 266 */         fis.close();
/* 267 */         bytes = baos.toByteArray();
/* 268 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 269 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 271 */           _os_.unmarshal_int();
/* 272 */           _os_.unmarshal_int();
/* 273 */           _os_.unmarshal_int();
/*     */         }
/* 275 */         _os_.unmarshal_int();
/* 276 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 279 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 281 */           FeiShengCfgOriginal _v_ = new FeiShengCfgOriginal();
/* 282 */           _v_.unmarshal(_os_);
/* 283 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 284 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 289 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 294 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static FeiShengCfgOriginal getOld(int key)
/*     */   {
/* 302 */     return (FeiShengCfgOriginal)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static FeiShengCfgOriginal get(int key)
/*     */   {
/* 307 */     return (FeiShengCfgOriginal)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, FeiShengCfgOriginal> getOldAll()
/*     */   {
/* 312 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, FeiShengCfgOriginal> getAll()
/*     */   {
/* 317 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, FeiShengCfgOriginal> newAll)
/*     */   {
/* 322 */     oldAll = all;
/* 323 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 328 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\feisheng\confbean\FeiShengCfgOriginal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */