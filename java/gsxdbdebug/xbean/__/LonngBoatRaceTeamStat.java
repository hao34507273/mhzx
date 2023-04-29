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
/*      */ import xdb.Log;
/*      */ import xdb.LogKey;
/*      */ import xdb.Logs;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableChanged;
/*      */ import xdb.logs.ListenableMap;
/*      */ 
/*      */ public final class LonngBoatRaceTeamStat extends XBean implements xbean.LonngBoatRaceTeamStat
/*      */ {
/*      */   private float speed;
/*      */   private float location;
/*      */   private int eventtypeid;
/*      */   private int eventid;
/*      */   private int eventtriggerid;
/*      */   private long endtimestamp;
/*      */   private HashMap<Long, xbean.LonngBoatRaceStat> role2stat;
/*      */   private HashMap<Long, xbean.LonngBoatRaceStat> role2stat_phase;
/*      */   private HashMap<Long, Boolean> role2isright_times;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   34 */     this.speed = 0.0F;
/*   35 */     this.location = 0.0F;
/*   36 */     this.eventtypeid = 0;
/*   37 */     this.eventid = 0;
/*   38 */     this.eventtriggerid = 0;
/*   39 */     this.endtimestamp = 0L;
/*   40 */     this.role2stat.clear();
/*   41 */     this.role2stat_phase.clear();
/*   42 */     this.role2isright_times.clear();
/*      */   }
/*      */   
/*      */   LonngBoatRaceTeamStat(int __, XBean _xp_, String _vn_)
/*      */   {
/*   47 */     super(_xp_, _vn_);
/*   48 */     this.role2stat = new HashMap();
/*   49 */     this.role2stat_phase = new HashMap();
/*   50 */     this.role2isright_times = new HashMap();
/*      */   }
/*      */   
/*      */   public LonngBoatRaceTeamStat()
/*      */   {
/*   55 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public LonngBoatRaceTeamStat(LonngBoatRaceTeamStat _o_)
/*      */   {
/*   60 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   LonngBoatRaceTeamStat(xbean.LonngBoatRaceTeamStat _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   65 */     super(_xp_, _vn_);
/*   66 */     if ((_o1_ instanceof LonngBoatRaceTeamStat)) { assign((LonngBoatRaceTeamStat)_o1_);
/*   67 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   68 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   69 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(LonngBoatRaceTeamStat _o_) {
/*   74 */     _o_._xdb_verify_unsafe_();
/*   75 */     this.speed = _o_.speed;
/*   76 */     this.location = _o_.location;
/*   77 */     this.eventtypeid = _o_.eventtypeid;
/*   78 */     this.eventid = _o_.eventid;
/*   79 */     this.eventtriggerid = _o_.eventtriggerid;
/*   80 */     this.endtimestamp = _o_.endtimestamp;
/*   81 */     this.role2stat = new HashMap();
/*   82 */     for (Map.Entry<Long, xbean.LonngBoatRaceStat> _e_ : _o_.role2stat.entrySet())
/*   83 */       this.role2stat.put(_e_.getKey(), new LonngBoatRaceStat((xbean.LonngBoatRaceStat)_e_.getValue(), this, "role2stat"));
/*   84 */     this.role2stat_phase = new HashMap();
/*   85 */     for (Map.Entry<Long, xbean.LonngBoatRaceStat> _e_ : _o_.role2stat_phase.entrySet())
/*   86 */       this.role2stat_phase.put(_e_.getKey(), new LonngBoatRaceStat((xbean.LonngBoatRaceStat)_e_.getValue(), this, "role2stat_phase"));
/*   87 */     this.role2isright_times = new HashMap();
/*   88 */     for (Map.Entry<Long, Boolean> _e_ : _o_.role2isright_times.entrySet()) {
/*   89 */       this.role2isright_times.put(_e_.getKey(), _e_.getValue());
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(Data _o_) {
/*   94 */     this.speed = _o_.speed;
/*   95 */     this.location = _o_.location;
/*   96 */     this.eventtypeid = _o_.eventtypeid;
/*   97 */     this.eventid = _o_.eventid;
/*   98 */     this.eventtriggerid = _o_.eventtriggerid;
/*   99 */     this.endtimestamp = _o_.endtimestamp;
/*  100 */     this.role2stat = new HashMap();
/*  101 */     for (Map.Entry<Long, xbean.LonngBoatRaceStat> _e_ : _o_.role2stat.entrySet())
/*  102 */       this.role2stat.put(_e_.getKey(), new LonngBoatRaceStat((xbean.LonngBoatRaceStat)_e_.getValue(), this, "role2stat"));
/*  103 */     this.role2stat_phase = new HashMap();
/*  104 */     for (Map.Entry<Long, xbean.LonngBoatRaceStat> _e_ : _o_.role2stat_phase.entrySet())
/*  105 */       this.role2stat_phase.put(_e_.getKey(), new LonngBoatRaceStat((xbean.LonngBoatRaceStat)_e_.getValue(), this, "role2stat_phase"));
/*  106 */     this.role2isright_times = new HashMap();
/*  107 */     for (Map.Entry<Long, Boolean> _e_ : _o_.role2isright_times.entrySet()) {
/*  108 */       this.role2isright_times.put(_e_.getKey(), _e_.getValue());
/*      */     }
/*      */   }
/*      */   
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*  114 */     _xdb_verify_unsafe_();
/*  115 */     _os_.marshal(this.speed);
/*  116 */     _os_.marshal(this.location);
/*  117 */     _os_.marshal(this.eventtypeid);
/*  118 */     _os_.marshal(this.eventid);
/*  119 */     _os_.marshal(this.eventtriggerid);
/*  120 */     _os_.marshal(this.endtimestamp);
/*  121 */     _os_.compact_uint32(this.role2stat.size());
/*  122 */     for (Map.Entry<Long, xbean.LonngBoatRaceStat> _e_ : this.role2stat.entrySet())
/*      */     {
/*  124 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  125 */       ((xbean.LonngBoatRaceStat)_e_.getValue()).marshal(_os_);
/*      */     }
/*  127 */     _os_.compact_uint32(this.role2stat_phase.size());
/*  128 */     for (Map.Entry<Long, xbean.LonngBoatRaceStat> _e_ : this.role2stat_phase.entrySet())
/*      */     {
/*  130 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  131 */       ((xbean.LonngBoatRaceStat)_e_.getValue()).marshal(_os_);
/*      */     }
/*  133 */     _os_.compact_uint32(this.role2isright_times.size());
/*  134 */     for (Map.Entry<Long, Boolean> _e_ : this.role2isright_times.entrySet())
/*      */     {
/*  136 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  137 */       _os_.marshal(((Boolean)_e_.getValue()).booleanValue());
/*      */     }
/*  139 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  145 */     _xdb_verify_unsafe_();
/*  146 */     this.speed = _os_.unmarshal_float();
/*  147 */     this.location = _os_.unmarshal_float();
/*  148 */     this.eventtypeid = _os_.unmarshal_int();
/*  149 */     this.eventid = _os_.unmarshal_int();
/*  150 */     this.eventtriggerid = _os_.unmarshal_int();
/*  151 */     this.endtimestamp = _os_.unmarshal_long();
/*      */     
/*  153 */     int size = _os_.uncompact_uint32();
/*  154 */     if (size >= 12)
/*      */     {
/*  156 */       this.role2stat = new HashMap(size * 2);
/*      */     }
/*  158 */     for (; size > 0; size--)
/*      */     {
/*  160 */       long _k_ = 0L;
/*  161 */       _k_ = _os_.unmarshal_long();
/*  162 */       xbean.LonngBoatRaceStat _v_ = new LonngBoatRaceStat(0, this, "role2stat");
/*  163 */       _v_.unmarshal(_os_);
/*  164 */       this.role2stat.put(Long.valueOf(_k_), _v_);
/*      */     }
/*      */     
/*      */ 
/*  168 */     int size = _os_.uncompact_uint32();
/*  169 */     if (size >= 12)
/*      */     {
/*  171 */       this.role2stat_phase = new HashMap(size * 2);
/*      */     }
/*  173 */     for (; size > 0; size--)
/*      */     {
/*  175 */       long _k_ = 0L;
/*  176 */       _k_ = _os_.unmarshal_long();
/*  177 */       xbean.LonngBoatRaceStat _v_ = new LonngBoatRaceStat(0, this, "role2stat_phase");
/*  178 */       _v_.unmarshal(_os_);
/*  179 */       this.role2stat_phase.put(Long.valueOf(_k_), _v_);
/*      */     }
/*      */     
/*      */ 
/*  183 */     int size = _os_.uncompact_uint32();
/*  184 */     if (size >= 12)
/*      */     {
/*  186 */       this.role2isright_times = new HashMap(size * 2);
/*      */     }
/*  188 */     for (; size > 0; size--)
/*      */     {
/*  190 */       long _k_ = 0L;
/*  191 */       _k_ = _os_.unmarshal_long();
/*  192 */       boolean _v_ = false;
/*  193 */       _v_ = _os_.unmarshal_boolean();
/*  194 */       this.role2isright_times.put(Long.valueOf(_k_), Boolean.valueOf(_v_));
/*      */     }
/*      */     
/*  197 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  203 */     _xdb_verify_unsafe_();
/*  204 */     int _size_ = 0;
/*  205 */     _size_ += CodedOutputStream.computeFloatSize(1, this.speed);
/*  206 */     _size_ += CodedOutputStream.computeFloatSize(2, this.location);
/*  207 */     _size_ += CodedOutputStream.computeInt32Size(3, this.eventtypeid);
/*  208 */     _size_ += CodedOutputStream.computeInt32Size(4, this.eventid);
/*  209 */     _size_ += CodedOutputStream.computeInt32Size(5, this.eventtriggerid);
/*  210 */     _size_ += CodedOutputStream.computeInt64Size(6, this.endtimestamp);
/*  211 */     for (Map.Entry<Long, xbean.LonngBoatRaceStat> _e_ : this.role2stat.entrySet())
/*      */     {
/*  213 */       _size_ += CodedOutputStream.computeInt64Size(7, ((Long)_e_.getKey()).longValue());
/*  214 */       _size_ += CodedOutputStream.computeMessageSize(7, (Message)_e_.getValue());
/*      */     }
/*  216 */     for (Map.Entry<Long, xbean.LonngBoatRaceStat> _e_ : this.role2stat_phase.entrySet())
/*      */     {
/*  218 */       _size_ += CodedOutputStream.computeInt64Size(8, ((Long)_e_.getKey()).longValue());
/*  219 */       _size_ += CodedOutputStream.computeMessageSize(8, (Message)_e_.getValue());
/*      */     }
/*  221 */     for (Map.Entry<Long, Boolean> _e_ : this.role2isright_times.entrySet())
/*      */     {
/*  223 */       _size_ += CodedOutputStream.computeInt64Size(9, ((Long)_e_.getKey()).longValue());
/*  224 */       _size_ += CodedOutputStream.computeBoolSize(9, ((Boolean)_e_.getValue()).booleanValue());
/*      */     }
/*  226 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  232 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  235 */       _output_.writeFloat(1, this.speed);
/*  236 */       _output_.writeFloat(2, this.location);
/*  237 */       _output_.writeInt32(3, this.eventtypeid);
/*  238 */       _output_.writeInt32(4, this.eventid);
/*  239 */       _output_.writeInt32(5, this.eventtriggerid);
/*  240 */       _output_.writeInt64(6, this.endtimestamp);
/*  241 */       for (Map.Entry<Long, xbean.LonngBoatRaceStat> _e_ : this.role2stat.entrySet())
/*      */       {
/*  243 */         _output_.writeInt64(7, ((Long)_e_.getKey()).longValue());
/*  244 */         _output_.writeMessage(7, (Message)_e_.getValue());
/*      */       }
/*  246 */       for (Map.Entry<Long, xbean.LonngBoatRaceStat> _e_ : this.role2stat_phase.entrySet())
/*      */       {
/*  248 */         _output_.writeInt64(8, ((Long)_e_.getKey()).longValue());
/*  249 */         _output_.writeMessage(8, (Message)_e_.getValue());
/*      */       }
/*  251 */       for (Map.Entry<Long, Boolean> _e_ : this.role2isright_times.entrySet())
/*      */       {
/*  253 */         _output_.writeInt64(9, ((Long)_e_.getKey()).longValue());
/*  254 */         _output_.writeBool(9, ((Boolean)_e_.getValue()).booleanValue());
/*      */       }
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  259 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  261 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  267 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  270 */       boolean done = false;
/*  271 */       while (!done)
/*      */       {
/*  273 */         int tag = _input_.readTag();
/*  274 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  278 */           done = true;
/*  279 */           break;
/*      */         
/*      */ 
/*      */         case 13: 
/*  283 */           this.speed = _input_.readFloat();
/*  284 */           break;
/*      */         
/*      */ 
/*      */         case 21: 
/*  288 */           this.location = _input_.readFloat();
/*  289 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  293 */           this.eventtypeid = _input_.readInt32();
/*  294 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  298 */           this.eventid = _input_.readInt32();
/*  299 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  303 */           this.eventtriggerid = _input_.readInt32();
/*  304 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  308 */           this.endtimestamp = _input_.readInt64();
/*  309 */           break;
/*      */         
/*      */ 
/*      */         case 56: 
/*  313 */           long _k_ = 0L;
/*  314 */           _k_ = _input_.readInt64();
/*  315 */           int readTag = _input_.readTag();
/*  316 */           if (58 != readTag)
/*      */           {
/*  318 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  320 */           xbean.LonngBoatRaceStat _v_ = new LonngBoatRaceStat(0, this, "role2stat");
/*  321 */           _input_.readMessage(_v_);
/*  322 */           this.role2stat.put(Long.valueOf(_k_), _v_);
/*  323 */           break;
/*      */         
/*      */ 
/*      */         case 64: 
/*  327 */           long _k_ = 0L;
/*  328 */           _k_ = _input_.readInt64();
/*  329 */           int readTag = _input_.readTag();
/*  330 */           if (66 != readTag)
/*      */           {
/*  332 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  334 */           xbean.LonngBoatRaceStat _v_ = new LonngBoatRaceStat(0, this, "role2stat_phase");
/*  335 */           _input_.readMessage(_v_);
/*  336 */           this.role2stat_phase.put(Long.valueOf(_k_), _v_);
/*  337 */           break;
/*      */         
/*      */ 
/*      */         case 72: 
/*  341 */           long _k_ = 0L;
/*  342 */           _k_ = _input_.readInt64();
/*  343 */           int readTag = _input_.readTag();
/*  344 */           if (72 != readTag)
/*      */           {
/*  346 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  348 */           boolean _v_ = false;
/*  349 */           _v_ = _input_.readBool();
/*  350 */           this.role2isright_times.put(Long.valueOf(_k_), Boolean.valueOf(_v_));
/*  351 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  355 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  357 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  366 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  370 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  372 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.LonngBoatRaceTeamStat copy()
/*      */   {
/*  378 */     _xdb_verify_unsafe_();
/*  379 */     return new LonngBoatRaceTeamStat(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.LonngBoatRaceTeamStat toData()
/*      */   {
/*  385 */     _xdb_verify_unsafe_();
/*  386 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.LonngBoatRaceTeamStat toBean()
/*      */   {
/*  391 */     _xdb_verify_unsafe_();
/*  392 */     return new LonngBoatRaceTeamStat(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.LonngBoatRaceTeamStat toDataIf()
/*      */   {
/*  398 */     _xdb_verify_unsafe_();
/*  399 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.LonngBoatRaceTeamStat toBeanIf()
/*      */   {
/*  404 */     _xdb_verify_unsafe_();
/*  405 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  411 */     _xdb_verify_unsafe_();
/*  412 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public float getSpeed()
/*      */   {
/*  419 */     _xdb_verify_unsafe_();
/*  420 */     return this.speed;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public float getLocation()
/*      */   {
/*  427 */     _xdb_verify_unsafe_();
/*  428 */     return this.location;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getEventtypeid()
/*      */   {
/*  435 */     _xdb_verify_unsafe_();
/*  436 */     return this.eventtypeid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getEventid()
/*      */   {
/*  443 */     _xdb_verify_unsafe_();
/*  444 */     return this.eventid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getEventtriggerid()
/*      */   {
/*  451 */     _xdb_verify_unsafe_();
/*  452 */     return this.eventtriggerid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getEndtimestamp()
/*      */   {
/*  459 */     _xdb_verify_unsafe_();
/*  460 */     return this.endtimestamp;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, xbean.LonngBoatRaceStat> getRole2stat()
/*      */   {
/*  467 */     _xdb_verify_unsafe_();
/*  468 */     return Logs.logMap(new LogKey(this, "role2stat"), this.role2stat);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, xbean.LonngBoatRaceStat> getRole2statAsData()
/*      */   {
/*  475 */     _xdb_verify_unsafe_();
/*      */     
/*  477 */     LonngBoatRaceTeamStat _o_ = this;
/*  478 */     Map<Long, xbean.LonngBoatRaceStat> role2stat = new HashMap();
/*  479 */     for (Map.Entry<Long, xbean.LonngBoatRaceStat> _e_ : _o_.role2stat.entrySet())
/*  480 */       role2stat.put(_e_.getKey(), new LonngBoatRaceStat.Data((xbean.LonngBoatRaceStat)_e_.getValue()));
/*  481 */     return role2stat;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, xbean.LonngBoatRaceStat> getRole2stat_phase()
/*      */   {
/*  488 */     _xdb_verify_unsafe_();
/*  489 */     return Logs.logMap(new LogKey(this, "role2stat_phase"), this.role2stat_phase);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, xbean.LonngBoatRaceStat> getRole2stat_phaseAsData()
/*      */   {
/*  496 */     _xdb_verify_unsafe_();
/*      */     
/*  498 */     LonngBoatRaceTeamStat _o_ = this;
/*  499 */     Map<Long, xbean.LonngBoatRaceStat> role2stat_phase = new HashMap();
/*  500 */     for (Map.Entry<Long, xbean.LonngBoatRaceStat> _e_ : _o_.role2stat_phase.entrySet())
/*  501 */       role2stat_phase.put(_e_.getKey(), new LonngBoatRaceStat.Data((xbean.LonngBoatRaceStat)_e_.getValue()));
/*  502 */     return role2stat_phase;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, Boolean> getRole2isright_times()
/*      */   {
/*  509 */     _xdb_verify_unsafe_();
/*  510 */     return Logs.logMap(new LogKey(this, "role2isright_times"), this.role2isright_times);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, Boolean> getRole2isright_timesAsData()
/*      */   {
/*  517 */     _xdb_verify_unsafe_();
/*      */     
/*  519 */     LonngBoatRaceTeamStat _o_ = this;
/*  520 */     Map<Long, Boolean> role2isright_times = new HashMap();
/*  521 */     for (Map.Entry<Long, Boolean> _e_ : _o_.role2isright_times.entrySet())
/*  522 */       role2isright_times.put(_e_.getKey(), _e_.getValue());
/*  523 */     return role2isright_times;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setSpeed(float _v_)
/*      */   {
/*  530 */     _xdb_verify_unsafe_();
/*  531 */     Logs.logIf(new LogKey(this, "speed")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  535 */         new xdb.logs.LogFloat(this, LonngBoatRaceTeamStat.this.speed)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  539 */             LonngBoatRaceTeamStat.this.speed = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  543 */     });
/*  544 */     this.speed = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setLocation(float _v_)
/*      */   {
/*  551 */     _xdb_verify_unsafe_();
/*  552 */     Logs.logIf(new LogKey(this, "location")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  556 */         new xdb.logs.LogFloat(this, LonngBoatRaceTeamStat.this.location)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  560 */             LonngBoatRaceTeamStat.this.location = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  564 */     });
/*  565 */     this.location = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setEventtypeid(int _v_)
/*      */   {
/*  572 */     _xdb_verify_unsafe_();
/*  573 */     Logs.logIf(new LogKey(this, "eventtypeid")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  577 */         new xdb.logs.LogInt(this, LonngBoatRaceTeamStat.this.eventtypeid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  581 */             LonngBoatRaceTeamStat.this.eventtypeid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  585 */     });
/*  586 */     this.eventtypeid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setEventid(int _v_)
/*      */   {
/*  593 */     _xdb_verify_unsafe_();
/*  594 */     Logs.logIf(new LogKey(this, "eventid")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  598 */         new xdb.logs.LogInt(this, LonngBoatRaceTeamStat.this.eventid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  602 */             LonngBoatRaceTeamStat.this.eventid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  606 */     });
/*  607 */     this.eventid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setEventtriggerid(int _v_)
/*      */   {
/*  614 */     _xdb_verify_unsafe_();
/*  615 */     Logs.logIf(new LogKey(this, "eventtriggerid")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  619 */         new xdb.logs.LogInt(this, LonngBoatRaceTeamStat.this.eventtriggerid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  623 */             LonngBoatRaceTeamStat.this.eventtriggerid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  627 */     });
/*  628 */     this.eventtriggerid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setEndtimestamp(long _v_)
/*      */   {
/*  635 */     _xdb_verify_unsafe_();
/*  636 */     Logs.logIf(new LogKey(this, "endtimestamp")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  640 */         new xdb.logs.LogLong(this, LonngBoatRaceTeamStat.this.endtimestamp)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  644 */             LonngBoatRaceTeamStat.this.endtimestamp = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  648 */     });
/*  649 */     this.endtimestamp = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  655 */     _xdb_verify_unsafe_();
/*  656 */     LonngBoatRaceTeamStat _o_ = null;
/*  657 */     if ((_o1_ instanceof LonngBoatRaceTeamStat)) { _o_ = (LonngBoatRaceTeamStat)_o1_;
/*  658 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  659 */       return false;
/*  660 */     if (this.speed != _o_.speed) return false;
/*  661 */     if (this.location != _o_.location) return false;
/*  662 */     if (this.eventtypeid != _o_.eventtypeid) return false;
/*  663 */     if (this.eventid != _o_.eventid) return false;
/*  664 */     if (this.eventtriggerid != _o_.eventtriggerid) return false;
/*  665 */     if (this.endtimestamp != _o_.endtimestamp) return false;
/*  666 */     if (!this.role2stat.equals(_o_.role2stat)) return false;
/*  667 */     if (!this.role2stat_phase.equals(_o_.role2stat_phase)) return false;
/*  668 */     if (!this.role2isright_times.equals(_o_.role2isright_times)) return false;
/*  669 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  675 */     _xdb_verify_unsafe_();
/*  676 */     int _h_ = 0;
/*  677 */     _h_ = (int)(_h_ + this.speed);
/*  678 */     _h_ = (int)(_h_ + this.location);
/*  679 */     _h_ += this.eventtypeid;
/*  680 */     _h_ += this.eventid;
/*  681 */     _h_ += this.eventtriggerid;
/*  682 */     _h_ = (int)(_h_ + this.endtimestamp);
/*  683 */     _h_ += this.role2stat.hashCode();
/*  684 */     _h_ += this.role2stat_phase.hashCode();
/*  685 */     _h_ += this.role2isright_times.hashCode();
/*  686 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  692 */     _xdb_verify_unsafe_();
/*  693 */     StringBuilder _sb_ = new StringBuilder();
/*  694 */     _sb_.append("(");
/*  695 */     _sb_.append(this.speed);
/*  696 */     _sb_.append(",");
/*  697 */     _sb_.append(this.location);
/*  698 */     _sb_.append(",");
/*  699 */     _sb_.append(this.eventtypeid);
/*  700 */     _sb_.append(",");
/*  701 */     _sb_.append(this.eventid);
/*  702 */     _sb_.append(",");
/*  703 */     _sb_.append(this.eventtriggerid);
/*  704 */     _sb_.append(",");
/*  705 */     _sb_.append(this.endtimestamp);
/*  706 */     _sb_.append(",");
/*  707 */     _sb_.append(this.role2stat);
/*  708 */     _sb_.append(",");
/*  709 */     _sb_.append(this.role2stat_phase);
/*  710 */     _sb_.append(",");
/*  711 */     _sb_.append(this.role2isright_times);
/*  712 */     _sb_.append(")");
/*  713 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  719 */     ListenableBean lb = new ListenableBean();
/*  720 */     lb.add(new ListenableChanged().setVarName("speed"));
/*  721 */     lb.add(new ListenableChanged().setVarName("location"));
/*  722 */     lb.add(new ListenableChanged().setVarName("eventtypeid"));
/*  723 */     lb.add(new ListenableChanged().setVarName("eventid"));
/*  724 */     lb.add(new ListenableChanged().setVarName("eventtriggerid"));
/*  725 */     lb.add(new ListenableChanged().setVarName("endtimestamp"));
/*  726 */     lb.add(new ListenableMap().setVarName("role2stat"));
/*  727 */     lb.add(new ListenableMap().setVarName("role2stat_phase"));
/*  728 */     lb.add(new ListenableMap().setVarName("role2isright_times"));
/*  729 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.LonngBoatRaceTeamStat {
/*      */     private Const() {}
/*      */     
/*      */     LonngBoatRaceTeamStat nThis() {
/*  736 */       return LonngBoatRaceTeamStat.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  742 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.LonngBoatRaceTeamStat copy()
/*      */     {
/*  748 */       return LonngBoatRaceTeamStat.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.LonngBoatRaceTeamStat toData()
/*      */     {
/*  754 */       return LonngBoatRaceTeamStat.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.LonngBoatRaceTeamStat toBean()
/*      */     {
/*  759 */       return LonngBoatRaceTeamStat.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.LonngBoatRaceTeamStat toDataIf()
/*      */     {
/*  765 */       return LonngBoatRaceTeamStat.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.LonngBoatRaceTeamStat toBeanIf()
/*      */     {
/*  770 */       return LonngBoatRaceTeamStat.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public float getSpeed()
/*      */     {
/*  777 */       LonngBoatRaceTeamStat.this._xdb_verify_unsafe_();
/*  778 */       return LonngBoatRaceTeamStat.this.speed;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public float getLocation()
/*      */     {
/*  785 */       LonngBoatRaceTeamStat.this._xdb_verify_unsafe_();
/*  786 */       return LonngBoatRaceTeamStat.this.location;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getEventtypeid()
/*      */     {
/*  793 */       LonngBoatRaceTeamStat.this._xdb_verify_unsafe_();
/*  794 */       return LonngBoatRaceTeamStat.this.eventtypeid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getEventid()
/*      */     {
/*  801 */       LonngBoatRaceTeamStat.this._xdb_verify_unsafe_();
/*  802 */       return LonngBoatRaceTeamStat.this.eventid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getEventtriggerid()
/*      */     {
/*  809 */       LonngBoatRaceTeamStat.this._xdb_verify_unsafe_();
/*  810 */       return LonngBoatRaceTeamStat.this.eventtriggerid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getEndtimestamp()
/*      */     {
/*  817 */       LonngBoatRaceTeamStat.this._xdb_verify_unsafe_();
/*  818 */       return LonngBoatRaceTeamStat.this.endtimestamp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.LonngBoatRaceStat> getRole2stat()
/*      */     {
/*  825 */       LonngBoatRaceTeamStat.this._xdb_verify_unsafe_();
/*  826 */       return xdb.Consts.constMap(LonngBoatRaceTeamStat.this.role2stat);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.LonngBoatRaceStat> getRole2statAsData()
/*      */     {
/*  833 */       LonngBoatRaceTeamStat.this._xdb_verify_unsafe_();
/*      */       
/*  835 */       LonngBoatRaceTeamStat _o_ = LonngBoatRaceTeamStat.this;
/*  836 */       Map<Long, xbean.LonngBoatRaceStat> role2stat = new HashMap();
/*  837 */       for (Map.Entry<Long, xbean.LonngBoatRaceStat> _e_ : _o_.role2stat.entrySet())
/*  838 */         role2stat.put(_e_.getKey(), new LonngBoatRaceStat.Data((xbean.LonngBoatRaceStat)_e_.getValue()));
/*  839 */       return role2stat;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.LonngBoatRaceStat> getRole2stat_phase()
/*      */     {
/*  846 */       LonngBoatRaceTeamStat.this._xdb_verify_unsafe_();
/*  847 */       return xdb.Consts.constMap(LonngBoatRaceTeamStat.this.role2stat_phase);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.LonngBoatRaceStat> getRole2stat_phaseAsData()
/*      */     {
/*  854 */       LonngBoatRaceTeamStat.this._xdb_verify_unsafe_();
/*      */       
/*  856 */       LonngBoatRaceTeamStat _o_ = LonngBoatRaceTeamStat.this;
/*  857 */       Map<Long, xbean.LonngBoatRaceStat> role2stat_phase = new HashMap();
/*  858 */       for (Map.Entry<Long, xbean.LonngBoatRaceStat> _e_ : _o_.role2stat_phase.entrySet())
/*  859 */         role2stat_phase.put(_e_.getKey(), new LonngBoatRaceStat.Data((xbean.LonngBoatRaceStat)_e_.getValue()));
/*  860 */       return role2stat_phase;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, Boolean> getRole2isright_times()
/*      */     {
/*  867 */       LonngBoatRaceTeamStat.this._xdb_verify_unsafe_();
/*  868 */       return xdb.Consts.constMap(LonngBoatRaceTeamStat.this.role2isright_times);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, Boolean> getRole2isright_timesAsData()
/*      */     {
/*  875 */       LonngBoatRaceTeamStat.this._xdb_verify_unsafe_();
/*      */       
/*  877 */       LonngBoatRaceTeamStat _o_ = LonngBoatRaceTeamStat.this;
/*  878 */       Map<Long, Boolean> role2isright_times = new HashMap();
/*  879 */       for (Map.Entry<Long, Boolean> _e_ : _o_.role2isright_times.entrySet())
/*  880 */         role2isright_times.put(_e_.getKey(), _e_.getValue());
/*  881 */       return role2isright_times;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setSpeed(float _v_)
/*      */     {
/*  888 */       LonngBoatRaceTeamStat.this._xdb_verify_unsafe_();
/*  889 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLocation(float _v_)
/*      */     {
/*  896 */       LonngBoatRaceTeamStat.this._xdb_verify_unsafe_();
/*  897 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setEventtypeid(int _v_)
/*      */     {
/*  904 */       LonngBoatRaceTeamStat.this._xdb_verify_unsafe_();
/*  905 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setEventid(int _v_)
/*      */     {
/*  912 */       LonngBoatRaceTeamStat.this._xdb_verify_unsafe_();
/*  913 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setEventtriggerid(int _v_)
/*      */     {
/*  920 */       LonngBoatRaceTeamStat.this._xdb_verify_unsafe_();
/*  921 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setEndtimestamp(long _v_)
/*      */     {
/*  928 */       LonngBoatRaceTeamStat.this._xdb_verify_unsafe_();
/*  929 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  935 */       LonngBoatRaceTeamStat.this._xdb_verify_unsafe_();
/*  936 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  942 */       LonngBoatRaceTeamStat.this._xdb_verify_unsafe_();
/*  943 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  949 */       return LonngBoatRaceTeamStat.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  955 */       return LonngBoatRaceTeamStat.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  961 */       LonngBoatRaceTeamStat.this._xdb_verify_unsafe_();
/*  962 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  968 */       return LonngBoatRaceTeamStat.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  974 */       return LonngBoatRaceTeamStat.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  980 */       LonngBoatRaceTeamStat.this._xdb_verify_unsafe_();
/*  981 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  987 */       return LonngBoatRaceTeamStat.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  993 */       return LonngBoatRaceTeamStat.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  999 */       return LonngBoatRaceTeamStat.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/* 1005 */       return LonngBoatRaceTeamStat.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/* 1011 */       return LonngBoatRaceTeamStat.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/* 1017 */       return LonngBoatRaceTeamStat.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1023 */       return LonngBoatRaceTeamStat.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.LonngBoatRaceTeamStat
/*      */   {
/*      */     private float speed;
/*      */     
/*      */     private float location;
/*      */     
/*      */     private int eventtypeid;
/*      */     
/*      */     private int eventid;
/*      */     
/*      */     private int eventtriggerid;
/*      */     
/*      */     private long endtimestamp;
/*      */     
/*      */     private HashMap<Long, xbean.LonngBoatRaceStat> role2stat;
/*      */     
/*      */     private HashMap<Long, xbean.LonngBoatRaceStat> role2stat_phase;
/*      */     
/*      */     private HashMap<Long, Boolean> role2isright_times;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/* 1051 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/* 1056 */       this.role2stat = new HashMap();
/* 1057 */       this.role2stat_phase = new HashMap();
/* 1058 */       this.role2isright_times = new HashMap();
/*      */     }
/*      */     
/*      */     Data(xbean.LonngBoatRaceTeamStat _o1_)
/*      */     {
/* 1063 */       if ((_o1_ instanceof LonngBoatRaceTeamStat)) { assign((LonngBoatRaceTeamStat)_o1_);
/* 1064 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 1065 */       } else if ((_o1_ instanceof LonngBoatRaceTeamStat.Const)) assign(((LonngBoatRaceTeamStat.Const)_o1_).nThis()); else {
/* 1066 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(LonngBoatRaceTeamStat _o_) {
/* 1071 */       this.speed = _o_.speed;
/* 1072 */       this.location = _o_.location;
/* 1073 */       this.eventtypeid = _o_.eventtypeid;
/* 1074 */       this.eventid = _o_.eventid;
/* 1075 */       this.eventtriggerid = _o_.eventtriggerid;
/* 1076 */       this.endtimestamp = _o_.endtimestamp;
/* 1077 */       this.role2stat = new HashMap();
/* 1078 */       for (Map.Entry<Long, xbean.LonngBoatRaceStat> _e_ : _o_.role2stat.entrySet())
/* 1079 */         this.role2stat.put(_e_.getKey(), new LonngBoatRaceStat.Data((xbean.LonngBoatRaceStat)_e_.getValue()));
/* 1080 */       this.role2stat_phase = new HashMap();
/* 1081 */       for (Map.Entry<Long, xbean.LonngBoatRaceStat> _e_ : _o_.role2stat_phase.entrySet())
/* 1082 */         this.role2stat_phase.put(_e_.getKey(), new LonngBoatRaceStat.Data((xbean.LonngBoatRaceStat)_e_.getValue()));
/* 1083 */       this.role2isright_times = new HashMap();
/* 1084 */       for (Map.Entry<Long, Boolean> _e_ : _o_.role2isright_times.entrySet()) {
/* 1085 */         this.role2isright_times.put(_e_.getKey(), _e_.getValue());
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(Data _o_) {
/* 1090 */       this.speed = _o_.speed;
/* 1091 */       this.location = _o_.location;
/* 1092 */       this.eventtypeid = _o_.eventtypeid;
/* 1093 */       this.eventid = _o_.eventid;
/* 1094 */       this.eventtriggerid = _o_.eventtriggerid;
/* 1095 */       this.endtimestamp = _o_.endtimestamp;
/* 1096 */       this.role2stat = new HashMap();
/* 1097 */       for (Map.Entry<Long, xbean.LonngBoatRaceStat> _e_ : _o_.role2stat.entrySet())
/* 1098 */         this.role2stat.put(_e_.getKey(), new LonngBoatRaceStat.Data((xbean.LonngBoatRaceStat)_e_.getValue()));
/* 1099 */       this.role2stat_phase = new HashMap();
/* 1100 */       for (Map.Entry<Long, xbean.LonngBoatRaceStat> _e_ : _o_.role2stat_phase.entrySet())
/* 1101 */         this.role2stat_phase.put(_e_.getKey(), new LonngBoatRaceStat.Data((xbean.LonngBoatRaceStat)_e_.getValue()));
/* 1102 */       this.role2isright_times = new HashMap();
/* 1103 */       for (Map.Entry<Long, Boolean> _e_ : _o_.role2isright_times.entrySet()) {
/* 1104 */         this.role2isright_times.put(_e_.getKey(), _e_.getValue());
/*      */       }
/*      */     }
/*      */     
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/* 1110 */       _os_.marshal(this.speed);
/* 1111 */       _os_.marshal(this.location);
/* 1112 */       _os_.marshal(this.eventtypeid);
/* 1113 */       _os_.marshal(this.eventid);
/* 1114 */       _os_.marshal(this.eventtriggerid);
/* 1115 */       _os_.marshal(this.endtimestamp);
/* 1116 */       _os_.compact_uint32(this.role2stat.size());
/* 1117 */       for (Map.Entry<Long, xbean.LonngBoatRaceStat> _e_ : this.role2stat.entrySet())
/*      */       {
/* 1119 */         _os_.marshal(((Long)_e_.getKey()).longValue());
/* 1120 */         ((xbean.LonngBoatRaceStat)_e_.getValue()).marshal(_os_);
/*      */       }
/* 1122 */       _os_.compact_uint32(this.role2stat_phase.size());
/* 1123 */       for (Map.Entry<Long, xbean.LonngBoatRaceStat> _e_ : this.role2stat_phase.entrySet())
/*      */       {
/* 1125 */         _os_.marshal(((Long)_e_.getKey()).longValue());
/* 1126 */         ((xbean.LonngBoatRaceStat)_e_.getValue()).marshal(_os_);
/*      */       }
/* 1128 */       _os_.compact_uint32(this.role2isright_times.size());
/* 1129 */       for (Map.Entry<Long, Boolean> _e_ : this.role2isright_times.entrySet())
/*      */       {
/* 1131 */         _os_.marshal(((Long)_e_.getKey()).longValue());
/* 1132 */         _os_.marshal(((Boolean)_e_.getValue()).booleanValue());
/*      */       }
/* 1134 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/* 1140 */       this.speed = _os_.unmarshal_float();
/* 1141 */       this.location = _os_.unmarshal_float();
/* 1142 */       this.eventtypeid = _os_.unmarshal_int();
/* 1143 */       this.eventid = _os_.unmarshal_int();
/* 1144 */       this.eventtriggerid = _os_.unmarshal_int();
/* 1145 */       this.endtimestamp = _os_.unmarshal_long();
/*      */       
/* 1147 */       int size = _os_.uncompact_uint32();
/* 1148 */       if (size >= 12)
/*      */       {
/* 1150 */         this.role2stat = new HashMap(size * 2);
/*      */       }
/* 1152 */       for (; size > 0; size--)
/*      */       {
/* 1154 */         long _k_ = 0L;
/* 1155 */         _k_ = _os_.unmarshal_long();
/* 1156 */         xbean.LonngBoatRaceStat _v_ = xbean.Pod.newLonngBoatRaceStatData();
/* 1157 */         _v_.unmarshal(_os_);
/* 1158 */         this.role2stat.put(Long.valueOf(_k_), _v_);
/*      */       }
/*      */       
/*      */ 
/* 1162 */       int size = _os_.uncompact_uint32();
/* 1163 */       if (size >= 12)
/*      */       {
/* 1165 */         this.role2stat_phase = new HashMap(size * 2);
/*      */       }
/* 1167 */       for (; size > 0; size--)
/*      */       {
/* 1169 */         long _k_ = 0L;
/* 1170 */         _k_ = _os_.unmarshal_long();
/* 1171 */         xbean.LonngBoatRaceStat _v_ = xbean.Pod.newLonngBoatRaceStatData();
/* 1172 */         _v_.unmarshal(_os_);
/* 1173 */         this.role2stat_phase.put(Long.valueOf(_k_), _v_);
/*      */       }
/*      */       
/*      */ 
/* 1177 */       int size = _os_.uncompact_uint32();
/* 1178 */       if (size >= 12)
/*      */       {
/* 1180 */         this.role2isright_times = new HashMap(size * 2);
/*      */       }
/* 1182 */       for (; size > 0; size--)
/*      */       {
/* 1184 */         long _k_ = 0L;
/* 1185 */         _k_ = _os_.unmarshal_long();
/* 1186 */         boolean _v_ = false;
/* 1187 */         _v_ = _os_.unmarshal_boolean();
/* 1188 */         this.role2isright_times.put(Long.valueOf(_k_), Boolean.valueOf(_v_));
/*      */       }
/*      */       
/* 1191 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/* 1197 */       int _size_ = 0;
/* 1198 */       _size_ += CodedOutputStream.computeFloatSize(1, this.speed);
/* 1199 */       _size_ += CodedOutputStream.computeFloatSize(2, this.location);
/* 1200 */       _size_ += CodedOutputStream.computeInt32Size(3, this.eventtypeid);
/* 1201 */       _size_ += CodedOutputStream.computeInt32Size(4, this.eventid);
/* 1202 */       _size_ += CodedOutputStream.computeInt32Size(5, this.eventtriggerid);
/* 1203 */       _size_ += CodedOutputStream.computeInt64Size(6, this.endtimestamp);
/* 1204 */       for (Map.Entry<Long, xbean.LonngBoatRaceStat> _e_ : this.role2stat.entrySet())
/*      */       {
/* 1206 */         _size_ += CodedOutputStream.computeInt64Size(7, ((Long)_e_.getKey()).longValue());
/* 1207 */         _size_ += CodedOutputStream.computeMessageSize(7, (Message)_e_.getValue());
/*      */       }
/* 1209 */       for (Map.Entry<Long, xbean.LonngBoatRaceStat> _e_ : this.role2stat_phase.entrySet())
/*      */       {
/* 1211 */         _size_ += CodedOutputStream.computeInt64Size(8, ((Long)_e_.getKey()).longValue());
/* 1212 */         _size_ += CodedOutputStream.computeMessageSize(8, (Message)_e_.getValue());
/*      */       }
/* 1214 */       for (Map.Entry<Long, Boolean> _e_ : this.role2isright_times.entrySet())
/*      */       {
/* 1216 */         _size_ += CodedOutputStream.computeInt64Size(9, ((Long)_e_.getKey()).longValue());
/* 1217 */         _size_ += CodedOutputStream.computeBoolSize(9, ((Boolean)_e_.getValue()).booleanValue());
/*      */       }
/* 1219 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1227 */         _output_.writeFloat(1, this.speed);
/* 1228 */         _output_.writeFloat(2, this.location);
/* 1229 */         _output_.writeInt32(3, this.eventtypeid);
/* 1230 */         _output_.writeInt32(4, this.eventid);
/* 1231 */         _output_.writeInt32(5, this.eventtriggerid);
/* 1232 */         _output_.writeInt64(6, this.endtimestamp);
/* 1233 */         for (Map.Entry<Long, xbean.LonngBoatRaceStat> _e_ : this.role2stat.entrySet())
/*      */         {
/* 1235 */           _output_.writeInt64(7, ((Long)_e_.getKey()).longValue());
/* 1236 */           _output_.writeMessage(7, (Message)_e_.getValue());
/*      */         }
/* 1238 */         for (Map.Entry<Long, xbean.LonngBoatRaceStat> _e_ : this.role2stat_phase.entrySet())
/*      */         {
/* 1240 */           _output_.writeInt64(8, ((Long)_e_.getKey()).longValue());
/* 1241 */           _output_.writeMessage(8, (Message)_e_.getValue());
/*      */         }
/* 1243 */         for (Map.Entry<Long, Boolean> _e_ : this.role2isright_times.entrySet())
/*      */         {
/* 1245 */           _output_.writeInt64(9, ((Long)_e_.getKey()).longValue());
/* 1246 */           _output_.writeBool(9, ((Boolean)_e_.getValue()).booleanValue());
/*      */         }
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1251 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1253 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1261 */         boolean done = false;
/* 1262 */         while (!done)
/*      */         {
/* 1264 */           int tag = _input_.readTag();
/* 1265 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/* 1269 */             done = true;
/* 1270 */             break;
/*      */           
/*      */ 
/*      */           case 13: 
/* 1274 */             this.speed = _input_.readFloat();
/* 1275 */             break;
/*      */           
/*      */ 
/*      */           case 21: 
/* 1279 */             this.location = _input_.readFloat();
/* 1280 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/* 1284 */             this.eventtypeid = _input_.readInt32();
/* 1285 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/* 1289 */             this.eventid = _input_.readInt32();
/* 1290 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/* 1294 */             this.eventtriggerid = _input_.readInt32();
/* 1295 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/* 1299 */             this.endtimestamp = _input_.readInt64();
/* 1300 */             break;
/*      */           
/*      */ 
/*      */           case 56: 
/* 1304 */             long _k_ = 0L;
/* 1305 */             _k_ = _input_.readInt64();
/* 1306 */             int readTag = _input_.readTag();
/* 1307 */             if (58 != readTag)
/*      */             {
/* 1309 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 1311 */             xbean.LonngBoatRaceStat _v_ = xbean.Pod.newLonngBoatRaceStatData();
/* 1312 */             _input_.readMessage(_v_);
/* 1313 */             this.role2stat.put(Long.valueOf(_k_), _v_);
/* 1314 */             break;
/*      */           
/*      */ 
/*      */           case 64: 
/* 1318 */             long _k_ = 0L;
/* 1319 */             _k_ = _input_.readInt64();
/* 1320 */             int readTag = _input_.readTag();
/* 1321 */             if (66 != readTag)
/*      */             {
/* 1323 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 1325 */             xbean.LonngBoatRaceStat _v_ = xbean.Pod.newLonngBoatRaceStatData();
/* 1326 */             _input_.readMessage(_v_);
/* 1327 */             this.role2stat_phase.put(Long.valueOf(_k_), _v_);
/* 1328 */             break;
/*      */           
/*      */ 
/*      */           case 72: 
/* 1332 */             long _k_ = 0L;
/* 1333 */             _k_ = _input_.readInt64();
/* 1334 */             int readTag = _input_.readTag();
/* 1335 */             if (72 != readTag)
/*      */             {
/* 1337 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 1339 */             boolean _v_ = false;
/* 1340 */             _v_ = _input_.readBool();
/* 1341 */             this.role2isright_times.put(Long.valueOf(_k_), Boolean.valueOf(_v_));
/* 1342 */             break;
/*      */           
/*      */ 
/*      */           default: 
/* 1346 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/* 1348 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/* 1357 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1361 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1363 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.LonngBoatRaceTeamStat copy()
/*      */     {
/* 1369 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.LonngBoatRaceTeamStat toData()
/*      */     {
/* 1375 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.LonngBoatRaceTeamStat toBean()
/*      */     {
/* 1380 */       return new LonngBoatRaceTeamStat(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.LonngBoatRaceTeamStat toDataIf()
/*      */     {
/* 1386 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.LonngBoatRaceTeamStat toBeanIf()
/*      */     {
/* 1391 */       return new LonngBoatRaceTeamStat(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1397 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/* 1401 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1405 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1409 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/* 1413 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1417 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1421 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public float getSpeed()
/*      */     {
/* 1428 */       return this.speed;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public float getLocation()
/*      */     {
/* 1435 */       return this.location;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getEventtypeid()
/*      */     {
/* 1442 */       return this.eventtypeid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getEventid()
/*      */     {
/* 1449 */       return this.eventid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getEventtriggerid()
/*      */     {
/* 1456 */       return this.eventtriggerid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getEndtimestamp()
/*      */     {
/* 1463 */       return this.endtimestamp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.LonngBoatRaceStat> getRole2stat()
/*      */     {
/* 1470 */       return this.role2stat;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.LonngBoatRaceStat> getRole2statAsData()
/*      */     {
/* 1477 */       return this.role2stat;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.LonngBoatRaceStat> getRole2stat_phase()
/*      */     {
/* 1484 */       return this.role2stat_phase;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.LonngBoatRaceStat> getRole2stat_phaseAsData()
/*      */     {
/* 1491 */       return this.role2stat_phase;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, Boolean> getRole2isright_times()
/*      */     {
/* 1498 */       return this.role2isright_times;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, Boolean> getRole2isright_timesAsData()
/*      */     {
/* 1505 */       return this.role2isright_times;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setSpeed(float _v_)
/*      */     {
/* 1512 */       this.speed = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLocation(float _v_)
/*      */     {
/* 1519 */       this.location = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setEventtypeid(int _v_)
/*      */     {
/* 1526 */       this.eventtypeid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setEventid(int _v_)
/*      */     {
/* 1533 */       this.eventid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setEventtriggerid(int _v_)
/*      */     {
/* 1540 */       this.eventtriggerid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setEndtimestamp(long _v_)
/*      */     {
/* 1547 */       this.endtimestamp = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1553 */       if (!(_o1_ instanceof Data)) return false;
/* 1554 */       Data _o_ = (Data)_o1_;
/* 1555 */       if (this.speed != _o_.speed) return false;
/* 1556 */       if (this.location != _o_.location) return false;
/* 1557 */       if (this.eventtypeid != _o_.eventtypeid) return false;
/* 1558 */       if (this.eventid != _o_.eventid) return false;
/* 1559 */       if (this.eventtriggerid != _o_.eventtriggerid) return false;
/* 1560 */       if (this.endtimestamp != _o_.endtimestamp) return false;
/* 1561 */       if (!this.role2stat.equals(_o_.role2stat)) return false;
/* 1562 */       if (!this.role2stat_phase.equals(_o_.role2stat_phase)) return false;
/* 1563 */       if (!this.role2isright_times.equals(_o_.role2isright_times)) return false;
/* 1564 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1570 */       int _h_ = 0;
/* 1571 */       _h_ = (int)(_h_ + this.speed);
/* 1572 */       _h_ = (int)(_h_ + this.location);
/* 1573 */       _h_ += this.eventtypeid;
/* 1574 */       _h_ += this.eventid;
/* 1575 */       _h_ += this.eventtriggerid;
/* 1576 */       _h_ = (int)(_h_ + this.endtimestamp);
/* 1577 */       _h_ += this.role2stat.hashCode();
/* 1578 */       _h_ += this.role2stat_phase.hashCode();
/* 1579 */       _h_ += this.role2isright_times.hashCode();
/* 1580 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1586 */       StringBuilder _sb_ = new StringBuilder();
/* 1587 */       _sb_.append("(");
/* 1588 */       _sb_.append(this.speed);
/* 1589 */       _sb_.append(",");
/* 1590 */       _sb_.append(this.location);
/* 1591 */       _sb_.append(",");
/* 1592 */       _sb_.append(this.eventtypeid);
/* 1593 */       _sb_.append(",");
/* 1594 */       _sb_.append(this.eventid);
/* 1595 */       _sb_.append(",");
/* 1596 */       _sb_.append(this.eventtriggerid);
/* 1597 */       _sb_.append(",");
/* 1598 */       _sb_.append(this.endtimestamp);
/* 1599 */       _sb_.append(",");
/* 1600 */       _sb_.append(this.role2stat);
/* 1601 */       _sb_.append(",");
/* 1602 */       _sb_.append(this.role2stat_phase);
/* 1603 */       _sb_.append(",");
/* 1604 */       _sb_.append(this.role2isright_times);
/* 1605 */       _sb_.append(")");
/* 1606 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\LonngBoatRaceTeamStat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */