/*     */ package mzm.gsp.crossbattle.confbean;
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
/*     */ public class CrossBattleRegisterCfgOriginal implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, CrossBattleRegisterCfgOriginal> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, CrossBattleRegisterCfgOriginal> all = null;
/*     */   
/*     */   public int id;
/*     */   public String desc;
/*     */   public int activity_cfg_id;
/*     */   public int moduleid;
/*     */   public int serverlevel;
/*     */   public int npc_id;
/*     */   public int npc_service_id;
/*     */   public int npc_controller_id;
/*     */   public int register_stage_moduleid;
/*     */   public int register_corps_member_num_lower_limit;
/*     */   public int register_corps_member_num_upper_limit;
/*     */   public int register_cost_type;
/*     */   public int register_cost_num;
/*     */   public int register_mail_cfg_id;
/*     */   public int active_unregister_mail_cfg_id;
/*     */   public int corps_member_num_dissatisfied_unregister_mail_cfg_id;
/*  34 */   public java.util.ArrayList<RegisterStageRemindTimePoint> register_stage_remind_time_points = new java.util.ArrayList();
/*     */   public String register_stage_remind_content;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  39 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  40 */     this.desc = rootElement.attributeValue("desc");
/*  41 */     this.activity_cfg_id = Integer.valueOf(rootElement.attributeValue("activity_cfg_id")).intValue();
/*  42 */     this.moduleid = Integer.valueOf(rootElement.attributeValue("moduleid")).intValue();
/*  43 */     this.serverlevel = Integer.valueOf(rootElement.attributeValue("serverlevel")).intValue();
/*  44 */     this.npc_id = Integer.valueOf(rootElement.attributeValue("npc_id")).intValue();
/*  45 */     this.npc_service_id = Integer.valueOf(rootElement.attributeValue("npc_service_id")).intValue();
/*  46 */     this.npc_controller_id = Integer.valueOf(rootElement.attributeValue("npc_controller_id")).intValue();
/*  47 */     this.register_stage_moduleid = Integer.valueOf(rootElement.attributeValue("register_stage_moduleid")).intValue();
/*  48 */     this.register_corps_member_num_lower_limit = Integer.valueOf(rootElement.attributeValue("register_corps_member_num_lower_limit")).intValue();
/*  49 */     this.register_corps_member_num_upper_limit = Integer.valueOf(rootElement.attributeValue("register_corps_member_num_upper_limit")).intValue();
/*  50 */     this.register_cost_type = Integer.valueOf(rootElement.attributeValue("register_cost_type")).intValue();
/*  51 */     this.register_cost_num = Integer.valueOf(rootElement.attributeValue("register_cost_num")).intValue();
/*  52 */     this.register_mail_cfg_id = Integer.valueOf(rootElement.attributeValue("register_mail_cfg_id")).intValue();
/*  53 */     this.active_unregister_mail_cfg_id = Integer.valueOf(rootElement.attributeValue("active_unregister_mail_cfg_id")).intValue();
/*  54 */     this.corps_member_num_dissatisfied_unregister_mail_cfg_id = Integer.valueOf(rootElement.attributeValue("corps_member_num_dissatisfied_unregister_mail_cfg_id")).intValue();
/*     */     
/*  56 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "register_stage_remind_time_points");
/*  57 */     if (collectionElement == null)
/*     */     {
/*  59 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  62 */     List<?> _nodeList = collectionElement.elements();
/*  63 */     int _len = _nodeList.size();
/*  64 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  66 */       Element elem = (Element)_nodeList.get(i);
/*  67 */       if (elem.getName().equalsIgnoreCase("mzm.gsp.crossbattle.confbean.RegisterStageRemindTimePoint"))
/*     */       {
/*     */         RegisterStageRemindTimePoint _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  74 */           _v_ = new RegisterStageRemindTimePoint();
/*  75 */           _v_.loadFromXml(elem);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  82 */         this.register_stage_remind_time_points.add(_v_);
/*     */       }
/*     */     }
/*  85 */     this.register_stage_remind_content = rootElement.attributeValue("register_stage_remind_content");
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  90 */     _os_.marshal(this.id);
/*  91 */     _os_.marshal(this.desc, "UTF-8");
/*  92 */     _os_.marshal(this.activity_cfg_id);
/*  93 */     _os_.marshal(this.moduleid);
/*  94 */     _os_.marshal(this.serverlevel);
/*  95 */     _os_.marshal(this.npc_id);
/*  96 */     _os_.marshal(this.npc_service_id);
/*  97 */     _os_.marshal(this.npc_controller_id);
/*  98 */     _os_.marshal(this.register_stage_moduleid);
/*  99 */     _os_.marshal(this.register_corps_member_num_lower_limit);
/* 100 */     _os_.marshal(this.register_corps_member_num_upper_limit);
/* 101 */     _os_.marshal(this.register_cost_type);
/* 102 */     _os_.marshal(this.register_cost_num);
/* 103 */     _os_.marshal(this.register_mail_cfg_id);
/* 104 */     _os_.marshal(this.active_unregister_mail_cfg_id);
/* 105 */     _os_.marshal(this.corps_member_num_dissatisfied_unregister_mail_cfg_id);
/* 106 */     _os_.compact_uint32(this.register_stage_remind_time_points.size());
/* 107 */     for (RegisterStageRemindTimePoint _v_ : this.register_stage_remind_time_points)
/*     */     {
/* 109 */       _os_.marshal(_v_);
/*     */     }
/* 111 */     _os_.marshal(this.register_stage_remind_content, "UTF-8");
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
/* 122 */     this.npc_id = _os_.unmarshal_int();
/* 123 */     this.npc_service_id = _os_.unmarshal_int();
/* 124 */     this.npc_controller_id = _os_.unmarshal_int();
/* 125 */     this.register_stage_moduleid = _os_.unmarshal_int();
/* 126 */     this.register_corps_member_num_lower_limit = _os_.unmarshal_int();
/* 127 */     this.register_corps_member_num_upper_limit = _os_.unmarshal_int();
/* 128 */     this.register_cost_type = _os_.unmarshal_int();
/* 129 */     this.register_cost_num = _os_.unmarshal_int();
/* 130 */     this.register_mail_cfg_id = _os_.unmarshal_int();
/* 131 */     this.active_unregister_mail_cfg_id = _os_.unmarshal_int();
/* 132 */     this.corps_member_num_dissatisfied_unregister_mail_cfg_id = _os_.unmarshal_int();
/* 133 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 136 */       RegisterStageRemindTimePoint _v_ = new RegisterStageRemindTimePoint();
/* 137 */       _v_.unmarshal(_os_);
/* 138 */       this.register_stage_remind_time_points.add(_v_);
/*     */     }
/* 140 */     this.register_stage_remind_content = _os_.unmarshal_String("UTF-8");
/* 141 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 146 */     String path = dir + "mzm.gsp.crossbattle.confbean.CrossBattleRegisterCfgOriginal.xml";
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
/* 159 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.crossbattle.confbean.CrossBattleRegisterCfgOriginal"))
/*     */         {
/*     */ 
/* 162 */           CrossBattleRegisterCfgOriginal obj = new CrossBattleRegisterCfgOriginal();
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
/*     */   public static void reLoadXml(String dir, Map<Integer, CrossBattleRegisterCfgOriginal> all)
/*     */   {
/* 176 */     String path = dir + "mzm.gsp.crossbattle.confbean.CrossBattleRegisterCfgOriginal.xml";
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
/* 188 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.crossbattle.confbean.CrossBattleRegisterCfgOriginal"))
/*     */         {
/*     */ 
/* 191 */           CrossBattleRegisterCfgOriginal obj = new CrossBattleRegisterCfgOriginal();
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
/* 207 */     String path = dir + "mzm.gsp.crossbattle.confbean.CrossBattleRegisterCfgOriginal.bny";
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
/* 234 */           CrossBattleRegisterCfgOriginal _v_ = new CrossBattleRegisterCfgOriginal();
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
/*     */   public static void reLoadBny(String dir, Map<Integer, CrossBattleRegisterCfgOriginal> all)
/*     */   {
/* 254 */     String path = dir + "mzm.gsp.crossbattle.confbean.CrossBattleRegisterCfgOriginal.bny";
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
/* 281 */           CrossBattleRegisterCfgOriginal _v_ = new CrossBattleRegisterCfgOriginal();
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
/*     */   public static CrossBattleRegisterCfgOriginal getOld(int key)
/*     */   {
/* 302 */     return (CrossBattleRegisterCfgOriginal)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static CrossBattleRegisterCfgOriginal get(int key)
/*     */   {
/* 307 */     return (CrossBattleRegisterCfgOriginal)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, CrossBattleRegisterCfgOriginal> getOldAll()
/*     */   {
/* 312 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, CrossBattleRegisterCfgOriginal> getAll()
/*     */   {
/* 317 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, CrossBattleRegisterCfgOriginal> newAll)
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


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\confbean\CrossBattleRegisterCfgOriginal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */