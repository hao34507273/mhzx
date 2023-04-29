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
/*     */ public class FeiShengCommitPetActivityCfgOriginal implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, FeiShengCommitPetActivityCfgOriginal> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, FeiShengCommitPetActivityCfgOriginal> all = null;
/*     */   
/*     */   public int id;
/*     */   public String desc;
/*     */   public int activity_cfg_id;
/*     */   public int moduleid;
/*     */   public int serverlevel;
/*     */   public int npc_id;
/*     */   public int npc_service_id;
/*     */   public int award_id;
/*     */   public int activity_map_cfg_id;
/*     */   public int effect_id;
/*     */   public int effect_coord_x;
/*     */   public int effect_coord_y;
/*  30 */   public java.util.ArrayList<NeedPetInfo> need_pet_info_list = new java.util.ArrayList();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  34 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  35 */     this.desc = rootElement.attributeValue("desc");
/*  36 */     this.activity_cfg_id = Integer.valueOf(rootElement.attributeValue("activity_cfg_id")).intValue();
/*  37 */     this.moduleid = Integer.valueOf(rootElement.attributeValue("moduleid")).intValue();
/*  38 */     this.serverlevel = Integer.valueOf(rootElement.attributeValue("serverlevel")).intValue();
/*  39 */     this.npc_id = Integer.valueOf(rootElement.attributeValue("npc_id")).intValue();
/*  40 */     this.npc_service_id = Integer.valueOf(rootElement.attributeValue("npc_service_id")).intValue();
/*  41 */     this.award_id = Integer.valueOf(rootElement.attributeValue("award_id")).intValue();
/*  42 */     this.activity_map_cfg_id = Integer.valueOf(rootElement.attributeValue("activity_map_cfg_id")).intValue();
/*  43 */     this.effect_id = Integer.valueOf(rootElement.attributeValue("effect_id")).intValue();
/*  44 */     this.effect_coord_x = Integer.valueOf(rootElement.attributeValue("effect_coord_x")).intValue();
/*  45 */     this.effect_coord_y = Integer.valueOf(rootElement.attributeValue("effect_coord_y")).intValue();
/*     */     
/*  47 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "need_pet_info_list");
/*  48 */     if (collectionElement == null)
/*     */     {
/*  50 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  53 */     List<?> _nodeList = collectionElement.elements();
/*  54 */     int _len = _nodeList.size();
/*  55 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  57 */       Element elem = (Element)_nodeList.get(i);
/*  58 */       if (elem.getName().equalsIgnoreCase("mzm.gsp.feisheng.confbean.NeedPetInfo"))
/*     */       {
/*     */         NeedPetInfo _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  65 */           _v_ = new NeedPetInfo();
/*  66 */           _v_.loadFromXml(elem);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  73 */         this.need_pet_info_list.add(_v_);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  80 */     _os_.marshal(this.id);
/*  81 */     _os_.marshal(this.desc, "UTF-8");
/*  82 */     _os_.marshal(this.activity_cfg_id);
/*  83 */     _os_.marshal(this.moduleid);
/*  84 */     _os_.marshal(this.serverlevel);
/*  85 */     _os_.marshal(this.npc_id);
/*  86 */     _os_.marshal(this.npc_service_id);
/*  87 */     _os_.marshal(this.award_id);
/*  88 */     _os_.marshal(this.activity_map_cfg_id);
/*  89 */     _os_.marshal(this.effect_id);
/*  90 */     _os_.marshal(this.effect_coord_x);
/*  91 */     _os_.marshal(this.effect_coord_y);
/*  92 */     _os_.compact_uint32(this.need_pet_info_list.size());
/*  93 */     for (NeedPetInfo _v_ : this.need_pet_info_list)
/*     */     {
/*  95 */       _os_.marshal(_v_);
/*     */     }
/*  97 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 102 */     this.id = _os_.unmarshal_int();
/* 103 */     this.desc = _os_.unmarshal_String("UTF-8");
/* 104 */     this.activity_cfg_id = _os_.unmarshal_int();
/* 105 */     this.moduleid = _os_.unmarshal_int();
/* 106 */     this.serverlevel = _os_.unmarshal_int();
/* 107 */     this.npc_id = _os_.unmarshal_int();
/* 108 */     this.npc_service_id = _os_.unmarshal_int();
/* 109 */     this.award_id = _os_.unmarshal_int();
/* 110 */     this.activity_map_cfg_id = _os_.unmarshal_int();
/* 111 */     this.effect_id = _os_.unmarshal_int();
/* 112 */     this.effect_coord_x = _os_.unmarshal_int();
/* 113 */     this.effect_coord_y = _os_.unmarshal_int();
/* 114 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 117 */       NeedPetInfo _v_ = new NeedPetInfo();
/* 118 */       _v_.unmarshal(_os_);
/* 119 */       this.need_pet_info_list.add(_v_);
/*     */     }
/* 121 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 126 */     String path = dir + "mzm.gsp.feisheng.confbean.FeiShengCommitPetActivityCfgOriginal.xml";
/*     */     
/*     */     try
/*     */     {
/* 130 */       all = new java.util.HashMap();
/* 131 */       SAXReader reader = new SAXReader();
/* 132 */       org.dom4j.Document doc = reader.read(new File(path));
/* 133 */       Element root = doc.getRootElement();
/* 134 */       List<?> nodeList = root.elements();
/* 135 */       int len = nodeList.size();
/* 136 */       for (int i = 0; i < len; i++)
/*     */       {
/* 138 */         Element elem = (Element)nodeList.get(i);
/* 139 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.feisheng.confbean.FeiShengCommitPetActivityCfgOriginal"))
/*     */         {
/*     */ 
/* 142 */           FeiShengCommitPetActivityCfgOriginal obj = new FeiShengCommitPetActivityCfgOriginal();
/* 143 */           obj.loadFromXml(elem);
/* 144 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 145 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 150 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, FeiShengCommitPetActivityCfgOriginal> all)
/*     */   {
/* 156 */     String path = dir + "mzm.gsp.feisheng.confbean.FeiShengCommitPetActivityCfgOriginal.xml";
/*     */     
/*     */     try
/*     */     {
/* 160 */       SAXReader reader = new SAXReader();
/* 161 */       org.dom4j.Document doc = reader.read(new File(path));
/* 162 */       Element root = doc.getRootElement();
/* 163 */       List<?> nodeList = root.elements();
/* 164 */       int len = nodeList.size();
/* 165 */       for (int i = 0; i < len; i++)
/*     */       {
/* 167 */         Element elem = (Element)nodeList.get(i);
/* 168 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.feisheng.confbean.FeiShengCommitPetActivityCfgOriginal"))
/*     */         {
/*     */ 
/* 171 */           FeiShengCommitPetActivityCfgOriginal obj = new FeiShengCommitPetActivityCfgOriginal();
/* 172 */           obj.loadFromXml(elem);
/* 173 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 174 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 179 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 185 */     all = new java.util.HashMap();
/*     */     
/* 187 */     String path = dir + "mzm.gsp.feisheng.confbean.FeiShengCommitPetActivityCfgOriginal.bny";
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
/* 214 */           FeiShengCommitPetActivityCfgOriginal _v_ = new FeiShengCommitPetActivityCfgOriginal();
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
/*     */   public static void reLoadBny(String dir, Map<Integer, FeiShengCommitPetActivityCfgOriginal> all)
/*     */   {
/* 234 */     String path = dir + "mzm.gsp.feisheng.confbean.FeiShengCommitPetActivityCfgOriginal.bny";
/*     */     try
/*     */     {
/* 237 */       File file = new File(path);
/* 238 */       if (file.exists())
/*     */       {
/* 240 */         byte[] bytes = new byte['Ѐ'];
/* 241 */         FileInputStream fis = new FileInputStream(file);
/* 242 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 243 */         int len = 0;
/* 244 */         while ((len = fis.read(bytes)) > 0)
/* 245 */           baos.write(bytes, 0, len);
/* 246 */         fis.close();
/* 247 */         bytes = baos.toByteArray();
/* 248 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 249 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 251 */           _os_.unmarshal_int();
/* 252 */           _os_.unmarshal_int();
/* 253 */           _os_.unmarshal_int();
/*     */         }
/* 255 */         _os_.unmarshal_int();
/* 256 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 259 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 261 */           FeiShengCommitPetActivityCfgOriginal _v_ = new FeiShengCommitPetActivityCfgOriginal();
/* 262 */           _v_.unmarshal(_os_);
/* 263 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 264 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 269 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 274 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static FeiShengCommitPetActivityCfgOriginal getOld(int key)
/*     */   {
/* 282 */     return (FeiShengCommitPetActivityCfgOriginal)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static FeiShengCommitPetActivityCfgOriginal get(int key)
/*     */   {
/* 287 */     return (FeiShengCommitPetActivityCfgOriginal)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, FeiShengCommitPetActivityCfgOriginal> getOldAll()
/*     */   {
/* 292 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, FeiShengCommitPetActivityCfgOriginal> getAll()
/*     */   {
/* 297 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, FeiShengCommitPetActivityCfgOriginal> newAll)
/*     */   {
/* 302 */     oldAll = all;
/* 303 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 308 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\feisheng\confbean\FeiShengCommitPetActivityCfgOriginal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */