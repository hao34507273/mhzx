/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.util.ArrayList;
/*      */ import java.util.HashMap;
/*      */ import java.util.HashSet;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import java.util.Set;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import ppbio.Message;
/*      */ import xdb.LogKey;
/*      */ import xdb.Logs;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableChanged;
/*      */ import xdb.util.SetX;
/*      */ 
/*      */ public final class Item extends XBean implements xbean.Item
/*      */ {
/*      */   private int cfgid;
/*      */   private int number;
/*      */   private SetX<Long> uuid;
/*      */   private long marketbuytime;
/*      */   private int flags;
/*      */   private HashMap<Integer, Integer> extra;
/*      */   private ArrayList<xbean.XExtraProBean> extraprolist;
/*      */   private HashMap<Integer, xbean.TempExtraProInfo> tempextrapropinfos;
/*      */   private ArrayList<xbean.FumoInfo> fumoprolist;
/*      */   private xbean.SuperEquipmentCostBean superequipmentcostbean;
/*      */   private HashMap<Integer, xbean.JewelInfo> jewelmap;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   38 */     this.cfgid = 0;
/*   39 */     this.number = 0;
/*   40 */     this.uuid.clear();
/*   41 */     this.marketbuytime = 0L;
/*   42 */     this.flags = 0;
/*   43 */     this.extra.clear();
/*   44 */     this.extraprolist.clear();
/*   45 */     this.tempextrapropinfos.clear();
/*   46 */     this.fumoprolist.clear();
/*   47 */     this.superequipmentcostbean._reset_unsafe_();
/*   48 */     this.jewelmap.clear();
/*      */   }
/*      */   
/*      */   Item(int __, XBean _xp_, String _vn_)
/*      */   {
/*   53 */     super(_xp_, _vn_);
/*   54 */     this.uuid = new SetX();
/*   55 */     this.marketbuytime = 0L;
/*   56 */     this.flags = 0;
/*   57 */     this.extra = new HashMap();
/*   58 */     this.extraprolist = new ArrayList();
/*   59 */     this.tempextrapropinfos = new HashMap();
/*   60 */     this.fumoprolist = new ArrayList();
/*   61 */     this.superequipmentcostbean = new SuperEquipmentCostBean(0, this, "superequipmentcostbean");
/*   62 */     this.jewelmap = new HashMap();
/*      */   }
/*      */   
/*      */   public Item()
/*      */   {
/*   67 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public Item(Item _o_)
/*      */   {
/*   72 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   Item(xbean.Item _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   77 */     super(_xp_, _vn_);
/*   78 */     if ((_o1_ instanceof Item)) { assign((Item)_o1_);
/*   79 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   80 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   81 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(Item _o_) {
/*   86 */     _o_._xdb_verify_unsafe_();
/*   87 */     this.cfgid = _o_.cfgid;
/*   88 */     this.number = _o_.number;
/*   89 */     this.uuid = new SetX();
/*   90 */     this.uuid.addAll(_o_.uuid);
/*   91 */     this.marketbuytime = _o_.marketbuytime;
/*   92 */     this.flags = _o_.flags;
/*   93 */     this.extra = new HashMap();
/*   94 */     for (Map.Entry<Integer, Integer> _e_ : _o_.extra.entrySet())
/*   95 */       this.extra.put(_e_.getKey(), _e_.getValue());
/*   96 */     this.extraprolist = new ArrayList();
/*   97 */     for (xbean.XExtraProBean _v_ : _o_.extraprolist)
/*   98 */       this.extraprolist.add(new XExtraProBean(_v_, this, "extraprolist"));
/*   99 */     this.tempextrapropinfos = new HashMap();
/*  100 */     for (Map.Entry<Integer, xbean.TempExtraProInfo> _e_ : _o_.tempextrapropinfos.entrySet())
/*  101 */       this.tempextrapropinfos.put(_e_.getKey(), new TempExtraProInfo((xbean.TempExtraProInfo)_e_.getValue(), this, "tempextrapropinfos"));
/*  102 */     this.fumoprolist = new ArrayList();
/*  103 */     for (xbean.FumoInfo _v_ : _o_.fumoprolist)
/*  104 */       this.fumoprolist.add(new FumoInfo(_v_, this, "fumoprolist"));
/*  105 */     this.superequipmentcostbean = new SuperEquipmentCostBean(_o_.superequipmentcostbean, this, "superequipmentcostbean");
/*  106 */     this.jewelmap = new HashMap();
/*  107 */     for (Map.Entry<Integer, xbean.JewelInfo> _e_ : _o_.jewelmap.entrySet()) {
/*  108 */       this.jewelmap.put(_e_.getKey(), new JewelInfo((xbean.JewelInfo)_e_.getValue(), this, "jewelmap"));
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(Data _o_) {
/*  113 */     this.cfgid = _o_.cfgid;
/*  114 */     this.number = _o_.number;
/*  115 */     this.uuid = new SetX();
/*  116 */     this.uuid.addAll(_o_.uuid);
/*  117 */     this.marketbuytime = _o_.marketbuytime;
/*  118 */     this.flags = _o_.flags;
/*  119 */     this.extra = new HashMap();
/*  120 */     for (Map.Entry<Integer, Integer> _e_ : _o_.extra.entrySet())
/*  121 */       this.extra.put(_e_.getKey(), _e_.getValue());
/*  122 */     this.extraprolist = new ArrayList();
/*  123 */     for (xbean.XExtraProBean _v_ : _o_.extraprolist)
/*  124 */       this.extraprolist.add(new XExtraProBean(_v_, this, "extraprolist"));
/*  125 */     this.tempextrapropinfos = new HashMap();
/*  126 */     for (Map.Entry<Integer, xbean.TempExtraProInfo> _e_ : _o_.tempextrapropinfos.entrySet())
/*  127 */       this.tempextrapropinfos.put(_e_.getKey(), new TempExtraProInfo((xbean.TempExtraProInfo)_e_.getValue(), this, "tempextrapropinfos"));
/*  128 */     this.fumoprolist = new ArrayList();
/*  129 */     for (xbean.FumoInfo _v_ : _o_.fumoprolist)
/*  130 */       this.fumoprolist.add(new FumoInfo(_v_, this, "fumoprolist"));
/*  131 */     this.superequipmentcostbean = new SuperEquipmentCostBean(_o_.superequipmentcostbean, this, "superequipmentcostbean");
/*  132 */     this.jewelmap = new HashMap();
/*  133 */     for (Map.Entry<Integer, xbean.JewelInfo> _e_ : _o_.jewelmap.entrySet()) {
/*  134 */       this.jewelmap.put(_e_.getKey(), new JewelInfo((xbean.JewelInfo)_e_.getValue(), this, "jewelmap"));
/*      */     }
/*      */   }
/*      */   
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*  140 */     _xdb_verify_unsafe_();
/*  141 */     _os_.marshal(this.cfgid);
/*  142 */     _os_.marshal(this.number);
/*  143 */     _os_.compact_uint32(this.uuid.size());
/*  144 */     for (Long _v_ : this.uuid)
/*      */     {
/*  146 */       _os_.marshal(_v_.longValue());
/*      */     }
/*  148 */     _os_.marshal(this.marketbuytime);
/*  149 */     _os_.marshal(this.flags);
/*  150 */     _os_.compact_uint32(this.extra.size());
/*  151 */     for (Map.Entry<Integer, Integer> _e_ : this.extra.entrySet())
/*      */     {
/*  153 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  154 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */     }
/*  156 */     _os_.compact_uint32(this.extraprolist.size());
/*  157 */     for (xbean.XExtraProBean _v_ : this.extraprolist)
/*      */     {
/*  159 */       _v_.marshal(_os_);
/*      */     }
/*  161 */     _os_.compact_uint32(this.tempextrapropinfos.size());
/*  162 */     for (Map.Entry<Integer, xbean.TempExtraProInfo> _e_ : this.tempextrapropinfos.entrySet())
/*      */     {
/*  164 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  165 */       ((xbean.TempExtraProInfo)_e_.getValue()).marshal(_os_);
/*      */     }
/*  167 */     _os_.compact_uint32(this.fumoprolist.size());
/*  168 */     for (xbean.FumoInfo _v_ : this.fumoprolist)
/*      */     {
/*  170 */       _v_.marshal(_os_);
/*      */     }
/*  172 */     this.superequipmentcostbean.marshal(_os_);
/*  173 */     _os_.compact_uint32(this.jewelmap.size());
/*  174 */     for (Map.Entry<Integer, xbean.JewelInfo> _e_ : this.jewelmap.entrySet())
/*      */     {
/*  176 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  177 */       ((xbean.JewelInfo)_e_.getValue()).marshal(_os_);
/*      */     }
/*  179 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  185 */     _xdb_verify_unsafe_();
/*  186 */     this.cfgid = _os_.unmarshal_int();
/*  187 */     this.number = _os_.unmarshal_int();
/*  188 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  190 */       long _v_ = 0L;
/*  191 */       _v_ = _os_.unmarshal_long();
/*  192 */       this.uuid.add(Long.valueOf(_v_));
/*      */     }
/*  194 */     this.marketbuytime = _os_.unmarshal_long();
/*  195 */     this.flags = _os_.unmarshal_int();
/*      */     
/*  197 */     int size = _os_.uncompact_uint32();
/*  198 */     if (size >= 12)
/*      */     {
/*  200 */       this.extra = new HashMap(size * 2);
/*      */     }
/*  202 */     for (; size > 0; size--)
/*      */     {
/*  204 */       int _k_ = 0;
/*  205 */       _k_ = _os_.unmarshal_int();
/*  206 */       int _v_ = 0;
/*  207 */       _v_ = _os_.unmarshal_int();
/*  208 */       this.extra.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*      */     }
/*      */     
/*  211 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  213 */       xbean.XExtraProBean _v_ = new XExtraProBean(0, this, "extraprolist");
/*  214 */       _v_.unmarshal(_os_);
/*  215 */       this.extraprolist.add(_v_);
/*      */     }
/*      */     
/*  218 */     int size = _os_.uncompact_uint32();
/*  219 */     if (size >= 12)
/*      */     {
/*  221 */       this.tempextrapropinfos = new HashMap(size * 2);
/*      */     }
/*  223 */     for (; size > 0; size--)
/*      */     {
/*  225 */       int _k_ = 0;
/*  226 */       _k_ = _os_.unmarshal_int();
/*  227 */       xbean.TempExtraProInfo _v_ = new TempExtraProInfo(0, this, "tempextrapropinfos");
/*  228 */       _v_.unmarshal(_os_);
/*  229 */       this.tempextrapropinfos.put(Integer.valueOf(_k_), _v_);
/*      */     }
/*      */     
/*  232 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  234 */       xbean.FumoInfo _v_ = new FumoInfo(0, this, "fumoprolist");
/*  235 */       _v_.unmarshal(_os_);
/*  236 */       this.fumoprolist.add(_v_);
/*      */     }
/*  238 */     this.superequipmentcostbean.unmarshal(_os_);
/*      */     
/*  240 */     int size = _os_.uncompact_uint32();
/*  241 */     if (size >= 12)
/*      */     {
/*  243 */       this.jewelmap = new HashMap(size * 2);
/*      */     }
/*  245 */     for (; size > 0; size--)
/*      */     {
/*  247 */       int _k_ = 0;
/*  248 */       _k_ = _os_.unmarshal_int();
/*  249 */       xbean.JewelInfo _v_ = new JewelInfo(0, this, "jewelmap");
/*  250 */       _v_.unmarshal(_os_);
/*  251 */       this.jewelmap.put(Integer.valueOf(_k_), _v_);
/*      */     }
/*      */     
/*  254 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  260 */     _xdb_verify_unsafe_();
/*  261 */     int _size_ = 0;
/*  262 */     _size_ += CodedOutputStream.computeInt32Size(1, this.cfgid);
/*  263 */     _size_ += CodedOutputStream.computeInt32Size(2, this.number);
/*  264 */     for (Long _v_ : this.uuid)
/*      */     {
/*  266 */       _size_ += CodedOutputStream.computeInt64Size(3, _v_.longValue());
/*      */     }
/*  268 */     _size_ += CodedOutputStream.computeInt64Size(4, this.marketbuytime);
/*  269 */     _size_ += CodedOutputStream.computeInt32Size(5, this.flags);
/*  270 */     for (Map.Entry<Integer, Integer> _e_ : this.extra.entrySet())
/*      */     {
/*  272 */       _size_ += CodedOutputStream.computeInt32Size(6, ((Integer)_e_.getKey()).intValue());
/*  273 */       _size_ += CodedOutputStream.computeInt32Size(6, ((Integer)_e_.getValue()).intValue());
/*      */     }
/*  275 */     for (xbean.XExtraProBean _v_ : this.extraprolist)
/*      */     {
/*  277 */       _size_ += CodedOutputStream.computeMessageSize(7, _v_);
/*      */     }
/*  279 */     for (Map.Entry<Integer, xbean.TempExtraProInfo> _e_ : this.tempextrapropinfos.entrySet())
/*      */     {
/*  281 */       _size_ += CodedOutputStream.computeInt32Size(8, ((Integer)_e_.getKey()).intValue());
/*  282 */       _size_ += CodedOutputStream.computeMessageSize(8, (Message)_e_.getValue());
/*      */     }
/*  284 */     for (xbean.FumoInfo _v_ : this.fumoprolist)
/*      */     {
/*  286 */       _size_ += CodedOutputStream.computeMessageSize(9, _v_);
/*      */     }
/*  288 */     _size_ += CodedOutputStream.computeMessageSize(10, this.superequipmentcostbean);
/*  289 */     for (Map.Entry<Integer, xbean.JewelInfo> _e_ : this.jewelmap.entrySet())
/*      */     {
/*  291 */       _size_ += CodedOutputStream.computeInt32Size(11, ((Integer)_e_.getKey()).intValue());
/*  292 */       _size_ += CodedOutputStream.computeMessageSize(11, (Message)_e_.getValue());
/*      */     }
/*  294 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  300 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  303 */       _output_.writeInt32(1, this.cfgid);
/*  304 */       _output_.writeInt32(2, this.number);
/*  305 */       for (Long _v_ : this.uuid)
/*      */       {
/*  307 */         _output_.writeInt64(3, _v_.longValue());
/*      */       }
/*  309 */       _output_.writeInt64(4, this.marketbuytime);
/*  310 */       _output_.writeInt32(5, this.flags);
/*  311 */       for (Map.Entry<Integer, Integer> _e_ : this.extra.entrySet())
/*      */       {
/*  313 */         _output_.writeInt32(6, ((Integer)_e_.getKey()).intValue());
/*  314 */         _output_.writeInt32(6, ((Integer)_e_.getValue()).intValue());
/*      */       }
/*  316 */       for (xbean.XExtraProBean _v_ : this.extraprolist)
/*      */       {
/*  318 */         _output_.writeMessage(7, _v_);
/*      */       }
/*  320 */       for (Map.Entry<Integer, xbean.TempExtraProInfo> _e_ : this.tempextrapropinfos.entrySet())
/*      */       {
/*  322 */         _output_.writeInt32(8, ((Integer)_e_.getKey()).intValue());
/*  323 */         _output_.writeMessage(8, (Message)_e_.getValue());
/*      */       }
/*  325 */       for (xbean.FumoInfo _v_ : this.fumoprolist)
/*      */       {
/*  327 */         _output_.writeMessage(9, _v_);
/*      */       }
/*  329 */       _output_.writeMessage(10, this.superequipmentcostbean);
/*  330 */       for (Map.Entry<Integer, xbean.JewelInfo> _e_ : this.jewelmap.entrySet())
/*      */       {
/*  332 */         _output_.writeInt32(11, ((Integer)_e_.getKey()).intValue());
/*  333 */         _output_.writeMessage(11, (Message)_e_.getValue());
/*      */       }
/*      */     }
/*      */     catch (java.io.IOException e)
/*      */     {
/*  338 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  340 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  346 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  349 */       boolean done = false;
/*  350 */       while (!done)
/*      */       {
/*  352 */         int tag = _input_.readTag();
/*  353 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  357 */           done = true;
/*  358 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  362 */           this.cfgid = _input_.readInt32();
/*  363 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  367 */           this.number = _input_.readInt32();
/*  368 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  372 */           long _v_ = 0L;
/*  373 */           _v_ = _input_.readInt64();
/*  374 */           this.uuid.add(Long.valueOf(_v_));
/*  375 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  379 */           this.marketbuytime = _input_.readInt64();
/*  380 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  384 */           this.flags = _input_.readInt32();
/*  385 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  389 */           int _k_ = 0;
/*  390 */           _k_ = _input_.readInt32();
/*  391 */           int readTag = _input_.readTag();
/*  392 */           if (48 != readTag)
/*      */           {
/*  394 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  396 */           int _v_ = 0;
/*  397 */           _v_ = _input_.readInt32();
/*  398 */           this.extra.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*  399 */           break;
/*      */         
/*      */ 
/*      */         case 58: 
/*  403 */           xbean.XExtraProBean _v_ = new XExtraProBean(0, this, "extraprolist");
/*  404 */           _input_.readMessage(_v_);
/*  405 */           this.extraprolist.add(_v_);
/*  406 */           break;
/*      */         
/*      */ 
/*      */         case 64: 
/*  410 */           int _k_ = 0;
/*  411 */           _k_ = _input_.readInt32();
/*  412 */           int readTag = _input_.readTag();
/*  413 */           if (66 != readTag)
/*      */           {
/*  415 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  417 */           xbean.TempExtraProInfo _v_ = new TempExtraProInfo(0, this, "tempextrapropinfos");
/*  418 */           _input_.readMessage(_v_);
/*  419 */           this.tempextrapropinfos.put(Integer.valueOf(_k_), _v_);
/*  420 */           break;
/*      */         
/*      */ 
/*      */         case 74: 
/*  424 */           xbean.FumoInfo _v_ = new FumoInfo(0, this, "fumoprolist");
/*  425 */           _input_.readMessage(_v_);
/*  426 */           this.fumoprolist.add(_v_);
/*  427 */           break;
/*      */         
/*      */ 
/*      */         case 82: 
/*  431 */           _input_.readMessage(this.superequipmentcostbean);
/*  432 */           break;
/*      */         
/*      */ 
/*      */         case 88: 
/*  436 */           int _k_ = 0;
/*  437 */           _k_ = _input_.readInt32();
/*  438 */           int readTag = _input_.readTag();
/*  439 */           if (90 != readTag)
/*      */           {
/*  441 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  443 */           xbean.JewelInfo _v_ = new JewelInfo(0, this, "jewelmap");
/*  444 */           _input_.readMessage(_v_);
/*  445 */           this.jewelmap.put(Integer.valueOf(_k_), _v_);
/*  446 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  450 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  452 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  461 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (java.io.IOException e)
/*      */     {
/*  465 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  467 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.Item copy()
/*      */   {
/*  473 */     _xdb_verify_unsafe_();
/*  474 */     return new Item(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.Item toData()
/*      */   {
/*  480 */     _xdb_verify_unsafe_();
/*  481 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.Item toBean()
/*      */   {
/*  486 */     _xdb_verify_unsafe_();
/*  487 */     return new Item(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.Item toDataIf()
/*      */   {
/*  493 */     _xdb_verify_unsafe_();
/*  494 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.Item toBeanIf()
/*      */   {
/*  499 */     _xdb_verify_unsafe_();
/*  500 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  506 */     _xdb_verify_unsafe_();
/*  507 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getCfgid()
/*      */   {
/*  514 */     _xdb_verify_unsafe_();
/*  515 */     return this.cfgid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getNumber()
/*      */   {
/*  522 */     _xdb_verify_unsafe_();
/*  523 */     return this.number;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Set<Long> getUuid()
/*      */   {
/*  530 */     _xdb_verify_unsafe_();
/*  531 */     return Logs.logSet(new LogKey(this, "uuid"), this.uuid);
/*      */   }
/*      */   
/*      */ 
/*      */   public Set<Long> getUuidAsData()
/*      */   {
/*  537 */     _xdb_verify_unsafe_();
/*      */     
/*  539 */     Item _o_ = this;
/*  540 */     Set<Long> uuid = new SetX();
/*  541 */     uuid.addAll(_o_.uuid);
/*  542 */     return uuid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getMarketbuytime()
/*      */   {
/*  549 */     _xdb_verify_unsafe_();
/*  550 */     return this.marketbuytime;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getFlags()
/*      */   {
/*  557 */     _xdb_verify_unsafe_();
/*  558 */     return this.flags;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getExtra()
/*      */   {
/*  565 */     _xdb_verify_unsafe_();
/*  566 */     return Logs.logMap(new LogKey(this, "extra"), this.extra);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getExtraAsData()
/*      */   {
/*  573 */     _xdb_verify_unsafe_();
/*      */     
/*  575 */     Item _o_ = this;
/*  576 */     Map<Integer, Integer> extra = new HashMap();
/*  577 */     for (Map.Entry<Integer, Integer> _e_ : _o_.extra.entrySet())
/*  578 */       extra.put(_e_.getKey(), _e_.getValue());
/*  579 */     return extra;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<xbean.XExtraProBean> getExtraprolist()
/*      */   {
/*  586 */     _xdb_verify_unsafe_();
/*  587 */     return Logs.logList(new LogKey(this, "extraprolist"), this.extraprolist);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<xbean.XExtraProBean> getExtraprolistAsData()
/*      */   {
/*  593 */     _xdb_verify_unsafe_();
/*      */     
/*  595 */     Item _o_ = this;
/*  596 */     List<xbean.XExtraProBean> extraprolist = new ArrayList();
/*  597 */     for (xbean.XExtraProBean _v_ : _o_.extraprolist)
/*  598 */       extraprolist.add(new XExtraProBean.Data(_v_));
/*  599 */     return extraprolist;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.TempExtraProInfo> getTempextrapropinfos()
/*      */   {
/*  606 */     _xdb_verify_unsafe_();
/*  607 */     return Logs.logMap(new LogKey(this, "tempextrapropinfos"), this.tempextrapropinfos);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.TempExtraProInfo> getTempextrapropinfosAsData()
/*      */   {
/*  614 */     _xdb_verify_unsafe_();
/*      */     
/*  616 */     Item _o_ = this;
/*  617 */     Map<Integer, xbean.TempExtraProInfo> tempextrapropinfos = new HashMap();
/*  618 */     for (Map.Entry<Integer, xbean.TempExtraProInfo> _e_ : _o_.tempextrapropinfos.entrySet())
/*  619 */       tempextrapropinfos.put(_e_.getKey(), new TempExtraProInfo.Data((xbean.TempExtraProInfo)_e_.getValue()));
/*  620 */     return tempextrapropinfos;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<xbean.FumoInfo> getFumoprolist()
/*      */   {
/*  627 */     _xdb_verify_unsafe_();
/*  628 */     return Logs.logList(new LogKey(this, "fumoprolist"), this.fumoprolist);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<xbean.FumoInfo> getFumoprolistAsData()
/*      */   {
/*  634 */     _xdb_verify_unsafe_();
/*      */     
/*  636 */     Item _o_ = this;
/*  637 */     List<xbean.FumoInfo> fumoprolist = new ArrayList();
/*  638 */     for (xbean.FumoInfo _v_ : _o_.fumoprolist)
/*  639 */       fumoprolist.add(new FumoInfo.Data(_v_));
/*  640 */     return fumoprolist;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public xbean.SuperEquipmentCostBean getSuperequipmentcostbean()
/*      */   {
/*  647 */     _xdb_verify_unsafe_();
/*  648 */     return this.superequipmentcostbean;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.JewelInfo> getJewelmap()
/*      */   {
/*  655 */     _xdb_verify_unsafe_();
/*  656 */     return Logs.logMap(new LogKey(this, "jewelmap"), this.jewelmap);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.JewelInfo> getJewelmapAsData()
/*      */   {
/*  663 */     _xdb_verify_unsafe_();
/*      */     
/*  665 */     Item _o_ = this;
/*  666 */     Map<Integer, xbean.JewelInfo> jewelmap = new HashMap();
/*  667 */     for (Map.Entry<Integer, xbean.JewelInfo> _e_ : _o_.jewelmap.entrySet())
/*  668 */       jewelmap.put(_e_.getKey(), new JewelInfo.Data((xbean.JewelInfo)_e_.getValue()));
/*  669 */     return jewelmap;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setCfgid(int _v_)
/*      */   {
/*  676 */     _xdb_verify_unsafe_();
/*  677 */     Logs.logIf(new LogKey(this, "cfgid")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  681 */         new xdb.logs.LogInt(this, Item.this.cfgid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  685 */             Item.this.cfgid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  689 */     });
/*  690 */     this.cfgid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setNumber(int _v_)
/*      */   {
/*  697 */     _xdb_verify_unsafe_();
/*  698 */     Logs.logIf(new LogKey(this, "number")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  702 */         new xdb.logs.LogInt(this, Item.this.number)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  706 */             Item.this.number = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  710 */     });
/*  711 */     this.number = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setMarketbuytime(long _v_)
/*      */   {
/*  718 */     _xdb_verify_unsafe_();
/*  719 */     Logs.logIf(new LogKey(this, "marketbuytime")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  723 */         new xdb.logs.LogLong(this, Item.this.marketbuytime)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  727 */             Item.this.marketbuytime = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  731 */     });
/*  732 */     this.marketbuytime = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setFlags(int _v_)
/*      */   {
/*  739 */     _xdb_verify_unsafe_();
/*  740 */     Logs.logIf(new LogKey(this, "flags")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  744 */         new xdb.logs.LogInt(this, Item.this.flags)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  748 */             Item.this.flags = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  752 */     });
/*  753 */     this.flags = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  759 */     _xdb_verify_unsafe_();
/*  760 */     Item _o_ = null;
/*  761 */     if ((_o1_ instanceof Item)) { _o_ = (Item)_o1_;
/*  762 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  763 */       return false;
/*  764 */     if (this.cfgid != _o_.cfgid) return false;
/*  765 */     if (this.number != _o_.number) return false;
/*  766 */     if (!this.uuid.equals(_o_.uuid)) return false;
/*  767 */     if (this.marketbuytime != _o_.marketbuytime) return false;
/*  768 */     if (this.flags != _o_.flags) return false;
/*  769 */     if (!this.extra.equals(_o_.extra)) return false;
/*  770 */     if (!this.extraprolist.equals(_o_.extraprolist)) return false;
/*  771 */     if (!this.tempextrapropinfos.equals(_o_.tempextrapropinfos)) return false;
/*  772 */     if (!this.fumoprolist.equals(_o_.fumoprolist)) return false;
/*  773 */     if (!this.superequipmentcostbean.equals(_o_.superequipmentcostbean)) return false;
/*  774 */     if (!this.jewelmap.equals(_o_.jewelmap)) return false;
/*  775 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  781 */     _xdb_verify_unsafe_();
/*  782 */     int _h_ = 0;
/*  783 */     _h_ += this.cfgid;
/*  784 */     _h_ += this.number;
/*  785 */     _h_ += this.uuid.hashCode();
/*  786 */     _h_ = (int)(_h_ + this.marketbuytime);
/*  787 */     _h_ += this.flags;
/*  788 */     _h_ += this.extra.hashCode();
/*  789 */     _h_ += this.extraprolist.hashCode();
/*  790 */     _h_ += this.tempextrapropinfos.hashCode();
/*  791 */     _h_ += this.fumoprolist.hashCode();
/*  792 */     _h_ += this.superequipmentcostbean.hashCode();
/*  793 */     _h_ += this.jewelmap.hashCode();
/*  794 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  800 */     _xdb_verify_unsafe_();
/*  801 */     StringBuilder _sb_ = new StringBuilder();
/*  802 */     _sb_.append("(");
/*  803 */     _sb_.append(this.cfgid);
/*  804 */     _sb_.append(",");
/*  805 */     _sb_.append(this.number);
/*  806 */     _sb_.append(",");
/*  807 */     _sb_.append(this.uuid);
/*  808 */     _sb_.append(",");
/*  809 */     _sb_.append(this.marketbuytime);
/*  810 */     _sb_.append(",");
/*  811 */     _sb_.append(this.flags);
/*  812 */     _sb_.append(",");
/*  813 */     _sb_.append(this.extra);
/*  814 */     _sb_.append(",");
/*  815 */     _sb_.append(this.extraprolist);
/*  816 */     _sb_.append(",");
/*  817 */     _sb_.append(this.tempextrapropinfos);
/*  818 */     _sb_.append(",");
/*  819 */     _sb_.append(this.fumoprolist);
/*  820 */     _sb_.append(",");
/*  821 */     _sb_.append(this.superequipmentcostbean);
/*  822 */     _sb_.append(",");
/*  823 */     _sb_.append(this.jewelmap);
/*  824 */     _sb_.append(")");
/*  825 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  831 */     ListenableBean lb = new ListenableBean();
/*  832 */     lb.add(new ListenableChanged().setVarName("cfgid"));
/*  833 */     lb.add(new ListenableChanged().setVarName("number"));
/*  834 */     lb.add(new xdb.logs.ListenableSet().setVarName("uuid"));
/*  835 */     lb.add(new ListenableChanged().setVarName("marketbuytime"));
/*  836 */     lb.add(new ListenableChanged().setVarName("flags"));
/*  837 */     lb.add(new xdb.logs.ListenableMap().setVarName("extra"));
/*  838 */     lb.add(new ListenableChanged().setVarName("extraprolist"));
/*  839 */     lb.add(new xdb.logs.ListenableMap().setVarName("tempextrapropinfos"));
/*  840 */     lb.add(new ListenableChanged().setVarName("fumoprolist"));
/*  841 */     lb.add(new ListenableChanged().setVarName("superequipmentcostbean"));
/*  842 */     lb.add(new xdb.logs.ListenableMap().setVarName("jewelmap"));
/*  843 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.Item {
/*      */     private Const() {}
/*      */     
/*      */     Item nThis() {
/*  850 */       return Item.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  856 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Item copy()
/*      */     {
/*  862 */       return Item.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Item toData()
/*      */     {
/*  868 */       return Item.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.Item toBean()
/*      */     {
/*  873 */       return Item.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Item toDataIf()
/*      */     {
/*  879 */       return Item.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.Item toBeanIf()
/*      */     {
/*  884 */       return Item.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCfgid()
/*      */     {
/*  891 */       Item.this._xdb_verify_unsafe_();
/*  892 */       return Item.this.cfgid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getNumber()
/*      */     {
/*  899 */       Item.this._xdb_verify_unsafe_();
/*  900 */       return Item.this.number;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Long> getUuid()
/*      */     {
/*  907 */       Item.this._xdb_verify_unsafe_();
/*  908 */       return xdb.Consts.constSet(Item.this.uuid);
/*      */     }
/*      */     
/*      */ 
/*      */     public Set<Long> getUuidAsData()
/*      */     {
/*  914 */       Item.this._xdb_verify_unsafe_();
/*      */       
/*  916 */       Item _o_ = Item.this;
/*  917 */       Set<Long> uuid = new SetX();
/*  918 */       uuid.addAll(_o_.uuid);
/*  919 */       return uuid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getMarketbuytime()
/*      */     {
/*  926 */       Item.this._xdb_verify_unsafe_();
/*  927 */       return Item.this.marketbuytime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getFlags()
/*      */     {
/*  934 */       Item.this._xdb_verify_unsafe_();
/*  935 */       return Item.this.flags;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getExtra()
/*      */     {
/*  942 */       Item.this._xdb_verify_unsafe_();
/*  943 */       return xdb.Consts.constMap(Item.this.extra);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getExtraAsData()
/*      */     {
/*  950 */       Item.this._xdb_verify_unsafe_();
/*      */       
/*  952 */       Item _o_ = Item.this;
/*  953 */       Map<Integer, Integer> extra = new HashMap();
/*  954 */       for (Map.Entry<Integer, Integer> _e_ : _o_.extra.entrySet())
/*  955 */         extra.put(_e_.getKey(), _e_.getValue());
/*  956 */       return extra;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<xbean.XExtraProBean> getExtraprolist()
/*      */     {
/*  963 */       Item.this._xdb_verify_unsafe_();
/*  964 */       return xdb.Consts.constList(Item.this.extraprolist);
/*      */     }
/*      */     
/*      */ 
/*      */     public List<xbean.XExtraProBean> getExtraprolistAsData()
/*      */     {
/*  970 */       Item.this._xdb_verify_unsafe_();
/*      */       
/*  972 */       Item _o_ = Item.this;
/*  973 */       List<xbean.XExtraProBean> extraprolist = new ArrayList();
/*  974 */       for (xbean.XExtraProBean _v_ : _o_.extraprolist)
/*  975 */         extraprolist.add(new XExtraProBean.Data(_v_));
/*  976 */       return extraprolist;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.TempExtraProInfo> getTempextrapropinfos()
/*      */     {
/*  983 */       Item.this._xdb_verify_unsafe_();
/*  984 */       return xdb.Consts.constMap(Item.this.tempextrapropinfos);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.TempExtraProInfo> getTempextrapropinfosAsData()
/*      */     {
/*  991 */       Item.this._xdb_verify_unsafe_();
/*      */       
/*  993 */       Item _o_ = Item.this;
/*  994 */       Map<Integer, xbean.TempExtraProInfo> tempextrapropinfos = new HashMap();
/*  995 */       for (Map.Entry<Integer, xbean.TempExtraProInfo> _e_ : _o_.tempextrapropinfos.entrySet())
/*  996 */         tempextrapropinfos.put(_e_.getKey(), new TempExtraProInfo.Data((xbean.TempExtraProInfo)_e_.getValue()));
/*  997 */       return tempextrapropinfos;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<xbean.FumoInfo> getFumoprolist()
/*      */     {
/* 1004 */       Item.this._xdb_verify_unsafe_();
/* 1005 */       return xdb.Consts.constList(Item.this.fumoprolist);
/*      */     }
/*      */     
/*      */ 
/*      */     public List<xbean.FumoInfo> getFumoprolistAsData()
/*      */     {
/* 1011 */       Item.this._xdb_verify_unsafe_();
/*      */       
/* 1013 */       Item _o_ = Item.this;
/* 1014 */       List<xbean.FumoInfo> fumoprolist = new ArrayList();
/* 1015 */       for (xbean.FumoInfo _v_ : _o_.fumoprolist)
/* 1016 */         fumoprolist.add(new FumoInfo.Data(_v_));
/* 1017 */       return fumoprolist;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public xbean.SuperEquipmentCostBean getSuperequipmentcostbean()
/*      */     {
/* 1024 */       Item.this._xdb_verify_unsafe_();
/* 1025 */       return (xbean.SuperEquipmentCostBean)xdb.Consts.toConst(Item.this.superequipmentcostbean);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.JewelInfo> getJewelmap()
/*      */     {
/* 1032 */       Item.this._xdb_verify_unsafe_();
/* 1033 */       return xdb.Consts.constMap(Item.this.jewelmap);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.JewelInfo> getJewelmapAsData()
/*      */     {
/* 1040 */       Item.this._xdb_verify_unsafe_();
/*      */       
/* 1042 */       Item _o_ = Item.this;
/* 1043 */       Map<Integer, xbean.JewelInfo> jewelmap = new HashMap();
/* 1044 */       for (Map.Entry<Integer, xbean.JewelInfo> _e_ : _o_.jewelmap.entrySet())
/* 1045 */         jewelmap.put(_e_.getKey(), new JewelInfo.Data((xbean.JewelInfo)_e_.getValue()));
/* 1046 */       return jewelmap;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCfgid(int _v_)
/*      */     {
/* 1053 */       Item.this._xdb_verify_unsafe_();
/* 1054 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setNumber(int _v_)
/*      */     {
/* 1061 */       Item.this._xdb_verify_unsafe_();
/* 1062 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMarketbuytime(long _v_)
/*      */     {
/* 1069 */       Item.this._xdb_verify_unsafe_();
/* 1070 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setFlags(int _v_)
/*      */     {
/* 1077 */       Item.this._xdb_verify_unsafe_();
/* 1078 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/* 1084 */       Item.this._xdb_verify_unsafe_();
/* 1085 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/* 1091 */       Item.this._xdb_verify_unsafe_();
/* 1092 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/* 1098 */       return Item.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/* 1104 */       return Item.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/* 1110 */       Item.this._xdb_verify_unsafe_();
/* 1111 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/* 1117 */       return Item.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/* 1123 */       return Item.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/* 1129 */       Item.this._xdb_verify_unsafe_();
/* 1130 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/* 1136 */       return Item.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1142 */       return Item.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/* 1148 */       return Item.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/* 1154 */       return Item.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/* 1160 */       return Item.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/* 1166 */       return Item.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1172 */       return Item.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.Item
/*      */   {
/*      */     private int cfgid;
/*      */     
/*      */     private int number;
/*      */     
/*      */     private HashSet<Long> uuid;
/*      */     
/*      */     private long marketbuytime;
/*      */     
/*      */     private int flags;
/*      */     
/*      */     private HashMap<Integer, Integer> extra;
/*      */     
/*      */     private ArrayList<xbean.XExtraProBean> extraprolist;
/*      */     
/*      */     private HashMap<Integer, xbean.TempExtraProInfo> tempextrapropinfos;
/*      */     
/*      */     private ArrayList<xbean.FumoInfo> fumoprolist;
/*      */     
/*      */     private xbean.SuperEquipmentCostBean superequipmentcostbean;
/*      */     
/*      */     private HashMap<Integer, xbean.JewelInfo> jewelmap;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/* 1204 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/* 1209 */       this.uuid = new HashSet();
/* 1210 */       this.marketbuytime = 0L;
/* 1211 */       this.flags = 0;
/* 1212 */       this.extra = new HashMap();
/* 1213 */       this.extraprolist = new ArrayList();
/* 1214 */       this.tempextrapropinfos = new HashMap();
/* 1215 */       this.fumoprolist = new ArrayList();
/* 1216 */       this.superequipmentcostbean = new SuperEquipmentCostBean.Data();
/* 1217 */       this.jewelmap = new HashMap();
/*      */     }
/*      */     
/*      */     Data(xbean.Item _o1_)
/*      */     {
/* 1222 */       if ((_o1_ instanceof Item)) { assign((Item)_o1_);
/* 1223 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 1224 */       } else if ((_o1_ instanceof Item.Const)) assign(((Item.Const)_o1_).nThis()); else {
/* 1225 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(Item _o_) {
/* 1230 */       this.cfgid = _o_.cfgid;
/* 1231 */       this.number = _o_.number;
/* 1232 */       this.uuid = new HashSet();
/* 1233 */       this.uuid.addAll(_o_.uuid);
/* 1234 */       this.marketbuytime = _o_.marketbuytime;
/* 1235 */       this.flags = _o_.flags;
/* 1236 */       this.extra = new HashMap();
/* 1237 */       for (Map.Entry<Integer, Integer> _e_ : _o_.extra.entrySet())
/* 1238 */         this.extra.put(_e_.getKey(), _e_.getValue());
/* 1239 */       this.extraprolist = new ArrayList();
/* 1240 */       for (xbean.XExtraProBean _v_ : _o_.extraprolist)
/* 1241 */         this.extraprolist.add(new XExtraProBean.Data(_v_));
/* 1242 */       this.tempextrapropinfos = new HashMap();
/* 1243 */       for (Map.Entry<Integer, xbean.TempExtraProInfo> _e_ : _o_.tempextrapropinfos.entrySet())
/* 1244 */         this.tempextrapropinfos.put(_e_.getKey(), new TempExtraProInfo.Data((xbean.TempExtraProInfo)_e_.getValue()));
/* 1245 */       this.fumoprolist = new ArrayList();
/* 1246 */       for (xbean.FumoInfo _v_ : _o_.fumoprolist)
/* 1247 */         this.fumoprolist.add(new FumoInfo.Data(_v_));
/* 1248 */       this.superequipmentcostbean = new SuperEquipmentCostBean.Data(_o_.superequipmentcostbean);
/* 1249 */       this.jewelmap = new HashMap();
/* 1250 */       for (Map.Entry<Integer, xbean.JewelInfo> _e_ : _o_.jewelmap.entrySet()) {
/* 1251 */         this.jewelmap.put(_e_.getKey(), new JewelInfo.Data((xbean.JewelInfo)_e_.getValue()));
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(Data _o_) {
/* 1256 */       this.cfgid = _o_.cfgid;
/* 1257 */       this.number = _o_.number;
/* 1258 */       this.uuid = new HashSet();
/* 1259 */       this.uuid.addAll(_o_.uuid);
/* 1260 */       this.marketbuytime = _o_.marketbuytime;
/* 1261 */       this.flags = _o_.flags;
/* 1262 */       this.extra = new HashMap();
/* 1263 */       for (Map.Entry<Integer, Integer> _e_ : _o_.extra.entrySet())
/* 1264 */         this.extra.put(_e_.getKey(), _e_.getValue());
/* 1265 */       this.extraprolist = new ArrayList();
/* 1266 */       for (xbean.XExtraProBean _v_ : _o_.extraprolist)
/* 1267 */         this.extraprolist.add(new XExtraProBean.Data(_v_));
/* 1268 */       this.tempextrapropinfos = new HashMap();
/* 1269 */       for (Map.Entry<Integer, xbean.TempExtraProInfo> _e_ : _o_.tempextrapropinfos.entrySet())
/* 1270 */         this.tempextrapropinfos.put(_e_.getKey(), new TempExtraProInfo.Data((xbean.TempExtraProInfo)_e_.getValue()));
/* 1271 */       this.fumoprolist = new ArrayList();
/* 1272 */       for (xbean.FumoInfo _v_ : _o_.fumoprolist)
/* 1273 */         this.fumoprolist.add(new FumoInfo.Data(_v_));
/* 1274 */       this.superequipmentcostbean = new SuperEquipmentCostBean.Data(_o_.superequipmentcostbean);
/* 1275 */       this.jewelmap = new HashMap();
/* 1276 */       for (Map.Entry<Integer, xbean.JewelInfo> _e_ : _o_.jewelmap.entrySet()) {
/* 1277 */         this.jewelmap.put(_e_.getKey(), new JewelInfo.Data((xbean.JewelInfo)_e_.getValue()));
/*      */       }
/*      */     }
/*      */     
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/* 1283 */       _os_.marshal(this.cfgid);
/* 1284 */       _os_.marshal(this.number);
/* 1285 */       _os_.compact_uint32(this.uuid.size());
/* 1286 */       for (Long _v_ : this.uuid)
/*      */       {
/* 1288 */         _os_.marshal(_v_.longValue());
/*      */       }
/* 1290 */       _os_.marshal(this.marketbuytime);
/* 1291 */       _os_.marshal(this.flags);
/* 1292 */       _os_.compact_uint32(this.extra.size());
/* 1293 */       for (Map.Entry<Integer, Integer> _e_ : this.extra.entrySet())
/*      */       {
/* 1295 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 1296 */         _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */       }
/* 1298 */       _os_.compact_uint32(this.extraprolist.size());
/* 1299 */       for (xbean.XExtraProBean _v_ : this.extraprolist)
/*      */       {
/* 1301 */         _v_.marshal(_os_);
/*      */       }
/* 1303 */       _os_.compact_uint32(this.tempextrapropinfos.size());
/* 1304 */       for (Map.Entry<Integer, xbean.TempExtraProInfo> _e_ : this.tempextrapropinfos.entrySet())
/*      */       {
/* 1306 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 1307 */         ((xbean.TempExtraProInfo)_e_.getValue()).marshal(_os_);
/*      */       }
/* 1309 */       _os_.compact_uint32(this.fumoprolist.size());
/* 1310 */       for (xbean.FumoInfo _v_ : this.fumoprolist)
/*      */       {
/* 1312 */         _v_.marshal(_os_);
/*      */       }
/* 1314 */       this.superequipmentcostbean.marshal(_os_);
/* 1315 */       _os_.compact_uint32(this.jewelmap.size());
/* 1316 */       for (Map.Entry<Integer, xbean.JewelInfo> _e_ : this.jewelmap.entrySet())
/*      */       {
/* 1318 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 1319 */         ((xbean.JewelInfo)_e_.getValue()).marshal(_os_);
/*      */       }
/* 1321 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/* 1327 */       this.cfgid = _os_.unmarshal_int();
/* 1328 */       this.number = _os_.unmarshal_int();
/* 1329 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/* 1331 */         long _v_ = 0L;
/* 1332 */         _v_ = _os_.unmarshal_long();
/* 1333 */         this.uuid.add(Long.valueOf(_v_));
/*      */       }
/* 1335 */       this.marketbuytime = _os_.unmarshal_long();
/* 1336 */       this.flags = _os_.unmarshal_int();
/*      */       
/* 1338 */       int size = _os_.uncompact_uint32();
/* 1339 */       if (size >= 12)
/*      */       {
/* 1341 */         this.extra = new HashMap(size * 2);
/*      */       }
/* 1343 */       for (; size > 0; size--)
/*      */       {
/* 1345 */         int _k_ = 0;
/* 1346 */         _k_ = _os_.unmarshal_int();
/* 1347 */         int _v_ = 0;
/* 1348 */         _v_ = _os_.unmarshal_int();
/* 1349 */         this.extra.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*      */       }
/*      */       
/* 1352 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/* 1354 */         xbean.XExtraProBean _v_ = xbean.Pod.newXExtraProBeanData();
/* 1355 */         _v_.unmarshal(_os_);
/* 1356 */         this.extraprolist.add(_v_);
/*      */       }
/*      */       
/* 1359 */       int size = _os_.uncompact_uint32();
/* 1360 */       if (size >= 12)
/*      */       {
/* 1362 */         this.tempextrapropinfos = new HashMap(size * 2);
/*      */       }
/* 1364 */       for (; size > 0; size--)
/*      */       {
/* 1366 */         int _k_ = 0;
/* 1367 */         _k_ = _os_.unmarshal_int();
/* 1368 */         xbean.TempExtraProInfo _v_ = xbean.Pod.newTempExtraProInfoData();
/* 1369 */         _v_.unmarshal(_os_);
/* 1370 */         this.tempextrapropinfos.put(Integer.valueOf(_k_), _v_);
/*      */       }
/*      */       
/* 1373 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/* 1375 */         xbean.FumoInfo _v_ = xbean.Pod.newFumoInfoData();
/* 1376 */         _v_.unmarshal(_os_);
/* 1377 */         this.fumoprolist.add(_v_);
/*      */       }
/* 1379 */       this.superequipmentcostbean.unmarshal(_os_);
/*      */       
/* 1381 */       int size = _os_.uncompact_uint32();
/* 1382 */       if (size >= 12)
/*      */       {
/* 1384 */         this.jewelmap = new HashMap(size * 2);
/*      */       }
/* 1386 */       for (; size > 0; size--)
/*      */       {
/* 1388 */         int _k_ = 0;
/* 1389 */         _k_ = _os_.unmarshal_int();
/* 1390 */         xbean.JewelInfo _v_ = xbean.Pod.newJewelInfoData();
/* 1391 */         _v_.unmarshal(_os_);
/* 1392 */         this.jewelmap.put(Integer.valueOf(_k_), _v_);
/*      */       }
/*      */       
/* 1395 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/* 1401 */       int _size_ = 0;
/* 1402 */       _size_ += CodedOutputStream.computeInt32Size(1, this.cfgid);
/* 1403 */       _size_ += CodedOutputStream.computeInt32Size(2, this.number);
/* 1404 */       for (Long _v_ : this.uuid)
/*      */       {
/* 1406 */         _size_ += CodedOutputStream.computeInt64Size(3, _v_.longValue());
/*      */       }
/* 1408 */       _size_ += CodedOutputStream.computeInt64Size(4, this.marketbuytime);
/* 1409 */       _size_ += CodedOutputStream.computeInt32Size(5, this.flags);
/* 1410 */       for (Map.Entry<Integer, Integer> _e_ : this.extra.entrySet())
/*      */       {
/* 1412 */         _size_ += CodedOutputStream.computeInt32Size(6, ((Integer)_e_.getKey()).intValue());
/* 1413 */         _size_ += CodedOutputStream.computeInt32Size(6, ((Integer)_e_.getValue()).intValue());
/*      */       }
/* 1415 */       for (xbean.XExtraProBean _v_ : this.extraprolist)
/*      */       {
/* 1417 */         _size_ += CodedOutputStream.computeMessageSize(7, _v_);
/*      */       }
/* 1419 */       for (Map.Entry<Integer, xbean.TempExtraProInfo> _e_ : this.tempextrapropinfos.entrySet())
/*      */       {
/* 1421 */         _size_ += CodedOutputStream.computeInt32Size(8, ((Integer)_e_.getKey()).intValue());
/* 1422 */         _size_ += CodedOutputStream.computeMessageSize(8, (Message)_e_.getValue());
/*      */       }
/* 1424 */       for (xbean.FumoInfo _v_ : this.fumoprolist)
/*      */       {
/* 1426 */         _size_ += CodedOutputStream.computeMessageSize(9, _v_);
/*      */       }
/* 1428 */       _size_ += CodedOutputStream.computeMessageSize(10, this.superequipmentcostbean);
/* 1429 */       for (Map.Entry<Integer, xbean.JewelInfo> _e_ : this.jewelmap.entrySet())
/*      */       {
/* 1431 */         _size_ += CodedOutputStream.computeInt32Size(11, ((Integer)_e_.getKey()).intValue());
/* 1432 */         _size_ += CodedOutputStream.computeMessageSize(11, (Message)_e_.getValue());
/*      */       }
/* 1434 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1442 */         _output_.writeInt32(1, this.cfgid);
/* 1443 */         _output_.writeInt32(2, this.number);
/* 1444 */         for (Long _v_ : this.uuid)
/*      */         {
/* 1446 */           _output_.writeInt64(3, _v_.longValue());
/*      */         }
/* 1448 */         _output_.writeInt64(4, this.marketbuytime);
/* 1449 */         _output_.writeInt32(5, this.flags);
/* 1450 */         for (Map.Entry<Integer, Integer> _e_ : this.extra.entrySet())
/*      */         {
/* 1452 */           _output_.writeInt32(6, ((Integer)_e_.getKey()).intValue());
/* 1453 */           _output_.writeInt32(6, ((Integer)_e_.getValue()).intValue());
/*      */         }
/* 1455 */         for (xbean.XExtraProBean _v_ : this.extraprolist)
/*      */         {
/* 1457 */           _output_.writeMessage(7, _v_);
/*      */         }
/* 1459 */         for (Map.Entry<Integer, xbean.TempExtraProInfo> _e_ : this.tempextrapropinfos.entrySet())
/*      */         {
/* 1461 */           _output_.writeInt32(8, ((Integer)_e_.getKey()).intValue());
/* 1462 */           _output_.writeMessage(8, (Message)_e_.getValue());
/*      */         }
/* 1464 */         for (xbean.FumoInfo _v_ : this.fumoprolist)
/*      */         {
/* 1466 */           _output_.writeMessage(9, _v_);
/*      */         }
/* 1468 */         _output_.writeMessage(10, this.superequipmentcostbean);
/* 1469 */         for (Map.Entry<Integer, xbean.JewelInfo> _e_ : this.jewelmap.entrySet())
/*      */         {
/* 1471 */           _output_.writeInt32(11, ((Integer)_e_.getKey()).intValue());
/* 1472 */           _output_.writeMessage(11, (Message)_e_.getValue());
/*      */         }
/*      */       }
/*      */       catch (java.io.IOException e)
/*      */       {
/* 1477 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1479 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1487 */         boolean done = false;
/* 1488 */         while (!done)
/*      */         {
/* 1490 */           int tag = _input_.readTag();
/* 1491 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/* 1495 */             done = true;
/* 1496 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/* 1500 */             this.cfgid = _input_.readInt32();
/* 1501 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/* 1505 */             this.number = _input_.readInt32();
/* 1506 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/* 1510 */             long _v_ = 0L;
/* 1511 */             _v_ = _input_.readInt64();
/* 1512 */             this.uuid.add(Long.valueOf(_v_));
/* 1513 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/* 1517 */             this.marketbuytime = _input_.readInt64();
/* 1518 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/* 1522 */             this.flags = _input_.readInt32();
/* 1523 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/* 1527 */             int _k_ = 0;
/* 1528 */             _k_ = _input_.readInt32();
/* 1529 */             int readTag = _input_.readTag();
/* 1530 */             if (48 != readTag)
/*      */             {
/* 1532 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 1534 */             int _v_ = 0;
/* 1535 */             _v_ = _input_.readInt32();
/* 1536 */             this.extra.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/* 1537 */             break;
/*      */           
/*      */ 
/*      */           case 58: 
/* 1541 */             xbean.XExtraProBean _v_ = xbean.Pod.newXExtraProBeanData();
/* 1542 */             _input_.readMessage(_v_);
/* 1543 */             this.extraprolist.add(_v_);
/* 1544 */             break;
/*      */           
/*      */ 
/*      */           case 64: 
/* 1548 */             int _k_ = 0;
/* 1549 */             _k_ = _input_.readInt32();
/* 1550 */             int readTag = _input_.readTag();
/* 1551 */             if (66 != readTag)
/*      */             {
/* 1553 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 1555 */             xbean.TempExtraProInfo _v_ = xbean.Pod.newTempExtraProInfoData();
/* 1556 */             _input_.readMessage(_v_);
/* 1557 */             this.tempextrapropinfos.put(Integer.valueOf(_k_), _v_);
/* 1558 */             break;
/*      */           
/*      */ 
/*      */           case 74: 
/* 1562 */             xbean.FumoInfo _v_ = xbean.Pod.newFumoInfoData();
/* 1563 */             _input_.readMessage(_v_);
/* 1564 */             this.fumoprolist.add(_v_);
/* 1565 */             break;
/*      */           
/*      */ 
/*      */           case 82: 
/* 1569 */             _input_.readMessage(this.superequipmentcostbean);
/* 1570 */             break;
/*      */           
/*      */ 
/*      */           case 88: 
/* 1574 */             int _k_ = 0;
/* 1575 */             _k_ = _input_.readInt32();
/* 1576 */             int readTag = _input_.readTag();
/* 1577 */             if (90 != readTag)
/*      */             {
/* 1579 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 1581 */             xbean.JewelInfo _v_ = xbean.Pod.newJewelInfoData();
/* 1582 */             _input_.readMessage(_v_);
/* 1583 */             this.jewelmap.put(Integer.valueOf(_k_), _v_);
/* 1584 */             break;
/*      */           
/*      */ 
/*      */           default: 
/* 1588 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/* 1590 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/* 1599 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (java.io.IOException e)
/*      */       {
/* 1603 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1605 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Item copy()
/*      */     {
/* 1611 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Item toData()
/*      */     {
/* 1617 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.Item toBean()
/*      */     {
/* 1622 */       return new Item(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Item toDataIf()
/*      */     {
/* 1628 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.Item toBeanIf()
/*      */     {
/* 1633 */       return new Item(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1639 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/* 1643 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1647 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1651 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/* 1655 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1659 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1663 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCfgid()
/*      */     {
/* 1670 */       return this.cfgid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getNumber()
/*      */     {
/* 1677 */       return this.number;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Long> getUuid()
/*      */     {
/* 1684 */       return this.uuid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Long> getUuidAsData()
/*      */     {
/* 1691 */       return this.uuid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getMarketbuytime()
/*      */     {
/* 1698 */       return this.marketbuytime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getFlags()
/*      */     {
/* 1705 */       return this.flags;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getExtra()
/*      */     {
/* 1712 */       return this.extra;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getExtraAsData()
/*      */     {
/* 1719 */       return this.extra;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<xbean.XExtraProBean> getExtraprolist()
/*      */     {
/* 1726 */       return this.extraprolist;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<xbean.XExtraProBean> getExtraprolistAsData()
/*      */     {
/* 1733 */       return this.extraprolist;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.TempExtraProInfo> getTempextrapropinfos()
/*      */     {
/* 1740 */       return this.tempextrapropinfos;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.TempExtraProInfo> getTempextrapropinfosAsData()
/*      */     {
/* 1747 */       return this.tempextrapropinfos;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<xbean.FumoInfo> getFumoprolist()
/*      */     {
/* 1754 */       return this.fumoprolist;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<xbean.FumoInfo> getFumoprolistAsData()
/*      */     {
/* 1761 */       return this.fumoprolist;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public xbean.SuperEquipmentCostBean getSuperequipmentcostbean()
/*      */     {
/* 1768 */       return this.superequipmentcostbean;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.JewelInfo> getJewelmap()
/*      */     {
/* 1775 */       return this.jewelmap;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.JewelInfo> getJewelmapAsData()
/*      */     {
/* 1782 */       return this.jewelmap;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCfgid(int _v_)
/*      */     {
/* 1789 */       this.cfgid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setNumber(int _v_)
/*      */     {
/* 1796 */       this.number = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMarketbuytime(long _v_)
/*      */     {
/* 1803 */       this.marketbuytime = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setFlags(int _v_)
/*      */     {
/* 1810 */       this.flags = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1816 */       if (!(_o1_ instanceof Data)) return false;
/* 1817 */       Data _o_ = (Data)_o1_;
/* 1818 */       if (this.cfgid != _o_.cfgid) return false;
/* 1819 */       if (this.number != _o_.number) return false;
/* 1820 */       if (!this.uuid.equals(_o_.uuid)) return false;
/* 1821 */       if (this.marketbuytime != _o_.marketbuytime) return false;
/* 1822 */       if (this.flags != _o_.flags) return false;
/* 1823 */       if (!this.extra.equals(_o_.extra)) return false;
/* 1824 */       if (!this.extraprolist.equals(_o_.extraprolist)) return false;
/* 1825 */       if (!this.tempextrapropinfos.equals(_o_.tempextrapropinfos)) return false;
/* 1826 */       if (!this.fumoprolist.equals(_o_.fumoprolist)) return false;
/* 1827 */       if (!this.superequipmentcostbean.equals(_o_.superequipmentcostbean)) return false;
/* 1828 */       if (!this.jewelmap.equals(_o_.jewelmap)) return false;
/* 1829 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1835 */       int _h_ = 0;
/* 1836 */       _h_ += this.cfgid;
/* 1837 */       _h_ += this.number;
/* 1838 */       _h_ += this.uuid.hashCode();
/* 1839 */       _h_ = (int)(_h_ + this.marketbuytime);
/* 1840 */       _h_ += this.flags;
/* 1841 */       _h_ += this.extra.hashCode();
/* 1842 */       _h_ += this.extraprolist.hashCode();
/* 1843 */       _h_ += this.tempextrapropinfos.hashCode();
/* 1844 */       _h_ += this.fumoprolist.hashCode();
/* 1845 */       _h_ += this.superequipmentcostbean.hashCode();
/* 1846 */       _h_ += this.jewelmap.hashCode();
/* 1847 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1853 */       StringBuilder _sb_ = new StringBuilder();
/* 1854 */       _sb_.append("(");
/* 1855 */       _sb_.append(this.cfgid);
/* 1856 */       _sb_.append(",");
/* 1857 */       _sb_.append(this.number);
/* 1858 */       _sb_.append(",");
/* 1859 */       _sb_.append(this.uuid);
/* 1860 */       _sb_.append(",");
/* 1861 */       _sb_.append(this.marketbuytime);
/* 1862 */       _sb_.append(",");
/* 1863 */       _sb_.append(this.flags);
/* 1864 */       _sb_.append(",");
/* 1865 */       _sb_.append(this.extra);
/* 1866 */       _sb_.append(",");
/* 1867 */       _sb_.append(this.extraprolist);
/* 1868 */       _sb_.append(",");
/* 1869 */       _sb_.append(this.tempextrapropinfos);
/* 1870 */       _sb_.append(",");
/* 1871 */       _sb_.append(this.fumoprolist);
/* 1872 */       _sb_.append(",");
/* 1873 */       _sb_.append(this.superequipmentcostbean);
/* 1874 */       _sb_.append(",");
/* 1875 */       _sb_.append(this.jewelmap);
/* 1876 */       _sb_.append(")");
/* 1877 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\Item.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */