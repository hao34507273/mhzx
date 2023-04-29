/*     */ package mzm.gsp.treasurehunt.confbean;
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
/*     */ public class STreasureHuntCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, STreasureHuntCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, STreasureHuntCfg> all = null;
/*     */   
/*     */   public int activity_cfg_id;
/*     */   public int switch_type;
/*     */   public int npc_service_id;
/*     */   public int npc_id;
/*     */   public int npc_controller_id;
/*     */   public int out_map_cfg_id;
/*     */   public int out_position_x;
/*     */   public int out_position_y;
/*     */   public int map_item_handler_type;
/*     */   public int all_pass_chapter_award_id;
/*  28 */   public java.util.ArrayList<Integer> chapter_id_list = new java.util.ArrayList();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  32 */     this.activity_cfg_id = Integer.valueOf(rootElement.attributeValue("activity_cfg_id")).intValue();
/*  33 */     this.switch_type = Integer.valueOf(rootElement.attributeValue("switch_type")).intValue();
/*  34 */     this.npc_service_id = Integer.valueOf(rootElement.attributeValue("npc_service_id")).intValue();
/*  35 */     this.npc_id = Integer.valueOf(rootElement.attributeValue("npc_id")).intValue();
/*  36 */     this.npc_controller_id = Integer.valueOf(rootElement.attributeValue("npc_controller_id")).intValue();
/*  37 */     this.out_map_cfg_id = Integer.valueOf(rootElement.attributeValue("out_map_cfg_id")).intValue();
/*  38 */     this.out_position_x = Integer.valueOf(rootElement.attributeValue("out_position_x")).intValue();
/*  39 */     this.out_position_y = Integer.valueOf(rootElement.attributeValue("out_position_y")).intValue();
/*  40 */     this.map_item_handler_type = Integer.valueOf(rootElement.attributeValue("map_item_handler_type")).intValue();
/*  41 */     this.all_pass_chapter_award_id = Integer.valueOf(rootElement.attributeValue("all_pass_chapter_award_id")).intValue();
/*     */     
/*  43 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "chapter_id_list");
/*  44 */     if (collectionElement == null)
/*     */     {
/*  46 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  49 */     List<?> _nodeList = collectionElement.elements();
/*  50 */     int _len = _nodeList.size();
/*  51 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  53 */       Element elem = (Element)_nodeList.get(i);
/*  54 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  61 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  68 */         this.chapter_id_list.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  75 */     _os_.marshal(this.activity_cfg_id);
/*  76 */     _os_.marshal(this.switch_type);
/*  77 */     _os_.marshal(this.npc_service_id);
/*  78 */     _os_.marshal(this.npc_id);
/*  79 */     _os_.marshal(this.npc_controller_id);
/*  80 */     _os_.marshal(this.out_map_cfg_id);
/*  81 */     _os_.marshal(this.out_position_x);
/*  82 */     _os_.marshal(this.out_position_y);
/*  83 */     _os_.marshal(this.map_item_handler_type);
/*  84 */     _os_.marshal(this.all_pass_chapter_award_id);
/*  85 */     _os_.compact_uint32(this.chapter_id_list.size());
/*  86 */     for (Integer _v_ : this.chapter_id_list)
/*     */     {
/*  88 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  90 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  95 */     this.activity_cfg_id = _os_.unmarshal_int();
/*  96 */     this.switch_type = _os_.unmarshal_int();
/*  97 */     this.npc_service_id = _os_.unmarshal_int();
/*  98 */     this.npc_id = _os_.unmarshal_int();
/*  99 */     this.npc_controller_id = _os_.unmarshal_int();
/* 100 */     this.out_map_cfg_id = _os_.unmarshal_int();
/* 101 */     this.out_position_x = _os_.unmarshal_int();
/* 102 */     this.out_position_y = _os_.unmarshal_int();
/* 103 */     this.map_item_handler_type = _os_.unmarshal_int();
/* 104 */     this.all_pass_chapter_award_id = _os_.unmarshal_int();
/* 105 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 108 */       int _v_ = _os_.unmarshal_int();
/* 109 */       this.chapter_id_list.add(Integer.valueOf(_v_));
/*     */     }
/* 111 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 116 */     String path = dir + "mzm.gsp.treasurehunt.confbean.STreasureHuntCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 120 */       all = new java.util.HashMap();
/* 121 */       SAXReader reader = new SAXReader();
/* 122 */       org.dom4j.Document doc = reader.read(new File(path));
/* 123 */       Element root = doc.getRootElement();
/* 124 */       List<?> nodeList = root.elements();
/* 125 */       int len = nodeList.size();
/* 126 */       for (int i = 0; i < len; i++)
/*     */       {
/* 128 */         Element elem = (Element)nodeList.get(i);
/* 129 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.treasurehunt.confbean.STreasureHuntCfg"))
/*     */         {
/*     */ 
/* 132 */           STreasureHuntCfg obj = new STreasureHuntCfg();
/* 133 */           obj.loadFromXml(elem);
/* 134 */           if (all.put(Integer.valueOf(obj.activity_cfg_id), obj) != null) {
/* 135 */             throw new RuntimeException("duplicate key : " + obj.activity_cfg_id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 140 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, STreasureHuntCfg> all)
/*     */   {
/* 146 */     String path = dir + "mzm.gsp.treasurehunt.confbean.STreasureHuntCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 150 */       SAXReader reader = new SAXReader();
/* 151 */       org.dom4j.Document doc = reader.read(new File(path));
/* 152 */       Element root = doc.getRootElement();
/* 153 */       List<?> nodeList = root.elements();
/* 154 */       int len = nodeList.size();
/* 155 */       for (int i = 0; i < len; i++)
/*     */       {
/* 157 */         Element elem = (Element)nodeList.get(i);
/* 158 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.treasurehunt.confbean.STreasureHuntCfg"))
/*     */         {
/*     */ 
/* 161 */           STreasureHuntCfg obj = new STreasureHuntCfg();
/* 162 */           obj.loadFromXml(elem);
/* 163 */           if (all.put(Integer.valueOf(obj.activity_cfg_id), obj) != null) {
/* 164 */             throw new RuntimeException("duplicate key : " + obj.activity_cfg_id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 169 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 175 */     all = new java.util.HashMap();
/*     */     
/* 177 */     String path = dir + "mzm.gsp.treasurehunt.confbean.STreasureHuntCfg.bny";
/*     */     try
/*     */     {
/* 180 */       File file = new File(path);
/* 181 */       if (file.exists())
/*     */       {
/* 183 */         byte[] bytes = new byte['Ѐ'];
/* 184 */         FileInputStream fis = new FileInputStream(file);
/* 185 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 186 */         int len = 0;
/* 187 */         while ((len = fis.read(bytes)) > 0)
/* 188 */           baos.write(bytes, 0, len);
/* 189 */         fis.close();
/* 190 */         bytes = baos.toByteArray();
/* 191 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 192 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 194 */           _os_.unmarshal_int();
/* 195 */           _os_.unmarshal_int();
/* 196 */           _os_.unmarshal_int();
/*     */         }
/* 198 */         _os_.unmarshal_int();
/* 199 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 202 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 204 */           STreasureHuntCfg _v_ = new STreasureHuntCfg();
/* 205 */           _v_.unmarshal(_os_);
/* 206 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 207 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 212 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 217 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, STreasureHuntCfg> all)
/*     */   {
/* 224 */     String path = dir + "mzm.gsp.treasurehunt.confbean.STreasureHuntCfg.bny";
/*     */     try
/*     */     {
/* 227 */       File file = new File(path);
/* 228 */       if (file.exists())
/*     */       {
/* 230 */         byte[] bytes = new byte['Ѐ'];
/* 231 */         FileInputStream fis = new FileInputStream(file);
/* 232 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 233 */         int len = 0;
/* 234 */         while ((len = fis.read(bytes)) > 0)
/* 235 */           baos.write(bytes, 0, len);
/* 236 */         fis.close();
/* 237 */         bytes = baos.toByteArray();
/* 238 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 239 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 241 */           _os_.unmarshal_int();
/* 242 */           _os_.unmarshal_int();
/* 243 */           _os_.unmarshal_int();
/*     */         }
/* 245 */         _os_.unmarshal_int();
/* 246 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 249 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 251 */           STreasureHuntCfg _v_ = new STreasureHuntCfg();
/* 252 */           _v_.unmarshal(_os_);
/* 253 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 254 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 259 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 264 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static STreasureHuntCfg getOld(int key)
/*     */   {
/* 272 */     return (STreasureHuntCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static STreasureHuntCfg get(int key)
/*     */   {
/* 277 */     return (STreasureHuntCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, STreasureHuntCfg> getOldAll()
/*     */   {
/* 282 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, STreasureHuntCfg> getAll()
/*     */   {
/* 287 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, STreasureHuntCfg> newAll)
/*     */   {
/* 292 */     oldAll = all;
/* 293 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 298 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\treasurehunt\confbean\STreasureHuntCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */