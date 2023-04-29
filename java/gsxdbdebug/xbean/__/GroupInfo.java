/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.io.IOException;
/*      */ import java.util.HashMap;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import ppbio.Message;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableMap;
/*      */ 
/*      */ public final class GroupInfo extends XBean implements xbean.GroupInfo
/*      */ {
/*      */   private HashMap<Long, xbean.GroupSetting> create_same_zone_groupids;
/*      */   private HashMap<Long, xbean.GroupSetting> join_same_zone_groupids;
/*      */   private HashMap<Long, Long> offline_group_join_infos;
/*      */   private HashMap<Long, Long> offline_group_kick_infos;
/*      */   private HashMap<Long, String> offline_group_dissolve_infos;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   26 */     this.create_same_zone_groupids.clear();
/*   27 */     this.join_same_zone_groupids.clear();
/*   28 */     this.offline_group_join_infos.clear();
/*   29 */     this.offline_group_kick_infos.clear();
/*   30 */     this.offline_group_dissolve_infos.clear();
/*      */   }
/*      */   
/*      */   GroupInfo(int __, XBean _xp_, String _vn_)
/*      */   {
/*   35 */     super(_xp_, _vn_);
/*   36 */     this.create_same_zone_groupids = new HashMap();
/*   37 */     this.join_same_zone_groupids = new HashMap();
/*   38 */     this.offline_group_join_infos = new HashMap();
/*   39 */     this.offline_group_kick_infos = new HashMap();
/*   40 */     this.offline_group_dissolve_infos = new HashMap();
/*      */   }
/*      */   
/*      */   public GroupInfo()
/*      */   {
/*   45 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public GroupInfo(GroupInfo _o_)
/*      */   {
/*   50 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   GroupInfo(xbean.GroupInfo _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   55 */     super(_xp_, _vn_);
/*   56 */     if ((_o1_ instanceof GroupInfo)) { assign((GroupInfo)_o1_);
/*   57 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   58 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   59 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(GroupInfo _o_) {
/*   64 */     _o_._xdb_verify_unsafe_();
/*   65 */     this.create_same_zone_groupids = new HashMap();
/*   66 */     for (Map.Entry<Long, xbean.GroupSetting> _e_ : _o_.create_same_zone_groupids.entrySet())
/*   67 */       this.create_same_zone_groupids.put(_e_.getKey(), new GroupSetting((xbean.GroupSetting)_e_.getValue(), this, "create_same_zone_groupids"));
/*   68 */     this.join_same_zone_groupids = new HashMap();
/*   69 */     for (Map.Entry<Long, xbean.GroupSetting> _e_ : _o_.join_same_zone_groupids.entrySet())
/*   70 */       this.join_same_zone_groupids.put(_e_.getKey(), new GroupSetting((xbean.GroupSetting)_e_.getValue(), this, "join_same_zone_groupids"));
/*   71 */     this.offline_group_join_infos = new HashMap();
/*   72 */     for (Map.Entry<Long, Long> _e_ : _o_.offline_group_join_infos.entrySet())
/*   73 */       this.offline_group_join_infos.put(_e_.getKey(), _e_.getValue());
/*   74 */     this.offline_group_kick_infos = new HashMap();
/*   75 */     for (Map.Entry<Long, Long> _e_ : _o_.offline_group_kick_infos.entrySet())
/*   76 */       this.offline_group_kick_infos.put(_e_.getKey(), _e_.getValue());
/*   77 */     this.offline_group_dissolve_infos = new HashMap();
/*   78 */     for (Map.Entry<Long, String> _e_ : _o_.offline_group_dissolve_infos.entrySet()) {
/*   79 */       this.offline_group_dissolve_infos.put(_e_.getKey(), _e_.getValue());
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(Data _o_) {
/*   84 */     this.create_same_zone_groupids = new HashMap();
/*   85 */     for (Map.Entry<Long, xbean.GroupSetting> _e_ : _o_.create_same_zone_groupids.entrySet())
/*   86 */       this.create_same_zone_groupids.put(_e_.getKey(), new GroupSetting((xbean.GroupSetting)_e_.getValue(), this, "create_same_zone_groupids"));
/*   87 */     this.join_same_zone_groupids = new HashMap();
/*   88 */     for (Map.Entry<Long, xbean.GroupSetting> _e_ : _o_.join_same_zone_groupids.entrySet())
/*   89 */       this.join_same_zone_groupids.put(_e_.getKey(), new GroupSetting((xbean.GroupSetting)_e_.getValue(), this, "join_same_zone_groupids"));
/*   90 */     this.offline_group_join_infos = new HashMap();
/*   91 */     for (Map.Entry<Long, Long> _e_ : _o_.offline_group_join_infos.entrySet())
/*   92 */       this.offline_group_join_infos.put(_e_.getKey(), _e_.getValue());
/*   93 */     this.offline_group_kick_infos = new HashMap();
/*   94 */     for (Map.Entry<Long, Long> _e_ : _o_.offline_group_kick_infos.entrySet())
/*   95 */       this.offline_group_kick_infos.put(_e_.getKey(), _e_.getValue());
/*   96 */     this.offline_group_dissolve_infos = new HashMap();
/*   97 */     for (Map.Entry<Long, String> _e_ : _o_.offline_group_dissolve_infos.entrySet()) {
/*   98 */       this.offline_group_dissolve_infos.put(_e_.getKey(), _e_.getValue());
/*      */     }
/*      */   }
/*      */   
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*  104 */     _xdb_verify_unsafe_();
/*  105 */     _os_.compact_uint32(this.create_same_zone_groupids.size());
/*  106 */     for (Map.Entry<Long, xbean.GroupSetting> _e_ : this.create_same_zone_groupids.entrySet())
/*      */     {
/*  108 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  109 */       ((xbean.GroupSetting)_e_.getValue()).marshal(_os_);
/*      */     }
/*  111 */     _os_.compact_uint32(this.join_same_zone_groupids.size());
/*  112 */     for (Map.Entry<Long, xbean.GroupSetting> _e_ : this.join_same_zone_groupids.entrySet())
/*      */     {
/*  114 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  115 */       ((xbean.GroupSetting)_e_.getValue()).marshal(_os_);
/*      */     }
/*  117 */     _os_.compact_uint32(this.offline_group_join_infos.size());
/*  118 */     for (Map.Entry<Long, Long> _e_ : this.offline_group_join_infos.entrySet())
/*      */     {
/*  120 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  121 */       _os_.marshal(((Long)_e_.getValue()).longValue());
/*      */     }
/*  123 */     _os_.compact_uint32(this.offline_group_kick_infos.size());
/*  124 */     for (Map.Entry<Long, Long> _e_ : this.offline_group_kick_infos.entrySet())
/*      */     {
/*  126 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  127 */       _os_.marshal(((Long)_e_.getValue()).longValue());
/*      */     }
/*  129 */     _os_.compact_uint32(this.offline_group_dissolve_infos.size());
/*  130 */     for (Map.Entry<Long, String> _e_ : this.offline_group_dissolve_infos.entrySet())
/*      */     {
/*  132 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  133 */       _os_.marshal((String)_e_.getValue(), "UTF-16LE");
/*      */     }
/*  135 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  141 */     _xdb_verify_unsafe_();
/*      */     
/*  143 */     int size = _os_.uncompact_uint32();
/*  144 */     if (size >= 12)
/*      */     {
/*  146 */       this.create_same_zone_groupids = new HashMap(size * 2);
/*      */     }
/*  148 */     for (; size > 0; size--)
/*      */     {
/*  150 */       long _k_ = 0L;
/*  151 */       _k_ = _os_.unmarshal_long();
/*  152 */       xbean.GroupSetting _v_ = new GroupSetting(0, this, "create_same_zone_groupids");
/*  153 */       _v_.unmarshal(_os_);
/*  154 */       this.create_same_zone_groupids.put(Long.valueOf(_k_), _v_);
/*      */     }
/*      */     
/*      */ 
/*  158 */     int size = _os_.uncompact_uint32();
/*  159 */     if (size >= 12)
/*      */     {
/*  161 */       this.join_same_zone_groupids = new HashMap(size * 2);
/*      */     }
/*  163 */     for (; size > 0; size--)
/*      */     {
/*  165 */       long _k_ = 0L;
/*  166 */       _k_ = _os_.unmarshal_long();
/*  167 */       xbean.GroupSetting _v_ = new GroupSetting(0, this, "join_same_zone_groupids");
/*  168 */       _v_.unmarshal(_os_);
/*  169 */       this.join_same_zone_groupids.put(Long.valueOf(_k_), _v_);
/*      */     }
/*      */     
/*      */ 
/*  173 */     int size = _os_.uncompact_uint32();
/*  174 */     if (size >= 12)
/*      */     {
/*  176 */       this.offline_group_join_infos = new HashMap(size * 2);
/*      */     }
/*  178 */     for (; size > 0; size--)
/*      */     {
/*  180 */       long _k_ = 0L;
/*  181 */       _k_ = _os_.unmarshal_long();
/*  182 */       long _v_ = 0L;
/*  183 */       _v_ = _os_.unmarshal_long();
/*  184 */       this.offline_group_join_infos.put(Long.valueOf(_k_), Long.valueOf(_v_));
/*      */     }
/*      */     
/*      */ 
/*  188 */     int size = _os_.uncompact_uint32();
/*  189 */     if (size >= 12)
/*      */     {
/*  191 */       this.offline_group_kick_infos = new HashMap(size * 2);
/*      */     }
/*  193 */     for (; size > 0; size--)
/*      */     {
/*  195 */       long _k_ = 0L;
/*  196 */       _k_ = _os_.unmarshal_long();
/*  197 */       long _v_ = 0L;
/*  198 */       _v_ = _os_.unmarshal_long();
/*  199 */       this.offline_group_kick_infos.put(Long.valueOf(_k_), Long.valueOf(_v_));
/*      */     }
/*      */     
/*      */ 
/*  203 */     int size = _os_.uncompact_uint32();
/*  204 */     if (size >= 12)
/*      */     {
/*  206 */       this.offline_group_dissolve_infos = new HashMap(size * 2);
/*      */     }
/*  208 */     for (; size > 0; size--)
/*      */     {
/*  210 */       long _k_ = 0L;
/*  211 */       _k_ = _os_.unmarshal_long();
/*  212 */       String _v_ = "";
/*  213 */       _v_ = _os_.unmarshal_String("UTF-16LE");
/*  214 */       this.offline_group_dissolve_infos.put(Long.valueOf(_k_), _v_);
/*      */     }
/*      */     
/*  217 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  223 */     _xdb_verify_unsafe_();
/*  224 */     int _size_ = 0;
/*  225 */     for (Map.Entry<Long, xbean.GroupSetting> _e_ : this.create_same_zone_groupids.entrySet())
/*      */     {
/*  227 */       _size_ += CodedOutputStream.computeInt64Size(1, ((Long)_e_.getKey()).longValue());
/*  228 */       _size_ += CodedOutputStream.computeMessageSize(1, (Message)_e_.getValue());
/*      */     }
/*  230 */     for (Map.Entry<Long, xbean.GroupSetting> _e_ : this.join_same_zone_groupids.entrySet())
/*      */     {
/*  232 */       _size_ += CodedOutputStream.computeInt64Size(2, ((Long)_e_.getKey()).longValue());
/*  233 */       _size_ += CodedOutputStream.computeMessageSize(2, (Message)_e_.getValue());
/*      */     }
/*  235 */     for (Map.Entry<Long, Long> _e_ : this.offline_group_join_infos.entrySet())
/*      */     {
/*  237 */       _size_ += CodedOutputStream.computeInt64Size(3, ((Long)_e_.getKey()).longValue());
/*  238 */       _size_ += CodedOutputStream.computeInt64Size(3, ((Long)_e_.getValue()).longValue());
/*      */     }
/*  240 */     for (Map.Entry<Long, Long> _e_ : this.offline_group_kick_infos.entrySet())
/*      */     {
/*  242 */       _size_ += CodedOutputStream.computeInt64Size(4, ((Long)_e_.getKey()).longValue());
/*  243 */       _size_ += CodedOutputStream.computeInt64Size(4, ((Long)_e_.getValue()).longValue());
/*      */     }
/*  245 */     for (Map.Entry<Long, String> _e_ : this.offline_group_dissolve_infos.entrySet())
/*      */     {
/*  247 */       _size_ += CodedOutputStream.computeInt64Size(5, ((Long)_e_.getKey()).longValue());
/*      */       try
/*      */       {
/*  250 */         _size_ += CodedOutputStream.computeBytesSize(5, ppbio.ByteString.copyFrom((String)_e_.getValue(), "UTF-16LE"));
/*      */       }
/*      */       catch (java.io.UnsupportedEncodingException e)
/*      */       {
/*  254 */         throw new RuntimeException("UTF-16LE not supported?", e);
/*      */       }
/*      */     }
/*  257 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  263 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  266 */       for (Map.Entry<Long, xbean.GroupSetting> _e_ : this.create_same_zone_groupids.entrySet())
/*      */       {
/*  268 */         _output_.writeInt64(1, ((Long)_e_.getKey()).longValue());
/*  269 */         _output_.writeMessage(1, (Message)_e_.getValue());
/*      */       }
/*  271 */       for (Map.Entry<Long, xbean.GroupSetting> _e_ : this.join_same_zone_groupids.entrySet())
/*      */       {
/*  273 */         _output_.writeInt64(2, ((Long)_e_.getKey()).longValue());
/*  274 */         _output_.writeMessage(2, (Message)_e_.getValue());
/*      */       }
/*  276 */       for (Map.Entry<Long, Long> _e_ : this.offline_group_join_infos.entrySet())
/*      */       {
/*  278 */         _output_.writeInt64(3, ((Long)_e_.getKey()).longValue());
/*  279 */         _output_.writeInt64(3, ((Long)_e_.getValue()).longValue());
/*      */       }
/*  281 */       for (Map.Entry<Long, Long> _e_ : this.offline_group_kick_infos.entrySet())
/*      */       {
/*  283 */         _output_.writeInt64(4, ((Long)_e_.getKey()).longValue());
/*  284 */         _output_.writeInt64(4, ((Long)_e_.getValue()).longValue());
/*      */       }
/*  286 */       for (Map.Entry<Long, String> _e_ : this.offline_group_dissolve_infos.entrySet())
/*      */       {
/*  288 */         _output_.writeInt64(5, ((Long)_e_.getKey()).longValue());
/*  289 */         _output_.writeBytes(5, ppbio.ByteString.copyFrom((String)_e_.getValue(), "UTF-16LE"));
/*      */       }
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  294 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  296 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  302 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  305 */       boolean done = false;
/*  306 */       while (!done)
/*      */       {
/*  308 */         int tag = _input_.readTag();
/*  309 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  313 */           done = true;
/*  314 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  318 */           long _k_ = 0L;
/*  319 */           _k_ = _input_.readInt64();
/*  320 */           int readTag = _input_.readTag();
/*  321 */           if (10 != readTag)
/*      */           {
/*  323 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  325 */           xbean.GroupSetting _v_ = new GroupSetting(0, this, "create_same_zone_groupids");
/*  326 */           _input_.readMessage(_v_);
/*  327 */           this.create_same_zone_groupids.put(Long.valueOf(_k_), _v_);
/*  328 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  332 */           long _k_ = 0L;
/*  333 */           _k_ = _input_.readInt64();
/*  334 */           int readTag = _input_.readTag();
/*  335 */           if (18 != readTag)
/*      */           {
/*  337 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  339 */           xbean.GroupSetting _v_ = new GroupSetting(0, this, "join_same_zone_groupids");
/*  340 */           _input_.readMessage(_v_);
/*  341 */           this.join_same_zone_groupids.put(Long.valueOf(_k_), _v_);
/*  342 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  346 */           long _k_ = 0L;
/*  347 */           _k_ = _input_.readInt64();
/*  348 */           int readTag = _input_.readTag();
/*  349 */           if (24 != readTag)
/*      */           {
/*  351 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  353 */           long _v_ = 0L;
/*  354 */           _v_ = _input_.readInt64();
/*  355 */           this.offline_group_join_infos.put(Long.valueOf(_k_), Long.valueOf(_v_));
/*  356 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  360 */           long _k_ = 0L;
/*  361 */           _k_ = _input_.readInt64();
/*  362 */           int readTag = _input_.readTag();
/*  363 */           if (32 != readTag)
/*      */           {
/*  365 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  367 */           long _v_ = 0L;
/*  368 */           _v_ = _input_.readInt64();
/*  369 */           this.offline_group_kick_infos.put(Long.valueOf(_k_), Long.valueOf(_v_));
/*  370 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  374 */           long _k_ = 0L;
/*  375 */           _k_ = _input_.readInt64();
/*  376 */           int readTag = _input_.readTag();
/*  377 */           if (42 != readTag)
/*      */           {
/*  379 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  381 */           String _v_ = "";
/*  382 */           _v_ = _input_.readBytes().toString("UTF-16LE");
/*  383 */           this.offline_group_dissolve_infos.put(Long.valueOf(_k_), _v_);
/*  384 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  388 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  390 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  399 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  403 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  405 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.GroupInfo copy()
/*      */   {
/*  411 */     _xdb_verify_unsafe_();
/*  412 */     return new GroupInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.GroupInfo toData()
/*      */   {
/*  418 */     _xdb_verify_unsafe_();
/*  419 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.GroupInfo toBean()
/*      */   {
/*  424 */     _xdb_verify_unsafe_();
/*  425 */     return new GroupInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.GroupInfo toDataIf()
/*      */   {
/*  431 */     _xdb_verify_unsafe_();
/*  432 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.GroupInfo toBeanIf()
/*      */   {
/*  437 */     _xdb_verify_unsafe_();
/*  438 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  444 */     _xdb_verify_unsafe_();
/*  445 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, xbean.GroupSetting> getCreate_same_zone_groupids()
/*      */   {
/*  452 */     _xdb_verify_unsafe_();
/*  453 */     return xdb.Logs.logMap(new xdb.LogKey(this, "create_same_zone_groupids"), this.create_same_zone_groupids);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, xbean.GroupSetting> getCreate_same_zone_groupidsAsData()
/*      */   {
/*  460 */     _xdb_verify_unsafe_();
/*      */     
/*  462 */     GroupInfo _o_ = this;
/*  463 */     Map<Long, xbean.GroupSetting> create_same_zone_groupids = new HashMap();
/*  464 */     for (Map.Entry<Long, xbean.GroupSetting> _e_ : _o_.create_same_zone_groupids.entrySet())
/*  465 */       create_same_zone_groupids.put(_e_.getKey(), new GroupSetting.Data((xbean.GroupSetting)_e_.getValue()));
/*  466 */     return create_same_zone_groupids;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, xbean.GroupSetting> getJoin_same_zone_groupids()
/*      */   {
/*  473 */     _xdb_verify_unsafe_();
/*  474 */     return xdb.Logs.logMap(new xdb.LogKey(this, "join_same_zone_groupids"), this.join_same_zone_groupids);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, xbean.GroupSetting> getJoin_same_zone_groupidsAsData()
/*      */   {
/*  481 */     _xdb_verify_unsafe_();
/*      */     
/*  483 */     GroupInfo _o_ = this;
/*  484 */     Map<Long, xbean.GroupSetting> join_same_zone_groupids = new HashMap();
/*  485 */     for (Map.Entry<Long, xbean.GroupSetting> _e_ : _o_.join_same_zone_groupids.entrySet())
/*  486 */       join_same_zone_groupids.put(_e_.getKey(), new GroupSetting.Data((xbean.GroupSetting)_e_.getValue()));
/*  487 */     return join_same_zone_groupids;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, Long> getOffline_group_join_infos()
/*      */   {
/*  494 */     _xdb_verify_unsafe_();
/*  495 */     return xdb.Logs.logMap(new xdb.LogKey(this, "offline_group_join_infos"), this.offline_group_join_infos);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, Long> getOffline_group_join_infosAsData()
/*      */   {
/*  502 */     _xdb_verify_unsafe_();
/*      */     
/*  504 */     GroupInfo _o_ = this;
/*  505 */     Map<Long, Long> offline_group_join_infos = new HashMap();
/*  506 */     for (Map.Entry<Long, Long> _e_ : _o_.offline_group_join_infos.entrySet())
/*  507 */       offline_group_join_infos.put(_e_.getKey(), _e_.getValue());
/*  508 */     return offline_group_join_infos;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, Long> getOffline_group_kick_infos()
/*      */   {
/*  515 */     _xdb_verify_unsafe_();
/*  516 */     return xdb.Logs.logMap(new xdb.LogKey(this, "offline_group_kick_infos"), this.offline_group_kick_infos);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, Long> getOffline_group_kick_infosAsData()
/*      */   {
/*  523 */     _xdb_verify_unsafe_();
/*      */     
/*  525 */     GroupInfo _o_ = this;
/*  526 */     Map<Long, Long> offline_group_kick_infos = new HashMap();
/*  527 */     for (Map.Entry<Long, Long> _e_ : _o_.offline_group_kick_infos.entrySet())
/*  528 */       offline_group_kick_infos.put(_e_.getKey(), _e_.getValue());
/*  529 */     return offline_group_kick_infos;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, String> getOffline_group_dissolve_infos()
/*      */   {
/*  536 */     _xdb_verify_unsafe_();
/*  537 */     return xdb.Logs.logMap(new xdb.LogKey(this, "offline_group_dissolve_infos"), this.offline_group_dissolve_infos);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, String> getOffline_group_dissolve_infosAsData()
/*      */   {
/*  544 */     _xdb_verify_unsafe_();
/*      */     
/*  546 */     GroupInfo _o_ = this;
/*  547 */     Map<Long, String> offline_group_dissolve_infos = new HashMap();
/*  548 */     for (Map.Entry<Long, String> _e_ : _o_.offline_group_dissolve_infos.entrySet())
/*  549 */       offline_group_dissolve_infos.put(_e_.getKey(), _e_.getValue());
/*  550 */     return offline_group_dissolve_infos;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  556 */     _xdb_verify_unsafe_();
/*  557 */     GroupInfo _o_ = null;
/*  558 */     if ((_o1_ instanceof GroupInfo)) { _o_ = (GroupInfo)_o1_;
/*  559 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  560 */       return false;
/*  561 */     if (!this.create_same_zone_groupids.equals(_o_.create_same_zone_groupids)) return false;
/*  562 */     if (!this.join_same_zone_groupids.equals(_o_.join_same_zone_groupids)) return false;
/*  563 */     if (!this.offline_group_join_infos.equals(_o_.offline_group_join_infos)) return false;
/*  564 */     if (!this.offline_group_kick_infos.equals(_o_.offline_group_kick_infos)) return false;
/*  565 */     if (!this.offline_group_dissolve_infos.equals(_o_.offline_group_dissolve_infos)) return false;
/*  566 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  572 */     _xdb_verify_unsafe_();
/*  573 */     int _h_ = 0;
/*  574 */     _h_ += this.create_same_zone_groupids.hashCode();
/*  575 */     _h_ += this.join_same_zone_groupids.hashCode();
/*  576 */     _h_ += this.offline_group_join_infos.hashCode();
/*  577 */     _h_ += this.offline_group_kick_infos.hashCode();
/*  578 */     _h_ += this.offline_group_dissolve_infos.hashCode();
/*  579 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  585 */     _xdb_verify_unsafe_();
/*  586 */     StringBuilder _sb_ = new StringBuilder();
/*  587 */     _sb_.append("(");
/*  588 */     _sb_.append(this.create_same_zone_groupids);
/*  589 */     _sb_.append(",");
/*  590 */     _sb_.append(this.join_same_zone_groupids);
/*  591 */     _sb_.append(",");
/*  592 */     _sb_.append(this.offline_group_join_infos);
/*  593 */     _sb_.append(",");
/*  594 */     _sb_.append(this.offline_group_kick_infos);
/*  595 */     _sb_.append(",");
/*  596 */     _sb_.append(this.offline_group_dissolve_infos);
/*  597 */     _sb_.append(")");
/*  598 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  604 */     ListenableBean lb = new ListenableBean();
/*  605 */     lb.add(new ListenableMap().setVarName("create_same_zone_groupids"));
/*  606 */     lb.add(new ListenableMap().setVarName("join_same_zone_groupids"));
/*  607 */     lb.add(new ListenableMap().setVarName("offline_group_join_infos"));
/*  608 */     lb.add(new ListenableMap().setVarName("offline_group_kick_infos"));
/*  609 */     lb.add(new ListenableMap().setVarName("offline_group_dissolve_infos"));
/*  610 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.GroupInfo {
/*      */     private Const() {}
/*      */     
/*      */     GroupInfo nThis() {
/*  617 */       return GroupInfo.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  623 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.GroupInfo copy()
/*      */     {
/*  629 */       return GroupInfo.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.GroupInfo toData()
/*      */     {
/*  635 */       return GroupInfo.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.GroupInfo toBean()
/*      */     {
/*  640 */       return GroupInfo.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.GroupInfo toDataIf()
/*      */     {
/*  646 */       return GroupInfo.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.GroupInfo toBeanIf()
/*      */     {
/*  651 */       return GroupInfo.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.GroupSetting> getCreate_same_zone_groupids()
/*      */     {
/*  658 */       GroupInfo.this._xdb_verify_unsafe_();
/*  659 */       return xdb.Consts.constMap(GroupInfo.this.create_same_zone_groupids);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.GroupSetting> getCreate_same_zone_groupidsAsData()
/*      */     {
/*  666 */       GroupInfo.this._xdb_verify_unsafe_();
/*      */       
/*  668 */       GroupInfo _o_ = GroupInfo.this;
/*  669 */       Map<Long, xbean.GroupSetting> create_same_zone_groupids = new HashMap();
/*  670 */       for (Map.Entry<Long, xbean.GroupSetting> _e_ : _o_.create_same_zone_groupids.entrySet())
/*  671 */         create_same_zone_groupids.put(_e_.getKey(), new GroupSetting.Data((xbean.GroupSetting)_e_.getValue()));
/*  672 */       return create_same_zone_groupids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.GroupSetting> getJoin_same_zone_groupids()
/*      */     {
/*  679 */       GroupInfo.this._xdb_verify_unsafe_();
/*  680 */       return xdb.Consts.constMap(GroupInfo.this.join_same_zone_groupids);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.GroupSetting> getJoin_same_zone_groupidsAsData()
/*      */     {
/*  687 */       GroupInfo.this._xdb_verify_unsafe_();
/*      */       
/*  689 */       GroupInfo _o_ = GroupInfo.this;
/*  690 */       Map<Long, xbean.GroupSetting> join_same_zone_groupids = new HashMap();
/*  691 */       for (Map.Entry<Long, xbean.GroupSetting> _e_ : _o_.join_same_zone_groupids.entrySet())
/*  692 */         join_same_zone_groupids.put(_e_.getKey(), new GroupSetting.Data((xbean.GroupSetting)_e_.getValue()));
/*  693 */       return join_same_zone_groupids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, Long> getOffline_group_join_infos()
/*      */     {
/*  700 */       GroupInfo.this._xdb_verify_unsafe_();
/*  701 */       return xdb.Consts.constMap(GroupInfo.this.offline_group_join_infos);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, Long> getOffline_group_join_infosAsData()
/*      */     {
/*  708 */       GroupInfo.this._xdb_verify_unsafe_();
/*      */       
/*  710 */       GroupInfo _o_ = GroupInfo.this;
/*  711 */       Map<Long, Long> offline_group_join_infos = new HashMap();
/*  712 */       for (Map.Entry<Long, Long> _e_ : _o_.offline_group_join_infos.entrySet())
/*  713 */         offline_group_join_infos.put(_e_.getKey(), _e_.getValue());
/*  714 */       return offline_group_join_infos;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, Long> getOffline_group_kick_infos()
/*      */     {
/*  721 */       GroupInfo.this._xdb_verify_unsafe_();
/*  722 */       return xdb.Consts.constMap(GroupInfo.this.offline_group_kick_infos);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, Long> getOffline_group_kick_infosAsData()
/*      */     {
/*  729 */       GroupInfo.this._xdb_verify_unsafe_();
/*      */       
/*  731 */       GroupInfo _o_ = GroupInfo.this;
/*  732 */       Map<Long, Long> offline_group_kick_infos = new HashMap();
/*  733 */       for (Map.Entry<Long, Long> _e_ : _o_.offline_group_kick_infos.entrySet())
/*  734 */         offline_group_kick_infos.put(_e_.getKey(), _e_.getValue());
/*  735 */       return offline_group_kick_infos;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, String> getOffline_group_dissolve_infos()
/*      */     {
/*  742 */       GroupInfo.this._xdb_verify_unsafe_();
/*  743 */       return xdb.Consts.constMap(GroupInfo.this.offline_group_dissolve_infos);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, String> getOffline_group_dissolve_infosAsData()
/*      */     {
/*  750 */       GroupInfo.this._xdb_verify_unsafe_();
/*      */       
/*  752 */       GroupInfo _o_ = GroupInfo.this;
/*  753 */       Map<Long, String> offline_group_dissolve_infos = new HashMap();
/*  754 */       for (Map.Entry<Long, String> _e_ : _o_.offline_group_dissolve_infos.entrySet())
/*  755 */         offline_group_dissolve_infos.put(_e_.getKey(), _e_.getValue());
/*  756 */       return offline_group_dissolve_infos;
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  762 */       GroupInfo.this._xdb_verify_unsafe_();
/*  763 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  769 */       GroupInfo.this._xdb_verify_unsafe_();
/*  770 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  776 */       return GroupInfo.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  782 */       return GroupInfo.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  788 */       GroupInfo.this._xdb_verify_unsafe_();
/*  789 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  795 */       return GroupInfo.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  801 */       return GroupInfo.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  807 */       GroupInfo.this._xdb_verify_unsafe_();
/*  808 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  814 */       return GroupInfo.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  820 */       return GroupInfo.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  826 */       return GroupInfo.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  832 */       return GroupInfo.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  838 */       return GroupInfo.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  844 */       return GroupInfo.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  850 */       return GroupInfo.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.GroupInfo
/*      */   {
/*      */     private HashMap<Long, xbean.GroupSetting> create_same_zone_groupids;
/*      */     
/*      */     private HashMap<Long, xbean.GroupSetting> join_same_zone_groupids;
/*      */     
/*      */     private HashMap<Long, Long> offline_group_join_infos;
/*      */     
/*      */     private HashMap<Long, Long> offline_group_kick_infos;
/*      */     
/*      */     private HashMap<Long, String> offline_group_dissolve_infos;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  870 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  875 */       this.create_same_zone_groupids = new HashMap();
/*  876 */       this.join_same_zone_groupids = new HashMap();
/*  877 */       this.offline_group_join_infos = new HashMap();
/*  878 */       this.offline_group_kick_infos = new HashMap();
/*  879 */       this.offline_group_dissolve_infos = new HashMap();
/*      */     }
/*      */     
/*      */     Data(xbean.GroupInfo _o1_)
/*      */     {
/*  884 */       if ((_o1_ instanceof GroupInfo)) { assign((GroupInfo)_o1_);
/*  885 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  886 */       } else if ((_o1_ instanceof GroupInfo.Const)) assign(((GroupInfo.Const)_o1_).nThis()); else {
/*  887 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(GroupInfo _o_) {
/*  892 */       this.create_same_zone_groupids = new HashMap();
/*  893 */       for (Map.Entry<Long, xbean.GroupSetting> _e_ : _o_.create_same_zone_groupids.entrySet())
/*  894 */         this.create_same_zone_groupids.put(_e_.getKey(), new GroupSetting.Data((xbean.GroupSetting)_e_.getValue()));
/*  895 */       this.join_same_zone_groupids = new HashMap();
/*  896 */       for (Map.Entry<Long, xbean.GroupSetting> _e_ : _o_.join_same_zone_groupids.entrySet())
/*  897 */         this.join_same_zone_groupids.put(_e_.getKey(), new GroupSetting.Data((xbean.GroupSetting)_e_.getValue()));
/*  898 */       this.offline_group_join_infos = new HashMap();
/*  899 */       for (Map.Entry<Long, Long> _e_ : _o_.offline_group_join_infos.entrySet())
/*  900 */         this.offline_group_join_infos.put(_e_.getKey(), _e_.getValue());
/*  901 */       this.offline_group_kick_infos = new HashMap();
/*  902 */       for (Map.Entry<Long, Long> _e_ : _o_.offline_group_kick_infos.entrySet())
/*  903 */         this.offline_group_kick_infos.put(_e_.getKey(), _e_.getValue());
/*  904 */       this.offline_group_dissolve_infos = new HashMap();
/*  905 */       for (Map.Entry<Long, String> _e_ : _o_.offline_group_dissolve_infos.entrySet()) {
/*  906 */         this.offline_group_dissolve_infos.put(_e_.getKey(), _e_.getValue());
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(Data _o_) {
/*  911 */       this.create_same_zone_groupids = new HashMap();
/*  912 */       for (Map.Entry<Long, xbean.GroupSetting> _e_ : _o_.create_same_zone_groupids.entrySet())
/*  913 */         this.create_same_zone_groupids.put(_e_.getKey(), new GroupSetting.Data((xbean.GroupSetting)_e_.getValue()));
/*  914 */       this.join_same_zone_groupids = new HashMap();
/*  915 */       for (Map.Entry<Long, xbean.GroupSetting> _e_ : _o_.join_same_zone_groupids.entrySet())
/*  916 */         this.join_same_zone_groupids.put(_e_.getKey(), new GroupSetting.Data((xbean.GroupSetting)_e_.getValue()));
/*  917 */       this.offline_group_join_infos = new HashMap();
/*  918 */       for (Map.Entry<Long, Long> _e_ : _o_.offline_group_join_infos.entrySet())
/*  919 */         this.offline_group_join_infos.put(_e_.getKey(), _e_.getValue());
/*  920 */       this.offline_group_kick_infos = new HashMap();
/*  921 */       for (Map.Entry<Long, Long> _e_ : _o_.offline_group_kick_infos.entrySet())
/*  922 */         this.offline_group_kick_infos.put(_e_.getKey(), _e_.getValue());
/*  923 */       this.offline_group_dissolve_infos = new HashMap();
/*  924 */       for (Map.Entry<Long, String> _e_ : _o_.offline_group_dissolve_infos.entrySet()) {
/*  925 */         this.offline_group_dissolve_infos.put(_e_.getKey(), _e_.getValue());
/*      */       }
/*      */     }
/*      */     
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  931 */       _os_.compact_uint32(this.create_same_zone_groupids.size());
/*  932 */       for (Map.Entry<Long, xbean.GroupSetting> _e_ : this.create_same_zone_groupids.entrySet())
/*      */       {
/*  934 */         _os_.marshal(((Long)_e_.getKey()).longValue());
/*  935 */         ((xbean.GroupSetting)_e_.getValue()).marshal(_os_);
/*      */       }
/*  937 */       _os_.compact_uint32(this.join_same_zone_groupids.size());
/*  938 */       for (Map.Entry<Long, xbean.GroupSetting> _e_ : this.join_same_zone_groupids.entrySet())
/*      */       {
/*  940 */         _os_.marshal(((Long)_e_.getKey()).longValue());
/*  941 */         ((xbean.GroupSetting)_e_.getValue()).marshal(_os_);
/*      */       }
/*  943 */       _os_.compact_uint32(this.offline_group_join_infos.size());
/*  944 */       for (Map.Entry<Long, Long> _e_ : this.offline_group_join_infos.entrySet())
/*      */       {
/*  946 */         _os_.marshal(((Long)_e_.getKey()).longValue());
/*  947 */         _os_.marshal(((Long)_e_.getValue()).longValue());
/*      */       }
/*  949 */       _os_.compact_uint32(this.offline_group_kick_infos.size());
/*  950 */       for (Map.Entry<Long, Long> _e_ : this.offline_group_kick_infos.entrySet())
/*      */       {
/*  952 */         _os_.marshal(((Long)_e_.getKey()).longValue());
/*  953 */         _os_.marshal(((Long)_e_.getValue()).longValue());
/*      */       }
/*  955 */       _os_.compact_uint32(this.offline_group_dissolve_infos.size());
/*  956 */       for (Map.Entry<Long, String> _e_ : this.offline_group_dissolve_infos.entrySet())
/*      */       {
/*  958 */         _os_.marshal(((Long)_e_.getKey()).longValue());
/*  959 */         _os_.marshal((String)_e_.getValue(), "UTF-16LE");
/*      */       }
/*  961 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  968 */       int size = _os_.uncompact_uint32();
/*  969 */       if (size >= 12)
/*      */       {
/*  971 */         this.create_same_zone_groupids = new HashMap(size * 2);
/*      */       }
/*  973 */       for (; size > 0; size--)
/*      */       {
/*  975 */         long _k_ = 0L;
/*  976 */         _k_ = _os_.unmarshal_long();
/*  977 */         xbean.GroupSetting _v_ = xbean.Pod.newGroupSettingData();
/*  978 */         _v_.unmarshal(_os_);
/*  979 */         this.create_same_zone_groupids.put(Long.valueOf(_k_), _v_);
/*      */       }
/*      */       
/*      */ 
/*  983 */       int size = _os_.uncompact_uint32();
/*  984 */       if (size >= 12)
/*      */       {
/*  986 */         this.join_same_zone_groupids = new HashMap(size * 2);
/*      */       }
/*  988 */       for (; size > 0; size--)
/*      */       {
/*  990 */         long _k_ = 0L;
/*  991 */         _k_ = _os_.unmarshal_long();
/*  992 */         xbean.GroupSetting _v_ = xbean.Pod.newGroupSettingData();
/*  993 */         _v_.unmarshal(_os_);
/*  994 */         this.join_same_zone_groupids.put(Long.valueOf(_k_), _v_);
/*      */       }
/*      */       
/*      */ 
/*  998 */       int size = _os_.uncompact_uint32();
/*  999 */       if (size >= 12)
/*      */       {
/* 1001 */         this.offline_group_join_infos = new HashMap(size * 2);
/*      */       }
/* 1003 */       for (; size > 0; size--)
/*      */       {
/* 1005 */         long _k_ = 0L;
/* 1006 */         _k_ = _os_.unmarshal_long();
/* 1007 */         long _v_ = 0L;
/* 1008 */         _v_ = _os_.unmarshal_long();
/* 1009 */         this.offline_group_join_infos.put(Long.valueOf(_k_), Long.valueOf(_v_));
/*      */       }
/*      */       
/*      */ 
/* 1013 */       int size = _os_.uncompact_uint32();
/* 1014 */       if (size >= 12)
/*      */       {
/* 1016 */         this.offline_group_kick_infos = new HashMap(size * 2);
/*      */       }
/* 1018 */       for (; size > 0; size--)
/*      */       {
/* 1020 */         long _k_ = 0L;
/* 1021 */         _k_ = _os_.unmarshal_long();
/* 1022 */         long _v_ = 0L;
/* 1023 */         _v_ = _os_.unmarshal_long();
/* 1024 */         this.offline_group_kick_infos.put(Long.valueOf(_k_), Long.valueOf(_v_));
/*      */       }
/*      */       
/*      */ 
/* 1028 */       int size = _os_.uncompact_uint32();
/* 1029 */       if (size >= 12)
/*      */       {
/* 1031 */         this.offline_group_dissolve_infos = new HashMap(size * 2);
/*      */       }
/* 1033 */       for (; size > 0; size--)
/*      */       {
/* 1035 */         long _k_ = 0L;
/* 1036 */         _k_ = _os_.unmarshal_long();
/* 1037 */         String _v_ = "";
/* 1038 */         _v_ = _os_.unmarshal_String("UTF-16LE");
/* 1039 */         this.offline_group_dissolve_infos.put(Long.valueOf(_k_), _v_);
/*      */       }
/*      */       
/* 1042 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/* 1048 */       int _size_ = 0;
/* 1049 */       for (Map.Entry<Long, xbean.GroupSetting> _e_ : this.create_same_zone_groupids.entrySet())
/*      */       {
/* 1051 */         _size_ += CodedOutputStream.computeInt64Size(1, ((Long)_e_.getKey()).longValue());
/* 1052 */         _size_ += CodedOutputStream.computeMessageSize(1, (Message)_e_.getValue());
/*      */       }
/* 1054 */       for (Map.Entry<Long, xbean.GroupSetting> _e_ : this.join_same_zone_groupids.entrySet())
/*      */       {
/* 1056 */         _size_ += CodedOutputStream.computeInt64Size(2, ((Long)_e_.getKey()).longValue());
/* 1057 */         _size_ += CodedOutputStream.computeMessageSize(2, (Message)_e_.getValue());
/*      */       }
/* 1059 */       for (Map.Entry<Long, Long> _e_ : this.offline_group_join_infos.entrySet())
/*      */       {
/* 1061 */         _size_ += CodedOutputStream.computeInt64Size(3, ((Long)_e_.getKey()).longValue());
/* 1062 */         _size_ += CodedOutputStream.computeInt64Size(3, ((Long)_e_.getValue()).longValue());
/*      */       }
/* 1064 */       for (Map.Entry<Long, Long> _e_ : this.offline_group_kick_infos.entrySet())
/*      */       {
/* 1066 */         _size_ += CodedOutputStream.computeInt64Size(4, ((Long)_e_.getKey()).longValue());
/* 1067 */         _size_ += CodedOutputStream.computeInt64Size(4, ((Long)_e_.getValue()).longValue());
/*      */       }
/* 1069 */       for (Map.Entry<Long, String> _e_ : this.offline_group_dissolve_infos.entrySet())
/*      */       {
/* 1071 */         _size_ += CodedOutputStream.computeInt64Size(5, ((Long)_e_.getKey()).longValue());
/*      */         try
/*      */         {
/* 1074 */           _size_ += CodedOutputStream.computeBytesSize(5, ppbio.ByteString.copyFrom((String)_e_.getValue(), "UTF-16LE"));
/*      */         }
/*      */         catch (java.io.UnsupportedEncodingException e)
/*      */         {
/* 1078 */           throw new RuntimeException("UTF-16LE not supported?", e);
/*      */         }
/*      */       }
/* 1081 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1089 */         for (Map.Entry<Long, xbean.GroupSetting> _e_ : this.create_same_zone_groupids.entrySet())
/*      */         {
/* 1091 */           _output_.writeInt64(1, ((Long)_e_.getKey()).longValue());
/* 1092 */           _output_.writeMessage(1, (Message)_e_.getValue());
/*      */         }
/* 1094 */         for (Map.Entry<Long, xbean.GroupSetting> _e_ : this.join_same_zone_groupids.entrySet())
/*      */         {
/* 1096 */           _output_.writeInt64(2, ((Long)_e_.getKey()).longValue());
/* 1097 */           _output_.writeMessage(2, (Message)_e_.getValue());
/*      */         }
/* 1099 */         for (Map.Entry<Long, Long> _e_ : this.offline_group_join_infos.entrySet())
/*      */         {
/* 1101 */           _output_.writeInt64(3, ((Long)_e_.getKey()).longValue());
/* 1102 */           _output_.writeInt64(3, ((Long)_e_.getValue()).longValue());
/*      */         }
/* 1104 */         for (Map.Entry<Long, Long> _e_ : this.offline_group_kick_infos.entrySet())
/*      */         {
/* 1106 */           _output_.writeInt64(4, ((Long)_e_.getKey()).longValue());
/* 1107 */           _output_.writeInt64(4, ((Long)_e_.getValue()).longValue());
/*      */         }
/* 1109 */         for (Map.Entry<Long, String> _e_ : this.offline_group_dissolve_infos.entrySet())
/*      */         {
/* 1111 */           _output_.writeInt64(5, ((Long)_e_.getKey()).longValue());
/* 1112 */           _output_.writeBytes(5, ppbio.ByteString.copyFrom((String)_e_.getValue(), "UTF-16LE"));
/*      */         }
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1117 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1119 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1127 */         boolean done = false;
/* 1128 */         while (!done)
/*      */         {
/* 1130 */           int tag = _input_.readTag();
/* 1131 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/* 1135 */             done = true;
/* 1136 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/* 1140 */             long _k_ = 0L;
/* 1141 */             _k_ = _input_.readInt64();
/* 1142 */             int readTag = _input_.readTag();
/* 1143 */             if (10 != readTag)
/*      */             {
/* 1145 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 1147 */             xbean.GroupSetting _v_ = xbean.Pod.newGroupSettingData();
/* 1148 */             _input_.readMessage(_v_);
/* 1149 */             this.create_same_zone_groupids.put(Long.valueOf(_k_), _v_);
/* 1150 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/* 1154 */             long _k_ = 0L;
/* 1155 */             _k_ = _input_.readInt64();
/* 1156 */             int readTag = _input_.readTag();
/* 1157 */             if (18 != readTag)
/*      */             {
/* 1159 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 1161 */             xbean.GroupSetting _v_ = xbean.Pod.newGroupSettingData();
/* 1162 */             _input_.readMessage(_v_);
/* 1163 */             this.join_same_zone_groupids.put(Long.valueOf(_k_), _v_);
/* 1164 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/* 1168 */             long _k_ = 0L;
/* 1169 */             _k_ = _input_.readInt64();
/* 1170 */             int readTag = _input_.readTag();
/* 1171 */             if (24 != readTag)
/*      */             {
/* 1173 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 1175 */             long _v_ = 0L;
/* 1176 */             _v_ = _input_.readInt64();
/* 1177 */             this.offline_group_join_infos.put(Long.valueOf(_k_), Long.valueOf(_v_));
/* 1178 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/* 1182 */             long _k_ = 0L;
/* 1183 */             _k_ = _input_.readInt64();
/* 1184 */             int readTag = _input_.readTag();
/* 1185 */             if (32 != readTag)
/*      */             {
/* 1187 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 1189 */             long _v_ = 0L;
/* 1190 */             _v_ = _input_.readInt64();
/* 1191 */             this.offline_group_kick_infos.put(Long.valueOf(_k_), Long.valueOf(_v_));
/* 1192 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/* 1196 */             long _k_ = 0L;
/* 1197 */             _k_ = _input_.readInt64();
/* 1198 */             int readTag = _input_.readTag();
/* 1199 */             if (42 != readTag)
/*      */             {
/* 1201 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 1203 */             String _v_ = "";
/* 1204 */             _v_ = _input_.readBytes().toString("UTF-16LE");
/* 1205 */             this.offline_group_dissolve_infos.put(Long.valueOf(_k_), _v_);
/* 1206 */             break;
/*      */           
/*      */ 
/*      */           default: 
/* 1210 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/* 1212 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/* 1221 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1225 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1227 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.GroupInfo copy()
/*      */     {
/* 1233 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.GroupInfo toData()
/*      */     {
/* 1239 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.GroupInfo toBean()
/*      */     {
/* 1244 */       return new GroupInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.GroupInfo toDataIf()
/*      */     {
/* 1250 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.GroupInfo toBeanIf()
/*      */     {
/* 1255 */       return new GroupInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1261 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/* 1265 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1269 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1273 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/* 1277 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1281 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1285 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.GroupSetting> getCreate_same_zone_groupids()
/*      */     {
/* 1292 */       return this.create_same_zone_groupids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.GroupSetting> getCreate_same_zone_groupidsAsData()
/*      */     {
/* 1299 */       return this.create_same_zone_groupids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.GroupSetting> getJoin_same_zone_groupids()
/*      */     {
/* 1306 */       return this.join_same_zone_groupids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.GroupSetting> getJoin_same_zone_groupidsAsData()
/*      */     {
/* 1313 */       return this.join_same_zone_groupids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, Long> getOffline_group_join_infos()
/*      */     {
/* 1320 */       return this.offline_group_join_infos;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, Long> getOffline_group_join_infosAsData()
/*      */     {
/* 1327 */       return this.offline_group_join_infos;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, Long> getOffline_group_kick_infos()
/*      */     {
/* 1334 */       return this.offline_group_kick_infos;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, Long> getOffline_group_kick_infosAsData()
/*      */     {
/* 1341 */       return this.offline_group_kick_infos;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, String> getOffline_group_dissolve_infos()
/*      */     {
/* 1348 */       return this.offline_group_dissolve_infos;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, String> getOffline_group_dissolve_infosAsData()
/*      */     {
/* 1355 */       return this.offline_group_dissolve_infos;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1361 */       if (!(_o1_ instanceof Data)) return false;
/* 1362 */       Data _o_ = (Data)_o1_;
/* 1363 */       if (!this.create_same_zone_groupids.equals(_o_.create_same_zone_groupids)) return false;
/* 1364 */       if (!this.join_same_zone_groupids.equals(_o_.join_same_zone_groupids)) return false;
/* 1365 */       if (!this.offline_group_join_infos.equals(_o_.offline_group_join_infos)) return false;
/* 1366 */       if (!this.offline_group_kick_infos.equals(_o_.offline_group_kick_infos)) return false;
/* 1367 */       if (!this.offline_group_dissolve_infos.equals(_o_.offline_group_dissolve_infos)) return false;
/* 1368 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1374 */       int _h_ = 0;
/* 1375 */       _h_ += this.create_same_zone_groupids.hashCode();
/* 1376 */       _h_ += this.join_same_zone_groupids.hashCode();
/* 1377 */       _h_ += this.offline_group_join_infos.hashCode();
/* 1378 */       _h_ += this.offline_group_kick_infos.hashCode();
/* 1379 */       _h_ += this.offline_group_dissolve_infos.hashCode();
/* 1380 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1386 */       StringBuilder _sb_ = new StringBuilder();
/* 1387 */       _sb_.append("(");
/* 1388 */       _sb_.append(this.create_same_zone_groupids);
/* 1389 */       _sb_.append(",");
/* 1390 */       _sb_.append(this.join_same_zone_groupids);
/* 1391 */       _sb_.append(",");
/* 1392 */       _sb_.append(this.offline_group_join_infos);
/* 1393 */       _sb_.append(",");
/* 1394 */       _sb_.append(this.offline_group_kick_infos);
/* 1395 */       _sb_.append(",");
/* 1396 */       _sb_.append(this.offline_group_dissolve_infos);
/* 1397 */       _sb_.append(")");
/* 1398 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\GroupInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */