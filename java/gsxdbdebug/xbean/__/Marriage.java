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
/*      */ import xdb.Bean;
/*      */ import xdb.Log;
/*      */ import xdb.LogKey;
/*      */ import xdb.Logs;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableChanged;
/*      */ import xdb.logs.ListenableMap;
/*      */ import xdb.logs.LogInt;
/*      */ import xdb.logs.LogLong;
/*      */ 
/*      */ public final class Marriage extends XBean implements xbean.Marriage
/*      */ {
/*      */   private long roleida;
/*      */   private long roleidb;
/*      */   private HashMap<Long, xbean.MarriageFriendInfo> friendainfos;
/*      */   private HashMap<Long, xbean.MarriageFriendInfo> friendbinfos;
/*      */   private long marrytime;
/*      */   private int level;
/*      */   private int marriagetitle;
/*      */   private HashMap<Integer, Integer> parammap;
/*      */   private int prepare_pregnant_score;
/*      */   private long child_belong_role_id;
/*      */   private int give_birth_score;
/*      */   private long give_birth_score_enough_time;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   40 */     this.roleida = 0L;
/*   41 */     this.roleidb = 0L;
/*   42 */     this.friendainfos.clear();
/*   43 */     this.friendbinfos.clear();
/*   44 */     this.marrytime = 0L;
/*   45 */     this.level = 0;
/*   46 */     this.marriagetitle = 0;
/*   47 */     this.parammap.clear();
/*   48 */     this.prepare_pregnant_score = 0;
/*   49 */     this.child_belong_role_id = 0L;
/*   50 */     this.give_birth_score = 0;
/*   51 */     this.give_birth_score_enough_time = 0L;
/*      */   }
/*      */   
/*      */   Marriage(int __, XBean _xp_, String _vn_)
/*      */   {
/*   56 */     super(_xp_, _vn_);
/*   57 */     this.friendainfos = new HashMap();
/*   58 */     this.friendbinfos = new HashMap();
/*   59 */     this.parammap = new HashMap();
/*      */   }
/*      */   
/*      */   public Marriage()
/*      */   {
/*   64 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public Marriage(Marriage _o_)
/*      */   {
/*   69 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   Marriage(xbean.Marriage _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   74 */     super(_xp_, _vn_);
/*   75 */     if ((_o1_ instanceof Marriage)) { assign((Marriage)_o1_);
/*   76 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   77 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   78 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(Marriage _o_) {
/*   83 */     _o_._xdb_verify_unsafe_();
/*   84 */     this.roleida = _o_.roleida;
/*   85 */     this.roleidb = _o_.roleidb;
/*   86 */     this.friendainfos = new HashMap();
/*   87 */     for (Map.Entry<Long, xbean.MarriageFriendInfo> _e_ : _o_.friendainfos.entrySet())
/*   88 */       this.friendainfos.put(_e_.getKey(), new MarriageFriendInfo((xbean.MarriageFriendInfo)_e_.getValue(), this, "friendainfos"));
/*   89 */     this.friendbinfos = new HashMap();
/*   90 */     for (Map.Entry<Long, xbean.MarriageFriendInfo> _e_ : _o_.friendbinfos.entrySet())
/*   91 */       this.friendbinfos.put(_e_.getKey(), new MarriageFriendInfo((xbean.MarriageFriendInfo)_e_.getValue(), this, "friendbinfos"));
/*   92 */     this.marrytime = _o_.marrytime;
/*   93 */     this.level = _o_.level;
/*   94 */     this.marriagetitle = _o_.marriagetitle;
/*   95 */     this.parammap = new HashMap();
/*   96 */     for (Map.Entry<Integer, Integer> _e_ : _o_.parammap.entrySet())
/*   97 */       this.parammap.put(_e_.getKey(), _e_.getValue());
/*   98 */     this.prepare_pregnant_score = _o_.prepare_pregnant_score;
/*   99 */     this.child_belong_role_id = _o_.child_belong_role_id;
/*  100 */     this.give_birth_score = _o_.give_birth_score;
/*  101 */     this.give_birth_score_enough_time = _o_.give_birth_score_enough_time;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*  106 */     this.roleida = _o_.roleida;
/*  107 */     this.roleidb = _o_.roleidb;
/*  108 */     this.friendainfos = new HashMap();
/*  109 */     for (Map.Entry<Long, xbean.MarriageFriendInfo> _e_ : _o_.friendainfos.entrySet())
/*  110 */       this.friendainfos.put(_e_.getKey(), new MarriageFriendInfo((xbean.MarriageFriendInfo)_e_.getValue(), this, "friendainfos"));
/*  111 */     this.friendbinfos = new HashMap();
/*  112 */     for (Map.Entry<Long, xbean.MarriageFriendInfo> _e_ : _o_.friendbinfos.entrySet())
/*  113 */       this.friendbinfos.put(_e_.getKey(), new MarriageFriendInfo((xbean.MarriageFriendInfo)_e_.getValue(), this, "friendbinfos"));
/*  114 */     this.marrytime = _o_.marrytime;
/*  115 */     this.level = _o_.level;
/*  116 */     this.marriagetitle = _o_.marriagetitle;
/*  117 */     this.parammap = new HashMap();
/*  118 */     for (Map.Entry<Integer, Integer> _e_ : _o_.parammap.entrySet())
/*  119 */       this.parammap.put(_e_.getKey(), _e_.getValue());
/*  120 */     this.prepare_pregnant_score = _o_.prepare_pregnant_score;
/*  121 */     this.child_belong_role_id = _o_.child_belong_role_id;
/*  122 */     this.give_birth_score = _o_.give_birth_score;
/*  123 */     this.give_birth_score_enough_time = _o_.give_birth_score_enough_time;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*  129 */     _xdb_verify_unsafe_();
/*  130 */     _os_.marshal(this.roleida);
/*  131 */     _os_.marshal(this.roleidb);
/*  132 */     _os_.compact_uint32(this.friendainfos.size());
/*  133 */     for (Map.Entry<Long, xbean.MarriageFriendInfo> _e_ : this.friendainfos.entrySet())
/*      */     {
/*  135 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  136 */       ((xbean.MarriageFriendInfo)_e_.getValue()).marshal(_os_);
/*      */     }
/*  138 */     _os_.compact_uint32(this.friendbinfos.size());
/*  139 */     for (Map.Entry<Long, xbean.MarriageFriendInfo> _e_ : this.friendbinfos.entrySet())
/*      */     {
/*  141 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  142 */       ((xbean.MarriageFriendInfo)_e_.getValue()).marshal(_os_);
/*      */     }
/*  144 */     _os_.marshal(this.marrytime);
/*  145 */     _os_.marshal(this.level);
/*  146 */     _os_.marshal(this.marriagetitle);
/*  147 */     _os_.compact_uint32(this.parammap.size());
/*  148 */     for (Map.Entry<Integer, Integer> _e_ : this.parammap.entrySet())
/*      */     {
/*  150 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  151 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */     }
/*  153 */     _os_.marshal(this.prepare_pregnant_score);
/*  154 */     _os_.marshal(this.child_belong_role_id);
/*  155 */     _os_.marshal(this.give_birth_score);
/*  156 */     _os_.marshal(this.give_birth_score_enough_time);
/*  157 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  163 */     _xdb_verify_unsafe_();
/*  164 */     this.roleida = _os_.unmarshal_long();
/*  165 */     this.roleidb = _os_.unmarshal_long();
/*      */     
/*  167 */     int size = _os_.uncompact_uint32();
/*  168 */     if (size >= 12)
/*      */     {
/*  170 */       this.friendainfos = new HashMap(size * 2);
/*      */     }
/*  172 */     for (; size > 0; size--)
/*      */     {
/*  174 */       long _k_ = 0L;
/*  175 */       _k_ = _os_.unmarshal_long();
/*  176 */       xbean.MarriageFriendInfo _v_ = new MarriageFriendInfo(0, this, "friendainfos");
/*  177 */       _v_.unmarshal(_os_);
/*  178 */       this.friendainfos.put(Long.valueOf(_k_), _v_);
/*      */     }
/*      */     
/*      */ 
/*  182 */     int size = _os_.uncompact_uint32();
/*  183 */     if (size >= 12)
/*      */     {
/*  185 */       this.friendbinfos = new HashMap(size * 2);
/*      */     }
/*  187 */     for (; size > 0; size--)
/*      */     {
/*  189 */       long _k_ = 0L;
/*  190 */       _k_ = _os_.unmarshal_long();
/*  191 */       xbean.MarriageFriendInfo _v_ = new MarriageFriendInfo(0, this, "friendbinfos");
/*  192 */       _v_.unmarshal(_os_);
/*  193 */       this.friendbinfos.put(Long.valueOf(_k_), _v_);
/*      */     }
/*      */     
/*  196 */     this.marrytime = _os_.unmarshal_long();
/*  197 */     this.level = _os_.unmarshal_int();
/*  198 */     this.marriagetitle = _os_.unmarshal_int();
/*      */     
/*  200 */     int size = _os_.uncompact_uint32();
/*  201 */     if (size >= 12)
/*      */     {
/*  203 */       this.parammap = new HashMap(size * 2);
/*      */     }
/*  205 */     for (; size > 0; size--)
/*      */     {
/*  207 */       int _k_ = 0;
/*  208 */       _k_ = _os_.unmarshal_int();
/*  209 */       int _v_ = 0;
/*  210 */       _v_ = _os_.unmarshal_int();
/*  211 */       this.parammap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*      */     }
/*      */     
/*  214 */     this.prepare_pregnant_score = _os_.unmarshal_int();
/*  215 */     this.child_belong_role_id = _os_.unmarshal_long();
/*  216 */     this.give_birth_score = _os_.unmarshal_int();
/*  217 */     this.give_birth_score_enough_time = _os_.unmarshal_long();
/*  218 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  224 */     _xdb_verify_unsafe_();
/*  225 */     int _size_ = 0;
/*  226 */     _size_ += CodedOutputStream.computeInt64Size(1, this.roleida);
/*  227 */     _size_ += CodedOutputStream.computeInt64Size(2, this.roleidb);
/*  228 */     for (Map.Entry<Long, xbean.MarriageFriendInfo> _e_ : this.friendainfos.entrySet())
/*      */     {
/*  230 */       _size_ += CodedOutputStream.computeInt64Size(3, ((Long)_e_.getKey()).longValue());
/*  231 */       _size_ += CodedOutputStream.computeMessageSize(3, (Message)_e_.getValue());
/*      */     }
/*  233 */     for (Map.Entry<Long, xbean.MarriageFriendInfo> _e_ : this.friendbinfos.entrySet())
/*      */     {
/*  235 */       _size_ += CodedOutputStream.computeInt64Size(4, ((Long)_e_.getKey()).longValue());
/*  236 */       _size_ += CodedOutputStream.computeMessageSize(4, (Message)_e_.getValue());
/*      */     }
/*  238 */     _size_ += CodedOutputStream.computeInt64Size(5, this.marrytime);
/*  239 */     _size_ += CodedOutputStream.computeInt32Size(6, this.level);
/*  240 */     _size_ += CodedOutputStream.computeInt32Size(7, this.marriagetitle);
/*  241 */     for (Map.Entry<Integer, Integer> _e_ : this.parammap.entrySet())
/*      */     {
/*  243 */       _size_ += CodedOutputStream.computeInt32Size(8, ((Integer)_e_.getKey()).intValue());
/*  244 */       _size_ += CodedOutputStream.computeInt32Size(8, ((Integer)_e_.getValue()).intValue());
/*      */     }
/*  246 */     _size_ += CodedOutputStream.computeInt32Size(9, this.prepare_pregnant_score);
/*  247 */     _size_ += CodedOutputStream.computeInt64Size(11, this.child_belong_role_id);
/*  248 */     _size_ += CodedOutputStream.computeInt32Size(12, this.give_birth_score);
/*  249 */     _size_ += CodedOutputStream.computeInt64Size(13, this.give_birth_score_enough_time);
/*  250 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  256 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  259 */       _output_.writeInt64(1, this.roleida);
/*  260 */       _output_.writeInt64(2, this.roleidb);
/*  261 */       for (Map.Entry<Long, xbean.MarriageFriendInfo> _e_ : this.friendainfos.entrySet())
/*      */       {
/*  263 */         _output_.writeInt64(3, ((Long)_e_.getKey()).longValue());
/*  264 */         _output_.writeMessage(3, (Message)_e_.getValue());
/*      */       }
/*  266 */       for (Map.Entry<Long, xbean.MarriageFriendInfo> _e_ : this.friendbinfos.entrySet())
/*      */       {
/*  268 */         _output_.writeInt64(4, ((Long)_e_.getKey()).longValue());
/*  269 */         _output_.writeMessage(4, (Message)_e_.getValue());
/*      */       }
/*  271 */       _output_.writeInt64(5, this.marrytime);
/*  272 */       _output_.writeInt32(6, this.level);
/*  273 */       _output_.writeInt32(7, this.marriagetitle);
/*  274 */       for (Map.Entry<Integer, Integer> _e_ : this.parammap.entrySet())
/*      */       {
/*  276 */         _output_.writeInt32(8, ((Integer)_e_.getKey()).intValue());
/*  277 */         _output_.writeInt32(8, ((Integer)_e_.getValue()).intValue());
/*      */       }
/*  279 */       _output_.writeInt32(9, this.prepare_pregnant_score);
/*  280 */       _output_.writeInt64(11, this.child_belong_role_id);
/*  281 */       _output_.writeInt32(12, this.give_birth_score);
/*  282 */       _output_.writeInt64(13, this.give_birth_score_enough_time);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  286 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  288 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  294 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  297 */       boolean done = false;
/*  298 */       while (!done)
/*      */       {
/*  300 */         int tag = _input_.readTag();
/*  301 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  305 */           done = true;
/*  306 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  310 */           this.roleida = _input_.readInt64();
/*  311 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  315 */           this.roleidb = _input_.readInt64();
/*  316 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  320 */           long _k_ = 0L;
/*  321 */           _k_ = _input_.readInt64();
/*  322 */           int readTag = _input_.readTag();
/*  323 */           if (26 != readTag)
/*      */           {
/*  325 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  327 */           xbean.MarriageFriendInfo _v_ = new MarriageFriendInfo(0, this, "friendainfos");
/*  328 */           _input_.readMessage(_v_);
/*  329 */           this.friendainfos.put(Long.valueOf(_k_), _v_);
/*  330 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  334 */           long _k_ = 0L;
/*  335 */           _k_ = _input_.readInt64();
/*  336 */           int readTag = _input_.readTag();
/*  337 */           if (34 != readTag)
/*      */           {
/*  339 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  341 */           xbean.MarriageFriendInfo _v_ = new MarriageFriendInfo(0, this, "friendbinfos");
/*  342 */           _input_.readMessage(_v_);
/*  343 */           this.friendbinfos.put(Long.valueOf(_k_), _v_);
/*  344 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  348 */           this.marrytime = _input_.readInt64();
/*  349 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  353 */           this.level = _input_.readInt32();
/*  354 */           break;
/*      */         
/*      */ 
/*      */         case 56: 
/*  358 */           this.marriagetitle = _input_.readInt32();
/*  359 */           break;
/*      */         
/*      */ 
/*      */         case 64: 
/*  363 */           int _k_ = 0;
/*  364 */           _k_ = _input_.readInt32();
/*  365 */           int readTag = _input_.readTag();
/*  366 */           if (64 != readTag)
/*      */           {
/*  368 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  370 */           int _v_ = 0;
/*  371 */           _v_ = _input_.readInt32();
/*  372 */           this.parammap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*  373 */           break;
/*      */         
/*      */ 
/*      */         case 72: 
/*  377 */           this.prepare_pregnant_score = _input_.readInt32();
/*  378 */           break;
/*      */         
/*      */ 
/*      */         case 88: 
/*  382 */           this.child_belong_role_id = _input_.readInt64();
/*  383 */           break;
/*      */         
/*      */ 
/*      */         case 96: 
/*  387 */           this.give_birth_score = _input_.readInt32();
/*  388 */           break;
/*      */         
/*      */ 
/*      */         case 104: 
/*  392 */           this.give_birth_score_enough_time = _input_.readInt64();
/*  393 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  397 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  399 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  408 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  412 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  414 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.Marriage copy()
/*      */   {
/*  420 */     _xdb_verify_unsafe_();
/*  421 */     return new Marriage(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.Marriage toData()
/*      */   {
/*  427 */     _xdb_verify_unsafe_();
/*  428 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.Marriage toBean()
/*      */   {
/*  433 */     _xdb_verify_unsafe_();
/*  434 */     return new Marriage(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.Marriage toDataIf()
/*      */   {
/*  440 */     _xdb_verify_unsafe_();
/*  441 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.Marriage toBeanIf()
/*      */   {
/*  446 */     _xdb_verify_unsafe_();
/*  447 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public Bean toConst()
/*      */   {
/*  453 */     _xdb_verify_unsafe_();
/*  454 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getRoleida()
/*      */   {
/*  461 */     _xdb_verify_unsafe_();
/*  462 */     return this.roleida;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getRoleidb()
/*      */   {
/*  469 */     _xdb_verify_unsafe_();
/*  470 */     return this.roleidb;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, xbean.MarriageFriendInfo> getFriendainfos()
/*      */   {
/*  477 */     _xdb_verify_unsafe_();
/*  478 */     return Logs.logMap(new LogKey(this, "friendainfos"), this.friendainfos);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, xbean.MarriageFriendInfo> getFriendainfosAsData()
/*      */   {
/*  485 */     _xdb_verify_unsafe_();
/*      */     
/*  487 */     Marriage _o_ = this;
/*  488 */     Map<Long, xbean.MarriageFriendInfo> friendainfos = new HashMap();
/*  489 */     for (Map.Entry<Long, xbean.MarriageFriendInfo> _e_ : _o_.friendainfos.entrySet())
/*  490 */       friendainfos.put(_e_.getKey(), new MarriageFriendInfo.Data((xbean.MarriageFriendInfo)_e_.getValue()));
/*  491 */     return friendainfos;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, xbean.MarriageFriendInfo> getFriendbinfos()
/*      */   {
/*  498 */     _xdb_verify_unsafe_();
/*  499 */     return Logs.logMap(new LogKey(this, "friendbinfos"), this.friendbinfos);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, xbean.MarriageFriendInfo> getFriendbinfosAsData()
/*      */   {
/*  506 */     _xdb_verify_unsafe_();
/*      */     
/*  508 */     Marriage _o_ = this;
/*  509 */     Map<Long, xbean.MarriageFriendInfo> friendbinfos = new HashMap();
/*  510 */     for (Map.Entry<Long, xbean.MarriageFriendInfo> _e_ : _o_.friendbinfos.entrySet())
/*  511 */       friendbinfos.put(_e_.getKey(), new MarriageFriendInfo.Data((xbean.MarriageFriendInfo)_e_.getValue()));
/*  512 */     return friendbinfos;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getMarrytime()
/*      */   {
/*  519 */     _xdb_verify_unsafe_();
/*  520 */     return this.marrytime;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getLevel()
/*      */   {
/*  527 */     _xdb_verify_unsafe_();
/*  528 */     return this.level;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getMarriagetitle()
/*      */   {
/*  535 */     _xdb_verify_unsafe_();
/*  536 */     return this.marriagetitle;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getParammap()
/*      */   {
/*  543 */     _xdb_verify_unsafe_();
/*  544 */     return Logs.logMap(new LogKey(this, "parammap"), this.parammap);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getParammapAsData()
/*      */   {
/*  551 */     _xdb_verify_unsafe_();
/*      */     
/*  553 */     Marriage _o_ = this;
/*  554 */     Map<Integer, Integer> parammap = new HashMap();
/*  555 */     for (Map.Entry<Integer, Integer> _e_ : _o_.parammap.entrySet())
/*  556 */       parammap.put(_e_.getKey(), _e_.getValue());
/*  557 */     return parammap;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getPrepare_pregnant_score()
/*      */   {
/*  564 */     _xdb_verify_unsafe_();
/*  565 */     return this.prepare_pregnant_score;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getChild_belong_role_id()
/*      */   {
/*  572 */     _xdb_verify_unsafe_();
/*  573 */     return this.child_belong_role_id;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getGive_birth_score()
/*      */   {
/*  580 */     _xdb_verify_unsafe_();
/*  581 */     return this.give_birth_score;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getGive_birth_score_enough_time()
/*      */   {
/*  588 */     _xdb_verify_unsafe_();
/*  589 */     return this.give_birth_score_enough_time;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setRoleida(long _v_)
/*      */   {
/*  596 */     _xdb_verify_unsafe_();
/*  597 */     Logs.logIf(new LogKey(this, "roleida")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  601 */         new LogLong(this, Marriage.this.roleida)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  605 */             Marriage.this.roleida = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  609 */     });
/*  610 */     this.roleida = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setRoleidb(long _v_)
/*      */   {
/*  617 */     _xdb_verify_unsafe_();
/*  618 */     Logs.logIf(new LogKey(this, "roleidb")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  622 */         new LogLong(this, Marriage.this.roleidb)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  626 */             Marriage.this.roleidb = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  630 */     });
/*  631 */     this.roleidb = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setMarrytime(long _v_)
/*      */   {
/*  638 */     _xdb_verify_unsafe_();
/*  639 */     Logs.logIf(new LogKey(this, "marrytime")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  643 */         new LogLong(this, Marriage.this.marrytime)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  647 */             Marriage.this.marrytime = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  651 */     });
/*  652 */     this.marrytime = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setLevel(int _v_)
/*      */   {
/*  659 */     _xdb_verify_unsafe_();
/*  660 */     Logs.logIf(new LogKey(this, "level")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  664 */         new LogInt(this, Marriage.this.level)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  668 */             Marriage.this.level = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  672 */     });
/*  673 */     this.level = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setMarriagetitle(int _v_)
/*      */   {
/*  680 */     _xdb_verify_unsafe_();
/*  681 */     Logs.logIf(new LogKey(this, "marriagetitle")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  685 */         new LogInt(this, Marriage.this.marriagetitle)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  689 */             Marriage.this.marriagetitle = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  693 */     });
/*  694 */     this.marriagetitle = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setPrepare_pregnant_score(int _v_)
/*      */   {
/*  701 */     _xdb_verify_unsafe_();
/*  702 */     Logs.logIf(new LogKey(this, "prepare_pregnant_score")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  706 */         new LogInt(this, Marriage.this.prepare_pregnant_score)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  710 */             Marriage.this.prepare_pregnant_score = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  714 */     });
/*  715 */     this.prepare_pregnant_score = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setChild_belong_role_id(long _v_)
/*      */   {
/*  722 */     _xdb_verify_unsafe_();
/*  723 */     Logs.logIf(new LogKey(this, "child_belong_role_id")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  727 */         new LogLong(this, Marriage.this.child_belong_role_id)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  731 */             Marriage.this.child_belong_role_id = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  735 */     });
/*  736 */     this.child_belong_role_id = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setGive_birth_score(int _v_)
/*      */   {
/*  743 */     _xdb_verify_unsafe_();
/*  744 */     Logs.logIf(new LogKey(this, "give_birth_score")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  748 */         new LogInt(this, Marriage.this.give_birth_score)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  752 */             Marriage.this.give_birth_score = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  756 */     });
/*  757 */     this.give_birth_score = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setGive_birth_score_enough_time(long _v_)
/*      */   {
/*  764 */     _xdb_verify_unsafe_();
/*  765 */     Logs.logIf(new LogKey(this, "give_birth_score_enough_time")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  769 */         new LogLong(this, Marriage.this.give_birth_score_enough_time)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  773 */             Marriage.this.give_birth_score_enough_time = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  777 */     });
/*  778 */     this.give_birth_score_enough_time = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  784 */     _xdb_verify_unsafe_();
/*  785 */     Marriage _o_ = null;
/*  786 */     if ((_o1_ instanceof Marriage)) { _o_ = (Marriage)_o1_;
/*  787 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  788 */       return false;
/*  789 */     if (this.roleida != _o_.roleida) return false;
/*  790 */     if (this.roleidb != _o_.roleidb) return false;
/*  791 */     if (!this.friendainfos.equals(_o_.friendainfos)) return false;
/*  792 */     if (!this.friendbinfos.equals(_o_.friendbinfos)) return false;
/*  793 */     if (this.marrytime != _o_.marrytime) return false;
/*  794 */     if (this.level != _o_.level) return false;
/*  795 */     if (this.marriagetitle != _o_.marriagetitle) return false;
/*  796 */     if (!this.parammap.equals(_o_.parammap)) return false;
/*  797 */     if (this.prepare_pregnant_score != _o_.prepare_pregnant_score) return false;
/*  798 */     if (this.child_belong_role_id != _o_.child_belong_role_id) return false;
/*  799 */     if (this.give_birth_score != _o_.give_birth_score) return false;
/*  800 */     if (this.give_birth_score_enough_time != _o_.give_birth_score_enough_time) return false;
/*  801 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  807 */     _xdb_verify_unsafe_();
/*  808 */     int _h_ = 0;
/*  809 */     _h_ = (int)(_h_ + this.roleida);
/*  810 */     _h_ = (int)(_h_ + this.roleidb);
/*  811 */     _h_ += this.friendainfos.hashCode();
/*  812 */     _h_ += this.friendbinfos.hashCode();
/*  813 */     _h_ = (int)(_h_ + this.marrytime);
/*  814 */     _h_ += this.level;
/*  815 */     _h_ += this.marriagetitle;
/*  816 */     _h_ += this.parammap.hashCode();
/*  817 */     _h_ += this.prepare_pregnant_score;
/*  818 */     _h_ = (int)(_h_ + this.child_belong_role_id);
/*  819 */     _h_ += this.give_birth_score;
/*  820 */     _h_ = (int)(_h_ + this.give_birth_score_enough_time);
/*  821 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  827 */     _xdb_verify_unsafe_();
/*  828 */     StringBuilder _sb_ = new StringBuilder();
/*  829 */     _sb_.append("(");
/*  830 */     _sb_.append(this.roleida);
/*  831 */     _sb_.append(",");
/*  832 */     _sb_.append(this.roleidb);
/*  833 */     _sb_.append(",");
/*  834 */     _sb_.append(this.friendainfos);
/*  835 */     _sb_.append(",");
/*  836 */     _sb_.append(this.friendbinfos);
/*  837 */     _sb_.append(",");
/*  838 */     _sb_.append(this.marrytime);
/*  839 */     _sb_.append(",");
/*  840 */     _sb_.append(this.level);
/*  841 */     _sb_.append(",");
/*  842 */     _sb_.append(this.marriagetitle);
/*  843 */     _sb_.append(",");
/*  844 */     _sb_.append(this.parammap);
/*  845 */     _sb_.append(",");
/*  846 */     _sb_.append(this.prepare_pregnant_score);
/*  847 */     _sb_.append(",");
/*  848 */     _sb_.append(this.child_belong_role_id);
/*  849 */     _sb_.append(",");
/*  850 */     _sb_.append(this.give_birth_score);
/*  851 */     _sb_.append(",");
/*  852 */     _sb_.append(this.give_birth_score_enough_time);
/*  853 */     _sb_.append(")");
/*  854 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  860 */     ListenableBean lb = new ListenableBean();
/*  861 */     lb.add(new ListenableChanged().setVarName("roleida"));
/*  862 */     lb.add(new ListenableChanged().setVarName("roleidb"));
/*  863 */     lb.add(new ListenableMap().setVarName("friendainfos"));
/*  864 */     lb.add(new ListenableMap().setVarName("friendbinfos"));
/*  865 */     lb.add(new ListenableChanged().setVarName("marrytime"));
/*  866 */     lb.add(new ListenableChanged().setVarName("level"));
/*  867 */     lb.add(new ListenableChanged().setVarName("marriagetitle"));
/*  868 */     lb.add(new ListenableMap().setVarName("parammap"));
/*  869 */     lb.add(new ListenableChanged().setVarName("prepare_pregnant_score"));
/*  870 */     lb.add(new ListenableChanged().setVarName("child_belong_role_id"));
/*  871 */     lb.add(new ListenableChanged().setVarName("give_birth_score"));
/*  872 */     lb.add(new ListenableChanged().setVarName("give_birth_score_enough_time"));
/*  873 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.Marriage {
/*      */     private Const() {}
/*      */     
/*      */     Marriage nThis() {
/*  880 */       return Marriage.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  886 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Marriage copy()
/*      */     {
/*  892 */       return Marriage.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Marriage toData()
/*      */     {
/*  898 */       return Marriage.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.Marriage toBean()
/*      */     {
/*  903 */       return Marriage.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Marriage toDataIf()
/*      */     {
/*  909 */       return Marriage.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.Marriage toBeanIf()
/*      */     {
/*  914 */       return Marriage.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getRoleida()
/*      */     {
/*  921 */       Marriage.this._xdb_verify_unsafe_();
/*  922 */       return Marriage.this.roleida;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getRoleidb()
/*      */     {
/*  929 */       Marriage.this._xdb_verify_unsafe_();
/*  930 */       return Marriage.this.roleidb;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.MarriageFriendInfo> getFriendainfos()
/*      */     {
/*  937 */       Marriage.this._xdb_verify_unsafe_();
/*  938 */       return xdb.Consts.constMap(Marriage.this.friendainfos);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.MarriageFriendInfo> getFriendainfosAsData()
/*      */     {
/*  945 */       Marriage.this._xdb_verify_unsafe_();
/*      */       
/*  947 */       Marriage _o_ = Marriage.this;
/*  948 */       Map<Long, xbean.MarriageFriendInfo> friendainfos = new HashMap();
/*  949 */       for (Map.Entry<Long, xbean.MarriageFriendInfo> _e_ : _o_.friendainfos.entrySet())
/*  950 */         friendainfos.put(_e_.getKey(), new MarriageFriendInfo.Data((xbean.MarriageFriendInfo)_e_.getValue()));
/*  951 */       return friendainfos;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.MarriageFriendInfo> getFriendbinfos()
/*      */     {
/*  958 */       Marriage.this._xdb_verify_unsafe_();
/*  959 */       return xdb.Consts.constMap(Marriage.this.friendbinfos);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.MarriageFriendInfo> getFriendbinfosAsData()
/*      */     {
/*  966 */       Marriage.this._xdb_verify_unsafe_();
/*      */       
/*  968 */       Marriage _o_ = Marriage.this;
/*  969 */       Map<Long, xbean.MarriageFriendInfo> friendbinfos = new HashMap();
/*  970 */       for (Map.Entry<Long, xbean.MarriageFriendInfo> _e_ : _o_.friendbinfos.entrySet())
/*  971 */         friendbinfos.put(_e_.getKey(), new MarriageFriendInfo.Data((xbean.MarriageFriendInfo)_e_.getValue()));
/*  972 */       return friendbinfos;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getMarrytime()
/*      */     {
/*  979 */       Marriage.this._xdb_verify_unsafe_();
/*  980 */       return Marriage.this.marrytime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getLevel()
/*      */     {
/*  987 */       Marriage.this._xdb_verify_unsafe_();
/*  988 */       return Marriage.this.level;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getMarriagetitle()
/*      */     {
/*  995 */       Marriage.this._xdb_verify_unsafe_();
/*  996 */       return Marriage.this.marriagetitle;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getParammap()
/*      */     {
/* 1003 */       Marriage.this._xdb_verify_unsafe_();
/* 1004 */       return xdb.Consts.constMap(Marriage.this.parammap);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getParammapAsData()
/*      */     {
/* 1011 */       Marriage.this._xdb_verify_unsafe_();
/*      */       
/* 1013 */       Marriage _o_ = Marriage.this;
/* 1014 */       Map<Integer, Integer> parammap = new HashMap();
/* 1015 */       for (Map.Entry<Integer, Integer> _e_ : _o_.parammap.entrySet())
/* 1016 */         parammap.put(_e_.getKey(), _e_.getValue());
/* 1017 */       return parammap;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getPrepare_pregnant_score()
/*      */     {
/* 1024 */       Marriage.this._xdb_verify_unsafe_();
/* 1025 */       return Marriage.this.prepare_pregnant_score;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getChild_belong_role_id()
/*      */     {
/* 1032 */       Marriage.this._xdb_verify_unsafe_();
/* 1033 */       return Marriage.this.child_belong_role_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getGive_birth_score()
/*      */     {
/* 1040 */       Marriage.this._xdb_verify_unsafe_();
/* 1041 */       return Marriage.this.give_birth_score;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getGive_birth_score_enough_time()
/*      */     {
/* 1048 */       Marriage.this._xdb_verify_unsafe_();
/* 1049 */       return Marriage.this.give_birth_score_enough_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRoleida(long _v_)
/*      */     {
/* 1056 */       Marriage.this._xdb_verify_unsafe_();
/* 1057 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRoleidb(long _v_)
/*      */     {
/* 1064 */       Marriage.this._xdb_verify_unsafe_();
/* 1065 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMarrytime(long _v_)
/*      */     {
/* 1072 */       Marriage.this._xdb_verify_unsafe_();
/* 1073 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLevel(int _v_)
/*      */     {
/* 1080 */       Marriage.this._xdb_verify_unsafe_();
/* 1081 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMarriagetitle(int _v_)
/*      */     {
/* 1088 */       Marriage.this._xdb_verify_unsafe_();
/* 1089 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPrepare_pregnant_score(int _v_)
/*      */     {
/* 1096 */       Marriage.this._xdb_verify_unsafe_();
/* 1097 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setChild_belong_role_id(long _v_)
/*      */     {
/* 1104 */       Marriage.this._xdb_verify_unsafe_();
/* 1105 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setGive_birth_score(int _v_)
/*      */     {
/* 1112 */       Marriage.this._xdb_verify_unsafe_();
/* 1113 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setGive_birth_score_enough_time(long _v_)
/*      */     {
/* 1120 */       Marriage.this._xdb_verify_unsafe_();
/* 1121 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean toConst()
/*      */     {
/* 1127 */       Marriage.this._xdb_verify_unsafe_();
/* 1128 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/* 1134 */       Marriage.this._xdb_verify_unsafe_();
/* 1135 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/* 1141 */       return Marriage.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/* 1147 */       return Marriage.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/* 1153 */       Marriage.this._xdb_verify_unsafe_();
/* 1154 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/* 1160 */       return Marriage.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/* 1166 */       return Marriage.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/* 1172 */       Marriage.this._xdb_verify_unsafe_();
/* 1173 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean xdbParent()
/*      */     {
/* 1179 */       return Marriage.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1185 */       return Marriage.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/* 1191 */       return Marriage.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/* 1197 */       return Marriage.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/* 1203 */       return Marriage.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/* 1209 */       return Marriage.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1215 */       return Marriage.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.Marriage
/*      */   {
/*      */     private long roleida;
/*      */     
/*      */     private long roleidb;
/*      */     
/*      */     private HashMap<Long, xbean.MarriageFriendInfo> friendainfos;
/*      */     
/*      */     private HashMap<Long, xbean.MarriageFriendInfo> friendbinfos;
/*      */     
/*      */     private long marrytime;
/*      */     
/*      */     private int level;
/*      */     
/*      */     private int marriagetitle;
/*      */     
/*      */     private HashMap<Integer, Integer> parammap;
/*      */     
/*      */     private int prepare_pregnant_score;
/*      */     
/*      */     private long child_belong_role_id;
/*      */     
/*      */     private int give_birth_score;
/*      */     
/*      */     private long give_birth_score_enough_time;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/* 1249 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/* 1254 */       this.friendainfos = new HashMap();
/* 1255 */       this.friendbinfos = new HashMap();
/* 1256 */       this.parammap = new HashMap();
/*      */     }
/*      */     
/*      */     Data(xbean.Marriage _o1_)
/*      */     {
/* 1261 */       if ((_o1_ instanceof Marriage)) { assign((Marriage)_o1_);
/* 1262 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 1263 */       } else if ((_o1_ instanceof Marriage.Const)) assign(((Marriage.Const)_o1_).nThis()); else {
/* 1264 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(Marriage _o_) {
/* 1269 */       this.roleida = _o_.roleida;
/* 1270 */       this.roleidb = _o_.roleidb;
/* 1271 */       this.friendainfos = new HashMap();
/* 1272 */       for (Map.Entry<Long, xbean.MarriageFriendInfo> _e_ : _o_.friendainfos.entrySet())
/* 1273 */         this.friendainfos.put(_e_.getKey(), new MarriageFriendInfo.Data((xbean.MarriageFriendInfo)_e_.getValue()));
/* 1274 */       this.friendbinfos = new HashMap();
/* 1275 */       for (Map.Entry<Long, xbean.MarriageFriendInfo> _e_ : _o_.friendbinfos.entrySet())
/* 1276 */         this.friendbinfos.put(_e_.getKey(), new MarriageFriendInfo.Data((xbean.MarriageFriendInfo)_e_.getValue()));
/* 1277 */       this.marrytime = _o_.marrytime;
/* 1278 */       this.level = _o_.level;
/* 1279 */       this.marriagetitle = _o_.marriagetitle;
/* 1280 */       this.parammap = new HashMap();
/* 1281 */       for (Map.Entry<Integer, Integer> _e_ : _o_.parammap.entrySet())
/* 1282 */         this.parammap.put(_e_.getKey(), _e_.getValue());
/* 1283 */       this.prepare_pregnant_score = _o_.prepare_pregnant_score;
/* 1284 */       this.child_belong_role_id = _o_.child_belong_role_id;
/* 1285 */       this.give_birth_score = _o_.give_birth_score;
/* 1286 */       this.give_birth_score_enough_time = _o_.give_birth_score_enough_time;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/* 1291 */       this.roleida = _o_.roleida;
/* 1292 */       this.roleidb = _o_.roleidb;
/* 1293 */       this.friendainfos = new HashMap();
/* 1294 */       for (Map.Entry<Long, xbean.MarriageFriendInfo> _e_ : _o_.friendainfos.entrySet())
/* 1295 */         this.friendainfos.put(_e_.getKey(), new MarriageFriendInfo.Data((xbean.MarriageFriendInfo)_e_.getValue()));
/* 1296 */       this.friendbinfos = new HashMap();
/* 1297 */       for (Map.Entry<Long, xbean.MarriageFriendInfo> _e_ : _o_.friendbinfos.entrySet())
/* 1298 */         this.friendbinfos.put(_e_.getKey(), new MarriageFriendInfo.Data((xbean.MarriageFriendInfo)_e_.getValue()));
/* 1299 */       this.marrytime = _o_.marrytime;
/* 1300 */       this.level = _o_.level;
/* 1301 */       this.marriagetitle = _o_.marriagetitle;
/* 1302 */       this.parammap = new HashMap();
/* 1303 */       for (Map.Entry<Integer, Integer> _e_ : _o_.parammap.entrySet())
/* 1304 */         this.parammap.put(_e_.getKey(), _e_.getValue());
/* 1305 */       this.prepare_pregnant_score = _o_.prepare_pregnant_score;
/* 1306 */       this.child_belong_role_id = _o_.child_belong_role_id;
/* 1307 */       this.give_birth_score = _o_.give_birth_score;
/* 1308 */       this.give_birth_score_enough_time = _o_.give_birth_score_enough_time;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/* 1314 */       _os_.marshal(this.roleida);
/* 1315 */       _os_.marshal(this.roleidb);
/* 1316 */       _os_.compact_uint32(this.friendainfos.size());
/* 1317 */       for (Map.Entry<Long, xbean.MarriageFriendInfo> _e_ : this.friendainfos.entrySet())
/*      */       {
/* 1319 */         _os_.marshal(((Long)_e_.getKey()).longValue());
/* 1320 */         ((xbean.MarriageFriendInfo)_e_.getValue()).marshal(_os_);
/*      */       }
/* 1322 */       _os_.compact_uint32(this.friendbinfos.size());
/* 1323 */       for (Map.Entry<Long, xbean.MarriageFriendInfo> _e_ : this.friendbinfos.entrySet())
/*      */       {
/* 1325 */         _os_.marshal(((Long)_e_.getKey()).longValue());
/* 1326 */         ((xbean.MarriageFriendInfo)_e_.getValue()).marshal(_os_);
/*      */       }
/* 1328 */       _os_.marshal(this.marrytime);
/* 1329 */       _os_.marshal(this.level);
/* 1330 */       _os_.marshal(this.marriagetitle);
/* 1331 */       _os_.compact_uint32(this.parammap.size());
/* 1332 */       for (Map.Entry<Integer, Integer> _e_ : this.parammap.entrySet())
/*      */       {
/* 1334 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 1335 */         _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */       }
/* 1337 */       _os_.marshal(this.prepare_pregnant_score);
/* 1338 */       _os_.marshal(this.child_belong_role_id);
/* 1339 */       _os_.marshal(this.give_birth_score);
/* 1340 */       _os_.marshal(this.give_birth_score_enough_time);
/* 1341 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/* 1347 */       this.roleida = _os_.unmarshal_long();
/* 1348 */       this.roleidb = _os_.unmarshal_long();
/*      */       
/* 1350 */       int size = _os_.uncompact_uint32();
/* 1351 */       if (size >= 12)
/*      */       {
/* 1353 */         this.friendainfos = new HashMap(size * 2);
/*      */       }
/* 1355 */       for (; size > 0; size--)
/*      */       {
/* 1357 */         long _k_ = 0L;
/* 1358 */         _k_ = _os_.unmarshal_long();
/* 1359 */         xbean.MarriageFriendInfo _v_ = xbean.Pod.newMarriageFriendInfoData();
/* 1360 */         _v_.unmarshal(_os_);
/* 1361 */         this.friendainfos.put(Long.valueOf(_k_), _v_);
/*      */       }
/*      */       
/*      */ 
/* 1365 */       int size = _os_.uncompact_uint32();
/* 1366 */       if (size >= 12)
/*      */       {
/* 1368 */         this.friendbinfos = new HashMap(size * 2);
/*      */       }
/* 1370 */       for (; size > 0; size--)
/*      */       {
/* 1372 */         long _k_ = 0L;
/* 1373 */         _k_ = _os_.unmarshal_long();
/* 1374 */         xbean.MarriageFriendInfo _v_ = xbean.Pod.newMarriageFriendInfoData();
/* 1375 */         _v_.unmarshal(_os_);
/* 1376 */         this.friendbinfos.put(Long.valueOf(_k_), _v_);
/*      */       }
/*      */       
/* 1379 */       this.marrytime = _os_.unmarshal_long();
/* 1380 */       this.level = _os_.unmarshal_int();
/* 1381 */       this.marriagetitle = _os_.unmarshal_int();
/*      */       
/* 1383 */       int size = _os_.uncompact_uint32();
/* 1384 */       if (size >= 12)
/*      */       {
/* 1386 */         this.parammap = new HashMap(size * 2);
/*      */       }
/* 1388 */       for (; size > 0; size--)
/*      */       {
/* 1390 */         int _k_ = 0;
/* 1391 */         _k_ = _os_.unmarshal_int();
/* 1392 */         int _v_ = 0;
/* 1393 */         _v_ = _os_.unmarshal_int();
/* 1394 */         this.parammap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*      */       }
/*      */       
/* 1397 */       this.prepare_pregnant_score = _os_.unmarshal_int();
/* 1398 */       this.child_belong_role_id = _os_.unmarshal_long();
/* 1399 */       this.give_birth_score = _os_.unmarshal_int();
/* 1400 */       this.give_birth_score_enough_time = _os_.unmarshal_long();
/* 1401 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/* 1407 */       int _size_ = 0;
/* 1408 */       _size_ += CodedOutputStream.computeInt64Size(1, this.roleida);
/* 1409 */       _size_ += CodedOutputStream.computeInt64Size(2, this.roleidb);
/* 1410 */       for (Map.Entry<Long, xbean.MarriageFriendInfo> _e_ : this.friendainfos.entrySet())
/*      */       {
/* 1412 */         _size_ += CodedOutputStream.computeInt64Size(3, ((Long)_e_.getKey()).longValue());
/* 1413 */         _size_ += CodedOutputStream.computeMessageSize(3, (Message)_e_.getValue());
/*      */       }
/* 1415 */       for (Map.Entry<Long, xbean.MarriageFriendInfo> _e_ : this.friendbinfos.entrySet())
/*      */       {
/* 1417 */         _size_ += CodedOutputStream.computeInt64Size(4, ((Long)_e_.getKey()).longValue());
/* 1418 */         _size_ += CodedOutputStream.computeMessageSize(4, (Message)_e_.getValue());
/*      */       }
/* 1420 */       _size_ += CodedOutputStream.computeInt64Size(5, this.marrytime);
/* 1421 */       _size_ += CodedOutputStream.computeInt32Size(6, this.level);
/* 1422 */       _size_ += CodedOutputStream.computeInt32Size(7, this.marriagetitle);
/* 1423 */       for (Map.Entry<Integer, Integer> _e_ : this.parammap.entrySet())
/*      */       {
/* 1425 */         _size_ += CodedOutputStream.computeInt32Size(8, ((Integer)_e_.getKey()).intValue());
/* 1426 */         _size_ += CodedOutputStream.computeInt32Size(8, ((Integer)_e_.getValue()).intValue());
/*      */       }
/* 1428 */       _size_ += CodedOutputStream.computeInt32Size(9, this.prepare_pregnant_score);
/* 1429 */       _size_ += CodedOutputStream.computeInt64Size(11, this.child_belong_role_id);
/* 1430 */       _size_ += CodedOutputStream.computeInt32Size(12, this.give_birth_score);
/* 1431 */       _size_ += CodedOutputStream.computeInt64Size(13, this.give_birth_score_enough_time);
/* 1432 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1440 */         _output_.writeInt64(1, this.roleida);
/* 1441 */         _output_.writeInt64(2, this.roleidb);
/* 1442 */         for (Map.Entry<Long, xbean.MarriageFriendInfo> _e_ : this.friendainfos.entrySet())
/*      */         {
/* 1444 */           _output_.writeInt64(3, ((Long)_e_.getKey()).longValue());
/* 1445 */           _output_.writeMessage(3, (Message)_e_.getValue());
/*      */         }
/* 1447 */         for (Map.Entry<Long, xbean.MarriageFriendInfo> _e_ : this.friendbinfos.entrySet())
/*      */         {
/* 1449 */           _output_.writeInt64(4, ((Long)_e_.getKey()).longValue());
/* 1450 */           _output_.writeMessage(4, (Message)_e_.getValue());
/*      */         }
/* 1452 */         _output_.writeInt64(5, this.marrytime);
/* 1453 */         _output_.writeInt32(6, this.level);
/* 1454 */         _output_.writeInt32(7, this.marriagetitle);
/* 1455 */         for (Map.Entry<Integer, Integer> _e_ : this.parammap.entrySet())
/*      */         {
/* 1457 */           _output_.writeInt32(8, ((Integer)_e_.getKey()).intValue());
/* 1458 */           _output_.writeInt32(8, ((Integer)_e_.getValue()).intValue());
/*      */         }
/* 1460 */         _output_.writeInt32(9, this.prepare_pregnant_score);
/* 1461 */         _output_.writeInt64(11, this.child_belong_role_id);
/* 1462 */         _output_.writeInt32(12, this.give_birth_score);
/* 1463 */         _output_.writeInt64(13, this.give_birth_score_enough_time);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1467 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1469 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1477 */         boolean done = false;
/* 1478 */         while (!done)
/*      */         {
/* 1480 */           int tag = _input_.readTag();
/* 1481 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/* 1485 */             done = true;
/* 1486 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/* 1490 */             this.roleida = _input_.readInt64();
/* 1491 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/* 1495 */             this.roleidb = _input_.readInt64();
/* 1496 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/* 1500 */             long _k_ = 0L;
/* 1501 */             _k_ = _input_.readInt64();
/* 1502 */             int readTag = _input_.readTag();
/* 1503 */             if (26 != readTag)
/*      */             {
/* 1505 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 1507 */             xbean.MarriageFriendInfo _v_ = xbean.Pod.newMarriageFriendInfoData();
/* 1508 */             _input_.readMessage(_v_);
/* 1509 */             this.friendainfos.put(Long.valueOf(_k_), _v_);
/* 1510 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/* 1514 */             long _k_ = 0L;
/* 1515 */             _k_ = _input_.readInt64();
/* 1516 */             int readTag = _input_.readTag();
/* 1517 */             if (34 != readTag)
/*      */             {
/* 1519 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 1521 */             xbean.MarriageFriendInfo _v_ = xbean.Pod.newMarriageFriendInfoData();
/* 1522 */             _input_.readMessage(_v_);
/* 1523 */             this.friendbinfos.put(Long.valueOf(_k_), _v_);
/* 1524 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/* 1528 */             this.marrytime = _input_.readInt64();
/* 1529 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/* 1533 */             this.level = _input_.readInt32();
/* 1534 */             break;
/*      */           
/*      */ 
/*      */           case 56: 
/* 1538 */             this.marriagetitle = _input_.readInt32();
/* 1539 */             break;
/*      */           
/*      */ 
/*      */           case 64: 
/* 1543 */             int _k_ = 0;
/* 1544 */             _k_ = _input_.readInt32();
/* 1545 */             int readTag = _input_.readTag();
/* 1546 */             if (64 != readTag)
/*      */             {
/* 1548 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 1550 */             int _v_ = 0;
/* 1551 */             _v_ = _input_.readInt32();
/* 1552 */             this.parammap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/* 1553 */             break;
/*      */           
/*      */ 
/*      */           case 72: 
/* 1557 */             this.prepare_pregnant_score = _input_.readInt32();
/* 1558 */             break;
/*      */           
/*      */ 
/*      */           case 88: 
/* 1562 */             this.child_belong_role_id = _input_.readInt64();
/* 1563 */             break;
/*      */           
/*      */ 
/*      */           case 96: 
/* 1567 */             this.give_birth_score = _input_.readInt32();
/* 1568 */             break;
/*      */           
/*      */ 
/*      */           case 104: 
/* 1572 */             this.give_birth_score_enough_time = _input_.readInt64();
/* 1573 */             break;
/*      */           
/*      */ 
/*      */           default: 
/* 1577 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/* 1579 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/* 1588 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1592 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1594 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Marriage copy()
/*      */     {
/* 1600 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Marriage toData()
/*      */     {
/* 1606 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.Marriage toBean()
/*      */     {
/* 1611 */       return new Marriage(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Marriage toDataIf()
/*      */     {
/* 1617 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.Marriage toBeanIf()
/*      */     {
/* 1622 */       return new Marriage(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1628 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean xdbParent() {
/* 1632 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1636 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1640 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean toConst() {
/* 1644 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1648 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1652 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getRoleida()
/*      */     {
/* 1659 */       return this.roleida;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getRoleidb()
/*      */     {
/* 1666 */       return this.roleidb;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.MarriageFriendInfo> getFriendainfos()
/*      */     {
/* 1673 */       return this.friendainfos;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.MarriageFriendInfo> getFriendainfosAsData()
/*      */     {
/* 1680 */       return this.friendainfos;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.MarriageFriendInfo> getFriendbinfos()
/*      */     {
/* 1687 */       return this.friendbinfos;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.MarriageFriendInfo> getFriendbinfosAsData()
/*      */     {
/* 1694 */       return this.friendbinfos;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getMarrytime()
/*      */     {
/* 1701 */       return this.marrytime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getLevel()
/*      */     {
/* 1708 */       return this.level;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getMarriagetitle()
/*      */     {
/* 1715 */       return this.marriagetitle;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getParammap()
/*      */     {
/* 1722 */       return this.parammap;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getParammapAsData()
/*      */     {
/* 1729 */       return this.parammap;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getPrepare_pregnant_score()
/*      */     {
/* 1736 */       return this.prepare_pregnant_score;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getChild_belong_role_id()
/*      */     {
/* 1743 */       return this.child_belong_role_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getGive_birth_score()
/*      */     {
/* 1750 */       return this.give_birth_score;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getGive_birth_score_enough_time()
/*      */     {
/* 1757 */       return this.give_birth_score_enough_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRoleida(long _v_)
/*      */     {
/* 1764 */       this.roleida = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRoleidb(long _v_)
/*      */     {
/* 1771 */       this.roleidb = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMarrytime(long _v_)
/*      */     {
/* 1778 */       this.marrytime = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLevel(int _v_)
/*      */     {
/* 1785 */       this.level = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMarriagetitle(int _v_)
/*      */     {
/* 1792 */       this.marriagetitle = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPrepare_pregnant_score(int _v_)
/*      */     {
/* 1799 */       this.prepare_pregnant_score = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setChild_belong_role_id(long _v_)
/*      */     {
/* 1806 */       this.child_belong_role_id = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setGive_birth_score(int _v_)
/*      */     {
/* 1813 */       this.give_birth_score = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setGive_birth_score_enough_time(long _v_)
/*      */     {
/* 1820 */       this.give_birth_score_enough_time = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1826 */       if (!(_o1_ instanceof Data)) return false;
/* 1827 */       Data _o_ = (Data)_o1_;
/* 1828 */       if (this.roleida != _o_.roleida) return false;
/* 1829 */       if (this.roleidb != _o_.roleidb) return false;
/* 1830 */       if (!this.friendainfos.equals(_o_.friendainfos)) return false;
/* 1831 */       if (!this.friendbinfos.equals(_o_.friendbinfos)) return false;
/* 1832 */       if (this.marrytime != _o_.marrytime) return false;
/* 1833 */       if (this.level != _o_.level) return false;
/* 1834 */       if (this.marriagetitle != _o_.marriagetitle) return false;
/* 1835 */       if (!this.parammap.equals(_o_.parammap)) return false;
/* 1836 */       if (this.prepare_pregnant_score != _o_.prepare_pregnant_score) return false;
/* 1837 */       if (this.child_belong_role_id != _o_.child_belong_role_id) return false;
/* 1838 */       if (this.give_birth_score != _o_.give_birth_score) return false;
/* 1839 */       if (this.give_birth_score_enough_time != _o_.give_birth_score_enough_time) return false;
/* 1840 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1846 */       int _h_ = 0;
/* 1847 */       _h_ = (int)(_h_ + this.roleida);
/* 1848 */       _h_ = (int)(_h_ + this.roleidb);
/* 1849 */       _h_ += this.friendainfos.hashCode();
/* 1850 */       _h_ += this.friendbinfos.hashCode();
/* 1851 */       _h_ = (int)(_h_ + this.marrytime);
/* 1852 */       _h_ += this.level;
/* 1853 */       _h_ += this.marriagetitle;
/* 1854 */       _h_ += this.parammap.hashCode();
/* 1855 */       _h_ += this.prepare_pregnant_score;
/* 1856 */       _h_ = (int)(_h_ + this.child_belong_role_id);
/* 1857 */       _h_ += this.give_birth_score;
/* 1858 */       _h_ = (int)(_h_ + this.give_birth_score_enough_time);
/* 1859 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1865 */       StringBuilder _sb_ = new StringBuilder();
/* 1866 */       _sb_.append("(");
/* 1867 */       _sb_.append(this.roleida);
/* 1868 */       _sb_.append(",");
/* 1869 */       _sb_.append(this.roleidb);
/* 1870 */       _sb_.append(",");
/* 1871 */       _sb_.append(this.friendainfos);
/* 1872 */       _sb_.append(",");
/* 1873 */       _sb_.append(this.friendbinfos);
/* 1874 */       _sb_.append(",");
/* 1875 */       _sb_.append(this.marrytime);
/* 1876 */       _sb_.append(",");
/* 1877 */       _sb_.append(this.level);
/* 1878 */       _sb_.append(",");
/* 1879 */       _sb_.append(this.marriagetitle);
/* 1880 */       _sb_.append(",");
/* 1881 */       _sb_.append(this.parammap);
/* 1882 */       _sb_.append(",");
/* 1883 */       _sb_.append(this.prepare_pregnant_score);
/* 1884 */       _sb_.append(",");
/* 1885 */       _sb_.append(this.child_belong_role_id);
/* 1886 */       _sb_.append(",");
/* 1887 */       _sb_.append(this.give_birth_score);
/* 1888 */       _sb_.append(",");
/* 1889 */       _sb_.append(this.give_birth_score_enough_time);
/* 1890 */       _sb_.append(")");
/* 1891 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\Marriage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */