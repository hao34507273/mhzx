/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.MarshalException;
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.io.IOException;
/*      */ import java.util.HashMap;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
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
/*      */ import xdb.logs.LogInt;
/*      */ import xdb.logs.LogLong;
/*      */ import xdb.logs.LogObject;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public final class HomeInfo
/*      */   extends XBean
/*      */   implements xbean.HomeInfo
/*      */ {
/*      */   private int homelevel;
/*      */   private int cleanliness;
/*      */   private int petroomlevel;
/*      */   private int bedroomlevel;
/*      */   private int daycleancount;
/*      */   private int drugroomlevel;
/*      */   private int kitchenlevel;
/*      */   private int maidroomlevel;
/*      */   private HashMap<Long, xbean.MaidInfo> uuid2maidinfo;
/*      */   private long currentmaiduuid;
/*      */   private boolean ismainhome;
/*      */   private long updatetime;
/*      */   private HashMap<Long, xbean.FurnitureInfo> mydisplayfurniture;
/*      */   private HashMap<Long, xbean.FurnitureInfo> partnerdisplayfurniture;
/*      */   private int courtyardlevel;
/*      */   private int fengshui;
/*      */   private long walluuid;
/*      */   private long flooruuid;
/*      */   private int court_yard_beautiful;
/*      */   private long court_yard_cleanliness_refresh_time;
/*      */   private int court_yard_cleanliness;
/*      */   private int court_yard_day_clean_count;
/*      */   private long fence_uuid;
/*      */   private long court_yard_terrain_uuid;
/*      */   private long court_yard_road_uuid;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   66 */     this.homelevel = 0;
/*   67 */     this.cleanliness = 0;
/*   68 */     this.petroomlevel = 0;
/*   69 */     this.bedroomlevel = 0;
/*   70 */     this.daycleancount = 0;
/*   71 */     this.drugroomlevel = 0;
/*   72 */     this.kitchenlevel = 0;
/*   73 */     this.maidroomlevel = 0;
/*   74 */     this.uuid2maidinfo.clear();
/*   75 */     this.currentmaiduuid = 0L;
/*   76 */     this.ismainhome = false;
/*   77 */     this.updatetime = 0L;
/*   78 */     this.mydisplayfurniture.clear();
/*   79 */     this.partnerdisplayfurniture.clear();
/*   80 */     this.courtyardlevel = 0;
/*   81 */     this.fengshui = 0;
/*   82 */     this.walluuid = 0L;
/*   83 */     this.flooruuid = 0L;
/*   84 */     this.court_yard_beautiful = 0;
/*   85 */     this.court_yard_cleanliness_refresh_time = 0L;
/*   86 */     this.court_yard_cleanliness = 0;
/*   87 */     this.court_yard_day_clean_count = 0;
/*   88 */     this.fence_uuid = 0L;
/*   89 */     this.court_yard_terrain_uuid = 0L;
/*   90 */     this.court_yard_road_uuid = 0L;
/*      */   }
/*      */   
/*      */   HomeInfo(int __, XBean _xp_, String _vn_)
/*      */   {
/*   95 */     super(_xp_, _vn_);
/*   96 */     this.uuid2maidinfo = new HashMap();
/*   97 */     this.ismainhome = false;
/*   98 */     this.mydisplayfurniture = new HashMap();
/*   99 */     this.partnerdisplayfurniture = new HashMap();
/*      */   }
/*      */   
/*      */   public HomeInfo()
/*      */   {
/*  104 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public HomeInfo(HomeInfo _o_)
/*      */   {
/*  109 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   HomeInfo(xbean.HomeInfo _o1_, XBean _xp_, String _vn_)
/*      */   {
/*  114 */     super(_xp_, _vn_);
/*  115 */     if ((_o1_ instanceof HomeInfo)) { assign((HomeInfo)_o1_);
/*  116 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  117 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  118 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(HomeInfo _o_) {
/*  123 */     _o_._xdb_verify_unsafe_();
/*  124 */     this.homelevel = _o_.homelevel;
/*  125 */     this.cleanliness = _o_.cleanliness;
/*  126 */     this.petroomlevel = _o_.petroomlevel;
/*  127 */     this.bedroomlevel = _o_.bedroomlevel;
/*  128 */     this.daycleancount = _o_.daycleancount;
/*  129 */     this.drugroomlevel = _o_.drugroomlevel;
/*  130 */     this.kitchenlevel = _o_.kitchenlevel;
/*  131 */     this.maidroomlevel = _o_.maidroomlevel;
/*  132 */     this.uuid2maidinfo = new HashMap();
/*  133 */     for (Map.Entry<Long, xbean.MaidInfo> _e_ : _o_.uuid2maidinfo.entrySet())
/*  134 */       this.uuid2maidinfo.put(_e_.getKey(), new MaidInfo((xbean.MaidInfo)_e_.getValue(), this, "uuid2maidinfo"));
/*  135 */     this.currentmaiduuid = _o_.currentmaiduuid;
/*  136 */     this.ismainhome = _o_.ismainhome;
/*  137 */     this.updatetime = _o_.updatetime;
/*  138 */     this.mydisplayfurniture = new HashMap();
/*  139 */     for (Map.Entry<Long, xbean.FurnitureInfo> _e_ : _o_.mydisplayfurniture.entrySet())
/*  140 */       this.mydisplayfurniture.put(_e_.getKey(), new FurnitureInfo((xbean.FurnitureInfo)_e_.getValue(), this, "mydisplayfurniture"));
/*  141 */     this.partnerdisplayfurniture = new HashMap();
/*  142 */     for (Map.Entry<Long, xbean.FurnitureInfo> _e_ : _o_.partnerdisplayfurniture.entrySet())
/*  143 */       this.partnerdisplayfurniture.put(_e_.getKey(), new FurnitureInfo((xbean.FurnitureInfo)_e_.getValue(), this, "partnerdisplayfurniture"));
/*  144 */     this.courtyardlevel = _o_.courtyardlevel;
/*  145 */     this.fengshui = _o_.fengshui;
/*  146 */     this.walluuid = _o_.walluuid;
/*  147 */     this.flooruuid = _o_.flooruuid;
/*  148 */     this.court_yard_beautiful = _o_.court_yard_beautiful;
/*  149 */     this.court_yard_cleanliness_refresh_time = _o_.court_yard_cleanliness_refresh_time;
/*  150 */     this.court_yard_cleanliness = _o_.court_yard_cleanliness;
/*  151 */     this.court_yard_day_clean_count = _o_.court_yard_day_clean_count;
/*  152 */     this.fence_uuid = _o_.fence_uuid;
/*  153 */     this.court_yard_terrain_uuid = _o_.court_yard_terrain_uuid;
/*  154 */     this.court_yard_road_uuid = _o_.court_yard_road_uuid;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*  159 */     this.homelevel = _o_.homelevel;
/*  160 */     this.cleanliness = _o_.cleanliness;
/*  161 */     this.petroomlevel = _o_.petroomlevel;
/*  162 */     this.bedroomlevel = _o_.bedroomlevel;
/*  163 */     this.daycleancount = _o_.daycleancount;
/*  164 */     this.drugroomlevel = _o_.drugroomlevel;
/*  165 */     this.kitchenlevel = _o_.kitchenlevel;
/*  166 */     this.maidroomlevel = _o_.maidroomlevel;
/*  167 */     this.uuid2maidinfo = new HashMap();
/*  168 */     for (Map.Entry<Long, xbean.MaidInfo> _e_ : _o_.uuid2maidinfo.entrySet())
/*  169 */       this.uuid2maidinfo.put(_e_.getKey(), new MaidInfo((xbean.MaidInfo)_e_.getValue(), this, "uuid2maidinfo"));
/*  170 */     this.currentmaiduuid = _o_.currentmaiduuid;
/*  171 */     this.ismainhome = _o_.ismainhome;
/*  172 */     this.updatetime = _o_.updatetime;
/*  173 */     this.mydisplayfurniture = new HashMap();
/*  174 */     for (Map.Entry<Long, xbean.FurnitureInfo> _e_ : _o_.mydisplayfurniture.entrySet())
/*  175 */       this.mydisplayfurniture.put(_e_.getKey(), new FurnitureInfo((xbean.FurnitureInfo)_e_.getValue(), this, "mydisplayfurniture"));
/*  176 */     this.partnerdisplayfurniture = new HashMap();
/*  177 */     for (Map.Entry<Long, xbean.FurnitureInfo> _e_ : _o_.partnerdisplayfurniture.entrySet())
/*  178 */       this.partnerdisplayfurniture.put(_e_.getKey(), new FurnitureInfo((xbean.FurnitureInfo)_e_.getValue(), this, "partnerdisplayfurniture"));
/*  179 */     this.courtyardlevel = _o_.courtyardlevel;
/*  180 */     this.fengshui = _o_.fengshui;
/*  181 */     this.walluuid = _o_.walluuid;
/*  182 */     this.flooruuid = _o_.flooruuid;
/*  183 */     this.court_yard_beautiful = _o_.court_yard_beautiful;
/*  184 */     this.court_yard_cleanliness_refresh_time = _o_.court_yard_cleanliness_refresh_time;
/*  185 */     this.court_yard_cleanliness = _o_.court_yard_cleanliness;
/*  186 */     this.court_yard_day_clean_count = _o_.court_yard_day_clean_count;
/*  187 */     this.fence_uuid = _o_.fence_uuid;
/*  188 */     this.court_yard_terrain_uuid = _o_.court_yard_terrain_uuid;
/*  189 */     this.court_yard_road_uuid = _o_.court_yard_road_uuid;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*  195 */     _xdb_verify_unsafe_();
/*  196 */     _os_.marshal(this.homelevel);
/*  197 */     _os_.marshal(this.cleanliness);
/*  198 */     _os_.marshal(this.petroomlevel);
/*  199 */     _os_.marshal(this.bedroomlevel);
/*  200 */     _os_.marshal(this.daycleancount);
/*  201 */     _os_.marshal(this.drugroomlevel);
/*  202 */     _os_.marshal(this.kitchenlevel);
/*  203 */     _os_.marshal(this.maidroomlevel);
/*  204 */     _os_.compact_uint32(this.uuid2maidinfo.size());
/*  205 */     for (Map.Entry<Long, xbean.MaidInfo> _e_ : this.uuid2maidinfo.entrySet())
/*      */     {
/*  207 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  208 */       ((xbean.MaidInfo)_e_.getValue()).marshal(_os_);
/*      */     }
/*  210 */     _os_.marshal(this.currentmaiduuid);
/*  211 */     _os_.marshal(this.ismainhome);
/*  212 */     _os_.marshal(this.updatetime);
/*  213 */     _os_.compact_uint32(this.mydisplayfurniture.size());
/*  214 */     for (Map.Entry<Long, xbean.FurnitureInfo> _e_ : this.mydisplayfurniture.entrySet())
/*      */     {
/*  216 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  217 */       ((xbean.FurnitureInfo)_e_.getValue()).marshal(_os_);
/*      */     }
/*  219 */     _os_.compact_uint32(this.partnerdisplayfurniture.size());
/*  220 */     for (Map.Entry<Long, xbean.FurnitureInfo> _e_ : this.partnerdisplayfurniture.entrySet())
/*      */     {
/*  222 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  223 */       ((xbean.FurnitureInfo)_e_.getValue()).marshal(_os_);
/*      */     }
/*  225 */     _os_.marshal(this.courtyardlevel);
/*  226 */     _os_.marshal(this.fengshui);
/*  227 */     _os_.marshal(this.walluuid);
/*  228 */     _os_.marshal(this.flooruuid);
/*  229 */     _os_.marshal(this.court_yard_beautiful);
/*  230 */     _os_.marshal(this.court_yard_cleanliness_refresh_time);
/*  231 */     _os_.marshal(this.court_yard_cleanliness);
/*  232 */     _os_.marshal(this.court_yard_day_clean_count);
/*  233 */     _os_.marshal(this.fence_uuid);
/*  234 */     _os_.marshal(this.court_yard_terrain_uuid);
/*  235 */     _os_.marshal(this.court_yard_road_uuid);
/*  236 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws MarshalException
/*      */   {
/*  242 */     _xdb_verify_unsafe_();
/*  243 */     this.homelevel = _os_.unmarshal_int();
/*  244 */     this.cleanliness = _os_.unmarshal_int();
/*  245 */     this.petroomlevel = _os_.unmarshal_int();
/*  246 */     this.bedroomlevel = _os_.unmarshal_int();
/*  247 */     this.daycleancount = _os_.unmarshal_int();
/*  248 */     this.drugroomlevel = _os_.unmarshal_int();
/*  249 */     this.kitchenlevel = _os_.unmarshal_int();
/*  250 */     this.maidroomlevel = _os_.unmarshal_int();
/*      */     
/*  252 */     int size = _os_.uncompact_uint32();
/*  253 */     if (size >= 12)
/*      */     {
/*  255 */       this.uuid2maidinfo = new HashMap(size * 2);
/*      */     }
/*  257 */     for (; size > 0; size--)
/*      */     {
/*  259 */       long _k_ = 0L;
/*  260 */       _k_ = _os_.unmarshal_long();
/*  261 */       xbean.MaidInfo _v_ = new MaidInfo(0, this, "uuid2maidinfo");
/*  262 */       _v_.unmarshal(_os_);
/*  263 */       this.uuid2maidinfo.put(Long.valueOf(_k_), _v_);
/*      */     }
/*      */     
/*  266 */     this.currentmaiduuid = _os_.unmarshal_long();
/*  267 */     this.ismainhome = _os_.unmarshal_boolean();
/*  268 */     this.updatetime = _os_.unmarshal_long();
/*      */     
/*  270 */     int size = _os_.uncompact_uint32();
/*  271 */     if (size >= 12)
/*      */     {
/*  273 */       this.mydisplayfurniture = new HashMap(size * 2);
/*      */     }
/*  275 */     for (; size > 0; size--)
/*      */     {
/*  277 */       long _k_ = 0L;
/*  278 */       _k_ = _os_.unmarshal_long();
/*  279 */       xbean.FurnitureInfo _v_ = new FurnitureInfo(0, this, "mydisplayfurniture");
/*  280 */       _v_.unmarshal(_os_);
/*  281 */       this.mydisplayfurniture.put(Long.valueOf(_k_), _v_);
/*      */     }
/*      */     
/*      */ 
/*  285 */     int size = _os_.uncompact_uint32();
/*  286 */     if (size >= 12)
/*      */     {
/*  288 */       this.partnerdisplayfurniture = new HashMap(size * 2);
/*      */     }
/*  290 */     for (; size > 0; size--)
/*      */     {
/*  292 */       long _k_ = 0L;
/*  293 */       _k_ = _os_.unmarshal_long();
/*  294 */       xbean.FurnitureInfo _v_ = new FurnitureInfo(0, this, "partnerdisplayfurniture");
/*  295 */       _v_.unmarshal(_os_);
/*  296 */       this.partnerdisplayfurniture.put(Long.valueOf(_k_), _v_);
/*      */     }
/*      */     
/*  299 */     this.courtyardlevel = _os_.unmarshal_int();
/*  300 */     this.fengshui = _os_.unmarshal_int();
/*  301 */     this.walluuid = _os_.unmarshal_long();
/*  302 */     this.flooruuid = _os_.unmarshal_long();
/*  303 */     this.court_yard_beautiful = _os_.unmarshal_int();
/*  304 */     this.court_yard_cleanliness_refresh_time = _os_.unmarshal_long();
/*  305 */     this.court_yard_cleanliness = _os_.unmarshal_int();
/*  306 */     this.court_yard_day_clean_count = _os_.unmarshal_int();
/*  307 */     this.fence_uuid = _os_.unmarshal_long();
/*  308 */     this.court_yard_terrain_uuid = _os_.unmarshal_long();
/*  309 */     this.court_yard_road_uuid = _os_.unmarshal_long();
/*  310 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  316 */     _xdb_verify_unsafe_();
/*  317 */     int _size_ = 0;
/*  318 */     _size_ += CodedOutputStream.computeInt32Size(1, this.homelevel);
/*  319 */     _size_ += CodedOutputStream.computeInt32Size(2, this.cleanliness);
/*  320 */     _size_ += CodedOutputStream.computeInt32Size(3, this.petroomlevel);
/*  321 */     _size_ += CodedOutputStream.computeInt32Size(4, this.bedroomlevel);
/*  322 */     _size_ += CodedOutputStream.computeInt32Size(5, this.daycleancount);
/*  323 */     _size_ += CodedOutputStream.computeInt32Size(6, this.drugroomlevel);
/*  324 */     _size_ += CodedOutputStream.computeInt32Size(7, this.kitchenlevel);
/*  325 */     _size_ += CodedOutputStream.computeInt32Size(8, this.maidroomlevel);
/*  326 */     for (Map.Entry<Long, xbean.MaidInfo> _e_ : this.uuid2maidinfo.entrySet())
/*      */     {
/*  328 */       _size_ += CodedOutputStream.computeInt64Size(9, ((Long)_e_.getKey()).longValue());
/*  329 */       _size_ += CodedOutputStream.computeMessageSize(9, (Message)_e_.getValue());
/*      */     }
/*  331 */     _size_ += CodedOutputStream.computeInt64Size(10, this.currentmaiduuid);
/*  332 */     _size_ += CodedOutputStream.computeBoolSize(11, this.ismainhome);
/*  333 */     _size_ += CodedOutputStream.computeInt64Size(12, this.updatetime);
/*  334 */     for (Map.Entry<Long, xbean.FurnitureInfo> _e_ : this.mydisplayfurniture.entrySet())
/*      */     {
/*  336 */       _size_ += CodedOutputStream.computeInt64Size(13, ((Long)_e_.getKey()).longValue());
/*  337 */       _size_ += CodedOutputStream.computeMessageSize(13, (Message)_e_.getValue());
/*      */     }
/*  339 */     for (Map.Entry<Long, xbean.FurnitureInfo> _e_ : this.partnerdisplayfurniture.entrySet())
/*      */     {
/*  341 */       _size_ += CodedOutputStream.computeInt64Size(14, ((Long)_e_.getKey()).longValue());
/*  342 */       _size_ += CodedOutputStream.computeMessageSize(14, (Message)_e_.getValue());
/*      */     }
/*  344 */     _size_ += CodedOutputStream.computeInt32Size(15, this.courtyardlevel);
/*  345 */     _size_ += CodedOutputStream.computeInt32Size(16, this.fengshui);
/*  346 */     _size_ += CodedOutputStream.computeInt64Size(17, this.walluuid);
/*  347 */     _size_ += CodedOutputStream.computeInt64Size(18, this.flooruuid);
/*  348 */     _size_ += CodedOutputStream.computeInt32Size(21, this.court_yard_beautiful);
/*  349 */     _size_ += CodedOutputStream.computeInt64Size(22, this.court_yard_cleanliness_refresh_time);
/*  350 */     _size_ += CodedOutputStream.computeInt32Size(23, this.court_yard_cleanliness);
/*  351 */     _size_ += CodedOutputStream.computeInt32Size(24, this.court_yard_day_clean_count);
/*  352 */     _size_ += CodedOutputStream.computeInt64Size(25, this.fence_uuid);
/*  353 */     _size_ += CodedOutputStream.computeInt64Size(26, this.court_yard_terrain_uuid);
/*  354 */     _size_ += CodedOutputStream.computeInt64Size(27, this.court_yard_road_uuid);
/*  355 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  361 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  364 */       _output_.writeInt32(1, this.homelevel);
/*  365 */       _output_.writeInt32(2, this.cleanliness);
/*  366 */       _output_.writeInt32(3, this.petroomlevel);
/*  367 */       _output_.writeInt32(4, this.bedroomlevel);
/*  368 */       _output_.writeInt32(5, this.daycleancount);
/*  369 */       _output_.writeInt32(6, this.drugroomlevel);
/*  370 */       _output_.writeInt32(7, this.kitchenlevel);
/*  371 */       _output_.writeInt32(8, this.maidroomlevel);
/*  372 */       for (Map.Entry<Long, xbean.MaidInfo> _e_ : this.uuid2maidinfo.entrySet())
/*      */       {
/*  374 */         _output_.writeInt64(9, ((Long)_e_.getKey()).longValue());
/*  375 */         _output_.writeMessage(9, (Message)_e_.getValue());
/*      */       }
/*  377 */       _output_.writeInt64(10, this.currentmaiduuid);
/*  378 */       _output_.writeBool(11, this.ismainhome);
/*  379 */       _output_.writeInt64(12, this.updatetime);
/*  380 */       for (Map.Entry<Long, xbean.FurnitureInfo> _e_ : this.mydisplayfurniture.entrySet())
/*      */       {
/*  382 */         _output_.writeInt64(13, ((Long)_e_.getKey()).longValue());
/*  383 */         _output_.writeMessage(13, (Message)_e_.getValue());
/*      */       }
/*  385 */       for (Map.Entry<Long, xbean.FurnitureInfo> _e_ : this.partnerdisplayfurniture.entrySet())
/*      */       {
/*  387 */         _output_.writeInt64(14, ((Long)_e_.getKey()).longValue());
/*  388 */         _output_.writeMessage(14, (Message)_e_.getValue());
/*      */       }
/*  390 */       _output_.writeInt32(15, this.courtyardlevel);
/*  391 */       _output_.writeInt32(16, this.fengshui);
/*  392 */       _output_.writeInt64(17, this.walluuid);
/*  393 */       _output_.writeInt64(18, this.flooruuid);
/*  394 */       _output_.writeInt32(21, this.court_yard_beautiful);
/*  395 */       _output_.writeInt64(22, this.court_yard_cleanliness_refresh_time);
/*  396 */       _output_.writeInt32(23, this.court_yard_cleanliness);
/*  397 */       _output_.writeInt32(24, this.court_yard_day_clean_count);
/*  398 */       _output_.writeInt64(25, this.fence_uuid);
/*  399 */       _output_.writeInt64(26, this.court_yard_terrain_uuid);
/*  400 */       _output_.writeInt64(27, this.court_yard_road_uuid);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  404 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  406 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  412 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  415 */       boolean done = false;
/*  416 */       while (!done)
/*      */       {
/*  418 */         int tag = _input_.readTag();
/*  419 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  423 */           done = true;
/*  424 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  428 */           this.homelevel = _input_.readInt32();
/*  429 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  433 */           this.cleanliness = _input_.readInt32();
/*  434 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  438 */           this.petroomlevel = _input_.readInt32();
/*  439 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  443 */           this.bedroomlevel = _input_.readInt32();
/*  444 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  448 */           this.daycleancount = _input_.readInt32();
/*  449 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  453 */           this.drugroomlevel = _input_.readInt32();
/*  454 */           break;
/*      */         
/*      */ 
/*      */         case 56: 
/*  458 */           this.kitchenlevel = _input_.readInt32();
/*  459 */           break;
/*      */         
/*      */ 
/*      */         case 64: 
/*  463 */           this.maidroomlevel = _input_.readInt32();
/*  464 */           break;
/*      */         
/*      */ 
/*      */         case 72: 
/*  468 */           long _k_ = 0L;
/*  469 */           _k_ = _input_.readInt64();
/*  470 */           int readTag = _input_.readTag();
/*  471 */           if (74 != readTag)
/*      */           {
/*  473 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  475 */           xbean.MaidInfo _v_ = new MaidInfo(0, this, "uuid2maidinfo");
/*  476 */           _input_.readMessage(_v_);
/*  477 */           this.uuid2maidinfo.put(Long.valueOf(_k_), _v_);
/*  478 */           break;
/*      */         
/*      */ 
/*      */         case 80: 
/*  482 */           this.currentmaiduuid = _input_.readInt64();
/*  483 */           break;
/*      */         
/*      */ 
/*      */         case 88: 
/*  487 */           this.ismainhome = _input_.readBool();
/*  488 */           break;
/*      */         
/*      */ 
/*      */         case 96: 
/*  492 */           this.updatetime = _input_.readInt64();
/*  493 */           break;
/*      */         
/*      */ 
/*      */         case 104: 
/*  497 */           long _k_ = 0L;
/*  498 */           _k_ = _input_.readInt64();
/*  499 */           int readTag = _input_.readTag();
/*  500 */           if (106 != readTag)
/*      */           {
/*  502 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  504 */           xbean.FurnitureInfo _v_ = new FurnitureInfo(0, this, "mydisplayfurniture");
/*  505 */           _input_.readMessage(_v_);
/*  506 */           this.mydisplayfurniture.put(Long.valueOf(_k_), _v_);
/*  507 */           break;
/*      */         
/*      */ 
/*      */         case 112: 
/*  511 */           long _k_ = 0L;
/*  512 */           _k_ = _input_.readInt64();
/*  513 */           int readTag = _input_.readTag();
/*  514 */           if (114 != readTag)
/*      */           {
/*  516 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  518 */           xbean.FurnitureInfo _v_ = new FurnitureInfo(0, this, "partnerdisplayfurniture");
/*  519 */           _input_.readMessage(_v_);
/*  520 */           this.partnerdisplayfurniture.put(Long.valueOf(_k_), _v_);
/*  521 */           break;
/*      */         
/*      */ 
/*      */         case 120: 
/*  525 */           this.courtyardlevel = _input_.readInt32();
/*  526 */           break;
/*      */         
/*      */ 
/*      */         case 128: 
/*  530 */           this.fengshui = _input_.readInt32();
/*  531 */           break;
/*      */         
/*      */ 
/*      */         case 136: 
/*  535 */           this.walluuid = _input_.readInt64();
/*  536 */           break;
/*      */         
/*      */ 
/*      */         case 144: 
/*  540 */           this.flooruuid = _input_.readInt64();
/*  541 */           break;
/*      */         
/*      */ 
/*      */         case 168: 
/*  545 */           this.court_yard_beautiful = _input_.readInt32();
/*  546 */           break;
/*      */         
/*      */ 
/*      */         case 176: 
/*  550 */           this.court_yard_cleanliness_refresh_time = _input_.readInt64();
/*  551 */           break;
/*      */         
/*      */ 
/*      */         case 184: 
/*  555 */           this.court_yard_cleanliness = _input_.readInt32();
/*  556 */           break;
/*      */         
/*      */ 
/*      */         case 192: 
/*  560 */           this.court_yard_day_clean_count = _input_.readInt32();
/*  561 */           break;
/*      */         
/*      */ 
/*      */         case 200: 
/*  565 */           this.fence_uuid = _input_.readInt64();
/*  566 */           break;
/*      */         
/*      */ 
/*      */         case 208: 
/*  570 */           this.court_yard_terrain_uuid = _input_.readInt64();
/*  571 */           break;
/*      */         
/*      */ 
/*      */         case 216: 
/*  575 */           this.court_yard_road_uuid = _input_.readInt64();
/*  576 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  580 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  582 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  591 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  595 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  597 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.HomeInfo copy()
/*      */   {
/*  603 */     _xdb_verify_unsafe_();
/*  604 */     return new HomeInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.HomeInfo toData()
/*      */   {
/*  610 */     _xdb_verify_unsafe_();
/*  611 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.HomeInfo toBean()
/*      */   {
/*  616 */     _xdb_verify_unsafe_();
/*  617 */     return new HomeInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.HomeInfo toDataIf()
/*      */   {
/*  623 */     _xdb_verify_unsafe_();
/*  624 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.HomeInfo toBeanIf()
/*      */   {
/*  629 */     _xdb_verify_unsafe_();
/*  630 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public Bean toConst()
/*      */   {
/*  636 */     _xdb_verify_unsafe_();
/*  637 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getHomelevel()
/*      */   {
/*  644 */     _xdb_verify_unsafe_();
/*  645 */     return this.homelevel;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getCleanliness()
/*      */   {
/*  652 */     _xdb_verify_unsafe_();
/*  653 */     return this.cleanliness;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getPetroomlevel()
/*      */   {
/*  660 */     _xdb_verify_unsafe_();
/*  661 */     return this.petroomlevel;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getBedroomlevel()
/*      */   {
/*  668 */     _xdb_verify_unsafe_();
/*  669 */     return this.bedroomlevel;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getDaycleancount()
/*      */   {
/*  676 */     _xdb_verify_unsafe_();
/*  677 */     return this.daycleancount;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getDrugroomlevel()
/*      */   {
/*  684 */     _xdb_verify_unsafe_();
/*  685 */     return this.drugroomlevel;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getKitchenlevel()
/*      */   {
/*  692 */     _xdb_verify_unsafe_();
/*  693 */     return this.kitchenlevel;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getMaidroomlevel()
/*      */   {
/*  700 */     _xdb_verify_unsafe_();
/*  701 */     return this.maidroomlevel;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, xbean.MaidInfo> getUuid2maidinfo()
/*      */   {
/*  708 */     _xdb_verify_unsafe_();
/*  709 */     return Logs.logMap(new LogKey(this, "uuid2maidinfo"), this.uuid2maidinfo);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, xbean.MaidInfo> getUuid2maidinfoAsData()
/*      */   {
/*  716 */     _xdb_verify_unsafe_();
/*      */     
/*  718 */     HomeInfo _o_ = this;
/*  719 */     Map<Long, xbean.MaidInfo> uuid2maidinfo = new HashMap();
/*  720 */     for (Map.Entry<Long, xbean.MaidInfo> _e_ : _o_.uuid2maidinfo.entrySet())
/*  721 */       uuid2maidinfo.put(_e_.getKey(), new MaidInfo.Data((xbean.MaidInfo)_e_.getValue()));
/*  722 */     return uuid2maidinfo;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getCurrentmaiduuid()
/*      */   {
/*  729 */     _xdb_verify_unsafe_();
/*  730 */     return this.currentmaiduuid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public boolean getIsmainhome()
/*      */   {
/*  737 */     _xdb_verify_unsafe_();
/*  738 */     return this.ismainhome;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getUpdatetime()
/*      */   {
/*  745 */     _xdb_verify_unsafe_();
/*  746 */     return this.updatetime;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, xbean.FurnitureInfo> getMydisplayfurniture()
/*      */   {
/*  753 */     _xdb_verify_unsafe_();
/*  754 */     return Logs.logMap(new LogKey(this, "mydisplayfurniture"), this.mydisplayfurniture);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, xbean.FurnitureInfo> getMydisplayfurnitureAsData()
/*      */   {
/*  761 */     _xdb_verify_unsafe_();
/*      */     
/*  763 */     HomeInfo _o_ = this;
/*  764 */     Map<Long, xbean.FurnitureInfo> mydisplayfurniture = new HashMap();
/*  765 */     for (Map.Entry<Long, xbean.FurnitureInfo> _e_ : _o_.mydisplayfurniture.entrySet())
/*  766 */       mydisplayfurniture.put(_e_.getKey(), new FurnitureInfo.Data((xbean.FurnitureInfo)_e_.getValue()));
/*  767 */     return mydisplayfurniture;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, xbean.FurnitureInfo> getPartnerdisplayfurniture()
/*      */   {
/*  774 */     _xdb_verify_unsafe_();
/*  775 */     return Logs.logMap(new LogKey(this, "partnerdisplayfurniture"), this.partnerdisplayfurniture);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, xbean.FurnitureInfo> getPartnerdisplayfurnitureAsData()
/*      */   {
/*  782 */     _xdb_verify_unsafe_();
/*      */     
/*  784 */     HomeInfo _o_ = this;
/*  785 */     Map<Long, xbean.FurnitureInfo> partnerdisplayfurniture = new HashMap();
/*  786 */     for (Map.Entry<Long, xbean.FurnitureInfo> _e_ : _o_.partnerdisplayfurniture.entrySet())
/*  787 */       partnerdisplayfurniture.put(_e_.getKey(), new FurnitureInfo.Data((xbean.FurnitureInfo)_e_.getValue()));
/*  788 */     return partnerdisplayfurniture;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getCourtyardlevel()
/*      */   {
/*  795 */     _xdb_verify_unsafe_();
/*  796 */     return this.courtyardlevel;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getFengshui()
/*      */   {
/*  803 */     _xdb_verify_unsafe_();
/*  804 */     return this.fengshui;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getWalluuid()
/*      */   {
/*  811 */     _xdb_verify_unsafe_();
/*  812 */     return this.walluuid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getFlooruuid()
/*      */   {
/*  819 */     _xdb_verify_unsafe_();
/*  820 */     return this.flooruuid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getCourt_yard_beautiful()
/*      */   {
/*  827 */     _xdb_verify_unsafe_();
/*  828 */     return this.court_yard_beautiful;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getCourt_yard_cleanliness_refresh_time()
/*      */   {
/*  835 */     _xdb_verify_unsafe_();
/*  836 */     return this.court_yard_cleanliness_refresh_time;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getCourt_yard_cleanliness()
/*      */   {
/*  843 */     _xdb_verify_unsafe_();
/*  844 */     return this.court_yard_cleanliness;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getCourt_yard_day_clean_count()
/*      */   {
/*  851 */     _xdb_verify_unsafe_();
/*  852 */     return this.court_yard_day_clean_count;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getFence_uuid()
/*      */   {
/*  859 */     _xdb_verify_unsafe_();
/*  860 */     return this.fence_uuid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getCourt_yard_terrain_uuid()
/*      */   {
/*  867 */     _xdb_verify_unsafe_();
/*  868 */     return this.court_yard_terrain_uuid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getCourt_yard_road_uuid()
/*      */   {
/*  875 */     _xdb_verify_unsafe_();
/*  876 */     return this.court_yard_road_uuid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setHomelevel(int _v_)
/*      */   {
/*  883 */     _xdb_verify_unsafe_();
/*  884 */     Logs.logIf(new LogKey(this, "homelevel")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  888 */         new LogInt(this, HomeInfo.this.homelevel)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  892 */             HomeInfo.this.homelevel = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  896 */     });
/*  897 */     this.homelevel = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setCleanliness(int _v_)
/*      */   {
/*  904 */     _xdb_verify_unsafe_();
/*  905 */     Logs.logIf(new LogKey(this, "cleanliness")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  909 */         new LogInt(this, HomeInfo.this.cleanliness)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  913 */             HomeInfo.this.cleanliness = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  917 */     });
/*  918 */     this.cleanliness = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setPetroomlevel(int _v_)
/*      */   {
/*  925 */     _xdb_verify_unsafe_();
/*  926 */     Logs.logIf(new LogKey(this, "petroomlevel")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  930 */         new LogInt(this, HomeInfo.this.petroomlevel)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  934 */             HomeInfo.this.petroomlevel = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  938 */     });
/*  939 */     this.petroomlevel = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setBedroomlevel(int _v_)
/*      */   {
/*  946 */     _xdb_verify_unsafe_();
/*  947 */     Logs.logIf(new LogKey(this, "bedroomlevel")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  951 */         new LogInt(this, HomeInfo.this.bedroomlevel)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  955 */             HomeInfo.this.bedroomlevel = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  959 */     });
/*  960 */     this.bedroomlevel = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setDaycleancount(int _v_)
/*      */   {
/*  967 */     _xdb_verify_unsafe_();
/*  968 */     Logs.logIf(new LogKey(this, "daycleancount")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  972 */         new LogInt(this, HomeInfo.this.daycleancount)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  976 */             HomeInfo.this.daycleancount = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  980 */     });
/*  981 */     this.daycleancount = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setDrugroomlevel(int _v_)
/*      */   {
/*  988 */     _xdb_verify_unsafe_();
/*  989 */     Logs.logIf(new LogKey(this, "drugroomlevel")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  993 */         new LogInt(this, HomeInfo.this.drugroomlevel)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  997 */             HomeInfo.this.drugroomlevel = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1001 */     });
/* 1002 */     this.drugroomlevel = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setKitchenlevel(int _v_)
/*      */   {
/* 1009 */     _xdb_verify_unsafe_();
/* 1010 */     Logs.logIf(new LogKey(this, "kitchenlevel")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1014 */         new LogInt(this, HomeInfo.this.kitchenlevel)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1018 */             HomeInfo.this.kitchenlevel = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1022 */     });
/* 1023 */     this.kitchenlevel = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setMaidroomlevel(int _v_)
/*      */   {
/* 1030 */     _xdb_verify_unsafe_();
/* 1031 */     Logs.logIf(new LogKey(this, "maidroomlevel")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1035 */         new LogInt(this, HomeInfo.this.maidroomlevel)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1039 */             HomeInfo.this.maidroomlevel = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1043 */     });
/* 1044 */     this.maidroomlevel = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setCurrentmaiduuid(long _v_)
/*      */   {
/* 1051 */     _xdb_verify_unsafe_();
/* 1052 */     Logs.logIf(new LogKey(this, "currentmaiduuid")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1056 */         new LogLong(this, HomeInfo.this.currentmaiduuid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1060 */             HomeInfo.this.currentmaiduuid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1064 */     });
/* 1065 */     this.currentmaiduuid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setIsmainhome(boolean _v_)
/*      */   {
/* 1072 */     _xdb_verify_unsafe_();
/* 1073 */     Logs.logIf(new LogKey(this, "ismainhome")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1077 */         new LogObject(this, Boolean.valueOf(HomeInfo.this.ismainhome))
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1081 */             HomeInfo.this.ismainhome = ((Boolean)this._xdb_saved).booleanValue();
/*      */           }
/*      */         };
/*      */       }
/* 1085 */     });
/* 1086 */     this.ismainhome = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setUpdatetime(long _v_)
/*      */   {
/* 1093 */     _xdb_verify_unsafe_();
/* 1094 */     Logs.logIf(new LogKey(this, "updatetime")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1098 */         new LogLong(this, HomeInfo.this.updatetime)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1102 */             HomeInfo.this.updatetime = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1106 */     });
/* 1107 */     this.updatetime = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setCourtyardlevel(int _v_)
/*      */   {
/* 1114 */     _xdb_verify_unsafe_();
/* 1115 */     Logs.logIf(new LogKey(this, "courtyardlevel")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1119 */         new LogInt(this, HomeInfo.this.courtyardlevel)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1123 */             HomeInfo.this.courtyardlevel = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1127 */     });
/* 1128 */     this.courtyardlevel = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setFengshui(int _v_)
/*      */   {
/* 1135 */     _xdb_verify_unsafe_();
/* 1136 */     Logs.logIf(new LogKey(this, "fengshui")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1140 */         new LogInt(this, HomeInfo.this.fengshui)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1144 */             HomeInfo.this.fengshui = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1148 */     });
/* 1149 */     this.fengshui = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setWalluuid(long _v_)
/*      */   {
/* 1156 */     _xdb_verify_unsafe_();
/* 1157 */     Logs.logIf(new LogKey(this, "walluuid")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1161 */         new LogLong(this, HomeInfo.this.walluuid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1165 */             HomeInfo.this.walluuid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1169 */     });
/* 1170 */     this.walluuid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setFlooruuid(long _v_)
/*      */   {
/* 1177 */     _xdb_verify_unsafe_();
/* 1178 */     Logs.logIf(new LogKey(this, "flooruuid")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1182 */         new LogLong(this, HomeInfo.this.flooruuid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1186 */             HomeInfo.this.flooruuid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1190 */     });
/* 1191 */     this.flooruuid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setCourt_yard_beautiful(int _v_)
/*      */   {
/* 1198 */     _xdb_verify_unsafe_();
/* 1199 */     Logs.logIf(new LogKey(this, "court_yard_beautiful")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1203 */         new LogInt(this, HomeInfo.this.court_yard_beautiful)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1207 */             HomeInfo.this.court_yard_beautiful = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1211 */     });
/* 1212 */     this.court_yard_beautiful = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setCourt_yard_cleanliness_refresh_time(long _v_)
/*      */   {
/* 1219 */     _xdb_verify_unsafe_();
/* 1220 */     Logs.logIf(new LogKey(this, "court_yard_cleanliness_refresh_time")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1224 */         new LogLong(this, HomeInfo.this.court_yard_cleanliness_refresh_time)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1228 */             HomeInfo.this.court_yard_cleanliness_refresh_time = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1232 */     });
/* 1233 */     this.court_yard_cleanliness_refresh_time = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setCourt_yard_cleanliness(int _v_)
/*      */   {
/* 1240 */     _xdb_verify_unsafe_();
/* 1241 */     Logs.logIf(new LogKey(this, "court_yard_cleanliness")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1245 */         new LogInt(this, HomeInfo.this.court_yard_cleanliness)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1249 */             HomeInfo.this.court_yard_cleanliness = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1253 */     });
/* 1254 */     this.court_yard_cleanliness = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setCourt_yard_day_clean_count(int _v_)
/*      */   {
/* 1261 */     _xdb_verify_unsafe_();
/* 1262 */     Logs.logIf(new LogKey(this, "court_yard_day_clean_count")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1266 */         new LogInt(this, HomeInfo.this.court_yard_day_clean_count)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1270 */             HomeInfo.this.court_yard_day_clean_count = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1274 */     });
/* 1275 */     this.court_yard_day_clean_count = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setFence_uuid(long _v_)
/*      */   {
/* 1282 */     _xdb_verify_unsafe_();
/* 1283 */     Logs.logIf(new LogKey(this, "fence_uuid")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1287 */         new LogLong(this, HomeInfo.this.fence_uuid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1291 */             HomeInfo.this.fence_uuid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1295 */     });
/* 1296 */     this.fence_uuid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setCourt_yard_terrain_uuid(long _v_)
/*      */   {
/* 1303 */     _xdb_verify_unsafe_();
/* 1304 */     Logs.logIf(new LogKey(this, "court_yard_terrain_uuid")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1308 */         new LogLong(this, HomeInfo.this.court_yard_terrain_uuid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1312 */             HomeInfo.this.court_yard_terrain_uuid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1316 */     });
/* 1317 */     this.court_yard_terrain_uuid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setCourt_yard_road_uuid(long _v_)
/*      */   {
/* 1324 */     _xdb_verify_unsafe_();
/* 1325 */     Logs.logIf(new LogKey(this, "court_yard_road_uuid")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1329 */         new LogLong(this, HomeInfo.this.court_yard_road_uuid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1333 */             HomeInfo.this.court_yard_road_uuid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1337 */     });
/* 1338 */     this.court_yard_road_uuid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/* 1344 */     _xdb_verify_unsafe_();
/* 1345 */     HomeInfo _o_ = null;
/* 1346 */     if ((_o1_ instanceof HomeInfo)) { _o_ = (HomeInfo)_o1_;
/* 1347 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 1348 */       return false;
/* 1349 */     if (this.homelevel != _o_.homelevel) return false;
/* 1350 */     if (this.cleanliness != _o_.cleanliness) return false;
/* 1351 */     if (this.petroomlevel != _o_.petroomlevel) return false;
/* 1352 */     if (this.bedroomlevel != _o_.bedroomlevel) return false;
/* 1353 */     if (this.daycleancount != _o_.daycleancount) return false;
/* 1354 */     if (this.drugroomlevel != _o_.drugroomlevel) return false;
/* 1355 */     if (this.kitchenlevel != _o_.kitchenlevel) return false;
/* 1356 */     if (this.maidroomlevel != _o_.maidroomlevel) return false;
/* 1357 */     if (!this.uuid2maidinfo.equals(_o_.uuid2maidinfo)) return false;
/* 1358 */     if (this.currentmaiduuid != _o_.currentmaiduuid) return false;
/* 1359 */     if (this.ismainhome != _o_.ismainhome) return false;
/* 1360 */     if (this.updatetime != _o_.updatetime) return false;
/* 1361 */     if (!this.mydisplayfurniture.equals(_o_.mydisplayfurniture)) return false;
/* 1362 */     if (!this.partnerdisplayfurniture.equals(_o_.partnerdisplayfurniture)) return false;
/* 1363 */     if (this.courtyardlevel != _o_.courtyardlevel) return false;
/* 1364 */     if (this.fengshui != _o_.fengshui) return false;
/* 1365 */     if (this.walluuid != _o_.walluuid) return false;
/* 1366 */     if (this.flooruuid != _o_.flooruuid) return false;
/* 1367 */     if (this.court_yard_beautiful != _o_.court_yard_beautiful) return false;
/* 1368 */     if (this.court_yard_cleanliness_refresh_time != _o_.court_yard_cleanliness_refresh_time) return false;
/* 1369 */     if (this.court_yard_cleanliness != _o_.court_yard_cleanliness) return false;
/* 1370 */     if (this.court_yard_day_clean_count != _o_.court_yard_day_clean_count) return false;
/* 1371 */     if (this.fence_uuid != _o_.fence_uuid) return false;
/* 1372 */     if (this.court_yard_terrain_uuid != _o_.court_yard_terrain_uuid) return false;
/* 1373 */     if (this.court_yard_road_uuid != _o_.court_yard_road_uuid) return false;
/* 1374 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/* 1380 */     _xdb_verify_unsafe_();
/* 1381 */     int _h_ = 0;
/* 1382 */     _h_ += this.homelevel;
/* 1383 */     _h_ += this.cleanliness;
/* 1384 */     _h_ += this.petroomlevel;
/* 1385 */     _h_ += this.bedroomlevel;
/* 1386 */     _h_ += this.daycleancount;
/* 1387 */     _h_ += this.drugroomlevel;
/* 1388 */     _h_ += this.kitchenlevel;
/* 1389 */     _h_ += this.maidroomlevel;
/* 1390 */     _h_ += this.uuid2maidinfo.hashCode();
/* 1391 */     _h_ = (int)(_h_ + this.currentmaiduuid);
/* 1392 */     _h_ += (this.ismainhome ? 1231 : 1237);
/* 1393 */     _h_ = (int)(_h_ + this.updatetime);
/* 1394 */     _h_ += this.mydisplayfurniture.hashCode();
/* 1395 */     _h_ += this.partnerdisplayfurniture.hashCode();
/* 1396 */     _h_ += this.courtyardlevel;
/* 1397 */     _h_ += this.fengshui;
/* 1398 */     _h_ = (int)(_h_ + this.walluuid);
/* 1399 */     _h_ = (int)(_h_ + this.flooruuid);
/* 1400 */     _h_ += this.court_yard_beautiful;
/* 1401 */     _h_ = (int)(_h_ + this.court_yard_cleanliness_refresh_time);
/* 1402 */     _h_ += this.court_yard_cleanliness;
/* 1403 */     _h_ += this.court_yard_day_clean_count;
/* 1404 */     _h_ = (int)(_h_ + this.fence_uuid);
/* 1405 */     _h_ = (int)(_h_ + this.court_yard_terrain_uuid);
/* 1406 */     _h_ = (int)(_h_ + this.court_yard_road_uuid);
/* 1407 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/* 1413 */     _xdb_verify_unsafe_();
/* 1414 */     StringBuilder _sb_ = new StringBuilder();
/* 1415 */     _sb_.append("(");
/* 1416 */     _sb_.append(this.homelevel);
/* 1417 */     _sb_.append(",");
/* 1418 */     _sb_.append(this.cleanliness);
/* 1419 */     _sb_.append(",");
/* 1420 */     _sb_.append(this.petroomlevel);
/* 1421 */     _sb_.append(",");
/* 1422 */     _sb_.append(this.bedroomlevel);
/* 1423 */     _sb_.append(",");
/* 1424 */     _sb_.append(this.daycleancount);
/* 1425 */     _sb_.append(",");
/* 1426 */     _sb_.append(this.drugroomlevel);
/* 1427 */     _sb_.append(",");
/* 1428 */     _sb_.append(this.kitchenlevel);
/* 1429 */     _sb_.append(",");
/* 1430 */     _sb_.append(this.maidroomlevel);
/* 1431 */     _sb_.append(",");
/* 1432 */     _sb_.append(this.uuid2maidinfo);
/* 1433 */     _sb_.append(",");
/* 1434 */     _sb_.append(this.currentmaiduuid);
/* 1435 */     _sb_.append(",");
/* 1436 */     _sb_.append(this.ismainhome);
/* 1437 */     _sb_.append(",");
/* 1438 */     _sb_.append(this.updatetime);
/* 1439 */     _sb_.append(",");
/* 1440 */     _sb_.append(this.mydisplayfurniture);
/* 1441 */     _sb_.append(",");
/* 1442 */     _sb_.append(this.partnerdisplayfurniture);
/* 1443 */     _sb_.append(",");
/* 1444 */     _sb_.append(this.courtyardlevel);
/* 1445 */     _sb_.append(",");
/* 1446 */     _sb_.append(this.fengshui);
/* 1447 */     _sb_.append(",");
/* 1448 */     _sb_.append(this.walluuid);
/* 1449 */     _sb_.append(",");
/* 1450 */     _sb_.append(this.flooruuid);
/* 1451 */     _sb_.append(",");
/* 1452 */     _sb_.append(this.court_yard_beautiful);
/* 1453 */     _sb_.append(",");
/* 1454 */     _sb_.append(this.court_yard_cleanliness_refresh_time);
/* 1455 */     _sb_.append(",");
/* 1456 */     _sb_.append(this.court_yard_cleanliness);
/* 1457 */     _sb_.append(",");
/* 1458 */     _sb_.append(this.court_yard_day_clean_count);
/* 1459 */     _sb_.append(",");
/* 1460 */     _sb_.append(this.fence_uuid);
/* 1461 */     _sb_.append(",");
/* 1462 */     _sb_.append(this.court_yard_terrain_uuid);
/* 1463 */     _sb_.append(",");
/* 1464 */     _sb_.append(this.court_yard_road_uuid);
/* 1465 */     _sb_.append(")");
/* 1466 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public Listenable newListenable()
/*      */   {
/* 1472 */     ListenableBean lb = new ListenableBean();
/* 1473 */     lb.add(new ListenableChanged().setVarName("homelevel"));
/* 1474 */     lb.add(new ListenableChanged().setVarName("cleanliness"));
/* 1475 */     lb.add(new ListenableChanged().setVarName("petroomlevel"));
/* 1476 */     lb.add(new ListenableChanged().setVarName("bedroomlevel"));
/* 1477 */     lb.add(new ListenableChanged().setVarName("daycleancount"));
/* 1478 */     lb.add(new ListenableChanged().setVarName("drugroomlevel"));
/* 1479 */     lb.add(new ListenableChanged().setVarName("kitchenlevel"));
/* 1480 */     lb.add(new ListenableChanged().setVarName("maidroomlevel"));
/* 1481 */     lb.add(new ListenableMap().setVarName("uuid2maidinfo"));
/* 1482 */     lb.add(new ListenableChanged().setVarName("currentmaiduuid"));
/* 1483 */     lb.add(new ListenableChanged().setVarName("ismainhome"));
/* 1484 */     lb.add(new ListenableChanged().setVarName("updatetime"));
/* 1485 */     lb.add(new ListenableMap().setVarName("mydisplayfurniture"));
/* 1486 */     lb.add(new ListenableMap().setVarName("partnerdisplayfurniture"));
/* 1487 */     lb.add(new ListenableChanged().setVarName("courtyardlevel"));
/* 1488 */     lb.add(new ListenableChanged().setVarName("fengshui"));
/* 1489 */     lb.add(new ListenableChanged().setVarName("walluuid"));
/* 1490 */     lb.add(new ListenableChanged().setVarName("flooruuid"));
/* 1491 */     lb.add(new ListenableChanged().setVarName("court_yard_beautiful"));
/* 1492 */     lb.add(new ListenableChanged().setVarName("court_yard_cleanliness_refresh_time"));
/* 1493 */     lb.add(new ListenableChanged().setVarName("court_yard_cleanliness"));
/* 1494 */     lb.add(new ListenableChanged().setVarName("court_yard_day_clean_count"));
/* 1495 */     lb.add(new ListenableChanged().setVarName("fence_uuid"));
/* 1496 */     lb.add(new ListenableChanged().setVarName("court_yard_terrain_uuid"));
/* 1497 */     lb.add(new ListenableChanged().setVarName("court_yard_road_uuid"));
/* 1498 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.HomeInfo {
/*      */     private Const() {}
/*      */     
/*      */     HomeInfo nThis() {
/* 1505 */       return HomeInfo.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/* 1511 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.HomeInfo copy()
/*      */     {
/* 1517 */       return HomeInfo.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.HomeInfo toData()
/*      */     {
/* 1523 */       return HomeInfo.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.HomeInfo toBean()
/*      */     {
/* 1528 */       return HomeInfo.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.HomeInfo toDataIf()
/*      */     {
/* 1534 */       return HomeInfo.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.HomeInfo toBeanIf()
/*      */     {
/* 1539 */       return HomeInfo.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getHomelevel()
/*      */     {
/* 1546 */       HomeInfo.this._xdb_verify_unsafe_();
/* 1547 */       return HomeInfo.this.homelevel;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCleanliness()
/*      */     {
/* 1554 */       HomeInfo.this._xdb_verify_unsafe_();
/* 1555 */       return HomeInfo.this.cleanliness;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getPetroomlevel()
/*      */     {
/* 1562 */       HomeInfo.this._xdb_verify_unsafe_();
/* 1563 */       return HomeInfo.this.petroomlevel;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getBedroomlevel()
/*      */     {
/* 1570 */       HomeInfo.this._xdb_verify_unsafe_();
/* 1571 */       return HomeInfo.this.bedroomlevel;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getDaycleancount()
/*      */     {
/* 1578 */       HomeInfo.this._xdb_verify_unsafe_();
/* 1579 */       return HomeInfo.this.daycleancount;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getDrugroomlevel()
/*      */     {
/* 1586 */       HomeInfo.this._xdb_verify_unsafe_();
/* 1587 */       return HomeInfo.this.drugroomlevel;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getKitchenlevel()
/*      */     {
/* 1594 */       HomeInfo.this._xdb_verify_unsafe_();
/* 1595 */       return HomeInfo.this.kitchenlevel;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getMaidroomlevel()
/*      */     {
/* 1602 */       HomeInfo.this._xdb_verify_unsafe_();
/* 1603 */       return HomeInfo.this.maidroomlevel;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.MaidInfo> getUuid2maidinfo()
/*      */     {
/* 1610 */       HomeInfo.this._xdb_verify_unsafe_();
/* 1611 */       return Consts.constMap(HomeInfo.this.uuid2maidinfo);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.MaidInfo> getUuid2maidinfoAsData()
/*      */     {
/* 1618 */       HomeInfo.this._xdb_verify_unsafe_();
/*      */       
/* 1620 */       HomeInfo _o_ = HomeInfo.this;
/* 1621 */       Map<Long, xbean.MaidInfo> uuid2maidinfo = new HashMap();
/* 1622 */       for (Map.Entry<Long, xbean.MaidInfo> _e_ : _o_.uuid2maidinfo.entrySet())
/* 1623 */         uuid2maidinfo.put(_e_.getKey(), new MaidInfo.Data((xbean.MaidInfo)_e_.getValue()));
/* 1624 */       return uuid2maidinfo;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getCurrentmaiduuid()
/*      */     {
/* 1631 */       HomeInfo.this._xdb_verify_unsafe_();
/* 1632 */       return HomeInfo.this.currentmaiduuid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getIsmainhome()
/*      */     {
/* 1639 */       HomeInfo.this._xdb_verify_unsafe_();
/* 1640 */       return HomeInfo.this.ismainhome;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getUpdatetime()
/*      */     {
/* 1647 */       HomeInfo.this._xdb_verify_unsafe_();
/* 1648 */       return HomeInfo.this.updatetime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.FurnitureInfo> getMydisplayfurniture()
/*      */     {
/* 1655 */       HomeInfo.this._xdb_verify_unsafe_();
/* 1656 */       return Consts.constMap(HomeInfo.this.mydisplayfurniture);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.FurnitureInfo> getMydisplayfurnitureAsData()
/*      */     {
/* 1663 */       HomeInfo.this._xdb_verify_unsafe_();
/*      */       
/* 1665 */       HomeInfo _o_ = HomeInfo.this;
/* 1666 */       Map<Long, xbean.FurnitureInfo> mydisplayfurniture = new HashMap();
/* 1667 */       for (Map.Entry<Long, xbean.FurnitureInfo> _e_ : _o_.mydisplayfurniture.entrySet())
/* 1668 */         mydisplayfurniture.put(_e_.getKey(), new FurnitureInfo.Data((xbean.FurnitureInfo)_e_.getValue()));
/* 1669 */       return mydisplayfurniture;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.FurnitureInfo> getPartnerdisplayfurniture()
/*      */     {
/* 1676 */       HomeInfo.this._xdb_verify_unsafe_();
/* 1677 */       return Consts.constMap(HomeInfo.this.partnerdisplayfurniture);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.FurnitureInfo> getPartnerdisplayfurnitureAsData()
/*      */     {
/* 1684 */       HomeInfo.this._xdb_verify_unsafe_();
/*      */       
/* 1686 */       HomeInfo _o_ = HomeInfo.this;
/* 1687 */       Map<Long, xbean.FurnitureInfo> partnerdisplayfurniture = new HashMap();
/* 1688 */       for (Map.Entry<Long, xbean.FurnitureInfo> _e_ : _o_.partnerdisplayfurniture.entrySet())
/* 1689 */         partnerdisplayfurniture.put(_e_.getKey(), new FurnitureInfo.Data((xbean.FurnitureInfo)_e_.getValue()));
/* 1690 */       return partnerdisplayfurniture;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCourtyardlevel()
/*      */     {
/* 1697 */       HomeInfo.this._xdb_verify_unsafe_();
/* 1698 */       return HomeInfo.this.courtyardlevel;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getFengshui()
/*      */     {
/* 1705 */       HomeInfo.this._xdb_verify_unsafe_();
/* 1706 */       return HomeInfo.this.fengshui;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getWalluuid()
/*      */     {
/* 1713 */       HomeInfo.this._xdb_verify_unsafe_();
/* 1714 */       return HomeInfo.this.walluuid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getFlooruuid()
/*      */     {
/* 1721 */       HomeInfo.this._xdb_verify_unsafe_();
/* 1722 */       return HomeInfo.this.flooruuid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCourt_yard_beautiful()
/*      */     {
/* 1729 */       HomeInfo.this._xdb_verify_unsafe_();
/* 1730 */       return HomeInfo.this.court_yard_beautiful;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getCourt_yard_cleanliness_refresh_time()
/*      */     {
/* 1737 */       HomeInfo.this._xdb_verify_unsafe_();
/* 1738 */       return HomeInfo.this.court_yard_cleanliness_refresh_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCourt_yard_cleanliness()
/*      */     {
/* 1745 */       HomeInfo.this._xdb_verify_unsafe_();
/* 1746 */       return HomeInfo.this.court_yard_cleanliness;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCourt_yard_day_clean_count()
/*      */     {
/* 1753 */       HomeInfo.this._xdb_verify_unsafe_();
/* 1754 */       return HomeInfo.this.court_yard_day_clean_count;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getFence_uuid()
/*      */     {
/* 1761 */       HomeInfo.this._xdb_verify_unsafe_();
/* 1762 */       return HomeInfo.this.fence_uuid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getCourt_yard_terrain_uuid()
/*      */     {
/* 1769 */       HomeInfo.this._xdb_verify_unsafe_();
/* 1770 */       return HomeInfo.this.court_yard_terrain_uuid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getCourt_yard_road_uuid()
/*      */     {
/* 1777 */       HomeInfo.this._xdb_verify_unsafe_();
/* 1778 */       return HomeInfo.this.court_yard_road_uuid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setHomelevel(int _v_)
/*      */     {
/* 1785 */       HomeInfo.this._xdb_verify_unsafe_();
/* 1786 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCleanliness(int _v_)
/*      */     {
/* 1793 */       HomeInfo.this._xdb_verify_unsafe_();
/* 1794 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPetroomlevel(int _v_)
/*      */     {
/* 1801 */       HomeInfo.this._xdb_verify_unsafe_();
/* 1802 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setBedroomlevel(int _v_)
/*      */     {
/* 1809 */       HomeInfo.this._xdb_verify_unsafe_();
/* 1810 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setDaycleancount(int _v_)
/*      */     {
/* 1817 */       HomeInfo.this._xdb_verify_unsafe_();
/* 1818 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setDrugroomlevel(int _v_)
/*      */     {
/* 1825 */       HomeInfo.this._xdb_verify_unsafe_();
/* 1826 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setKitchenlevel(int _v_)
/*      */     {
/* 1833 */       HomeInfo.this._xdb_verify_unsafe_();
/* 1834 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMaidroomlevel(int _v_)
/*      */     {
/* 1841 */       HomeInfo.this._xdb_verify_unsafe_();
/* 1842 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCurrentmaiduuid(long _v_)
/*      */     {
/* 1849 */       HomeInfo.this._xdb_verify_unsafe_();
/* 1850 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setIsmainhome(boolean _v_)
/*      */     {
/* 1857 */       HomeInfo.this._xdb_verify_unsafe_();
/* 1858 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setUpdatetime(long _v_)
/*      */     {
/* 1865 */       HomeInfo.this._xdb_verify_unsafe_();
/* 1866 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCourtyardlevel(int _v_)
/*      */     {
/* 1873 */       HomeInfo.this._xdb_verify_unsafe_();
/* 1874 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setFengshui(int _v_)
/*      */     {
/* 1881 */       HomeInfo.this._xdb_verify_unsafe_();
/* 1882 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setWalluuid(long _v_)
/*      */     {
/* 1889 */       HomeInfo.this._xdb_verify_unsafe_();
/* 1890 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setFlooruuid(long _v_)
/*      */     {
/* 1897 */       HomeInfo.this._xdb_verify_unsafe_();
/* 1898 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCourt_yard_beautiful(int _v_)
/*      */     {
/* 1905 */       HomeInfo.this._xdb_verify_unsafe_();
/* 1906 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCourt_yard_cleanliness_refresh_time(long _v_)
/*      */     {
/* 1913 */       HomeInfo.this._xdb_verify_unsafe_();
/* 1914 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCourt_yard_cleanliness(int _v_)
/*      */     {
/* 1921 */       HomeInfo.this._xdb_verify_unsafe_();
/* 1922 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCourt_yard_day_clean_count(int _v_)
/*      */     {
/* 1929 */       HomeInfo.this._xdb_verify_unsafe_();
/* 1930 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setFence_uuid(long _v_)
/*      */     {
/* 1937 */       HomeInfo.this._xdb_verify_unsafe_();
/* 1938 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCourt_yard_terrain_uuid(long _v_)
/*      */     {
/* 1945 */       HomeInfo.this._xdb_verify_unsafe_();
/* 1946 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCourt_yard_road_uuid(long _v_)
/*      */     {
/* 1953 */       HomeInfo.this._xdb_verify_unsafe_();
/* 1954 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean toConst()
/*      */     {
/* 1960 */       HomeInfo.this._xdb_verify_unsafe_();
/* 1961 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/* 1967 */       HomeInfo.this._xdb_verify_unsafe_();
/* 1968 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/* 1974 */       return HomeInfo.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/* 1980 */       return HomeInfo.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws MarshalException
/*      */     {
/* 1986 */       HomeInfo.this._xdb_verify_unsafe_();
/* 1987 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/* 1993 */       return HomeInfo.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/* 1999 */       return HomeInfo.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/* 2005 */       HomeInfo.this._xdb_verify_unsafe_();
/* 2006 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean xdbParent()
/*      */     {
/* 2012 */       return HomeInfo.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 2018 */       return HomeInfo.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/* 2024 */       return HomeInfo.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/* 2030 */       return HomeInfo.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/* 2036 */       return HomeInfo.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/* 2042 */       return HomeInfo.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 2048 */       return HomeInfo.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.HomeInfo
/*      */   {
/*      */     private int homelevel;
/*      */     
/*      */     private int cleanliness;
/*      */     
/*      */     private int petroomlevel;
/*      */     
/*      */     private int bedroomlevel;
/*      */     
/*      */     private int daycleancount;
/*      */     
/*      */     private int drugroomlevel;
/*      */     
/*      */     private int kitchenlevel;
/*      */     
/*      */     private int maidroomlevel;
/*      */     
/*      */     private HashMap<Long, xbean.MaidInfo> uuid2maidinfo;
/*      */     
/*      */     private long currentmaiduuid;
/*      */     
/*      */     private boolean ismainhome;
/*      */     
/*      */     private long updatetime;
/*      */     
/*      */     private HashMap<Long, xbean.FurnitureInfo> mydisplayfurniture;
/*      */     
/*      */     private HashMap<Long, xbean.FurnitureInfo> partnerdisplayfurniture;
/*      */     
/*      */     private int courtyardlevel;
/*      */     
/*      */     private int fengshui;
/*      */     
/*      */     private long walluuid;
/*      */     
/*      */     private long flooruuid;
/*      */     
/*      */     private int court_yard_beautiful;
/*      */     
/*      */     private long court_yard_cleanliness_refresh_time;
/*      */     
/*      */     private int court_yard_cleanliness;
/*      */     
/*      */     private int court_yard_day_clean_count;
/*      */     
/*      */     private long fence_uuid;
/*      */     
/*      */     private long court_yard_terrain_uuid;
/*      */     
/*      */     private long court_yard_road_uuid;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/* 2108 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/* 2113 */       this.uuid2maidinfo = new HashMap();
/* 2114 */       this.ismainhome = false;
/* 2115 */       this.mydisplayfurniture = new HashMap();
/* 2116 */       this.partnerdisplayfurniture = new HashMap();
/*      */     }
/*      */     
/*      */     Data(xbean.HomeInfo _o1_)
/*      */     {
/* 2121 */       if ((_o1_ instanceof HomeInfo)) { assign((HomeInfo)_o1_);
/* 2122 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 2123 */       } else if ((_o1_ instanceof HomeInfo.Const)) assign(((HomeInfo.Const)_o1_).nThis()); else {
/* 2124 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(HomeInfo _o_) {
/* 2129 */       this.homelevel = _o_.homelevel;
/* 2130 */       this.cleanliness = _o_.cleanliness;
/* 2131 */       this.petroomlevel = _o_.petroomlevel;
/* 2132 */       this.bedroomlevel = _o_.bedroomlevel;
/* 2133 */       this.daycleancount = _o_.daycleancount;
/* 2134 */       this.drugroomlevel = _o_.drugroomlevel;
/* 2135 */       this.kitchenlevel = _o_.kitchenlevel;
/* 2136 */       this.maidroomlevel = _o_.maidroomlevel;
/* 2137 */       this.uuid2maidinfo = new HashMap();
/* 2138 */       for (Map.Entry<Long, xbean.MaidInfo> _e_ : _o_.uuid2maidinfo.entrySet())
/* 2139 */         this.uuid2maidinfo.put(_e_.getKey(), new MaidInfo.Data((xbean.MaidInfo)_e_.getValue()));
/* 2140 */       this.currentmaiduuid = _o_.currentmaiduuid;
/* 2141 */       this.ismainhome = _o_.ismainhome;
/* 2142 */       this.updatetime = _o_.updatetime;
/* 2143 */       this.mydisplayfurniture = new HashMap();
/* 2144 */       for (Map.Entry<Long, xbean.FurnitureInfo> _e_ : _o_.mydisplayfurniture.entrySet())
/* 2145 */         this.mydisplayfurniture.put(_e_.getKey(), new FurnitureInfo.Data((xbean.FurnitureInfo)_e_.getValue()));
/* 2146 */       this.partnerdisplayfurniture = new HashMap();
/* 2147 */       for (Map.Entry<Long, xbean.FurnitureInfo> _e_ : _o_.partnerdisplayfurniture.entrySet())
/* 2148 */         this.partnerdisplayfurniture.put(_e_.getKey(), new FurnitureInfo.Data((xbean.FurnitureInfo)_e_.getValue()));
/* 2149 */       this.courtyardlevel = _o_.courtyardlevel;
/* 2150 */       this.fengshui = _o_.fengshui;
/* 2151 */       this.walluuid = _o_.walluuid;
/* 2152 */       this.flooruuid = _o_.flooruuid;
/* 2153 */       this.court_yard_beautiful = _o_.court_yard_beautiful;
/* 2154 */       this.court_yard_cleanliness_refresh_time = _o_.court_yard_cleanliness_refresh_time;
/* 2155 */       this.court_yard_cleanliness = _o_.court_yard_cleanliness;
/* 2156 */       this.court_yard_day_clean_count = _o_.court_yard_day_clean_count;
/* 2157 */       this.fence_uuid = _o_.fence_uuid;
/* 2158 */       this.court_yard_terrain_uuid = _o_.court_yard_terrain_uuid;
/* 2159 */       this.court_yard_road_uuid = _o_.court_yard_road_uuid;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/* 2164 */       this.homelevel = _o_.homelevel;
/* 2165 */       this.cleanliness = _o_.cleanliness;
/* 2166 */       this.petroomlevel = _o_.petroomlevel;
/* 2167 */       this.bedroomlevel = _o_.bedroomlevel;
/* 2168 */       this.daycleancount = _o_.daycleancount;
/* 2169 */       this.drugroomlevel = _o_.drugroomlevel;
/* 2170 */       this.kitchenlevel = _o_.kitchenlevel;
/* 2171 */       this.maidroomlevel = _o_.maidroomlevel;
/* 2172 */       this.uuid2maidinfo = new HashMap();
/* 2173 */       for (Map.Entry<Long, xbean.MaidInfo> _e_ : _o_.uuid2maidinfo.entrySet())
/* 2174 */         this.uuid2maidinfo.put(_e_.getKey(), new MaidInfo.Data((xbean.MaidInfo)_e_.getValue()));
/* 2175 */       this.currentmaiduuid = _o_.currentmaiduuid;
/* 2176 */       this.ismainhome = _o_.ismainhome;
/* 2177 */       this.updatetime = _o_.updatetime;
/* 2178 */       this.mydisplayfurniture = new HashMap();
/* 2179 */       for (Map.Entry<Long, xbean.FurnitureInfo> _e_ : _o_.mydisplayfurniture.entrySet())
/* 2180 */         this.mydisplayfurniture.put(_e_.getKey(), new FurnitureInfo.Data((xbean.FurnitureInfo)_e_.getValue()));
/* 2181 */       this.partnerdisplayfurniture = new HashMap();
/* 2182 */       for (Map.Entry<Long, xbean.FurnitureInfo> _e_ : _o_.partnerdisplayfurniture.entrySet())
/* 2183 */         this.partnerdisplayfurniture.put(_e_.getKey(), new FurnitureInfo.Data((xbean.FurnitureInfo)_e_.getValue()));
/* 2184 */       this.courtyardlevel = _o_.courtyardlevel;
/* 2185 */       this.fengshui = _o_.fengshui;
/* 2186 */       this.walluuid = _o_.walluuid;
/* 2187 */       this.flooruuid = _o_.flooruuid;
/* 2188 */       this.court_yard_beautiful = _o_.court_yard_beautiful;
/* 2189 */       this.court_yard_cleanliness_refresh_time = _o_.court_yard_cleanliness_refresh_time;
/* 2190 */       this.court_yard_cleanliness = _o_.court_yard_cleanliness;
/* 2191 */       this.court_yard_day_clean_count = _o_.court_yard_day_clean_count;
/* 2192 */       this.fence_uuid = _o_.fence_uuid;
/* 2193 */       this.court_yard_terrain_uuid = _o_.court_yard_terrain_uuid;
/* 2194 */       this.court_yard_road_uuid = _o_.court_yard_road_uuid;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/* 2200 */       _os_.marshal(this.homelevel);
/* 2201 */       _os_.marshal(this.cleanliness);
/* 2202 */       _os_.marshal(this.petroomlevel);
/* 2203 */       _os_.marshal(this.bedroomlevel);
/* 2204 */       _os_.marshal(this.daycleancount);
/* 2205 */       _os_.marshal(this.drugroomlevel);
/* 2206 */       _os_.marshal(this.kitchenlevel);
/* 2207 */       _os_.marshal(this.maidroomlevel);
/* 2208 */       _os_.compact_uint32(this.uuid2maidinfo.size());
/* 2209 */       for (Map.Entry<Long, xbean.MaidInfo> _e_ : this.uuid2maidinfo.entrySet())
/*      */       {
/* 2211 */         _os_.marshal(((Long)_e_.getKey()).longValue());
/* 2212 */         ((xbean.MaidInfo)_e_.getValue()).marshal(_os_);
/*      */       }
/* 2214 */       _os_.marshal(this.currentmaiduuid);
/* 2215 */       _os_.marshal(this.ismainhome);
/* 2216 */       _os_.marshal(this.updatetime);
/* 2217 */       _os_.compact_uint32(this.mydisplayfurniture.size());
/* 2218 */       for (Map.Entry<Long, xbean.FurnitureInfo> _e_ : this.mydisplayfurniture.entrySet())
/*      */       {
/* 2220 */         _os_.marshal(((Long)_e_.getKey()).longValue());
/* 2221 */         ((xbean.FurnitureInfo)_e_.getValue()).marshal(_os_);
/*      */       }
/* 2223 */       _os_.compact_uint32(this.partnerdisplayfurniture.size());
/* 2224 */       for (Map.Entry<Long, xbean.FurnitureInfo> _e_ : this.partnerdisplayfurniture.entrySet())
/*      */       {
/* 2226 */         _os_.marshal(((Long)_e_.getKey()).longValue());
/* 2227 */         ((xbean.FurnitureInfo)_e_.getValue()).marshal(_os_);
/*      */       }
/* 2229 */       _os_.marshal(this.courtyardlevel);
/* 2230 */       _os_.marshal(this.fengshui);
/* 2231 */       _os_.marshal(this.walluuid);
/* 2232 */       _os_.marshal(this.flooruuid);
/* 2233 */       _os_.marshal(this.court_yard_beautiful);
/* 2234 */       _os_.marshal(this.court_yard_cleanliness_refresh_time);
/* 2235 */       _os_.marshal(this.court_yard_cleanliness);
/* 2236 */       _os_.marshal(this.court_yard_day_clean_count);
/* 2237 */       _os_.marshal(this.fence_uuid);
/* 2238 */       _os_.marshal(this.court_yard_terrain_uuid);
/* 2239 */       _os_.marshal(this.court_yard_road_uuid);
/* 2240 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws MarshalException
/*      */     {
/* 2246 */       this.homelevel = _os_.unmarshal_int();
/* 2247 */       this.cleanliness = _os_.unmarshal_int();
/* 2248 */       this.petroomlevel = _os_.unmarshal_int();
/* 2249 */       this.bedroomlevel = _os_.unmarshal_int();
/* 2250 */       this.daycleancount = _os_.unmarshal_int();
/* 2251 */       this.drugroomlevel = _os_.unmarshal_int();
/* 2252 */       this.kitchenlevel = _os_.unmarshal_int();
/* 2253 */       this.maidroomlevel = _os_.unmarshal_int();
/*      */       
/* 2255 */       int size = _os_.uncompact_uint32();
/* 2256 */       if (size >= 12)
/*      */       {
/* 2258 */         this.uuid2maidinfo = new HashMap(size * 2);
/*      */       }
/* 2260 */       for (; size > 0; size--)
/*      */       {
/* 2262 */         long _k_ = 0L;
/* 2263 */         _k_ = _os_.unmarshal_long();
/* 2264 */         xbean.MaidInfo _v_ = Pod.newMaidInfoData();
/* 2265 */         _v_.unmarshal(_os_);
/* 2266 */         this.uuid2maidinfo.put(Long.valueOf(_k_), _v_);
/*      */       }
/*      */       
/* 2269 */       this.currentmaiduuid = _os_.unmarshal_long();
/* 2270 */       this.ismainhome = _os_.unmarshal_boolean();
/* 2271 */       this.updatetime = _os_.unmarshal_long();
/*      */       
/* 2273 */       int size = _os_.uncompact_uint32();
/* 2274 */       if (size >= 12)
/*      */       {
/* 2276 */         this.mydisplayfurniture = new HashMap(size * 2);
/*      */       }
/* 2278 */       for (; size > 0; size--)
/*      */       {
/* 2280 */         long _k_ = 0L;
/* 2281 */         _k_ = _os_.unmarshal_long();
/* 2282 */         xbean.FurnitureInfo _v_ = Pod.newFurnitureInfoData();
/* 2283 */         _v_.unmarshal(_os_);
/* 2284 */         this.mydisplayfurniture.put(Long.valueOf(_k_), _v_);
/*      */       }
/*      */       
/*      */ 
/* 2288 */       int size = _os_.uncompact_uint32();
/* 2289 */       if (size >= 12)
/*      */       {
/* 2291 */         this.partnerdisplayfurniture = new HashMap(size * 2);
/*      */       }
/* 2293 */       for (; size > 0; size--)
/*      */       {
/* 2295 */         long _k_ = 0L;
/* 2296 */         _k_ = _os_.unmarshal_long();
/* 2297 */         xbean.FurnitureInfo _v_ = Pod.newFurnitureInfoData();
/* 2298 */         _v_.unmarshal(_os_);
/* 2299 */         this.partnerdisplayfurniture.put(Long.valueOf(_k_), _v_);
/*      */       }
/*      */       
/* 2302 */       this.courtyardlevel = _os_.unmarshal_int();
/* 2303 */       this.fengshui = _os_.unmarshal_int();
/* 2304 */       this.walluuid = _os_.unmarshal_long();
/* 2305 */       this.flooruuid = _os_.unmarshal_long();
/* 2306 */       this.court_yard_beautiful = _os_.unmarshal_int();
/* 2307 */       this.court_yard_cleanliness_refresh_time = _os_.unmarshal_long();
/* 2308 */       this.court_yard_cleanliness = _os_.unmarshal_int();
/* 2309 */       this.court_yard_day_clean_count = _os_.unmarshal_int();
/* 2310 */       this.fence_uuid = _os_.unmarshal_long();
/* 2311 */       this.court_yard_terrain_uuid = _os_.unmarshal_long();
/* 2312 */       this.court_yard_road_uuid = _os_.unmarshal_long();
/* 2313 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/* 2319 */       int _size_ = 0;
/* 2320 */       _size_ += CodedOutputStream.computeInt32Size(1, this.homelevel);
/* 2321 */       _size_ += CodedOutputStream.computeInt32Size(2, this.cleanliness);
/* 2322 */       _size_ += CodedOutputStream.computeInt32Size(3, this.petroomlevel);
/* 2323 */       _size_ += CodedOutputStream.computeInt32Size(4, this.bedroomlevel);
/* 2324 */       _size_ += CodedOutputStream.computeInt32Size(5, this.daycleancount);
/* 2325 */       _size_ += CodedOutputStream.computeInt32Size(6, this.drugroomlevel);
/* 2326 */       _size_ += CodedOutputStream.computeInt32Size(7, this.kitchenlevel);
/* 2327 */       _size_ += CodedOutputStream.computeInt32Size(8, this.maidroomlevel);
/* 2328 */       for (Map.Entry<Long, xbean.MaidInfo> _e_ : this.uuid2maidinfo.entrySet())
/*      */       {
/* 2330 */         _size_ += CodedOutputStream.computeInt64Size(9, ((Long)_e_.getKey()).longValue());
/* 2331 */         _size_ += CodedOutputStream.computeMessageSize(9, (Message)_e_.getValue());
/*      */       }
/* 2333 */       _size_ += CodedOutputStream.computeInt64Size(10, this.currentmaiduuid);
/* 2334 */       _size_ += CodedOutputStream.computeBoolSize(11, this.ismainhome);
/* 2335 */       _size_ += CodedOutputStream.computeInt64Size(12, this.updatetime);
/* 2336 */       for (Map.Entry<Long, xbean.FurnitureInfo> _e_ : this.mydisplayfurniture.entrySet())
/*      */       {
/* 2338 */         _size_ += CodedOutputStream.computeInt64Size(13, ((Long)_e_.getKey()).longValue());
/* 2339 */         _size_ += CodedOutputStream.computeMessageSize(13, (Message)_e_.getValue());
/*      */       }
/* 2341 */       for (Map.Entry<Long, xbean.FurnitureInfo> _e_ : this.partnerdisplayfurniture.entrySet())
/*      */       {
/* 2343 */         _size_ += CodedOutputStream.computeInt64Size(14, ((Long)_e_.getKey()).longValue());
/* 2344 */         _size_ += CodedOutputStream.computeMessageSize(14, (Message)_e_.getValue());
/*      */       }
/* 2346 */       _size_ += CodedOutputStream.computeInt32Size(15, this.courtyardlevel);
/* 2347 */       _size_ += CodedOutputStream.computeInt32Size(16, this.fengshui);
/* 2348 */       _size_ += CodedOutputStream.computeInt64Size(17, this.walluuid);
/* 2349 */       _size_ += CodedOutputStream.computeInt64Size(18, this.flooruuid);
/* 2350 */       _size_ += CodedOutputStream.computeInt32Size(21, this.court_yard_beautiful);
/* 2351 */       _size_ += CodedOutputStream.computeInt64Size(22, this.court_yard_cleanliness_refresh_time);
/* 2352 */       _size_ += CodedOutputStream.computeInt32Size(23, this.court_yard_cleanliness);
/* 2353 */       _size_ += CodedOutputStream.computeInt32Size(24, this.court_yard_day_clean_count);
/* 2354 */       _size_ += CodedOutputStream.computeInt64Size(25, this.fence_uuid);
/* 2355 */       _size_ += CodedOutputStream.computeInt64Size(26, this.court_yard_terrain_uuid);
/* 2356 */       _size_ += CodedOutputStream.computeInt64Size(27, this.court_yard_road_uuid);
/* 2357 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 2365 */         _output_.writeInt32(1, this.homelevel);
/* 2366 */         _output_.writeInt32(2, this.cleanliness);
/* 2367 */         _output_.writeInt32(3, this.petroomlevel);
/* 2368 */         _output_.writeInt32(4, this.bedroomlevel);
/* 2369 */         _output_.writeInt32(5, this.daycleancount);
/* 2370 */         _output_.writeInt32(6, this.drugroomlevel);
/* 2371 */         _output_.writeInt32(7, this.kitchenlevel);
/* 2372 */         _output_.writeInt32(8, this.maidroomlevel);
/* 2373 */         for (Map.Entry<Long, xbean.MaidInfo> _e_ : this.uuid2maidinfo.entrySet())
/*      */         {
/* 2375 */           _output_.writeInt64(9, ((Long)_e_.getKey()).longValue());
/* 2376 */           _output_.writeMessage(9, (Message)_e_.getValue());
/*      */         }
/* 2378 */         _output_.writeInt64(10, this.currentmaiduuid);
/* 2379 */         _output_.writeBool(11, this.ismainhome);
/* 2380 */         _output_.writeInt64(12, this.updatetime);
/* 2381 */         for (Map.Entry<Long, xbean.FurnitureInfo> _e_ : this.mydisplayfurniture.entrySet())
/*      */         {
/* 2383 */           _output_.writeInt64(13, ((Long)_e_.getKey()).longValue());
/* 2384 */           _output_.writeMessage(13, (Message)_e_.getValue());
/*      */         }
/* 2386 */         for (Map.Entry<Long, xbean.FurnitureInfo> _e_ : this.partnerdisplayfurniture.entrySet())
/*      */         {
/* 2388 */           _output_.writeInt64(14, ((Long)_e_.getKey()).longValue());
/* 2389 */           _output_.writeMessage(14, (Message)_e_.getValue());
/*      */         }
/* 2391 */         _output_.writeInt32(15, this.courtyardlevel);
/* 2392 */         _output_.writeInt32(16, this.fengshui);
/* 2393 */         _output_.writeInt64(17, this.walluuid);
/* 2394 */         _output_.writeInt64(18, this.flooruuid);
/* 2395 */         _output_.writeInt32(21, this.court_yard_beautiful);
/* 2396 */         _output_.writeInt64(22, this.court_yard_cleanliness_refresh_time);
/* 2397 */         _output_.writeInt32(23, this.court_yard_cleanliness);
/* 2398 */         _output_.writeInt32(24, this.court_yard_day_clean_count);
/* 2399 */         _output_.writeInt64(25, this.fence_uuid);
/* 2400 */         _output_.writeInt64(26, this.court_yard_terrain_uuid);
/* 2401 */         _output_.writeInt64(27, this.court_yard_road_uuid);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 2405 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 2407 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 2415 */         boolean done = false;
/* 2416 */         while (!done)
/*      */         {
/* 2418 */           int tag = _input_.readTag();
/* 2419 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/* 2423 */             done = true;
/* 2424 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/* 2428 */             this.homelevel = _input_.readInt32();
/* 2429 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/* 2433 */             this.cleanliness = _input_.readInt32();
/* 2434 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/* 2438 */             this.petroomlevel = _input_.readInt32();
/* 2439 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/* 2443 */             this.bedroomlevel = _input_.readInt32();
/* 2444 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/* 2448 */             this.daycleancount = _input_.readInt32();
/* 2449 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/* 2453 */             this.drugroomlevel = _input_.readInt32();
/* 2454 */             break;
/*      */           
/*      */ 
/*      */           case 56: 
/* 2458 */             this.kitchenlevel = _input_.readInt32();
/* 2459 */             break;
/*      */           
/*      */ 
/*      */           case 64: 
/* 2463 */             this.maidroomlevel = _input_.readInt32();
/* 2464 */             break;
/*      */           
/*      */ 
/*      */           case 72: 
/* 2468 */             long _k_ = 0L;
/* 2469 */             _k_ = _input_.readInt64();
/* 2470 */             int readTag = _input_.readTag();
/* 2471 */             if (74 != readTag)
/*      */             {
/* 2473 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 2475 */             xbean.MaidInfo _v_ = Pod.newMaidInfoData();
/* 2476 */             _input_.readMessage(_v_);
/* 2477 */             this.uuid2maidinfo.put(Long.valueOf(_k_), _v_);
/* 2478 */             break;
/*      */           
/*      */ 
/*      */           case 80: 
/* 2482 */             this.currentmaiduuid = _input_.readInt64();
/* 2483 */             break;
/*      */           
/*      */ 
/*      */           case 88: 
/* 2487 */             this.ismainhome = _input_.readBool();
/* 2488 */             break;
/*      */           
/*      */ 
/*      */           case 96: 
/* 2492 */             this.updatetime = _input_.readInt64();
/* 2493 */             break;
/*      */           
/*      */ 
/*      */           case 104: 
/* 2497 */             long _k_ = 0L;
/* 2498 */             _k_ = _input_.readInt64();
/* 2499 */             int readTag = _input_.readTag();
/* 2500 */             if (106 != readTag)
/*      */             {
/* 2502 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 2504 */             xbean.FurnitureInfo _v_ = Pod.newFurnitureInfoData();
/* 2505 */             _input_.readMessage(_v_);
/* 2506 */             this.mydisplayfurniture.put(Long.valueOf(_k_), _v_);
/* 2507 */             break;
/*      */           
/*      */ 
/*      */           case 112: 
/* 2511 */             long _k_ = 0L;
/* 2512 */             _k_ = _input_.readInt64();
/* 2513 */             int readTag = _input_.readTag();
/* 2514 */             if (114 != readTag)
/*      */             {
/* 2516 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 2518 */             xbean.FurnitureInfo _v_ = Pod.newFurnitureInfoData();
/* 2519 */             _input_.readMessage(_v_);
/* 2520 */             this.partnerdisplayfurniture.put(Long.valueOf(_k_), _v_);
/* 2521 */             break;
/*      */           
/*      */ 
/*      */           case 120: 
/* 2525 */             this.courtyardlevel = _input_.readInt32();
/* 2526 */             break;
/*      */           
/*      */ 
/*      */           case 128: 
/* 2530 */             this.fengshui = _input_.readInt32();
/* 2531 */             break;
/*      */           
/*      */ 
/*      */           case 136: 
/* 2535 */             this.walluuid = _input_.readInt64();
/* 2536 */             break;
/*      */           
/*      */ 
/*      */           case 144: 
/* 2540 */             this.flooruuid = _input_.readInt64();
/* 2541 */             break;
/*      */           
/*      */ 
/*      */           case 168: 
/* 2545 */             this.court_yard_beautiful = _input_.readInt32();
/* 2546 */             break;
/*      */           
/*      */ 
/*      */           case 176: 
/* 2550 */             this.court_yard_cleanliness_refresh_time = _input_.readInt64();
/* 2551 */             break;
/*      */           
/*      */ 
/*      */           case 184: 
/* 2555 */             this.court_yard_cleanliness = _input_.readInt32();
/* 2556 */             break;
/*      */           
/*      */ 
/*      */           case 192: 
/* 2560 */             this.court_yard_day_clean_count = _input_.readInt32();
/* 2561 */             break;
/*      */           
/*      */ 
/*      */           case 200: 
/* 2565 */             this.fence_uuid = _input_.readInt64();
/* 2566 */             break;
/*      */           
/*      */ 
/*      */           case 208: 
/* 2570 */             this.court_yard_terrain_uuid = _input_.readInt64();
/* 2571 */             break;
/*      */           
/*      */ 
/*      */           case 216: 
/* 2575 */             this.court_yard_road_uuid = _input_.readInt64();
/* 2576 */             break;
/*      */           
/*      */ 
/*      */           default: 
/* 2580 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/* 2582 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/* 2591 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 2595 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 2597 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.HomeInfo copy()
/*      */     {
/* 2603 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.HomeInfo toData()
/*      */     {
/* 2609 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.HomeInfo toBean()
/*      */     {
/* 2614 */       return new HomeInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.HomeInfo toDataIf()
/*      */     {
/* 2620 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.HomeInfo toBeanIf()
/*      */     {
/* 2625 */       return new HomeInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 2631 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean xdbParent() {
/* 2635 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 2639 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 2643 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean toConst() {
/* 2647 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 2651 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 2655 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getHomelevel()
/*      */     {
/* 2662 */       return this.homelevel;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCleanliness()
/*      */     {
/* 2669 */       return this.cleanliness;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getPetroomlevel()
/*      */     {
/* 2676 */       return this.petroomlevel;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getBedroomlevel()
/*      */     {
/* 2683 */       return this.bedroomlevel;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getDaycleancount()
/*      */     {
/* 2690 */       return this.daycleancount;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getDrugroomlevel()
/*      */     {
/* 2697 */       return this.drugroomlevel;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getKitchenlevel()
/*      */     {
/* 2704 */       return this.kitchenlevel;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getMaidroomlevel()
/*      */     {
/* 2711 */       return this.maidroomlevel;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.MaidInfo> getUuid2maidinfo()
/*      */     {
/* 2718 */       return this.uuid2maidinfo;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.MaidInfo> getUuid2maidinfoAsData()
/*      */     {
/* 2725 */       return this.uuid2maidinfo;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getCurrentmaiduuid()
/*      */     {
/* 2732 */       return this.currentmaiduuid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getIsmainhome()
/*      */     {
/* 2739 */       return this.ismainhome;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getUpdatetime()
/*      */     {
/* 2746 */       return this.updatetime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.FurnitureInfo> getMydisplayfurniture()
/*      */     {
/* 2753 */       return this.mydisplayfurniture;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.FurnitureInfo> getMydisplayfurnitureAsData()
/*      */     {
/* 2760 */       return this.mydisplayfurniture;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.FurnitureInfo> getPartnerdisplayfurniture()
/*      */     {
/* 2767 */       return this.partnerdisplayfurniture;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.FurnitureInfo> getPartnerdisplayfurnitureAsData()
/*      */     {
/* 2774 */       return this.partnerdisplayfurniture;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCourtyardlevel()
/*      */     {
/* 2781 */       return this.courtyardlevel;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getFengshui()
/*      */     {
/* 2788 */       return this.fengshui;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getWalluuid()
/*      */     {
/* 2795 */       return this.walluuid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getFlooruuid()
/*      */     {
/* 2802 */       return this.flooruuid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCourt_yard_beautiful()
/*      */     {
/* 2809 */       return this.court_yard_beautiful;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getCourt_yard_cleanliness_refresh_time()
/*      */     {
/* 2816 */       return this.court_yard_cleanliness_refresh_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCourt_yard_cleanliness()
/*      */     {
/* 2823 */       return this.court_yard_cleanliness;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCourt_yard_day_clean_count()
/*      */     {
/* 2830 */       return this.court_yard_day_clean_count;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getFence_uuid()
/*      */     {
/* 2837 */       return this.fence_uuid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getCourt_yard_terrain_uuid()
/*      */     {
/* 2844 */       return this.court_yard_terrain_uuid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getCourt_yard_road_uuid()
/*      */     {
/* 2851 */       return this.court_yard_road_uuid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setHomelevel(int _v_)
/*      */     {
/* 2858 */       this.homelevel = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCleanliness(int _v_)
/*      */     {
/* 2865 */       this.cleanliness = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPetroomlevel(int _v_)
/*      */     {
/* 2872 */       this.petroomlevel = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setBedroomlevel(int _v_)
/*      */     {
/* 2879 */       this.bedroomlevel = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setDaycleancount(int _v_)
/*      */     {
/* 2886 */       this.daycleancount = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setDrugroomlevel(int _v_)
/*      */     {
/* 2893 */       this.drugroomlevel = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setKitchenlevel(int _v_)
/*      */     {
/* 2900 */       this.kitchenlevel = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMaidroomlevel(int _v_)
/*      */     {
/* 2907 */       this.maidroomlevel = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCurrentmaiduuid(long _v_)
/*      */     {
/* 2914 */       this.currentmaiduuid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setIsmainhome(boolean _v_)
/*      */     {
/* 2921 */       this.ismainhome = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setUpdatetime(long _v_)
/*      */     {
/* 2928 */       this.updatetime = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCourtyardlevel(int _v_)
/*      */     {
/* 2935 */       this.courtyardlevel = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setFengshui(int _v_)
/*      */     {
/* 2942 */       this.fengshui = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setWalluuid(long _v_)
/*      */     {
/* 2949 */       this.walluuid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setFlooruuid(long _v_)
/*      */     {
/* 2956 */       this.flooruuid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCourt_yard_beautiful(int _v_)
/*      */     {
/* 2963 */       this.court_yard_beautiful = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCourt_yard_cleanliness_refresh_time(long _v_)
/*      */     {
/* 2970 */       this.court_yard_cleanliness_refresh_time = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCourt_yard_cleanliness(int _v_)
/*      */     {
/* 2977 */       this.court_yard_cleanliness = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCourt_yard_day_clean_count(int _v_)
/*      */     {
/* 2984 */       this.court_yard_day_clean_count = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setFence_uuid(long _v_)
/*      */     {
/* 2991 */       this.fence_uuid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCourt_yard_terrain_uuid(long _v_)
/*      */     {
/* 2998 */       this.court_yard_terrain_uuid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCourt_yard_road_uuid(long _v_)
/*      */     {
/* 3005 */       this.court_yard_road_uuid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 3011 */       if (!(_o1_ instanceof Data)) return false;
/* 3012 */       Data _o_ = (Data)_o1_;
/* 3013 */       if (this.homelevel != _o_.homelevel) return false;
/* 3014 */       if (this.cleanliness != _o_.cleanliness) return false;
/* 3015 */       if (this.petroomlevel != _o_.petroomlevel) return false;
/* 3016 */       if (this.bedroomlevel != _o_.bedroomlevel) return false;
/* 3017 */       if (this.daycleancount != _o_.daycleancount) return false;
/* 3018 */       if (this.drugroomlevel != _o_.drugroomlevel) return false;
/* 3019 */       if (this.kitchenlevel != _o_.kitchenlevel) return false;
/* 3020 */       if (this.maidroomlevel != _o_.maidroomlevel) return false;
/* 3021 */       if (!this.uuid2maidinfo.equals(_o_.uuid2maidinfo)) return false;
/* 3022 */       if (this.currentmaiduuid != _o_.currentmaiduuid) return false;
/* 3023 */       if (this.ismainhome != _o_.ismainhome) return false;
/* 3024 */       if (this.updatetime != _o_.updatetime) return false;
/* 3025 */       if (!this.mydisplayfurniture.equals(_o_.mydisplayfurniture)) return false;
/* 3026 */       if (!this.partnerdisplayfurniture.equals(_o_.partnerdisplayfurniture)) return false;
/* 3027 */       if (this.courtyardlevel != _o_.courtyardlevel) return false;
/* 3028 */       if (this.fengshui != _o_.fengshui) return false;
/* 3029 */       if (this.walluuid != _o_.walluuid) return false;
/* 3030 */       if (this.flooruuid != _o_.flooruuid) return false;
/* 3031 */       if (this.court_yard_beautiful != _o_.court_yard_beautiful) return false;
/* 3032 */       if (this.court_yard_cleanliness_refresh_time != _o_.court_yard_cleanliness_refresh_time) return false;
/* 3033 */       if (this.court_yard_cleanliness != _o_.court_yard_cleanliness) return false;
/* 3034 */       if (this.court_yard_day_clean_count != _o_.court_yard_day_clean_count) return false;
/* 3035 */       if (this.fence_uuid != _o_.fence_uuid) return false;
/* 3036 */       if (this.court_yard_terrain_uuid != _o_.court_yard_terrain_uuid) return false;
/* 3037 */       if (this.court_yard_road_uuid != _o_.court_yard_road_uuid) return false;
/* 3038 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 3044 */       int _h_ = 0;
/* 3045 */       _h_ += this.homelevel;
/* 3046 */       _h_ += this.cleanliness;
/* 3047 */       _h_ += this.petroomlevel;
/* 3048 */       _h_ += this.bedroomlevel;
/* 3049 */       _h_ += this.daycleancount;
/* 3050 */       _h_ += this.drugroomlevel;
/* 3051 */       _h_ += this.kitchenlevel;
/* 3052 */       _h_ += this.maidroomlevel;
/* 3053 */       _h_ += this.uuid2maidinfo.hashCode();
/* 3054 */       _h_ = (int)(_h_ + this.currentmaiduuid);
/* 3055 */       _h_ += (this.ismainhome ? 1231 : 1237);
/* 3056 */       _h_ = (int)(_h_ + this.updatetime);
/* 3057 */       _h_ += this.mydisplayfurniture.hashCode();
/* 3058 */       _h_ += this.partnerdisplayfurniture.hashCode();
/* 3059 */       _h_ += this.courtyardlevel;
/* 3060 */       _h_ += this.fengshui;
/* 3061 */       _h_ = (int)(_h_ + this.walluuid);
/* 3062 */       _h_ = (int)(_h_ + this.flooruuid);
/* 3063 */       _h_ += this.court_yard_beautiful;
/* 3064 */       _h_ = (int)(_h_ + this.court_yard_cleanliness_refresh_time);
/* 3065 */       _h_ += this.court_yard_cleanliness;
/* 3066 */       _h_ += this.court_yard_day_clean_count;
/* 3067 */       _h_ = (int)(_h_ + this.fence_uuid);
/* 3068 */       _h_ = (int)(_h_ + this.court_yard_terrain_uuid);
/* 3069 */       _h_ = (int)(_h_ + this.court_yard_road_uuid);
/* 3070 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 3076 */       StringBuilder _sb_ = new StringBuilder();
/* 3077 */       _sb_.append("(");
/* 3078 */       _sb_.append(this.homelevel);
/* 3079 */       _sb_.append(",");
/* 3080 */       _sb_.append(this.cleanliness);
/* 3081 */       _sb_.append(",");
/* 3082 */       _sb_.append(this.petroomlevel);
/* 3083 */       _sb_.append(",");
/* 3084 */       _sb_.append(this.bedroomlevel);
/* 3085 */       _sb_.append(",");
/* 3086 */       _sb_.append(this.daycleancount);
/* 3087 */       _sb_.append(",");
/* 3088 */       _sb_.append(this.drugroomlevel);
/* 3089 */       _sb_.append(",");
/* 3090 */       _sb_.append(this.kitchenlevel);
/* 3091 */       _sb_.append(",");
/* 3092 */       _sb_.append(this.maidroomlevel);
/* 3093 */       _sb_.append(",");
/* 3094 */       _sb_.append(this.uuid2maidinfo);
/* 3095 */       _sb_.append(",");
/* 3096 */       _sb_.append(this.currentmaiduuid);
/* 3097 */       _sb_.append(",");
/* 3098 */       _sb_.append(this.ismainhome);
/* 3099 */       _sb_.append(",");
/* 3100 */       _sb_.append(this.updatetime);
/* 3101 */       _sb_.append(",");
/* 3102 */       _sb_.append(this.mydisplayfurniture);
/* 3103 */       _sb_.append(",");
/* 3104 */       _sb_.append(this.partnerdisplayfurniture);
/* 3105 */       _sb_.append(",");
/* 3106 */       _sb_.append(this.courtyardlevel);
/* 3107 */       _sb_.append(",");
/* 3108 */       _sb_.append(this.fengshui);
/* 3109 */       _sb_.append(",");
/* 3110 */       _sb_.append(this.walluuid);
/* 3111 */       _sb_.append(",");
/* 3112 */       _sb_.append(this.flooruuid);
/* 3113 */       _sb_.append(",");
/* 3114 */       _sb_.append(this.court_yard_beautiful);
/* 3115 */       _sb_.append(",");
/* 3116 */       _sb_.append(this.court_yard_cleanliness_refresh_time);
/* 3117 */       _sb_.append(",");
/* 3118 */       _sb_.append(this.court_yard_cleanliness);
/* 3119 */       _sb_.append(",");
/* 3120 */       _sb_.append(this.court_yard_day_clean_count);
/* 3121 */       _sb_.append(",");
/* 3122 */       _sb_.append(this.fence_uuid);
/* 3123 */       _sb_.append(",");
/* 3124 */       _sb_.append(this.court_yard_terrain_uuid);
/* 3125 */       _sb_.append(",");
/* 3126 */       _sb_.append(this.court_yard_road_uuid);
/* 3127 */       _sb_.append(")");
/* 3128 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\HomeInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */