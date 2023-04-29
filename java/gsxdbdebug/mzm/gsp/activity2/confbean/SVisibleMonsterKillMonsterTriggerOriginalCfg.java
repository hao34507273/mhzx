/*     */ package mzm.gsp.activity2.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ 
/*     */ public class SVisibleMonsterKillMonsterTriggerOriginalCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SVisibleMonsterKillMonsterTriggerOriginalCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SVisibleMonsterKillMonsterTriggerOriginalCfg> all = null;
/*     */   
/*     */   public int id;
/*     */   public int activity_cfg_id;
/*     */   public int monster_type;
/*  21 */   public ArrayList<Integer> monster_category_id_list = new ArrayList();
/*     */   public int monster_kill_award_id;
/*     */   public int monster_kill_award_num;
/*     */   public int next_controller_need_kill_num;
/*  25 */   public ArrayList<ControllerId2Time> controller_id_list = new ArrayList();
/*  26 */   public ArrayList<ControllerId2Monster> controller_trigger_monster_id_list = new ArrayList();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  30 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  31 */     this.activity_cfg_id = Integer.valueOf(rootElement.attributeValue("activity_cfg_id")).intValue();
/*  32 */     this.monster_type = Integer.valueOf(rootElement.attributeValue("monster_type")).intValue();
/*     */     
/*  34 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "monster_category_id_list");
/*  35 */     if (collectionElement == null)
/*     */     {
/*  37 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  40 */     List<?> _nodeList = collectionElement.elements();
/*  41 */     int _len = _nodeList.size();
/*  42 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  44 */       Element elem = (Element)_nodeList.get(i);
/*  45 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  52 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  59 */         this.monster_category_id_list.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*  62 */     this.monster_kill_award_id = Integer.valueOf(rootElement.attributeValue("monster_kill_award_id")).intValue();
/*  63 */     this.monster_kill_award_num = Integer.valueOf(rootElement.attributeValue("monster_kill_award_num")).intValue();
/*  64 */     this.next_controller_need_kill_num = Integer.valueOf(rootElement.attributeValue("next_controller_need_kill_num")).intValue();
/*     */     
/*  66 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "controller_id_list");
/*  67 */     if (collectionElement == null)
/*     */     {
/*  69 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  72 */     List<?> _nodeList = collectionElement.elements();
/*  73 */     int _len = _nodeList.size();
/*  74 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  76 */       Element elem = (Element)_nodeList.get(i);
/*  77 */       if (elem.getName().equalsIgnoreCase("mzm.gsp.activity2.confbean.ControllerId2Time"))
/*     */       {
/*     */         ControllerId2Time _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  84 */           _v_ = new ControllerId2Time();
/*  85 */           _v_.loadFromXml(elem);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  92 */         this.controller_id_list.add(_v_);
/*     */       }
/*     */     }
/*     */     
/*  96 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "controller_trigger_monster_id_list");
/*  97 */     if (collectionElement == null)
/*     */     {
/*  99 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/* 102 */     List<?> _nodeList = collectionElement.elements();
/* 103 */     int _len = _nodeList.size();
/* 104 */     for (int i = 0; i < _len; i++)
/*     */     {
/* 106 */       Element elem = (Element)_nodeList.get(i);
/* 107 */       if (elem.getName().equalsIgnoreCase("mzm.gsp.activity2.confbean.ControllerId2Monster"))
/*     */       {
/*     */         ControllerId2Monster _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/* 114 */           _v_ = new ControllerId2Monster();
/* 115 */           _v_.loadFromXml(elem);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/* 122 */         this.controller_trigger_monster_id_list.add(_v_);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/* 129 */     _os_.marshal(this.id);
/* 130 */     _os_.marshal(this.activity_cfg_id);
/* 131 */     _os_.marshal(this.monster_type);
/* 132 */     _os_.compact_uint32(this.monster_category_id_list.size());
/* 133 */     for (Integer _v_ : this.monster_category_id_list)
/*     */     {
/* 135 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 137 */     _os_.marshal(this.monster_kill_award_id);
/* 138 */     _os_.marshal(this.monster_kill_award_num);
/* 139 */     _os_.marshal(this.next_controller_need_kill_num);
/* 140 */     _os_.compact_uint32(this.controller_id_list.size());
/* 141 */     for (ControllerId2Time _v_ : this.controller_id_list)
/*     */     {
/* 143 */       _os_.marshal(_v_);
/*     */     }
/* 145 */     _os_.compact_uint32(this.controller_trigger_monster_id_list.size());
/* 146 */     for (ControllerId2Monster _v_ : this.controller_trigger_monster_id_list)
/*     */     {
/* 148 */       _os_.marshal(_v_);
/*     */     }
/* 150 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 155 */     this.id = _os_.unmarshal_int();
/* 156 */     this.activity_cfg_id = _os_.unmarshal_int();
/* 157 */     this.monster_type = _os_.unmarshal_int();
/* 158 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 161 */       int _v_ = _os_.unmarshal_int();
/* 162 */       this.monster_category_id_list.add(Integer.valueOf(_v_));
/*     */     }
/* 164 */     this.monster_kill_award_id = _os_.unmarshal_int();
/* 165 */     this.monster_kill_award_num = _os_.unmarshal_int();
/* 166 */     this.next_controller_need_kill_num = _os_.unmarshal_int();
/* 167 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 170 */       ControllerId2Time _v_ = new ControllerId2Time();
/* 171 */       _v_.unmarshal(_os_);
/* 172 */       this.controller_id_list.add(_v_);
/*     */     }
/* 174 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 177 */       ControllerId2Monster _v_ = new ControllerId2Monster();
/* 178 */       _v_.unmarshal(_os_);
/* 179 */       this.controller_trigger_monster_id_list.add(_v_);
/*     */     }
/* 181 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 186 */     String path = dir + "mzm.gsp.activity2.confbean.SVisibleMonsterKillMonsterTriggerOriginalCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 190 */       all = new java.util.HashMap();
/* 191 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 192 */       org.dom4j.Document doc = reader.read(new File(path));
/* 193 */       Element root = doc.getRootElement();
/* 194 */       List<?> nodeList = root.elements();
/* 195 */       int len = nodeList.size();
/* 196 */       for (int i = 0; i < len; i++)
/*     */       {
/* 198 */         Element elem = (Element)nodeList.get(i);
/* 199 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.activity2.confbean.SVisibleMonsterKillMonsterTriggerOriginalCfg"))
/*     */         {
/*     */ 
/* 202 */           SVisibleMonsterKillMonsterTriggerOriginalCfg obj = new SVisibleMonsterKillMonsterTriggerOriginalCfg();
/* 203 */           obj.loadFromXml(elem);
/* 204 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 205 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 210 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SVisibleMonsterKillMonsterTriggerOriginalCfg> all)
/*     */   {
/* 216 */     String path = dir + "mzm.gsp.activity2.confbean.SVisibleMonsterKillMonsterTriggerOriginalCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 220 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 221 */       org.dom4j.Document doc = reader.read(new File(path));
/* 222 */       Element root = doc.getRootElement();
/* 223 */       List<?> nodeList = root.elements();
/* 224 */       int len = nodeList.size();
/* 225 */       for (int i = 0; i < len; i++)
/*     */       {
/* 227 */         Element elem = (Element)nodeList.get(i);
/* 228 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.activity2.confbean.SVisibleMonsterKillMonsterTriggerOriginalCfg"))
/*     */         {
/*     */ 
/* 231 */           SVisibleMonsterKillMonsterTriggerOriginalCfg obj = new SVisibleMonsterKillMonsterTriggerOriginalCfg();
/* 232 */           obj.loadFromXml(elem);
/* 233 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 234 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 239 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 245 */     all = new java.util.HashMap();
/*     */     
/* 247 */     String path = dir + "mzm.gsp.activity2.confbean.SVisibleMonsterKillMonsterTriggerOriginalCfg.bny";
/*     */     try
/*     */     {
/* 250 */       File file = new File(path);
/* 251 */       if (file.exists())
/*     */       {
/* 253 */         byte[] bytes = new byte['Ѐ'];
/* 254 */         FileInputStream fis = new FileInputStream(file);
/* 255 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 256 */         int len = 0;
/* 257 */         while ((len = fis.read(bytes)) > 0)
/* 258 */           baos.write(bytes, 0, len);
/* 259 */         fis.close();
/* 260 */         bytes = baos.toByteArray();
/* 261 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 262 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 264 */           _os_.unmarshal_int();
/* 265 */           _os_.unmarshal_int();
/* 266 */           _os_.unmarshal_int();
/*     */         }
/* 268 */         _os_.unmarshal_int();
/* 269 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 272 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 274 */           SVisibleMonsterKillMonsterTriggerOriginalCfg _v_ = new SVisibleMonsterKillMonsterTriggerOriginalCfg();
/* 275 */           _v_.unmarshal(_os_);
/* 276 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 277 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 282 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 287 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SVisibleMonsterKillMonsterTriggerOriginalCfg> all)
/*     */   {
/* 294 */     String path = dir + "mzm.gsp.activity2.confbean.SVisibleMonsterKillMonsterTriggerOriginalCfg.bny";
/*     */     try
/*     */     {
/* 297 */       File file = new File(path);
/* 298 */       if (file.exists())
/*     */       {
/* 300 */         byte[] bytes = new byte['Ѐ'];
/* 301 */         FileInputStream fis = new FileInputStream(file);
/* 302 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 303 */         int len = 0;
/* 304 */         while ((len = fis.read(bytes)) > 0)
/* 305 */           baos.write(bytes, 0, len);
/* 306 */         fis.close();
/* 307 */         bytes = baos.toByteArray();
/* 308 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 309 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 311 */           _os_.unmarshal_int();
/* 312 */           _os_.unmarshal_int();
/* 313 */           _os_.unmarshal_int();
/*     */         }
/* 315 */         _os_.unmarshal_int();
/* 316 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 319 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 321 */           SVisibleMonsterKillMonsterTriggerOriginalCfg _v_ = new SVisibleMonsterKillMonsterTriggerOriginalCfg();
/* 322 */           _v_.unmarshal(_os_);
/* 323 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 324 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 329 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 334 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SVisibleMonsterKillMonsterTriggerOriginalCfg getOld(int key)
/*     */   {
/* 342 */     return (SVisibleMonsterKillMonsterTriggerOriginalCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SVisibleMonsterKillMonsterTriggerOriginalCfg get(int key)
/*     */   {
/* 347 */     return (SVisibleMonsterKillMonsterTriggerOriginalCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SVisibleMonsterKillMonsterTriggerOriginalCfg> getOldAll()
/*     */   {
/* 352 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SVisibleMonsterKillMonsterTriggerOriginalCfg> getAll()
/*     */   {
/* 357 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SVisibleMonsterKillMonsterTriggerOriginalCfg> newAll)
/*     */   {
/* 362 */     oldAll = all;
/* 363 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 368 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity2\confbean\SVisibleMonsterKillMonsterTriggerOriginalCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */