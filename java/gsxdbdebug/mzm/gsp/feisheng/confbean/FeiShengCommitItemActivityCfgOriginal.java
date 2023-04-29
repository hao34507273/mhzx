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
/*     */ public class FeiShengCommitItemActivityCfgOriginal implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, FeiShengCommitItemActivityCfgOriginal> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, FeiShengCommitItemActivityCfgOriginal> all = null;
/*     */   
/*     */   public int id;
/*     */   public String desc;
/*     */   public int activity_cfg_id;
/*     */   public int moduleid;
/*     */   public int serverlevel;
/*     */   public int npc_id;
/*     */   public int npc_service_id;
/*     */   public int award_id;
/*     */   public int display_item_cfg_id;
/*     */   public int activity_map_cfg_id;
/*     */   public int effect_id;
/*     */   public int effect_coord_x;
/*     */   public int effect_coord_y;
/*  31 */   public java.util.ArrayList<NeedItemInfo> need_item_info_list = new java.util.ArrayList();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  35 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  36 */     this.desc = rootElement.attributeValue("desc");
/*  37 */     this.activity_cfg_id = Integer.valueOf(rootElement.attributeValue("activity_cfg_id")).intValue();
/*  38 */     this.moduleid = Integer.valueOf(rootElement.attributeValue("moduleid")).intValue();
/*  39 */     this.serverlevel = Integer.valueOf(rootElement.attributeValue("serverlevel")).intValue();
/*  40 */     this.npc_id = Integer.valueOf(rootElement.attributeValue("npc_id")).intValue();
/*  41 */     this.npc_service_id = Integer.valueOf(rootElement.attributeValue("npc_service_id")).intValue();
/*  42 */     this.award_id = Integer.valueOf(rootElement.attributeValue("award_id")).intValue();
/*  43 */     this.display_item_cfg_id = Integer.valueOf(rootElement.attributeValue("display_item_cfg_id")).intValue();
/*  44 */     this.activity_map_cfg_id = Integer.valueOf(rootElement.attributeValue("activity_map_cfg_id")).intValue();
/*  45 */     this.effect_id = Integer.valueOf(rootElement.attributeValue("effect_id")).intValue();
/*  46 */     this.effect_coord_x = Integer.valueOf(rootElement.attributeValue("effect_coord_x")).intValue();
/*  47 */     this.effect_coord_y = Integer.valueOf(rootElement.attributeValue("effect_coord_y")).intValue();
/*     */     
/*  49 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "need_item_info_list");
/*  50 */     if (collectionElement == null)
/*     */     {
/*  52 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  55 */     List<?> _nodeList = collectionElement.elements();
/*  56 */     int _len = _nodeList.size();
/*  57 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  59 */       Element elem = (Element)_nodeList.get(i);
/*  60 */       if (elem.getName().equalsIgnoreCase("mzm.gsp.feisheng.confbean.NeedItemInfo"))
/*     */       {
/*     */         NeedItemInfo _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  67 */           _v_ = new NeedItemInfo();
/*  68 */           _v_.loadFromXml(elem);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  75 */         this.need_item_info_list.add(_v_);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  82 */     _os_.marshal(this.id);
/*  83 */     _os_.marshal(this.desc, "UTF-8");
/*  84 */     _os_.marshal(this.activity_cfg_id);
/*  85 */     _os_.marshal(this.moduleid);
/*  86 */     _os_.marshal(this.serverlevel);
/*  87 */     _os_.marshal(this.npc_id);
/*  88 */     _os_.marshal(this.npc_service_id);
/*  89 */     _os_.marshal(this.award_id);
/*  90 */     _os_.marshal(this.display_item_cfg_id);
/*  91 */     _os_.marshal(this.activity_map_cfg_id);
/*  92 */     _os_.marshal(this.effect_id);
/*  93 */     _os_.marshal(this.effect_coord_x);
/*  94 */     _os_.marshal(this.effect_coord_y);
/*  95 */     _os_.compact_uint32(this.need_item_info_list.size());
/*  96 */     for (NeedItemInfo _v_ : this.need_item_info_list)
/*     */     {
/*  98 */       _os_.marshal(_v_);
/*     */     }
/* 100 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 105 */     this.id = _os_.unmarshal_int();
/* 106 */     this.desc = _os_.unmarshal_String("UTF-8");
/* 107 */     this.activity_cfg_id = _os_.unmarshal_int();
/* 108 */     this.moduleid = _os_.unmarshal_int();
/* 109 */     this.serverlevel = _os_.unmarshal_int();
/* 110 */     this.npc_id = _os_.unmarshal_int();
/* 111 */     this.npc_service_id = _os_.unmarshal_int();
/* 112 */     this.award_id = _os_.unmarshal_int();
/* 113 */     this.display_item_cfg_id = _os_.unmarshal_int();
/* 114 */     this.activity_map_cfg_id = _os_.unmarshal_int();
/* 115 */     this.effect_id = _os_.unmarshal_int();
/* 116 */     this.effect_coord_x = _os_.unmarshal_int();
/* 117 */     this.effect_coord_y = _os_.unmarshal_int();
/* 118 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 121 */       NeedItemInfo _v_ = new NeedItemInfo();
/* 122 */       _v_.unmarshal(_os_);
/* 123 */       this.need_item_info_list.add(_v_);
/*     */     }
/* 125 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 130 */     String path = dir + "mzm.gsp.feisheng.confbean.FeiShengCommitItemActivityCfgOriginal.xml";
/*     */     
/*     */     try
/*     */     {
/* 134 */       all = new java.util.HashMap();
/* 135 */       SAXReader reader = new SAXReader();
/* 136 */       org.dom4j.Document doc = reader.read(new File(path));
/* 137 */       Element root = doc.getRootElement();
/* 138 */       List<?> nodeList = root.elements();
/* 139 */       int len = nodeList.size();
/* 140 */       for (int i = 0; i < len; i++)
/*     */       {
/* 142 */         Element elem = (Element)nodeList.get(i);
/* 143 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.feisheng.confbean.FeiShengCommitItemActivityCfgOriginal"))
/*     */         {
/*     */ 
/* 146 */           FeiShengCommitItemActivityCfgOriginal obj = new FeiShengCommitItemActivityCfgOriginal();
/* 147 */           obj.loadFromXml(elem);
/* 148 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 149 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 154 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, FeiShengCommitItemActivityCfgOriginal> all)
/*     */   {
/* 160 */     String path = dir + "mzm.gsp.feisheng.confbean.FeiShengCommitItemActivityCfgOriginal.xml";
/*     */     
/*     */     try
/*     */     {
/* 164 */       SAXReader reader = new SAXReader();
/* 165 */       org.dom4j.Document doc = reader.read(new File(path));
/* 166 */       Element root = doc.getRootElement();
/* 167 */       List<?> nodeList = root.elements();
/* 168 */       int len = nodeList.size();
/* 169 */       for (int i = 0; i < len; i++)
/*     */       {
/* 171 */         Element elem = (Element)nodeList.get(i);
/* 172 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.feisheng.confbean.FeiShengCommitItemActivityCfgOriginal"))
/*     */         {
/*     */ 
/* 175 */           FeiShengCommitItemActivityCfgOriginal obj = new FeiShengCommitItemActivityCfgOriginal();
/* 176 */           obj.loadFromXml(elem);
/* 177 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 178 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 183 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 189 */     all = new java.util.HashMap();
/*     */     
/* 191 */     String path = dir + "mzm.gsp.feisheng.confbean.FeiShengCommitItemActivityCfgOriginal.bny";
/*     */     try
/*     */     {
/* 194 */       File file = new File(path);
/* 195 */       if (file.exists())
/*     */       {
/* 197 */         byte[] bytes = new byte['Ѐ'];
/* 198 */         FileInputStream fis = new FileInputStream(file);
/* 199 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 200 */         int len = 0;
/* 201 */         while ((len = fis.read(bytes)) > 0)
/* 202 */           baos.write(bytes, 0, len);
/* 203 */         fis.close();
/* 204 */         bytes = baos.toByteArray();
/* 205 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 206 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 208 */           _os_.unmarshal_int();
/* 209 */           _os_.unmarshal_int();
/* 210 */           _os_.unmarshal_int();
/*     */         }
/* 212 */         _os_.unmarshal_int();
/* 213 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 216 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 218 */           FeiShengCommitItemActivityCfgOriginal _v_ = new FeiShengCommitItemActivityCfgOriginal();
/* 219 */           _v_.unmarshal(_os_);
/* 220 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 221 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 226 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 231 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, FeiShengCommitItemActivityCfgOriginal> all)
/*     */   {
/* 238 */     String path = dir + "mzm.gsp.feisheng.confbean.FeiShengCommitItemActivityCfgOriginal.bny";
/*     */     try
/*     */     {
/* 241 */       File file = new File(path);
/* 242 */       if (file.exists())
/*     */       {
/* 244 */         byte[] bytes = new byte['Ѐ'];
/* 245 */         FileInputStream fis = new FileInputStream(file);
/* 246 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 247 */         int len = 0;
/* 248 */         while ((len = fis.read(bytes)) > 0)
/* 249 */           baos.write(bytes, 0, len);
/* 250 */         fis.close();
/* 251 */         bytes = baos.toByteArray();
/* 252 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 253 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 255 */           _os_.unmarshal_int();
/* 256 */           _os_.unmarshal_int();
/* 257 */           _os_.unmarshal_int();
/*     */         }
/* 259 */         _os_.unmarshal_int();
/* 260 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 263 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 265 */           FeiShengCommitItemActivityCfgOriginal _v_ = new FeiShengCommitItemActivityCfgOriginal();
/* 266 */           _v_.unmarshal(_os_);
/* 267 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 268 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 273 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 278 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static FeiShengCommitItemActivityCfgOriginal getOld(int key)
/*     */   {
/* 286 */     return (FeiShengCommitItemActivityCfgOriginal)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static FeiShengCommitItemActivityCfgOriginal get(int key)
/*     */   {
/* 291 */     return (FeiShengCommitItemActivityCfgOriginal)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, FeiShengCommitItemActivityCfgOriginal> getOldAll()
/*     */   {
/* 296 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, FeiShengCommitItemActivityCfgOriginal> getAll()
/*     */   {
/* 301 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, FeiShengCommitItemActivityCfgOriginal> newAll)
/*     */   {
/* 306 */     oldAll = all;
/* 307 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 312 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\feisheng\confbean\FeiShengCommitItemActivityCfgOriginal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */