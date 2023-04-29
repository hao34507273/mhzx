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
/*     */ public class STreasureHuntChapterCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, STreasureHuntChapterCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, STreasureHuntChapterCfg> all = null;
/*     */   
/*     */   public int id;
/*     */   public int map_cfg_id;
/*     */   public int treasure_hunt_time;
/*     */   public int pass_chapter_award_id;
/*     */   public int pass_chapter_effect_id;
/*  23 */   public java.util.LinkedList<ControllerId2Num> controllerList = new java.util.LinkedList();
/*     */   public int map_item_num;
/*     */   public int guarantee_num;
/*     */   public int class_id;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  30 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  31 */     this.map_cfg_id = Integer.valueOf(rootElement.attributeValue("map_cfg_id")).intValue();
/*  32 */     this.treasure_hunt_time = Integer.valueOf(rootElement.attributeValue("treasure_hunt_time")).intValue();
/*  33 */     this.pass_chapter_award_id = Integer.valueOf(rootElement.attributeValue("pass_chapter_award_id")).intValue();
/*  34 */     this.pass_chapter_effect_id = Integer.valueOf(rootElement.attributeValue("pass_chapter_effect_id")).intValue();
/*     */     
/*  36 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "controllerList");
/*  37 */     if (collectionElement == null)
/*     */     {
/*  39 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  42 */     List<?> _nodeList = collectionElement.elements();
/*  43 */     int _len = _nodeList.size();
/*  44 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  46 */       Element elem = (Element)_nodeList.get(i);
/*  47 */       if (elem.getName().equalsIgnoreCase("mzm.gsp.treasurehunt.confbean.ControllerId2Num"))
/*     */       {
/*     */         ControllerId2Num _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  54 */           _v_ = new ControllerId2Num();
/*  55 */           _v_.loadFromXml(elem);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  62 */         this.controllerList.add(_v_);
/*     */       }
/*     */     }
/*  65 */     this.map_item_num = Integer.valueOf(rootElement.attributeValue("map_item_num")).intValue();
/*  66 */     this.guarantee_num = Integer.valueOf(rootElement.attributeValue("guarantee_num")).intValue();
/*  67 */     this.class_id = Integer.valueOf(rootElement.attributeValue("class_id")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  72 */     _os_.marshal(this.id);
/*  73 */     _os_.marshal(this.map_cfg_id);
/*  74 */     _os_.marshal(this.treasure_hunt_time);
/*  75 */     _os_.marshal(this.pass_chapter_award_id);
/*  76 */     _os_.marshal(this.pass_chapter_effect_id);
/*  77 */     _os_.compact_uint32(this.controllerList.size());
/*  78 */     for (ControllerId2Num _v_ : this.controllerList)
/*     */     {
/*  80 */       _os_.marshal(_v_);
/*     */     }
/*  82 */     _os_.marshal(this.map_item_num);
/*  83 */     _os_.marshal(this.guarantee_num);
/*  84 */     _os_.marshal(this.class_id);
/*  85 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  90 */     this.id = _os_.unmarshal_int();
/*  91 */     this.map_cfg_id = _os_.unmarshal_int();
/*  92 */     this.treasure_hunt_time = _os_.unmarshal_int();
/*  93 */     this.pass_chapter_award_id = _os_.unmarshal_int();
/*  94 */     this.pass_chapter_effect_id = _os_.unmarshal_int();
/*  95 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/*  98 */       ControllerId2Num _v_ = new ControllerId2Num();
/*  99 */       _v_.unmarshal(_os_);
/* 100 */       this.controllerList.add(_v_);
/*     */     }
/* 102 */     this.map_item_num = _os_.unmarshal_int();
/* 103 */     this.guarantee_num = _os_.unmarshal_int();
/* 104 */     this.class_id = _os_.unmarshal_int();
/* 105 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 110 */     String path = dir + "mzm.gsp.treasurehunt.confbean.STreasureHuntChapterCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 114 */       all = new java.util.HashMap();
/* 115 */       SAXReader reader = new SAXReader();
/* 116 */       org.dom4j.Document doc = reader.read(new File(path));
/* 117 */       Element root = doc.getRootElement();
/* 118 */       List<?> nodeList = root.elements();
/* 119 */       int len = nodeList.size();
/* 120 */       for (int i = 0; i < len; i++)
/*     */       {
/* 122 */         Element elem = (Element)nodeList.get(i);
/* 123 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.treasurehunt.confbean.STreasureHuntChapterCfg"))
/*     */         {
/*     */ 
/* 126 */           STreasureHuntChapterCfg obj = new STreasureHuntChapterCfg();
/* 127 */           obj.loadFromXml(elem);
/* 128 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 129 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 134 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, STreasureHuntChapterCfg> all)
/*     */   {
/* 140 */     String path = dir + "mzm.gsp.treasurehunt.confbean.STreasureHuntChapterCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 144 */       SAXReader reader = new SAXReader();
/* 145 */       org.dom4j.Document doc = reader.read(new File(path));
/* 146 */       Element root = doc.getRootElement();
/* 147 */       List<?> nodeList = root.elements();
/* 148 */       int len = nodeList.size();
/* 149 */       for (int i = 0; i < len; i++)
/*     */       {
/* 151 */         Element elem = (Element)nodeList.get(i);
/* 152 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.treasurehunt.confbean.STreasureHuntChapterCfg"))
/*     */         {
/*     */ 
/* 155 */           STreasureHuntChapterCfg obj = new STreasureHuntChapterCfg();
/* 156 */           obj.loadFromXml(elem);
/* 157 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 158 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 163 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 169 */     all = new java.util.HashMap();
/*     */     
/* 171 */     String path = dir + "mzm.gsp.treasurehunt.confbean.STreasureHuntChapterCfg.bny";
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
/* 198 */           STreasureHuntChapterCfg _v_ = new STreasureHuntChapterCfg();
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
/*     */   public static void reLoadBny(String dir, Map<Integer, STreasureHuntChapterCfg> all)
/*     */   {
/* 218 */     String path = dir + "mzm.gsp.treasurehunt.confbean.STreasureHuntChapterCfg.bny";
/*     */     try
/*     */     {
/* 221 */       File file = new File(path);
/* 222 */       if (file.exists())
/*     */       {
/* 224 */         byte[] bytes = new byte['Ѐ'];
/* 225 */         FileInputStream fis = new FileInputStream(file);
/* 226 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 227 */         int len = 0;
/* 228 */         while ((len = fis.read(bytes)) > 0)
/* 229 */           baos.write(bytes, 0, len);
/* 230 */         fis.close();
/* 231 */         bytes = baos.toByteArray();
/* 232 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 233 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 235 */           _os_.unmarshal_int();
/* 236 */           _os_.unmarshal_int();
/* 237 */           _os_.unmarshal_int();
/*     */         }
/* 239 */         _os_.unmarshal_int();
/* 240 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 243 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 245 */           STreasureHuntChapterCfg _v_ = new STreasureHuntChapterCfg();
/* 246 */           _v_.unmarshal(_os_);
/* 247 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 248 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 253 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 258 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static STreasureHuntChapterCfg getOld(int key)
/*     */   {
/* 266 */     return (STreasureHuntChapterCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static STreasureHuntChapterCfg get(int key)
/*     */   {
/* 271 */     return (STreasureHuntChapterCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, STreasureHuntChapterCfg> getOldAll()
/*     */   {
/* 276 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, STreasureHuntChapterCfg> getAll()
/*     */   {
/* 281 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, STreasureHuntChapterCfg> newAll)
/*     */   {
/* 286 */     oldAll = all;
/* 287 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 292 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\treasurehunt\confbean\STreasureHuntChapterCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */