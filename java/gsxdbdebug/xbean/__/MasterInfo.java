/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.util.HashMap;
/*      */ import java.util.HashSet;
/*      */ import java.util.LinkedList;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import ppbio.Message;
/*      */ import xdb.LogKey;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.util.SetX;
/*      */ 
/*      */ public final class MasterInfo extends XBean implements xbean.MasterInfo
/*      */ {
/*      */   private HashMap<Long, xbean.ShiTuTimeInfo> apprentice_now;
/*      */   private LinkedList<Long> apprentice_role_list;
/*      */   private HashMap<Long, xbean.ShiTuTimeInfo> apprentice_graduate;
/*      */   private HashMap<Long, xbean.ShiTuTimeInfo> force_relieve;
/*      */   private SetX<Integer> alwardy_awarded_cfg_set;
/*      */   private LinkedList<Long> now_apprentice_role_list;
/*      */   private long publish_reset_time;
/*      */   private int publish_times;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   32 */     this.apprentice_now.clear();
/*   33 */     this.apprentice_role_list.clear();
/*   34 */     this.apprentice_graduate.clear();
/*   35 */     this.force_relieve.clear();
/*   36 */     this.alwardy_awarded_cfg_set.clear();
/*   37 */     this.now_apprentice_role_list.clear();
/*   38 */     this.publish_reset_time = 0L;
/*   39 */     this.publish_times = 0;
/*      */   }
/*      */   
/*      */   MasterInfo(int __, XBean _xp_, String _vn_)
/*      */   {
/*   44 */     super(_xp_, _vn_);
/*   45 */     this.apprentice_now = new HashMap();
/*   46 */     this.apprentice_role_list = new LinkedList();
/*   47 */     this.apprentice_graduate = new HashMap();
/*   48 */     this.force_relieve = new HashMap();
/*   49 */     this.alwardy_awarded_cfg_set = new SetX();
/*   50 */     this.now_apprentice_role_list = new LinkedList();
/*      */   }
/*      */   
/*      */   public MasterInfo()
/*      */   {
/*   55 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public MasterInfo(MasterInfo _o_)
/*      */   {
/*   60 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   MasterInfo(xbean.MasterInfo _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   65 */     super(_xp_, _vn_);
/*   66 */     if ((_o1_ instanceof MasterInfo)) { assign((MasterInfo)_o1_);
/*   67 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   68 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   69 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(MasterInfo _o_) {
/*   74 */     _o_._xdb_verify_unsafe_();
/*   75 */     this.apprentice_now = new HashMap();
/*   76 */     for (Map.Entry<Long, xbean.ShiTuTimeInfo> _e_ : _o_.apprentice_now.entrySet())
/*   77 */       this.apprentice_now.put(_e_.getKey(), new ShiTuTimeInfo((xbean.ShiTuTimeInfo)_e_.getValue(), this, "apprentice_now"));
/*   78 */     this.apprentice_role_list = new LinkedList();
/*   79 */     this.apprentice_role_list.addAll(_o_.apprentice_role_list);
/*   80 */     this.apprentice_graduate = new HashMap();
/*   81 */     for (Map.Entry<Long, xbean.ShiTuTimeInfo> _e_ : _o_.apprentice_graduate.entrySet())
/*   82 */       this.apprentice_graduate.put(_e_.getKey(), new ShiTuTimeInfo((xbean.ShiTuTimeInfo)_e_.getValue(), this, "apprentice_graduate"));
/*   83 */     this.force_relieve = new HashMap();
/*   84 */     for (Map.Entry<Long, xbean.ShiTuTimeInfo> _e_ : _o_.force_relieve.entrySet())
/*   85 */       this.force_relieve.put(_e_.getKey(), new ShiTuTimeInfo((xbean.ShiTuTimeInfo)_e_.getValue(), this, "force_relieve"));
/*   86 */     this.alwardy_awarded_cfg_set = new SetX();
/*   87 */     this.alwardy_awarded_cfg_set.addAll(_o_.alwardy_awarded_cfg_set);
/*   88 */     this.now_apprentice_role_list = new LinkedList();
/*   89 */     this.now_apprentice_role_list.addAll(_o_.now_apprentice_role_list);
/*   90 */     this.publish_reset_time = _o_.publish_reset_time;
/*   91 */     this.publish_times = _o_.publish_times;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   96 */     this.apprentice_now = new HashMap();
/*   97 */     for (Map.Entry<Long, xbean.ShiTuTimeInfo> _e_ : _o_.apprentice_now.entrySet())
/*   98 */       this.apprentice_now.put(_e_.getKey(), new ShiTuTimeInfo((xbean.ShiTuTimeInfo)_e_.getValue(), this, "apprentice_now"));
/*   99 */     this.apprentice_role_list = new LinkedList();
/*  100 */     this.apprentice_role_list.addAll(_o_.apprentice_role_list);
/*  101 */     this.apprentice_graduate = new HashMap();
/*  102 */     for (Map.Entry<Long, xbean.ShiTuTimeInfo> _e_ : _o_.apprentice_graduate.entrySet())
/*  103 */       this.apprentice_graduate.put(_e_.getKey(), new ShiTuTimeInfo((xbean.ShiTuTimeInfo)_e_.getValue(), this, "apprentice_graduate"));
/*  104 */     this.force_relieve = new HashMap();
/*  105 */     for (Map.Entry<Long, xbean.ShiTuTimeInfo> _e_ : _o_.force_relieve.entrySet())
/*  106 */       this.force_relieve.put(_e_.getKey(), new ShiTuTimeInfo((xbean.ShiTuTimeInfo)_e_.getValue(), this, "force_relieve"));
/*  107 */     this.alwardy_awarded_cfg_set = new SetX();
/*  108 */     this.alwardy_awarded_cfg_set.addAll(_o_.alwardy_awarded_cfg_set);
/*  109 */     this.now_apprentice_role_list = new LinkedList();
/*  110 */     this.now_apprentice_role_list.addAll(_o_.now_apprentice_role_list);
/*  111 */     this.publish_reset_time = _o_.publish_reset_time;
/*  112 */     this.publish_times = _o_.publish_times;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*  118 */     _xdb_verify_unsafe_();
/*  119 */     _os_.compact_uint32(this.apprentice_now.size());
/*  120 */     for (Map.Entry<Long, xbean.ShiTuTimeInfo> _e_ : this.apprentice_now.entrySet())
/*      */     {
/*  122 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  123 */       ((xbean.ShiTuTimeInfo)_e_.getValue()).marshal(_os_);
/*      */     }
/*  125 */     _os_.compact_uint32(this.apprentice_role_list.size());
/*  126 */     for (Long _v_ : this.apprentice_role_list)
/*      */     {
/*  128 */       _os_.marshal(_v_.longValue());
/*      */     }
/*  130 */     _os_.compact_uint32(this.apprentice_graduate.size());
/*  131 */     for (Map.Entry<Long, xbean.ShiTuTimeInfo> _e_ : this.apprentice_graduate.entrySet())
/*      */     {
/*  133 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  134 */       ((xbean.ShiTuTimeInfo)_e_.getValue()).marshal(_os_);
/*      */     }
/*  136 */     _os_.compact_uint32(this.force_relieve.size());
/*  137 */     for (Map.Entry<Long, xbean.ShiTuTimeInfo> _e_ : this.force_relieve.entrySet())
/*      */     {
/*  139 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  140 */       ((xbean.ShiTuTimeInfo)_e_.getValue()).marshal(_os_);
/*      */     }
/*  142 */     _os_.compact_uint32(this.alwardy_awarded_cfg_set.size());
/*  143 */     for (Integer _v_ : this.alwardy_awarded_cfg_set)
/*      */     {
/*  145 */       _os_.marshal(_v_.intValue());
/*      */     }
/*  147 */     _os_.compact_uint32(this.now_apprentice_role_list.size());
/*  148 */     for (Long _v_ : this.now_apprentice_role_list)
/*      */     {
/*  150 */       _os_.marshal(_v_.longValue());
/*      */     }
/*  152 */     _os_.marshal(this.publish_reset_time);
/*  153 */     _os_.marshal(this.publish_times);
/*  154 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  160 */     _xdb_verify_unsafe_();
/*      */     
/*  162 */     int size = _os_.uncompact_uint32();
/*  163 */     if (size >= 12)
/*      */     {
/*  165 */       this.apprentice_now = new HashMap(size * 2);
/*      */     }
/*  167 */     for (; size > 0; size--)
/*      */     {
/*  169 */       long _k_ = 0L;
/*  170 */       _k_ = _os_.unmarshal_long();
/*  171 */       xbean.ShiTuTimeInfo _v_ = new ShiTuTimeInfo(0, this, "apprentice_now");
/*  172 */       _v_.unmarshal(_os_);
/*  173 */       this.apprentice_now.put(Long.valueOf(_k_), _v_);
/*      */     }
/*      */     
/*  176 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  178 */       long _v_ = 0L;
/*  179 */       _v_ = _os_.unmarshal_long();
/*  180 */       this.apprentice_role_list.add(Long.valueOf(_v_));
/*      */     }
/*      */     
/*  183 */     int size = _os_.uncompact_uint32();
/*  184 */     if (size >= 12)
/*      */     {
/*  186 */       this.apprentice_graduate = new HashMap(size * 2);
/*      */     }
/*  188 */     for (; size > 0; size--)
/*      */     {
/*  190 */       long _k_ = 0L;
/*  191 */       _k_ = _os_.unmarshal_long();
/*  192 */       xbean.ShiTuTimeInfo _v_ = new ShiTuTimeInfo(0, this, "apprentice_graduate");
/*  193 */       _v_.unmarshal(_os_);
/*  194 */       this.apprentice_graduate.put(Long.valueOf(_k_), _v_);
/*      */     }
/*      */     
/*      */ 
/*  198 */     int size = _os_.uncompact_uint32();
/*  199 */     if (size >= 12)
/*      */     {
/*  201 */       this.force_relieve = new HashMap(size * 2);
/*      */     }
/*  203 */     for (; size > 0; size--)
/*      */     {
/*  205 */       long _k_ = 0L;
/*  206 */       _k_ = _os_.unmarshal_long();
/*  207 */       xbean.ShiTuTimeInfo _v_ = new ShiTuTimeInfo(0, this, "force_relieve");
/*  208 */       _v_.unmarshal(_os_);
/*  209 */       this.force_relieve.put(Long.valueOf(_k_), _v_);
/*      */     }
/*      */     
/*  212 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  214 */       int _v_ = 0;
/*  215 */       _v_ = _os_.unmarshal_int();
/*  216 */       this.alwardy_awarded_cfg_set.add(Integer.valueOf(_v_));
/*      */     }
/*  218 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  220 */       long _v_ = 0L;
/*  221 */       _v_ = _os_.unmarshal_long();
/*  222 */       this.now_apprentice_role_list.add(Long.valueOf(_v_));
/*      */     }
/*  224 */     this.publish_reset_time = _os_.unmarshal_long();
/*  225 */     this.publish_times = _os_.unmarshal_int();
/*  226 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  232 */     _xdb_verify_unsafe_();
/*  233 */     int _size_ = 0;
/*  234 */     for (Map.Entry<Long, xbean.ShiTuTimeInfo> _e_ : this.apprentice_now.entrySet())
/*      */     {
/*  236 */       _size_ += CodedOutputStream.computeInt64Size(1, ((Long)_e_.getKey()).longValue());
/*  237 */       _size_ += CodedOutputStream.computeMessageSize(1, (Message)_e_.getValue());
/*      */     }
/*  239 */     for (Long _v_ : this.apprentice_role_list)
/*      */     {
/*  241 */       _size_ += CodedOutputStream.computeInt64Size(2, _v_.longValue());
/*      */     }
/*  243 */     for (Map.Entry<Long, xbean.ShiTuTimeInfo> _e_ : this.apprentice_graduate.entrySet())
/*      */     {
/*  245 */       _size_ += CodedOutputStream.computeInt64Size(3, ((Long)_e_.getKey()).longValue());
/*  246 */       _size_ += CodedOutputStream.computeMessageSize(3, (Message)_e_.getValue());
/*      */     }
/*  248 */     for (Map.Entry<Long, xbean.ShiTuTimeInfo> _e_ : this.force_relieve.entrySet())
/*      */     {
/*  250 */       _size_ += CodedOutputStream.computeInt64Size(4, ((Long)_e_.getKey()).longValue());
/*  251 */       _size_ += CodedOutputStream.computeMessageSize(4, (Message)_e_.getValue());
/*      */     }
/*  253 */     for (Integer _v_ : this.alwardy_awarded_cfg_set)
/*      */     {
/*  255 */       _size_ += CodedOutputStream.computeInt32Size(5, _v_.intValue());
/*      */     }
/*  257 */     for (Long _v_ : this.now_apprentice_role_list)
/*      */     {
/*  259 */       _size_ += CodedOutputStream.computeInt64Size(6, _v_.longValue());
/*      */     }
/*  261 */     _size_ += CodedOutputStream.computeInt64Size(7, this.publish_reset_time);
/*  262 */     _size_ += CodedOutputStream.computeInt32Size(8, this.publish_times);
/*  263 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  269 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  272 */       for (Map.Entry<Long, xbean.ShiTuTimeInfo> _e_ : this.apprentice_now.entrySet())
/*      */       {
/*  274 */         _output_.writeInt64(1, ((Long)_e_.getKey()).longValue());
/*  275 */         _output_.writeMessage(1, (Message)_e_.getValue());
/*      */       }
/*  277 */       for (Long _v_ : this.apprentice_role_list)
/*      */       {
/*  279 */         _output_.writeInt64(2, _v_.longValue());
/*      */       }
/*  281 */       for (Map.Entry<Long, xbean.ShiTuTimeInfo> _e_ : this.apprentice_graduate.entrySet())
/*      */       {
/*  283 */         _output_.writeInt64(3, ((Long)_e_.getKey()).longValue());
/*  284 */         _output_.writeMessage(3, (Message)_e_.getValue());
/*      */       }
/*  286 */       for (Map.Entry<Long, xbean.ShiTuTimeInfo> _e_ : this.force_relieve.entrySet())
/*      */       {
/*  288 */         _output_.writeInt64(4, ((Long)_e_.getKey()).longValue());
/*  289 */         _output_.writeMessage(4, (Message)_e_.getValue());
/*      */       }
/*  291 */       for (Integer _v_ : this.alwardy_awarded_cfg_set)
/*      */       {
/*  293 */         _output_.writeInt32(5, _v_.intValue());
/*      */       }
/*  295 */       for (Long _v_ : this.now_apprentice_role_list)
/*      */       {
/*  297 */         _output_.writeInt64(6, _v_.longValue());
/*      */       }
/*  299 */       _output_.writeInt64(7, this.publish_reset_time);
/*  300 */       _output_.writeInt32(8, this.publish_times);
/*      */     }
/*      */     catch (java.io.IOException e)
/*      */     {
/*  304 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  306 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  312 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  315 */       boolean done = false;
/*  316 */       while (!done)
/*      */       {
/*  318 */         int tag = _input_.readTag();
/*  319 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  323 */           done = true;
/*  324 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  328 */           long _k_ = 0L;
/*  329 */           _k_ = _input_.readInt64();
/*  330 */           int readTag = _input_.readTag();
/*  331 */           if (10 != readTag)
/*      */           {
/*  333 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  335 */           xbean.ShiTuTimeInfo _v_ = new ShiTuTimeInfo(0, this, "apprentice_now");
/*  336 */           _input_.readMessage(_v_);
/*  337 */           this.apprentice_now.put(Long.valueOf(_k_), _v_);
/*  338 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  342 */           long _v_ = 0L;
/*  343 */           _v_ = _input_.readInt64();
/*  344 */           this.apprentice_role_list.add(Long.valueOf(_v_));
/*  345 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  349 */           long _k_ = 0L;
/*  350 */           _k_ = _input_.readInt64();
/*  351 */           int readTag = _input_.readTag();
/*  352 */           if (26 != readTag)
/*      */           {
/*  354 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  356 */           xbean.ShiTuTimeInfo _v_ = new ShiTuTimeInfo(0, this, "apprentice_graduate");
/*  357 */           _input_.readMessage(_v_);
/*  358 */           this.apprentice_graduate.put(Long.valueOf(_k_), _v_);
/*  359 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  363 */           long _k_ = 0L;
/*  364 */           _k_ = _input_.readInt64();
/*  365 */           int readTag = _input_.readTag();
/*  366 */           if (34 != readTag)
/*      */           {
/*  368 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  370 */           xbean.ShiTuTimeInfo _v_ = new ShiTuTimeInfo(0, this, "force_relieve");
/*  371 */           _input_.readMessage(_v_);
/*  372 */           this.force_relieve.put(Long.valueOf(_k_), _v_);
/*  373 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  377 */           int _v_ = 0;
/*  378 */           _v_ = _input_.readInt32();
/*  379 */           this.alwardy_awarded_cfg_set.add(Integer.valueOf(_v_));
/*  380 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  384 */           long _v_ = 0L;
/*  385 */           _v_ = _input_.readInt64();
/*  386 */           this.now_apprentice_role_list.add(Long.valueOf(_v_));
/*  387 */           break;
/*      */         
/*      */ 
/*      */         case 56: 
/*  391 */           this.publish_reset_time = _input_.readInt64();
/*  392 */           break;
/*      */         
/*      */ 
/*      */         case 64: 
/*  396 */           this.publish_times = _input_.readInt32();
/*  397 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  401 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  403 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  412 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (java.io.IOException e)
/*      */     {
/*  416 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  418 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.MasterInfo copy()
/*      */   {
/*  424 */     _xdb_verify_unsafe_();
/*  425 */     return new MasterInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.MasterInfo toData()
/*      */   {
/*  431 */     _xdb_verify_unsafe_();
/*  432 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.MasterInfo toBean()
/*      */   {
/*  437 */     _xdb_verify_unsafe_();
/*  438 */     return new MasterInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.MasterInfo toDataIf()
/*      */   {
/*  444 */     _xdb_verify_unsafe_();
/*  445 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.MasterInfo toBeanIf()
/*      */   {
/*  450 */     _xdb_verify_unsafe_();
/*  451 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  457 */     _xdb_verify_unsafe_();
/*  458 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, xbean.ShiTuTimeInfo> getApprentice_now()
/*      */   {
/*  465 */     _xdb_verify_unsafe_();
/*  466 */     return xdb.Logs.logMap(new LogKey(this, "apprentice_now"), this.apprentice_now);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, xbean.ShiTuTimeInfo> getApprentice_nowAsData()
/*      */   {
/*  473 */     _xdb_verify_unsafe_();
/*      */     
/*  475 */     MasterInfo _o_ = this;
/*  476 */     Map<Long, xbean.ShiTuTimeInfo> apprentice_now = new HashMap();
/*  477 */     for (Map.Entry<Long, xbean.ShiTuTimeInfo> _e_ : _o_.apprentice_now.entrySet())
/*  478 */       apprentice_now.put(_e_.getKey(), new ShiTuTimeInfo.Data((xbean.ShiTuTimeInfo)_e_.getValue()));
/*  479 */     return apprentice_now;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<Long> getApprentice_role_list()
/*      */   {
/*  486 */     _xdb_verify_unsafe_();
/*  487 */     return xdb.Logs.logList(new LogKey(this, "apprentice_role_list"), this.apprentice_role_list);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<Long> getApprentice_role_listAsData()
/*      */   {
/*  493 */     _xdb_verify_unsafe_();
/*      */     
/*  495 */     MasterInfo _o_ = this;
/*  496 */     List<Long> apprentice_role_list = new LinkedList();
/*  497 */     apprentice_role_list.addAll(_o_.apprentice_role_list);
/*  498 */     return apprentice_role_list;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, xbean.ShiTuTimeInfo> getApprentice_graduate()
/*      */   {
/*  505 */     _xdb_verify_unsafe_();
/*  506 */     return xdb.Logs.logMap(new LogKey(this, "apprentice_graduate"), this.apprentice_graduate);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, xbean.ShiTuTimeInfo> getApprentice_graduateAsData()
/*      */   {
/*  513 */     _xdb_verify_unsafe_();
/*      */     
/*  515 */     MasterInfo _o_ = this;
/*  516 */     Map<Long, xbean.ShiTuTimeInfo> apprentice_graduate = new HashMap();
/*  517 */     for (Map.Entry<Long, xbean.ShiTuTimeInfo> _e_ : _o_.apprentice_graduate.entrySet())
/*  518 */       apprentice_graduate.put(_e_.getKey(), new ShiTuTimeInfo.Data((xbean.ShiTuTimeInfo)_e_.getValue()));
/*  519 */     return apprentice_graduate;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, xbean.ShiTuTimeInfo> getForce_relieve()
/*      */   {
/*  526 */     _xdb_verify_unsafe_();
/*  527 */     return xdb.Logs.logMap(new LogKey(this, "force_relieve"), this.force_relieve);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, xbean.ShiTuTimeInfo> getForce_relieveAsData()
/*      */   {
/*  534 */     _xdb_verify_unsafe_();
/*      */     
/*  536 */     MasterInfo _o_ = this;
/*  537 */     Map<Long, xbean.ShiTuTimeInfo> force_relieve = new HashMap();
/*  538 */     for (Map.Entry<Long, xbean.ShiTuTimeInfo> _e_ : _o_.force_relieve.entrySet())
/*  539 */       force_relieve.put(_e_.getKey(), new ShiTuTimeInfo.Data((xbean.ShiTuTimeInfo)_e_.getValue()));
/*  540 */     return force_relieve;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public java.util.Set<Integer> getAlwardy_awarded_cfg_set()
/*      */   {
/*  547 */     _xdb_verify_unsafe_();
/*  548 */     return xdb.Logs.logSet(new LogKey(this, "alwardy_awarded_cfg_set"), this.alwardy_awarded_cfg_set);
/*      */   }
/*      */   
/*      */ 
/*      */   public java.util.Set<Integer> getAlwardy_awarded_cfg_setAsData()
/*      */   {
/*  554 */     _xdb_verify_unsafe_();
/*      */     
/*  556 */     MasterInfo _o_ = this;
/*  557 */     java.util.Set<Integer> alwardy_awarded_cfg_set = new SetX();
/*  558 */     alwardy_awarded_cfg_set.addAll(_o_.alwardy_awarded_cfg_set);
/*  559 */     return alwardy_awarded_cfg_set;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<Long> getNow_apprentice_role_list()
/*      */   {
/*  566 */     _xdb_verify_unsafe_();
/*  567 */     return xdb.Logs.logList(new LogKey(this, "now_apprentice_role_list"), this.now_apprentice_role_list);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<Long> getNow_apprentice_role_listAsData()
/*      */   {
/*  573 */     _xdb_verify_unsafe_();
/*      */     
/*  575 */     MasterInfo _o_ = this;
/*  576 */     List<Long> now_apprentice_role_list = new LinkedList();
/*  577 */     now_apprentice_role_list.addAll(_o_.now_apprentice_role_list);
/*  578 */     return now_apprentice_role_list;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getPublish_reset_time()
/*      */   {
/*  585 */     _xdb_verify_unsafe_();
/*  586 */     return this.publish_reset_time;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getPublish_times()
/*      */   {
/*  593 */     _xdb_verify_unsafe_();
/*  594 */     return this.publish_times;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setPublish_reset_time(long _v_)
/*      */   {
/*  601 */     _xdb_verify_unsafe_();
/*  602 */     xdb.Logs.logIf(new LogKey(this, "publish_reset_time")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  606 */         new xdb.logs.LogLong(this, MasterInfo.this.publish_reset_time)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  610 */             MasterInfo.this.publish_reset_time = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  614 */     });
/*  615 */     this.publish_reset_time = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setPublish_times(int _v_)
/*      */   {
/*  622 */     _xdb_verify_unsafe_();
/*  623 */     xdb.Logs.logIf(new LogKey(this, "publish_times")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  627 */         new xdb.logs.LogInt(this, MasterInfo.this.publish_times)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  631 */             MasterInfo.this.publish_times = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  635 */     });
/*  636 */     this.publish_times = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  642 */     _xdb_verify_unsafe_();
/*  643 */     MasterInfo _o_ = null;
/*  644 */     if ((_o1_ instanceof MasterInfo)) { _o_ = (MasterInfo)_o1_;
/*  645 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  646 */       return false;
/*  647 */     if (!this.apprentice_now.equals(_o_.apprentice_now)) return false;
/*  648 */     if (!this.apprentice_role_list.equals(_o_.apprentice_role_list)) return false;
/*  649 */     if (!this.apprentice_graduate.equals(_o_.apprentice_graduate)) return false;
/*  650 */     if (!this.force_relieve.equals(_o_.force_relieve)) return false;
/*  651 */     if (!this.alwardy_awarded_cfg_set.equals(_o_.alwardy_awarded_cfg_set)) return false;
/*  652 */     if (!this.now_apprentice_role_list.equals(_o_.now_apprentice_role_list)) return false;
/*  653 */     if (this.publish_reset_time != _o_.publish_reset_time) return false;
/*  654 */     if (this.publish_times != _o_.publish_times) return false;
/*  655 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  661 */     _xdb_verify_unsafe_();
/*  662 */     int _h_ = 0;
/*  663 */     _h_ += this.apprentice_now.hashCode();
/*  664 */     _h_ += this.apprentice_role_list.hashCode();
/*  665 */     _h_ += this.apprentice_graduate.hashCode();
/*  666 */     _h_ += this.force_relieve.hashCode();
/*  667 */     _h_ += this.alwardy_awarded_cfg_set.hashCode();
/*  668 */     _h_ += this.now_apprentice_role_list.hashCode();
/*  669 */     _h_ = (int)(_h_ + this.publish_reset_time);
/*  670 */     _h_ += this.publish_times;
/*  671 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  677 */     _xdb_verify_unsafe_();
/*  678 */     StringBuilder _sb_ = new StringBuilder();
/*  679 */     _sb_.append("(");
/*  680 */     _sb_.append(this.apprentice_now);
/*  681 */     _sb_.append(",");
/*  682 */     _sb_.append(this.apprentice_role_list);
/*  683 */     _sb_.append(",");
/*  684 */     _sb_.append(this.apprentice_graduate);
/*  685 */     _sb_.append(",");
/*  686 */     _sb_.append(this.force_relieve);
/*  687 */     _sb_.append(",");
/*  688 */     _sb_.append(this.alwardy_awarded_cfg_set);
/*  689 */     _sb_.append(",");
/*  690 */     _sb_.append(this.now_apprentice_role_list);
/*  691 */     _sb_.append(",");
/*  692 */     _sb_.append(this.publish_reset_time);
/*  693 */     _sb_.append(",");
/*  694 */     _sb_.append(this.publish_times);
/*  695 */     _sb_.append(")");
/*  696 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  702 */     ListenableBean lb = new ListenableBean();
/*  703 */     lb.add(new xdb.logs.ListenableMap().setVarName("apprentice_now"));
/*  704 */     lb.add(new xdb.logs.ListenableChanged().setVarName("apprentice_role_list"));
/*  705 */     lb.add(new xdb.logs.ListenableMap().setVarName("apprentice_graduate"));
/*  706 */     lb.add(new xdb.logs.ListenableMap().setVarName("force_relieve"));
/*  707 */     lb.add(new xdb.logs.ListenableSet().setVarName("alwardy_awarded_cfg_set"));
/*  708 */     lb.add(new xdb.logs.ListenableChanged().setVarName("now_apprentice_role_list"));
/*  709 */     lb.add(new xdb.logs.ListenableChanged().setVarName("publish_reset_time"));
/*  710 */     lb.add(new xdb.logs.ListenableChanged().setVarName("publish_times"));
/*  711 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.MasterInfo {
/*      */     private Const() {}
/*      */     
/*      */     MasterInfo nThis() {
/*  718 */       return MasterInfo.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  724 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.MasterInfo copy()
/*      */     {
/*  730 */       return MasterInfo.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.MasterInfo toData()
/*      */     {
/*  736 */       return MasterInfo.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.MasterInfo toBean()
/*      */     {
/*  741 */       return MasterInfo.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.MasterInfo toDataIf()
/*      */     {
/*  747 */       return MasterInfo.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.MasterInfo toBeanIf()
/*      */     {
/*  752 */       return MasterInfo.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.ShiTuTimeInfo> getApprentice_now()
/*      */     {
/*  759 */       MasterInfo.this._xdb_verify_unsafe_();
/*  760 */       return xdb.Consts.constMap(MasterInfo.this.apprentice_now);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.ShiTuTimeInfo> getApprentice_nowAsData()
/*      */     {
/*  767 */       MasterInfo.this._xdb_verify_unsafe_();
/*      */       
/*  769 */       MasterInfo _o_ = MasterInfo.this;
/*  770 */       Map<Long, xbean.ShiTuTimeInfo> apprentice_now = new HashMap();
/*  771 */       for (Map.Entry<Long, xbean.ShiTuTimeInfo> _e_ : _o_.apprentice_now.entrySet())
/*  772 */         apprentice_now.put(_e_.getKey(), new ShiTuTimeInfo.Data((xbean.ShiTuTimeInfo)_e_.getValue()));
/*  773 */       return apprentice_now;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getApprentice_role_list()
/*      */     {
/*  780 */       MasterInfo.this._xdb_verify_unsafe_();
/*  781 */       return xdb.Consts.constList(MasterInfo.this.apprentice_role_list);
/*      */     }
/*      */     
/*      */ 
/*      */     public List<Long> getApprentice_role_listAsData()
/*      */     {
/*  787 */       MasterInfo.this._xdb_verify_unsafe_();
/*      */       
/*  789 */       MasterInfo _o_ = MasterInfo.this;
/*  790 */       List<Long> apprentice_role_list = new LinkedList();
/*  791 */       apprentice_role_list.addAll(_o_.apprentice_role_list);
/*  792 */       return apprentice_role_list;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.ShiTuTimeInfo> getApprentice_graduate()
/*      */     {
/*  799 */       MasterInfo.this._xdb_verify_unsafe_();
/*  800 */       return xdb.Consts.constMap(MasterInfo.this.apprentice_graduate);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.ShiTuTimeInfo> getApprentice_graduateAsData()
/*      */     {
/*  807 */       MasterInfo.this._xdb_verify_unsafe_();
/*      */       
/*  809 */       MasterInfo _o_ = MasterInfo.this;
/*  810 */       Map<Long, xbean.ShiTuTimeInfo> apprentice_graduate = new HashMap();
/*  811 */       for (Map.Entry<Long, xbean.ShiTuTimeInfo> _e_ : _o_.apprentice_graduate.entrySet())
/*  812 */         apprentice_graduate.put(_e_.getKey(), new ShiTuTimeInfo.Data((xbean.ShiTuTimeInfo)_e_.getValue()));
/*  813 */       return apprentice_graduate;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.ShiTuTimeInfo> getForce_relieve()
/*      */     {
/*  820 */       MasterInfo.this._xdb_verify_unsafe_();
/*  821 */       return xdb.Consts.constMap(MasterInfo.this.force_relieve);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.ShiTuTimeInfo> getForce_relieveAsData()
/*      */     {
/*  828 */       MasterInfo.this._xdb_verify_unsafe_();
/*      */       
/*  830 */       MasterInfo _o_ = MasterInfo.this;
/*  831 */       Map<Long, xbean.ShiTuTimeInfo> force_relieve = new HashMap();
/*  832 */       for (Map.Entry<Long, xbean.ShiTuTimeInfo> _e_ : _o_.force_relieve.entrySet())
/*  833 */         force_relieve.put(_e_.getKey(), new ShiTuTimeInfo.Data((xbean.ShiTuTimeInfo)_e_.getValue()));
/*  834 */       return force_relieve;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public java.util.Set<Integer> getAlwardy_awarded_cfg_set()
/*      */     {
/*  841 */       MasterInfo.this._xdb_verify_unsafe_();
/*  842 */       return xdb.Consts.constSet(MasterInfo.this.alwardy_awarded_cfg_set);
/*      */     }
/*      */     
/*      */ 
/*      */     public java.util.Set<Integer> getAlwardy_awarded_cfg_setAsData()
/*      */     {
/*  848 */       MasterInfo.this._xdb_verify_unsafe_();
/*      */       
/*  850 */       MasterInfo _o_ = MasterInfo.this;
/*  851 */       java.util.Set<Integer> alwardy_awarded_cfg_set = new SetX();
/*  852 */       alwardy_awarded_cfg_set.addAll(_o_.alwardy_awarded_cfg_set);
/*  853 */       return alwardy_awarded_cfg_set;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getNow_apprentice_role_list()
/*      */     {
/*  860 */       MasterInfo.this._xdb_verify_unsafe_();
/*  861 */       return xdb.Consts.constList(MasterInfo.this.now_apprentice_role_list);
/*      */     }
/*      */     
/*      */ 
/*      */     public List<Long> getNow_apprentice_role_listAsData()
/*      */     {
/*  867 */       MasterInfo.this._xdb_verify_unsafe_();
/*      */       
/*  869 */       MasterInfo _o_ = MasterInfo.this;
/*  870 */       List<Long> now_apprentice_role_list = new LinkedList();
/*  871 */       now_apprentice_role_list.addAll(_o_.now_apprentice_role_list);
/*  872 */       return now_apprentice_role_list;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getPublish_reset_time()
/*      */     {
/*  879 */       MasterInfo.this._xdb_verify_unsafe_();
/*  880 */       return MasterInfo.this.publish_reset_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getPublish_times()
/*      */     {
/*  887 */       MasterInfo.this._xdb_verify_unsafe_();
/*  888 */       return MasterInfo.this.publish_times;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPublish_reset_time(long _v_)
/*      */     {
/*  895 */       MasterInfo.this._xdb_verify_unsafe_();
/*  896 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPublish_times(int _v_)
/*      */     {
/*  903 */       MasterInfo.this._xdb_verify_unsafe_();
/*  904 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  910 */       MasterInfo.this._xdb_verify_unsafe_();
/*  911 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  917 */       MasterInfo.this._xdb_verify_unsafe_();
/*  918 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  924 */       return MasterInfo.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  930 */       return MasterInfo.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  936 */       MasterInfo.this._xdb_verify_unsafe_();
/*  937 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  943 */       return MasterInfo.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  949 */       return MasterInfo.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  955 */       MasterInfo.this._xdb_verify_unsafe_();
/*  956 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  962 */       return MasterInfo.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  968 */       return MasterInfo.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  974 */       return MasterInfo.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  980 */       return MasterInfo.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  986 */       return MasterInfo.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  992 */       return MasterInfo.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  998 */       return MasterInfo.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.MasterInfo
/*      */   {
/*      */     private HashMap<Long, xbean.ShiTuTimeInfo> apprentice_now;
/*      */     
/*      */     private LinkedList<Long> apprentice_role_list;
/*      */     
/*      */     private HashMap<Long, xbean.ShiTuTimeInfo> apprentice_graduate;
/*      */     
/*      */     private HashMap<Long, xbean.ShiTuTimeInfo> force_relieve;
/*      */     
/*      */     private HashSet<Integer> alwardy_awarded_cfg_set;
/*      */     
/*      */     private LinkedList<Long> now_apprentice_role_list;
/*      */     
/*      */     private long publish_reset_time;
/*      */     
/*      */     private int publish_times;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/* 1024 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/* 1029 */       this.apprentice_now = new HashMap();
/* 1030 */       this.apprentice_role_list = new LinkedList();
/* 1031 */       this.apprentice_graduate = new HashMap();
/* 1032 */       this.force_relieve = new HashMap();
/* 1033 */       this.alwardy_awarded_cfg_set = new HashSet();
/* 1034 */       this.now_apprentice_role_list = new LinkedList();
/*      */     }
/*      */     
/*      */     Data(xbean.MasterInfo _o1_)
/*      */     {
/* 1039 */       if ((_o1_ instanceof MasterInfo)) { assign((MasterInfo)_o1_);
/* 1040 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 1041 */       } else if ((_o1_ instanceof MasterInfo.Const)) assign(((MasterInfo.Const)_o1_).nThis()); else {
/* 1042 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(MasterInfo _o_) {
/* 1047 */       this.apprentice_now = new HashMap();
/* 1048 */       for (Map.Entry<Long, xbean.ShiTuTimeInfo> _e_ : _o_.apprentice_now.entrySet())
/* 1049 */         this.apprentice_now.put(_e_.getKey(), new ShiTuTimeInfo.Data((xbean.ShiTuTimeInfo)_e_.getValue()));
/* 1050 */       this.apprentice_role_list = new LinkedList();
/* 1051 */       this.apprentice_role_list.addAll(_o_.apprentice_role_list);
/* 1052 */       this.apprentice_graduate = new HashMap();
/* 1053 */       for (Map.Entry<Long, xbean.ShiTuTimeInfo> _e_ : _o_.apprentice_graduate.entrySet())
/* 1054 */         this.apprentice_graduate.put(_e_.getKey(), new ShiTuTimeInfo.Data((xbean.ShiTuTimeInfo)_e_.getValue()));
/* 1055 */       this.force_relieve = new HashMap();
/* 1056 */       for (Map.Entry<Long, xbean.ShiTuTimeInfo> _e_ : _o_.force_relieve.entrySet())
/* 1057 */         this.force_relieve.put(_e_.getKey(), new ShiTuTimeInfo.Data((xbean.ShiTuTimeInfo)_e_.getValue()));
/* 1058 */       this.alwardy_awarded_cfg_set = new HashSet();
/* 1059 */       this.alwardy_awarded_cfg_set.addAll(_o_.alwardy_awarded_cfg_set);
/* 1060 */       this.now_apprentice_role_list = new LinkedList();
/* 1061 */       this.now_apprentice_role_list.addAll(_o_.now_apprentice_role_list);
/* 1062 */       this.publish_reset_time = _o_.publish_reset_time;
/* 1063 */       this.publish_times = _o_.publish_times;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/* 1068 */       this.apprentice_now = new HashMap();
/* 1069 */       for (Map.Entry<Long, xbean.ShiTuTimeInfo> _e_ : _o_.apprentice_now.entrySet())
/* 1070 */         this.apprentice_now.put(_e_.getKey(), new ShiTuTimeInfo.Data((xbean.ShiTuTimeInfo)_e_.getValue()));
/* 1071 */       this.apprentice_role_list = new LinkedList();
/* 1072 */       this.apprentice_role_list.addAll(_o_.apprentice_role_list);
/* 1073 */       this.apprentice_graduate = new HashMap();
/* 1074 */       for (Map.Entry<Long, xbean.ShiTuTimeInfo> _e_ : _o_.apprentice_graduate.entrySet())
/* 1075 */         this.apprentice_graduate.put(_e_.getKey(), new ShiTuTimeInfo.Data((xbean.ShiTuTimeInfo)_e_.getValue()));
/* 1076 */       this.force_relieve = new HashMap();
/* 1077 */       for (Map.Entry<Long, xbean.ShiTuTimeInfo> _e_ : _o_.force_relieve.entrySet())
/* 1078 */         this.force_relieve.put(_e_.getKey(), new ShiTuTimeInfo.Data((xbean.ShiTuTimeInfo)_e_.getValue()));
/* 1079 */       this.alwardy_awarded_cfg_set = new HashSet();
/* 1080 */       this.alwardy_awarded_cfg_set.addAll(_o_.alwardy_awarded_cfg_set);
/* 1081 */       this.now_apprentice_role_list = new LinkedList();
/* 1082 */       this.now_apprentice_role_list.addAll(_o_.now_apprentice_role_list);
/* 1083 */       this.publish_reset_time = _o_.publish_reset_time;
/* 1084 */       this.publish_times = _o_.publish_times;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/* 1090 */       _os_.compact_uint32(this.apprentice_now.size());
/* 1091 */       for (Map.Entry<Long, xbean.ShiTuTimeInfo> _e_ : this.apprentice_now.entrySet())
/*      */       {
/* 1093 */         _os_.marshal(((Long)_e_.getKey()).longValue());
/* 1094 */         ((xbean.ShiTuTimeInfo)_e_.getValue()).marshal(_os_);
/*      */       }
/* 1096 */       _os_.compact_uint32(this.apprentice_role_list.size());
/* 1097 */       for (Long _v_ : this.apprentice_role_list)
/*      */       {
/* 1099 */         _os_.marshal(_v_.longValue());
/*      */       }
/* 1101 */       _os_.compact_uint32(this.apprentice_graduate.size());
/* 1102 */       for (Map.Entry<Long, xbean.ShiTuTimeInfo> _e_ : this.apprentice_graduate.entrySet())
/*      */       {
/* 1104 */         _os_.marshal(((Long)_e_.getKey()).longValue());
/* 1105 */         ((xbean.ShiTuTimeInfo)_e_.getValue()).marshal(_os_);
/*      */       }
/* 1107 */       _os_.compact_uint32(this.force_relieve.size());
/* 1108 */       for (Map.Entry<Long, xbean.ShiTuTimeInfo> _e_ : this.force_relieve.entrySet())
/*      */       {
/* 1110 */         _os_.marshal(((Long)_e_.getKey()).longValue());
/* 1111 */         ((xbean.ShiTuTimeInfo)_e_.getValue()).marshal(_os_);
/*      */       }
/* 1113 */       _os_.compact_uint32(this.alwardy_awarded_cfg_set.size());
/* 1114 */       for (Integer _v_ : this.alwardy_awarded_cfg_set)
/*      */       {
/* 1116 */         _os_.marshal(_v_.intValue());
/*      */       }
/* 1118 */       _os_.compact_uint32(this.now_apprentice_role_list.size());
/* 1119 */       for (Long _v_ : this.now_apprentice_role_list)
/*      */       {
/* 1121 */         _os_.marshal(_v_.longValue());
/*      */       }
/* 1123 */       _os_.marshal(this.publish_reset_time);
/* 1124 */       _os_.marshal(this.publish_times);
/* 1125 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/* 1132 */       int size = _os_.uncompact_uint32();
/* 1133 */       if (size >= 12)
/*      */       {
/* 1135 */         this.apprentice_now = new HashMap(size * 2);
/*      */       }
/* 1137 */       for (; size > 0; size--)
/*      */       {
/* 1139 */         long _k_ = 0L;
/* 1140 */         _k_ = _os_.unmarshal_long();
/* 1141 */         xbean.ShiTuTimeInfo _v_ = xbean.Pod.newShiTuTimeInfoData();
/* 1142 */         _v_.unmarshal(_os_);
/* 1143 */         this.apprentice_now.put(Long.valueOf(_k_), _v_);
/*      */       }
/*      */       
/* 1146 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/* 1148 */         long _v_ = 0L;
/* 1149 */         _v_ = _os_.unmarshal_long();
/* 1150 */         this.apprentice_role_list.add(Long.valueOf(_v_));
/*      */       }
/*      */       
/* 1153 */       int size = _os_.uncompact_uint32();
/* 1154 */       if (size >= 12)
/*      */       {
/* 1156 */         this.apprentice_graduate = new HashMap(size * 2);
/*      */       }
/* 1158 */       for (; size > 0; size--)
/*      */       {
/* 1160 */         long _k_ = 0L;
/* 1161 */         _k_ = _os_.unmarshal_long();
/* 1162 */         xbean.ShiTuTimeInfo _v_ = xbean.Pod.newShiTuTimeInfoData();
/* 1163 */         _v_.unmarshal(_os_);
/* 1164 */         this.apprentice_graduate.put(Long.valueOf(_k_), _v_);
/*      */       }
/*      */       
/*      */ 
/* 1168 */       int size = _os_.uncompact_uint32();
/* 1169 */       if (size >= 12)
/*      */       {
/* 1171 */         this.force_relieve = new HashMap(size * 2);
/*      */       }
/* 1173 */       for (; size > 0; size--)
/*      */       {
/* 1175 */         long _k_ = 0L;
/* 1176 */         _k_ = _os_.unmarshal_long();
/* 1177 */         xbean.ShiTuTimeInfo _v_ = xbean.Pod.newShiTuTimeInfoData();
/* 1178 */         _v_.unmarshal(_os_);
/* 1179 */         this.force_relieve.put(Long.valueOf(_k_), _v_);
/*      */       }
/*      */       
/* 1182 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/* 1184 */         int _v_ = 0;
/* 1185 */         _v_ = _os_.unmarshal_int();
/* 1186 */         this.alwardy_awarded_cfg_set.add(Integer.valueOf(_v_));
/*      */       }
/* 1188 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/* 1190 */         long _v_ = 0L;
/* 1191 */         _v_ = _os_.unmarshal_long();
/* 1192 */         this.now_apprentice_role_list.add(Long.valueOf(_v_));
/*      */       }
/* 1194 */       this.publish_reset_time = _os_.unmarshal_long();
/* 1195 */       this.publish_times = _os_.unmarshal_int();
/* 1196 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/* 1202 */       int _size_ = 0;
/* 1203 */       for (Map.Entry<Long, xbean.ShiTuTimeInfo> _e_ : this.apprentice_now.entrySet())
/*      */       {
/* 1205 */         _size_ += CodedOutputStream.computeInt64Size(1, ((Long)_e_.getKey()).longValue());
/* 1206 */         _size_ += CodedOutputStream.computeMessageSize(1, (Message)_e_.getValue());
/*      */       }
/* 1208 */       for (Long _v_ : this.apprentice_role_list)
/*      */       {
/* 1210 */         _size_ += CodedOutputStream.computeInt64Size(2, _v_.longValue());
/*      */       }
/* 1212 */       for (Map.Entry<Long, xbean.ShiTuTimeInfo> _e_ : this.apprentice_graduate.entrySet())
/*      */       {
/* 1214 */         _size_ += CodedOutputStream.computeInt64Size(3, ((Long)_e_.getKey()).longValue());
/* 1215 */         _size_ += CodedOutputStream.computeMessageSize(3, (Message)_e_.getValue());
/*      */       }
/* 1217 */       for (Map.Entry<Long, xbean.ShiTuTimeInfo> _e_ : this.force_relieve.entrySet())
/*      */       {
/* 1219 */         _size_ += CodedOutputStream.computeInt64Size(4, ((Long)_e_.getKey()).longValue());
/* 1220 */         _size_ += CodedOutputStream.computeMessageSize(4, (Message)_e_.getValue());
/*      */       }
/* 1222 */       for (Integer _v_ : this.alwardy_awarded_cfg_set)
/*      */       {
/* 1224 */         _size_ += CodedOutputStream.computeInt32Size(5, _v_.intValue());
/*      */       }
/* 1226 */       for (Long _v_ : this.now_apprentice_role_list)
/*      */       {
/* 1228 */         _size_ += CodedOutputStream.computeInt64Size(6, _v_.longValue());
/*      */       }
/* 1230 */       _size_ += CodedOutputStream.computeInt64Size(7, this.publish_reset_time);
/* 1231 */       _size_ += CodedOutputStream.computeInt32Size(8, this.publish_times);
/* 1232 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1240 */         for (Map.Entry<Long, xbean.ShiTuTimeInfo> _e_ : this.apprentice_now.entrySet())
/*      */         {
/* 1242 */           _output_.writeInt64(1, ((Long)_e_.getKey()).longValue());
/* 1243 */           _output_.writeMessage(1, (Message)_e_.getValue());
/*      */         }
/* 1245 */         for (Long _v_ : this.apprentice_role_list)
/*      */         {
/* 1247 */           _output_.writeInt64(2, _v_.longValue());
/*      */         }
/* 1249 */         for (Map.Entry<Long, xbean.ShiTuTimeInfo> _e_ : this.apprentice_graduate.entrySet())
/*      */         {
/* 1251 */           _output_.writeInt64(3, ((Long)_e_.getKey()).longValue());
/* 1252 */           _output_.writeMessage(3, (Message)_e_.getValue());
/*      */         }
/* 1254 */         for (Map.Entry<Long, xbean.ShiTuTimeInfo> _e_ : this.force_relieve.entrySet())
/*      */         {
/* 1256 */           _output_.writeInt64(4, ((Long)_e_.getKey()).longValue());
/* 1257 */           _output_.writeMessage(4, (Message)_e_.getValue());
/*      */         }
/* 1259 */         for (Integer _v_ : this.alwardy_awarded_cfg_set)
/*      */         {
/* 1261 */           _output_.writeInt32(5, _v_.intValue());
/*      */         }
/* 1263 */         for (Long _v_ : this.now_apprentice_role_list)
/*      */         {
/* 1265 */           _output_.writeInt64(6, _v_.longValue());
/*      */         }
/* 1267 */         _output_.writeInt64(7, this.publish_reset_time);
/* 1268 */         _output_.writeInt32(8, this.publish_times);
/*      */       }
/*      */       catch (java.io.IOException e)
/*      */       {
/* 1272 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1274 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1282 */         boolean done = false;
/* 1283 */         while (!done)
/*      */         {
/* 1285 */           int tag = _input_.readTag();
/* 1286 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/* 1290 */             done = true;
/* 1291 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/* 1295 */             long _k_ = 0L;
/* 1296 */             _k_ = _input_.readInt64();
/* 1297 */             int readTag = _input_.readTag();
/* 1298 */             if (10 != readTag)
/*      */             {
/* 1300 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 1302 */             xbean.ShiTuTimeInfo _v_ = xbean.Pod.newShiTuTimeInfoData();
/* 1303 */             _input_.readMessage(_v_);
/* 1304 */             this.apprentice_now.put(Long.valueOf(_k_), _v_);
/* 1305 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/* 1309 */             long _v_ = 0L;
/* 1310 */             _v_ = _input_.readInt64();
/* 1311 */             this.apprentice_role_list.add(Long.valueOf(_v_));
/* 1312 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/* 1316 */             long _k_ = 0L;
/* 1317 */             _k_ = _input_.readInt64();
/* 1318 */             int readTag = _input_.readTag();
/* 1319 */             if (26 != readTag)
/*      */             {
/* 1321 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 1323 */             xbean.ShiTuTimeInfo _v_ = xbean.Pod.newShiTuTimeInfoData();
/* 1324 */             _input_.readMessage(_v_);
/* 1325 */             this.apprentice_graduate.put(Long.valueOf(_k_), _v_);
/* 1326 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/* 1330 */             long _k_ = 0L;
/* 1331 */             _k_ = _input_.readInt64();
/* 1332 */             int readTag = _input_.readTag();
/* 1333 */             if (34 != readTag)
/*      */             {
/* 1335 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 1337 */             xbean.ShiTuTimeInfo _v_ = xbean.Pod.newShiTuTimeInfoData();
/* 1338 */             _input_.readMessage(_v_);
/* 1339 */             this.force_relieve.put(Long.valueOf(_k_), _v_);
/* 1340 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/* 1344 */             int _v_ = 0;
/* 1345 */             _v_ = _input_.readInt32();
/* 1346 */             this.alwardy_awarded_cfg_set.add(Integer.valueOf(_v_));
/* 1347 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/* 1351 */             long _v_ = 0L;
/* 1352 */             _v_ = _input_.readInt64();
/* 1353 */             this.now_apprentice_role_list.add(Long.valueOf(_v_));
/* 1354 */             break;
/*      */           
/*      */ 
/*      */           case 56: 
/* 1358 */             this.publish_reset_time = _input_.readInt64();
/* 1359 */             break;
/*      */           
/*      */ 
/*      */           case 64: 
/* 1363 */             this.publish_times = _input_.readInt32();
/* 1364 */             break;
/*      */           
/*      */ 
/*      */           default: 
/* 1368 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/* 1370 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/* 1379 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (java.io.IOException e)
/*      */       {
/* 1383 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1385 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.MasterInfo copy()
/*      */     {
/* 1391 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.MasterInfo toData()
/*      */     {
/* 1397 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.MasterInfo toBean()
/*      */     {
/* 1402 */       return new MasterInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.MasterInfo toDataIf()
/*      */     {
/* 1408 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.MasterInfo toBeanIf()
/*      */     {
/* 1413 */       return new MasterInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1419 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/* 1423 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1427 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1431 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/* 1435 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1439 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1443 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.ShiTuTimeInfo> getApprentice_now()
/*      */     {
/* 1450 */       return this.apprentice_now;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.ShiTuTimeInfo> getApprentice_nowAsData()
/*      */     {
/* 1457 */       return this.apprentice_now;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getApprentice_role_list()
/*      */     {
/* 1464 */       return this.apprentice_role_list;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getApprentice_role_listAsData()
/*      */     {
/* 1471 */       return this.apprentice_role_list;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.ShiTuTimeInfo> getApprentice_graduate()
/*      */     {
/* 1478 */       return this.apprentice_graduate;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.ShiTuTimeInfo> getApprentice_graduateAsData()
/*      */     {
/* 1485 */       return this.apprentice_graduate;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.ShiTuTimeInfo> getForce_relieve()
/*      */     {
/* 1492 */       return this.force_relieve;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.ShiTuTimeInfo> getForce_relieveAsData()
/*      */     {
/* 1499 */       return this.force_relieve;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public java.util.Set<Integer> getAlwardy_awarded_cfg_set()
/*      */     {
/* 1506 */       return this.alwardy_awarded_cfg_set;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public java.util.Set<Integer> getAlwardy_awarded_cfg_setAsData()
/*      */     {
/* 1513 */       return this.alwardy_awarded_cfg_set;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getNow_apprentice_role_list()
/*      */     {
/* 1520 */       return this.now_apprentice_role_list;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getNow_apprentice_role_listAsData()
/*      */     {
/* 1527 */       return this.now_apprentice_role_list;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getPublish_reset_time()
/*      */     {
/* 1534 */       return this.publish_reset_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getPublish_times()
/*      */     {
/* 1541 */       return this.publish_times;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPublish_reset_time(long _v_)
/*      */     {
/* 1548 */       this.publish_reset_time = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPublish_times(int _v_)
/*      */     {
/* 1555 */       this.publish_times = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1561 */       if (!(_o1_ instanceof Data)) return false;
/* 1562 */       Data _o_ = (Data)_o1_;
/* 1563 */       if (!this.apprentice_now.equals(_o_.apprentice_now)) return false;
/* 1564 */       if (!this.apprentice_role_list.equals(_o_.apprentice_role_list)) return false;
/* 1565 */       if (!this.apprentice_graduate.equals(_o_.apprentice_graduate)) return false;
/* 1566 */       if (!this.force_relieve.equals(_o_.force_relieve)) return false;
/* 1567 */       if (!this.alwardy_awarded_cfg_set.equals(_o_.alwardy_awarded_cfg_set)) return false;
/* 1568 */       if (!this.now_apprentice_role_list.equals(_o_.now_apprentice_role_list)) return false;
/* 1569 */       if (this.publish_reset_time != _o_.publish_reset_time) return false;
/* 1570 */       if (this.publish_times != _o_.publish_times) return false;
/* 1571 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1577 */       int _h_ = 0;
/* 1578 */       _h_ += this.apprentice_now.hashCode();
/* 1579 */       _h_ += this.apprentice_role_list.hashCode();
/* 1580 */       _h_ += this.apprentice_graduate.hashCode();
/* 1581 */       _h_ += this.force_relieve.hashCode();
/* 1582 */       _h_ += this.alwardy_awarded_cfg_set.hashCode();
/* 1583 */       _h_ += this.now_apprentice_role_list.hashCode();
/* 1584 */       _h_ = (int)(_h_ + this.publish_reset_time);
/* 1585 */       _h_ += this.publish_times;
/* 1586 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1592 */       StringBuilder _sb_ = new StringBuilder();
/* 1593 */       _sb_.append("(");
/* 1594 */       _sb_.append(this.apprentice_now);
/* 1595 */       _sb_.append(",");
/* 1596 */       _sb_.append(this.apprentice_role_list);
/* 1597 */       _sb_.append(",");
/* 1598 */       _sb_.append(this.apprentice_graduate);
/* 1599 */       _sb_.append(",");
/* 1600 */       _sb_.append(this.force_relieve);
/* 1601 */       _sb_.append(",");
/* 1602 */       _sb_.append(this.alwardy_awarded_cfg_set);
/* 1603 */       _sb_.append(",");
/* 1604 */       _sb_.append(this.now_apprentice_role_list);
/* 1605 */       _sb_.append(",");
/* 1606 */       _sb_.append(this.publish_reset_time);
/* 1607 */       _sb_.append(",");
/* 1608 */       _sb_.append(this.publish_times);
/* 1609 */       _sb_.append(")");
/* 1610 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\MasterInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */