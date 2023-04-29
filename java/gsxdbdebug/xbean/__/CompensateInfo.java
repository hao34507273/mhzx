/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import com.goldhuman.Common.Octets;
/*      */ import java.io.IOException;
/*      */ import java.io.UnsupportedEncodingException;
/*      */ import java.util.HashMap;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import ppbio.ByteString;
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
/*      */ 
/*      */ public final class CompensateInfo extends XBean implements xbean.CompensateInfo
/*      */ {
/*      */   private int mode;
/*      */   private int min_level;
/*      */   private int max_level;
/*      */   private long start_time;
/*      */   private long end_time;
/*      */   private String mail_title;
/*      */   private String mail_content;
/*      */   private HashMap<Integer, Integer> items;
/*      */   private HashMap<Integer, Integer> currencies;
/*      */   private long min_create_role_time;
/*      */   private long max_create_role_time;
/*      */   private int tagid;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   40 */     this.mode = 0;
/*   41 */     this.min_level = 0;
/*   42 */     this.max_level = 0;
/*   43 */     this.start_time = 0L;
/*   44 */     this.end_time = 0L;
/*   45 */     this.mail_title = "";
/*   46 */     this.mail_content = "";
/*   47 */     this.items.clear();
/*   48 */     this.currencies.clear();
/*   49 */     this.min_create_role_time = 0L;
/*   50 */     this.max_create_role_time = 0L;
/*   51 */     this.tagid = 0;
/*      */   }
/*      */   
/*      */   CompensateInfo(int __, XBean _xp_, String _vn_)
/*      */   {
/*   56 */     super(_xp_, _vn_);
/*   57 */     this.min_level = 0;
/*   58 */     this.max_level = 0;
/*   59 */     this.start_time = 0L;
/*   60 */     this.end_time = 0L;
/*   61 */     this.mail_title = "";
/*   62 */     this.mail_content = "";
/*   63 */     this.items = new HashMap();
/*   64 */     this.currencies = new HashMap();
/*   65 */     this.min_create_role_time = 0L;
/*   66 */     this.max_create_role_time = 0L;
/*   67 */     this.tagid = 0;
/*      */   }
/*      */   
/*      */   public CompensateInfo()
/*      */   {
/*   72 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public CompensateInfo(CompensateInfo _o_)
/*      */   {
/*   77 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   CompensateInfo(xbean.CompensateInfo _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   82 */     super(_xp_, _vn_);
/*   83 */     if ((_o1_ instanceof CompensateInfo)) { assign((CompensateInfo)_o1_);
/*   84 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   85 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   86 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(CompensateInfo _o_) {
/*   91 */     _o_._xdb_verify_unsafe_();
/*   92 */     this.mode = _o_.mode;
/*   93 */     this.min_level = _o_.min_level;
/*   94 */     this.max_level = _o_.max_level;
/*   95 */     this.start_time = _o_.start_time;
/*   96 */     this.end_time = _o_.end_time;
/*   97 */     this.mail_title = _o_.mail_title;
/*   98 */     this.mail_content = _o_.mail_content;
/*   99 */     this.items = new HashMap();
/*  100 */     for (Map.Entry<Integer, Integer> _e_ : _o_.items.entrySet())
/*  101 */       this.items.put(_e_.getKey(), _e_.getValue());
/*  102 */     this.currencies = new HashMap();
/*  103 */     for (Map.Entry<Integer, Integer> _e_ : _o_.currencies.entrySet())
/*  104 */       this.currencies.put(_e_.getKey(), _e_.getValue());
/*  105 */     this.min_create_role_time = _o_.min_create_role_time;
/*  106 */     this.max_create_role_time = _o_.max_create_role_time;
/*  107 */     this.tagid = _o_.tagid;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*  112 */     this.mode = _o_.mode;
/*  113 */     this.min_level = _o_.min_level;
/*  114 */     this.max_level = _o_.max_level;
/*  115 */     this.start_time = _o_.start_time;
/*  116 */     this.end_time = _o_.end_time;
/*  117 */     this.mail_title = _o_.mail_title;
/*  118 */     this.mail_content = _o_.mail_content;
/*  119 */     this.items = new HashMap();
/*  120 */     for (Map.Entry<Integer, Integer> _e_ : _o_.items.entrySet())
/*  121 */       this.items.put(_e_.getKey(), _e_.getValue());
/*  122 */     this.currencies = new HashMap();
/*  123 */     for (Map.Entry<Integer, Integer> _e_ : _o_.currencies.entrySet())
/*  124 */       this.currencies.put(_e_.getKey(), _e_.getValue());
/*  125 */     this.min_create_role_time = _o_.min_create_role_time;
/*  126 */     this.max_create_role_time = _o_.max_create_role_time;
/*  127 */     this.tagid = _o_.tagid;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*  133 */     _xdb_verify_unsafe_();
/*  134 */     _os_.marshal(this.mode);
/*  135 */     _os_.marshal(this.min_level);
/*  136 */     _os_.marshal(this.max_level);
/*  137 */     _os_.marshal(this.start_time);
/*  138 */     _os_.marshal(this.end_time);
/*  139 */     _os_.marshal(this.mail_title, "UTF-16LE");
/*  140 */     _os_.marshal(this.mail_content, "UTF-16LE");
/*  141 */     _os_.compact_uint32(this.items.size());
/*  142 */     for (Map.Entry<Integer, Integer> _e_ : this.items.entrySet())
/*      */     {
/*  144 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  145 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */     }
/*  147 */     _os_.compact_uint32(this.currencies.size());
/*  148 */     for (Map.Entry<Integer, Integer> _e_ : this.currencies.entrySet())
/*      */     {
/*  150 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  151 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */     }
/*  153 */     _os_.marshal(this.min_create_role_time);
/*  154 */     _os_.marshal(this.max_create_role_time);
/*  155 */     _os_.marshal(this.tagid);
/*  156 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  162 */     _xdb_verify_unsafe_();
/*  163 */     this.mode = _os_.unmarshal_int();
/*  164 */     this.min_level = _os_.unmarshal_int();
/*  165 */     this.max_level = _os_.unmarshal_int();
/*  166 */     this.start_time = _os_.unmarshal_long();
/*  167 */     this.end_time = _os_.unmarshal_long();
/*  168 */     this.mail_title = _os_.unmarshal_String("UTF-16LE");
/*  169 */     this.mail_content = _os_.unmarshal_String("UTF-16LE");
/*      */     
/*  171 */     int size = _os_.uncompact_uint32();
/*  172 */     if (size >= 12)
/*      */     {
/*  174 */       this.items = new HashMap(size * 2);
/*      */     }
/*  176 */     for (; size > 0; size--)
/*      */     {
/*  178 */       int _k_ = 0;
/*  179 */       _k_ = _os_.unmarshal_int();
/*  180 */       int _v_ = 0;
/*  181 */       _v_ = _os_.unmarshal_int();
/*  182 */       this.items.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*      */     }
/*      */     
/*      */ 
/*  186 */     int size = _os_.uncompact_uint32();
/*  187 */     if (size >= 12)
/*      */     {
/*  189 */       this.currencies = new HashMap(size * 2);
/*      */     }
/*  191 */     for (; size > 0; size--)
/*      */     {
/*  193 */       int _k_ = 0;
/*  194 */       _k_ = _os_.unmarshal_int();
/*  195 */       int _v_ = 0;
/*  196 */       _v_ = _os_.unmarshal_int();
/*  197 */       this.currencies.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*      */     }
/*      */     
/*  200 */     this.min_create_role_time = _os_.unmarshal_long();
/*  201 */     this.max_create_role_time = _os_.unmarshal_long();
/*  202 */     this.tagid = _os_.unmarshal_int();
/*  203 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  209 */     _xdb_verify_unsafe_();
/*  210 */     int _size_ = 0;
/*  211 */     _size_ += CodedOutputStream.computeInt32Size(1, this.mode);
/*  212 */     _size_ += CodedOutputStream.computeInt32Size(2, this.min_level);
/*  213 */     _size_ += CodedOutputStream.computeInt32Size(3, this.max_level);
/*  214 */     _size_ += CodedOutputStream.computeInt64Size(4, this.start_time);
/*  215 */     _size_ += CodedOutputStream.computeInt64Size(5, this.end_time);
/*      */     try
/*      */     {
/*  218 */       _size_ += CodedOutputStream.computeBytesSize(6, ByteString.copyFrom(this.mail_title, "UTF-16LE"));
/*      */     }
/*      */     catch (UnsupportedEncodingException e)
/*      */     {
/*  222 */       throw new RuntimeException("UTF-16LE not supported?", e);
/*      */     }
/*      */     try
/*      */     {
/*  226 */       _size_ += CodedOutputStream.computeBytesSize(7, ByteString.copyFrom(this.mail_content, "UTF-16LE"));
/*      */     }
/*      */     catch (UnsupportedEncodingException e)
/*      */     {
/*  230 */       throw new RuntimeException("UTF-16LE not supported?", e);
/*      */     }
/*  232 */     for (Map.Entry<Integer, Integer> _e_ : this.items.entrySet())
/*      */     {
/*  234 */       _size_ += CodedOutputStream.computeInt32Size(8, ((Integer)_e_.getKey()).intValue());
/*  235 */       _size_ += CodedOutputStream.computeInt32Size(8, ((Integer)_e_.getValue()).intValue());
/*      */     }
/*  237 */     for (Map.Entry<Integer, Integer> _e_ : this.currencies.entrySet())
/*      */     {
/*  239 */       _size_ += CodedOutputStream.computeInt32Size(9, ((Integer)_e_.getKey()).intValue());
/*  240 */       _size_ += CodedOutputStream.computeInt32Size(9, ((Integer)_e_.getValue()).intValue());
/*      */     }
/*  242 */     _size_ += CodedOutputStream.computeInt64Size(10, this.min_create_role_time);
/*  243 */     _size_ += CodedOutputStream.computeInt64Size(11, this.max_create_role_time);
/*  244 */     _size_ += CodedOutputStream.computeInt32Size(12, this.tagid);
/*  245 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  251 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  254 */       _output_.writeInt32(1, this.mode);
/*  255 */       _output_.writeInt32(2, this.min_level);
/*  256 */       _output_.writeInt32(3, this.max_level);
/*  257 */       _output_.writeInt64(4, this.start_time);
/*  258 */       _output_.writeInt64(5, this.end_time);
/*  259 */       _output_.writeBytes(6, ByteString.copyFrom(this.mail_title, "UTF-16LE"));
/*  260 */       _output_.writeBytes(7, ByteString.copyFrom(this.mail_content, "UTF-16LE"));
/*  261 */       for (Map.Entry<Integer, Integer> _e_ : this.items.entrySet())
/*      */       {
/*  263 */         _output_.writeInt32(8, ((Integer)_e_.getKey()).intValue());
/*  264 */         _output_.writeInt32(8, ((Integer)_e_.getValue()).intValue());
/*      */       }
/*  266 */       for (Map.Entry<Integer, Integer> _e_ : this.currencies.entrySet())
/*      */       {
/*  268 */         _output_.writeInt32(9, ((Integer)_e_.getKey()).intValue());
/*  269 */         _output_.writeInt32(9, ((Integer)_e_.getValue()).intValue());
/*      */       }
/*  271 */       _output_.writeInt64(10, this.min_create_role_time);
/*  272 */       _output_.writeInt64(11, this.max_create_role_time);
/*  273 */       _output_.writeInt32(12, this.tagid);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  277 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  279 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  285 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  288 */       boolean done = false;
/*  289 */       while (!done)
/*      */       {
/*  291 */         int tag = _input_.readTag();
/*  292 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  296 */           done = true;
/*  297 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  301 */           this.mode = _input_.readInt32();
/*  302 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  306 */           this.min_level = _input_.readInt32();
/*  307 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  311 */           this.max_level = _input_.readInt32();
/*  312 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  316 */           this.start_time = _input_.readInt64();
/*  317 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  321 */           this.end_time = _input_.readInt64();
/*  322 */           break;
/*      */         
/*      */ 
/*      */         case 50: 
/*  326 */           this.mail_title = _input_.readBytes().toString("UTF-16LE");
/*  327 */           break;
/*      */         
/*      */ 
/*      */         case 58: 
/*  331 */           this.mail_content = _input_.readBytes().toString("UTF-16LE");
/*  332 */           break;
/*      */         
/*      */ 
/*      */         case 64: 
/*  336 */           int _k_ = 0;
/*  337 */           _k_ = _input_.readInt32();
/*  338 */           int readTag = _input_.readTag();
/*  339 */           if (64 != readTag)
/*      */           {
/*  341 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  343 */           int _v_ = 0;
/*  344 */           _v_ = _input_.readInt32();
/*  345 */           this.items.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*  346 */           break;
/*      */         
/*      */ 
/*      */         case 72: 
/*  350 */           int _k_ = 0;
/*  351 */           _k_ = _input_.readInt32();
/*  352 */           int readTag = _input_.readTag();
/*  353 */           if (72 != readTag)
/*      */           {
/*  355 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  357 */           int _v_ = 0;
/*  358 */           _v_ = _input_.readInt32();
/*  359 */           this.currencies.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*  360 */           break;
/*      */         
/*      */ 
/*      */         case 80: 
/*  364 */           this.min_create_role_time = _input_.readInt64();
/*  365 */           break;
/*      */         
/*      */ 
/*      */         case 88: 
/*  369 */           this.max_create_role_time = _input_.readInt64();
/*  370 */           break;
/*      */         
/*      */ 
/*      */         case 96: 
/*  374 */           this.tagid = _input_.readInt32();
/*  375 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  379 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  381 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  390 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  394 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  396 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.CompensateInfo copy()
/*      */   {
/*  402 */     _xdb_verify_unsafe_();
/*  403 */     return new CompensateInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.CompensateInfo toData()
/*      */   {
/*  409 */     _xdb_verify_unsafe_();
/*  410 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.CompensateInfo toBean()
/*      */   {
/*  415 */     _xdb_verify_unsafe_();
/*  416 */     return new CompensateInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.CompensateInfo toDataIf()
/*      */   {
/*  422 */     _xdb_verify_unsafe_();
/*  423 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.CompensateInfo toBeanIf()
/*      */   {
/*  428 */     _xdb_verify_unsafe_();
/*  429 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  435 */     _xdb_verify_unsafe_();
/*  436 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getMode()
/*      */   {
/*  443 */     _xdb_verify_unsafe_();
/*  444 */     return this.mode;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getMin_level()
/*      */   {
/*  451 */     _xdb_verify_unsafe_();
/*  452 */     return this.min_level;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getMax_level()
/*      */   {
/*  459 */     _xdb_verify_unsafe_();
/*  460 */     return this.max_level;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getStart_time()
/*      */   {
/*  467 */     _xdb_verify_unsafe_();
/*  468 */     return this.start_time;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getEnd_time()
/*      */   {
/*  475 */     _xdb_verify_unsafe_();
/*  476 */     return this.end_time;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public String getMail_title()
/*      */   {
/*  483 */     _xdb_verify_unsafe_();
/*  484 */     return this.mail_title;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Octets getMail_titleOctets()
/*      */   {
/*  491 */     _xdb_verify_unsafe_();
/*  492 */     return Octets.wrap(getMail_title(), "UTF-16LE");
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public String getMail_content()
/*      */   {
/*  499 */     _xdb_verify_unsafe_();
/*  500 */     return this.mail_content;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Octets getMail_contentOctets()
/*      */   {
/*  507 */     _xdb_verify_unsafe_();
/*  508 */     return Octets.wrap(getMail_content(), "UTF-16LE");
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getItems()
/*      */   {
/*  515 */     _xdb_verify_unsafe_();
/*  516 */     return Logs.logMap(new LogKey(this, "items"), this.items);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getItemsAsData()
/*      */   {
/*  523 */     _xdb_verify_unsafe_();
/*      */     
/*  525 */     CompensateInfo _o_ = this;
/*  526 */     Map<Integer, Integer> items = new HashMap();
/*  527 */     for (Map.Entry<Integer, Integer> _e_ : _o_.items.entrySet())
/*  528 */       items.put(_e_.getKey(), _e_.getValue());
/*  529 */     return items;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getCurrencies()
/*      */   {
/*  536 */     _xdb_verify_unsafe_();
/*  537 */     return Logs.logMap(new LogKey(this, "currencies"), this.currencies);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getCurrenciesAsData()
/*      */   {
/*  544 */     _xdb_verify_unsafe_();
/*      */     
/*  546 */     CompensateInfo _o_ = this;
/*  547 */     Map<Integer, Integer> currencies = new HashMap();
/*  548 */     for (Map.Entry<Integer, Integer> _e_ : _o_.currencies.entrySet())
/*  549 */       currencies.put(_e_.getKey(), _e_.getValue());
/*  550 */     return currencies;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getMin_create_role_time()
/*      */   {
/*  557 */     _xdb_verify_unsafe_();
/*  558 */     return this.min_create_role_time;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getMax_create_role_time()
/*      */   {
/*  565 */     _xdb_verify_unsafe_();
/*  566 */     return this.max_create_role_time;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getTagid()
/*      */   {
/*  573 */     _xdb_verify_unsafe_();
/*  574 */     return this.tagid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setMode(int _v_)
/*      */   {
/*  581 */     _xdb_verify_unsafe_();
/*  582 */     Logs.logIf(new LogKey(this, "mode")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  586 */         new LogInt(this, CompensateInfo.this.mode)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  590 */             CompensateInfo.this.mode = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  594 */     });
/*  595 */     this.mode = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setMin_level(int _v_)
/*      */   {
/*  602 */     _xdb_verify_unsafe_();
/*  603 */     Logs.logIf(new LogKey(this, "min_level")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  607 */         new LogInt(this, CompensateInfo.this.min_level)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  611 */             CompensateInfo.this.min_level = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  615 */     });
/*  616 */     this.min_level = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setMax_level(int _v_)
/*      */   {
/*  623 */     _xdb_verify_unsafe_();
/*  624 */     Logs.logIf(new LogKey(this, "max_level")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  628 */         new LogInt(this, CompensateInfo.this.max_level)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  632 */             CompensateInfo.this.max_level = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  636 */     });
/*  637 */     this.max_level = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setStart_time(long _v_)
/*      */   {
/*  644 */     _xdb_verify_unsafe_();
/*  645 */     Logs.logIf(new LogKey(this, "start_time")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  649 */         new LogLong(this, CompensateInfo.this.start_time)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  653 */             CompensateInfo.this.start_time = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  657 */     });
/*  658 */     this.start_time = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setEnd_time(long _v_)
/*      */   {
/*  665 */     _xdb_verify_unsafe_();
/*  666 */     Logs.logIf(new LogKey(this, "end_time")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  670 */         new LogLong(this, CompensateInfo.this.end_time)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  674 */             CompensateInfo.this.end_time = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  678 */     });
/*  679 */     this.end_time = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setMail_title(String _v_)
/*      */   {
/*  686 */     _xdb_verify_unsafe_();
/*  687 */     if (null == _v_)
/*  688 */       throw new NullPointerException();
/*  689 */     Logs.logIf(new LogKey(this, "mail_title")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  693 */         new xdb.logs.LogString(this, CompensateInfo.this.mail_title)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  697 */             CompensateInfo.this.mail_title = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  701 */     });
/*  702 */     this.mail_title = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setMail_titleOctets(Octets _v_)
/*      */   {
/*  709 */     _xdb_verify_unsafe_();
/*  710 */     setMail_title(_v_.getString("UTF-16LE"));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setMail_content(String _v_)
/*      */   {
/*  717 */     _xdb_verify_unsafe_();
/*  718 */     if (null == _v_)
/*  719 */       throw new NullPointerException();
/*  720 */     Logs.logIf(new LogKey(this, "mail_content")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  724 */         new xdb.logs.LogString(this, CompensateInfo.this.mail_content)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  728 */             CompensateInfo.this.mail_content = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  732 */     });
/*  733 */     this.mail_content = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setMail_contentOctets(Octets _v_)
/*      */   {
/*  740 */     _xdb_verify_unsafe_();
/*  741 */     setMail_content(_v_.getString("UTF-16LE"));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setMin_create_role_time(long _v_)
/*      */   {
/*  748 */     _xdb_verify_unsafe_();
/*  749 */     Logs.logIf(new LogKey(this, "min_create_role_time")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  753 */         new LogLong(this, CompensateInfo.this.min_create_role_time)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  757 */             CompensateInfo.this.min_create_role_time = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  761 */     });
/*  762 */     this.min_create_role_time = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setMax_create_role_time(long _v_)
/*      */   {
/*  769 */     _xdb_verify_unsafe_();
/*  770 */     Logs.logIf(new LogKey(this, "max_create_role_time")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  774 */         new LogLong(this, CompensateInfo.this.max_create_role_time)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  778 */             CompensateInfo.this.max_create_role_time = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  782 */     });
/*  783 */     this.max_create_role_time = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setTagid(int _v_)
/*      */   {
/*  790 */     _xdb_verify_unsafe_();
/*  791 */     Logs.logIf(new LogKey(this, "tagid")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  795 */         new LogInt(this, CompensateInfo.this.tagid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  799 */             CompensateInfo.this.tagid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  803 */     });
/*  804 */     this.tagid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  810 */     _xdb_verify_unsafe_();
/*  811 */     CompensateInfo _o_ = null;
/*  812 */     if ((_o1_ instanceof CompensateInfo)) { _o_ = (CompensateInfo)_o1_;
/*  813 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  814 */       return false;
/*  815 */     if (this.mode != _o_.mode) return false;
/*  816 */     if (this.min_level != _o_.min_level) return false;
/*  817 */     if (this.max_level != _o_.max_level) return false;
/*  818 */     if (this.start_time != _o_.start_time) return false;
/*  819 */     if (this.end_time != _o_.end_time) return false;
/*  820 */     if (!this.mail_title.equals(_o_.mail_title)) return false;
/*  821 */     if (!this.mail_content.equals(_o_.mail_content)) return false;
/*  822 */     if (!this.items.equals(_o_.items)) return false;
/*  823 */     if (!this.currencies.equals(_o_.currencies)) return false;
/*  824 */     if (this.min_create_role_time != _o_.min_create_role_time) return false;
/*  825 */     if (this.max_create_role_time != _o_.max_create_role_time) return false;
/*  826 */     if (this.tagid != _o_.tagid) return false;
/*  827 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  833 */     _xdb_verify_unsafe_();
/*  834 */     int _h_ = 0;
/*  835 */     _h_ += this.mode;
/*  836 */     _h_ += this.min_level;
/*  837 */     _h_ += this.max_level;
/*  838 */     _h_ = (int)(_h_ + this.start_time);
/*  839 */     _h_ = (int)(_h_ + this.end_time);
/*  840 */     _h_ += this.mail_title.hashCode();
/*  841 */     _h_ += this.mail_content.hashCode();
/*  842 */     _h_ += this.items.hashCode();
/*  843 */     _h_ += this.currencies.hashCode();
/*  844 */     _h_ = (int)(_h_ + this.min_create_role_time);
/*  845 */     _h_ = (int)(_h_ + this.max_create_role_time);
/*  846 */     _h_ += this.tagid;
/*  847 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  853 */     _xdb_verify_unsafe_();
/*  854 */     StringBuilder _sb_ = new StringBuilder();
/*  855 */     _sb_.append("(");
/*  856 */     _sb_.append(this.mode);
/*  857 */     _sb_.append(",");
/*  858 */     _sb_.append(this.min_level);
/*  859 */     _sb_.append(",");
/*  860 */     _sb_.append(this.max_level);
/*  861 */     _sb_.append(",");
/*  862 */     _sb_.append(this.start_time);
/*  863 */     _sb_.append(",");
/*  864 */     _sb_.append(this.end_time);
/*  865 */     _sb_.append(",");
/*  866 */     _sb_.append("'").append(this.mail_title).append("'");
/*  867 */     _sb_.append(",");
/*  868 */     _sb_.append("'").append(this.mail_content).append("'");
/*  869 */     _sb_.append(",");
/*  870 */     _sb_.append(this.items);
/*  871 */     _sb_.append(",");
/*  872 */     _sb_.append(this.currencies);
/*  873 */     _sb_.append(",");
/*  874 */     _sb_.append(this.min_create_role_time);
/*  875 */     _sb_.append(",");
/*  876 */     _sb_.append(this.max_create_role_time);
/*  877 */     _sb_.append(",");
/*  878 */     _sb_.append(this.tagid);
/*  879 */     _sb_.append(")");
/*  880 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  886 */     ListenableBean lb = new ListenableBean();
/*  887 */     lb.add(new ListenableChanged().setVarName("mode"));
/*  888 */     lb.add(new ListenableChanged().setVarName("min_level"));
/*  889 */     lb.add(new ListenableChanged().setVarName("max_level"));
/*  890 */     lb.add(new ListenableChanged().setVarName("start_time"));
/*  891 */     lb.add(new ListenableChanged().setVarName("end_time"));
/*  892 */     lb.add(new ListenableChanged().setVarName("mail_title"));
/*  893 */     lb.add(new ListenableChanged().setVarName("mail_content"));
/*  894 */     lb.add(new xdb.logs.ListenableMap().setVarName("items"));
/*  895 */     lb.add(new xdb.logs.ListenableMap().setVarName("currencies"));
/*  896 */     lb.add(new ListenableChanged().setVarName("min_create_role_time"));
/*  897 */     lb.add(new ListenableChanged().setVarName("max_create_role_time"));
/*  898 */     lb.add(new ListenableChanged().setVarName("tagid"));
/*  899 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.CompensateInfo {
/*      */     private Const() {}
/*      */     
/*      */     CompensateInfo nThis() {
/*  906 */       return CompensateInfo.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  912 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.CompensateInfo copy()
/*      */     {
/*  918 */       return CompensateInfo.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.CompensateInfo toData()
/*      */     {
/*  924 */       return CompensateInfo.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.CompensateInfo toBean()
/*      */     {
/*  929 */       return CompensateInfo.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.CompensateInfo toDataIf()
/*      */     {
/*  935 */       return CompensateInfo.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.CompensateInfo toBeanIf()
/*      */     {
/*  940 */       return CompensateInfo.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getMode()
/*      */     {
/*  947 */       CompensateInfo.this._xdb_verify_unsafe_();
/*  948 */       return CompensateInfo.this.mode;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getMin_level()
/*      */     {
/*  955 */       CompensateInfo.this._xdb_verify_unsafe_();
/*  956 */       return CompensateInfo.this.min_level;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getMax_level()
/*      */     {
/*  963 */       CompensateInfo.this._xdb_verify_unsafe_();
/*  964 */       return CompensateInfo.this.max_level;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getStart_time()
/*      */     {
/*  971 */       CompensateInfo.this._xdb_verify_unsafe_();
/*  972 */       return CompensateInfo.this.start_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getEnd_time()
/*      */     {
/*  979 */       CompensateInfo.this._xdb_verify_unsafe_();
/*  980 */       return CompensateInfo.this.end_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getMail_title()
/*      */     {
/*  987 */       CompensateInfo.this._xdb_verify_unsafe_();
/*  988 */       return CompensateInfo.this.mail_title;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getMail_titleOctets()
/*      */     {
/*  995 */       CompensateInfo.this._xdb_verify_unsafe_();
/*  996 */       return CompensateInfo.this.getMail_titleOctets();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getMail_content()
/*      */     {
/* 1003 */       CompensateInfo.this._xdb_verify_unsafe_();
/* 1004 */       return CompensateInfo.this.mail_content;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getMail_contentOctets()
/*      */     {
/* 1011 */       CompensateInfo.this._xdb_verify_unsafe_();
/* 1012 */       return CompensateInfo.this.getMail_contentOctets();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getItems()
/*      */     {
/* 1019 */       CompensateInfo.this._xdb_verify_unsafe_();
/* 1020 */       return xdb.Consts.constMap(CompensateInfo.this.items);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getItemsAsData()
/*      */     {
/* 1027 */       CompensateInfo.this._xdb_verify_unsafe_();
/*      */       
/* 1029 */       CompensateInfo _o_ = CompensateInfo.this;
/* 1030 */       Map<Integer, Integer> items = new HashMap();
/* 1031 */       for (Map.Entry<Integer, Integer> _e_ : _o_.items.entrySet())
/* 1032 */         items.put(_e_.getKey(), _e_.getValue());
/* 1033 */       return items;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getCurrencies()
/*      */     {
/* 1040 */       CompensateInfo.this._xdb_verify_unsafe_();
/* 1041 */       return xdb.Consts.constMap(CompensateInfo.this.currencies);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getCurrenciesAsData()
/*      */     {
/* 1048 */       CompensateInfo.this._xdb_verify_unsafe_();
/*      */       
/* 1050 */       CompensateInfo _o_ = CompensateInfo.this;
/* 1051 */       Map<Integer, Integer> currencies = new HashMap();
/* 1052 */       for (Map.Entry<Integer, Integer> _e_ : _o_.currencies.entrySet())
/* 1053 */         currencies.put(_e_.getKey(), _e_.getValue());
/* 1054 */       return currencies;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getMin_create_role_time()
/*      */     {
/* 1061 */       CompensateInfo.this._xdb_verify_unsafe_();
/* 1062 */       return CompensateInfo.this.min_create_role_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getMax_create_role_time()
/*      */     {
/* 1069 */       CompensateInfo.this._xdb_verify_unsafe_();
/* 1070 */       return CompensateInfo.this.max_create_role_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getTagid()
/*      */     {
/* 1077 */       CompensateInfo.this._xdb_verify_unsafe_();
/* 1078 */       return CompensateInfo.this.tagid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMode(int _v_)
/*      */     {
/* 1085 */       CompensateInfo.this._xdb_verify_unsafe_();
/* 1086 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMin_level(int _v_)
/*      */     {
/* 1093 */       CompensateInfo.this._xdb_verify_unsafe_();
/* 1094 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMax_level(int _v_)
/*      */     {
/* 1101 */       CompensateInfo.this._xdb_verify_unsafe_();
/* 1102 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setStart_time(long _v_)
/*      */     {
/* 1109 */       CompensateInfo.this._xdb_verify_unsafe_();
/* 1110 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setEnd_time(long _v_)
/*      */     {
/* 1117 */       CompensateInfo.this._xdb_verify_unsafe_();
/* 1118 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMail_title(String _v_)
/*      */     {
/* 1125 */       CompensateInfo.this._xdb_verify_unsafe_();
/* 1126 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMail_titleOctets(Octets _v_)
/*      */     {
/* 1133 */       CompensateInfo.this._xdb_verify_unsafe_();
/* 1134 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMail_content(String _v_)
/*      */     {
/* 1141 */       CompensateInfo.this._xdb_verify_unsafe_();
/* 1142 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMail_contentOctets(Octets _v_)
/*      */     {
/* 1149 */       CompensateInfo.this._xdb_verify_unsafe_();
/* 1150 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMin_create_role_time(long _v_)
/*      */     {
/* 1157 */       CompensateInfo.this._xdb_verify_unsafe_();
/* 1158 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMax_create_role_time(long _v_)
/*      */     {
/* 1165 */       CompensateInfo.this._xdb_verify_unsafe_();
/* 1166 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setTagid(int _v_)
/*      */     {
/* 1173 */       CompensateInfo.this._xdb_verify_unsafe_();
/* 1174 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/* 1180 */       CompensateInfo.this._xdb_verify_unsafe_();
/* 1181 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/* 1187 */       CompensateInfo.this._xdb_verify_unsafe_();
/* 1188 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/* 1194 */       return CompensateInfo.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/* 1200 */       return CompensateInfo.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/* 1206 */       CompensateInfo.this._xdb_verify_unsafe_();
/* 1207 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/* 1213 */       return CompensateInfo.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/* 1219 */       return CompensateInfo.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/* 1225 */       CompensateInfo.this._xdb_verify_unsafe_();
/* 1226 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/* 1232 */       return CompensateInfo.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1238 */       return CompensateInfo.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/* 1244 */       return CompensateInfo.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/* 1250 */       return CompensateInfo.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/* 1256 */       return CompensateInfo.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/* 1262 */       return CompensateInfo.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1268 */       return CompensateInfo.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.CompensateInfo
/*      */   {
/*      */     private int mode;
/*      */     
/*      */     private int min_level;
/*      */     
/*      */     private int max_level;
/*      */     
/*      */     private long start_time;
/*      */     
/*      */     private long end_time;
/*      */     
/*      */     private String mail_title;
/*      */     
/*      */     private String mail_content;
/*      */     
/*      */     private HashMap<Integer, Integer> items;
/*      */     
/*      */     private HashMap<Integer, Integer> currencies;
/*      */     
/*      */     private long min_create_role_time;
/*      */     
/*      */     private long max_create_role_time;
/*      */     
/*      */     private int tagid;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/* 1302 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/* 1307 */       this.min_level = 0;
/* 1308 */       this.max_level = 0;
/* 1309 */       this.start_time = 0L;
/* 1310 */       this.end_time = 0L;
/* 1311 */       this.mail_title = "";
/* 1312 */       this.mail_content = "";
/* 1313 */       this.items = new HashMap();
/* 1314 */       this.currencies = new HashMap();
/* 1315 */       this.min_create_role_time = 0L;
/* 1316 */       this.max_create_role_time = 0L;
/* 1317 */       this.tagid = 0;
/*      */     }
/*      */     
/*      */     Data(xbean.CompensateInfo _o1_)
/*      */     {
/* 1322 */       if ((_o1_ instanceof CompensateInfo)) { assign((CompensateInfo)_o1_);
/* 1323 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 1324 */       } else if ((_o1_ instanceof CompensateInfo.Const)) assign(((CompensateInfo.Const)_o1_).nThis()); else {
/* 1325 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(CompensateInfo _o_) {
/* 1330 */       this.mode = _o_.mode;
/* 1331 */       this.min_level = _o_.min_level;
/* 1332 */       this.max_level = _o_.max_level;
/* 1333 */       this.start_time = _o_.start_time;
/* 1334 */       this.end_time = _o_.end_time;
/* 1335 */       this.mail_title = _o_.mail_title;
/* 1336 */       this.mail_content = _o_.mail_content;
/* 1337 */       this.items = new HashMap();
/* 1338 */       for (Map.Entry<Integer, Integer> _e_ : _o_.items.entrySet())
/* 1339 */         this.items.put(_e_.getKey(), _e_.getValue());
/* 1340 */       this.currencies = new HashMap();
/* 1341 */       for (Map.Entry<Integer, Integer> _e_ : _o_.currencies.entrySet())
/* 1342 */         this.currencies.put(_e_.getKey(), _e_.getValue());
/* 1343 */       this.min_create_role_time = _o_.min_create_role_time;
/* 1344 */       this.max_create_role_time = _o_.max_create_role_time;
/* 1345 */       this.tagid = _o_.tagid;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/* 1350 */       this.mode = _o_.mode;
/* 1351 */       this.min_level = _o_.min_level;
/* 1352 */       this.max_level = _o_.max_level;
/* 1353 */       this.start_time = _o_.start_time;
/* 1354 */       this.end_time = _o_.end_time;
/* 1355 */       this.mail_title = _o_.mail_title;
/* 1356 */       this.mail_content = _o_.mail_content;
/* 1357 */       this.items = new HashMap();
/* 1358 */       for (Map.Entry<Integer, Integer> _e_ : _o_.items.entrySet())
/* 1359 */         this.items.put(_e_.getKey(), _e_.getValue());
/* 1360 */       this.currencies = new HashMap();
/* 1361 */       for (Map.Entry<Integer, Integer> _e_ : _o_.currencies.entrySet())
/* 1362 */         this.currencies.put(_e_.getKey(), _e_.getValue());
/* 1363 */       this.min_create_role_time = _o_.min_create_role_time;
/* 1364 */       this.max_create_role_time = _o_.max_create_role_time;
/* 1365 */       this.tagid = _o_.tagid;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/* 1371 */       _os_.marshal(this.mode);
/* 1372 */       _os_.marshal(this.min_level);
/* 1373 */       _os_.marshal(this.max_level);
/* 1374 */       _os_.marshal(this.start_time);
/* 1375 */       _os_.marshal(this.end_time);
/* 1376 */       _os_.marshal(this.mail_title, "UTF-16LE");
/* 1377 */       _os_.marshal(this.mail_content, "UTF-16LE");
/* 1378 */       _os_.compact_uint32(this.items.size());
/* 1379 */       for (Map.Entry<Integer, Integer> _e_ : this.items.entrySet())
/*      */       {
/* 1381 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 1382 */         _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */       }
/* 1384 */       _os_.compact_uint32(this.currencies.size());
/* 1385 */       for (Map.Entry<Integer, Integer> _e_ : this.currencies.entrySet())
/*      */       {
/* 1387 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 1388 */         _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */       }
/* 1390 */       _os_.marshal(this.min_create_role_time);
/* 1391 */       _os_.marshal(this.max_create_role_time);
/* 1392 */       _os_.marshal(this.tagid);
/* 1393 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/* 1399 */       this.mode = _os_.unmarshal_int();
/* 1400 */       this.min_level = _os_.unmarshal_int();
/* 1401 */       this.max_level = _os_.unmarshal_int();
/* 1402 */       this.start_time = _os_.unmarshal_long();
/* 1403 */       this.end_time = _os_.unmarshal_long();
/* 1404 */       this.mail_title = _os_.unmarshal_String("UTF-16LE");
/* 1405 */       this.mail_content = _os_.unmarshal_String("UTF-16LE");
/*      */       
/* 1407 */       int size = _os_.uncompact_uint32();
/* 1408 */       if (size >= 12)
/*      */       {
/* 1410 */         this.items = new HashMap(size * 2);
/*      */       }
/* 1412 */       for (; size > 0; size--)
/*      */       {
/* 1414 */         int _k_ = 0;
/* 1415 */         _k_ = _os_.unmarshal_int();
/* 1416 */         int _v_ = 0;
/* 1417 */         _v_ = _os_.unmarshal_int();
/* 1418 */         this.items.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*      */       }
/*      */       
/*      */ 
/* 1422 */       int size = _os_.uncompact_uint32();
/* 1423 */       if (size >= 12)
/*      */       {
/* 1425 */         this.currencies = new HashMap(size * 2);
/*      */       }
/* 1427 */       for (; size > 0; size--)
/*      */       {
/* 1429 */         int _k_ = 0;
/* 1430 */         _k_ = _os_.unmarshal_int();
/* 1431 */         int _v_ = 0;
/* 1432 */         _v_ = _os_.unmarshal_int();
/* 1433 */         this.currencies.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*      */       }
/*      */       
/* 1436 */       this.min_create_role_time = _os_.unmarshal_long();
/* 1437 */       this.max_create_role_time = _os_.unmarshal_long();
/* 1438 */       this.tagid = _os_.unmarshal_int();
/* 1439 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/* 1445 */       int _size_ = 0;
/* 1446 */       _size_ += CodedOutputStream.computeInt32Size(1, this.mode);
/* 1447 */       _size_ += CodedOutputStream.computeInt32Size(2, this.min_level);
/* 1448 */       _size_ += CodedOutputStream.computeInt32Size(3, this.max_level);
/* 1449 */       _size_ += CodedOutputStream.computeInt64Size(4, this.start_time);
/* 1450 */       _size_ += CodedOutputStream.computeInt64Size(5, this.end_time);
/*      */       try
/*      */       {
/* 1453 */         _size_ += CodedOutputStream.computeBytesSize(6, ByteString.copyFrom(this.mail_title, "UTF-16LE"));
/*      */       }
/*      */       catch (UnsupportedEncodingException e)
/*      */       {
/* 1457 */         throw new RuntimeException("UTF-16LE not supported?", e);
/*      */       }
/*      */       try
/*      */       {
/* 1461 */         _size_ += CodedOutputStream.computeBytesSize(7, ByteString.copyFrom(this.mail_content, "UTF-16LE"));
/*      */       }
/*      */       catch (UnsupportedEncodingException e)
/*      */       {
/* 1465 */         throw new RuntimeException("UTF-16LE not supported?", e);
/*      */       }
/* 1467 */       for (Map.Entry<Integer, Integer> _e_ : this.items.entrySet())
/*      */       {
/* 1469 */         _size_ += CodedOutputStream.computeInt32Size(8, ((Integer)_e_.getKey()).intValue());
/* 1470 */         _size_ += CodedOutputStream.computeInt32Size(8, ((Integer)_e_.getValue()).intValue());
/*      */       }
/* 1472 */       for (Map.Entry<Integer, Integer> _e_ : this.currencies.entrySet())
/*      */       {
/* 1474 */         _size_ += CodedOutputStream.computeInt32Size(9, ((Integer)_e_.getKey()).intValue());
/* 1475 */         _size_ += CodedOutputStream.computeInt32Size(9, ((Integer)_e_.getValue()).intValue());
/*      */       }
/* 1477 */       _size_ += CodedOutputStream.computeInt64Size(10, this.min_create_role_time);
/* 1478 */       _size_ += CodedOutputStream.computeInt64Size(11, this.max_create_role_time);
/* 1479 */       _size_ += CodedOutputStream.computeInt32Size(12, this.tagid);
/* 1480 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1488 */         _output_.writeInt32(1, this.mode);
/* 1489 */         _output_.writeInt32(2, this.min_level);
/* 1490 */         _output_.writeInt32(3, this.max_level);
/* 1491 */         _output_.writeInt64(4, this.start_time);
/* 1492 */         _output_.writeInt64(5, this.end_time);
/* 1493 */         _output_.writeBytes(6, ByteString.copyFrom(this.mail_title, "UTF-16LE"));
/* 1494 */         _output_.writeBytes(7, ByteString.copyFrom(this.mail_content, "UTF-16LE"));
/* 1495 */         for (Map.Entry<Integer, Integer> _e_ : this.items.entrySet())
/*      */         {
/* 1497 */           _output_.writeInt32(8, ((Integer)_e_.getKey()).intValue());
/* 1498 */           _output_.writeInt32(8, ((Integer)_e_.getValue()).intValue());
/*      */         }
/* 1500 */         for (Map.Entry<Integer, Integer> _e_ : this.currencies.entrySet())
/*      */         {
/* 1502 */           _output_.writeInt32(9, ((Integer)_e_.getKey()).intValue());
/* 1503 */           _output_.writeInt32(9, ((Integer)_e_.getValue()).intValue());
/*      */         }
/* 1505 */         _output_.writeInt64(10, this.min_create_role_time);
/* 1506 */         _output_.writeInt64(11, this.max_create_role_time);
/* 1507 */         _output_.writeInt32(12, this.tagid);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1511 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1513 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1521 */         boolean done = false;
/* 1522 */         while (!done)
/*      */         {
/* 1524 */           int tag = _input_.readTag();
/* 1525 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/* 1529 */             done = true;
/* 1530 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/* 1534 */             this.mode = _input_.readInt32();
/* 1535 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/* 1539 */             this.min_level = _input_.readInt32();
/* 1540 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/* 1544 */             this.max_level = _input_.readInt32();
/* 1545 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/* 1549 */             this.start_time = _input_.readInt64();
/* 1550 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/* 1554 */             this.end_time = _input_.readInt64();
/* 1555 */             break;
/*      */           
/*      */ 
/*      */           case 50: 
/* 1559 */             this.mail_title = _input_.readBytes().toString("UTF-16LE");
/* 1560 */             break;
/*      */           
/*      */ 
/*      */           case 58: 
/* 1564 */             this.mail_content = _input_.readBytes().toString("UTF-16LE");
/* 1565 */             break;
/*      */           
/*      */ 
/*      */           case 64: 
/* 1569 */             int _k_ = 0;
/* 1570 */             _k_ = _input_.readInt32();
/* 1571 */             int readTag = _input_.readTag();
/* 1572 */             if (64 != readTag)
/*      */             {
/* 1574 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 1576 */             int _v_ = 0;
/* 1577 */             _v_ = _input_.readInt32();
/* 1578 */             this.items.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/* 1579 */             break;
/*      */           
/*      */ 
/*      */           case 72: 
/* 1583 */             int _k_ = 0;
/* 1584 */             _k_ = _input_.readInt32();
/* 1585 */             int readTag = _input_.readTag();
/* 1586 */             if (72 != readTag)
/*      */             {
/* 1588 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 1590 */             int _v_ = 0;
/* 1591 */             _v_ = _input_.readInt32();
/* 1592 */             this.currencies.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/* 1593 */             break;
/*      */           
/*      */ 
/*      */           case 80: 
/* 1597 */             this.min_create_role_time = _input_.readInt64();
/* 1598 */             break;
/*      */           
/*      */ 
/*      */           case 88: 
/* 1602 */             this.max_create_role_time = _input_.readInt64();
/* 1603 */             break;
/*      */           
/*      */ 
/*      */           case 96: 
/* 1607 */             this.tagid = _input_.readInt32();
/* 1608 */             break;
/*      */           
/*      */ 
/*      */           default: 
/* 1612 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/* 1614 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/* 1623 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1627 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1629 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.CompensateInfo copy()
/*      */     {
/* 1635 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.CompensateInfo toData()
/*      */     {
/* 1641 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.CompensateInfo toBean()
/*      */     {
/* 1646 */       return new CompensateInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.CompensateInfo toDataIf()
/*      */     {
/* 1652 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.CompensateInfo toBeanIf()
/*      */     {
/* 1657 */       return new CompensateInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1663 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/* 1667 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1671 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1675 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/* 1679 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1683 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1687 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getMode()
/*      */     {
/* 1694 */       return this.mode;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getMin_level()
/*      */     {
/* 1701 */       return this.min_level;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getMax_level()
/*      */     {
/* 1708 */       return this.max_level;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getStart_time()
/*      */     {
/* 1715 */       return this.start_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getEnd_time()
/*      */     {
/* 1722 */       return this.end_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getMail_title()
/*      */     {
/* 1729 */       return this.mail_title;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getMail_titleOctets()
/*      */     {
/* 1736 */       return Octets.wrap(getMail_title(), "UTF-16LE");
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getMail_content()
/*      */     {
/* 1743 */       return this.mail_content;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getMail_contentOctets()
/*      */     {
/* 1750 */       return Octets.wrap(getMail_content(), "UTF-16LE");
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getItems()
/*      */     {
/* 1757 */       return this.items;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getItemsAsData()
/*      */     {
/* 1764 */       return this.items;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getCurrencies()
/*      */     {
/* 1771 */       return this.currencies;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getCurrenciesAsData()
/*      */     {
/* 1778 */       return this.currencies;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getMin_create_role_time()
/*      */     {
/* 1785 */       return this.min_create_role_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getMax_create_role_time()
/*      */     {
/* 1792 */       return this.max_create_role_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getTagid()
/*      */     {
/* 1799 */       return this.tagid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMode(int _v_)
/*      */     {
/* 1806 */       this.mode = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMin_level(int _v_)
/*      */     {
/* 1813 */       this.min_level = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMax_level(int _v_)
/*      */     {
/* 1820 */       this.max_level = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setStart_time(long _v_)
/*      */     {
/* 1827 */       this.start_time = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setEnd_time(long _v_)
/*      */     {
/* 1834 */       this.end_time = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMail_title(String _v_)
/*      */     {
/* 1841 */       if (null == _v_)
/* 1842 */         throw new NullPointerException();
/* 1843 */       this.mail_title = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMail_titleOctets(Octets _v_)
/*      */     {
/* 1850 */       setMail_title(_v_.getString("UTF-16LE"));
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMail_content(String _v_)
/*      */     {
/* 1857 */       if (null == _v_)
/* 1858 */         throw new NullPointerException();
/* 1859 */       this.mail_content = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMail_contentOctets(Octets _v_)
/*      */     {
/* 1866 */       setMail_content(_v_.getString("UTF-16LE"));
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMin_create_role_time(long _v_)
/*      */     {
/* 1873 */       this.min_create_role_time = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMax_create_role_time(long _v_)
/*      */     {
/* 1880 */       this.max_create_role_time = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setTagid(int _v_)
/*      */     {
/* 1887 */       this.tagid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1893 */       if (!(_o1_ instanceof Data)) return false;
/* 1894 */       Data _o_ = (Data)_o1_;
/* 1895 */       if (this.mode != _o_.mode) return false;
/* 1896 */       if (this.min_level != _o_.min_level) return false;
/* 1897 */       if (this.max_level != _o_.max_level) return false;
/* 1898 */       if (this.start_time != _o_.start_time) return false;
/* 1899 */       if (this.end_time != _o_.end_time) return false;
/* 1900 */       if (!this.mail_title.equals(_o_.mail_title)) return false;
/* 1901 */       if (!this.mail_content.equals(_o_.mail_content)) return false;
/* 1902 */       if (!this.items.equals(_o_.items)) return false;
/* 1903 */       if (!this.currencies.equals(_o_.currencies)) return false;
/* 1904 */       if (this.min_create_role_time != _o_.min_create_role_time) return false;
/* 1905 */       if (this.max_create_role_time != _o_.max_create_role_time) return false;
/* 1906 */       if (this.tagid != _o_.tagid) return false;
/* 1907 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1913 */       int _h_ = 0;
/* 1914 */       _h_ += this.mode;
/* 1915 */       _h_ += this.min_level;
/* 1916 */       _h_ += this.max_level;
/* 1917 */       _h_ = (int)(_h_ + this.start_time);
/* 1918 */       _h_ = (int)(_h_ + this.end_time);
/* 1919 */       _h_ += this.mail_title.hashCode();
/* 1920 */       _h_ += this.mail_content.hashCode();
/* 1921 */       _h_ += this.items.hashCode();
/* 1922 */       _h_ += this.currencies.hashCode();
/* 1923 */       _h_ = (int)(_h_ + this.min_create_role_time);
/* 1924 */       _h_ = (int)(_h_ + this.max_create_role_time);
/* 1925 */       _h_ += this.tagid;
/* 1926 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1932 */       StringBuilder _sb_ = new StringBuilder();
/* 1933 */       _sb_.append("(");
/* 1934 */       _sb_.append(this.mode);
/* 1935 */       _sb_.append(",");
/* 1936 */       _sb_.append(this.min_level);
/* 1937 */       _sb_.append(",");
/* 1938 */       _sb_.append(this.max_level);
/* 1939 */       _sb_.append(",");
/* 1940 */       _sb_.append(this.start_time);
/* 1941 */       _sb_.append(",");
/* 1942 */       _sb_.append(this.end_time);
/* 1943 */       _sb_.append(",");
/* 1944 */       _sb_.append("'").append(this.mail_title).append("'");
/* 1945 */       _sb_.append(",");
/* 1946 */       _sb_.append("'").append(this.mail_content).append("'");
/* 1947 */       _sb_.append(",");
/* 1948 */       _sb_.append(this.items);
/* 1949 */       _sb_.append(",");
/* 1950 */       _sb_.append(this.currencies);
/* 1951 */       _sb_.append(",");
/* 1952 */       _sb_.append(this.min_create_role_time);
/* 1953 */       _sb_.append(",");
/* 1954 */       _sb_.append(this.max_create_role_time);
/* 1955 */       _sb_.append(",");
/* 1956 */       _sb_.append(this.tagid);
/* 1957 */       _sb_.append(")");
/* 1958 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\CompensateInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */