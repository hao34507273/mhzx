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
/*     */ public class PlantTreeCfgOriginal implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, PlantTreeCfgOriginal> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, PlantTreeCfgOriginal> all = null;
/*     */   
/*     */   public int id;
/*     */   public String name;
/*     */   public String desc;
/*     */   public int activity_cfg_id;
/*     */   public int moduleid;
/*     */   public int activity_type;
/*     */   public int section_num;
/*     */   public int online_unit_interval;
/*     */   public int online_reward_max_point;
/*     */   public int activity_complete_award_id;
/*     */   public int add_point_max_times;
/*     */   public int special_state_refresh_interval;
/*     */   public int remove_special_state_award_max_times;
/*     */   public int remove_special_state_awardid;
/*     */   public int tips_content_id;
/*     */   public int activity_complete_modle_id;
/*     */   public String activity_complete_name;
/*  35 */   public java.util.ArrayList<SpecialStateInfo> special_state_infos = new java.util.ArrayList();
/*     */   public int section_id;
/*     */   public int section_total_point;
/*     */   public int section_complete_award_id;
/*     */   public int section_modle_id;
/*     */   public String section_name;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  44 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  45 */     this.name = rootElement.attributeValue("name");
/*  46 */     this.desc = rootElement.attributeValue("desc");
/*  47 */     this.activity_cfg_id = Integer.valueOf(rootElement.attributeValue("activity_cfg_id")).intValue();
/*  48 */     this.moduleid = Integer.valueOf(rootElement.attributeValue("moduleid")).intValue();
/*  49 */     this.activity_type = Integer.valueOf(rootElement.attributeValue("activity_type")).intValue();
/*  50 */     this.section_num = Integer.valueOf(rootElement.attributeValue("section_num")).intValue();
/*  51 */     this.online_unit_interval = Integer.valueOf(rootElement.attributeValue("online_unit_interval")).intValue();
/*  52 */     this.online_reward_max_point = Integer.valueOf(rootElement.attributeValue("online_reward_max_point")).intValue();
/*  53 */     this.activity_complete_award_id = Integer.valueOf(rootElement.attributeValue("activity_complete_award_id")).intValue();
/*  54 */     this.add_point_max_times = Integer.valueOf(rootElement.attributeValue("add_point_max_times")).intValue();
/*  55 */     this.special_state_refresh_interval = Integer.valueOf(rootElement.attributeValue("special_state_refresh_interval")).intValue();
/*  56 */     this.remove_special_state_award_max_times = Integer.valueOf(rootElement.attributeValue("remove_special_state_award_max_times")).intValue();
/*  57 */     this.remove_special_state_awardid = Integer.valueOf(rootElement.attributeValue("remove_special_state_awardid")).intValue();
/*  58 */     this.tips_content_id = Integer.valueOf(rootElement.attributeValue("tips_content_id")).intValue();
/*  59 */     this.activity_complete_modle_id = Integer.valueOf(rootElement.attributeValue("activity_complete_modle_id")).intValue();
/*  60 */     this.activity_complete_name = rootElement.attributeValue("activity_complete_name");
/*     */     
/*  62 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "special_state_infos");
/*  63 */     if (collectionElement == null)
/*     */     {
/*  65 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  68 */     List<?> _nodeList = collectionElement.elements();
/*  69 */     int _len = _nodeList.size();
/*  70 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  72 */       Element elem = (Element)_nodeList.get(i);
/*  73 */       if (elem.getName().equalsIgnoreCase("mzm.gsp.planttree.confbean.SpecialStateInfo"))
/*     */       {
/*     */         SpecialStateInfo _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  80 */           _v_ = new SpecialStateInfo();
/*  81 */           _v_.loadFromXml(elem);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  88 */         this.special_state_infos.add(_v_);
/*     */       }
/*     */     }
/*  91 */     this.section_id = Integer.valueOf(rootElement.attributeValue("section_id")).intValue();
/*  92 */     this.section_total_point = Integer.valueOf(rootElement.attributeValue("section_total_point")).intValue();
/*  93 */     this.section_complete_award_id = Integer.valueOf(rootElement.attributeValue("section_complete_award_id")).intValue();
/*  94 */     this.section_modle_id = Integer.valueOf(rootElement.attributeValue("section_modle_id")).intValue();
/*  95 */     this.section_name = rootElement.attributeValue("section_name");
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/* 100 */     _os_.marshal(this.id);
/* 101 */     _os_.marshal(this.name, "UTF-8");
/* 102 */     _os_.marshal(this.desc, "UTF-8");
/* 103 */     _os_.marshal(this.activity_cfg_id);
/* 104 */     _os_.marshal(this.moduleid);
/* 105 */     _os_.marshal(this.activity_type);
/* 106 */     _os_.marshal(this.section_num);
/* 107 */     _os_.marshal(this.online_unit_interval);
/* 108 */     _os_.marshal(this.online_reward_max_point);
/* 109 */     _os_.marshal(this.activity_complete_award_id);
/* 110 */     _os_.marshal(this.add_point_max_times);
/* 111 */     _os_.marshal(this.special_state_refresh_interval);
/* 112 */     _os_.marshal(this.remove_special_state_award_max_times);
/* 113 */     _os_.marshal(this.remove_special_state_awardid);
/* 114 */     _os_.marshal(this.tips_content_id);
/* 115 */     _os_.marshal(this.activity_complete_modle_id);
/* 116 */     _os_.marshal(this.activity_complete_name, "UTF-8");
/* 117 */     _os_.compact_uint32(this.special_state_infos.size());
/* 118 */     for (SpecialStateInfo _v_ : this.special_state_infos)
/*     */     {
/* 120 */       _os_.marshal(_v_);
/*     */     }
/* 122 */     _os_.marshal(this.section_id);
/* 123 */     _os_.marshal(this.section_total_point);
/* 124 */     _os_.marshal(this.section_complete_award_id);
/* 125 */     _os_.marshal(this.section_modle_id);
/* 126 */     _os_.marshal(this.section_name, "UTF-8");
/* 127 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 132 */     this.id = _os_.unmarshal_int();
/* 133 */     this.name = _os_.unmarshal_String("UTF-8");
/* 134 */     this.desc = _os_.unmarshal_String("UTF-8");
/* 135 */     this.activity_cfg_id = _os_.unmarshal_int();
/* 136 */     this.moduleid = _os_.unmarshal_int();
/* 137 */     this.activity_type = _os_.unmarshal_int();
/* 138 */     this.section_num = _os_.unmarshal_int();
/* 139 */     this.online_unit_interval = _os_.unmarshal_int();
/* 140 */     this.online_reward_max_point = _os_.unmarshal_int();
/* 141 */     this.activity_complete_award_id = _os_.unmarshal_int();
/* 142 */     this.add_point_max_times = _os_.unmarshal_int();
/* 143 */     this.special_state_refresh_interval = _os_.unmarshal_int();
/* 144 */     this.remove_special_state_award_max_times = _os_.unmarshal_int();
/* 145 */     this.remove_special_state_awardid = _os_.unmarshal_int();
/* 146 */     this.tips_content_id = _os_.unmarshal_int();
/* 147 */     this.activity_complete_modle_id = _os_.unmarshal_int();
/* 148 */     this.activity_complete_name = _os_.unmarshal_String("UTF-8");
/* 149 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 152 */       SpecialStateInfo _v_ = new SpecialStateInfo();
/* 153 */       _v_.unmarshal(_os_);
/* 154 */       this.special_state_infos.add(_v_);
/*     */     }
/* 156 */     this.section_id = _os_.unmarshal_int();
/* 157 */     this.section_total_point = _os_.unmarshal_int();
/* 158 */     this.section_complete_award_id = _os_.unmarshal_int();
/* 159 */     this.section_modle_id = _os_.unmarshal_int();
/* 160 */     this.section_name = _os_.unmarshal_String("UTF-8");
/* 161 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 166 */     String path = dir + "mzm.gsp.planttree.confbean.PlantTreeCfgOriginal.xml";
/*     */     
/*     */     try
/*     */     {
/* 170 */       all = new java.util.HashMap();
/* 171 */       SAXReader reader = new SAXReader();
/* 172 */       org.dom4j.Document doc = reader.read(new File(path));
/* 173 */       Element root = doc.getRootElement();
/* 174 */       List<?> nodeList = root.elements();
/* 175 */       int len = nodeList.size();
/* 176 */       for (int i = 0; i < len; i++)
/*     */       {
/* 178 */         Element elem = (Element)nodeList.get(i);
/* 179 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.planttree.confbean.PlantTreeCfgOriginal"))
/*     */         {
/*     */ 
/* 182 */           PlantTreeCfgOriginal obj = new PlantTreeCfgOriginal();
/* 183 */           obj.loadFromXml(elem);
/* 184 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 185 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 190 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, PlantTreeCfgOriginal> all)
/*     */   {
/* 196 */     String path = dir + "mzm.gsp.planttree.confbean.PlantTreeCfgOriginal.xml";
/*     */     
/*     */     try
/*     */     {
/* 200 */       SAXReader reader = new SAXReader();
/* 201 */       org.dom4j.Document doc = reader.read(new File(path));
/* 202 */       Element root = doc.getRootElement();
/* 203 */       List<?> nodeList = root.elements();
/* 204 */       int len = nodeList.size();
/* 205 */       for (int i = 0; i < len; i++)
/*     */       {
/* 207 */         Element elem = (Element)nodeList.get(i);
/* 208 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.planttree.confbean.PlantTreeCfgOriginal"))
/*     */         {
/*     */ 
/* 211 */           PlantTreeCfgOriginal obj = new PlantTreeCfgOriginal();
/* 212 */           obj.loadFromXml(elem);
/* 213 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 214 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 219 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 225 */     all = new java.util.HashMap();
/*     */     
/* 227 */     String path = dir + "mzm.gsp.planttree.confbean.PlantTreeCfgOriginal.bny";
/*     */     try
/*     */     {
/* 230 */       File file = new File(path);
/* 231 */       if (file.exists())
/*     */       {
/* 233 */         byte[] bytes = new byte['Ѐ'];
/* 234 */         FileInputStream fis = new FileInputStream(file);
/* 235 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 236 */         int len = 0;
/* 237 */         while ((len = fis.read(bytes)) > 0)
/* 238 */           baos.write(bytes, 0, len);
/* 239 */         fis.close();
/* 240 */         bytes = baos.toByteArray();
/* 241 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 242 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 244 */           _os_.unmarshal_int();
/* 245 */           _os_.unmarshal_int();
/* 246 */           _os_.unmarshal_int();
/*     */         }
/* 248 */         _os_.unmarshal_int();
/* 249 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 252 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 254 */           PlantTreeCfgOriginal _v_ = new PlantTreeCfgOriginal();
/* 255 */           _v_.unmarshal(_os_);
/* 256 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 257 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 262 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 267 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, PlantTreeCfgOriginal> all)
/*     */   {
/* 274 */     String path = dir + "mzm.gsp.planttree.confbean.PlantTreeCfgOriginal.bny";
/*     */     try
/*     */     {
/* 277 */       File file = new File(path);
/* 278 */       if (file.exists())
/*     */       {
/* 280 */         byte[] bytes = new byte['Ѐ'];
/* 281 */         FileInputStream fis = new FileInputStream(file);
/* 282 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 283 */         int len = 0;
/* 284 */         while ((len = fis.read(bytes)) > 0)
/* 285 */           baos.write(bytes, 0, len);
/* 286 */         fis.close();
/* 287 */         bytes = baos.toByteArray();
/* 288 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 289 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 291 */           _os_.unmarshal_int();
/* 292 */           _os_.unmarshal_int();
/* 293 */           _os_.unmarshal_int();
/*     */         }
/* 295 */         _os_.unmarshal_int();
/* 296 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 299 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 301 */           PlantTreeCfgOriginal _v_ = new PlantTreeCfgOriginal();
/* 302 */           _v_.unmarshal(_os_);
/* 303 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 304 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 309 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 314 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static PlantTreeCfgOriginal getOld(int key)
/*     */   {
/* 322 */     return (PlantTreeCfgOriginal)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static PlantTreeCfgOriginal get(int key)
/*     */   {
/* 327 */     return (PlantTreeCfgOriginal)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, PlantTreeCfgOriginal> getOldAll()
/*     */   {
/* 332 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, PlantTreeCfgOriginal> getAll()
/*     */   {
/* 337 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, PlantTreeCfgOriginal> newAll)
/*     */   {
/* 342 */     oldAll = all;
/* 343 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 348 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\planttree\confbean\PlantTreeCfgOriginal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */