/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.MarshalException;
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.io.IOException;
/*      */ import java.util.HashMap;
/*      */ import java.util.HashSet;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import java.util.Set;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import ppbio.Message;
/*      */ import xbean.Pod;
/*      */ import xdb.Bean;
/*      */ import xdb.Consts;
/*      */ import xdb.Log;
/*      */ import xdb.LogKey;
/*      */ import xdb.Logs;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.Listenable;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableChanged;
/*      */ import xdb.logs.ListenableMap;
/*      */ import xdb.logs.ListenableSet;
/*      */ import xdb.logs.LogInt;
/*      */ import xdb.logs.LogLong;
/*      */ import xdb.util.SetX;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public final class Properties
/*      */   extends XBean
/*      */   implements xbean.Properties
/*      */ {
/*      */   private int level;
/*      */   private int exp;
/*      */   private int hp;
/*      */   private int mp;
/*      */   private int anger;
/*      */   private int vigor;
/*      */   private HashMap<Integer, xbean.BasicPropertiesSystem> propertysysmap;
/*      */   private int activitybpsys;
/*      */   private int todaypropsysswitchcount;
/*      */   private long timestamp;
/*      */   private xbean.Location location;
/*      */   private long gold;
/*      */   private long silver;
/*      */   private long goldingot;
/*      */   private int dyecolorid;
/*      */   private int baoshidu;
/*      */   private long lastlogintime;
/*      */   private long lastlogofftime;
/*      */   private long keeponlinetime;
/*      */   private int fightvalue;
/*      */   private long leveluptime;
/*      */   private long accumulateleveluptime;
/*      */   private long vigorrefreshtime;
/*      */   private int convertxiulianexp;
/*      */   private SetX<Long> compensates;
/*      */   private HashMap<Integer, xbean.GatherMapItemInfo> gather_map_item_infos;
/*      */   private long lastcalcuatetime;
/*      */   private int dayonlineseconds;
/*      */   private long onlineseconds;
/*      */   private int send_recharge_times_tip_mail_no;
/*      */   private long levelupcurtime;
/*      */   private HashMap<Integer, xbean.TransferOccupationPropertiesSys> transfer_occupation_property_sys_map;
/*      */   private HashMap<Integer, xbean.CoinInfo> coins;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   82 */     this.level = 0;
/*   83 */     this.exp = 0;
/*   84 */     this.hp = 0;
/*   85 */     this.mp = 0;
/*   86 */     this.anger = 0;
/*   87 */     this.vigor = 0;
/*   88 */     this.propertysysmap.clear();
/*   89 */     this.activitybpsys = 0;
/*   90 */     this.todaypropsysswitchcount = 0;
/*   91 */     this.timestamp = 0L;
/*   92 */     this.location._reset_unsafe_();
/*   93 */     this.gold = 0L;
/*   94 */     this.silver = 0L;
/*   95 */     this.goldingot = 0L;
/*   96 */     this.dyecolorid = 0;
/*   97 */     this.baoshidu = 0;
/*   98 */     this.lastlogintime = 0L;
/*   99 */     this.lastlogofftime = 0L;
/*  100 */     this.keeponlinetime = 0L;
/*  101 */     this.fightvalue = 0;
/*  102 */     this.leveluptime = 0L;
/*  103 */     this.accumulateleveluptime = 0L;
/*  104 */     this.vigorrefreshtime = 0L;
/*  105 */     this.convertxiulianexp = 0;
/*  106 */     this.compensates.clear();
/*  107 */     this.gather_map_item_infos.clear();
/*  108 */     this.lastcalcuatetime = 0L;
/*  109 */     this.dayonlineseconds = 0;
/*  110 */     this.onlineseconds = 0L;
/*  111 */     this.send_recharge_times_tip_mail_no = 0;
/*  112 */     this.levelupcurtime = 0L;
/*  113 */     this.transfer_occupation_property_sys_map.clear();
/*  114 */     this.coins.clear();
/*      */   }
/*      */   
/*      */   Properties(int __, XBean _xp_, String _vn_)
/*      */   {
/*  119 */     super(_xp_, _vn_);
/*  120 */     this.level = 0;
/*  121 */     this.exp = 0;
/*  122 */     this.hp = 0;
/*  123 */     this.mp = 0;
/*  124 */     this.anger = 0;
/*  125 */     this.vigor = 0;
/*  126 */     this.propertysysmap = new HashMap();
/*  127 */     this.location = new Location(0, this, "location");
/*  128 */     this.compensates = new SetX();
/*  129 */     this.gather_map_item_infos = new HashMap();
/*  130 */     this.send_recharge_times_tip_mail_no = 0;
/*  131 */     this.transfer_occupation_property_sys_map = new HashMap();
/*  132 */     this.coins = new HashMap();
/*      */   }
/*      */   
/*      */   public Properties()
/*      */   {
/*  137 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public Properties(Properties _o_)
/*      */   {
/*  142 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   Properties(xbean.Properties _o1_, XBean _xp_, String _vn_)
/*      */   {
/*  147 */     super(_xp_, _vn_);
/*  148 */     if ((_o1_ instanceof Properties)) { assign((Properties)_o1_);
/*  149 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  150 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  151 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(Properties _o_) {
/*  156 */     _o_._xdb_verify_unsafe_();
/*  157 */     this.level = _o_.level;
/*  158 */     this.exp = _o_.exp;
/*  159 */     this.hp = _o_.hp;
/*  160 */     this.mp = _o_.mp;
/*  161 */     this.anger = _o_.anger;
/*  162 */     this.vigor = _o_.vigor;
/*  163 */     this.propertysysmap = new HashMap();
/*  164 */     for (Map.Entry<Integer, xbean.BasicPropertiesSystem> _e_ : _o_.propertysysmap.entrySet())
/*  165 */       this.propertysysmap.put(_e_.getKey(), new BasicPropertiesSystem((xbean.BasicPropertiesSystem)_e_.getValue(), this, "propertysysmap"));
/*  166 */     this.activitybpsys = _o_.activitybpsys;
/*  167 */     this.todaypropsysswitchcount = _o_.todaypropsysswitchcount;
/*  168 */     this.timestamp = _o_.timestamp;
/*  169 */     this.location = new Location(_o_.location, this, "location");
/*  170 */     this.gold = _o_.gold;
/*  171 */     this.silver = _o_.silver;
/*  172 */     this.goldingot = _o_.goldingot;
/*  173 */     this.dyecolorid = _o_.dyecolorid;
/*  174 */     this.baoshidu = _o_.baoshidu;
/*  175 */     this.lastlogintime = _o_.lastlogintime;
/*  176 */     this.lastlogofftime = _o_.lastlogofftime;
/*  177 */     this.keeponlinetime = _o_.keeponlinetime;
/*  178 */     this.fightvalue = _o_.fightvalue;
/*  179 */     this.leveluptime = _o_.leveluptime;
/*  180 */     this.accumulateleveluptime = _o_.accumulateleveluptime;
/*  181 */     this.vigorrefreshtime = _o_.vigorrefreshtime;
/*  182 */     this.convertxiulianexp = _o_.convertxiulianexp;
/*  183 */     this.compensates = new SetX();
/*  184 */     this.compensates.addAll(_o_.compensates);
/*  185 */     this.gather_map_item_infos = new HashMap();
/*  186 */     for (Map.Entry<Integer, xbean.GatherMapItemInfo> _e_ : _o_.gather_map_item_infos.entrySet())
/*  187 */       this.gather_map_item_infos.put(_e_.getKey(), new GatherMapItemInfo((xbean.GatherMapItemInfo)_e_.getValue(), this, "gather_map_item_infos"));
/*  188 */     this.lastcalcuatetime = _o_.lastcalcuatetime;
/*  189 */     this.dayonlineseconds = _o_.dayonlineseconds;
/*  190 */     this.onlineseconds = _o_.onlineseconds;
/*  191 */     this.send_recharge_times_tip_mail_no = _o_.send_recharge_times_tip_mail_no;
/*  192 */     this.levelupcurtime = _o_.levelupcurtime;
/*  193 */     this.transfer_occupation_property_sys_map = new HashMap();
/*  194 */     for (Map.Entry<Integer, xbean.TransferOccupationPropertiesSys> _e_ : _o_.transfer_occupation_property_sys_map.entrySet())
/*  195 */       this.transfer_occupation_property_sys_map.put(_e_.getKey(), new TransferOccupationPropertiesSys((xbean.TransferOccupationPropertiesSys)_e_.getValue(), this, "transfer_occupation_property_sys_map"));
/*  196 */     this.coins = new HashMap();
/*  197 */     for (Map.Entry<Integer, xbean.CoinInfo> _e_ : _o_.coins.entrySet()) {
/*  198 */       this.coins.put(_e_.getKey(), new CoinInfo((xbean.CoinInfo)_e_.getValue(), this, "coins"));
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(Data _o_) {
/*  203 */     this.level = _o_.level;
/*  204 */     this.exp = _o_.exp;
/*  205 */     this.hp = _o_.hp;
/*  206 */     this.mp = _o_.mp;
/*  207 */     this.anger = _o_.anger;
/*  208 */     this.vigor = _o_.vigor;
/*  209 */     this.propertysysmap = new HashMap();
/*  210 */     for (Map.Entry<Integer, xbean.BasicPropertiesSystem> _e_ : _o_.propertysysmap.entrySet())
/*  211 */       this.propertysysmap.put(_e_.getKey(), new BasicPropertiesSystem((xbean.BasicPropertiesSystem)_e_.getValue(), this, "propertysysmap"));
/*  212 */     this.activitybpsys = _o_.activitybpsys;
/*  213 */     this.todaypropsysswitchcount = _o_.todaypropsysswitchcount;
/*  214 */     this.timestamp = _o_.timestamp;
/*  215 */     this.location = new Location(_o_.location, this, "location");
/*  216 */     this.gold = _o_.gold;
/*  217 */     this.silver = _o_.silver;
/*  218 */     this.goldingot = _o_.goldingot;
/*  219 */     this.dyecolorid = _o_.dyecolorid;
/*  220 */     this.baoshidu = _o_.baoshidu;
/*  221 */     this.lastlogintime = _o_.lastlogintime;
/*  222 */     this.lastlogofftime = _o_.lastlogofftime;
/*  223 */     this.keeponlinetime = _o_.keeponlinetime;
/*  224 */     this.fightvalue = _o_.fightvalue;
/*  225 */     this.leveluptime = _o_.leveluptime;
/*  226 */     this.accumulateleveluptime = _o_.accumulateleveluptime;
/*  227 */     this.vigorrefreshtime = _o_.vigorrefreshtime;
/*  228 */     this.convertxiulianexp = _o_.convertxiulianexp;
/*  229 */     this.compensates = new SetX();
/*  230 */     this.compensates.addAll(_o_.compensates);
/*  231 */     this.gather_map_item_infos = new HashMap();
/*  232 */     for (Map.Entry<Integer, xbean.GatherMapItemInfo> _e_ : _o_.gather_map_item_infos.entrySet())
/*  233 */       this.gather_map_item_infos.put(_e_.getKey(), new GatherMapItemInfo((xbean.GatherMapItemInfo)_e_.getValue(), this, "gather_map_item_infos"));
/*  234 */     this.lastcalcuatetime = _o_.lastcalcuatetime;
/*  235 */     this.dayonlineseconds = _o_.dayonlineseconds;
/*  236 */     this.onlineseconds = _o_.onlineseconds;
/*  237 */     this.send_recharge_times_tip_mail_no = _o_.send_recharge_times_tip_mail_no;
/*  238 */     this.levelupcurtime = _o_.levelupcurtime;
/*  239 */     this.transfer_occupation_property_sys_map = new HashMap();
/*  240 */     for (Map.Entry<Integer, xbean.TransferOccupationPropertiesSys> _e_ : _o_.transfer_occupation_property_sys_map.entrySet())
/*  241 */       this.transfer_occupation_property_sys_map.put(_e_.getKey(), new TransferOccupationPropertiesSys((xbean.TransferOccupationPropertiesSys)_e_.getValue(), this, "transfer_occupation_property_sys_map"));
/*  242 */     this.coins = new HashMap();
/*  243 */     for (Map.Entry<Integer, xbean.CoinInfo> _e_ : _o_.coins.entrySet()) {
/*  244 */       this.coins.put(_e_.getKey(), new CoinInfo((xbean.CoinInfo)_e_.getValue(), this, "coins"));
/*      */     }
/*      */   }
/*      */   
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*  250 */     _xdb_verify_unsafe_();
/*  251 */     _os_.marshal(this.level);
/*  252 */     _os_.marshal(this.exp);
/*  253 */     _os_.marshal(this.hp);
/*  254 */     _os_.marshal(this.mp);
/*  255 */     _os_.marshal(this.anger);
/*  256 */     _os_.marshal(this.vigor);
/*  257 */     _os_.compact_uint32(this.propertysysmap.size());
/*  258 */     for (Map.Entry<Integer, xbean.BasicPropertiesSystem> _e_ : this.propertysysmap.entrySet())
/*      */     {
/*  260 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  261 */       ((xbean.BasicPropertiesSystem)_e_.getValue()).marshal(_os_);
/*      */     }
/*  263 */     _os_.marshal(this.activitybpsys);
/*  264 */     _os_.marshal(this.todaypropsysswitchcount);
/*  265 */     _os_.marshal(this.timestamp);
/*  266 */     this.location.marshal(_os_);
/*  267 */     _os_.marshal(this.gold);
/*  268 */     _os_.marshal(this.silver);
/*  269 */     _os_.marshal(this.goldingot);
/*  270 */     _os_.marshal(this.dyecolorid);
/*  271 */     _os_.marshal(this.baoshidu);
/*  272 */     _os_.marshal(this.lastlogintime);
/*  273 */     _os_.marshal(this.lastlogofftime);
/*  274 */     _os_.marshal(this.keeponlinetime);
/*  275 */     _os_.marshal(this.fightvalue);
/*  276 */     _os_.marshal(this.leveluptime);
/*  277 */     _os_.marshal(this.accumulateleveluptime);
/*  278 */     _os_.marshal(this.vigorrefreshtime);
/*  279 */     _os_.marshal(this.convertxiulianexp);
/*  280 */     _os_.compact_uint32(this.compensates.size());
/*  281 */     for (Long _v_ : this.compensates)
/*      */     {
/*  283 */       _os_.marshal(_v_.longValue());
/*      */     }
/*  285 */     _os_.compact_uint32(this.gather_map_item_infos.size());
/*  286 */     for (Map.Entry<Integer, xbean.GatherMapItemInfo> _e_ : this.gather_map_item_infos.entrySet())
/*      */     {
/*  288 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  289 */       ((xbean.GatherMapItemInfo)_e_.getValue()).marshal(_os_);
/*      */     }
/*  291 */     _os_.marshal(this.lastcalcuatetime);
/*  292 */     _os_.marshal(this.dayonlineseconds);
/*  293 */     _os_.marshal(this.onlineseconds);
/*  294 */     _os_.marshal(this.send_recharge_times_tip_mail_no);
/*  295 */     _os_.marshal(this.levelupcurtime);
/*  296 */     _os_.compact_uint32(this.transfer_occupation_property_sys_map.size());
/*  297 */     for (Map.Entry<Integer, xbean.TransferOccupationPropertiesSys> _e_ : this.transfer_occupation_property_sys_map.entrySet())
/*      */     {
/*  299 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  300 */       ((xbean.TransferOccupationPropertiesSys)_e_.getValue()).marshal(_os_);
/*      */     }
/*  302 */     _os_.compact_uint32(this.coins.size());
/*  303 */     for (Map.Entry<Integer, xbean.CoinInfo> _e_ : this.coins.entrySet())
/*      */     {
/*  305 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  306 */       ((xbean.CoinInfo)_e_.getValue()).marshal(_os_);
/*      */     }
/*  308 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws MarshalException
/*      */   {
/*  314 */     _xdb_verify_unsafe_();
/*  315 */     this.level = _os_.unmarshal_int();
/*  316 */     this.exp = _os_.unmarshal_int();
/*  317 */     this.hp = _os_.unmarshal_int();
/*  318 */     this.mp = _os_.unmarshal_int();
/*  319 */     this.anger = _os_.unmarshal_int();
/*  320 */     this.vigor = _os_.unmarshal_int();
/*      */     
/*  322 */     int size = _os_.uncompact_uint32();
/*  323 */     if (size >= 12)
/*      */     {
/*  325 */       this.propertysysmap = new HashMap(size * 2);
/*      */     }
/*  327 */     for (; size > 0; size--)
/*      */     {
/*  329 */       int _k_ = 0;
/*  330 */       _k_ = _os_.unmarshal_int();
/*  331 */       xbean.BasicPropertiesSystem _v_ = new BasicPropertiesSystem(0, this, "propertysysmap");
/*  332 */       _v_.unmarshal(_os_);
/*  333 */       this.propertysysmap.put(Integer.valueOf(_k_), _v_);
/*      */     }
/*      */     
/*  336 */     this.activitybpsys = _os_.unmarshal_int();
/*  337 */     this.todaypropsysswitchcount = _os_.unmarshal_int();
/*  338 */     this.timestamp = _os_.unmarshal_long();
/*  339 */     this.location.unmarshal(_os_);
/*  340 */     this.gold = _os_.unmarshal_long();
/*  341 */     this.silver = _os_.unmarshal_long();
/*  342 */     this.goldingot = _os_.unmarshal_long();
/*  343 */     this.dyecolorid = _os_.unmarshal_int();
/*  344 */     this.baoshidu = _os_.unmarshal_int();
/*  345 */     this.lastlogintime = _os_.unmarshal_long();
/*  346 */     this.lastlogofftime = _os_.unmarshal_long();
/*  347 */     this.keeponlinetime = _os_.unmarshal_long();
/*  348 */     this.fightvalue = _os_.unmarshal_int();
/*  349 */     this.leveluptime = _os_.unmarshal_long();
/*  350 */     this.accumulateleveluptime = _os_.unmarshal_long();
/*  351 */     this.vigorrefreshtime = _os_.unmarshal_long();
/*  352 */     this.convertxiulianexp = _os_.unmarshal_int();
/*  353 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  355 */       long _v_ = 0L;
/*  356 */       _v_ = _os_.unmarshal_long();
/*  357 */       this.compensates.add(Long.valueOf(_v_));
/*      */     }
/*      */     
/*  360 */     int size = _os_.uncompact_uint32();
/*  361 */     if (size >= 12)
/*      */     {
/*  363 */       this.gather_map_item_infos = new HashMap(size * 2);
/*      */     }
/*  365 */     for (; size > 0; size--)
/*      */     {
/*  367 */       int _k_ = 0;
/*  368 */       _k_ = _os_.unmarshal_int();
/*  369 */       xbean.GatherMapItemInfo _v_ = new GatherMapItemInfo(0, this, "gather_map_item_infos");
/*  370 */       _v_.unmarshal(_os_);
/*  371 */       this.gather_map_item_infos.put(Integer.valueOf(_k_), _v_);
/*      */     }
/*      */     
/*  374 */     this.lastcalcuatetime = _os_.unmarshal_long();
/*  375 */     this.dayonlineseconds = _os_.unmarshal_int();
/*  376 */     this.onlineseconds = _os_.unmarshal_long();
/*  377 */     this.send_recharge_times_tip_mail_no = _os_.unmarshal_int();
/*  378 */     this.levelupcurtime = _os_.unmarshal_long();
/*      */     
/*  380 */     int size = _os_.uncompact_uint32();
/*  381 */     if (size >= 12)
/*      */     {
/*  383 */       this.transfer_occupation_property_sys_map = new HashMap(size * 2);
/*      */     }
/*  385 */     for (; size > 0; size--)
/*      */     {
/*  387 */       int _k_ = 0;
/*  388 */       _k_ = _os_.unmarshal_int();
/*  389 */       xbean.TransferOccupationPropertiesSys _v_ = new TransferOccupationPropertiesSys(0, this, "transfer_occupation_property_sys_map");
/*  390 */       _v_.unmarshal(_os_);
/*  391 */       this.transfer_occupation_property_sys_map.put(Integer.valueOf(_k_), _v_);
/*      */     }
/*      */     
/*      */ 
/*  395 */     int size = _os_.uncompact_uint32();
/*  396 */     if (size >= 12)
/*      */     {
/*  398 */       this.coins = new HashMap(size * 2);
/*      */     }
/*  400 */     for (; size > 0; size--)
/*      */     {
/*  402 */       int _k_ = 0;
/*  403 */       _k_ = _os_.unmarshal_int();
/*  404 */       xbean.CoinInfo _v_ = new CoinInfo(0, this, "coins");
/*  405 */       _v_.unmarshal(_os_);
/*  406 */       this.coins.put(Integer.valueOf(_k_), _v_);
/*      */     }
/*      */     
/*  409 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  415 */     _xdb_verify_unsafe_();
/*  416 */     int _size_ = 0;
/*  417 */     _size_ += CodedOutputStream.computeInt32Size(1, this.level);
/*  418 */     _size_ += CodedOutputStream.computeInt32Size(2, this.exp);
/*  419 */     _size_ += CodedOutputStream.computeInt32Size(3, this.hp);
/*  420 */     _size_ += CodedOutputStream.computeInt32Size(4, this.mp);
/*  421 */     _size_ += CodedOutputStream.computeInt32Size(5, this.anger);
/*  422 */     _size_ += CodedOutputStream.computeInt32Size(6, this.vigor);
/*  423 */     for (Map.Entry<Integer, xbean.BasicPropertiesSystem> _e_ : this.propertysysmap.entrySet())
/*      */     {
/*  425 */       _size_ += CodedOutputStream.computeInt32Size(7, ((Integer)_e_.getKey()).intValue());
/*  426 */       _size_ += CodedOutputStream.computeMessageSize(7, (Message)_e_.getValue());
/*      */     }
/*  428 */     _size_ += CodedOutputStream.computeInt32Size(8, this.activitybpsys);
/*  429 */     _size_ += CodedOutputStream.computeInt32Size(9, this.todaypropsysswitchcount);
/*  430 */     _size_ += CodedOutputStream.computeInt64Size(10, this.timestamp);
/*  431 */     _size_ += CodedOutputStream.computeMessageSize(11, this.location);
/*  432 */     _size_ += CodedOutputStream.computeInt64Size(12, this.gold);
/*  433 */     _size_ += CodedOutputStream.computeInt64Size(13, this.silver);
/*  434 */     _size_ += CodedOutputStream.computeInt64Size(14, this.goldingot);
/*  435 */     _size_ += CodedOutputStream.computeInt32Size(15, this.dyecolorid);
/*  436 */     _size_ += CodedOutputStream.computeInt32Size(16, this.baoshidu);
/*  437 */     _size_ += CodedOutputStream.computeInt64Size(17, this.lastlogintime);
/*  438 */     _size_ += CodedOutputStream.computeInt64Size(18, this.lastlogofftime);
/*  439 */     _size_ += CodedOutputStream.computeInt64Size(19, this.keeponlinetime);
/*  440 */     _size_ += CodedOutputStream.computeInt32Size(20, this.fightvalue);
/*  441 */     _size_ += CodedOutputStream.computeInt64Size(21, this.leveluptime);
/*  442 */     _size_ += CodedOutputStream.computeInt64Size(22, this.accumulateleveluptime);
/*  443 */     _size_ += CodedOutputStream.computeInt64Size(23, this.vigorrefreshtime);
/*  444 */     _size_ += CodedOutputStream.computeInt32Size(24, this.convertxiulianexp);
/*  445 */     for (Long _v_ : this.compensates)
/*      */     {
/*  447 */       _size_ += CodedOutputStream.computeInt64Size(25, _v_.longValue());
/*      */     }
/*  449 */     for (Map.Entry<Integer, xbean.GatherMapItemInfo> _e_ : this.gather_map_item_infos.entrySet())
/*      */     {
/*  451 */       _size_ += CodedOutputStream.computeInt32Size(26, ((Integer)_e_.getKey()).intValue());
/*  452 */       _size_ += CodedOutputStream.computeMessageSize(26, (Message)_e_.getValue());
/*      */     }
/*  454 */     _size_ += CodedOutputStream.computeInt64Size(27, this.lastcalcuatetime);
/*  455 */     _size_ += CodedOutputStream.computeInt32Size(28, this.dayonlineseconds);
/*  456 */     _size_ += CodedOutputStream.computeInt64Size(29, this.onlineseconds);
/*  457 */     _size_ += CodedOutputStream.computeInt32Size(30, this.send_recharge_times_tip_mail_no);
/*  458 */     _size_ += CodedOutputStream.computeInt64Size(31, this.levelupcurtime);
/*  459 */     for (Map.Entry<Integer, xbean.TransferOccupationPropertiesSys> _e_ : this.transfer_occupation_property_sys_map.entrySet())
/*      */     {
/*  461 */       _size_ += CodedOutputStream.computeInt32Size(32, ((Integer)_e_.getKey()).intValue());
/*  462 */       _size_ += CodedOutputStream.computeMessageSize(32, (Message)_e_.getValue());
/*      */     }
/*  464 */     for (Map.Entry<Integer, xbean.CoinInfo> _e_ : this.coins.entrySet())
/*      */     {
/*  466 */       _size_ += CodedOutputStream.computeInt32Size(33, ((Integer)_e_.getKey()).intValue());
/*  467 */       _size_ += CodedOutputStream.computeMessageSize(33, (Message)_e_.getValue());
/*      */     }
/*  469 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  475 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  478 */       _output_.writeInt32(1, this.level);
/*  479 */       _output_.writeInt32(2, this.exp);
/*  480 */       _output_.writeInt32(3, this.hp);
/*  481 */       _output_.writeInt32(4, this.mp);
/*  482 */       _output_.writeInt32(5, this.anger);
/*  483 */       _output_.writeInt32(6, this.vigor);
/*  484 */       for (Map.Entry<Integer, xbean.BasicPropertiesSystem> _e_ : this.propertysysmap.entrySet())
/*      */       {
/*  486 */         _output_.writeInt32(7, ((Integer)_e_.getKey()).intValue());
/*  487 */         _output_.writeMessage(7, (Message)_e_.getValue());
/*      */       }
/*  489 */       _output_.writeInt32(8, this.activitybpsys);
/*  490 */       _output_.writeInt32(9, this.todaypropsysswitchcount);
/*  491 */       _output_.writeInt64(10, this.timestamp);
/*  492 */       _output_.writeMessage(11, this.location);
/*  493 */       _output_.writeInt64(12, this.gold);
/*  494 */       _output_.writeInt64(13, this.silver);
/*  495 */       _output_.writeInt64(14, this.goldingot);
/*  496 */       _output_.writeInt32(15, this.dyecolorid);
/*  497 */       _output_.writeInt32(16, this.baoshidu);
/*  498 */       _output_.writeInt64(17, this.lastlogintime);
/*  499 */       _output_.writeInt64(18, this.lastlogofftime);
/*  500 */       _output_.writeInt64(19, this.keeponlinetime);
/*  501 */       _output_.writeInt32(20, this.fightvalue);
/*  502 */       _output_.writeInt64(21, this.leveluptime);
/*  503 */       _output_.writeInt64(22, this.accumulateleveluptime);
/*  504 */       _output_.writeInt64(23, this.vigorrefreshtime);
/*  505 */       _output_.writeInt32(24, this.convertxiulianexp);
/*  506 */       for (Long _v_ : this.compensates)
/*      */       {
/*  508 */         _output_.writeInt64(25, _v_.longValue());
/*      */       }
/*  510 */       for (Map.Entry<Integer, xbean.GatherMapItemInfo> _e_ : this.gather_map_item_infos.entrySet())
/*      */       {
/*  512 */         _output_.writeInt32(26, ((Integer)_e_.getKey()).intValue());
/*  513 */         _output_.writeMessage(26, (Message)_e_.getValue());
/*      */       }
/*  515 */       _output_.writeInt64(27, this.lastcalcuatetime);
/*  516 */       _output_.writeInt32(28, this.dayonlineseconds);
/*  517 */       _output_.writeInt64(29, this.onlineseconds);
/*  518 */       _output_.writeInt32(30, this.send_recharge_times_tip_mail_no);
/*  519 */       _output_.writeInt64(31, this.levelupcurtime);
/*  520 */       for (Map.Entry<Integer, xbean.TransferOccupationPropertiesSys> _e_ : this.transfer_occupation_property_sys_map.entrySet())
/*      */       {
/*  522 */         _output_.writeInt32(32, ((Integer)_e_.getKey()).intValue());
/*  523 */         _output_.writeMessage(32, (Message)_e_.getValue());
/*      */       }
/*  525 */       for (Map.Entry<Integer, xbean.CoinInfo> _e_ : this.coins.entrySet())
/*      */       {
/*  527 */         _output_.writeInt32(33, ((Integer)_e_.getKey()).intValue());
/*  528 */         _output_.writeMessage(33, (Message)_e_.getValue());
/*      */       }
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  533 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  535 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  541 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  544 */       boolean done = false;
/*  545 */       while (!done)
/*      */       {
/*  547 */         int tag = _input_.readTag();
/*  548 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  552 */           done = true;
/*  553 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  557 */           this.level = _input_.readInt32();
/*  558 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  562 */           this.exp = _input_.readInt32();
/*  563 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  567 */           this.hp = _input_.readInt32();
/*  568 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  572 */           this.mp = _input_.readInt32();
/*  573 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  577 */           this.anger = _input_.readInt32();
/*  578 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  582 */           this.vigor = _input_.readInt32();
/*  583 */           break;
/*      */         
/*      */ 
/*      */         case 56: 
/*  587 */           int _k_ = 0;
/*  588 */           _k_ = _input_.readInt32();
/*  589 */           int readTag = _input_.readTag();
/*  590 */           if (58 != readTag)
/*      */           {
/*  592 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  594 */           xbean.BasicPropertiesSystem _v_ = new BasicPropertiesSystem(0, this, "propertysysmap");
/*  595 */           _input_.readMessage(_v_);
/*  596 */           this.propertysysmap.put(Integer.valueOf(_k_), _v_);
/*  597 */           break;
/*      */         
/*      */ 
/*      */         case 64: 
/*  601 */           this.activitybpsys = _input_.readInt32();
/*  602 */           break;
/*      */         
/*      */ 
/*      */         case 72: 
/*  606 */           this.todaypropsysswitchcount = _input_.readInt32();
/*  607 */           break;
/*      */         
/*      */ 
/*      */         case 80: 
/*  611 */           this.timestamp = _input_.readInt64();
/*  612 */           break;
/*      */         
/*      */ 
/*      */         case 90: 
/*  616 */           _input_.readMessage(this.location);
/*  617 */           break;
/*      */         
/*      */ 
/*      */         case 96: 
/*  621 */           this.gold = _input_.readInt64();
/*  622 */           break;
/*      */         
/*      */ 
/*      */         case 104: 
/*  626 */           this.silver = _input_.readInt64();
/*  627 */           break;
/*      */         
/*      */ 
/*      */         case 112: 
/*  631 */           this.goldingot = _input_.readInt64();
/*  632 */           break;
/*      */         
/*      */ 
/*      */         case 120: 
/*  636 */           this.dyecolorid = _input_.readInt32();
/*  637 */           break;
/*      */         
/*      */ 
/*      */         case 128: 
/*  641 */           this.baoshidu = _input_.readInt32();
/*  642 */           break;
/*      */         
/*      */ 
/*      */         case 136: 
/*  646 */           this.lastlogintime = _input_.readInt64();
/*  647 */           break;
/*      */         
/*      */ 
/*      */         case 144: 
/*  651 */           this.lastlogofftime = _input_.readInt64();
/*  652 */           break;
/*      */         
/*      */ 
/*      */         case 152: 
/*  656 */           this.keeponlinetime = _input_.readInt64();
/*  657 */           break;
/*      */         
/*      */ 
/*      */         case 160: 
/*  661 */           this.fightvalue = _input_.readInt32();
/*  662 */           break;
/*      */         
/*      */ 
/*      */         case 168: 
/*  666 */           this.leveluptime = _input_.readInt64();
/*  667 */           break;
/*      */         
/*      */ 
/*      */         case 176: 
/*  671 */           this.accumulateleveluptime = _input_.readInt64();
/*  672 */           break;
/*      */         
/*      */ 
/*      */         case 184: 
/*  676 */           this.vigorrefreshtime = _input_.readInt64();
/*  677 */           break;
/*      */         
/*      */ 
/*      */         case 192: 
/*  681 */           this.convertxiulianexp = _input_.readInt32();
/*  682 */           break;
/*      */         
/*      */ 
/*      */         case 200: 
/*  686 */           long _v_ = 0L;
/*  687 */           _v_ = _input_.readInt64();
/*  688 */           this.compensates.add(Long.valueOf(_v_));
/*  689 */           break;
/*      */         
/*      */ 
/*      */         case 208: 
/*  693 */           int _k_ = 0;
/*  694 */           _k_ = _input_.readInt32();
/*  695 */           int readTag = _input_.readTag();
/*  696 */           if (210 != readTag)
/*      */           {
/*  698 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  700 */           xbean.GatherMapItemInfo _v_ = new GatherMapItemInfo(0, this, "gather_map_item_infos");
/*  701 */           _input_.readMessage(_v_);
/*  702 */           this.gather_map_item_infos.put(Integer.valueOf(_k_), _v_);
/*  703 */           break;
/*      */         
/*      */ 
/*      */         case 216: 
/*  707 */           this.lastcalcuatetime = _input_.readInt64();
/*  708 */           break;
/*      */         
/*      */ 
/*      */         case 224: 
/*  712 */           this.dayonlineseconds = _input_.readInt32();
/*  713 */           break;
/*      */         
/*      */ 
/*      */         case 232: 
/*  717 */           this.onlineseconds = _input_.readInt64();
/*  718 */           break;
/*      */         
/*      */ 
/*      */         case 240: 
/*  722 */           this.send_recharge_times_tip_mail_no = _input_.readInt32();
/*  723 */           break;
/*      */         
/*      */ 
/*      */         case 248: 
/*  727 */           this.levelupcurtime = _input_.readInt64();
/*  728 */           break;
/*      */         
/*      */ 
/*      */         case 256: 
/*  732 */           int _k_ = 0;
/*  733 */           _k_ = _input_.readInt32();
/*  734 */           int readTag = _input_.readTag();
/*  735 */           if (258 != readTag)
/*      */           {
/*  737 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  739 */           xbean.TransferOccupationPropertiesSys _v_ = new TransferOccupationPropertiesSys(0, this, "transfer_occupation_property_sys_map");
/*  740 */           _input_.readMessage(_v_);
/*  741 */           this.transfer_occupation_property_sys_map.put(Integer.valueOf(_k_), _v_);
/*  742 */           break;
/*      */         
/*      */ 
/*      */         case 264: 
/*  746 */           int _k_ = 0;
/*  747 */           _k_ = _input_.readInt32();
/*  748 */           int readTag = _input_.readTag();
/*  749 */           if (266 != readTag)
/*      */           {
/*  751 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  753 */           xbean.CoinInfo _v_ = new CoinInfo(0, this, "coins");
/*  754 */           _input_.readMessage(_v_);
/*  755 */           this.coins.put(Integer.valueOf(_k_), _v_);
/*  756 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  760 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  762 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  771 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  775 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  777 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.Properties copy()
/*      */   {
/*  783 */     _xdb_verify_unsafe_();
/*  784 */     return new Properties(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.Properties toData()
/*      */   {
/*  790 */     _xdb_verify_unsafe_();
/*  791 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.Properties toBean()
/*      */   {
/*  796 */     _xdb_verify_unsafe_();
/*  797 */     return new Properties(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.Properties toDataIf()
/*      */   {
/*  803 */     _xdb_verify_unsafe_();
/*  804 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.Properties toBeanIf()
/*      */   {
/*  809 */     _xdb_verify_unsafe_();
/*  810 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public Bean toConst()
/*      */   {
/*  816 */     _xdb_verify_unsafe_();
/*  817 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getLevel()
/*      */   {
/*  824 */     _xdb_verify_unsafe_();
/*  825 */     return this.level;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getExp()
/*      */   {
/*  832 */     _xdb_verify_unsafe_();
/*  833 */     return this.exp;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getHp()
/*      */   {
/*  840 */     _xdb_verify_unsafe_();
/*  841 */     return this.hp;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getMp()
/*      */   {
/*  848 */     _xdb_verify_unsafe_();
/*  849 */     return this.mp;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getAnger()
/*      */   {
/*  856 */     _xdb_verify_unsafe_();
/*  857 */     return this.anger;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getVigor()
/*      */   {
/*  864 */     _xdb_verify_unsafe_();
/*  865 */     return this.vigor;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.BasicPropertiesSystem> getPropertysysmap()
/*      */   {
/*  872 */     _xdb_verify_unsafe_();
/*  873 */     return Logs.logMap(new LogKey(this, "propertysysmap"), this.propertysysmap);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.BasicPropertiesSystem> getPropertysysmapAsData()
/*      */   {
/*  880 */     _xdb_verify_unsafe_();
/*      */     
/*  882 */     Properties _o_ = this;
/*  883 */     Map<Integer, xbean.BasicPropertiesSystem> propertysysmap = new HashMap();
/*  884 */     for (Map.Entry<Integer, xbean.BasicPropertiesSystem> _e_ : _o_.propertysysmap.entrySet())
/*  885 */       propertysysmap.put(_e_.getKey(), new BasicPropertiesSystem.Data((xbean.BasicPropertiesSystem)_e_.getValue()));
/*  886 */     return propertysysmap;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getActivitybpsys()
/*      */   {
/*  893 */     _xdb_verify_unsafe_();
/*  894 */     return this.activitybpsys;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getTodaypropsysswitchcount()
/*      */   {
/*  901 */     _xdb_verify_unsafe_();
/*  902 */     return this.todaypropsysswitchcount;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getTimestamp()
/*      */   {
/*  909 */     _xdb_verify_unsafe_();
/*  910 */     return this.timestamp;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public xbean.Location getLocation()
/*      */   {
/*  917 */     _xdb_verify_unsafe_();
/*  918 */     return this.location;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getGold()
/*      */   {
/*  925 */     _xdb_verify_unsafe_();
/*  926 */     return this.gold;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getSilver()
/*      */   {
/*  933 */     _xdb_verify_unsafe_();
/*  934 */     return this.silver;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getGoldingot()
/*      */   {
/*  941 */     _xdb_verify_unsafe_();
/*  942 */     return this.goldingot;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getDyecolorid()
/*      */   {
/*  949 */     _xdb_verify_unsafe_();
/*  950 */     return this.dyecolorid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getBaoshidu()
/*      */   {
/*  957 */     _xdb_verify_unsafe_();
/*  958 */     return this.baoshidu;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getLastlogintime()
/*      */   {
/*  965 */     _xdb_verify_unsafe_();
/*  966 */     return this.lastlogintime;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getLastlogofftime()
/*      */   {
/*  973 */     _xdb_verify_unsafe_();
/*  974 */     return this.lastlogofftime;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getKeeponlinetime()
/*      */   {
/*  981 */     _xdb_verify_unsafe_();
/*  982 */     return this.keeponlinetime;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getFightvalue()
/*      */   {
/*  989 */     _xdb_verify_unsafe_();
/*  990 */     return this.fightvalue;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getLeveluptime()
/*      */   {
/*  997 */     _xdb_verify_unsafe_();
/*  998 */     return this.leveluptime;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getAccumulateleveluptime()
/*      */   {
/* 1005 */     _xdb_verify_unsafe_();
/* 1006 */     return this.accumulateleveluptime;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getVigorrefreshtime()
/*      */   {
/* 1013 */     _xdb_verify_unsafe_();
/* 1014 */     return this.vigorrefreshtime;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getConvertxiulianexp()
/*      */   {
/* 1021 */     _xdb_verify_unsafe_();
/* 1022 */     return this.convertxiulianexp;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Set<Long> getCompensates()
/*      */   {
/* 1029 */     _xdb_verify_unsafe_();
/* 1030 */     return Logs.logSet(new LogKey(this, "compensates"), this.compensates);
/*      */   }
/*      */   
/*      */ 
/*      */   public Set<Long> getCompensatesAsData()
/*      */   {
/* 1036 */     _xdb_verify_unsafe_();
/*      */     
/* 1038 */     Properties _o_ = this;
/* 1039 */     Set<Long> compensates = new SetX();
/* 1040 */     compensates.addAll(_o_.compensates);
/* 1041 */     return compensates;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.GatherMapItemInfo> getGather_map_item_infos()
/*      */   {
/* 1048 */     _xdb_verify_unsafe_();
/* 1049 */     return Logs.logMap(new LogKey(this, "gather_map_item_infos"), this.gather_map_item_infos);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.GatherMapItemInfo> getGather_map_item_infosAsData()
/*      */   {
/* 1056 */     _xdb_verify_unsafe_();
/*      */     
/* 1058 */     Properties _o_ = this;
/* 1059 */     Map<Integer, xbean.GatherMapItemInfo> gather_map_item_infos = new HashMap();
/* 1060 */     for (Map.Entry<Integer, xbean.GatherMapItemInfo> _e_ : _o_.gather_map_item_infos.entrySet())
/* 1061 */       gather_map_item_infos.put(_e_.getKey(), new GatherMapItemInfo.Data((xbean.GatherMapItemInfo)_e_.getValue()));
/* 1062 */     return gather_map_item_infos;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getLastcalcuatetime()
/*      */   {
/* 1069 */     _xdb_verify_unsafe_();
/* 1070 */     return this.lastcalcuatetime;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getDayonlineseconds()
/*      */   {
/* 1077 */     _xdb_verify_unsafe_();
/* 1078 */     return this.dayonlineseconds;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getOnlineseconds()
/*      */   {
/* 1085 */     _xdb_verify_unsafe_();
/* 1086 */     return this.onlineseconds;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getSend_recharge_times_tip_mail_no()
/*      */   {
/* 1093 */     _xdb_verify_unsafe_();
/* 1094 */     return this.send_recharge_times_tip_mail_no;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getLevelupcurtime()
/*      */   {
/* 1101 */     _xdb_verify_unsafe_();
/* 1102 */     return this.levelupcurtime;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.TransferOccupationPropertiesSys> getTransfer_occupation_property_sys_map()
/*      */   {
/* 1109 */     _xdb_verify_unsafe_();
/* 1110 */     return Logs.logMap(new LogKey(this, "transfer_occupation_property_sys_map"), this.transfer_occupation_property_sys_map);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.TransferOccupationPropertiesSys> getTransfer_occupation_property_sys_mapAsData()
/*      */   {
/* 1117 */     _xdb_verify_unsafe_();
/*      */     
/* 1119 */     Properties _o_ = this;
/* 1120 */     Map<Integer, xbean.TransferOccupationPropertiesSys> transfer_occupation_property_sys_map = new HashMap();
/* 1121 */     for (Map.Entry<Integer, xbean.TransferOccupationPropertiesSys> _e_ : _o_.transfer_occupation_property_sys_map.entrySet())
/* 1122 */       transfer_occupation_property_sys_map.put(_e_.getKey(), new TransferOccupationPropertiesSys.Data((xbean.TransferOccupationPropertiesSys)_e_.getValue()));
/* 1123 */     return transfer_occupation_property_sys_map;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.CoinInfo> getCoins()
/*      */   {
/* 1130 */     _xdb_verify_unsafe_();
/* 1131 */     return Logs.logMap(new LogKey(this, "coins"), this.coins);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.CoinInfo> getCoinsAsData()
/*      */   {
/* 1138 */     _xdb_verify_unsafe_();
/*      */     
/* 1140 */     Properties _o_ = this;
/* 1141 */     Map<Integer, xbean.CoinInfo> coins = new HashMap();
/* 1142 */     for (Map.Entry<Integer, xbean.CoinInfo> _e_ : _o_.coins.entrySet())
/* 1143 */       coins.put(_e_.getKey(), new CoinInfo.Data((xbean.CoinInfo)_e_.getValue()));
/* 1144 */     return coins;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setLevel(int _v_)
/*      */   {
/* 1151 */     _xdb_verify_unsafe_();
/* 1152 */     Logs.logIf(new LogKey(this, "level")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1156 */         new LogInt(this, Properties.this.level)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1160 */             Properties.this.level = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1164 */     });
/* 1165 */     this.level = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setExp(int _v_)
/*      */   {
/* 1172 */     _xdb_verify_unsafe_();
/* 1173 */     Logs.logIf(new LogKey(this, "exp")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1177 */         new LogInt(this, Properties.this.exp)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1181 */             Properties.this.exp = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1185 */     });
/* 1186 */     this.exp = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setHp(int _v_)
/*      */   {
/* 1193 */     _xdb_verify_unsafe_();
/* 1194 */     Logs.logIf(new LogKey(this, "hp")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1198 */         new LogInt(this, Properties.this.hp)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1202 */             Properties.this.hp = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1206 */     });
/* 1207 */     this.hp = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setMp(int _v_)
/*      */   {
/* 1214 */     _xdb_verify_unsafe_();
/* 1215 */     Logs.logIf(new LogKey(this, "mp")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1219 */         new LogInt(this, Properties.this.mp)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1223 */             Properties.this.mp = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1227 */     });
/* 1228 */     this.mp = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setAnger(int _v_)
/*      */   {
/* 1235 */     _xdb_verify_unsafe_();
/* 1236 */     Logs.logIf(new LogKey(this, "anger")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1240 */         new LogInt(this, Properties.this.anger)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1244 */             Properties.this.anger = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1248 */     });
/* 1249 */     this.anger = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setVigor(int _v_)
/*      */   {
/* 1256 */     _xdb_verify_unsafe_();
/* 1257 */     Logs.logIf(new LogKey(this, "vigor")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1261 */         new LogInt(this, Properties.this.vigor)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1265 */             Properties.this.vigor = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1269 */     });
/* 1270 */     this.vigor = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setActivitybpsys(int _v_)
/*      */   {
/* 1277 */     _xdb_verify_unsafe_();
/* 1278 */     Logs.logIf(new LogKey(this, "activitybpsys")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1282 */         new LogInt(this, Properties.this.activitybpsys)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1286 */             Properties.this.activitybpsys = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1290 */     });
/* 1291 */     this.activitybpsys = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setTodaypropsysswitchcount(int _v_)
/*      */   {
/* 1298 */     _xdb_verify_unsafe_();
/* 1299 */     Logs.logIf(new LogKey(this, "todaypropsysswitchcount")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1303 */         new LogInt(this, Properties.this.todaypropsysswitchcount)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1307 */             Properties.this.todaypropsysswitchcount = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1311 */     });
/* 1312 */     this.todaypropsysswitchcount = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setTimestamp(long _v_)
/*      */   {
/* 1319 */     _xdb_verify_unsafe_();
/* 1320 */     Logs.logIf(new LogKey(this, "timestamp")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1324 */         new LogLong(this, Properties.this.timestamp)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1328 */             Properties.this.timestamp = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1332 */     });
/* 1333 */     this.timestamp = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setGold(long _v_)
/*      */   {
/* 1340 */     _xdb_verify_unsafe_();
/* 1341 */     Logs.logIf(new LogKey(this, "gold")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1345 */         new LogLong(this, Properties.this.gold)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1349 */             Properties.this.gold = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1353 */     });
/* 1354 */     this.gold = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setSilver(long _v_)
/*      */   {
/* 1361 */     _xdb_verify_unsafe_();
/* 1362 */     Logs.logIf(new LogKey(this, "silver")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1366 */         new LogLong(this, Properties.this.silver)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1370 */             Properties.this.silver = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1374 */     });
/* 1375 */     this.silver = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setGoldingot(long _v_)
/*      */   {
/* 1382 */     _xdb_verify_unsafe_();
/* 1383 */     Logs.logIf(new LogKey(this, "goldingot")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1387 */         new LogLong(this, Properties.this.goldingot)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1391 */             Properties.this.goldingot = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1395 */     });
/* 1396 */     this.goldingot = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setDyecolorid(int _v_)
/*      */   {
/* 1403 */     _xdb_verify_unsafe_();
/* 1404 */     Logs.logIf(new LogKey(this, "dyecolorid")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1408 */         new LogInt(this, Properties.this.dyecolorid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1412 */             Properties.this.dyecolorid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1416 */     });
/* 1417 */     this.dyecolorid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setBaoshidu(int _v_)
/*      */   {
/* 1424 */     _xdb_verify_unsafe_();
/* 1425 */     Logs.logIf(new LogKey(this, "baoshidu")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1429 */         new LogInt(this, Properties.this.baoshidu)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1433 */             Properties.this.baoshidu = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1437 */     });
/* 1438 */     this.baoshidu = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setLastlogintime(long _v_)
/*      */   {
/* 1445 */     _xdb_verify_unsafe_();
/* 1446 */     Logs.logIf(new LogKey(this, "lastlogintime")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1450 */         new LogLong(this, Properties.this.lastlogintime)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1454 */             Properties.this.lastlogintime = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1458 */     });
/* 1459 */     this.lastlogintime = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setLastlogofftime(long _v_)
/*      */   {
/* 1466 */     _xdb_verify_unsafe_();
/* 1467 */     Logs.logIf(new LogKey(this, "lastlogofftime")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1471 */         new LogLong(this, Properties.this.lastlogofftime)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1475 */             Properties.this.lastlogofftime = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1479 */     });
/* 1480 */     this.lastlogofftime = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setKeeponlinetime(long _v_)
/*      */   {
/* 1487 */     _xdb_verify_unsafe_();
/* 1488 */     Logs.logIf(new LogKey(this, "keeponlinetime")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1492 */         new LogLong(this, Properties.this.keeponlinetime)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1496 */             Properties.this.keeponlinetime = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1500 */     });
/* 1501 */     this.keeponlinetime = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setFightvalue(int _v_)
/*      */   {
/* 1508 */     _xdb_verify_unsafe_();
/* 1509 */     Logs.logIf(new LogKey(this, "fightvalue")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1513 */         new LogInt(this, Properties.this.fightvalue)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1517 */             Properties.this.fightvalue = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1521 */     });
/* 1522 */     this.fightvalue = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setLeveluptime(long _v_)
/*      */   {
/* 1529 */     _xdb_verify_unsafe_();
/* 1530 */     Logs.logIf(new LogKey(this, "leveluptime")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1534 */         new LogLong(this, Properties.this.leveluptime)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1538 */             Properties.this.leveluptime = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1542 */     });
/* 1543 */     this.leveluptime = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setAccumulateleveluptime(long _v_)
/*      */   {
/* 1550 */     _xdb_verify_unsafe_();
/* 1551 */     Logs.logIf(new LogKey(this, "accumulateleveluptime")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1555 */         new LogLong(this, Properties.this.accumulateleveluptime)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1559 */             Properties.this.accumulateleveluptime = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1563 */     });
/* 1564 */     this.accumulateleveluptime = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setVigorrefreshtime(long _v_)
/*      */   {
/* 1571 */     _xdb_verify_unsafe_();
/* 1572 */     Logs.logIf(new LogKey(this, "vigorrefreshtime")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1576 */         new LogLong(this, Properties.this.vigorrefreshtime)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1580 */             Properties.this.vigorrefreshtime = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1584 */     });
/* 1585 */     this.vigorrefreshtime = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setConvertxiulianexp(int _v_)
/*      */   {
/* 1592 */     _xdb_verify_unsafe_();
/* 1593 */     Logs.logIf(new LogKey(this, "convertxiulianexp")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1597 */         new LogInt(this, Properties.this.convertxiulianexp)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1601 */             Properties.this.convertxiulianexp = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1605 */     });
/* 1606 */     this.convertxiulianexp = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setLastcalcuatetime(long _v_)
/*      */   {
/* 1613 */     _xdb_verify_unsafe_();
/* 1614 */     Logs.logIf(new LogKey(this, "lastcalcuatetime")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1618 */         new LogLong(this, Properties.this.lastcalcuatetime)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1622 */             Properties.this.lastcalcuatetime = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1626 */     });
/* 1627 */     this.lastcalcuatetime = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setDayonlineseconds(int _v_)
/*      */   {
/* 1634 */     _xdb_verify_unsafe_();
/* 1635 */     Logs.logIf(new LogKey(this, "dayonlineseconds")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1639 */         new LogInt(this, Properties.this.dayonlineseconds)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1643 */             Properties.this.dayonlineseconds = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1647 */     });
/* 1648 */     this.dayonlineseconds = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setOnlineseconds(long _v_)
/*      */   {
/* 1655 */     _xdb_verify_unsafe_();
/* 1656 */     Logs.logIf(new LogKey(this, "onlineseconds")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1660 */         new LogLong(this, Properties.this.onlineseconds)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1664 */             Properties.this.onlineseconds = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1668 */     });
/* 1669 */     this.onlineseconds = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setSend_recharge_times_tip_mail_no(int _v_)
/*      */   {
/* 1676 */     _xdb_verify_unsafe_();
/* 1677 */     Logs.logIf(new LogKey(this, "send_recharge_times_tip_mail_no")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1681 */         new LogInt(this, Properties.this.send_recharge_times_tip_mail_no)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1685 */             Properties.this.send_recharge_times_tip_mail_no = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1689 */     });
/* 1690 */     this.send_recharge_times_tip_mail_no = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setLevelupcurtime(long _v_)
/*      */   {
/* 1697 */     _xdb_verify_unsafe_();
/* 1698 */     Logs.logIf(new LogKey(this, "levelupcurtime")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1702 */         new LogLong(this, Properties.this.levelupcurtime)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1706 */             Properties.this.levelupcurtime = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1710 */     });
/* 1711 */     this.levelupcurtime = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/* 1717 */     _xdb_verify_unsafe_();
/* 1718 */     Properties _o_ = null;
/* 1719 */     if ((_o1_ instanceof Properties)) { _o_ = (Properties)_o1_;
/* 1720 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 1721 */       return false;
/* 1722 */     if (this.level != _o_.level) return false;
/* 1723 */     if (this.exp != _o_.exp) return false;
/* 1724 */     if (this.hp != _o_.hp) return false;
/* 1725 */     if (this.mp != _o_.mp) return false;
/* 1726 */     if (this.anger != _o_.anger) return false;
/* 1727 */     if (this.vigor != _o_.vigor) return false;
/* 1728 */     if (!this.propertysysmap.equals(_o_.propertysysmap)) return false;
/* 1729 */     if (this.activitybpsys != _o_.activitybpsys) return false;
/* 1730 */     if (this.todaypropsysswitchcount != _o_.todaypropsysswitchcount) return false;
/* 1731 */     if (this.timestamp != _o_.timestamp) return false;
/* 1732 */     if (!this.location.equals(_o_.location)) return false;
/* 1733 */     if (this.gold != _o_.gold) return false;
/* 1734 */     if (this.silver != _o_.silver) return false;
/* 1735 */     if (this.goldingot != _o_.goldingot) return false;
/* 1736 */     if (this.dyecolorid != _o_.dyecolorid) return false;
/* 1737 */     if (this.baoshidu != _o_.baoshidu) return false;
/* 1738 */     if (this.lastlogintime != _o_.lastlogintime) return false;
/* 1739 */     if (this.lastlogofftime != _o_.lastlogofftime) return false;
/* 1740 */     if (this.keeponlinetime != _o_.keeponlinetime) return false;
/* 1741 */     if (this.fightvalue != _o_.fightvalue) return false;
/* 1742 */     if (this.leveluptime != _o_.leveluptime) return false;
/* 1743 */     if (this.accumulateleveluptime != _o_.accumulateleveluptime) return false;
/* 1744 */     if (this.vigorrefreshtime != _o_.vigorrefreshtime) return false;
/* 1745 */     if (this.convertxiulianexp != _o_.convertxiulianexp) return false;
/* 1746 */     if (!this.compensates.equals(_o_.compensates)) return false;
/* 1747 */     if (!this.gather_map_item_infos.equals(_o_.gather_map_item_infos)) return false;
/* 1748 */     if (this.lastcalcuatetime != _o_.lastcalcuatetime) return false;
/* 1749 */     if (this.dayonlineseconds != _o_.dayonlineseconds) return false;
/* 1750 */     if (this.onlineseconds != _o_.onlineseconds) return false;
/* 1751 */     if (this.send_recharge_times_tip_mail_no != _o_.send_recharge_times_tip_mail_no) return false;
/* 1752 */     if (this.levelupcurtime != _o_.levelupcurtime) return false;
/* 1753 */     if (!this.transfer_occupation_property_sys_map.equals(_o_.transfer_occupation_property_sys_map)) return false;
/* 1754 */     if (!this.coins.equals(_o_.coins)) return false;
/* 1755 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/* 1761 */     _xdb_verify_unsafe_();
/* 1762 */     int _h_ = 0;
/* 1763 */     _h_ += this.level;
/* 1764 */     _h_ += this.exp;
/* 1765 */     _h_ += this.hp;
/* 1766 */     _h_ += this.mp;
/* 1767 */     _h_ += this.anger;
/* 1768 */     _h_ += this.vigor;
/* 1769 */     _h_ += this.propertysysmap.hashCode();
/* 1770 */     _h_ += this.activitybpsys;
/* 1771 */     _h_ += this.todaypropsysswitchcount;
/* 1772 */     _h_ = (int)(_h_ + this.timestamp);
/* 1773 */     _h_ += this.location.hashCode();
/* 1774 */     _h_ = (int)(_h_ + this.gold);
/* 1775 */     _h_ = (int)(_h_ + this.silver);
/* 1776 */     _h_ = (int)(_h_ + this.goldingot);
/* 1777 */     _h_ += this.dyecolorid;
/* 1778 */     _h_ += this.baoshidu;
/* 1779 */     _h_ = (int)(_h_ + this.lastlogintime);
/* 1780 */     _h_ = (int)(_h_ + this.lastlogofftime);
/* 1781 */     _h_ = (int)(_h_ + this.keeponlinetime);
/* 1782 */     _h_ += this.fightvalue;
/* 1783 */     _h_ = (int)(_h_ + this.leveluptime);
/* 1784 */     _h_ = (int)(_h_ + this.accumulateleveluptime);
/* 1785 */     _h_ = (int)(_h_ + this.vigorrefreshtime);
/* 1786 */     _h_ += this.convertxiulianexp;
/* 1787 */     _h_ += this.compensates.hashCode();
/* 1788 */     _h_ += this.gather_map_item_infos.hashCode();
/* 1789 */     _h_ = (int)(_h_ + this.lastcalcuatetime);
/* 1790 */     _h_ += this.dayonlineseconds;
/* 1791 */     _h_ = (int)(_h_ + this.onlineseconds);
/* 1792 */     _h_ += this.send_recharge_times_tip_mail_no;
/* 1793 */     _h_ = (int)(_h_ + this.levelupcurtime);
/* 1794 */     _h_ += this.transfer_occupation_property_sys_map.hashCode();
/* 1795 */     _h_ += this.coins.hashCode();
/* 1796 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/* 1802 */     _xdb_verify_unsafe_();
/* 1803 */     StringBuilder _sb_ = new StringBuilder();
/* 1804 */     _sb_.append("(");
/* 1805 */     _sb_.append(this.level);
/* 1806 */     _sb_.append(",");
/* 1807 */     _sb_.append(this.exp);
/* 1808 */     _sb_.append(",");
/* 1809 */     _sb_.append(this.hp);
/* 1810 */     _sb_.append(",");
/* 1811 */     _sb_.append(this.mp);
/* 1812 */     _sb_.append(",");
/* 1813 */     _sb_.append(this.anger);
/* 1814 */     _sb_.append(",");
/* 1815 */     _sb_.append(this.vigor);
/* 1816 */     _sb_.append(",");
/* 1817 */     _sb_.append(this.propertysysmap);
/* 1818 */     _sb_.append(",");
/* 1819 */     _sb_.append(this.activitybpsys);
/* 1820 */     _sb_.append(",");
/* 1821 */     _sb_.append(this.todaypropsysswitchcount);
/* 1822 */     _sb_.append(",");
/* 1823 */     _sb_.append(this.timestamp);
/* 1824 */     _sb_.append(",");
/* 1825 */     _sb_.append(this.location);
/* 1826 */     _sb_.append(",");
/* 1827 */     _sb_.append(this.gold);
/* 1828 */     _sb_.append(",");
/* 1829 */     _sb_.append(this.silver);
/* 1830 */     _sb_.append(",");
/* 1831 */     _sb_.append(this.goldingot);
/* 1832 */     _sb_.append(",");
/* 1833 */     _sb_.append(this.dyecolorid);
/* 1834 */     _sb_.append(",");
/* 1835 */     _sb_.append(this.baoshidu);
/* 1836 */     _sb_.append(",");
/* 1837 */     _sb_.append(this.lastlogintime);
/* 1838 */     _sb_.append(",");
/* 1839 */     _sb_.append(this.lastlogofftime);
/* 1840 */     _sb_.append(",");
/* 1841 */     _sb_.append(this.keeponlinetime);
/* 1842 */     _sb_.append(",");
/* 1843 */     _sb_.append(this.fightvalue);
/* 1844 */     _sb_.append(",");
/* 1845 */     _sb_.append(this.leveluptime);
/* 1846 */     _sb_.append(",");
/* 1847 */     _sb_.append(this.accumulateleveluptime);
/* 1848 */     _sb_.append(",");
/* 1849 */     _sb_.append(this.vigorrefreshtime);
/* 1850 */     _sb_.append(",");
/* 1851 */     _sb_.append(this.convertxiulianexp);
/* 1852 */     _sb_.append(",");
/* 1853 */     _sb_.append(this.compensates);
/* 1854 */     _sb_.append(",");
/* 1855 */     _sb_.append(this.gather_map_item_infos);
/* 1856 */     _sb_.append(",");
/* 1857 */     _sb_.append(this.lastcalcuatetime);
/* 1858 */     _sb_.append(",");
/* 1859 */     _sb_.append(this.dayonlineseconds);
/* 1860 */     _sb_.append(",");
/* 1861 */     _sb_.append(this.onlineseconds);
/* 1862 */     _sb_.append(",");
/* 1863 */     _sb_.append(this.send_recharge_times_tip_mail_no);
/* 1864 */     _sb_.append(",");
/* 1865 */     _sb_.append(this.levelupcurtime);
/* 1866 */     _sb_.append(",");
/* 1867 */     _sb_.append(this.transfer_occupation_property_sys_map);
/* 1868 */     _sb_.append(",");
/* 1869 */     _sb_.append(this.coins);
/* 1870 */     _sb_.append(")");
/* 1871 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public Listenable newListenable()
/*      */   {
/* 1877 */     ListenableBean lb = new ListenableBean();
/* 1878 */     lb.add(new ListenableChanged().setVarName("level"));
/* 1879 */     lb.add(new ListenableChanged().setVarName("exp"));
/* 1880 */     lb.add(new ListenableChanged().setVarName("hp"));
/* 1881 */     lb.add(new ListenableChanged().setVarName("mp"));
/* 1882 */     lb.add(new ListenableChanged().setVarName("anger"));
/* 1883 */     lb.add(new ListenableChanged().setVarName("vigor"));
/* 1884 */     lb.add(new ListenableMap().setVarName("propertysysmap"));
/* 1885 */     lb.add(new ListenableChanged().setVarName("activitybpsys"));
/* 1886 */     lb.add(new ListenableChanged().setVarName("todaypropsysswitchcount"));
/* 1887 */     lb.add(new ListenableChanged().setVarName("timestamp"));
/* 1888 */     lb.add(new ListenableChanged().setVarName("location"));
/* 1889 */     lb.add(new ListenableChanged().setVarName("gold"));
/* 1890 */     lb.add(new ListenableChanged().setVarName("silver"));
/* 1891 */     lb.add(new ListenableChanged().setVarName("goldingot"));
/* 1892 */     lb.add(new ListenableChanged().setVarName("dyecolorid"));
/* 1893 */     lb.add(new ListenableChanged().setVarName("baoshidu"));
/* 1894 */     lb.add(new ListenableChanged().setVarName("lastlogintime"));
/* 1895 */     lb.add(new ListenableChanged().setVarName("lastlogofftime"));
/* 1896 */     lb.add(new ListenableChanged().setVarName("keeponlinetime"));
/* 1897 */     lb.add(new ListenableChanged().setVarName("fightvalue"));
/* 1898 */     lb.add(new ListenableChanged().setVarName("leveluptime"));
/* 1899 */     lb.add(new ListenableChanged().setVarName("accumulateleveluptime"));
/* 1900 */     lb.add(new ListenableChanged().setVarName("vigorrefreshtime"));
/* 1901 */     lb.add(new ListenableChanged().setVarName("convertxiulianexp"));
/* 1902 */     lb.add(new ListenableSet().setVarName("compensates"));
/* 1903 */     lb.add(new ListenableMap().setVarName("gather_map_item_infos"));
/* 1904 */     lb.add(new ListenableChanged().setVarName("lastcalcuatetime"));
/* 1905 */     lb.add(new ListenableChanged().setVarName("dayonlineseconds"));
/* 1906 */     lb.add(new ListenableChanged().setVarName("onlineseconds"));
/* 1907 */     lb.add(new ListenableChanged().setVarName("send_recharge_times_tip_mail_no"));
/* 1908 */     lb.add(new ListenableChanged().setVarName("levelupcurtime"));
/* 1909 */     lb.add(new ListenableMap().setVarName("transfer_occupation_property_sys_map"));
/* 1910 */     lb.add(new ListenableMap().setVarName("coins"));
/* 1911 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.Properties {
/*      */     private Const() {}
/*      */     
/*      */     Properties nThis() {
/* 1918 */       return Properties.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/* 1924 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Properties copy()
/*      */     {
/* 1930 */       return Properties.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Properties toData()
/*      */     {
/* 1936 */       return Properties.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.Properties toBean()
/*      */     {
/* 1941 */       return Properties.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Properties toDataIf()
/*      */     {
/* 1947 */       return Properties.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.Properties toBeanIf()
/*      */     {
/* 1952 */       return Properties.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getLevel()
/*      */     {
/* 1959 */       Properties.this._xdb_verify_unsafe_();
/* 1960 */       return Properties.this.level;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getExp()
/*      */     {
/* 1967 */       Properties.this._xdb_verify_unsafe_();
/* 1968 */       return Properties.this.exp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getHp()
/*      */     {
/* 1975 */       Properties.this._xdb_verify_unsafe_();
/* 1976 */       return Properties.this.hp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getMp()
/*      */     {
/* 1983 */       Properties.this._xdb_verify_unsafe_();
/* 1984 */       return Properties.this.mp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getAnger()
/*      */     {
/* 1991 */       Properties.this._xdb_verify_unsafe_();
/* 1992 */       return Properties.this.anger;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getVigor()
/*      */     {
/* 1999 */       Properties.this._xdb_verify_unsafe_();
/* 2000 */       return Properties.this.vigor;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.BasicPropertiesSystem> getPropertysysmap()
/*      */     {
/* 2007 */       Properties.this._xdb_verify_unsafe_();
/* 2008 */       return Consts.constMap(Properties.this.propertysysmap);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.BasicPropertiesSystem> getPropertysysmapAsData()
/*      */     {
/* 2015 */       Properties.this._xdb_verify_unsafe_();
/*      */       
/* 2017 */       Properties _o_ = Properties.this;
/* 2018 */       Map<Integer, xbean.BasicPropertiesSystem> propertysysmap = new HashMap();
/* 2019 */       for (Map.Entry<Integer, xbean.BasicPropertiesSystem> _e_ : _o_.propertysysmap.entrySet())
/* 2020 */         propertysysmap.put(_e_.getKey(), new BasicPropertiesSystem.Data((xbean.BasicPropertiesSystem)_e_.getValue()));
/* 2021 */       return propertysysmap;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getActivitybpsys()
/*      */     {
/* 2028 */       Properties.this._xdb_verify_unsafe_();
/* 2029 */       return Properties.this.activitybpsys;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getTodaypropsysswitchcount()
/*      */     {
/* 2036 */       Properties.this._xdb_verify_unsafe_();
/* 2037 */       return Properties.this.todaypropsysswitchcount;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getTimestamp()
/*      */     {
/* 2044 */       Properties.this._xdb_verify_unsafe_();
/* 2045 */       return Properties.this.timestamp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public xbean.Location getLocation()
/*      */     {
/* 2052 */       Properties.this._xdb_verify_unsafe_();
/* 2053 */       return (xbean.Location)Consts.toConst(Properties.this.location);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getGold()
/*      */     {
/* 2060 */       Properties.this._xdb_verify_unsafe_();
/* 2061 */       return Properties.this.gold;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getSilver()
/*      */     {
/* 2068 */       Properties.this._xdb_verify_unsafe_();
/* 2069 */       return Properties.this.silver;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getGoldingot()
/*      */     {
/* 2076 */       Properties.this._xdb_verify_unsafe_();
/* 2077 */       return Properties.this.goldingot;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getDyecolorid()
/*      */     {
/* 2084 */       Properties.this._xdb_verify_unsafe_();
/* 2085 */       return Properties.this.dyecolorid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getBaoshidu()
/*      */     {
/* 2092 */       Properties.this._xdb_verify_unsafe_();
/* 2093 */       return Properties.this.baoshidu;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getLastlogintime()
/*      */     {
/* 2100 */       Properties.this._xdb_verify_unsafe_();
/* 2101 */       return Properties.this.lastlogintime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getLastlogofftime()
/*      */     {
/* 2108 */       Properties.this._xdb_verify_unsafe_();
/* 2109 */       return Properties.this.lastlogofftime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getKeeponlinetime()
/*      */     {
/* 2116 */       Properties.this._xdb_verify_unsafe_();
/* 2117 */       return Properties.this.keeponlinetime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getFightvalue()
/*      */     {
/* 2124 */       Properties.this._xdb_verify_unsafe_();
/* 2125 */       return Properties.this.fightvalue;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getLeveluptime()
/*      */     {
/* 2132 */       Properties.this._xdb_verify_unsafe_();
/* 2133 */       return Properties.this.leveluptime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getAccumulateleveluptime()
/*      */     {
/* 2140 */       Properties.this._xdb_verify_unsafe_();
/* 2141 */       return Properties.this.accumulateleveluptime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getVigorrefreshtime()
/*      */     {
/* 2148 */       Properties.this._xdb_verify_unsafe_();
/* 2149 */       return Properties.this.vigorrefreshtime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getConvertxiulianexp()
/*      */     {
/* 2156 */       Properties.this._xdb_verify_unsafe_();
/* 2157 */       return Properties.this.convertxiulianexp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Long> getCompensates()
/*      */     {
/* 2164 */       Properties.this._xdb_verify_unsafe_();
/* 2165 */       return Consts.constSet(Properties.this.compensates);
/*      */     }
/*      */     
/*      */ 
/*      */     public Set<Long> getCompensatesAsData()
/*      */     {
/* 2171 */       Properties.this._xdb_verify_unsafe_();
/*      */       
/* 2173 */       Properties _o_ = Properties.this;
/* 2174 */       Set<Long> compensates = new SetX();
/* 2175 */       compensates.addAll(_o_.compensates);
/* 2176 */       return compensates;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.GatherMapItemInfo> getGather_map_item_infos()
/*      */     {
/* 2183 */       Properties.this._xdb_verify_unsafe_();
/* 2184 */       return Consts.constMap(Properties.this.gather_map_item_infos);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.GatherMapItemInfo> getGather_map_item_infosAsData()
/*      */     {
/* 2191 */       Properties.this._xdb_verify_unsafe_();
/*      */       
/* 2193 */       Properties _o_ = Properties.this;
/* 2194 */       Map<Integer, xbean.GatherMapItemInfo> gather_map_item_infos = new HashMap();
/* 2195 */       for (Map.Entry<Integer, xbean.GatherMapItemInfo> _e_ : _o_.gather_map_item_infos.entrySet())
/* 2196 */         gather_map_item_infos.put(_e_.getKey(), new GatherMapItemInfo.Data((xbean.GatherMapItemInfo)_e_.getValue()));
/* 2197 */       return gather_map_item_infos;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getLastcalcuatetime()
/*      */     {
/* 2204 */       Properties.this._xdb_verify_unsafe_();
/* 2205 */       return Properties.this.lastcalcuatetime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getDayonlineseconds()
/*      */     {
/* 2212 */       Properties.this._xdb_verify_unsafe_();
/* 2213 */       return Properties.this.dayonlineseconds;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getOnlineseconds()
/*      */     {
/* 2220 */       Properties.this._xdb_verify_unsafe_();
/* 2221 */       return Properties.this.onlineseconds;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getSend_recharge_times_tip_mail_no()
/*      */     {
/* 2228 */       Properties.this._xdb_verify_unsafe_();
/* 2229 */       return Properties.this.send_recharge_times_tip_mail_no;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getLevelupcurtime()
/*      */     {
/* 2236 */       Properties.this._xdb_verify_unsafe_();
/* 2237 */       return Properties.this.levelupcurtime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.TransferOccupationPropertiesSys> getTransfer_occupation_property_sys_map()
/*      */     {
/* 2244 */       Properties.this._xdb_verify_unsafe_();
/* 2245 */       return Consts.constMap(Properties.this.transfer_occupation_property_sys_map);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.TransferOccupationPropertiesSys> getTransfer_occupation_property_sys_mapAsData()
/*      */     {
/* 2252 */       Properties.this._xdb_verify_unsafe_();
/*      */       
/* 2254 */       Properties _o_ = Properties.this;
/* 2255 */       Map<Integer, xbean.TransferOccupationPropertiesSys> transfer_occupation_property_sys_map = new HashMap();
/* 2256 */       for (Map.Entry<Integer, xbean.TransferOccupationPropertiesSys> _e_ : _o_.transfer_occupation_property_sys_map.entrySet())
/* 2257 */         transfer_occupation_property_sys_map.put(_e_.getKey(), new TransferOccupationPropertiesSys.Data((xbean.TransferOccupationPropertiesSys)_e_.getValue()));
/* 2258 */       return transfer_occupation_property_sys_map;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.CoinInfo> getCoins()
/*      */     {
/* 2265 */       Properties.this._xdb_verify_unsafe_();
/* 2266 */       return Consts.constMap(Properties.this.coins);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.CoinInfo> getCoinsAsData()
/*      */     {
/* 2273 */       Properties.this._xdb_verify_unsafe_();
/*      */       
/* 2275 */       Properties _o_ = Properties.this;
/* 2276 */       Map<Integer, xbean.CoinInfo> coins = new HashMap();
/* 2277 */       for (Map.Entry<Integer, xbean.CoinInfo> _e_ : _o_.coins.entrySet())
/* 2278 */         coins.put(_e_.getKey(), new CoinInfo.Data((xbean.CoinInfo)_e_.getValue()));
/* 2279 */       return coins;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLevel(int _v_)
/*      */     {
/* 2286 */       Properties.this._xdb_verify_unsafe_();
/* 2287 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setExp(int _v_)
/*      */     {
/* 2294 */       Properties.this._xdb_verify_unsafe_();
/* 2295 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setHp(int _v_)
/*      */     {
/* 2302 */       Properties.this._xdb_verify_unsafe_();
/* 2303 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMp(int _v_)
/*      */     {
/* 2310 */       Properties.this._xdb_verify_unsafe_();
/* 2311 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setAnger(int _v_)
/*      */     {
/* 2318 */       Properties.this._xdb_verify_unsafe_();
/* 2319 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setVigor(int _v_)
/*      */     {
/* 2326 */       Properties.this._xdb_verify_unsafe_();
/* 2327 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setActivitybpsys(int _v_)
/*      */     {
/* 2334 */       Properties.this._xdb_verify_unsafe_();
/* 2335 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setTodaypropsysswitchcount(int _v_)
/*      */     {
/* 2342 */       Properties.this._xdb_verify_unsafe_();
/* 2343 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setTimestamp(long _v_)
/*      */     {
/* 2350 */       Properties.this._xdb_verify_unsafe_();
/* 2351 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setGold(long _v_)
/*      */     {
/* 2358 */       Properties.this._xdb_verify_unsafe_();
/* 2359 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setSilver(long _v_)
/*      */     {
/* 2366 */       Properties.this._xdb_verify_unsafe_();
/* 2367 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setGoldingot(long _v_)
/*      */     {
/* 2374 */       Properties.this._xdb_verify_unsafe_();
/* 2375 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setDyecolorid(int _v_)
/*      */     {
/* 2382 */       Properties.this._xdb_verify_unsafe_();
/* 2383 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setBaoshidu(int _v_)
/*      */     {
/* 2390 */       Properties.this._xdb_verify_unsafe_();
/* 2391 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLastlogintime(long _v_)
/*      */     {
/* 2398 */       Properties.this._xdb_verify_unsafe_();
/* 2399 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLastlogofftime(long _v_)
/*      */     {
/* 2406 */       Properties.this._xdb_verify_unsafe_();
/* 2407 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setKeeponlinetime(long _v_)
/*      */     {
/* 2414 */       Properties.this._xdb_verify_unsafe_();
/* 2415 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setFightvalue(int _v_)
/*      */     {
/* 2422 */       Properties.this._xdb_verify_unsafe_();
/* 2423 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLeveluptime(long _v_)
/*      */     {
/* 2430 */       Properties.this._xdb_verify_unsafe_();
/* 2431 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setAccumulateleveluptime(long _v_)
/*      */     {
/* 2438 */       Properties.this._xdb_verify_unsafe_();
/* 2439 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setVigorrefreshtime(long _v_)
/*      */     {
/* 2446 */       Properties.this._xdb_verify_unsafe_();
/* 2447 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setConvertxiulianexp(int _v_)
/*      */     {
/* 2454 */       Properties.this._xdb_verify_unsafe_();
/* 2455 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLastcalcuatetime(long _v_)
/*      */     {
/* 2462 */       Properties.this._xdb_verify_unsafe_();
/* 2463 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setDayonlineseconds(int _v_)
/*      */     {
/* 2470 */       Properties.this._xdb_verify_unsafe_();
/* 2471 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setOnlineseconds(long _v_)
/*      */     {
/* 2478 */       Properties.this._xdb_verify_unsafe_();
/* 2479 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setSend_recharge_times_tip_mail_no(int _v_)
/*      */     {
/* 2486 */       Properties.this._xdb_verify_unsafe_();
/* 2487 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLevelupcurtime(long _v_)
/*      */     {
/* 2494 */       Properties.this._xdb_verify_unsafe_();
/* 2495 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean toConst()
/*      */     {
/* 2501 */       Properties.this._xdb_verify_unsafe_();
/* 2502 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/* 2508 */       Properties.this._xdb_verify_unsafe_();
/* 2509 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/* 2515 */       return Properties.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/* 2521 */       return Properties.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws MarshalException
/*      */     {
/* 2527 */       Properties.this._xdb_verify_unsafe_();
/* 2528 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/* 2534 */       return Properties.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/* 2540 */       return Properties.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/* 2546 */       Properties.this._xdb_verify_unsafe_();
/* 2547 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean xdbParent()
/*      */     {
/* 2553 */       return Properties.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 2559 */       return Properties.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/* 2565 */       return Properties.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/* 2571 */       return Properties.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/* 2577 */       return Properties.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/* 2583 */       return Properties.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 2589 */       return Properties.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.Properties
/*      */   {
/*      */     private int level;
/*      */     
/*      */     private int exp;
/*      */     
/*      */     private int hp;
/*      */     
/*      */     private int mp;
/*      */     
/*      */     private int anger;
/*      */     
/*      */     private int vigor;
/*      */     
/*      */     private HashMap<Integer, xbean.BasicPropertiesSystem> propertysysmap;
/*      */     
/*      */     private int activitybpsys;
/*      */     
/*      */     private int todaypropsysswitchcount;
/*      */     
/*      */     private long timestamp;
/*      */     
/*      */     private xbean.Location location;
/*      */     
/*      */     private long gold;
/*      */     
/*      */     private long silver;
/*      */     
/*      */     private long goldingot;
/*      */     
/*      */     private int dyecolorid;
/*      */     
/*      */     private int baoshidu;
/*      */     
/*      */     private long lastlogintime;
/*      */     
/*      */     private long lastlogofftime;
/*      */     
/*      */     private long keeponlinetime;
/*      */     
/*      */     private int fightvalue;
/*      */     
/*      */     private long leveluptime;
/*      */     
/*      */     private long accumulateleveluptime;
/*      */     
/*      */     private long vigorrefreshtime;
/*      */     
/*      */     private int convertxiulianexp;
/*      */     
/*      */     private HashSet<Long> compensates;
/*      */     
/*      */     private HashMap<Integer, xbean.GatherMapItemInfo> gather_map_item_infos;
/*      */     
/*      */     private long lastcalcuatetime;
/*      */     
/*      */     private int dayonlineseconds;
/*      */     
/*      */     private long onlineseconds;
/*      */     
/*      */     private int send_recharge_times_tip_mail_no;
/*      */     
/*      */     private long levelupcurtime;
/*      */     
/*      */     private HashMap<Integer, xbean.TransferOccupationPropertiesSys> transfer_occupation_property_sys_map;
/*      */     
/*      */     private HashMap<Integer, xbean.CoinInfo> coins;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/* 2665 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/* 2670 */       this.level = 0;
/* 2671 */       this.exp = 0;
/* 2672 */       this.hp = 0;
/* 2673 */       this.mp = 0;
/* 2674 */       this.anger = 0;
/* 2675 */       this.vigor = 0;
/* 2676 */       this.propertysysmap = new HashMap();
/* 2677 */       this.location = new Location.Data();
/* 2678 */       this.compensates = new HashSet();
/* 2679 */       this.gather_map_item_infos = new HashMap();
/* 2680 */       this.send_recharge_times_tip_mail_no = 0;
/* 2681 */       this.transfer_occupation_property_sys_map = new HashMap();
/* 2682 */       this.coins = new HashMap();
/*      */     }
/*      */     
/*      */     Data(xbean.Properties _o1_)
/*      */     {
/* 2687 */       if ((_o1_ instanceof Properties)) { assign((Properties)_o1_);
/* 2688 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 2689 */       } else if ((_o1_ instanceof Properties.Const)) assign(((Properties.Const)_o1_).nThis()); else {
/* 2690 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(Properties _o_) {
/* 2695 */       this.level = _o_.level;
/* 2696 */       this.exp = _o_.exp;
/* 2697 */       this.hp = _o_.hp;
/* 2698 */       this.mp = _o_.mp;
/* 2699 */       this.anger = _o_.anger;
/* 2700 */       this.vigor = _o_.vigor;
/* 2701 */       this.propertysysmap = new HashMap();
/* 2702 */       for (Map.Entry<Integer, xbean.BasicPropertiesSystem> _e_ : _o_.propertysysmap.entrySet())
/* 2703 */         this.propertysysmap.put(_e_.getKey(), new BasicPropertiesSystem.Data((xbean.BasicPropertiesSystem)_e_.getValue()));
/* 2704 */       this.activitybpsys = _o_.activitybpsys;
/* 2705 */       this.todaypropsysswitchcount = _o_.todaypropsysswitchcount;
/* 2706 */       this.timestamp = _o_.timestamp;
/* 2707 */       this.location = new Location.Data(_o_.location);
/* 2708 */       this.gold = _o_.gold;
/* 2709 */       this.silver = _o_.silver;
/* 2710 */       this.goldingot = _o_.goldingot;
/* 2711 */       this.dyecolorid = _o_.dyecolorid;
/* 2712 */       this.baoshidu = _o_.baoshidu;
/* 2713 */       this.lastlogintime = _o_.lastlogintime;
/* 2714 */       this.lastlogofftime = _o_.lastlogofftime;
/* 2715 */       this.keeponlinetime = _o_.keeponlinetime;
/* 2716 */       this.fightvalue = _o_.fightvalue;
/* 2717 */       this.leveluptime = _o_.leveluptime;
/* 2718 */       this.accumulateleveluptime = _o_.accumulateleveluptime;
/* 2719 */       this.vigorrefreshtime = _o_.vigorrefreshtime;
/* 2720 */       this.convertxiulianexp = _o_.convertxiulianexp;
/* 2721 */       this.compensates = new HashSet();
/* 2722 */       this.compensates.addAll(_o_.compensates);
/* 2723 */       this.gather_map_item_infos = new HashMap();
/* 2724 */       for (Map.Entry<Integer, xbean.GatherMapItemInfo> _e_ : _o_.gather_map_item_infos.entrySet())
/* 2725 */         this.gather_map_item_infos.put(_e_.getKey(), new GatherMapItemInfo.Data((xbean.GatherMapItemInfo)_e_.getValue()));
/* 2726 */       this.lastcalcuatetime = _o_.lastcalcuatetime;
/* 2727 */       this.dayonlineseconds = _o_.dayonlineseconds;
/* 2728 */       this.onlineseconds = _o_.onlineseconds;
/* 2729 */       this.send_recharge_times_tip_mail_no = _o_.send_recharge_times_tip_mail_no;
/* 2730 */       this.levelupcurtime = _o_.levelupcurtime;
/* 2731 */       this.transfer_occupation_property_sys_map = new HashMap();
/* 2732 */       for (Map.Entry<Integer, xbean.TransferOccupationPropertiesSys> _e_ : _o_.transfer_occupation_property_sys_map.entrySet())
/* 2733 */         this.transfer_occupation_property_sys_map.put(_e_.getKey(), new TransferOccupationPropertiesSys.Data((xbean.TransferOccupationPropertiesSys)_e_.getValue()));
/* 2734 */       this.coins = new HashMap();
/* 2735 */       for (Map.Entry<Integer, xbean.CoinInfo> _e_ : _o_.coins.entrySet()) {
/* 2736 */         this.coins.put(_e_.getKey(), new CoinInfo.Data((xbean.CoinInfo)_e_.getValue()));
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(Data _o_) {
/* 2741 */       this.level = _o_.level;
/* 2742 */       this.exp = _o_.exp;
/* 2743 */       this.hp = _o_.hp;
/* 2744 */       this.mp = _o_.mp;
/* 2745 */       this.anger = _o_.anger;
/* 2746 */       this.vigor = _o_.vigor;
/* 2747 */       this.propertysysmap = new HashMap();
/* 2748 */       for (Map.Entry<Integer, xbean.BasicPropertiesSystem> _e_ : _o_.propertysysmap.entrySet())
/* 2749 */         this.propertysysmap.put(_e_.getKey(), new BasicPropertiesSystem.Data((xbean.BasicPropertiesSystem)_e_.getValue()));
/* 2750 */       this.activitybpsys = _o_.activitybpsys;
/* 2751 */       this.todaypropsysswitchcount = _o_.todaypropsysswitchcount;
/* 2752 */       this.timestamp = _o_.timestamp;
/* 2753 */       this.location = new Location.Data(_o_.location);
/* 2754 */       this.gold = _o_.gold;
/* 2755 */       this.silver = _o_.silver;
/* 2756 */       this.goldingot = _o_.goldingot;
/* 2757 */       this.dyecolorid = _o_.dyecolorid;
/* 2758 */       this.baoshidu = _o_.baoshidu;
/* 2759 */       this.lastlogintime = _o_.lastlogintime;
/* 2760 */       this.lastlogofftime = _o_.lastlogofftime;
/* 2761 */       this.keeponlinetime = _o_.keeponlinetime;
/* 2762 */       this.fightvalue = _o_.fightvalue;
/* 2763 */       this.leveluptime = _o_.leveluptime;
/* 2764 */       this.accumulateleveluptime = _o_.accumulateleveluptime;
/* 2765 */       this.vigorrefreshtime = _o_.vigorrefreshtime;
/* 2766 */       this.convertxiulianexp = _o_.convertxiulianexp;
/* 2767 */       this.compensates = new HashSet();
/* 2768 */       this.compensates.addAll(_o_.compensates);
/* 2769 */       this.gather_map_item_infos = new HashMap();
/* 2770 */       for (Map.Entry<Integer, xbean.GatherMapItemInfo> _e_ : _o_.gather_map_item_infos.entrySet())
/* 2771 */         this.gather_map_item_infos.put(_e_.getKey(), new GatherMapItemInfo.Data((xbean.GatherMapItemInfo)_e_.getValue()));
/* 2772 */       this.lastcalcuatetime = _o_.lastcalcuatetime;
/* 2773 */       this.dayonlineseconds = _o_.dayonlineseconds;
/* 2774 */       this.onlineseconds = _o_.onlineseconds;
/* 2775 */       this.send_recharge_times_tip_mail_no = _o_.send_recharge_times_tip_mail_no;
/* 2776 */       this.levelupcurtime = _o_.levelupcurtime;
/* 2777 */       this.transfer_occupation_property_sys_map = new HashMap();
/* 2778 */       for (Map.Entry<Integer, xbean.TransferOccupationPropertiesSys> _e_ : _o_.transfer_occupation_property_sys_map.entrySet())
/* 2779 */         this.transfer_occupation_property_sys_map.put(_e_.getKey(), new TransferOccupationPropertiesSys.Data((xbean.TransferOccupationPropertiesSys)_e_.getValue()));
/* 2780 */       this.coins = new HashMap();
/* 2781 */       for (Map.Entry<Integer, xbean.CoinInfo> _e_ : _o_.coins.entrySet()) {
/* 2782 */         this.coins.put(_e_.getKey(), new CoinInfo.Data((xbean.CoinInfo)_e_.getValue()));
/*      */       }
/*      */     }
/*      */     
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/* 2788 */       _os_.marshal(this.level);
/* 2789 */       _os_.marshal(this.exp);
/* 2790 */       _os_.marshal(this.hp);
/* 2791 */       _os_.marshal(this.mp);
/* 2792 */       _os_.marshal(this.anger);
/* 2793 */       _os_.marshal(this.vigor);
/* 2794 */       _os_.compact_uint32(this.propertysysmap.size());
/* 2795 */       for (Map.Entry<Integer, xbean.BasicPropertiesSystem> _e_ : this.propertysysmap.entrySet())
/*      */       {
/* 2797 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 2798 */         ((xbean.BasicPropertiesSystem)_e_.getValue()).marshal(_os_);
/*      */       }
/* 2800 */       _os_.marshal(this.activitybpsys);
/* 2801 */       _os_.marshal(this.todaypropsysswitchcount);
/* 2802 */       _os_.marshal(this.timestamp);
/* 2803 */       this.location.marshal(_os_);
/* 2804 */       _os_.marshal(this.gold);
/* 2805 */       _os_.marshal(this.silver);
/* 2806 */       _os_.marshal(this.goldingot);
/* 2807 */       _os_.marshal(this.dyecolorid);
/* 2808 */       _os_.marshal(this.baoshidu);
/* 2809 */       _os_.marshal(this.lastlogintime);
/* 2810 */       _os_.marshal(this.lastlogofftime);
/* 2811 */       _os_.marshal(this.keeponlinetime);
/* 2812 */       _os_.marshal(this.fightvalue);
/* 2813 */       _os_.marshal(this.leveluptime);
/* 2814 */       _os_.marshal(this.accumulateleveluptime);
/* 2815 */       _os_.marshal(this.vigorrefreshtime);
/* 2816 */       _os_.marshal(this.convertxiulianexp);
/* 2817 */       _os_.compact_uint32(this.compensates.size());
/* 2818 */       for (Long _v_ : this.compensates)
/*      */       {
/* 2820 */         _os_.marshal(_v_.longValue());
/*      */       }
/* 2822 */       _os_.compact_uint32(this.gather_map_item_infos.size());
/* 2823 */       for (Map.Entry<Integer, xbean.GatherMapItemInfo> _e_ : this.gather_map_item_infos.entrySet())
/*      */       {
/* 2825 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 2826 */         ((xbean.GatherMapItemInfo)_e_.getValue()).marshal(_os_);
/*      */       }
/* 2828 */       _os_.marshal(this.lastcalcuatetime);
/* 2829 */       _os_.marshal(this.dayonlineseconds);
/* 2830 */       _os_.marshal(this.onlineseconds);
/* 2831 */       _os_.marshal(this.send_recharge_times_tip_mail_no);
/* 2832 */       _os_.marshal(this.levelupcurtime);
/* 2833 */       _os_.compact_uint32(this.transfer_occupation_property_sys_map.size());
/* 2834 */       for (Map.Entry<Integer, xbean.TransferOccupationPropertiesSys> _e_ : this.transfer_occupation_property_sys_map.entrySet())
/*      */       {
/* 2836 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 2837 */         ((xbean.TransferOccupationPropertiesSys)_e_.getValue()).marshal(_os_);
/*      */       }
/* 2839 */       _os_.compact_uint32(this.coins.size());
/* 2840 */       for (Map.Entry<Integer, xbean.CoinInfo> _e_ : this.coins.entrySet())
/*      */       {
/* 2842 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 2843 */         ((xbean.CoinInfo)_e_.getValue()).marshal(_os_);
/*      */       }
/* 2845 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws MarshalException
/*      */     {
/* 2851 */       this.level = _os_.unmarshal_int();
/* 2852 */       this.exp = _os_.unmarshal_int();
/* 2853 */       this.hp = _os_.unmarshal_int();
/* 2854 */       this.mp = _os_.unmarshal_int();
/* 2855 */       this.anger = _os_.unmarshal_int();
/* 2856 */       this.vigor = _os_.unmarshal_int();
/*      */       
/* 2858 */       int size = _os_.uncompact_uint32();
/* 2859 */       if (size >= 12)
/*      */       {
/* 2861 */         this.propertysysmap = new HashMap(size * 2);
/*      */       }
/* 2863 */       for (; size > 0; size--)
/*      */       {
/* 2865 */         int _k_ = 0;
/* 2866 */         _k_ = _os_.unmarshal_int();
/* 2867 */         xbean.BasicPropertiesSystem _v_ = Pod.newBasicPropertiesSystemData();
/* 2868 */         _v_.unmarshal(_os_);
/* 2869 */         this.propertysysmap.put(Integer.valueOf(_k_), _v_);
/*      */       }
/*      */       
/* 2872 */       this.activitybpsys = _os_.unmarshal_int();
/* 2873 */       this.todaypropsysswitchcount = _os_.unmarshal_int();
/* 2874 */       this.timestamp = _os_.unmarshal_long();
/* 2875 */       this.location.unmarshal(_os_);
/* 2876 */       this.gold = _os_.unmarshal_long();
/* 2877 */       this.silver = _os_.unmarshal_long();
/* 2878 */       this.goldingot = _os_.unmarshal_long();
/* 2879 */       this.dyecolorid = _os_.unmarshal_int();
/* 2880 */       this.baoshidu = _os_.unmarshal_int();
/* 2881 */       this.lastlogintime = _os_.unmarshal_long();
/* 2882 */       this.lastlogofftime = _os_.unmarshal_long();
/* 2883 */       this.keeponlinetime = _os_.unmarshal_long();
/* 2884 */       this.fightvalue = _os_.unmarshal_int();
/* 2885 */       this.leveluptime = _os_.unmarshal_long();
/* 2886 */       this.accumulateleveluptime = _os_.unmarshal_long();
/* 2887 */       this.vigorrefreshtime = _os_.unmarshal_long();
/* 2888 */       this.convertxiulianexp = _os_.unmarshal_int();
/* 2889 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/* 2891 */         long _v_ = 0L;
/* 2892 */         _v_ = _os_.unmarshal_long();
/* 2893 */         this.compensates.add(Long.valueOf(_v_));
/*      */       }
/*      */       
/* 2896 */       int size = _os_.uncompact_uint32();
/* 2897 */       if (size >= 12)
/*      */       {
/* 2899 */         this.gather_map_item_infos = new HashMap(size * 2);
/*      */       }
/* 2901 */       for (; size > 0; size--)
/*      */       {
/* 2903 */         int _k_ = 0;
/* 2904 */         _k_ = _os_.unmarshal_int();
/* 2905 */         xbean.GatherMapItemInfo _v_ = Pod.newGatherMapItemInfoData();
/* 2906 */         _v_.unmarshal(_os_);
/* 2907 */         this.gather_map_item_infos.put(Integer.valueOf(_k_), _v_);
/*      */       }
/*      */       
/* 2910 */       this.lastcalcuatetime = _os_.unmarshal_long();
/* 2911 */       this.dayonlineseconds = _os_.unmarshal_int();
/* 2912 */       this.onlineseconds = _os_.unmarshal_long();
/* 2913 */       this.send_recharge_times_tip_mail_no = _os_.unmarshal_int();
/* 2914 */       this.levelupcurtime = _os_.unmarshal_long();
/*      */       
/* 2916 */       int size = _os_.uncompact_uint32();
/* 2917 */       if (size >= 12)
/*      */       {
/* 2919 */         this.transfer_occupation_property_sys_map = new HashMap(size * 2);
/*      */       }
/* 2921 */       for (; size > 0; size--)
/*      */       {
/* 2923 */         int _k_ = 0;
/* 2924 */         _k_ = _os_.unmarshal_int();
/* 2925 */         xbean.TransferOccupationPropertiesSys _v_ = Pod.newTransferOccupationPropertiesSysData();
/* 2926 */         _v_.unmarshal(_os_);
/* 2927 */         this.transfer_occupation_property_sys_map.put(Integer.valueOf(_k_), _v_);
/*      */       }
/*      */       
/*      */ 
/* 2931 */       int size = _os_.uncompact_uint32();
/* 2932 */       if (size >= 12)
/*      */       {
/* 2934 */         this.coins = new HashMap(size * 2);
/*      */       }
/* 2936 */       for (; size > 0; size--)
/*      */       {
/* 2938 */         int _k_ = 0;
/* 2939 */         _k_ = _os_.unmarshal_int();
/* 2940 */         xbean.CoinInfo _v_ = Pod.newCoinInfoData();
/* 2941 */         _v_.unmarshal(_os_);
/* 2942 */         this.coins.put(Integer.valueOf(_k_), _v_);
/*      */       }
/*      */       
/* 2945 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/* 2951 */       int _size_ = 0;
/* 2952 */       _size_ += CodedOutputStream.computeInt32Size(1, this.level);
/* 2953 */       _size_ += CodedOutputStream.computeInt32Size(2, this.exp);
/* 2954 */       _size_ += CodedOutputStream.computeInt32Size(3, this.hp);
/* 2955 */       _size_ += CodedOutputStream.computeInt32Size(4, this.mp);
/* 2956 */       _size_ += CodedOutputStream.computeInt32Size(5, this.anger);
/* 2957 */       _size_ += CodedOutputStream.computeInt32Size(6, this.vigor);
/* 2958 */       for (Map.Entry<Integer, xbean.BasicPropertiesSystem> _e_ : this.propertysysmap.entrySet())
/*      */       {
/* 2960 */         _size_ += CodedOutputStream.computeInt32Size(7, ((Integer)_e_.getKey()).intValue());
/* 2961 */         _size_ += CodedOutputStream.computeMessageSize(7, (Message)_e_.getValue());
/*      */       }
/* 2963 */       _size_ += CodedOutputStream.computeInt32Size(8, this.activitybpsys);
/* 2964 */       _size_ += CodedOutputStream.computeInt32Size(9, this.todaypropsysswitchcount);
/* 2965 */       _size_ += CodedOutputStream.computeInt64Size(10, this.timestamp);
/* 2966 */       _size_ += CodedOutputStream.computeMessageSize(11, this.location);
/* 2967 */       _size_ += CodedOutputStream.computeInt64Size(12, this.gold);
/* 2968 */       _size_ += CodedOutputStream.computeInt64Size(13, this.silver);
/* 2969 */       _size_ += CodedOutputStream.computeInt64Size(14, this.goldingot);
/* 2970 */       _size_ += CodedOutputStream.computeInt32Size(15, this.dyecolorid);
/* 2971 */       _size_ += CodedOutputStream.computeInt32Size(16, this.baoshidu);
/* 2972 */       _size_ += CodedOutputStream.computeInt64Size(17, this.lastlogintime);
/* 2973 */       _size_ += CodedOutputStream.computeInt64Size(18, this.lastlogofftime);
/* 2974 */       _size_ += CodedOutputStream.computeInt64Size(19, this.keeponlinetime);
/* 2975 */       _size_ += CodedOutputStream.computeInt32Size(20, this.fightvalue);
/* 2976 */       _size_ += CodedOutputStream.computeInt64Size(21, this.leveluptime);
/* 2977 */       _size_ += CodedOutputStream.computeInt64Size(22, this.accumulateleveluptime);
/* 2978 */       _size_ += CodedOutputStream.computeInt64Size(23, this.vigorrefreshtime);
/* 2979 */       _size_ += CodedOutputStream.computeInt32Size(24, this.convertxiulianexp);
/* 2980 */       for (Long _v_ : this.compensates)
/*      */       {
/* 2982 */         _size_ += CodedOutputStream.computeInt64Size(25, _v_.longValue());
/*      */       }
/* 2984 */       for (Map.Entry<Integer, xbean.GatherMapItemInfo> _e_ : this.gather_map_item_infos.entrySet())
/*      */       {
/* 2986 */         _size_ += CodedOutputStream.computeInt32Size(26, ((Integer)_e_.getKey()).intValue());
/* 2987 */         _size_ += CodedOutputStream.computeMessageSize(26, (Message)_e_.getValue());
/*      */       }
/* 2989 */       _size_ += CodedOutputStream.computeInt64Size(27, this.lastcalcuatetime);
/* 2990 */       _size_ += CodedOutputStream.computeInt32Size(28, this.dayonlineseconds);
/* 2991 */       _size_ += CodedOutputStream.computeInt64Size(29, this.onlineseconds);
/* 2992 */       _size_ += CodedOutputStream.computeInt32Size(30, this.send_recharge_times_tip_mail_no);
/* 2993 */       _size_ += CodedOutputStream.computeInt64Size(31, this.levelupcurtime);
/* 2994 */       for (Map.Entry<Integer, xbean.TransferOccupationPropertiesSys> _e_ : this.transfer_occupation_property_sys_map.entrySet())
/*      */       {
/* 2996 */         _size_ += CodedOutputStream.computeInt32Size(32, ((Integer)_e_.getKey()).intValue());
/* 2997 */         _size_ += CodedOutputStream.computeMessageSize(32, (Message)_e_.getValue());
/*      */       }
/* 2999 */       for (Map.Entry<Integer, xbean.CoinInfo> _e_ : this.coins.entrySet())
/*      */       {
/* 3001 */         _size_ += CodedOutputStream.computeInt32Size(33, ((Integer)_e_.getKey()).intValue());
/* 3002 */         _size_ += CodedOutputStream.computeMessageSize(33, (Message)_e_.getValue());
/*      */       }
/* 3004 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 3012 */         _output_.writeInt32(1, this.level);
/* 3013 */         _output_.writeInt32(2, this.exp);
/* 3014 */         _output_.writeInt32(3, this.hp);
/* 3015 */         _output_.writeInt32(4, this.mp);
/* 3016 */         _output_.writeInt32(5, this.anger);
/* 3017 */         _output_.writeInt32(6, this.vigor);
/* 3018 */         for (Map.Entry<Integer, xbean.BasicPropertiesSystem> _e_ : this.propertysysmap.entrySet())
/*      */         {
/* 3020 */           _output_.writeInt32(7, ((Integer)_e_.getKey()).intValue());
/* 3021 */           _output_.writeMessage(7, (Message)_e_.getValue());
/*      */         }
/* 3023 */         _output_.writeInt32(8, this.activitybpsys);
/* 3024 */         _output_.writeInt32(9, this.todaypropsysswitchcount);
/* 3025 */         _output_.writeInt64(10, this.timestamp);
/* 3026 */         _output_.writeMessage(11, this.location);
/* 3027 */         _output_.writeInt64(12, this.gold);
/* 3028 */         _output_.writeInt64(13, this.silver);
/* 3029 */         _output_.writeInt64(14, this.goldingot);
/* 3030 */         _output_.writeInt32(15, this.dyecolorid);
/* 3031 */         _output_.writeInt32(16, this.baoshidu);
/* 3032 */         _output_.writeInt64(17, this.lastlogintime);
/* 3033 */         _output_.writeInt64(18, this.lastlogofftime);
/* 3034 */         _output_.writeInt64(19, this.keeponlinetime);
/* 3035 */         _output_.writeInt32(20, this.fightvalue);
/* 3036 */         _output_.writeInt64(21, this.leveluptime);
/* 3037 */         _output_.writeInt64(22, this.accumulateleveluptime);
/* 3038 */         _output_.writeInt64(23, this.vigorrefreshtime);
/* 3039 */         _output_.writeInt32(24, this.convertxiulianexp);
/* 3040 */         for (Long _v_ : this.compensates)
/*      */         {
/* 3042 */           _output_.writeInt64(25, _v_.longValue());
/*      */         }
/* 3044 */         for (Map.Entry<Integer, xbean.GatherMapItemInfo> _e_ : this.gather_map_item_infos.entrySet())
/*      */         {
/* 3046 */           _output_.writeInt32(26, ((Integer)_e_.getKey()).intValue());
/* 3047 */           _output_.writeMessage(26, (Message)_e_.getValue());
/*      */         }
/* 3049 */         _output_.writeInt64(27, this.lastcalcuatetime);
/* 3050 */         _output_.writeInt32(28, this.dayonlineseconds);
/* 3051 */         _output_.writeInt64(29, this.onlineseconds);
/* 3052 */         _output_.writeInt32(30, this.send_recharge_times_tip_mail_no);
/* 3053 */         _output_.writeInt64(31, this.levelupcurtime);
/* 3054 */         for (Map.Entry<Integer, xbean.TransferOccupationPropertiesSys> _e_ : this.transfer_occupation_property_sys_map.entrySet())
/*      */         {
/* 3056 */           _output_.writeInt32(32, ((Integer)_e_.getKey()).intValue());
/* 3057 */           _output_.writeMessage(32, (Message)_e_.getValue());
/*      */         }
/* 3059 */         for (Map.Entry<Integer, xbean.CoinInfo> _e_ : this.coins.entrySet())
/*      */         {
/* 3061 */           _output_.writeInt32(33, ((Integer)_e_.getKey()).intValue());
/* 3062 */           _output_.writeMessage(33, (Message)_e_.getValue());
/*      */         }
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 3067 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 3069 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 3077 */         boolean done = false;
/* 3078 */         while (!done)
/*      */         {
/* 3080 */           int tag = _input_.readTag();
/* 3081 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/* 3085 */             done = true;
/* 3086 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/* 3090 */             this.level = _input_.readInt32();
/* 3091 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/* 3095 */             this.exp = _input_.readInt32();
/* 3096 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/* 3100 */             this.hp = _input_.readInt32();
/* 3101 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/* 3105 */             this.mp = _input_.readInt32();
/* 3106 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/* 3110 */             this.anger = _input_.readInt32();
/* 3111 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/* 3115 */             this.vigor = _input_.readInt32();
/* 3116 */             break;
/*      */           
/*      */ 
/*      */           case 56: 
/* 3120 */             int _k_ = 0;
/* 3121 */             _k_ = _input_.readInt32();
/* 3122 */             int readTag = _input_.readTag();
/* 3123 */             if (58 != readTag)
/*      */             {
/* 3125 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 3127 */             xbean.BasicPropertiesSystem _v_ = Pod.newBasicPropertiesSystemData();
/* 3128 */             _input_.readMessage(_v_);
/* 3129 */             this.propertysysmap.put(Integer.valueOf(_k_), _v_);
/* 3130 */             break;
/*      */           
/*      */ 
/*      */           case 64: 
/* 3134 */             this.activitybpsys = _input_.readInt32();
/* 3135 */             break;
/*      */           
/*      */ 
/*      */           case 72: 
/* 3139 */             this.todaypropsysswitchcount = _input_.readInt32();
/* 3140 */             break;
/*      */           
/*      */ 
/*      */           case 80: 
/* 3144 */             this.timestamp = _input_.readInt64();
/* 3145 */             break;
/*      */           
/*      */ 
/*      */           case 90: 
/* 3149 */             _input_.readMessage(this.location);
/* 3150 */             break;
/*      */           
/*      */ 
/*      */           case 96: 
/* 3154 */             this.gold = _input_.readInt64();
/* 3155 */             break;
/*      */           
/*      */ 
/*      */           case 104: 
/* 3159 */             this.silver = _input_.readInt64();
/* 3160 */             break;
/*      */           
/*      */ 
/*      */           case 112: 
/* 3164 */             this.goldingot = _input_.readInt64();
/* 3165 */             break;
/*      */           
/*      */ 
/*      */           case 120: 
/* 3169 */             this.dyecolorid = _input_.readInt32();
/* 3170 */             break;
/*      */           
/*      */ 
/*      */           case 128: 
/* 3174 */             this.baoshidu = _input_.readInt32();
/* 3175 */             break;
/*      */           
/*      */ 
/*      */           case 136: 
/* 3179 */             this.lastlogintime = _input_.readInt64();
/* 3180 */             break;
/*      */           
/*      */ 
/*      */           case 144: 
/* 3184 */             this.lastlogofftime = _input_.readInt64();
/* 3185 */             break;
/*      */           
/*      */ 
/*      */           case 152: 
/* 3189 */             this.keeponlinetime = _input_.readInt64();
/* 3190 */             break;
/*      */           
/*      */ 
/*      */           case 160: 
/* 3194 */             this.fightvalue = _input_.readInt32();
/* 3195 */             break;
/*      */           
/*      */ 
/*      */           case 168: 
/* 3199 */             this.leveluptime = _input_.readInt64();
/* 3200 */             break;
/*      */           
/*      */ 
/*      */           case 176: 
/* 3204 */             this.accumulateleveluptime = _input_.readInt64();
/* 3205 */             break;
/*      */           
/*      */ 
/*      */           case 184: 
/* 3209 */             this.vigorrefreshtime = _input_.readInt64();
/* 3210 */             break;
/*      */           
/*      */ 
/*      */           case 192: 
/* 3214 */             this.convertxiulianexp = _input_.readInt32();
/* 3215 */             break;
/*      */           
/*      */ 
/*      */           case 200: 
/* 3219 */             long _v_ = 0L;
/* 3220 */             _v_ = _input_.readInt64();
/* 3221 */             this.compensates.add(Long.valueOf(_v_));
/* 3222 */             break;
/*      */           
/*      */ 
/*      */           case 208: 
/* 3226 */             int _k_ = 0;
/* 3227 */             _k_ = _input_.readInt32();
/* 3228 */             int readTag = _input_.readTag();
/* 3229 */             if (210 != readTag)
/*      */             {
/* 3231 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 3233 */             xbean.GatherMapItemInfo _v_ = Pod.newGatherMapItemInfoData();
/* 3234 */             _input_.readMessage(_v_);
/* 3235 */             this.gather_map_item_infos.put(Integer.valueOf(_k_), _v_);
/* 3236 */             break;
/*      */           
/*      */ 
/*      */           case 216: 
/* 3240 */             this.lastcalcuatetime = _input_.readInt64();
/* 3241 */             break;
/*      */           
/*      */ 
/*      */           case 224: 
/* 3245 */             this.dayonlineseconds = _input_.readInt32();
/* 3246 */             break;
/*      */           
/*      */ 
/*      */           case 232: 
/* 3250 */             this.onlineseconds = _input_.readInt64();
/* 3251 */             break;
/*      */           
/*      */ 
/*      */           case 240: 
/* 3255 */             this.send_recharge_times_tip_mail_no = _input_.readInt32();
/* 3256 */             break;
/*      */           
/*      */ 
/*      */           case 248: 
/* 3260 */             this.levelupcurtime = _input_.readInt64();
/* 3261 */             break;
/*      */           
/*      */ 
/*      */           case 256: 
/* 3265 */             int _k_ = 0;
/* 3266 */             _k_ = _input_.readInt32();
/* 3267 */             int readTag = _input_.readTag();
/* 3268 */             if (258 != readTag)
/*      */             {
/* 3270 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 3272 */             xbean.TransferOccupationPropertiesSys _v_ = Pod.newTransferOccupationPropertiesSysData();
/* 3273 */             _input_.readMessage(_v_);
/* 3274 */             this.transfer_occupation_property_sys_map.put(Integer.valueOf(_k_), _v_);
/* 3275 */             break;
/*      */           
/*      */ 
/*      */           case 264: 
/* 3279 */             int _k_ = 0;
/* 3280 */             _k_ = _input_.readInt32();
/* 3281 */             int readTag = _input_.readTag();
/* 3282 */             if (266 != readTag)
/*      */             {
/* 3284 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 3286 */             xbean.CoinInfo _v_ = Pod.newCoinInfoData();
/* 3287 */             _input_.readMessage(_v_);
/* 3288 */             this.coins.put(Integer.valueOf(_k_), _v_);
/* 3289 */             break;
/*      */           
/*      */ 
/*      */           default: 
/* 3293 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/* 3295 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/* 3304 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 3308 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 3310 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Properties copy()
/*      */     {
/* 3316 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Properties toData()
/*      */     {
/* 3322 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.Properties toBean()
/*      */     {
/* 3327 */       return new Properties(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Properties toDataIf()
/*      */     {
/* 3333 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.Properties toBeanIf()
/*      */     {
/* 3338 */       return new Properties(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 3344 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean xdbParent() {
/* 3348 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 3352 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 3356 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean toConst() {
/* 3360 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 3364 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 3368 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getLevel()
/*      */     {
/* 3375 */       return this.level;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getExp()
/*      */     {
/* 3382 */       return this.exp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getHp()
/*      */     {
/* 3389 */       return this.hp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getMp()
/*      */     {
/* 3396 */       return this.mp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getAnger()
/*      */     {
/* 3403 */       return this.anger;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getVigor()
/*      */     {
/* 3410 */       return this.vigor;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.BasicPropertiesSystem> getPropertysysmap()
/*      */     {
/* 3417 */       return this.propertysysmap;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.BasicPropertiesSystem> getPropertysysmapAsData()
/*      */     {
/* 3424 */       return this.propertysysmap;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getActivitybpsys()
/*      */     {
/* 3431 */       return this.activitybpsys;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getTodaypropsysswitchcount()
/*      */     {
/* 3438 */       return this.todaypropsysswitchcount;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getTimestamp()
/*      */     {
/* 3445 */       return this.timestamp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public xbean.Location getLocation()
/*      */     {
/* 3452 */       return this.location;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getGold()
/*      */     {
/* 3459 */       return this.gold;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getSilver()
/*      */     {
/* 3466 */       return this.silver;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getGoldingot()
/*      */     {
/* 3473 */       return this.goldingot;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getDyecolorid()
/*      */     {
/* 3480 */       return this.dyecolorid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getBaoshidu()
/*      */     {
/* 3487 */       return this.baoshidu;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getLastlogintime()
/*      */     {
/* 3494 */       return this.lastlogintime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getLastlogofftime()
/*      */     {
/* 3501 */       return this.lastlogofftime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getKeeponlinetime()
/*      */     {
/* 3508 */       return this.keeponlinetime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getFightvalue()
/*      */     {
/* 3515 */       return this.fightvalue;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getLeveluptime()
/*      */     {
/* 3522 */       return this.leveluptime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getAccumulateleveluptime()
/*      */     {
/* 3529 */       return this.accumulateleveluptime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getVigorrefreshtime()
/*      */     {
/* 3536 */       return this.vigorrefreshtime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getConvertxiulianexp()
/*      */     {
/* 3543 */       return this.convertxiulianexp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Long> getCompensates()
/*      */     {
/* 3550 */       return this.compensates;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Long> getCompensatesAsData()
/*      */     {
/* 3557 */       return this.compensates;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.GatherMapItemInfo> getGather_map_item_infos()
/*      */     {
/* 3564 */       return this.gather_map_item_infos;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.GatherMapItemInfo> getGather_map_item_infosAsData()
/*      */     {
/* 3571 */       return this.gather_map_item_infos;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getLastcalcuatetime()
/*      */     {
/* 3578 */       return this.lastcalcuatetime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getDayonlineseconds()
/*      */     {
/* 3585 */       return this.dayonlineseconds;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getOnlineseconds()
/*      */     {
/* 3592 */       return this.onlineseconds;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getSend_recharge_times_tip_mail_no()
/*      */     {
/* 3599 */       return this.send_recharge_times_tip_mail_no;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getLevelupcurtime()
/*      */     {
/* 3606 */       return this.levelupcurtime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.TransferOccupationPropertiesSys> getTransfer_occupation_property_sys_map()
/*      */     {
/* 3613 */       return this.transfer_occupation_property_sys_map;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.TransferOccupationPropertiesSys> getTransfer_occupation_property_sys_mapAsData()
/*      */     {
/* 3620 */       return this.transfer_occupation_property_sys_map;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.CoinInfo> getCoins()
/*      */     {
/* 3627 */       return this.coins;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.CoinInfo> getCoinsAsData()
/*      */     {
/* 3634 */       return this.coins;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLevel(int _v_)
/*      */     {
/* 3641 */       this.level = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setExp(int _v_)
/*      */     {
/* 3648 */       this.exp = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setHp(int _v_)
/*      */     {
/* 3655 */       this.hp = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMp(int _v_)
/*      */     {
/* 3662 */       this.mp = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setAnger(int _v_)
/*      */     {
/* 3669 */       this.anger = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setVigor(int _v_)
/*      */     {
/* 3676 */       this.vigor = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setActivitybpsys(int _v_)
/*      */     {
/* 3683 */       this.activitybpsys = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setTodaypropsysswitchcount(int _v_)
/*      */     {
/* 3690 */       this.todaypropsysswitchcount = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setTimestamp(long _v_)
/*      */     {
/* 3697 */       this.timestamp = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setGold(long _v_)
/*      */     {
/* 3704 */       this.gold = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setSilver(long _v_)
/*      */     {
/* 3711 */       this.silver = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setGoldingot(long _v_)
/*      */     {
/* 3718 */       this.goldingot = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setDyecolorid(int _v_)
/*      */     {
/* 3725 */       this.dyecolorid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setBaoshidu(int _v_)
/*      */     {
/* 3732 */       this.baoshidu = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLastlogintime(long _v_)
/*      */     {
/* 3739 */       this.lastlogintime = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLastlogofftime(long _v_)
/*      */     {
/* 3746 */       this.lastlogofftime = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setKeeponlinetime(long _v_)
/*      */     {
/* 3753 */       this.keeponlinetime = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setFightvalue(int _v_)
/*      */     {
/* 3760 */       this.fightvalue = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLeveluptime(long _v_)
/*      */     {
/* 3767 */       this.leveluptime = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setAccumulateleveluptime(long _v_)
/*      */     {
/* 3774 */       this.accumulateleveluptime = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setVigorrefreshtime(long _v_)
/*      */     {
/* 3781 */       this.vigorrefreshtime = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setConvertxiulianexp(int _v_)
/*      */     {
/* 3788 */       this.convertxiulianexp = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLastcalcuatetime(long _v_)
/*      */     {
/* 3795 */       this.lastcalcuatetime = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setDayonlineseconds(int _v_)
/*      */     {
/* 3802 */       this.dayonlineseconds = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setOnlineseconds(long _v_)
/*      */     {
/* 3809 */       this.onlineseconds = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setSend_recharge_times_tip_mail_no(int _v_)
/*      */     {
/* 3816 */       this.send_recharge_times_tip_mail_no = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLevelupcurtime(long _v_)
/*      */     {
/* 3823 */       this.levelupcurtime = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 3829 */       if (!(_o1_ instanceof Data)) return false;
/* 3830 */       Data _o_ = (Data)_o1_;
/* 3831 */       if (this.level != _o_.level) return false;
/* 3832 */       if (this.exp != _o_.exp) return false;
/* 3833 */       if (this.hp != _o_.hp) return false;
/* 3834 */       if (this.mp != _o_.mp) return false;
/* 3835 */       if (this.anger != _o_.anger) return false;
/* 3836 */       if (this.vigor != _o_.vigor) return false;
/* 3837 */       if (!this.propertysysmap.equals(_o_.propertysysmap)) return false;
/* 3838 */       if (this.activitybpsys != _o_.activitybpsys) return false;
/* 3839 */       if (this.todaypropsysswitchcount != _o_.todaypropsysswitchcount) return false;
/* 3840 */       if (this.timestamp != _o_.timestamp) return false;
/* 3841 */       if (!this.location.equals(_o_.location)) return false;
/* 3842 */       if (this.gold != _o_.gold) return false;
/* 3843 */       if (this.silver != _o_.silver) return false;
/* 3844 */       if (this.goldingot != _o_.goldingot) return false;
/* 3845 */       if (this.dyecolorid != _o_.dyecolorid) return false;
/* 3846 */       if (this.baoshidu != _o_.baoshidu) return false;
/* 3847 */       if (this.lastlogintime != _o_.lastlogintime) return false;
/* 3848 */       if (this.lastlogofftime != _o_.lastlogofftime) return false;
/* 3849 */       if (this.keeponlinetime != _o_.keeponlinetime) return false;
/* 3850 */       if (this.fightvalue != _o_.fightvalue) return false;
/* 3851 */       if (this.leveluptime != _o_.leveluptime) return false;
/* 3852 */       if (this.accumulateleveluptime != _o_.accumulateleveluptime) return false;
/* 3853 */       if (this.vigorrefreshtime != _o_.vigorrefreshtime) return false;
/* 3854 */       if (this.convertxiulianexp != _o_.convertxiulianexp) return false;
/* 3855 */       if (!this.compensates.equals(_o_.compensates)) return false;
/* 3856 */       if (!this.gather_map_item_infos.equals(_o_.gather_map_item_infos)) return false;
/* 3857 */       if (this.lastcalcuatetime != _o_.lastcalcuatetime) return false;
/* 3858 */       if (this.dayonlineseconds != _o_.dayonlineseconds) return false;
/* 3859 */       if (this.onlineseconds != _o_.onlineseconds) return false;
/* 3860 */       if (this.send_recharge_times_tip_mail_no != _o_.send_recharge_times_tip_mail_no) return false;
/* 3861 */       if (this.levelupcurtime != _o_.levelupcurtime) return false;
/* 3862 */       if (!this.transfer_occupation_property_sys_map.equals(_o_.transfer_occupation_property_sys_map)) return false;
/* 3863 */       if (!this.coins.equals(_o_.coins)) return false;
/* 3864 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 3870 */       int _h_ = 0;
/* 3871 */       _h_ += this.level;
/* 3872 */       _h_ += this.exp;
/* 3873 */       _h_ += this.hp;
/* 3874 */       _h_ += this.mp;
/* 3875 */       _h_ += this.anger;
/* 3876 */       _h_ += this.vigor;
/* 3877 */       _h_ += this.propertysysmap.hashCode();
/* 3878 */       _h_ += this.activitybpsys;
/* 3879 */       _h_ += this.todaypropsysswitchcount;
/* 3880 */       _h_ = (int)(_h_ + this.timestamp);
/* 3881 */       _h_ += this.location.hashCode();
/* 3882 */       _h_ = (int)(_h_ + this.gold);
/* 3883 */       _h_ = (int)(_h_ + this.silver);
/* 3884 */       _h_ = (int)(_h_ + this.goldingot);
/* 3885 */       _h_ += this.dyecolorid;
/* 3886 */       _h_ += this.baoshidu;
/* 3887 */       _h_ = (int)(_h_ + this.lastlogintime);
/* 3888 */       _h_ = (int)(_h_ + this.lastlogofftime);
/* 3889 */       _h_ = (int)(_h_ + this.keeponlinetime);
/* 3890 */       _h_ += this.fightvalue;
/* 3891 */       _h_ = (int)(_h_ + this.leveluptime);
/* 3892 */       _h_ = (int)(_h_ + this.accumulateleveluptime);
/* 3893 */       _h_ = (int)(_h_ + this.vigorrefreshtime);
/* 3894 */       _h_ += this.convertxiulianexp;
/* 3895 */       _h_ += this.compensates.hashCode();
/* 3896 */       _h_ += this.gather_map_item_infos.hashCode();
/* 3897 */       _h_ = (int)(_h_ + this.lastcalcuatetime);
/* 3898 */       _h_ += this.dayonlineseconds;
/* 3899 */       _h_ = (int)(_h_ + this.onlineseconds);
/* 3900 */       _h_ += this.send_recharge_times_tip_mail_no;
/* 3901 */       _h_ = (int)(_h_ + this.levelupcurtime);
/* 3902 */       _h_ += this.transfer_occupation_property_sys_map.hashCode();
/* 3903 */       _h_ += this.coins.hashCode();
/* 3904 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 3910 */       StringBuilder _sb_ = new StringBuilder();
/* 3911 */       _sb_.append("(");
/* 3912 */       _sb_.append(this.level);
/* 3913 */       _sb_.append(",");
/* 3914 */       _sb_.append(this.exp);
/* 3915 */       _sb_.append(",");
/* 3916 */       _sb_.append(this.hp);
/* 3917 */       _sb_.append(",");
/* 3918 */       _sb_.append(this.mp);
/* 3919 */       _sb_.append(",");
/* 3920 */       _sb_.append(this.anger);
/* 3921 */       _sb_.append(",");
/* 3922 */       _sb_.append(this.vigor);
/* 3923 */       _sb_.append(",");
/* 3924 */       _sb_.append(this.propertysysmap);
/* 3925 */       _sb_.append(",");
/* 3926 */       _sb_.append(this.activitybpsys);
/* 3927 */       _sb_.append(",");
/* 3928 */       _sb_.append(this.todaypropsysswitchcount);
/* 3929 */       _sb_.append(",");
/* 3930 */       _sb_.append(this.timestamp);
/* 3931 */       _sb_.append(",");
/* 3932 */       _sb_.append(this.location);
/* 3933 */       _sb_.append(",");
/* 3934 */       _sb_.append(this.gold);
/* 3935 */       _sb_.append(",");
/* 3936 */       _sb_.append(this.silver);
/* 3937 */       _sb_.append(",");
/* 3938 */       _sb_.append(this.goldingot);
/* 3939 */       _sb_.append(",");
/* 3940 */       _sb_.append(this.dyecolorid);
/* 3941 */       _sb_.append(",");
/* 3942 */       _sb_.append(this.baoshidu);
/* 3943 */       _sb_.append(",");
/* 3944 */       _sb_.append(this.lastlogintime);
/* 3945 */       _sb_.append(",");
/* 3946 */       _sb_.append(this.lastlogofftime);
/* 3947 */       _sb_.append(",");
/* 3948 */       _sb_.append(this.keeponlinetime);
/* 3949 */       _sb_.append(",");
/* 3950 */       _sb_.append(this.fightvalue);
/* 3951 */       _sb_.append(",");
/* 3952 */       _sb_.append(this.leveluptime);
/* 3953 */       _sb_.append(",");
/* 3954 */       _sb_.append(this.accumulateleveluptime);
/* 3955 */       _sb_.append(",");
/* 3956 */       _sb_.append(this.vigorrefreshtime);
/* 3957 */       _sb_.append(",");
/* 3958 */       _sb_.append(this.convertxiulianexp);
/* 3959 */       _sb_.append(",");
/* 3960 */       _sb_.append(this.compensates);
/* 3961 */       _sb_.append(",");
/* 3962 */       _sb_.append(this.gather_map_item_infos);
/* 3963 */       _sb_.append(",");
/* 3964 */       _sb_.append(this.lastcalcuatetime);
/* 3965 */       _sb_.append(",");
/* 3966 */       _sb_.append(this.dayonlineseconds);
/* 3967 */       _sb_.append(",");
/* 3968 */       _sb_.append(this.onlineseconds);
/* 3969 */       _sb_.append(",");
/* 3970 */       _sb_.append(this.send_recharge_times_tip_mail_no);
/* 3971 */       _sb_.append(",");
/* 3972 */       _sb_.append(this.levelupcurtime);
/* 3973 */       _sb_.append(",");
/* 3974 */       _sb_.append(this.transfer_occupation_property_sys_map);
/* 3975 */       _sb_.append(",");
/* 3976 */       _sb_.append(this.coins);
/* 3977 */       _sb_.append(")");
/* 3978 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\Properties.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */