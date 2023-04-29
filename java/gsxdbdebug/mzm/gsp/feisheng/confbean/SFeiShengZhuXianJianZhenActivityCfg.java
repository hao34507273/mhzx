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
/*     */ public class SFeiShengZhuXianJianZhenActivityCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SFeiShengZhuXianJianZhenActivityCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SFeiShengZhuXianJianZhenActivityCfg> all = null;
/*     */   
/*     */   public int activity_cfg_id;
/*     */   public int moduleid;
/*     */   public int serverlevel;
/*     */   public int npc_id;
/*     */   public int npc_service_id;
/*     */   public int activity_map_cfg_id;
/*     */   public int activity_map_transfer_x;
/*     */   public int activity_map_transfer_y;
/*     */   public int out_map_cfg_id;
/*     */   public int out_map_transfer_x;
/*     */   public int out_map_transfer_y;
/*     */   public int award_id;
/*     */   public int daily_try_max_times;
/*     */   public int collect_item_tips_duration_in_second;
/*     */   public int collect_item_duration_in_second;
/*     */   public int commit_item_npc_controller_id;
/*     */   public int item_controller_id;
/*     */   public int item_refresh_num;
/*     */   public int commit_item_npc_id;
/*     */   public int commit_item_npc_service_id;
/*     */   public int commit_item_cfg_id;
/*     */   public int commit_item_num;
/*     */   public int collect_item_success_effect_duration;
/*     */   public int kill_monster_tips_duration_in_second;
/*     */   public int kill_monster_duration_in_second;
/*     */   public int monster_controller_id;
/*     */   public int monster_group_id;
/*     */   public int kill_monster_num;
/*     */   public int kill_monster_success_effect_duration;
/*     */   public int delay_leave_interval;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  51 */     this.activity_cfg_id = Integer.valueOf(rootElement.attributeValue("activity_cfg_id")).intValue();
/*  52 */     this.moduleid = Integer.valueOf(rootElement.attributeValue("moduleid")).intValue();
/*  53 */     this.serverlevel = Integer.valueOf(rootElement.attributeValue("serverlevel")).intValue();
/*  54 */     this.npc_id = Integer.valueOf(rootElement.attributeValue("npc_id")).intValue();
/*  55 */     this.npc_service_id = Integer.valueOf(rootElement.attributeValue("npc_service_id")).intValue();
/*  56 */     this.activity_map_cfg_id = Integer.valueOf(rootElement.attributeValue("activity_map_cfg_id")).intValue();
/*  57 */     this.activity_map_transfer_x = Integer.valueOf(rootElement.attributeValue("activity_map_transfer_x")).intValue();
/*  58 */     this.activity_map_transfer_y = Integer.valueOf(rootElement.attributeValue("activity_map_transfer_y")).intValue();
/*  59 */     this.out_map_cfg_id = Integer.valueOf(rootElement.attributeValue("out_map_cfg_id")).intValue();
/*  60 */     this.out_map_transfer_x = Integer.valueOf(rootElement.attributeValue("out_map_transfer_x")).intValue();
/*  61 */     this.out_map_transfer_y = Integer.valueOf(rootElement.attributeValue("out_map_transfer_y")).intValue();
/*  62 */     this.award_id = Integer.valueOf(rootElement.attributeValue("award_id")).intValue();
/*  63 */     this.daily_try_max_times = Integer.valueOf(rootElement.attributeValue("daily_try_max_times")).intValue();
/*  64 */     this.collect_item_tips_duration_in_second = Integer.valueOf(rootElement.attributeValue("collect_item_tips_duration_in_second")).intValue();
/*  65 */     this.collect_item_duration_in_second = Integer.valueOf(rootElement.attributeValue("collect_item_duration_in_second")).intValue();
/*  66 */     this.commit_item_npc_controller_id = Integer.valueOf(rootElement.attributeValue("commit_item_npc_controller_id")).intValue();
/*  67 */     this.item_controller_id = Integer.valueOf(rootElement.attributeValue("item_controller_id")).intValue();
/*  68 */     this.item_refresh_num = Integer.valueOf(rootElement.attributeValue("item_refresh_num")).intValue();
/*  69 */     this.commit_item_npc_id = Integer.valueOf(rootElement.attributeValue("commit_item_npc_id")).intValue();
/*  70 */     this.commit_item_npc_service_id = Integer.valueOf(rootElement.attributeValue("commit_item_npc_service_id")).intValue();
/*  71 */     this.commit_item_cfg_id = Integer.valueOf(rootElement.attributeValue("commit_item_cfg_id")).intValue();
/*  72 */     this.commit_item_num = Integer.valueOf(rootElement.attributeValue("commit_item_num")).intValue();
/*  73 */     this.collect_item_success_effect_duration = Integer.valueOf(rootElement.attributeValue("collect_item_success_effect_duration")).intValue();
/*  74 */     this.kill_monster_tips_duration_in_second = Integer.valueOf(rootElement.attributeValue("kill_monster_tips_duration_in_second")).intValue();
/*  75 */     this.kill_monster_duration_in_second = Integer.valueOf(rootElement.attributeValue("kill_monster_duration_in_second")).intValue();
/*  76 */     this.monster_controller_id = Integer.valueOf(rootElement.attributeValue("monster_controller_id")).intValue();
/*  77 */     this.monster_group_id = Integer.valueOf(rootElement.attributeValue("monster_group_id")).intValue();
/*  78 */     this.kill_monster_num = Integer.valueOf(rootElement.attributeValue("kill_monster_num")).intValue();
/*  79 */     this.kill_monster_success_effect_duration = Integer.valueOf(rootElement.attributeValue("kill_monster_success_effect_duration")).intValue();
/*  80 */     this.delay_leave_interval = Integer.valueOf(rootElement.attributeValue("delay_leave_interval")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  85 */     _os_.marshal(this.activity_cfg_id);
/*  86 */     _os_.marshal(this.moduleid);
/*  87 */     _os_.marshal(this.serverlevel);
/*  88 */     _os_.marshal(this.npc_id);
/*  89 */     _os_.marshal(this.npc_service_id);
/*  90 */     _os_.marshal(this.activity_map_cfg_id);
/*  91 */     _os_.marshal(this.activity_map_transfer_x);
/*  92 */     _os_.marshal(this.activity_map_transfer_y);
/*  93 */     _os_.marshal(this.out_map_cfg_id);
/*  94 */     _os_.marshal(this.out_map_transfer_x);
/*  95 */     _os_.marshal(this.out_map_transfer_y);
/*  96 */     _os_.marshal(this.award_id);
/*  97 */     _os_.marshal(this.daily_try_max_times);
/*  98 */     _os_.marshal(this.collect_item_tips_duration_in_second);
/*  99 */     _os_.marshal(this.collect_item_duration_in_second);
/* 100 */     _os_.marshal(this.commit_item_npc_controller_id);
/* 101 */     _os_.marshal(this.item_controller_id);
/* 102 */     _os_.marshal(this.item_refresh_num);
/* 103 */     _os_.marshal(this.commit_item_npc_id);
/* 104 */     _os_.marshal(this.commit_item_npc_service_id);
/* 105 */     _os_.marshal(this.commit_item_cfg_id);
/* 106 */     _os_.marshal(this.commit_item_num);
/* 107 */     _os_.marshal(this.collect_item_success_effect_duration);
/* 108 */     _os_.marshal(this.kill_monster_tips_duration_in_second);
/* 109 */     _os_.marshal(this.kill_monster_duration_in_second);
/* 110 */     _os_.marshal(this.monster_controller_id);
/* 111 */     _os_.marshal(this.monster_group_id);
/* 112 */     _os_.marshal(this.kill_monster_num);
/* 113 */     _os_.marshal(this.kill_monster_success_effect_duration);
/* 114 */     _os_.marshal(this.delay_leave_interval);
/* 115 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 120 */     this.activity_cfg_id = _os_.unmarshal_int();
/* 121 */     this.moduleid = _os_.unmarshal_int();
/* 122 */     this.serverlevel = _os_.unmarshal_int();
/* 123 */     this.npc_id = _os_.unmarshal_int();
/* 124 */     this.npc_service_id = _os_.unmarshal_int();
/* 125 */     this.activity_map_cfg_id = _os_.unmarshal_int();
/* 126 */     this.activity_map_transfer_x = _os_.unmarshal_int();
/* 127 */     this.activity_map_transfer_y = _os_.unmarshal_int();
/* 128 */     this.out_map_cfg_id = _os_.unmarshal_int();
/* 129 */     this.out_map_transfer_x = _os_.unmarshal_int();
/* 130 */     this.out_map_transfer_y = _os_.unmarshal_int();
/* 131 */     this.award_id = _os_.unmarshal_int();
/* 132 */     this.daily_try_max_times = _os_.unmarshal_int();
/* 133 */     this.collect_item_tips_duration_in_second = _os_.unmarshal_int();
/* 134 */     this.collect_item_duration_in_second = _os_.unmarshal_int();
/* 135 */     this.commit_item_npc_controller_id = _os_.unmarshal_int();
/* 136 */     this.item_controller_id = _os_.unmarshal_int();
/* 137 */     this.item_refresh_num = _os_.unmarshal_int();
/* 138 */     this.commit_item_npc_id = _os_.unmarshal_int();
/* 139 */     this.commit_item_npc_service_id = _os_.unmarshal_int();
/* 140 */     this.commit_item_cfg_id = _os_.unmarshal_int();
/* 141 */     this.commit_item_num = _os_.unmarshal_int();
/* 142 */     this.collect_item_success_effect_duration = _os_.unmarshal_int();
/* 143 */     this.kill_monster_tips_duration_in_second = _os_.unmarshal_int();
/* 144 */     this.kill_monster_duration_in_second = _os_.unmarshal_int();
/* 145 */     this.monster_controller_id = _os_.unmarshal_int();
/* 146 */     this.monster_group_id = _os_.unmarshal_int();
/* 147 */     this.kill_monster_num = _os_.unmarshal_int();
/* 148 */     this.kill_monster_success_effect_duration = _os_.unmarshal_int();
/* 149 */     this.delay_leave_interval = _os_.unmarshal_int();
/* 150 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 155 */     String path = dir + "mzm.gsp.feisheng.confbean.SFeiShengZhuXianJianZhenActivityCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 159 */       all = new java.util.HashMap();
/* 160 */       SAXReader reader = new SAXReader();
/* 161 */       org.dom4j.Document doc = reader.read(new File(path));
/* 162 */       Element root = doc.getRootElement();
/* 163 */       List<?> nodeList = root.elements();
/* 164 */       int len = nodeList.size();
/* 165 */       for (int i = 0; i < len; i++)
/*     */       {
/* 167 */         Element elem = (Element)nodeList.get(i);
/* 168 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.feisheng.confbean.SFeiShengZhuXianJianZhenActivityCfg"))
/*     */         {
/*     */ 
/* 171 */           SFeiShengZhuXianJianZhenActivityCfg obj = new SFeiShengZhuXianJianZhenActivityCfg();
/* 172 */           obj.loadFromXml(elem);
/* 173 */           if (all.put(Integer.valueOf(obj.activity_cfg_id), obj) != null) {
/* 174 */             throw new RuntimeException("duplicate key : " + obj.activity_cfg_id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 179 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SFeiShengZhuXianJianZhenActivityCfg> all)
/*     */   {
/* 185 */     String path = dir + "mzm.gsp.feisheng.confbean.SFeiShengZhuXianJianZhenActivityCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 189 */       SAXReader reader = new SAXReader();
/* 190 */       org.dom4j.Document doc = reader.read(new File(path));
/* 191 */       Element root = doc.getRootElement();
/* 192 */       List<?> nodeList = root.elements();
/* 193 */       int len = nodeList.size();
/* 194 */       for (int i = 0; i < len; i++)
/*     */       {
/* 196 */         Element elem = (Element)nodeList.get(i);
/* 197 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.feisheng.confbean.SFeiShengZhuXianJianZhenActivityCfg"))
/*     */         {
/*     */ 
/* 200 */           SFeiShengZhuXianJianZhenActivityCfg obj = new SFeiShengZhuXianJianZhenActivityCfg();
/* 201 */           obj.loadFromXml(elem);
/* 202 */           if (all.put(Integer.valueOf(obj.activity_cfg_id), obj) != null) {
/* 203 */             throw new RuntimeException("duplicate key : " + obj.activity_cfg_id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 208 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 214 */     all = new java.util.HashMap();
/*     */     
/* 216 */     String path = dir + "mzm.gsp.feisheng.confbean.SFeiShengZhuXianJianZhenActivityCfg.bny";
/*     */     try
/*     */     {
/* 219 */       File file = new File(path);
/* 220 */       if (file.exists())
/*     */       {
/* 222 */         byte[] bytes = new byte['Ѐ'];
/* 223 */         FileInputStream fis = new FileInputStream(file);
/* 224 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 225 */         int len = 0;
/* 226 */         while ((len = fis.read(bytes)) > 0)
/* 227 */           baos.write(bytes, 0, len);
/* 228 */         fis.close();
/* 229 */         bytes = baos.toByteArray();
/* 230 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 231 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 233 */           _os_.unmarshal_int();
/* 234 */           _os_.unmarshal_int();
/* 235 */           _os_.unmarshal_int();
/*     */         }
/* 237 */         _os_.unmarshal_int();
/* 238 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 241 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 243 */           SFeiShengZhuXianJianZhenActivityCfg _v_ = new SFeiShengZhuXianJianZhenActivityCfg();
/* 244 */           _v_.unmarshal(_os_);
/* 245 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 246 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 251 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 256 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SFeiShengZhuXianJianZhenActivityCfg> all)
/*     */   {
/* 263 */     String path = dir + "mzm.gsp.feisheng.confbean.SFeiShengZhuXianJianZhenActivityCfg.bny";
/*     */     try
/*     */     {
/* 266 */       File file = new File(path);
/* 267 */       if (file.exists())
/*     */       {
/* 269 */         byte[] bytes = new byte['Ѐ'];
/* 270 */         FileInputStream fis = new FileInputStream(file);
/* 271 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 272 */         int len = 0;
/* 273 */         while ((len = fis.read(bytes)) > 0)
/* 274 */           baos.write(bytes, 0, len);
/* 275 */         fis.close();
/* 276 */         bytes = baos.toByteArray();
/* 277 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 278 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 280 */           _os_.unmarshal_int();
/* 281 */           _os_.unmarshal_int();
/* 282 */           _os_.unmarshal_int();
/*     */         }
/* 284 */         _os_.unmarshal_int();
/* 285 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 288 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 290 */           SFeiShengZhuXianJianZhenActivityCfg _v_ = new SFeiShengZhuXianJianZhenActivityCfg();
/* 291 */           _v_.unmarshal(_os_);
/* 292 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 293 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 298 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 303 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SFeiShengZhuXianJianZhenActivityCfg getOld(int key)
/*     */   {
/* 311 */     return (SFeiShengZhuXianJianZhenActivityCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SFeiShengZhuXianJianZhenActivityCfg get(int key)
/*     */   {
/* 316 */     return (SFeiShengZhuXianJianZhenActivityCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SFeiShengZhuXianJianZhenActivityCfg> getOldAll()
/*     */   {
/* 321 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SFeiShengZhuXianJianZhenActivityCfg> getAll()
/*     */   {
/* 326 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SFeiShengZhuXianJianZhenActivityCfg> newAll)
/*     */   {
/* 331 */     oldAll = all;
/* 332 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 337 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\feisheng\confbean\SFeiShengZhuXianJianZhenActivityCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */