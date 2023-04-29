/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.io.IOException;
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
/*      */ import xdb.Log;
/*      */ import xdb.LogKey;
/*      */ import xdb.Logs;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableChanged;
/*      */ import xdb.logs.LogInt;
/*      */ import xdb.logs.LogLong;
/*      */ import xdb.util.SetX;
/*      */ 
/*      */ public final class FlowerParade extends XBean implements xbean.FlowerParade
/*      */ {
/*      */   private ArrayList<Long> roles;
/*      */   private int ocpid;
/*      */   private int mapid;
/*      */   private int danceindex;
/*      */   private int toposindex;
/*      */   private HashMap<Long, Long> followtimestart;
/*      */   private int state;
/*      */   private long sessionidrest;
/*      */   private long sessionidcountdown;
/*      */   private long flowerinstanceid;
/*      */   private SetX<Long> flowerroleiddoneset;
/*      */   private long starttimeinsec;
/*      */   private long sessionidstopcountdown;
/*      */   private long paradeindex;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   44 */     this.roles.clear();
/*   45 */     this.ocpid = 0;
/*   46 */     this.mapid = 0;
/*   47 */     this.danceindex = 0;
/*   48 */     this.toposindex = 0;
/*   49 */     this.followtimestart.clear();
/*   50 */     this.state = 0;
/*   51 */     this.sessionidrest = 0L;
/*   52 */     this.sessionidcountdown = 0L;
/*   53 */     this.flowerinstanceid = 0L;
/*   54 */     this.flowerroleiddoneset.clear();
/*   55 */     this.starttimeinsec = 0L;
/*   56 */     this.sessionidstopcountdown = 0L;
/*   57 */     this.paradeindex = 0L;
/*      */   }
/*      */   
/*      */   FlowerParade(int __, XBean _xp_, String _vn_)
/*      */   {
/*   62 */     super(_xp_, _vn_);
/*   63 */     this.roles = new ArrayList();
/*   64 */     this.followtimestart = new HashMap();
/*   65 */     this.sessionidrest = 0L;
/*   66 */     this.sessionidcountdown = 0L;
/*   67 */     this.flowerinstanceid = 0L;
/*   68 */     this.flowerroleiddoneset = new SetX();
/*   69 */     this.sessionidstopcountdown = 0L;
/*   70 */     this.paradeindex = 0L;
/*      */   }
/*      */   
/*      */   public FlowerParade()
/*      */   {
/*   75 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public FlowerParade(FlowerParade _o_)
/*      */   {
/*   80 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   FlowerParade(xbean.FlowerParade _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   85 */     super(_xp_, _vn_);
/*   86 */     if ((_o1_ instanceof FlowerParade)) { assign((FlowerParade)_o1_);
/*   87 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   88 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   89 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(FlowerParade _o_) {
/*   94 */     _o_._xdb_verify_unsafe_();
/*   95 */     this.roles = new ArrayList();
/*   96 */     this.roles.addAll(_o_.roles);
/*   97 */     this.ocpid = _o_.ocpid;
/*   98 */     this.mapid = _o_.mapid;
/*   99 */     this.danceindex = _o_.danceindex;
/*  100 */     this.toposindex = _o_.toposindex;
/*  101 */     this.followtimestart = new HashMap();
/*  102 */     for (Map.Entry<Long, Long> _e_ : _o_.followtimestart.entrySet())
/*  103 */       this.followtimestart.put(_e_.getKey(), _e_.getValue());
/*  104 */     this.state = _o_.state;
/*  105 */     this.sessionidrest = _o_.sessionidrest;
/*  106 */     this.sessionidcountdown = _o_.sessionidcountdown;
/*  107 */     this.flowerinstanceid = _o_.flowerinstanceid;
/*  108 */     this.flowerroleiddoneset = new SetX();
/*  109 */     this.flowerroleiddoneset.addAll(_o_.flowerroleiddoneset);
/*  110 */     this.starttimeinsec = _o_.starttimeinsec;
/*  111 */     this.sessionidstopcountdown = _o_.sessionidstopcountdown;
/*  112 */     this.paradeindex = _o_.paradeindex;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*  117 */     this.roles = new ArrayList();
/*  118 */     this.roles.addAll(_o_.roles);
/*  119 */     this.ocpid = _o_.ocpid;
/*  120 */     this.mapid = _o_.mapid;
/*  121 */     this.danceindex = _o_.danceindex;
/*  122 */     this.toposindex = _o_.toposindex;
/*  123 */     this.followtimestart = new HashMap();
/*  124 */     for (Map.Entry<Long, Long> _e_ : _o_.followtimestart.entrySet())
/*  125 */       this.followtimestart.put(_e_.getKey(), _e_.getValue());
/*  126 */     this.state = _o_.state;
/*  127 */     this.sessionidrest = _o_.sessionidrest;
/*  128 */     this.sessionidcountdown = _o_.sessionidcountdown;
/*  129 */     this.flowerinstanceid = _o_.flowerinstanceid;
/*  130 */     this.flowerroleiddoneset = new SetX();
/*  131 */     this.flowerroleiddoneset.addAll(_o_.flowerroleiddoneset);
/*  132 */     this.starttimeinsec = _o_.starttimeinsec;
/*  133 */     this.sessionidstopcountdown = _o_.sessionidstopcountdown;
/*  134 */     this.paradeindex = _o_.paradeindex;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*  140 */     _xdb_verify_unsafe_();
/*  141 */     _os_.compact_uint32(this.roles.size());
/*  142 */     for (Long _v_ : this.roles)
/*      */     {
/*  144 */       _os_.marshal(_v_.longValue());
/*      */     }
/*  146 */     _os_.marshal(this.ocpid);
/*  147 */     _os_.marshal(this.mapid);
/*  148 */     _os_.marshal(this.danceindex);
/*  149 */     _os_.marshal(this.toposindex);
/*  150 */     _os_.compact_uint32(this.followtimestart.size());
/*  151 */     for (Map.Entry<Long, Long> _e_ : this.followtimestart.entrySet())
/*      */     {
/*  153 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  154 */       _os_.marshal(((Long)_e_.getValue()).longValue());
/*      */     }
/*  156 */     _os_.marshal(this.state);
/*  157 */     _os_.marshal(this.sessionidrest);
/*  158 */     _os_.marshal(this.sessionidcountdown);
/*  159 */     _os_.marshal(this.flowerinstanceid);
/*  160 */     _os_.compact_uint32(this.flowerroleiddoneset.size());
/*  161 */     for (Long _v_ : this.flowerroleiddoneset)
/*      */     {
/*  163 */       _os_.marshal(_v_.longValue());
/*      */     }
/*  165 */     _os_.marshal(this.starttimeinsec);
/*  166 */     _os_.marshal(this.sessionidstopcountdown);
/*  167 */     _os_.marshal(this.paradeindex);
/*  168 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  174 */     _xdb_verify_unsafe_();
/*  175 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  177 */       long _v_ = 0L;
/*  178 */       _v_ = _os_.unmarshal_long();
/*  179 */       this.roles.add(Long.valueOf(_v_));
/*      */     }
/*  181 */     this.ocpid = _os_.unmarshal_int();
/*  182 */     this.mapid = _os_.unmarshal_int();
/*  183 */     this.danceindex = _os_.unmarshal_int();
/*  184 */     this.toposindex = _os_.unmarshal_int();
/*      */     
/*  186 */     int size = _os_.uncompact_uint32();
/*  187 */     if (size >= 12)
/*      */     {
/*  189 */       this.followtimestart = new HashMap(size * 2);
/*      */     }
/*  191 */     for (; size > 0; size--)
/*      */     {
/*  193 */       long _k_ = 0L;
/*  194 */       _k_ = _os_.unmarshal_long();
/*  195 */       long _v_ = 0L;
/*  196 */       _v_ = _os_.unmarshal_long();
/*  197 */       this.followtimestart.put(Long.valueOf(_k_), Long.valueOf(_v_));
/*      */     }
/*      */     
/*  200 */     this.state = _os_.unmarshal_int();
/*  201 */     this.sessionidrest = _os_.unmarshal_long();
/*  202 */     this.sessionidcountdown = _os_.unmarshal_long();
/*  203 */     this.flowerinstanceid = _os_.unmarshal_long();
/*  204 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  206 */       long _v_ = 0L;
/*  207 */       _v_ = _os_.unmarshal_long();
/*  208 */       this.flowerroleiddoneset.add(Long.valueOf(_v_));
/*      */     }
/*  210 */     this.starttimeinsec = _os_.unmarshal_long();
/*  211 */     this.sessionidstopcountdown = _os_.unmarshal_long();
/*  212 */     this.paradeindex = _os_.unmarshal_long();
/*  213 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  219 */     _xdb_verify_unsafe_();
/*  220 */     int _size_ = 0;
/*  221 */     for (Long _v_ : this.roles)
/*      */     {
/*  223 */       _size_ += CodedOutputStream.computeInt64Size(1, _v_.longValue());
/*      */     }
/*  225 */     _size_ += CodedOutputStream.computeInt32Size(2, this.ocpid);
/*  226 */     _size_ += CodedOutputStream.computeInt32Size(3, this.mapid);
/*  227 */     _size_ += CodedOutputStream.computeInt32Size(4, this.danceindex);
/*  228 */     _size_ += CodedOutputStream.computeInt32Size(5, this.toposindex);
/*  229 */     for (Map.Entry<Long, Long> _e_ : this.followtimestart.entrySet())
/*      */     {
/*  231 */       _size_ += CodedOutputStream.computeInt64Size(6, ((Long)_e_.getKey()).longValue());
/*  232 */       _size_ += CodedOutputStream.computeInt64Size(6, ((Long)_e_.getValue()).longValue());
/*      */     }
/*  234 */     _size_ += CodedOutputStream.computeInt32Size(7, this.state);
/*  235 */     _size_ += CodedOutputStream.computeInt64Size(8, this.sessionidrest);
/*  236 */     _size_ += CodedOutputStream.computeInt64Size(9, this.sessionidcountdown);
/*  237 */     _size_ += CodedOutputStream.computeInt64Size(10, this.flowerinstanceid);
/*  238 */     for (Long _v_ : this.flowerroleiddoneset)
/*      */     {
/*  240 */       _size_ += CodedOutputStream.computeInt64Size(11, _v_.longValue());
/*      */     }
/*  242 */     _size_ += CodedOutputStream.computeInt64Size(12, this.starttimeinsec);
/*  243 */     _size_ += CodedOutputStream.computeInt64Size(13, this.sessionidstopcountdown);
/*  244 */     _size_ += CodedOutputStream.computeInt64Size(14, this.paradeindex);
/*  245 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  251 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  254 */       for (Long _v_ : this.roles)
/*      */       {
/*  256 */         _output_.writeInt64(1, _v_.longValue());
/*      */       }
/*  258 */       _output_.writeInt32(2, this.ocpid);
/*  259 */       _output_.writeInt32(3, this.mapid);
/*  260 */       _output_.writeInt32(4, this.danceindex);
/*  261 */       _output_.writeInt32(5, this.toposindex);
/*  262 */       for (Map.Entry<Long, Long> _e_ : this.followtimestart.entrySet())
/*      */       {
/*  264 */         _output_.writeInt64(6, ((Long)_e_.getKey()).longValue());
/*  265 */         _output_.writeInt64(6, ((Long)_e_.getValue()).longValue());
/*      */       }
/*  267 */       _output_.writeInt32(7, this.state);
/*  268 */       _output_.writeInt64(8, this.sessionidrest);
/*  269 */       _output_.writeInt64(9, this.sessionidcountdown);
/*  270 */       _output_.writeInt64(10, this.flowerinstanceid);
/*  271 */       for (Long _v_ : this.flowerroleiddoneset)
/*      */       {
/*  273 */         _output_.writeInt64(11, _v_.longValue());
/*      */       }
/*  275 */       _output_.writeInt64(12, this.starttimeinsec);
/*  276 */       _output_.writeInt64(13, this.sessionidstopcountdown);
/*  277 */       _output_.writeInt64(14, this.paradeindex);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  281 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  283 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  289 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  292 */       boolean done = false;
/*  293 */       while (!done)
/*      */       {
/*  295 */         int tag = _input_.readTag();
/*  296 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  300 */           done = true;
/*  301 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  305 */           long _v_ = 0L;
/*  306 */           _v_ = _input_.readInt64();
/*  307 */           this.roles.add(Long.valueOf(_v_));
/*  308 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  312 */           this.ocpid = _input_.readInt32();
/*  313 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  317 */           this.mapid = _input_.readInt32();
/*  318 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  322 */           this.danceindex = _input_.readInt32();
/*  323 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  327 */           this.toposindex = _input_.readInt32();
/*  328 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  332 */           long _k_ = 0L;
/*  333 */           _k_ = _input_.readInt64();
/*  334 */           int readTag = _input_.readTag();
/*  335 */           if (48 != readTag)
/*      */           {
/*  337 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  339 */           long _v_ = 0L;
/*  340 */           _v_ = _input_.readInt64();
/*  341 */           this.followtimestart.put(Long.valueOf(_k_), Long.valueOf(_v_));
/*  342 */           break;
/*      */         
/*      */ 
/*      */         case 56: 
/*  346 */           this.state = _input_.readInt32();
/*  347 */           break;
/*      */         
/*      */ 
/*      */         case 64: 
/*  351 */           this.sessionidrest = _input_.readInt64();
/*  352 */           break;
/*      */         
/*      */ 
/*      */         case 72: 
/*  356 */           this.sessionidcountdown = _input_.readInt64();
/*  357 */           break;
/*      */         
/*      */ 
/*      */         case 80: 
/*  361 */           this.flowerinstanceid = _input_.readInt64();
/*  362 */           break;
/*      */         
/*      */ 
/*      */         case 88: 
/*  366 */           long _v_ = 0L;
/*  367 */           _v_ = _input_.readInt64();
/*  368 */           this.flowerroleiddoneset.add(Long.valueOf(_v_));
/*  369 */           break;
/*      */         
/*      */ 
/*      */         case 96: 
/*  373 */           this.starttimeinsec = _input_.readInt64();
/*  374 */           break;
/*      */         
/*      */ 
/*      */         case 104: 
/*  378 */           this.sessionidstopcountdown = _input_.readInt64();
/*  379 */           break;
/*      */         
/*      */ 
/*      */         case 112: 
/*  383 */           this.paradeindex = _input_.readInt64();
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
/*      */   public xbean.FlowerParade copy()
/*      */   {
/*  411 */     _xdb_verify_unsafe_();
/*  412 */     return new FlowerParade(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.FlowerParade toData()
/*      */   {
/*  418 */     _xdb_verify_unsafe_();
/*  419 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.FlowerParade toBean()
/*      */   {
/*  424 */     _xdb_verify_unsafe_();
/*  425 */     return new FlowerParade(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.FlowerParade toDataIf()
/*      */   {
/*  431 */     _xdb_verify_unsafe_();
/*  432 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.FlowerParade toBeanIf()
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
/*      */   public List<Long> getRoles()
/*      */   {
/*  452 */     _xdb_verify_unsafe_();
/*  453 */     return Logs.logList(new LogKey(this, "roles"), this.roles);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<Long> getRolesAsData()
/*      */   {
/*  459 */     _xdb_verify_unsafe_();
/*      */     
/*  461 */     FlowerParade _o_ = this;
/*  462 */     List<Long> roles = new ArrayList();
/*  463 */     roles.addAll(_o_.roles);
/*  464 */     return roles;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getOcpid()
/*      */   {
/*  471 */     _xdb_verify_unsafe_();
/*  472 */     return this.ocpid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getMapid()
/*      */   {
/*  479 */     _xdb_verify_unsafe_();
/*  480 */     return this.mapid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getDanceindex()
/*      */   {
/*  487 */     _xdb_verify_unsafe_();
/*  488 */     return this.danceindex;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getToposindex()
/*      */   {
/*  495 */     _xdb_verify_unsafe_();
/*  496 */     return this.toposindex;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, Long> getFollowtimestart()
/*      */   {
/*  503 */     _xdb_verify_unsafe_();
/*  504 */     return Logs.logMap(new LogKey(this, "followtimestart"), this.followtimestart);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, Long> getFollowtimestartAsData()
/*      */   {
/*  511 */     _xdb_verify_unsafe_();
/*      */     
/*  513 */     FlowerParade _o_ = this;
/*  514 */     Map<Long, Long> followtimestart = new HashMap();
/*  515 */     for (Map.Entry<Long, Long> _e_ : _o_.followtimestart.entrySet())
/*  516 */       followtimestart.put(_e_.getKey(), _e_.getValue());
/*  517 */     return followtimestart;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getState()
/*      */   {
/*  524 */     _xdb_verify_unsafe_();
/*  525 */     return this.state;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getSessionidrest()
/*      */   {
/*  532 */     _xdb_verify_unsafe_();
/*  533 */     return this.sessionidrest;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getSessionidcountdown()
/*      */   {
/*  540 */     _xdb_verify_unsafe_();
/*  541 */     return this.sessionidcountdown;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getFlowerinstanceid()
/*      */   {
/*  548 */     _xdb_verify_unsafe_();
/*  549 */     return this.flowerinstanceid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Set<Long> getFlowerroleiddoneset()
/*      */   {
/*  556 */     _xdb_verify_unsafe_();
/*  557 */     return Logs.logSet(new LogKey(this, "flowerroleiddoneset"), this.flowerroleiddoneset);
/*      */   }
/*      */   
/*      */ 
/*      */   public Set<Long> getFlowerroleiddonesetAsData()
/*      */   {
/*  563 */     _xdb_verify_unsafe_();
/*      */     
/*  565 */     FlowerParade _o_ = this;
/*  566 */     Set<Long> flowerroleiddoneset = new SetX();
/*  567 */     flowerroleiddoneset.addAll(_o_.flowerroleiddoneset);
/*  568 */     return flowerroleiddoneset;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getStarttimeinsec()
/*      */   {
/*  575 */     _xdb_verify_unsafe_();
/*  576 */     return this.starttimeinsec;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getSessionidstopcountdown()
/*      */   {
/*  583 */     _xdb_verify_unsafe_();
/*  584 */     return this.sessionidstopcountdown;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getParadeindex()
/*      */   {
/*  591 */     _xdb_verify_unsafe_();
/*  592 */     return this.paradeindex;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setOcpid(int _v_)
/*      */   {
/*  599 */     _xdb_verify_unsafe_();
/*  600 */     Logs.logIf(new LogKey(this, "ocpid")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  604 */         new LogInt(this, FlowerParade.this.ocpid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  608 */             FlowerParade.this.ocpid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  612 */     });
/*  613 */     this.ocpid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setMapid(int _v_)
/*      */   {
/*  620 */     _xdb_verify_unsafe_();
/*  621 */     Logs.logIf(new LogKey(this, "mapid")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  625 */         new LogInt(this, FlowerParade.this.mapid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  629 */             FlowerParade.this.mapid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  633 */     });
/*  634 */     this.mapid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setDanceindex(int _v_)
/*      */   {
/*  641 */     _xdb_verify_unsafe_();
/*  642 */     Logs.logIf(new LogKey(this, "danceindex")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  646 */         new LogInt(this, FlowerParade.this.danceindex)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  650 */             FlowerParade.this.danceindex = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  654 */     });
/*  655 */     this.danceindex = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setToposindex(int _v_)
/*      */   {
/*  662 */     _xdb_verify_unsafe_();
/*  663 */     Logs.logIf(new LogKey(this, "toposindex")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  667 */         new LogInt(this, FlowerParade.this.toposindex)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  671 */             FlowerParade.this.toposindex = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  675 */     });
/*  676 */     this.toposindex = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setState(int _v_)
/*      */   {
/*  683 */     _xdb_verify_unsafe_();
/*  684 */     Logs.logIf(new LogKey(this, "state")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  688 */         new LogInt(this, FlowerParade.this.state)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  692 */             FlowerParade.this.state = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  696 */     });
/*  697 */     this.state = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setSessionidrest(long _v_)
/*      */   {
/*  704 */     _xdb_verify_unsafe_();
/*  705 */     Logs.logIf(new LogKey(this, "sessionidrest")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  709 */         new LogLong(this, FlowerParade.this.sessionidrest)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  713 */             FlowerParade.this.sessionidrest = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  717 */     });
/*  718 */     this.sessionidrest = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setSessionidcountdown(long _v_)
/*      */   {
/*  725 */     _xdb_verify_unsafe_();
/*  726 */     Logs.logIf(new LogKey(this, "sessionidcountdown")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  730 */         new LogLong(this, FlowerParade.this.sessionidcountdown)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  734 */             FlowerParade.this.sessionidcountdown = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  738 */     });
/*  739 */     this.sessionidcountdown = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setFlowerinstanceid(long _v_)
/*      */   {
/*  746 */     _xdb_verify_unsafe_();
/*  747 */     Logs.logIf(new LogKey(this, "flowerinstanceid")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  751 */         new LogLong(this, FlowerParade.this.flowerinstanceid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  755 */             FlowerParade.this.flowerinstanceid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  759 */     });
/*  760 */     this.flowerinstanceid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setStarttimeinsec(long _v_)
/*      */   {
/*  767 */     _xdb_verify_unsafe_();
/*  768 */     Logs.logIf(new LogKey(this, "starttimeinsec")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  772 */         new LogLong(this, FlowerParade.this.starttimeinsec)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  776 */             FlowerParade.this.starttimeinsec = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  780 */     });
/*  781 */     this.starttimeinsec = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setSessionidstopcountdown(long _v_)
/*      */   {
/*  788 */     _xdb_verify_unsafe_();
/*  789 */     Logs.logIf(new LogKey(this, "sessionidstopcountdown")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  793 */         new LogLong(this, FlowerParade.this.sessionidstopcountdown)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  797 */             FlowerParade.this.sessionidstopcountdown = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  801 */     });
/*  802 */     this.sessionidstopcountdown = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setParadeindex(long _v_)
/*      */   {
/*  809 */     _xdb_verify_unsafe_();
/*  810 */     Logs.logIf(new LogKey(this, "paradeindex")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  814 */         new LogLong(this, FlowerParade.this.paradeindex)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  818 */             FlowerParade.this.paradeindex = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  822 */     });
/*  823 */     this.paradeindex = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  829 */     _xdb_verify_unsafe_();
/*  830 */     FlowerParade _o_ = null;
/*  831 */     if ((_o1_ instanceof FlowerParade)) { _o_ = (FlowerParade)_o1_;
/*  832 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  833 */       return false;
/*  834 */     if (!this.roles.equals(_o_.roles)) return false;
/*  835 */     if (this.ocpid != _o_.ocpid) return false;
/*  836 */     if (this.mapid != _o_.mapid) return false;
/*  837 */     if (this.danceindex != _o_.danceindex) return false;
/*  838 */     if (this.toposindex != _o_.toposindex) return false;
/*  839 */     if (!this.followtimestart.equals(_o_.followtimestart)) return false;
/*  840 */     if (this.state != _o_.state) return false;
/*  841 */     if (this.sessionidrest != _o_.sessionidrest) return false;
/*  842 */     if (this.sessionidcountdown != _o_.sessionidcountdown) return false;
/*  843 */     if (this.flowerinstanceid != _o_.flowerinstanceid) return false;
/*  844 */     if (!this.flowerroleiddoneset.equals(_o_.flowerroleiddoneset)) return false;
/*  845 */     if (this.starttimeinsec != _o_.starttimeinsec) return false;
/*  846 */     if (this.sessionidstopcountdown != _o_.sessionidstopcountdown) return false;
/*  847 */     if (this.paradeindex != _o_.paradeindex) return false;
/*  848 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  854 */     _xdb_verify_unsafe_();
/*  855 */     int _h_ = 0;
/*  856 */     _h_ += this.roles.hashCode();
/*  857 */     _h_ += this.ocpid;
/*  858 */     _h_ += this.mapid;
/*  859 */     _h_ += this.danceindex;
/*  860 */     _h_ += this.toposindex;
/*  861 */     _h_ += this.followtimestart.hashCode();
/*  862 */     _h_ += this.state;
/*  863 */     _h_ = (int)(_h_ + this.sessionidrest);
/*  864 */     _h_ = (int)(_h_ + this.sessionidcountdown);
/*  865 */     _h_ = (int)(_h_ + this.flowerinstanceid);
/*  866 */     _h_ += this.flowerroleiddoneset.hashCode();
/*  867 */     _h_ = (int)(_h_ + this.starttimeinsec);
/*  868 */     _h_ = (int)(_h_ + this.sessionidstopcountdown);
/*  869 */     _h_ = (int)(_h_ + this.paradeindex);
/*  870 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  876 */     _xdb_verify_unsafe_();
/*  877 */     StringBuilder _sb_ = new StringBuilder();
/*  878 */     _sb_.append("(");
/*  879 */     _sb_.append(this.roles);
/*  880 */     _sb_.append(",");
/*  881 */     _sb_.append(this.ocpid);
/*  882 */     _sb_.append(",");
/*  883 */     _sb_.append(this.mapid);
/*  884 */     _sb_.append(",");
/*  885 */     _sb_.append(this.danceindex);
/*  886 */     _sb_.append(",");
/*  887 */     _sb_.append(this.toposindex);
/*  888 */     _sb_.append(",");
/*  889 */     _sb_.append(this.followtimestart);
/*  890 */     _sb_.append(",");
/*  891 */     _sb_.append(this.state);
/*  892 */     _sb_.append(",");
/*  893 */     _sb_.append(this.sessionidrest);
/*  894 */     _sb_.append(",");
/*  895 */     _sb_.append(this.sessionidcountdown);
/*  896 */     _sb_.append(",");
/*  897 */     _sb_.append(this.flowerinstanceid);
/*  898 */     _sb_.append(",");
/*  899 */     _sb_.append(this.flowerroleiddoneset);
/*  900 */     _sb_.append(",");
/*  901 */     _sb_.append(this.starttimeinsec);
/*  902 */     _sb_.append(",");
/*  903 */     _sb_.append(this.sessionidstopcountdown);
/*  904 */     _sb_.append(",");
/*  905 */     _sb_.append(this.paradeindex);
/*  906 */     _sb_.append(")");
/*  907 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  913 */     ListenableBean lb = new ListenableBean();
/*  914 */     lb.add(new ListenableChanged().setVarName("roles"));
/*  915 */     lb.add(new ListenableChanged().setVarName("ocpid"));
/*  916 */     lb.add(new ListenableChanged().setVarName("mapid"));
/*  917 */     lb.add(new ListenableChanged().setVarName("danceindex"));
/*  918 */     lb.add(new ListenableChanged().setVarName("toposindex"));
/*  919 */     lb.add(new xdb.logs.ListenableMap().setVarName("followtimestart"));
/*  920 */     lb.add(new ListenableChanged().setVarName("state"));
/*  921 */     lb.add(new ListenableChanged().setVarName("sessionidrest"));
/*  922 */     lb.add(new ListenableChanged().setVarName("sessionidcountdown"));
/*  923 */     lb.add(new ListenableChanged().setVarName("flowerinstanceid"));
/*  924 */     lb.add(new xdb.logs.ListenableSet().setVarName("flowerroleiddoneset"));
/*  925 */     lb.add(new ListenableChanged().setVarName("starttimeinsec"));
/*  926 */     lb.add(new ListenableChanged().setVarName("sessionidstopcountdown"));
/*  927 */     lb.add(new ListenableChanged().setVarName("paradeindex"));
/*  928 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.FlowerParade {
/*      */     private Const() {}
/*      */     
/*      */     FlowerParade nThis() {
/*  935 */       return FlowerParade.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  941 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.FlowerParade copy()
/*      */     {
/*  947 */       return FlowerParade.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.FlowerParade toData()
/*      */     {
/*  953 */       return FlowerParade.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.FlowerParade toBean()
/*      */     {
/*  958 */       return FlowerParade.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.FlowerParade toDataIf()
/*      */     {
/*  964 */       return FlowerParade.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.FlowerParade toBeanIf()
/*      */     {
/*  969 */       return FlowerParade.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getRoles()
/*      */     {
/*  976 */       FlowerParade.this._xdb_verify_unsafe_();
/*  977 */       return xdb.Consts.constList(FlowerParade.this.roles);
/*      */     }
/*      */     
/*      */ 
/*      */     public List<Long> getRolesAsData()
/*      */     {
/*  983 */       FlowerParade.this._xdb_verify_unsafe_();
/*      */       
/*  985 */       FlowerParade _o_ = FlowerParade.this;
/*  986 */       List<Long> roles = new ArrayList();
/*  987 */       roles.addAll(_o_.roles);
/*  988 */       return roles;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getOcpid()
/*      */     {
/*  995 */       FlowerParade.this._xdb_verify_unsafe_();
/*  996 */       return FlowerParade.this.ocpid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getMapid()
/*      */     {
/* 1003 */       FlowerParade.this._xdb_verify_unsafe_();
/* 1004 */       return FlowerParade.this.mapid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getDanceindex()
/*      */     {
/* 1011 */       FlowerParade.this._xdb_verify_unsafe_();
/* 1012 */       return FlowerParade.this.danceindex;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getToposindex()
/*      */     {
/* 1019 */       FlowerParade.this._xdb_verify_unsafe_();
/* 1020 */       return FlowerParade.this.toposindex;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, Long> getFollowtimestart()
/*      */     {
/* 1027 */       FlowerParade.this._xdb_verify_unsafe_();
/* 1028 */       return xdb.Consts.constMap(FlowerParade.this.followtimestart);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, Long> getFollowtimestartAsData()
/*      */     {
/* 1035 */       FlowerParade.this._xdb_verify_unsafe_();
/*      */       
/* 1037 */       FlowerParade _o_ = FlowerParade.this;
/* 1038 */       Map<Long, Long> followtimestart = new HashMap();
/* 1039 */       for (Map.Entry<Long, Long> _e_ : _o_.followtimestart.entrySet())
/* 1040 */         followtimestart.put(_e_.getKey(), _e_.getValue());
/* 1041 */       return followtimestart;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getState()
/*      */     {
/* 1048 */       FlowerParade.this._xdb_verify_unsafe_();
/* 1049 */       return FlowerParade.this.state;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getSessionidrest()
/*      */     {
/* 1056 */       FlowerParade.this._xdb_verify_unsafe_();
/* 1057 */       return FlowerParade.this.sessionidrest;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getSessionidcountdown()
/*      */     {
/* 1064 */       FlowerParade.this._xdb_verify_unsafe_();
/* 1065 */       return FlowerParade.this.sessionidcountdown;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getFlowerinstanceid()
/*      */     {
/* 1072 */       FlowerParade.this._xdb_verify_unsafe_();
/* 1073 */       return FlowerParade.this.flowerinstanceid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Long> getFlowerroleiddoneset()
/*      */     {
/* 1080 */       FlowerParade.this._xdb_verify_unsafe_();
/* 1081 */       return xdb.Consts.constSet(FlowerParade.this.flowerroleiddoneset);
/*      */     }
/*      */     
/*      */ 
/*      */     public Set<Long> getFlowerroleiddonesetAsData()
/*      */     {
/* 1087 */       FlowerParade.this._xdb_verify_unsafe_();
/*      */       
/* 1089 */       FlowerParade _o_ = FlowerParade.this;
/* 1090 */       Set<Long> flowerroleiddoneset = new SetX();
/* 1091 */       flowerroleiddoneset.addAll(_o_.flowerroleiddoneset);
/* 1092 */       return flowerroleiddoneset;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getStarttimeinsec()
/*      */     {
/* 1099 */       FlowerParade.this._xdb_verify_unsafe_();
/* 1100 */       return FlowerParade.this.starttimeinsec;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getSessionidstopcountdown()
/*      */     {
/* 1107 */       FlowerParade.this._xdb_verify_unsafe_();
/* 1108 */       return FlowerParade.this.sessionidstopcountdown;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getParadeindex()
/*      */     {
/* 1115 */       FlowerParade.this._xdb_verify_unsafe_();
/* 1116 */       return FlowerParade.this.paradeindex;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setOcpid(int _v_)
/*      */     {
/* 1123 */       FlowerParade.this._xdb_verify_unsafe_();
/* 1124 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMapid(int _v_)
/*      */     {
/* 1131 */       FlowerParade.this._xdb_verify_unsafe_();
/* 1132 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setDanceindex(int _v_)
/*      */     {
/* 1139 */       FlowerParade.this._xdb_verify_unsafe_();
/* 1140 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setToposindex(int _v_)
/*      */     {
/* 1147 */       FlowerParade.this._xdb_verify_unsafe_();
/* 1148 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setState(int _v_)
/*      */     {
/* 1155 */       FlowerParade.this._xdb_verify_unsafe_();
/* 1156 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setSessionidrest(long _v_)
/*      */     {
/* 1163 */       FlowerParade.this._xdb_verify_unsafe_();
/* 1164 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setSessionidcountdown(long _v_)
/*      */     {
/* 1171 */       FlowerParade.this._xdb_verify_unsafe_();
/* 1172 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setFlowerinstanceid(long _v_)
/*      */     {
/* 1179 */       FlowerParade.this._xdb_verify_unsafe_();
/* 1180 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setStarttimeinsec(long _v_)
/*      */     {
/* 1187 */       FlowerParade.this._xdb_verify_unsafe_();
/* 1188 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setSessionidstopcountdown(long _v_)
/*      */     {
/* 1195 */       FlowerParade.this._xdb_verify_unsafe_();
/* 1196 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setParadeindex(long _v_)
/*      */     {
/* 1203 */       FlowerParade.this._xdb_verify_unsafe_();
/* 1204 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/* 1210 */       FlowerParade.this._xdb_verify_unsafe_();
/* 1211 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/* 1217 */       FlowerParade.this._xdb_verify_unsafe_();
/* 1218 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/* 1224 */       return FlowerParade.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/* 1230 */       return FlowerParade.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/* 1236 */       FlowerParade.this._xdb_verify_unsafe_();
/* 1237 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/* 1243 */       return FlowerParade.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/* 1249 */       return FlowerParade.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/* 1255 */       FlowerParade.this._xdb_verify_unsafe_();
/* 1256 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/* 1262 */       return FlowerParade.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1268 */       return FlowerParade.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/* 1274 */       return FlowerParade.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/* 1280 */       return FlowerParade.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/* 1286 */       return FlowerParade.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/* 1292 */       return FlowerParade.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1298 */       return FlowerParade.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.FlowerParade
/*      */   {
/*      */     private ArrayList<Long> roles;
/*      */     
/*      */     private int ocpid;
/*      */     
/*      */     private int mapid;
/*      */     
/*      */     private int danceindex;
/*      */     
/*      */     private int toposindex;
/*      */     
/*      */     private HashMap<Long, Long> followtimestart;
/*      */     
/*      */     private int state;
/*      */     
/*      */     private long sessionidrest;
/*      */     
/*      */     private long sessionidcountdown;
/*      */     
/*      */     private long flowerinstanceid;
/*      */     
/*      */     private HashSet<Long> flowerroleiddoneset;
/*      */     
/*      */     private long starttimeinsec;
/*      */     
/*      */     private long sessionidstopcountdown;
/*      */     
/*      */     private long paradeindex;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/* 1336 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/* 1341 */       this.roles = new ArrayList();
/* 1342 */       this.followtimestart = new HashMap();
/* 1343 */       this.sessionidrest = 0L;
/* 1344 */       this.sessionidcountdown = 0L;
/* 1345 */       this.flowerinstanceid = 0L;
/* 1346 */       this.flowerroleiddoneset = new HashSet();
/* 1347 */       this.sessionidstopcountdown = 0L;
/* 1348 */       this.paradeindex = 0L;
/*      */     }
/*      */     
/*      */     Data(xbean.FlowerParade _o1_)
/*      */     {
/* 1353 */       if ((_o1_ instanceof FlowerParade)) { assign((FlowerParade)_o1_);
/* 1354 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 1355 */       } else if ((_o1_ instanceof FlowerParade.Const)) assign(((FlowerParade.Const)_o1_).nThis()); else {
/* 1356 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(FlowerParade _o_) {
/* 1361 */       this.roles = new ArrayList();
/* 1362 */       this.roles.addAll(_o_.roles);
/* 1363 */       this.ocpid = _o_.ocpid;
/* 1364 */       this.mapid = _o_.mapid;
/* 1365 */       this.danceindex = _o_.danceindex;
/* 1366 */       this.toposindex = _o_.toposindex;
/* 1367 */       this.followtimestart = new HashMap();
/* 1368 */       for (Map.Entry<Long, Long> _e_ : _o_.followtimestart.entrySet())
/* 1369 */         this.followtimestart.put(_e_.getKey(), _e_.getValue());
/* 1370 */       this.state = _o_.state;
/* 1371 */       this.sessionidrest = _o_.sessionidrest;
/* 1372 */       this.sessionidcountdown = _o_.sessionidcountdown;
/* 1373 */       this.flowerinstanceid = _o_.flowerinstanceid;
/* 1374 */       this.flowerroleiddoneset = new HashSet();
/* 1375 */       this.flowerroleiddoneset.addAll(_o_.flowerroleiddoneset);
/* 1376 */       this.starttimeinsec = _o_.starttimeinsec;
/* 1377 */       this.sessionidstopcountdown = _o_.sessionidstopcountdown;
/* 1378 */       this.paradeindex = _o_.paradeindex;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/* 1383 */       this.roles = new ArrayList();
/* 1384 */       this.roles.addAll(_o_.roles);
/* 1385 */       this.ocpid = _o_.ocpid;
/* 1386 */       this.mapid = _o_.mapid;
/* 1387 */       this.danceindex = _o_.danceindex;
/* 1388 */       this.toposindex = _o_.toposindex;
/* 1389 */       this.followtimestart = new HashMap();
/* 1390 */       for (Map.Entry<Long, Long> _e_ : _o_.followtimestart.entrySet())
/* 1391 */         this.followtimestart.put(_e_.getKey(), _e_.getValue());
/* 1392 */       this.state = _o_.state;
/* 1393 */       this.sessionidrest = _o_.sessionidrest;
/* 1394 */       this.sessionidcountdown = _o_.sessionidcountdown;
/* 1395 */       this.flowerinstanceid = _o_.flowerinstanceid;
/* 1396 */       this.flowerroleiddoneset = new HashSet();
/* 1397 */       this.flowerroleiddoneset.addAll(_o_.flowerroleiddoneset);
/* 1398 */       this.starttimeinsec = _o_.starttimeinsec;
/* 1399 */       this.sessionidstopcountdown = _o_.sessionidstopcountdown;
/* 1400 */       this.paradeindex = _o_.paradeindex;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/* 1406 */       _os_.compact_uint32(this.roles.size());
/* 1407 */       for (Long _v_ : this.roles)
/*      */       {
/* 1409 */         _os_.marshal(_v_.longValue());
/*      */       }
/* 1411 */       _os_.marshal(this.ocpid);
/* 1412 */       _os_.marshal(this.mapid);
/* 1413 */       _os_.marshal(this.danceindex);
/* 1414 */       _os_.marshal(this.toposindex);
/* 1415 */       _os_.compact_uint32(this.followtimestart.size());
/* 1416 */       for (Map.Entry<Long, Long> _e_ : this.followtimestart.entrySet())
/*      */       {
/* 1418 */         _os_.marshal(((Long)_e_.getKey()).longValue());
/* 1419 */         _os_.marshal(((Long)_e_.getValue()).longValue());
/*      */       }
/* 1421 */       _os_.marshal(this.state);
/* 1422 */       _os_.marshal(this.sessionidrest);
/* 1423 */       _os_.marshal(this.sessionidcountdown);
/* 1424 */       _os_.marshal(this.flowerinstanceid);
/* 1425 */       _os_.compact_uint32(this.flowerroleiddoneset.size());
/* 1426 */       for (Long _v_ : this.flowerroleiddoneset)
/*      */       {
/* 1428 */         _os_.marshal(_v_.longValue());
/*      */       }
/* 1430 */       _os_.marshal(this.starttimeinsec);
/* 1431 */       _os_.marshal(this.sessionidstopcountdown);
/* 1432 */       _os_.marshal(this.paradeindex);
/* 1433 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/* 1439 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/* 1441 */         long _v_ = 0L;
/* 1442 */         _v_ = _os_.unmarshal_long();
/* 1443 */         this.roles.add(Long.valueOf(_v_));
/*      */       }
/* 1445 */       this.ocpid = _os_.unmarshal_int();
/* 1446 */       this.mapid = _os_.unmarshal_int();
/* 1447 */       this.danceindex = _os_.unmarshal_int();
/* 1448 */       this.toposindex = _os_.unmarshal_int();
/*      */       
/* 1450 */       int size = _os_.uncompact_uint32();
/* 1451 */       if (size >= 12)
/*      */       {
/* 1453 */         this.followtimestart = new HashMap(size * 2);
/*      */       }
/* 1455 */       for (; size > 0; size--)
/*      */       {
/* 1457 */         long _k_ = 0L;
/* 1458 */         _k_ = _os_.unmarshal_long();
/* 1459 */         long _v_ = 0L;
/* 1460 */         _v_ = _os_.unmarshal_long();
/* 1461 */         this.followtimestart.put(Long.valueOf(_k_), Long.valueOf(_v_));
/*      */       }
/*      */       
/* 1464 */       this.state = _os_.unmarshal_int();
/* 1465 */       this.sessionidrest = _os_.unmarshal_long();
/* 1466 */       this.sessionidcountdown = _os_.unmarshal_long();
/* 1467 */       this.flowerinstanceid = _os_.unmarshal_long();
/* 1468 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/* 1470 */         long _v_ = 0L;
/* 1471 */         _v_ = _os_.unmarshal_long();
/* 1472 */         this.flowerroleiddoneset.add(Long.valueOf(_v_));
/*      */       }
/* 1474 */       this.starttimeinsec = _os_.unmarshal_long();
/* 1475 */       this.sessionidstopcountdown = _os_.unmarshal_long();
/* 1476 */       this.paradeindex = _os_.unmarshal_long();
/* 1477 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/* 1483 */       int _size_ = 0;
/* 1484 */       for (Long _v_ : this.roles)
/*      */       {
/* 1486 */         _size_ += CodedOutputStream.computeInt64Size(1, _v_.longValue());
/*      */       }
/* 1488 */       _size_ += CodedOutputStream.computeInt32Size(2, this.ocpid);
/* 1489 */       _size_ += CodedOutputStream.computeInt32Size(3, this.mapid);
/* 1490 */       _size_ += CodedOutputStream.computeInt32Size(4, this.danceindex);
/* 1491 */       _size_ += CodedOutputStream.computeInt32Size(5, this.toposindex);
/* 1492 */       for (Map.Entry<Long, Long> _e_ : this.followtimestart.entrySet())
/*      */       {
/* 1494 */         _size_ += CodedOutputStream.computeInt64Size(6, ((Long)_e_.getKey()).longValue());
/* 1495 */         _size_ += CodedOutputStream.computeInt64Size(6, ((Long)_e_.getValue()).longValue());
/*      */       }
/* 1497 */       _size_ += CodedOutputStream.computeInt32Size(7, this.state);
/* 1498 */       _size_ += CodedOutputStream.computeInt64Size(8, this.sessionidrest);
/* 1499 */       _size_ += CodedOutputStream.computeInt64Size(9, this.sessionidcountdown);
/* 1500 */       _size_ += CodedOutputStream.computeInt64Size(10, this.flowerinstanceid);
/* 1501 */       for (Long _v_ : this.flowerroleiddoneset)
/*      */       {
/* 1503 */         _size_ += CodedOutputStream.computeInt64Size(11, _v_.longValue());
/*      */       }
/* 1505 */       _size_ += CodedOutputStream.computeInt64Size(12, this.starttimeinsec);
/* 1506 */       _size_ += CodedOutputStream.computeInt64Size(13, this.sessionidstopcountdown);
/* 1507 */       _size_ += CodedOutputStream.computeInt64Size(14, this.paradeindex);
/* 1508 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1516 */         for (Long _v_ : this.roles)
/*      */         {
/* 1518 */           _output_.writeInt64(1, _v_.longValue());
/*      */         }
/* 1520 */         _output_.writeInt32(2, this.ocpid);
/* 1521 */         _output_.writeInt32(3, this.mapid);
/* 1522 */         _output_.writeInt32(4, this.danceindex);
/* 1523 */         _output_.writeInt32(5, this.toposindex);
/* 1524 */         for (Map.Entry<Long, Long> _e_ : this.followtimestart.entrySet())
/*      */         {
/* 1526 */           _output_.writeInt64(6, ((Long)_e_.getKey()).longValue());
/* 1527 */           _output_.writeInt64(6, ((Long)_e_.getValue()).longValue());
/*      */         }
/* 1529 */         _output_.writeInt32(7, this.state);
/* 1530 */         _output_.writeInt64(8, this.sessionidrest);
/* 1531 */         _output_.writeInt64(9, this.sessionidcountdown);
/* 1532 */         _output_.writeInt64(10, this.flowerinstanceid);
/* 1533 */         for (Long _v_ : this.flowerroleiddoneset)
/*      */         {
/* 1535 */           _output_.writeInt64(11, _v_.longValue());
/*      */         }
/* 1537 */         _output_.writeInt64(12, this.starttimeinsec);
/* 1538 */         _output_.writeInt64(13, this.sessionidstopcountdown);
/* 1539 */         _output_.writeInt64(14, this.paradeindex);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1543 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1545 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1553 */         boolean done = false;
/* 1554 */         while (!done)
/*      */         {
/* 1556 */           int tag = _input_.readTag();
/* 1557 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/* 1561 */             done = true;
/* 1562 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/* 1566 */             long _v_ = 0L;
/* 1567 */             _v_ = _input_.readInt64();
/* 1568 */             this.roles.add(Long.valueOf(_v_));
/* 1569 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/* 1573 */             this.ocpid = _input_.readInt32();
/* 1574 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/* 1578 */             this.mapid = _input_.readInt32();
/* 1579 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/* 1583 */             this.danceindex = _input_.readInt32();
/* 1584 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/* 1588 */             this.toposindex = _input_.readInt32();
/* 1589 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/* 1593 */             long _k_ = 0L;
/* 1594 */             _k_ = _input_.readInt64();
/* 1595 */             int readTag = _input_.readTag();
/* 1596 */             if (48 != readTag)
/*      */             {
/* 1598 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 1600 */             long _v_ = 0L;
/* 1601 */             _v_ = _input_.readInt64();
/* 1602 */             this.followtimestart.put(Long.valueOf(_k_), Long.valueOf(_v_));
/* 1603 */             break;
/*      */           
/*      */ 
/*      */           case 56: 
/* 1607 */             this.state = _input_.readInt32();
/* 1608 */             break;
/*      */           
/*      */ 
/*      */           case 64: 
/* 1612 */             this.sessionidrest = _input_.readInt64();
/* 1613 */             break;
/*      */           
/*      */ 
/*      */           case 72: 
/* 1617 */             this.sessionidcountdown = _input_.readInt64();
/* 1618 */             break;
/*      */           
/*      */ 
/*      */           case 80: 
/* 1622 */             this.flowerinstanceid = _input_.readInt64();
/* 1623 */             break;
/*      */           
/*      */ 
/*      */           case 88: 
/* 1627 */             long _v_ = 0L;
/* 1628 */             _v_ = _input_.readInt64();
/* 1629 */             this.flowerroleiddoneset.add(Long.valueOf(_v_));
/* 1630 */             break;
/*      */           
/*      */ 
/*      */           case 96: 
/* 1634 */             this.starttimeinsec = _input_.readInt64();
/* 1635 */             break;
/*      */           
/*      */ 
/*      */           case 104: 
/* 1639 */             this.sessionidstopcountdown = _input_.readInt64();
/* 1640 */             break;
/*      */           
/*      */ 
/*      */           case 112: 
/* 1644 */             this.paradeindex = _input_.readInt64();
/* 1645 */             break;
/*      */           
/*      */ 
/*      */           default: 
/* 1649 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/* 1651 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/* 1660 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1664 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1666 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.FlowerParade copy()
/*      */     {
/* 1672 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.FlowerParade toData()
/*      */     {
/* 1678 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.FlowerParade toBean()
/*      */     {
/* 1683 */       return new FlowerParade(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.FlowerParade toDataIf()
/*      */     {
/* 1689 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.FlowerParade toBeanIf()
/*      */     {
/* 1694 */       return new FlowerParade(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1700 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/* 1704 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1708 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1712 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/* 1716 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1720 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1724 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getRoles()
/*      */     {
/* 1731 */       return this.roles;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getRolesAsData()
/*      */     {
/* 1738 */       return this.roles;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getOcpid()
/*      */     {
/* 1745 */       return this.ocpid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getMapid()
/*      */     {
/* 1752 */       return this.mapid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getDanceindex()
/*      */     {
/* 1759 */       return this.danceindex;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getToposindex()
/*      */     {
/* 1766 */       return this.toposindex;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, Long> getFollowtimestart()
/*      */     {
/* 1773 */       return this.followtimestart;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, Long> getFollowtimestartAsData()
/*      */     {
/* 1780 */       return this.followtimestart;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getState()
/*      */     {
/* 1787 */       return this.state;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getSessionidrest()
/*      */     {
/* 1794 */       return this.sessionidrest;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getSessionidcountdown()
/*      */     {
/* 1801 */       return this.sessionidcountdown;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getFlowerinstanceid()
/*      */     {
/* 1808 */       return this.flowerinstanceid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Long> getFlowerroleiddoneset()
/*      */     {
/* 1815 */       return this.flowerroleiddoneset;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Long> getFlowerroleiddonesetAsData()
/*      */     {
/* 1822 */       return this.flowerroleiddoneset;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getStarttimeinsec()
/*      */     {
/* 1829 */       return this.starttimeinsec;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getSessionidstopcountdown()
/*      */     {
/* 1836 */       return this.sessionidstopcountdown;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getParadeindex()
/*      */     {
/* 1843 */       return this.paradeindex;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setOcpid(int _v_)
/*      */     {
/* 1850 */       this.ocpid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMapid(int _v_)
/*      */     {
/* 1857 */       this.mapid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setDanceindex(int _v_)
/*      */     {
/* 1864 */       this.danceindex = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setToposindex(int _v_)
/*      */     {
/* 1871 */       this.toposindex = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setState(int _v_)
/*      */     {
/* 1878 */       this.state = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setSessionidrest(long _v_)
/*      */     {
/* 1885 */       this.sessionidrest = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setSessionidcountdown(long _v_)
/*      */     {
/* 1892 */       this.sessionidcountdown = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setFlowerinstanceid(long _v_)
/*      */     {
/* 1899 */       this.flowerinstanceid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setStarttimeinsec(long _v_)
/*      */     {
/* 1906 */       this.starttimeinsec = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setSessionidstopcountdown(long _v_)
/*      */     {
/* 1913 */       this.sessionidstopcountdown = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setParadeindex(long _v_)
/*      */     {
/* 1920 */       this.paradeindex = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1926 */       if (!(_o1_ instanceof Data)) return false;
/* 1927 */       Data _o_ = (Data)_o1_;
/* 1928 */       if (!this.roles.equals(_o_.roles)) return false;
/* 1929 */       if (this.ocpid != _o_.ocpid) return false;
/* 1930 */       if (this.mapid != _o_.mapid) return false;
/* 1931 */       if (this.danceindex != _o_.danceindex) return false;
/* 1932 */       if (this.toposindex != _o_.toposindex) return false;
/* 1933 */       if (!this.followtimestart.equals(_o_.followtimestart)) return false;
/* 1934 */       if (this.state != _o_.state) return false;
/* 1935 */       if (this.sessionidrest != _o_.sessionidrest) return false;
/* 1936 */       if (this.sessionidcountdown != _o_.sessionidcountdown) return false;
/* 1937 */       if (this.flowerinstanceid != _o_.flowerinstanceid) return false;
/* 1938 */       if (!this.flowerroleiddoneset.equals(_o_.flowerroleiddoneset)) return false;
/* 1939 */       if (this.starttimeinsec != _o_.starttimeinsec) return false;
/* 1940 */       if (this.sessionidstopcountdown != _o_.sessionidstopcountdown) return false;
/* 1941 */       if (this.paradeindex != _o_.paradeindex) return false;
/* 1942 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1948 */       int _h_ = 0;
/* 1949 */       _h_ += this.roles.hashCode();
/* 1950 */       _h_ += this.ocpid;
/* 1951 */       _h_ += this.mapid;
/* 1952 */       _h_ += this.danceindex;
/* 1953 */       _h_ += this.toposindex;
/* 1954 */       _h_ += this.followtimestart.hashCode();
/* 1955 */       _h_ += this.state;
/* 1956 */       _h_ = (int)(_h_ + this.sessionidrest);
/* 1957 */       _h_ = (int)(_h_ + this.sessionidcountdown);
/* 1958 */       _h_ = (int)(_h_ + this.flowerinstanceid);
/* 1959 */       _h_ += this.flowerroleiddoneset.hashCode();
/* 1960 */       _h_ = (int)(_h_ + this.starttimeinsec);
/* 1961 */       _h_ = (int)(_h_ + this.sessionidstopcountdown);
/* 1962 */       _h_ = (int)(_h_ + this.paradeindex);
/* 1963 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1969 */       StringBuilder _sb_ = new StringBuilder();
/* 1970 */       _sb_.append("(");
/* 1971 */       _sb_.append(this.roles);
/* 1972 */       _sb_.append(",");
/* 1973 */       _sb_.append(this.ocpid);
/* 1974 */       _sb_.append(",");
/* 1975 */       _sb_.append(this.mapid);
/* 1976 */       _sb_.append(",");
/* 1977 */       _sb_.append(this.danceindex);
/* 1978 */       _sb_.append(",");
/* 1979 */       _sb_.append(this.toposindex);
/* 1980 */       _sb_.append(",");
/* 1981 */       _sb_.append(this.followtimestart);
/* 1982 */       _sb_.append(",");
/* 1983 */       _sb_.append(this.state);
/* 1984 */       _sb_.append(",");
/* 1985 */       _sb_.append(this.sessionidrest);
/* 1986 */       _sb_.append(",");
/* 1987 */       _sb_.append(this.sessionidcountdown);
/* 1988 */       _sb_.append(",");
/* 1989 */       _sb_.append(this.flowerinstanceid);
/* 1990 */       _sb_.append(",");
/* 1991 */       _sb_.append(this.flowerroleiddoneset);
/* 1992 */       _sb_.append(",");
/* 1993 */       _sb_.append(this.starttimeinsec);
/* 1994 */       _sb_.append(",");
/* 1995 */       _sb_.append(this.sessionidstopcountdown);
/* 1996 */       _sb_.append(",");
/* 1997 */       _sb_.append(this.paradeindex);
/* 1998 */       _sb_.append(")");
/* 1999 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\FlowerParade.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */